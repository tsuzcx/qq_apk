import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class aogb
  implements Manager
{
  public static byte a;
  private int jdField_a_of_type_Int = 0;
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  
  static
  {
    jdField_a_of_type_Byte = 30;
  }
  
  public aogb(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)aush.a(paramQQAppInterface.getCurrentAccountUin(), "nearby_usercard_tab_host", Integer.valueOf(0))).intValue();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)aush.a(paramQQAppInterface.getCurrentAccountUin(), "face_score_switch", Integer.valueOf(0))).intValue() == 1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)aush.a(paramQQAppInterface.getCurrentAccountUin(), "nearby_usercard_tab_guest", Integer.valueOf(-1))).intValue();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a() {}
  
  public void a(NearbyAppInterface paramNearbyAppInterface, oidb_0x8dd.SelfInfo paramSelfInfo)
  {
    int i = 2;
    QLog.d("NearbyNiche", 2, "writeSelfInfo" + paramSelfInfo);
    if (paramSelfInfo == null) {}
    do
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramNearbyAppInterface.getCurrentAccountUin(), 4);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit().putString("nick", paramSelfInfo.bytes_nick.get().toStringUtf8()).putInt("charm_level", paramSelfInfo.uint32_charm_level.get()).putInt("charm", paramSelfInfo.uint32_charm.get()).putString("third_line", paramSelfInfo.str_third_line_info.get()).putString("third_line_icon", paramSelfInfo.str_third_line_icon.get()).putInt("god_flag", paramSelfInfo.uint32_god_flag.get()).putInt("real_video_auth", paramSelfInfo.uint32_real_video_flag.get()).putInt("gender", paramSelfInfo.uint32_gender.get()).putInt("age", paramSelfInfo.uint32_age.get()).putInt("task_finished", paramSelfInfo.uint32_finish_task_num.get()).putInt("task_total", paramSelfInfo.uint32_all_task_num.get());
        if (paramSelfInfo.uint32_vote_num.get() >= 0) {
          ((SharedPreferences.Editor)localObject).putInt("vote", paramSelfInfo.uint32_vote_num.get());
        }
        if (paramSelfInfo.uint32_vote_increment.get() >= 0) {
          ((SharedPreferences.Editor)localObject).putInt("vote_increment", paramSelfInfo.uint32_vote_increment.get());
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
    } while (paramSelfInfo.uint32_gender.get() == -1);
    switch (paramSelfInfo.uint32_gender.get())
    {
    }
    for (i = 0;; i = 1)
    {
      aush.a(paramNearbyAppInterface.getAccount(), "self_gender", Integer.valueOf(i));
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception paramString)
    {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aogb
 * JD-Core Version:    0.7.0.1
 */