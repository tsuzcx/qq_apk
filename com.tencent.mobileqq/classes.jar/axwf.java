import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class axwf
  extends axup
{
  public int k;
  
  public axwf()
  {
    this.a = "voice";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return null;
  }
  
  public String a()
  {
    return null;
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
    paramXmlSerializer.startTag(null, "voice");
    paramXmlSerializer.attribute(null, "length", String.valueOf(this.k));
    paramXmlSerializer.endTag(null, "voice");
  }
  
  public boolean a(axwg paramaxwg)
  {
    paramaxwg = paramaxwg.a("length");
    if (!TextUtils.isEmpty(paramaxwg)) {
      this.k = Integer.parseInt(paramaxwg);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwf
 * JD-Core Version:    0.7.0.1
 */