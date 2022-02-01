package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.aelight.camera.qqstory.api.ILaunchVideoEditorForAlbum;
import com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowConfigManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowConfigManager.Music;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.biz.qqstory.utils.ffmpeg.QimSegmentMergeUtil;
import com.tencent.biz.qqstory.utils.ffmpeg.SegmentClipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoMerger
  extends ToVideoConverter
{
  long a;
  private MediaFormat b;
  private boolean c = false;
  
  public void a(VideoMerger.MergeContext paramMergeContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoMerger", 2, "start combine");
    }
    if (paramMergeContext.a == null) {
      return;
    }
    Object localObject2 = new QimSegmentMergeUtil();
    Object localObject1 = new ArrayList(paramMergeContext.a.size());
    Object localObject6 = new ArrayList(paramMergeContext.a.size());
    Object localObject4 = (TransitionHandler)QQStoryContext.k().getBusinessHandler(PeakAppInterface.c);
    Object localObject7 = new ArrayList();
    Object localObject5 = paramMergeContext.a.iterator();
    boolean bool2 = false;
    Object localObject8;
    while (((Iterator)localObject5).hasNext())
    {
      localObject8 = (SlideItemInfo)((Iterator)localObject5).next();
      Object localObject9 = ((TransitionHandler)localObject4).a(((SlideItemInfo)localObject8).f);
      if (localObject9 != null)
      {
        ((List)localObject1).add(((LocalMediaInfo)localObject9).path);
        ((List)localObject7).add(((LocalMediaInfo)localObject9).mAudioPath);
        ((SlideItemInfo)localObject8).k = ((LocalMediaInfo)localObject9).path;
        ((SlideItemInfo)localObject8).l = ((LocalMediaInfo)localObject9).mAudioPath;
        ((SlideItemInfo)localObject8).m = ((LocalMediaInfo)localObject9).mHasAudioTrack;
        ((SlideItemInfo)localObject8).n = ((LocalMediaInfo)localObject9).mSampleRate;
        ((List)localObject6).add(localObject8);
        if (((SlideItemInfo)localObject8).e == 1)
        {
          if (((SlideItemInfo)localObject8).m) {
            bool2 = true;
          }
          localObject9 = new StringBuilder();
          ((StringBuilder)localObject9).append("mergeRunnable hasAudioTrack=");
          ((StringBuilder)localObject9).append(((SlideItemInfo)localObject8).m);
          ((StringBuilder)localObject9).append(" mSampleRate:");
          ((StringBuilder)localObject9).append(((SlideItemInfo)localObject8).n);
          QLog.i("VideoMerger", 1, ((StringBuilder)localObject9).toString());
        }
      }
    }
    if (a(paramMergeContext))
    {
      a(9, "", null, null, null, paramMergeContext);
      return;
    }
    if (this.b == null)
    {
      if (((TransitionHandler)localObject4).a() != null)
      {
        this.b = ((TransitionHandler)localObject4).a();
        if (QLog.isColorLevel()) {
          QLog.d("VideoMerger", 2, "transHandler.getMediaFormat");
        }
      }
      else
      {
        if (((List)localObject1).size() > 0)
        {
          this.b = ImageToVideo.a((String)((List)localObject1).get(0));
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("ImageToVideo.getVideoFormatFromVideo, videoPath : ");
            ((StringBuilder)localObject4).append((String)((List)localObject1).get(0));
            QLog.d("VideoMerger", 2, ((StringBuilder)localObject4).toString());
          }
        }
        if (this.b == null)
        {
          this.b = ImageToVideo.a();
          if (QLog.isColorLevel()) {
            QLog.d("VideoMerger", 2, "ImageToVideo.getVideoFormatDefault");
          }
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "mVideoFormat not null");
    }
    if (paramMergeContext.b != null) {
      paramMergeContext.b.a(bool2);
    }
    localObject5 = SlideShowUtils.a();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject5);
    ((StringBuilder)localObject4).append(".dat");
    localObject4 = ((StringBuilder)localObject4).toString();
    boolean bool1;
    if (bool2)
    {
      bool3 = SegmentClipUtils.b((List)localObject6);
      localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append("clip audio success=");
      ((StringBuilder)localObject8).append(bool3);
      QLog.i("VideoMerger", 1, ((StringBuilder)localObject8).toString());
      bool1 = bool3;
      if (bool3)
      {
        ((List)localObject7).clear();
        localObject8 = ((List)localObject6).iterator();
        while (((Iterator)localObject8).hasNext()) {
          ((List)localObject7).add(((SlideItemInfo)((Iterator)localObject8).next()).l);
        }
        bool1 = ((QimSegmentMergeUtil)localObject2).a((List)localObject7, (String)localObject4);
      }
    }
    else
    {
      bool1 = true;
    }
    localObject7 = new StringBuilder();
    ((StringBuilder)localObject7).append("merge audio success ");
    ((StringBuilder)localObject7).append(bool1);
    QLog.i("VideoMerger", 1, ((StringBuilder)localObject7).toString());
    boolean bool3 = bool1;
    if (bool1)
    {
      bool1 = SegmentClipUtils.a((List)localObject6);
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("clip video success=");
      ((StringBuilder)localObject7).append(bool1);
      QLog.i("VideoMerger", 1, ((StringBuilder)localObject7).toString());
      ((List)localObject1).clear();
      localObject6 = ((List)localObject6).iterator();
      for (;;)
      {
        bool3 = bool1;
        if (!((Iterator)localObject6).hasNext()) {
          break;
        }
        localObject7 = (SlideItemInfo)((Iterator)localObject6).next();
        if (((SlideItemInfo)localObject7).e == 0) {
          ((List)localObject1).add(((SlideItemInfo)localObject7).k);
        }
        ((List)localObject1).add(((SlideItemInfo)localObject7).k);
      }
    }
    localObject6 = ((List)localObject1).iterator();
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (String)((Iterator)localObject6).next();
      localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append("merge print video begin:  path: ");
      ((StringBuilder)localObject8).append((String)localObject7);
      QLog.i("VideoMerger", 1, ((StringBuilder)localObject8).toString());
    }
    long l1;
    long l2;
    if (bool3)
    {
      l1 = System.currentTimeMillis();
      bool1 = ((QimSegmentMergeUtil)localObject2).a((List)localObject1, (String)localObject5, 720, 1280, this.b);
      l2 = System.currentTimeMillis();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("merge video result ");
      ((StringBuilder)localObject6).append(bool1);
      ((StringBuilder)localObject6).append(" cost: ");
      ((StringBuilder)localObject6).append(l2 - l1);
      ((StringBuilder)localObject6).append(" ms");
      QLog.i("VideoMerger", 1, ((StringBuilder)localObject6).toString());
    }
    else
    {
      bool1 = false;
    }
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("merge video result ");
    ((StringBuilder)localObject6).append(bool1);
    QLog.i("VideoMerger", 1, ((StringBuilder)localObject6).toString());
    localObject6 = new LocalMediaInfo();
    ((LocalMediaInfo)localObject6).path = ((String)localObject5);
    ((LocalMediaInfo)localObject6).mMimeType = "video";
    if (QQAudioHelper.g()) {
      ((LocalMediaInfo)localObject6).mTransferPosList = ((QimSegmentMergeUtil)localObject2).b((List)localObject1, (String)localObject5);
    } else {
      ((LocalMediaInfo)localObject6).mTransferPosList = ((QimSegmentMergeUtil)localObject2).a((List)localObject1);
    }
    localObject2 = MediaScanner.getInstance(BaseApplicationImpl.getContext());
    try
    {
      ((MediaScanner)localObject2).buildAndUpdateVideo((LocalMediaInfo)localObject6);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("VideoMerger", 1, "pic2video err", localThrowable);
    }
    if (bool1)
    {
      l1 = System.currentTimeMillis();
      l2 = this.a;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(l1 - l2);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append(paramMergeContext.a.size());
      ((StringBuilder)localObject7).append("");
      StoryReportor.a("actAlbumTime", new String[] { localObject3, ((StringBuilder)localObject7).toString() });
      localObject7 = new CameraCaptureView.VideoCaptureResult();
      ((CameraCaptureView.VideoCaptureResult)localObject7).videoFrameCount = ((List)localObject1).size();
      if (bool2) {
        ((CameraCaptureView.VideoCaptureResult)localObject7).audioDataFilePath = ((String)localObject4);
      } else {
        ((CameraCaptureView.VideoCaptureResult)localObject7).audioDataFilePath = Image2Video.a();
      }
      ((CameraCaptureView.VideoCaptureResult)localObject7).videoMp4FilePath = ((String)localObject5);
      localObject1 = null;
      localObject3 = paramMergeContext.c.getIntent();
      if (localObject3 != null) {
        localObject1 = ((Intent)localObject3).getBundleExtra("state");
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new Bundle();
      }
      localObject4 = paramMergeContext.c.getIntent().getExtras();
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = new Bundle();
      }
      localObject4 = paramMergeContext.c.getIntent();
      int i = ((Intent)localObject4).getIntExtra("entrance_type", 99);
      bool2 = ((Intent)localObject4).getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
      int j = ((Bundle)localObject1).getInt("qq_sub_business_id", 2);
      int k = ((Bundle)localObject1).getInt("edit_video_type", 10002);
      ((ILaunchVideoEditorForAlbum)QRoute.api(ILaunchVideoEditorForAlbum.class)).setVideoParams(k, i, j, SlideShowPhotoListManager.a().d());
      ((Bundle)localObject1).putBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", true);
      ((Bundle)localObject1).putString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", (String)localObject5);
      ((Bundle)localObject1).putInt("extra_transiton_src_from", 1);
      ((Bundle)localObject1).putInt("extra_slide_entrance", paramMergeContext.e);
      ((Bundle)localObject1).putInt("extra_slide_sticker_id", paramMergeContext.f);
      ((Bundle)localObject1).putString("extra_slide_sticker_str", paramMergeContext.g);
      if (paramMergeContext.a.size() > 0)
      {
        ((Bundle)localObject1).putString("extra_transiton_default", ((SlideItemInfo)paramMergeContext.a.get(0)).r);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("doMerge mTransId=");
          ((StringBuilder)localObject4).append(((SlideItemInfo)paramMergeContext.a.get(0)).r);
          QLog.d("VideoMerger", 2, ((StringBuilder)localObject4).toString());
        }
        if (((SlideItemInfo)paramMergeContext.a.get(0)).b != null)
        {
          ((Bundle)localObject1).putInt("extra_ablum_type", ((SlideItemInfo)paramMergeContext.a.get(0)).b.b);
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("doMerge mAlbumType=");
            ((StringBuilder)localObject4).append(((SlideItemInfo)paramMergeContext.a.get(0)).b.b);
            QLog.d("VideoMerger", 2, ((StringBuilder)localObject4).toString());
          }
        }
        localObject4 = SlideShowConfigManager.a(paramMergeContext.c).a(((SlideItemInfo)paramMergeContext.a.get(0)).r);
        if ((localObject4 != null) && (((List)localObject4).size() > 0))
        {
          localObject4 = ((IAELaunchMusicConfigManager)QRoute.api(IAELaunchMusicConfigManager.class)).getMusicItemById(((SlideShowConfigManager.Music)((List)localObject4).get(0)).a, ((SlideShowConfigManager.Music)((List)localObject4).get(0)).b);
          if (localObject4 != null)
          {
            localObject5 = new Bundle();
            localObject8 = new Bundle();
            ((Bundle)localObject8).putParcelable("select_music", (Parcelable)localObject4);
            ((Bundle)localObject8).putString("select_music_local_path", ((MusicItemInfo)localObject4).getLocalPath());
            ((Bundle)localObject8).putInt("capture_mode", 2);
            ((Bundle)localObject5).putBundle(((IAEClassManager)QRoute.api(IAEClassManager.class)).getMusicProviderViewClass().getSimpleName(), (Bundle)localObject8);
            ((Bundle)localObject3).putBundle("container", (Bundle)localObject5);
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("doMerge musicItemInfo=");
              ((StringBuilder)localObject5).append(((MusicItemInfo)localObject4).mTagName);
              ((StringBuilder)localObject5).append(" ");
              ((StringBuilder)localObject5).append(((MusicItemInfo)localObject4).mItemId);
              QLog.d("VideoMerger", 2, ((StringBuilder)localObject5).toString());
            }
          }
        }
      }
      ((Bundle)localObject1).putBoolean("PhotoConst.IS_FROM_EDIT", bool2);
      if (SlideShowPhotoListManager.a().d() == 13) {
        ((IQimMusicPlayer)QRoute.api(IQimMusicPlayer.class)).clearMusic();
      }
      paramMergeContext.d.post(new VideoMerger.1(this, paramMergeContext, (CameraCaptureView.VideoCaptureResult)localObject7, (LocalMediaInfo)localObject6, (Bundle)localObject3, (Bundle)localObject1));
      localObject1 = paramMergeContext.a.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext()) {
        if (((SlideItemInfo)((Iterator)localObject1).next()).e == 1) {
          i += 1;
        }
      }
      j = paramMergeContext.a.size();
      bool2 = this.c;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramMergeContext.a.size());
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(j - i);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append("");
      StoryReportor.a("video_edit_slides", "suc_compose", bool2 ^ true, 0, new String[] { "", localObject1, localObject3, ((StringBuilder)localObject4).toString() });
      StoryReportor.a("actAlbumResult", new String[] { "0" });
    }
    else
    {
      paramMergeContext.d.post(new VideoMerger.2(this, paramMergeContext));
    }
    if (paramMergeContext.b != null) {
      paramMergeContext.b.n();
    }
    if (QLog.isColorLevel())
    {
      paramMergeContext = new StringBuilder();
      paramMergeContext.append("combine video result =");
      paramMergeContext.append(bool1);
      QLog.i("VideoMerger", 2, paramMergeContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger
 * JD-Core Version:    0.7.0.1
 */