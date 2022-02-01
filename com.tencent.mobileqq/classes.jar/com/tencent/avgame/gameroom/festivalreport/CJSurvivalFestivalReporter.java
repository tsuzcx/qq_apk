package com.tencent.avgame.gameroom.festivalreport;

import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CJSurvivalFestivalReporter
{
  private static int jdField_a_of_type_Int = 0;
  private static String jdField_a_of_type_JavaLangString = "0";
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static int a(EngineData paramEngineData)
  {
    switch (paramEngineData.o())
    {
    case 6: 
    case 7: 
    default: 
      return 0;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "other";
    case 1: 
      return "clk";
    case 0: 
      return "exp";
    case 3: 
      return "quit";
    case 4: 
      return "share";
    case 2: 
      return "start";
    }
    return "enter";
  }
  
  private static String a(EngineData paramEngineData)
  {
    if (paramEngineData.b == 0L)
    {
      paramEngineData = paramEngineData.a().getPlayers().iterator();
      Player localPlayer;
      do
      {
        if (!paramEngineData.hasNext()) {
          break;
        }
        localPlayer = (Player)paramEngineData.next();
      } while (localPlayer.uin.equals(GameEngine.a().a().getCurrentAccountUin()));
      return localPlayer.uin;
    }
    return String.valueOf(paramEngineData.b);
    return "";
  }
  
  private static Map<String, String> a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4, String paramString, boolean paramBoolean3)
  {
    int j = 1;
    paramString = GameEngine.a().a();
    HashMap localHashMap = new HashMap();
    int i;
    if ((paramInt1 != 1) && (paramInt1 != 0)) {
      if (paramString != null)
      {
        if (paramInt1 == 3) {
          break label372;
        }
        if (paramInt1 != 2)
        {
          localHashMap.put("touin", a(paramString));
          if ((paramInt3 != 2) && (paramInt3 != 3))
          {
            localHashMap.put("ext1", String.valueOf(paramString.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int));
            localHashMap.put("ext2", String.valueOf(paramString.p()));
            if (paramInt1 != 8) {
              break label312;
            }
            if (paramBoolean1) {
              localHashMap.put("ext3", String.valueOf(paramString.l()));
            }
          }
        }
        if (paramInt1 != 2)
        {
          if (!paramString.h()) {
            break label393;
          }
          i = 1;
          label155:
          localHashMap.put("op_via", String.valueOf(i));
          localHashMap.put("room_id", String.valueOf(paramString.j()));
        }
        localHashMap.put("bussis_id", String.valueOf(paramString.r()));
      }
      else
      {
        if ((paramInt1 != 7) || (paramInt2 != 3)) {
          break label431;
        }
        if (paramInt3 > 0) {
          localHashMap.put("refer", String.valueOf(paramInt3));
        }
        label235:
        if (paramInt1 != 1) {
          break label517;
        }
        localHashMap.put("active_id", String.valueOf(paramInt4));
      }
    }
    for (;;)
    {
      localHashMap.put("op_cnt", "1");
      if ((paramInt1 == 6) && (paramBoolean1) && (paramString.h()))
      {
        paramInt1 = j;
        if (paramBoolean3) {
          paramInt1 = 0;
        }
        localHashMap.put("ext5", String.valueOf(paramInt1));
      }
      return localHashMap;
      label312:
      if (paramString.a().jdField_a_of_type_ComTencentAvgameGamelogicITopic != null) {
        localHashMap.put("ext3", String.valueOf(paramString.a().jdField_a_of_type_ComTencentAvgameGamelogicITopic.a()));
      }
      localHashMap.put("ext4", String.valueOf(paramString.e() + 1));
      break;
      label372:
      localHashMap.put("ext3", String.valueOf(paramString.l()));
      break;
      label393:
      i = 2;
      break label155;
      if (paramBoolean2) {}
      for (i = 1;; i = 2)
      {
        localHashMap.put("op_via", String.valueOf(i));
        break;
      }
      label431:
      if (paramInt1 != 2) {
        break label235;
      }
      localHashMap.put("refer", String.valueOf(jdField_a_of_type_Int));
      QLog.d("CJSurvivalFestivalReporter", 1, "call refer=" + jdField_a_of_type_Int);
      if (jdField_a_of_type_Int == 3)
      {
        localHashMap.put("touin", jdField_a_of_type_JavaLangString);
        break label235;
      }
      localHashMap.put("touin", "0");
      break label235;
      label517:
      if (paramString != null) {
        localHashMap.put("active_id", String.valueOf(paramString.k()));
      }
    }
  }
  
  private static Map<String, String> a(@CJSurvivalFestivalReporter.EVENT_MEDIA_PLAYER_TYPE int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    try
    {
      EngineData localEngineData = GameEngine.a().a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("refer", "16");
      localHashMap.put("ext1", paramString1);
      if (paramInt1 == 3)
      {
        localHashMap.put("ext2", String.valueOf(paramInt2));
        localHashMap.put("ext3", paramString2);
      }
      localHashMap.put("ext4", String.valueOf(paramInt1));
      localHashMap.put("active_id", String.valueOf(localEngineData.k()));
      localHashMap.put("room_id", String.valueOf(localEngineData.j()));
      localHashMap.put("bussis_id", String.valueOf(localEngineData.a()));
      localHashMap.put("ext5", String.valueOf(localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int));
      localHashMap.put("ext6", String.valueOf(localEngineData.b()));
      return localHashMap;
    }
    finally {}
  }
  
  private static Map<String, String> a(@CJSurvivalFestivalReporter.EVENT_EXCEPTION_REFER_TYPE int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        EngineData localEngineData = GameEngine.a().a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("refer", String.valueOf(paramInt));
        if (!TextUtils.isEmpty(paramString1)) {
          localHashMap.put("ext1", paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localHashMap.put("ext2", paramString2);
        }
        if (localEngineData == null) {
          return localHashMap;
        }
        if (paramBoolean)
        {
          if (localEngineData.h())
          {
            paramInt = 1;
            localHashMap.put("op_via", String.valueOf(paramInt));
          }
        }
        else
        {
          localHashMap.put("active_id", String.valueOf(localEngineData.k()));
          localHashMap.put("room_id", String.valueOf(localEngineData.j()));
          continue;
        }
        paramInt = 2;
      }
      finally {}
    }
  }
  
  public static void a()
  {
    int i = 2;
    int j = 0;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CJSurvivalFestivalReporter", 2, "reportFinalResult");
        }
        EngineData localEngineData = GameEngine.a().a();
        if (localEngineData != null)
        {
          boolean bool = localEngineData.g();
          if (!bool) {}
        }
        else
        {
          if (localEngineData != null) {
            continue;
          }
        }
        return;
        SurvivalPkResultInfo localSurvivalPkResultInfo = localEngineData.a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("touin", a(localEngineData));
        if (localEngineData.h()) {
          i = 1;
        }
        localHashMap.put("op_via", String.valueOf(i));
        localHashMap.put("active_id", String.valueOf(localEngineData.k()));
        localHashMap.put("bussis_id", String.valueOf(localEngineData.r()));
        localHashMap.put("room_id", String.valueOf(localEngineData.j()));
        localHashMap.put("ext1", String.valueOf(localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int));
        localHashMap.put("ext2", String.valueOf(localEngineData.p()));
        if (localSurvivalPkResultInfo.gameSur)
        {
          i = 1;
          localHashMap.put("ext3", String.valueOf(i));
          localHashMap.put("ext4", String.valueOf(localSurvivalPkResultInfo.total));
          if (!localSurvivalPkResultInfo.gameSur) {
            break label279;
          }
          i = j;
          SpringHbReporter.a("survival_final_result", 0, i, localHashMap, a(5), jdField_a_of_type_Boolean);
          continue;
        }
        i = localSurvivalPkResultInfo.rank;
      }
      finally {}
      continue;
      label279:
      i = 1;
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 186
    //   11: iconst_2
    //   12: new 188	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 272
    //   22: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_0
    //   26: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 274
    //   32: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_1
    //   36: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 276
    //   42: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_2
    //   46: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: invokestatic 84	com/tencent/avgame/gamelogic/GameEngine:a	()Lcom/tencent/avgame/gamelogic/GameEngine;
    //   58: invokevirtual 109	com/tencent/avgame/gamelogic/GameEngine:a	()Lcom/tencent/avgame/gamelogic/data/EngineData;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +13 -> 78
    //   68: aload 4
    //   70: invokevirtual 245	com/tencent/avgame/gamelogic/data/EngineData:g	()Z
    //   73: istore_3
    //   74: iload_3
    //   75: ifne +7 -> 82
    //   78: ldc 2
    //   80: monitorexit
    //   81: return
    //   82: new 111	java/util/HashMap
    //   85: dup
    //   86: invokespecial 112	java/util/HashMap:<init>	()V
    //   89: astore 5
    //   91: aload 5
    //   93: ldc 164
    //   95: ldc_w 278
    //   98: invokeinterface 122 3 0
    //   103: pop
    //   104: aload 5
    //   106: ldc 124
    //   108: iload_0
    //   109: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   112: invokeinterface 122 3 0
    //   117: pop
    //   118: aload 5
    //   120: ldc 139
    //   122: iload_1
    //   123: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   126: invokeinterface 122 3 0
    //   131: pop
    //   132: aload 5
    //   134: ldc 181
    //   136: iload_2
    //   137: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   140: invokeinterface 122 3 0
    //   145: pop
    //   146: aload 5
    //   148: ldc 172
    //   150: aload 4
    //   152: invokevirtual 142	com/tencent/avgame/gamelogic/data/EngineData:p	()I
    //   155: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   158: invokeinterface 122 3 0
    //   163: pop
    //   164: aload 5
    //   166: ldc 221
    //   168: aload 4
    //   170: invokevirtual 223	com/tencent/avgame/gamelogic/data/EngineData:b	()Ljava/lang/String;
    //   173: invokestatic 226	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokeinterface 122 3 0
    //   181: pop
    //   182: aload 5
    //   184: ldc 154
    //   186: aload 4
    //   188: invokevirtual 157	com/tencent/avgame/gamelogic/data/EngineData:j	()I
    //   191: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokeinterface 122 3 0
    //   199: pop
    //   200: aload 5
    //   202: ldc 166
    //   204: aload 4
    //   206: invokevirtual 210	com/tencent/avgame/gamelogic/data/EngineData:k	()I
    //   209: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   212: invokeinterface 122 3 0
    //   217: pop
    //   218: aload 5
    //   220: ldc 159
    //   222: aload 4
    //   224: invokevirtual 219	com/tencent/avgame/gamelogic/data/EngineData:a	()J
    //   227: invokestatic 103	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   230: invokeinterface 122 3 0
    //   235: pop
    //   236: ldc_w 280
    //   239: iconst_0
    //   240: iconst_1
    //   241: aload 5
    //   243: iconst_0
    //   244: invokestatic 260	com/tencent/avgame/gameroom/festivalreport/CJSurvivalFestivalReporter:a	(I)Ljava/lang/String;
    //   247: iconst_1
    //   248: invokestatic 265	com/tencent/mobileqq/activity/springfestival/report/SpringHbReporter:a	(Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Z)V
    //   251: goto -173 -> 78
    //   254: astore 4
    //   256: ldc 2
    //   258: monitorexit
    //   259: aload 4
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramInt1	int
    //   0	262	1	paramInt2	int
    //   0	262	2	paramInt3	int
    //   73	2	3	bool	boolean
    //   61	162	4	localEngineData	EngineData
    //   254	6	4	localObject	Object
    //   89	153	5	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   3	55	254	finally
    //   55	63	254	finally
    //   68	74	254	finally
    //   82	251	254	finally
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramBoolean, false);
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, String paramString, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramBoolean1, paramInt3, false, paramString, paramBoolean2);
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramBoolean1, paramInt3, "", paramBoolean2);
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4, String paramString, boolean paramBoolean3)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CJSurvivalFestivalReporter", 2, "report eventType=" + paramInt1 + " actionType=" + paramInt2 + " isSuccess=" + paramBoolean1 + " refer=" + paramInt3 + " isReserve=" + paramBoolean2 + " pkId=" + paramInt4 + " isSelf=" + paramBoolean3);
        }
        Object localObject = GameEngine.a().a();
        if (localObject != null)
        {
          boolean bool = ((EngineData)localObject).g();
          if (!bool) {
            return;
          }
        }
        paramString = a(paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, paramInt4, paramString, paramBoolean3);
        localObject = b(paramInt1);
        if (paramBoolean1)
        {
          paramInt1 = i;
          SpringHbReporter.a((String)localObject, 0, paramInt1, paramString, a(paramInt2), jdField_a_of_type_Boolean);
        }
        else
        {
          paramInt1 = 1;
        }
      }
      finally {}
    }
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    a(paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, 0, paramString, paramBoolean3);
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramBoolean1, 0, paramBoolean2);
  }
  
  public static void a(@CJSurvivalFestivalReporter.EVENT_MEDIA_PLAYER_TYPE int paramInt, String paramString)
  {
    try
    {
      a(paramInt, paramString, 0, "");
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static void a(@CJSurvivalFestivalReporter.EVENT_MEDIA_PLAYER_TYPE int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc 186
    //   11: iconst_2
    //   12: ldc_w 323
    //   15: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: invokestatic 84	com/tencent/avgame/gamelogic/GameEngine:a	()Lcom/tencent/avgame/gamelogic/GameEngine;
    //   21: invokevirtual 109	com/tencent/avgame/gamelogic/GameEngine:a	()Lcom/tencent/avgame/gamelogic/data/EngineData;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +19 -> 47
    //   31: aload 5
    //   33: invokevirtual 245	com/tencent/avgame/gamelogic/data/EngineData:g	()Z
    //   36: istore 4
    //   38: iload 4
    //   40: ifne +7 -> 47
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: ldc_w 280
    //   50: iconst_0
    //   51: iconst_1
    //   52: iload_0
    //   53: aload_1
    //   54: iload_2
    //   55: aload_3
    //   56: invokestatic 325	com/tencent/avgame/gameroom/festivalreport/CJSurvivalFestivalReporter:a	(ILjava/lang/String;ILjava/lang/String;)Ljava/util/Map;
    //   59: iconst_0
    //   60: invokestatic 260	com/tencent/avgame/gameroom/festivalreport/CJSurvivalFestivalReporter:a	(I)Ljava/lang/String;
    //   63: iconst_1
    //   64: invokestatic 265	com/tencent/mobileqq/activity/springfestival/report/SpringHbReporter:a	(Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Z)V
    //   67: goto -24 -> 43
    //   70: astore_1
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramInt1	int
    //   0	76	1	paramString1	String
    //   0	76	2	paramInt2	int
    //   0	76	3	paramString2	String
    //   36	3	4	bool	boolean
    //   24	8	5	localEngineData	EngineData
    // Exception table:
    //   from	to	target	type
    //   3	18	70	finally
    //   18	26	70	finally
    //   31	38	70	finally
    //   47	67	70	finally
  }
  
  /* Error */
  public static void a(@CJSurvivalFestivalReporter.EVENT_EXCEPTION_REFER_TYPE int paramInt, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +70 -> 76
    //   9: ldc 186
    //   11: iconst_2
    //   12: new 188	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 328
    //   22: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_0
    //   26: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 330
    //   32: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_1
    //   36: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 332
    //   42: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_2
    //   46: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 334
    //   52: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 336
    //   62: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload 4
    //   67: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   70: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: invokestatic 84	com/tencent/avgame/gamelogic/GameEngine:a	()Lcom/tencent/avgame/gamelogic/GameEngine;
    //   79: invokevirtual 109	com/tencent/avgame/gamelogic/GameEngine:a	()Lcom/tencent/avgame/gamelogic/data/EngineData;
    //   82: astore 6
    //   84: aload 6
    //   86: ifnull +19 -> 105
    //   89: aload 6
    //   91: invokevirtual 245	com/tencent/avgame/gamelogic/data/EngineData:g	()Z
    //   94: istore 5
    //   96: iload 5
    //   98: ifne +7 -> 105
    //   101: ldc 2
    //   103: monitorexit
    //   104: return
    //   105: ldc_w 280
    //   108: iconst_0
    //   109: iconst_1
    //   110: iload_0
    //   111: iload_1
    //   112: aload_2
    //   113: aload_3
    //   114: invokestatic 338	com/tencent/avgame/gameroom/festivalreport/CJSurvivalFestivalReporter:a	(IZLjava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   117: iconst_0
    //   118: invokestatic 260	com/tencent/avgame/gameroom/festivalreport/CJSurvivalFestivalReporter:a	(I)Ljava/lang/String;
    //   121: iload 4
    //   123: invokestatic 265	com/tencent/mobileqq/activity/springfestival/report/SpringHbReporter:a	(Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Z)V
    //   126: goto -25 -> 101
    //   129: astore_2
    //   130: ldc 2
    //   132: monitorexit
    //   133: aload_2
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramInt	int
    //   0	135	1	paramBoolean1	boolean
    //   0	135	2	paramString1	String
    //   0	135	3	paramString2	String
    //   0	135	4	paramBoolean2	boolean
    //   94	3	5	bool	boolean
    //   82	8	6	localEngineData	EngineData
    // Exception table:
    //   from	to	target	type
    //   3	76	129	finally
    //   76	84	129	finally
    //   89	96	129	finally
    //   105	126	129	finally
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      jdField_a_of_type_JavaLangString = paramString;
      return;
      paramString = "0";
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +39 -> 45
    //   9: ldc 186
    //   11: iconst_2
    //   12: new 188	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 342
    //   22: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 344
    //   32: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_1
    //   36: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: invokestatic 84	com/tencent/avgame/gamelogic/GameEngine:a	()Lcom/tencent/avgame/gamelogic/GameEngine;
    //   48: invokevirtual 109	com/tencent/avgame/gamelogic/GameEngine:a	()Lcom/tencent/avgame/gamelogic/data/EngineData;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +12 -> 65
    //   56: aload_3
    //   57: invokevirtual 245	com/tencent/avgame/gamelogic/data/EngineData:g	()Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifne +7 -> 69
    //   65: ldc 2
    //   67: monitorexit
    //   68: return
    //   69: new 111	java/util/HashMap
    //   72: dup
    //   73: invokespecial 112	java/util/HashMap:<init>	()V
    //   76: astore 4
    //   78: aload 4
    //   80: ldc 164
    //   82: ldc_w 346
    //   85: invokeinterface 122 3 0
    //   90: pop
    //   91: aload 4
    //   93: ldc 124
    //   95: aload_3
    //   96: invokevirtual 223	com/tencent/avgame/gamelogic/data/EngineData:b	()Ljava/lang/String;
    //   99: invokestatic 226	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokeinterface 122 3 0
    //   107: pop
    //   108: aload 4
    //   110: ldc 139
    //   112: aload_0
    //   113: invokeinterface 122 3 0
    //   118: pop
    //   119: aload 4
    //   121: ldc 144
    //   123: iload_1
    //   124: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   127: invokeinterface 122 3 0
    //   132: pop
    //   133: aload 4
    //   135: ldc 172
    //   137: aload_3
    //   138: invokevirtual 142	com/tencent/avgame/gamelogic/data/EngineData:p	()I
    //   141: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   144: invokeinterface 122 3 0
    //   149: pop
    //   150: aload 4
    //   152: ldc 154
    //   154: aload_3
    //   155: invokevirtual 157	com/tencent/avgame/gamelogic/data/EngineData:j	()I
    //   158: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   161: invokeinterface 122 3 0
    //   166: pop
    //   167: aload 4
    //   169: ldc 166
    //   171: aload_3
    //   172: invokevirtual 210	com/tencent/avgame/gamelogic/data/EngineData:k	()I
    //   175: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   178: invokeinterface 122 3 0
    //   183: pop
    //   184: aload 4
    //   186: ldc 159
    //   188: aload_3
    //   189: invokevirtual 219	com/tencent/avgame/gamelogic/data/EngineData:a	()J
    //   192: invokestatic 103	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   195: invokeinterface 122 3 0
    //   200: pop
    //   201: ldc_w 280
    //   204: iconst_0
    //   205: iconst_1
    //   206: aload 4
    //   208: iconst_0
    //   209: invokestatic 260	com/tencent/avgame/gameroom/festivalreport/CJSurvivalFestivalReporter:a	(I)Ljava/lang/String;
    //   212: iconst_1
    //   213: invokestatic 265	com/tencent/mobileqq/activity/springfestival/report/SpringHbReporter:a	(Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Z)V
    //   216: goto -151 -> 65
    //   219: astore_0
    //   220: ldc 2
    //   222: monitorexit
    //   223: aload_0
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramString	String
    //   0	225	1	paramInt	int
    //   60	2	2	bool	boolean
    //   51	138	3	localEngineData	EngineData
    //   76	131	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   3	45	219	finally
    //   45	52	219	finally
    //   56	61	219	finally
    //   69	216	219	finally
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 5: 
      return "survival_answer";
    case 2: 
      return "survival_call";
    case 3: 
      return "survival_countdown";
    case 1: 
      return "survival_entry";
    case 9: 
      return "survival_final_rank";
    case 7: 
      return "survival_game";
    case 0: 
      return "survival_main";
    case 6: 
      return "survival_result";
    case 4: 
      return "survival_subject";
    case 8: 
      return "survival_term_result";
    }
    return "survival_final_result";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter
 * JD-Core Version:    0.7.0.1
 */