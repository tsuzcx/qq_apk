package com.tencent.mobileqq.apollo.api.model;

import com.tencent.mobileqq.apollo.api.uitls.IApolloConfigHelper;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloGrayConfBean
{
  private Map<String, String> mApolloGrayConfigMap = new HashMap();
  
  public static ApolloGrayConfBean parse(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject;
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        ApolloGrayConfBean localApolloGrayConfBean = new ApolloGrayConfBean();
        i = 0;
        localObject = localApolloGrayConfBean;
        if (i >= paramArrayOfQConfItem.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfQConfItem[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localApolloGrayConfBean.mApolloGrayConfigMap.put("apolloGrayUrlWhite", paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localApolloGrayConfBean.mApolloGrayConfigMap.put("apolloTraceConfig", paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfQConfItem, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void parseApolloGrayConfBean(AppRuntime paramAppRuntime, boolean paramBoolean, ApolloGrayConfBean paramApolloGrayConfBean)
  {
    if ((paramAppRuntime == null) || (paramApolloGrayConfBean == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramApolloGrayConfBean.mApolloGrayConfigMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramApolloGrayConfBean.mApolloGrayConfigMap.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        IApolloConfigHelper localIApolloConfigHelper = (IApolloConfigHelper)QRoute.api(IApolloConfigHelper.class);
        if ("apolloGrayUrlWhite".equals(str1)) {
          localIApolloConfigHelper.parseUrlGrayConfigJson(paramAppRuntime, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          localIApolloConfigHelper.parseTraceConfigJson(paramAppRuntime, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloGrayConfBean
 * JD-Core Version:    0.7.0.1
 */