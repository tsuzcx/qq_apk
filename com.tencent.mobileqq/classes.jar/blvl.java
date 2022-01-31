import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class blvl
  extends uxx
{
  blvl(blvk paramblvk, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      wxe.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.b);
      blvi.a(this.a.jdField_a_of_type_Blvi, true);
      blvi.a(this.a.jdField_a_of_type_Blvi, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_Blvi.a(null);
      return;
    }
    wxe.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvl
 * JD-Core Version:    0.7.0.1
 */