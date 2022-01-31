import com.tencent.open.wadl.WLog;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlProxyServiceManager;
import cooperation.wadl.ipc.WadlProxyServiceMonitor;

public class amqo
  extends Thread
{
  public volatile boolean a;
  
  private amqo(WadlProxyServiceMonitor paramWadlProxyServiceMonitor)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    try
    {
      while (this.jdField_a_of_type_Boolean)
      {
        Thread.sleep(WadlProxyServiceMonitor.a(this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor));
        long l = System.currentTimeMillis();
        if ((WadlProxyServiceMonitor.b(this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor) != 0L) && (l - WadlProxyServiceMonitor.b(this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor) > 30000L) && (WadlProxyServiceMonitor.a(this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor)) && (WadlProxyServiceMonitor.a(this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor) != null))
        {
          if (QLog.isColorLevel()) {
            WLog.b(WadlProxyServiceMonitor.a(), "##@<<<MonitorWorkingThread: check ipc service status...");
          }
          WadlProxyServiceMonitor.a(this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor).a();
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqo
 * JD-Core Version:    0.7.0.1
 */