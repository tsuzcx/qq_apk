package com.tencent.mobileqq.activity;

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
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.SimplePhoneContact;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.util.ContactSyncUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class ContactSyncJumpActivity
  extends BaseActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new ContactSyncJumpActivity.4(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new ContactSyncJumpActivity.3(this);
  private ChatActivityUtils.StartVideoListener jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new ContactSyncJumpActivity.1(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ContactSyncJumpActivity.2(this);
  private IContactSyncService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService;
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new ContactSyncJumpActivity.5(this);
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private Dialog a()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756189);
    localReportDialog.setContentView(2131561034);
    Object localObject2 = (ImageView)localReportDialog.findViewById(2131365664);
    if (this.d.equals("0"))
    {
      localObject1 = this.app;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(this.c);
      localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 11, ((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject1 = FaceDrawable.getFaceDrawable(this.app, 1, this.d);
    }
    ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
    Object localObject3 = (TextView)localReportDialog.findViewById(2131365670);
    Object localObject1 = (TextView)localReportDialog.findViewById(2131365678);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365667);
    localObject2 = (TextView)localReportDialog.findViewById(2131365673);
    ((TextView)localObject3).setText(this.e);
    localTextView.setText(2131698730);
    localTextView.setOnClickListener(this);
    ((TextView)localObject2).setText(String.format(getResources().getString(2131698725), new Object[] { "" }));
    if (NetworkUtil.isNetSupport(this))
    {
      localObject3 = getResources().getDrawable(2130839406);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject3, null, null, null);
      ((TextView)localObject1).setCompoundDrawablePadding(10);
      ((Animatable)localObject3).start();
      ((TextView)localObject2).setOnClickListener(this);
      return localReportDialog;
    }
    ((TextView)localObject1).setText(2131698727);
    ((TextView)localObject2).setTextColor(getResources().getColor(2131165606));
    ((TextView)localObject2).setEnabled(false);
    return localReportDialog;
  }
  
  private Dialog a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756189);
    localReportDialog.setContentView(2131561033);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365681);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView4 = (TextView)localReportDialog.findViewById(2131365673);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramString);
    if (paramInt2 == 0) {
      localTextView3.setVisibility(8);
    } else {
      localTextView3.setText(paramInt2);
    }
    localTextView4.setText(paramInt3);
    localTextView3.setOnClickListener(this);
    localTextView4.setOnClickListener(this);
    return localReportDialog;
  }
  
  private void a()
  {
    ReportController.b(this.app, "CliOper", "", "", "System_contact", "Contact_msg", 0, 0, "", "", "", "");
    if (!this.d.equals("0"))
    {
      localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtra("uin", this.d);
      localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).e(this.d);
        if (localObject != null)
        {
          localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
          localIntent.putExtra("uinname", ContactUtils.a((Friends)localObject));
          if ((CrmUtils.a(((Friends)localObject).cSpecialFlag)) || (QidianManager.b(((Friends)localObject).cSpecialFlag)))
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
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("entrance", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(this.c);
    localIntent.putExtra("uin", ((StringBuilder)localObject).toString());
    localIntent.putExtra("uintype", 1006);
    localIntent.putExtra("uinname", this.e);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(this.c);
    localObject = new AllInOne(((StringBuilder)localObject).toString(), 31);
    ((AllInOne)localObject).contactArray = new ArrayList();
    ((AllInOne)localObject).contactName = this.e;
    ((AllInOne)localObject).contactArray.add(new ProfileContactInfo(this.e, this.c, this.jdField_b_of_type_JavaLangString));
    ((AllInOne)localObject).chatAbility = this.jdField_b_of_type_Int;
    ((AllInOne)localObject).profileEntryType = 59;
    localIntent.putExtra("AIO_INFO", (Parcelable)localObject);
    localIntent.putExtra("key_req_by_contact_sync", true);
    startActivity(localIntent);
    finish();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showAlertDialog | type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" | current type = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("ContactSync.JumpActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          this.jdField_a_of_type_AndroidAppDialog = a();
        }
      }
      else {
        this.jdField_a_of_type_AndroidAppDialog = a(2131698721, paramString, 0, 2131698720);
      }
    }
    else {
      this.jdField_a_of_type_AndroidAppDialog = a(2131698732, paramString, 2131698730, 2131698731);
    }
    paramString = this.jdField_a_of_type_AndroidAppDialog;
    if (paramString != null)
    {
      paramString.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private boolean a(int paramInt)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService.getSyncAccountUin();
    String str2 = this.app.getCurrentAccountUin();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dealWithUnbind | syncUin = ");
      ((StringBuilder)localObject).append(ContactSyncUtils.a(str1));
      ((StringBuilder)localObject).append(" | loginUin = ");
      ((StringBuilder)localObject).append(ContactSyncUtils.a(str2));
      ((StringBuilder)localObject).append(" | bindState = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ContactSync.JumpActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt != 5) && (paramInt != 1) && (paramInt != 0)) {
      localObject = getResources().getString(2131698734);
    } else {
      localObject = getResources().getString(2131698733);
    }
    a(0, String.format((String)localObject, new Object[] { ContactSyncUtils.c(str2), ContactSyncUtils.c(str1) }));
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject1 = getIntent();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doJump | intent = ");
      localStringBuilder.append(localObject1);
      QLog.d("ContactSync.JumpActivity", 2, localStringBuilder.toString());
    }
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        boolean bool = TextUtils.isEmpty(((Intent)localObject1).getAction());
        if ((!bool) || (((Intent)localObject1).getBooleanExtra("key_req_from_switch_account", false)) || (((Intent)localObject1).getBooleanExtra("key_req_from_lock_screen", false)))
        {
          bool = ((Intent)localObject1).getBooleanExtra("key_req_from_switch_account", false);
          if (bool)
          {
            if (!((Intent)localObject1).getBooleanExtra("key_change", false))
            {
              finish();
              return false;
            }
            localObject1 = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject1 != null) && ((localObject1 instanceof Intent)))
            {
              setIntent((Intent)localObject1);
            }
            else
            {
              finish();
              return false;
            }
          }
          else if (((Intent)localObject1).getBooleanExtra("key_req_from_lock_screen", false))
          {
            localObject1 = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject1 != null) && ((localObject1 instanceof Intent)))
            {
              setIntent((Intent)localObject1);
            }
            else
            {
              finish();
              return false;
            }
          }
          if ((paramBoolean) && (!this.app.isLogin()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is not login");
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_req_by_contact_sync", true);
            ((Intent)localObject1).putExtra("key_orginal_intent", getIntent());
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).addFlags(536870912);
            RouteUtils.a(this, (Intent)localObject1, "/base/login");
            finish();
            return false;
          }
          if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
          {
            localObject1 = new Intent(this, GesturePWDUnlockActivity.class);
            ((Intent)localObject1).putExtra("key_req_by_contact_sync", true);
            ((Intent)localObject1).putExtra("key_orginal_intent", getIntent());
            startActivity((Intent)localObject1);
            finish();
            return false;
          }
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class));
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService = ((IContactSyncService)this.app.getRuntimeService(IContactSyncService.class));
          try
          {
            this.f = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService.getMimeTypeByJumpUri(getIntent().getData());
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.JumpActivity", 2, "doJump | e = ", localException1);
            }
          }
          Object localObject2;
          if ((this.f != null) && ((this.f.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) || (this.f.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile"))))
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService.getMobileNoByJumpUri(getIntent().getData());
            i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService.getSyncAccountUin();
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("doJump | check user is login | bind state is ");
              localStringBuilder.append(i);
              localStringBuilder.append(" | currentUin = ");
              localStringBuilder.append(ContactSyncUtils.a(this.app.getCurrentAccountUin()));
              localStringBuilder.append(" | syncUin = ");
              localStringBuilder.append(ContactSyncUtils.a((String)localObject2));
              QLog.d("ContactSync.JumpActivity", 2, localStringBuilder.toString());
            }
            if ((i != 0) || (!((String)localObject2).equals(this.app.getCurrentAccountUin()))) {
              break label779;
            }
            return b();
            if ((!this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.isBindContactOk()) && (!((String)localObject2).equals(this.app.getCurrentAccountUin()))) {
              return a(i);
            }
            return b();
            return a(i);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doJump | error mimeType = ");
            ((StringBuilder)localObject2).append(this.f);
            QLog.d("ContactSync.JumpActivity", 2, ((StringBuilder)localObject2).toString());
          }
          finish();
          return false;
        }
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump", localException2);
        }
      }
      return false;
      label779:
      if ((i != 5) && (i != 1)) {
        if (i != 0) {}
      }
    }
  }
  
  private void b()
  {
    Object localObject2 = this.d;
    Object localObject1 = "0";
    boolean bool = ((String)localObject2).equals("0") ^ true;
    localObject2 = this.app;
    if (!bool) {
      localObject1 = "3";
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "16", (String)localObject1, "", "");
    int i;
    if (bool) {
      bool = false;
    } else {
      i = 1006;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(this.c);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (ChatActivityUtils.a(this.app, this, i, this.d, this.e, (String)localObject1, true, null, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_app_contact")) {
      finish();
    }
  }
  
  private boolean b()
  {
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    Object localObject2 = getIntent().getData();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.queryPhoneContactByMobile(this.jdField_a_of_type_JavaLangString);
    } else {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealWithBindOK | getTargetPhoneContact | uri = ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append(" | mobileNo = ");
      localStringBuilder.append(ContactSyncUtils.b(this.jdField_a_of_type_JavaLangString));
      localStringBuilder.append(" | pc = ");
      boolean bool;
      if (localObject1 != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("ContactSync.JumpActivity", 2, localStringBuilder.toString());
    }
    if (localObject1 != null)
    {
      this.d = ((PhoneContact)localObject1).uin;
      this.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).nationCode;
      this.c = ((PhoneContact)localObject1).mobileCode;
      this.e = ((PhoneContact)localObject1).name;
      this.jdField_b_of_type_Int = ((PhoneContact)localObject1).ability;
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService.getSimplePhoneContactByJumpUri((Uri)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("dealWithBindOK | pc is null | simplePc = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("ContactSync.JumpActivity", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != null)
      {
        this.d = "0";
        this.jdField_b_of_type_JavaLangString = ((SimplePhoneContact)localObject1).jdField_b_of_type_JavaLangString;
        this.c = ((SimplePhoneContact)localObject1).c;
        this.e = ((SimplePhoneContact)localObject1).jdField_a_of_type_JavaLangString;
        this.jdField_b_of_type_Int = ((SimplePhoneContact)localObject1).jdField_a_of_type_Int;
      }
    }
    if (((!TextUtils.isEmpty(this.d)) && (!this.d.equals("0"))) || (!TextUtils.isEmpty(this.c)))
    {
      if (this.f.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat"))
      {
        a();
        return false;
      }
      a(2, null);
      if (NetworkUtil.isNetSupport(this))
      {
        localObject1 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(this.c);
        ((FriendListHandler)localObject1).getOnlineInfo(((StringBuilder)localObject2).toString(), true);
      }
      return true;
    }
    Object localObject1 = String.format(getResources().getString(2131698719), new Object[] { this.e });
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService.deleteSyncContact(this.jdField_a_of_type_JavaLangString);
    a(1, (String)localObject1);
    return true;
  }
  
  boolean a()
  {
    return ((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return a(true);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    setIntent(paramIntent);
    a(true);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    finish();
  }
  
  public void finish()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131365667)
    {
      if (i == 2131365673)
      {
        i = this.jdField_a_of_type_Int;
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
          Intent localIntent = new Intent();
          localIntent.setPackage(getPackageName());
          localIntent.putExtra("IS_ADD_ACCOUNT", true);
          localIntent.putExtra("key_req_by_contact_sync", true);
          localIntent.putExtra("key_uin_to_login", this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIContactSyncService.getSyncAccountUin());
          localIntent.putExtra("key_orginal_intent", getIntent());
          localIntent.addFlags(67108864);
          localIntent.addFlags(536870912);
          RouteUtils.a(this, localIntent, "/base/login");
          finish();
        }
        else if (i == 2)
        {
          b();
        }
        else
        {
          finish();
        }
      }
    }
    else
    {
      i = this.jdField_a_of_type_Int;
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        finish();
      }
      else if (i == 2)
      {
        finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity
 * JD-Core Version:    0.7.0.1
 */