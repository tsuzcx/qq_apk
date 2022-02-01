import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.VipProxyRreLoadReaderProcess;
import java.util.Calendar;
import mqq.manager.Manager;

public class bmeh
  implements Manager
{
  public long a;
  public blqc a;
  public blqd a;
  public bmei a;
  public bmej a;
  protected QQAppInterface a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public bmeh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = (DeviceInfoUtil.getSystemTotalMemory() / 1048576L);
    c();
  }
  
  private void a(blpz paramblpz, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRProcessManager", 2, "run startQQReaderProcess");
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), VipProxyRreLoadReaderProcess.class);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("params_uin_for_reader", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("is_preload_reader_plugin", true);
    blwh localblwh = new blwh(0);
    localblwh.b = "qqreaderplugin.apk";
    localblwh.d = "qqreader";
    localblwh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localblwh.e = "com.qqreader.ReaderPreloadReaderProcess";
    localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (paramblpz != null)
    {
      localblwh.jdField_a_of_type_Avlg = paramblpz.jdField_a_of_type_Avlg;
      paramblpz.a(2, paramString, paramInt);
    }
    blvy.b(BaseApplicationImpl.getContext(), localblwh);
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      c();
      if (QLog.isColorLevel()) {
        QLog.d("QRProcessManager", 2, "pluginType:1  preload:fail:dpc");
      }
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  private void c()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 1) {
        this.jdField_a_of_type_Boolean = "1".equals(localObject[0]);
      }
    }
  }
  
  private void d()
  {
    try
    {
      if (this.b) {
        return;
      }
      this.jdField_a_of_type_Blqd = new blqd(769, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (this.jdField_a_of_type_Blqd.jdField_a_of_type_Int != -1) {
        this.b = true;
      }
      this.c = this.jdField_a_of_type_Blqd.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Blqc = blqc.a(this.jdField_a_of_type_Blqd.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Blqc == null) {
        this.jdField_a_of_type_Blqc = new blqc();
      }
      return;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhhl.a()).getInt("usedTimes" + paramString, 0);
  }
  
  public long a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhhl.a()).getLong(paramString, -1L);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRProcessManager", 2, "firstTimeLoadApk");
    }
    a(null, "", 0);
  }
  
  public void a(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        blqe.a((blqa)localObject, 500L);
      }
      return;
      if (this.jdField_a_of_type_Bmej == null) {
        this.jdField_a_of_type_Bmej = new bmej(this, 6);
      }
      localObject = this.jdField_a_of_type_Bmej;
      continue;
      if (this.jdField_a_of_type_Bmei == null) {
        this.jdField_a_of_type_Bmei = new bmei(this, 9999, "qqreader_qqbrowser_preload");
      }
      localObject = this.jdField_a_of_type_Bmei;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhhl.a()).edit().putLong(paramString, paramLong).commit();
  }
  
  public int[] a(String paramString)
  {
    int[] arrayOfInt = new int[24];
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhhl.a());
    int i = 0;
    while (i < 24)
    {
      arrayOfInt[i] = localSharedPreferences.getInt("usedTimesInHour" + i + ":" + paramString, 0);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhhl.a());
    int i = a(str);
    localSharedPreferences.edit().putInt("usedTimes" + str, i + 1).commit();
    i = Calendar.getInstance().get(11);
    int j = localSharedPreferences.getInt("usedTimesInHour" + i + ":" + str, 0);
    localSharedPreferences.edit().putInt("usedTimesInHour" + i + ":" + str, j + 1).commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeh
 * JD-Core Version:    0.7.0.1
 */