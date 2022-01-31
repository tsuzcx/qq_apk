import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class astq
{
  int a = 0;
  
  public static astq a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          Object localObject = paramString.getElementsByTagName("hotpic_config");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            localObject = new astq();
            ((astq)localObject).a = Integer.parseInt(paramString.getElementsByTagName("entry").item(0).getFirstChild().getNodeValue());
            return localObject;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("HotPicConfProcessor", 1, "handleHotPicConfig failed" + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astq
 * JD-Core Version:    0.7.0.1
 */