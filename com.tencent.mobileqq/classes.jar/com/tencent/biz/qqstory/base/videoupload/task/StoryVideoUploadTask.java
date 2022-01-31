package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import atmo;
import atmp;
import atmq;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.SafeBitmapFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import sfm;
import sje;
import sjz;
import skb;
import skc;
import skl;
import skm;
import skn;
import sko;
import skp;
import skq;
import skr;
import skt;
import slv;
import srp;
import srq;
import srv;
import taq;
import tfy;
import urk;
import urp;
import vlc;
import vlm;
import vnr;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<skl>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(skl paramskl)
  {
    super(paramskl);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramskl.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (vlc.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramskl.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
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
      ((atmp)localObject2).b((atmo)localObject1);
      urk.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (skt.a(2131034113).booleanValue()) {
            a(paramskl);
          }
          localObject1 = paramskl.a().videoUploadTempDir;
          if (localObject1 != null) {
            vlm.a((String)localObject1);
          }
          urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramskl.a() });
          if (!TextUtils.isEmpty(paramskl.jdField_b_of_type_JavaLangString)) {
            urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(vlm.b(paramskl.jdField_b_of_type_JavaLangString)), paramskl.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramskl.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(vlm.b((String)localObject1)), localObject1 });
          }
          paramskl.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          sje.a().a(((skl)this.jdField_a_of_type_Skj).a());
          if ((TextUtils.isEmpty(paramskl.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramskl.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new sjz(true);
          ((sjz)localObject1).jdField_a_of_type_JavaLangString = paramskl.jdField_e_of_type_JavaLangString;
          ((sjz)localObject1).a(new skm(this, paramskl));
          paramskl.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramskl.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramskl.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new sjz(true);
          ((sjz)localObject1).jdField_a_of_type_JavaLangString = paramskl.jdField_f_of_type_JavaLangString;
          ((sjz)localObject1).a(new skn(this, paramskl));
          paramskl.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((skl)this.jdField_a_of_type_Skj).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new skc(((skl)this.jdField_a_of_type_Skj).a(), ((skl)this.jdField_a_of_type_Skj).jdField_a_of_type_JavaLangString);
          ((skc)localObject1).a(new sko(this));
          paramskl.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((skl)this.jdField_a_of_type_Skj).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((skl)this.jdField_a_of_type_Skj).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new sjz(false);
            ((sjz)localObject1).jdField_a_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).jdField_b_of_type_JavaLangString;
            ((sjz)localObject1).a(new skp(this));
            paramskl.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((skl)this.jdField_a_of_type_Skj).jdField_a_of_type_Srv;
          if ((localObject1 != null) && (((srv)localObject1).jdField_a_of_type_Int == 1) && (((srv)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new skb(((srv)localObject1).jdField_a_of_type_JavaLangString);
            ((srv)localObject1).jdField_b_of_type_Int = 1;
            ((skb)localObject2).a(new skq(this, (srv)localObject1, (skb)localObject2));
            paramskl.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          urk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          urk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          urk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!vlm.b(paramString)) {}
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
  
  private void a(skl paramskl)
  {
    Object localObject4 = paramskl.a();
    Object localObject2;
    if ((paramskl.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        urk.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = vlc.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = srq.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = vnr.a((srq)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = vlc.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = srp.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = vnr.a((srp)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = vlc.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramskl = tfy.a(paramskl.jdField_g_of_type_JavaLangString, true);
      vlm.a(sfm.jdField_e_of_type_JavaLangString);
      boolean bool = vlc.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramskl);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        urk.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramskl);
        urp.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        vlm.b(QQStoryContext.a().a(), new File(paramskl));
        return;
      }
      urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    sje.a().c(((skl)this.jdField_a_of_type_Skj).a());
    if (((skl)this.jdField_a_of_type_Skj).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      taq localtaq = new taq(bool);
      localtaq.jdField_d_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).jdField_g_of_type_JavaLangString;
      localtaq.jdField_f_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).jdField_h_of_type_JavaLangString;
      localtaq.jdField_j_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).jdField_j_of_type_JavaLangString;
      localtaq.jdField_k_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).jdField_i_of_type_JavaLangString;
      localtaq.jdField_c_of_type_Long = ((skl)this.jdField_a_of_type_Skj).jdField_b_of_type_Long;
      localtaq.jdField_g_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).a().videoLabel;
      localtaq.jdField_h_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).a().videoDoodleDescription;
      localtaq.jdField_i_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).a().getStringExtra("all_doodle_text", "");
      localtaq.jdField_e_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).a().mLocalDate;
      localtaq.jdField_b_of_type_Long = ((skl)this.jdField_a_of_type_Skj).a().timeZoneOffset;
      localtaq.jdField_d_of_type_Long = ((skl)this.jdField_a_of_type_Skj).jdField_d_of_type_Long;
      localtaq.jdField_c_of_type_Int = ((skl)this.jdField_a_of_type_Skj).jdField_d_of_type_Int;
      localtaq.jdField_d_of_type_Int = ((skl)this.jdField_a_of_type_Skj).jdField_e_of_type_Int;
      localtaq.jdField_e_of_type_Long = ((skl)this.jdField_a_of_type_Skj).jdField_c_of_type_Long;
      localtaq.jdField_l_of_type_JavaLangString = ((skl)this.jdField_a_of_type_Skj).a().videoLocationDescription;
      localtaq.m = ((skl)this.jdField_a_of_type_Skj).a().gpsFilterDescription;
      localtaq.n = ((skl)this.jdField_a_of_type_Skj).a().atJsonData;
      localtaq.jdField_g_of_type_Int = ((skl)this.jdField_a_of_type_Skj).a().publishFrom;
      localtaq.jdField_f_of_type_Long = ((skl)this.jdField_a_of_type_Skj).a().videoCreateTime;
      localtaq.jdField_h_of_type_Int = ((skl)this.jdField_a_of_type_Skj).a().videoLatitude;
      localtaq.jdField_i_of_type_Int = ((skl)this.jdField_a_of_type_Skj).a().videoLongitude;
      localtaq.o = ((skl)this.jdField_a_of_type_Skj).a().localCreateCity;
      if (((skl)this.jdField_a_of_type_Skj).a().isPicture) {}
      for (;;)
      {
        localtaq.jdField_e_of_type_Int = i;
        localtaq.jdField_f_of_type_Int = ((skl)this.jdField_a_of_type_Skj).a().getIntExtra("video_type", 0);
        localtaq.jdField_a_of_type_ArrayOfByte = ((skl)this.jdField_a_of_type_Skj).a().readerConfBytes;
        localtaq.jdField_b_of_type_ArrayOfByte = ((skl)this.jdField_a_of_type_Skj).a().spreadGroupBytes;
        localtaq.p = ((skl)this.jdField_a_of_type_Skj).a().multiFragmentGroupId;
        localtaq.jdField_b_of_type_Boolean = ((skl)this.jdField_a_of_type_Skj).a().getBooleanExtra("ignorePersonalPublish", false);
        localtaq.jdField_j_of_type_Int = ((skl)this.jdField_a_of_type_Skj).a().getIntExtra("add_video_source", 0);
        localtaq.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((skl)this.jdField_a_of_type_Skj).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localtaq.jdField_c_of_type_ArrayOfByte = ((skl)this.jdField_a_of_type_Skj).a().tagInfoBytes;
        localtaq.q = ((skl)this.jdField_a_of_type_Skj).a().getStringExtra("pl", null);
        localtaq.r = ((skl)this.jdField_a_of_type_Skj).jdField_k_of_type_JavaLangString;
        localtaq.s = ((skl)this.jdField_a_of_type_Skj).a().getStringExtra("i_l", null);
        localtaq.t = ((skl)this.jdField_a_of_type_Skj).jdField_l_of_type_JavaLangString;
        localtaq.jdField_c_of_type_Boolean = ((skl)this.jdField_a_of_type_Skj).a().getBooleanExtra("story_sync_qzone", false);
        localtaq.jdField_a_of_type_Srv = ((skl)this.jdField_a_of_type_Skj).jdField_a_of_type_Srv;
        localtaq.u = ((skl)this.jdField_a_of_type_Skj).a().getStringExtra("game", null);
        localtaq.v = ((skl)this.jdField_a_of_type_Skj).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((skl)this.jdField_a_of_type_Skj).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localtaq.w = localJSONObject.optString("vid");
          localtaq.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localtaq.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        slv.a().a(localtaq, new skr(this));
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