package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import awge;
import awgf;
import awgg;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.SafeBitmapFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import ulg;
import uoy;
import upt;
import upv;
import upw;
import uqf;
import uqg;
import uqh;
import uqi;
import uqj;
import uqk;
import uql;
import uqn;
import urp;
import uxj;
import uxk;
import uxp;
import vgk;
import vls;
import wxe;
import wxj;
import xqw;
import xrg;
import xtl;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<uqf>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(uqf paramuqf)
  {
    super(paramuqf);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramuqf.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (xqw.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramuqf.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
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
      ((awgf)localObject2).b((awge)localObject1);
      wxe.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (uqn.a(2131099649).booleanValue()) {
            a(paramuqf);
          }
          localObject1 = paramuqf.a().videoUploadTempDir;
          if (localObject1 != null) {
            xrg.a((String)localObject1);
          }
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramuqf.a() });
          if (!TextUtils.isEmpty(paramuqf.jdField_b_of_type_JavaLangString)) {
            wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(xrg.b(paramuqf.jdField_b_of_type_JavaLangString)), paramuqf.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramuqf.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(xrg.b((String)localObject1)), localObject1 });
          }
          paramuqf.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          uoy.a().a(((uqf)this.jdField_a_of_type_Uqd).a());
          if ((TextUtils.isEmpty(paramuqf.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramuqf.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new upt(true);
          ((upt)localObject1).jdField_a_of_type_JavaLangString = paramuqf.jdField_e_of_type_JavaLangString;
          ((upt)localObject1).a(new uqg(this, paramuqf));
          paramuqf.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramuqf.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramuqf.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new upt(true);
          ((upt)localObject1).jdField_a_of_type_JavaLangString = paramuqf.jdField_f_of_type_JavaLangString;
          ((upt)localObject1).a(new uqh(this, paramuqf));
          paramuqf.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((uqf)this.jdField_a_of_type_Uqd).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new upw(((uqf)this.jdField_a_of_type_Uqd).a(), ((uqf)this.jdField_a_of_type_Uqd).jdField_a_of_type_JavaLangString);
          ((upw)localObject1).a(new uqi(this));
          paramuqf.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((uqf)this.jdField_a_of_type_Uqd).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((uqf)this.jdField_a_of_type_Uqd).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new upt(false);
            ((upt)localObject1).jdField_a_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).jdField_b_of_type_JavaLangString;
            ((upt)localObject1).a(new uqj(this));
            paramuqf.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((uqf)this.jdField_a_of_type_Uqd).jdField_a_of_type_Uxp;
          if ((localObject1 != null) && (((uxp)localObject1).jdField_a_of_type_Int == 1) && (((uxp)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new upv(((uxp)localObject1).jdField_a_of_type_JavaLangString);
            ((uxp)localObject1).jdField_b_of_type_Int = 1;
            ((upv)localObject2).a(new uqk(this, (uxp)localObject1, (upv)localObject2));
            paramuqf.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          wxe.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          wxe.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          wxe.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!xrg.b(paramString)) {}
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
  
  private void a(uqf paramuqf)
  {
    Object localObject4 = paramuqf.a();
    Object localObject2;
    if ((paramuqf.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        wxe.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = xqw.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = uxk.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = xtl.a((uxk)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = xqw.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = uxj.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = xtl.a((uxj)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = xqw.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramuqf = vls.a(paramuqf.jdField_g_of_type_JavaLangString, true);
      xrg.a(ulg.jdField_e_of_type_JavaLangString);
      boolean bool = xqw.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramuqf);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        wxe.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramuqf);
        wxj.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        xrg.b(QQStoryContext.a().a(), new File(paramuqf));
        return;
      }
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    uoy.a().c(((uqf)this.jdField_a_of_type_Uqd).a());
    if (((uqf)this.jdField_a_of_type_Uqd).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      vgk localvgk = new vgk(bool);
      localvgk.jdField_d_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).jdField_g_of_type_JavaLangString;
      localvgk.jdField_f_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).jdField_h_of_type_JavaLangString;
      localvgk.jdField_j_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).jdField_j_of_type_JavaLangString;
      localvgk.jdField_k_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).jdField_i_of_type_JavaLangString;
      localvgk.jdField_c_of_type_Long = ((uqf)this.jdField_a_of_type_Uqd).jdField_b_of_type_Long;
      localvgk.jdField_g_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).a().videoLabel;
      localvgk.jdField_h_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).a().videoDoodleDescription;
      localvgk.jdField_i_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).a().getStringExtra("all_doodle_text", "");
      localvgk.jdField_e_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).a().mLocalDate;
      localvgk.jdField_b_of_type_Long = ((uqf)this.jdField_a_of_type_Uqd).a().timeZoneOffset;
      localvgk.jdField_d_of_type_Long = ((uqf)this.jdField_a_of_type_Uqd).jdField_d_of_type_Long;
      localvgk.jdField_c_of_type_Int = ((uqf)this.jdField_a_of_type_Uqd).jdField_d_of_type_Int;
      localvgk.jdField_d_of_type_Int = ((uqf)this.jdField_a_of_type_Uqd).jdField_e_of_type_Int;
      localvgk.jdField_e_of_type_Long = ((uqf)this.jdField_a_of_type_Uqd).jdField_c_of_type_Long;
      localvgk.jdField_l_of_type_JavaLangString = ((uqf)this.jdField_a_of_type_Uqd).a().videoLocationDescription;
      localvgk.m = ((uqf)this.jdField_a_of_type_Uqd).a().gpsFilterDescription;
      localvgk.n = ((uqf)this.jdField_a_of_type_Uqd).a().atJsonData;
      localvgk.jdField_g_of_type_Int = ((uqf)this.jdField_a_of_type_Uqd).a().publishFrom;
      localvgk.jdField_f_of_type_Long = ((uqf)this.jdField_a_of_type_Uqd).a().videoCreateTime;
      localvgk.jdField_h_of_type_Int = ((uqf)this.jdField_a_of_type_Uqd).a().videoLatitude;
      localvgk.jdField_i_of_type_Int = ((uqf)this.jdField_a_of_type_Uqd).a().videoLongitude;
      localvgk.o = ((uqf)this.jdField_a_of_type_Uqd).a().localCreateCity;
      if (((uqf)this.jdField_a_of_type_Uqd).a().isPicture) {}
      for (;;)
      {
        localvgk.jdField_e_of_type_Int = i;
        localvgk.jdField_f_of_type_Int = ((uqf)this.jdField_a_of_type_Uqd).a().getIntExtra("video_type", 0);
        localvgk.jdField_a_of_type_ArrayOfByte = ((uqf)this.jdField_a_of_type_Uqd).a().readerConfBytes;
        localvgk.jdField_b_of_type_ArrayOfByte = ((uqf)this.jdField_a_of_type_Uqd).a().spreadGroupBytes;
        localvgk.p = ((uqf)this.jdField_a_of_type_Uqd).a().multiFragmentGroupId;
        localvgk.jdField_b_of_type_Boolean = ((uqf)this.jdField_a_of_type_Uqd).a().getBooleanExtra("ignorePersonalPublish", false);
        localvgk.jdField_j_of_type_Int = ((uqf)this.jdField_a_of_type_Uqd).a().getIntExtra("add_video_source", 0);
        localvgk.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((uqf)this.jdField_a_of_type_Uqd).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localvgk.jdField_c_of_type_ArrayOfByte = ((uqf)this.jdField_a_of_type_Uqd).a().tagInfoBytes;
        localvgk.q = ((uqf)this.jdField_a_of_type_Uqd).a().getStringExtra("pl", null);
        localvgk.r = ((uqf)this.jdField_a_of_type_Uqd).jdField_k_of_type_JavaLangString;
        localvgk.s = ((uqf)this.jdField_a_of_type_Uqd).a().getStringExtra("i_l", null);
        localvgk.t = ((uqf)this.jdField_a_of_type_Uqd).jdField_l_of_type_JavaLangString;
        localvgk.jdField_c_of_type_Boolean = ((uqf)this.jdField_a_of_type_Uqd).a().getBooleanExtra("story_sync_qzone", false);
        localvgk.jdField_a_of_type_Uxp = ((uqf)this.jdField_a_of_type_Uqd).jdField_a_of_type_Uxp;
        localvgk.u = ((uqf)this.jdField_a_of_type_Uqd).a().getStringExtra("game", null);
        localvgk.v = ((uqf)this.jdField_a_of_type_Uqd).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((uqf)this.jdField_a_of_type_Uqd).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localvgk.w = localJSONObject.optString("vid");
          localvgk.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localvgk.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        urp.a().a(localvgk, new uql(this));
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