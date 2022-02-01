import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

public class amyn
  extends amyk
{
  public amyn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void a(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      this.b = true;
      localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", true));
    angi.a(paramangr, anzj.a(2131703502), 7, 0);
    localSharedPreferences.edit().putBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", false).commit();
    a(paramContext, paramQQAppInterface);
  }
  
  public boolean a()
  {
    return (this.c) && (!this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyn
 * JD-Core Version:    0.7.0.1
 */