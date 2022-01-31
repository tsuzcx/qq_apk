import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bjfk
  extends tez
{
  bjfk(bjfj parambjfj, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Bjfi.jdField_a_of_type_Double = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      this.a.jdField_a_of_type_Bjfi.b = paramSosoLbsInfo.a.b;
      veg.b("FacePoiManager", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Bjfi.jdField_a_of_type_Double + " longitude=" + this.a.jdField_a_of_type_Bjfi.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Bjfi.a();
      }
      return;
    }
    this.a.jdField_a_of_type_Bjfi.jdField_a_of_type_Double = 0.0D;
    this.a.jdField_a_of_type_Bjfi.b = 0.0D;
    veg.b("FacePoiManager", "onLocationUpdate() error");
    this.a.jdField_a_of_type_Bjfi.jdField_a_of_type_Bjfl.a(false, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfk
 * JD-Core Version:    0.7.0.1
 */