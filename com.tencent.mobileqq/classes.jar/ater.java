import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class ater
  extends akuo
{
  public ater(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      ateo.jdField_a_of_type_ArrayOfLong[0] = ((paramSosoLbsInfo.a.b * 1000000.0D));
      ateo.jdField_a_of_type_ArrayOfLong[1] = ((paramSosoLbsInfo.a.a * 1000000.0D));
      ateo.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ater
 * JD-Core Version:    0.7.0.1
 */