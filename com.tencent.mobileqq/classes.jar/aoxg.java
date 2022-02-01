import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aoxg
  extends aouc
{
  public aoxg(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    i = 0;
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("guin");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!TroopInfo.isTroopMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopProfileAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject });
      }
      return false;
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("TroopProfileAction", 1, "illegal goToTroopProfileApp jumpAction. action type is null");
      label94:
      if (!"group_file".equals(str)) {
        break label156;
      }
      TroopUtils.startTroopFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject);
    }
    for (;;)
    {
      return true;
      QLog.e("TroopProfileAction", 1, "goToTroopProfileApp jumpAction. type[" + str + "]");
      break label94;
      label156:
      if ("group_album".equals(str)) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gname");
      }
      try
      {
        j = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("unreadnum"));
        i = j;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        int j;
        label198:
        break label198;
      }
      TroopUtils.gotoQZoneQun(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject, str, i);
      continue;
      if ("group_story".equals(str)) {
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
                label342:
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
              localObject = QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, null, (String)localObject, j, k);
              ((Intent)localObject).putExtra("extra_last_open_from", m);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              j = i;
              i = k;
              break label342;
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
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc");
      localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", (String)localObject);
      localBundle.putString("selfSet_leftViewText", anvx.a(2131705373));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxg
 * JD-Core Version:    0.7.0.1
 */