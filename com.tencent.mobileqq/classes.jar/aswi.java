import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.proxyinner.plugin.loader.QTProxyService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;

public class aswi
  implements PluginProcessKiller
{
  private static HashMap<String, aswi> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private asuy jdField_a_of_type_Asuy = new asuy();
  private aswv jdField_a_of_type_Aswv;
  private aswx jdField_a_of_type_Aswx = new aswj(this);
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  private String jdField_a_of_type_JavaLangString;
  private List<aswl> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, IVPluginInfo> jdField_a_of_type_JavaUtilMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private aswi(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.d = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment(paramString2);
    this.jdField_a_of_type_Aswv = aswv.a(paramContext, paramString1, paramString2);
  }
  
  public static aswi a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = paramString2 + paramString1;
      aswi localaswi2 = (aswi)jdField_a_of_type_JavaUtilHashMap.get(str);
      aswi localaswi1 = localaswi2;
      if (localaswi2 == null)
      {
        localaswi1 = new aswi(paramContext, paramString1, paramString2);
        jdField_a_of_type_JavaUtilHashMap.put(str, localaswi1);
      }
      return localaswi1;
    }
    finally {}
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, boolean paramBoolean, long paramLong)
  {
    IVPluginInfo localIVPluginInfo = (IVPluginInfo)this.jdField_a_of_type_JavaUtilMap.get(paramInstalledPlugin.pluginPackageName);
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "开始拉取AI票据：" + localIVPluginInfo.jdField_a_of_type_Int);
    }
    paramInstalledPlugin = new aswl(this, this.d, localIVPluginInfo, paramInstalledPlugin, paramBoolean, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(paramInstalledPlugin);
    if (localIVPluginInfo.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Asuy.a(this.jdField_a_of_type_JavaLangString, localIVPluginInfo.jdField_a_of_type_JavaLangString, localIVPluginInfo.c, localIVPluginInfo.jdField_b_of_type_JavaLangString, paramInstalledPlugin, true, localIVPluginInfo.k);
    }
    while (localIVPluginInfo.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    AppInterface localAppInterface = (AppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null);
    this.jdField_a_of_type_Asuy.a(localAppInterface, localIVPluginInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, localIVPluginInfo.jdField_b_of_type_JavaLangString, paramInstalledPlugin);
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aswl)localIterator.next()).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "setStop");
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aswv.a(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.c = null;
    if (!bdee.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_a_of_type_Aswv.a();
    }
    this.jdField_a_of_type_Aswv.b();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, IVPluginInfo> paramMap)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aswv.jdField_a_of_type_JavaLangString = paramString2;
    if (!paramString2.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Asuy.a();
    }
    aswy.jdField_a_of_type_Boolean = TextUtils.equals(paramString1, "hy_sixgod");
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.c = paramString4;
    this.e = paramString1;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aswv.a(this.jdField_a_of_type_Aswx);
    this.jdField_a_of_type_Aswv.a(paramString1, paramString4, this.d, paramMap);
  }
  
  public void onKillPluginProcess()
  {
    int i = 1;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new RuntimeException(alpo.a(2131706009));
    }
    this.jdField_a_of_type_Boolean = true;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QTProxyService.class);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    long l = System.currentTimeMillis();
    QLog.i("HuayangPluginNewDownloader", 2, "bindService ");
    this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, new aswk(this, localCountDownLatch), 1);
    for (;;)
    {
      try
      {
        if (localCountDownLatch.await(3L, TimeUnit.SECONDS)) {
          continue;
        }
        if (i != 0)
        {
          QLog.e("HuayangPluginNewDownloader", 2, "onKillPluginProcess timeout");
          aswr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getPackageName() + ":troophomework");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      QLog.i("HuayangPluginNewDownloader", 2, "onKillPluginProcess end costTime:" + (System.currentTimeMillis() - l));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswi
 * JD-Core Version:    0.7.0.1
 */