import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bhks
  extends ssd
{
  bhks(bhkr parambhkr, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Bhkq.jdField_a_of_type_Double = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      this.a.jdField_a_of_type_Bhkq.b = paramSosoLbsInfo.a.b;
      urk.b("FacePoiManager", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Bhkq.jdField_a_of_type_Double + " longitude=" + this.a.jdField_a_of_type_Bhkq.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Bhkq.a();
      }
      return;
    }
    this.a.jdField_a_of_type_Bhkq.jdField_a_of_type_Double = 0.0D;
    this.a.jdField_a_of_type_Bhkq.b = 0.0D;
    urk.b("FacePoiManager", "onLocationUpdate() error");
    this.a.jdField_a_of_type_Bhkq.jdField_a_of_type_Bhkt.a(false, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhks
 * JD-Core Version:    0.7.0.1
 */