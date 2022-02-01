package com.tencent.biz.pubaccount.conf;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PublicAccountConfBean
  implements IQStorageSafable<String>
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<IPublicAccountConfigUtil.PublicAccountConfigFolder> jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
  private boolean jdField_a_of_type_Boolean = false;
  
  public static PublicAccountConfBean a(String paramString)
  {
    try
    {
      PublicAccountConfBean localPublicAccountConfBean = (PublicAccountConfBean)QStorage.a(paramString, PublicAccountConfBean.class);
      return localPublicAccountConfBean;
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
  
  public static PublicAccountConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    PublicAccountConfBean localPublicAccountConfBean = null;
    int i = 0;
    while (i < paramArrayOfQConfItem.length)
    {
      localPublicAccountConfBean = a(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
      i += 1;
    }
    return localPublicAccountConfBean;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        SharedPreUtils.f(((QQAppInterface)localAppRuntime).getApplication(), this.jdField_a_of_type_JavaLangString);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("PublicAccountConfProcessor", 2, "updateEqqConfig fail");
    }
  }
  
  public void a(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseConfigXml xml: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("PublicAccountConfProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getElementsByTagName("public-account-folder");
        int j = paramString.getLength();
        Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject2 instanceof QQAppInterface))
        {
          localObject1 = (QQAppInterface)localObject2;
          localObject2 = ((AppRuntime)localObject2).getApplication();
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
          int i = 0;
          while (i < j)
          {
            Object localObject3 = (Element)paramString.item(i);
            int k = Integer.parseInt(((Element)localObject3).getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
            String str = ((Element)localObject3).getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
            localObject3 = ((Element)localObject3).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue();
            IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = new IPublicAccountConfigUtil.PublicAccountConfigFolder();
            ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).initPublicAccountConfigFolder(localPublicAccountConfigFolder, (AppInterface)localObject1, (Context)localObject2, k, str, (String)localObject3);
            this.jdField_a_of_type_JavaUtilArrayList.add(localPublicAccountConfigFolder);
            i += 1;
          }
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfProcessor", 2, "parsePublicAccountConfigXml xml is empty");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfProcessor", 2, "parsePublicAccountConfigXml error", paramString);
      }
      paramString.printStackTrace();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      PublicAccountConfigUtilImpl.addFolders(this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.PublicAccountConfBean
 * JD-Core Version:    0.7.0.1
 */