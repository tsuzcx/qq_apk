import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;

public class awur
{
  private static volatile awur jdField_a_of_type_Awur;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static awur a()
  {
    if (jdField_a_of_type_Awur == null) {}
    try
    {
      if (jdField_a_of_type_Awur == null) {
        jdField_a_of_type_Awur = new awur();
      }
      return jdField_a_of_type_Awur;
    }
    finally {}
  }
  
  public void a(awbw paramawbw, long paramLong, awus paramawus)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramawbw, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, paramawus), 8, null, false);
  }
  
  public void a(awbw paramawbw, PushDialogTemplate paramPushDialogTemplate)
  {
    ThreadManager.post(new PushDialogDbUtil.2(this, paramawbw, paramPushDialogTemplate), 8, null, false);
  }
  
  public void b(awbw paramawbw, PushDialogTemplate paramPushDialogTemplate)
  {
    if ((paramawbw == null) || (paramPushDialogTemplate == null)) {
      return;
    }
    ThreadManager.post(new PushDialogDbUtil.3(this, paramawbw, paramPushDialogTemplate), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awur
 * JD-Core Version:    0.7.0.1
 */