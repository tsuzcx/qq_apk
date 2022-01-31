import com.tencent.mobileqq.app.QQAppInterface;

public class aodq
{
  private QQAppInterface a;
  
  public aodq(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, aodv paramaodv)
  {
    aofv localaofv = this.a.a().a();
    aofw localaofw = new aofw();
    localaofw.jdField_a_of_type_JavaLangString = paramString4;
    localaofw.jdField_a_of_type_Long = paramLong;
    localaofw.c = paramString5;
    localaofw.b = paramString3;
    if (paramInt1 != 3000)
    {
      localaofv.a(paramString1, paramInt1, paramString2, paramInt2, localaofw, 5000, 5, new aodt(this, paramaodv));
      return;
    }
    localaofv.a(paramString1, paramString2, localaofw, new aodu(this, paramaodv));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2, aodv paramaodv)
  {
    aofv localaofv = this.a.a().a();
    aofw localaofw = new aofw();
    localaofw.jdField_a_of_type_JavaLangString = paramString3;
    localaofw.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localaofv.a(paramString2, paramString1, localaofw, paramInt2, 5000, 3, new aodr(this, paramaodv));
      return;
    }
    localaofv.a(paramString1, paramInt1, paramString2, 5000, 3, new aods(this, paramaodv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aodq
 * JD-Core Version:    0.7.0.1
 */