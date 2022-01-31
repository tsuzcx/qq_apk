import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager.1;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager.2;
import java.io.File;
import java.util.HashMap;

public class bkdc
{
  public static final String a;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new bkdd(this);
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  private TMAssistantDownloadSettingClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadSettingClient;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private String jdField_b_of_type_JavaLangString;
  private HashMap<String, bkde> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = bkdc.class.getName();
  }
  
  public bkdc(Context paramContext)
  {
    TMAssistantDownloadManager localTMAssistantDownloadManager = TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext());
    this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_JavaLangString + Process.myPid() + "_" + System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = localTMAssistantDownloadManager.getDownloadSDKClient(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKSettingClient();
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext()).releaseDownloadSDKClient(this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new TroopHWFileDownloadManager.2(this, paramString), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2, bkde parambkde)
  {
    String str = paramString2.substring(paramString2.lastIndexOf("/") + 1);
    File localFile = new File(paramString2);
    if (localFile.exists())
    {
      if (parambkde != null)
      {
        parambkde.a(paramString1, localFile.length(), localFile.length());
        parambkde.a(paramString1, 3, 0, null, paramString2);
      }
      return;
    }
    if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, parambkde);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    }
    ThreadManager.post(new TroopHWFileDownloadManager.1(this, paramString1, str), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdc
 * JD-Core Version:    0.7.0.1
 */