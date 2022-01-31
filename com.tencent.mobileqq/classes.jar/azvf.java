import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class azvf
  extends azqj
  implements View.OnClickListener
{
  public String S;
  public String T;
  public String U;
  public int k;
  public int l;
  
  public azvf()
  {
    this.a = "textButton";
    b(32);
    c(32);
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    paramContext.setId(2131378976);
    return paramContext;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramView != null) {
      paramContext = (azvg)paramView.getTag();
    }
    for (;;)
    {
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTag(this);
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTextColor(c());
      paramContext.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT, d());
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTextSize(b() / 2);
      if (!TextUtils.isEmpty(this.S)) {
        paramContext.jdField_a_of_type_AndroidWidgetTextView.setText(this.S);
      }
      try
      {
        if (!TextUtils.isEmpty(this.T))
        {
          paramBundle = URLDrawable.getDrawable(this.T, this.k, this.k, null, null);
          paramBundle.setAutoDownload(true);
          paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
        }
        if (!TextUtils.isEmpty(this.U))
        {
          paramBundle = URLDrawable.getDrawable(this.U, this.l, this.l, null, null);
          paramBundle.setAutoDownload(true);
          paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, " URLDrawable.exception illegal url : " + paramContext.getMessage());
          }
        }
      }
      if ((this.c != null) && (!this.c.equals("")))
      {
        paramView.setClickable(true);
        paramView.setOnClickListener(this);
      }
      return paramView;
      paramView = new azvg(this);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = a(paramContext);
      paramView.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      paramView.b = new ImageView(paramContext);
      paramView.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.gravity = 16;
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_a_of_type_AndroidWidgetImageView, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.b, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramView);
      paramBundle = paramView.jdField_a_of_type_AndroidWidgetLinearLayout;
      paramContext = paramView;
      paramView = paramBundle;
    }
  }
  
  public String a()
  {
    return "TextButton";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.S = ayvy.a(paramObjectInput.readUTF(), false);
    this.T = ayvy.a(paramObjectInput.readUTF(), false);
    this.U = ayvy.a(paramObjectInput.readUTF(), false);
    this.b = ayvy.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.S == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.T != null) {
        break label86;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.U != null) {
        break label94;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.b != null) {
        break label102;
      }
    }
    label86:
    label94:
    label102:
    for (String str = "";; str = this.b)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = ayvy.a(this.S, false);
      break;
      str = this.T;
      break label32;
      str = this.U;
      break label49;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (!TextUtils.isEmpty(this.S)) {
      paramXmlSerializer.attribute(null, "text", this.S);
    }
    if (!TextUtils.isEmpty(this.T)) {
      paramXmlSerializer.attribute(null, "leftImage", this.T);
    }
    if (!TextUtils.isEmpty(this.U)) {
      paramXmlSerializer.attribute(null, "rightImage", this.U);
    }
    if (!TextUtils.isEmpty(this.b)) {
      paramXmlSerializer.attribute(null, "url", this.b);
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(azsa paramazsa)
  {
    if (paramazsa == null) {
      return true;
    }
    this.b = paramazsa.a("url");
    this.T = paramazsa.a("leftImage");
    this.U = paramazsa.a("rightImage");
    this.S = ayvy.a(paramazsa.a("text"), false);
    return true;
  }
  
  public int b()
  {
    return 26;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int c()
  {
    return -16777216;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvf
 * JD-Core Version:    0.7.0.1
 */