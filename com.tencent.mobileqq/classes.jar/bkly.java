import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.util.TimeZone;

public class bkly
  extends bklt<bkld, bkld>
{
  private final EditVideoParams a;
  
  public bkly(@NonNull EditVideoParams paramEditVideoParams)
  {
    this.a = paramEditVideoParams;
  }
  
  public static long a(int paramInt, long paramLong)
  {
    long l;
    if (paramInt == 1) {
      l = paramLong / 2L;
    }
    do
    {
      return l;
      if (paramInt == 2) {
        return paramLong * 2L;
      }
      if (paramInt == 4) {
        return paramLong * 4L;
      }
      l = paramLong;
    } while (paramInt != 3);
    return ((float)paramLong / 1.5F);
  }
  
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    ved.c("Q.qqstory.publish.edit.PublishVideoSegment", "PublishVideoSegment.");
    PublishVideoEntry localPublishVideoEntry = parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    localPublishVideoEntry.publishFrom = this.a.c();
    localPublishVideoEntry.businessId = this.a.jdField_a_of_type_Int;
    localPublishVideoEntry.fakeVid = StoryVideoItem.makeFakeVid();
    localPublishVideoEntry.mLocalDate = uvx.a();
    localPublishVideoEntry.timeZoneOffset = TimeZone.getDefault().getRawOffset();
    if (localPublishVideoEntry.createTime == 0L) {
      localPublishVideoEntry.createTime = NetConnInfoCenter.getServerTimeMillis();
    }
    ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish date:%s and time:%d,", new Object[] { localPublishVideoEntry.mLocalDate, Long.valueOf(localPublishVideoEntry.createTime) });
    localPublishVideoEntry.publishState = 1;
    localPublishVideoEntry.videoUploadTempDir = parambkld.jdField_b_of_type_JavaLangString;
    localPublishVideoEntry.putExtra("extra_capture_mode", Integer.valueOf(this.a.jdField_b_of_type_Int));
    localPublishVideoEntry.redBagType = this.a.a("video_redbag_get", 0);
    if (localPublishVideoEntry.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "VideoRedbag, publishVideoEntry take redbag flag");
    }
    localPublishVideoEntry.specialVideoType = this.a.a("special_video_type", 0);
    int i;
    label896:
    Object localObject2;
    Object localObject1;
    if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localPublishVideoEntry.hwEncodeRecordVideo = true;
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = false;
      paramJobContext = (EditTakeVideoSource)parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.a();
      localPublishVideoEntry.recordTime = paramJobContext.a.mDuration;
      localPublishVideoEntry.recordFrames = ((int)paramJobContext.a.mDuration * 30);
      localPublishVideoEntry.mAudioFilePath = paramJobContext.jdField_b_of_type_JavaLangString;
      localPublishVideoEntry.mbgmAudioFilePath = paramJobContext.c;
      if (this.a.jdField_b_of_type_Int == 5) {
        localPublishVideoEntry.putExtra("video_type", Integer.valueOf(3));
      }
      if (vzu.b(paramJobContext.a()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = paramJobContext.b();
      }
      for (localPublishVideoEntry.videoHeight = paramJobContext.a();; localPublishVideoEntry.videoHeight = paramJobContext.b())
      {
        localPublishVideoEntry.videoDuration = a(localPublishVideoEntry.saveMode, paramJobContext.a.mDuration);
        if ((localPublishVideoEntry.saveMode != 5) || (vyf.c(localPublishVideoEntry.mIFrameVideoPath))) {
          break;
        }
        super.notifyError(new ErrorMessage(-1, "back mode but iframe file is empty"));
        return;
        localPublishVideoEntry.videoWidth = paramJobContext.a();
      }
      localPublishVideoEntry.videoCreateTime = paramJobContext.a.addedDate;
      i = 1;
      if (i != 0) {
        bkrf.a().a(localPublishVideoEntry);
      }
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : edit source = %s", new Object[] { parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fake vid = %s", new Object[] { localPublishVideoEntry.fakeVid });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : mLocalRawVideoDir = %s", new Object[] { localPublishVideoEntry.mLocalRawVideoDir });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : width = %d, height = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.videoWidth), Integer.valueOf(localPublishVideoEntry.videoHeight) });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : duration = %d, recordTime = %d", new Object[] { Integer.valueOf((int)localPublishVideoEntry.videoDuration), Integer.valueOf((int)localPublishVideoEntry.recordTime) });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : businessId = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.businessId) });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : thumbPath = %s", new Object[] { localPublishVideoEntry.thumbPath });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleImagePath = %s", new Object[] { localPublishVideoEntry.doodlePath });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleRawImagePath = %s", new Object[] { localPublishVideoEntry.doodleRawPath });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : atDoodleImagePath = %s", new Object[] { localPublishVideoEntry.atDoodlePath });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragmentGroupId = %s", new Object[] { localPublishVideoEntry.multiFragmentGroupId });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : isLocalPublish = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.isLocalPublish) });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : hasFragments = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.hasFragments) });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragments = %s", new Object[] { localPublishVideoEntry.fragments });
      ved.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : publishFrom = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.publishFrom) });
      localPublishVideoEntry.putExtra("composite_key_merge_thumb_cost", Long.valueOf(System.currentTimeMillis() - parambkld.jdField_a_of_type_Long));
      if (this.a.a() == 14) {
        localPublishVideoEntry.putExtra("VIDEO_STORY_JUMP_TO_TYPE", Integer.valueOf(this.a.a("VIDEO_STORY_JUMP_TO_TYPE", 0)));
      }
      if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir)) {
        super.notifyError(new ErrorMessage(-1, "mLocalRawVideoDir is empty"));
      }
    }
    else if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localPublishVideoEntry.isPicture = false;
      if (this.a.a("extra_is_slide_show_video", false))
      {
        i = 2;
        localPublishVideoEntry.putExtra("video_type", Integer.valueOf(i));
        localPublishVideoEntry.isLocalPublish = true;
        localObject2 = (EditLocalVideoSource)parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        paramJobContext = ((EditLocalVideoSource)localObject2).a();
        if ((this.a.a() == 1) || (this.a.a() == 11) || (this.a.a() == 12)) {
          break label2231;
        }
        localObject1 = new File(paramJobContext);
        localObject1 = ahvy.c + localPublishVideoEntry.fakeVid + File.separator + ((File)localObject1).getName();
        if (!bbdx.d(paramJobContext, (String)localObject1)) {
          break label2231;
        }
        paramJobContext = (JobContext)localObject1;
      }
    }
    label2089:
    label2219:
    label2228:
    label2231:
    for (;;)
    {
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
      localPublishVideoEntry.recordTime = ((EditLocalVideoSource)localObject2).a.mDuration;
      localPublishVideoEntry.recordFrames = ((int)((EditLocalVideoSource)localObject2).a.mDuration * 30);
      if (vzu.b(((EditLocalVideoSource)localObject2).a()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).b();
      }
      for (localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).a();; localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).b())
      {
        localPublishVideoEntry.videoDuration = a(localPublishVideoEntry.saveMode, ((EditLocalVideoSource)localObject2).a.mDuration);
        localPublishVideoEntry.videoCreateTime = ((EditLocalVideoSource)localObject2).a.addedDate;
        i = 1;
        break;
        i = 0;
        break label896;
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).a();
      }
      if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
      {
        localPublishVideoEntry.isPicture = false;
        localPublishVideoEntry.isLocalPublish = false;
        paramJobContext = (EditRecordVideoSource)parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.a();
        localPublishVideoEntry.recordTime = paramJobContext.jdField_a_of_type_Long;
        localPublishVideoEntry.recordFrames = paramJobContext.jdField_a_of_type_Int;
        localPublishVideoEntry.videoWidth = paramJobContext.a();
        localPublishVideoEntry.videoHeight = paramJobContext.b();
        localPublishVideoEntry.videoDuration = a(localPublishVideoEntry.saveMode, paramJobContext.jdField_a_of_type_Long);
        i = 1;
        break;
      }
      if (((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)))
      {
        localPublishVideoEntry.isPicture = true;
        paramJobContext = parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
        if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
        {
          localObject1 = (EditLocalPhotoSource)parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          localPublishVideoEntry.isLocalPublish = true;
          localPublishVideoEntry.videoCreateTime = ((EditLocalPhotoSource)localObject1).a.addedDate;
        }
        for (;;)
        {
          if (this.a.jdField_b_of_type_Int == 5) {
            localPublishVideoEntry.putExtra("video_type", Integer.valueOf(3));
          }
          if (localPublishVideoEntry.thumbPath == null) {
            break label1479;
          }
          localPublishVideoEntry.mLocalRawVideoDir = localPublishVideoEntry.thumbPath;
          if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
            localPublishVideoEntry.mLocalRawPicPath = parambkld.jdField_a_of_type_Bklj.a;
          }
          localPublishVideoEntry.recordTime = 5000.0D;
          localPublishVideoEntry.recordFrames = 150000;
          paramJobContext = new BitmapFactory.Options();
          paramJobContext.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(localPublishVideoEntry.mLocalRawVideoDir, paramJobContext);
          localPublishVideoEntry.videoWidth = paramJobContext.outWidth;
          localPublishVideoEntry.videoHeight = paramJobContext.outHeight;
          localPublishVideoEntry.videoDuration = 5000L;
          i = 0;
          break;
          localPublishVideoEntry.isLocalPublish = false;
        }
        label1479:
        if ((parambkld.jdField_a_of_type_Bklj.c) || (!parambkld.jdField_a_of_type_Bklj.jdField_b_of_type_Boolean)) {
          break label2228;
        }
        paramJobContext = parambkld.jdField_a_of_type_Bklj.jdField_b_of_type_JavaLangString;
      }
      for (;;)
      {
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
        break;
        super.notifyError(new ErrorMessage(-1, "illegal argument " + parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource));
        return;
        if (localPublishVideoEntry.thumbPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.thumbPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "thumbFile is invalid : " + paramJobContext));
            return;
          }
        }
        if (localPublishVideoEntry.doodlePath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.doodlePath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "doodleFile is invalid : " + paramJobContext));
            return;
          }
        }
        if (localPublishVideoEntry.mosaicPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.mosaicPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "mosaicfile is invalid : " + paramJobContext));
            return;
          }
        }
        if (localPublishVideoEntry.doodleRawPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.doodleRawPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "doodleRawFile is invalid : " + paramJobContext));
            return;
          }
        }
        QQStoryContext.a().a().createEntityManager().b(localPublishVideoEntry);
        ved.c("Q.qqstory.publish.edit.PublishVideoSegment", "after persist or replace.");
        i = 0;
        if (parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0) {
          i = 1;
        }
        if (parambkld.jdField_b_of_type_Boolean) {
          i = 1;
        }
        if (localPublishVideoEntry.isMuteRecordVoice) {
          i = 1;
        }
        if (localPublishVideoEntry.backgroundMusicPath != null) {
          i = 1;
        }
        if (localPublishVideoEntry.doodlePath != null) {
          i = 1;
        }
        if (localPublishVideoEntry.doodleRawPath != null) {
          i = 1;
        }
        if (parambkld.c) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            vej.a("0X80076BD");
          }
          paramJobContext = localPublishVideoEntry.fakeVid;
          localObject1 = localPublishVideoEntry.thumbPath;
          localObject2 = localPublishVideoEntry.doodlePath;
          String str1 = localPublishVideoEntry.videoLabel;
          String str2 = localPublishVideoEntry.videoDoodleDescription;
          String str3 = localPublishVideoEntry.videoAddress;
          int n = localPublishVideoEntry.videoWidth;
          int i1 = localPublishVideoEntry.videoHeight;
          long l = localPublishVideoEntry.videoDuration;
          int i2 = localPublishVideoEntry.videoMaxrate;
          int i3 = localPublishVideoEntry.videoMinrate;
          int i4 = localPublishVideoEntry.saveMode;
          int i5 = localPublishVideoEntry.recordFrames;
          String str4 = localPublishVideoEntry.atDoodlePath;
          String str5 = localPublishVideoEntry.atJsonData;
          int j;
          int k;
          if (localPublishVideoEntry.isPicture)
          {
            j = 1;
            if (!parambkld.d) {
              break label2213;
            }
            k = 1;
            if (!localPublishVideoEntry.hwEncodeRecordVideo) {
              break label2219;
            }
          }
          for (int m = 1;; m = 0)
          {
            parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam = new PublishParam(paramJobContext, (String)localObject1, (String)localObject2, str1, str2, str3, n, i1, l, i2, i3, i, i4, i5, str4, str5, j, k, m, localPublishVideoEntry.mLocalRawVideoDir, localPublishVideoEntry.mAudioFilePath, localPublishVideoEntry.mIFrameVideoPath, localPublishVideoEntry.mosaicPath, parambkld.jdField_b_of_type_Int, localPublishVideoEntry.isLocalPublish, localPublishVideoEntry.videoLocationDescription, localPublishVideoEntry.videoLongitude, localPublishVideoEntry.videoLatitude, localPublishVideoEntry.redBagType, localPublishVideoEntry.specialVideoType);
            super.notifyResult(parambkld);
            return;
            j = 0;
            break;
            k = 0;
            break label2089;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkly
 * JD-Core Version:    0.7.0.1
 */