import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

public class bhdv
  implements INetEventHandler
{
  private Context jdField_a_of_type_AndroidContentContext;
  
  public bhdv(bhdu parambhdu)
  {
    this.jdField_a_of_type_AndroidContentContext = bhdu.a(parambhdu);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	bhdv:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6: aload_0
    //   7: invokestatic 32	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:registerNetChangeReceiver	(Landroid/content/Context;Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;)V
    //   10: invokestatic 36	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isWifiConn	()Z
    //   13: ifeq +14 -> 27
    //   16: aload_0
    //   17: getfield 13	bhdv:jdField_a_of_type_Bhdu	Lbhdu;
    //   20: iconst_1
    //   21: invokevirtual 40	bhdu:c	(Z)V
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
    //   0	53	0	this	bhdv
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
      this.jdField_a_of_type_Bhdu.c();
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
    int i = bhnv.b(this.jdField_a_of_type_AndroidContentContext);
    if (i == 0) {
      if (bhdu.a(this.jdField_a_of_type_Bhdu)) {
        this.jdField_a_of_type_Bhdu.e();
      }
    }
    do
    {
      return;
      if (i == 1)
      {
        if (!bhdu.a(this.jdField_a_of_type_Bhdu))
        {
          this.jdField_a_of_type_Bhdu.c(true);
          return;
        }
        this.jdField_a_of_type_Bhdu.d();
        return;
      }
    } while ((i != 0) || (!bhdu.a(this.jdField_a_of_type_Bhdu)));
    this.jdField_a_of_type_Bhdu.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdv
 * JD-Core Version:    0.7.0.1
 */