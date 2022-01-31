import org.xmlpull.v1.XmlSerializer;

public class baag
  extends azwv
{
  public baag()
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
  
  public boolean a(azwj paramazwj)
  {
    if (paramazwj == null) {
      return true;
    }
    paramazwj = paramazwj.a("cover");
    if (paramazwj != null) {}
    for (;;)
    {
      this.S = paramazwj;
      return true;
      paramazwj = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baag
 * JD-Core Version:    0.7.0.1
 */