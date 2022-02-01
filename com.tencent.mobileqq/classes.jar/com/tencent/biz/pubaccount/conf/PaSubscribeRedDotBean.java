package com.tencent.biz.pubaccount.conf;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PaSubscribeRedDotBean
  implements IQStorageSafable<String>
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "";
  private int b = 0;
  
  public static PaSubscribeRedDotBean a(int paramInt, String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static PaSubscribeRedDotBean a(String paramString)
  {
    try
    {
      PaSubscribeRedDotBean localPaSubscribeRedDotBean = (PaSubscribeRedDotBean)QStorage.a(paramString, PaSubscribeRedDotBean.class);
      return localPaSubscribeRedDotBean;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadConfig l :");
      localStringBuilder.append(paramString);
      QLog.i("PublicAccountCenterUrlConfProcessor", 1, localStringBuilder.toString(), localQStorageInstantiateException);
    }
    return null;
  }
  
  public static PaSubscribeRedDotBean a(QConfItem[] paramArrayOfQConfItem)
  {
    PaSubscribeRedDotBean localPaSubscribeRedDotBean = null;
    int i = 0;
    while (i < paramArrayOfQConfItem.length)
    {
      localPaSubscribeRedDotBean = a(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
      i += 1;
    }
    return localPaSubscribeRedDotBean;
  }
  
  public void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      int i = SubscriptRecommendController.a((QQAppInterface)localObject);
      int j = this.jdField_a_of_type_Int;
      if (j == i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PaSubscribeRedDotProcessor", 2, "IGNORE THIS ACTION because of SAME VERSION");
        }
        return;
      }
      SubscriptRecommendController.a((QQAppInterface)localObject, j);
      SubscriptRecommendController.a((QQAppInterface)localObject, this.b, this.jdField_a_of_type_JavaLangString);
      localObject = (IWebProcessManagerService)((QQAppInterface)localObject).getRuntimeService(IWebProcessManagerService.class, "");
      if (localObject != null) {
        ((IWebProcessManagerService)localObject).startWebProcess(-1, null);
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateSubscribeConfig xml: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("PaSubscribeRedDotProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        localObject1 = paramString.getElementsByTagName("version");
        Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject2 instanceof QQAppInterface))
        {
          localObject2 = (QQAppInterface)localObject2;
          this.jdField_a_of_type_Int = Integer.parseInt(((NodeList)localObject1).item(0).getFirstChild().getNodeValue());
          paramString = paramString.getElementsByTagName("public-account-folder");
          if (paramString.getLength() > 0)
          {
            paramString = (Element)paramString.item(0);
            this.b = Integer.parseInt(paramString.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
            this.jdField_a_of_type_JavaLangString = paramString.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig xml is empty");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig error", paramString);
      }
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.PaSubscribeRedDotBean
 * JD-Core Version:    0.7.0.1
 */