import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class bjxl
  extends WebViewPlugin
  implements befm
{
  private boolean jdField_a_of_type_Boolean;
  private bjxz[] jdField_a_of_type_ArrayOfBjxz;
  
  public static int a(WebViewPlugin paramWebViewPlugin, begz parambegz, int paramInt)
  {
    parambegz = parambegz.a(parambegz.a());
    int i = paramInt;
    if ((parambegz instanceof beha)) {
      i = ((beha)parambegz).switchRequestCode(paramWebViewPlugin, (byte)paramInt);
    }
    return i;
  }
  
  private void a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ArrayOfBjxz == null) || (this.jdField_a_of_type_ArrayOfBjxz.length == 0))
    {
      this.jdField_a_of_type_ArrayOfBjxz = new bjxz[] { new bjwz(), new bkag(), new bjzg(), new bjxr(), new bjye(), new bjya(), new bjxt(), new bjwq(), new bjxu(), new bjyg(), new bjwr(), new bjwx(), new bjyj(), new bjxn(), new bjxm(), new bjyr(), new bjwu(), new bjze(), new bjzm(), new bjwp(), new bjyx(), new bjxq(), new bjxy(), new bjyy(), new bjwn(), new bjzb(), new bkae(), new bjxd(), new bjxe(), new bjxs(), new bjxo(), new bjxb(), new bjzh(), new bjzn(), new bjys(), new bjzd(), new bjwm(), new bjyc(), new bjwo() };
      bjxz[] arrayOfbjxz = this.jdField_a_of_type_ArrayOfBjxz;
      int j = arrayOfbjxz.length;
      while (i < j)
      {
        arrayOfbjxz[i].a(this);
        i += 1;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    try
    {
      Object localObject = this.mRuntime.a().getIntent();
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("fromQZone", false))) {}
      for (boolean bool = true;; bool = false)
      {
        CustomWebView localCustomWebView = this.mRuntime.a();
        localObject = null;
        if (localCustomWebView != null) {
          localObject = localCustomWebView.getUrl();
        }
        bool = bjvh.a((String)localObject, paramString, bool);
        if (!bool) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneWebViewPlugin", 1, "handleBanUrlOrScheme error", paramString);
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "Qzone", "qzDynamicAlbum", "QZImagePicker", "qzlive", "qqexplive", "qzui", "QzoneUpload", "QzoneAudio", "Qzone", "checkin" };
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    a();
    bjxz[] arrayOfbjxz = this.jdField_a_of_type_ArrayOfBjxz;
    int j = arrayOfbjxz.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfbjxz[i].a(paramString, paramLong);
      if (localObject != null) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934601L) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/sendGift/index.html")) || (paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/gift/mall.html"))))
    {
      paramString = new Intent();
      this.mRuntime.a().setResult(0, paramString);
      this.mRuntime.a().finish();
    }
    label114:
    do
    {
      return true;
      a();
      bjxz[] arrayOfbjxz = this.jdField_a_of_type_ArrayOfBjxz;
      int j = arrayOfbjxz.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label114;
        }
        if (arrayOfbjxz[i].a(paramString, paramLong, paramMap)) {
          break;
        }
        i += 1;
      }
      if ((paramLong == 8589934594L) && (this.jdField_a_of_type_Boolean))
      {
        paramMap = null;
        if (this.mRuntime != null) {
          paramMap = this.mRuntime.a();
        }
        if (paramMap != null) {
          paramMap.clearHistory();
        }
        this.jdField_a_of_type_Boolean = false;
      }
    } while ((1024L == paramLong) && (a(paramString)));
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) && (!paramString2.equals("qzDynamicAlbum")) && (!paramString2.equals("QZImagePicker")) && (!paramString2.equals("qzlive")) && (!paramString2.equals("qzui")) && (!paramString2.equals("QzoneUpload")) && (!paramString2.equals("QzoneAudio")) && (!paramString2.equals("qqexplive")) && (!paramString2.equals("checkin"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneWebViewPlugin", 2, "handleJsRequest pkgName: " + paramString2 + ",method: " + paramString3);
    }
    a();
    bjxz[] arrayOfbjxz = this.jdField_a_of_type_ArrayOfBjxz;
    int j = arrayOfbjxz.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfbjxz[i].a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs)) {
        return true;
      }
      i += 1;
    }
    return bjxh.a(this, this.mRuntime, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    a();
    Object localObject = this.jdField_a_of_type_ArrayOfBjxz;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].a(paramIntent, paramByte, paramInt);
      i += 1;
    }
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt != -1);
      this.mRuntime.a().finish();
      return;
    } while (paramInt != -1);
    try
    {
      localObject = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("cellid");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramIntent);
      localJSONObject.put("uin", localObject);
      dispatchJsEvent("deleteMessageSuccess", localJSONObject, new JSONObject());
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    bjxz[] arrayOfbjxz = this.jdField_a_of_type_ArrayOfBjxz;
    int j = arrayOfbjxz.length;
    int i = 0;
    while (i < j)
    {
      arrayOfbjxz[i].a();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxl
 * JD-Core Version:    0.7.0.1
 */