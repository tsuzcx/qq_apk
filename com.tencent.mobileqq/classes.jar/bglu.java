import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

class bglu
  implements aaav
{
  bglu(bglt parambglt) {}
  
  public void onReceive(boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof QQCircleCountergroup.GetGroupCountRsp)))
    {
      paramString = (QQCircleCountergroup.GetGroupCountRsp)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("QCircleMsgProcessor", 2, String.format(Locale.getDefault(), "rsp.content=%s,rsp.count=%d, rsp.hasMore=%d, rsp.iconUrl=%s, rsp.latestFeedTime=%s, rsp.timeInterval=%s", new Object[] { paramString.content.get(), Integer.valueOf(paramString.count.get()), Integer.valueOf(paramString.hasMore.get()), paramString.iconUrl.get(), Integer.valueOf(paramString.latestFeedTime.get()), Integer.valueOf(paramString.timeInterval.get()) }));
      }
      if ((paramString.count.get() < 1) || (TextUtils.isEmpty(paramString.content.get())))
      {
        QLog.d("QCircleMsgProcessor", 2, "rsp.count.get() < 1 || TextUtils.isEmpty(rsp.content.get())");
        return;
      }
      bglt.a(this.a, paramString);
      bglt.a(this.a, NetConnInfoCenter.getServerTimeMillis() / 1000L);
      bglt.b(this.a, paramString.timeInterval.get());
      bdll.b(null, "dc00898", "", String.valueOf(bglt.a(this.a)), "0X800B24E", "0X800B24E", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("QCircleMsgProcessor", 2, "retCode:" + paramLong + ", errMsg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglu
 * JD-Core Version:    0.7.0.1
 */