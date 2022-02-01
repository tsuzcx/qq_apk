package com.tencent.aelight.camera.aioeditor.capture.music;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.IQIMManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.aelight.camera.aioeditor.musicwavesupport.MusicWaveformManager;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QimMusicPlayer
  extends IQIMManager
  implements QQSpecialAVFilter.MusicWaveformSupporter
{
  public ConcurrentHashMap<String, MusicItemInfo> a = new ConcurrentHashMap();
  private MusicItemInfo b;
  private MusicItemInfo c;
  private MusicMuteListener d;
  private HashMap<Integer, MusicPlayerScene> e = new HashMap();
  private List<MusicPlayerSceneListener> f = new ArrayList();
  private MusicPlayerScene g;
  private ConcurrentHashMap<String, DownloadTask> h = new ConcurrentHashMap();
  private MusicWaveformManager i = new MusicWaveformManager();
  private int j = QQFilterRenderManagerHolder.a;
  private volatile int k = 0;
  private boolean l;
  private boolean m;
  
  private void e(MusicItemInfo paramMusicItemInfo)
  {
    if ((this.d != null) && (!this.l))
    {
      MusicItemInfo localMusicItemInfo = this.b;
      if ((localMusicItemInfo == null) || (localMusicItemInfo.isMute() != paramMusicItemInfo.isMute())) {
        this.d.a(paramMusicItemInfo.isMute());
      }
    }
  }
  
  private MusicPlayerScene f(MusicItemInfo paramMusicItemInfo)
  {
    Object localObject = null;
    try
    {
      MusicPlayerScene localMusicPlayerScene;
      if (paramMusicItemInfo.mType == 1)
      {
        localMusicPlayerScene = (MusicPlayerScene)this.e.get(Integer.valueOf(1));
        localObject = localMusicPlayerScene;
        if (localMusicPlayerScene == null)
        {
          localObject = new MusicPlayerScene();
          ((MusicPlayerScene)localObject).a(this.f);
          this.e.put(Integer.valueOf(1), localObject);
        }
        ((MusicPlayerScene)localObject).a(paramMusicItemInfo);
      }
      else if (paramMusicItemInfo.mType == 5)
      {
        localMusicPlayerScene = (MusicPlayerScene)this.e.get(Integer.valueOf(2));
        localObject = localMusicPlayerScene;
        if (localMusicPlayerScene == null)
        {
          localObject = new QQMusicPlayerScene();
          ((MusicPlayerScene)localObject).a(this.f);
          this.e.put(Integer.valueOf(2), localObject);
        }
        ((MusicPlayerScene)localObject).a(paramMusicItemInfo);
      }
      return localObject;
    }
    finally {}
  }
  
  private void m()
  {
    if (this.g != null)
    {
      k();
      this.g.a();
    }
  }
  
  public void a()
  {
    if (this.g != null)
    {
      if (this.b != null)
      {
        Object localObject = this.f;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((MusicPlayerSceneListener)((Iterator)localObject).next()).a(this.b);
          }
        }
      }
      this.g.b();
      k();
    }
  }
  
  public void a(int paramInt)
  {
    MusicMuteListener localMusicMuteListener = this.d;
    if (localMusicMuteListener != null) {
      localMusicMuteListener.a(true);
    }
    a(-1, -1, paramInt);
  }
  
  public void a(MusicMuteListener paramMusicMuteListener)
  {
    this.d = paramMusicMuteListener;
    if (!this.l)
    {
      paramMusicMuteListener = this.b;
      if (paramMusicMuteListener != null)
      {
        MusicMuteListener localMusicMuteListener = this.d;
        if (localMusicMuteListener != null) {
          localMusicMuteListener.a(paramMusicMuteListener.isMute());
        }
      }
    }
  }
  
  public void a(MusicPlayerSceneListener paramMusicPlayerSceneListener)
  {
    if (paramMusicPlayerSceneListener != null)
    {
      List localList = this.f;
      if (localList != null)
      {
        if (localList.contains(paramMusicPlayerSceneListener))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener mListeners has listener");
          }
          return;
        }
        this.f.add(paramMusicPlayerSceneListener);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener listener = null");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    MusicItemInfo localMusicItemInfo = ((QIMMusicConfigManager)QIMManager.a(2)).a(paramInt1, paramInt2);
    boolean bool = false;
    if (localMusicItemInfo != null) {
      bool = a(localMusicItemInfo, false, paramInt3);
    }
    return bool;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "replaceCurMusicInfoForFuturePlay");
    }
    if (!b(paramMusicItemInfo)) {
      return false;
    }
    if ((this.b == paramMusicItemInfo) && (f()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("have playing");
      ((StringBuilder)localObject).append(paramMusicItemInfo);
      QLog.i("QimMusicPlayer", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    e(paramMusicItemInfo);
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MusicPlayerSceneListener)((Iterator)localObject).next()).a(paramMusicItemInfo);
      }
    }
    e();
    this.b = paramMusicItemInfo;
    this.c = paramMusicItemInfo;
    this.g = f(paramMusicItemInfo);
    return true;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    return a(paramMusicItemInfo, false, paramInt);
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, MusicDownloadListener paramMusicDownloadListener)
  {
    if ((!b(paramMusicItemInfo)) && (paramMusicItemInfo != null))
    {
      String str = paramMusicItemInfo.getLocalPath();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if (!this.a.containsKey(str))
      {
        paramMusicItemInfo.mProgress = 0;
        paramMusicDownloadListener = new QQMusicDownloadListener(this.a, this.h, paramMusicDownloadListener);
        DownloadTask localDownloadTask = QQMusicDownloader.a(paramMusicItemInfo.mUrl, str, paramMusicDownloadListener);
        if (localDownloadTask != null)
        {
          this.h.put(str, localDownloadTask);
          QQMusicDownloader.a(localDownloadTask, paramMusicDownloadListener);
          this.a.put(str, paramMusicItemInfo);
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestPlay ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("QimMusicPlayer", 2, ((StringBuilder)localObject).toString());
    }
    this.k = paramInt;
    if (!b(paramMusicItemInfo)) {
      return false;
    }
    if (d(paramMusicItemInfo)) {
      return false;
    }
    if ((this.b == paramMusicItemInfo) && (f()) && (!paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("have playing");
      ((StringBuilder)localObject).append(paramMusicItemInfo);
      QLog.i("QimMusicPlayer", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    e(paramMusicItemInfo);
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MusicPlayerSceneListener)((Iterator)localObject).next()).a(paramMusicItemInfo);
      }
    }
    e();
    this.b = paramMusicItemInfo;
    this.c = paramMusicItemInfo;
    this.g = f(paramMusicItemInfo);
    m();
    return true;
  }
  
  public void b()
  {
    MusicPlayerScene localMusicPlayerScene = this.g;
    if (localMusicPlayerScene != null) {
      localMusicPlayerScene.c();
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pauseMusicCheckScene ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("QimMusicPlayer", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != this.k) {
      return;
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((MusicPlayerScene)localObject).c();
    }
  }
  
  public void b(MusicPlayerSceneListener paramMusicPlayerSceneListener)
  {
    List localList = this.f;
    if ((localList != null) && (localList.contains(paramMusicPlayerSceneListener))) {
      this.f.remove(paramMusicPlayerSceneListener);
    }
  }
  
  public boolean b(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return false;
    }
    return ((paramMusicItemInfo.mType != 5) && (paramMusicItemInfo.mType != 1)) || (FileUtils.fileExistsAndNotEmpty(paramMusicItemInfo.getLocalPath()));
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void c(MusicItemInfo paramMusicItemInfo)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = (DownloadTask)((ConcurrentHashMap)localObject).get(paramMusicItemInfo.getLocalPath());
      if (localObject != null) {
        QQMusicDownloader.a((DownloadTask)localObject);
      }
    }
    localObject = paramMusicItemInfo.getLocalPath();
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.contains(localObject))) {
      this.a.remove(localObject);
    }
    paramMusicItemInfo.mProgress = -1;
    QIMCommonLoadingProgress.a(paramMusicItemInfo).d();
  }
  
  public void d()
  {
    this.b = null;
    this.c = null;
    this.d = null;
    this.f.clear();
    this.f = null;
    this.g = null;
    this.h.clear();
    this.a.clear();
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext()) {
      ((MusicPlayerScene)localIterator.next()).f();
    }
    this.e.clear();
    this.e = null;
    this.i.b();
    this.i = null;
  }
  
  public boolean d(MusicItemInfo paramMusicItemInfo)
  {
    if (!this.m) {
      return false;
    }
    return (h() != -1) && (paramMusicItemInfo.mSongMid.equals(i().mSongMid)) && (h() < paramMusicItemInfo.musicDuration);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "clearMusic ");
    }
    this.c = null;
    this.b = null;
    MusicPlayerScene localMusicPlayerScene = this.g;
    if (localMusicPlayerScene != null) {
      localMusicPlayerScene.e();
    }
  }
  
  public boolean f()
  {
    MusicPlayerScene localMusicPlayerScene = this.g;
    return (localMusicPlayerScene != null) && (localMusicPlayerScene.g());
  }
  
  public float getCurrentMusicGain()
  {
    MusicItemInfo localMusicItemInfo = i();
    if (localMusicItemInfo == null) {
      return -1.0F;
    }
    try
    {
      if ((this.i != null) && (localMusicItemInfo.needPlay()) && (f()))
      {
        float f1 = this.i.a(h() - localMusicItemInfo.musicStart);
        return f1;
      }
      return -1.0F;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentMusicGain() error: ");
        localStringBuilder.append(localException.toString());
        QLog.e("QimMusicPlayer", 2, localStringBuilder.toString());
      }
    }
    return -1.0F;
  }
  
  public MusicItemInfo getMusicItemInfo()
  {
    MusicItemInfo localMusicItemInfo = i();
    if ((localMusicItemInfo != null) && (localMusicItemInfo.needPlay())) {
      return localMusicItemInfo.copy();
    }
    return null;
  }
  
  public int h()
  {
    if (f()) {
      return this.g.h();
    }
    return -1;
  }
  
  public MusicItemInfo i()
  {
    MusicItemInfo localMusicItemInfo = this.b;
    if (localMusicItemInfo == null) {
      return null;
    }
    if ((localMusicItemInfo.mType != 5) && (this.b.mType != 1)) {
      return null;
    }
    return this.b;
  }
  
  public MusicItemInfo j()
  {
    return this.c;
  }
  
  public void k()
  {
    MusicItemInfo localMusicItemInfo = i();
    if (localMusicItemInfo == null) {
      return;
    }
    if (this.i != null)
    {
      QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(this.j);
      if ((localMusicItemInfo.needPlay()) && (l()))
      {
        int n;
        if (f()) {
          n = h() - localMusicItemInfo.musicStart;
        } else {
          n = 0;
        }
        this.i.a(localMusicItemInfo, n);
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.getBusinessOperation().setMusicWaveformSupporter(this);
        }
      }
      else if ((localMusicItemInfo.needPlay()) || (l()))
      {
        this.i.b();
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.getBusinessOperation().setMusicWaveformSupporter(null);
        }
      }
    }
  }
  
  public boolean l()
  {
    Object localObject = QQFilterRenderManagerHolder.a(this.j);
    if (localObject != null) {
      localObject = ((QQFilterRenderManager)localObject).getBusinessOperation().getCurrentAVFilterIdByType(2);
    } else {
      localObject = null;
    }
    return (localObject != null) && (QQAVImageFilterConstants.isMusicSpecialFilter(((FilterDesc)localObject).id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer
 * JD-Core Version:    0.7.0.1
 */