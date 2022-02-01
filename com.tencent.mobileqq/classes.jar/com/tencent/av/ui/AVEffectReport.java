package com.tencent.av.ui;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.statistics.ReportController;

public class AVEffectReport
{
  static void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X8006F88", "0X8006F88", 0, 0, "", "", "", "");
  }
  
  static void a(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3)
  {
    int i = 2;
    if ((paramInt1 != 1) && (paramInt1 != 2)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if (paramInt1 != 0) {
      i = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BB5B", "0X800BB5B", paramInt2, 0, String.valueOf(paramInt3), String.valueOf(i), String.valueOf(paramLong), paramString);
  }
  
  public static void a(int paramInt, long paramLong)
  {
    String str;
    if (paramInt != 1) {
      if (paramInt != 2) {
        str = "0X8006F87";
      }
    }
    for (;;)
    {
      break;
      str = "0X8007F25";
      continue;
      str = "0X8007F2B";
    }
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", String.valueOf(paramLong), "");
    }
  }
  
  static void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = DoodleLogic.a();
    if (!DoodleUtils.a()) {
      localObject = "0X80077BF";
    } else if (!((DoodleLogic)localObject).a()) {
      localObject = "0X80077C0";
    } else if (!((DoodleLogic)localObject).b) {
      localObject = "0X80077BE";
    } else {
      localObject = "0X80077BD";
    }
    a((String)localObject, paramBoolean, paramLong);
  }
  
  static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramBoolean)
        {
          paramContext = "0X8006F8D";
          break label77;
        }
        paramContext = "0X8006F8E";
        break label77;
      }
      if (paramInt2 == 4)
      {
        if (EffectFilterTools.a(paramContext))
        {
          paramContext = "0X8007F28";
          break label77;
        }
        paramContext = "0X8007F29";
        break label77;
      }
    }
    else if (paramInt2 == 4)
    {
      if (EffectFilterTools.a(paramContext))
      {
        paramContext = "0X8007F2E";
        break label77;
      }
      paramContext = "0X8007F2F";
      break label77;
    }
    paramContext = null;
    label77:
    if (!TextUtils.isEmpty(paramContext)) {
      a(paramContext, paramBoolean, paramLong);
    }
  }
  
  static void a(VideoAppInterface paramVideoAppInterface, long paramLong, boolean paramBoolean)
  {
    if (paramVideoAppInterface != null)
    {
      paramVideoAppInterface = (EffectSupportManager)paramVideoAppInterface.a(5);
      boolean bool = paramVideoAppInterface.a(3, "normal");
      if (paramVideoAppInterface.a(3, "interact")) {
        paramVideoAppInterface = "0X8008023";
      } else if (bool) {
        paramVideoAppInterface = "0X8008024";
      } else {
        paramVideoAppInterface = "0X8008132";
      }
      a(paramVideoAppInterface, paramBoolean, paramLong);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = -1;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, i, "", "", String.valueOf(paramLong), "");
  }
  
  static void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X8006F8F", "0X8006F8F", 0, 0, "", "", "", "");
  }
  
  static void b(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3)
  {
    int i = 2;
    if ((paramInt1 != 1) && (paramInt1 != 2)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if (paramInt1 != 0) {
      i = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X8008395", "0X8008395", paramInt2, 0, String.valueOf(paramInt3), String.valueOf(i), String.valueOf(paramLong), paramString);
  }
  
  static void b(Context paramContext, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (EffectFilterTools.a(paramContext))
      {
        i = j;
        if (GestureMgr.a().c()) {
          i = 1;
        }
      }
    }
    paramContext = "";
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        String str2;
        if (paramBoolean) {
          str2 = "0X8006F89";
        } else {
          str2 = "0X8006F8A";
        }
        str1 = str2;
        if (i == 0) {
          break label131;
        }
        paramContext = "0X8008394";
        str1 = str2;
        break label131;
      }
      if (paramInt2 == 4)
      {
        if (i != 0) {
          paramContext = "0X8008397";
        }
        str1 = "0X8007F26";
        break label131;
      }
    }
    else if (paramInt2 == 4)
    {
      if (i != 0) {
        paramContext = "0X80083A9";
      }
      str1 = "0X8007F2C";
      break label131;
    }
    String str1 = "";
    label131:
    a(str1, paramBoolean, paramLong);
    a(paramContext, paramBoolean, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVEffectReport
 * JD-Core Version:    0.7.0.1
 */