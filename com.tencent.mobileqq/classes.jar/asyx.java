import com.tencent.mobileqq.app.QQAppInterface;

public class asyx
{
  private QQAppInterface a;
  
  public asyx(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, aszc paramaszc)
  {
    atab localatab = this.a.a().a();
    atac localatac = new atac();
    localatac.jdField_a_of_type_JavaLangString = paramString4;
    localatac.jdField_a_of_type_Long = paramLong;
    localatac.c = paramString5;
    localatac.b = paramString3;
    if (paramInt1 != 3000)
    {
      localatab.a(paramString1, paramInt1, paramString2, paramInt2, localatac, 5000, 5, new asza(this, paramaszc));
      return;
    }
    localatab.a(paramString1, paramString2, localatac, new aszb(this, paramaszc));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2, aszc paramaszc)
  {
    atab localatab = this.a.a().a();
    atac localatac = new atac();
    localatac.jdField_a_of_type_JavaLangString = paramString4;
    localatac.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localatab.a(paramString2, paramString1, localatac, paramInt2, 5000, 3, new asyy(this, paramaszc));
      return;
    }
    localatab.a(paramString1, paramInt1, paramString2, paramString3, 5000, 3, new asyz(this, paramaszc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     asyx
 * JD-Core Version:    0.7.0.1
 */