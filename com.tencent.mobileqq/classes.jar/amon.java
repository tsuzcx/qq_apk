import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class amon
  implements Runnable
{
  public amon(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void run()
  {
    DatalineRemoteManager.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amon
 * JD-Core Version:    0.7.0.1
 */