import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.NewUpgradeDialog.5;
import com.tencent.mobileqq.utils.NewUpgradeDialog.6;
import com.tencent.mobileqq.utils.NewUpgradeDialog.7;
import com.tencent.mobileqq.utils.NewUpgradeDialog.8;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class bdef
  extends bdfq
{
  private static long jdField_a_of_type_Long;
  private static int jdField_b_of_type_Int = 3;
  private static boolean jdField_c_of_type_Boolean;
  private int jdField_a_of_type_Int = 1;
  protected View.OnClickListener a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfka jdField_a_of_type_Bfka;
  public final WeakReference<Activity> a;
  private boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_e_of_type_Boolean;
  TextView f;
  
  public bdef(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bdej(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131559398);
    this.jdField_a_of_type_Bfka = new bdek(this);
    this.jdField_b_of_type_Boolean = bfjt.b();
    bfkb.a();
    setOnKeyListener(new bdeg(this));
    a();
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, jdField_b_of_type_Int, 1, 100));
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, jdField_b_of_type_Int, 2, 100));
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, jdField_b_of_type_Int, 3, 100));
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, jdField_b_of_type_Int, 4, 100));
    bfef.a().a(16, bfeh.a(10010, jdField_b_of_type_Int, 1, 100));
    bfef.a().a(16, bfeh.a(10010, jdField_b_of_type_Int, 2, 100));
    bfef.a().a(16, bfeh.a(10010, jdField_b_of_type_Int, 3, 100));
    bfef.a().a(16, bfeh.a(10010, jdField_b_of_type_Int, 4, 100));
    if (jdField_b_of_type_Int == 2)
    {
      azmj.b(null, "dc00898", "", "", "0X8008F7F", "0X8008F7F", 0, 0, "", "", "", "");
      return;
    }
    azmj.b(null, "dc00898", "", "", "0X8008F82", "0X8008F82", 0, 0, "", "", "", "");
  }
  
  public static String a(double paramDouble, int paramInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt <= 0)
    {
      localStringBuilder.append((int)Math.round(paramDouble));
      return localStringBuilder.toString();
    }
    if ((paramInt == 1) && (paramDouble >= (int)paramDouble + 0.95D)) {
      localStringBuilder.append((int)paramDouble + 1);
    }
    double d1;
    for (;;)
    {
      localStringBuilder.append(".");
      d1 = 1.0D;
      i = 0;
      while (i < paramInt)
      {
        d1 *= 10.0D;
        i += 1;
      }
      localStringBuilder.append((int)paramDouble);
    }
    paramDouble = Math.abs(Math.round((paramDouble - (int)paramDouble) * d1) / d1);
    int i = j;
    while (i < paramInt)
    {
      paramDouble *= 10.0D;
      localStringBuilder.append((int)paramDouble % 10);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(float paramFloat, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(a(paramFloat / 1024.0F / 1024.0F, paramInt));
    if (paramBoolean) {
      return "MB";
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    jdField_c_of_type_Boolean = bdii.a();
    if (jdField_c_of_type_Boolean)
    {
      jdField_b_of_type_Int = 2;
      return;
    }
    jdField_b_of_type_Int = 3;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.f.getPaint().setFakeBoldText(false);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.f.setText(alpo.a(2131707959));
      return;
    case 1: 
    case 20: 
      this.f.setText(alpo.a(2131707971));
      return;
    case 3: 
      this.f.setText(alpo.a(2131707969));
      return;
    case 4: 
      this.f.setText(alpo.a(2131707973));
      return;
    }
    this.f.setText(alpo.a(2131707966));
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long <= 1000L) {
      return false;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject1 = amlp.a().a();
    if ((localObject1 == null) || (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_Amlu == null))
    {
      bfhq.a().a(alpo.a(2131707963));
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("sdkShowNotification", 0);
    localBundle.putBoolean("showNetworkDialog", false);
    localBundle.putString("appName", ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_Amlu.jdField_a_of_type_JavaLangString);
    localBundle.putString("url", ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
    Object localObject2 = String.valueOf(((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
    localBundle.putString("appId", (String)localObject2);
    localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    localBundle.putBoolean("autoInstall", true);
    int j = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_Amlu.jdField_a_of_type_Int;
    int i = j;
    if (j == 999) {
      i = 718;
    }
    localBundle.putInt("versionCode", i);
    localBundle.putString("packageName", BaseApplicationImpl.getApplication().getPackageName());
    localBundle.putInt("downloadType", 1);
    localBundle.putBoolean("autoDownload", true);
    localObject2 = bfkb.a().a((String)localObject2);
    localObject1 = "";
    if (localObject2 != null) {
      localObject1 = ((DownloadInfo)localObject2).l;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new File((String)localObject1);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localBundle.putInt(bfjy.k, 5);
        bfju.a(localBundle, "biz_src_jc_update", amlp.a().a().jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
        return true;
      }
    }
    if ((bfjt.h()) || (bfko.a().g())) {
      ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.7(paramActivity, localBundle));
    }
    for (;;)
    {
      return true;
      UpgradeDetailActivity.a(paramActivity, amlp.a().a(), false, true, true);
    }
  }
  
  public static void b()
  {
    jdField_c_of_type_Boolean = true;
    jdField_b_of_type_Int = 2;
  }
  
  private void e()
  {
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, jdField_b_of_type_Int, 3, 300));
    bfef.a().a(21, bfeh.a(10010, jdField_b_of_type_Int, 3, 300));
    DownloadInfo localDownloadInfo = bfkb.a().a("1101070898");
    bfkb.a().c(localDownloadInfo);
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.5(this));
    i();
    e();
  }
  
  private void g()
  {
    this.jdField_b_of_type_Boolean = bfjt.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!bfhb.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        bfhq.a().a(alpo.a(2131707958));
      }
    }
    else {
      return;
    }
    a(2);
    bfkb.a().a(bfkb.a().a("1101070898"));
  }
  
  private void h()
  {
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, jdField_b_of_type_Int, 3, 200));
    bfef.a().a(17, bfeh.a(10010, jdField_b_of_type_Int, 3, 200));
    if (jdField_b_of_type_Int == 2) {
      azmj.b(null, "dc00898", "", "", "0X8008F81", "0X8008F81", 0, 0, "", "", "", "");
    }
    while (bfko.a().b())
    {
      a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      dismiss();
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      return;
      azmj.b(null, "dc00898", "", "", "0X8008F84", "0X8008F84", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    DownloadInfo localDownloadInfo = bfkb.a().a("1101070898");
    this.jdField_b_of_type_Boolean = bfjt.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!bfhb.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        bfhq.a().a(alpo.a(2131707960));
        this.jdField_a_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.a() != 4)) {
        a(localDownloadInfo.f, localDownloadInfo.a());
      }
      if ((localDownloadInfo == null) || (localDownloadInfo.a() == 1) || (localDownloadInfo.a() == 10) || (localDownloadInfo.a() == 3) || (localDownloadInfo.a() == 4))
      {
        bfhg.b("NewUpgradeDialog", bfeh.a(10010, jdField_b_of_type_Int, 3, 500));
        bfef.a().a(18, bfeh.a(10010, jdField_b_of_type_Int, 3, 500));
        bfko.a().a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "ANDROIDQQ.NEWYYB.QQUPDATE", true);
      }
    }
    for (;;)
    {
      bfkb.a().a(this.jdField_a_of_type_Bfka);
      return;
      ThreadManager.post(new NewUpgradeDialog.6(this), 5, null, false);
    }
  }
  
  private void i()
  {
    int j = 0;
    Object localObject = amlp.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_Amlu == null))
    {
      bfhq.a().a(alpo.a(2131707968));
      return;
    }
    int k = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_Amlu.jdField_a_of_type_Int;
    int i = k;
    if (k == 999) {
      i = 718;
    }
    try
    {
      k = BaseActivity.sTopActivity.getPackageManager().getPackageInfo(BaseActivity.sTopActivity.getPackageName(), 0).versionCode;
      j = k;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Bundle localBundle;
        localNameNotFoundException.printStackTrace();
      }
    }
    localObject = "tmast://appdetails?r=0.9138136501079244&pname=com.tencent.mobileqq&oplist=1%3B2&via=ANDROIDQQ.NEWYYB.QQUPDATE&appid=" + ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid + "&versioncode=" + i + "&hostpname=" + BaseApplicationImpl.getApplication().getPackageName() + "&hostversioncode=" + j + "\"\n";
    localBundle = new Bundle();
    localBundle.putString("url", (String)localObject);
    bfju.a(localBundle);
    bfju.b(localBundle);
    bfko.a().a();
    k();
  }
  
  private void j()
  {
    this.f.getPaint().setFakeBoldText(true);
    this.f.setText(alpo.a(2131707962));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
  }
  
  private void k()
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = amlp.a().a();
    if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (localUpgradeDetailWrapper.jdField_a_of_type_Amlu == null))
    {
      bfhq.a().a(alpo.a(2131707961));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("sdkShowNotification", 0);
    localBundle.putBoolean("showNetworkDialog", false);
    localBundle.putString("appName", localUpgradeDetailWrapper.jdField_a_of_type_Amlu.jdField_a_of_type_JavaLangString);
    localBundle.putString("url", localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
    localBundle.putString("appId", String.valueOf(localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid));
    localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    localBundle.putBoolean("autoInstall", true);
    int j = localUpgradeDetailWrapper.jdField_a_of_type_Amlu.jdField_a_of_type_Int;
    int i = j;
    if (j == 999) {
      i = 718;
    }
    localBundle.putInt("versionCode", i);
    localBundle.putString("packageName", "com.tencent.mobileqq");
    localBundle.putInt("downloadType", 1);
    localBundle.putBoolean("autoDownload", true);
    ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.8(this, localBundle));
  }
  
  public bdef a(long paramLong)
  {
    String str = a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131707965) + str);
    }
    return this;
  }
  
  public bdef a(DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new bdei(this, paramOnClickListener, paramBoolean));
    return this;
  }
  
  public bdef a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 100;
    bfhg.c("NewUpgradeDialog", "updateView--progress--" + paramInt1 + " state = " + paramInt2);
    this.jdField_a_of_type_Int = paramInt2;
    a(paramInt2);
    if (paramInt2 == 4) {
      paramInt1 = 100;
    }
    for (;;)
    {
      if (paramInt1 < 0)
      {
        this.jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
        paramInt1 = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          return;
          if (paramInt1 >= 100)
          {
            this.jdField_a_of_type_Boolean = false;
            paramInt1 = i;
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          return;
        }
      }
    }
  }
  
  public bdef b(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
    return this;
  }
  
  public bdef c(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
    paramCharSequence = new SpannableString("推荐使用\"省流升级\",通过QQ官方下载器\"应用宝\"升级,节省流量速度更快");
    paramCharSequence.setSpan(new ForegroundColorSpan(Color.parseColor("#0099EE")), 21, 24, 17);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    return this;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = bfjt.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!bfhb.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        bfhq.a().a(alpo.a(2131707970));
      }
    }
    else {
      return;
    }
    a(3);
    bfkb.a().a("1101070898");
  }
  
  public void d()
  {
    DownloadInfo localDownloadInfo = bfkb.a().a("1101070898");
    if ((localDownloadInfo != null) && (localDownloadInfo.a() == 2)) {
      bfkb.a().a("1101070898");
    }
  }
  
  public void dismiss()
  {
    try
    {
      if (this.jdField_a_of_type_Int != 2)
      {
        this.jdField_d_of_type_Boolean = false;
        bfkb.a().b(this.jdField_a_of_type_Bfka);
        this.jdField_a_of_type_Bfka = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365235));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379148));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365231));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379144));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365220));
    this.f = ((TextView)findViewById(2131365226));
    this.f.setVisibility(0);
    this.f.getPaint().setFakeBoldText(true);
    this.f.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372312));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368084));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bdeh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdef
 * JD-Core Version:    0.7.0.1
 */