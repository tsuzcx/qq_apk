import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class axtl
  extends SosoInterface.OnLocationListener
{
  public axtl(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      axti.jdField_a_of_type_ArrayOfLong[0] = ((paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      axti.jdField_a_of_type_ArrayOfLong[1] = ((paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      axti.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtl
 * JD-Core Version:    0.7.0.1
 */