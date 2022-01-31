import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.TMSManager.1;
import com.tencent.mobileqq.vip.TMSManager.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bbwx
{
  protected static final String[] a;
  private bbwo a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "tmsdualcore", "tmsdualcore785", "tmsdualcore790", "tmsdualcore7901" };
  }
  
  public static bbwx a()
  {
    if (bbxb.a().jdField_a_of_type_Bbwo == null) {}
    synchronized (bbxb.a())
    {
      if (bbxb.a().jdField_a_of_type_Bbwo == null) {
        bbxb.a().a();
      }
      return bbxb.a();
    }
  }
  
  public static bbwz a()
  {
    return bbxa.a();
  }
  
  private void a()
  {
    int i = amzw.c().a;
    QLog.d("KC.TMSManager", 1, "KingCardConfig : " + i);
    switch (i)
    {
    case 0: 
    case 1: 
    default: 
      this.jdField_a_of_type_Bbwo = new bbwo();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bbwo != null) {
        b();
      }
      return;
      if (a(BaseApplicationImpl.getApplication())) {
        this.jdField_a_of_type_Bbwo = new bbwp();
      } else if (bbwo.c()) {
        this.jdField_a_of_type_Bbwo = new bbwt();
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    int i = Process.myPid();
    String str = "";
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid != i) {
        break label88;
      }
      str = localRunningAppProcessInfo.processName;
    }
    label88:
    for (;;)
    {
      break;
      return paramContext.getPackageName().equals(str);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bbwo != null) {
      this.jdField_a_of_type_Bbwo.a(new TMSManager.2(this));
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Bbwo != null) && (this.jdField_a_of_type_Bbwo.a())) {
      this.jdField_a_of_type_Bbwo.a(paramViewGroup);
    }
  }
  
  public void a(bbwy parambbwy, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bbwo != null) && (this.jdField_a_of_type_Bbwo.a())) {
      this.jdField_a_of_type_Bbwo.a(parambbwy, paramBoolean);
    }
    while (parambbwy == null) {
      return;
    }
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new TMSManager.1(this, parambbwy));
      return;
    }
    parambbwy.a(false, false, 0);
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	bbwx:jdField_a_of_type_Bbwo	Lbbwo;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 32	bbwx:jdField_a_of_type_Bbwo	Lbbwo;
    //   13: invokevirtual 162	bbwo:a	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	bbwx
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public boolean a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Bbwo != null) && (this.jdField_a_of_type_Bbwo.a())) {
      return this.jdField_a_of_type_Bbwo.a(paramActivity);
    }
    return false;
  }
  
  public boolean b()
  {
    return bbwc.a() > 0;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Bbwo != null) && (this.jdField_a_of_type_Bbwo.a())) {
      return this.jdField_a_of_type_Bbwo.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbwx
 * JD-Core Version:    0.7.0.1
 */