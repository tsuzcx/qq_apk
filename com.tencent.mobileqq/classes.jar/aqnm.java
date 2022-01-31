import com.tencent.mobileqq.app.QQAppInterface;

public class aqnm
{
  private QQAppInterface a;
  
  public aqnm(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, aqnr paramaqnr)
  {
    aqpr localaqpr = this.a.a().a();
    aqps localaqps = new aqps();
    localaqps.jdField_a_of_type_JavaLangString = paramString4;
    localaqps.jdField_a_of_type_Long = paramLong;
    localaqps.c = paramString5;
    localaqps.b = paramString3;
    if (paramInt1 != 3000)
    {
      localaqpr.a(paramString1, paramInt1, paramString2, paramInt2, localaqps, 5000, 5, new aqnp(this, paramaqnr));
      return;
    }
    localaqpr.a(paramString1, paramString2, localaqps, new aqnq(this, paramaqnr));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2, aqnr paramaqnr)
  {
    aqpr localaqpr = this.a.a().a();
    aqps localaqps = new aqps();
    localaqps.jdField_a_of_type_JavaLangString = paramString3;
    localaqps.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localaqpr.a(paramString2, paramString1, localaqps, paramInt2, 5000, 3, new aqnn(this, paramaqnr));
      return;
    }
    localaqpr.a(paramString1, paramInt1, paramString2, 5000, 3, new aqno(this, paramaqnr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqnm
 * JD-Core Version:    0.7.0.1
 */