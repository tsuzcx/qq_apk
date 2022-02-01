import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;

public class banf
{
  private static volatile banf jdField_a_of_type_Banf;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static banf a()
  {
    if (jdField_a_of_type_Banf == null) {}
    try
    {
      if (jdField_a_of_type_Banf == null) {
        jdField_a_of_type_Banf = new banf();
      }
      return jdField_a_of_type_Banf;
    }
    finally {}
  }
  
  public void a(EntityManager paramEntityManager, long paramLong, bang parambang)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramEntityManager, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, parambang), 8, null, false);
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
 * Qualified Name:     banf
 * JD-Core Version:    0.7.0.1
 */