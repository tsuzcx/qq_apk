import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

class beaq
  extends beap
{
  private beaq(bean parambean, SSLSocket paramSSLSocket)
  {
    super(parambean, paramSSLSocket);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      arrayOfString = paramArrayOfString;
      if (paramArrayOfString.length == 1)
      {
        arrayOfString = paramArrayOfString;
        if ("SSLv3".equals(paramArrayOfString[0]))
        {
          paramArrayOfString = new ArrayList(Arrays.asList(this.a.getEnabledProtocols()));
          if (paramArrayOfString.size() <= 1) {
            break label101;
          }
          paramArrayOfString.remove("SSLv3");
          QLog.i("setEnabledProtocols", 1, "Removed SSLv3 from enabled protocols");
        }
      }
    }
    for (;;)
    {
      arrayOfString = (String[])paramArrayOfString.toArray(new String[paramArrayOfString.size()]);
      if (arrayOfString != null) {
        super.setEnabledProtocols(arrayOfString);
      }
      return;
      label101:
      QLog.i("setEnabledProtocols", 1, "SSL stuck with protocol available for " + String.valueOf(paramArrayOfString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaq
 * JD-Core Version:    0.7.0.1
 */