import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class azjy
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<BaseActivity> b;
  
  public azjy(WeakReference<QQAppInterface> paramWeakReference, WeakReference<BaseActivity> paramWeakReference1)
  {
    WeakReference localWeakReference;
    if (a(paramWeakReference1, localWeakReference))
    {
      QLog.e("ClosePCVerifyImpl", 1, "ClosePCVerifyClickableSpan() error: params wrong");
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference1;
    this.b = localWeakReference;
  }
  
  private boolean a()
  {
    return (this.b == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.b.get() == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
  }
  
  private boolean a(WeakReference<QQAppInterface> paramWeakReference, WeakReference<BaseActivity> paramWeakReference1)
  {
    return (paramWeakReference == null) || (paramWeakReference1 == null);
  }
  
  public void onClick(View paramView)
  {
    QLog.d("ClosePCVerifyImpl", 1, "onClick");
    bcef.b(null, "dc00898", "", "", "0X800AE03", "0X800AE03", 0, 0, "", "", "", "");
    if (a())
    {
      QLog.e("ClosePCVerifyImpl", 1, "onClick error: params wrong");
      return;
    }
    paramView = (BaseActivity)this.b.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!NetworkUtil.isNetSupport(paramView))
    {
      QQToast.a(paramView, 1, 2131698646, 1).a();
      QLog.e("ClosePCVerifyImpl", 1, "NetworkError");
      return;
    }
    azjv.a(this.jdField_a_of_type_Azjv, localQQAppInterface, paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    QLog.d("ClosePCVerifyImpl", 1, "updateDrawState");
    if (a())
    {
      QLog.e("ClosePCVerifyImpl", 1, "updateDrawState error: param wrong");
      return;
    }
    paramTextPaint.setColor(((BaseActivity)this.b.get()).getResources().getColor(2131165739));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjy
 * JD-Core Version:    0.7.0.1
 */