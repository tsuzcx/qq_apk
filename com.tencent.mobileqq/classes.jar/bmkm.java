import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvWebPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "callJsOnFail", "", "callback", "", "errMsg", "handleGetPreloadGdtAd", "arg", "handleInitDeviceInfo", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "handleRewardVideo", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmkm
  extends WebViewPlugin
{
  public static final bmkn a = new bmkn(null);
  
  public bmkm()
  {
    bmkk.a.a().a(null);
  }
  
  private final void a(String paramString)
  {
    Object localObject2 = new JSONObject(paramString);
    String str2 = ((JSONObject)localObject2).getString("callback");
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new bmol(null, null, null, null, null, null, null, 127, null);
        Object localObject3 = ((JSONObject)localObject2).getString("adv_pos");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "jsonObj.getString(\"adv_pos\")");
        localObject1 = ((bmol)localObject1).a(Integer.parseInt((String)localObject3));
        localObject3 = ((JSONObject)localObject2).getString("reward_type");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "jsonObj.getString(\"reward_type\")");
        localObject1 = ((bmol)localObject1).b(Integer.parseInt((String)localObject3));
        localObject3 = ((JSONObject)localObject2).optString("reward_item");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "jsonObj.optString(\"reward_item\")");
        localObject3 = ((bmol)localObject1).a((String)localObject3);
        localObject1 = (CharSequence)((JSONObject)localObject2).optString("reward_text");
        if (((CharSequence)localObject1).length() == 0)
        {
          i = 1;
          break label364;
          localObject3 = ((bmol)localObject3).b((String)localObject1);
          localObject1 = (CharSequence)((JSONObject)localObject2).optString("biz_src_id");
          if (((CharSequence)localObject1).length() == 0)
          {
            i = 1;
            break label373;
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "jsonObj.optString(\"biz_s…fEmpty { Source.SRC_VIP }");
            localObject3 = ((bmol)localObject3).d((String)localObject1);
            localObject1 = (CharSequence)((JSONObject)localObject2).optString("gdt_biz_id");
            if (((CharSequence)localObject1).length() != 0) {
              continue;
            }
            i = 1;
            if (i != 0) {
              localObject1 = bmkk.a.a().a();
            }
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "jsonObj.optString(\"gdt_b…ort.get().vasGdtBizId() }");
            localObject1 = ((bmol)localObject3).c((String)localObject1).a();
            localObject2 = new bmko(this, str2);
            localObject3 = this.mRuntime;
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "mRuntime");
            localObject3 = ((bifw)localObject3).a();
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "mRuntime.activity");
            new bmom((Activity)localObject3, (bmok)localObject1, (bmoj)localObject2).a();
          }
        }
        else
        {
          i = 0;
          break label364;
        }
        i = 0;
        break label373;
        i = 0;
        continue;
        if (i == 0) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Intrinsics.checkExpressionValueIsNotNull(str2, "jsCallback");
        a(str2, localThrowable.getMessage());
        QLog.e("VasAdvWebPlugin", 1, "invalid arg:" + paramString, localThrowable);
        return;
      }
      label364:
      String str1 = null;
      continue;
      label373:
      if (i != 0) {
        str1 = "biz_src_jc_vip";
      }
    }
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString1))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("returnCode", -1);
      localJSONObject.put("errorMsg", paramString2);
      callJs(paramString1, new String[] { localJSONObject.toString(0) });
    }
  }
  
  private final void b(String paramString)
  {
    paramString = new JSONObject(paramString);
    String str = paramString.getString("callback");
    try
    {
      paramString = (CharSequence)paramString.optString("gdt_biz_id");
      if (paramString.length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          paramString = bmkk.a.a().a();
        }
        paramString = (String)paramString;
        bmkk.a.a().a(paramString);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      Intrinsics.checkExpressionValueIsNotNull(str, "jsCallback");
      a(str, paramString.getMessage());
      QLog.e("VasAdvWebPlugin", 1, "handleInitDeviceInfo", paramString);
    }
  }
  
  private final void c(String paramString)
  {
    Object localObject1 = new JSONObject(paramString);
    String str = ((JSONObject)localObject1).getString("callback");
    try
    {
      localObject1 = ((JSONObject)localObject1).getString("businessId");
      Object localObject2 = bmny.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "businessId");
      localObject1 = ((bmoa)localObject2).a((String)localObject1);
      localObject2 = new JSONObject();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((JSONObject)localObject2).put("returnCode", 0);
        ((JSONObject)localObject2).put("data", new JSONObject().put("preloadAd", localObject1));
      }
      for (;;)
      {
        callJs(str, new String[] { ((JSONObject)localObject2).toString(0) });
        return;
        ((JSONObject)localObject2).put("returnCode", -1);
        ((JSONObject)localObject2).put("errorMsg", "preload ad is null");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Intrinsics.checkExpressionValueIsNotNull(str, "jsCallback");
      a(str, localThrowable.getMessage());
      QLog.e("VasAdvWebPlugin", 1, "handleGetPreloadGdtAd failed :" + paramString + ' ', localThrowable);
    }
  }
  
  public boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (QLog.isColorLevel()) {
      QLog.d("VasAdvWebPlugin", 2, "handleJsRequest -> url : " + paramString1 + ",pkgName : " + paramString2 + ",method : " + paramString3 + ",args[0 : " + paramVarArgs[0]);
    }
    if ((Intrinsics.areEqual("vasAdv", paramString2) ^ true)) {
      return false;
    }
    String str = (String)ArraysKt.firstOrNull(paramVarArgs);
    boolean bool;
    if (str != null) {
      if (paramString3 == null) {
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      switch (paramString3.hashCode())
      {
      default: 
        break;
      case -1091552849: 
        if (!paramString3.equals("showRewardAD")) {
          break;
        }
        a(str);
        bool = true;
        break;
      case -1091160153: 
        if (!paramString3.equals("getPreloadGdtAd")) {
          break;
        }
        c(str);
        bool = true;
        break;
      case 1696532820: 
        if (!paramString3.equals("initDeviceInfo")) {
          break;
        }
        b(str);
        bool = true;
        continue;
        bool = super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkm
 * JD-Core Version:    0.7.0.1
 */