import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;

public class avde
{
  private static volatile avde jdField_a_of_type_Avde;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static avde a()
  {
    if (jdField_a_of_type_Avde == null) {}
    try
    {
      if (jdField_a_of_type_Avde == null) {
        jdField_a_of_type_Avde = new avde();
      }
      return jdField_a_of_type_Avde;
    }
    finally {}
  }
  
  public void a(aukp paramaukp, long paramLong, avdf paramavdf)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramaukp, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, paramavdf), 8, null, false);
  }
  
  public void a(aukp paramaukp, PushDialogTemplate paramPushDialogTemplate)
  {
    ThreadManager.post(new PushDialogDbUtil.2(this, paramaukp, paramPushDialogTemplate), 8, null, false);
  }
  
  public void b(aukp paramaukp, PushDialogTemplate paramPushDialogTemplate)
  {
    if ((paramaukp == null) || (paramPushDialogTemplate == null)) {
      return;
    }
    ThreadManager.post(new PushDialogDbUtil.3(this, paramaukp, paramPushDialogTemplate), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avde
 * JD-Core Version:    0.7.0.1
 */