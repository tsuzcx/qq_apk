package com.tencent.av.core;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.AVLog;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jjr;

public class VcSystemInfo
{
  static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString = "";
  static boolean jdField_a_of_type_Boolean;
  static int jdField_b_of_type_Int;
  static long jdField_b_of_type_Long;
  static String jdField_b_of_type_JavaLangString = "";
  static boolean jdField_b_of_type_Boolean;
  static int jdField_c_of_type_Int;
  static String jdField_c_of_type_JavaLangString;
  static boolean jdField_c_of_type_Boolean;
  static int jdField_d_of_type_Int;
  static String jdField_d_of_type_JavaLangString;
  static boolean jdField_d_of_type_Boolean;
  static int i;
  int e = 320;
  int f = 480;
  public int g = 320;
  public int h = 240;
  
  static
  {
    jdField_a_of_type_Int = 5;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 1;
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Boolean = true;
    a();
  }
  
  static int a()
  {
    try
    {
      int j = new File("/sys/devices/system/cpu/").listFiles(new jjr()).length;
      return j;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  /* Error */
  static long a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   5: iconst_1
    //   6: if_icmpge +22 -> 28
    //   9: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +11 -> 23
    //   15: ldc 79
    //   17: iconst_2
    //   18: ldc 81
    //   20: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: bipush 8
    //   25: putstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   28: iconst_0
    //   29: istore_2
    //   30: lconst_0
    //   31: lstore 5
    //   33: lconst_0
    //   34: lstore_3
    //   35: iload_1
    //   36: getstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   39: if_icmpge +313 -> 352
    //   42: aconst_null
    //   43: astore 12
    //   45: new 86	java/io/BufferedReader
    //   48: dup
    //   49: new 88	java/io/FileReader
    //   52: dup
    //   53: new 90	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   60: ldc 93
    //   62: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_1
    //   66: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc 102
    //   71: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   80: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   83: astore 11
    //   85: lload_3
    //   86: lstore 7
    //   88: aload 11
    //   90: ifnull +51 -> 141
    //   93: aload 11
    //   95: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 12
    //   100: aload 12
    //   102: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +334 -> 439
    //   108: aload 12
    //   110: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   113: astore 12
    //   115: lload_3
    //   116: lstore 7
    //   118: aload 12
    //   120: ifnull +21 -> 141
    //   123: lload_3
    //   124: lstore 7
    //   126: aload 12
    //   128: invokevirtual 127	java/lang/String:length	()I
    //   131: ifle +10 -> 141
    //   134: aload 12
    //   136: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   139: lstore 7
    //   141: iload_2
    //   142: istore_0
    //   143: lload 7
    //   145: lstore_3
    //   146: aload 11
    //   148: ifnull +13 -> 161
    //   151: aload 11
    //   153: invokevirtual 136	java/io/BufferedReader:close	()V
    //   156: lload 7
    //   158: lstore_3
    //   159: iload_2
    //   160: istore_0
    //   161: lload 5
    //   163: lstore 7
    //   165: lload_3
    //   166: lload 5
    //   168: lcmp
    //   169: ifle +6 -> 175
    //   172: lload_3
    //   173: lstore 7
    //   175: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +47 -> 225
    //   181: ldc 79
    //   183: iconst_2
    //   184: new 90	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   191: ldc 138
    //   193: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload_1
    //   197: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc 140
    //   202: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: lload_3
    //   206: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   209: ldc 145
    //   211: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: lload 7
    //   216: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: iload_1
    //   226: iconst_1
    //   227: iadd
    //   228: istore_1
    //   229: iload_0
    //   230: istore_2
    //   231: lload 7
    //   233: lstore 5
    //   235: goto -200 -> 35
    //   238: astore 11
    //   240: aload 11
    //   242: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   245: iload_2
    //   246: istore_0
    //   247: lload 7
    //   249: lstore_3
    //   250: goto -89 -> 161
    //   253: astore 12
    //   255: aconst_null
    //   256: astore 11
    //   258: ldc 79
    //   260: iconst_1
    //   261: new 90	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   268: ldc 150
    //   270: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_1
    //   274: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc 152
    //   279: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 12
    //   284: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   287: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload 11
    //   298: ifnull +8 -> 306
    //   301: aload 11
    //   303: invokevirtual 136	java/io/BufferedReader:close	()V
    //   306: iconst_1
    //   307: istore_0
    //   308: lconst_0
    //   309: lstore_3
    //   310: goto -149 -> 161
    //   313: astore 11
    //   315: aload 11
    //   317: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   320: iconst_1
    //   321: istore_0
    //   322: lconst_0
    //   323: lstore_3
    //   324: goto -163 -> 161
    //   327: astore 11
    //   329: aload 12
    //   331: ifnull +8 -> 339
    //   334: aload 12
    //   336: invokevirtual 136	java/io/BufferedReader:close	()V
    //   339: aload 11
    //   341: athrow
    //   342: astore 12
    //   344: aload 12
    //   346: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   349: goto -10 -> 339
    //   352: lload 5
    //   354: lstore 7
    //   356: iload_2
    //   357: ifeq +23 -> 380
    //   360: invokestatic 157	com/tencent/av/core/VcSystemInfo:b	()J
    //   363: lstore 9
    //   365: lload 5
    //   367: lstore 7
    //   369: lload 9
    //   371: lload_3
    //   372: lcmp
    //   373: ifle +7 -> 380
    //   376: lload 9
    //   378: lstore 7
    //   380: ldc 79
    //   382: new 90	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   389: ldc 159
    //   391: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: lload 7
    //   396: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 164	com/tencent/av/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: lload 7
    //   407: lreturn
    //   408: astore 13
    //   410: aload 11
    //   412: astore 12
    //   414: aload 13
    //   416: astore 11
    //   418: goto -89 -> 329
    //   421: astore 13
    //   423: aload 11
    //   425: astore 12
    //   427: aload 13
    //   429: astore 11
    //   431: goto -102 -> 329
    //   434: astore 12
    //   436: goto -178 -> 258
    //   439: ldc 21
    //   441: astore 12
    //   443: goto -328 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   142	180	0	j	int
    //   1	273	1	k	int
    //   29	328	2	m	int
    //   34	338	3	l1	long
    //   31	335	5	l2	long
    //   86	320	7	l3	long
    //   363	14	9	l4	long
    //   83	69	11	localBufferedReader	java.io.BufferedReader
    //   238	3	11	localIOException1	java.io.IOException
    //   256	46	11	localObject1	Object
    //   313	3	11	localIOException2	java.io.IOException
    //   327	84	11	localObject2	Object
    //   416	14	11	localObject3	Object
    //   43	92	12	str1	String
    //   253	82	12	localException1	Exception
    //   342	3	12	localIOException3	java.io.IOException
    //   412	14	12	localObject4	Object
    //   434	1	12	localException2	Exception
    //   441	1	12	str2	String
    //   408	7	13	localObject5	Object
    //   421	7	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   151	156	238	java/io/IOException
    //   45	85	253	java/lang/Exception
    //   301	306	313	java/io/IOException
    //   45	85	327	finally
    //   334	339	342	java/io/IOException
    //   93	115	408	finally
    //   126	141	408	finally
    //   258	296	421	finally
    //   93	115	434	java/lang/Exception
    //   126	141	434	java/lang/Exception
  }
  
  public static String a()
  {
    return Build.MODEL;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 175	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 9
    //   11: ldc2_w 176
    //   14: lstore 4
    //   16: ldc 178
    //   18: fstore_0
    //   19: new 90	java/lang/StringBuilder
    //   22: dup
    //   23: sipush 1024
    //   26: invokespecial 181	java/lang/StringBuilder:<init>	(I)V
    //   29: astore 10
    //   31: new 86	java/io/BufferedReader
    //   34: dup
    //   35: new 88	java/io/FileReader
    //   38: dup
    //   39: ldc 183
    //   41: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 8
    //   49: aload 8
    //   51: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 9
    //   56: aload 9
    //   58: ifnonnull +269 -> 327
    //   61: iconst_1
    //   62: putstatic 175	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   65: lload 4
    //   67: lstore 6
    //   69: fload_0
    //   70: fstore_1
    //   71: aload 8
    //   73: ifnull +14 -> 87
    //   76: aload 8
    //   78: invokevirtual 136	java/io/BufferedReader:close	()V
    //   81: fload_0
    //   82: fstore_1
    //   83: lload 4
    //   85: lstore 6
    //   87: invokestatic 185	com/tencent/av/core/VcSystemInfo:a	()I
    //   90: istore_2
    //   91: iload_2
    //   92: ifle +1105 -> 1197
    //   95: iload_2
    //   96: putstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   99: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +28 -> 130
    //   105: aload 10
    //   107: ldc 187
    //   109: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: getstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   118: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 10
    //   124: ldc 189
    //   126: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: invokestatic 191	com/tencent/av/core/VcSystemInfo:a	()J
    //   133: lstore 4
    //   135: lload 4
    //   137: lconst_0
    //   138: lcmp
    //   139: ifle +1106 -> 1245
    //   142: lload 4
    //   144: putstatic 193	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   147: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +28 -> 178
    //   153: aload 10
    //   155: ldc 195
    //   157: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 10
    //   163: getstatic 193	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   166: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 10
    //   172: ldc 189
    //   174: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: getstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   181: ifle +11 -> 192
    //   184: getstatic 193	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   187: lconst_0
    //   188: lcmp
    //   189: ifgt +1156 -> 1345
    //   192: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +45 -> 240
    //   198: aload 10
    //   200: ldc 197
    //   202: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 10
    //   208: getstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   211: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 10
    //   217: ldc 199
    //   219: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 10
    //   225: getstatic 193	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   228: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 10
    //   234: ldc 189
    //   236: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: iconst_0
    //   241: putstatic 175	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   244: invokestatic 201	com/tencent/av/core/VcSystemInfo:b	()I
    //   247: putstatic 33	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_Int	I
    //   250: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq -246 -> 7
    //   256: aload 10
    //   258: ldc 203
    //   260: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 10
    //   266: getstatic 33	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_Int	I
    //   269: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 10
    //   275: ldc 205
    //   277: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: getstatic 37	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_Boolean	Z
    //   286: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 10
    //   292: ldc 210
    //   294: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 10
    //   300: getstatic 35	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Boolean	Z
    //   303: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 10
    //   309: ldc 189
    //   311: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 79
    //   317: iconst_2
    //   318: aload 10
    //   320: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: return
    //   327: aload 9
    //   329: ldc 212
    //   331: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   334: ifeq +134 -> 468
    //   337: aload 9
    //   339: bipush 58
    //   341: invokevirtual 220	java/lang/String:indexOf	(I)I
    //   344: istore_2
    //   345: iload_2
    //   346: iconst_1
    //   347: if_icmple -298 -> 49
    //   350: aload 9
    //   352: iload_2
    //   353: iconst_1
    //   354: iadd
    //   355: aload 9
    //   357: invokevirtual 127	java/lang/String:length	()I
    //   360: invokevirtual 224	java/lang/String:substring	(II)Ljava/lang/String;
    //   363: putstatic 23	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   366: getstatic 23	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   369: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   372: putstatic 23	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   375: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq -329 -> 49
    //   381: aload 10
    //   383: ldc 226
    //   385: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 10
    //   391: getstatic 23	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   394: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 10
    //   400: ldc 228
    //   402: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 10
    //   408: aload 9
    //   410: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 10
    //   416: ldc 189
    //   418: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: goto -373 -> 49
    //   425: astore 9
    //   427: lload 4
    //   429: lstore 6
    //   431: fload_0
    //   432: fstore_1
    //   433: aload 8
    //   435: ifnull -348 -> 87
    //   438: aload 8
    //   440: invokevirtual 136	java/io/BufferedReader:close	()V
    //   443: lload 4
    //   445: lstore 6
    //   447: fload_0
    //   448: fstore_1
    //   449: goto -362 -> 87
    //   452: astore 8
    //   454: aload 8
    //   456: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   459: lload 4
    //   461: lstore 6
    //   463: fload_0
    //   464: fstore_1
    //   465: goto -378 -> 87
    //   468: aload 9
    //   470: ldc 230
    //   472: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   475: ifeq +228 -> 703
    //   478: aload 9
    //   480: bipush 58
    //   482: invokevirtual 220	java/lang/String:indexOf	(I)I
    //   485: istore_2
    //   486: iload_2
    //   487: iconst_1
    //   488: if_icmple +49 -> 537
    //   491: aload 9
    //   493: iload_2
    //   494: iconst_1
    //   495: iadd
    //   496: aload 9
    //   498: invokevirtual 127	java/lang/String:length	()I
    //   501: invokevirtual 224	java/lang/String:substring	(II)Ljava/lang/String;
    //   504: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   507: astore 11
    //   509: aload 11
    //   511: ifnull +26 -> 537
    //   514: aload 11
    //   516: invokevirtual 127	java/lang/String:length	()I
    //   519: ifle +18 -> 537
    //   522: aload 11
    //   524: ldc 232
    //   526: invokevirtual 235	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   529: ifeq +115 -> 644
    //   532: bipush 8
    //   534: putstatic 27	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Int	I
    //   537: aload 9
    //   539: ldc 237
    //   541: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   544: ifeq +7 -> 551
    //   547: iconst_5
    //   548: putstatic 27	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Int	I
    //   551: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq -505 -> 49
    //   557: aload 10
    //   559: ldc 242
    //   561: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload 10
    //   567: getstatic 27	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Int	I
    //   570: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 10
    //   576: ldc 228
    //   578: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 10
    //   584: aload 9
    //   586: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 10
    //   592: ldc 189
    //   594: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: goto -549 -> 49
    //   601: astore 9
    //   603: lload 4
    //   605: lstore 6
    //   607: fload_0
    //   608: fstore_1
    //   609: aload 8
    //   611: ifnull -524 -> 87
    //   614: aload 8
    //   616: invokevirtual 136	java/io/BufferedReader:close	()V
    //   619: lload 4
    //   621: lstore 6
    //   623: fload_0
    //   624: fstore_1
    //   625: goto -538 -> 87
    //   628: astore 8
    //   630: aload 8
    //   632: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   635: lload 4
    //   637: lstore 6
    //   639: fload_0
    //   640: fstore_1
    //   641: goto -554 -> 87
    //   644: aload 11
    //   646: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   649: l2i
    //   650: putstatic 27	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Int	I
    //   653: goto -116 -> 537
    //   656: astore 12
    //   658: iconst_1
    //   659: istore_2
    //   660: aload 11
    //   662: invokevirtual 127	java/lang/String:length	()I
    //   665: istore_3
    //   666: iload_2
    //   667: iload_3
    //   668: if_icmpge -131 -> 537
    //   671: aload 11
    //   673: iconst_0
    //   674: aload 11
    //   676: invokevirtual 127	java/lang/String:length	()I
    //   679: iload_2
    //   680: isub
    //   681: invokevirtual 224	java/lang/String:substring	(II)Ljava/lang/String;
    //   684: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   687: l2i
    //   688: putstatic 27	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Int	I
    //   691: goto -154 -> 537
    //   694: astore 12
    //   696: iload_2
    //   697: iconst_1
    //   698: iadd
    //   699: istore_2
    //   700: goto -40 -> 660
    //   703: aload 9
    //   705: ldc 244
    //   707: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   710: ifeq +128 -> 838
    //   713: aload 9
    //   715: bipush 58
    //   717: invokevirtual 220	java/lang/String:indexOf	(I)I
    //   720: istore_2
    //   721: iload_2
    //   722: iconst_1
    //   723: if_icmple +22 -> 745
    //   726: aload 9
    //   728: iload_2
    //   729: iconst_1
    //   730: iadd
    //   731: aload 9
    //   733: invokevirtual 127	java/lang/String:length	()I
    //   736: invokevirtual 224	java/lang/String:substring	(II)Ljava/lang/String;
    //   739: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   742: putstatic 25	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   745: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq -699 -> 49
    //   751: aload 10
    //   753: ldc 246
    //   755: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 10
    //   761: getstatic 25	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   764: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 10
    //   770: ldc 228
    //   772: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 10
    //   778: aload 9
    //   780: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload 10
    //   786: ldc 189
    //   788: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: goto -743 -> 49
    //   795: astore 9
    //   797: lload 4
    //   799: lstore 6
    //   801: fload_0
    //   802: fstore_1
    //   803: aload 8
    //   805: ifnull -718 -> 87
    //   808: aload 8
    //   810: invokevirtual 136	java/io/BufferedReader:close	()V
    //   813: lload 4
    //   815: lstore 6
    //   817: fload_0
    //   818: fstore_1
    //   819: goto -732 -> 87
    //   822: astore 8
    //   824: aload 8
    //   826: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   829: lload 4
    //   831: lstore 6
    //   833: fload_0
    //   834: fstore_1
    //   835: goto -748 -> 87
    //   838: aload 9
    //   840: ldc 248
    //   842: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   845: ifeq +108 -> 953
    //   848: aload 9
    //   850: bipush 58
    //   852: invokevirtual 220	java/lang/String:indexOf	(I)I
    //   855: istore_2
    //   856: iload_2
    //   857: iconst_1
    //   858: if_icmple +22 -> 880
    //   861: aload 9
    //   863: iload_2
    //   864: iconst_1
    //   865: iadd
    //   866: aload 9
    //   868: invokevirtual 127	java/lang/String:length	()I
    //   871: invokevirtual 224	java/lang/String:substring	(II)Ljava/lang/String;
    //   874: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   877: putstatic 250	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   880: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   883: ifeq -834 -> 49
    //   886: aload 10
    //   888: ldc 252
    //   890: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: aload 10
    //   896: getstatic 250	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   899: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload 10
    //   905: ldc 228
    //   907: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload 10
    //   913: aload 9
    //   915: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: aload 10
    //   921: ldc 189
    //   923: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: pop
    //   927: goto -878 -> 49
    //   930: astore 10
    //   932: aload 8
    //   934: astore 9
    //   936: aload 10
    //   938: astore 8
    //   940: aload 9
    //   942: ifnull +8 -> 950
    //   945: aload 9
    //   947: invokevirtual 136	java/io/BufferedReader:close	()V
    //   950: aload 8
    //   952: athrow
    //   953: aload 9
    //   955: ldc 254
    //   957: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   960: ifeq +77 -> 1037
    //   963: aload 9
    //   965: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   968: putstatic 256	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   971: aload 9
    //   973: ldc_w 258
    //   976: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   979: ifeq +7 -> 986
    //   982: iconst_1
    //   983: putstatic 260	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_Boolean	Z
    //   986: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   989: ifeq -940 -> 49
    //   992: aload 10
    //   994: ldc_w 262
    //   997: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: aload 10
    //   1003: getstatic 260	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_Boolean	Z
    //   1006: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: aload 10
    //   1012: ldc 228
    //   1014: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: pop
    //   1018: aload 10
    //   1020: aload 9
    //   1022: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: aload 10
    //   1028: ldc 189
    //   1030: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: goto -985 -> 49
    //   1037: aload 9
    //   1039: ldc_w 264
    //   1042: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1045: ifeq +67 -> 1112
    //   1048: aload 9
    //   1050: bipush 58
    //   1052: invokevirtual 220	java/lang/String:indexOf	(I)I
    //   1055: istore_2
    //   1056: iload_2
    //   1057: iconst_1
    //   1058: if_icmple -1009 -> 49
    //   1061: aload 9
    //   1063: iload_2
    //   1064: iconst_1
    //   1065: iadd
    //   1066: aload 9
    //   1068: invokevirtual 127	java/lang/String:length	()I
    //   1071: invokevirtual 224	java/lang/String:substring	(II)Ljava/lang/String;
    //   1074: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   1077: astore 9
    //   1079: aload 9
    //   1081: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1084: lstore 6
    //   1086: lload 6
    //   1088: lconst_0
    //   1089: lcmp
    //   1090: iflt -1041 -> 49
    //   1093: lconst_1
    //   1094: lload 6
    //   1096: ladd
    //   1097: lload 4
    //   1099: lcmp
    //   1100: ifle -1051 -> 49
    //   1103: lconst_1
    //   1104: lload 6
    //   1106: ladd
    //   1107: lstore 4
    //   1109: goto -1060 -> 49
    //   1112: aload 9
    //   1114: ldc_w 266
    //   1117: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1120: ifeq -1071 -> 49
    //   1123: aload 9
    //   1125: bipush 58
    //   1127: invokevirtual 220	java/lang/String:indexOf	(I)I
    //   1130: istore_2
    //   1131: iload_2
    //   1132: iconst_1
    //   1133: if_icmple -1084 -> 49
    //   1136: aload 9
    //   1138: iload_2
    //   1139: iconst_1
    //   1140: iadd
    //   1141: aload 9
    //   1143: invokevirtual 127	java/lang/String:length	()I
    //   1146: invokevirtual 224	java/lang/String:substring	(II)Ljava/lang/String;
    //   1149: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   1152: astore 9
    //   1154: aload 9
    //   1156: invokestatic 272	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1159: fstore_1
    //   1160: fload_1
    //   1161: fload_0
    //   1162: fcmpl
    //   1163: ifle +232 -> 1395
    //   1166: fload_1
    //   1167: fstore_0
    //   1168: goto -1119 -> 49
    //   1171: astore 8
    //   1173: aload 8
    //   1175: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   1178: lload 4
    //   1180: lstore 6
    //   1182: fload_0
    //   1183: fstore_1
    //   1184: goto -1097 -> 87
    //   1187: astore 9
    //   1189: aload 9
    //   1191: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   1194: goto -244 -> 950
    //   1197: lload 6
    //   1199: lconst_0
    //   1200: lcmp
    //   1201: ifle -1071 -> 130
    //   1204: lload 6
    //   1206: l2i
    //   1207: putstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   1210: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1213: ifeq -1083 -> 130
    //   1216: aload 10
    //   1218: ldc_w 274
    //   1221: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: aload 10
    //   1227: getstatic 29	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Int	I
    //   1230: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1233: pop
    //   1234: aload 10
    //   1236: ldc 189
    //   1238: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: pop
    //   1242: goto -1112 -> 130
    //   1245: fload_1
    //   1246: fconst_0
    //   1247: fcmpl
    //   1248: ifle -1070 -> 178
    //   1251: fload_1
    //   1252: ldc_w 275
    //   1255: fcmpg
    //   1256: ifge +52 -> 1308
    //   1259: fload_1
    //   1260: f2d
    //   1261: ldc2_w 276
    //   1264: dmul
    //   1265: ldc2_w 278
    //   1268: dmul
    //   1269: d2l
    //   1270: putstatic 193	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1273: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1276: ifeq -1098 -> 178
    //   1279: aload 10
    //   1281: ldc_w 281
    //   1284: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: pop
    //   1288: aload 10
    //   1290: getstatic 193	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1293: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: aload 10
    //   1299: ldc 189
    //   1301: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: goto -1127 -> 178
    //   1308: fload_1
    //   1309: ldc_w 282
    //   1312: fcmpl
    //   1313: ifle +20 -> 1333
    //   1316: fload_1
    //   1317: f2d
    //   1318: ldc2_w 283
    //   1321: ddiv
    //   1322: ldc2_w 278
    //   1325: dmul
    //   1326: d2l
    //   1327: putstatic 193	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1330: goto -57 -> 1273
    //   1333: ldc_w 285
    //   1336: fload_1
    //   1337: fmul
    //   1338: f2l
    //   1339: putstatic 193	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1342: goto -69 -> 1273
    //   1345: iconst_1
    //   1346: putstatic 175	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   1349: goto -1105 -> 244
    //   1352: astore 9
    //   1354: goto -1305 -> 49
    //   1357: astore 9
    //   1359: goto -1310 -> 49
    //   1362: astore 8
    //   1364: aconst_null
    //   1365: astore 9
    //   1367: goto -427 -> 940
    //   1370: astore 8
    //   1372: aconst_null
    //   1373: astore 8
    //   1375: goto -578 -> 797
    //   1378: astore 8
    //   1380: aconst_null
    //   1381: astore 8
    //   1383: goto -780 -> 603
    //   1386: astore 8
    //   1388: aload 9
    //   1390: astore 8
    //   1392: goto -965 -> 427
    //   1395: goto -227 -> 1168
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	1165	0	f1	float
    //   70	1267	1	f2	float
    //   90	1051	2	j	int
    //   665	4	3	k	int
    //   14	1165	4	l1	long
    //   67	1138	6	l2	long
    //   47	392	8	localBufferedReader	java.io.BufferedReader
    //   452	163	8	localIOException1	java.io.IOException
    //   628	181	8	localIOException2	java.io.IOException
    //   822	111	8	localIOException3	java.io.IOException
    //   938	13	8	localObject1	Object
    //   1171	3	8	localIOException4	java.io.IOException
    //   1362	1	8	localObject2	Object
    //   1370	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   1373	1	8	localObject3	Object
    //   1378	1	8	localIOException5	java.io.IOException
    //   1381	1	8	localObject4	Object
    //   1386	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1390	1	8	localObject5	Object
    //   9	400	9	str1	String
    //   425	160	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   601	178	9	localIOException6	java.io.IOException
    //   795	119	9	localNumberFormatException2	java.lang.NumberFormatException
    //   934	221	9	localObject6	Object
    //   1187	3	9	localIOException7	java.io.IOException
    //   1352	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   1357	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   1365	24	9	localObject7	Object
    //   29	891	10	localStringBuilder	java.lang.StringBuilder
    //   930	368	10	localObject8	Object
    //   507	168	11	str2	String
    //   656	1	12	localNumberFormatException5	java.lang.NumberFormatException
    //   694	1	12	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   49	56	425	java/io/FileNotFoundException
    //   61	65	425	java/io/FileNotFoundException
    //   327	345	425	java/io/FileNotFoundException
    //   350	422	425	java/io/FileNotFoundException
    //   468	486	425	java/io/FileNotFoundException
    //   491	509	425	java/io/FileNotFoundException
    //   514	537	425	java/io/FileNotFoundException
    //   537	551	425	java/io/FileNotFoundException
    //   551	598	425	java/io/FileNotFoundException
    //   644	653	425	java/io/FileNotFoundException
    //   660	666	425	java/io/FileNotFoundException
    //   671	691	425	java/io/FileNotFoundException
    //   703	721	425	java/io/FileNotFoundException
    //   726	745	425	java/io/FileNotFoundException
    //   745	792	425	java/io/FileNotFoundException
    //   838	856	425	java/io/FileNotFoundException
    //   861	880	425	java/io/FileNotFoundException
    //   880	927	425	java/io/FileNotFoundException
    //   953	986	425	java/io/FileNotFoundException
    //   986	1034	425	java/io/FileNotFoundException
    //   1037	1056	425	java/io/FileNotFoundException
    //   1061	1079	425	java/io/FileNotFoundException
    //   1079	1086	425	java/io/FileNotFoundException
    //   1112	1131	425	java/io/FileNotFoundException
    //   1136	1154	425	java/io/FileNotFoundException
    //   1154	1160	425	java/io/FileNotFoundException
    //   438	443	452	java/io/IOException
    //   49	56	601	java/io/IOException
    //   61	65	601	java/io/IOException
    //   327	345	601	java/io/IOException
    //   350	422	601	java/io/IOException
    //   468	486	601	java/io/IOException
    //   491	509	601	java/io/IOException
    //   514	537	601	java/io/IOException
    //   537	551	601	java/io/IOException
    //   551	598	601	java/io/IOException
    //   644	653	601	java/io/IOException
    //   660	666	601	java/io/IOException
    //   671	691	601	java/io/IOException
    //   703	721	601	java/io/IOException
    //   726	745	601	java/io/IOException
    //   745	792	601	java/io/IOException
    //   838	856	601	java/io/IOException
    //   861	880	601	java/io/IOException
    //   880	927	601	java/io/IOException
    //   953	986	601	java/io/IOException
    //   986	1034	601	java/io/IOException
    //   1037	1056	601	java/io/IOException
    //   1061	1079	601	java/io/IOException
    //   1079	1086	601	java/io/IOException
    //   1112	1131	601	java/io/IOException
    //   1136	1154	601	java/io/IOException
    //   1154	1160	601	java/io/IOException
    //   614	619	628	java/io/IOException
    //   644	653	656	java/lang/NumberFormatException
    //   671	691	694	java/lang/NumberFormatException
    //   49	56	795	java/lang/NumberFormatException
    //   61	65	795	java/lang/NumberFormatException
    //   327	345	795	java/lang/NumberFormatException
    //   350	422	795	java/lang/NumberFormatException
    //   468	486	795	java/lang/NumberFormatException
    //   491	509	795	java/lang/NumberFormatException
    //   514	537	795	java/lang/NumberFormatException
    //   537	551	795	java/lang/NumberFormatException
    //   551	598	795	java/lang/NumberFormatException
    //   660	666	795	java/lang/NumberFormatException
    //   703	721	795	java/lang/NumberFormatException
    //   726	745	795	java/lang/NumberFormatException
    //   745	792	795	java/lang/NumberFormatException
    //   838	856	795	java/lang/NumberFormatException
    //   861	880	795	java/lang/NumberFormatException
    //   880	927	795	java/lang/NumberFormatException
    //   953	986	795	java/lang/NumberFormatException
    //   986	1034	795	java/lang/NumberFormatException
    //   1037	1056	795	java/lang/NumberFormatException
    //   1061	1079	795	java/lang/NumberFormatException
    //   1112	1131	795	java/lang/NumberFormatException
    //   1136	1154	795	java/lang/NumberFormatException
    //   808	813	822	java/io/IOException
    //   49	56	930	finally
    //   61	65	930	finally
    //   327	345	930	finally
    //   350	422	930	finally
    //   468	486	930	finally
    //   491	509	930	finally
    //   514	537	930	finally
    //   537	551	930	finally
    //   551	598	930	finally
    //   644	653	930	finally
    //   660	666	930	finally
    //   671	691	930	finally
    //   703	721	930	finally
    //   726	745	930	finally
    //   745	792	930	finally
    //   838	856	930	finally
    //   861	880	930	finally
    //   880	927	930	finally
    //   953	986	930	finally
    //   986	1034	930	finally
    //   1037	1056	930	finally
    //   1061	1079	930	finally
    //   1079	1086	930	finally
    //   1112	1131	930	finally
    //   1136	1154	930	finally
    //   1154	1160	930	finally
    //   76	81	1171	java/io/IOException
    //   945	950	1187	java/io/IOException
    //   1079	1086	1352	java/lang/NumberFormatException
    //   1154	1160	1357	java/lang/NumberFormatException
    //   31	49	1362	finally
    //   31	49	1370	java/lang/NumberFormatException
    //   31	49	1378	java/io/IOException
    //   31	49	1386	java/io/FileNotFoundException
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (i == 0) {
        i = e();
      }
      if (jdField_b_of_type_Long == 0L) {
        jdField_b_of_type_Long = c();
      }
    } while ((i <= 1) && (jdField_b_of_type_Long <= 1025000L));
    return false;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if ((jdField_b_of_type_JavaLangString == null) || (jdField_b_of_type_JavaLangString.equals(""))) {
        a();
      }
      int j = jdField_b_of_type_JavaLangString.indexOf(paramString);
      if (j > 0) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  static int b()
  {
    if (jdField_a_of_type_JavaLangString.contains("ARMv6")) {}
    do
    {
      return 2;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
        return 4;
      }
    } while (Build.CPU_ABI.equalsIgnoreCase("armeabi"));
    if ((jdField_a_of_type_Int == 7) && (jdField_b_of_type_JavaLangString.indexOf("neon") < 0))
    {
      long l = c();
      int j = e();
      if ((l < 1100000L) || (j < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    switch (jdField_a_of_type_Int)
    {
    case 6: 
    default: 
      if ((jdField_c_of_type_JavaLangString != null) && ((jdField_c_of_type_JavaLangString.equalsIgnoreCase("AuthenticAMD")) || (jdField_c_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel")))) {
        return 7;
      }
      break;
    case 5: 
      return 1;
    case 7: 
      return 4;
    case 8: 
      return 5;
    }
    return 0;
  }
  
  /* Error */
  static long b()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 10
    //   5: new 86	java/io/BufferedReader
    //   8: dup
    //   9: new 88	java/io/FileReader
    //   12: dup
    //   13: ldc_w 328
    //   16: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 9
    //   24: lload_3
    //   25: lstore_1
    //   26: aload 9
    //   28: ifnull +92 -> 120
    //   31: aload 9
    //   33: astore 7
    //   35: aload 9
    //   37: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 8
    //   42: aload 8
    //   44: ifnull +262 -> 306
    //   47: aload 9
    //   49: astore 7
    //   51: aload 9
    //   53: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 11
    //   58: aload 8
    //   60: astore 10
    //   62: aload 11
    //   64: astore 8
    //   66: goto -24 -> 42
    //   69: lload_3
    //   70: lstore_1
    //   71: iload_0
    //   72: iconst_m1
    //   73: if_icmpeq +47 -> 120
    //   76: aload 9
    //   78: astore 7
    //   80: aload 10
    //   82: iconst_0
    //   83: iload_0
    //   84: invokevirtual 224	java/lang/String:substring	(II)Ljava/lang/String;
    //   87: astore 8
    //   89: lload_3
    //   90: lstore_1
    //   91: aload 8
    //   93: ifnull +27 -> 120
    //   96: lload_3
    //   97: lstore_1
    //   98: aload 9
    //   100: astore 7
    //   102: aload 8
    //   104: invokevirtual 127	java/lang/String:length	()I
    //   107: ifle +13 -> 120
    //   110: aload 9
    //   112: astore 7
    //   114: aload 8
    //   116: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   119: lstore_1
    //   120: lload_1
    //   121: lstore 5
    //   123: aload 9
    //   125: ifnull +11 -> 136
    //   128: aload 9
    //   130: invokevirtual 136	java/io/BufferedReader:close	()V
    //   133: lload_1
    //   134: lstore 5
    //   136: ldc 79
    //   138: new 90	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 330
    //   148: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: lload 5
    //   153: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 164	com/tencent/av/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: lload 5
    //   164: lreturn
    //   165: aload 9
    //   167: astore 7
    //   169: aload 10
    //   171: bipush 9
    //   173: invokevirtual 220	java/lang/String:indexOf	(I)I
    //   176: istore_0
    //   177: goto -108 -> 69
    //   180: astore 7
    //   182: aload 7
    //   184: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   187: lload_1
    //   188: lstore 5
    //   190: goto -54 -> 136
    //   193: astore 10
    //   195: aconst_null
    //   196: astore 8
    //   198: aload 8
    //   200: astore 7
    //   202: ldc 79
    //   204: new 90	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 332
    //   214: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 10
    //   219: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   222: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 337	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   231: pop
    //   232: lload_3
    //   233: lstore 5
    //   235: aload 8
    //   237: ifnull -101 -> 136
    //   240: aload 8
    //   242: invokevirtual 136	java/io/BufferedReader:close	()V
    //   245: lload_3
    //   246: lstore 5
    //   248: goto -112 -> 136
    //   251: astore 7
    //   253: aload 7
    //   255: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   258: lload_3
    //   259: lstore 5
    //   261: goto -125 -> 136
    //   264: astore 8
    //   266: aconst_null
    //   267: astore 7
    //   269: aload 7
    //   271: ifnull +8 -> 279
    //   274: aload 7
    //   276: invokevirtual 136	java/io/BufferedReader:close	()V
    //   279: aload 8
    //   281: athrow
    //   282: astore 7
    //   284: aload 7
    //   286: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   289: goto -10 -> 279
    //   292: astore 8
    //   294: goto -25 -> 269
    //   297: astore 10
    //   299: aload 9
    //   301: astore 8
    //   303: goto -105 -> 198
    //   306: aload 10
    //   308: ifnonnull -143 -> 165
    //   311: iconst_m1
    //   312: istore_0
    //   313: goto -244 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   71	242	0	j	int
    //   25	163	1	l1	long
    //   1	258	3	l2	long
    //   121	139	5	l3	long
    //   33	135	7	localBufferedReader1	java.io.BufferedReader
    //   180	3	7	localIOException1	java.io.IOException
    //   200	1	7	localObject1	Object
    //   251	3	7	localIOException2	java.io.IOException
    //   267	8	7	localObject2	Object
    //   282	3	7	localIOException3	java.io.IOException
    //   40	201	8	localObject3	Object
    //   264	16	8	localObject4	Object
    //   292	1	8	localObject5	Object
    //   301	1	8	localBufferedReader2	java.io.BufferedReader
    //   22	278	9	localBufferedReader3	java.io.BufferedReader
    //   3	167	10	localObject6	Object
    //   193	25	10	localException1	Exception
    //   297	10	10	localException2	Exception
    //   56	7	11	str	String
    // Exception table:
    //   from	to	target	type
    //   128	133	180	java/io/IOException
    //   5	24	193	java/lang/Exception
    //   240	245	251	java/io/IOException
    //   5	24	264	finally
    //   274	279	282	java/io/IOException
    //   35	42	292	finally
    //   51	58	292	finally
    //   80	89	292	finally
    //   102	110	292	finally
    //   114	120	292	finally
    //   169	177	292	finally
    //   202	232	292	finally
    //   35	42	297	java/lang/Exception
    //   51	58	297	java/lang/Exception
    //   80	89	297	java/lang/Exception
    //   102	110	297	java/lang/Exception
    //   114	120	297	java/lang/Exception
    //   169	177	297	java/lang/Exception
  }
  
  public static String b()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  public static boolean b()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 2, "[isSupportSharpVideo] [CpuInfo] mProcessorName=" + jdField_a_of_type_JavaLangString + " \nmCpuArchitecture=" + jdField_a_of_type_Int + " \nmFeature=" + jdField_b_of_type_JavaLangString + " \nmVendorId=" + jdField_c_of_type_JavaLangString + " \nmMaxCpuFreq=" + jdField_a_of_type_Long + " \nmCoreNumber=" + jdField_b_of_type_Int + " \nmOpenGLVersion=" + jdField_c_of_type_Int + " \nmIsMarvell=" + jdField_d_of_type_Boolean + " \nChip=" + jdField_d_of_type_Int + ", Video=" + jdField_c_of_type_Boolean + ", Audio=" + jdField_b_of_type_Boolean + " \ndevModel=" + Build.MODEL + " \ndevVersion=" + Build.VERSION.INCREMENTAL + " \ndevManufacturer=" + Build.MANUFACTURER + " \nsdkVersion=" + Build.VERSION.SDK_INT + " \n");
    }
    return true;
  }
  
  public static long c()
  {
    EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
    int k = 0;
    int j = k;
    if (localEffectFaceDeviceConfig != null) {}
    try
    {
      j = localEffectFaceDeviceConfig.a();
      if (j == 0)
      {
        a();
        AVLog.c("VcSystemInfo", "getMaxCpuFreq: " + Build.BRAND + "|" + Build.MODEL + "|" + jdField_a_of_type_Long);
        return jdField_a_of_type_Long;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        j = k;
        continue;
        jdField_a_of_type_Long = j;
      }
    }
  }
  
  public static String c()
  {
    a();
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean c()
  {
    return true;
  }
  
  public static String d()
  {
    a();
    return "prcs(" + jdField_a_of_type_JavaLangString + ") arch(" + jdField_a_of_type_Int + ") hard(" + jdField_d_of_type_JavaLangString + ") chip(" + jdField_d_of_type_Int + ") freq(" + jdField_a_of_type_Long + ") num(" + jdField_b_of_type_Int + ")";
  }
  
  public static boolean d()
  {
    if (jdField_d_of_type_Int > 2) {}
    BaseApplication localBaseApplication;
    do
    {
      return true;
      localBaseApplication = BaseApplicationImpl.getContext();
    } while (UpdateAvSo.a(localBaseApplication));
    if (QLog.isColorLevel()) {
      QLog.w("VcSystemInfo", 2, "EarlyDownload libs is not ready for armv6/armv5 device");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.downloadAvSo");
    localIntent.setPackage(localBaseApplication.getPackageName());
    localBaseApplication.sendBroadcast(localIntent);
    return false;
  }
  
  public static int e()
  {
    a();
    return jdField_b_of_type_Int;
  }
  
  public static String e()
  {
    a();
    return "model(" + Build.MODEL + ") Mnfc(" + Build.MANUFACTURER + ") dev(" + Build.VERSION.INCREMENTAL + ") sdk(" + Build.VERSION.SDK_INT + ") gl(" + jdField_c_of_type_Int + ")";
  }
  
  public static boolean e()
  {
    return ((a("neon")) || (a("asimd"))) && (e() >= 2) && (f() >= 4);
  }
  
  public static int f()
  {
    a();
    return jdField_d_of_type_Int;
  }
  
  public static boolean f()
  {
    a();
    return (jdField_d_of_type_Int >= 3) && (jdField_a_of_type_Long / 1000L >= 800L) && (Build.VERSION.SDK_INT >= 9);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public int c()
  {
    return 2;
  }
  
  public int d()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        int k = str.charAt(0);
        int m = str.charAt(2);
        int j = 0;
        if (str.length() >= 5) {
          j = str.charAt(4);
        }
        switch (k)
        {
        default: 
          return 200;
        case 49: 
          if (m == 49) {
            return 101;
          }
          if (m == 53) {
            return 102;
          }
          if (m == 54) {
            return 103;
          }
          break;
        case 50: 
          if (m == 48)
          {
            if (j == 49) {
              return 105;
            }
            return 104;
          }
          if (m == 49) {
            return 106;
          }
          if (m == 50)
          {
            if (j == 49) {
              return 108;
            }
            return 107;
          }
          if ((m == 51) && (j >= 48) && (j <= 57)) {
            return 109;
          }
          break;
        case 51: 
          if (m == 48) {
            return 110;
          }
          if (m == 49) {
            return 111;
          }
          if (m == 50) {
            return 112;
          }
          break;
        case 52: 
          if (m == 48) {
            return 113;
          }
          if (m == 49) {
            return 114;
          }
          if (m == 50) {
            return 115;
          }
          if (m == 51) {
            return 116;
          }
          if (m == 52) {
            return 117;
          }
          break;
        case 53: 
          if (m == 48) {
            return 118;
          }
          break;
        }
      }
    }
    catch (Exception localException) {}
    return 200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.core.VcSystemInfo
 * JD-Core Version:    0.7.0.1
 */