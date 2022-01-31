import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMWebEffectCameraCaptureUnit.2;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class bkof
  extends QIMEffectCameraCaptureUnit
{
  public static int d;
  public static int e;
  public static String p;
  public boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private BroadcastReceiver a;
  public boolean a;
  protected int f;
  public int g;
  public int h;
  private int i;
  private int j;
  public String l;
  public String m;
  public String n;
  public String o;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  public boolean y;
  public boolean z = true;
  
  static
  {
    jdField_e_of_type_Int = 1;
    jdField_p_of_type_JavaLangString = "key_is_from_bless";
  }
  
  public bkof(bmhh parambmhh, bmhg parambmhg)
  {
    super(parambmhh, parambmhg);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bkog(this);
    this.jdField_a_of_type_Bmgz = new bmgz(10007, 7, 6);
    this.jdField_a_of_type_Int = 5;
  }
  
  private Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    return localBundle;
  }
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2, boolean paramBoolean6, boolean paramBoolean7, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, bkoe parambkoe)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("ARG_SUPPORT_VIDEO", paramBoolean1);
    localBundle.putBoolean("ARG_SUPPORT_PHOTO", paramBoolean2);
    localBundle.putInt("ARG_CAMERA_MODE", paramInt1);
    localBundle.putBoolean("ARG_BEAUTY", paramBoolean3);
    localBundle.putBoolean("ARG_SUPPORT_DD", paramBoolean4);
    localBundle.putBoolean("ARG_UNFOLD_DD", paramBoolean5);
    localBundle.putString("ARG_DD_CATEGORY_NAME", paramString1);
    localBundle.putString("ARG_DD_ITEM_ID", paramString2);
    localBundle.putBoolean("ARG_SUPPORT_FILTER", paramBoolean6);
    localBundle.putBoolean("ARG_UNFOLD_FILTER", paramBoolean7);
    localBundle.putString("ARG_FILTER_CATEGORY_NAME", paramString3);
    localBundle.putString("ARG_FILTER_ITEM_ID", paramString4);
    localBundle.putInt("ARG_DEAL_TYPE", paramInt2);
    localBundle.putString("ARG_ACTIVITY_ID", paramString6);
    localBundle.putString("ARG_ACTIVITY_TYPE", paramString5);
    localBundle.putString("ARG_WEB_CALLBACK", paramString7);
    localBundle.putString("ARG_CALLER_TYPE", paramString8);
    localBundle.putString("arg_topic_id", paramString9);
    localBundle.putString("arg_topic_name", paramString10);
    localBundle.putString("arg_ad_tag", paramString11);
    localBundle.putString("arg_callback", paramString7);
    if (parambkoe != null)
    {
      localBundle.putBoolean("arg_support_combo", parambkoe.jdField_a_of_type_Boolean);
      localBundle.putBoolean("arg_unfold_combo", parambkoe.jdField_b_of_type_Boolean);
      localBundle.putString("arg_combo_name", parambkoe.jdField_c_of_type_JavaLangString);
      localBundle.putString("arg_combo_id", parambkoe.jdField_d_of_type_JavaLangString);
      localBundle.putBoolean("arg_support_music", parambkoe.jdField_c_of_type_Boolean);
      localBundle.putBoolean("arg_unfold_music", parambkoe.jdField_d_of_type_Boolean);
      localBundle.putString("arg_music_name", parambkoe.g);
      localBundle.putString("arg_music_id", parambkoe.h);
    }
    localBundle.putInt("edit_video_type", 10007);
    localBundle.putInt("entrance_type", 7);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putBoolean("enable_local_video", false);
    return localBundle;
  }
  
  public View a()
  {
    View localView = super.a();
    int i1 = 1;
    int k;
    if ((this.B) && (!this.C))
    {
      k = 3;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(k);
      this.f = this.jdField_a_of_type_Bmhh.a().getIntent().getIntExtra("videoId", 0);
      if (this.f == 0) {
        break label103;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(5000.0F);
    }
    for (;;)
    {
      this.b.setOnClickListener(this);
      return localView;
      k = i1;
      if (this.B) {
        break;
      }
      k = i1;
      if (!this.C) {
        break;
      }
      k = 2;
      break;
      label103:
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(10000.0F);
    }
  }
  
  protected axqt a()
  {
    axqt localaxqt = super.a();
    localaxqt.i(this.i);
    return localaxqt;
  }
  
  protected List<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    PublishParam localPublishParam;
    Activity localActivity;
    Object localObject;
    if ((paramInt1 == 10007) && (paramInt2 == -1) && (paramIntent != null))
    {
      localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (localPublishParam.jdField_j_of_type_Int == 1)
      {
        localActivity = this.jdField_a_of_type_Bmhh.a();
        localActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        localObject = localPublishParam.jdField_c_of_type_JavaLangString;
        if (QLog.isColorLevel())
        {
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, "publishParam =" + localPublishParam.toString());
        }
        PtvFilterUtils.a(new File(localPublishParam.jdField_j_of_type_JavaLangString).getParent(), localPublishParam.jdField_b_of_type_JavaLangString);
        if (!this.I) {
          break label251;
        }
      }
    }
    label251:
    for (paramInt1 = 15;; paramInt1 = 32)
    {
      localActivity.getIntent().putExtra("param_entrance", paramInt1);
      localActivity.getIntent().putExtra("fake_id", localPublishParam.jdField_b_of_type_JavaLangString);
      paramIntent = a(paramIntent);
      localObject = new SessionInfo();
      ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = "0";
      bkoi.a(localActivity, (SessionInfo)localObject, localPublishParam, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramIntent, null);
      this.jdField_a_of_type_Blqk.n();
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.g = this.jdField_a_of_type_Bmhh.a().getIntent().getIntExtra("type", 1);
    this.h = this.jdField_a_of_type_Bmhh.a().getIntent().getIntExtra("WebSceneType", ajpx.jdField_d_of_type_Int);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.q2v.startUploadPTV");
    this.jdField_a_of_type_Bmhh.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
  }
  
  public void a(axqw paramaxqw)
  {
    super.a(paramaxqw);
    bmha localbmha = new bmhc(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(3).a();
    localbmha.jdField_a_of_type_Int = this.jdField_j_of_type_Int;
    localbmha.jdField_a_of_type_JavaLangString = this.jdField_q_of_type_JavaLangString;
    this.jdField_a_of_type_Bmgz.a(localbmha);
    bnld.a(this.jdField_a_of_type_Bmhh.a(), paramaxqw, this.jdField_a_of_type_Bmgz, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool2 = true;
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    Object localObject = new bmhf().b(3).a();
    if (this.jdField_j_of_type_Int == jdField_d_of_type_Int)
    {
      ((bmhd)localObject).i = true;
      ((bmhd)localObject).jdField_a_of_type_JavaLangString = this.jdField_q_of_type_JavaLangString;
    }
    ((bmhd)localObject).jdField_a_of_type_Int = this.g;
    ((bmhd)localObject).jdField_b_of_type_Int = this.h;
    ((bmhd)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bmhh.a().getIntent().getStringExtra("succUrl");
    ((bmhd)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bmhh.a().getIntent().getStringExtra("failedUrl");
    this.jdField_a_of_type_Bmgz.a((bmhd)localObject);
    a(paramLocalMediaInfo);
    localObject = new bnkq();
    if (this.h == ajpx.jdField_b_of_type_Int)
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = ((bnpl)blqr.a(3)).a();
      if ((localPtvTemplateInfo != null) && ((localPtvTemplateInfo.kind == 5) || (localPtvTemplateInfo.kind == 6) || (localPtvTemplateInfo.kind == 8) || (localPtvTemplateInfo.kind == 9) || (localPtvTemplateInfo.kind == 10)))
      {
        ((bnkq)localObject).jdField_a_of_type_Int = this.jdField_c_of_type_Int;
        ((bnkq)localObject).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        ((bnkq)localObject).g = this.jdField_e_of_type_JavaLangString;
        ((bnkq)localObject).f = this.jdField_d_of_type_JavaLangString;
        ((bnkq)localObject).jdField_b_of_type_JavaLangString = (localPtvTemplateInfo.categoryId + "");
        ((bnkq)localObject).jdField_c_of_type_JavaLangString = localPtvTemplateInfo.id;
        ((bnkq)localObject).jdField_a_of_type_Boolean = true;
        if (localPtvTemplateInfo.kind != 8) {
          break label387;
        }
        bool1 = true;
        ((bnkq)localObject).jdField_b_of_type_Boolean = bool1;
        if (localPtvTemplateInfo.kind != 9) {
          break label392;
        }
        bool1 = true;
        label324:
        ((bnkq)localObject).jdField_c_of_type_Boolean = bool1;
        if (localPtvTemplateInfo.kind != 10) {
          break label397;
        }
      }
    }
    label387:
    label392:
    label397:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((bnkq)localObject).jdField_d_of_type_Boolean = bool1;
      ((bnkq)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.e();
      bnld.a(this.jdField_a_of_type_Bmhh.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Bmgz, this.jdField_a_of_type_AndroidOsBundle, 5, (bnkq)localObject);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label324;
    }
  }
  
  public void ac()
  {
    Bundle localBundle = this.jdField_a_of_type_Bmhh.a().getIntent().getExtras();
    this.B = localBundle.getBoolean("ARG_SUPPORT_VIDEO");
    this.C = localBundle.getBoolean("ARG_SUPPORT_PHOTO");
    this.i = localBundle.getInt("ARG_CAMERA_MODE");
    this.D = localBundle.getBoolean("ARG_BEAUTY");
    this.H = localBundle.getBoolean("ARG_SUPPORT_DD");
    this.E = localBundle.getBoolean("ARG_UNFOLD_DD");
    this.t = localBundle.getString("ARG_DD_CATEGORY_NAME");
    this.u = localBundle.getString("ARG_DD_ITEM_ID");
    this.G = localBundle.getBoolean("ARG_SUPPORT_FILTER");
    this.F = localBundle.getBoolean("ARG_UNFOLD_FILTER");
    this.v = localBundle.getString("ARG_FILTER_CATEGORY_NAME");
    this.w = localBundle.getString("ARG_FILTER_ITEM_ID");
    this.jdField_j_of_type_Int = localBundle.getInt("ARG_DEAL_TYPE");
    this.jdField_q_of_type_JavaLangString = localBundle.getString("ARG_WEB_CALLBACK");
    this.jdField_s_of_type_JavaLangString = localBundle.getString("ARG_ACTIVITY_ID");
    this.jdField_r_of_type_JavaLangString = localBundle.getString("ARG_ACTIVITY_TYPE");
    this.x = localBundle.getString("ARG_CALLER_TYPE");
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("arg_support_combo");
    this.y = localBundle.getBoolean("arg_unfold_combo");
    this.l = localBundle.getString("arg_combo_name");
    this.m = localBundle.getString("arg_combo_id");
    this.z = localBundle.getBoolean("arg_support_music");
    this.A = localBundle.getBoolean("arg_unfold_music");
    this.n = localBundle.getString("arg_music_name");
    this.jdField_o_of_type_JavaLangString = localBundle.getString("arg_music_id");
    this.I = localBundle.getBoolean(jdField_p_of_type_JavaLangString);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Bmhh.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void h()
  {
    super.h();
    this.b.setVisibility(8);
  }
  
  public void n()
  {
    super.n();
    ThreadManager.getUIHandler().postDelayed(new QIMWebEffectCameraCaptureUnit.2(this), 300L);
  }
  
  public void o()
  {
    ac();
    this.jdField_o_of_type_Boolean = this.D;
    this.jdField_p_of_type_Boolean = this.G;
    this.jdField_q_of_type_Boolean = this.H;
    this.jdField_r_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_s_of_type_Boolean = this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkof
 * JD-Core Version:    0.7.0.1
 */