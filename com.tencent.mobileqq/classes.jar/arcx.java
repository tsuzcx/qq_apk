import android.content.Context;
import android.content.Intent;
import com.tencent.kwstudio.office.preview.IHostInterface.IWebClient;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public final class arcx
  extends WebViewClient
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final IHostInterface.IWebClient jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IWebClient;
  
  private arcx(Context paramContext, IHostInterface.IWebClient paramIWebClient)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IWebClient = paramIWebClient;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IWebClient == null) || (!this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IWebClient.onPageFinished(paramWebView, paramString))) {
      super.onPageFinished(paramWebView, paramString);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IWebClient == null) || (!this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IWebClient.shouldOverrideUrlLoading(paramWebView, paramString)))
    {
      paramWebView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
      paramWebView.putExtra("param_force_internal_browser", true);
      paramWebView.putExtra("url", paramString);
      aeif.a(this.jdField_a_of_type_AndroidContentContext, paramWebView, paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcx
 * JD-Core Version:    0.7.0.1
 */