import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONObject;

public class bbdj
{
  private final bbcj a;
  public String a;
  
  public bbdj(bbcj parambbcj)
  {
    this.jdField_a_of_type_Bbcj = parambbcj;
  }
  
  public void a(int paramInt)
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_Bbcj.a();
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    if ((localTouchWebView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
    }
    try
    {
      localJSONObject1.put("code", 0);
      localJSONObject1.put("message", "ok");
      localJSONObject2.put("subIndex", paramInt);
      localJSONObject1.put("data", localJSONObject2);
      localTouchWebView.callJs(WebViewPlugin.toJsScript(this.jdField_a_of_type_JavaLangString, localJSONObject1, null));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbdj
 * JD-Core Version:    0.7.0.1
 */