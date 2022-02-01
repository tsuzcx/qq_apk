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
  private AtomicInteger h = new AtomicInteger(0);
  
  public StoryVideoUploadTask(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    super(paramStoryVideoTaskInfo);
    long l = SystemClock.elapsedRealtime();
    PublishVideoEntry localPublishVideoEntry = paramStoryVideoTaskInfo.e();
    boolean bool;
    int i;
    Object localObject2;
    if ((!TextUtils.isEmpty(localPublishVideoEntry.doodleRawPath)) && (TextUtils.isEmpty(localPublishVideoEntry.doodlePath)))
    {
      if (BitmapUtils.b(localPublishVideoEntry.doodleRawPath))
      {
        paramStoryVideoTaskInfo.j = localPublishVideoEntry.doodleRawPath;
        localPublishVideoEntry.getBooleanExtra("is_hw_encode", false);
        bool = localPublishVideoEntry.isLocalPublish;
        i = localPublishVideoEntry.businessId;
        localPublishVideoEntry.getBooleanExtra("landscape_video", false);
        localPublishVideoEntry.getIntExtra("thumb_rotation", 0);
        localPublishVideoEntry.getBooleanExtra("has_rotate", false);
        localPublishVideoEntry.doodlePath = localPublishVideoEntry.doodleRawPath;
        localObject2 = QQStoryContext.a().d().createEntityManager();
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
      if (StoryApi.a(2131099653).booleanValue()) {
        a(paramStoryVideoTaskInfo);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
    }
    Object localObject1 = paramStoryVideoTaskInfo.e().videoUploadTempDir;
    if (localObject1 != null) {
      FileUtils.g((String)localObject1);
    }
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramStoryVideoTaskInfo.e() });
    if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.h)) {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(FileUtils.c(paramStoryVideoTaskInfo.h)), paramStoryVideoTaskInfo.h });
    }
    localObject1 = paramStoryVideoTaskInfo.e().backgroundMusicPath;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(FileUtils.c((String)localObject1)), localObject1 });
    }
    paramStoryVideoTaskInfo.e = SystemClock.elapsedRealtime();
    StoryVideoUploadProgressManager.a().a(((StoryVideoTaskInfo)this.b).d());
    if ((!TextUtils.isEmpty(paramStoryVideoTaskInfo.k)) && (TextUtils.isEmpty(paramStoryVideoTaskInfo.w)))
    {
      localObject1 = new ImageFileObject(true);
      ((ImageFileObject)localObject1).a = paramStoryVideoTaskInfo.k;
      ((ImageFileObject)localObject1).a(new StoryVideoUploadTask.1(this, paramStoryVideoTaskInfo));
      paramStoryVideoTaskInfo.b.add(localObject1);
    }
    else
    {
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
    }
    if ((!TextUtils.isEmpty(paramStoryVideoTaskInfo.l)) && (TextUtils.isEmpty(paramStoryVideoTaskInfo.x)))
    {
      localObject1 = new ImageFileObject(true);
      ((ImageFileObject)localObject1).a = paramStoryVideoTaskInfo.l;
      ((ImageFileObject)localObject1).a(new StoryVideoUploadTask.2(this, paramStoryVideoTaskInfo));
      paramStoryVideoTaskInfo.b.add(localObject1);
    }
    else
    {
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
    }
    if (TextUtils.isEmpty(((StoryVideoTaskInfo)this.b).s))
    {
      localObject1 = new StoryVideoFileObject(((StoryVideoTaskInfo)this.b).d(), ((StoryVideoTaskInfo)this.b).g);
      ((StoryVideoFileObject)localObject1).a(new StoryVideoUploadTask.3(this));
      paramStoryVideoTaskInfo.b.add(localObject1);
    }
    else
    {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
    }
    if ((TextUtils.isEmpty(((StoryVideoTaskInfo)this.b).v)) && (!TextUtils.isEmpty(((StoryVideoTaskInfo)this.b).h)))
    {
      localObject1 = new ImageFileObject(false);
      ((ImageFileObject)localObject1).a = ((StoryVideoTaskInfo)this.b).h;
      ((ImageFileObject)localObject1).a(new StoryVideoUploadTask.4(this));
      paramStoryVideoTaskInfo.b.add(localObject1);
    }
    localObject1 = ((StoryVideoTaskInfo)this.b).B;
    if ((localObject1 != null) && (((VideoLinkInfo)localObject1).a == 1) && (((VideoLinkInfo)localObject1).g != 2))
    {
      localObject2 = new LinkRichObject(((VideoLinkInfo)localObject1).b);
      ((VideoLinkInfo)localObject1).g = 1;
      ((LinkRichObject)localObject2).a(new StoryVideoUploadTask.5(this, (VideoLinkInfo)localObject1, (LinkRichObject)localObject2));
      paramStoryVideoTaskInfo.b.add(localObject2);
    }
  }
  
  static long a(String paramString)
  {
    if (!FileUtils.c(paramString)) {
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
    Object localObject2 = paramStoryVideoTaskInfo.e();
    if ((paramStoryVideoTaskInfo.c == 0) && (!((PublishVideoEntry)localObject2).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject2).mLocalRawPicPath)))
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
      paramStoryVideoTaskInfo = PlayModeUtils.a(paramStoryVideoTaskInfo.s, true);
      FileUtils.b(QQStoryConstant.g);
      boolean bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 100, paramStoryVideoTaskInfo);
      ((Bitmap)localObject1).recycle();
      if (bool)
      {
        SLog.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramStoryVideoTaskInfo);
        StoryReportor.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        FileUtils.b(QQStoryContext.a().c(), new File(paramStoryVideoTaskInfo));
        return;
      }
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
    }
  }
  
  protected void e()
  {
    StoryVideoUploadProgressManager.a().c(((StoryVideoTaskInfo)this.b).d());
    boolean bool;
    if (((StoryVideoTaskInfo)this.b).e().publishFrom == 14) {
      bool = true;
    } else {
      bool = false;
    }
    PublishStoryVideoRequest localPublishStoryVideoRequest = new PublishStoryVideoRequest(bool);
    localPublishStoryVideoRequest.i = ((StoryVideoTaskInfo)this.b).s;
    localPublishStoryVideoRequest.l = ((StoryVideoTaskInfo)this.b).t;
    localPublishStoryVideoRequest.q = ((StoryVideoTaskInfo)this.b).v;
    localPublishStoryVideoRequest.r = ((StoryVideoTaskInfo)this.b).u;
    localPublishStoryVideoRequest.p = ((StoryVideoTaskInfo)this.b).m;
    localPublishStoryVideoRequest.m = ((StoryVideoTaskInfo)this.b).e().videoLabel;
    localPublishStoryVideoRequest.n = ((StoryVideoTaskInfo)this.b).e().videoDoodleDescription;
    localPublishStoryVideoRequest.j = ((StoryVideoTaskInfo)this.b).e().mLocalDate;
    localPublishStoryVideoRequest.k = ((StoryVideoTaskInfo)this.b).e().timeZoneOffset;
    localPublishStoryVideoRequest.t = ((StoryVideoTaskInfo)this.b).q;
    localPublishStoryVideoRequest.u = ((StoryVideoTaskInfo)this.b).o;
    localPublishStoryVideoRequest.v = ((StoryVideoTaskInfo)this.b).p;
    localPublishStoryVideoRequest.y = ((StoryVideoTaskInfo)this.b).n;
    localPublishStoryVideoRequest.z = ((StoryVideoTaskInfo)this.b).e().videoLocationDescription;
    localPublishStoryVideoRequest.A = ((StoryVideoTaskInfo)this.b).e().gpsFilterDescription;
    localPublishStoryVideoRequest.B = ((StoryVideoTaskInfo)this.b).e().atJsonData;
    localPublishStoryVideoRequest.C = ((StoryVideoTaskInfo)this.b).e().publishFrom;
    localPublishStoryVideoRequest.D = ((StoryVideoTaskInfo)this.b).e().videoCreateTime;
    localPublishStoryVideoRequest.E = ((StoryVideoTaskInfo)this.b).e().videoLatitude;
    localPublishStoryVideoRequest.F = ((StoryVideoTaskInfo)this.b).e().videoLongitude;
    localPublishStoryVideoRequest.G = ((StoryVideoTaskInfo)this.b).e().localCreateCity;
    localPublishStoryVideoRequest.x = ((StoryVideoTaskInfo)this.b).e().getIntExtra("video_type", 0);
    localPublishStoryVideoRequest.H = ((StoryVideoTaskInfo)this.b).e().readerConfBytes;
    localPublishStoryVideoRequest.I = ((StoryVideoTaskInfo)this.b).e().spreadGroupBytes;
    localPublishStoryVideoRequest.J = ((StoryVideoTaskInfo)this.b).e().multiFragmentGroupId;
    localPublishStoryVideoRequest.s = ((StoryVideoTaskInfo)this.b).r;
    localPublishStoryVideoRequest.M = ((StoryVideoTaskInfo)this.b).e().tagInfoBytes;
    localPublishStoryVideoRequest.N = ((StoryVideoTaskInfo)this.b).e().getStringExtra("pl", null);
    localPublishStoryVideoRequest.O = ((StoryVideoTaskInfo)this.b).w;
    localPublishStoryVideoRequest.P = ((StoryVideoTaskInfo)this.b).e().getStringExtra("i_l", null);
    localPublishStoryVideoRequest.Q = ((StoryVideoTaskInfo)this.b).x;
    localPublishStoryVideoRequest.U = ((StoryVideoTaskInfo)this.b).e().getBooleanExtra("story_sync_qzone", false);
    localPublishStoryVideoRequest.R = ((StoryVideoTaskInfo)this.b).B;
    CmdTaskManger.a().a(localPublishStoryVideoRequest, new StoryVideoUploadTask.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */