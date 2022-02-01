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
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import win;
import wmf;
import wna;
import wnc;
import wnd;
import wnm;
import wnn;
import wno;
import wnp;
import wnq;
import wnr;
import wns;
import wnu;
import wow;
import wuq;
import wur;
import wuw;
import xdr;
import xiz;
import yuk;
import yup;
import zoc;
import zom;
import zqr;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<wnm>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(wnm paramwnm)
  {
    super(paramwnm);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramwnm.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (zoc.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramwnm.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
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
      yuk.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (wnu.a(2131099649).booleanValue()) {
            a(paramwnm);
          }
          localObject1 = paramwnm.a().videoUploadTempDir;
          if (localObject1 != null) {
            zom.a((String)localObject1);
          }
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramwnm.a() });
          if (!TextUtils.isEmpty(paramwnm.jdField_b_of_type_JavaLangString)) {
            yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(zom.b(paramwnm.jdField_b_of_type_JavaLangString)), paramwnm.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramwnm.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(zom.b((String)localObject1)), localObject1 });
          }
          paramwnm.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          wmf.a().a(((wnm)this.jdField_a_of_type_Wnk).a());
          if ((TextUtils.isEmpty(paramwnm.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramwnm.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new wna(true);
          ((wna)localObject1).jdField_a_of_type_JavaLangString = paramwnm.jdField_e_of_type_JavaLangString;
          ((wna)localObject1).a(new wnn(this, paramwnm));
          paramwnm.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramwnm.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramwnm.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new wna(true);
          ((wna)localObject1).jdField_a_of_type_JavaLangString = paramwnm.jdField_f_of_type_JavaLangString;
          ((wna)localObject1).a(new wno(this, paramwnm));
          paramwnm.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((wnm)this.jdField_a_of_type_Wnk).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new wnd(((wnm)this.jdField_a_of_type_Wnk).a(), ((wnm)this.jdField_a_of_type_Wnk).jdField_a_of_type_JavaLangString);
          ((wnd)localObject1).a(new wnp(this));
          paramwnm.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((wnm)this.jdField_a_of_type_Wnk).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((wnm)this.jdField_a_of_type_Wnk).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new wna(false);
            ((wna)localObject1).jdField_a_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).jdField_b_of_type_JavaLangString;
            ((wna)localObject1).a(new wnq(this));
            paramwnm.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((wnm)this.jdField_a_of_type_Wnk).jdField_a_of_type_Wuw;
          if ((localObject1 != null) && (((wuw)localObject1).jdField_a_of_type_Int == 1) && (((wuw)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new wnc(((wuw)localObject1).jdField_a_of_type_JavaLangString);
            ((wuw)localObject1).jdField_b_of_type_Int = 1;
            ((wnc)localObject2).a(new wnr(this, (wuw)localObject1, (wnc)localObject2));
            paramwnm.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          yuk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          yuk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          yuk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!zom.b(paramString)) {}
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
  
  private void a(wnm paramwnm)
  {
    Object localObject4 = paramwnm.a();
    Object localObject2;
    if ((paramwnm.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        yuk.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = zoc.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = wur.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = zqr.a((wur)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = zoc.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = wuq.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = zqr.a((wuq)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = zoc.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramwnm = xiz.a(paramwnm.jdField_g_of_type_JavaLangString, true);
      zom.a(win.jdField_e_of_type_JavaLangString);
      boolean bool = zoc.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramwnm);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        yuk.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramwnm);
        yup.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        zom.b(QQStoryContext.a().a(), new File(paramwnm));
        return;
      }
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    wmf.a().c(((wnm)this.jdField_a_of_type_Wnk).a());
    if (((wnm)this.jdField_a_of_type_Wnk).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      xdr localxdr = new xdr(bool);
      localxdr.jdField_d_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).jdField_g_of_type_JavaLangString;
      localxdr.jdField_f_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).jdField_h_of_type_JavaLangString;
      localxdr.jdField_j_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).jdField_j_of_type_JavaLangString;
      localxdr.jdField_k_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).jdField_i_of_type_JavaLangString;
      localxdr.jdField_c_of_type_Long = ((wnm)this.jdField_a_of_type_Wnk).jdField_b_of_type_Long;
      localxdr.jdField_g_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).a().videoLabel;
      localxdr.jdField_h_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).a().videoDoodleDescription;
      localxdr.jdField_i_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).a().getStringExtra("all_doodle_text", "");
      localxdr.jdField_e_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).a().mLocalDate;
      localxdr.jdField_b_of_type_Long = ((wnm)this.jdField_a_of_type_Wnk).a().timeZoneOffset;
      localxdr.jdField_d_of_type_Long = ((wnm)this.jdField_a_of_type_Wnk).jdField_d_of_type_Long;
      localxdr.jdField_c_of_type_Int = ((wnm)this.jdField_a_of_type_Wnk).jdField_d_of_type_Int;
      localxdr.jdField_d_of_type_Int = ((wnm)this.jdField_a_of_type_Wnk).jdField_e_of_type_Int;
      localxdr.jdField_e_of_type_Long = ((wnm)this.jdField_a_of_type_Wnk).jdField_c_of_type_Long;
      localxdr.jdField_l_of_type_JavaLangString = ((wnm)this.jdField_a_of_type_Wnk).a().videoLocationDescription;
      localxdr.m = ((wnm)this.jdField_a_of_type_Wnk).a().gpsFilterDescription;
      localxdr.n = ((wnm)this.jdField_a_of_type_Wnk).a().atJsonData;
      localxdr.jdField_g_of_type_Int = ((wnm)this.jdField_a_of_type_Wnk).a().publishFrom;
      localxdr.jdField_f_of_type_Long = ((wnm)this.jdField_a_of_type_Wnk).a().videoCreateTime;
      localxdr.jdField_h_of_type_Int = ((wnm)this.jdField_a_of_type_Wnk).a().videoLatitude;
      localxdr.jdField_i_of_type_Int = ((wnm)this.jdField_a_of_type_Wnk).a().videoLongitude;
      localxdr.o = ((wnm)this.jdField_a_of_type_Wnk).a().localCreateCity;
      if (((wnm)this.jdField_a_of_type_Wnk).a().isPicture) {}
      for (;;)
      {
        localxdr.jdField_e_of_type_Int = i;
        localxdr.jdField_f_of_type_Int = ((wnm)this.jdField_a_of_type_Wnk).a().getIntExtra("video_type", 0);
        localxdr.jdField_a_of_type_ArrayOfByte = ((wnm)this.jdField_a_of_type_Wnk).a().readerConfBytes;
        localxdr.jdField_b_of_type_ArrayOfByte = ((wnm)this.jdField_a_of_type_Wnk).a().spreadGroupBytes;
        localxdr.p = ((wnm)this.jdField_a_of_type_Wnk).a().multiFragmentGroupId;
        localxdr.jdField_b_of_type_Boolean = ((wnm)this.jdField_a_of_type_Wnk).a().getBooleanExtra("ignorePersonalPublish", false);
        localxdr.jdField_j_of_type_Int = ((wnm)this.jdField_a_of_type_Wnk).a().getIntExtra("add_video_source", 0);
        localxdr.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((wnm)this.jdField_a_of_type_Wnk).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localxdr.jdField_c_of_type_ArrayOfByte = ((wnm)this.jdField_a_of_type_Wnk).a().tagInfoBytes;
        localxdr.q = ((wnm)this.jdField_a_of_type_Wnk).a().getStringExtra("pl", null);
        localxdr.r = ((wnm)this.jdField_a_of_type_Wnk).jdField_k_of_type_JavaLangString;
        localxdr.s = ((wnm)this.jdField_a_of_type_Wnk).a().getStringExtra("i_l", null);
        localxdr.t = ((wnm)this.jdField_a_of_type_Wnk).jdField_l_of_type_JavaLangString;
        localxdr.jdField_c_of_type_Boolean = ((wnm)this.jdField_a_of_type_Wnk).a().getBooleanExtra("story_sync_qzone", false);
        localxdr.jdField_a_of_type_Wuw = ((wnm)this.jdField_a_of_type_Wnk).jdField_a_of_type_Wuw;
        localxdr.u = ((wnm)this.jdField_a_of_type_Wnk).a().getStringExtra("game", null);
        localxdr.v = ((wnm)this.jdField_a_of_type_Wnk).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((wnm)this.jdField_a_of_type_Wnk).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localxdr.w = localJSONObject.optString("vid");
          localxdr.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localxdr.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        wow.a().a(localxdr, new wns(this));
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */