import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;

public class bcwd
{
  public static long a;
  public static final String a;
  public static long b;
  public static long c;
  public static long d;
  public static long e;
  public static long f;
  public static long g;
  public static long h;
  public static long i;
  public static long j;
  public static long k;
  public static long l;
  public static long m;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo";
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 11;
    case 1: 
      return 9;
    }
    return 10;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      String str = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      if ("".equals(str))
      {
        QLog.d("AIOShortVideoUtil", 1, "camera result null");
        return;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 9501)
      {
        ChatActivityUtils.a(paramQQAppInterface, paramActivity, paramSessionInfo, 1, paramIntent, 1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOShortVideoUtil", 2, "on camera result " + paramInt1);
      }
      paramActivity.getIntent().removeExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      paramIntent = EditPicActivity.a(paramActivity, str, true, true, true, true, false, 2, 99, 1);
      paramIntent.putExtra("qq_sub_business_id", 109);
      agej.a(paramIntent, null);
      paramIntent.putExtra("camera_type", paramInt1);
      if (bhjx.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        paramIntent.putExtra("babyq_ability", ((antk)paramQQAppInterface.a(53)).a());
      }
      paramIntent.putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
      paramIntent.putExtra("editpic_cameratype", 3);
      paramActivity.startActivity(paramIntent);
      return;
    }
    paramQQAppInterface = new Intent(paramActivity, SendVideoActivity.class);
    paramIntent = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
    paramQQAppInterface.putExtra("file_send_path", paramIntent);
    paramQQAppInterface.putExtra("file_send_size", new File(paramIntent).length());
    paramQQAppInterface.putExtra("file_send_duration", ShortVideoUtils.a(paramIntent));
    paramQQAppInterface.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("file_source", "camera");
    paramQQAppInterface.putExtra("start_init_activity_after_sended", false);
    paramActivity.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwd
 * JD-Core Version:    0.7.0.1
 */