import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bcjb
  extends bcgw
{
  public boolean a;
  public int o;
  
  public bcjb()
  {
    this.jdField_a_of_type_JavaLangString = "hr";
    this.jdField_a_of_type_Int = 9;
  }
  
  @TargetApi(11)
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = new View(paramContext);
      }
      if (this.o == 0) {
        paramBundle.setBackgroundColor(-2170912);
      }
      do
      {
        do
        {
          return paramBundle;
        } while (this.o != 1);
        paramBundle.setBackgroundResource(2130847392);
      } while (Build.VERSION.SDK_INT < 11);
      paramBundle.setLayerType(1, null);
      return paramBundle;
    }
    return null;
  }
  
  public String a()
  {
    return "Hr";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.jdField_a_of_type_Int > 4)
    {
      String str = paramObjectInput.readUTF();
      if ((str != null) && (str.toLowerCase().equals("true"))) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    if (this.jdField_a_of_type_Int >= 9) {
      this.o = paramObjectInput.readInt();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "true";; str = "false")
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.o);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "hr");
    if (this.jdField_a_of_type_Int > 4) {
      if (!this.jdField_a_of_type_Boolean) {
        break label76;
      }
    }
    label76:
    for (String str = "true";; str = "false")
    {
      paramXmlSerializer.attribute(null, "hidden", str);
      if (this.jdField_a_of_type_Int >= 9) {
        paramXmlSerializer.attribute(null, "style", String.valueOf(this.o));
      }
      paramXmlSerializer.endTag(null, "hr");
      return;
    }
  }
  
  public boolean a(bcin parambcin)
  {
    if (parambcin == null) {}
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Int > 4)
      {
        String str = parambcin.a("hidden");
        if ((str != null) && (str.toLowerCase().equals("true"))) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        parambcin = parambcin.a("style");
        if (!TextUtils.isEmpty(parambcin)) {
          try
          {
            this.o = Integer.parseInt(parambcin);
            if (QLog.isColorLevel())
            {
              QLog.i("StructMsg", 2, "type=" + this.o);
              return true;
            }
          }
          catch (NumberFormatException parambcin)
          {
            if (QLog.isColorLevel()) {
              QLog.e("StructMsg", 2, "", parambcin);
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjb
 * JD-Core Version:    0.7.0.1
 */