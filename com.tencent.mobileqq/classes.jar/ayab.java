import org.xmlpull.v1.XmlSerializer;

public class ayab
  extends axwq
{
  public ayab()
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
  
  public boolean a(axwe paramaxwe)
  {
    if (paramaxwe == null) {
      return true;
    }
    paramaxwe = paramaxwe.a("cover");
    if (paramaxwe != null) {}
    for (;;)
    {
      this.S = paramaxwe;
      return true;
      paramaxwe = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayab
 * JD-Core Version:    0.7.0.1
 */