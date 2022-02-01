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
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.LinkRichObject;
import com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<StoryVideoTaskInfo>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    super(paramStoryVideoTaskInfo);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    PublishVideoEntry localPublishVideoEntry = paramStoryVideoTaskInfo.a();
    boolean bool;
    int i;
    Object localObject2;
    if ((!TextUtils.isEmpty(localPublishVideoEntry.doodleRawPath)) && (TextUtils.isEmpty(localPublishVideoEntry.doodlePath)))
    {
      if (BitmapUtils.a(localPublishVideoEntry.doodleRawPath))
      {
        paramStoryVideoTaskInfo.jdField_d_of_type_JavaLangString = localPublishVideoEntry.doodleRawPath;
        localPublishVideoEntry.getBooleanExtra("is_hw_encode", false);
        bool = localPublishVideoEntry.isLocalPublish;
        i = localPublishVideoEntry.businessId;
        localPublishVideoEntry.getBooleanExtra("landscape_video", false);
        localPublishVideoEntry.getIntExtra("thumb_rotation", 0);
        localPublishVideoEntry.getBooleanExtra("has_rotate", false);
        localPublishVideoEntry.doodlePath = localPublishVideoEntry.doodleRawPath;
        localObject2 = QQStoryContext.a().a().createEntityManager();
        localPublishVideoEntry.setStatus(1000);
        ((EntityManager)localObject2).persistOrReplace(localPublishVideoEntry);
        SLog.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      }
    }
    else if (!TextUtils.isEmpty(localPublishVideoEntry.doodlePath))
    {
      localPublishVideoEntry.getBooleanExtra("is_hw_encode", false);
      bool = localPublishVideoEntry.isLocalPublish;
      i = localPublishVideoEntry.businessId;
      localPublishVideoEntry.getBooleanExtra("landscape_video", false);
      localPublishVideoEntry.getIntExtra("thumb_rotation", 0);
      localPublishVideoEntry.getBooleanExtra("has_rotate", false);
    }
    try
    {
      if (StoryApi.a(2131099652).booleanValue()) {
        a(paramStoryVideoTaskInfo);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
    }
    Object localObject1 = paramStoryVideoTaskInfo.a().videoUploadTempDir;
    if (localObject1 != null) {
      FileUtils.a((String)localObject1);
    }
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramStoryVideoTaskInfo.a() });
    if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString)) {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(FileUtils.b(paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString)), paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString });
    }
    localObject1 = paramStoryVideoTaskInfo.a().backgroundMusicPath;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(FileUtils.b((String)localObject1)), localObject1 });
    }
    paramStoryVideoTaskInfo.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    StoryVideoUploadProgressManager.a().a(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a());
    if ((!TextUtils.isEmpty(paramStoryVideoTaskInfo.jdField_e_of_type_JavaLangString)) && (TextUtils.isEmpty(paramStoryVideoTaskInfo.k)))
    {
      localObject1 = new ImageFileObject(true);
      ((ImageFileObject)localObject1).jdField_a_of_type_JavaLangString = paramStoryVideoTaskInfo.jdField_e_of_type_JavaLangString;
      ((ImageFileObject)localObject1).a(new StoryVideoUploadTask.1(this, paramStoryVideoTaskInfo));
      paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject1);
    }
    else
    {
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
    }
    if ((!TextUtils.isEmpty(paramStoryVideoTaskInfo.jdField_f_of_type_JavaLangString)) && (TextUtils.isEmpty(paramStoryVideoTaskInfo.l)))
    {
      localObject1 = new ImageFileObject(true);
      ((ImageFileObject)localObject1).jdField_a_of_type_JavaLangString = paramStoryVideoTaskInfo.jdField_f_of_type_JavaLangString;
      ((ImageFileObject)localObject1).a(new StoryVideoUploadTask.2(this, paramStoryVideoTaskInfo));
      paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject1);
    }
    else
    {
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
    }
    if (TextUtils.isEmpty(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_g_of_type_JavaLangString))
    {
      localObject1 = new StoryVideoFileObject(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a(), ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_a_of_type_JavaLangString);
      ((StoryVideoFileObject)localObject1).a(new StoryVideoUploadTask.3(this));
      paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject1);
    }
    else
    {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
    }
    if ((TextUtils.isEmpty(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).j)) && (!TextUtils.isEmpty(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_b_of_type_JavaLangString)))
    {
      localObject1 = new ImageFileObject(false);
      ((ImageFileObject)localObject1).jdField_a_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_b_of_type_JavaLangString;
      ((ImageFileObject)localObject1).a(new StoryVideoUploadTask.4(this));
      paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject1);
    }
    localObject1 = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
    if ((localObject1 != null) && (((VideoLinkInfo)localObject1).jdField_a_of_type_Int == 1) && (((VideoLinkInfo)localObject1).jdField_b_of_type_Int != 2))
    {
      localObject2 = new LinkRichObject(((VideoLinkInfo)localObject1).jdField_a_of_type_JavaLangString);
      ((VideoLinkInfo)localObject1).jdField_b_of_type_Int = 1;
      ((LinkRichObject)localObject2).a(new StoryVideoUploadTask.5(this, (VideoLinkInfo)localObject1, (LinkRichObject)localObject2));
      paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localObject2);
    }
  }
  
  static long a(String paramString)
  {
    if (!FileUtils.b(paramString)) {
      return 0L;
    }
    if (Build.VERSION.SDK_INT >= 10) {}
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
    return 0L;
  }
  
  private void a(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    Object localObject2 = paramStoryVideoTaskInfo.a();
    if ((paramStoryVideoTaskInfo.jdField_b_of_type_Int == 0) && (!((PublishVideoEntry)localObject2).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject2).mLocalRawPicPath)))
    {
      Bitmap localBitmap1 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject2).mLocalRawPicPath);
      if (localBitmap1 == null)
      {
        SLog.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
        return;
      }
      Object localObject1 = localBitmap1;
      if (!TextUtils.isEmpty(((PublishVideoEntry)localObject2).doodlePath))
      {
        Bitmap localBitmap2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject2).doodlePath);
        localObject2 = BitmapUtils.b(localBitmap1, localBitmap2);
        localObject1 = localBitmap1;
        if (localObject2 != null)
        {
          localBitmap2.recycle();
          localBitmap1.recycle();
          localObject1 = localObject2;
        }
      }
      paramStoryVideoTaskInfo = PlayModeUtils.a(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString, true);
      FileUtils.a(QQStoryConstant.jdField_f_of_type_JavaLangString);
      boolean bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 100, paramStoryVideoTaskInfo);
      ((Bitmap)localObject1).recycle();
      if (bool)
      {
        SLog.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramStoryVideoTaskInfo);
        StoryReportor.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        FileUtils.b(QQStoryContext.a().a(), new File(paramStoryVideoTaskInfo));
        return;
      }
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
    }
  }
  
  protected void c()
  {
    StoryVideoUploadProgressManager.a().c(((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a());
    boolean bool;
    if (((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().publishFrom == 14) {
      bool = true;
    } else {
      bool = false;
    }
    PublishStoryVideoRequest localPublishStoryVideoRequest = new PublishStoryVideoRequest(bool);
    localPublishStoryVideoRequest.jdField_d_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_g_of_type_JavaLangString;
    localPublishStoryVideoRequest.jdField_f_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_h_of_type_JavaLangString;
    localPublishStoryVideoRequest.j = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).j;
    localPublishStoryVideoRequest.k = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).i;
    localPublishStoryVideoRequest.jdField_c_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_b_of_type_Long;
    localPublishStoryVideoRequest.jdField_g_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoLabel;
    localPublishStoryVideoRequest.jdField_h_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoDoodleDescription;
    localPublishStoryVideoRequest.jdField_e_of_type_JavaLangString = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().mLocalDate;
    localPublishStoryVideoRequest.jdField_b_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().timeZoneOffset;
    localPublishStoryVideoRequest.jdField_d_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_d_of_type_Long;
    localPublishStoryVideoRequest.jdField_c_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_d_of_type_Int;
    localPublishStoryVideoRequest.jdField_d_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_e_of_type_Int;
    localPublishStoryVideoRequest.jdField_e_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_c_of_type_Long;
    localPublishStoryVideoRequest.l = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoLocationDescription;
    localPublishStoryVideoRequest.m = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().gpsFilterDescription;
    localPublishStoryVideoRequest.n = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().atJsonData;
    localPublishStoryVideoRequest.jdField_g_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().publishFrom;
    localPublishStoryVideoRequest.jdField_f_of_type_Long = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoCreateTime;
    localPublishStoryVideoRequest.jdField_h_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoLatitude;
    localPublishStoryVideoRequest.i = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().videoLongitude;
    localPublishStoryVideoRequest.o = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().localCreateCity;
    localPublishStoryVideoRequest.jdField_f_of_type_Int = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getIntExtra("video_type", 0);
    localPublishStoryVideoRequest.jdField_a_of_type_ArrayOfByte = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().readerConfBytes;
    localPublishStoryVideoRequest.jdField_b_of_type_ArrayOfByte = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().spreadGroupBytes;
    localPublishStoryVideoRequest.p = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().multiFragmentGroupId;
    localPublishStoryVideoRequest.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
    localPublishStoryVideoRequest.jdField_c_of_type_ArrayOfByte = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().tagInfoBytes;
    localPublishStoryVideoRequest.q = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getStringExtra("pl", null);
    localPublishStoryVideoRequest.r = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).k;
    localPublishStoryVideoRequest.s = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getStringExtra("i_l", null);
    localPublishStoryVideoRequest.t = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).l;
    localPublishStoryVideoRequest.jdField_c_of_type_Boolean = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a().getBooleanExtra("story_sync_qzone", false);
    localPublishStoryVideoRequest.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = ((StoryVideoTaskInfo)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
    CmdTaskManger.a().a(localPublishStoryVideoRequest, new StoryVideoUploadTask.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */