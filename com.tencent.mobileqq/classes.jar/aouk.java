import com.tencent.mobileqq.app.QQAppInterface;

public class aouk
{
  private QQAppInterface a;
  
  public aouk(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, aoup paramaoup)
  {
    aowp localaowp = this.a.a().a();
    aowq localaowq = new aowq();
    localaowq.jdField_a_of_type_JavaLangString = paramString4;
    localaowq.jdField_a_of_type_Long = paramLong;
    localaowq.c = paramString5;
    localaowq.b = paramString3;
    if (paramInt1 != 3000)
    {
      localaowp.a(paramString1, paramInt1, paramString2, paramInt2, localaowq, 5000, 5, new aoun(this, paramaoup));
      return;
    }
    localaowp.a(paramString1, paramString2, localaowq, new aouo(this, paramaoup));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2, aoup paramaoup)
  {
    aowp localaowp = this.a.a().a();
    aowq localaowq = new aowq();
    localaowq.jdField_a_of_type_JavaLangString = paramString3;
    localaowq.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localaowp.a(paramString2, paramString1, localaowq, paramInt2, 5000, 3, new aoul(this, paramaoup));
      return;
    }
    localaowp.a(paramString1, paramInt1, paramString2, 5000, 3, new aoum(this, paramaoup));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aouk
 * JD-Core Version:    0.7.0.1
 */