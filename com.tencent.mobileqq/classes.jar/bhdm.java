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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.5;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.6;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.7;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.8;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class bhdm
  extends bhpc
{
  private static long jdField_a_of_type_Long;
  private static int jdField_b_of_type_Int = 3;
  private static boolean jdField_c_of_type_Boolean;
  private int jdField_a_of_type_Int = 1;
  protected View.OnClickListener a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener;
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
  
  public bhdm(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bhdq(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131559518);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new bhdr(this);
    this.jdField_b_of_type_Boolean = bjwj.b();
    bjwq.a();
    setOnKeyListener(new bhdn(this));
    a();
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, jdField_b_of_type_Int, 1, 100));
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, jdField_b_of_type_Int, 2, 100));
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, jdField_b_of_type_Int, 3, 100));
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, jdField_b_of_type_Int, 4, 100));
    bjqw.a().a(16, bjqy.a(10010, jdField_b_of_type_Int, 1, 100));
    bjqw.a().a(16, bjqy.a(10010, jdField_b_of_type_Int, 2, 100));
    bjqw.a().a(16, bjqy.a(10010, jdField_b_of_type_Int, 3, 100));
    bjqw.a().a(16, bjqy.a(10010, jdField_b_of_type_Int, 4, 100));
    if (jdField_b_of_type_Int == 2)
    {
      bdll.b(null, "dc00898", "", "", "0X8008F7F", "0X8008F7F", 0, 0, "", "", "", "");
      return;
    }
    bdll.b(null, "dc00898", "", "", "0X8008F82", "0X8008F82", 0, 0, "", "", "", "");
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
    jdField_c_of_type_Boolean = bhrv.a();
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
      this.f.setText(anzj.a(2131706455));
      return;
    case 1: 
    case 20: 
      this.f.setText(anzj.a(2131706467));
      return;
    case 3: 
      this.f.setText(anzj.a(2131706465));
      return;
    case 4: 
      this.f.setText(anzj.a(2131706469));
      return;
    }
    this.f.setText(anzj.a(2131706462));
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long <= 1000L) {
      return false;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject1 = bhdu.a().a();
    if ((localObject1 == null) || (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_Bhdz == null))
    {
      bjuh.a().a(anzj.a(2131706459));
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("sdkShowNotification", 0);
    localBundle.putBoolean("showNetworkDialog", false);
    localBundle.putString("appName", ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_Bhdz.jdField_a_of_type_JavaLangString);
    localBundle.putString("url", ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
    Object localObject2 = String.valueOf(((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
    localBundle.putString("appId", (String)localObject2);
    localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    localBundle.putBoolean("autoInstall", true);
    int j = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_Bhdz.jdField_a_of_type_Int;
    int i = j;
    if (j == 999) {
      i = 718;
    }
    localBundle.putInt("versionCode", i);
    localBundle.putString("packageName", BaseApplicationImpl.getApplication().getPackageName());
    localBundle.putInt("downloadType", 1);
    localBundle.putBoolean("autoDownload", true);
    localObject2 = bjwq.a().a((String)localObject2);
    localObject1 = "";
    if (localObject2 != null) {
      localObject1 = ((DownloadInfo)localObject2).l;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new File((String)localObject1);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localBundle.putInt(bjwo.k, 5);
        bjwk.a(localBundle, "biz_src_jc_update", bhdu.a().a().jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
        return true;
      }
    }
    if ((bjwj.h()) || (bjxd.a().g())) {
      ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.7(paramActivity, localBundle));
    }
    for (;;)
    {
      return true;
      UpgradeDetailActivity.a(paramActivity, bhdu.a().a(), false, true, true);
    }
  }
  
  public static void b()
  {
    jdField_c_of_type_Boolean = true;
    jdField_b_of_type_Int = 2;
  }
  
  private void e()
  {
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, jdField_b_of_type_Int, 3, 300));
    bjqw.a().a(21, bjqy.a(10010, jdField_b_of_type_Int, 3, 300));
    DownloadInfo localDownloadInfo = bjwq.a().a("1101070898");
    bjwq.a().c(localDownloadInfo);
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.5(this));
    i();
    e();
  }
  
  private void g()
  {
    this.jdField_b_of_type_Boolean = bjwj.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!bjts.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        bjuh.a().a(anzj.a(2131706454));
      }
    }
    else {
      return;
    }
    a(2);
    bjwq.a().a(bjwq.a().a("1101070898"));
  }
  
  private void h()
  {
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, jdField_b_of_type_Int, 3, 200));
    bjqw.a().a(17, bjqy.a(10010, jdField_b_of_type_Int, 3, 200));
    if (jdField_b_of_type_Int == 2) {
      bdll.b(null, "dc00898", "", "", "0X8008F81", "0X8008F81", 0, 0, "", "", "", "");
    }
    while (bjxd.a().b())
    {
      a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      dismiss();
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      return;
      bdll.b(null, "dc00898", "", "", "0X8008F84", "0X8008F84", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    DownloadInfo localDownloadInfo = bjwq.a().a("1101070898");
    this.jdField_b_of_type_Boolean = bjwj.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!bjts.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        bjuh.a().a(anzj.a(2131706456));
        this.jdField_a_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.a() != 4)) {
        a(localDownloadInfo.f, localDownloadInfo.a());
      }
      if ((localDownloadInfo == null) || (localDownloadInfo.a() == 1) || (localDownloadInfo.a() == 10) || (localDownloadInfo.a() == 3) || (localDownloadInfo.a() == 4))
      {
        bjtx.b("NewUpgradeDialog", bjqy.a(10010, jdField_b_of_type_Int, 3, 500));
        bjqw.a().a(18, bjqy.a(10010, jdField_b_of_type_Int, 3, 500));
        bjxd.a().a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "ANDROIDQQ.NEWYYB.QQUPDATE", true);
      }
    }
    for (;;)
    {
      bjwq.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
      return;
      ThreadManager.post(new NewUpgradeDialog.6(this), 5, null, false);
    }
  }
  
  private void i()
  {
    int j = 0;
    Object localObject = bhdu.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_Bhdz == null))
    {
      bjuh.a().a(anzj.a(2131706464));
      return;
    }
    int k = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_Bhdz.jdField_a_of_type_Int;
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
    bjwk.a(localBundle);
    bjwk.b(localBundle);
    bjxd.a().a();
    k();
  }
  
  private void j()
  {
    this.f.getPaint().setFakeBoldText(true);
    this.f.setText(anzj.a(2131706458));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
  }
  
  private void k()
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = bhdu.a().a();
    if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (localUpgradeDetailWrapper.jdField_a_of_type_Bhdz == null))
    {
      bjuh.a().a(anzj.a(2131706457));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("sdkShowNotification", 0);
    localBundle.putBoolean("showNetworkDialog", false);
    localBundle.putString("appName", localUpgradeDetailWrapper.jdField_a_of_type_Bhdz.jdField_a_of_type_JavaLangString);
    localBundle.putString("url", localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
    localBundle.putString("appId", String.valueOf(localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid));
    localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    localBundle.putBoolean("autoInstall", true);
    int j = localUpgradeDetailWrapper.jdField_a_of_type_Bhdz.jdField_a_of_type_Int;
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
  
  public bhdm a(long paramLong)
  {
    String str = a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131706461) + str);
    }
    return this;
  }
  
  public bhdm a(DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new bhdp(this, paramOnClickListener, paramBoolean));
    return this;
  }
  
  public bhdm a(CharSequence paramCharSequence)
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
    bjtx.c("NewUpgradeDialog", "updateView--progress--" + paramInt1 + " state = " + paramInt2);
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
  
  public bhdm b(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
    return this;
  }
  
  public bhdm c(CharSequence paramCharSequence)
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
    this.jdField_b_of_type_Boolean = bjwj.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!bjts.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        bjuh.a().a(anzj.a(2131706466));
      }
    }
    else {
      return;
    }
    a(3);
    bjwq.a().a("1101070898");
  }
  
  public void d()
  {
    DownloadInfo localDownloadInfo = bjwq.a().a("1101070898");
    if ((localDownloadInfo != null) && (localDownloadInfo.a() == 2)) {
      bjwq.a().a("1101070898");
    }
  }
  
  public void dismiss()
  {
    try
    {
      if (this.jdField_a_of_type_Int != 2)
      {
        this.jdField_d_of_type_Boolean = false;
        bjwq.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365523));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380316));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365519));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380312));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365508));
    this.f = ((TextView)findViewById(2131365514));
    this.f.setVisibility(0);
    this.f.getPaint().setFakeBoldText(true);
    this.f.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373039));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368494));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bhdo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdm
 * JD-Core Version:    0.7.0.1
 */