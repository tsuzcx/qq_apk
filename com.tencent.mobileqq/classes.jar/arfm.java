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

public class arfm
  extends aqwt<arfn>
{
  @NonNull
  public arfn a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = bhhr.n(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin());
    return new arfn(bhhr.o(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin()), str);
  }
  
  @Nullable
  public arfn a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onParsed, content:" + paramArrayOfaqxa);
    }
    try
    {
      paramArrayOfaqxa = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramArrayOfaqxa.getBytes("utf-8")));
      NodeList localNodeList = paramArrayOfaqxa.getElementsByTagName("video_redbag_config");
      if ((localNodeList != null) && (localNodeList.getLength() > 0))
      {
        paramArrayOfaqxa = new arfn(paramArrayOfaqxa.getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue(), paramArrayOfaqxa.getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue());
        return paramArrayOfaqxa;
      }
    }
    catch (Exception paramArrayOfaqxa)
    {
      QLog.e("RedBagVideoResProcessor", 1, "handleVideoRedbagConfig failed" + paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arfn paramarfn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onUpdate");
    }
  }
  
  public Class<arfn> clazz()
  {
    return arfn.class;
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
    return bhhr.ao(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin());
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
 * Qualified Name:     arfm
 * JD-Core Version:    0.7.0.1
 */