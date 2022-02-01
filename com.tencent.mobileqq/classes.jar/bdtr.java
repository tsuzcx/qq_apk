import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bdtr
  extends bdol
{
  public int o;
  
  public bdtr()
  {
    this.a = "type";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return null;
  }
  
  public String a()
  {
    return "type";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.o = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.o);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "type");
    paramXmlSerializer.text(this.o + "");
    paramXmlSerializer.endTag(null, "type");
  }
  
  public boolean a(bdqc parambdqc)
  {
    if (parambdqc == null) {
      return false;
    }
    try
    {
      this.o = Integer.valueOf(bcsa.a(bdow.a(parambdqc), false)).intValue();
      return true;
    }
    catch (Exception parambdqc)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StructMsgItemType", 2, parambdqc, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtr
 * JD-Core Version:    0.7.0.1
 */