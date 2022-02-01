import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import mqq.util.WeakReference;

final class bkis
  extends ClickableSpan
{
  private WeakReference<Context> a;
  
  private bkis(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  public void onClick(@NonNull View paramView)
  {
    paramView = (Context)this.a.get();
    if (paramView != null)
    {
      Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", "https://support.qq.com/product/36028");
      paramView.startActivity(localIntent);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkis
 * JD-Core Version:    0.7.0.1
 */