import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import org.json.JSONException;
import org.json.JSONObject;

public class atbp
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new atbz(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new atby(this, Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atao jdField_a_of_type_Atao = new atbu(this);
  bety jdField_a_of_type_Bety;
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  String d;
  String e = null;
  String f = null;
  String g = null;
  String h = null;
  String i = null;
  
  public atbp(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      this.jdField_c_of_type_JavaLangString = "checkVersion";
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      Object localObject2 = atam.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_JavaLangString);
      String str1 = this.d;
      String str2 = this.e;
      String str3 = this.h;
      String str4 = this.jdField_c_of_type_JavaLangString;
      String str5 = this.e;
      Object localObject1;
      if (this.f == null)
      {
        localObject1 = "";
        ((atam)localObject2).a(str1, str2, "", str3, 0, str4, "", "", str5, (String)localObject1, this.jdField_a_of_type_Atao);
        return;
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        atcg.a.a(40, String.valueOf(this.jdField_a_of_type_Boolean));
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("huiyin").opName("download").d1(String.valueOf(bdin.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))).d2(String.valueOf(this.jdField_a_of_type_Boolean)).report();
        if (this.f == null) {}
      }
      try
      {
        localObject1 = new JSONObject(this.f);
        ((JSONObject)localObject1).put("startTS", System.currentTimeMillis());
        this.f = ((JSONObject)localObject1).toString();
        label211:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("huiyin").opName("launch");
        if (bdin.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
        {
          localObject1 = "1";
          label242:
          localObject2 = ((IVPluginDataReporter)localObject2).d1((String)localObject1);
          if (!this.jdField_c_of_type_Boolean) {
            break label291;
          }
          localObject1 = "1";
          label258:
          localObject2 = ((IVPluginDataReporter)localObject2).d2((String)localObject1);
          if (!this.jdField_a_of_type_Boolean) {
            break label297;
          }
        }
        label291:
        label297:
        for (localObject1 = "1";; localObject1 = "2")
        {
          ((IVPluginDataReporter)localObject2).d3((String)localObject1).report();
          break;
          localObject1 = "2";
          break label242;
          localObject1 = "2";
          break label258;
        }
        localObject1 = this.f;
      }
      catch (Exception localException)
      {
        break label211;
      }
    }
  }
  
  private void c()
  {
    if (!bdin.g(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
    {
      atcg.a.a(32, null);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131706045));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131706049));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidAppActivity.findViewById(16908290).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new atbr(this));
      return;
    }
    atad.a(this.d, new atbs(this));
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidAppActivity.setContentView(2131561056);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131372368));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131367433));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131365422));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131372332));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131372360));
    this.jdField_a_of_type_AndroidAppActivity.findViewById(16908290).setVisibility(8);
    this.jdField_a_of_type_AndroidAppActivity.findViewById(2131367846).setOnClickListener(new atbq(this));
  }
  
  public void a(Bundle paramBundle)
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("huiyin");
    this.h = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("uin");
    this.f = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("extra");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("preloadOnly", false);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    paramBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("param_general");
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.e = paramBundle.optString("opentype");
      this.g = paramBundle.optString("uri");
      this.jdField_b_of_type_JavaLangString = paramBundle.optString("notifyJsCallback");
      this.jdField_c_of_type_JavaLangString = paramBundle.optString("action");
      this.jdField_a_of_type_JavaLangString = paramBundle.optString("pluginPackageName");
      this.i = paramBundle.optString("pluginData");
      this.d = paramBundle.optString("appType");
      c();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      this.jdField_b_of_type_Long = 0L;
      if (this.jdField_a_of_type_Boolean)
      {
        atcg.a.a(20, null);
        paramBundle = new IntentFilter();
        paramBundle.addAction("close.activity");
        paramBundle.addAction("close.loading");
        this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        atcg.a.a(30, null);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbp
 * JD-Core Version:    0.7.0.1
 */