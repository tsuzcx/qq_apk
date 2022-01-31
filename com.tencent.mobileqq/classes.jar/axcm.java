import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;

final class axcm
  extends akui
{
  axcm(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----locate");
    long l1 = System.currentTimeMillis();
    long l2 = axcl.a();
    bhlg.a(paramInt, this.businessId, l1 - l2);
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      axcl.a(LbsDataV2.convertFromSoso(paramSosoLbsInfo.a));
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "[QZ_LBS_MODULE]onLocationFinish succeed! gps=" + axcl.a());
    }
    for (;;)
    {
      axcl.a(paramInt);
      return;
      QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "[QZ_LBS_MODULE]onLocationFinish failed: error in force gps info update..");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axcm
 * JD-Core Version:    0.7.0.1
 */