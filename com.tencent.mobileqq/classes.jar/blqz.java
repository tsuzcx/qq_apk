import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class blqz
  extends uto
{
  blqz(blqy paramblqy, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      wsv.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.b);
      blqw.a(this.a.jdField_a_of_type_Blqw, true);
      blqw.a(this.a.jdField_a_of_type_Blqw, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_Blqw.a(null);
      return;
    }
    wsv.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqz
 * JD-Core Version:    0.7.0.1
 */