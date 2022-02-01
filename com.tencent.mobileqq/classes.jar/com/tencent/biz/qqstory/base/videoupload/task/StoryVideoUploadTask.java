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
import wes;
import wik;
import wjf;
import wjh;
import wji;
import wjr;
import wjs;
import wjt;
import wju;
import wjv;
import wjw;
import wjx;
import wjz;
import wlb;
import wqv;
import wqw;
import wrb;
import wzw;
import xfe;
import yqp;
import yqu;
import zkh;
import zkr;
import zmw;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<wjr>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(wjr paramwjr)
  {
    super(paramwjr);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramwjr.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (zkh.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramwjr.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
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
      yqp.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (wjz.a(2131099649).booleanValue()) {
            a(paramwjr);
          }
          localObject1 = paramwjr.a().videoUploadTempDir;
          if (localObject1 != null) {
            zkr.a((String)localObject1);
          }
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramwjr.a() });
          if (!TextUtils.isEmpty(paramwjr.jdField_b_of_type_JavaLangString)) {
            yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(zkr.b(paramwjr.jdField_b_of_type_JavaLangString)), paramwjr.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramwjr.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(zkr.b((String)localObject1)), localObject1 });
          }
          paramwjr.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          wik.a().a(((wjr)this.jdField_a_of_type_Wjp).a());
          if ((TextUtils.isEmpty(paramwjr.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramwjr.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new wjf(true);
          ((wjf)localObject1).jdField_a_of_type_JavaLangString = paramwjr.jdField_e_of_type_JavaLangString;
          ((wjf)localObject1).a(new wjs(this, paramwjr));
          paramwjr.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramwjr.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramwjr.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new wjf(true);
          ((wjf)localObject1).jdField_a_of_type_JavaLangString = paramwjr.jdField_f_of_type_JavaLangString;
          ((wjf)localObject1).a(new wjt(this, paramwjr));
          paramwjr.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((wjr)this.jdField_a_of_type_Wjp).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new wji(((wjr)this.jdField_a_of_type_Wjp).a(), ((wjr)this.jdField_a_of_type_Wjp).jdField_a_of_type_JavaLangString);
          ((wji)localObject1).a(new wju(this));
          paramwjr.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((wjr)this.jdField_a_of_type_Wjp).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((wjr)this.jdField_a_of_type_Wjp).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new wjf(false);
            ((wjf)localObject1).jdField_a_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).jdField_b_of_type_JavaLangString;
            ((wjf)localObject1).a(new wjv(this));
            paramwjr.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((wjr)this.jdField_a_of_type_Wjp).jdField_a_of_type_Wrb;
          if ((localObject1 != null) && (((wrb)localObject1).jdField_a_of_type_Int == 1) && (((wrb)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new wjh(((wrb)localObject1).jdField_a_of_type_JavaLangString);
            ((wrb)localObject1).jdField_b_of_type_Int = 1;
            ((wjh)localObject2).a(new wjw(this, (wrb)localObject1, (wjh)localObject2));
            paramwjr.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          yqp.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          yqp.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          yqp.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!zkr.b(paramString)) {}
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
  
  private void a(wjr paramwjr)
  {
    Object localObject4 = paramwjr.a();
    Object localObject2;
    if ((paramwjr.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        yqp.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = zkh.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = wqw.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = zmw.a((wqw)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = zkh.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = wqv.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = zmw.a((wqv)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = zkh.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramwjr = xfe.a(paramwjr.jdField_g_of_type_JavaLangString, true);
      zkr.a(wes.jdField_e_of_type_JavaLangString);
      boolean bool = zkh.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramwjr);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        yqp.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramwjr);
        yqu.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        zkr.b(QQStoryContext.a().a(), new File(paramwjr));
        return;
      }
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    wik.a().c(((wjr)this.jdField_a_of_type_Wjp).a());
    if (((wjr)this.jdField_a_of_type_Wjp).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      wzw localwzw = new wzw(bool);
      localwzw.jdField_d_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).jdField_g_of_type_JavaLangString;
      localwzw.jdField_f_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).jdField_h_of_type_JavaLangString;
      localwzw.jdField_j_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).jdField_j_of_type_JavaLangString;
      localwzw.jdField_k_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).jdField_i_of_type_JavaLangString;
      localwzw.jdField_c_of_type_Long = ((wjr)this.jdField_a_of_type_Wjp).jdField_b_of_type_Long;
      localwzw.jdField_g_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).a().videoLabel;
      localwzw.jdField_h_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).a().videoDoodleDescription;
      localwzw.jdField_i_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).a().getStringExtra("all_doodle_text", "");
      localwzw.jdField_e_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).a().mLocalDate;
      localwzw.jdField_b_of_type_Long = ((wjr)this.jdField_a_of_type_Wjp).a().timeZoneOffset;
      localwzw.jdField_d_of_type_Long = ((wjr)this.jdField_a_of_type_Wjp).jdField_d_of_type_Long;
      localwzw.jdField_c_of_type_Int = ((wjr)this.jdField_a_of_type_Wjp).jdField_d_of_type_Int;
      localwzw.jdField_d_of_type_Int = ((wjr)this.jdField_a_of_type_Wjp).jdField_e_of_type_Int;
      localwzw.jdField_e_of_type_Long = ((wjr)this.jdField_a_of_type_Wjp).jdField_c_of_type_Long;
      localwzw.jdField_l_of_type_JavaLangString = ((wjr)this.jdField_a_of_type_Wjp).a().videoLocationDescription;
      localwzw.m = ((wjr)this.jdField_a_of_type_Wjp).a().gpsFilterDescription;
      localwzw.n = ((wjr)this.jdField_a_of_type_Wjp).a().atJsonData;
      localwzw.jdField_g_of_type_Int = ((wjr)this.jdField_a_of_type_Wjp).a().publishFrom;
      localwzw.jdField_f_of_type_Long = ((wjr)this.jdField_a_of_type_Wjp).a().videoCreateTime;
      localwzw.jdField_h_of_type_Int = ((wjr)this.jdField_a_of_type_Wjp).a().videoLatitude;
      localwzw.jdField_i_of_type_Int = ((wjr)this.jdField_a_of_type_Wjp).a().videoLongitude;
      localwzw.o = ((wjr)this.jdField_a_of_type_Wjp).a().localCreateCity;
      if (((wjr)this.jdField_a_of_type_Wjp).a().isPicture) {}
      for (;;)
      {
        localwzw.jdField_e_of_type_Int = i;
        localwzw.jdField_f_of_type_Int = ((wjr)this.jdField_a_of_type_Wjp).a().getIntExtra("video_type", 0);
        localwzw.jdField_a_of_type_ArrayOfByte = ((wjr)this.jdField_a_of_type_Wjp).a().readerConfBytes;
        localwzw.jdField_b_of_type_ArrayOfByte = ((wjr)this.jdField_a_of_type_Wjp).a().spreadGroupBytes;
        localwzw.p = ((wjr)this.jdField_a_of_type_Wjp).a().multiFragmentGroupId;
        localwzw.jdField_b_of_type_Boolean = ((wjr)this.jdField_a_of_type_Wjp).a().getBooleanExtra("ignorePersonalPublish", false);
        localwzw.jdField_j_of_type_Int = ((wjr)this.jdField_a_of_type_Wjp).a().getIntExtra("add_video_source", 0);
        localwzw.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((wjr)this.jdField_a_of_type_Wjp).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localwzw.jdField_c_of_type_ArrayOfByte = ((wjr)this.jdField_a_of_type_Wjp).a().tagInfoBytes;
        localwzw.q = ((wjr)this.jdField_a_of_type_Wjp).a().getStringExtra("pl", null);
        localwzw.r = ((wjr)this.jdField_a_of_type_Wjp).jdField_k_of_type_JavaLangString;
        localwzw.s = ((wjr)this.jdField_a_of_type_Wjp).a().getStringExtra("i_l", null);
        localwzw.t = ((wjr)this.jdField_a_of_type_Wjp).jdField_l_of_type_JavaLangString;
        localwzw.jdField_c_of_type_Boolean = ((wjr)this.jdField_a_of_type_Wjp).a().getBooleanExtra("story_sync_qzone", false);
        localwzw.jdField_a_of_type_Wrb = ((wjr)this.jdField_a_of_type_Wjp).jdField_a_of_type_Wrb;
        localwzw.u = ((wjr)this.jdField_a_of_type_Wjp).a().getStringExtra("game", null);
        localwzw.v = ((wjr)this.jdField_a_of_type_Wjp).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((wjr)this.jdField_a_of_type_Wjp).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localwzw.w = localJSONObject.optString("vid");
          localwzw.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localwzw.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        wlb.a().a(localwzw, new wjx(this));
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