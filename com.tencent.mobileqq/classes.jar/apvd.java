import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class apvd
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public apvd() {}
  
  public apvd(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
    this.e = paramBoolean5;
  }
  
  public static apvd a(String paramString)
  {
    boolean bool6 = false;
    if (paramString == null) {
      return null;
    }
    boolean bool1;
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      localNodeList = paramString.getElementsByTagName("shortvideo_troop_auto_play");
      if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
        break label488;
      }
      if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
        break label452;
      }
      bool1 = true;
    }
    catch (Exception paramString)
    {
      NodeList localNodeList;
      label152:
      label212:
      QLog.e("AIOVideoPlayConfigProcessor", 1, "onParsed failed" + paramString);
      return null;
    }
    localNodeList = paramString.getElementsByTagName("shortvideo_not_troop_auto_play");
    if ((localNodeList != null) && (localNodeList.getLength() > 0)) {
      if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() > 0)
      {
        bool1 = true;
        break label498;
        localNodeList = paramString.getElementsByTagName("shortvideo_real_troop_auto_play");
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label477;
        }
        if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label462;
        }
        bool1 = true;
        break label503;
        localNodeList = paramString.getElementsByTagName("shortvideo_real_not_troop_auto_play");
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label472;
        }
        if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label467;
        }
        bool1 = true;
        break label509;
      }
    }
    label452:
    label462:
    label467:
    label472:
    label477:
    label488:
    label493:
    label498:
    label503:
    label509:
    for (;;)
    {
      paramString = paramString.getElementsByTagName("auto_del_bad_cache");
      boolean bool5 = bool6;
      if (paramString != null)
      {
        bool5 = bool6;
        if (paramString.getLength() > 0)
        {
          bool5 = bool6;
          if (Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
            bool5 = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayConfigProcessor", 2, "parse, shortvideo_troop_auto_play = " + bool2 + ", shortvideo_not_troop_auto_play = " + bool3 + ", shortvideo_real_troop_auto_play = " + bool4 + ", shortvideo_real_not_troop_auto_play = " + bool1 + ", auto_del_bad_cache = " + bool5);
      }
      paramString = new apvd(bool2, bool3, bool4, bool1, bool5);
      return paramString;
      bool1 = false;
      break label493;
      bool1 = false;
      break label498;
      bool1 = false;
      break label503;
      bool1 = false;
      break label509;
      bool1 = true;
      continue;
      boolean bool4 = true;
      break label212;
      boolean bool3 = true;
      break label152;
      boolean bool2 = true;
      break;
      bool2 = bool1;
      break;
      bool3 = bool1;
      break label152;
      bool4 = bool1;
      break label212;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apvd
 * JD-Core Version:    0.7.0.1
 */