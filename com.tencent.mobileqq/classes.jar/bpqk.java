import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bpqk
  extends wve
{
  bpqk(bpqj parambpqj, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      yuk.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.b);
      bpqh.a(this.a.jdField_a_of_type_Bpqh, true);
      bpqh.a(this.a.jdField_a_of_type_Bpqh, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_Bpqh.a(null);
      return;
    }
    yuk.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqk
 * JD-Core Version:    0.7.0.1
 */