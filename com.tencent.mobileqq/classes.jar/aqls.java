import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.List;

public class aqls
  implements aqmb
{
  private aqlt jdField_a_of_type_Aqlt;
  private aqlu jdField_a_of_type_Aqlu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aqls(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<aqla> paramList, aqlt paramaqlt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqlt = paramaqlt;
    a(paramContext, paramQQAppInterface, paramString, paramList, paramBoolean);
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<aqla> paramList, boolean paramBoolean)
  {
    boolean bool1 = aqlr.b(paramQQAppInterface);
    boolean bool2 = aqlr.a(paramQQAppInterface, paramString);
    if (paramBoolean) {
      bool1 = false;
    }
    this.jdField_a_of_type_Aqlu = new aqlu(paramQQAppInterface, paramContext, paramString, bool1, bool2, paramList, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqlu.show();
  }
  
  public void a(int paramInt, aqla paramaqla)
  {
    if (this.jdField_a_of_type_Aqlt != null) {
      this.jdField_a_of_type_Aqlt.a(paramInt, paramaqla);
    }
    b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ((aqlp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).a(paramBoolean, paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aqlu.dismiss();
  }
  
  public void c()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqls
 * JD-Core Version:    0.7.0.1
 */