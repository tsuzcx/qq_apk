import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tablequery.TableQueryController.1;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bdgq
{
  private static bdgq jdField_a_of_type_Bdgq;
  public static boolean a;
  public static boolean b = true;
  public static boolean c;
  private static boolean e;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bdgr(this);
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private bdgs jdField_a_of_type_Bdgs = new bdgs();
  private TableQueryViewer jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean d;
  
  /* Error */
  public static bdgq a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 40	bdgq:jdField_a_of_type_Bdgq	Lbdgq;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	bdgq
    //   15: dup
    //   16: invokespecial 41	bdgq:<init>	()V
    //   19: putstatic 40	bdgq:jdField_a_of_type_Bdgq	Lbdgq;
    //   22: ldc 2
    //   24: monitorexit
    //   25: ldc 2
    //   27: monitorexit
    //   28: getstatic 40	bdgq:jdField_a_of_type_Bdgq	Lbdgq;
    //   31: areturn
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	5	0	localObject1	Object
    //   38	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	32	finally
    //   33	36	32	finally
    //   3	12	38	finally
    //   25	28	38	finally
    //   36	38	38	finally
    //   39	42	38	finally
  }
  
  public int a(bdgp parambdgp)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.a(parambdgp);
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.a();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      e = true;
      if (!c) {
        a().a();
      }
    }
    while (paramMotionEvent.getAction() != 1) {
      return;
    }
    paramMotionEvent = new TableQueryController.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(paramMotionEvent, 400L);
  }
  
  public void a(bdgp parambdgp)
  {
    if (jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.a(parambdgp);
    }
  }
  
  public void b()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localBaseApplication.getSystemService("window"));
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = new TableQueryViewer(localBaseApplication);
    }
    if (!this.d) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer);
      label56:
      int i;
      if (Build.VERSION.SDK_INT >= 26) {
        i = 2038;
      }
      for (;;)
      {
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
        localLayoutParams.gravity = 51;
        localLayoutParams.x = 0;
        localLayoutParams.y = bggq.a(localBaseApplication, 72.0F);
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer, localLayoutParams);
          this.d = true;
          return;
          i = 2003;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QQToast.a(localBaseApplication, 1, localBaseApplication.getString(2131690507), 0).a();
          }
        }
      }
    }
    catch (Exception localException2)
    {
      break label56;
    }
  }
  
  public void c()
  {
    if (this.d) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer);
    }
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgq
 * JD-Core Version:    0.7.0.1
 */