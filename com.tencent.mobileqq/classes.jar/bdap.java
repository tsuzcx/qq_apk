import android.graphics.Color;
import android.text.TextUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bdap
  extends bcvu
{
  String aq;
  
  public bdap()
  {
    this(null);
  }
  
  public bdap(String paramString)
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
    this.aq = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.aq == null) {}
    for (String str = "";; str = this.aq)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    if (!TextUtils.isEmpty(this.aq)) {
      paramXmlSerializer.attribute(null, "url", this.aq);
    }
  }
  
  public boolean a(bcxj parambcxj)
  {
    if (parambcxj == null) {
      return true;
    }
    this.aq = parambcxj.a("bgColor");
    return super.a(parambcxj);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2131379866;
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
    return this.aq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdap
 * JD-Core Version:    0.7.0.1
 */