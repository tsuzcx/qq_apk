import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amyp
  extends amyk
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  boolean d;
  
  public amyp(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.c(), 0);
    this.jdField_a_of_type_Int = paramQQAppInterface.getInt("hire_priority", 1);
    this.jdField_b_of_type_Int = paramQQAppInterface.getInt("hire_action", 0);
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getString("hire_word", "");
    this.jdField_a_of_type_Long = paramQQAppInterface.getLong("hire_for", 0L);
    this.jdField_b_of_type_Long = paramQQAppInterface.getLong("hire_end", 0L);
  }
  
  public int a(angr paramangr, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((NetConnInfoCenter.getServerTime() > this.jdField_b_of_type_Long) || (this.d) || (!this.c)) {
      return super.a(paramangr, paramInt, paramAppInterface, paramContext);
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      if (ApolloUtil.c(5, this.jdField_b_of_type_Int))
      {
        paramContext = new ApolloActionData();
        paramContext.actionId = this.jdField_b_of_type_Int;
        paramContext.actionType = 0;
        angi.a(paramangr, 6, paramContext);
        this.d = true;
        paramAppInterface.getApp().getSharedPreferences("apollo_sp" + paramAppInterface.getCurrentAccountUin(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
        return 0;
      }
      QLog.w("AplloDrawerStatus", 2, "HireDrawerStatus resource is not ready, actionId:" + this.jdField_b_of_type_Int);
      super.a(paramangr, paramInt, paramAppInterface, paramContext);
      aniv.a(paramAppInterface, ApolloUtil.c(this.jdField_b_of_type_Int) + "/d.zip", ApolloUtil.d(this.jdField_b_of_type_Int));
      return 0;
    }
    QLog.w("AplloDrawerStatus", 2, "HireDrawerStatus action is not correct, actionId:" + this.jdField_b_of_type_Int);
    super.a(paramangr, paramInt, paramAppInterface, paramContext);
    paramAppInterface.getApp().getSharedPreferences("apollo_sp" + paramAppInterface.getCurrentAccountUin(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
    return 0;
  }
  
  public void a(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramangr = new Intent();
    paramangr.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
    ApolloUtil.a(paramContext, paramangr, "drawer", annv.ai, null);
    a(paramQQAppInterface);
    VipUtils.a(null, "cmshow", "Apollo", "0X80065F002", 0, 0, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {}
    boolean bool;
    do
    {
      return;
      bool = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.c(), 0).getBoolean("hire_bubble_click", false);
    } while ((NetConnInfoCenter.getServerTime() > this.jdField_b_of_type_Long) || (bool));
    this.jdField_b_of_type_Boolean = true;
    angi.a(paramangr, this.jdField_a_of_type_JavaLangString, 7, 0);
    VipUtils.a(null, "cmshow", "Apollo", "0X80065F001", 0, 0, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.c(), 0).edit().putBoolean("hire_bubble_click", true).commit();
  }
  
  public boolean a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyp
 * JD-Core Version:    0.7.0.1
 */