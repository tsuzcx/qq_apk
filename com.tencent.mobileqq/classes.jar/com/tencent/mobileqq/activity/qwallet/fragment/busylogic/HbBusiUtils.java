package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.utils.StringUtil;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.pluginshare.HbInfo.BundleInfo;
import org.json.JSONObject;

public class HbBusiUtils
{
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 == 1)
    {
      paramInt1 = i;
      if (paramInt2 == 1) {
        paramInt1 = 0;
      }
      return paramInt1;
    }
    return RedPacketManager.getEnterType(paramInt1);
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString)) {
      i = paramString.replaceAll("[\\u4e00-\\u9fa5]", "aa").length() - paramString.length();
    }
    return i;
  }
  
  public static String a(int paramInt, HbInfo.BundleInfo paramBundleInfo, ConfigLogic paramConfigLogic, String paramString)
  {
    int i = 2;
    if (paramBundleInfo != null)
    {
      int j = QwUtils.a(paramBundleInfo.bus_type, 2);
      i = j;
      if (!StringUtil.a(paramBundleInfo.biz_params)) {
        try
        {
          String str = new JSONObject(paramBundleInfo.biz_params).optString("memo", "");
          paramBundleInfo = str;
          if (a(str) >= 18) {
            paramBundleInfo = str.substring(0, 18) + "...";
          }
          boolean bool = StringUtil.a(paramBundleInfo);
          i = j;
          if (!bool) {
            return paramBundleInfo;
          }
        }
        catch (Exception paramBundleInfo)
        {
          paramBundleInfo.printStackTrace();
          i = j;
        }
      }
    }
    return paramConfigLogic.a(paramInt, i, paramString);
  }
  
  public static String a(EditText paramEditText)
  {
    String str = paramEditText.getText().toString();
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = paramEditText.getHint();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = paramEditText.getResources().getString(2131696794);
      }
    }
    else
    {
      return localObject;
    }
    return ((CharSequence)localObject).toString();
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replaceAll("[\\u4e00-\\u9fa5,，。、 ]", "");
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbBusiUtils
 * JD-Core Version:    0.7.0.1
 */