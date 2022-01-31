import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.Set;

public class arvj
  extends arum
{
  int d;
  
  public arvj(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramBundle.getString("uin"));
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramBundle.getInt("uintype"));
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    this.jdField_a_of_type_AndroidContentIntent = aekt.a(this.jdField_a_of_type_AndroidContentIntent, new int[] { 2 });
    this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
    this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", "FORWARD_EMOPGK_ID");
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("FORWARD_EMOPGK_ID", -1);
    return true;
  }
  
  public void c()
  {
    super.c();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", this.jdField_a_of_type_AndroidContentIntent.getIntExtra("FORWARD_EMOPGK_ID", -1) + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvj
 * JD-Core Version:    0.7.0.1
 */