import android.content.Context;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import java.util.List;

public class bdcr
{
  bdcq a;
  
  public bdcr(Context paramContext)
  {
    this.a = new bdcq(paramContext);
  }
  
  public bdcq a()
  {
    return this.a;
  }
  
  public bdcr a(String paramString, Class paramClass1, Class paramClass2, ProcessType paramProcessType)
  {
    bdcs localbdcs = new bdcs();
    localbdcs.jdField_a_of_type_JavaLangString = paramString;
    localbdcs.jdField_a_of_type_JavaLangClass = paramClass1;
    localbdcs.b = paramClass2;
    localbdcs.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType = paramProcessType;
    this.a.jdField_a_of_type_JavaUtilList.add(localbdcs);
    return this;
  }
  
  public bdcr a(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdcr
 * JD-Core Version:    0.7.0.1
 */