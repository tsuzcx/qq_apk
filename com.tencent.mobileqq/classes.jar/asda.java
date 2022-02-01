import com.tencent.mobileqq.app.QQAppInterface;

public class asda
{
  private QQAppInterface a;
  
  public asda(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, asdf paramasdf)
  {
    aseg localaseg = this.a.getFileManagerEngine().a();
    asei localasei = new asei();
    localasei.jdField_a_of_type_JavaLangString = paramString4;
    localasei.jdField_a_of_type_Long = paramLong;
    localasei.c = paramString5;
    localasei.b = paramString3;
    if (paramInt1 != 3000)
    {
      localaseg.a(paramString1, paramInt1, paramString2, paramInt2, localasei, 5000, 5, new asdd(this, paramasdf));
      return;
    }
    localaseg.a(paramString1, paramString2, localasei, new asde(this, paramasdf));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2, asdf paramasdf)
  {
    aseg localaseg = this.a.getFileManagerEngine().a();
    asei localasei = new asei();
    localasei.jdField_a_of_type_JavaLangString = paramString4;
    localasei.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localaseg.a(paramString2, paramString1, localasei, paramInt2, 5000, 3, new asdb(this, paramasdf));
      return;
    }
    localaseg.a(paramString1, paramInt1, paramString2, paramString3, 5000, 3, new asdc(this, paramasdf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     asda
 * JD-Core Version:    0.7.0.1
 */