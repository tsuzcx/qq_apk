package com.tencent.av.utils;

import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class AVEnterPopActionSheetUtil
{
  public static String a = "AVEnterPopActionSheetUtil";
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (paramSessionInfo != null))
    {
      if (VideoActionSheet.a()) {
        return;
      }
      VideoActionSheet localVideoActionSheet = VideoActionSheet.a(paramContext);
      int[] arrayOfInt = new int[5];
      localVideoActionSheet.setMainTitle(2131689542);
      arrayOfInt[0] = 1;
      localVideoActionSheet.addButton(2131719732);
      arrayOfInt[1] = 2;
      localVideoActionSheet.addButton(2131719746);
      localVideoActionSheet.addCancelButton(2131690728);
      localVideoActionSheet.setOnDismissListener(new AVEnterPopActionSheetUtil.1());
      localVideoActionSheet.setOnButtonClickListener(new AVEnterPopActionSheetUtil.2(localVideoActionSheet, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramContext, paramInt));
      localVideoActionSheet.show();
      if (paramInt == 3)
      {
        if (paramSessionInfo.jdField_a_of_type_Int == 1)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 2, "", "", "", "");
          return;
        }
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 1, "", "", "", "");
      }
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "app == null || context == null || sessionInfo == null");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramContext != null))
    {
      if (paramSessionInfo == null) {
        return;
      }
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterGroupVideo,, isAudio[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], msgSelfUin[");
      localStringBuilder.append(paramQQAppInterface.getCurrentUin());
      localStringBuilder.append("], uinType[");
      localStringBuilder.append(paramSessionInfo.jdField_a_of_type_Int);
      localStringBuilder.append("], groupId[");
      localStringBuilder.append(paramSessionInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("], curFriendNick[");
      localStringBuilder.append(paramSessionInfo.d);
      localStringBuilder.append("], troopUin[");
      localStringBuilder.append(paramSessionInfo.b);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      VideoItemBuilder.a(paramQQAppInterface, paramContext, paramSessionInfo, 10, paramBoolean ^ true, paramQQAppInterface.getCurrentUin(), "");
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    if ((paramQQAppInterface != null) && (paramContext != null))
    {
      if (paramSessionInfo == null) {
        return;
      }
      String str = jdField_a_of_type_JavaLangString;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterC2CAudioVideo,, isAudio[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], fromType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], msgSelfUin[");
      ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentUin());
      ((StringBuilder)localObject).append("], uinType[");
      ((StringBuilder)localObject).append(paramSessionInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("], groupId[");
      ((StringBuilder)localObject).append(paramSessionInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("], curFriendNick[");
      ((StringBuilder)localObject).append(paramSessionInfo.d);
      ((StringBuilder)localObject).append("], troopUin[");
      ((StringBuilder)localObject).append(paramSessionInfo.b);
      ((StringBuilder)localObject).append("]");
      QLog.w(str, 1, ((StringBuilder)localObject).toString());
      localObject = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (localObject == null) {
        return;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1006)
      {
        str = ((IPhoneContactService)localObject).getUinByPhoneNum(paramSessionInfo.jdField_a_of_type_JavaLangString);
        localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;
      }
      else
      {
        str = paramSessionInfo.jdField_a_of_type_JavaLangString;
        localObject = ((IPhoneContactService)localObject).getPhoneNumByUin(str);
      }
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, "from_internal", paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AVEnterPopActionSheetUtil
 * JD-Core Version:    0.7.0.1
 */