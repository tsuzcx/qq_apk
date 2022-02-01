package com.tencent.mobileqq.apollo.api.model;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.IApolloConfigHelper;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.config.ApolloConfProcessor;
import com.tencent.mobileqq.apollo.config.ApolloGrayConfProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloConfBean
{
  private Map<String, String> mApolloConfigMap = new HashMap();
  
  public static String getContentByItem(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!paramBoolean) {}
    return paramString2;
  }
  
  public static ApolloConfBean parse(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject;
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      ApolloConfBean localApolloConfBean;
      int i;
      try
      {
        localApolloConfBean = new ApolloConfBean();
        i = 0;
        localObject = localApolloConfBean;
        if (i >= paramArrayOfQConfItem.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfQConfItem[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localApolloConfBean.mApolloConfigMap.put("apolloConfig", paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localApolloConfBean.mApolloConfigMap.put("apolloGame", paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfQConfItem, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localApolloConfBean.mApolloConfigMap.put("apolloPreDownload", paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
  
  public static void parseApolloConfBean(AppRuntime paramAppRuntime, boolean paramBoolean, ApolloConfBean paramApolloConfBean)
  {
    if ((paramAppRuntime == null) || (paramApolloConfBean == null) || (paramApolloConfBean.mApolloConfigMap.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        ApolloConfProcessor.b();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramApolloConfBean.mApolloConfigMap.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = getContentByItem(paramBoolean, str1, (String)paramApolloConfBean.mApolloConfigMap.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        IApolloConfigHelper localIApolloConfigHelper = (IApolloConfigHelper)QRoute.api(IApolloConfigHelper.class);
        if ("apolloConfig".equals(str1))
        {
          localIApolloConfigHelper.parseConfigJson(str2, paramAppRuntime, paramBoolean);
          if (paramBoolean) {
            ((IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).initCmShowBaseScript(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            localIApolloConfigHelper.parseGameConfigJson(paramAppRuntime, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            localIApolloConfigHelper.parsePreDownloadConfig(paramAppRuntime, str2);
          }
        }
      }
    } while (i == 0);
    ApolloGrayConfProcessor.a();
  }
  
  public static void rollbackConfig()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getString("sp_key_config_script", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.d("ApolloConfig_GlobalProcessor", 1, new Object[] { "rollbackConfig scriptConfig:", localObject });
        localObject = new JSONObject((String)localObject);
        ((IApolloConfigHelper)QRoute.api(IApolloConfigHelper.class)).parseBaseScriptConfig((JSONObject)localObject, "base_script", false);
        localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
        if (localObject != null) {
          ((IApolloManagerService)((AppRuntime)localObject).getRuntimeService(IApolloManagerService.class, "all")).setConfigInitDone(true);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloConfBean
 * JD-Core Version:    0.7.0.1
 */