package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import azmj;
import bdkd;
import bdpt;
import blve;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQLightRecognitionGuide
  extends Fragment
  implements Handler.Callback, View.OnClickListener
{
  private final int jdField_a_of_type_Int = 120;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private IphoneTitleBarActivity jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity;
  private final String jdField_a_of_type_JavaLangString = blve.a().getAbsolutePath() + "/qq_recognition_guide/";
  private final String b = "qq_pic_recognition_guide.png";
  
  private void a(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("method");
    if ("setFaceData".equals(str)) {
      azmj.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "1", "", "", "");
    }
    if ("loginVerify".equals(str)) {
      azmj.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "2", "", "", "");
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    paramString = "light_recognition_guide" + paramString;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 4).edit().putBoolean("has_show_guide", paramBoolean).apply();
  }
  
  private void b(String paramString)
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString + this.b);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getAppInterface();
    if (((localObject == null) || (!((AppInterface)localObject).isLogin())) && (!a())) {}
    for (paramString = getResources().getDrawable(2130845221);; paramString = bdpt.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getAppRuntime(), localFile.getAbsolutePath(), paramString, (Drawable)localObject, new int[] { 25 }, "-lightRecognition-", null))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      ApngImage.playByTag(25);
      return;
      localObject = super.getResources().getDrawable(2130845220);
    }
  }
  
  public boolean a()
  {
    String str = bdkd.a();
    return (!TextUtils.isEmpty(str)) && (new File(str + "libAPNG_release_813.so").exists());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 120) {
      b("https://sqimg.qq.com/qq_product_operations/tiqq/mqq_resource/guide_animation.png");
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 22)
    {
      QLog.d("QQLightRecognitionGuide", 1, "onActivity requestCode == AuthDevActivity.REQ_IDENTIFICATION, resultCode is : " + paramInt2);
      if ((paramInt2 == -1) && (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setResult(paramInt2, paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)paramActivity);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131371108)
    {
      a("0X800A85D");
      paramView = (FaceDetectForThirdPartyManager.AppConf)getArguments().getSerializable("FaceRecognition.AppConf");
      if ("setFaceData".equals(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("method")))
      {
        QLog.d("QQLightRecognitionGuide", 1, "click next_btn, method is METHOD_SETTING_FACE_DATA");
        localIntent1 = getActivity().getIntent();
        Intent localIntent2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQIdentiferActivity.class);
        localIntent2.putExtra("platformAppId", 101810106);
        localIntent2.putExtra("srcAppId", 101810106);
        localIntent2.putExtra("srcOpenId", localIntent1.getStringExtra("srcOpenId"));
        localIntent2.putExtra("key", localIntent1.getStringExtra("key"));
        localIntent2.putExtra("method", "setFaceData");
        localIntent2.putExtra("serviceType", localIntent1.getIntExtra("serviceType", -1));
        localIntent2.putExtra("FaceRecognition.AppConf", paramView);
        if (paramView != null) {
          localIntent2.putExtra("key_identification_type", paramView.mode);
        }
        startActivityForResult(localIntent2, 22);
      }
    }
    else
    {
      return;
    }
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("FaceRecognition.AppConf", paramView);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setResult(-1, localIntent1);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getCurrentAccountUin(), true);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561373, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131371108).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131375366));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(120);
    a("0X800A85C");
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(25);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(25);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLightRecognitionGuide
 * JD-Core Version:    0.7.0.1
 */