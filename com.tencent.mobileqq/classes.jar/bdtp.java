import org.xmlpull.v1.XmlSerializer;

public class bdtp
  extends bdpx
{
  public bdtp()
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
  
  public boolean a(bdpl parambdpl)
  {
    if (parambdpl == null) {
      return true;
    }
    parambdpl = parambdpl.a("cover");
    if (parambdpl != null) {}
    for (;;)
    {
      this.ac = parambdpl;
      return true;
      parambdpl = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtp
 * JD-Core Version:    0.7.0.1
 */