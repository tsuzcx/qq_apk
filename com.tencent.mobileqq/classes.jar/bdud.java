import org.xmlpull.v1.XmlSerializer;

public class bdud
  extends bdqo
{
  public bdud()
  {
    this.a = "vote";
  }
  
  public String a()
  {
    return "VoteCover";
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "vote");
    if (this.ac == null) {}
    for (String str = "";; str = this.ac)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "vote");
      return;
    }
  }
  
  public boolean a(bdqc parambdqc)
  {
    if (parambdqc == null) {
      return true;
    }
    parambdqc = parambdqc.a("cover");
    if (parambdqc != null) {}
    for (;;)
    {
      this.ac = parambdqc;
      return true;
      parambdqc = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdud
 * JD-Core Version:    0.7.0.1
 */