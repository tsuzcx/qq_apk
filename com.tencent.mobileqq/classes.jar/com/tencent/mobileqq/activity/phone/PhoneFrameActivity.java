package com.tencent.mobileqq.activity.phone;

import aepi;
import ainb;
import ainc;
import alud;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import azqs;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class PhoneFrameActivity
  extends IphoneTitleBarActivity
{
  private int jdField_a_of_type_Int = 0;
  Bundle jdField_a_of_type_AndroidOsBundle;
  public View a;
  public ImageView a;
  public TextView a;
  public PhoneFrame a;
  public View b;
  
  public PhoneFrameActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = null;
  }
  
  private void a()
  {
    Intent localIntent = aepi.a(new Intent(this, SplashActivity.class), null);
    Object localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    ((Bundle)localObject).putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Bundle)localObject).putBoolean("PhotoConst.IS_FORWARD", true);
    ((Bundle)localObject).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    ((Bundle)localObject).putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localIntent.putExtra("isBack2Root", false);
    localIntent.putExtras((Bundle)localObject);
    localIntent.putExtra("uin", getIntent().getStringExtra("uin"));
    localIntent.putExtra("uinname", getIntent().getStringExtra("uinname"));
    localIntent.putExtra("uintype", getIntent().getIntExtra("uintype", 0));
    localIntent.putExtra("troop_uin", getIntent().getStringExtra("uin"));
    localObject = ((Bundle)localObject).getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    PhotoUtils.a(this, localIntent, localArrayList, 0, false);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375863);
    this.b = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368624));
    this.leftView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368626));
    this.rightViewText = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368655));
    this.rightViewText.setText(2131695209);
    this.rightViewText.setOnClickListener(new ainb(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368638));
    if (AppSetting.c) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131708393));
    }
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidViewView);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetTextView);
    IphoneTitleBarActivity.setLayerType(this.leftView);
    IphoneTitleBarActivity.setLayerType(this.rightViewText);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = ((PhoneFrame)findViewById(2131371762));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setPhoneContext(new ainc(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a(null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_req_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.b(localBundle);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20001)
    {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    setContentView(2131559424);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_req_type", 0);
    b();
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.d();
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {}
    }
    else
    {
      return;
    }
    paramIntent = (String)paramIntent.get(0);
    this.jdField_a_of_type_AndroidOsBundle.putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("FORWARD_IS_EDITED", true);
    a();
    azqs.b(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
  }
  
  public void doOnPause()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.b();
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a();
  }
  
  public void finish()
  {
    if ((this.app.isLogin()) && (this.jdField_a_of_type_Int == 0))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", MainFragment.d);
      startActivity(localIntent);
    }
    super.finish();
    overridePendingTransition(2130771988, 2130771989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrameActivity
 * JD-Core Version:    0.7.0.1
 */