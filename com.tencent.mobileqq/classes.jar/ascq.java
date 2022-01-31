import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption.8;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption.9;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;

public abstract class ascq
  extends aryv
  implements bfic
{
  protected static final Object a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ascr(this);
  protected Handler a;
  public aryj a;
  ascy jdField_a_of_type_Ascy = new ascy(this);
  protected ascz a;
  public AbsShareMsg a;
  private HandlerPlus jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  protected BusinessObserver a;
  public long b;
  @SuppressLint({"HandlerLeak"})
  private Handler b;
  protected zhh b;
  protected long c;
  public int d;
  protected String h;
  protected String i;
  protected boolean i;
  protected String j = "";
  public boolean j;
  public String k;
  protected boolean k;
  protected boolean l;
  public boolean m;
  volatile boolean n = false;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public ascq(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_a_of_type_MqqObserverBusinessObserver = new ascu(this);
    this.jdField_b_of_type_AndroidOsHandler = new ascx(this);
  }
  
  private void L()
  {
    try
    {
      bfnj.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static final void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    long l1 = 0L;
    if ((paramActivity == null) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = paramIntent.getBundleExtra("share_data");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramIntent.getExtras();
      }
      paramIntent = "shareToQzone";
      if (localObject1 != null)
      {
        localObject2 = ((Bundle)localObject1).getString("share_action");
        paramIntent = (Intent)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramIntent = "shareToQzone";
        }
      }
      if (localObject1 != null) {
        l1 = ((Bundle)localObject1).getLong("req_share_id", 0L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + l1 + " action=" + "shareToQzone");
      }
      localObject2 = new Intent();
      if (paramBoolean)
      {
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l1), paramIntent })));
        bjdt.c((Intent)localObject2);
        if (localObject1 == null) {}
      }
      try
      {
        ((Intent)localObject2).setPackage(((Bundle)localObject1).getString("pkg_name"));
        try
        {
          paramActivity.startActivity((Intent)localObject2);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity, new Object[0]);
        return;
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(l1), paramIntent })));
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          ((Intent)localObject2).setPackage(null);
        }
      }
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, new Object[] { "sdk_share:sdk callback=", Boolean.valueOf(paramBoolean), " appid=", Long.valueOf(paramLong), " action=", paramString });
      }
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), paramString })));
        if (paramActivity.getIntent() != null)
        {
          String str = paramActivity.getIntent().getStringExtra("pkg_name");
          paramString = str;
          if (!TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        paramString = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
        return;
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString })));
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramLong + " action=" + paramString1);
      }
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt), paramString2 })));
        if (paramActivity.getIntent() != null)
        {
          paramString2 = paramActivity.getIntent().getStringExtra("pkg_name");
          paramString1 = paramString2;
          if (!TextUtils.isEmpty(paramString2)) {}
        }
      }
      try
      {
        paramString1 = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString1);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
        return;
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString1 })));
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
  }
  
  private void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      aseh.a(paramString, paramBundle, paramBoolean);
    }
  }
  
  private void e(String paramString)
  {
    if (this.jdField_c_of_type_Boolean) {
      aseh.a(paramString);
    }
  }
  
  private boolean q()
  {
    if ((!this.jdField_c_of_type_Boolean) || (!this.n) || (this.jdField_a_of_type_Aryj == null)) {
      return false;
    }
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    if ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      str = this.jdField_a_of_type_Aryj.e();
      this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", str);
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.updateCover(str);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(2);
      }
      QLog.i("ForwardSdkBaseOption", 1, "checkAndUseAppIcon|use app icon:" + str);
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "18");
      if (TextUtils.isEmpty(str)) {}
      for (str = "1";; str = "0")
      {
        ((Bundle)localObject).putString("intext_1", str);
        bfhz.a().a((Bundle)localObject, "" + this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
        return true;
      }
    }
    return false;
  }
  
  private boolean r()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("req_type");
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "QQShare find local image shareType:", Integer.valueOf(i1) });
    if ((i1 == 5) && (!TextUtils.isEmpty(str)) && (!str.startsWith("http://")) && (!str.startsWith("https://")))
    {
      boolean bool = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext);
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getExternalFilesDir(null);
      if (localObject != null) {}
      for (localObject = ((File)localObject).getAbsolutePath();; localObject = "")
      {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "QQShare find local image hasSDPermission:", Boolean.valueOf(bool), ", localImageUrl:", str, ",appSpecificPath=", localObject });
        if ((bool) || (TextUtils.isEmpty((CharSequence)localObject)) || (str.contains((CharSequence)localObject)) || (this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
          break;
        }
        localObject = new asct(this);
        bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 233, alud.a(2131720808), alud.a(2131720039), -1, 2131720038, (DialogInterface.OnClickListener)localObject, null).show();
        return true;
      }
    }
    return false;
  }
  
  protected void G()
  {
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("desc");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("...")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("..."));
      }
    }
    localObject2 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject3;
      if (((String)localObject3).endsWith("...")) {
        localObject2 = ((String)localObject3).substring(0, ((String)localObject3).lastIndexOf("..."));
      }
    }
    localObject3 = localObject1;
    if (ndp.a((String)localObject1, "UTF-8") > 80) {
      localObject3 = ndp.a((String)localObject1, 80, "UTF-8", null);
    }
    localObject1 = localObject2;
    if (ndp.a((String)localObject2, "UTF-8") > 130) {
      localObject1 = ndp.a((String)localObject2, 130, "UTF-8", null);
    }
    if ((localObject3 != null) && (!((String)localObject3).endsWith("...")) && (!((String)localObject3).equals(this.jdField_a_of_type_AndroidOsBundle.getString("title")))) {}
    for (localObject2 = (String)localObject3 + "...";; localObject2 = localObject3)
    {
      if ((localObject1 != null) && (!((String)localObject1).endsWith("...")) && (!((String)localObject1).equals(this.jdField_a_of_type_AndroidOsBundle.getString("desc")))) {
        localObject1 = (String)localObject1 + "...";
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("title", (String)localObject2);
        this.jdField_a_of_type_AndroidOsBundle.putString("desc", (String)localObject1);
        return;
      }
    }
  }
  
  public final void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, new Object[] { "-->getQQAccountSKey--send g_t_n_p, account = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
    }
    if (this.jdField_c_of_type_Boolean)
    {
      String str = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_k_of_type_JavaLangString = str;
        this.m = true;
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "-->getQQAccountSKey--use TicketManager cache, account = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
        return;
      }
    }
    e("KEY_SSO_GET_TICKET_NO_PASSWD");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4096, this.jdField_a_of_type_Ascy);
  }
  
  void I()
  {
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    if ((this.jdField_a_of_type_Zhh != null) && (this.jdField_a_of_type_Zhh.isShowing())) {
      this.jdField_a_of_type_Zhh.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, new Object[] { "asyncUploadImageAndSendToBuddy mForwardSubType=", Integer.valueOf(this.d) });
    }
    if (this.j != null) {
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", this.j);
    }
    if (this.d != 5)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      if (!azuw.a((String)localObject))
      {
        K();
        return;
      }
      a(2131692315);
      ThreadManager.post(new ForwardSdkBaseOption.8(this, (String)localObject), 8, null, false);
      return;
    }
    a(2131692315);
    Object localObject = new ForwardSdkBaseOption.9(this);
    if (QLog.isDevelopLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 4, "ThreadManager.post asyncUploadImageAndSendToBuddy");
    }
    ThreadManager.post((Runnable)localObject, 8, null, false);
  }
  
  public void J() {}
  
  public void K()
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "realSendStructMsg mActivity.isFinishing()");
      J();
    }
    Object localObject2;
    label286:
    do
    {
      return;
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "realSendStructMsg, mForwardSubType = ", Integer.valueOf(this.d) });
      x();
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1) != 2) {
        break;
      }
      localObject1 = azvd.a(this.jdField_a_of_type_AndroidOsBundle);
      ((AbsStructMsg)localObject1).forwardID = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0);
      if (f())
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target").iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject2).next();
          AbsShareMsg.sendSdkShareMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AbsShareMsg)localObject1, ((ResultRecord)localObject3).a, ((ResultRecord)localObject3).a(), ((ResultRecord)localObject3).c);
        }
      }
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
      AbsShareMsg.sendSdkShareMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AbsShareMsg)localObject1, (String)localObject2, i1, (String)localObject3);
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_share2qq", 1, "", "", String.valueOf(this.jdField_b_of_type_Long));
      if (this.d != 5) {
        break label645;
      }
      localObject1 = "connect_sharepic";
      ndq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, (String)localObject1, "send", this.jdField_b_of_type_Long, f(), String.valueOf(i1));
      a(0, "", "");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "83");
      ((Bundle)localObject1).putString("intext_1", "" + bfif.a(this.d));
      ((Bundle)localObject1).putString("intext_2", "" + bfif.a(i1, (String)localObject2));
      ((Bundle)localObject1).putString("intext_3", "0");
      bfhz.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    } while ((!this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty((CharSequence)localObject1)));
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "55");
    if (this.jdField_a_of_type_Aryj == null) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_Aryj.a())
    {
      ((Bundle)localObject1).putString("intext_1", "" + i1);
      ((Bundle)localObject1).putString("app_id", "" + this.jdField_b_of_type_Long);
      bfhz.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      return;
      localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, MessageShareActivity.class);
      localObject2 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
      }
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).setFlags(67108864);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
      break;
      label645:
      localObject1 = "connect_share2qq";
      break label286;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    x();
    if ((paramInt2 == e.intValue()) && (paramInt1 == 0)) {
      this.jdField_k_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Zhh == null)
    {
      this.jdField_a_of_type_Zhh = new zhh(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Zhh.a(new ascs(this));
    }
    for (;;)
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690623);
      Object localObject = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"))) {
        localObject = str + this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      }
      this.jdField_a_of_type_Zhh.a((String)localObject, c());
      this.jdField_a_of_type_Zhh.a(2131692307);
      localObject = this.jdField_a_of_type_Zhh;
      boolean bool;
      if (paramInt1 == 0)
      {
        bool = true;
        label181:
        ((zhh)localObject).a(bool);
        if (paramInt1 != 0) {
          break label227;
        }
        L();
        this.jdField_a_of_type_Zhh.b(null, null);
      }
      try
      {
        this.jdField_a_of_type_Zhh.show();
        return;
        this.jdField_a_of_type_Zhh.dismiss();
        continue;
        bool = false;
        break label181;
        label227:
        if (paramInt1 == 1002) {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!upload image fail---------------------------------");
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Zhh.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131719243), c());
          break;
          if (paramInt1 == 1003) {
            this.jdField_a_of_type_Zhh.a(2131692310);
          } else if (paramInt1 == 1004)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!skey not ready fail---------------------------------");
            }
          }
          else if ((paramInt1 == 1005) && (QLog.isColorLevel())) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!vkey not ready fail---------------------------------");
          }
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "resultDlg.show() failed");
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt >= 0) {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    }
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (!r())
      {
        super.a(paramInt, paramBundle);
        if (paramInt == g.intValue()) {
          this.jdField_a_of_type_Bdjz.setEditLint("");
        }
      }
    } while (paramBundle == null);
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "81");
    localBundle.putString("intext_1", "" + bfif.a(this.d));
    localBundle.putString("intext_2", "" + bfif.a(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
    localBundle.putString("intext_3", "0");
    bfhz.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
      x();
    }
    while (f()) {
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive show forbidden dialog");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    bdjz localbdjz = bdgm.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbdjz.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131720037));
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131720040);
      }
      localbdjz.setMessageWithUrl((String)localObject);
    }
    for (;;)
    {
      localObject = localbdjz.setPositiveButton(2131719922, new ascw(this));
      StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_AndroidAppActivity.getString(2131690623));
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = "";
      }
      ((bdjz)localObject).setNegativeButton(paramString, new ascv(this));
      localbdjz.setCancelable(false);
      localbdjz.show();
      return;
      localbdjz.setMessage(2131720040);
    }
  }
  
  public boolean a()
  {
    super.a();
    this.j = "";
    this.jdField_i_of_type_Boolean = "login".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("jfrom"));
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pkg_name"))) && (!"1103584836".equals(String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id")))) && (!"101735437".equals(String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id"))))) {
      this.jdField_a_of_type_AndroidOsBundle.putLong("req_share_id", 65520L);
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    this.h = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("open_id");
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("share_uin");
    this.d = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    long l2 = ForwardUtils.a(this.jdField_a_of_type_AndroidOsBundle.getString("chSrc"));
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "preloadData|subType=", Integer.valueOf(this.d), ",targetUrl=", str2, ",remoteImg=", localObject2, ",localImg=", str1 });
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!ndd.a((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((String)localObject2).startsWith("//")) {
          continue;
        }
        localObject1 = localObject2;
        str2 = new URL(str2).getProtocol();
        localObject1 = localObject2;
        localObject2 = str2 + ":" + (String)localObject2;
        localObject1 = localObject2;
        this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)localObject2);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        continue;
      }
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "repair invalid img url=", localObject1 });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "80");
      ((Bundle)localObject2).putString("intext_1", "" + bfif.a(this.d));
      ((Bundle)localObject2).putString("intext_3", "0");
      bfhz.a().a((Bundle)localObject2, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      if ((this.d == 5) && (TextUtils.isEmpty(str1)) && (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "-->preloadData--is image share type, but imageUrl and remoteImageUrl are both empty");
        }
        a(-1, alud.a(2131705193), alud.a(2131705205));
      }
      try
      {
        bfnj.a().a(1, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享的图片不存在");
        return false;
        localObject1 = null;
        continue;
        if (((asdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a())
        {
          b("KEY_STAGE_1_TOTAL", true);
          QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "-->preloadData-- null != mAppInfo");
          return true;
        }
        if ((l1 > 0L) && (!"101735437".equals(String.valueOf(l1))))
        {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
          this.l = true;
          long l3 = System.currentTimeMillis() / 1000L;
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = "";
            QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "-->sdk_share, getting appinfo in construct. sign: ", localObject1 });
            if (!(this instanceof asdb))
            {
              a(2131719380);
              this.jdField_b_of_type_Bety.setCancelable(false);
            }
            long l4 = asdt.a();
            e("KEY_GET_APP_INFO");
            zfy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), l1, (String)localObject1, l2, l3, this.jdField_a_of_type_MqqObserverBusinessObserver, (String)localObject2, l4, true);
            return true;
          }
          localObject1 = AgentActivity.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, l3 + "");
          continue;
        }
        if (!(this instanceof asdb)) {
          continue;
        }
        a("", false);
      }
      catch (Exception localException) {}
    }
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      aseh.a(paramString, paramBoolean);
    }
  }
  
  public boolean d()
  {
    return true;
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Aryj.a())
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aryj.a())) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", this.jdField_a_of_type_Aryj.a());
      }
      String str = this.jdField_a_of_type_Aryj.e();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon_big", str);
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aryj.b())) && (this.jdField_b_of_type_Long != Long.parseLong("1103584836"))) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", this.jdField_a_of_type_Aryj.b());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aryj.c())) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", this.jdField_a_of_type_Aryj.c());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aryj.d())) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", this.jdField_a_of_type_Aryj.d());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceIcon = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName)) {
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putByte("struct_share_key_app_info_status", (byte)1);
      q();
    }
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  protected void n()
  {
    if (this.jdField_k_of_type_Boolean) {
      a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", this.jdField_b_of_type_Long);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "back call");
      }
      return;
      a(this.jdField_a_of_type_AndroidAppActivity, false, "shareToQQ", this.jdField_b_of_type_Long);
    }
  }
  
  protected void o()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "send call");
    }
    I();
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "82");
    localBundle.putString("intext_1", "" + bfif.a(this.d));
    localBundle.putString("intext_2", "" + bfif.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
    localBundle.putString("intext_3", "0");
    bfhz.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public void w()
  {
    super.w();
    if ((this.jdField_a_of_type_Zhh != null) && (this.jdField_a_of_type_Zhh.isShowing())) {
      this.jdField_a_of_type_Zhh.dismiss();
    }
    if ((this.jdField_b_of_type_Zhh != null) && (this.jdField_b_of_type_Zhh.isShowing())) {
      this.jdField_b_of_type_Zhh.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascq
 * JD-Core Version:    0.7.0.1
 */