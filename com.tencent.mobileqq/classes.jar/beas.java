import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

public class beas
  extends QQText
{
  public beas(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public void onURLLinkClicked(View paramView, String paramString)
  {
    paramString = Uri.parse(paramString);
    paramView = paramView.getContext();
    paramString = new Intent("android.intent.action.VIEW", paramString);
    paramString.putExtra("com.android.browser.application_id", paramView.getPackageName());
    try
    {
      paramView.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      QLog.w("OpenDefaultBrowserQQText", 1, "Activity was not found for intent, " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beas
 * JD-Core Version:    0.7.0.1
 */