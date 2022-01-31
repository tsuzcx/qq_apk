import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;

public class atxu
  implements View.OnClickListener, View.OnLongClickListener, behy
{
  private BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atuh jdField_a_of_type_Atuh;
  private atxv jdField_a_of_type_Atxv;
  
  private atxu(TextView paramTextView, atuh paramatuh)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Atuh = paramatuh;
  }
  
  public static void a(TextView paramTextView, String paramString)
  {
    if (paramTextView != null)
    {
      String str = paramTextView.getText().toString();
      atuh localatuh = new atuh(str);
      localatuh.a(paramString, str);
      paramTextView.setOnLongClickListener(new atxu(paramTextView, localatuh));
      paramTextView.setText(paramTextView.getText(), TextView.BufferType.SPANNABLE);
    }
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2, atxv paramatxv)
  {
    if (paramTextView != null)
    {
      atuh localatuh = new atuh(paramString1);
      localatuh.a(paramString2, paramString1);
      paramString1 = new atxu(paramTextView, localatuh);
      paramString1.a(paramatxv);
      paramTextView.setOnLongClickListener(paramString1);
      paramTextView.setText(paramTextView.getText(), TextView.BufferType.SPANNABLE);
    }
  }
  
  private void a(atxv paramatxv)
  {
    this.jdField_a_of_type_Atxv = paramatxv;
  }
  
  private void a(String paramString)
  {
    if (paramString != null) {
      try
      {
        BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
        if (localBaseApplicationImpl != null)
        {
          if (Build.VERSION.SDK_INT < 11)
          {
            ((android.text.ClipboardManager)localBaseApplicationImpl.getSystemService("clipboard")).setText(paramString);
            return;
          }
          ((android.content.ClipboardManager)localBaseApplicationImpl.getSystemService("clipboard")).setText(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TextViewCopyAction", 0, "copyContent fail.", paramString);
      }
    }
  }
  
  private void b()
  {
    int k;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      k = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().length();
      if (!(this.jdField_a_of_type_AndroidWidgetTextView.getText() instanceof Spannable)) {
        break label104;
      }
    }
    label71:
    label104:
    for (Spannable localSpannable = (Spannable)this.jdField_a_of_type_AndroidWidgetTextView.getText();; localSpannable = null)
    {
      int i;
      if (localSpannable != null) {
        if (this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan == null) {
          i = 1714664933;
        }
      }
      try
      {
        int j = Color.parseColor("#33000000");
        i = j;
      }
      catch (Exception localException)
      {
        break label71;
      }
      this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = new BackgroundColorSpan(i);
      localSpannable.setSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan, 0, k, 17);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Spannable localSpannable = null;
      if ((this.jdField_a_of_type_AndroidWidgetTextView.getText() instanceof Spannable)) {
        localSpannable = (Spannable)this.jdField_a_of_type_AndroidWidgetTextView.getText();
      }
      if (localSpannable != null) {
        localSpannable.removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
      }
    }
  }
  
  public void a()
  {
    c();
  }
  
  public void onClick(View paramView)
  {
    String str = null;
    if (this.jdField_a_of_type_Atuh != null)
    {
      if (!(paramView instanceof TextView)) {
        break label93;
      }
      paramView = ((TextView)paramView).getText().toString();
    }
    label93:
    for (str = this.jdField_a_of_type_Atuh.a(paramView);; str = this.jdField_a_of_type_Atuh.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TextViewCopyAction", 0, String.format("onClick copyResult=%s", new Object[] { str }));
      }
      if (!TextUtils.isEmpty(str))
      {
        a(str);
        if (this.jdField_a_of_type_Atxv != null) {
          this.jdField_a_of_type_Atxv.a(str);
        }
      }
      return;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Atuh != null)
    {
      bakh localbakh = new bakh();
      this.jdField_a_of_type_Atuh.a(localbakh);
      b();
      baay.a(paramView, localbakh, this, this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxu
 * JD-Core Version:    0.7.0.1
 */