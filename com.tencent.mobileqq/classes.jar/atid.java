import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class atid
  extends mxi
{
  atid(atib paramatib, atii paramatii) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("reportPlay", 1, " reportPlay code:" + paramInt);
    if (this.jdField_a_of_type_Atii != null) {
      this.jdField_a_of_type_Atii.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atid
 * JD-Core Version:    0.7.0.1
 */