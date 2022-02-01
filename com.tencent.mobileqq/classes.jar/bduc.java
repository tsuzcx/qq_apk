import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.ui.PttSttItemAnimator.1;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bduc
{
  public int a;
  private volatile SpannableString jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private WeakReference<ahdf> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public bduc() {}
  
  public bduc(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = paramMessageForPtt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private int a()
  {
    int i = BaseApplicationImpl.getContext().getResources().getColor(2131167011);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (!this.jdField_a_of_type_JavaLangRefWeakReference.isEnqueued()))
    {
      ahdf localahdf = (ahdf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localahdf != null) && (localahdf.jdField_a_of_type_AndroidWidgetTextView != null)) {
        return localahdf.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor();
      }
    }
    return i;
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramString);
    if (this.jdField_a_of_type_AndroidTextSpannableString.length() > 0) {
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(a()), 0, this.jdField_a_of_type_AndroidTextSpannableString.length(), 17);
    }
    f();
  }
  
  public static boolean a(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {}
    while ((paramMessageForPtt.sttAbility == 3) || (!paramMessageForPtt.expandStt)) {
      return false;
    }
    return paramMessageForPtt.getSttResult().a();
  }
  
  private int b()
  {
    return ColorUtils.setAlphaComponent(a(), 128);
  }
  
  private void b(String paramString)
  {
    c(paramString);
    g();
  }
  
  public static boolean b(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {}
    while ((paramMessageForPtt.getSttResult().a() == 4) || ((!StringUtil.isEmpty(paramMessageForPtt.sttText)) && (!paramMessageForPtt.getSttResult().a()))) {
      return true;
    }
    return false;
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return;
      i = paramString.length();
      if (i <= 0)
      {
        this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
        return;
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        if (i >= 2)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramString.substring(0, 2));
          this.jdField_b_of_type_Int += 2;
          return;
        }
        this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
        return;
      }
    } while (this.jdField_b_of_type_Int < 2);
    if (i - this.jdField_b_of_type_Int >= 2)
    {
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramString.substring(0, this.jdField_b_of_type_Int + 2));
      this.jdField_b_of_type_Int += 2;
      return;
    }
    if (i % 2 == 0) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramString.substring(0, i));
      this.jdField_b_of_type_Int = i;
      return;
      i -= 1;
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void g()
  {
    int i = this.jdField_a_of_type_AndroidTextSpannableString.length();
    if (i <= 0) {}
    do
    {
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(a()), 0, i, 17);
        return;
      }
      if (i == 2)
      {
        this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(b()), 0, 2, 17);
        return;
      }
    } while (i < 4);
    int j = this.jdField_b_of_type_Int + 2 - 3;
    this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(a()), 0, j, 17);
    this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(b()), j, i, 17);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((ahdf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_AndroidTextSpannableString, this.jdField_a_of_type_Int);
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((ahdf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, a(), this.jdField_a_of_type_Int);
    }
  }
  
  public SpannableString a()
  {
    return this.jdField_a_of_type_AndroidTextSpannableString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(ahdf paramahdf)
  {
    if (paramahdf != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramahdf);
    }
  }
  
  public void a(Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    paramHandler.post(new PttSttItemAnimator.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult() == null))
    {
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a();
    switch (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a())
    {
    default: 
      return;
    case 2: 
      b(str);
      return;
    }
    a(str);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    h();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ahdf localahdf = (ahdf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localahdf.jdField_a_of_type_AndroidWidgetProgressBar != null)
      {
        localahdf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localahdf.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt_PttSttItemAnimator", 2, "stt repush, progress appear again");
        }
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduc
 * JD-Core Version:    0.7.0.1
 */