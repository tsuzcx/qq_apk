import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraManager;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;

public class bmuz
  extends bmxa
{
  public static int a;
  public static int b;
  private BroadcastReceiver a;
  private String b;
  private int f;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public bmuz(borh paramborh, borg paramborg)
  {
    super(paramborh, paramborg);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bmva(this);
    this.jdField_a_of_type_Boqz = new boqz(10007, this.jdField_a_of_type_Bmvr.d(), 6);
    this.d = 5;
  }
  
  private Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    return localBundle;
  }
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2, boolean paramBoolean6, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3)
  {
    paramString1 = new Bundle();
    int j = 1;
    int i;
    if ((paramBoolean2) && (!paramBoolean1))
    {
      i = 2;
      paramString1.putInt("ability_flag", i);
      paramString1.putInt("PeakConstants.ARG_FORCE_CAMERA", paramInt1);
      paramString1.putBoolean("PeakConstants.ARG_BEAUTY", paramBoolean3);
      paramString1.putBoolean("PeakConstants.ARG_SHARP_FACE", paramBoolean3);
      paramString1.putBoolean("PeakConstants.ARG_SUPPORT_DD", paramBoolean4);
      if ((paramBoolean4) && (paramBoolean5))
      {
        paramString1.putString("KEY_CURRENT_TAB", AECaptureMode.NORMAL.name);
        paramString1.putString("KEY_CURRENT_SELECT_ID", paramString2);
      }
      paramString1.putBoolean("PeakConstants.ARG_SUPPORT_FILTER", paramBoolean6);
      paramString1.putInt("ARG_DEAL_TYPE", paramInt2);
      paramString1.putString("ARG_WEB_CALLBACK", paramString3);
      paramString1.putString("arg_topic_id", paramString4);
      paramString1.putString("arg_topic_name", paramString5);
      paramString1.putString("arg_ad_tag", paramString6);
      paramString1.putString("arg_callback", paramString3);
      paramString1.putInt("edit_video_type", 10007);
      paramString1.putInt("entrance_type", paramInt3);
      paramString1.putBoolean("PeakConstants.ARG_ALBUM", false);
      paramInt1 = bnlb.F.a();
      if (paramInt3 != 107) {
        break label241;
      }
      paramInt1 = bnlb.G.a();
    }
    for (;;)
    {
      paramString1.putInt("VIDEO_STORY_FROM_TYPE", paramInt1);
      return paramString1;
      i = j;
      if (paramBoolean2) {
        break;
      }
      i = j;
      if (!paramBoolean1) {
        break;
      }
      i = 3;
      break;
      label241:
      if (paramInt3 == 108) {
        paramInt1 = bnlb.D.a();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    PublishParam localPublishParam;
    Activity localActivity;
    Object localObject;
    if ((paramInt1 == 10007) && (paramInt2 == -1) && (paramIntent != null))
    {
      localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      if (localPublishParam.jdField_j_of_type_Int == 1)
      {
        localActivity = this.jdField_a_of_type_Borh.a();
        localActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        localObject = localPublishParam.c;
        if (QLog.isColorLevel())
        {
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, "publishParam =" + localPublishParam.toString());
        }
        PtvFilterUtils.a(new File(localPublishParam.jdField_j_of_type_JavaLangString).getParent(), localPublishParam.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_Boqz.b() != 107) {
          break label244;
        }
      }
    }
    label244:
    for (paramInt1 = 15;; paramInt1 = 32)
    {
      localActivity.getIntent().putExtra("param_entrance", paramInt1);
      localActivity.getIntent().putExtra("fake_id", localPublishParam.jdField_b_of_type_JavaLangString);
      paramIntent = a(paramIntent);
      localObject = new SessionInfo();
      ((SessionInfo)localObject).curFriendUin = "0";
      bmvc.a(localActivity, (SessionInfo)localObject, localPublishParam, paramIntent, null);
      this.jdField_a_of_type_Bnbg.i();
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = this.jdField_a_of_type_Borh.a().getIntent().getExtras();
    this.f = paramBundle.getInt("ARG_DEAL_TYPE");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("ARG_WEB_CALLBACK");
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.q2v.startUploadPTV");
    this.jdField_a_of_type_Borh.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = new borf().b(3).a();
      if (this.f == jdField_a_of_type_Int)
      {
        ((bord)localObject).d = true;
        ((bord)localObject).a = this.jdField_b_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Boqz.a((bord)localObject);
      return;
    }
    Object localObject = new borc(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getSelectedCamera()).a(3).b(this.jdField_b_of_type_JavaLangString).b(this.f).a();
    this.jdField_a_of_type_Boqz.a((bora)localObject);
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Borh.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuz
 * JD-Core Version:    0.7.0.1
 */