package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.av.opengl.utils.IntArray;
import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloResHelperImpl
  implements IApolloResHelper
{
  public static final int[] DEFAULT_DRESSIDS_ROLE0 = { 1, 2, 3, 4, 5, 6, 7 };
  public static final int[] DEFAULT_DRESSIDS_ROLE1 = { 53, 54, 55, 56, 86, 87, 88 };
  public static final int[] DEFAULT_DRESSIDS_ROLE2 = { 91, 90, 63, 64, 65, 102, 103 };
  public static final int[] DEFAULT_DRESSIDS_ROLE3000055 = { 3000536, 3000421, 3000436, 3000420, 3000438, 3000593, 3000432, 3000674 };
  private static final String TAG = "[cmshow]ApolloResHelperImpl";
  public static ConcurrentHashMap<Integer, IntArray> sRoleDefaultDress = new ConcurrentHashMap();
  
  /* Error */
  public int[] readRoleDefaultDressIds(int paramInt)
  {
    // Byte code:
    //   0: getstatic 43	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:sRoleDefaultDress	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: iload_1
    //   4: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: invokevirtual 61	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: istore 4
    //   12: aconst_null
    //   13: astore 6
    //   15: iload 4
    //   17: ifeq +32 -> 49
    //   20: getstatic 43	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:sRoleDefaultDress	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: iload_1
    //   24: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 65	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 67	com/tencent/av/opengl/utils/IntArray
    //   33: astore 5
    //   35: aload 5
    //   37: ifnonnull +5 -> 42
    //   40: aconst_null
    //   41: areturn
    //   42: aload 5
    //   44: aconst_null
    //   45: invokevirtual 71	com/tencent/av/opengl/utils/IntArray:a	([I)[I
    //   48: areturn
    //   49: getstatic 76	com/tencent/mobileqq/cmshow/engine/resource/ApolloResManagerFacade:a	Lcom/tencent/mobileqq/cmshow/engine/resource/ApolloResManagerFacade;
    //   52: iload_1
    //   53: invokevirtual 79	com/tencent/mobileqq/cmshow/engine/resource/ApolloResManagerFacade:a	(I)Ljava/io/File;
    //   56: astore 7
    //   58: aload 6
    //   60: astore 5
    //   62: aload 7
    //   64: invokevirtual 85	java/io/File:exists	()Z
    //   67: ifeq +104 -> 171
    //   70: new 87	org/json/JSONObject
    //   73: dup
    //   74: aload 7
    //   76: invokestatic 93	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   79: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   82: ldc 98
    //   84: invokevirtual 102	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   87: astore 7
    //   89: aload 6
    //   91: astore 5
    //   93: aload 7
    //   95: ifnull +76 -> 171
    //   98: aload 6
    //   100: astore 5
    //   102: aload 7
    //   104: invokevirtual 108	org/json/JSONArray:length	()I
    //   107: ifle +64 -> 171
    //   110: aload 7
    //   112: invokevirtual 108	org/json/JSONArray:length	()I
    //   115: istore_3
    //   116: new 67	com/tencent/av/opengl/utils/IntArray
    //   119: dup
    //   120: invokespecial 109	com/tencent/av/opengl/utils/IntArray:<init>	()V
    //   123: astore 5
    //   125: iconst_0
    //   126: istore_2
    //   127: iload_2
    //   128: iload_3
    //   129: if_icmpge +21 -> 150
    //   132: aload 5
    //   134: aload 7
    //   136: iload_2
    //   137: invokevirtual 113	org/json/JSONArray:optInt	(I)I
    //   140: invokevirtual 116	com/tencent/av/opengl/utils/IntArray:a	(I)V
    //   143: iload_2
    //   144: iconst_1
    //   145: iadd
    //   146: istore_2
    //   147: goto -20 -> 127
    //   150: getstatic 43	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:sRoleDefaultDress	Ljava/util/concurrent/ConcurrentHashMap;
    //   153: iload_1
    //   154: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aload 5
    //   159: invokevirtual 120	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: aload 5
    //   165: aconst_null
    //   166: invokevirtual 71	com/tencent/av/opengl/utils/IntArray:a	([I)[I
    //   169: astore 5
    //   171: aload 5
    //   173: ifnull +9 -> 182
    //   176: aload 5
    //   178: arraylength
    //   179: ifne +123 -> 302
    //   182: iload_1
    //   183: ldc 121
    //   185: if_icmpne +7 -> 192
    //   188: getstatic 36	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:DEFAULT_DRESSIDS_ROLE3000055	[I
    //   191: areturn
    //   192: iload_1
    //   193: iconst_1
    //   194: if_icmpne +7 -> 201
    //   197: getstatic 24	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:DEFAULT_DRESSIDS_ROLE1	[I
    //   200: areturn
    //   201: iload_1
    //   202: iconst_2
    //   203: if_icmpne +7 -> 210
    //   206: getstatic 26	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:DEFAULT_DRESSIDS_ROLE2	[I
    //   209: areturn
    //   210: getstatic 22	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:DEFAULT_DRESSIDS_ROLE0	[I
    //   213: areturn
    //   214: astore 5
    //   216: goto +89 -> 305
    //   219: ldc 15
    //   221: iconst_1
    //   222: ldc 123
    //   224: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iload_1
    //   228: ldc 121
    //   230: if_icmpne +134 -> 364
    //   233: goto -45 -> 188
    //   236: astore 5
    //   238: new 131	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   245: astore 6
    //   247: aload 6
    //   249: ldc 134
    //   251: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 6
    //   257: aload 5
    //   259: invokevirtual 142	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   262: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: ldc 15
    //   268: iconst_1
    //   269: aload 6
    //   271: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: iload_1
    //   278: ldc 121
    //   280: if_icmpne +6 -> 286
    //   283: goto -95 -> 188
    //   286: iload_1
    //   287: iconst_1
    //   288: if_icmpne +6 -> 294
    //   291: goto -94 -> 197
    //   294: iload_1
    //   295: iconst_2
    //   296: if_icmpne -86 -> 210
    //   299: goto -93 -> 206
    //   302: aload 5
    //   304: areturn
    //   305: iload_1
    //   306: ldc 121
    //   308: if_icmpeq +37 -> 345
    //   311: iload_1
    //   312: iconst_1
    //   313: if_icmpeq +24 -> 337
    //   316: iload_1
    //   317: iconst_2
    //   318: if_icmpne +11 -> 329
    //   321: getstatic 26	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:DEFAULT_DRESSIDS_ROLE2	[I
    //   324: astore 6
    //   326: goto +24 -> 350
    //   329: getstatic 22	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:DEFAULT_DRESSIDS_ROLE0	[I
    //   332: astore 6
    //   334: goto +16 -> 350
    //   337: getstatic 24	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:DEFAULT_DRESSIDS_ROLE1	[I
    //   340: astore 6
    //   342: goto +8 -> 350
    //   345: getstatic 36	com/tencent/mobileqq/apollo/res/api/impl/ApolloResHelperImpl:DEFAULT_DRESSIDS_ROLE3000055	[I
    //   348: astore 6
    //   350: goto +6 -> 356
    //   353: aload 5
    //   355: athrow
    //   356: goto -3 -> 353
    //   359: astore 5
    //   361: goto -142 -> 219
    //   364: iload_1
    //   365: iconst_1
    //   366: if_icmpne +6 -> 372
    //   369: goto -172 -> 197
    //   372: iload_1
    //   373: iconst_2
    //   374: if_icmpne -164 -> 210
    //   377: goto -171 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	ApolloResHelperImpl
    //   0	380	1	paramInt	int
    //   126	21	2	i	int
    //   115	15	3	j	int
    //   10	6	4	bool	boolean
    //   33	144	5	localObject1	Object
    //   214	1	5	localObject2	Object
    //   236	118	5	localException	java.lang.Exception
    //   359	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   13	336	6	localObject3	Object
    //   56	79	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   49	58	214	finally
    //   62	89	214	finally
    //   102	125	214	finally
    //   132	143	214	finally
    //   150	171	214	finally
    //   219	227	214	finally
    //   238	277	214	finally
    //   49	58	236	java/lang/Exception
    //   62	89	236	java/lang/Exception
    //   102	125	236	java/lang/Exception
    //   132	143	236	java/lang/Exception
    //   150	171	236	java/lang/Exception
    //   49	58	359	java/lang/OutOfMemoryError
    //   62	89	359	java/lang/OutOfMemoryError
    //   102	125	359	java/lang/OutOfMemoryError
    //   132	143	359	java/lang/OutOfMemoryError
    //   150	171	359	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResHelperImpl
 * JD-Core Version:    0.7.0.1
 */