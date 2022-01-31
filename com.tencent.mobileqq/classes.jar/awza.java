import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;

public class awza
{
  private static volatile awza jdField_a_of_type_Awza;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static awza a()
  {
    if (jdField_a_of_type_Awza == null) {}
    try
    {
      if (jdField_a_of_type_Awza == null) {
        jdField_a_of_type_Awza = new awza();
      }
      return jdField_a_of_type_Awza;
    }
    finally {}
  }
  
  public void a(awgf paramawgf, long paramLong, awzb paramawzb)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramawgf, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, paramawzb), 8, null, false);
  }
  
  public void a(awgf paramawgf, PushDialogTemplate paramPushDialogTemplate)
  {
    ThreadManager.post(new PushDialogDbUtil.2(this, paramawgf, paramPushDialogTemplate), 8, null, false);
  }
  
  public void b(awgf paramawgf, PushDialogTemplate paramPushDialogTemplate)
  {
    if ((paramawgf == null) || (paramPushDialogTemplate == null)) {
      return;
    }
    ThreadManager.post(new PushDialogDbUtil.3(this, paramawgf, paramPushDialogTemplate), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awza
 * JD-Core Version:    0.7.0.1
 */