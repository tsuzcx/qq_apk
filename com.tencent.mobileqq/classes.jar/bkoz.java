import android.os.Handler;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class bkoz
  extends akup
{
  private int jdField_a_of_type_Int = -1;
  
  public bkoz(bkow parambkow, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, int paramInt2)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      double d1 = paramSosoLbsInfo.a.a;
      double d2 = paramSosoLbsInfo.a.b;
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "onLocationUpdate() latitude=" + d1 + " longitude=" + d2);
      }
      bkow.a(this.jdField_a_of_type_Bkow, d1, d2, this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "onLocationUpdate() error");
      }
    } while ((bkow.a(this.jdField_a_of_type_Bkow) == null) || (!bkow.a(this.jdField_a_of_type_Bkow).hasMessages(this.jdField_a_of_type_Int)));
    bkow.a(this.jdField_a_of_type_Bkow, false, null, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkoz
 * JD-Core Version:    0.7.0.1
 */