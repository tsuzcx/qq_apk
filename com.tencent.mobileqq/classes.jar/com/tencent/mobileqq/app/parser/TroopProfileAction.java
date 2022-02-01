package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class TroopProfileAction
  extends JumpActionBase
{
  public TroopProfileAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    i = 0;
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("guin");
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((TroopManager)localObject2).m((String)localObject1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopProfileAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject1 });
      }
      return false;
    }
    localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.e("TroopProfileAction", 1, "illegal goToTroopProfileApp jumpAction. action type is null");
      label107:
      if (!"group_file".equals(localObject2)) {
        break label169;
      }
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
    }
    for (;;)
    {
      return true;
      QLog.e("TroopProfileAction", 1, "goToTroopProfileApp jumpAction. type[" + (String)localObject2 + "]");
      break label107;
      label169:
      if ("group_album".equals(localObject2)) {
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gname");
      }
      try
      {
        j = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("unreadnum"));
        i = j;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        int j;
        label211:
        break label211;
      }
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, (String)localObject2, i);
      continue;
      if ("group_story".equals(localObject2)) {
        for (;;)
        {
          for (;;)
          {
            int k;
            int m;
            try
            {
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("troopStoryMemoriesFrom")) {
                i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopStoryMemoriesFrom"));
              }
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              i = 0;
              j = 0;
            }
            try
            {
              k = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("playVideoFrom"));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              for (;;)
              {
                label355:
                Bundle localBundle;
                k = 0;
                j = i;
                i = k;
              }
            }
            try
            {
              m = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("lastOpenFrom"));
              j = i;
              localObject1 = QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, null, (String)localObject1, j, k);
              ((Intent)localObject1).putExtra("extra_last_open_from", m);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              j = i;
              i = k;
              break label355;
            }
          }
          i = 8;
          continue;
          m = 0;
          k = i;
        }
      }
      if (!"bulk_send_message".equals(localNumberFormatException1)) {
        break;
      }
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc");
      localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", (String)localObject1);
      localBundle.putString("selfSet_leftViewText", HardCodeUtil.a(2131705916));
      BulkSendMessageFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("TroopProfileAction", 1, "doAction error: " + localException.getMessage());
      a("TroopProfileAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TroopProfileAction
 * JD-Core Version:    0.7.0.1
 */