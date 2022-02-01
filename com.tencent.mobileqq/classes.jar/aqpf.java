import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class aqpf
  implements aqpo
{
  private aqpg jdField_a_of_type_Aqpg;
  private aqph jdField_a_of_type_Aqph;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aqpf(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<aqon> paramList, aqpg paramaqpg, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqpg = paramaqpg;
    a(paramContext, paramQQAppInterface, paramString, paramList, paramBoolean);
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<aqon> paramList, boolean paramBoolean)
  {
    boolean bool1 = aqpe.b(paramQQAppInterface);
    boolean bool2 = aqpe.a(paramQQAppInterface, paramString);
    if (paramBoolean) {
      bool1 = false;
    }
    this.jdField_a_of_type_Aqph = new aqph(paramQQAppInterface, paramContext, paramString, bool1, bool2, paramList, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqph.show();
  }
  
  public void a(int paramInt, aqon paramaqon)
  {
    if (this.jdField_a_of_type_Aqpg != null) {
      this.jdField_a_of_type_Aqpg.a(paramInt, paramaqon);
    }
    b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ((aqpc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(380)).a(paramBoolean, paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aqph.dismiss();
  }
  
  public void c()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpf
 * JD-Core Version:    0.7.0.1
 */