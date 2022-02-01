package com.tencent.gdtad.basics.motivevideo.elements;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext;

public class GdtMvElementsHelper
{
  public static final Pattern a = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  
  public static String a(GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = HardCodeUtil.a(2131705300);
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramGdtMotiveVideoModel.a();
    Object localObject2 = paramGdtMotiveVideoModel.a();
    Object localObject1 = str;
    if (localObject2 != null) {
      if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).ext.is_app_preorder.get())
      {
        localObject1 = HardCodeUtil.a(2131692843);
      }
      else
      {
        localObject1 = str;
        if (!((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info.button_info.get().isEmpty())
        {
          str = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info.button_info.get(0)).txt.get();
          localObject2 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info.app_package_name.get();
          int i;
          if (!TextUtils.isEmpty(str))
          {
            localObject1 = str;
            if (!a(paramGdtMotiveVideoModel)) {
              break label204;
            }
            localObject1 = str;
            if (!GdtUtil.a(localBaseApplication, (String)localObject2)) {
              break label204;
            }
            if (localGdtMotiveVideoPageData.isStyleC()) {
              i = 2131705295;
            } else {
              i = 2131705296;
            }
          }
          for (paramGdtMotiveVideoModel = HardCodeUtil.a(i);; paramGdtMotiveVideoModel = HardCodeUtil.a(i))
          {
            localObject1 = paramGdtMotiveVideoModel;
            break label204;
            if (!a(paramGdtMotiveVideoModel)) {
              break;
            }
            if (GdtUtil.a(localBaseApplication, (String)localObject2)) {
              i = 2131705297;
            } else {
              i = 2131705299;
            }
          }
          localObject1 = HardCodeUtil.a(2131705301);
        }
      }
    }
    label204:
    paramGdtMotiveVideoModel = new StringBuilder();
    paramGdtMotiveVideoModel.append("getContentStr:");
    paramGdtMotiveVideoModel.append((String)localObject1);
    GdtLog.b("GdtMvElementsHelper", paramGdtMotiveVideoModel.toString());
    return localObject1;
  }
  
  public static boolean a(GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    paramGdtMotiveVideoModel = paramGdtMotiveVideoModel.a();
    return (paramGdtMotiveVideoModel.productType == 12) || (paramGdtMotiveVideoModel.productType == 19);
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = Uri.parse(paramString);
        paramString = ((Uri)localObject2).getPath();
        Object localObject1 = a.matcher(paramString);
        if (!((Matcher)localObject1).matches())
        {
          QLog.i("GdtMvElementsHelper", 1, "callJs !matcher.matches()");
          return;
        }
        paramString = ((Matcher)localObject1).group(1);
        localObject1 = ((Matcher)localObject1).group(3);
        Object localObject3 = ((Uri)localObject2).getQueryParameter("q");
        localObject2 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("action", paramString);
        ((JSONObject)localObject2).put("data", localJSONObject);
        ((JSONObject)localObject2).put("code", 0);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          paramString = new JSONObject((String)localObject3).optString("bridgeName");
          if (!TextUtils.isEmpty(paramString))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("callbackid", localObject1);
            ((JSONObject)localObject3).put("status", 0);
            ((JSONObject)localObject3).put("data", ((JSONObject)localObject2).toString());
            ((JSONObject)localObject3).put("keep", 1);
            localObject1 = new StringBuffer();
            ((StringBuffer)localObject1).append(paramString);
            ((StringBuffer)localObject1).append("(");
            ((StringBuffer)localObject1).append(((JSONObject)localObject3).toString());
            ((StringBuffer)localObject1).append(")");
            paramString = new StringBuilder();
            paramString.append("callJs script: ");
            paramString.append(((StringBuffer)localObject1).toString());
            QLog.i("GdtMvElementsHelper", 1, paramString.toString());
            paramWebView.evaluateJavascript(((StringBuffer)localObject1).toString(), new GdtMvElementsHelper.1(this));
            return;
          }
        }
      }
      catch (Exception paramWebView)
      {
        QLog.e("GdtMvElementsHelper", 1, "doOpenMain", paramWebView);
        return;
      }
      paramString = "bridge.callback";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsHelper
 * JD-Core Version:    0.7.0.1
 */