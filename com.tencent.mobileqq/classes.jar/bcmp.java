import org.xmlpull.v1.XmlSerializer;

public class bcmp
  extends bciz
{
  public bcmp()
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
  
  public boolean a(bcin parambcin)
  {
    if (parambcin == null) {
      return true;
    }
    parambcin = parambcin.a("cover");
    if (parambcin != null) {}
    for (;;)
    {
      this.ac = parambcin;
      return true;
      parambcin = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmp
 * JD-Core Version:    0.7.0.1
 */