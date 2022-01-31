package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import awbv;
import awbw;
import awbx;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.SafeBitmapFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import ugx;
import ukp;
import ulk;
import ulm;
import uln;
import ulw;
import ulx;
import uly;
import ulz;
import uma;
import umb;
import umc;
import ume;
import ung;
import uta;
import utb;
import utg;
import vcb;
import vhj;
import wsv;
import wta;
import xmn;
import xmx;
import xpc;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<ulw>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(ulw paramulw)
  {
    super(paramulw);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramulw.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (xmn.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramulw.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
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
      ((awbw)localObject2).b((awbv)localObject1);
      wsv.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (ume.a(2131099649).booleanValue()) {
            a(paramulw);
          }
          localObject1 = paramulw.a().videoUploadTempDir;
          if (localObject1 != null) {
            xmx.a((String)localObject1);
          }
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramulw.a() });
          if (!TextUtils.isEmpty(paramulw.jdField_b_of_type_JavaLangString)) {
            wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(xmx.b(paramulw.jdField_b_of_type_JavaLangString)), paramulw.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramulw.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(xmx.b((String)localObject1)), localObject1 });
          }
          paramulw.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          ukp.a().a(((ulw)this.jdField_a_of_type_Ulu).a());
          if ((TextUtils.isEmpty(paramulw.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramulw.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new ulk(true);
          ((ulk)localObject1).jdField_a_of_type_JavaLangString = paramulw.jdField_e_of_type_JavaLangString;
          ((ulk)localObject1).a(new ulx(this, paramulw));
          paramulw.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramulw.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramulw.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new ulk(true);
          ((ulk)localObject1).jdField_a_of_type_JavaLangString = paramulw.jdField_f_of_type_JavaLangString;
          ((ulk)localObject1).a(new uly(this, paramulw));
          paramulw.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((ulw)this.jdField_a_of_type_Ulu).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new uln(((ulw)this.jdField_a_of_type_Ulu).a(), ((ulw)this.jdField_a_of_type_Ulu).jdField_a_of_type_JavaLangString);
          ((uln)localObject1).a(new ulz(this));
          paramulw.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((ulw)this.jdField_a_of_type_Ulu).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((ulw)this.jdField_a_of_type_Ulu).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new ulk(false);
            ((ulk)localObject1).jdField_a_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).jdField_b_of_type_JavaLangString;
            ((ulk)localObject1).a(new uma(this));
            paramulw.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((ulw)this.jdField_a_of_type_Ulu).jdField_a_of_type_Utg;
          if ((localObject1 != null) && (((utg)localObject1).jdField_a_of_type_Int == 1) && (((utg)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new ulm(((utg)localObject1).jdField_a_of_type_JavaLangString);
            ((utg)localObject1).jdField_b_of_type_Int = 1;
            ((ulm)localObject2).a(new umb(this, (utg)localObject1, (ulm)localObject2));
            paramulw.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          wsv.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          wsv.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          wsv.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!xmx.b(paramString)) {}
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
  
  private void a(ulw paramulw)
  {
    Object localObject4 = paramulw.a();
    Object localObject2;
    if ((paramulw.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        wsv.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = xmn.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = utb.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = xpc.a((utb)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = xmn.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = uta.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = xpc.a((uta)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = xmn.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramulw = vhj.a(paramulw.jdField_g_of_type_JavaLangString, true);
      xmx.a(ugx.jdField_e_of_type_JavaLangString);
      boolean bool = xmn.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramulw);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        wsv.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramulw);
        wta.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        xmx.b(QQStoryContext.a().a(), new File(paramulw));
        return;
      }
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    ukp.a().c(((ulw)this.jdField_a_of_type_Ulu).a());
    if (((ulw)this.jdField_a_of_type_Ulu).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      vcb localvcb = new vcb(bool);
      localvcb.jdField_d_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).jdField_g_of_type_JavaLangString;
      localvcb.jdField_f_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).jdField_h_of_type_JavaLangString;
      localvcb.jdField_j_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).jdField_j_of_type_JavaLangString;
      localvcb.jdField_k_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).jdField_i_of_type_JavaLangString;
      localvcb.jdField_c_of_type_Long = ((ulw)this.jdField_a_of_type_Ulu).jdField_b_of_type_Long;
      localvcb.jdField_g_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).a().videoLabel;
      localvcb.jdField_h_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).a().videoDoodleDescription;
      localvcb.jdField_i_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).a().getStringExtra("all_doodle_text", "");
      localvcb.jdField_e_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).a().mLocalDate;
      localvcb.jdField_b_of_type_Long = ((ulw)this.jdField_a_of_type_Ulu).a().timeZoneOffset;
      localvcb.jdField_d_of_type_Long = ((ulw)this.jdField_a_of_type_Ulu).jdField_d_of_type_Long;
      localvcb.jdField_c_of_type_Int = ((ulw)this.jdField_a_of_type_Ulu).jdField_d_of_type_Int;
      localvcb.jdField_d_of_type_Int = ((ulw)this.jdField_a_of_type_Ulu).jdField_e_of_type_Int;
      localvcb.jdField_e_of_type_Long = ((ulw)this.jdField_a_of_type_Ulu).jdField_c_of_type_Long;
      localvcb.jdField_l_of_type_JavaLangString = ((ulw)this.jdField_a_of_type_Ulu).a().videoLocationDescription;
      localvcb.m = ((ulw)this.jdField_a_of_type_Ulu).a().gpsFilterDescription;
      localvcb.n = ((ulw)this.jdField_a_of_type_Ulu).a().atJsonData;
      localvcb.jdField_g_of_type_Int = ((ulw)this.jdField_a_of_type_Ulu).a().publishFrom;
      localvcb.jdField_f_of_type_Long = ((ulw)this.jdField_a_of_type_Ulu).a().videoCreateTime;
      localvcb.jdField_h_of_type_Int = ((ulw)this.jdField_a_of_type_Ulu).a().videoLatitude;
      localvcb.jdField_i_of_type_Int = ((ulw)this.jdField_a_of_type_Ulu).a().videoLongitude;
      localvcb.o = ((ulw)this.jdField_a_of_type_Ulu).a().localCreateCity;
      if (((ulw)this.jdField_a_of_type_Ulu).a().isPicture) {}
      for (;;)
      {
        localvcb.jdField_e_of_type_Int = i;
        localvcb.jdField_f_of_type_Int = ((ulw)this.jdField_a_of_type_Ulu).a().getIntExtra("video_type", 0);
        localvcb.jdField_a_of_type_ArrayOfByte = ((ulw)this.jdField_a_of_type_Ulu).a().readerConfBytes;
        localvcb.jdField_b_of_type_ArrayOfByte = ((ulw)this.jdField_a_of_type_Ulu).a().spreadGroupBytes;
        localvcb.p = ((ulw)this.jdField_a_of_type_Ulu).a().multiFragmentGroupId;
        localvcb.jdField_b_of_type_Boolean = ((ulw)this.jdField_a_of_type_Ulu).a().getBooleanExtra("ignorePersonalPublish", false);
        localvcb.jdField_j_of_type_Int = ((ulw)this.jdField_a_of_type_Ulu).a().getIntExtra("add_video_source", 0);
        localvcb.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((ulw)this.jdField_a_of_type_Ulu).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localvcb.jdField_c_of_type_ArrayOfByte = ((ulw)this.jdField_a_of_type_Ulu).a().tagInfoBytes;
        localvcb.q = ((ulw)this.jdField_a_of_type_Ulu).a().getStringExtra("pl", null);
        localvcb.r = ((ulw)this.jdField_a_of_type_Ulu).jdField_k_of_type_JavaLangString;
        localvcb.s = ((ulw)this.jdField_a_of_type_Ulu).a().getStringExtra("i_l", null);
        localvcb.t = ((ulw)this.jdField_a_of_type_Ulu).jdField_l_of_type_JavaLangString;
        localvcb.jdField_c_of_type_Boolean = ((ulw)this.jdField_a_of_type_Ulu).a().getBooleanExtra("story_sync_qzone", false);
        localvcb.jdField_a_of_type_Utg = ((ulw)this.jdField_a_of_type_Ulu).jdField_a_of_type_Utg;
        localvcb.u = ((ulw)this.jdField_a_of_type_Ulu).a().getStringExtra("game", null);
        localvcb.v = ((ulw)this.jdField_a_of_type_Ulu).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((ulw)this.jdField_a_of_type_Ulu).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localvcb.w = localJSONObject.optString("vid");
          localvcb.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localvcb.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        ung.a().a(localvcb, new umc(this));
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