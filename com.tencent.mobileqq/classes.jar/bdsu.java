import android.graphics.Color;
import android.text.TextUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bdsu
  extends bdnw
{
  String as;
  
  public bdsu()
  {
    this(null);
  }
  
  public bdsu(String paramString)
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
    this.as = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.as == null) {}
    for (String str = "";; str = this.as)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    if (!TextUtils.isEmpty(this.as)) {
      paramXmlSerializer.attribute(null, "url", this.as);
    }
  }
  
  public boolean a(bdpl parambdpl)
  {
    if (parambdpl == null) {
      return true;
    }
    this.as = parambdpl.a("bgColor");
    return super.a(parambdpl);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2131380123;
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
    return this.as;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsu
 * JD-Core Version:    0.7.0.1
 */