import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONObject;

public class bhml
  implements Manager
{
  bhyn jdField_a_of_type_Bhyn = new bhmm(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bhyq jdField_a_of_type_Bhyq;
  public bhyu a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bhml(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bhyq = ((bhyq)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY));
  }
  
  public static Bitmap a(long paramLong)
  {
    if (paramLong == 0L) {}
    for (;;)
    {
      return null;
      Object localObject = a(paramLong, 1);
      if (new File((String)localObject).exists())
      {
        try
        {
          localObject = BitmapFactory.decodeFile((String)localObject);
          return localObject;
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
        if (QLog.isColorLevel()) {
          QLog.d("ColorRingManager", 2, "getCoverBitmap OOM.");
        }
      }
    }
  }
  
  public static String a(long paramLong, int paramInt)
  {
    if (paramLong == 0L) {}
    do
    {
      return "";
      if (paramInt == 2) {
        return bhmk.a + File.separator + paramLong + File.separator + "config.txt";
      }
      if (paramInt == 1) {
        return bhmk.a + File.separator + paramLong + File.separator + "cover.jpg";
      }
    } while (paramInt != 3);
    return bhmk.a + File.separator + paramLong + File.separator + "ring.mp3";
  }
  
  public static String a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    Object localObject = "";
    if (paramInt2 == 3)
    {
      localObject = bibh.a(paramAppRuntime, 0, null).getString("_3_" + paramInt1, null);
      paramAppRuntime = (AppRuntime)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppRuntime = bhnp.a("colorringAudio");
      }
    }
    for (;;)
    {
      localObject = paramAppRuntime;
      if (paramAppRuntime != null) {
        localObject = paramAppRuntime.replace("[id]", String.valueOf(paramInt1));
      }
      return localObject;
      if (paramInt2 == 2)
      {
        paramAppRuntime = bhnp.a("colorringConfig");
      }
      else
      {
        paramAppRuntime = (AppRuntime)localObject;
        if (paramInt2 == 1) {
          paramAppRuntime = bhnp.a("colorringCover");
        }
      }
    }
  }
  
  public static JSONObject a(long paramLong)
  {
    Object localObject = new File(bhmk.a + File.separator + paramLong + File.separator + "config.txt");
    try
    {
      localObject = FileUtils.readFileContent((File)localObject);
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bhyq.a(1).a(true, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, ">>startDownload, id=" + paramInt1);
    }
    if (paramInt1 == 0) {}
    label284:
    do
    {
      return;
      String str = a(paramInt1, paramInt2);
      File localFile = new File(str);
      if ((localFile.exists()) && (localFile.isFile())) {}
      Bundle localBundle;
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorRingManager", 2, "startDownload exists(), id=" + paramInt1 + ", resType=ring3,, isIPC=" + paramBoolean + ", srcType=" + paramInt3 + ", fileExist=" + bool);
        }
        if ((bool) && (!paramBoolean)) {
          break;
        }
        localBundle = new Bundle();
        localBundle.putInt("callId", paramInt1);
        localBundle.putString("path", str);
        localBundle.putBoolean("isIPC", paramBoolean);
        localBundle.putInt("resourceType", paramInt2);
        localBundle.putInt("srcType", paramInt3);
        localBundle.putString("path", str);
        localBundle.putString("colorType", paramString);
        paramString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2);
        if (!bool) {
          break label284;
        }
        localBundle.putBoolean("isExists", true);
        paramString = new bhyo(paramString, localFile);
        paramString.a(3);
        paramString.a = 0;
        paramString.a(localBundle);
        this.jdField_a_of_type_Bhyn.onDone(paramString);
        return;
      }
      paramString = new bhyo(paramString, new File(str + ".tmp"));
      paramString.e = 3145728L;
      paramString.b = true;
      this.jdField_a_of_type_Bhyq.a(1).a(paramString, this.jdField_a_of_type_Bhyn, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ColorRingManager", 2, "<<startDownload, id=" + paramInt1);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bhyu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhml
 * JD-Core Version:    0.7.0.1
 */