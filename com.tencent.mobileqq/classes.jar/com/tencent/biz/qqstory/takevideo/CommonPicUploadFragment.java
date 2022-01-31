package com.tencent.biz.qqstory.takevideo;

import alud;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import awkj;
import baqy;
import bayf;
import bayj;
import bayk;
import bdin;
import bhsl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import wxl;
import wxm;

public class CommonPicUploadFragment
  extends PublicBaseFragment
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected Dialog a;
  bayj jdField_a_of_type_Bayj = new wxm(this);
  private bhsl jdField_a_of_type_Bhsl;
  public BaseActivity a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long = -1L;
  private String jdField_c_of_type_JavaLangString;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f = "0";
  
  public CommonPicUploadFragment()
  {
    this.jdField_e_of_type_JavaLangString = "0";
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 51;
    }
    return 58;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "h5UploadPicHit";
    }
    return "DGPKSharePicHit";
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, "cancelProgressDialog");
        }
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CommonPicUploadFragment", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558965);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new wxl(this));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setAttributes(localLayoutParams);
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371894);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131719784);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, "showProgressDialog");
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      ((TextView)localObject).setText(paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonPicUploadFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Bhsl.sendEmptyMessage(1003);
      if (QLog.isColorLevel()) {
        QLog.d("CommonPicUploadFragment", 2, "startUploadPic empty path!");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = new File(paramString);
      if (((File)localObject).exists()) {
        break;
      }
      this.jdField_a_of_type_Bhsl.sendEmptyMessage(1003);
    } while (!QLog.isColorLevel());
    QLog.d("CommonPicUploadFragment", 2, "startUploadPic file not exist, path=" + paramString);
    return;
    this.jdField_a_of_type_Long = ((File)localObject).length();
    if (!bdin.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_a_of_type_Bhsl.sendEmptyMessage(1004);
      return;
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    CompressInfo localCompressInfo;
    if (this.jdField_b_of_type_Boolean)
    {
      localCompressInfo = new CompressInfo(paramString, 0);
      localCompressInfo.f = 0;
      if (!awkj.a(localCompressInfo)) {
        QLog.d("CommonPicUploadFragment", 1, "CompressOperator failed");
      }
      if (TextUtils.isEmpty(localCompressInfo.jdField_e_of_type_JavaLangString))
      {
        localObject = paramString;
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        this.jdField_b_of_type_Long = new File(paramString).length();
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, String.format("startUploadPic outWidth[%s], outHeight[%s], sizeBefore[%s], sizeAfter[%s], compressPath=[%s], originPath[%s]", new Object[] { Integer.valueOf(localCompressInfo.d), Integer.valueOf(localCompressInfo.jdField_e_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), localCompressInfo.jdField_e_of_type_JavaLangString, paramString }));
        }
      }
    }
    for (;;)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_Bayj.addFilter(new Class[] { baqy.class });
      paramString.a(this.jdField_a_of_type_Bayj);
      localObject = new bayk();
      ((bayk)localObject).jdField_a_of_type_Boolean = true;
      ((bayk)localObject).jdField_c_of_type_Int = a(this.jdField_a_of_type_Int);
      ((bayk)localObject).i = this.jdField_a_of_type_JavaLangString;
      this.jdField_d_of_type_Long = ((Math.random() * 1000000.0D));
      ((bayk)localObject).jdField_a_of_type_Long = this.jdField_d_of_type_Long;
      ((bayk)localObject).jdField_c_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      ((bayk)localObject).jdField_b_of_type_Int = 24;
      ((bayk)localObject).jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_Int);
      paramString.a((bayk)localObject);
      return;
      localObject = localCompressInfo.jdField_e_of_type_JavaLangString;
      break;
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonPicUploadFragment", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      a();
      a(alud.a(2131702627));
      return true;
    case 1002: 
    case 1003: 
      a();
      this.jdField_c_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(2);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return true;
    case 1004: 
      a();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(2);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return true;
    }
    paramMessage = new Intent();
    paramMessage.putExtra("upload_result", true);
    paramMessage.putExtra("upload_pic_uuid", this.jdField_c_of_type_JavaLangString);
    paramMessage.putExtra("upload_pic_md5", this.jdField_b_of_type_JavaLangString);
    paramMessage.putExtra("share_method", this.jdField_b_of_type_Int);
    paramMessage.putExtra("pk_rank", this.f);
    paramMessage.putExtra("current_nickname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    if (this.jdField_c_of_type_Long != -1L) {
      paramMessage.putExtra("upload_time_cost", SystemClock.elapsedRealtime() - this.jdField_c_of_type_Long);
    }
    BaseActivity localBaseActivity1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    BaseActivity localBaseActivity2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    localBaseActivity1.setResult(-1, paramMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Bhsl = new bhsl(this);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getExtras().getString("upload_pic_path");
    this.jdField_b_of_type_Boolean = paramBundle.getExtras().getBoolean("upload_pic_need_compress", false);
    paramBundle.getExtras().getString("dance_machine_rank", "0");
    paramBundle.getExtras().getString("dance_machine_score", "0");
    this.jdField_a_of_type_Int = paramBundle.getExtras().getInt("upload_pic_busi_type", 0);
    this.jdField_b_of_type_Int = paramBundle.getExtras().getInt("share_method", 0);
    this.f = paramBundle.getExtras().getString("pk_rank", "0");
    ThreadManager.executeOnSubThread(new CommonPicUploadFragment.1(this));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setTheme(16973841);
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bhsl != null) {
      this.jdField_a_of_type_Bhsl.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment
 * JD-Core Version:    0.7.0.1
 */