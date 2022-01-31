import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;

public class avdc
{
  private static volatile avdc jdField_a_of_type_Avdc;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static avdc a()
  {
    if (jdField_a_of_type_Avdc == null) {}
    try
    {
      if (jdField_a_of_type_Avdc == null) {
        jdField_a_of_type_Avdc = new avdc();
      }
      return jdField_a_of_type_Avdc;
    }
    finally {}
  }
  
  public void a(aukn paramaukn, long paramLong, avdd paramavdd)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramaukn, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, paramavdd), 8, null, false);
  }
  
  public void a(aukn paramaukn, PushDialogTemplate paramPushDialogTemplate)
  {
    ThreadManager.post(new PushDialogDbUtil.2(this, paramaukn, paramPushDialogTemplate), 8, null, false);
  }
  
  public void b(aukn paramaukn, PushDialogTemplate paramPushDialogTemplate)
  {
    if ((paramaukn == null) || (paramPushDialogTemplate == null)) {
      return;
    }
    ThreadManager.post(new PushDialogDbUtil.3(this, paramaukn, paramPushDialogTemplate), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdc
 * JD-Core Version:    0.7.0.1
 */