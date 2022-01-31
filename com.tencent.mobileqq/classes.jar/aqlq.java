import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper.GetLoginKeyDataListener.1;
import com.tencent.qphone.base.util.QLog;

public class aqlq
  implements aqkh
{
  private final long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final InstalledPlugin jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin;
  private final IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public aqlq(aqln paramaqln, String paramString, IVPluginInfo paramIVPluginInfo, InstalledPlugin paramInstalledPlugin, boolean paramBoolean, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = paramIVPluginInfo;
    this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin = paramInstalledPlugin;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!paramBoolean2))
    {
      aqln.a(this.jdField_a_of_type_Aqln).a(5, new Object[] { "" });
      return;
    }
    if (paramBoolean1) {}
    for (long l = 0L;; l = 2000L)
    {
      if (!this.b) {
        break label66;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("HuayangPluginNewDownloader", 2, "需要stop");
      return;
    }
    label66:
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new HuayangDowanloadHelper.GetLoginKeyDataListener.1(this, paramBoolean1, paramBoolean2), l);
  }
  
  public void a()
  {
    this.b = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    long l1;
    label99:
    String str;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_AndroidOsBundle = aqln.a(this.jdField_a_of_type_Aqln).a().a.getExtras();
        if ("Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
          aqmd.a("2653752");
        }
        a(this.jdField_a_of_type_Boolean, paramBoolean);
        long l2 = System.currentTimeMillis();
        if (!"Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
          break label421;
        }
        l1 = aqln.a(this.jdField_a_of_type_Aqln);
        l1 = l2 - l1;
        if (QLog.isColorLevel()) {
          QLog.d("HuayangPluginNewDownloader", 2, "拉取票据完成 耗时：" + l1 + "appId = " + paramString + " isSuccess =  " + paramBoolean + " code = " + paramInt);
        }
        if (!aqmd.jdField_a_of_type_Boolean) {
          break label433;
        }
        str = "huayang";
        label175:
        if (!paramBoolean) {
          break label440;
        }
        i = 1;
        label182:
        urp.a(str, "getLoginKey", i, (int)l1, new String[] { aqln.c(this.jdField_a_of_type_Aqln), paramInt + "", paramString, "8.2.6" });
        paramString = aqln.a(this.jdField_a_of_type_Aqln).opName(aqln.a(this.jdField_a_of_type_Aqln)).opType("getLoginKey");
        if (!paramBoolean) {
          break label446;
        }
      }
    }
    label421:
    label433:
    label440:
    label446:
    for (int i = j;; i = 0)
    {
      paramString.opIn(i).opResult(paramInt).report();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_AndroidOsBundle = aqpp.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, aqln.a(this.jdField_a_of_type_Aqln));
      if (!"Od".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
      aqmd.a("2691711");
      break;
      if ("Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
        aqmd.a("2653753");
      }
      for (;;)
      {
        Toast.makeText(aqln.a(this.jdField_a_of_type_Aqln), ajjy.a(2131639842) + paramInt, 0).show();
        break;
        if ("Od".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
          aqmd.a("2691712");
        }
      }
      l1 = aqln.b(this.jdField_a_of_type_Aqln);
      break label99;
      str = "group_video";
      break label175;
      i = 0;
      break label182;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqlq
 * JD-Core Version:    0.7.0.1
 */