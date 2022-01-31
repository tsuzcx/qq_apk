import org.xmlpull.v1.XmlSerializer;

public class awzz
  extends awwo
{
  public awzz()
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
  
  public boolean a(awwc paramawwc)
  {
    if (paramawwc == null) {
      return true;
    }
    paramawwc = paramawwc.a("cover");
    if (paramawwc != null) {}
    for (;;)
    {
      this.S = paramawwc;
      return true;
      paramawwc = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzz
 * JD-Core Version:    0.7.0.1
 */