package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
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
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.EditState;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoMerger
  extends ToVideoConverter
{
  long jdField_a_of_type_Long;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private boolean jdField_a_of_type_Boolean = false;
  
  private CaptureVideoParams a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      if ((paramInt2 == 102) || (paramInt2 != 102)) {}
      return new CaptureVideoParams.CaptureVideoParamsBuilder().a(false).c(true).b(false).d(true).c(2).a();
    }
    return new CaptureVideoParams.CaptureVideoParamsBuilder().a(true).c(true).b(true).d(false).c(2).a();
  }
  
  public void a(VideoMerger.MergeContext paramMergeContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoMerger", 2, "start combine");
    }
    if (paramMergeContext.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Object localObject2 = new QimSegmentMergeUtil();
      Object localObject1 = new ArrayList(paramMergeContext.jdField_a_of_type_JavaUtilList.size());
      Object localObject5 = new ArrayList(paramMergeContext.jdField_a_of_type_JavaUtilList.size());
      Object localObject3 = (TransitionHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.jdField_b_of_type_JavaLangString);
      Object localObject6 = new ArrayList();
      Object localObject4 = paramMergeContext.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject7;
      Object localObject8;
      for (boolean bool1 = false; ((Iterator)localObject4).hasNext(); bool1 = bool2)
      {
        localObject7 = (SlideItemInfo)((Iterator)localObject4).next();
        localObject8 = ((TransitionHandler)localObject3).a(((SlideItemInfo)localObject7).jdField_b_of_type_JavaLangString);
        bool2 = bool1;
        if (localObject8 != null)
        {
          ((List)localObject1).add(((LocalMediaInfo)localObject8).path);
          ((List)localObject6).add(((LocalMediaInfo)localObject8).mAudioPath);
          ((SlideItemInfo)localObject7).jdField_c_of_type_JavaLangString = ((LocalMediaInfo)localObject8).path;
          ((SlideItemInfo)localObject7).d = ((LocalMediaInfo)localObject8).mAudioPath;
          ((SlideItemInfo)localObject7).jdField_a_of_type_Boolean = ((LocalMediaInfo)localObject8).mHasAudioTrack;
          ((SlideItemInfo)localObject7).jdField_c_of_type_Int = ((LocalMediaInfo)localObject8).mSampleRate;
          ((List)localObject5).add(localObject7);
          bool2 = bool1;
          if (((SlideItemInfo)localObject7).jdField_b_of_type_Int == 1)
          {
            if (((SlideItemInfo)localObject7).jdField_a_of_type_Boolean) {
              bool1 = true;
            }
            QLog.i("VideoMerger", 1, "mergeRunnable hasAudioTrack=" + ((SlideItemInfo)localObject7).jdField_a_of_type_Boolean + " mSampleRate:" + ((SlideItemInfo)localObject7).jdField_c_of_type_Int);
            bool2 = bool1;
          }
        }
      }
      if (a(paramMergeContext))
      {
        a(9, "", null, null, null, paramMergeContext);
        return;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {
        if (((TransitionHandler)localObject3).a() != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = ((TransitionHandler)localObject3).a();
          if (QLog.isColorLevel()) {
            QLog.d("VideoMerger", 2, "transHandler.getMediaFormat");
          }
        }
      }
      boolean bool3;
      for (;;)
      {
        if (paramMergeContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger$VideoMergeListener != null) {
          paramMergeContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger$VideoMergeListener.a(bool1);
        }
        localObject4 = SlideShowUtils.a();
        localObject3 = (String)localObject4 + ".dat";
        if (!bool1) {
          break label772;
        }
        bool3 = SegmentClipUtils.clipAudio((List)localObject5);
        QLog.i("VideoMerger", 1, "clip audio success=" + bool3);
        bool2 = bool3;
        if (!bool3) {
          break label629;
        }
        ((List)localObject6).clear();
        localObject7 = ((List)localObject5).iterator();
        while (((Iterator)localObject7).hasNext()) {
          ((List)localObject6).add(((SlideItemInfo)((Iterator)localObject7).next()).d);
        }
        if (((List)localObject1).size() > 0)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = ImageToVideo.a((String)((List)localObject1).get(0));
          if (QLog.isColorLevel()) {
            QLog.d("VideoMerger", 2, "ImageToVideo.getVideoFormatFromVideo, videoPath : " + (String)((List)localObject1).get(0));
          }
        }
        if (this.jdField_a_of_type_AndroidMediaMediaFormat == null)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = ImageToVideo.a();
          if (QLog.isColorLevel())
          {
            QLog.d("VideoMerger", 2, "ImageToVideo.getVideoFormatDefault");
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("VideoMerger", 2, "mVideoFormat not null");
            }
          }
        }
      }
      label772:
      for (boolean bool2 = ((QimSegmentMergeUtil)localObject2).mergeAudioCache((List)localObject6, (String)localObject3);; bool2 = true)
      {
        label629:
        QLog.i("VideoMerger", 1, "merge audio success " + bool2);
        if (!bool2) {
          break;
        }
        bool3 = SegmentClipUtils.clipVideo((List)localObject5);
        QLog.i("VideoMerger", 1, "clip video success=" + bool3);
        ((List)localObject1).clear();
        localObject5 = ((List)localObject5).iterator();
        for (;;)
        {
          bool2 = bool3;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (SlideItemInfo)((Iterator)localObject5).next();
          if (((SlideItemInfo)localObject6).jdField_b_of_type_Int == 0) {
            ((List)localObject1).add(((SlideItemInfo)localObject6).jdField_c_of_type_JavaLangString);
          }
          ((List)localObject1).add(((SlideItemInfo)localObject6).jdField_c_of_type_JavaLangString);
        }
      }
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        QLog.i("VideoMerger", 1, "merge print video begin:  path: " + (String)localObject6);
      }
      long l1;
      long l2;
      if (bool2)
      {
        l1 = System.currentTimeMillis();
        bool2 = ((QimSegmentMergeUtil)localObject2).startMergeVideoWithoutAudioSync((List)localObject1, (String)localObject4, 720, 1280, this.jdField_a_of_type_AndroidMediaMediaFormat);
        l2 = System.currentTimeMillis();
        QLog.i("VideoMerger", 1, "merge video result " + bool2 + " cost: " + (l2 - l1) + " ms");
        label918:
        QLog.i("VideoMerger", 1, "merge video result " + bool2);
        localObject5 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject5).path = ((String)localObject4);
        ((LocalMediaInfo)localObject5).mMimeType = "video";
        if (!AudioHelper.f()) {
          break label1928;
        }
        ((LocalMediaInfo)localObject5).mTransferPosList = ((QimSegmentMergeUtil)localObject2).getMergeVideoPositionsForFFmpegNewClip((List)localObject1, (String)localObject4);
        localObject2 = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      }
      try
      {
        ((MediaScanner)localObject2).buildAndUpdateVideo((LocalMediaInfo)localObject5);
        if (bool2)
        {
          l1 = System.currentTimeMillis();
          l2 = this.jdField_a_of_type_Long;
          StoryReportor.a("actAlbumTime", new String[] { l1 - l2 + "", paramMergeContext.jdField_a_of_type_JavaUtilList.size() + "" });
          localObject6 = new CameraCaptureView.VideoCaptureResult();
          ((CameraCaptureView.VideoCaptureResult)localObject6).videoFrameCount = ((List)localObject1).size();
          if (bool1)
          {
            ((CameraCaptureView.VideoCaptureResult)localObject6).audioDataFilePath = ((String)localObject3);
            ((CameraCaptureView.VideoCaptureResult)localObject6).videoMp4FilePath = ((String)localObject4);
            localObject1 = null;
            localObject2 = paramMergeContext.jdField_a_of_type_AndroidAppActivity.getIntent();
            if (localObject2 != null) {
              localObject1 = EditState.a((Intent)localObject2);
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new Bundle();
            }
            localObject3 = paramMergeContext.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = new Bundle();
            }
            localObject3 = paramMergeContext.jdField_a_of_type_AndroidAppActivity.getIntent();
            i = ((Intent)localObject3).getIntExtra("entrance_type", 99);
            j = ((Intent)localObject3).getIntExtra("shareGroupType", 0);
            localObject7 = ((Intent)localObject3).getStringExtra("shareGroupId");
            localObject8 = ((Intent)localObject3).getStringExtra("shareGroupName");
            bool1 = ((Intent)localObject3).getBooleanExtra("ignorePersonalPublish", false);
            bool3 = ((Intent)localObject3).getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
            ((Bundle)localObject1).putBoolean("ignorePersonalPublish", bool1);
            ((Bundle)localObject1).putInt("shareGroupType", j);
            ((Bundle)localObject1).putString("shareGroupId", (String)localObject7);
            ((Bundle)localObject1).putString("shareGroupName", (String)localObject8);
            localObject7 = a(SlideShowPhotoListManager.a().a(), i);
            j = ((Bundle)localObject1).getInt("qq_sub_business_id", 2);
            localObject3 = new CaptureEntranceParams(((Bundle)localObject1).getInt("edit_video_type", 10002), i, j);
            ((CaptureEntranceParams)localObject3).a((CaptureVideoParams)localObject7);
            ((Bundle)localObject1).putBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", true);
            ((Bundle)localObject1).putString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", (String)localObject4);
            ((Bundle)localObject1).putInt("extra_transiton_src_from", 1);
            ((Bundle)localObject1).putInt("extra_slide_entrance", paramMergeContext.jdField_a_of_type_Int);
            ((Bundle)localObject1).putInt("extra_slide_sticker_id", paramMergeContext.jdField_b_of_type_Int);
            ((Bundle)localObject1).putString("extra_slide_sticker_str", paramMergeContext.jdField_a_of_type_JavaLangString);
            if (paramMergeContext.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              ((Bundle)localObject1).putString("extra_transiton_default", ((SlideItemInfo)paramMergeContext.jdField_a_of_type_JavaUtilList.get(0)).e);
              if (QLog.isColorLevel()) {
                QLog.d("VideoMerger", 2, "doMerge mTransId=" + ((SlideItemInfo)paramMergeContext.jdField_a_of_type_JavaUtilList.get(0)).e);
              }
              if (((SlideItemInfo)paramMergeContext.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum != null)
              {
                ((Bundle)localObject1).putInt("extra_ablum_type", ((SlideItemInfo)paramMergeContext.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_a_of_type_Int);
                if (QLog.isColorLevel()) {
                  QLog.d("VideoMerger", 2, "doMerge mAlbumType=" + ((SlideItemInfo)paramMergeContext.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_a_of_type_Int);
                }
              }
              localObject4 = SlideShowConfigManager.a(paramMergeContext.jdField_a_of_type_AndroidAppActivity).a(((SlideItemInfo)paramMergeContext.jdField_a_of_type_JavaUtilList.get(0)).e);
              if ((localObject4 != null) && (((List)localObject4).size() > 0))
              {
                localObject4 = ((QIMMusicConfigManager)QIMManager.a(2)).a(((SlideShowConfigManager.Music)((List)localObject4).get(0)).jdField_a_of_type_Int, ((SlideShowConfigManager.Music)((List)localObject4).get(0)).jdField_b_of_type_Int);
                if (localObject4 != null)
                {
                  localObject7 = new Bundle();
                  localObject8 = new Bundle();
                  ((Bundle)localObject8).putParcelable("select_music", (Parcelable)localObject4);
                  ((Bundle)localObject8).putString("select_music_local_path", ((MusicItemInfo)localObject4).getLocalPath());
                  ((Bundle)localObject8).putInt("capture_mode", 2);
                  ((Bundle)localObject7).putBundle(MusicProviderView.class.getSimpleName(), (Bundle)localObject8);
                  ((Bundle)localObject2).putBundle("container", (Bundle)localObject7);
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoMerger", 2, "doMerge musicItemInfo=" + ((MusicItemInfo)localObject4).mTagName + " " + ((MusicItemInfo)localObject4).mItemId);
                  }
                }
              }
            }
            ((Bundle)localObject1).putBoolean("PhotoConst.IS_FROM_EDIT", bool3);
            if (SlideShowPhotoListManager.a().a() == 13) {
              ((QimMusicPlayer)QIMManager.a().c(8)).c();
            }
            paramMergeContext.jdField_a_of_type_AndroidOsHandler.post(new VideoMerger.1(this, paramMergeContext, (CameraCaptureView.VideoCaptureResult)localObject6, (LocalMediaInfo)localObject5, (CaptureEntranceParams)localObject3, (Bundle)localObject2, (Bundle)localObject1));
            localObject1 = paramMergeContext.jdField_a_of_type_JavaUtilList.iterator();
            i = 0;
            while (((Iterator)localObject1).hasNext())
            {
              if (((SlideItemInfo)((Iterator)localObject1).next()).jdField_b_of_type_Int != 1) {
                break label2183;
              }
              i += 1;
            }
            bool2 = false;
            break label918;
            label1928:
            ((LocalMediaInfo)localObject5).mTransferPosList = ((QimSegmentMergeUtil)localObject2).getMergeVideoPositionsNewClip((List)localObject1);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        label2183:
        for (;;)
        {
          int i;
          int j;
          localThrowable.printStackTrace();
          QLog.e("VideoMerger", 1, "pic2video err", localThrowable);
          continue;
          ((CameraCaptureView.VideoCaptureResult)localObject6).audioDataFilePath = Image2Video.a();
          continue;
          int k = paramMergeContext.jdField_a_of_type_JavaUtilList.size();
          if (this.jdField_a_of_type_Boolean)
          {
            j = 0;
            label1995:
            StoryReportor.a("video_edit_slides", "suc_compose", j, 0, new String[] { "", paramMergeContext.jdField_a_of_type_JavaUtilList.size() + "", k - i + "", i + "" });
            StoryReportor.a("actAlbumResult", new String[] { "0" });
          }
          for (;;)
          {
            if (paramMergeContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger$VideoMergeListener != null) {
              paramMergeContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger$VideoMergeListener.j();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("VideoMerger", 2, "combine video result =" + bool2);
            return;
            j = 1;
            break label1995;
            paramMergeContext.jdField_a_of_type_AndroidOsHandler.post(new VideoMerger.2(this, paramMergeContext));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger
 * JD-Core Version:    0.7.0.1
 */