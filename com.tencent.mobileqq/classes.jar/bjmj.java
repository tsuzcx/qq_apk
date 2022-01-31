import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.share.FilterComboSharePlugin.4;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bjmj
  extends WebViewPlugin
  implements AdapterView.OnItemClickListener
{
  int jdField_a_of_type_Int;
  public anqq a;
  private bbjq jdField_a_of_type_Bbjq;
  private bcqf jdField_a_of_type_Bcqf;
  public String a;
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this.mRuntime.a(), this.mRuntime.a().getResources().getDimensionPixelSize(2131298865));
    }
    this.jdField_a_of_type_Bcqf.show();
    Bundle localBundle = new Bundle();
    localBundle.putString("k_f_id", paramString);
    localBundle.putInt("k_s_t", paramInt);
    localBundle.putString("k_ms", "getSharePic");
    localBundle = anqu.a("ipc_f_c_s", null, this.jdField_a_of_type_Anqq.key, localBundle);
    anvq.a().a(localBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FilterComboShare", 2, "requestSharePic" + paramString + " " + paramInt);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("k_f_id", paramString);
    localBundle.putString("k_ms", "notifyResult");
    localBundle.putBoolean("k_r", paramBoolean);
    paramString = anqu.a("ipc_f_c_s", null, this.jdField_a_of_type_Anqq.key, localBundle);
    anvq.a().a(paramString);
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().postDelayed(new FilterComboSharePlugin.4(this), 250L);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterComboShare", 2, "onresp " + paramBoolean + " type" + paramInt);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("result", paramBoolean);
      callJs("respShareResult", new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = this.mRuntime.a().getIntent().getStringExtra("k_f_id");
    if (paramString3.equals("showShareSheet")) {
      if (this.jdField_a_of_type_Bbjq == null)
      {
        this.jdField_a_of_type_Bbjq = new bbjq(this.mRuntime.a());
        this.jdField_a_of_type_Bbjq.a(BaseApplicationImpl.getApplication().getString(2131719508));
        paramJsBridgeListener = new ArrayList();
        paramString1 = new bbjs();
        paramString1.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696716);
        paramString1.jdField_b_of_type_Int = 2130838758;
        paramString1.c = 9;
        paramString1.jdField_b_of_type_JavaLangString = "";
        paramJsBridgeListener.add(paramString1);
        paramString1 = new bbjs();
        paramString1.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696699);
        paramString1.jdField_b_of_type_Int = 2130838752;
        paramString1.c = 10;
        paramString1.jdField_b_of_type_JavaLangString = "";
        paramJsBridgeListener.add(paramString1);
        paramString1 = new bbjs();
        paramString1.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696713);
        paramString1.jdField_b_of_type_Boolean = true;
        paramString1.jdField_b_of_type_Int = 2130838757;
        paramString1.c = 12;
        paramString1.jdField_b_of_type_JavaLangString = "";
        paramJsBridgeListener.add(paramString1);
        paramJsBridgeListener = (List[])new ArrayList[] { paramJsBridgeListener };
        this.jdField_a_of_type_Bbjq.a(paramJsBridgeListener);
        this.jdField_a_of_type_Bbjq.a(this);
      }
    }
    while (!"closeSharePage".equals(paramString3)) {
      try
      {
        this.jdField_a_of_type_Bbjq.a();
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("FilterComboShare", 2, "actionSheet.show exception=" + paramJsBridgeListener);
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterComboShare", 2, "closeSharePage");
    }
    this.mRuntime.a().finish();
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  public void onCreate()
  {
    super.onCreate();
    anvq.a().a(this.jdField_a_of_type_Anqq);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    anvq.a().b(this.jdField_a_of_type_Anqq);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("FilterComboShare", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    paramView = this.mRuntime.a().getIntent().getStringExtra("k_f_id");
    this.jdField_a_of_type_Bbjq.b();
    int j = ((bbjv)paramAdapterView).a.c;
    this.jdField_a_of_type_Int = j;
    if ((j == 10) || (j == 9)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720667;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        wij.a(0, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131720918;
        }
      }
      else
      {
        if (j == 10) {}
        for (paramInt = i;; paramInt = 0)
        {
          a(paramView, paramInt);
          return;
          if (j != 12) {
            break;
          }
          a(paramView, j);
          return;
        }
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjmj
 * JD-Core Version:    0.7.0.1
 */