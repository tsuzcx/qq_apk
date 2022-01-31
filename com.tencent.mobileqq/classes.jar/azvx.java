import org.xmlpull.v1.XmlSerializer;

public class azvx
  extends azsm
{
  public azvx()
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
    if (this.S == null) {}
    for (String str = "";; str = this.S)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "vote");
      return;
    }
  }
  
  public boolean a(azsa paramazsa)
  {
    if (paramazsa == null) {
      return true;
    }
    paramazsa = paramazsa.a("cover");
    if (paramazsa != null) {}
    for (;;)
    {
      this.S = paramazsa;
      return true;
      paramazsa = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvx
 * JD-Core Version:    0.7.0.1
 */