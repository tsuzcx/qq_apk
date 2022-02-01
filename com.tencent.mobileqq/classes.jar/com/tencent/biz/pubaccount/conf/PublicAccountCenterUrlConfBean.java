package com.tencent.biz.pubaccount.conf;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
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
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private String c = "";
  
  public static PublicAccountCenterUrlConfBean a()
  {
    PublicAccountCenterUrlConfBean localPublicAccountCenterUrlConfBean = new PublicAccountCenterUrlConfBean();
    localPublicAccountCenterUrlConfBean.jdField_a_of_type_JavaLangString = PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CENTER_URL;
    localPublicAccountCenterUrlConfBean.jdField_b_of_type_JavaLangString = PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CATEGORY_URL;
    localPublicAccountCenterUrlConfBean.c = PublicAccountConfigUtilImpl.READINJOY_SEARCH_URL;
    localPublicAccountCenterUrlConfBean.jdField_a_of_type_Boolean = PublicAccountConfigUtilImpl.IMAGE_COLLECTION_COMMENT;
    return localPublicAccountCenterUrlConfBean;
  }
  
  private PublicAccountCenterUrlConfBean a(PublicAccountCenterUrlConfBean paramPublicAccountCenterUrlConfBean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return this;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("pacenter_url")) {
          this.jdField_a_of_type_JavaLangString = paramPublicAccountCenterUrlConfBean.jdField_a_of_type_JavaLangString;
        }
        if (paramString.has("pacategory_url")) {
          this.jdField_b_of_type_JavaLangString = paramPublicAccountCenterUrlConfBean.jdField_b_of_type_JavaLangString;
        }
        if (paramString.has("readinjoy_search_url")) {
          this.c = paramPublicAccountCenterUrlConfBean.c;
        }
        if (paramString.has("image_collection_comment")) {
          this.jdField_a_of_type_Boolean = paramPublicAccountCenterUrlConfBean.jdField_a_of_type_Boolean;
        }
        if (paramPublicAccountCenterUrlConfBean.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
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
    }
    return this;
  }
  
  public static PublicAccountCenterUrlConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject = new PublicAccountCenterUrlConfBean();
    int i = 0;
    String str;
    for (;;)
    {
      if (i >= paramArrayOfQConfItem.length) {
        return localObject;
      }
      str = paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString;
      try
      {
        PublicAccountCenterUrlConfBean localPublicAccountCenterUrlConfBean = ((PublicAccountCenterUrlConfBean)localObject).a((PublicAccountCenterUrlConfBean)QStorage.a(str, PublicAccountCenterUrlConfBean.class), str);
        localObject = localPublicAccountCenterUrlConfBean;
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + str, localQStorageInstantiateException);
        }
      }
      i += 1;
    }
    return localObject;
  }
  
  public void a()
  {
    PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CENTER_URL = this.jdField_a_of_type_JavaLangString;
    PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CATEGORY_URL = this.jdField_b_of_type_JavaLangString;
    PublicAccountConfigUtilImpl.READINJOY_SEARCH_URL = this.c;
    PublicAccountConfigUtilImpl.IMAGE_COLLECTION_COMMENT = this.jdField_a_of_type_Boolean;
  }
  
  public void a(String paramString)
  {
    boolean bool3 = true;
    for (;;)
    {
      boolean bool2;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (!PublicAccountConfigUtilImpl.checkUrlFormat(str1)) {
          break label156;
        }
        this.jdField_a_of_type_JavaLangString = str1;
        bool1 = true;
        if (PublicAccountConfigUtilImpl.checkUrlFormat(str2))
        {
          this.jdField_b_of_type_JavaLangString = str2;
          bool1 = true;
        }
        bool2 = bool1;
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
          this.jdField_a_of_type_Boolean = paramString.getBoolean("image_collection_comment");
          bool1 = bool3;
          this.jdField_b_of_type_Boolean = bool1;
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", paramString);
        }
        paramString.printStackTrace();
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      boolean bool1 = bool2;
      continue;
      label156:
      bool1 = false;
    }
  }
  
  public void b()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updatePublicAccountCenterUrlConfigData((QQAppInterface)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.PublicAccountCenterUrlConfBean
 * JD-Core Version:    0.7.0.1
 */