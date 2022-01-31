import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import java.lang.ref.SoftReference;

public class anji
  extends ClickableSpan
{
  public anji(MessageForQQWalletTips paramMessageForQQWalletTips, String paramString, SoftReference paramSoftReference, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      paramView = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    } while (paramView == null);
    Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramView.startActivity(localIntent);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anji
 * JD-Core Version:    0.7.0.1
 */