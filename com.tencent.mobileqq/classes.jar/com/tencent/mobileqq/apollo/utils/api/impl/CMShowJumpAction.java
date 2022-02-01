package com.tencent.mobileqq.apollo.utils.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;

public class CMShowJumpAction
  extends JumpAction
{
  public CMShowJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    label324:
    label329:
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split("\\?");
        localStringBuilder = null;
        Object localObject = localStringBuilder;
        if (arrayOfString.length >= 2)
        {
          localIntent.putExtra("extra_key_url_append", arrayOfString[1]);
          localObject = localStringBuilder;
          if (arrayOfString[1] != null)
          {
            if (arrayOfString[1].contains("tab=other_url&url="))
            {
              localObject = URLDecoder.decode(arrayOfString[1].substring(arrayOfString[1].indexOf("tab=other_url&url=") + 18));
              i = 1;
            }
            else
            {
              localObject = new HashMap();
              StoryShareEncryptHelper.a(arrayOfString[1], (HashMap)localObject);
              localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getStoreTabUrl((String)((HashMap)localObject).get("tab"), true);
              break label324;
            }
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]CMShowAction", 2, new Object[] { "apollo_store url:", localObject });
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label329;
            }
            localObject = ApolloConstant.z;
            if (i != 0) {
              ((IApolloUtil)QRoute.api(IApolloUtil.class)).openWebViewActivity(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            } else {
              ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_AndroidContentContext, localIntent, null, (String)localObject, null);
            }
            if (this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface != null)
            {
              localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
              VipUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "cmshow", "Apollo", "action_clk", ((IApolloManagerService)localObject).getApolloStatus(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentUin()), 0, new String[] { "0" });
            }
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        b_("[cmshow]CMShowAction");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doAction error: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("[cmshow]CMShowAction", 1, localStringBuilder.toString());
        return false;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.CMShowJumpAction
 * JD-Core Version:    0.7.0.1
 */