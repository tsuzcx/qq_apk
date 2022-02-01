package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.web.IApolloJsCallBack;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class Makeup3DJsModule$2
  implements IApolloResManager.ApolloDressInfoListener
{
  Makeup3DJsModule$2(Makeup3DJsModule paramMakeup3DJsModule, long paramLong, ArrayList paramArrayList, String paramString, Activity paramActivity, int paramInt, Map paramMap) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("duration", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    ((Map)localObject).put("itemids", this.jdField_a_of_type_JavaUtilArrayList.toString());
    ApolloDtReportUtil.a("dressup_3d_page", "model", "change_dress", (Map)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleCmShowChange3DAvatarComponent] onGetApolloDressInfo: ");
    ((StringBuilder)localObject).append(paramHashMap);
    ((StringBuilder)localObject).append(", errMsg: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[cmshow]Makeup3DJsModule", 1, ((StringBuilder)localObject).toString());
    if (paramHashMap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_JavaLangString, paramString);
      Makeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule, false, paramString);
      paramHashMap = new StringBuilder();
      paramHashMap.append("[handleCmShowChange3DAvatarComponent] dress info is null ");
      paramHashMap.append(paramString);
      QLog.e("[cmshow]Makeup3DJsModule", 1, paramHashMap.toString());
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new Makeup3DJsModule.2.1(this));
      return;
    }
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 0)
    {
      paramString = new CmShowAssetsData();
      localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramString.a.put(localEntry.getValue(), paramHashMap.get(localEntry.getKey()));
      }
      paramHashMap = this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a();
      if ((paramHashMap instanceof IApolloJsCallBack))
      {
        ((IApolloJsCallBack)paramHashMap).a(paramString, 2);
        Makeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule, true, "");
        this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] no apolloJsCallBack to handle this event!");
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_JavaLangString, "no apolloJsCallBack to handle this event!");
      Makeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule, false, "no apolloJsCallBack to handle this event!");
      return;
    }
    if (paramInt == 1)
    {
      ThreadManager.getFileThreadHandler().post(new Makeup3DJsModule.2.2(this, paramHashMap));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_JavaLangString, "invalid param: type");
    Makeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule, false, "invalid param: type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.2
 * JD-Core Version:    0.7.0.1
 */