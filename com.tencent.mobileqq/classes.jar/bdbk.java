import org.xmlpull.v1.XmlSerializer;

public class bdbk
  extends bcxv
{
  public bdbk()
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
    if (this.aa == null) {}
    for (String str = "";; str = this.aa)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "vote");
      return;
    }
  }
  
  public boolean a(bcxj parambcxj)
  {
    if (parambcxj == null) {
      return true;
    }
    parambcxj = parambcxj.a("cover");
    if (parambcxj != null) {}
    for (;;)
    {
      this.aa = parambcxj;
      return true;
      parambcxj = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbk
 * JD-Core Version:    0.7.0.1
 */