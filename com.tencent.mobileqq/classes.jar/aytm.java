import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aytm
  implements View.OnClickListener, View.OnLongClickListener, bjoy
{
  private BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
  private View jdField_a_of_type_AndroidViewView;
  private aytn jdField_a_of_type_Aytn;
  private ayto jdField_a_of_type_Ayto;
  
  private aytm(View paramView, ayto paramayto)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LongClickCopyAction", 2, String.format("TextViewCopyAction target=%s copyData=%s", new Object[] { paramView, paramayto }));
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Ayto = paramayto;
  }
  
  public static aytm a(View paramView, ayto paramayto)
  {
    ayto localayto = null;
    if (paramView != null)
    {
      paramayto = new aytm(paramView, paramayto);
      paramView.setOnLongClickListener(paramayto);
      localayto = paramayto;
      if ((paramView instanceof TextView))
      {
        paramView = (TextView)paramView;
        paramView.setText(paramView.getText(), TextView.BufferType.SPANNABLE);
        localayto = paramayto;
      }
    }
    return localayto;
  }
  
  public static aytm a(View paramView, String paramString1, String paramString2)
  {
    ayto localayto = new ayto();
    localayto.a(paramString1, paramString2);
    return a(paramView, localayto);
  }
  
  public static aytm a(TextView paramTextView)
  {
    String str1 = null;
    String str2;
    if (paramTextView != null)
    {
      str2 = paramTextView.getResources().getString(2131698444);
      str1 = paramTextView.getText().toString();
    }
    for (;;)
    {
      ayto localayto = new ayto();
      localayto.a(str2, str1);
      return a(paramTextView, localayto);
      str2 = null;
    }
  }
  
  public static aytm a(TextView paramTextView, String paramString)
  {
    String str = null;
    if (paramTextView != null) {
      str = paramTextView.getText().toString();
    }
    ayto localayto = new ayto();
    localayto.a(paramString, str);
    return a(paramTextView, localayto);
  }
  
  private void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (localBaseApplicationImpl != null) {
        ((ClipboardManager)localBaseApplicationImpl.getSystemService("clipboard")).setText(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("LongClickCopyAction", 2, "copyContent fail.", paramString);
    }
  }
  
  private void b()
  {
    int k;
    Spannable localSpannable;
    int i;
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof TextView)))
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView;
      k = localTextView.getText().toString().length();
      localSpannable = null;
      if ((localTextView.getText() instanceof Spannable)) {
        localSpannable = (Spannable)localTextView.getText();
      }
      if (localSpannable != null) {
        if (this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan == null) {
          i = 1714664933;
        }
      }
    }
    try
    {
      int j = Color.parseColor("#33000000");
      i = j;
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = new BackgroundColorSpan(i);
    localSpannable.setSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan, 0, k, 17);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof TextView)))
    {
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView;
      if (!(((TextView)localObject).getText() instanceof Spannable)) {
        break label58;
      }
    }
    label58:
    for (Object localObject = (Spannable)((TextView)localObject).getText();; localObject = null)
    {
      if (localObject != null) {
        ((Spannable)localObject).removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
      }
      return;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof TextView)) {
      c();
    }
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setSelected(false);
  }
  
  public void a(aytn paramaytn)
  {
    this.jdField_a_of_type_Aytn = paramaytn;
  }
  
  public void onClick(View paramView)
  {
    String str = null;
    if ((paramView instanceof TextView))
    {
      str = ((TextView)paramView).getText().toString();
      str = this.jdField_a_of_type_Ayto.a(str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LongClickCopyAction", 2, String.format("onClick view=%s copyResult=%s", new Object[] { paramView, str }));
    }
    if (!TextUtils.isEmpty(str))
    {
      a(str);
      if (this.jdField_a_of_type_Aytn != null) {
        this.jdField_a_of_type_Aytn.a(str);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    bgaz localbgaz;
    if (this.jdField_a_of_type_Ayto != null)
    {
      localbgaz = new bgaz();
      this.jdField_a_of_type_Ayto.a(localbgaz);
      if (!(this.jdField_a_of_type_AndroidViewView instanceof TextView)) {
        break label63;
      }
      b();
    }
    for (;;)
    {
      bfue.a(paramView, localbgaz, this, this);
      if (this.jdField_a_of_type_Aytn != null) {
        this.jdField_a_of_type_Aytn.a();
      }
      return true;
      label63:
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setSelected(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytm
 * JD-Core Version:    0.7.0.1
 */