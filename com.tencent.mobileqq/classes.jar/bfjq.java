import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

public class bfjq
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (bfjp)paramMessage.obj;
    } while ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentSmttSdkWebView == null) || (paramMessage.jdField_a_of_type_JavaLangString == null));
    try
    {
      paramMessage.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramMessage.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfjq
 * JD-Core Version:    0.7.0.1
 */