import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class axce
  extends axcb
{
  public axce(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
  }
  
  public axaa a()
  {
    boolean bool2 = false;
    MsgBackupResEntity localMsgBackupResEntity = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    axaa localaxaa = new axaa();
    String str1 = b(localMsgBackupResEntity);
    if (str1 == null)
    {
      a("getResDownloadObject realPath is null");
      localaxaa.jdField_a_of_type_Boolean = false;
      return localaxaa;
    }
    String str2 = a(str1);
    boolean bool3 = a(str2);
    boolean bool4 = a(str1);
    if (QLog.isColorLevel()) {
      a("getResDownloadObject,entity:" + localMsgBackupResEntity.toLogString() + " tempPath:" + str2 + " exist:" + bool3 + " realPath:" + str1 + " exist:" + bool4);
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!bool4) {
        bool1 = true;
      }
    }
    localaxaa.jdField_a_of_type_Boolean = bool1;
    localaxaa.jdField_a_of_type_JavaLangString = str2;
    return localaxaa;
  }
  
  public String a()
  {
    String str = b(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity);
    if (TextUtils.isEmpty(str))
    {
      a("getTempPath realPath is null");
      return null;
    }
    return a(str);
  }
  
  public String a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilMap.get("md5");
    String str2 = (String)this.jdField_a_of_type_JavaUtilMap.get("isOriginal");
    int i;
    if (str2 != null) {
      if (!str2.equals("0")) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = paramMsgBackupResEntity.msgSubType;
      if (j == 1) {
        if (i == 0) {
          paramMsgBackupResEntity = "chatimg";
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str1))
        {
          try
          {
            paramMsgBackupResEntity = AbsDownloader.getFilePath(new URL(paramMsgBackupResEntity, null, str1).toString());
            return paramMsgBackupResEntity;
          }
          catch (MalformedURLException paramMsgBackupResEntity)
          {
            paramMsgBackupResEntity.printStackTrace();
          }
          i = 0;
          break;
          paramMsgBackupResEntity = "chatraw";
          continue;
          if (j == 2) {
            paramMsgBackupResEntity = "chatimg";
          } else if (j == 3) {
            paramMsgBackupResEntity = "chatthumb";
          } else {
            return null;
          }
        }
      }
      return null;
      i = 1;
    }
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = paramString.substring(a());
      paramString = axcp.jdField_a_of_type_JavaLangString + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String b()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity);
  }
  
  public String b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return a(paramMsgBackupResEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axce
 * JD-Core Version:    0.7.0.1
 */