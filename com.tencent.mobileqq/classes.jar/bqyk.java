import android.os.Handler;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class bqyk
  extends apcq
{
  private int jdField_a_of_type_Int = -1;
  
  public bqyk(bqyh parambqyh, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, int paramInt2)
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
      bqyh.a(this.jdField_a_of_type_Bqyh, d1, d2, this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "onLocationUpdate() error");
      }
    } while ((bqyh.a(this.jdField_a_of_type_Bqyh) == null) || (!bqyh.a(this.jdField_a_of_type_Bqyh).hasMessages(this.jdField_a_of_type_Int)));
    bqyh.a(this.jdField_a_of_type_Bqyh, false, null, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqyk
 * JD-Core Version:    0.7.0.1
 */