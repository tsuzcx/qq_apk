import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
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

public class aokf
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
        paramString = aokb.a();
      } while (paramString == null);
      a(paramString.a, paramArrayOfByte);
      return;
    case 24: 
      aokb.a.b();
      aokb.a.a(false);
      a(aokb.a, paramArrayOfByte, paramString);
      return;
    }
    aokb.b.b();
    aokb.b.a(false);
    a(aokb.b, paramArrayOfByte);
  }
  
  private static void a(aoke paramaoke, byte[] paramArrayOfByte)
  {
    int i = bdqa.a(paramArrayOfByte, 0);
    paramaoke.jdField_a_of_type_JavaLangString = bdqa.a(paramArrayOfByte, 2, i);
    i += 2;
    paramaoke.jdField_a_of_type_Byte = paramArrayOfByte[i];
    i += 1;
    paramaoke.jdField_b_of_type_Byte = paramArrayOfByte[i];
    int j = i + 1;
    i = bdqa.a(paramArrayOfByte, j);
    j += 2;
    paramaoke.jdField_b_of_type_JavaLangString = bdqa.a(paramArrayOfByte, j, i);
  }
  
  private static void a(aokg paramaokg) {}
  
  private static void a(aokg paramaokg, String paramString)
  {
    int k = 2;
    int m = 0;
    int n = bdqa.a(paramaokg.jdField_a_of_type_ArrayOfByte, 0);
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
      k = bdqa.a(paramaokg.jdField_a_of_type_ArrayOfByte, j);
      m = j + 2;
      j = bdqa.a(paramaokg.jdField_a_of_type_ArrayOfByte, m);
      m += 2;
      byte[] arrayOfByte = new byte[j];
      bdqa.b(paramaokg.jdField_a_of_type_ArrayOfByte, m, arrayOfByte, j);
      j = m + j;
      a(k, arrayOfByte, paramString);
      i += 1;
    }
    paramaokg = aokb.a();
    if (paramaokg != null) {
      paramaokg.c();
    }
  }
  
  private static void a(aozv paramaozv, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--buildItem_FlashLogo = ");
    }
    paramaozv.jdField_a_of_type_Long = bdqa.a(paramArrayOfByte, 0);
    paramaozv.b = (bdqa.a(paramArrayOfByte, 4) * 1000L);
    paramaozv.c = (bdqa.a(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int m;
    int n;
    for (int j = 13; i < k; j = n + m)
    {
      long l = bdqa.a(paramArrayOfByte, j);
      m = j + 4;
      j = paramArrayOfByte[m];
      n = m + 1 + 1;
      m = bdqa.a(paramArrayOfByte, n);
      n += 2;
      String str1 = bdqa.a(paramArrayOfByte, n, m);
      n += m;
      m = bdqa.a(paramArrayOfByte, n);
      n += 2;
      String str2 = bdqa.a(paramArrayOfByte, n, m);
      if (j == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShanPing", 2, "flashlogo desc= " + str1 + " src addr = " + str2);
        }
        str2 = paramaozv.a(str1, (byte)3);
        paramaozv.c(str2);
        paramaozv.a(paramaozv.a(l, str1, str2, null, ""));
      }
      i += 1;
    }
  }
  
  private static void a(aozv paramaozv, byte[] paramArrayOfByte, String paramString)
  {
    paramaozv.jdField_a_of_type_Long = bdqa.a(paramArrayOfByte, 0);
    paramaozv.b = (bdqa.a(paramArrayOfByte, 4) * 1000L);
    paramaozv.c = (bdqa.a(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int j = 13;
    if (k > 0)
    {
      paramaozv.c();
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + paramString, true).commit();
    }
    int i = 0;
    while (i < k)
    {
      long l1 = bdqa.a(paramArrayOfByte, j);
      int m = j + 4;
      j = paramArrayOfByte[m];
      m = m + 1 + 1;
      long l2 = bdqa.a(paramArrayOfByte, m);
      int n = m + 4;
      m = bdqa.a(paramArrayOfByte, n);
      int i1 = n + 2;
      n = bdqa.a(paramArrayOfByte, i1);
      i1 += 2;
      paramString = bdqa.a(paramArrayOfByte, i1, n);
      i1 += n;
      n = bdqa.a(paramArrayOfByte, i1);
      i1 += 2;
      String str2 = bdqa.a(paramArrayOfByte, i1, n);
      i1 += n;
      n = bdqa.a(paramArrayOfByte, i1);
      i1 += 2;
      String str1 = bdqa.a(paramArrayOfByte, i1, n);
      if (j == 1)
      {
        str2 = paramaozv.a(str2, (byte)3);
        if (!a(String.valueOf(l1))) {
          paramaozv.c(str2);
        }
        paramaozv.a(paramaozv.a(l1, paramString, str2, str1, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + l1, "" + l2, (short)m));
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
  
  private static void a(byte[] paramArrayOfByte, aokg paramaokg)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 11)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte[0] == 2)
      {
        paramaokg.b = bdqa.a(paramArrayOfByte, 1);
        paramaokg.jdField_a_of_type_Short = bdqa.a(paramArrayOfByte, 3);
        paramaokg.jdField_a_of_type_Long = (bdqa.a(paramArrayOfByte, 5) * 1000L);
        paramaokg.jdField_a_of_type_Byte = paramArrayOfByte[9];
        int i = paramArrayOfByte.length - 10 - 1;
        if (paramaokg.jdField_a_of_type_Byte == 0)
        {
          paramaokg.jdField_a_of_type_ArrayOfByte = new byte[i];
          bdqa.b(paramArrayOfByte, 10, paramaokg.jdField_a_of_type_ArrayOfByte, i);
        }
        while (paramArrayOfByte.length != i + 10 + 1)
        {
          return;
          paramaokg.jdField_a_of_type_JavaLangString = bdqa.a(paramArrayOfByte, 10, i);
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString).exists();
  }
  
  public static boolean a(byte[] paramArrayOfByte, aokg paramaokg, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    do
    {
      do
      {
        return false;
        a(paramArrayOfByte, paramaokg);
      } while (paramaokg.b != 768);
      if (paramaokg.jdField_a_of_type_Byte != 0)
      {
        a(paramaokg);
        return false;
      }
    } while ((paramaokg.jdField_a_of_type_ArrayOfByte == null) || (paramaokg.jdField_a_of_type_ArrayOfByte.length == 0));
    a(paramaokg, paramString);
    return true;
  }
  
  private static byte[] a()
  {
    String str = MD5.toMD5(aokb.a() + AppSetting.d() + "E1D84CC825147ECD").substring(0, 16);
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
 * Qualified Name:     aokf
 * JD-Core Version:    0.7.0.1
 */