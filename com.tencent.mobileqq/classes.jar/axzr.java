import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class axzr
  extends axup
{
  public int k;
  
  public axzr()
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
    this.k = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.k);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "type");
    paramXmlSerializer.text(this.k + "");
    paramXmlSerializer.endTag(null, "type");
  }
  
  public boolean a(axwg paramaxwg)
  {
    if (paramaxwg == null) {
      return false;
    }
    try
    {
      this.k = Integer.valueOf(axau.a(axva.a(paramaxwg), false)).intValue();
      return true;
    }
    catch (Exception paramaxwg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StructMsgItemType", 2, paramaxwg, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzr
 * JD-Core Version:    0.7.0.1
 */