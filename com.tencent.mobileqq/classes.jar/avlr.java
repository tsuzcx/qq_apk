import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class avlr
  extends arac<avlq>
{
  private static avlq jdField_a_of_type_Avlq;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static avlq a()
  {
    if (jdField_a_of_type_Avlq != null) {
      return jdField_a_of_type_Avlq;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      ThreadManager.executeOnSubThread(new GameShareConfProcessor.1());
    }
    return avlq.jdField_a_of_type_Avlq;
  }
  
  public static void a()
  {
    jdField_a_of_type_Avlq = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  @NonNull
  public avlq a(int paramInt)
  {
    return new avlq();
  }
  
  @Nullable
  public avlq a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0) || (paramArrayOfaraj[0] == null)) {}
    for (paramArrayOfaraj = new avlq();; paramArrayOfaraj = avlq.a(paramArrayOfaraj[0].a))
    {
      jdField_a_of_type_Avlq = paramArrayOfaraj;
      return paramArrayOfaraj;
    }
  }
  
  public void a(avlq paramavlq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onUpdate] newConf:" + paramavlq);
    }
  }
  
  public Class<avlq> clazz()
  {
    return avlq.class;
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
    aran.a().a(617);
  }
  
  public void onReqNoReceive()
  {
    aran.a().a(617);
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + jdField_a_of_type_Avlq);
    }
  }
  
  public int type()
  {
    return 617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlr
 * JD-Core Version:    0.7.0.1
 */