import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

final class ayrr
  extends DefaultRedirectHandler
{
  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    URI localURI = super.getLocationURI(paramHttpResponse, paramHttpContext);
    paramHttpResponse = paramHttpContext.getAttribute("mobileqq_report_flag");
    if ((paramHttpResponse != null) && ((paramHttpResponse instanceof Integer)) && (((Integer)paramHttpResponse).intValue() > 0))
    {
      Object localObject = paramHttpContext.getAttribute("mobileqq_direct_uri");
      paramHttpResponse = localObject;
      if (localObject == null)
      {
        paramHttpResponse = new ArrayList();
        paramHttpContext.setAttribute("mobileqq_direct_uri", paramHttpResponse);
      }
      if ((paramHttpResponse != null) && ((paramHttpResponse instanceof List))) {
        ((List)paramHttpResponse).add(localURI);
      }
    }
    return localURI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrr
 * JD-Core Version:    0.7.0.1
 */