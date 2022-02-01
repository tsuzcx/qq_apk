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

public class baex
  implements View.OnClickListener, View.OnLongClickListener, blkc
{
  private BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
  private View jdField_a_of_type_AndroidViewView;
  private baey jdField_a_of_type_Baey;
  private baez jdField_a_of_type_Baez;
  
  private baex(View paramView, baez parambaez)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LongClickCopyAction", 2, String.format("TextViewCopyAction target=%s copyData=%s", new Object[] { paramView, parambaez }));
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Baez = parambaez;
  }
  
  public static baex a(View paramView, baez parambaez)
  {
    baez localbaez = null;
    if (paramView != null)
    {
      parambaez = new baex(paramView, parambaez);
      paramView.setOnLongClickListener(parambaez);
      localbaez = parambaez;
      if ((paramView instanceof TextView))
      {
        paramView = (TextView)paramView;
        paramView.setText(paramView.getText(), TextView.BufferType.SPANNABLE);
        localbaez = parambaez;
      }
    }
    return localbaez;
  }
  
  public static baex a(View paramView, String paramString1, String paramString2)
  {
    baez localbaez = new baez();
    localbaez.a(paramString1, paramString2);
    return a(paramView, localbaez);
  }
  
  public static baex a(TextView paramTextView)
  {
    String str1 = null;
    String str2;
    if (paramTextView != null)
    {
      str2 = paramTextView.getResources().getString(2131698275);
      str1 = paramTextView.getText().toString();
    }
    for (;;)
    {
      baez localbaez = new baez();
      localbaez.a(str2, str1);
      return a(paramTextView, localbaez);
      str2 = null;
    }
  }
  
  public static baex a(TextView paramTextView, String paramString)
  {
    String str = null;
    if (paramTextView != null) {
      str = paramTextView.getText().toString();
    }
    baez localbaez = new baez();
    localbaez.a(paramString, str);
    return a(paramTextView, localbaez);
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
  
  public void a(baey parambaey)
  {
    this.jdField_a_of_type_Baey = parambaey;
  }
  
  public void onClick(View paramView)
  {
    String str = null;
    if ((paramView instanceof TextView))
    {
      str = ((TextView)paramView).getText().toString();
      str = this.jdField_a_of_type_Baez.a(str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LongClickCopyAction", 2, String.format("onClick view=%s copyResult=%s", new Object[] { paramView, str }));
    }
    if (!TextUtils.isEmpty(str))
    {
      a(str);
      if (this.jdField_a_of_type_Baey != null) {
        this.jdField_a_of_type_Baey.a(str);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    bhuk localbhuk;
    if (this.jdField_a_of_type_Baez != null)
    {
      localbhuk = new bhuk();
      this.jdField_a_of_type_Baez.a(localbhuk);
      if (!(this.jdField_a_of_type_AndroidViewView instanceof TextView)) {
        break label63;
      }
      b();
    }
    for (;;)
    {
      bhkx.a(paramView, localbhuk, this, this);
      if (this.jdField_a_of_type_Baey != null) {
        this.jdField_a_of_type_Baey.a();
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
 * Qualified Name:     baex
 * JD-Core Version:    0.7.0.1
 */