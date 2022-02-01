import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class awbc
  extends LbsManagerService.OnLocationChangeListener
{
  awbc(awbb paramawbb, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_a_of_type_Away.TAG, 2, "onLocationFinish errCode = " + paramInt);
    }
    away.a(this.a.jdField_a_of_type_Away, paramSosoLbsInfo, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbc
 * JD-Core Version:    0.7.0.1
 */