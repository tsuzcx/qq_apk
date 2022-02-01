import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.VipProxyRreLoadReaderProcess;
import java.util.Calendar;
import mqq.manager.Manager;

public class bmor
  implements Manager
{
  public long a;
  public bmaw a;
  public bmax a;
  public bmos a;
  public bmot a;
  protected QQAppInterface a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public bmor(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = (bhlo.d() / 1048576L);
    c();
  }
  
  private void a(bmat parambmat, String paramString, int paramInt)
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
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "qqreaderplugin.apk";
    localbmgt.d = "qqreader";
    localbmgt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localbmgt.e = "com.qqreader.ReaderPreloadReaderProcess";
    localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (parambmat != null)
    {
      localbmgt.jdField_a_of_type_Avsk = parambmat.jdField_a_of_type_Avsk;
      parambmat.a(2, paramString, paramInt);
    }
    bmgk.b(BaseApplicationImpl.getContext(), localbmgt);
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
      this.jdField_a_of_type_Bmax = new bmax(769, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (this.jdField_a_of_type_Bmax.jdField_a_of_type_Int != -1) {
        this.b = true;
      }
      this.c = this.jdField_a_of_type_Bmax.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Bmaw = bmaw.a(this.jdField_a_of_type_Bmax.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bmaw == null) {
        this.jdField_a_of_type_Bmaw = new bmaw();
      }
      return;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhrx.a()).getInt("usedTimes" + paramString, 0);
  }
  
  public long a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhrx.a()).getLong(paramString, -1L);
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
        bmay.a((bmau)localObject, 500L);
      }
      return;
      if (this.jdField_a_of_type_Bmot == null) {
        this.jdField_a_of_type_Bmot = new bmot(this, 6);
      }
      localObject = this.jdField_a_of_type_Bmot;
      continue;
      if (this.jdField_a_of_type_Bmos == null) {
        this.jdField_a_of_type_Bmos = new bmos(this, 9999, "qqreader_qqbrowser_preload");
      }
      localObject = this.jdField_a_of_type_Bmos;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhrx.a()).edit().putLong(paramString, paramLong).commit();
  }
  
  public int[] a(String paramString)
  {
    int[] arrayOfInt = new int[24];
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhrx.a());
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
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", bhrx.a());
    int i = a(str);
    localSharedPreferences.edit().putInt("usedTimes" + str, i + 1).commit();
    i = Calendar.getInstance().get(11);
    int j = localSharedPreferences.getInt("usedTimesInHour" + i + ":" + str, 0);
    localSharedPreferences.edit().putInt("usedTimesInHour" + i + ":" + str, j + 1).commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmor
 * JD-Core Version:    0.7.0.1
 */