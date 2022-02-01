import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aydo
  extends nkp
{
  aydo(aydm paramaydm, aydt paramaydt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("reportPlay", 1, " reportPlay code:" + paramInt);
    if (this.jdField_a_of_type_Aydt != null) {
      this.jdField_a_of_type_Aydt.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydo
 * JD-Core Version:    0.7.0.1
 */