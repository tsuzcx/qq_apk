import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class bjfo
  extends tew
{
  bjfo(bjfn parambjfn, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      ved.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.b);
      bjfl.a(this.a.jdField_a_of_type_Bjfl, true);
      bjfl.a(this.a.jdField_a_of_type_Bjfl, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_Bjfl.a(null);
      return;
    }
    ved.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfo
 * JD-Core Version:    0.7.0.1
 */