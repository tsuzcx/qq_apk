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

public class ario
  extends arac<arip>
{
  @NonNull
  public arip a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = bhsi.n(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin());
    return new arip(bhsi.o(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin()), str);
  }
  
  @Nullable
  public arip a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onParsed, content:" + paramArrayOfaraj);
    }
    try
    {
      paramArrayOfaraj = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramArrayOfaraj.getBytes("utf-8")));
      NodeList localNodeList = paramArrayOfaraj.getElementsByTagName("video_redbag_config");
      if ((localNodeList != null) && (localNodeList.getLength() > 0))
      {
        paramArrayOfaraj = new arip(paramArrayOfaraj.getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue(), paramArrayOfaraj.getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue());
        return paramArrayOfaraj;
      }
    }
    catch (Exception paramArrayOfaraj)
    {
      QLog.e("RedBagVideoResProcessor", 1, "handleVideoRedbagConfig failed" + paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arip paramarip)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onUpdate");
    }
  }
  
  public Class<arip> clazz()
  {
    return arip.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return bhsi.an(localQQAppInterface.getApp(), localQQAppInterface.c());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onReqFailed");
    }
  }
  
  public int type()
  {
    return 252;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ario
 * JD-Core Version:    0.7.0.1
 */