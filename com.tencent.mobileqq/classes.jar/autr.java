import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class autr
  extends aqkz<autq>
{
  private static autq jdField_a_of_type_Autq;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static autq a()
  {
    if (jdField_a_of_type_Autq != null) {
      return jdField_a_of_type_Autq;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      ThreadManager.executeOnSubThread(new GameShareConfProcessor.1());
    }
    return autq.jdField_a_of_type_Autq;
  }
  
  public static void a()
  {
    jdField_a_of_type_Autq = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  @NonNull
  public autq a(int paramInt)
  {
    return new autq();
  }
  
  @Nullable
  public autq a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length == 0) || (paramArrayOfaqlg[0] == null)) {}
    for (paramArrayOfaqlg = new autq();; paramArrayOfaqlg = autq.a(paramArrayOfaqlg[0].a))
    {
      jdField_a_of_type_Autq = paramArrayOfaqlg;
      return paramArrayOfaqlg;
    }
  }
  
  public void a(autq paramautq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onUpdate] newConf:" + paramautq);
    }
  }
  
  public Class<autq> clazz()
  {
    return autq.class;
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
    aqlk.a().a(617);
  }
  
  public void onReqNoReceive()
  {
    aqlk.a().a(617);
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + jdField_a_of_type_Autq);
    }
  }
  
  public int type()
  {
    return 617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autr
 * JD-Core Version:    0.7.0.1
 */