import com.tencent.mobileqq.app.QQAppInterface;

public class atqr
{
  private QQAppInterface a;
  
  public atqr(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, atqw paramatqw)
  {
    atrw localatrw = this.a.a().a();
    atry localatry = new atry();
    localatry.jdField_a_of_type_JavaLangString = paramString4;
    localatry.jdField_a_of_type_Long = paramLong;
    localatry.c = paramString5;
    localatry.b = paramString3;
    if (paramInt1 != 3000)
    {
      localatrw.a(paramString1, paramInt1, paramString2, paramInt2, localatry, 5000, 5, new atqu(this, paramatqw));
      return;
    }
    localatrw.a(paramString1, paramString2, localatry, new atqv(this, paramatqw));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2, atqw paramatqw)
  {
    atrw localatrw = this.a.a().a();
    atry localatry = new atry();
    localatry.jdField_a_of_type_JavaLangString = paramString4;
    localatry.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localatrw.a(paramString2, paramString1, localatry, paramInt2, 5000, 3, new atqs(this, paramatqw));
      return;
    }
    localatrw.a(paramString1, paramInt1, paramString2, paramString3, 5000, 3, new atqt(this, paramatqw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atqr
 * JD-Core Version:    0.7.0.1
 */