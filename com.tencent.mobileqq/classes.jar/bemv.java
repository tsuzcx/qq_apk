import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.together.writetogether.data.EditUserHistory;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.Atext;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.EditUinInfo;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.RspGetDocContent;

public class bemv
{
  public static int a()
  {
    int j = b().getInt("KEY_WRITE_TOGETHER_WORD_LIMIT_", 0);
    int i = j;
    if (j == 0) {
      i = 10000;
    }
    return i;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 5: 
      return 4;
    case 7: 
      return 5;
    case 4: 
      return 6;
    case 8: 
      return 7;
    }
    return 8;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
    if (paramQQAppInterface == null) {
      return 0;
    }
    return (int)paramQQAppInterface.dwGroupClassExt;
  }
  
  public static aamq a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new aamq();
    paramString1.jdField_a_of_type_JavaLangString = "android";
    paramString1.jdField_b_of_type_JavaLangString = AppSetting.f();
    paramString1.jdField_c_of_type_JavaLangString = "1";
    paramString1.jdField_e_of_type_JavaLangString = "KQQ";
    paramString1.f = "2400002";
    paramString1.h = "25043";
    paramString1.g = "write_togethe";
    paramString1.j = ("group_id:" + paramString2 + "|doc_id:" + paramString3 + "|base_version:" + paramInt);
    paramString1.s = paramString2;
    paramString1.jdField_d_of_type_JavaLangString = paramString4;
    return paramString1;
  }
  
  public static benw a(String paramString)
  {
    benw localbenw = new benw();
    try
    {
      paramString = new JSONObject(paramString);
      localbenw.jdField_a_of_type_JavaLangString = paramString.optString("creatorId");
      localbenw.jdField_a_of_type_Long = paramString.optLong("mtime");
      localbenw.jdField_b_of_type_JavaLangString = paramString.optString("padId");
      return localbenw;
    }
    catch (Exception paramString)
    {
      QLog.e("WriteTogetherUtils", 4, "[parseMetaDataFromJson] parse json error", paramString);
    }
    return localbenw;
  }
  
  public static OpenDocParam a(oidb_cmd0xe89.RspGetDocContent paramRspGetDocContent)
  {
    OpenDocParam localOpenDocParam = new OpenDocParam();
    localOpenDocParam.f = paramRspGetDocContent.bytes_global_padid.get().toStringUtf8();
    localOpenDocParam.jdField_a_of_type_Int = paramRspGetDocContent.uint32_doc_type.get();
    localOpenDocParam.g = paramRspGetDocContent.bytes_title.get().toStringUtf8();
    oidb_cmd0xe89.Atext localAtext = (oidb_cmd0xe89.Atext)paramRspGetDocContent.msg_atext.get(0);
    localOpenDocParam.jdField_d_of_type_JavaLangString = localAtext.bytes_name.get().toStringUtf8();
    localOpenDocParam.jdField_e_of_type_JavaLangString = localAtext.bytes_subid.get().toStringUtf8();
    localOpenDocParam.jdField_a_of_type_JavaLangString = localAtext.bytes_text.get().toStringUtf8();
    localOpenDocParam.jdField_b_of_type_JavaLangString = localAtext.bytes_attribs.get().toStringUtf8();
    localOpenDocParam.jdField_c_of_type_JavaLangString = localAtext.bytes_apool.get().toStringUtf8();
    localOpenDocParam.h = paramRspGetDocContent.bytes_subid.get().toStringUtf8();
    localOpenDocParam.jdField_b_of_type_Int = paramRspGetDocContent.uint32_baseRev.get();
    localOpenDocParam.jdField_c_of_type_Int = paramRspGetDocContent.uint32_baseLen.get();
    localOpenDocParam.i = paramRspGetDocContent.bytes_meta.get().toStringUtf8();
    localOpenDocParam.jdField_d_of_type_Int = paramRspGetDocContent.uint32_sheetPosLen.get();
    localOpenDocParam.j = paramRspGetDocContent.bytes_owner_appid.get().toStringUtf8();
    localOpenDocParam.jdField_a_of_type_Long = paramRspGetDocContent.uint64_baseLen.get();
    localOpenDocParam.jdField_b_of_type_Long = paramRspGetDocContent.uint64_sheetPosLen.get();
    localOpenDocParam.jdField_a_of_type_JavaUtilList = a(paramRspGetDocContent.rpt_edit_uin_list.get());
    localOpenDocParam.jdField_c_of_type_Long = paramRspGetDocContent.uint64_owner_uin.get();
    if (paramRspGetDocContent.uint32_max_len.has()) {}
    for (int i = paramRspGetDocContent.uint32_max_len.get();; i = 10000)
    {
      localOpenDocParam.jdField_e_of_type_Int = i;
      if (localOpenDocParam.jdField_e_of_type_Int <= 0) {
        localOpenDocParam.jdField_e_of_type_Int = 10000;
      }
      return localOpenDocParam;
    }
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return "";
    }
    return new begp(paramCharSequence, 5).a(false);
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 7)) {}
    do
    {
      return paramString;
      if (paramString.startsWith("p.")) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WriteTogetherUtils", 2, "userId is not start with p.");
    return paramString;
    return paramString.substring(2);
  }
  
  public static String a(String paramString, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString, new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1) });
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString1, new Object[] { paramString2, Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1) });
  }
  
  private static List<EditUserHistory> a(List<oidb_cmd0xe89.EditUinInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0xe89.EditUinInfo localEditUinInfo = (oidb_cmd0xe89.EditUinInfo)paramList.next();
      localArrayList.add(new EditUserHistory(String.valueOf(localEditUinInfo.uint.get()), localEditUinInfo.last_edit_ts.get(), localEditUinInfo.nick_name.get().toStringUtf8()));
    }
    return localArrayList;
  }
  
  public static void a(int paramInt)
  {
    b().edit().putInt("KEY_WRITE_TOGETHER_WORD_LIMIT_", paramInt).apply();
  }
  
  public static void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramActivity = bhlq.a(paramActivity, anzj.a(2131719381), 2131719350, 2131719351, paramOnClickListener2, paramOnClickListener1);
    if ((paramActivity != null) && (!paramActivity.isShowing())) {
      paramActivity.show();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, bemy parambemy)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559008);
    paramContext.dismissMessage();
    ((RelativeLayout.LayoutParams)paramContext.getTitleTextView().getLayoutParams()).bottomMargin = bhtq.a(26.0F);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setTitle(paramString1);
    paramContext.getTitleTextView().setSingleLine(false);
    paramContext.getTitleTextView().setMaxLines(2);
    paramContext.setNegativeButton(paramString2, new bemx(paramContext, parambemy));
    if (paramContext.isShowing()) {
      paramContext.dismiss();
    }
    paramContext.show();
    paramContext = paramContext.getTitleTextView();
    paramContext.setClickable(true);
    paramContext.setFocusable(true);
    paramContext.setFocusableInTouchMode(true);
    bhga.a(paramContext, true);
  }
  
  public static void a(BaseActivity paramBaseActivity, bemy parambemy)
  {
    Resources localResources = paramBaseActivity.getResources();
    paramBaseActivity = bhlq.a(paramBaseActivity, localResources.getString(2131719398), localResources.getString(2131719388), localResources.getString(2131719392), new bemw(parambemy));
    paramBaseActivity.setCancelable(false);
    paramBaseActivity.show();
  }
  
  public static boolean a()
  {
    return b().getBoolean("KEY_WRITE_TOGETHER_IS_FIRST_USE_", true);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static boolean a(bekn parambekn)
  {
    if ((parambekn == null) || (TextUtils.isEmpty(parambekn.jdField_a_of_type_JavaLangString))) {}
    while (parambekn.jdField_a_of_type_JavaLangString.length() <= a()) {
      return false;
    }
    return true;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo == null) && (QLog.isColorLevel())) {
      QLog.d("WriteTogetherUtils", 2, "[shouldShowWriteTogetherMenuItem] sessionInfo is null. ");
    }
    return (paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Int == 1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((aoip)paramQQAppInterface.a(20)).b(paramString, false);
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
    return (paramQQAppInterface != null) && ((paramQQAppInterface.dwGroupFlagExt3 & 0x40000000) == 0L);
  }
  
  private static SharedPreferences b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "FILE_WRITE_TOGETHER_" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  public static String b(String paramString, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString, new Object[] { Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
  }
  
  public static String b(String paramString1, String paramString2, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString1, new Object[] { paramString2, Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
  }
  
  public static String c(String paramString, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString, new Object[] { Integer.valueOf(localCalendar.get(11)), Integer.valueOf(localCalendar.get(12)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemv
 * JD-Core Version:    0.7.0.1
 */