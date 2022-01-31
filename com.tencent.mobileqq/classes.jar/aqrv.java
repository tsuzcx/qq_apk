import com.tencent.mobileqq.app.QQAppInterface;

public class aqrv
{
  private QQAppInterface a;
  
  public aqrv(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, aqsa paramaqsa)
  {
    aqua localaqua = this.a.a().a();
    aqub localaqub = new aqub();
    localaqub.jdField_a_of_type_JavaLangString = paramString4;
    localaqub.jdField_a_of_type_Long = paramLong;
    localaqub.c = paramString5;
    localaqub.b = paramString3;
    if (paramInt1 != 3000)
    {
      localaqua.a(paramString1, paramInt1, paramString2, paramInt2, localaqub, 5000, 5, new aqry(this, paramaqsa));
      return;
    }
    localaqua.a(paramString1, paramString2, localaqub, new aqrz(this, paramaqsa));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2, aqsa paramaqsa)
  {
    aqua localaqua = this.a.a().a();
    aqub localaqub = new aqub();
    localaqub.jdField_a_of_type_JavaLangString = paramString3;
    localaqub.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localaqua.a(paramString2, paramString1, localaqub, paramInt2, 5000, 3, new aqrw(this, paramaqsa));
      return;
    }
    localaqua.a(paramString1, paramInt1, paramString2, 5000, 3, new aqrx(this, paramaqsa));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqrv
 * JD-Core Version:    0.7.0.1
 */