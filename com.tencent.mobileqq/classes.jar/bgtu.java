import android.os.Bundle;
import com.tencent.qqmini.sdk.ipc.AppBrandProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;

public class bgtu
{
  private static volatile bgtu jdField_a_of_type_Bgtu;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private AppBrandProxy jdField_a_of_type_ComTencentQqminiSdkIpcAppBrandProxy;
  
  public static bgtu a()
  {
    if (jdField_a_of_type_Bgtu == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bgtu == null) {
        jdField_a_of_type_Bgtu = new bgtu();
      }
      return jdField_a_of_type_Bgtu;
    }
  }
  
  /* Error */
  public void a(AppBrandProxy paramAppBrandProxy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	bgtu:jdField_a_of_type_ComTencentQqminiSdkIpcAppBrandProxy	Lcom/tencent/qqmini/sdk/ipc/AppBrandProxy;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 23	bgtu:jdField_a_of_type_ComTencentQqminiSdkIpcAppBrandProxy	Lcom/tencent/qqmini/sdk/ipc/AppBrandProxy;
    //   19: goto -8 -> 11
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	bgtu
    //   0	27	1	paramAppBrandProxy	AppBrandProxy
    //   6	2	2	localAppBrandProxy	AppBrandProxy
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
    //   14	19	22	finally
  }
  
  public void a(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkIpcAppBrandProxy != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkIpcAppBrandProxy.sendCmd(paramString, paramBundle, paramMiniCmdCallback);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtu
 * JD-Core Version:    0.7.0.1
 */