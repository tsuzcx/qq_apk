package com.tencent.av.utils;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class DataReport
{
  static boolean a = false;
  static boolean b = false;
  static boolean c = false;
  static boolean d = false;
  
  static String a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.u()) {
      return paramSessionInfo.s;
    }
    if (paramSessionInfo.p()) {
      return String.valueOf(paramSessionInfo.aN);
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUin, error, sessionInfo[");
      localStringBuilder.append(paramSessionInfo);
      localStringBuilder.append("]");
      QLog.w("DataReport", 1, localStringBuilder.toString());
    }
    return paramSessionInfo.s;
  }
  
  public static void a()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004AD0", "0X8004AD0", 0, 0, "", "", "", "");
  }
  
  public static void a(int paramInt)
  {
    String str;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            str = "";
          }
        }
      }
    }
    for (;;)
    {
      break;
      str = "0X8004E20";
      continue;
      str = "0X8004E1F";
      continue;
      str = "0X8004E21";
      continue;
      str = "0X8004E22";
    }
    ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt2 == 1) {
      paramInt2 = i;
    } else {
      paramInt2 = 0;
    }
    String str;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt1 == 2131441006)
    {
      str = "0X8004E23";
      localObject2 = "0X80043C5";
      if (paramInt2 != 0) {
        localObject1 = "0X8004E23";
      } else {
        localObject1 = "0X80043C5";
      }
      localObject3 = localObject1;
      if (paramInt2 != 0) {
        localObject2 = str;
      } else {
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      break label108;
      if (paramInt1 == 2131441008)
      {
        str = "0X8004368";
        localObject2 = "0X8004450";
        if (paramInt2 != 0) {
          localObject1 = "0X8004368";
        } else {
          localObject1 = "0X8004450";
        }
        localObject3 = localObject1;
        if (paramInt2 == 0) {
          break;
        }
        localObject2 = str;
        continue;
      }
      localObject1 = "";
      localObject2 = localObject1;
    }
    label108:
    ReportController.b(null, "CliOper", "", "", (String)localObject1, (String)localObject2, 0, 0, "", "", "", "");
  }
  
  public static void a(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      if (paramVideoController.k().j())
      {
        ReportController.b(null, "CliOper", "", "", "0X800436B", "0X800436B", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X800434C", "0X800434C", 0, 0, String.valueOf(PhoneStatusTools.g(paramVideoController.i())), "", "", "");
      return;
    }
    if (i == 2)
    {
      if (paramVideoController.k().j())
      {
        ReportController.b(null, "CliOper", "", "", "0X80043CB", "0X80043CB", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043B7", "0X80043B7", 0, 0, String.valueOf(PhoneStatusTools.g(paramVideoController.i())), "", "", "");
    }
  }
  
  public static void a(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      if (paramVideoController.k().j())
      {
        if (paramBoolean) {
          ReportController.b(null, "CliOper", "", "", "0X8004373", "0X8004373", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8004378", "0X8004378", 0, 0, "", "", "", "");
        }
      }
      else if (paramBoolean) {
        ReportController.b(null, "CliOper", "", "", "0X800434F", "0X800434F", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8004350", "0X8004350", 0, 0, "", "", "", "");
      }
    }
    else if (i == 2) {
      if (paramVideoController.k().j())
      {
        if (paramBoolean) {
          ReportController.b(null, "CliOper", "", "", "0X80043D3", "0X80043D3", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80043D4", "0X80043D4", 0, 0, "", "", "", "");
        }
      }
      else if (paramBoolean) {
        ReportController.b(null, "CliOper", "", "", "0X80043BA", "0X80043BA", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X80043BB", "0X80043BB", 0, 0, "", "", "", "");
      }
    }
    if (paramVideoController.k().p == 1008)
    {
      if (paramBoolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005DA8", "0X8005DA8", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005DAA", "0X8005DAA", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A2CD", "0X800A2CD", VideoController.f().k().g, 0, paramString, "", "", "");
  }
  
  static void a(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "0X80049A8";
    } else {
      str1 = "0X80049B8";
    }
    String str2;
    if (paramBoolean) {
      str2 = "0X80049A8";
    } else {
      str2 = "0X80049B8";
    }
    ReportController.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X800592B", "0X800592B", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X80046D1", "0X80046D1", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8004CE7", "0X8004CE7", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X800592C", "0X800592C", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X80046D2", "0X80046D2", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8004CE6", "0X8004CE6", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2;
    String str1;
    Object localObject2;
    if (paramBoolean1)
    {
      str2 = "0X80049A2";
      str1 = "0X80049B1";
      if (paramBoolean2) {
        localObject1 = "0X80049A2";
      } else {
        localObject1 = "0X80049B1";
      }
      localObject2 = localObject1;
      if (paramBoolean2)
      {
        str1 = str2;
        break label74;
      }
    }
    else
    {
      str2 = "0X800499F";
      str1 = "0X80049AE";
      if (paramBoolean2) {
        localObject1 = "0X800499F";
      } else {
        localObject1 = "0X80049AE";
      }
      localObject2 = localObject1;
      if (paramBoolean2)
      {
        str1 = str2;
        break label74;
      }
    }
    Object localObject1 = localObject2;
    label74:
    ReportController.b(null, "CliOper", "", "", (String)localObject1, str1, 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramInt == 1)
    {
      if (paramBoolean2)
      {
        ReportController.b(null, "CliOper", "", "", "0X80041B9", "0X80041B9", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80041BC", "0X80041BC", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 10)
    {
      if ((paramBoolean1) && (!paramBoolean2)) {
        ReportController.b(null, "CliOper", "", "", "0X800593F", "0X800593F", 0, 0, "", "", "", "");
      }
      if (paramBoolean2) {
        ReportController.b(null, "CliOper", "", "", "0X800593C", "0X800593C", 0, 0, "", "", "", "");
      }
    }
    else if (paramInt == 2)
    {
      if ((paramBoolean1) && (!paramBoolean2)) {
        ReportController.b(null, "CliOper", "", "", "0X80046E9", "0X80046E9", 0, 0, "", "", "", "");
      }
      if (paramBoolean2) {
        ReportController.b(null, "CliOper", "", "", "0X80046E6", "0X80046E6", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static int b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return 1;
    }
    int i = paramSessionInfo.g;
    if ((i != 1) && (i != 2)) {
      return i;
    }
    if (paramSessionInfo.f()) {
      i = 5;
    }
    return i;
  }
  
  public static void b()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004AD1", "0X8004AD1", 0, 0, "", "", "", "");
  }
  
  public static void b(int paramInt)
  {
    if (paramInt == 2)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004F5E", "0X8004F5E", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 10)
    {
      ReportController.b(null, "CliOper", "", "", "0X800594C", "0X800594C", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(null, "CliOper", "", "", "0X8004CFA", "0X8004CFA", 0, 0, "", "", "", "");
    }
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 90)
      {
        if (paramInt2 == 180) {
          break label85;
        }
        if (paramInt2 != 270) {
          return;
        }
      }
      if (paramInt1 == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004429", "0X8004429", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt1 != 2) {
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X800442C", "0X800442C", 0, 0, "", "", "", "");
      return;
    }
    label85:
    if (paramInt1 == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X800442A", "0X800442A", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt1 == 2) {
      ReportController.b(null, "CliOper", "", "", "0X800442B", "0X800442B", 0, 0, "", "", "", "");
    }
  }
  
  public static void b(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      if (paramVideoController.k().j())
      {
        ReportController.b(null, "CliOper", "", "", "0X800436C", "0X800436C", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X800434D", "0X800434D", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2)
    {
      if (paramVideoController.k().j())
      {
        ReportController.b(null, "CliOper", "", "", "0X80043CC", "0X80043CC", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043B8", "0X80043B8", 0, 0, "", "", "", "");
    }
  }
  
  public static void b(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if ((i != 1) && (i != 2))
    {
      if ((i != 3) && (i != 4))
      {
        paramVideoController = "";
        i = 0;
        break label80;
      }
      if (paramBoolean)
      {
        paramVideoController = "1";
      }
      else
      {
        paramVideoController = "1";
        break label78;
      }
    }
    else
    {
      if (!paramBoolean) {
        break label75;
      }
      paramVideoController = "2";
    }
    i = 1;
    break label80;
    label75:
    paramVideoController = "2";
    label78:
    i = 2;
    label80:
    ReportController.b(null, "CliOper", "", "", "0X800BBB5", "0X800BBB5", i, 0, paramVideoController, "1", "", "");
  }
  
  public static void b(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "0X80049A9";
    } else {
      str1 = "0X80049B9";
    }
    String str2;
    if (paramBoolean) {
      str2 = "0X80049A9";
    } else {
      str2 = "0X80049B9";
    }
    ReportController.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
  }
  
  public static void b(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 1)
    {
      if (paramBoolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004CF9", "0X8004CF9", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004CF5", "0X8004CF5", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 10)
    {
      if (paramBoolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800594B", "0X800594B", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005947", "0X8005947", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2)
    {
      if (paramBoolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004F5D", "0X8004F5D", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004F59", "0X8004F59", 0, 0, "", "", "", "");
    }
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2;
    String str1;
    Object localObject2;
    if (paramBoolean1)
    {
      str2 = "0X80049A3";
      str1 = "0X80049B2";
      if (paramBoolean2) {
        localObject1 = "0X80049A3";
      } else {
        localObject1 = "0X80049B2";
      }
      localObject2 = localObject1;
      if (paramBoolean2)
      {
        str1 = str2;
        break label82;
      }
    }
    else
    {
      str2 = "0X80049A0";
      str1 = "0X80049AF";
      if (paramBoolean2) {
        localObject1 = "0X80049A0";
      } else {
        localObject1 = "0X80049AF";
      }
      localObject2 = localObject1;
      if (paramBoolean2)
      {
        str1 = str2;
        break label82;
      }
    }
    Object localObject1 = localObject2;
    label82:
    ReportController.b(null, "CliOper", "", "", (String)localObject1, str1, 0, 0, "", "", "", "");
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramInt == 1)
    {
      if (paramBoolean2)
      {
        ReportController.b(null, "CliOper", "", "", "0x80041BA", "0x80041BA", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0x80041BD", "0x80041BD", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 10)
    {
      if ((paramBoolean1) && (!paramBoolean2)) {
        ReportController.b(null, "CliOper", "", "", "0x8005940", "0x8005940", 0, 0, "", "", "", "");
      }
      if (paramBoolean2) {
        ReportController.b(null, "CliOper", "", "", "0x800593D", "0x800593D", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void c()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004E1A", "0X8004E1A", 0, 0, "", "", "", "");
  }
  
  public static void c(int paramInt)
  {
    SessionInfo localSessionInfo = VideoController.f().k();
    int j = localSessionInfo.g;
    String str = "0X800A154";
    int i = j;
    switch (paramInt)
    {
    default: 
      return;
    case 2131893084: 
      str = "0X800A158";
      i = j;
      break;
    case 2131893079: 
      str = "0X800A15B";
      i = j;
      break;
    case 2131893078: 
      str = "0X800A157";
      i = j;
      break;
    case 2131893075: 
      str = "0X800A15C";
      i = j;
      break;
    case 2131441323: 
    case 2131893077: 
      i = b(localSessionInfo);
      str = "0X800A15A";
      break;
    case 2131441310: 
      str = "0X800A15D";
      i = j;
      break;
    case 2131441300: 
    case 2131893073: 
      i = b(localSessionInfo);
      str = "0X800A155";
      break;
    case 2131441199: 
      str = "0X800A159";
      i = j;
      break;
    case 2131440994: 
    case 2131893087: 
      str = "0X800A156";
      i = j;
    }
    ReportController.b(null, "dc00898", "", "", str, str, i, 0, "", "", "", "");
  }
  
  public static void c(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      if (paramVideoController.k().j())
      {
        if (paramVideoController.k().E)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004381", "0X8004381", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004382", "0X8004382", 0, 0, "", "", "", "");
        return;
      }
      if (paramVideoController.k().E)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004353", "0X8004353", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004354", "0X8004354", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2)
    {
      if (paramVideoController.k().j())
      {
        if (paramVideoController.k().E)
        {
          ReportController.b(null, "CliOper", "", "", "0X80043DC", "0X80043DC", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X80043DD", "0X80043DD", 0, 0, "", "", "", "");
        return;
      }
      if (paramVideoController.k().E)
      {
        ReportController.b(null, "CliOper", "", "", "0X80043BE", "0X80043BE", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043BF", "0X80043BF", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController != null)
    {
      if (paramVideoController.k().aw == 0L) {
        return;
      }
      Object localObject1 = paramVideoController.i();
      int j = paramVideoController.k().aC;
      AudioManager localAudioManager = (AudioManager)((Context)localObject1).getSystemService("audio");
      int i = localAudioManager.getStreamVolume(j);
      j = localAudioManager.getStreamMaxVolume(j);
      j = (int)(i / j * 100.0F);
      i = 0;
      if (j < 30) {
        i = 1;
      } else if ((j >= 30) && (j <= 70)) {
        i = 2;
      } else if (j > 70) {
        i = 3;
      }
      localObject1 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      String str = paramVideoController.k().aD;
      if ("DEVICE_EARPHONE".equals(str)) {
        str = "0";
      } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
        str = "1";
      } else if ("DEVICE_WIRED_HEADSET".equals(str)) {
        str = "2";
      } else if ("DEVICE_BLUETOOTH_HEADSET".equals(str)) {
        str = "3";
      } else {
        str = "4";
      }
      j = paramVideoController.k().g;
      if (j == 1)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              localObject1 = localObject2;
            } else if (paramBoolean) {
              localObject1 = "0X800437D";
            } else {
              localObject1 = "0X8004380";
            }
          }
          else if (paramBoolean) {
            localObject1 = "0X800437C";
          } else {
            localObject1 = "0X800437F";
          }
        }
        else if (paramBoolean) {
          localObject1 = "0X800437B";
        } else {
          localObject1 = "0X800437E";
        }
        localObject2 = localObject1;
        if (!paramBoolean) {
          break label504;
        }
        localObject2 = localObject1;
        if (!paramVideoController.k().B) {
          break label504;
        }
        if (localAudioManager.isBluetoothA2dpOn())
        {
          paramVideoController = (VideoController)localObject1;
          localObject1 = "3";
          break label511;
        }
        if (!localAudioManager.isWiredHeadsetOn()) {}
      }
      do
      {
        paramVideoController = (VideoController)localObject1;
        localObject1 = "2";
        break label511;
        paramVideoController = (VideoController)localObject1;
        localObject1 = "0";
        break label511;
        localObject2 = localObject3;
        if (j != 2) {
          break label504;
        }
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              if (paramBoolean) {
                localObject1 = "0X80043D8";
              } else {
                localObject1 = "0X80043DB";
              }
            }
          }
          else if (paramBoolean) {
            localObject1 = "0X80043D7";
          } else {
            localObject1 = "0X80043DA";
          }
        }
        else if (paramBoolean) {
          localObject1 = "0X80043D6";
        } else {
          localObject1 = "0X80043D9";
        }
        localObject2 = localObject1;
        if (!paramBoolean) {
          break label504;
        }
        localObject2 = localObject1;
        if (!paramVideoController.k().B) {
          break label504;
        }
        if (localAudioManager.isBluetoothA2dpOn()) {
          break;
        }
      } while (localAudioManager.isWiredHeadsetOn());
      paramVideoController = (VideoController)localObject1;
      localObject1 = "1";
      break label511;
      label504:
      paramVideoController = localObject2;
      localObject1 = str;
      label511:
      if (paramVideoController != null) {
        ReportController.b(null, "CliOper", "", "", paramVideoController, paramVideoController, 0, 0, (String)localObject1, "", "", "");
      }
    }
  }
  
  public static void c(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "0X8004ACC";
    } else {
      str = "0X8004AC9";
    }
    ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
  }
  
  public static void c(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (paramInt == 1) {
        return;
      }
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005926", "0X8005926", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80046CC", "0X80046CC", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (paramInt == 1) {
        return;
      }
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005927", "0X8005927", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80046CD", "0X80046CD", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2;
    String str1;
    Object localObject2;
    if (paramBoolean1)
    {
      str2 = "0X80049A4";
      str1 = "0X80049B3";
      if (paramBoolean2) {
        localObject1 = "0X80049A4";
      } else {
        localObject1 = "0X80049B3";
      }
      localObject2 = localObject1;
      if (paramBoolean2)
      {
        str1 = str2;
        break label82;
      }
    }
    else
    {
      str2 = "0X80049A1";
      str1 = "0X80049B0";
      if (paramBoolean2) {
        localObject1 = "0X80049A1";
      } else {
        localObject1 = "0X80049B0";
      }
      localObject2 = localObject1;
      if (paramBoolean2)
      {
        str1 = str2;
        break label82;
      }
    }
    Object localObject1 = localObject2;
    label82:
    ReportController.b(null, "CliOper", "", "", (String)localObject1, str1, 0, 0, "", "", "", "");
  }
  
  public static void d()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004E1B", "0X8004E1B", 0, 0, "", "", "", "");
  }
  
  public static void d(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().ay;
    String str;
    if (i != -1) {
      if (i != 0) {
        if (i != 3) {
          if (i != 12) {
            if (i != 25) {
              if (i != 54) {
                if (i != 42) {
                  if (i != 43) {
                    str = "8";
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      str = "5";
      continue;
      str = "6";
      continue;
      str = "10";
      continue;
      str = "7";
      continue;
      if (!paramVideoController.k().Q)
      {
        str = "2";
      }
      else
      {
        str = "4";
        continue;
        str = "3";
        continue;
        if (paramVideoController.k().W >= 0)
        {
          str = "1";
        }
        else
        {
          str = "0";
          continue;
          str = "9";
        }
      }
    }
    i = paramVideoController.k().g;
    if (i == 1)
    {
      if (paramVideoController.k().j())
      {
        ReportController.b(null, "CliOper", "", "", "0X8004389", "0X8004389", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004358", "0X8004358", 0, 0, str, "", "", "");
      return;
    }
    if (i == 2)
    {
      if (paramVideoController.k().j())
      {
        ReportController.b(null, "CliOper", "", "", "0X80043E4", "0X80043E4", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043C3", "0X80043C3", 0, 0, str, "", "", "");
    }
  }
  
  public static void d(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      if (paramBoolean)
      {
        if (!paramVideoController.k().B)
        {
          if (paramVideoController.k().E)
          {
            ReportController.b(null, "CliOper", "", "", "0X8004356", "0X8004356", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(null, "CliOper", "", "", "0X8004355", "0X8004355", 0, 0, "", "", "", "");
        }
      }
      else if (paramVideoController.k().aw > 0L)
      {
        if (paramVideoController.k().E)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004384", "0X8004384", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004383", "0X8004383", 0, 0, "", "", "", "");
      }
    }
    else if (i == 2) {
      if (paramBoolean)
      {
        if (!paramVideoController.k().B)
        {
          if (paramVideoController.k().E)
          {
            ReportController.b(null, "CliOper", "", "", "0X80043C1", "0X80043C1", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(null, "CliOper", "", "", "0X80043C0", "0X80043C0", 0, 0, "", "", "", "");
        }
      }
      else if (paramVideoController.k().aw > 0L)
      {
        if (paramVideoController.k().E)
        {
          ReportController.b(null, "CliOper", "", "", "0X80043DF", "0X80043DF", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X80043DE", "0X80043DE", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "0X8004ACD";
    } else {
      str = "0X8004ACA";
    }
    ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
  }
  
  public static void d(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (paramInt == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005949", "0X8005949", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (paramInt == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005946", "0X8005946", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ReportController.b(null, "CliOper", "", "", "0X8009F5A", "0X8009F5A", 0, 0, "", "", "", "");
    }
    if (paramBoolean2) {
      ReportController.b(null, "CliOper", "", "", "0X8009F5B", "0X8009F5B", 0, 0, "", "", "", "");
    }
  }
  
  public static void e()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004E1D", "0X8004E1D", 0, 0, "", "", "", "");
  }
  
  public static void e(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X800435E", "0X800435E", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2) {
      ReportController.b(null, "CliOper", "", "", "0X80043C9", "0X80043C9", 0, 0, "", "", "", "");
    }
  }
  
  public static void e(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "0X8004ACE";
    } else {
      str = "0X8004ACB";
    }
    ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
  }
  
  public static void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A014", "0X800A014", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A015", "0X800A015", 0, 0, "", "", "", "");
      return;
    }
    if (paramBoolean2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A016", "0X800A016", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A017", "0X800A017", 0, 0, "", "", "", "");
  }
  
  public static void f()
  {
    SessionInfo localSessionInfo = VideoController.f().k();
    int i = localSessionInfo.g;
    ReportController.b(null, "dc00898", "", a(localSessionInfo), "0X800A2CC", "0X800A2CC", i, 0, "", "", "", "");
  }
  
  public static void f(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004394", "0X8004394", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2) {
      ReportController.b(null, "CliOper", "", "", "0X80043F2", "0X80043F2", 0, 0, "", "", "", "");
    }
  }
  
  public static void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      ReportController.b(null, "CliOper", "", "", "0X8005615", "0X8005615", 0, 0, "", "", "", "");
    }
  }
  
  public static void g(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004370", "0X8004370", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2) {
      ReportController.b(null, "CliOper", "", "", "0X80043D0", "0X80043D0", 0, 0, "", "", "", "");
    }
  }
  
  public static void h(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004388", "0X8004388", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2) {
      ReportController.b(null, "CliOper", "", "", "0X80043E3", "0X80043E3", 0, 0, "", "", "", "");
    }
  }
  
  public static void i(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      if (paramVideoController.k().aG)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004351", "0X8004351", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004352", "0X8004352", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2)
    {
      if (paramVideoController.k().aG)
      {
        ReportController.b(null, "CliOper", "", "", "0X80043BC", "0X80043BC", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043BD", "0X80043BD", 0, 0, "", "", "", "");
    }
  }
  
  public static void j(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    if ((paramVideoController.k().j()) && (paramVideoController.k().g == 1) && (!paramVideoController.k().aG)) {
      ReportController.b(null, "CliOper", "", "", "0X8004379", "0X8004379", 0, 0, "", "", "", "");
    }
  }
  
  public static void k(VideoController paramVideoController)
  {
    if (a) {
      return;
    }
    a = true;
    if (paramVideoController == null) {
      return;
    }
    if (paramVideoController.k().j())
    {
      int i = paramVideoController.k().g;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X800437A", "0X800437A", 0, 0, "", "", "", "");
        return;
      }
      if (i == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80043D5", "0X80043D5", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void l(VideoController paramVideoController)
  {
    if (paramVideoController == null) {
      return;
    }
    String str;
    if (!paramVideoController.k().R)
    {
      i = paramVideoController.k().ay;
      if (i != -1) {
        if (i != 0)
        {
          if (i != 3)
          {
            if (i != 12)
            {
              if (i != 25)
              {
                if (i != 54)
                {
                  if (i != 42)
                  {
                    if (i != 43)
                    {
                      str = "8";
                      break label158;
                    }
                    str = "5";
                    break label158;
                  }
                  str = "6";
                  break label158;
                }
              }
              else
              {
                str = "7";
                break label158;
              }
            }
            else
            {
              if (!paramVideoController.k().Q)
              {
                str = "2";
                break label158;
              }
              str = "4";
              break label158;
            }
          }
          else
          {
            str = "3";
            break label158;
          }
        }
        else
        {
          if (paramVideoController.k().W >= 0)
          {
            str = "1";
            break label158;
          }
          str = "0";
          break label158;
        }
      }
      str = "9";
    }
    else
    {
      str = "";
    }
    label158:
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      if (paramVideoController.k().j())
      {
        ReportController.b(null, "CliOper", "", "", "0X800438A", "0X800438A", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X800435B", "0X800435B", 0, 0, str, "", "", "");
      return;
    }
    if (i == 2)
    {
      if (paramVideoController.k().j())
      {
        ReportController.b(null, "CliOper", "", "", "0X80043E5", "0X80043E5", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043C6", "0X80043C6", 0, 0, str, "", "", "");
    }
  }
  
  public static void m(VideoController paramVideoController)
  {
    if (b) {
      return;
    }
    b = true;
    if (paramVideoController == null) {
      return;
    }
    if ((paramVideoController.k().H) || (paramVideoController.k().I)) {
      ReportController.b(null, "CliOper", "", "", "0X800438F", "0X800438F", 0, 0, "", "", "", "");
    }
  }
  
  public static void n(VideoController paramVideoController)
  {
    if (c) {
      return;
    }
    c = true;
    if (paramVideoController == null) {
      return;
    }
    if ((!paramVideoController.k().H) && (!paramVideoController.k().I)) {
      ReportController.b(null, "CliOper", "", "", "0X80043EB", "0X80043EB", 0, 0, "", "", "", "");
    }
  }
  
  public static void o(VideoController paramVideoController)
  {
    if (d) {
      return;
    }
    d = true;
    if (paramVideoController == null) {
      return;
    }
    int i = paramVideoController.k().g;
    if (i == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004395", "0X8004395", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2) {
      ReportController.b(null, "CliOper", "", "", "0X80043F3", "0X80043F3", 0, 0, "", "", "", "");
    }
  }
  
  public static void p(VideoController paramVideoController)
  {
    Object localObject;
    if (paramVideoController.k().g == 1)
    {
      localObject = "0X8004361";
      paramVideoController = "0X8004360";
    }
    else
    {
      if (paramVideoController.k().g == 2) {
        paramVideoController = "0X800444C";
      } else {
        paramVideoController = "";
      }
      localObject = paramVideoController;
    }
    ReportController.b(null, "CliOper", "", "", paramVideoController, (String)localObject, 0, 0, "", "", "", "");
  }
  
  public static void q(VideoController paramVideoController)
  {
    Object localObject;
    if (paramVideoController.k().g == 1)
    {
      localObject = "0X8004362";
      paramVideoController = "0X8004361";
    }
    else
    {
      if (paramVideoController.k().g == 2) {
        paramVideoController = "0X800444D";
      } else {
        paramVideoController = "";
      }
      localObject = paramVideoController;
    }
    ReportController.b(null, "CliOper", "", "", paramVideoController, (String)localObject, 0, 0, "", "", "", "");
  }
  
  public static void r(VideoController paramVideoController)
  {
    if (paramVideoController.k().g == 1) {
      paramVideoController = "0X8004369";
    } else if (paramVideoController.k().g == 2) {
      paramVideoController = "0X8004451";
    } else {
      paramVideoController = "";
    }
    ReportController.b(null, "CliOper", "", "", paramVideoController, paramVideoController, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.DataReport
 * JD-Core Version:    0.7.0.1
 */