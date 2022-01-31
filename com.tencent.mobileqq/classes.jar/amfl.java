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

public class amfl
  extends alzl<amfm>
{
  public int a()
  {
    return 252;
  }
  
  @NonNull
  public amfm a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = baig.m(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin());
    return new amfm(baig.n(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin()), str);
  }
  
  @Nullable
  public amfm a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length == 0)) {
      return null;
    }
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onParsed, content:" + paramArrayOfalzs);
    }
    try
    {
      paramArrayOfalzs = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramArrayOfalzs.getBytes("utf-8")));
      NodeList localNodeList = paramArrayOfalzs.getElementsByTagName("video_redbag_config");
      if ((localNodeList != null) && (localNodeList.getLength() > 0))
      {
        paramArrayOfalzs = new amfm(paramArrayOfalzs.getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue(), paramArrayOfalzs.getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue());
        return paramArrayOfalzs;
      }
    }
    catch (Exception paramArrayOfalzs)
    {
      QLog.e("RedBagVideoResProcessor", 1, "handleVideoRedbagConfig failed" + paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amfm> a()
  {
    return amfm.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onReqFailed");
    }
  }
  
  public void a(amfm paramamfm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onUpdate");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return baig.am(localQQAppInterface.getApp(), localQQAppInterface.c());
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
 * Qualified Name:     amfl
 * JD-Core Version:    0.7.0.1
 */