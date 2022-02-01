package com.tencent.biz.pubaccount.conf;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class PublicAccountCenterUrlConfBean
  implements IQStorageSafable<String>
{
  private String a = "";
  private String b = "";
  private String c = "";
  private boolean d = false;
  private boolean e = false;
  
  public static PublicAccountCenterUrlConfBean a()
  {
    PublicAccountCenterUrlConfBean localPublicAccountCenterUrlConfBean = new PublicAccountCenterUrlConfBean();
    localPublicAccountCenterUrlConfBean.a = PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CENTER_URL;
    localPublicAccountCenterUrlConfBean.b = PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CATEGORY_URL;
    localPublicAccountCenterUrlConfBean.c = PublicAccountConfigUtilImpl.READINJOY_SEARCH_URL;
    localPublicAccountCenterUrlConfBean.d = PublicAccountConfigUtilImpl.IMAGE_COLLECTION_COMMENT;
    return localPublicAccountCenterUrlConfBean;
  }
  
  private PublicAccountCenterUrlConfBean a(PublicAccountCenterUrlConfBean paramPublicAccountCenterUrlConfBean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return this;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("pacenter_url")) {
        this.a = paramPublicAccountCenterUrlConfBean.a;
      }
      if (paramString.has("pacategory_url")) {
        this.b = paramPublicAccountCenterUrlConfBean.b;
      }
      if (paramString.has("readinjoy_search_url")) {
        this.c = paramPublicAccountCenterUrlConfBean.c;
      }
      if (paramString.has("image_collection_comment")) {
        this.d = paramPublicAccountCenterUrlConfBean.d;
      }
      if (paramPublicAccountCenterUrlConfBean.e)
      {
        this.e = true;
        return this;
      }
    }
    catch (Exception paramPublicAccountCenterUrlConfBean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", paramPublicAccountCenterUrlConfBean);
      }
      paramPublicAccountCenterUrlConfBean.printStackTrace();
    }
    return this;
  }
  
  public static PublicAccountCenterUrlConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject = new PublicAccountCenterUrlConfBean();
    int i = 0;
    while (i < paramArrayOfQConfItem.length)
    {
      String str = paramArrayOfQConfItem[i].b;
      try
      {
        PublicAccountCenterUrlConfBean localPublicAccountCenterUrlConfBean = ((PublicAccountCenterUrlConfBean)localObject).a((PublicAccountCenterUrlConfBean)QStorage.a(str, PublicAccountCenterUrlConfBean.class), str);
        localObject = localPublicAccountCenterUrlConfBean;
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadConfig l :");
        localStringBuilder.append(str);
        QLog.i("PublicAccountCenterUrlConfProcessor", 1, localStringBuilder.toString(), localQStorageInstantiateException);
      }
      i += 1;
    }
    return localObject;
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (PublicAccountConfigUtilImpl.checkUrlFormat(str1))
        {
          this.a = str1;
          bool1 = true;
          if (PublicAccountConfigUtilImpl.checkUrlFormat(str2))
          {
            this.b = str2;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (paramString.has("readinjoy_search_url"))
          {
            str1 = paramString.getString("readinjoy_search_url");
            bool2 = bool1;
            if (PublicAccountConfigUtilImpl.checkUrlFormat(str1))
            {
              this.c = str1;
              bool2 = true;
            }
          }
          if (paramString.has("image_collection_comment"))
          {
            this.d = paramString.getBoolean("image_collection_comment");
            bool2 = true;
          }
          this.e = bool2;
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", paramString);
        }
        paramString.printStackTrace();
        this.e = false;
        return;
      }
      boolean bool1 = false;
    }
  }
  
  public void b()
  {
    PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CENTER_URL = this.a;
    PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CATEGORY_URL = this.b;
    PublicAccountConfigUtilImpl.READINJOY_SEARCH_URL = this.c;
    PublicAccountConfigUtilImpl.IMAGE_COLLECTION_COMMENT = this.d;
  }
  
  public void c()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updatePublicAccountCenterUrlConfigData((AppInterface)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.PublicAccountCenterUrlConfBean
 * JD-Core Version:    0.7.0.1
 */