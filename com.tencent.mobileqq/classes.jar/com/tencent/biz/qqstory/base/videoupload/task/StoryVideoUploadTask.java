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
import vzh;
import wcz;
import wdm;
import wdo;
import wdp;
import wdy;
import wdz;
import wea;
import web;
import wec;
import wed;
import wee;
import weg;
import wfi;
import wlb;
import wlc;
import wlh;
import wuc;
import wzk;
import ykq;
import ykv;
import zdr;
import zeb;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<wdy>
{
  private AtomicInteger a;
  
  public StoryVideoUploadTask(wdy paramwdy)
  {
    super(paramwdy);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = paramwdy.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (zdr.a(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        paramwdy.jdField_d_of_type_JavaLangString = ((PublishVideoEntry)localObject1).doodleRawPath;
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
      ykq.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (weg.a(2131099649).booleanValue()) {
            a(paramwdy);
          }
          localObject1 = paramwdy.a().videoUploadTempDir;
          if (localObject1 != null) {
            zeb.a((String)localObject1);
          }
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { paramwdy.a() });
          if (!TextUtils.isEmpty(paramwdy.jdField_b_of_type_JavaLangString)) {
            ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(zeb.b(paramwdy.jdField_b_of_type_JavaLangString)), paramwdy.jdField_b_of_type_JavaLangString });
          }
          localObject1 = paramwdy.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(zeb.b((String)localObject1)), localObject1 });
          }
          paramwdy.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          wcz.a().a(((wdy)this.jdField_a_of_type_Wdw).a());
          if ((TextUtils.isEmpty(paramwdy.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramwdy.jdField_k_of_type_JavaLangString))) {
            break label789;
          }
          localObject1 = new wdm(true);
          ((wdm)localObject1).jdField_a_of_type_JavaLangString = paramwdy.jdField_e_of_type_JavaLangString;
          ((wdm)localObject1).a(new wdz(this, paramwdy));
          paramwdy.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(paramwdy.jdField_f_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramwdy.jdField_l_of_type_JavaLangString))) {
            break label800;
          }
          localObject1 = new wdm(true);
          ((wdm)localObject1).jdField_a_of_type_JavaLangString = paramwdy.jdField_f_of_type_JavaLangString;
          ((wdm)localObject1).a(new wea(this, paramwdy));
          paramwdy.jdField_a_of_type_JavaUtilList.add(localObject1);
          if (!TextUtils.isEmpty(((wdy)this.jdField_a_of_type_Wdw).jdField_g_of_type_JavaLangString)) {
            break label811;
          }
          localObject1 = new wdp(((wdy)this.jdField_a_of_type_Wdw).a(), ((wdy)this.jdField_a_of_type_Wdw).jdField_a_of_type_JavaLangString);
          ((wdp)localObject1).a(new web(this));
          paramwdy.jdField_a_of_type_JavaUtilList.add(localObject1);
          if ((TextUtils.isEmpty(((wdy)this.jdField_a_of_type_Wdw).jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(((wdy)this.jdField_a_of_type_Wdw).jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new wdm(false);
            ((wdm)localObject1).jdField_a_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).jdField_b_of_type_JavaLangString;
            ((wdm)localObject1).a(new wec(this));
            paramwdy.jdField_a_of_type_JavaUtilList.add(localObject1);
          }
          localObject1 = ((wdy)this.jdField_a_of_type_Wdw).jdField_a_of_type_Wlh;
          if ((localObject1 != null) && (((wlh)localObject1).jdField_a_of_type_Int == 1) && (((wlh)localObject1).jdField_b_of_type_Int != 2))
          {
            localObject2 = new wdo(((wlh)localObject1).jdField_a_of_type_JavaLangString);
            ((wlh)localObject1).jdField_b_of_type_Int = 1;
            ((wdo)localObject2).a(new wed(this, (wlh)localObject1, (wdo)localObject2));
            paramwdy.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          ykq.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          ykq.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          ykq.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (!zeb.b(paramString)) {}
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
  
  private void a(wdy paramwdy)
  {
    Object localObject4 = paramwdy.a();
    Object localObject2;
    if ((paramwdy.jdField_b_of_type_Int == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        ykq.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
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
      localObject1 = zdr.b((Bitmap)localObject2, (Bitmap)localObject3);
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
      localObject3 = wlc.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = FFmpegUtils.generateVoteBitmap((wlc)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = zdr.b((Bitmap)localObject2, localBitmap);
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
      localObject3 = wlb.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = FFmpegUtils.generateInteractBitmap((wlb)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = zdr.b((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      paramwdy = wzk.a(paramwdy.jdField_g_of_type_JavaLangString, true);
      zeb.a(vzh.jdField_e_of_type_JavaLangString);
      boolean bool = zdr.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, paramwdy);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        ykq.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", paramwdy);
        ykv.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        zeb.b(QQStoryContext.a().a(), new File(paramwdy));
        return;
      }
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
    }
  }
  
  protected void c()
  {
    int i = 1;
    wcz.a().c(((wdy)this.jdField_a_of_type_Wdw).a());
    if (((wdy)this.jdField_a_of_type_Wdw).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      wuc localwuc = new wuc(bool);
      localwuc.jdField_d_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).jdField_g_of_type_JavaLangString;
      localwuc.jdField_f_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).jdField_h_of_type_JavaLangString;
      localwuc.jdField_j_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).jdField_j_of_type_JavaLangString;
      localwuc.jdField_k_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).jdField_i_of_type_JavaLangString;
      localwuc.jdField_c_of_type_Long = ((wdy)this.jdField_a_of_type_Wdw).jdField_b_of_type_Long;
      localwuc.jdField_g_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).a().videoLabel;
      localwuc.jdField_h_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).a().videoDoodleDescription;
      localwuc.jdField_i_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).a().getStringExtra("all_doodle_text", "");
      localwuc.jdField_e_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).a().mLocalDate;
      localwuc.jdField_b_of_type_Long = ((wdy)this.jdField_a_of_type_Wdw).a().timeZoneOffset;
      localwuc.jdField_d_of_type_Long = ((wdy)this.jdField_a_of_type_Wdw).jdField_d_of_type_Long;
      localwuc.jdField_c_of_type_Int = ((wdy)this.jdField_a_of_type_Wdw).jdField_d_of_type_Int;
      localwuc.jdField_d_of_type_Int = ((wdy)this.jdField_a_of_type_Wdw).jdField_e_of_type_Int;
      localwuc.jdField_e_of_type_Long = ((wdy)this.jdField_a_of_type_Wdw).jdField_c_of_type_Long;
      localwuc.jdField_l_of_type_JavaLangString = ((wdy)this.jdField_a_of_type_Wdw).a().videoLocationDescription;
      localwuc.m = ((wdy)this.jdField_a_of_type_Wdw).a().gpsFilterDescription;
      localwuc.n = ((wdy)this.jdField_a_of_type_Wdw).a().atJsonData;
      localwuc.jdField_g_of_type_Int = ((wdy)this.jdField_a_of_type_Wdw).a().publishFrom;
      localwuc.jdField_f_of_type_Long = ((wdy)this.jdField_a_of_type_Wdw).a().videoCreateTime;
      localwuc.jdField_h_of_type_Int = ((wdy)this.jdField_a_of_type_Wdw).a().videoLatitude;
      localwuc.jdField_i_of_type_Int = ((wdy)this.jdField_a_of_type_Wdw).a().videoLongitude;
      localwuc.o = ((wdy)this.jdField_a_of_type_Wdw).a().localCreateCity;
      if (((wdy)this.jdField_a_of_type_Wdw).a().isPicture) {}
      for (;;)
      {
        localwuc.jdField_e_of_type_Int = i;
        localwuc.jdField_f_of_type_Int = ((wdy)this.jdField_a_of_type_Wdw).a().getIntExtra("video_type", 0);
        localwuc.jdField_a_of_type_ArrayOfByte = ((wdy)this.jdField_a_of_type_Wdw).a().readerConfBytes;
        localwuc.jdField_b_of_type_ArrayOfByte = ((wdy)this.jdField_a_of_type_Wdw).a().spreadGroupBytes;
        localwuc.p = ((wdy)this.jdField_a_of_type_Wdw).a().multiFragmentGroupId;
        localwuc.jdField_b_of_type_Boolean = ((wdy)this.jdField_a_of_type_Wdw).a().getBooleanExtra("ignorePersonalPublish", false);
        localwuc.jdField_j_of_type_Int = ((wdy)this.jdField_a_of_type_Wdw).a().getIntExtra("add_video_source", 0);
        localwuc.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = ((wdy)this.jdField_a_of_type_Wdw).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
        localwuc.jdField_c_of_type_ArrayOfByte = ((wdy)this.jdField_a_of_type_Wdw).a().tagInfoBytes;
        localwuc.q = ((wdy)this.jdField_a_of_type_Wdw).a().getStringExtra("pl", null);
        localwuc.r = ((wdy)this.jdField_a_of_type_Wdw).jdField_k_of_type_JavaLangString;
        localwuc.s = ((wdy)this.jdField_a_of_type_Wdw).a().getStringExtra("i_l", null);
        localwuc.t = ((wdy)this.jdField_a_of_type_Wdw).jdField_l_of_type_JavaLangString;
        localwuc.jdField_c_of_type_Boolean = ((wdy)this.jdField_a_of_type_Wdw).a().getBooleanExtra("story_sync_qzone", false);
        localwuc.jdField_a_of_type_Wlh = ((wdy)this.jdField_a_of_type_Wdw).jdField_a_of_type_Wlh;
        localwuc.u = ((wdy)this.jdField_a_of_type_Wdw).a().getStringExtra("game", null);
        localwuc.v = ((wdy)this.jdField_a_of_type_Wdw).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((wdy)this.jdField_a_of_type_Wdw).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localwuc.w = localJSONObject.optString("vid");
          localwuc.jdField_k_of_type_Int = (localJSONObject.optInt("comparedLevel") + 1);
          localwuc.jdField_l_of_type_Int = localJSONObject.optInt("comparedActivityId");
        }
        wfi.a().a(localwuc, new wee(this));
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