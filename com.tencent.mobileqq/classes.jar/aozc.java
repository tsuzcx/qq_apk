import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aozc
  extends aoxg
{
  public aozc(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!bnkq.a().b(this.e, this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("QzoneAction", 1, "has no right to handle this schema");
        return false;
      }
      String str;
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqzone"))
      {
        str = "mqzone" + this.jdField_a_of_type_JavaLangString.substring("mqqzone".length());
        if (TextUtils.isEmpty(str)) {
          break label198;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("cmd", "Schema");
        localIntent.putExtra("schema", str);
        uqt.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.d);
        ueg.a(this.jdField_a_of_type_AndroidContentContext, this.d, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          return true;
          str = (String)blhn.a(this.jdField_a_of_type_JavaLangString).get("schema");
          if (!TextUtils.isEmpty(str)) {
            try
            {
              str = new String(Base64.decode(str, 0), "utf-8");
            }
            catch (Exception localException)
            {
              QLog.e("QzoneAction", 1, localException, new Object[0]);
            }
          }
        }
        Object localObject = null;
        break;
        label198:
        QLog.e("QzoneAction", 1, "gotoQzoneHandleSchema,schema=null");
      }
    }
    return false;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneAction", 1, "doAction error: " + localException.getMessage());
      a("QzoneAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozc
 * JD-Core Version:    0.7.0.1
 */