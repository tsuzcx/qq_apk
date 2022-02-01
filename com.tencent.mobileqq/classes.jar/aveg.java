import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aveg
  extends aqwt<avef>
{
  private static avef jdField_a_of_type_Avef;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static avef a()
  {
    if (jdField_a_of_type_Avef != null) {
      return jdField_a_of_type_Avef;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      ThreadManager.executeOnSubThread(new GameShareConfProcessor.1());
    }
    return avef.jdField_a_of_type_Avef;
  }
  
  public static void a()
  {
    jdField_a_of_type_Avef = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  @NonNull
  public avef a(int paramInt)
  {
    return new avef();
  }
  
  @Nullable
  public avef a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0) || (paramArrayOfaqxa[0] == null)) {}
    for (paramArrayOfaqxa = new avef();; paramArrayOfaqxa = avef.a(paramArrayOfaqxa[0].a))
    {
      jdField_a_of_type_Avef = paramArrayOfaqxa;
      return paramArrayOfaqxa;
    }
  }
  
  public void a(avef paramavef)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onUpdate] newConf:" + paramavef);
    }
  }
  
  public Class<avef> clazz()
  {
    return avef.class;
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
    aqxe.a().a(617);
  }
  
  public void onReqNoReceive()
  {
    aqxe.a().a(617);
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + jdField_a_of_type_Avef);
    }
  }
  
  public int type()
  {
    return 617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aveg
 * JD-Core Version:    0.7.0.1
 */