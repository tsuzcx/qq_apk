import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bjgb
  extends tew
{
  bjgb(bjga parambjga, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Bjfz.jdField_a_of_type_Double = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      this.a.jdField_a_of_type_Bjfz.b = paramSosoLbsInfo.a.b;
      ved.b("FacePoiManager", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Bjfz.jdField_a_of_type_Double + " longitude=" + this.a.jdField_a_of_type_Bjfz.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Bjfz.a();
      }
      return;
    }
    this.a.jdField_a_of_type_Bjfz.jdField_a_of_type_Double = 0.0D;
    this.a.jdField_a_of_type_Bjfz.b = 0.0D;
    ved.b("FacePoiManager", "onLocationUpdate() error");
    this.a.jdField_a_of_type_Bjfz.jdField_a_of_type_Bjgc.a(false, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgb
 * JD-Core Version:    0.7.0.1
 */