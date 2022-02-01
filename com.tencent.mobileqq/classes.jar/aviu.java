import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class aviu
  extends LbsManagerService.OnLocationChangeListener
{
  public int a;
  public boolean a;
  public int b;
  
  public aviu(String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = ((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      this.b = ((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, String.format("onLocationFinish [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aviu
 * JD-Core Version:    0.7.0.1
 */