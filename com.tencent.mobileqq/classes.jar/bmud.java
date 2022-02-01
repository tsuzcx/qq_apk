import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bmud
  extends vwu
{
  bmud(bmuc parambmuc, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      xvv.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.mLocation.mLat02 + " longitude=" + paramSosoLbsInfo.mLocation.mLon02);
      bmua.a(this.a.jdField_a_of_type_Bmua, true);
      bmua.a(this.a.jdField_a_of_type_Bmua, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_Bmua.a(null);
      return;
    }
    xvv.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmud
 * JD-Core Version:    0.7.0.1
 */