package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import auko;
import aukp;
import aukq;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.SafeBitmapFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import ssf;
import svx;
import sws;
import swu;
import swv;
import sxe;
import sxf;
import sxg;
import sxh;
import sxi;
import sxj;
import sxk;
import sxm;
import syo;
import tei;
import tej;
import teo;
import tnj;
import tsr;
import ved;
import vei;
import vxv;
import vyf;
import wak;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<sxe>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(sxe paramsxe)
  {
    super(paramsxe);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramsxe.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (vxv.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramsxe.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
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
      ((aukp)localObject2).b((auko)localObject1);
      ved.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (sxm.a(2131099649).booleanValue()) {
            a(paramsxe);
          }
          localObject1 = paramsxe.a().videoUploadTempDir;
          if (localObject1 != null) {
            vyf.a((String)localObject1);
          }
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramsxe.a() });
          if (!TextUtils.isEmpty(paramsxe.jdField_b_of_type_JavaLangString)) {
            ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(vyf.b(paramsxe.jdField_b_of_type_JavaLangString)), paramsxe.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramsxe.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(vyf.b((String)localObject1)), localObject1 });
          }
          paramsxe.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          svx.a().a(((sxe)this.jdField_a_of_type_Sxc).a());
          if ((TextUtils.isEmpty(paramsxe.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramsxe.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new sws(true);
          ((sws)localObject1).jdField_a_of_type_JavaLangString = paramsxe.jdField_e_of_type_JavaLangString;
          ((sws)localObject1).a(new sxf(this, paramsxe));
          paramsxe.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramsxe.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramsxe.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new sws(true);
          ((sws)localObject1).jdField_a_of_type_JavaLangString = paramsxe.jdField_f_of_type_JavaLangString;
          ((sws)localObject1).a(new sxg(this, paramsxe));
          paramsxe.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((sxe)this.jdField_a_of_type_Sxc).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new swv(((sxe)this.jdField_a_of_type_Sxc).a(), ((sxe)this.jdField_a_of_type_Sxc).jdField_a_of_type_JavaLangString);
          ((swv)localObject1).a(new sxh(this));
          paramsxe.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((sxe)this.jdField_a_of_type_Sxc).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((sxe)this.jdField_a_of_type_Sxc).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new sws(false);
            ((sws)localObject1).jdField_a_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).jdField_b_of_type_JavaLangString;
            ((sws)localObject1).a(new sxi(this));
            paramsxe.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((sxe)this.jdField_a_of_type_Sxc).jdField_a_of_type_Teo;
          if ((localObject1 != null) && (((teo)localObject1).jdField_a_of_type_Int == 1) && (((teo)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new swu(((teo)localObject1).jdField_a_of_type_JavaLangString);
            ((teo)localObject1).jdField_b_of_type_Int = 1;
            ((swu)localObject2).a(new sxj(this, (teo)localObject1, (swu)localObject2));
            paramsxe.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          ved.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          ved.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          ved.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!vyf.b(paramString)) {}
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
  
  private void a(sxe paramsxe)
  {
    Object localObject4 = paramsxe.a();
    Object localObject2;
    if ((paramsxe.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        ved.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = vxv.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = tej.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = wak.a((tej)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = vxv.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = tei.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = wak.a((tei)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = vxv.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramsxe = tsr.a(paramsxe.jdField_g_of_type_JavaLangString, true);
      vyf.a(ssf.jdField_e_of_type_JavaLangString);
      boolean bool = vxv.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramsxe);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        ved.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramsxe);
        vei.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        vyf.b(QQStoryContext.a().a(), new File(paramsxe));
        return;
      }
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    svx.a().c(((sxe)this.jdField_a_of_type_Sxc).a());
    if (((sxe)this.jdField_a_of_type_Sxc).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      tnj localtnj = new tnj(bool);
      localtnj.jdField_d_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).jdField_g_of_type_JavaLangString;
      localtnj.jdField_f_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).jdField_h_of_type_JavaLangString;
      localtnj.jdField_j_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).jdField_j_of_type_JavaLangString;
      localtnj.jdField_k_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).jdField_i_of_type_JavaLangString;
      localtnj.jdField_c_of_type_Long = ((sxe)this.jdField_a_of_type_Sxc).jdField_b_of_type_Long;
      localtnj.jdField_g_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).a().videoLabel;
      localtnj.jdField_h_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).a().videoDoodleDescription;
      localtnj.jdField_i_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).a().getStringExtra("all_doodle_text", "");
      localtnj.jdField_e_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).a().mLocalDate;
      localtnj.jdField_b_of_type_Long = ((sxe)this.jdField_a_of_type_Sxc).a().timeZoneOffset;
      localtnj.jdField_d_of_type_Long = ((sxe)this.jdField_a_of_type_Sxc).jdField_d_of_type_Long;
      localtnj.jdField_c_of_type_Int = ((sxe)this.jdField_a_of_type_Sxc).jdField_d_of_type_Int;
      localtnj.jdField_d_of_type_Int = ((sxe)this.jdField_a_of_type_Sxc).jdField_e_of_type_Int;
      localtnj.jdField_e_of_type_Long = ((sxe)this.jdField_a_of_type_Sxc).jdField_c_of_type_Long;
      localtnj.jdField_l_of_type_JavaLangString = ((sxe)this.jdField_a_of_type_Sxc).a().videoLocationDescription;
      localtnj.m = ((sxe)this.jdField_a_of_type_Sxc).a().gpsFilterDescription;
      localtnj.n = ((sxe)this.jdField_a_of_type_Sxc).a().atJsonData;
      localtnj.jdField_g_of_type_Int = ((sxe)this.jdField_a_of_type_Sxc).a().publishFrom;
      localtnj.jdField_f_of_type_Long = ((sxe)this.jdField_a_of_type_Sxc).a().videoCreateTime;
      localtnj.jdField_h_of_type_Int = ((sxe)this.jdField_a_of_type_Sxc).a().videoLatitude;
      localtnj.jdField_i_of_type_Int = ((sxe)this.jdField_a_of_type_Sxc).a().videoLongitude;
      localtnj.o = ((sxe)this.jdField_a_of_type_Sxc).a().localCreateCity;
      if (((sxe)this.jdField_a_of_type_Sxc).a().isPicture) {}
      for (;;)
      {
        localtnj.jdField_e_of_type_Int = i;
        localtnj.jdField_f_of_type_Int = ((sxe)this.jdField_a_of_type_Sxc).a().getIntExtra("video_type", 0);
        localtnj.jdField_a_of_type_ArrayOfByte = ((sxe)this.jdField_a_of_type_Sxc).a().readerConfBytes;
        localtnj.jdField_b_of_type_ArrayOfByte = ((sxe)this.jdField_a_of_type_Sxc).a().spreadGroupBytes;
        localtnj.p = ((sxe)this.jdField_a_of_type_Sxc).a().multiFragmentGroupId;
        localtnj.jdField_b_of_type_Boolean = ((sxe)this.jdField_a_of_type_Sxc).a().getBooleanExtra("ignorePersonalPublish", false);
        localtnj.jdField_j_of_type_Int = ((sxe)this.jdField_a_of_type_Sxc).a().getIntExtra("add_video_source", 0);
        localtnj.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((sxe)this.jdField_a_of_type_Sxc).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localtnj.jdField_c_of_type_ArrayOfByte = ((sxe)this.jdField_a_of_type_Sxc).a().tagInfoBytes;
        localtnj.q = ((sxe)this.jdField_a_of_type_Sxc).a().getStringExtra("pl", null);
        localtnj.r = ((sxe)this.jdField_a_of_type_Sxc).jdField_k_of_type_JavaLangString;
        localtnj.s = ((sxe)this.jdField_a_of_type_Sxc).a().getStringExtra("i_l", null);
        localtnj.t = ((sxe)this.jdField_a_of_type_Sxc).jdField_l_of_type_JavaLangString;
        localtnj.jdField_c_of_type_Boolean = ((sxe)this.jdField_a_of_type_Sxc).a().getBooleanExtra("story_sync_qzone", false);
        localtnj.jdField_a_of_type_Teo = ((sxe)this.jdField_a_of_type_Sxc).jdField_a_of_type_Teo;
        localtnj.u = ((sxe)this.jdField_a_of_type_Sxc).a().getStringExtra("game", null);
        localtnj.v = ((sxe)this.jdField_a_of_type_Sxc).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((sxe)this.jdField_a_of_type_Sxc).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localtnj.w = localJSONObject.optString("vid");
          localtnj.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localtnj.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        syo.a().a(localtnj, new sxk(this));
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