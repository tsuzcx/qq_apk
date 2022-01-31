import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class awwb
  extends awul
{
  public int i;
  
  public awwb()
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
    this.i = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.i);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "voice");
    paramXmlSerializer.attribute(null, "length", String.valueOf(this.i));
    paramXmlSerializer.endTag(null, "voice");
  }
  
  public boolean a(awwc paramawwc)
  {
    paramawwc = paramawwc.a("length");
    if (!TextUtils.isEmpty(paramawwc)) {
      this.i = Integer.parseInt(paramawwc);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awwb
 * JD-Core Version:    0.7.0.1
 */