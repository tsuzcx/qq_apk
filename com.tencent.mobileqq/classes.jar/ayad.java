import org.xmlpull.v1.XmlSerializer;

public class ayad
  extends axws
{
  public ayad()
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
  
  public boolean a(axwg paramaxwg)
  {
    if (paramaxwg == null) {
      return true;
    }
    paramaxwg = paramaxwg.a("cover");
    if (paramaxwg != null) {}
    for (;;)
    {
      this.S = paramaxwg;
      return true;
      paramaxwg = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayad
 * JD-Core Version:    0.7.0.1
 */