import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;

class bjrx
  extends amky
  implements bjrr
{
  private static long jdField_a_of_type_Long;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, bjrx> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  
  private bjrx(String paramString)
  {
    super(paramString, false);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static bjrx a(String paramString)
  {
    Object localObject1 = (bjrx)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        bjrx localbjrx = (bjrx)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localbjrx;
        if (localbjrx == null)
        {
          localObject1 = new bjrx(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public static LbsDataV2.GpsInfo a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    localGpsInfo.accuracy = ((int)paramSosoLocation.jdField_a_of_type_Float);
    localGpsInfo.alt = ((int)paramSosoLocation.jdField_e_of_type_Double);
    if ((paramSosoLocation.d == 0.0D) && (paramSosoLocation.c == 0.0D))
    {
      localGpsInfo.gpsType = 1;
      localGpsInfo.lat = ((int)(paramSosoLocation.jdField_a_of_type_Double * 1000000.0D));
      localGpsInfo.lon = ((int)(paramSosoLocation.b * 1000000.0D));
      return localGpsInfo;
    }
    localGpsInfo.gpsType = 0;
    localGpsInfo.lat = ((int)(paramSosoLocation.c * 1000000.0D));
    localGpsInfo.lon = ((int)(paramSosoLocation.d * 1000000.0D));
    return localGpsInfo;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    try
    {
      jdField_a_of_type_Long = System.currentTimeMillis();
      amkv.a(this);
      return;
    }
    catch (Exception paramHandler)
    {
      QLog.e("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]exception ", paramHandler);
    }
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QZLog.i("QzoneNewLiveInitLocation.NewLbsInterface", 1, "[QZLIVE_LBS_MODULE]----Info");
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    bjmr.a(paramInt, this.jdField_a_of_type_JavaLangString, l1 - l2);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_initlocation_success", false);
    if (paramInt == 0)
    {
      SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.a;
      paramSosoLbsInfo = a(paramSosoLbsInfo.a);
      if ((localSosoLocation != null) && (paramSosoLbsInfo != null) && (!TextUtils.isEmpty(localSosoLocation.jdField_e_of_type_JavaLangString)) && (!localSosoLocation.jdField_e_of_type_JavaLangString.equalsIgnoreCase("unknown")))
      {
        localBundle.putBoolean("key_initlocation_success", true);
        localBundle.putString("key_select_poi_name", localSosoLocation.jdField_e_of_type_JavaLangString.trim());
        localBundle.putString("key_select_poi_default_name", localSosoLocation.jdField_a_of_type_JavaLangString);
        localBundle.putInt("key_select_latitude", paramSosoLbsInfo.lat);
        localBundle.putInt("key_select_longtitude", paramSosoLbsInfo.lon);
        localBundle.putInt("key_select_altitude", paramSosoLbsInfo.alt);
        localBundle.putInt("key_select_gpstype", paramSosoLbsInfo.gpsType);
        QLog.i("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]#onGetDeviceData succeed! just location--->" + paramSosoLbsInfo);
      }
    }
    for (;;)
    {
      localMessage.obj = localBundle;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      QLog.e("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]location failed: error in force gps info update..");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrx
 * JD-Core Version:    0.7.0.1
 */