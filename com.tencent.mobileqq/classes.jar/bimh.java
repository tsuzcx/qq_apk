import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;

public class bimh
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  
  public bimh(int paramInt, String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ppp_profile", 4);
    this.jdField_a_of_type_Int = localSharedPreferences.getInt(paramInt + "preload_switch" + paramString, -1);
    this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(paramInt + "preload" + paramString, false);
    this.jdField_b_of_type_Boolean = localSharedPreferences.getBoolean(paramInt + "preload_data" + paramString, false);
    this.jdField_b_of_type_Int = localSharedPreferences.getInt(paramInt + "mem_limit" + paramString, 256);
    this.jdField_a_of_type_JavaLangString = localSharedPreferences.getString(paramInt + "ext1" + paramString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimh
 * JD-Core Version:    0.7.0.1
 */