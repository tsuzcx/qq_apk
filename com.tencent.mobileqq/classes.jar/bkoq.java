import android.annotation.TargetApi;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import java.util.Arrays;
import java.util.HashMap;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

@TargetApi(16)
public class bkoq
{
  protected static long a;
  protected Choreographer.FrameCallback a;
  protected Choreographer a;
  protected bkos a;
  protected final RecyclablePool a;
  private AbstractUnifiedMonitor.ThreadMonitorCallback a;
  protected boolean a;
  protected long b;
  protected boolean b;
  protected long c;
  protected boolean c;
  private boolean d;
  
  public bkoq()
  {
    this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(bkos.class, 4);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = new bkor(this);
  }
  
  private boolean a()
  {
    return 2 == BaseApplicationImpl.sProcessId;
  }
  
  public int a()
  {
    return UnifiedMonitor.a().getThreshold(9);
  }
  
  protected final long a(long paramLong)
  {
    return paramLong / 1000000L;
  }
  
  protected void a()
  {
    this.d = false;
    if (this.jdField_a_of_type_Bkos == null)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      }
      this.jdField_c_of_type_Long = 0L;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 54	com/tencent/mobileqq/statistics/UnifiedMonitor:a	()Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   5: bipush 9
    //   7: invokevirtual 84	com/tencent/mobileqq/statistics/UnifiedMonitor:whetherReportDuringThisStartup	(I)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifne +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: invokestatic 54	com/tencent/mobileqq/statistics/UnifiedMonitor:a	()Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   21: bipush 9
    //   23: invokevirtual 87	com/tencent/mobileqq/statistics/UnifiedMonitor:whetherReportThisTime	(I)Z
    //   26: ifeq -11 -> 15
    //   29: aload_0
    //   30: getfield 89	bkoq:jdField_a_of_type_Boolean	Z
    //   33: ifeq -18 -> 15
    //   36: aload_0
    //   37: getfield 65	bkoq:jdField_a_of_type_Bkos	Lbkos;
    //   40: ifnull +17 -> 57
    //   43: aload_0
    //   44: getfield 65	bkoq:jdField_a_of_type_Bkos	Lbkos;
    //   47: getfield 92	bkos:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: aload_1
    //   51: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifne -39 -> 15
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 31	bkoq:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   62: ldc 26
    //   64: invokevirtual 102	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   67: checkcast 26	bkos
    //   70: putfield 65	bkoq:jdField_a_of_type_Bkos	Lbkos;
    //   73: aload_0
    //   74: getfield 65	bkoq:jdField_a_of_type_Bkos	Lbkos;
    //   77: aload_1
    //   78: putfield 92	bkos:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: aload_0
    //   82: getfield 63	bkoq:d	Z
    //   85: ifne +32 -> 117
    //   88: aload_0
    //   89: getfield 33	bkoq:jdField_b_of_type_Boolean	Z
    //   92: ifeq +25 -> 117
    //   95: aload_0
    //   96: getfield 67	bkoq:jdField_a_of_type_AndroidViewChoreographer	Landroid/view/Choreographer;
    //   99: aload_0
    //   100: getfield 69	bkoq:jdField_a_of_type_AndroidViewChoreographer$FrameCallback	Landroid/view/Choreographer$FrameCallback;
    //   103: invokevirtual 75	android/view/Choreographer:removeFrameCallback	(Landroid/view/Choreographer$FrameCallback;)V
    //   106: aload_0
    //   107: getfield 67	bkoq:jdField_a_of_type_AndroidViewChoreographer	Landroid/view/Choreographer;
    //   110: aload_0
    //   111: getfield 69	bkoq:jdField_a_of_type_AndroidViewChoreographer$FrameCallback	Landroid/view/Choreographer$FrameCallback;
    //   114: invokevirtual 105	android/view/Choreographer:postFrameCallback	(Landroid/view/Choreographer$FrameCallback;)V
    //   117: aload_0
    //   118: iconst_1
    //   119: putfield 79	bkoq:jdField_c_of_type_Boolean	Z
    //   122: goto -107 -> 15
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	bkoq
    //   0	130	1	paramString	String
    //   10	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	125	finally
    //   18	57	125	finally
    //   57	117	125	finally
    //   117	122	125	finally
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    label297:
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          return;
        }
        if (this.jdField_a_of_type_Bkos != null)
        {
          if (!paramBoolean)
          {
            l1 = a(this.jdField_a_of_type_Bkos.jdField_c_of_type_Long - this.jdField_a_of_type_Bkos.jdField_b_of_type_Long);
            if ((this.jdField_a_of_type_Bkos.jdField_a_of_type_Long > 0L) && (l1 > a()))
            {
              long l2 = (this.jdField_a_of_type_Bkos.jdField_c_of_type_Long - this.jdField_a_of_type_Bkos.jdField_b_of_type_Long) / this.jdField_b_of_type_Long;
              long l3 = this.jdField_a_of_type_Bkos.jdField_a_of_type_Long;
              if (a()) {}
              paramString = new HashMap(10);
              paramString.put("dropCount", String.valueOf(l2 + 1L - l3));
              paramString.put("totalMs", String.valueOf(l1));
              paramString.put("scene", this.jdField_a_of_type_Bkos.jdField_a_of_type_JavaLangString);
              paramString.put("dropTimes", Arrays.toString(this.jdField_a_of_type_Bkos.jdField_a_of_type_ArrayOfLong));
              paramString.put("isFirstLaunch", String.valueOf(BaseApplicationImpl.isFirstLaunchNew));
              if (jdField_a_of_type_Long <= 0L) {
                break label297;
              }
              l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
              paramString.put("intervalAfterSyncMsg", String.valueOf(l1));
              UnifiedMonitor.a().addEvent(9, null, 0, 0, paramString);
              aaam.a().a(paramString);
            }
          }
          this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(this.jdField_a_of_type_Bkos);
          this.jdField_a_of_type_Bkos = null;
        }
        else
        {
          if (!this.d)
          {
            if (this.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
            }
            this.jdField_c_of_type_Long = 0L;
          }
          this.jdField_c_of_type_Boolean = false;
          continue;
        }
        long l1 = -1L;
      }
      finally {}
    }
  }
  
  public String toString()
  {
    if (this.jdField_c_of_type_Boolean) {
      return "y";
    }
    return "n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkoq
 * JD-Core Version:    0.7.0.1
 */