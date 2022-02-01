import com.tencent.mobileqq.app.QQAppInterface;

public class athh
{
  private QQAppInterface a;
  
  public athh(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, athm paramathm)
  {
    atim localatim = this.a.getFileManagerEngine().a();
    atio localatio = new atio();
    localatio.jdField_a_of_type_JavaLangString = paramString4;
    localatio.jdField_a_of_type_Long = paramLong;
    localatio.c = paramString5;
    localatio.b = paramString3;
    if (paramInt1 != 3000)
    {
      localatim.a(paramString1, paramInt1, paramString2, paramInt2, localatio, 5000, 5, new athk(this, paramathm));
      return;
    }
    localatim.a(paramString1, paramString2, localatio, new athl(this, paramathm));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2, athm paramathm)
  {
    atim localatim = this.a.getFileManagerEngine().a();
    atio localatio = new atio();
    localatio.jdField_a_of_type_JavaLangString = paramString4;
    localatio.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localatim.a(paramString2, paramString1, localatio, paramInt2, 5000, 3, new athi(this, paramathm));
      return;
    }
    localatim.a(paramString1, paramInt1, paramString2, paramString3, 5000, 3, new athj(this, paramathm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     athh
 * JD-Core Version:    0.7.0.1
 */