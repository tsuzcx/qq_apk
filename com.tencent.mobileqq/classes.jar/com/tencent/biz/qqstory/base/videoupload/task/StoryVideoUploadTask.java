package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import aukm;
import aukn;
import auko;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.SafeBitmapFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import ssi;
import swa;
import swv;
import swx;
import swy;
import sxh;
import sxi;
import sxj;
import sxk;
import sxl;
import sxm;
import sxn;
import sxp;
import syr;
import tel;
import tem;
import ter;
import tnm;
import tsu;
import veg;
import vel;
import vxy;
import vyi;
import wan;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<sxh>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(sxh paramsxh)
  {
    super(paramsxh);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramsxh.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (vxy.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramsxh.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
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
      ((aukn)localObject2).b((aukm)localObject1);
      veg.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (sxp.a(2131099649).booleanValue()) {
            a(paramsxh);
          }
          localObject1 = paramsxh.a().videoUploadTempDir;
          if (localObject1 != null) {
            vyi.a((String)localObject1);
          }
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramsxh.a() });
          if (!TextUtils.isEmpty(paramsxh.jdField_b_of_type_JavaLangString)) {
            veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(vyi.b(paramsxh.jdField_b_of_type_JavaLangString)), paramsxh.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramsxh.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(vyi.b((String)localObject1)), localObject1 });
          }
          paramsxh.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          swa.a().a(((sxh)this.jdField_a_of_type_Sxf).a());
          if ((TextUtils.isEmpty(paramsxh.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramsxh.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new swv(true);
          ((swv)localObject1).jdField_a_of_type_JavaLangString = paramsxh.jdField_e_of_type_JavaLangString;
          ((swv)localObject1).a(new sxi(this, paramsxh));
          paramsxh.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramsxh.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramsxh.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new swv(true);
          ((swv)localObject1).jdField_a_of_type_JavaLangString = paramsxh.jdField_f_of_type_JavaLangString;
          ((swv)localObject1).a(new sxj(this, paramsxh));
          paramsxh.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((sxh)this.jdField_a_of_type_Sxf).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new swy(((sxh)this.jdField_a_of_type_Sxf).a(), ((sxh)this.jdField_a_of_type_Sxf).jdField_a_of_type_JavaLangString);
          ((swy)localObject1).a(new sxk(this));
          paramsxh.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((sxh)this.jdField_a_of_type_Sxf).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((sxh)this.jdField_a_of_type_Sxf).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new swv(false);
            ((swv)localObject1).jdField_a_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).jdField_b_of_type_JavaLangString;
            ((swv)localObject1).a(new sxl(this));
            paramsxh.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((sxh)this.jdField_a_of_type_Sxf).jdField_a_of_type_Ter;
          if ((localObject1 != null) && (((ter)localObject1).jdField_a_of_type_Int == 1) && (((ter)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new swx(((ter)localObject1).jdField_a_of_type_JavaLangString);
            ((ter)localObject1).jdField_b_of_type_Int = 1;
            ((swx)localObject2).a(new sxm(this, (ter)localObject1, (swx)localObject2));
            paramsxh.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          veg.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          veg.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          veg.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!vyi.b(paramString)) {}
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
  
  private void a(sxh paramsxh)
  {
    Object localObject4 = paramsxh.a();
    Object localObject2;
    if ((paramsxh.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        veg.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = vxy.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = tem.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = wan.a((tem)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = vxy.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = tel.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = wan.a((tel)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = vxy.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramsxh = tsu.a(paramsxh.jdField_g_of_type_JavaLangString, true);
      vyi.a(ssi.jdField_e_of_type_JavaLangString);
      boolean bool = vxy.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramsxh);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        veg.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramsxh);
        vel.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        vyi.b(QQStoryContext.a().a(), new File(paramsxh));
        return;
      }
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    swa.a().c(((sxh)this.jdField_a_of_type_Sxf).a());
    if (((sxh)this.jdField_a_of_type_Sxf).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      tnm localtnm = new tnm(bool);
      localtnm.jdField_d_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).jdField_g_of_type_JavaLangString;
      localtnm.jdField_f_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).jdField_h_of_type_JavaLangString;
      localtnm.jdField_j_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).jdField_j_of_type_JavaLangString;
      localtnm.jdField_k_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).jdField_i_of_type_JavaLangString;
      localtnm.jdField_c_of_type_Long = ((sxh)this.jdField_a_of_type_Sxf).jdField_b_of_type_Long;
      localtnm.jdField_g_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).a().videoLabel;
      localtnm.jdField_h_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).a().videoDoodleDescription;
      localtnm.jdField_i_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).a().getStringExtra("all_doodle_text", "");
      localtnm.jdField_e_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).a().mLocalDate;
      localtnm.jdField_b_of_type_Long = ((sxh)this.jdField_a_of_type_Sxf).a().timeZoneOffset;
      localtnm.jdField_d_of_type_Long = ((sxh)this.jdField_a_of_type_Sxf).jdField_d_of_type_Long;
      localtnm.jdField_c_of_type_Int = ((sxh)this.jdField_a_of_type_Sxf).jdField_d_of_type_Int;
      localtnm.jdField_d_of_type_Int = ((sxh)this.jdField_a_of_type_Sxf).jdField_e_of_type_Int;
      localtnm.jdField_e_of_type_Long = ((sxh)this.jdField_a_of_type_Sxf).jdField_c_of_type_Long;
      localtnm.jdField_l_of_type_JavaLangString = ((sxh)this.jdField_a_of_type_Sxf).a().videoLocationDescription;
      localtnm.m = ((sxh)this.jdField_a_of_type_Sxf).a().gpsFilterDescription;
      localtnm.n = ((sxh)this.jdField_a_of_type_Sxf).a().atJsonData;
      localtnm.jdField_g_of_type_Int = ((sxh)this.jdField_a_of_type_Sxf).a().publishFrom;
      localtnm.jdField_f_of_type_Long = ((sxh)this.jdField_a_of_type_Sxf).a().videoCreateTime;
      localtnm.jdField_h_of_type_Int = ((sxh)this.jdField_a_of_type_Sxf).a().videoLatitude;
      localtnm.jdField_i_of_type_Int = ((sxh)this.jdField_a_of_type_Sxf).a().videoLongitude;
      localtnm.o = ((sxh)this.jdField_a_of_type_Sxf).a().localCreateCity;
      if (((sxh)this.jdField_a_of_type_Sxf).a().isPicture) {}
      for (;;)
      {
        localtnm.jdField_e_of_type_Int = i;
        localtnm.jdField_f_of_type_Int = ((sxh)this.jdField_a_of_type_Sxf).a().getIntExtra("video_type", 0);
        localtnm.jdField_a_of_type_ArrayOfByte = ((sxh)this.jdField_a_of_type_Sxf).a().readerConfBytes;
        localtnm.jdField_b_of_type_ArrayOfByte = ((sxh)this.jdField_a_of_type_Sxf).a().spreadGroupBytes;
        localtnm.p = ((sxh)this.jdField_a_of_type_Sxf).a().multiFragmentGroupId;
        localtnm.jdField_b_of_type_Boolean = ((sxh)this.jdField_a_of_type_Sxf).a().getBooleanExtra("ignorePersonalPublish", false);
        localtnm.jdField_j_of_type_Int = ((sxh)this.jdField_a_of_type_Sxf).a().getIntExtra("add_video_source", 0);
        localtnm.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((sxh)this.jdField_a_of_type_Sxf).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localtnm.jdField_c_of_type_ArrayOfByte = ((sxh)this.jdField_a_of_type_Sxf).a().tagInfoBytes;
        localtnm.q = ((sxh)this.jdField_a_of_type_Sxf).a().getStringExtra("pl", null);
        localtnm.r = ((sxh)this.jdField_a_of_type_Sxf).jdField_k_of_type_JavaLangString;
        localtnm.s = ((sxh)this.jdField_a_of_type_Sxf).a().getStringExtra("i_l", null);
        localtnm.t = ((sxh)this.jdField_a_of_type_Sxf).jdField_l_of_type_JavaLangString;
        localtnm.jdField_c_of_type_Boolean = ((sxh)this.jdField_a_of_type_Sxf).a().getBooleanExtra("story_sync_qzone", false);
        localtnm.jdField_a_of_type_Ter = ((sxh)this.jdField_a_of_type_Sxf).jdField_a_of_type_Ter;
        localtnm.u = ((sxh)this.jdField_a_of_type_Sxf).a().getStringExtra("game", null);
        localtnm.v = ((sxh)this.jdField_a_of_type_Sxf).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((sxh)this.jdField_a_of_type_Sxf).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localtnm.w = localJSONObject.optString("vid");
          localtnm.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localtnm.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        syr.a().a(localtnm, new sxn(this));
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */