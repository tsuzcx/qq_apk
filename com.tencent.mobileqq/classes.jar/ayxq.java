import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;

final class ayxq
  extends amky
{
  ayxq(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----locate");
    long l1 = System.currentTimeMillis();
    long l2 = ayxp.a();
    bjmr.a(paramInt, this.businessId, l1 - l2);
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      ayxp.a(LbsDataV2.convertFromSoso(paramSosoLbsInfo.a));
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "[QZ_LBS_MODULE]onLocationFinish succeed! gps=" + ayxp.a());
    }
    for (;;)
    {
      ayxp.a(paramInt);
      return;
      QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "[QZ_LBS_MODULE]onLocationFinish failed: error in force gps info update..");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxq
 * JD-Core Version:    0.7.0.1
 */