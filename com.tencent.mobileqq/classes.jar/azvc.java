import android.graphics.Color;
import android.text.TextUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class azvc
  extends azql
{
  String ai;
  
  public azvc()
  {
    this(null);
  }
  
  public azvc(String paramString)
  {
    super(paramString, "remark");
  }
  
  public String a()
  {
    return "Remark";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ai = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ai == null) {}
    for (String str = "";; str = this.ai)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    if (!TextUtils.isEmpty(this.ai)) {
      paramXmlSerializer.attribute(null, "url", this.ai);
    }
  }
  
  public boolean a(azsa paramazsa)
  {
    if (paramazsa == null) {
      return true;
    }
    this.ai = paramazsa.a("bgColor");
    return super.a(paramazsa);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2131378912;
  }
  
  public int e()
  {
    return Color.rgb(128, 128, 128);
  }
  
  public int f()
  {
    return 24;
  }
  
  public String g()
  {
    return this.ai;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvc
 * JD-Core Version:    0.7.0.1
 */