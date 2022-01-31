import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class amqa
  implements bfob
{
  private amqb jdField_a_of_type_Amqb;
  private String jdField_a_of_type_JavaLangString;
  
  public amqa(String paramString, amqb paramamqb)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Amqb = paramamqb;
  }
  
  public int a(String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    int i = -20;
    if (paramString1.equals(BaseApplicationImpl.sApplication.getPackageName()))
    {
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        paramString1 = null;
        paramInt = -1;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Amqb != null) {
          this.jdField_a_of_type_Amqb.a(paramInt);
        }
        QLog.d("UpgradeController", 1, "writeCodeToApk:" + this.jdField_a_of_type_JavaLangString + ", forFile:" + paramString2 + " result: " + paramInt, paramString1);
        return paramInt;
        if (this.jdField_a_of_type_JavaLangString.length() == 0)
        {
          paramString1 = null;
          paramInt = 0;
        }
        else
        {
          try
          {
            paramString1 = new File(paramString2);
            paramBundle = new File(paramString2 + "~tmp");
            if (paramBundle.exists()) {
              paramBundle.delete();
            }
            paramString1.renameTo(paramBundle);
            bhqd.a(paramBundle, this.jdField_a_of_type_JavaLangString);
            paramBundle.renameTo(paramString1);
            paramString1 = null;
            paramInt = 0;
          }
          catch (FileNotFoundException paramString1)
          {
            paramInt = -30;
          }
          catch (IOException paramString1)
          {
            paramInt = i;
            if (paramString1 != null)
            {
              paramInt = i;
              if (paramString1.getMessage() != null)
              {
                paramInt = i;
                if (paramString1.getMessage().contains("space")) {
                  paramInt = -10;
                }
              }
            }
          }
          catch (Exception paramString1)
          {
            paramInt = -20;
          }
        }
      }
    }
    return -1;
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (BaseApplicationImpl.sApplication.getPackageName().equals(paramString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("UpgradeController", 4, "syncVersionCodeToTool:" + paramString + ", versionCode:" + paramInt);
      }
      if ((this.jdField_a_of_type_Amqb != null) && (!this.jdField_a_of_type_Amqb.a(paramInt))) {
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqa
 * JD-Core Version:    0.7.0.1
 */