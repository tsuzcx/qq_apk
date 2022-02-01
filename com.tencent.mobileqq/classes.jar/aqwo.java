import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class aqwo
{
  public static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      a(localHashMap, DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + paramString).getBytes())).getDocumentElement().getChildNodes());
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static void a(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = new Cryptor().decrypt(paramArrayOfByte, a());
    switch (paramInt)
    {
    case 3: 
    default: 
    case 4: 
      do
      {
        return;
        paramString = aqwk.a();
      } while (paramString == null);
      a(paramString.a, paramArrayOfByte);
      return;
    case 24: 
      aqwk.a.b();
      aqwk.a.a(false);
      a(aqwk.a, paramArrayOfByte, paramString);
      return;
    }
    aqwk.b.b();
    aqwk.b.a(false);
    a(aqwk.b, paramArrayOfByte);
  }
  
  private static void a(aqwn paramaqwn, byte[] paramArrayOfByte)
  {
    int i = PkgTools.getShortData(paramArrayOfByte, 0);
    paramaqwn.jdField_a_of_type_JavaLangString = PkgTools.getUTFString(paramArrayOfByte, 2, i);
    i += 2;
    paramaqwn.jdField_a_of_type_Byte = paramArrayOfByte[i];
    i += 1;
    paramaqwn.jdField_b_of_type_Byte = paramArrayOfByte[i];
    int j = i + 1;
    i = PkgTools.getShortData(paramArrayOfByte, j);
    j += 2;
    paramaqwn.jdField_b_of_type_JavaLangString = PkgTools.getUTFString(paramArrayOfByte, j, i);
  }
  
  private static void a(aqwp paramaqwp) {}
  
  private static void a(aqwp paramaqwp, String paramString)
  {
    int k = 2;
    int m = 0;
    int n = PkgTools.getShortData(paramaqwp.jdField_a_of_type_ArrayOfByte, 0);
    int i = m;
    int j = k;
    if (QLog.isColorLevel())
    {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--itemNum = " + n);
      j = k;
      i = m;
    }
    while (i < n)
    {
      k = PkgTools.getShortData(paramaqwp.jdField_a_of_type_ArrayOfByte, j);
      m = j + 2;
      j = PkgTools.getShortData(paramaqwp.jdField_a_of_type_ArrayOfByte, m);
      m += 2;
      byte[] arrayOfByte = new byte[j];
      PkgTools.getBytesData(paramaqwp.jdField_a_of_type_ArrayOfByte, m, arrayOfByte, j);
      j = m + j;
      a(k, arrayOfByte, paramString);
      i += 1;
    }
    paramaqwp = aqwk.a();
    if (paramaqwp != null) {
      paramaqwp.c();
    }
  }
  
  private static void a(arpt paramarpt, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--buildItem_FlashLogo = ");
    }
    paramarpt.jdField_a_of_type_Long = PkgTools.getLongData(paramArrayOfByte, 0);
    paramarpt.b = (PkgTools.getLongData(paramArrayOfByte, 4) * 1000L);
    paramarpt.c = (PkgTools.getLongData(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int m;
    int n;
    for (int j = 13; i < k; j = n + m)
    {
      long l = PkgTools.getLongData(paramArrayOfByte, j);
      m = j + 4;
      j = paramArrayOfByte[m];
      n = m + 1 + 1;
      m = PkgTools.getShortData(paramArrayOfByte, n);
      n += 2;
      String str1 = PkgTools.getUTFString(paramArrayOfByte, n, m);
      n += m;
      m = PkgTools.getShortData(paramArrayOfByte, n);
      n += 2;
      String str2 = PkgTools.getUTFString(paramArrayOfByte, n, m);
      if (j == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShanPing", 2, "flashlogo desc= " + str1 + " src addr = " + str2);
        }
        str2 = paramarpt.a(str1, (byte)3);
        paramarpt.b(str2);
        paramarpt.a(paramarpt.a(l, str1, str2, null, ""));
      }
      i += 1;
    }
  }
  
  private static void a(arpt paramarpt, byte[] paramArrayOfByte, String paramString)
  {
    paramarpt.jdField_a_of_type_Long = PkgTools.getLongData(paramArrayOfByte, 0);
    paramarpt.b = (PkgTools.getLongData(paramArrayOfByte, 4) * 1000L);
    paramarpt.c = (PkgTools.getLongData(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int j = 13;
    if (k > 0)
    {
      paramarpt.c();
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + paramString, true).commit();
    }
    int i = 0;
    while (i < k)
    {
      long l1 = PkgTools.getLongData(paramArrayOfByte, j);
      int m = j + 4;
      j = paramArrayOfByte[m];
      m = m + 1 + 1;
      long l2 = PkgTools.getLongData(paramArrayOfByte, m);
      int n = m + 4;
      m = PkgTools.getShortData(paramArrayOfByte, n);
      int i1 = n + 2;
      n = PkgTools.getShortData(paramArrayOfByte, i1);
      i1 += 2;
      paramString = PkgTools.getUTFString(paramArrayOfByte, i1, n);
      i1 += n;
      n = PkgTools.getShortData(paramArrayOfByte, i1);
      i1 += 2;
      String str2 = PkgTools.getUTFString(paramArrayOfByte, i1, n);
      i1 += n;
      n = PkgTools.getShortData(paramArrayOfByte, i1);
      i1 += 2;
      String str1 = PkgTools.getUTFString(paramArrayOfByte, i1, n);
      if (j == 1)
      {
        str2 = paramarpt.a(str2, (byte)3);
        if (!a(String.valueOf(l1))) {
          paramarpt.b(str2);
        }
        paramarpt.a(paramarpt.a(l1, paramString, str2, str1, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + l1, "" + l2, (short)m));
      }
      i += 1;
      j = n + i1;
    }
  }
  
  private static void a(HashMap<String, String> paramHashMap, NodeList paramNodeList)
  {
    if ((paramNodeList == null) || (paramNodeList.getLength() == 0)) {
      return;
    }
    int i = 0;
    label16:
    Node localNode;
    if (i < paramNodeList.getLength())
    {
      localNode = paramNodeList.item(i);
      if (!(localNode instanceof Element)) {
        break label67;
      }
      if (localNode.hasChildNodes()) {
        a(paramHashMap, localNode.getChildNodes());
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label67:
      if (localNode.getParentNode() != null) {
        paramHashMap.put(localNode.getParentNode().getNodeName(), localNode.getNodeValue());
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, aqwp paramaqwp)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 11)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte[0] == 2)
      {
        paramaqwp.b = PkgTools.getShortData(paramArrayOfByte, 1);
        paramaqwp.jdField_a_of_type_Short = PkgTools.getShortData(paramArrayOfByte, 3);
        paramaqwp.jdField_a_of_type_Long = (PkgTools.getLongData(paramArrayOfByte, 5) * 1000L);
        paramaqwp.jdField_a_of_type_Byte = paramArrayOfByte[9];
        int i = paramArrayOfByte.length - 10 - 1;
        if (paramaqwp.jdField_a_of_type_Byte == 0)
        {
          paramaqwp.jdField_a_of_type_ArrayOfByte = new byte[i];
          PkgTools.getBytesData(paramArrayOfByte, 10, paramaqwp.jdField_a_of_type_ArrayOfByte, i);
        }
        while (paramArrayOfByte.length != i + 10 + 1)
        {
          return;
          paramaqwp.jdField_a_of_type_JavaLangString = PkgTools.getUTFString(paramArrayOfByte, 10, i);
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString).exists();
  }
  
  public static boolean a(byte[] paramArrayOfByte, aqwp paramaqwp, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    do
    {
      do
      {
        return false;
        a(paramArrayOfByte, paramaqwp);
      } while (paramaqwp.b != 768);
      if (paramaqwp.jdField_a_of_type_Byte != 0)
      {
        a(paramaqwp);
        return false;
      }
    } while ((paramaqwp.jdField_a_of_type_ArrayOfByte == null) || (paramaqwp.jdField_a_of_type_ArrayOfByte.length == 0));
    a(paramaqwp, paramString);
    return true;
  }
  
  private static byte[] a()
  {
    String str = MD5.toMD5(aqwk.a() + AppSetting.d() + "E1D84CC825147ECD").substring(0, 16);
    try
    {
      byte[] arrayOfByte = str.getBytes("ISO8859_1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return str.getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwo
 * JD-Core Version:    0.7.0.1
 */