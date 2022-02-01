import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class axcj
  extends axcb
{
  private static final String b = RmVFSUtils.getVFSPath(axcp.jdField_a_of_type_JavaLangString + "shortvideo" + File.separator);
  private String c = (String)this.jdField_a_of_type_JavaUtilMap.get("md5");
  private String d = (String)this.jdField_a_of_type_JavaUtilMap.get("thumbMd5");
  
  public axcj(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.d))) {
      a("md5:" + this.c + " mThumbMD5:" + this.d);
    }
  }
  
  public static String a(String paramString)
  {
    return ShortVideoUtils.getShortVideoThumbPicPath(paramString, "jpg");
  }
  
  public static String b(String paramString)
  {
    paramString = ShortVideoUtils.getShortVideoFileDir(paramString);
    return paramString + "MsgBackUp";
  }
  
  private String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(b);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(b);
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public axaa a()
  {
    MsgBackupResEntity localMsgBackupResEntity = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    int i = localMsgBackupResEntity.msgSubType;
    axaa localaxaa = new axaa();
    String str1 = a();
    String str2 = b();
    boolean bool1 = a(str1);
    boolean bool2 = a(str2);
    if (QLog.isColorLevel()) {
      a("getResDownloadObject,entity:" + localMsgBackupResEntity.toLogString() + " tempPath:" + str1 + " exist:" + bool1 + " realPath:" + str2 + " exist:" + bool2);
    }
    localaxaa.jdField_a_of_type_JavaLangString = str1;
    if ((!bool1) && (!bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      localaxaa.jdField_a_of_type_Boolean = bool1;
      return localaxaa;
    }
  }
  
  public String a()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity.msgSubType)
    {
    default: 
      return null;
    case 4: 
    case 5: 
    case 6: 
      return c(this.c);
    }
    return d(this.d);
  }
  
  public String b()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity.msgSubType)
    {
    default: 
      return null;
    case 4: 
    case 5: 
    case 6: 
      return b(this.c);
    }
    return a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axcj
 * JD-Core Version:    0.7.0.1
 */