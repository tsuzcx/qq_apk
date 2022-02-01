import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class atyr
  extends aptq<atyq>
{
  private static atyq jdField_a_of_type_Atyq;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static atyq a()
  {
    if (jdField_a_of_type_Atyq != null) {
      return jdField_a_of_type_Atyq;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      ThreadManager.executeOnSubThread(new GameShareConfProcessor.1());
    }
    return atyq.jdField_a_of_type_Atyq;
  }
  
  public static void a()
  {
    jdField_a_of_type_Atyq = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  @NonNull
  public atyq a(int paramInt)
  {
    return new atyq();
  }
  
  @Nullable
  public atyq a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0) || (paramArrayOfaptx[0] == null)) {}
    for (paramArrayOfaptx = new atyq();; paramArrayOfaptx = atyq.a(paramArrayOfaptx[0].a))
    {
      jdField_a_of_type_Atyq = paramArrayOfaptx;
      return paramArrayOfaptx;
    }
  }
  
  public void a(atyq paramatyq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onUpdate] newConf:" + paramatyq);
    }
  }
  
  public Class<atyq> clazz()
  {
    return atyq.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
    apub.a().a(617);
  }
  
  public void onReqNoReceive()
  {
    apub.a().a(617);
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + jdField_a_of_type_Atyq);
    }
  }
  
  public int type()
  {
    return 617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyr
 * JD-Core Version:    0.7.0.1
 */