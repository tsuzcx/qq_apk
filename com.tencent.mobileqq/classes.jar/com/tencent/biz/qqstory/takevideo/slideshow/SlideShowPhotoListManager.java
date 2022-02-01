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
  private static SlideShowPhotoListManager jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager;
  private int jdField_a_of_type_Int = 20999;
  long jdField_a_of_type_Long;
  protected Handler a;
  MusicDownloadListener jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener = new SlideShowPhotoListManager.1(this);
  protected SlideShowPhotoListManager.AblumListener a;
  private SlideShowViewController jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController;
  protected SlideShowProcessor a;
  protected List<WeakReference<Activity>> a;
  private int jdField_b_of_type_Int;
  private List<SlideItemInfo> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private int jdField_c_of_type_Int = 21;
  private List<LocalMediaInfo> jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private List<SlideItemInfo> d = new CopyOnWriteArrayList();
  
  public SlideShowPhotoListManager()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor = new SlideShowProcessor();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a();
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager create, ", new Exception());
    }
  }
  
  public static SlideShowPhotoListManager a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager == null) {
      jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager = new SlideShowPhotoListManager();
    }
    return jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager;
  }
  
  private void a(Activity paramActivity, List<String> paramList, SlideShowPhotoListManager.AblumListener paramAblumListener, int paramInt)
  {
    paramList = (SlideItemInfo)a().get(0);
    if (paramList.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$AblumListener = paramAblumListener;
      int i = this.jdField_b_of_type_Int;
      if (((i == 13) || (i == 11) || (i == 12) || (this.jdField_c_of_type_Int == 22)) && (((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
        a();
      }
      paramList = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController;
      if (paramList != null) {
        paramList.c();
      }
      if (this.jdField_b_of_type_JavaUtilList.size() > 0)
      {
        paramList = (SlideItemInfo)this.jdField_b_of_type_JavaUtilList.get(0);
        if (paramList != null)
        {
          i = paramList.jdField_a_of_type_Int;
          paramList = paramList.jdField_a_of_type_JavaLangString;
          break label143;
        }
      }
      paramList = "";
      i = -1;
      label143:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(this.jdField_b_of_type_JavaUtilList, this, paramActivity, this.jdField_a_of_type_AndroidOsHandler, paramInt, i, paramList);
      return;
    }
    ((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).startEditVideoActivity(paramActivity, paramList.jdField_b_of_type_JavaLangString, paramList.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, (int)paramList.jdField_b_of_type_Long, (int)paramList.jdField_c_of_type_Long, 120, 10023, 0, "", "", false, 11, 14, null);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new SlideShowPhotoListManager.2(this, paramContext, paramString));
  }
  
  private void a(Context paramContext, List<SlideItemInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramContext = SlideShowConfigManager.a(paramContext).a(((SlideItemInfo)paramList.get(0)).jdField_e_of_type_JavaLangString);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((IAELaunchMusicConfigManager)QRoute.api(IAELaunchMusicConfigManager.class)).getMusicItemById(((SlideShowConfigManager.Music)paramContext.get(0)).jdField_a_of_type_Int, ((SlideShowConfigManager.Music)paramContext.get(0)).jdField_b_of_type_Int);
        if ((paramContext != null) && (!((IQimMusicPlayer)QRoute.api(IQimMusicPlayer.class)).checkMusicCanPlay(paramContext)))
        {
          ((IQimMusicPlayer)QRoute.api(IQimMusicPlayer.class)).requestDownLoadMusicInfo(paramContext, this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener);
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
  
  private boolean a(Activity paramActivity)
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
        localHashSet.add(((SlideItemInfo)paramList1.next()).jdField_b_of_type_JavaLangString);
      }
      if (localHashSet.size() != paramList2.size()) {
        return true;
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext()) {
        if (!localHashSet.contains(((SlideItemInfo)paramList1.next()).jdField_b_of_type_JavaLangString)) {
          return true;
        }
      }
    }
    return false;
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
    if ((l2 > this.jdField_a_of_type_Int) && (QzoneSlideShowPhotoListManager.a().b() != 22))
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor != null)
    {
      TransitionHandler localTransitionHandler = (TransitionHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.jdField_b_of_type_JavaLangString);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
        if ((localSlideItemInfo != null) && (!TextUtils.isEmpty(localSlideItemInfo.jdField_b_of_type_JavaLangString)))
        {
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("convertToVideo path = ");
            ((StringBuilder)localObject).append(localSlideItemInfo.jdField_b_of_type_JavaLangString);
            QLog.i("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
          }
          long l = localSlideItemInfo.a();
          if (l > this.jdField_a_of_type_Int - 2000)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Duration too max: convertToVideoInternal durationValid=");
              ((StringBuilder)localObject).append(l);
              QLog.d("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
            }
            localSlideItemInfo.jdField_b_of_type_Boolean = false;
          }
          else
          {
            boolean bool = localSlideItemInfo.jdField_b_of_type_Boolean;
            localSlideItemInfo.jdField_b_of_type_Boolean = false;
            if (!localTransitionHandler.a(localSlideItemInfo.jdField_b_of_type_JavaLangString))
            {
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo.jdField_b_of_type_JavaLangString))
              {
                this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
              }
              else
              {
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("[hasAlreadyRunning=true]convertToVideo path = ");
                  ((StringBuilder)localObject).append(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                  QLog.i("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
                }
                if ((bool) && (localSlideItemInfo.jdField_b_of_type_Int == 1))
                {
                  this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                  localObject = localTransitionHandler.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                  if (localObject != null)
                  {
                    FileUtil.c(((LocalMediaInfo)localObject).path);
                    localTransitionHandler.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                  }
                  this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
                }
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("[hasCachedMediaInfo=true]convertToVideo path = ");
                ((StringBuilder)localObject).append(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                QLog.i("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
              }
              if ((bool) && (localSlideItemInfo.jdField_b_of_type_Int == 1))
              {
                localObject = localTransitionHandler.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                if (localObject != null) {
                  FileUtil.c(((LocalMediaInfo)localObject).path);
                }
                localTransitionHandler.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
              }
            }
          }
        }
        else if (localSlideItemInfo != null)
        {
          localSlideItemInfo.jdField_b_of_type_Boolean = false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "combine video mConvertProcessor is null");
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public List<SlideItemInfo> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (localActivity.getClass().getName().contains("EditVideoActivity")))
      {
        localActivity.finish();
        this.jdField_a_of_type_JavaUtilList.remove(localActivity);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramActivity));
  }
  
  public void a(Activity paramActivity, SlideShowPhotoListManager.AblumListener paramAblumListener, int paramInt)
  {
    Object localObject1 = SlideShowUtils.a(a());
    if ((paramActivity != null) && (localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      boolean bool = paramActivity instanceof NewPhotoListActivity;
      if (a(paramActivity))
      {
        a(paramActivity, (List)localObject1, paramAblumListener, paramInt);
        return;
      }
      Object localObject3;
      int i;
      Object localObject2;
      int j;
      if ((((List)localObject1).size() == 1) && (this.jdField_c_of_type_Int != 22))
      {
        localObject3 = (SlideItemInfo)a().get(0);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(((SlideItemInfo)localObject3).jdField_b_of_type_JavaLangString);
        if (paramActivity.getIntent() != null) {
          paramInt = paramActivity.getIntent().getIntExtra("entrance_type", 99);
        } else {
          paramInt = 99;
        }
        if (((SlideItemInfo)localObject3).jdField_b_of_type_Int == 0)
        {
          paramAblumListener = (IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class);
          localObject1 = ((SlideItemInfo)localObject3).jdField_b_of_type_JavaLangString;
          i = 1;
          paramAblumListener = paramAblumListener.startEditPic(paramActivity, (String)localObject1, true, true, true, true, true, false, false, false, 2, paramInt, 0, false, null);
          paramAblumListener.putExtra("media_info", ((SlideItemInfo)localObject3).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
          paramAblumListener.putExtra("extra_edit_video_from", 2);
          paramActivity.startActivityForResult(paramAblumListener, 10002);
          paramActivity = new StringBuilder();
          paramInt = i;
          if (bool) {
            paramInt = 0;
          }
          paramActivity.append(paramInt);
          paramActivity.append("");
          StoryReportor.a("video_edit", "edit_local", 0, 0, new String[] { paramActivity.toString() });
          return;
        }
        if (((SlideItemInfo)localObject3).jdField_b_of_type_Int == 1)
        {
          paramAblumListener = new StringBuilder();
          if (bool) {
            i = 0;
          } else {
            i = 1;
          }
          paramAblumListener.append(i);
          paramAblumListener.append("");
          StoryReportor.a("video_edit", "edit_local", 0, 1, new String[] { paramAblumListener.toString() });
          localObject2 = paramActivity.getIntent();
          if (localObject2 != null)
          {
            i = ((Intent)localObject2).getIntExtra("shareGroupType", 0);
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
            i = 0;
            bool = false;
          }
          if (a().b() == 22) {
            j = 10001;
          } else {
            j = 10002;
          }
          ((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).startEditVideoActivity(paramActivity, ((SlideItemInfo)localObject3).jdField_b_of_type_JavaLangString, ((SlideItemInfo)localObject3).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, (int)((SlideItemInfo)localObject3).jdField_b_of_type_Long, (int)((SlideItemInfo)localObject3).jdField_c_of_type_Long, paramInt, j, i, (String)localObject1, paramAblumListener, bool, 3, 2, (Bundle)localObject2);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$AblumListener = paramAblumListener;
        i = this.jdField_b_of_type_Int;
        if (((i == 13) || (i == 11) || (i == 12) || (this.jdField_c_of_type_Int == 22)) && ((bool) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
          a();
        }
        paramAblumListener = this.jdField_b_of_type_JavaUtilList.iterator();
        i = 0;
        while (paramAblumListener.hasNext())
        {
          localObject1 = (SlideItemInfo)paramAblumListener.next();
          if ((localObject1 != null) && (((SlideItemInfo)localObject1).jdField_b_of_type_Int == 1)) {
            i += 1;
          }
        }
        int m = this.jdField_b_of_type_JavaUtilList.size();
        paramAblumListener = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController;
        if (paramAblumListener != null)
        {
          paramAblumListener.c();
          if (bool) {
            j = 1;
          } else {
            j = 0;
          }
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          int k;
          if (this.jdField_b_of_type_Int == 11) {
            k = 0;
          } else {
            k = 1;
          }
          if (j != 0) {
            paramAblumListener = "0";
          } else {
            paramAblumListener = "1";
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaUtilList.size());
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(m - i);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("");
          StoryReportor.a("pic_choose_slides", "clk_create", k, 0, new String[] { paramAblumListener, localObject1, localObject2, ((StringBuilder)localObject3).toString() });
        }
        a(paramActivity, this.jdField_b_of_type_JavaUtilList);
        e();
        if (this.jdField_b_of_type_JavaUtilList.size() > 0)
        {
          paramAblumListener = (SlideItemInfo)this.jdField_b_of_type_JavaUtilList.get(0);
          if (paramAblumListener != null)
          {
            i = paramAblumListener.jdField_a_of_type_Int;
            paramAblumListener = paramAblumListener.jdField_a_of_type_JavaLangString;
            break label887;
          }
        }
        paramAblumListener = "";
        i = -1;
        label887:
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(this.jdField_b_of_type_JavaUtilList, this, paramActivity, this.jdField_a_of_type_AndroidOsHandler, paramInt, i, paramAblumListener);
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
      int j = 0;
      int i = paramIntent.getIntExtra("video_index", 0);
      int n = paramIntent.getIntExtra("start_index", 0);
      int i1 = paramIntent.getIntExtra("end_index", 0);
      int i2 = paramIntent.getIntExtra("scroll_x", 0);
      int k = paramIntent.getIntExtra("start_time", 0);
      int m = paramIntent.getIntExtra("end_time", 0);
      paramIntent = (SlideItemInfo)this.jdField_b_of_type_JavaUtilList.get(i);
      paramIntent.jdField_e_of_type_Int = n;
      paramIntent.f = i1;
      paramIntent.d = i2;
      long l1 = k;
      if (Math.abs(l1 - paramIntent.jdField_b_of_type_Long) >= 50L) {
        i = 1;
      } else {
        i = 0;
      }
      long l2 = m;
      if (Math.abs(l2 - paramIntent.jdField_c_of_type_Long) >= 50L) {
        j = 1;
      }
      boolean bool = j | i | 0x0;
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("isOperateClip : ");
        paramMap.append(bool);
        paramMap.append("  startTime : ");
        paramMap.append(k);
        paramMap.append("  slideInfo.startTime : ");
        paramMap.append(paramIntent.jdField_b_of_type_Long);
        paramMap.append(" endTime : ");
        paramMap.append(m);
        paramMap.append("  slideInfo.endTime : ");
        paramMap.append(paramIntent.jdField_c_of_type_Long);
        QLog.d("SlideShowPhotoListManager", 2, paramMap.toString());
      }
      if (bool)
      {
        paramIntent.jdField_b_of_type_Boolean = bool;
        paramIntent.jdField_b_of_type_Long = l1;
        paramIntent.jdField_c_of_type_Long = l2;
      }
    }
  }
  
  public void a(ResultInfo paramResultInfo)
  {
    Object localObject1 = QQStoryContext.a();
    Object localObject2;
    if (paramResultInfo.jdField_a_of_type_Int == 0)
    {
      String str = paramResultInfo.jdField_a_of_type_JavaLangString;
      localObject2 = new LocalMediaInfo();
      ((LocalMediaInfo)localObject2).path = paramResultInfo.jdField_b_of_type_JavaLangString;
      ((LocalMediaInfo)localObject2).mMimeType = "video";
      ((LocalMediaInfo)localObject2).mAudioPath = paramResultInfo.c;
      ((LocalMediaInfo)localObject2).mHasAudioTrack = paramResultInfo.jdField_a_of_type_Boolean;
      ((LocalMediaInfo)localObject2).mSampleRate = paramResultInfo.jdField_b_of_type_Int;
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
      localObject1 = (TransitionHandler)((AppInterface)localObject1).getBusinessHandler(PeakAppInterface.jdField_b_of_type_JavaLangString);
      ((TransitionHandler)localObject1).a(str, (LocalMediaInfo)localObject2);
      if (((TransitionHandler)localObject1).a() == null) {
        ((TransitionHandler)localObject1).a(paramResultInfo.jdField_a_of_type_AndroidMediaMediaFormat);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onImage2VideoResult RESULT_SUCC  hasAudioTrack:");
        ((StringBuilder)localObject1).append(((LocalMediaInfo)localObject2).mHasAudioTrack);
        QLog.e("SlideShowPhotoListManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else if (paramResultInfo.jdField_a_of_type_Int == 2)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onImage2VideoResult cancel");
        ((StringBuilder)localObject1).append(paramResultInfo);
        QLog.i("SlideShowPhotoListManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramResultInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("");
      StoryReportor.a("actAlbumResult", new String[] { ((StringBuilder)localObject1).toString() });
    }
    else if (paramResultInfo.jdField_a_of_type_Int == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult fail load");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramResultInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append("");
      StoryReportor.a("actAlbumResult", new String[] { ((StringBuilder)localObject2).toString() });
      a(((AppInterface)localObject1).getApp(), HardCodeUtil.a(2131714068));
    }
    else if (paramResultInfo.jdField_a_of_type_Int == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "result audio fail");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramResultInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append("");
      StoryReportor.a("actAlbumResult", new String[] { ((StringBuilder)localObject2).toString() });
      a(((AppInterface)localObject1).getApp(), HardCodeUtil.a(2131714067));
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor;
      if (localObject1 != null) {
        ((SlideShowProcessor)localObject1).b();
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController;
      if (localObject1 != null) {
        ((SlideShowViewController)localObject1).e();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramResultInfo.jdField_a_of_type_Int);
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController = paramSlideShowViewController;
  }
  
  public void a(List<SlideItemInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
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
      localObject = this.jdField_c_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        int j = 0;
        Iterator localIterator = paramList.iterator();
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((String)localIterator.next()).equals(localLocalMediaInfo.path));
        int i = 1;
        if (i != 0) {
          localLocalMediaInfo.selectStatus = 1;
        } else {
          localLocalMediaInfo.selectStatus = 2;
        }
      }
      localObject = new ArrayList();
      ((List)localObject).addAll(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList.clear();
      if (paramHashMap.size() > 0)
      {
        paramList = SlideShowUtils.a(paramList, paramHashMap, (List)localObject);
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      }
      ((List)localObject).clear();
      paramList = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController;
      if (paramList != null) {
        paramList.a();
      }
      if (paramBoolean) {
        c(this.jdField_b_of_type_JavaUtilList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SlideShowViewController localSlideShowViewController = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController;
    if (localSlideShowViewController != null) {
      localSlideShowViewController.d();
    }
  }
  
  public boolean a()
  {
    return a(this.d, this.jdField_b_of_type_JavaUtilList);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public List<LocalMediaInfo> b()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SlideShowPhotoListManager", 2, "onResume");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(List<SlideItemInfo> paramList)
  {
    this.d.clear();
    this.d.addAll(paramList);
  }
  
  public List<SlideItemInfo> c()
  {
    return this.d;
  }
  
  public void c()
  {
    d();
    TransitionHandler localTransitionHandler = (TransitionHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.jdField_b_of_type_JavaLangString);
    if (localTransitionHandler != null) {
      localTransitionHandler.a();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    SlideShowProcessor.c();
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor;
    if (localObject != null) {
      ((SlideShowProcessor)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController;
    if (localObject != null) {
      ((SlideShowViewController)localObject).e();
    }
  }
  
  protected void e()
  {
    Object localObject = (TransitionHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.jdField_b_of_type_JavaLangString);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)localIterator.next();
      if (((TransitionHandler)localObject).a(localSlideItemInfo.jdField_b_of_type_JavaLangString) == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkIsNeedRetrySendConvert allFinish=false picInfo.mPath =");
          ((StringBuilder)localObject).append(localSlideItemInfo.jdField_b_of_type_JavaLangString);
          QLog.d("SlideShowPhotoListManager", 2, ((StringBuilder)localObject).toString());
        }
        i = 0;
        break label104;
      }
    }
    int i = 1;
    label104:
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "checkIsNeedRetrySendConvert allFinish=false send convert request...");
      }
      c(this.jdField_b_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    List localList = a().a();
    boolean bool = QLog.isColorLevel();
    String str1 = "\n";
    String str2 = " isOperateClip : ";
    Object localObject5 = " mDuration : ";
    Object localObject6 = " endTime : ";
    Object localObject3 = "SlideShowPhotoListManager";
    if (bool)
    {
      localObject1 = "before : \n";
      i = 0;
      while (i < localList.size())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" path : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i)).jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" startTime : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i)).jdField_b_of_type_Long);
        ((StringBuilder)localObject2).append(" endTime : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i)).jdField_c_of_type_Long);
        ((StringBuilder)localObject2).append(" mDuration : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i)).jdField_a_of_type_Long);
        ((StringBuilder)localObject2).append(" isOperateClip : ");
        ((StringBuilder)localObject2).append(((SlideItemInfo)localList.get(i)).jdField_b_of_type_Boolean);
        ((StringBuilder)localObject2).append("\n");
        localObject1 = ((StringBuilder)localObject2).toString();
        i += 1;
      }
      QLog.d("SlideShowPhotoListManager", 2, (String)localObject1);
    }
    Object localObject1 = localList.iterator();
    for (int i = 0; ((Iterator)localObject1).hasNext(); i = (int)(i + ((SlideItemInfo)localObject2).jdField_a_of_type_Long)) {
      localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
    }
    if (i <= this.jdField_a_of_type_Int - 500)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("totalDuration : ");
        ((StringBuilder)localObject1).append(i);
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
      if (((SlideItemInfo)localObject7).jdField_b_of_type_Int == 1)
      {
        i = 0;
        while (i < localArrayList.size())
        {
          if (((SlideItemInfo)localObject7).jdField_a_of_type_Long < ((SlideItemInfo)localArrayList.get(i)).jdField_a_of_type_Long)
          {
            localArrayList.add(i, localObject7);
            break;
          }
          i += 1;
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        localObject2 = localObject4;
        localObject1 = localObject3;
        if (i == localArrayList.size())
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
    i = localList.size();
    int j = localArrayList.size();
    int k = this.jdField_a_of_type_Int - 500 - (i - j) * 2000 - localArrayList.size() * 2000;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("leftTime : ");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("   videoCount : ");
      ((StringBuilder)localObject2).append(localArrayList.size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject7 = localObject1;
    localObject3 = localArrayList.iterator();
    i = 0;
    localObject1 = str2;
    localObject2 = str1;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (SlideItemInfo)((Iterator)localObject3).next();
      i = (int)(i + ((SlideItemInfo)localObject4).jdField_a_of_type_Long);
    }
    int m = localArrayList.size();
    j = 0;
    localObject3 = localObject6;
    Object localObject4 = localObject5;
    while (j < localArrayList.size())
    {
      localObject5 = (SlideItemInfo)localArrayList.get(j);
      long l = (int)(((float)((SlideItemInfo)localObject5).jdField_a_of_type_Long - 2000.0F) / (i - m * 2000) * k) + 2000;
      if ((Math.abs(l - ((SlideItemInfo)localObject5).jdField_c_of_type_Long) <= 50L) && (Math.abs(((SlideItemInfo)localObject5).jdField_b_of_type_Long) <= 50L)) {
        break label820;
      }
      ((SlideItemInfo)localObject5).jdField_b_of_type_Boolean = true;
      ((SlideItemInfo)localObject5).jdField_c_of_type_Boolean = true;
      label820:
      ((SlideItemInfo)localObject5).jdField_c_of_type_Long = l;
      ((SlideItemInfo)localObject5).jdField_b_of_type_Long = 0L;
      ((SlideItemInfo)localObject5).jdField_e_of_type_Int = 0;
      ((SlideItemInfo)localObject5).f = 0;
      ((SlideItemInfo)localObject5).d = 0;
      if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("eachTime <= info.mDuration, i : ");
        ((StringBuilder)localObject6).append(j);
        ((StringBuilder)localObject6).append("  leftTime : ");
        ((StringBuilder)localObject6).append(k);
        ((StringBuilder)localObject6).append("  mDuration : ");
        ((StringBuilder)localObject6).append(((SlideItemInfo)localObject5).jdField_a_of_type_Long);
        QLog.d((String)localObject7, 2, ((StringBuilder)localObject6).toString());
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject5 = "after : \n";
      i = 0;
      while (i < localList.size())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append((String)localObject5);
        ((StringBuilder)localObject6).append(" path : ");
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i)).jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject6).append(" startTime : ");
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i)).jdField_b_of_type_Long);
        ((StringBuilder)localObject6).append((String)localObject3);
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i)).jdField_c_of_type_Long);
        ((StringBuilder)localObject6).append((String)localObject4);
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i)).jdField_a_of_type_Long);
        ((StringBuilder)localObject6).append((String)localObject1);
        ((StringBuilder)localObject6).append(((SlideItemInfo)localList.get(i)).jdField_b_of_type_Boolean);
        ((StringBuilder)localObject6).append((String)localObject2);
        localObject5 = ((StringBuilder)localObject6).toString();
        i += 1;
      }
      QLog.d((String)localObject7, 2, (String)localObject5);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController.a();
    d();
    c(localList);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController.b();
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController;
    if (localObject != null) {
      ((SlideShowViewController)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$AblumListener;
    if (localObject != null) {
      ((SlideShowPhotoListManager.AblumListener)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager
 * JD-Core Version:    0.7.0.1
 */