package com.tencent.av.opengl.effects;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;

public final class AEKitAbilityInfo
{
  private static int jdField_a_of_type_Int = -1;
  private static Boolean jdField_a_of_type_JavaLangBoolean = null;
  private static Boolean b = null;
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 24
    //   2: fstore_0
    //   3: iconst_1
    //   4: istore 8
    //   6: getstatic 12	com/tencent/av/opengl/effects/AEKitAbilityInfo:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   9: ifnonnull +135 -> 144
    //   12: invokestatic 29	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()I
    //   15: istore 7
    //   17: ldc 31
    //   19: invokestatic 36	com/tencent/av/utils/QAVConfigUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: ldc 37
    //   26: fstore_2
    //   27: ldc 38
    //   29: fstore 5
    //   31: aload 9
    //   33: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +224 -> 260
    //   39: aload 9
    //   41: ldc 46
    //   43: invokevirtual 52	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   46: astore 9
    //   48: aload 9
    //   50: arraylength
    //   51: iconst_4
    //   52: if_icmplt +208 -> 260
    //   55: aload 9
    //   57: iconst_0
    //   58: aaload
    //   59: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   62: fstore_1
    //   63: fload_0
    //   64: fstore_3
    //   65: aload 9
    //   67: iconst_1
    //   68: aaload
    //   69: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   72: fstore 4
    //   74: fload_0
    //   75: fstore_3
    //   76: fload 4
    //   78: fstore_2
    //   79: aload 9
    //   81: iconst_2
    //   82: aaload
    //   83: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   86: fstore_0
    //   87: fload_0
    //   88: fstore_3
    //   89: fload 4
    //   91: fstore_2
    //   92: aload 9
    //   94: iconst_3
    //   95: aaload
    //   96: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   99: fstore 6
    //   101: fload 6
    //   103: fstore_3
    //   104: fload 4
    //   106: fstore_2
    //   107: invokestatic 61	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()J
    //   110: l2f
    //   111: fconst_1
    //   112: fmul
    //   113: ldc 62
    //   115: fdiv
    //   116: fstore 4
    //   118: invokestatic 67	com/tencent/av/core/VcSystemInfo:getMaxCpuFreq	()J
    //   121: l2f
    //   122: ldc 68
    //   124: fdiv
    //   125: fstore 5
    //   127: iload 7
    //   129: iconst_4
    //   130: if_icmpge +37 -> 167
    //   133: new 70	java/lang/Boolean
    //   136: dup
    //   137: iconst_0
    //   138: invokespecial 73	java/lang/Boolean:<init>	(Z)V
    //   141: putstatic 12	com/tencent/av/opengl/effects/AEKitAbilityInfo:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   144: getstatic 12	com/tencent/av/opengl/effects/AEKitAbilityInfo:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   147: invokevirtual 76	java/lang/Boolean:booleanValue	()Z
    //   150: ireturn
    //   151: astore 9
    //   153: ldc 24
    //   155: fstore_1
    //   156: aload 9
    //   158: invokevirtual 79	java/lang/NumberFormatException:printStackTrace	()V
    //   161: fload 5
    //   163: fstore_3
    //   164: goto -57 -> 107
    //   167: iload 7
    //   169: iconst_4
    //   170: if_icmplt +48 -> 218
    //   173: iload 7
    //   175: bipush 8
    //   177: if_icmpge +41 -> 218
    //   180: fload 4
    //   182: fload_1
    //   183: fcmpl
    //   184: iflt +28 -> 212
    //   187: fload 5
    //   189: fload_2
    //   190: fcmpl
    //   191: iflt +21 -> 212
    //   194: iconst_1
    //   195: istore 8
    //   197: new 70	java/lang/Boolean
    //   200: dup
    //   201: iload 8
    //   203: invokespecial 73	java/lang/Boolean:<init>	(Z)V
    //   206: putstatic 12	com/tencent/av/opengl/effects/AEKitAbilityInfo:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   209: goto -65 -> 144
    //   212: iconst_0
    //   213: istore 8
    //   215: goto -18 -> 197
    //   218: fload 4
    //   220: fload_0
    //   221: fcmpl
    //   222: iflt +25 -> 247
    //   225: fload 5
    //   227: fload_3
    //   228: fcmpl
    //   229: iflt +18 -> 247
    //   232: new 70	java/lang/Boolean
    //   235: dup
    //   236: iload 8
    //   238: invokespecial 73	java/lang/Boolean:<init>	(Z)V
    //   241: putstatic 12	com/tencent/av/opengl/effects/AEKitAbilityInfo:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   244: goto -100 -> 144
    //   247: iconst_0
    //   248: istore 8
    //   250: goto -18 -> 232
    //   253: astore 9
    //   255: fload_3
    //   256: fstore_0
    //   257: goto -101 -> 156
    //   260: ldc 24
    //   262: fstore_1
    //   263: fload 5
    //   265: fstore_3
    //   266: goto -159 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   2	255	0	f1	float
    //   62	201	1	f2	float
    //   26	164	2	f3	float
    //   64	202	3	f4	float
    //   72	147	4	f5	float
    //   29	235	5	f6	float
    //   99	3	6	f7	float
    //   15	163	7	i	int
    //   4	245	8	bool	boolean
    //   22	71	9	localObject	Object
    //   151	6	9	localNumberFormatException1	NumberFormatException
    //   253	1	9	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   55	63	151	java/lang/NumberFormatException
    //   65	74	253	java/lang/NumberFormatException
    //   79	87	253	java/lang/NumberFormatException
    //   92	101	253	java/lang/NumberFormatException
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = true;
    if (!b())
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess machine power not support");
      return false;
    }
    if (jdField_a_of_type_Int != -1)
    {
      if (jdField_a_of_type_Int == 0) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    if (!PtuResChecker.a().a(paramVideoAppInterface))
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess so not ready.");
      return false;
    }
    long l1 = AudioHelper.c();
    bool = FeatureManager.Features.PAG.init();
    long l2 = AudioHelper.c();
    if (!bool) {}
    for (jdField_a_of_type_Int = 1;; jdField_a_of_type_Int = 0)
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess, AEKitBaseRes[" + PtuResChecker.a().a() + "], sLoadPagSoReady[" + jdField_a_of_type_Int + "], cost[" + (l2 - l1) / 1000000L + "ms]");
      return bool;
    }
  }
  
  public static boolean b()
  {
    Object localObject;
    int i;
    float f1;
    if (b == null)
    {
      localObject = QAVConfigUtils.a("ptuAfterTreamentLimit");
      f3 = 3.0F;
      j = 4;
      f4 = 1.1F;
      f2 = f4;
      i = j;
      f1 = f3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(";");
        f2 = f4;
        i = j;
        f1 = f3;
        if (localObject.length >= 3)
        {
          i = j;
          f1 = f3;
        }
      }
    }
    try
    {
      f2 = Float.parseFloat(localObject[0]);
      i = j;
      f1 = f2;
      j = Integer.parseInt(localObject[1]);
      i = j;
      f1 = f2;
      f3 = Float.parseFloat(localObject[2]);
      f1 = f2;
      i = j;
      f2 = f3;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        f2 = f4;
        continue;
        b = new Boolean(false);
        continue;
        boolean bool = false;
      }
    }
    float f3 = (float)DeviceInfoUtil.a() * 1.0F / 1.073742E+009F;
    int j = DeviceInfoUtil.b();
    f4 = (float)VcSystemInfo.getMaxCpuFreq() / 1048576.0F;
    if ((f1 <= f3) && (i <= j) && (f2 <= f4))
    {
      b = new Boolean(true);
      if ((!b.booleanValue()) || (Build.VERSION.SDK_INT < 21) || (!PtuResChecker.c())) {
        break label233;
      }
      bool = true;
      b = Boolean.valueOf(bool);
      return b.booleanValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEKitAbilityInfo
 * JD-Core Version:    0.7.0.1
 */