import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class avdl
  extends nab
{
  avdl(avdj paramavdj, avdq paramavdq) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("reportPlay", 1, " reportPlay code:" + paramInt);
    if (this.jdField_a_of_type_Avdq != null) {
      this.jdField_a_of_type_Avdq.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avdl
 * JD-Core Version:    0.7.0.1
 */