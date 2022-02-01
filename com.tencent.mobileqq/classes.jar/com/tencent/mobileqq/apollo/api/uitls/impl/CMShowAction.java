package com.tencent.mobileqq.apollo.api.uitls.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.JumpActionBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;

public class CMShowAction
  extends JumpActionBase
{
  public CMShowAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        Object localObject2 = this.jdField_a_of_type_JavaLangString.split("\\?");
        if (localObject2.length < 2) {
          break label367;
        }
        localIntent.putExtra("extra_key_url_append", localObject2[1]);
        if (localObject2[1] == null) {
          break label367;
        }
        if (localObject2[1].contains("tab=game_center"))
        {
          i = 0;
          j = 1;
          if (QLog.isColorLevel()) {
            QLog.d("CMShowAction", 2, new Object[] { "apollo_store url:", localObject1 });
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = ApolloConstant.u;
          }
          if (j != 0)
          {
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloGameCenter(this.jdField_a_of_type_AndroidContentContext);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break;
            }
            localObject1 = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", ((IApolloManagerService)localObject1).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), 0, new String[] { "0" });
            break;
          }
        }
        else
        {
          if (localObject2[1].contains("tab=other_url&url="))
          {
            localObject1 = URLDecoder.decode(localObject2[1].substring(localObject2[1].indexOf("tab=other_url&url=") + "tab=other_url&url=".length()));
            i = 1;
            j = 0;
            continue;
          }
          localObject1 = new HashMap();
          StoryShareEncryptHelper.a(localObject2[1], (HashMap)localObject1);
          localObject1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getStoreTabUrl((String)((HashMap)localObject1).get("tab"), true);
          i = 0;
          j = 0;
          continue;
        }
        if (i != 0)
        {
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openWebViewActivity(this.jdField_a_of_type_AndroidContentContext, (String)localObject2);
          continue;
        }
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_AndroidContentContext, localIntent, null, (String)localObject2, null);
      }
      catch (Exception localException)
      {
        a("CMShowAction");
        QLog.e("CMShowAction", 1, "doAction error: " + localException.getMessage());
        return false;
      }
      continue;
      label367:
      int i = 0;
      int j = 0;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.CMShowAction
 * JD-Core Version:    0.7.0.1
 */