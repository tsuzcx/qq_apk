import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bdtr
  implements IBinder.DeathRecipient, bdts
{
  private long jdField_a_of_type_Long;
  private bans jdField_a_of_type_Bans;
  private String jdField_a_of_type_JavaLangString;
  
  private bdtr(long paramLong, String paramString, bans parambans)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bans = parambans;
    try
    {
      parambans.asBinder().linkToDeath(this, 0);
      return;
    }
    catch (RemoteException paramString)
    {
      QLog.e("QuickUpdateIPCModule", 1, "linkToDeath fail: " + this, paramString);
    }
  }
  
  public void binderDied()
  {
    QLog.e("QuickUpdateIPCModule", 1, "binderDied: " + this);
    bdws.a(this.jdField_a_of_type_Long).removeListener(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this);
  }
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    QLog.e("QuickUpdateIPCModule", 1, "onCompleted: " + paramInt1 + ", " + this);
    try
    {
      this.jdField_a_of_type_Bans.onComplete(paramString1, paramInt1);
      return;
    }
    catch (RemoteException paramQQAppInterface)
    {
      QLog.e("QuickUpdateIPCModule", 1, "onCompleted: " + this, paramQQAppInterface);
    }
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    try
    {
      this.jdField_a_of_type_Bans.onProgress(paramString1, paramLong2, paramLong3);
      return;
    }
    catch (RemoteException paramQQAppInterface)
    {
      QLog.e("QuickUpdateIPCModule", 1, "onProgress: " + this, paramQQAppInterface);
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Long + "_" + this.jdField_a_of_type_JavaLangString + "," + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtr
 * JD-Core Version:    0.7.0.1
 */