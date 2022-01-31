import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import mqq.app.ISecurityFileHelper;

public class bioo
  implements ISecurityFileHelper
{
  private FilenameFilter jdField_a_of_type_JavaIoFilenameFilter = new biop(this);
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{5,}");
  
  public String declareBusinessFileName()
  {
    return "QQComicOffline";
  }
  
  public boolean doMigrate(File paramFile)
  {
    boolean bool2 = false;
    File localFile1 = new File(alof.aW, "/tencent/MobileQQ/qqcomic/offline/");
    String[] arrayOfString = localFile1.list(this.jdField_a_of_type_JavaIoFilenameFilter);
    boolean bool1;
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      bool1 = true;
      return bool1;
    }
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label220;
      }
      Object localObject = arrayOfString[i];
      File localFile2 = new File(localFile1, (String)localObject);
      localObject = new File(paramFile.getAbsolutePath() + File.separator + (String)localObject + File.separator + declareBusinessFileName());
      int k = bdhb.a(localFile2.getAbsolutePath(), ((File)localObject).getAbsolutePath());
      QLog.d("VipComicSecurityFileHelper", 2, "doMigrate：" + declareBusinessFileName() + " result = " + k + " fromFile = " + localFile2.getAbsolutePath() + " targetFile = " + ((File)localObject).getAbsolutePath());
      bool1 = bool2;
      if (k != 0) {
        break;
      }
      i += 1;
    }
    label220:
    return true;
  }
  
  public boolean needMigration()
  {
    Object localObject = new File(alof.aW, "/tencent/MobileQQ/qqcomic/offline/").list(this.jdField_a_of_type_JavaIoFilenameFilter);
    boolean bool;
    StringBuilder localStringBuilder;
    if ((localObject != null) && (localObject.length > 0))
    {
      bool = true;
      localStringBuilder = new StringBuilder().append("needMigration: uinDirs.len=");
      if (localObject != null) {
        break label74;
      }
    }
    label74:
    for (localObject = Integer.valueOf(0);; localObject = localObject.length + " needMigration=" + bool)
    {
      QLog.i("VipComicSecurityFileHelper", 2, localObject);
      return bool;
      bool = false;
      break;
    }
  }
  
  public File oldBusinessDir(String paramString)
  {
    return new File(new File(alof.aW, "/tencent/MobileQQ/qqcomic/offline/"), paramString);
  }
  
  public boolean oldBusinessDirExist(String paramString)
  {
    paramString = oldBusinessDir(paramString);
    return (paramString.isDirectory()) && (paramString.exists());
  }
  
  public String[] reportHistoryFileInfo()
  {
    long l2 = 0L;
    String[] arrayOfString1 = new String[2];
    File localFile = new File(alof.aW, "/tencent/MobileQQ/qqcomic/offline/");
    String[] arrayOfString2 = localFile.list(this.jdField_a_of_type_JavaIoFilenameFilter);
    if ((arrayOfString2 != null) && (arrayOfString2.length > 0))
    {
      int j = arrayOfString2.length;
      int i = 0;
      long l1 = 0L;
      while (i < j)
      {
        String str = arrayOfString2[i];
        l2 += bdhb.b(new File(localFile, str).getAbsolutePath());
        l1 += bdhb.c(new File(localFile, str).getAbsolutePath());
        i += 1;
      }
      arrayOfString1[0] = Long.toString(l2);
      arrayOfString1[1] = Long.toString(l1);
      QLog.d("VipComicSecurityFileHelper", 2, "reportHistoryFileInfo:" + declareBusinessFileName() + " fileAmount = " + l1 + " fileSize = " + l2);
    }
    return arrayOfString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bioo
 * JD-Core Version:    0.7.0.1
 */