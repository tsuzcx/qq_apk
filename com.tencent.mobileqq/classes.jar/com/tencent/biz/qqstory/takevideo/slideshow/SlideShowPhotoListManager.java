package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.SlideShowProcessListener;
import com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.VideoMergeListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class SlideShowPhotoListManager
  implements SlideShowProcessor.SlideShowProcessListener, VideoMerger.VideoMergeListener
{
  private static SlideShowPhotoListManager n;
  protected SlideShowProcessor a = new SlideShowProcessor();
  protected Handler b = new Handler(Looper.getMainLooper());
  long c;
  protected List<WeakReference<Activity>> d = new CopyOnWriteArrayList();
  protected SlideShowPhotoListManager.AblumListener e;
  MusicDownloadListener f = new SlideShowPhotoListManager.1(this);
  private int g = 20999;
  private List<SlideItemInfo> h = new CopyOnWriteArrayList();
  private List<LocalMediaInfo> i = new CopyOnWriteArrayList();
  private List<SlideItemInfo> j = new CopyOnWriteArrayList();
  private int k;
  private int l = 21;
  private SlideShowViewController m;
  
  public SlideShowPhotoListManager()
  {
    this.a.a();
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager create, ", new Exception());
    }
  }
  
  public static SlideShowPhotoListManager a()
  {
    if (n == null) {
      n = new SlideShowPhotoListManager();
    }
    return n;
  }
  
  private void a(Activity paramActivity, List<String> paramList, SlideShowPhotoListManager.AblumListener paramAblumListener, int paramInt)
  {
    paramList = (SlideItemInfo)f().get(0);
    if (paramList.e == 0)
    {
      this.e = paramAblumListener;
      int i1 = this.k;
      if (((i1 == 13) || (i1 == 11) || (i1 == 12) || (this.l == 22)) && (((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
        c();
      }
      paramList = this.m;
      if (paramList != null) {
        paramList.c();
      }
      if (this.h.size() > 0)
      {
        paramList = (SlideItemInfo)this.h.get(0);
        if (paramList != null)
        {
          i1 = paramList.c;
          paramList = paramList.d;
          break label143;
        }
      }
      paramList = "";
      i1 = -1;
      label143:
      this.a.a(this.h, this, paramActivity, this.b, paramInt, i1, paramList);
      return;
    }
    ((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).startEditVideoActivity(paramActivity, paramList.f, paramList.a, (int)paramList.i, (int)paramList.j, 120, 10023, 0, "", "", false, 11, 14, null);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Handler localHandler = this.b;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new SlideShowPhotoListManager.2(this, paramContext, paramString));
  }
  
  private void a(Context paramContext, List<SlideItemInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramContext = SlideShowConfigManager.a(paramContext).a(((SlideItemInfo)paramList.get(0)).r);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((IAELaunchMusicConfigManager)QRoute.api(IAELaunchMusicConfigManager.class)).getMusicItemById(((SlideShowConfigManager.Music)paramContext.get(0)).a, ((SlideShowConfigManager.Music)paramContext.get(0)).b);
        if ((paramContext != null) && (!((IQimMusicPlayer)QRoute.api(IQimMusicPlayer.class)).checkMusicCanPlay(paramContext)))
        {
          ((IQimMusicPlayer)QRoute.api(IQimMusicPlayer.class)).requestDownLoadMusicInfo(paramContext, this.f);
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder();
            paramList.append("SlideShowPhotoListManager preloadMusic mItemId=");
            paramList.append(paramContext.mItemId);
            QLog.d("SlideShowPhotoListManager", 2, paramList.toString());
          }
        }
      }
    }
  }
  
  private boolean a(List<SlideItemInfo> paramList1, List<SlideItemInfo> paramList2)
  {
    if (paramList1 == paramList2) {
      return false;
    }
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return false;
      }
      if (paramList1.size() != paramList2.size()) {
        return true;
      }
      HashSet localHashSet = new HashSet();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext()) {
        localHashSet.add(((SlideItemInfo)paramList1.next()).f);
      }
      if (localHashSet.size() != paramList2.size()) {
        return true;
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext()) {
        if (!localHashSet.contains(((SlideItemInfo)paramList1.next()).f)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.getIntent() != null)
      {
        bool1 = bool2;
        if (paramActivity.getIntent().getIntExtra("edit_video_type", 10002) == 10023) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c(List<SlideItemInfo> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("convertToVideo size : ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = 0L;
    long l2 = l1;
    if (paramList != null)
    {
      localObject = paramList.iterator();
      for (;;)
      {
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
        if (localSlideItemInfo != null) {
          l1 += localSlideItemInfo.a();
        }
      }
    }
    if ((l2 > this.g) && (QzoneSlideShowPhotoListManager.a().e() != 22))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("Duration too max: convertToVideo totalDuration=");
        paramList.append(l2);
        QLog.d("SlideShowPhotoListManager", 2, paramList.toString());
      }
    }
    else
    {
      if (paramList != null)
      {
        d(paramList);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "newInfoList is null");
      }
    }
  }
  
  private void d(@NonNull List<SlideItemInfo> paramList)
  {
    if (this.a != null)
    {
      TransitionHandler localTransitionHandler = (TransitionHandler)QQStoryContext.k().getBusinessHandler(PeakAppInterface.c);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
        if ((localSlideItemInfo != null) && (!TextUtils.isEmpty(localSlideItemInfo.f)))
        {
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("convertToVideo path = ");
            ((StringBuilder)localObject).append(localSlideItemInfo.f);
            QLog.i("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
          }
          long l1 = localSlideItemInfo.a();
          if (l1 > this.g - 2000)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Duration too max: convertToVideoInternal durationValid=");
              ((StringBuilder)localObject).append(l1);
              QLog.d("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
            }
            localSlideItemInfo.s = false;
          }
          else
          {
            boolean bool = localSlideItemInfo.s;
            localSlideItemInfo.s = false;
            if (!localTransitionHandler.b(localSlideItemInfo.f))
            {
              if (!this.a.b(localSlideItemInfo.f))
              {
                this.a.a(localSlideItemInfo, this);
              }
              else
              {
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("[hasAlreadyRunning=true]convertToVideo path = ");
                  ((StringBuilder)localObject).append(localSlideItemInfo.f);
                  QLog.i("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
                }
                if ((bool) && (localSlideItemInfo.e == 1))
                {
                  this.a.a(localSlideItemInfo.f);
                  localObject = localTransitionHandler.a(localSlideItemInfo.f);
                  if (localObject != null)
                  {
                    FileUtil.e(((LocalMediaInfo)localObject).path);
                    localTransitionHandler.c(localSlideItemInfo.f);
                  }
                  this.a.a(localSlideItemInfo, this);
                }
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("[hasCachedMediaInfo=true]convertToVideo path = ");
                ((StringBuilder)localObject).append(localSlideItemInfo.f);
                QLog.i("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
              }
              if ((bool) && (localSlideItemInfo.e == 1))
              {
                localObject = localTransitionHandler.a(localSlideItemInfo.f);
                if (localObject != null) {
                  FileUtil.e(((LocalMediaInfo)localObject).path);
                }
                localTransitionHandler.c(localSlideItemInfo.f);
                this.a.a(localSlideItemInfo, this);
              }
            }
          }
        }
        else if (localSlideItemInfo != null)
        {
          localSlideItemInfo.s = false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "combine video mConvertProcessor is null");
    }
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    this.d.add(new WeakReference(paramActivity));
  }
  
  public void a(Activity paramActivity, SlideShowPhotoListManager.AblumListener paramAblumListener, int paramInt)
  {
    Object localObject1 = SlideShowUtils.a(f());
    if ((paramActivity != null) && (localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      boolean bool = paramActivity instanceof NewPhotoListActivity;
      if (b(paramActivity))
      {
        a(paramActivity, (List)localObject1, paramAblumListener, paramInt);
        return;
      }
      Object localObject3;
      int i1;
      Object localObject2;
      int i2;
      if ((((List)localObject1).size() == 1) && (this.l != 22))
      {
        localObject3 = (SlideItemInfo)f().get(0);
        this.a.a(((SlideItemInfo)localObject3).f);
        if (paramActivity.getIntent() != null) {
          paramInt = paramActivity.getIntent().getIntExtra("entrance_type", 99);
        } else {
          paramInt = 99;
        }
        if (((SlideItemInfo)localObject3).e == 0)
        {
          paramAblumListener = (IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class);
          localObject1 = ((SlideItemInfo)localObject3).f;
          i1 = 1;
          paramAblumListener = paramAblumListener.startEditPic(paramActivity, (String)localObject1, true, true, true, true, true, false, false, false, 2, paramInt, 0, false, null);
          paramAblumListener.putExtra("media_info", ((SlideItemInfo)localObject3).a);
          paramAblumListener.putExtra("extra_edit_video_from", 2);
          paramActivity.startActivityForResult(paramAblumListener, 10002);
          paramActivity = new StringBuilder();
          paramInt = i1;
          if (bool) {
            paramInt = 0;
          }
          paramActivity.append(paramInt);
          paramActivity.append("");
          StoryReportor.a("video_edit", "edit_local", 0, 0, new String[] { paramActivity.toString() });
          return;
        }
        if (((SlideItemInfo)localObject3).e == 1)
        {
          paramAblumListener = new StringBuilder();
          if (bool) {
            i1 = 0;
          } else {
            i1 = 1;
          }
          paramAblumListener.append(i1);
          paramAblumListener.append("");
          StoryReportor.a("video_edit", "edit_local", 0, 1, new String[] { paramAblumListener.toString() });
          localObject2 = paramActivity.getIntent();
          if (localObject2 != null)
          {
            i1 = ((Intent)localObject2).getIntExtra("shareGroupType", 0);
            localObject1 = ((Intent)localObject2).getStringExtra("shareGroupId");
            paramAblumListener = ((Intent)localObject2).getStringExtra("shareGroupName");
            bool = ((Intent)localObject2).getBooleanExtra("ignorePersonalPublish", false);
            ((Intent)localObject2).putExtra("extra_edit_video_from", 3);
            localObject2 = ((Intent)localObject2).getBundleExtra("state");
          }
          else
          {
            localObject1 = null;
            paramAblumListener = (SlideShowPhotoListManager.AblumListener)localObject1;
            localObject2 = paramAblumListener;
            i1 = 0;
            bool = false;
          }
          if (a().e() == 22) {
            i2 = 10001;
          } else {
            i2 = 10002;
          }
          ((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).startEditVideoActivity(paramActivity, ((SlideItemInfo)localObject3).f, ((SlideItemInfo)localObject3).a, (int)((SlideItemInfo)localObject3).i, (int)((SlideItemInfo)localObject3).j, paramInt, i2, i1, (String)localObject1, paramAblumListener, bool, 3, 2, (Bundle)localObject2);
        }
      }
      else
      {
        this.e = paramAblumListener;
        i1 = this.k;
        if (((i1 == 13) || (i1 == 11) || (i1 == 12) || (this.l == 22)) && ((bool) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
          c();
        }
        paramAblumListener = this.h.iterator();
        i1 = 0;
        while (paramAblumListener.hasNext())
        {
          localObject1 = (SlideItemInfo)paramAblumListener.next();
          if ((localObject1 != null) && (((SlideItemInfo)localObject1).e == 1)) {
            i1 += 1;
          }
        }
        int i4 = this.h.size();
        paramAblumListener = this.m;
        if (paramAblumListener != null)
        {
          paramAblumListener.c();
          if (bool) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          this.c = System.currentTimeMillis();
          int i3;
          if (this.k == 11) {
            i3 = 0;
          } else {
            i3 = 1;
          }
          if (i2 != 0) {
            paramAblumListener = "0";
          } else {
            paramAblumListener = "1";
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.h.size());
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i4 - i1);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i1);
          ((StringBuilder)localObject3).append("");
          StoryReportor.a("pic_choose_slides", "clk_create", i3, 0, new String[] { paramAblumListener, localObject1, localObject2, ((StringBuilder)localObject3).toString() });
        }
        a(paramActivity, this.h);
        l();
        if (this.h.size() > 0)
        {
          paramAblumListener = (SlideItemInfo)this.h.get(0);
          if (paramAblumListener != null)
          {
            i1 = paramAblumListener.c;
            paramAblumListener = paramAblumListener.d;
            break label887;
          }
        }
        paramAblumListener = "";
        i1 = -1;
        label887:
        this.a.a(this.h, this, paramActivity, this.b, paramInt, i1, paramAblumListener);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "activity == null || imgPathList == null");
    }
  }
  
  public void a(Intent paramIntent, Map<String, LocalMediaInfo> paramMap)
  {
    if (paramIntent != null)
    {
      if (paramMap == null) {
        return;
      }
      int i2 = 0;
      int i1 = paramIntent.getIntExtra("video_index", 0);
      int i5 = paramIntent.getIntExtra("start_index", 0);
      int i6 = paramIntent.getIntExtra("end_index", 0);
      int i7 = paramIntent.getIntExtra("scroll_x", 0);
      int i3 = paramIntent.getIntExtra("start_time", 0);
      int i4 = paramIntent.getIntExtra("end_time", 0);
      paramIntent = (SlideItemInfo)this.h.get(i1);
      paramIntent.p = i5;
      paramIntent.q = i6;
      paramIntent.o = i7;
      long l1 = i3;
      if (Math.abs(l1 - paramIntent.i) >= 50L) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      long l2 = i4;
      if (Math.abs(l2 - paramIntent.j) >= 50L) {
        i2 = 1;
      }
      boolean bool = i2 | i1 | 0x0;
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("isOperateClip : ");
        paramMap.append(bool);
        paramMap.append("  startTime : ");
        paramMap.append(i3);
        paramMap.append("  slideInfo.startTime : ");
        paramMap.append(paramIntent.i);
        paramMap.append(" endTime : ");
        paramMap.append(i4);
        paramMap.append("  slideInfo.endTime : ");
        paramMap.append(paramIntent.j);
        QLog.d("SlideShowPhotoListManager", 2, paramMap.toString());
      }
      if (bool)
      {
        paramIntent.s = bool;
        paramIntent.i = l1;
        paramIntent.j = l2;
      }
    }
  }
  
  public void a(ResultInfo paramResultInfo)
  {
    Object localObject1 = QQStoryContext.k();
    Object localObject2;
    if (paramResultInfo.b == 0)
    {
      String str = paramResultInfo.c;
      localObject2 = new LocalMediaInfo();
      ((LocalMediaInfo)localObject2).path = paramResultInfo.d;
      ((LocalMediaInfo)localObject2).mMimeType = "video";
      ((LocalMediaInfo)localObject2).mAudioPath = paramResultInfo.f;
      ((LocalMediaInfo)localObject2).mHasAudioTrack = paramResultInfo.i;
      ((LocalMediaInfo)localObject2).mSampleRate = paramResultInfo.j;
      MediaScanner localMediaScanner = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      try
      {
        localMediaScanner.buildAndUpdateVideo((LocalMediaInfo)localObject2);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.e("SlideShowPhotoListManager", 1, "pic2video err", localThrowable);
      }
      localObject1 = (TransitionHandler)((AppInterface)localObject1).getBusinessHandler(PeakAppInterface.c);
      ((TransitionHandler)localObject1).a(str, (LocalMediaInfo)localObject2);
      if (((TransitionHandler)localObject1).a() == null) {
        ((TransitionHandler)localObject1).a(paramResultInfo.e);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onImage2VideoResult RESULT_SUCC  hasAudioTrack:");
        ((StringBuilder)localObject1).append(((LocalMediaInfo)localObject2).mHasAudioTrack);
        QLog.e("SlideShowPhotoListManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else if (paramResultInfo.b == 2)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onImage2VideoResult cancel");
        ((StringBuilder)localObject1).append(paramResultInfo);
        QLog.i("SlideShowPhotoListManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramResultInfo.b);
      ((StringBuilder)localObject1).append("");
      StoryReportor.a("actAlbumResult", new String[] { ((StringBuilder)localObject1).toString() });
    }
    else if (paramResultInfo.b == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult fail load");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramResultInfo.b);
      ((StringBuilder)localObject2).append("");
      StoryReportor.a("actAlbumResult", new String[] { ((StringBuilder)localObject2).toString() });
      a(((AppInterface)localObject1).getApp(), HardCodeUtil.a(2131911599));
    }
    else if (paramResultInfo.b == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "result audio fail");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramResultInfo.b);
      ((StringBuilder)localObject2).append("");
      StoryReportor.a("actAlbumResult", new String[] { ((StringBuilder)localObject2).toString() });
      a(((AppInterface)localObject1).getApp(), HardCodeUtil.a(2131911598));
      localObject1 = this.a;
      if (localObject1 != null) {
        ((SlideShowProcessor)localObject1).c();
      }
      localObject1 = this.m;
      if (localObject1 != null) {
        ((SlideShowViewController)localObject1).e();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramResultInfo.b);
      ((StringBuilder)localObject1).append("");
      StoryReportor.a("actAlbumResult", new String[] { ((StringBuilder)localObject1).toString() });
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onImage2VideoResult ");
      ((StringBuilder)localObject1).append(paramResultInfo);
      QLog.e("SlideShowPhotoListManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(SlideShowViewController paramSlideShowViewController)
  {
    this.m = paramSlideShowViewController;
  }
  
  public void a(List<SlideItemInfo> paramList)
  {
    this.h.clear();
    this.h.addAll(paramList);
  }
  
  public void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    a(paramList, paramHashMap, true);
  }
  
  public void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel()) {
      if ((paramList != null) && (paramHashMap != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemsSelectChanged selectedPhotoList = ");
        ((StringBuilder)localObject).append(paramList.size());
        ((StringBuilder)localObject).append(" mediaMap=");
        ((StringBuilder)localObject).append(paramHashMap.size());
        QLog.e("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemsSelectChanged selectedPhotoList = ");
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append(" mediaMap=");
        ((StringBuilder)localObject).append(paramHashMap);
        QLog.e("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((paramList != null) && (paramHashMap != null))
    {
      localObject = this.i.iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        int i2 = 0;
        Iterator localIterator = paramList.iterator();
        do
        {
          i1 = i2;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((String)localIterator.next()).equals(localLocalMediaInfo.path));
        int i1 = 1;
        if (i1 != 0) {
          localLocalMediaInfo.selectStatus = 1;
        } else {
          localLocalMediaInfo.selectStatus = 2;
        }
      }
      localObject = new ArrayList();
      ((List)localObject).addAll(this.h);
      this.h.clear();
      if (paramHashMap.size() > 0)
      {
        paramList = SlideShowUtils.a(paramList, paramHashMap, (List)localObject);
        this.h.addAll(paramList);
      }
      ((List)localObject).clear();
      paramList = this.m;
      if (paramList != null) {
        paramList.a();
      }
      if (paramBoolean) {
        c(this.h);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SlideShowViewController localSlideShowViewController = this.m;
    if (localSlideShowViewController != null) {
      localSlideShowViewController.d();
    }
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(List<SlideItemInfo> paramList)
  {
    this.j.clear();
    this.j.addAll(paramList);
  }
  
  public boolean b()
  {
    return a(this.j, this.h);
  }
  
  public void c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (localActivity.getClass().getName().contains("EditVideoActivity")))
      {
        localActivity.finish();
        this.d.remove(localActivity);
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int d()
  {
    return this.k;
  }
  
  public int e()
  {
    return this.l;
  }
  
  public List<SlideItemInfo> f()
  {
    return this.h;
  }
  
  public List<LocalMediaInfo> g()
  {
    return this.i;
  }
  
  public List<SlideItemInfo> h()
  {
    return this.j;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SlideShowPhotoListManager", 2, "onResume");
    }
  }
  
  public void j()
  {
    k();
    TransitionHandler localTransitionHandler = (TransitionHandler)QQStoryContext.k().getBusinessHandler(PeakAppInterface.c);
    if (localTransitionHandler != null) {
      localTransitionHandler.b();
    }
    this.h.clear();
    this.i.clear();
    SlideShowProcessor.d();
  }
  
  public void k()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((SlideShowProcessor)localObject).c();
    }
    localObject = this.m;
    if (localObject != null) {
      ((SlideShowViewController)localObject).e();
    }
  }
  
  protected void l()
  {
    Object localObject = (TransitionHandler)QQStoryContext.k().getBusinessHandler(PeakAppInterface.c);
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)localIterator.next();
      if (((TransitionHandler)localObject).a(localSlideItemInfo.f) == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkIsNeedRetrySendConvert allFinish=false picInfo.mPath =");
          ((StringBuilder)localObject).append(localSlideItemInfo.f);
          QLog.d("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
        }
        i1 = 0;
        break label104;
      }
    }
    int i1 = 1;
    label104:
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "checkIsNeedRetrySendConvert allFinish=false send convert request...");
      }
      c(this.h);
    }
  }
  
  public void m()
  {
    List localList = a().f();
    boolean bool = QLog.isColorLevel();
    String str1 = "\n";
    String str2 = " isOperateClip : ";
    Object localObject5 = " mDuration : ";
    Object localObject6 = " endTime : ";
    Object localObject3 = "SlideShowPhotoListManager";
    if (bool)
    {
      localObject1 = "before : \n";
      i1 = 0;
      while (i1 < localList.size())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" path : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i1)).f);
        ((StringBuilder)localObject2).append(" startTime : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i1)).i);
        ((StringBuilder)localObject2).append(" endTime : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i1)).j);
        ((StringBuilder)localObject2).append(" mDuration : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i1)).h);
        ((StringBuilder)localObject2).append(" isOperateClip : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i1)).s);
        ((StringBuilder)localObject2).append("\n");
        localObject1 = ((StringBuilder)localObject2).toString();
        i1 += 1;
      }
      QLog.d("SlideShowPhotoListManager", 2, (String)localObject1);
    }
    Object localObject1 = localList.iterator();
    for (int i1 = 0; ((Iterator)localObject1).hasNext(); i1 = (int)(i1 + ((SlideItemInfo)localObject2).h)) {
      localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
    }
    if (i1 <= this.g - 500)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("totalDuration : ");
        ((StringBuilder)localObject1).append(i1);
        QLog.d("SlideShowPhotoListManager", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = localList.iterator();
    localObject1 = localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject7 = (SlideItemInfo)((Iterator)localObject2).next();
      if (((SlideItemInfo)localObject7).e == 1)
      {
        i1 = 0;
        while (i1 < localArrayList.size())
        {
          if (((SlideItemInfo)localObject7).h < ((SlideItemInfo)localArrayList.get(i1)).h)
          {
            localArrayList.add(i1, localObject7);
            break;
          }
          i1 += 1;
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        localObject2 = localObject4;
        localObject1 = localObject3;
        if (i1 == localArrayList.size())
        {
          localArrayList.add(localObject7);
          localObject2 = localObject4;
          localObject1 = localObject3;
        }
      }
    }
    if (localArrayList.size() == 0) {
      return;
    }
    i1 = localList.size();
    int i2 = localArrayList.size();
    int i3 = this.g - 500 - (i1 - i2) * 2000 - localArrayList.size() * 2000;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("leftTime : ");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append("   videoCount : ");
      ((StringBuilder)localObject2).append(localArrayList.size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject7 = localObject1;
    localObject3 = localArrayList.iterator();
    i1 = 0;
    localObject1 = str2;
    localObject2 = str1;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (SlideItemInfo)((Iterator)localObject3).next();
      i1 = (int)(i1 + ((SlideItemInfo)localObject4).h);
    }
    int i4 = localArrayList.size();
    i2 = 0;
    localObject3 = localObject6;
    Object localObject4 = localObject5;
    while (i2 < localArrayList.size())
    {
      localObject5 = (SlideItemInfo)localArrayList.get(i2);
      long l1 = (int)(((float)((SlideItemInfo)localObject5).h - 2000.0F) / (i1 - i4 * 2000) * i3) + 2000;
      if ((Math.abs(l1 - ((SlideItemInfo)localObject5).j) <= 50L) && (Math.abs(((SlideItemInfo)localObject5).i) <= 50L)) {
        break label820;
      }
      ((SlideItemInfo)localObject5).s = true;
      ((SlideItemInfo)localObject5).t = true;
      label820:
      ((SlideItemInfo)localObject5).j = l1;
      ((SlideItemInfo)localObject5).i = 0L;
      ((SlideItemInfo)localObject5).p = 0;
      ((SlideItemInfo)localObject5).q = 0;
      ((SlideItemInfo)localObject5).o = 0;
      if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("eachTime <= info.mDuration, i : ");
        ((StringBuilder)localObject6).append(i2);
        ((StringBuilder)localObject6).append("  leftTime : ");
        ((StringBuilder)localObject6).append(i3);
        ((StringBuilder)localObject6).append("  mDuration : ");
        ((StringBuilder)localObject6).append(((SlideItemInfo)localObject5).h);
        QLog.d((String)localObject7, 2, ((StringBuilder)localObject6).toString());
      }
      i2 += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject5 = "after : \n";
      i1 = 0;
      while (i1 < localList.size())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append((String)localObject5);
        ((StringBuilder)localObject6).append(" path : ");
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i1)).f);
        ((StringBuilder)localObject6).append(" startTime : ");
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i1)).i);
        ((StringBuilder)localObject6).append((String)localObject3);
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i1)).j);
        ((StringBuilder)localObject6).append((String)localObject4);
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i1)).h);
        ((StringBuilder)localObject6).append((String)localObject1);
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i1)).s);
        ((StringBuilder)localObject6).append((String)localObject2);
        localObject5 = ((StringBuilder)localObject6).toString();
        i1 += 1;
      }
      QLog.d((String)localObject7, 2, (String)localObject5);
    }
    this.m.a();
    k();
    c(localList);
    this.m.b();
  }
  
  public void n()
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((SlideShowViewController)localObject).e();
    }
    localObject = this.e;
    if (localObject != null) {
      ((SlideShowPhotoListManager.AblumListener)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager
 * JD-Core Version:    0.7.0.1
 */