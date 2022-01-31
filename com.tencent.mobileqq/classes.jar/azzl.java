import android.graphics.Color;
import android.text.TextUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class azzl
  extends azuu
{
  String ai;
  
  public azzl()
  {
    this(null);
  }
  
  public azzl(String paramString)
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
  
  public boolean a(azwj paramazwj)
  {
    if (paramazwj == null) {
      return true;
    }
    this.ai = paramazwj.a("bgColor");
    return super.a(paramazwj);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2131378970;
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
 * Qualified Name:     azzl
 * JD-Core Version:    0.7.0.1
 */