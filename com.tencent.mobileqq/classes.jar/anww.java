import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.ISecurityFileHelper;

public class anww
  extends anwu
  implements ISecurityFileHelper
{
  public anww()
  {
    super(null);
  }
  
  protected String a()
  {
    return "QQFavoriteMigration";
  }
  
  public String declareBusinessFileName()
  {
    return "QQ_Favorite";
  }
  
  public boolean doMigrate(File paramFile)
  {
    QLog.d("ISecurityFileHelper", 1, "Move QQFavorite file start");
    File localFile = new File(AppConstants.SDCARD_IMG_FAVORITE);
    if ((localFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = anws.a(localFile);
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        localFile = paramFile[i];
        String str = localFile.getName();
        if ((str.length() > 4) && (str.matches("[0-9]{5}.*"))) {
          FileUtils.quickMove(localFile.getAbsolutePath(), AppConstants.SDCARD_IMG_FAVORITE + anws.a(str));
        }
        i += 1;
      }
    }
    a();
    return true;
  }
  
  public boolean needMigration()
  {
    if (a())
    {
      File localFile = new File(AppConstants.SDCARD_IMG_FAVORITE);
      if ((localFile.exists()) && (localFile.isDirectory())) {
        return true;
      }
      a();
    }
    return false;
  }
  
  public File oldBusinessDir(String paramString)
  {
    return null;
  }
  
  public boolean oldBusinessDirExist(String paramString)
  {
    return false;
  }
  
  public String[] reportHistoryFileInfo()
  {
    return new String[] { "0", "0" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anww
 * JD-Core Version:    0.7.0.1
 */