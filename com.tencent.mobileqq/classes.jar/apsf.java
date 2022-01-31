import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;

public abstract class apsf
  extends apov
{
  apns jdField_a_of_type_Apns = new apsh(this);
  apnv jdField_a_of_type_Apnv = new apsg(this);
  protected int h = 2;
  
  public apsf(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, appt paramappt)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramappt);
    apne.a().a(this.jdField_a_of_type_Apns);
    apnw.a().a(this.jdField_a_of_type_Apnv);
  }
  
  public void a()
  {
    super.a();
    apne.a().b(this.jdField_a_of_type_Apns);
    apnw.a().b(this.jdField_a_of_type_Apnv);
  }
  
  public void a(int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void b(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsf
 * JD-Core Version:    0.7.0.1
 */