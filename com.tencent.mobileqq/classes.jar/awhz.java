import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class awhz
  extends apck
{
  awhz(awhy paramawhy, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_a_of_type_Awhv.TAG, 2, "onLocationFinish errCode = " + paramInt);
    }
    awhv.a(this.a.jdField_a_of_type_Awhv, paramSosoLbsInfo, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhz
 * JD-Core Version:    0.7.0.1
 */