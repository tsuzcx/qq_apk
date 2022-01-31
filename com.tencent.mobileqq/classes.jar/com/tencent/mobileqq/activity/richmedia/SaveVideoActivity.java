package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import xtz;
import xua;

public class SaveVideoActivity
  extends FlowActivity
{
  private static FFmpeg jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
  private static boolean jdField_a_of_type_Boolean;
  private xua jdField_a_of_type_Xua;
  private boolean d;
  
  public static Intent a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = new Intent(paramContext, SaveVideoActivity.class);
    paramContext.putExtra("fakeId", paramString);
    paramContext.putExtra("sv_total_frame_count", paramInt2);
    paramContext.putExtra("sv_total_record_time", paramInt1);
    return paramContext;
  }
  
  private static PublishVideoEntry b(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      if (paramAppInterface == null) {
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
      }
      paramAppInterface = new QQStoryEntityManagerFactory(paramAppInterface);
      paramAppInterface.verifyAuthentication();
      paramAppInterface = ShortVideoRealItemBuilder.a(paramAppInterface.createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[] { paramString });
    } while ((paramAppInterface == null) || (paramAppInterface.size() <= 0));
    return (PublishVideoEntry)paramAppInterface.get(0);
  }
  
  private static void b(AppInterface paramAppInterface, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry == null) {
      return;
    }
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    if (paramAppInterface == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    paramAppInterface = new QQStoryEntityManagerFactory(paramAppInterface);
    paramAppInterface.verifyAuthentication();
    paramAppInterface.createEntityManager().b(paramPublishVideoEntry);
  }
  
  protected void a(ViewGroup paramViewGroup) {}
  
  public void onBackPressed()
  {
    if (this.d) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.U = false;
    this.V = false;
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.z = paramBundle.getIntExtra("sv_total_frame_count", 0);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.y = paramBundle.getIntExtra("sv_total_record_time", 0);
    this.jdField_a_of_type_Xua = new xua(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    xua.a(this.jdField_a_of_type_Xua, paramBundle.getStringExtra("mc_video.mp4"));
    xua.b(this.jdField_a_of_type_Xua, paramBundle.getStringExtra("mc_audio.mp4"));
    xua.c(this.jdField_a_of_type_Xua, paramBundle.getStringExtra("all_i_mc_video.mp4"));
    xua.a(this.jdField_a_of_type_Xua, paramBundle.getBooleanExtra("mediacodec_encode_enable", false));
    Utils.executeAsyncTaskOnSerialExcuter(this.jdField_a_of_type_Xua, new Void[] { (Void)null });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.d = true;
      if ((this.jdField_a_of_type_Xua != null) && (!isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "cancel save video");
        }
        xua.a(this.jdField_a_of_type_Xua).set(true);
        setResult(0, getIntent());
        if (getIntent() != null) {
          ThreadManager.postImmediately(new xtz(this, getIntent().getStringExtra("fakeId")), null, true);
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.SaveVideoActivity
 * JD-Core Version:    0.7.0.1
 */