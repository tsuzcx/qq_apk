package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import nez;
import nfa;
import nfb;
import nfc;
import nfd;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    super(paramStoryVideoTaskInfo);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject = paramStoryVideoTaskInfo.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject).doodlePath))) {
      if (BitmapUtils.a(((PublishVideoEntry)localObject).doodleRawPath))
      {
        paramStoryVideoTaskInfo.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject).doodleRawPath;
        ((PublishVideoEntry)localObject).getBooleanExtra("is_hw_encode", false);
        bool = ((PublishVideoEntry)localObject).isLocalPublish;
        if (((PublishVideoEntry)localObject).businessId == 1) {}
        ((PublishVideoEntry)localObject).getBooleanExtra("landscape_video", false);
        ((PublishVideoEntry)localObject).getIntExtra("thumb_rotation", 0);
        ((PublishVideoEntry)localObject).getBooleanExtra("has_rotate", false);
        if (!bool) {
          break label605;
        }
      }
    }
    for (;;)
    {
      ((PublishVideoEntry)localObject).doodlePath = ((PublishVideoEntry)localObject).doodleRawPath;
      EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
      ((PublishVideoEntry)localObject).setStatus(1000);
      localEntityManager.b((Entity)localObject);
      SLog.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (StoryApi.a(2131755010).booleanValue()) {
            a(paramStoryVideoTaskInfo);
          }
          localObject = paramStoryVideoTaskInfo.a().videoUploadTempDir;
          if (localObject != null) {
            FileUtils.a((String)localObject);
          }
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramStoryVideoTaskInfo.a() });
          if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString)) {
            SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(FileUtils.b(paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString)), paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString });
          }
          localObject = paramStoryVideoTaskInfo.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(FileUtils.b((String)localObject)), localObject });
          }
          paramStoryVideoTaskInfo.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          if ((TextUtils.isEmpty(paramStoryVideoTaskInfo.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramStoryVideoTaskInfo.k))) {
            break label688;
          }
          localObject = new ImageFileObject(true);
          ((ImageFileObject)localObject).jdField_a_of_type_JavaLangString = paramStoryVideoTaskInfo.jdField_e_of_type_JavaLangString;
          ((ImageFileObject)localObject).a(new nez(this, paramStoryVideoTaskInfo));
          paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject);
          if ((TextUtils.isEmpty(paramStoryVideoTaskInfo.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramStoryVideoTaskInfo.l))) {
            break label698;
          }
          localObject = new ImageFileObject(true);
          ((ImageFileObject)localObject).jdField_a_of_type_JavaLangString = paramStoryVideoTaskInfo.jdField_f_of_type_JavaLangString;
          ((ImageFileObject)localObject).a(new nfa(this, paramStoryVideoTaskInfo));
          paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject);
          if (!TextUtils.isEmpty(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_g_of_type_JavaLangString)) {
            break label708;
          }
          localObject = new StoryVideoFileObject(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a(), ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_a_of_type_JavaLangString);
          ((StoryVideoFileObject)localObject).a(new nfb(this));
          paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject);
          if ((TextUtils.isEmpty(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_b_of_type_JavaLangString)))
          {
            localObject = new ImageFileObject(false);
            ((ImageFileObject)localObject).jdField_a_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_b_of_type_JavaLangString;
            ((ImageFileObject)localObject).a(new nfc(this));
            paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject);
          }
          return;
          label605:
          break;
          if (!TextUtils.isEmpty(((PublishVideoEntry)localObject).doodlePath))
          {
            ((PublishVideoEntry)localObject).getBooleanExtra("is_hw_encode", false);
            bool = ((PublishVideoEntry)localObject).isLocalPublish;
            if (((PublishVideoEntry)localObject).businessId == 1) {}
            ((PublishVideoEntry)localObject).getBooleanExtra("landscape_video", false);
            ((PublishVideoEntry)localObject).getIntExtra("thumb_rotation", 0);
            ((PublishVideoEntry)localObject).getBooleanExtra("has_rotate", false);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label688:
          SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label698:
          SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label708:
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!FileUtils.b(paramString)) {}
    while (Build.VERSION.SDK_INT < 10) {
      return 0L;
    }
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private void a(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    Object localObject4 = paramStoryVideoTaskInfo.a();
    Object localObject2;
    if ((paramStoryVideoTaskInfo.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        SLog.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
      }
    }
    else
    {
      return;
    }
    Object localObject3;
    Object localObject1;
    if (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).doodlePath))
    {
      localObject3 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).doodlePath);
      localObject1 = BitmapUtils.a((Bitmap)localObject2, (Bitmap)localObject3);
      if (localObject1 != null)
      {
        ((Bitmap)localObject3).recycle();
        ((Bitmap)localObject2).recycle();
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      localObject1 = ((PublishVideoEntry)localObject4).getStringExtra("pl", null);
      if (localObject1 == null) {
        break;
      }
      localObject3 = StoryVideoItem.PollLayout.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = FFmpegUtils.a((StoryVideoItem.PollLayout)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = BitmapUtils.a((Bitmap)localObject2, localBitmap);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localBitmap.recycle();
          ((Bitmap)localObject2).recycle();
          localObject1 = localObject3;
        }
      }
      localObject2 = ((PublishVideoEntry)localObject4).getStringExtra("i_l", null);
      if (localObject2 == null) {
        break;
      }
      localObject3 = StoryVideoItem.InteractPasterLayout.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = FFmpegUtils.a((StoryVideoItem.InteractPasterLayout)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = BitmapUtils.a((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramStoryVideoTaskInfo = PlayModeUtils.a(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString, true);
      FileUtils.a(QQStoryConstant.c);
      boolean bool = BitmapUtils.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramStoryVideoTaskInfo);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        SLog.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramStoryVideoTaskInfo);
        StoryReportor.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        FileUtils.b(QQStoryContext.a().a(), new File(paramStoryVideoTaskInfo));
        return;
      }
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    if (((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      PublishStoryVideoRequest localPublishStoryVideoRequest = new PublishStoryVideoRequest(bool);
      localPublishStoryVideoRequest.jdField_d_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_g_of_type_JavaLangString;
      localPublishStoryVideoRequest.jdField_f_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_h_of_type_JavaLangString;
      localPublishStoryVideoRequest.jdField_j_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_j_of_type_JavaLangString;
      localPublishStoryVideoRequest.k = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_i_of_type_JavaLangString;
      localPublishStoryVideoRequest.jdField_b_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_b_of_type_Long;
      localPublishStoryVideoRequest.jdField_g_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoLabel;
      localPublishStoryVideoRequest.jdField_h_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoDoodleDescription;
      localPublishStoryVideoRequest.jdField_i_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getStringExtra("all_doodle_text", "");
      localPublishStoryVideoRequest.jdField_e_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().mLocalDate;
      localPublishStoryVideoRequest.jdField_a_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().timeZoneOffset;
      localPublishStoryVideoRequest.jdField_c_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_d_of_type_Long;
      localPublishStoryVideoRequest.jdField_c_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_d_of_type_Int;
      localPublishStoryVideoRequest.jdField_d_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_e_of_type_Int;
      localPublishStoryVideoRequest.jdField_d_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_c_of_type_Long;
      localPublishStoryVideoRequest.l = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoLocationDescription;
      localPublishStoryVideoRequest.m = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().gpsFilterDescription;
      localPublishStoryVideoRequest.n = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().atJsonData;
      localPublishStoryVideoRequest.jdField_g_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().publishFrom;
      localPublishStoryVideoRequest.jdField_e_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoCreateTime;
      localPublishStoryVideoRequest.jdField_h_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoLatitude;
      localPublishStoryVideoRequest.jdField_i_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoLongitude;
      localPublishStoryVideoRequest.o = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().localCreateCity;
      if (((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().isPicture) {}
      for (;;)
      {
        localPublishStoryVideoRequest.jdField_e_of_type_Int = i;
        localPublishStoryVideoRequest.jdField_f_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getIntExtra("video_type", 0);
        localPublishStoryVideoRequest.jdField_a_of_type_ArrayOfByte = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().readerConfBytes;
        localPublishStoryVideoRequest.jdField_b_of_type_ArrayOfByte = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().spreadGroupBytes;
        localPublishStoryVideoRequest.p = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().multiFragmentGroupId;
        localPublishStoryVideoRequest.jdField_b_of_type_Boolean = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getBooleanExtra("ignorePersonalPublish", false);
        localPublishStoryVideoRequest.jdField_j_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getIntExtra("add_video_source", 0);
        localPublishStoryVideoRequest.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localPublishStoryVideoRequest.jdField_c_of_type_ArrayOfByte = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().tagInfoBytes;
        localPublishStoryVideoRequest.q = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getStringExtra("pl", null);
        localPublishStoryVideoRequest.r = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).k;
        localPublishStoryVideoRequest.s = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getStringExtra("i_l", null);
        localPublishStoryVideoRequest.t = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).l;
        localPublishStoryVideoRequest.jdField_c_of_type_Boolean = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getBooleanExtra("story_sync_qzone", false);
        CmdTaskManger.a().a(localPublishStoryVideoRequest, new nfd(this));
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */