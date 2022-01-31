import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bhkf
  extends ssd
{
  bhkf(bhke parambhke, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      urk.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.b);
      bhkc.a(this.a.jdField_a_of_type_Bhkc, true);
      bhkc.a(this.a.jdField_a_of_type_Bhkc, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_Bhkc.a(null);
      return;
    }
    urk.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhkf
 * JD-Core Version:    0.7.0.1
 */