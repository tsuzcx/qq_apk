import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.VipBannerInfo.2;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class axme
  implements axlz
{
  public axme(VipBannerInfo.2 param2) {}
  
  public boolean a(axmd paramaxmd)
  {
    if (paramaxmd == null) {}
    label98:
    label357:
    label362:
    label368:
    label372:
    for (;;)
    {
      return false;
      Object localObject = (QQAppInterface)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localObject != null)
      {
        int i;
        int j;
        int k;
        if (1 == paramaxmd.jdField_b_of_type_Int)
        {
          this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("blue_banner_time_out" + ((QQAppInterface)localObject).getAccount(), System.currentTimeMillis() + paramaxmd.jdField_a_of_type_Long).commit();
          paramaxmd.jdField_b_of_type_Long = paramaxmd.jdField_a_of_type_Long;
          i = 1;
          if (paramaxmd.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null) {
            break label350;
          }
          m = paramaxmd.jdField_a_of_type_Int;
          if ((1 != paramaxmd.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get()) || (i == 0) || (TextUtils.isEmpty(paramaxmd.jdField_b_of_type_JavaLangString)) || (m < 1) || (m > 4)) {
            continue;
          }
          if ((1 != m) || (VipUtils.c((QQAppInterface)localObject))) {
            break label352;
          }
          i = 1;
          if ((2 != m) || (VipUtils.b((QQAppInterface)localObject))) {
            break label357;
          }
          j = 1;
          if ((3 != m) || (!VipUtils.c((QQAppInterface)localObject))) {
            break label362;
          }
          k = 1;
          if ((4 != m) || (!VipUtils.b((QQAppInterface)localObject))) {
            break label368;
          }
        }
        for (int m = 1;; m = 0)
        {
          if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
            break label372;
          }
          this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9);
          localObject = this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(8, paramaxmd);
          ((Message)localObject).obj = paramaxmd;
          this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          return true;
          long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("blue_banner_time_out" + ((QQAppInterface)localObject).getAccount(), -1L);
          if (l > System.currentTimeMillis())
          {
            paramaxmd.jdField_b_of_type_Long = (l - System.currentTimeMillis());
            i = 1;
            break label98;
          }
          i = 0;
          break label98;
          break;
          i = 0;
          break label167;
          j = 0;
          break label183;
          k = 0;
          break label200;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axme
 * JD-Core Version:    0.7.0.1
 */