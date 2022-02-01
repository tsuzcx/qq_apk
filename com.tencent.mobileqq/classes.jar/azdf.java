import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;

public class azdf
{
  private static volatile azdf jdField_a_of_type_Azdf;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static azdf a()
  {
    if (jdField_a_of_type_Azdf == null) {}
    try
    {
      if (jdField_a_of_type_Azdf == null) {
        jdField_a_of_type_Azdf = new azdf();
      }
      return jdField_a_of_type_Azdf;
    }
    finally {}
  }
  
  public void a(EntityManager paramEntityManager, long paramLong, azdg paramazdg)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramEntityManager, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, paramazdg), 8, null, false);
  }
  
  public void a(EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate)
  {
    ThreadManager.post(new PushDialogDbUtil.2(this, paramEntityManager, paramPushDialogTemplate), 8, null, false);
  }
  
  public void b(EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate)
  {
    if ((paramEntityManager == null) || (paramPushDialogTemplate == null)) {
      return;
    }
    ThreadManager.post(new PushDialogDbUtil.3(this, paramEntityManager, paramPushDialogTemplate), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdf
 * JD-Core Version:    0.7.0.1
 */