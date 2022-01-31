import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class amqd
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public amqd() {}
  
  public amqd(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }
  
  public static amqd a(String paramString)
  {
    boolean bool5 = false;
    if (paramString == null) {
      return null;
    }
    boolean bool1;
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      localNodeList = paramString.getElementsByTagName("shortvideo_troop_auto_play");
      if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
        break label401;
      }
      if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
        break label370;
      }
      bool1 = true;
    }
    catch (Exception paramString)
    {
      NodeList localNodeList;
      label152:
      QLog.e("AIOVideoPlayConfigProcessor", 1, "onParsed failed" + paramString);
      return null;
    }
    localNodeList = paramString.getElementsByTagName("shortvideo_not_troop_auto_play");
    if ((localNodeList != null) && (localNodeList.getLength() > 0)) {
      if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() > 0)
      {
        bool1 = true;
        break label411;
        localNodeList = paramString.getElementsByTagName("shortvideo_real_troop_auto_play");
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label390;
        }
        if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label380;
        }
        bool1 = true;
        break label416;
      }
    }
    for (;;)
    {
      paramString = paramString.getElementsByTagName("shortvideo_real_not_troop_auto_play");
      if ((paramString != null) && (paramString.getLength() > 0))
      {
        bool1 = bool5;
        if (Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {}
      }
      for (bool1 = true;; bool1 = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOVideoPlayConfigProcessor", 2, "parse, shortvideo_troop_auto_play = " + bool2 + ", shortvideo_not_troop_auto_play = " + bool3 + ", shortvideo_real_troop_auto_play = " + bool4 + ", shortvideo_real_not_troop_auto_play = " + bool1);
        }
        paramString = new amqd(bool2, bool3, bool4, bool1);
        return paramString;
        label370:
        bool1 = false;
        break;
        bool1 = false;
        break label411;
        label380:
        bool1 = false;
        break label416;
      }
      label390:
      boolean bool4 = true;
      continue;
      boolean bool3 = true;
      break label152;
      label401:
      boolean bool2 = true;
      break;
      bool2 = bool1;
      break;
      label411:
      bool3 = bool1;
      break label152;
      label416:
      bool4 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqd
 * JD-Core Version:    0.7.0.1
 */