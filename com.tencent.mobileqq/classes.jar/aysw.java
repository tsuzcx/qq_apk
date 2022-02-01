import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

public class aysw
  extends aopa
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private WeakReference<aysy> jdField_a_of_type_MqqUtilWeakReference;
  
  public aysw(int paramInt, Intent paramIntent, aysy paramaysy)
  {
    super(4, true, true, 60000L, false, false, "QQSettingRedesign");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaysy);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d3 = 0.0D;
    long l = System.currentTimeMillis();
    Object localObject;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null))
    {
      localObject = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label301;
      }
    }
    label301:
    for (double d1 = paramSosoLbsInfo.a.a;; d1 = 0.0D)
    {
      double d2 = d3;
      if (paramSosoLbsInfo != null)
      {
        d2 = d3;
        if (paramSosoLbsInfo.a != null) {
          d2 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatus", 2, "onLocationFinish() latitude=" + d1 + " longitude=" + d2 + ", address=" + (String)localObject);
      }
      paramSosoLbsInfo = String.format("/ws/geocoder/v1/?get_poi=0&key=%s&location=%s,%s", new Object[] { "7B5BZ-MNDHR-SKFWQ-WAXND-2P45Z-4FFNM", String.valueOf(d1), String.valueOf(d2) });
      localObject = MD5.toMD5(paramSosoLbsInfo + "MaZnPqbKJxWQLLVDEGMXiYarddkxX2Wl").toLowerCase();
      paramSosoLbsInfo = "https://apis.map.qq.com" + paramSosoLbsInfo + "&sig=" + (String)localObject;
      localObject = new HashMap();
      ((HashMap)localObject).put("BUNDLE", new Bundle());
      ((HashMap)localObject).put("CONTEXT", BaseApplicationImpl.getApplication().getApplicationContext());
      new bfpp(paramSosoLbsInfo, "GET", new aysx(this, d1, d2, l), 1000, null).a((HashMap)localObject);
      return;
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysw
 * JD-Core Version:    0.7.0.1
 */