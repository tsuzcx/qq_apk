import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bopc
  extends wrj
{
  bopc(bopb parambopb, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Bopa.jdField_a_of_type_Double = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      this.a.jdField_a_of_type_Bopa.b = paramSosoLbsInfo.a.b;
      yqp.b("FacePoiManager", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Bopa.jdField_a_of_type_Double + " longitude=" + this.a.jdField_a_of_type_Bopa.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Bopa.a();
      }
      return;
    }
    this.a.jdField_a_of_type_Bopa.jdField_a_of_type_Double = 0.0D;
    this.a.jdField_a_of_type_Bopa.b = 0.0D;
    yqp.b("FacePoiManager", "onLocationUpdate() error");
    this.a.jdField_a_of_type_Bopa.jdField_a_of_type_Bopd.a(false, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopc
 * JD-Core Version:    0.7.0.1
 */