import android.os.SystemClock;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class amdw
  extends ampn
{
  amdw(amdu paramamdu, String paramString1, long paramLong, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "onLocationFinish, time=" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    if (paramInt != 0) {
      QLog.i("TroopHandler", 1, "getDetailOnlineMemberList, startLocation, errorCode=" + paramInt);
    }
    amdu.a(this.jdField_a_of_type_Amdu, this.jdField_a_of_type_JavaLangString, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdw
 * JD-Core Version:    0.7.0.1
 */