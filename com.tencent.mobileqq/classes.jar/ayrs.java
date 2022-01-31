import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpInterfaceForTVK;
import com.tencent.qphone.base.util.BaseApplication;
import java.security.InvalidParameterException;
import java.util.HashMap;

public class ayrs
  extends HttpInterfaceForTVK
{
  public int a;
  private ayru jdField_a_of_type_Ayru = new ayru(this, null);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public int a(String arg1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((??? == null) || (paramString2 == null)) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HttpInterfaceForTVKImp", 0, "downLoadSync, url = " + ??? + ", filePath = " + paramString2);
    }
    ayrv localayrv;
    try
    {
      localayrv = new ayrv();
      localayrv.jdField_a_of_type_Aysa = this.jdField_a_of_type_Ayru;
      localayrv.jdField_a_of_type_JavaLangString = ???;
      localayrv.jdField_a_of_type_Int = 0;
      localayrv.c = paramString2;
      localayrv.e = String.valueOf(System.currentTimeMillis());
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if (!(??? instanceof QQAppInterface)) {
        throw new InvalidParameterException("can't get AppInterface");
      }
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HttpInterfaceForTVKImp", 0, "downLoadSync, setp 1", ???);
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        try
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaLangObject.wait(600000L);
            continue;
          }
          ???.put("param_isSuccess", "1");
        }
        catch (InterruptedException paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HttpInterfaceForTVKImp", 0, "downLoadSync, setp 2", paramString2);
          }
          ??? = new HashMap();
          if (this.b != 0) {
            break label289;
          }
        }
        ???.put("param_ErrorCode", String.valueOf(this.c));
        ???.put("param_ErrDesc", this.jdField_a_of_type_JavaLangString);
        ???.put("param_HttpCode", String.valueOf(this.jdField_a_of_type_Int));
        axrl.a(BaseApplication.getContext()).a(null, "HttpInterfaceForTVKImp", true, 0L, 0L, ???, "");
        return this.b;
        ((QQAppInterface)???).getNetEngine(0).a(localayrv);
      }
      label289:
      ???.put("param_isSuccess", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrs
 * JD-Core Version:    0.7.0.1
 */