import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import cooperation.qqreader.utils.ReaderSplashActivityUtils.2;
import mqq.os.MqqHandler;

public class bfng
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bfni jdField_a_of_type_Bfni;
  private final ReaderHomePageActivity jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity;
  
  public bfng(ReaderHomePageActivity paramReaderHomePageActivity)
  {
    this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity = paramReaderHomePageActivity;
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity, ReaderHomePageActivity.class);
    localIntent.putExtras(bflh.c(localIntent));
    localIntent.putExtra("params_remote_connect_at_launch", true);
    return localIntent;
  }
  
  private Intent a(Intent paramIntent)
  {
    boolean bool = false;
    Object localObject = null;
    if (paramIntent.getExtras() != null)
    {
      localObject = paramIntent.getStringExtra("readtype");
      int i = -1;
      if (localObject != null) {
        i = Integer.valueOf((String)localObject).intValue();
      }
      switch (i)
      {
      case 17: 
      case 18: 
      case 19: 
      case 21: 
      case 22: 
      case 23: 
      default: 
        paramIntent = a();
        localObject = null;
        if (localObject != null) {
          break;
        }
      }
    }
    for (;;)
    {
      paramIntent.putExtra("params_remote_connect_at_launch", true);
      return paramIntent;
      String str1 = paramIntent.getStringExtra("stay");
      String str2 = paramIntent.getStringExtra("nbid");
      String str3 = paramIntent.getStringExtra("id");
      String str4 = paramIntent.getStringExtra("group_code");
      localObject = bflh.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
      ((Intent)localObject).putExtra("com.qqreader.pureader.BOOK_ID", str2);
      ((Intent)localObject).putExtra("com.qqreader.pureader.YW_BOOK_ID", str3);
      ((Intent)localObject).putExtra("ChannelSrc2", str4);
      if (!TextUtils.equals(str1, "1")) {
        bool = true;
      }
      ((Intent)localObject).putExtra("is_from_splashactivity", bool);
      break;
      str1 = paramIntent.getStringExtra("book_new_id");
      localObject = bflh.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
      ((Intent)localObject).putExtra("com.qqreader.pureader.BOOK_ID", str1);
      ((Intent)localObject).putExtra("is_from_conversation", paramIntent.getBooleanExtra("is_from_conversation", false));
      break;
      str1 = paramIntent.getStringExtra("stay");
      str2 = paramIntent.getStringExtra("bid");
      str3 = paramIntent.getStringExtra("nbid");
      str4 = paramIntent.getStringExtra("cid");
      String str5 = paramIntent.getStringExtra("add");
      localObject = bflh.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
      ((Intent)localObject).putExtra("com.qqreader.pureader.BOOK_ID", str3);
      ((Intent)localObject).putExtra("com.qqreader.pureader.YW_BOOK_ID", str2);
      ((Intent)localObject).putExtra("com.qqreader.pureader.CHAPTER_ID", str4);
      if (!TextUtils.equals(str1, "1")) {}
      for (bool = true;; bool = false)
      {
        ((Intent)localObject).putExtra("is_from_splashactivity", bool);
        ((Intent)localObject).putExtra("com.qq.reader.OnlineTag.web.chapter", true);
        ((Intent)localObject).putExtra("alreadyaddtoshelf", TextUtils.equals(str5, "1"));
        ((Intent)localObject).putExtra("is_from_conversation", paramIntent.getBooleanExtra("is_from_conversation", false));
        if (paramIntent.getBooleanExtra("recent_note", false)) {
          ((Intent)localObject).putExtra("ChannelID", "100336");
        }
        ((Intent)localObject).setFlags(67108864);
        break;
      }
      paramIntent.getStringExtra("stay");
      str1 = paramIntent.getStringExtra("bid");
      str2 = paramIntent.getStringExtra("nbid");
      str3 = paramIntent.getStringExtra("cid");
      str4 = paramIntent.getStringExtra("add");
      paramIntent.getStringExtra("flag");
      str5 = paramIntent.getStringExtra("ChannelID");
      localObject = bflh.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
      ((Intent)localObject).putExtra("com.qqreader.pureader.BOOK_ID", str2);
      ((Intent)localObject).putExtra("com.qqreader.pureader.YW_BOOK_ID", str1);
      ((Intent)localObject).putExtra("com.qqreader.pureader.CHAPTER_ID", str3);
      ((Intent)localObject).putExtra("alreadyaddtoshelf", TextUtils.equals(str4, "1"));
      ((Intent)localObject).putExtra("ChannelID", str5);
      ((Intent)localObject).putExtra("com.qqreader.pureader.IN_BOOKSHELF", paramIntent.getStringExtra("inBookShelf"));
      ((Intent)localObject).setFlags(67108864);
      break;
      localObject = b(paramIntent);
      break;
      paramIntent = a();
      break;
      paramIntent = (Intent)localObject;
    }
  }
  
  private View a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
    localImageView.setBackgroundColor(-1);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLinearLayout.addView(localImageView);
    TextView localTextView = new TextView(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
    localTextView.setText(2131632731);
    localLinearLayout.addView(localTextView);
    bflu.a().a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity, localImageView);
    return localLinearLayout;
  }
  
  private void a(Intent paramIntent)
  {
    if (bfmm.a())
    {
      bfne.d("ReaderSplashActivityUti", "useShadow");
      bfmm.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity, paramIntent, "com.qqreader.pureader", "SSReaderActivity", new bfnh(this));
      return;
    }
    if (QRBridgeUtil.isPluginReady())
    {
      bfne.d("ReaderSplashActivityUti", "pluginReady");
      bflh.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity, paramIntent, "com.qqreader.pureader.SSReaderActivity");
      return;
    }
    this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity.b(false);
    a(a());
    ThreadManager.getUIHandler().postDelayed(new ReaderSplashActivityUtils.2(this, paramIntent), 2000L);
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, localLayoutParams);
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity.addContentView(this.jdField_a_of_type_AndroidViewViewGroup, paramView);
    }
  }
  
  private Intent b(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("is_from_qreader_shortcut")))
    {
      long l2 = localBundle.getLong("book_id");
      long l3 = localBundle.getLong("book_new_id");
      long l1;
      String str1;
      String str2;
      if (bflt.a())
      {
        l1 = l3;
        str1 = babp.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity).a;
        str2 = bfnm.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
        if (l1 == 0L) {
          break label163;
        }
      }
      label163:
      for (paramIntent = String.valueOf(l1);; paramIntent = "")
      {
        bfnk.a(str1, str2, "2198", paramIntent, "2", "");
        if (!localBundle.getBoolean("cityshortcut")) {
          break label170;
        }
        paramIntent = new Intent();
        paramIntent.setClass(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity, ReaderHomePageActivity.class);
        paramIntent.putExtras(bflh.c(paramIntent));
        paramIntent.putExtra("params_remote_connect_at_launch", true);
        paramIntent.putExtra("is_from_qreader_shortcut", true);
        return paramIntent;
        l1 = l2;
        break;
      }
      label170:
      paramIntent = bflh.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
      paramIntent.putExtra("com.qqreader.pureader.BOOK_ID", String.valueOf(l3));
      paramIntent.putExtra("com.qqreader.pureader.YW_BOOK_ID", String.valueOf(l2));
      paramIntent.putExtra("com.qq.reader.OnlineTag.web.chapter", true);
      paramIntent.putExtra("params_remote_connect_at_launch", true);
      paramIntent.putExtra("is_from_qreader_shortcut", true);
      paramIntent.setFlags(67108864);
      return paramIntent;
    }
    return null;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && ((this.jdField_a_of_type_AndroidViewViewGroup.getParent() instanceof ViewGroup))) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity.b(true);
    this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity.finish();
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("RECEIVER_JUMP_SSR_ACTIVITY_COMPLETED");
    this.jdField_a_of_type_Bfni = new bfni(this, null);
    this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity.registerReceiver(this.jdField_a_of_type_Bfni, localIntentFilter);
  }
  
  public boolean a(@NonNull Intent paramIntent)
  {
    new bfmk().a("EVENT_RECORD_ENTER_READER_TIME", null);
    boolean bool = paramIntent.getBooleanExtra("auto_launch", false);
    int i = paramIntent.getIntExtra("from_where", -1);
    long l1 = paramIntent.getLongExtra("click_start_time", 0L);
    long l2 = paramIntent.getLongExtra("qrbright_create_time", 0L);
    long l3 = paramIntent.getLongExtra("install_time", 0L);
    long l4 = paramIntent.getLongExtra("download_time", 0L);
    int j = paramIntent.getIntExtra("plugin_isExist", 0);
    long l5 = paramIntent.getLongExtra("start_plugin_time", 0L);
    long l6 = bfnm.a(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity);
    Object localObject = paramIntent.getStringExtra("ChannelSrc2");
    String str = paramIntent.getStringExtra("ChannelSrc3");
    Bundle localBundle = paramIntent.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("is_from_qreader_shortcut"))) {
      paramIntent.putExtra("readtype", "26");
    }
    paramIntent = a(paramIntent);
    if (paramIntent != null)
    {
      paramIntent.putExtra("launch_by_splash", true);
      paramIntent.putExtra("click_start_time", l1);
      paramIntent.putExtra("qrbright_create_time", l2);
      paramIntent.putExtra("install_time", l3);
      paramIntent.putExtra("download_time", l4);
      paramIntent.putExtra("plugin_isExist", j);
      paramIntent.putExtra("main_launch_time", System.currentTimeMillis());
      paramIntent.putExtra("start_plugin_time", l5);
      paramIntent.putExtra("from_where", i);
      paramIntent.putExtra("auto_launch", bool);
      paramIntent.putExtra("login_interval", l6);
      if (paramIntent.getStringExtra("ChannelSrc2") == null) {
        paramIntent.putExtra("ChannelSrc2", (String)localObject);
      }
      paramIntent.putExtra("ChannelSrc3", str);
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      if (!bflt.a())
      {
        localObject = new Intent(this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity, ForceUserUpdateActivity.class);
        ((Intent)localObject).putExtra("origin_intent", paramIntent);
        this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity.startActivity((Intent)localObject);
        this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity.finish();
        return false;
      }
      if ((this.jdField_a_of_type_AndroidContentIntent.getComponent() != null) && ("cooperation.qqreader.ui.ReaderHomePageActivity".equals(this.jdField_a_of_type_AndroidContentIntent.getComponent().getClassName()))) {
        return true;
      }
      a(this.jdField_a_of_type_AndroidContentIntent);
      return false;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_CooperationQqreaderUiReaderHomePageActivity.unregisterReceiver(this.jdField_a_of_type_Bfni);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfng
 * JD-Core Version:    0.7.0.1
 */