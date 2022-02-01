package com.tencent.biz.qqstory.base.videoupload;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.composite.step.HwVideoMerge;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.monitor.CaptureFreqMonitorItem;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class VideoCompositeManager
  extends BaseManger
{
  protected final ArrayList<String> a = new ArrayList(3);
  protected final ConcurrentHashMap<String, VideoCompositeManager.CompositeResult> b = new ConcurrentHashMap(3);
  protected final Object c = new Object();
  protected final Object d = new Object();
  protected AtomicBoolean e = new AtomicBoolean(false);
  private VideoSaveToAlbumHelper f = new VideoSaveToAlbumHelper();
  
  private void a(VideoCompositeManager.CompositeVideoEvent paramCompositeVideoEvent, PublishVideoEntry paramPublishVideoEntry, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString, long paramLong, VideoCompositeManager.CompositeResult paramCompositeResult)
  {
    long l = SystemClock.elapsedRealtime();
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(paramString);
    if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {
      paramString = "0";
    } else {
      paramString = "1";
    }
    StoryReportor.b("publish_story", "video_composite_wait", a(localPublishVideoEntry), paramCompositeResult.g.errorCode, new String[] { paramCompositeResult.g.errorMsg, String.valueOf(l - paramLong), String.valueOf(localPublishVideoEntry.videoDuration), paramString });
  }
  
  protected int a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (!paramPublishVideoEntry.isLocalPublish)
    {
      if (!paramPublishVideoEntry.isPicture) {
        return 1;
      }
      return 2;
    }
    if (!paramPublishVideoEntry.isPicture) {
      return 3;
    }
    return 4;
  }
  
  protected void a(int paramInt, String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    try
    {
      int i = (int)com.tencent.mobileqq.utils.FileUtils.getFileSizes(paramString);
      if (i <= 0) {
        return;
      }
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(9);
      String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(20);
      String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(18);
      String str3 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
      ((MediaMetadataRetriever)localObject).release();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("*");
      ((StringBuilder)localObject).append(str3);
      localObject = ((StringBuilder)localObject).toString();
      StoryReportor.b("publish_story", "video_info", paramInt, i, new String[] { localObject, paramString, String.valueOf(paramPublishVideoEntry.recordFrames), str1 });
      SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "video info size:%d, duration:%s, framesCount:%d, bitRate:%s, picSize:%s", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(paramPublishVideoEntry.recordFrames), str1, localObject });
      return;
    }
    catch (Exception paramString)
    {
      SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "exception ", paramString);
    }
  }
  
  protected void a(PublishVideoEntry paramPublishVideoEntry, String arg2, int paramInt, String arg4, String paramString3, long paramLong)
  {
    VideoCompositeManager.CompositeVideoEvent localCompositeVideoEvent = new VideoCompositeManager.CompositeVideoEvent(this);
    localCompositeVideoEvent.g = new ErrorMessage(paramInt, ???);
    localCompositeVideoEvent.a = ???;
    localCompositeVideoEvent.b = paramString3;
    if ((paramInt == 0) && ((TextUtils.isEmpty(paramString3)) || (!com.tencent.biz.qqstory.utils.FileUtils.c(paramString3)) || (com.tencent.mobileqq.utils.FileUtils.getFileSizes(paramString3) < 100L))) {
      localCompositeVideoEvent.g = new ErrorMessage(940007, String.format("vid:%s file:%s", new Object[] { ???, paramString3 }));
    }
    synchronized (this.c)
    {
      if (this.a.remove(???)) {
        this.e.set(false);
      }
      this.b.put(???, localCompositeVideoEvent);
      ??? = "";
      Object localObject1;
      long l1;
      Object localObject2;
      try
      {
        if (localCompositeVideoEvent.g.isFail())
        {
          long l2;
          if (new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory())
          {
            localObject1 = com.tencent.mobileqq.utils.FileUtils.getChildFiles(paramPublishVideoEntry.mLocalRawVideoDir).iterator();
            l1 = 0L;
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              l1 += com.tencent.mobileqq.utils.FileUtils.getFileSizes((String)localObject2);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(???);
              localStringBuilder.append((String)localObject2);
              ??? = localStringBuilder.toString();
            }
            localObject1 = ???;
            l2 = l1;
            if (TextUtils.isEmpty(???))
            {
              localObject1 = paramPublishVideoEntry.mLocalRawVideoDir;
              l2 = l1;
            }
          }
          else
          {
            l2 = com.tencent.mobileqq.utils.FileUtils.getFileSizes(paramPublishVideoEntry.mLocalRawVideoDir);
            ??? = new StringBuilder();
            ???.append("");
            ???.append(paramPublishVideoEntry.mLocalRawVideoDir);
            localObject1 = ???.toString();
          }
          l1 = com.tencent.biz.qqstory.utils.FileUtils.b();
          localCompositeVideoEvent.g.errorMsg = String.format("errorCode:%d, sdcard free size:%d, vf dir size:%d, vf filename:%s, oMsg:%s", new Object[] { Integer.valueOf(localCompositeVideoEvent.g.errorCode), Long.valueOf(l1), Long.valueOf(l2), localObject1, localCompositeVideoEvent.g.errorMsg });
          if (l2 < 100L) {
            localCompositeVideoEvent.g.errorCode = 940018;
          }
          SLog.e("Q.qqstory.publish.upload.VideoCompositeManager", localCompositeVideoEvent.g.errorMsg);
        }
      }
      catch (Exception ???)
      {
        SLog.c("Q.qqstory.publish.upload.VideoCompositeManager", "", ???);
      }
      boolean bool2 = paramPublishVideoEntry.getBooleanExtra("isEdited", false);
      if ((paramPublishVideoEntry.isLocalPublish) && (bool2)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      boolean bool1;
      if (((paramPublishVideoEntry.businessId == 1) || (paramPublishVideoEntry.businessId == 14)) && (!paramPublishVideoEntry.isPicture)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("save from: story ");
        ???.append(bool2);
        ???.append(" ");
        ???.append(paramPublishVideoEntry.isLocalPublish);
        ???.append(" ");
        ???.append(bool1);
        QLog.d("Q.qqstory.publish.upload.VideoCompositeManager", 2, ???.toString());
      }
      if ((bool1) || (paramInt != 0))
      {
        if (localCompositeVideoEvent.g.isSuccess())
        {
          SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task.");
          ??? = this.f.a(???);
          this.f.a(paramString3, ???);
          l1 = paramPublishVideoEntry.getLongExtra("groupUin", -1L);
          paramString3 = paramPublishVideoEntry.getStringExtra("pl", "");
          localObject1 = paramPublishVideoEntry.getStringExtra("i_l", "");
          SLog.a("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task. pl: %s", String.valueOf(paramString3));
          localObject2 = this.f;
          paramInt = paramPublishVideoEntry.videoWidth;
          int i = paramPublishVideoEntry.videoHeight;
          if (l1 > 0L) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((VideoSaveToAlbumHelper)localObject2).a(???, ???, null, paramInt, i, bool1, StoryVideoItem.PollLayout.a(paramString3), StoryVideoItem.InteractPasterLayout.a((String)localObject1));
        }
        else
        {
          SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "failed to composite. let's save original video to album.");
          ??? = new StringBuilder();
          ???.append(paramPublishVideoEntry.videoUploadTempDir);
          ???.append("mc_audio.mp4");
          ??? = ???.toString();
          paramString3 = AudioEncoder.a(null, null, 0);
          paramString3.b = ???;
          paramString3.a = paramPublishVideoEntry.mAudioFilePath;
          paramInt = AudioEncoder.a(paramString3);
          if (paramInt == 0)
          {
            ??? = PlayModeUtils.a(???, false);
            paramInt = HwVideoMerge.merge(paramPublishVideoEntry.mLocalRawVideoDir, ???, ???, 0);
            if (paramInt == 0)
            {
              SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: success.");
              com.tencent.biz.qqstory.utils.FileUtils.b(BaseApplication.getContext(), new File(???));
            }
            else
            {
              SLog.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: errcode=%s", new Object[] { Integer.valueOf(paramInt) });
            }
          }
          else
          {
            ??? = new StringBuilder();
            ???.append("save original video. AudioEncoder.encodeSafely: errcode=%s");
            ???.append(paramInt);
            SLog.e("Q.qqstory.publish.upload.VideoCompositeManager", ???.toString());
          }
        }
        this.f.a();
      }
      StoryDispatcher.a().dispatch(localCompositeVideoEvent);
      synchronized (this.d)
      {
        this.d.notifyAll();
        SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "end composite result:%s", new Object[] { localCompositeVideoEvent });
        c();
        a(localCompositeVideoEvent, paramPublishVideoEntry, paramLong);
        return;
      }
    }
    for (;;)
    {
      throw paramPublishVideoEntry;
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.c)
    {
      if (!this.a.contains(paramString))
      {
        this.a.add(paramString);
        SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "add composite vid:%s", new Object[] { paramString });
      }
      c();
      return;
    }
  }
  
  public VideoCompositeManager.CompositeResult b(String paramString)
  {
    long l = SystemClock.elapsedRealtime();
    synchronized (this.c)
    {
      VideoCompositeManager.CompositeResult localCompositeResult1 = (VideoCompositeManager.CompositeResult)this.b.get(paramString);
      if (localCompositeResult1 != null)
      {
        if (com.tencent.biz.qqstory.utils.FileUtils.c(localCompositeResult1.b))
        {
          a(paramString, l, localCompositeResult1);
          return localCompositeResult1;
        }
        this.b.remove(localCompositeResult1.a);
      }
      a(paramString);
      int i = 0;
      try
      {
        synchronized (this.d)
        {
          SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "start wait vid:%s", new Object[] { paramString });
          this.d.wait(10000L);
          SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "end wait vid:%s", new Object[] { paramString });
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "waiting lock", localInterruptedException);
          synchronized (this.c)
          {
            boolean bool = this.a.contains(paramString);
            VideoCompositeManager.CompositeResult localCompositeResult2 = (VideoCompositeManager.CompositeResult)this.b.get(paramString);
            if (localCompositeResult2 != null)
            {
              SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "get result:%s", new Object[] { localCompositeResult2 });
              a(paramString, l, localCompositeResult2);
              return localCompositeResult2;
            }
            if (!bool)
            {
              ??? = new VideoCompositeManager.CompositeResult(this);
              ((VideoCompositeManager.CompositeResult)???).g = new ErrorMessage(942011, "no video need composite");
              SLog.e("Q.qqstory.publish.upload.VideoCompositeManager", "no video should composite is imposable vid:%s", new Object[] { paramString });
              a(paramString, l, (VideoCompositeManager.CompositeResult)???);
              return ???;
            }
            if (i > 40)
            {
              localCompositeResult2 = new VideoCompositeManager.CompositeResult(this);
              localCompositeResult2.g = new ErrorMessage(942009, "wait composite video timeout");
              SLog.e("Q.qqstory.publish.upload.VideoCompositeManager", "wait composite video timeout vid:%s", new Object[] { paramString });
              a(paramString, l, localCompositeResult2);
              synchronized (this.c)
              {
                this.a.remove(paramString);
                this.e.set(false);
                return localCompositeResult2;
              }
            }
            i += 1;
          }
        }
      }
      throw paramString;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected void c()
  {
    if (this.e.getAndSet(true))
    {
      SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "video composite ing");
      return;
    }
    synchronized (this.c)
    {
      String str;
      if (this.a.size() > 0) {
        str = (String)this.a.get(0);
      } else {
        str = "";
      }
      if (TextUtils.isEmpty(str))
      {
        this.e.set(false);
        SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "no video to composite");
        return;
      }
      SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "will composite vid:%s", new Object[] { str });
      long l = System.currentTimeMillis();
      if (CaptureFreqMonitor.d) {
        CaptureFreqMonitor.f.c();
      }
      Bosses.get().postJob(new VideoCompositeManager.1(this, "Q.qqstory.publish.upload.VideoCompositeManager", str, l));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager
 * JD-Core Version:    0.7.0.1
 */