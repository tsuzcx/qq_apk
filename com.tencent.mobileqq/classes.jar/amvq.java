import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class amvq
  extends ampa<amvr>
{
  public int a()
  {
    return 252;
  }
  
  @NonNull
  public amvr a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = bbkb.m(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin());
    return new amvr(bbkb.n(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin()), str);
  }
  
  @Nullable
  public amvr a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length == 0)) {
      return null;
    }
    paramArrayOfamph = paramArrayOfamph[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onParsed, content:" + paramArrayOfamph);
    }
    try
    {
      paramArrayOfamph = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramArrayOfamph.getBytes("utf-8")));
      NodeList localNodeList = paramArrayOfamph.getElementsByTagName("video_redbag_config");
      if ((localNodeList != null) && (localNodeList.getLength() > 0))
      {
        paramArrayOfamph = new amvr(paramArrayOfamph.getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue(), paramArrayOfamph.getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue());
        return paramArrayOfamph;
      }
    }
    catch (Exception paramArrayOfamph)
    {
      QLog.e("RedBagVideoResProcessor", 1, "handleVideoRedbagConfig failed" + paramArrayOfamph);
    }
    return null;
  }
  
  public Class<amvr> a()
  {
    return amvr.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onReqFailed");
    }
  }
  
  public void a(amvr paramamvr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onUpdate");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return bbkb.am(localQQAppInterface.getApp(), localQQAppInterface.c());
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvq
 * JD-Core Version:    0.7.0.1
 */