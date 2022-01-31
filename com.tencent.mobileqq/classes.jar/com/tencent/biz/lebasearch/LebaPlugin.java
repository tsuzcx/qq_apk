package com.tencent.biz.lebasearch;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import kpk;
import org.json.JSONException;
import org.json.JSONObject;

public class LebaPlugin
  extends WebViewPlugin
{
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  public BusinessObserver a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public String a;
  QQCustomDialog b = null;
  
  public LebaPlugin()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new kpk(this);
    this.mPluginNameSpace = "lebaPlugin";
  }
  
  private void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if ((this.mRuntime.a() == null) || (this.mRuntime.a().isFinishing())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.createPluginSetDialogForWeb(this.mRuntime.a(), this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, paramInt, paramLong, paramString1, paramString2);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = paramVarArgs[0];
    if (paramString3 == null) {
      return false;
    }
    if (paramString3.equals("showOpenDialog")) {}
    for (;;)
    {
      long l;
      try
      {
        paramString1 = new JSONObject(paramJsBridgeListener);
        l = paramString1.optLong("id", -1L);
        paramJsBridgeListener = paramString1.optString("msg");
        paramString1 = paramString1.optString("callback");
        if (l != -1L)
        {
          paramString2 = new Bundle();
          paramString2.putInt("reqCode", 10000);
          paramString2.putLong("uiResId", l);
          paramString2.putString("msg", paramJsBridgeListener);
          paramString2.putString("callback", paramString1);
          paramString2.putInt("dialogType", 1);
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(18, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        continue;
      }
      return true;
      if (paramString3.equals("getPluginStatus")) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
          l = paramJsBridgeListener.optLong("id", -1L);
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (l == -1L) {
            continue;
          }
          paramString1 = new Bundle();
          paramString1.putInt("reqCode", 10002);
          paramString1.putLong("uiResId", l);
          paramString1.putString("callback", paramJsBridgeListener);
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(18, paramString1, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      } else if (paramString3.equals("search")) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener).optString("keyWord");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            if (this.mRuntime.a() != null) {}
            SearchUtils.a("hot_list", "clk_hot_list", new String[] { paramJsBridgeListener });
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaPlugin
 * JD-Core Version:    0.7.0.1
 */