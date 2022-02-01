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
  Dialog a = null;
  int b;
  private IPhoneContactService c;
  private IContactSyncService d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j;
  private String k;
  private ChatActivityUtils.StartVideoListener l = new ContactSyncJumpActivity.1(this);
  private FriendListObserver m = new ContactSyncJumpActivity.2(this);
  private Handler n = new ContactSyncJumpActivity.3(this);
  private DialogInterface.OnCancelListener o = new ContactSyncJumpActivity.4(this);
  private ContactBindObserver p = new ContactSyncJumpActivity.5(this);
  
  private Dialog a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131627374);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431915);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431902);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131431900);
    TextView localTextView4 = (TextView)localReportDialog.findViewById(2131431907);
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
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showAlertDialog | type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" | current type = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("ContactSync.JumpActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      this.a = null;
    }
    this.b = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          this.a = e();
        }
      }
      else {
        this.a = a(2131896679, paramString, 0, 2131896678);
      }
    }
    else {
      this.a = a(2131896690, paramString, 2131896688, 2131896689);
    }
    paramString = this.a;
    if (paramString != null)
    {
      paramString.setOnCancelListener(this.o);
      this.a.show();
    }
  }
  
  private boolean a(int paramInt)
  {
    String str1 = this.d.getSyncAccountUin();
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
      localObject = getResources().getString(2131896692);
    } else {
      localObject = getResources().getString(2131896691);
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
      int i1;
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
          this.c = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class));
          this.d = ((IContactSyncService)this.app.getRuntimeService(IContactSyncService.class));
          try
          {
            this.k = this.d.getMimeTypeByJumpUri(getIntent().getData());
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.JumpActivity", 2, "doJump | e = ", localException1);
            }
          }
          Object localObject2;
          if ((this.k != null) && ((this.k.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) || (this.k.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile"))))
          {
            this.e = this.d.getMobileNoByJumpUri(getIntent().getData());
            i1 = this.c.getSelfBindState();
            localObject2 = this.d.getSyncAccountUin();
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("doJump | check user is login | bind state is ");
              localStringBuilder.append(i1);
              localStringBuilder.append(" | currentUin = ");
              localStringBuilder.append(ContactSyncUtils.a(this.app.getCurrentAccountUin()));
              localStringBuilder.append(" | syncUin = ");
              localStringBuilder.append(ContactSyncUtils.a((String)localObject2));
              QLog.d("ContactSync.JumpActivity", 2, localStringBuilder.toString());
            }
            if ((i1 != 0) || (!((String)localObject2).equals(this.app.getCurrentAccountUin()))) {
              break label762;
            }
            return b();
            if ((!this.c.isBindContactOk()) && (!((String)localObject2).equals(this.app.getCurrentAccountUin()))) {
              return a(i1);
            }
            return b();
            return a(i1);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doJump | error mimeType = ");
            ((StringBuilder)localObject2).append(this.k);
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
      label762:
      if ((i1 != 5) && (i1 != 1)) {
        if (i1 != 0) {}
      }
    }
  }
  
  private boolean b()
  {
    this.app.registObserver(this.p);
    Object localObject2 = getIntent().getData();
    if (!TextUtils.isEmpty(this.e)) {
      localObject1 = this.c.queryPhoneContactByMobile(this.e);
    } else {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealWithBindOK | getTargetPhoneContact | uri = ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append(" | mobileNo = ");
      localStringBuilder.append(ContactSyncUtils.b(this.e));
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
      this.h = ((PhoneContact)localObject1).uin;
      this.f = ((PhoneContact)localObject1).nationCode;
      this.g = ((PhoneContact)localObject1).mobileCode;
      this.i = ((PhoneContact)localObject1).name;
      this.j = ((PhoneContact)localObject1).ability;
    }
    else
    {
      localObject1 = this.d.getSimplePhoneContactByJumpUri((Uri)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("dealWithBindOK | pc is null | simplePc = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("ContactSync.JumpActivity", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != null)
      {
        this.h = "0";
        this.f = ((SimplePhoneContact)localObject1).b;
        this.g = ((SimplePhoneContact)localObject1).c;
        this.i = ((SimplePhoneContact)localObject1).a;
        this.j = ((SimplePhoneContact)localObject1).d;
      }
    }
    if (((!TextUtils.isEmpty(this.h)) && (!this.h.equals("0"))) || (!TextUtils.isEmpty(this.g)))
    {
      if (this.k.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat"))
      {
        c();
        return false;
      }
      a(2, null);
      if (NetworkUtil.isNetSupport(this))
      {
        localObject1 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.app.addObserver(this.m);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.f);
        ((StringBuilder)localObject2).append(this.g);
        ((FriendListHandler)localObject1).getOnlineInfo(((StringBuilder)localObject2).toString(), true);
      }
      return true;
    }
    Object localObject1 = String.format(getResources().getString(2131896677), new Object[] { this.i });
    this.d.deleteSyncContact(this.e);
    a(1, (String)localObject1);
    return true;
  }
  
  private void c()
  {
    ReportController.b(this.app, "CliOper", "", "", "System_contact", "Contact_msg", 0, 0, "", "", "", "");
    if (!this.h.equals("0"))
    {
      localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtra("uin", this.h);
      localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).m(this.h);
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
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(this.g);
    localIntent.putExtra("uin", ((StringBuilder)localObject).toString());
    localIntent.putExtra("uintype", 1006);
    localIntent.putExtra("uinname", this.i);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(this.g);
    localObject = new AllInOne(((StringBuilder)localObject).toString(), 31);
    ((AllInOne)localObject).contactArray = new ArrayList();
    ((AllInOne)localObject).contactName = this.i;
    ((AllInOne)localObject).contactArray.add(new ProfileContactInfo(this.i, this.g, this.f));
    ((AllInOne)localObject).chatAbility = this.j;
    ((AllInOne)localObject).profileEntryType = 59;
    localIntent.putExtra("AIO_INFO", (Parcelable)localObject);
    localIntent.putExtra("key_req_by_contact_sync", true);
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    Object localObject2 = this.h;
    Object localObject1 = "0";
    boolean bool = ((String)localObject2).equals("0") ^ true;
    localObject2 = this.app;
    if (!bool) {
      localObject1 = "3";
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "16", (String)localObject1, "", "");
    int i1;
    if (bool) {
      bool = false;
    } else {
      i1 = 1006;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).append(this.g);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (ChatActivityUtils.a(this.app, this, i1, this.h, this.i, (String)localObject1, true, null, true, true, this.l, "from_app_contact")) {
      finish();
    }
  }
  
  private Dialog e()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131627375);
    Object localObject2 = (ImageView)localReportDialog.findViewById(2131431897);
    if (this.h.equals("0"))
    {
      localObject1 = this.app;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.f);
      ((StringBuilder)localObject3).append(this.g);
      localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 11, ((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject1 = FaceDrawable.getFaceDrawable(this.app, 1, this.h);
    }
    ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
    Object localObject3 = (TextView)localReportDialog.findViewById(2131431903);
    Object localObject1 = (TextView)localReportDialog.findViewById(2131431912);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131431900);
    localObject2 = (TextView)localReportDialog.findViewById(2131431907);
    ((TextView)localObject3).setText(this.i);
    localTextView.setText(2131896688);
    localTextView.setOnClickListener(this);
    ((TextView)localObject2).setText(String.format(getResources().getString(2131896683), new Object[] { "" }));
    if (NetworkUtil.isNetSupport(this))
    {
      localObject3 = getResources().getDrawable(2130839590);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject3, null, null, null);
      ((TextView)localObject1).setCompoundDrawablePadding(10);
      ((Animatable)localObject3).start();
      ((TextView)localObject2).setOnClickListener(this);
      return localReportDialog;
    }
    ((TextView)localObject1).setText(2131896685);
    ((TextView)localObject2).setTextColor(getResources().getColor(2131165998));
    ((TextView)localObject2).setEnabled(false);
    return localReportDialog;
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
    this.n.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.m);
    this.app.unRegistObserver(this.p);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.n.removeCallbacksAndMessages(null);
    this.app.unRegistObserver(this.p);
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
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Intent localIntent;
    if (i1 != 2131431900)
    {
      if (i1 != 2131431907) {
        break label181;
      }
      i1 = this.b;
      if (i1 == 0)
      {
        this.a.dismiss();
        localIntent = new Intent();
        localIntent.setPackage(getPackageName());
        localIntent.putExtra("IS_ADD_ACCOUNT", true);
        localIntent.putExtra("key_req_by_contact_sync", true);
        localIntent.putExtra("key_uin_to_login", this.d.getSyncAccountUin());
      }
    }
    try
    {
      localIntent.putExtra("key_orginal_intent", getIntent());
      label99:
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      RouteUtils.a(this, localIntent, "/base/login");
      finish();
      break label181;
      if (i1 == 2)
      {
        d();
      }
      else
      {
        finish();
        break label181;
        i1 = this.b;
        if (i1 == 0)
        {
          this.a.dismiss();
          finish();
        }
        else if (i1 == 2)
        {
          finish();
        }
      }
      label181:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label99;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity
 * JD-Core Version:    0.7.0.1
 */