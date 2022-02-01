import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bggd
  extends aqde
{
  private static String a()
  {
    if (SystemUtil.isExistSDCard()) {}
    for (String str1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
    {
      String str2 = str1;
      if (str1 != null)
      {
        str2 = str1;
        if (!str1.endsWith(File.separator)) {
          str2 = str1 + File.separator;
        }
      }
      return str2 + "troopgamecard/res" + File.separator;
    }
  }
  
  public String a(aqdi paramaqdi)
  {
    paramaqdi = a() + paramaqdi.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardResHandler", 2, "getUnzipDirPath dir = " + paramaqdi);
    }
    return paramaqdi;
  }
  
  public boolean a(aqdi paramaqdi)
  {
    String str = b(paramaqdi);
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    Object localObject1 = new File(str);
    boolean bool = ((File)localObject1).exists();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardResHandler", 2, "needDownload path[" + str + "], exists[" + bool + "]");
    }
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardResHandler", 2, "needDownload exists, path[" + str + "]");
      }
      return true;
    }
    Object localObject2 = null;
    try
    {
      localObject1 = bkvq.a((File)localObject1);
      if (!TextUtils.equals((CharSequence)localObject1, paramaqdi.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameCardResHandler", 2, "needDownload exists, path[" + str + "], filemd5[" + (String)localObject1 + "], downloadMd5[" + paramaqdi.b + "]");
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopGameCardResHandler", 2, "needDownload Exception" + localException);
          localObject1 = localObject2;
        }
      }
    }
    return super.a(paramaqdi);
  }
  
  public boolean a(aqdi paramaqdi, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramaqdi.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).getLong(paramaqdi.b, -1L);
      paramaqdi = new File(a(paramaqdi));
      paramBoolean = bool2;
      if (paramaqdi.exists())
      {
        long l2 = paramaqdi.lastModified();
        l1 = l2;
        paramBoolean = bool2;
        if (l3 > 0L)
        {
          l1 = l2;
          paramBoolean = bool2;
          if (l3 != l2)
          {
            paramBoolean = false;
            l1 = l2;
          }
        }
      }
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopGameCardResHandler", 2, "verifyUnzipDir result = " + paramBoolean + ",recordedModifyTime = " + l3 + ",realModifyTime = " + l1);
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(aqdi paramaqdi)
  {
    if (paramaqdi.a) {}
    for (paramaqdi = a() + paramaqdi.b + ".end";; paramaqdi = a() + paramaqdi.b + paramaqdi.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardResHandler", 2, "getDownloadPath path[" + paramaqdi + "]");
      }
      return paramaqdi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggd
 * JD-Core Version:    0.7.0.1
 */