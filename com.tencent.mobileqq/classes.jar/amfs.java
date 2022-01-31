import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class amfs
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public amfs() {}
  
  public amfs(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }
  
  public static amfs a(String paramString)
  {
    boolean bool5 = false;
    if (paramString == null) {
      return null;
    }
    boolean bool1;
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      localNodeList = paramString.getElementsByTagName("bdh_ipv6_switch");
      if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
        break label405;
      }
      if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
        break label380;
      }
      bool1 = true;
    }
    catch (Exception paramString)
    {
      NodeList localNodeList;
      label152:
      QLog.e("RichmediaIpv6ConifgProcessor", 1, "onParsed failed" + paramString);
      return null;
    }
    localNodeList = paramString.getElementsByTagName("bdh_dual_ipv6_switch");
    if ((localNodeList != null) && (localNodeList.getLength() > 0)) {
      if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() > 0)
      {
        bool1 = true;
        break label415;
        localNodeList = paramString.getElementsByTagName("richmedia_down_ipv6_switch");
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label395;
        }
        if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label390;
        }
        bool1 = true;
        break label420;
      }
    }
    label390:
    label395:
    label405:
    label410:
    label415:
    label420:
    for (;;)
    {
      paramString = paramString.getElementsByTagName("richmedia_down_dual_ipv6_switch");
      boolean bool4 = bool5;
      if (paramString != null)
      {
        bool4 = bool5;
        if (paramString.getLength() > 0)
        {
          bool4 = bool5;
          if (Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
            bool4 = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichmediaIpv6ConifgProcessor", 2, "parse, bdh_ipv6_switch = " + bool2 + ", bdh_dual_ipv6_switch = " + bool3 + ", richmedia_down_ipv6_switch = " + bool1 + ", richmedia_down_dual_ipv6_switch = " + bool4);
      }
      paramString = new amfs(bool2, bool3, bool1, bool4);
      return paramString;
      label380:
      bool1 = false;
      break label410;
      bool1 = false;
      break label415;
      bool1 = false;
      break label420;
      bool1 = false;
      continue;
      boolean bool3 = false;
      break label152;
      boolean bool2 = false;
      break;
      bool2 = bool1;
      break;
      bool3 = bool1;
      break label152;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfs
 * JD-Core Version:    0.7.0.1
 */