package com.tencent.biz.webviewplugin;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class OfflinePlugin$3
  implements AsyncBack
{
  OfflinePlugin$3(OfflinePlugin paramOfflinePlugin, JsBridgeListener paramJsBridgeListener) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("retcode", -1);
        paramString.put("msg", "error");
        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("OfflinePlugin, batchCheckUpdate, JSONException :");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("OfflinePluginQQ", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    Object localObject = Message.obtain();
    ((Message)localObject).what = 121;
    ((Message)localObject).obj = new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, paramString };
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.3
 * JD-Core Version:    0.7.0.1
 */