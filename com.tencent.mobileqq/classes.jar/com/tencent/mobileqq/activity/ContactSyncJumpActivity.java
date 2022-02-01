package com.tencent.mobileqq.activity;

import Override;
import adsx;
import adyj;
import adyk;
import adyl;
import adym;
import adyn;
import afur;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import anmu;
import anmw;
import aoch;
import ardh;
import aywi;
import bcst;
import bglf;
import bgnt;
import bjft;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import nmp;

public class ContactSyncJumpActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public int a;
  private adsx jdField_a_of_type_Adsx = new adyj(this);
  public Dialog a;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new adym(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new adyl(this);
  private anmu jdField_a_of_type_Anmu = new adyk(this);
  private aywi jdField_a_of_type_Aywi = new adyn(this);
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private ContactSyncManager jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public ContactSyncJumpActivity()
  {
    this.jdField_a_of_type_AndroidAppDialog = null;
  }
  
  private Dialog a()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755823);
    localReportDialog.setContentView(2131561112);
    Object localObject2 = (ImageView)localReportDialog.findViewById(2131365497);
    if (this.d.equals("0")) {}
    for (Object localObject1 = aoch.a(this.app, 11, this.jdField_b_of_type_JavaLangString + this.c);; localObject1 = aoch.a(this.app, 1, this.d))
    {
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      Object localObject3 = (TextView)localReportDialog.findViewById(2131365503);
      localObject1 = (TextView)localReportDialog.findViewById(2131365511);
      TextView localTextView = (TextView)localReportDialog.findViewById(2131365500);
      localObject2 = (TextView)localReportDialog.findViewById(2131365506);
      ((TextView)localObject3).setText(this.e);
      localTextView.setText(2131697854);
      localTextView.setOnClickListener(this);
      ((TextView)localObject2).setText(String.format(getResources().getString(2131697850), new Object[] { "" }));
      if (!bgnt.d(this)) {
        break;
      }
      localObject3 = getResources().getDrawable(2130839406);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject3, null, null, null);
      ((TextView)localObject1).setCompoundDrawablePadding(10);
      ((Animatable)localObject3).start();
      ((TextView)localObject2).setOnClickListener(this);
      return localReportDialog;
    }
    ((TextView)localObject1).setText(2131697852);
    ((TextView)localObject2).setTextColor(getResources().getColor(2131165613));
    ((TextView)localObject2).setEnabled(false);
    return localReportDialog;
  }
  
  private Dialog a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755823);
    localReportDialog.setContentView(2131561111);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365514);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365502);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365500);
    TextView localTextView4 = (TextView)localReportDialog.findViewById(2131365506);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramString);
    if (paramInt2 == 0) {
      localTextView3.setVisibility(8);
    }
    for (;;)
    {
      localTextView4.setText(paramInt3);
      localTextView3.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return localReportDialog;
      localTextView3.setText(paramInt2);
    }
  }
  
  private void a()
  {
    bcst.b(this.app, "CliOper", "", "", "System_contact", "Contact_msg", 0, 0, "", "", "", "");
    if (!this.d.equals("0"))
    {
      localIntent = afur.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtra("uin", this.d);
      localObject = (anmw)this.app.getManager(51);
      if (localObject != null)
      {
        localObject = ((anmw)localObject).e(this.d);
        if (localObject != null)
        {
          localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
          localIntent.putExtra("uinname", bglf.a((Friends)localObject));
          if ((nmp.a(((Friends)localObject).cSpecialFlag)) || (bjft.b(((Friends)localObject).cSpecialFlag)))
          {
            localIntent.setClass(this, SplashActivity.class);
            localIntent.putExtra("chat_subType", 1);
          }
        }
      }
      localIntent.putExtra("entrance", 0);
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("key_req_by_contact_sync", true);
      startActivity(localIntent);
      finish();
      return;
    }
    Intent localIntent = afur.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("entrance", 0);
    localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString + this.c);
    localIntent.putExtra("uintype", 1006);
    localIntent.putExtra("uinname", this.e);
    Object localObject = new ProfileActivity.AllInOne(this.jdField_b_of_type_JavaLangString + this.c, 31);
    ((ProfileActivity.AllInOne)localObject).a = new ArrayList();
    ((ProfileActivity.AllInOne)localObject).k = this.e;
    ((ProfileActivity.AllInOne)localObject).a.add(new ProfileActivity.CardContactInfo(this.e, this.c, this.jdField_b_of_type_JavaLangString));
    ((ProfileActivity.AllInOne)localObject).d = this.jdField_b_of_type_Int;
    ((ProfileActivity.AllInOne)localObject).h = 59;
    localIntent.putExtra("AIO_INFO", (Parcelable)localObject);
    localIntent.putExtra("key_req_by_contact_sync", true);
    startActivity(localIntent);
    finish();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "showAlertDialog | type = " + paramInt + " | current type = " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      this.jdField_a_of_type_AndroidAppDialog = a(2131697856, paramString, 2131697854, 2131697855);
      continue;
      this.jdField_a_of_type_AndroidAppDialog = a(2131697846, paramString, 0, 2131697845);
      continue;
      this.jdField_a_of_type_AndroidAppDialog = a();
    }
  }
  
  private boolean a(int paramInt)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a();
    String str3 = this.app.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "dealWithUnbind | syncUin = " + ContactSyncManager.b(str2) + " | loginUin = " + ContactSyncManager.b(str3) + " | bindState = " + paramInt);
    }
    if ((paramInt == 5) || (paramInt == 1) || (paramInt == 0)) {}
    for (String str1 = getResources().getString(2131697857);; str1 = getResources().getString(2131697858))
    {
      a(0, String.format(str1, new Object[] { ContactSyncManager.d(str3), ContactSyncManager.d(str2) }));
      return true;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = getIntent();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "doJump | intent = " + localObject);
    }
    if (localObject != null) {
      try
      {
        if ((!TextUtils.isEmpty(((Intent)localObject).getAction())) || (((Intent)localObject).getBooleanExtra("key_req_from_switch_account", false)) || (((Intent)localObject).getBooleanExtra("key_req_from_lock_screen", false))) {
          if (((Intent)localObject).getBooleanExtra("key_req_from_switch_account", false))
          {
            if (!((Intent)localObject).getBooleanExtra("key_change", false))
            {
              finish();
              return false;
            }
            localObject = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject == null) || (!(localObject instanceof Intent)))
            {
              finish();
              return false;
            }
            setIntent((Intent)localObject);
          }
        }
        while ((paramBoolean) && (!this.app.isLogin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is not login");
          }
          localObject = new Intent(this, LoginActivity.class);
          ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
          ((Intent)localObject).putExtra("key_orginal_intent", getIntent());
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(536870912);
          startActivity((Intent)localObject);
          finish();
          return false;
          if (((Intent)localObject).getBooleanExtra("key_req_from_lock_screen", false))
          {
            localObject = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject == null) || (!(localObject instanceof Intent)))
            {
              finish();
              return false;
            }
            setIntent((Intent)localObject);
            continue;
            return false;
          }
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump", localException1);
        }
      }
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      Intent localIntent = new Intent(this, GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_req_by_contact_sync", true);
      localIntent.putExtra("key_orginal_intent", getIntent());
      startActivity(localIntent);
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager = ((ContactSyncManager)this.app.getManager(41));
    int i;
    String str;
    try
    {
      this.f = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(getIntent().getData());
      if ((this.f == null) || ((!this.f.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) && (!this.f.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump | error mimeType = " + this.f);
        }
        finish();
        return false;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump | e = ", localException2);
        }
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.b(getIntent().getData());
      i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d();
      str = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is login | bind state is " + i + " | currentUin = " + ContactSyncManager.b(this.app.getCurrentAccountUin()) + " | syncUin = " + ContactSyncManager.b(str));
      }
      if (i != 0) {
        break label674;
      }
    }
    if (str.equals(this.app.getCurrentAccountUin())) {
      return b();
    }
    for (;;)
    {
      return a(i);
      label674:
      do
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d()) || (str.equals(this.app.getCurrentAccountUin()))) {
          return b();
        }
        paramBoolean = a(i);
        return paramBoolean;
        if ((i == 5) || (i == 1)) {
          break;
        }
      } while (i != 0);
    }
  }
  
  private void b()
  {
    String str;
    if (!this.d.equals("0"))
    {
      i = 1;
      QQAppInterface localQQAppInterface = this.app;
      if (i == 0) {
        break label125;
      }
      str = "0";
      label26:
      bcst.b(localQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "16", str, "", "");
      if (i == 0) {
        break label132;
      }
    }
    label132:
    for (int i = 0;; i = 1006)
    {
      str = this.jdField_b_of_type_JavaLangString + this.c;
      if (ChatActivityUtils.a(this.app, this, i, this.d, this.e, str, true, null, true, true, this.jdField_a_of_type_Adsx, "from_app_contact")) {
        finish();
      }
      return;
      i = 0;
      break;
      label125:
      str = "3";
      break label26;
    }
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    this.app.registObserver(this.jdField_a_of_type_Aywi);
    Uri localUri = getIntent().getData();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      boolean bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("dealWithBindOK | getTargetPhoneContact | uri = ").append(localUri).append(" | mobileNo = ").append(ContactSyncManager.c(this.jdField_a_of_type_JavaLangString)).append(" | pc = ");
        if (localObject != null)
        {
          bool1 = true;
          QLog.d("ContactSync.JumpActivity", 2, bool1);
        }
      }
      else
      {
        if (localObject == null) {
          break label216;
        }
        this.d = ((PhoneContact)localObject).uin;
        this.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject).nationCode;
        this.c = ((PhoneContact)localObject).mobileCode;
        this.e = ((PhoneContact)localObject).name;
        this.jdField_b_of_type_Int = ((PhoneContact)localObject).ability;
        label158:
        if (((TextUtils.isEmpty(this.d)) || (this.d.equals("0"))) && (TextUtils.isEmpty(this.c))) {
          break label373;
        }
        if (!this.f.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) {
          break label304;
        }
        a();
        bool1 = false;
      }
      label216:
      do
      {
        return bool1;
        bool1 = false;
        break;
        localObject = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(localUri);
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "dealWithBindOK | pc is null | simplePc = " + localObject);
        }
        if (localObject == null) {
          break label158;
        }
        this.d = "0";
        this.jdField_b_of_type_JavaLangString = ((ardh)localObject).jdField_b_of_type_JavaLangString;
        this.c = ((ardh)localObject).c;
        this.e = ((ardh)localObject).jdField_a_of_type_JavaLangString;
        this.jdField_b_of_type_Int = ((ardh)localObject).jdField_a_of_type_Int;
        break label158;
        a(2, null);
        bool1 = bool2;
      } while (!bgnt.d(this));
      label304:
      localObject = (FriendListHandler)this.app.a(1);
      this.app.addObserver(this.jdField_a_of_type_Anmu);
      ((FriendListHandler)localObject).c(this.jdField_b_of_type_JavaLangString + this.c, true);
      return true;
      label373:
      localObject = String.format(getResources().getString(2131697844), new Object[] { this.e });
      this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(this.jdField_a_of_type_JavaLangString);
      a(1, (String)localObject);
      return true;
    }
  }
  
  public boolean a()
  {
    return ((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return a(true);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.jdField_a_of_type_Anmu);
    this.app.unRegistObserver(this.jdField_a_of_type_Aywi);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.unRegistObserver(this.jdField_a_of_type_Aywi);
    setIntent(paramIntent);
    a(true);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    finish();
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        finish();
      }
      else if (this.jdField_a_of_type_Int == 2)
      {
        finish();
        continue;
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
          Intent localIntent = new Intent();
          localIntent.setPackage(getPackageName());
          localIntent.setClass(this, LoginActivity.class);
          localIntent.putExtra("IS_ADD_ACCOUNT", true);
          localIntent.putExtra("key_req_by_contact_sync", true);
          localIntent.putExtra("key_uin_to_login", this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a());
          localIntent.putExtra("key_orginal_intent", getIntent());
          localIntent.addFlags(67108864);
          localIntent.addFlags(536870912);
          startActivity(localIntent);
          finish();
        }
        else if (this.jdField_a_of_type_Int == 2)
        {
          b();
        }
        else
        {
          finish();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity
 * JD-Core Version:    0.7.0.1
 */