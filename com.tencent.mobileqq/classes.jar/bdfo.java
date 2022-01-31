import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class bdfo
{
  public float a;
  public SessionInfo a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e = "";
  
  public bdfo(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("appName");
    this.b = paramBundle.getString("appView");
    this.c = paramBundle.getString("appMinVersion");
    this.d = paramBundle.getString("metaData");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale", 1.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramBundle = paramBundle.getString("troopUin");
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfo
 * JD-Core Version:    0.7.0.1
 */