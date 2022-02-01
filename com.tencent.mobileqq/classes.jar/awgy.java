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
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.2;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class awgy
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new OldMutualMarkLogicHelper.3(paramQQAppInterface), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, afiw paramafiw)
  {
    ThreadManager.post(new OldMutualMarkLogicHelper.1(paramQQAppInterface, paramSessionInfo, paramafiw), 5, null, false);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForUniteGrayTip paramMessageForUniteGrayTip, MqqHandler paramMqqHandler, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if (!TextUtils.isEmpty(paramMessageForUniteGrayTip.caidanAnimUrl))
    {
      paramSessionInfo = afdp.a();
      paramMessageForUniteGrayTip = new awfv(BaseApplicationImpl.getContext(), paramMessageForUniteGrayTip.caidanAnimUrl);
      if (paramMessageForUniteGrayTip.a()) {
        paramSessionInfo.a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, paramMessageForUniteGrayTip, 4);
      }
    }
    else
    {
      return;
    }
    paramMqqHandler.postDelayed(new OldMutualMarkLogicHelper.2(paramMessageForUniteGrayTip, paramSessionInfo, paramQQAppInterface, paramAIOAnimationConatiner), 800L);
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
        a(paramQQAppInterface, paramSessionInfo, paramMessageForUniteGrayTip, paramMqqHandler, paramAIOAnimationConatiner);
        return;
      }
      paramMqqHandler = afdp.a();
      if (paramInt == 3) {
        paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850114);
      }
      while (paramMessageForUniteGrayTip != null)
      {
        paramMqqHandler.a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, paramMessageForUniteGrayTip, 4);
        return;
        if (paramInt == 26)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850115);
        }
        else if (paramInt == 27)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850116);
        }
        else if (paramInt == 4)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850070);
        }
        else if (paramInt == 28)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850071);
        }
        else if (paramInt == 29)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850072);
        }
        else if (paramInt == 1)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850118);
        }
        else if (paramInt == 2)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850074);
        }
        else if (paramInt == 5)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850117);
        }
        else if (paramInt == 30)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850119);
        }
        else if (paramInt == 31)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850120);
        }
        else if (paramInt == 7)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850112);
        }
        else if (paramInt == 8)
        {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850113);
        }
        else
        {
          paramMessageForUniteGrayTip = localObject;
          if (paramInt != 11) {
            if (paramInt == 12)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850085);
            }
            else if (paramInt == 13)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850086);
            }
            else if (paramInt == 14)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850093);
            }
            else if (paramInt == 15)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850094);
            }
            else if (paramInt == 16)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850095);
            }
            else if (paramInt == 17)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850087);
            }
            else if (paramInt == 18)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850088);
            }
            else if (paramInt == 19)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850089);
            }
            else if (paramInt == 20)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850090);
            }
            else if (paramInt == 21)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850091);
            }
            else if (paramInt == 22)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850092);
            }
            else if (paramInt == 23)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850096);
            }
            else if (paramInt == 24)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850097);
            }
            else if (paramInt == 25)
            {
              paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130850098);
            }
            else
            {
              paramMessageForUniteGrayTip = localObject;
              if (awfy.a(paramInt))
              {
                paramMessageForUniteGrayTip = localObject;
                if (paramSessionInfo != null)
                {
                  paramInt = awfn.a(paramQQAppInterface, paramSessionInfo.curFriendUin, String.valueOf(paramInt));
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
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<ChatMessage> paramList, afiw paramafiw)
  {
    if ((anwe.a().a()) && (a(paramQQAppInterface, paramSessionInfo, paramList)))
    {
      paramafiw.e = true;
      anwe.a().a();
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
    if ((paramInt == 6) || (paramInt == 32) || (paramInt == 33)) {}
    while (paramInt == awfy.a(12L, 2L)) {
      return true;
    }
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramSessionInfo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    long l1 = bbko.a();
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
          break label413;
        }
        long l2 = Math.abs(localChatMessage.time - l1);
        if (l2 <= 86400L) {
          break label202;
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
        label202:
        if (!a(localChatMessage))
        {
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          break label413;
        }
        if ((TextUtils.equals(localChatMessage.senderuin, paramSessionInfo.curFriendUin)) || (TextUtils.equals(localChatMessage.senderuin, paramQQAppInterface.getCurrentAccountUin())))
        {
          localTime2.set(localChatMessage.time * 1000L);
          if ((localTime1.year == localTime2.year) && (localTime1.yearDay == localTime2.yearDay))
          {
            bool3 = TextUtils.equals(localChatMessage.senderuin, paramSessionInfo.curFriendUin);
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
                break label413;
              }
              bool1 = bool3;
              bool2 = bool4;
              if (!bool3) {
                break label413;
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
      label413:
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
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, afiw paramafiw)
  {
    if (paramafiw.e) {}
    for (;;)
    {
      return;
      if (((amsw)paramQQAppInterface.getManager(51)).a(paramSessionInfo.curFriendUin, false) != null)
      {
        awgq localawgq = awfp.a(paramQQAppInterface, paramSessionInfo.curFriendUin, 7L, false);
        if ((localawgq != null) && (localawgq.b > 0L) && (localawgq.a())) {}
        for (int i = 1; i != 0; i = 0)
        {
          a(paramQQAppInterface, paramSessionInfo, paramQQAppInterface.getMessageFacade().getAIOList(paramSessionInfo.curFriendUin, paramSessionInfo.curType), paramafiw);
          return;
        }
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    if (paramInt == 13) {}
    while (paramInt == awfy.a(4L, 3L)) {
      return true;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgy
 * JD-Core Version:    0.7.0.1
 */