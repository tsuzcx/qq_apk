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
  private int jdField_a_of_type_Int = QQFilterRenderManagerHolder.jdField_a_of_type_Int;
  private MusicMuteListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicMuteListener;
  private MusicPlayerScene jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene;
  private MusicWaveformManager jdField_a_of_type_ComTencentAelightCameraAioeditorMusicwavesupportMusicWaveformManager = new MusicWaveformManager();
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private HashMap<Integer, MusicPlayerScene> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<MusicPlayerSceneListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  public ConcurrentHashMap<String, MusicItemInfo> a;
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int = 0;
  private MusicItemInfo jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private ConcurrentHashMap<String, DownloadTask> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  public QimMusicPlayer()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private MusicPlayerScene a(MusicItemInfo paramMusicItemInfo)
  {
    Object localObject = null;
    try
    {
      MusicPlayerScene localMusicPlayerScene;
      if (paramMusicItemInfo.mType == 1)
      {
        localMusicPlayerScene = (MusicPlayerScene)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
        localObject = localMusicPlayerScene;
        if (localMusicPlayerScene == null)
        {
          localObject = new MusicPlayerScene();
          ((MusicPlayerScene)localObject).a(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), localObject);
        }
        ((MusicPlayerScene)localObject).a(paramMusicItemInfo);
      }
      else if (paramMusicItemInfo.mType == 5)
      {
        localMusicPlayerScene = (MusicPlayerScene)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
        localObject = localMusicPlayerScene;
        if (localMusicPlayerScene == null)
        {
          localObject = new QQMusicPlayerScene();
          ((MusicPlayerScene)localObject).a(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), localObject);
        }
        ((MusicPlayerScene)localObject).a(paramMusicItemInfo);
      }
      return localObject;
    }
    finally {}
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicMuteListener != null) && (!this.jdField_a_of_type_Boolean))
    {
      MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
      if ((localMusicItemInfo == null) || (localMusicItemInfo.isMute() != paramMusicItemInfo.isMute())) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicMuteListener.a(paramMusicItemInfo.isMute());
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene != null)
    {
      f();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene.a();
    }
  }
  
  public int a()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene.a();
    }
    return -1;
  }
  
  public MusicItemInfo a()
  {
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    if (localMusicItemInfo == null) {
      return null;
    }
    if ((localMusicItemInfo.mType != 5) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mType != 1)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    MusicMuteListener localMusicMuteListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicMuteListener;
    if (localMusicMuteListener != null) {
      localMusicMuteListener.a(true);
    }
    a(-1, -1, paramInt);
  }
  
  public void a(MusicMuteListener paramMusicMuteListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicMuteListener = paramMusicMuteListener;
    if (!this.jdField_a_of_type_Boolean)
    {
      paramMusicMuteListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
      if (paramMusicMuteListener != null)
      {
        MusicMuteListener localMusicMuteListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicMuteListener;
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
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList != null)
      {
        if (localList.contains(paramMusicPlayerSceneListener))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener mListeners has listener");
          }
          return;
        }
        this.jdField_a_of_type_JavaUtilList.add(paramMusicPlayerSceneListener);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener listener = null");
    }
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      localObject = (DownloadTask)((ConcurrentHashMap)localObject).get(paramMusicItemInfo.getLocalPath());
      if (localObject != null) {
        QQMusicDownloader.a((DownloadTask)localObject);
      }
    }
    localObject = paramMusicItemInfo.getLocalPath();
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.contains(localObject))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
    }
    paramMusicItemInfo.mProgress = -1;
    QIMCommonLoadingProgress.a(paramMusicItemInfo).c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    MusicPlayerScene localMusicPlayerScene = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene;
    return (localMusicPlayerScene != null) && (localMusicPlayerScene.a());
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
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == paramMusicItemInfo) && (a()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("have playing");
      ((StringBuilder)localObject).append(paramMusicItemInfo);
      QLog.i("QimMusicPlayer", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    b(paramMusicItemInfo);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MusicPlayerSceneListener)((Iterator)localObject).next()).a(paramMusicItemInfo);
      }
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene = a(paramMusicItemInfo);
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
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
      {
        paramMusicItemInfo.mProgress = 0;
        paramMusicDownloadListener = new QQMusicDownloadListener(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap, paramMusicDownloadListener);
        DownloadTask localDownloadTask = QQMusicDownloader.a(paramMusicItemInfo.mUrl, str, paramMusicDownloadListener);
        if (localDownloadTask != null)
        {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localDownloadTask);
          QQMusicDownloader.a(localDownloadTask, paramMusicDownloadListener);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramMusicItemInfo);
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
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      QLog.d("QimMusicPlayer", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_Int = paramInt;
    if (!b(paramMusicItemInfo)) {
      return false;
    }
    if (c(paramMusicItemInfo)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == paramMusicItemInfo) && (a()) && (!paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("have playing");
      ((StringBuilder)localObject).append(paramMusicItemInfo);
      QLog.i("QimMusicPlayer", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    b(paramMusicItemInfo);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MusicPlayerSceneListener)((Iterator)localObject).next()).a(paramMusicItemInfo);
      }
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene = a(paramMusicItemInfo);
    g();
    return true;
  }
  
  public MusicItemInfo b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicMuteListener = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene = null;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((MusicPlayerScene)localIterator.next()).f();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorMusicwavesupportMusicWaveformManager.a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorMusicwavesupportMusicWaveformManager = null;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pauseMusicCheckScene ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      QLog.d("QimMusicPlayer", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != this.jdField_b_of_type_Int) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene;
    if (localObject != null) {
      ((MusicPlayerScene)localObject).c();
    }
  }
  
  public void b(MusicPlayerSceneListener paramMusicPlayerSceneListener)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.contains(paramMusicPlayerSceneListener))) {
      this.jdField_a_of_type_JavaUtilList.remove(paramMusicPlayerSceneListener);
    }
  }
  
  public boolean b()
  {
    Object localObject = QQFilterRenderManagerHolder.a(this.jdField_a_of_type_Int);
    if (localObject != null) {
      localObject = ((QQFilterRenderManager)localObject).getBusinessOperation().getCurrentAVFilterIdByType(2);
    } else {
      localObject = null;
    }
    return (localObject != null) && (QQAVImageFilterConstants.isMusicSpecialFilter(((FilterDesc)localObject).id));
  }
  
  public boolean b(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return false;
    }
    return ((paramMusicItemInfo.mType != 5) && (paramMusicItemInfo.mType != 1)) || (FileUtils.fileExistsAndNotEmpty(paramMusicItemInfo.getLocalPath()));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((MusicPlayerSceneListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          }
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene.b();
      f();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean c(MusicItemInfo paramMusicItemInfo)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    return (a() != -1) && (paramMusicItemInfo.mSongMid.equals(a().mSongMid)) && (a() < paramMusicItemInfo.musicDuration);
  }
  
  public void d()
  {
    MusicPlayerScene localMusicPlayerScene = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene;
    if (localMusicPlayerScene != null) {
      localMusicPlayerScene.c();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "clearMusic ");
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    MusicPlayerScene localMusicPlayerScene = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerScene;
    if (localMusicPlayerScene != null) {
      localMusicPlayerScene.e();
    }
  }
  
  public void f()
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorMusicwavesupportMusicWaveformManager != null)
    {
      QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(this.jdField_a_of_type_Int);
      if ((localMusicItemInfo.needPlay()) && (b()))
      {
        int i;
        if (a()) {
          i = a() - localMusicItemInfo.musicStart;
        } else {
          i = 0;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorMusicwavesupportMusicWaveformManager.a(localMusicItemInfo, i);
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.getBusinessOperation().setMusicWaveformSupporter(this);
        }
      }
      else if ((localMusicItemInfo.needPlay()) || (b()))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorMusicwavesupportMusicWaveformManager.a();
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.getBusinessOperation().setMusicWaveformSupporter(null);
        }
      }
    }
  }
  
  public float getCurrentMusicGain()
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null) {
      return -1.0F;
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorMusicwavesupportMusicWaveformManager != null) && (localMusicItemInfo.needPlay()) && (a()))
      {
        float f = this.jdField_a_of_type_ComTencentAelightCameraAioeditorMusicwavesupportMusicWaveformManager.a(a() - localMusicItemInfo.musicStart);
        return f;
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
    MusicItemInfo localMusicItemInfo = a();
    if ((localMusicItemInfo != null) && (localMusicItemInfo.needPlay())) {
      return localMusicItemInfo.copy();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer
 * JD-Core Version:    0.7.0.1
 */