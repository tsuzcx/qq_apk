import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;

public class audw
{
  private static volatile audw jdField_a_of_type_Audw;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static audw a()
  {
    if (jdField_a_of_type_Audw == null) {}
    try
    {
      if (jdField_a_of_type_Audw == null) {
        jdField_a_of_type_Audw = new audw();
      }
      return jdField_a_of_type_Audw;
    }
    finally {}
  }
  
  public void a(atmp paramatmp, long paramLong, audx paramaudx)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramatmp, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, paramaudx), 8, null, false);
  }
  
  public void a(atmp paramatmp, PushDialogTemplate paramPushDialogTemplate)
  {
    ThreadManager.post(new PushDialogDbUtil.2(this, paramatmp, paramPushDialogTemplate), 8, null, false);
  }
  
  public void b(atmp paramatmp, PushDialogTemplate paramPushDialogTemplate)
  {
    if ((paramatmp == null) || (paramPushDialogTemplate == null)) {
      return;
    }
    ThreadManager.post(new PushDialogDbUtil.3(this, paramatmp, paramPushDialogTemplate), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     audw
 * JD-Core Version:    0.7.0.1
 */