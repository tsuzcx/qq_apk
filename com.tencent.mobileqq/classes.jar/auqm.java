import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.VipBannerInfo.2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;

public class auqm
  implements auqi
{
  public auqm(VipBannerInfo.2 param2) {}
  
  public boolean a(auql paramauql)
  {
    if (paramauql == null) {}
    label385:
    label390:
    label396:
    label400:
    for (;;)
    {
      return false;
      int i;
      label86:
      int j;
      label163:
      label187:
      int k;
      if (1 == paramauql.jdField_b_of_type_Int)
      {
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("blue_banner_time_out" + this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getAccount(), System.currentTimeMillis() + paramauql.jdField_a_of_type_Long).commit();
        paramauql.jdField_b_of_type_Long = paramauql.jdField_a_of_type_Long;
        i = 1;
        if (paramauql.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null) {
          break label378;
        }
        m = paramauql.jdField_a_of_type_Int;
        if ((1 != paramauql.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get()) || (i == 0) || (TextUtils.isEmpty(paramauql.jdField_b_of_type_JavaLangString)) || (m < 1) || (m > 4)) {
          continue;
        }
        if ((1 != m) || (bajr.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
          break label380;
        }
        i = 1;
        if ((2 != m) || (bajr.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
          break label385;
        }
        j = 1;
        if ((3 != m) || (!bajr.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
          break label390;
        }
        k = 1;
        label212:
        if ((4 != m) || (!bajr.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
          break label396;
        }
      }
      for (int m = 1;; m = 0)
      {
        if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
          break label400;
        }
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9);
        Message localMessage = this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(8, paramauql);
        localMessage.obj = paramauql;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        return true;
        long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("blue_banner_time_out" + this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getAccount(), -1L);
        if (l > System.currentTimeMillis())
        {
          paramauql.jdField_b_of_type_Long = (l - System.currentTimeMillis());
          i = 1;
          break label86;
        }
        i = 0;
        break label86;
        label378:
        break;
        label380:
        i = 0;
        break label163;
        j = 0;
        break label187;
        k = 0;
        break label212;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auqm
 * JD-Core Version:    0.7.0.1
 */