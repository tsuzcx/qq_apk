package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import vkm;
import voe;
import vor;
import vot;
import vou;
import vpd;
import vpe;
import vpf;
import vpg;
import vph;
import vpi;
import vpj;
import vpl;
import vqn;
import vwg;
import vwh;
import vwm;
import wfh;
import wkp;
import xvv;
import xwa;
import yoy;
import ypi;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<vpd>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(vpd paramvpd)
  {
    super(paramvpd);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramvpd.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (yoy.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramvpd.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
        ((PublishVideoEntry)localObject1).getBooleanExtra("is_hw_encode", false);
        bool = ((PublishVideoEntry)localObject1).isLocalPublish;
        if (((PublishVideoEntry)localObject1).businessId == 1) {}
        ((PublishVideoEntry)localObject1).getBooleanExtra("landscape_video", false);
        ((PublishVideoEntry)localObject1).getIntExtra("thumb_rotation", 0);
        ((PublishVideoEntry)localObject1).getBooleanExtra("has_rotate", false);
        if (!bool) {
          break label705;
        }
      }
    }
    for (;;)
    {
      ((PublishVideoEntry)localObject1).doodlePath = ((PublishVideoEntry)localObject1).doodleRawPath;
      Object localObject2 = QQStoryContext.a().a().createEntityManager();
      ((PublishVideoEntry)localObject1).setStatus(1000);
      ((EntityManager)localObject2).persistOrReplace((Entity)localObject1);
      xvv.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (vpl.a(2131099649).booleanValue()) {
            a(paramvpd);
          }
          localObject1 = paramvpd.a().videoUploadTempDir;
          if (localObject1 != null) {
            ypi.a((String)localObject1);
          }
          xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramvpd.a() });
          if (!TextUtils.isEmpty(paramvpd.jdField_b_of_type_JavaLangString)) {
            xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(ypi.b(paramvpd.jdField_b_of_type_JavaLangString)), paramvpd.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramvpd.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(ypi.b((String)localObject1)), localObject1 });
          }
          paramvpd.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          voe.a().a(((vpd)this.jdField_a_of_type_Vpb).a());
          if ((TextUtils.isEmpty(paramvpd.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramvpd.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new vor(true);
          ((vor)localObject1).jdField_a_of_type_JavaLangString = paramvpd.jdField_e_of_type_JavaLangString;
          ((vor)localObject1).a(new vpe(this, paramvpd));
          paramvpd.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramvpd.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramvpd.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new vor(true);
          ((vor)localObject1).jdField_a_of_type_JavaLangString = paramvpd.jdField_f_of_type_JavaLangString;
          ((vor)localObject1).a(new vpf(this, paramvpd));
          paramvpd.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((vpd)this.jdField_a_of_type_Vpb).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new vou(((vpd)this.jdField_a_of_type_Vpb).a(), ((vpd)this.jdField_a_of_type_Vpb).jdField_a_of_type_JavaLangString);
          ((vou)localObject1).a(new vpg(this));
          paramvpd.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((vpd)this.jdField_a_of_type_Vpb).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((vpd)this.jdField_a_of_type_Vpb).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new vor(false);
            ((vor)localObject1).jdField_a_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).jdField_b_of_type_JavaLangString;
            ((vor)localObject1).a(new vph(this));
            paramvpd.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((vpd)this.jdField_a_of_type_Vpb).jdField_a_of_type_Vwm;
          if ((localObject1 != null) && (((vwm)localObject1).jdField_a_of_type_Int == 1) && (((vwm)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new vot(((vwm)localObject1).jdField_a_of_type_JavaLangString);
            ((vwm)localObject1).jdField_b_of_type_Int = 1;
            ((vot)localObject2).a(new vpi(this, (vwm)localObject1, (vot)localObject2));
            paramvpd.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
          return;
          label705:
          break;
          if (!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))
          {
            ((PublishVideoEntry)localObject1).getBooleanExtra("is_hw_encode", false);
            bool = ((PublishVideoEntry)localObject1).isLocalPublish;
            if (((PublishVideoEntry)localObject1).businessId == 1) {}
            ((PublishVideoEntry)localObject1).getBooleanExtra("landscape_video", false);
            ((PublishVideoEntry)localObject1).getIntExtra("thumb_rotation", 0);
            ((PublishVideoEntry)localObject1).getBooleanExtra("has_rotate", false);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          xvv.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          xvv.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          xvv.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!ypi.b(paramString)) {}
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
  
  private void a(vpd paramvpd)
  {
    Object localObject4 = paramvpd.a();
    Object localObject2;
    if ((paramvpd.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        xvv.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = yoy.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = vwh.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = FFmpegUtils.generateVoteBitmap((vwh)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = yoy.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = vwg.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = FFmpegUtils.generateInteractBitmap((vwg)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = yoy.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramvpd = wkp.a(paramvpd.jdField_g_of_type_JavaLangString, true);
      ypi.a(vkm.jdField_e_of_type_JavaLangString);
      boolean bool = yoy.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramvpd);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        xvv.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramvpd);
        xwa.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        ypi.b(QQStoryContext.a().a(), new File(paramvpd));
        return;
      }
      xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    voe.a().c(((vpd)this.jdField_a_of_type_Vpb).a());
    if (((vpd)this.jdField_a_of_type_Vpb).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      wfh localwfh = new wfh(bool);
      localwfh.jdField_d_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).jdField_g_of_type_JavaLangString;
      localwfh.jdField_f_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).jdField_h_of_type_JavaLangString;
      localwfh.jdField_j_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).jdField_j_of_type_JavaLangString;
      localwfh.jdField_k_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).jdField_i_of_type_JavaLangString;
      localwfh.jdField_c_of_type_Long = ((vpd)this.jdField_a_of_type_Vpb).jdField_b_of_type_Long;
      localwfh.jdField_g_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).a().videoLabel;
      localwfh.jdField_h_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).a().videoDoodleDescription;
      localwfh.jdField_i_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).a().getStringExtra("all_doodle_text", "");
      localwfh.jdField_e_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).a().mLocalDate;
      localwfh.jdField_b_of_type_Long = ((vpd)this.jdField_a_of_type_Vpb).a().timeZoneOffset;
      localwfh.jdField_d_of_type_Long = ((vpd)this.jdField_a_of_type_Vpb).jdField_d_of_type_Long;
      localwfh.jdField_c_of_type_Int = ((vpd)this.jdField_a_of_type_Vpb).jdField_d_of_type_Int;
      localwfh.jdField_d_of_type_Int = ((vpd)this.jdField_a_of_type_Vpb).jdField_e_of_type_Int;
      localwfh.jdField_e_of_type_Long = ((vpd)this.jdField_a_of_type_Vpb).jdField_c_of_type_Long;
      localwfh.jdField_l_of_type_JavaLangString = ((vpd)this.jdField_a_of_type_Vpb).a().videoLocationDescription;
      localwfh.m = ((vpd)this.jdField_a_of_type_Vpb).a().gpsFilterDescription;
      localwfh.n = ((vpd)this.jdField_a_of_type_Vpb).a().atJsonData;
      localwfh.jdField_g_of_type_Int = ((vpd)this.jdField_a_of_type_Vpb).a().publishFrom;
      localwfh.jdField_f_of_type_Long = ((vpd)this.jdField_a_of_type_Vpb).a().videoCreateTime;
      localwfh.jdField_h_of_type_Int = ((vpd)this.jdField_a_of_type_Vpb).a().videoLatitude;
      localwfh.jdField_i_of_type_Int = ((vpd)this.jdField_a_of_type_Vpb).a().videoLongitude;
      localwfh.o = ((vpd)this.jdField_a_of_type_Vpb).a().localCreateCity;
      if (((vpd)this.jdField_a_of_type_Vpb).a().isPicture) {}
      for (;;)
      {
        localwfh.jdField_e_of_type_Int = i;
        localwfh.jdField_f_of_type_Int = ((vpd)this.jdField_a_of_type_Vpb).a().getIntExtra("video_type", 0);
        localwfh.jdField_a_of_type_ArrayOfByte = ((vpd)this.jdField_a_of_type_Vpb).a().readerConfBytes;
        localwfh.jdField_b_of_type_ArrayOfByte = ((vpd)this.jdField_a_of_type_Vpb).a().spreadGroupBytes;
        localwfh.p = ((vpd)this.jdField_a_of_type_Vpb).a().multiFragmentGroupId;
        localwfh.jdField_b_of_type_Boolean = ((vpd)this.jdField_a_of_type_Vpb).a().getBooleanExtra("ignorePersonalPublish", false);
        localwfh.jdField_j_of_type_Int = ((vpd)this.jdField_a_of_type_Vpb).a().getIntExtra("add_video_source", 0);
        localwfh.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((vpd)this.jdField_a_of_type_Vpb).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localwfh.jdField_c_of_type_ArrayOfByte = ((vpd)this.jdField_a_of_type_Vpb).a().tagInfoBytes;
        localwfh.q = ((vpd)this.jdField_a_of_type_Vpb).a().getStringExtra("pl", null);
        localwfh.r = ((vpd)this.jdField_a_of_type_Vpb).jdField_k_of_type_JavaLangString;
        localwfh.s = ((vpd)this.jdField_a_of_type_Vpb).a().getStringExtra("i_l", null);
        localwfh.t = ((vpd)this.jdField_a_of_type_Vpb).jdField_l_of_type_JavaLangString;
        localwfh.jdField_c_of_type_Boolean = ((vpd)this.jdField_a_of_type_Vpb).a().getBooleanExtra("story_sync_qzone", false);
        localwfh.jdField_a_of_type_Vwm = ((vpd)this.jdField_a_of_type_Vpb).jdField_a_of_type_Vwm;
        localwfh.u = ((vpd)this.jdField_a_of_type_Vpb).a().getStringExtra("game", null);
        localwfh.v = ((vpd)this.jdField_a_of_type_Vpb).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((vpd)this.jdField_a_of_type_Vpb).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localwfh.w = localJSONObject.optString("vid");
          localwfh.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localwfh.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        vqn.a().a(localwfh, new vpj(this));
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */