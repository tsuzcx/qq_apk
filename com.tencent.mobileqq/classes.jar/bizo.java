import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import cooperation.qqreader.QRReaderPageProxyActivity;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.js.JsCallParams;
import cooperation.qqreader.proxy.ReaderJsPluginProxy;
import cooperation.qqreader.ui.ReaderHomePageActivity;

public class bizo
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bizd jdField_a_of_type_Bizd = new bizp(this);
  private bizt jdField_a_of_type_Bizt;
  private JsCallParams jdField_a_of_type_CooperationQqreaderJsJsCallParams;
  
  public bizo(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private Intent a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QRReaderPageProxyActivity.class);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtras(paramActivity.getIntent());
    localIntent.putExtra("readerDpcConfig", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|0|0|0|0|0"));
    return localIntent;
  }
  
  private Intent a(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = false;
    String str1 = paramBundle.getString("readtype");
    int i = -1;
    if (!TextUtils.isEmpty(str1)) {
      i = Integer.valueOf(str1).intValue();
    }
    switch (i)
    {
    case 17: 
    case 18: 
    case 19: 
    case 21: 
    case 22: 
    case 23: 
    case 28: 
    case 29: 
    case 30: 
    default: 
      paramActivity = null;
    }
    for (;;)
    {
      paramBundle = paramActivity;
      if (paramActivity == null)
      {
        paramBundle = new Intent();
        paramBundle.setClass(this.jdField_a_of_type_AndroidAppActivity, ReaderHomePageActivity.class);
        paramBundle.putExtras(biyw.a(paramBundle, 1));
      }
      paramBundle.putExtra("params_remote_connect_at_launch", true);
      return paramBundle;
      paramActivity = a(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", paramBundle.getString("nbid"));
      paramActivity.putExtra("com.qqreader.pureader.YW_BOOK_ID", paramBundle.getString("id"));
      paramActivity.putExtra("ChannelSrc2", paramBundle.getString("group_code"));
      if (!TextUtils.equals(paramBundle.getString("stay"), "1")) {
        bool = true;
      }
      paramActivity.putExtra("is_return_to_home_page", bool);
      continue;
      paramActivity = a(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", paramBundle.getString("book_new_id"));
      paramActivity.putExtra("is_from_conversation", paramBundle.getBoolean("is_from_conversation", false));
      continue;
      paramActivity = a(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", paramBundle.getString("nbid"));
      paramActivity.putExtra("com.qqreader.pureader.YW_BOOK_ID", paramBundle.getString("bid"));
      paramActivity.putExtra("com.qqreader.pureader.CHAPTER_ID", paramBundle.getString("cid"));
      if (!TextUtils.equals(paramBundle.getString("stay"), "1")) {}
      for (bool = true;; bool = false)
      {
        paramActivity.putExtra("is_return_to_home_page", bool);
        paramActivity.putExtra("is_from_conversation", paramBundle.getBoolean("is_from_conversation", false));
        if (paramBundle.getBoolean("recent_note", false)) {
          ChannelIdHelper.setChannelId("100336");
        }
        paramActivity.setFlags(67108864);
        break;
      }
      paramActivity = a(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", paramBundle.getString("nbid"));
      paramActivity.putExtra("com.qqreader.pureader.YW_BOOK_ID", paramBundle.getString("bid"));
      paramActivity.putExtra("com.qqreader.pureader.CHAPTER_ID", paramBundle.getString("cid"));
      paramActivity.putExtra("com.qqreader.pureader.IN_BOOKSHELF", paramBundle.getString("inBookShelf"));
      ChannelIdHelper.setChannelId(paramBundle);
      paramActivity.setFlags(67108864);
      continue;
      paramActivity = a(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.FILE_PATH", paramBundle.getString("com.qqreader.pureader.FILE_PATH"));
      paramActivity.putExtra("com.qqreader.pureader.EXTRA_KEY_IS_LOCAL", true);
      ChannelIdHelper.setChannelId(paramBundle);
      continue;
      if (!paramBundle.getBoolean("is_from_qreader_shortcut", false))
      {
        paramActivity = null;
      }
      else
      {
        if (!paramBundle.getBoolean("cityshortcut")) {
          break;
        }
        paramBundle = new Intent();
        paramBundle.setClass(paramActivity, ReaderHomePageActivity.class);
        paramBundle.putExtras(biyw.a(paramBundle, 1));
        paramBundle.putExtra("is_from_qreader_shortcut", true);
        paramActivity = paramBundle;
      }
    }
    long l1 = paramBundle.getLong("book_id");
    long l2 = paramBundle.getLong("book_new_id");
    str1 = bdgk.a(paramActivity).a;
    String str2 = bjbq.a(paramActivity);
    if (l2 != 0L) {}
    for (paramBundle = String.valueOf(l2);; paramBundle = "")
    {
      bjbo.a(str1, str2, "2198", paramBundle, "2", "");
      paramActivity = a(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", String.valueOf(l2));
      paramActivity.putExtra("com.qqreader.pureader.YW_BOOK_ID", String.valueOf(l1));
      paramActivity.putExtra("is_return_to_home_page", true);
      paramActivity.putExtra("is_from_qreader_shortcut", true);
      paramActivity.setFlags(67108864);
      break;
    }
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    localImageView.setBackgroundColor(-1);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRelativeLayout.addView(localImageView);
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    localTextView.setText(2131694097);
    localTextView.setTextColor(-16777216);
    localTextView.setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    localTextView.setPadding(0, bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 120.0F), 0, 0);
    localRelativeLayout.addView(localTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    bizw.a().a(this.jdField_a_of_type_AndroidAppActivity, localImageView);
    return localRelativeLayout;
  }
  
  private void a(Intent paramIntent)
  {
    boolean bool = bjat.a();
    bjbl.e("ReaderSplashImpl", "jumpToPlugin: isUseShadow = " + bool);
    if (bool)
    {
      bjat.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent, "com.qqreader.pureader.SSReaderActivity", new bizr(this));
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    bizc.a().a(this.jdField_a_of_type_Bizd);
    a(a());
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      bjbl.a("ReaderSplashImpl", "showLoadingView: mContentView == null");
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView);
  }
  
  private void a(JsCallParams paramJsCallParams)
  {
    if (bizc.a().a())
    {
      ReaderJsPluginProxy localReaderJsPluginProxy = bizc.a().a(new bizq(this));
      if (localReaderJsPluginProxy != null) {
        localReaderJsPluginProxy.call(paramJsCallParams.a(), paramJsCallParams.b(), paramJsCallParams.c(), paramJsCallParams.a());
      }
      for (;;)
      {
        d();
        return;
        bjbl.a("ReaderSplashImpl", "checkPluginForHandleSpecialJsCall: plugin is ready but jsPluginProxy is null");
      }
    }
    this.jdField_a_of_type_CooperationQqreaderJsJsCallParams = paramJsCallParams;
    bizc.a().a(this.jdField_a_of_type_Bizd);
    a(a());
  }
  
  private void b(@NonNull Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      bjbl.a("ReaderSplashImpl", "doJump: activity is null");
    }
    Intent localIntent;
    do
    {
      return;
      if (paramBundle.getBoolean("is_from_qreader_shortcut")) {
        paramBundle.putString("readtype", String.valueOf(26));
      }
      localIntent = a(this.jdField_a_of_type_AndroidAppActivity, paramBundle);
    } while (localIntent == null);
    localIntent.putExtra("launch_by_splash", true);
    localIntent.putExtra("login_interval", bjbq.a(BaseApplicationImpl.getApplication()));
    if (localIntent.getStringExtra("ChannelSrc2") == null) {
      localIntent.putExtra("ChannelSrc2", paramBundle.getString("ChannelSrc2"));
    }
    if ((localIntent.getComponent() != null) && ("cooperation.qqreader.ui.ReaderHomePageActivity".equals(localIntent.getComponent().getClassName())))
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      d();
      return;
    }
    localIntent.putExtra("is_from_splash_activity", true);
    localIntent.putExtra("com.qqreader.pureader.START_TIME", System.currentTimeMillis());
    a(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentIntent == null)
    {
      bjbl.a("ReaderSplashImpl", "handlePendingJumpPluginIntent: mPendingJumpPluginIntent == null");
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (this.jdField_a_of_type_AndroidAppActivity.isDestroyed())))
    {
      bjbl.b("ReaderSplashImpl", "handlePendingJumpPluginIntent: activity is destroyed");
      return;
    }
    biyw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, "com.qqreader.pureader.SSReaderActivity", new bizs(this));
    this.jdField_a_of_type_AndroidContentIntent = null;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    bjbl.d("ReaderSplashImpl", "onCreate");
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("cooperation.qqreader.start_reader_act_completed");
    if (this.jdField_a_of_type_Bizt == null)
    {
      this.jdField_a_of_type_Bizt = new bizt(this, null);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_Bizt, (IntentFilter)localObject);
    }
    localObject = (JsCallParams)this.jdField_a_of_type_AndroidOsBundle.getParcelable("splash_pending_js_param");
    if (localObject != null)
    {
      a((JsCallParams)localObject);
      return;
    }
    b(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bizt != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_Bizt);
      this.jdField_a_of_type_Bizt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bizo
 * JD-Core Version:    0.7.0.1
 */