import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bojv
  extends wlp
{
  bojv(boju paramboju, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      ykq.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.mLocation.mLat02 + " longitude=" + paramSosoLbsInfo.mLocation.mLon02);
      bojs.a(this.a.jdField_a_of_type_Bojs, true);
      bojs.a(this.a.jdField_a_of_type_Bojs, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_Bojs.a(null);
      return;
    }
    ykq.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojv
 * JD-Core Version:    0.7.0.1
 */