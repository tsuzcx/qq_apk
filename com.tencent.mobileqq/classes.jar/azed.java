public class azed
{
  public volatile int a = 0;
  public int b;
  public int c = 0;
  public int d;
  
  public String a()
  {
    switch (this.a)
    {
    default: 
      return "UNKNOWN_STATUS";
    case 0: 
      return "CONFIG_REQUEST_OK";
    case 1: 
      return "CONFIG_START_SERVLET";
    }
    return "CONFIG_SEND_REQ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azed
 * JD-Core Version:    0.7.0.1
 */