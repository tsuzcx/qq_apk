import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class apio
  implements apix
{
  private apip jdField_a_of_type_Apip;
  private apiq jdField_a_of_type_Apiq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public apio(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<aphw> paramList, apip paramapip, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Apip = paramapip;
    a(paramContext, paramQQAppInterface, paramString, paramList, paramBoolean);
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<aphw> paramList, boolean paramBoolean)
  {
    boolean bool1 = apin.b(paramQQAppInterface);
    boolean bool2 = apin.a(paramQQAppInterface, paramString);
    if (paramBoolean) {
      bool1 = false;
    }
    this.jdField_a_of_type_Apiq = new apiq(paramQQAppInterface, paramContext, paramString, bool1, bool2, paramList, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Apiq.show();
  }
  
  public void a(int paramInt, aphw paramaphw)
  {
    if (this.jdField_a_of_type_Apip != null) {
      this.jdField_a_of_type_Apip.a(paramInt, paramaphw);
    }
    b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ((apil)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(380)).a(paramBoolean, paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Apiq.dismiss();
  }
  
  public void c()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apio
 * JD-Core Version:    0.7.0.1
 */