import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class auvd
  extends LbsManagerService.OnLocationChangeListener
{
  auvd(auvc paramauvc, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_a_of_type_Auuz.TAG, 2, "onLocationFinish errCode = " + paramInt);
    }
    auuz.a(this.a.jdField_a_of_type_Auuz, paramSosoLbsInfo, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvd
 * JD-Core Version:    0.7.0.1
 */