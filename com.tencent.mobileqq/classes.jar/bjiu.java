import android.os.Bundle;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class bjiu
  implements bjil
{
  private void a(Document paramDocument, Bundle paramBundle)
  {
    NodeList localNodeList = paramDocument.getElementsByTagName("ModifyPwdUrls");
    paramDocument = new Bundle();
    if ((localNodeList != null) && (localNodeList.getLength() >= 1))
    {
      localNodeList = localNodeList.item(0).getChildNodes();
      int i = 0;
      while (i < localNodeList.getLength())
      {
        Object localObject = localNodeList.item(i);
        if ((localObject instanceof Element))
        {
          String str = ((Element)localObject).getAttribute("Name");
          localObject = ((Element)localObject).getAttribute("Url");
          if ((str != null) && (localObject != null) && (!str.equals("")) && (!((String)localObject).equals(""))) {
            paramDocument.putString(str, (String)localObject);
          }
        }
        i += 1;
      }
      paramBundle.putBundle("ModifyPwdUrls", paramDocument);
    }
  }
  
  public bjis a(String paramString)
  {
    paramString = new File(paramString);
    Object localObject1 = DocumentBuilderFactory.newInstance();
    try
    {
      paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(paramString);
      Object localObject2 = paramString.getDocumentElement();
      localObject1 = new Bundle();
      localObject2 = ((Element)localObject2).getAttribute("Version");
      int i = -1;
      try
      {
        int j = Integer.parseInt((String)localObject2);
        i = j;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
      ((Bundle)localObject1).putInt("version", i);
      a(paramString, (Bundle)localObject1);
      return new bjit((Bundle)localObject1);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjiu
 * JD-Core Version:    0.7.0.1
 */