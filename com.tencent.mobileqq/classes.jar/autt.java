import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class autt
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new OldMutualMarkLogicHelper.2(paramQQAppInterface), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, agps paramagps)
  {
    ThreadManager.post(new OldMutualMarkLogicHelper.1(paramQQAppInterface, paramSessionInfo, paramagps), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForUniteGrayTip paramMessageForUniteGrayTip, MqqHandler paramMqqHandler, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt)
  {
    Object localObject = null;
    if (a(paramMessageForUniteGrayTip.subType))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "new message graytips big ship");
      }
      paramMqqHandler.sendEmptyMessage(70);
    }
    for (;;)
    {
      return;
      if (b(paramMessageForUniteGrayTip.subType))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendReactive", 2, "new message graytips friendship");
        }
        paramMqqHandler.sendEmptyMessage(88);
        return;
      }
      if (c(paramMessageForUniteGrayTip.subType))
      {
        paramMqqHandler.obtainMessage(201, new String[] { paramMessageForUniteGrayTip.caidanAnimUrl, paramMessageForUniteGrayTip.caidanAnimUrlMd5 }).sendToTarget();
        return;
      }
      if (d(paramMessageForUniteGrayTip.subType))
      {
        if (!TextUtils.isEmpty(paramMessageForUniteGrayTip.caidanAnimUrl)) {
          aeus.a().a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, new ausp(BaseApplicationImpl.getContext(), paramMessageForUniteGrayTip.caidanAnimUrl), 4);
        }
      }
      else
      {
        paramMqqHandler = aeus.a();
        if (paramInt == 3) {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849630);
        }
        while (paramMessageForUniteGrayTip != null)
        {
          paramMqqHandler.a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, paramMessageForUniteGrayTip, 4);
          return;
          if (paramInt == 26)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849631);
          }
          else if (paramInt == 27)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849632);
          }
          else if (paramInt == 4)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849589);
          }
          else if (paramInt == 28)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849590);
          }
          else if (paramInt == 29)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849591);
          }
          else if (paramInt == 1)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849634);
          }
          else if (paramInt == 2)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849593);
          }
          else if (paramInt == 5)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849633);
          }
          else if (paramInt == 30)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849635);
          }
          else if (paramInt == 31)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849636);
          }
          else if (paramInt == 7)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849628);
          }
          else if (paramInt == 8)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849629);
          }
          else
          {
            paramMessageForUniteGrayTip = localObject;
            if (paramInt != 11) {
              if (paramInt == 12)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849604);
              }
              else if (paramInt == 13)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849605);
              }
              else if (paramInt == 14)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849612);
              }
              else if (paramInt == 15)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849613);
              }
              else if (paramInt == 16)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849614);
              }
              else if (paramInt == 17)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849606);
              }
              else if (paramInt == 18)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849607);
              }
              else if (paramInt == 19)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849608);
              }
              else if (paramInt == 20)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849609);
              }
              else if (paramInt == 21)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849610);
              }
              else if (paramInt == 22)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849611);
              }
              else if (paramInt == 23)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849615);
              }
              else if (paramInt == 24)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849616);
              }
              else if (paramInt == 25)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130849617);
              }
              else
              {
                paramMessageForUniteGrayTip = localObject;
                if (auss.a(paramInt))
                {
                  paramMessageForUniteGrayTip = localObject;
                  if (paramSessionInfo != null)
                  {
                    paramInt = aush.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(paramInt));
                    paramMessageForUniteGrayTip = localObject;
                    if (paramInt != 0) {
                      paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<ChatMessage> paramList, agps paramagps)
  {
    if ((ampe.a().a()) && (a(paramQQAppInterface, paramSessionInfo, paramList)))
    {
      paramagps.W = true;
      ampe.a().a();
      if (QLog.isColorLevel()) {
        QLog.i("OldMutualMarkLogicHelper", 2, "checkLightingQzoneLover enter!!!!!!!!");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("OldMutualMarkLogicHelper", 2, "checkLightingQzoneLover not enter!!!!!!!!");
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 6) {}
    while (paramInt == auss.a(12L, 2L)) {
      return true;
    }
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramSessionInfo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    long l1 = ayzl.a();
    Time localTime1 = new Time();
    localTime1.set(1000L * l1);
    Time localTime2 = new Time();
    boolean bool1 = false;
    boolean bool2 = false;
    int i = paramList.size() - 1;
    for (;;)
    {
      boolean bool3 = bool2;
      boolean bool4 = bool1;
      if (i >= 0) {}
      try
      {
        localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage == null)
        {
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          break label411;
        }
        long l2 = Math.abs(localChatMessage.time - l1);
        if (l2 <= 86400L) {
          break label200;
        }
        bool4 = bool1;
        bool3 = bool2;
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          ChatMessage localChatMessage;
          bool4 = false;
          bool3 = false;
          QLog.e("OldMutualMarkLogicHelper", 1, "hasInteractiveToday error: " + paramQQAppInterface.getMessage());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("OldMutualMarkLogicHelper", 2, "hasInteractiveToday selfSend:" + bool4 + " friendSend: " + bool3);
      }
      if ((bool4) && (bool3))
      {
        return true;
        label200:
        if (!a(localChatMessage))
        {
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          break label411;
        }
        if ((TextUtils.equals(localChatMessage.senderuin, paramSessionInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.equals(localChatMessage.senderuin, paramQQAppInterface.getCurrentAccountUin())))
        {
          localTime2.set(localChatMessage.time * 1000L);
          if ((localTime1.year == localTime2.year) && (localTime1.yearDay == localTime2.yearDay))
          {
            bool3 = TextUtils.equals(localChatMessage.senderuin, paramSessionInfo.jdField_a_of_type_JavaLangString);
            if (bool3)
            {
              bool3 = true;
              bool4 = bool1;
            }
            for (;;)
            {
              bool1 = bool3;
              bool2 = bool4;
              if (!bool4) {
                break label411;
              }
              bool1 = bool3;
              bool2 = bool4;
              if (!bool3) {
                break label411;
              }
              break;
              bool4 = true;
              bool3 = bool2;
            }
          }
        }
      }
      else
      {
        return false;
      }
      bool3 = bool2;
      bool2 = bool1;
      bool1 = bool3;
      label411:
      i -= 1;
      bool3 = bool2;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  private static boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = new int[20];
      int[] tmp12_11 = arrayOfInt;
      tmp12_11[0] = -1000;
      int[] tmp18_12 = tmp12_11;
      tmp18_12[1] = -1001;
      int[] tmp24_18 = tmp18_12;
      tmp24_18[2] = -2009;
      int[] tmp30_24 = tmp24_18;
      tmp30_24[3] = -2045;
      int[] tmp36_30 = tmp30_24;
      tmp36_30[4] = -2009;
      int[] tmp42_36 = tmp36_30;
      tmp42_36[5] = -2001;
      int[] tmp48_42 = tmp42_36;
      tmp48_42[6] = -2005;
      int[] tmp55_48 = tmp48_42;
      tmp55_48[7] = -2010;
      int[] tmp62_55 = tmp55_48;
      tmp62_55[8] = -2000;
      int[] tmp69_62 = tmp62_55;
      tmp69_62[9] = -2002;
      int[] tmp76_69 = tmp69_62;
      tmp76_69[10] = -2008;
      int[] tmp83_76 = tmp76_69;
      tmp83_76[11] = -2022;
      int[] tmp90_83 = tmp83_76;
      tmp90_83[12] = -30002;
      int[] tmp97_90 = tmp90_83;
      tmp97_90[13] = -2011;
      int[] tmp104_97 = tmp97_90;
      tmp104_97[14] = -2020;
      int[] tmp111_104 = tmp104_97;
      tmp111_104[15] = -2025;
      int[] tmp118_111 = tmp111_104;
      tmp118_111[16] = -2065;
      int[] tmp125_118 = tmp118_111;
      tmp125_118[17] = -2066;
      int[] tmp132_125 = tmp125_118;
      tmp132_125[18] = -3000;
      int[] tmp139_132 = tmp132_125;
      tmp139_132[19] = -1035;
      tmp139_132;
      int i = 0;
      while (i < arrayOfInt.length)
      {
        if (paramChatMessage.msgtype == arrayOfInt[i]) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, agps paramagps)
  {
    if (paramagps.W) {}
    for (;;)
    {
      return;
      alto localalto = (alto)paramQQAppInterface.getManager(51);
      ExtensionInfo localExtensionInfo = localalto.a(paramSessionInfo.jdField_a_of_type_JavaLangString, false);
      if (localExtensionInfo != null)
      {
        int i = autp.a(1, paramSessionInfo.jdField_a_of_type_JavaLangString, localExtensionInfo, localalto.a(false));
        long l = localExtensionInfo.loverLastChatTime;
        boolean bool = autp.a(autp.b(), l * 1000L, localExtensionInfo.loverTransFlag);
        if ((i != 0) && (bool)) {}
        for (i = 1; i != 0; i = 0)
        {
          a(paramQQAppInterface, paramSessionInfo, paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int), paramagps);
          return;
        }
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    if (paramInt == 13) {}
    while (paramInt == auss.a(4L, 3L)) {
      return true;
    }
    return false;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString, Boolean paramBoolean, int paramInt1, int paramInt2, boolean paramBoolean1, ExtensionInfo paramExtensionInfo, int paramInt3)
  {
    boolean bool = true;
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    SharedPreferences.Editor localEditor = paramQQAppInterface.edit();
    int i = paramQQAppInterface.getInt(paramString, 0);
    if ((i >= paramInt3) || ((paramInt1 & paramInt2) > 0) || (!paramBoolean1)) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("reactivetip", 2, "checkReactiveGraytip remindTimes=" + i + "isRemind=" + paramInt1 + "needRemind=" + paramBoolean1 + "isNeed=" + bool);
      }
      return bool;
      localEditor.putInt(paramString, i + 1);
      localEditor.commit();
      if (paramBoolean.booleanValue()) {
        paramExtensionInfo.isGrayTipMultiRemind |= paramInt2;
      } else {
        paramExtensionInfo.isGrayTipRemind |= paramInt2;
      }
    }
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 999;
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == 998;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     autt
 * JD-Core Version:    0.7.0.1
 */