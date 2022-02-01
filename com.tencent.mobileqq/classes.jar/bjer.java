import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.qphone.base.util.QLog;

class bjer
  implements IBinder.DeathRecipient
{
  bjer(bjeq parambjeq, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    this.jdField_a_of_type_AndroidOsIBinder.unlinkToDeath(this, 0);
    bjep.a(this.jdField_a_of_type_Bjeq.a, null);
    QLog.i("MusicPlayerProxyImpl", 2, "linkToDeath binderDied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjer
 * JD-Core Version:    0.7.0.1
 */