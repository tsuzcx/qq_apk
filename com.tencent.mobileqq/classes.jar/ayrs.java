import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class ayrs
  extends DefaultHttpClient
{
  public ayrs(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    super(paramClientConnectionManager, null);
  }
  
  public HttpContext createHttpContext()
  {
    return super.createHttpContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrs
 * JD-Core Version:    0.7.0.1
 */