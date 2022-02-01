import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;

public class bgvy
  implements INetEventHandler
{
  private Context jdField_a_of_type_AndroidContentContext;
  
  public bgvy(bgvx parambgvx)
  {
    this.jdField_a_of_type_AndroidContentContext = bgvx.a(parambgvx);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	bgvy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6: aload_0
    //   7: invokestatic 32	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:registerNetChangeReceiver	(Landroid/content/Context;Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;)V
    //   10: invokestatic 36	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isWifiConn	()Z
    //   13: ifeq +14 -> 27
    //   16: aload_0
    //   17: getfield 13	bgvy:jdField_a_of_type_Bgvx	Lbgvx;
    //   20: iconst_1
    //   21: invokevirtual 40	bgvx:c	(Z)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq -6 -> 24
    //   33: ldc 47
    //   35: iconst_2
    //   36: ldc 49
    //   38: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: goto -17 -> 24
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_1
    //   50: goto -40 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	bgvy
    //   44	4	1	localObject	Object
    //   49	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	10	44	finally
    //   10	24	44	finally
    //   27	41	44	finally
    //   2	10	49	java/lang/Exception
  }
  
  public void b()
  {
    try
    {
      AppNetConnInfo.unregisterNetEventHandler(this);
      label7:
      this.jdField_a_of_type_Bgvx.c();
      return;
    }
    catch (Exception localException)
    {
      break label7;
    }
    finally {}
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = NetworkUtil.getNetworkType(this.jdField_a_of_type_AndroidContentContext);
    if (i == 0) {
      if (bgvx.a(this.jdField_a_of_type_Bgvx)) {
        this.jdField_a_of_type_Bgvx.e();
      }
    }
    do
    {
      return;
      if (i == 1)
      {
        if (!bgvx.a(this.jdField_a_of_type_Bgvx))
        {
          this.jdField_a_of_type_Bgvx.c(true);
          return;
        }
        this.jdField_a_of_type_Bgvx.d();
        return;
      }
    } while ((i != 0) || (!bgvx.a(this.jdField_a_of_type_Bgvx)));
    this.jdField_a_of_type_Bgvx.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvy
 * JD-Core Version:    0.7.0.1
 */