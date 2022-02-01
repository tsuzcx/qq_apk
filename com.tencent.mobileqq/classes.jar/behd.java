import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.lang.ref.WeakReference;

public class behd
  extends ClickableSpan
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public behd(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramView != null) {
      paramView.startActivity(new Intent(paramView, QQBrowserActivity.class).putExtra("url", this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behd
 * JD-Core Version:    0.7.0.1
 */