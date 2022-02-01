import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/misc/VasProfileTemplatePreloadHelper;", "", "()V", "BACKGROUND", "", "BODY", "HEADER", "TAG", "TITLE_STYLE", "URL_PREFIX", "initDiyData", "", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class baec
{
  public static final baec a = new baec();
  
  /* Error */
  public final boolean a(@org.jetbrains.annotations.NotNull azrb paramazrb)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 45
    //   3: invokestatic 51	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: aconst_null
    //   8: checkcast 53	bacz
    //   11: putfield 58	azrb:jdField_a_of_type_Bacz	Lbacz;
    //   14: aload_1
    //   15: getfield 61	azrb:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   18: getfield 67	com/tencent/mobileqq/data/Card:diyComplicatedInfo	Ljava/lang/String;
    //   21: astore 4
    //   23: aload 4
    //   25: checkcast 69	java/lang/CharSequence
    //   28: astore 5
    //   30: aload 5
    //   32: ifnull +13 -> 45
    //   35: aload 5
    //   37: invokeinterface 73 1 0
    //   42: ifne +19 -> 61
    //   45: iconst_1
    //   46: istore_2
    //   47: iload_2
    //   48: ifeq +18 -> 66
    //   51: ldc 75
    //   53: iconst_1
    //   54: ldc 77
    //   56: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_0
    //   60: ireturn
    //   61: iconst_0
    //   62: istore_2
    //   63: goto -16 -> 47
    //   66: new 85	org/json/JSONObject
    //   69: dup
    //   70: aload 4
    //   72: invokespecial 88	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   75: astore 8
    //   77: aload 8
    //   79: ldc 90
    //   81: ldc 91
    //   83: invokevirtual 95	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 4
    //   88: aload 8
    //   90: ldc 97
    //   92: invokevirtual 101	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   95: astore 5
    //   97: aload 5
    //   99: ifnull +81 -> 180
    //   102: aload 8
    //   104: ldc 103
    //   106: invokevirtual 101	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   109: astore 6
    //   111: aload 6
    //   113: ifnull +113 -> 226
    //   116: aload 8
    //   118: ldc 105
    //   120: invokevirtual 109	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   123: astore 7
    //   125: aload 7
    //   127: ifnull +130 -> 257
    //   130: aload 7
    //   132: ldc 111
    //   134: invokevirtual 114	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokestatic 120	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   140: istore_2
    //   141: aload 7
    //   143: ldc 122
    //   145: iconst_0
    //   146: invokevirtual 126	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   149: istore_3
    //   150: aload 4
    //   152: ldc 128
    //   154: invokestatic 131	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   157: aload_1
    //   158: new 53	bacz
    //   161: dup
    //   162: aload 4
    //   164: iload_3
    //   165: iload_2
    //   166: aload 6
    //   168: aload 7
    //   170: aload 5
    //   172: invokespecial 134	bacz:<init>	(Ljava/lang/String;IILjava/lang/Object;Lorg/json/JSONObject;Ljava/lang/Object;)V
    //   175: putfield 58	azrb:jdField_a_of_type_Bacz	Lbacz;
    //   178: iconst_1
    //   179: ireturn
    //   180: new 136	org/json/JSONException
    //   183: dup
    //   184: new 138	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   191: ldc 141
    //   193: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 8
    //   198: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokespecial 153	org/json/JSONException:<init>	(Ljava/lang/String;)V
    //   207: checkcast 155	java/lang/Throwable
    //   210: athrow
    //   211: astore_1
    //   212: ldc 75
    //   214: iconst_1
    //   215: ldc 77
    //   217: aload_1
    //   218: checkcast 155	java/lang/Throwable
    //   221: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: iconst_0
    //   225: ireturn
    //   226: new 136	org/json/JSONException
    //   229: dup
    //   230: new 138	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   237: ldc 160
    //   239: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 8
    //   244: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokespecial 153	org/json/JSONException:<init>	(Ljava/lang/String;)V
    //   253: checkcast 155	java/lang/Throwable
    //   256: athrow
    //   257: new 136	org/json/JSONException
    //   260: dup
    //   261: new 138	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   268: ldc 162
    //   270: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 8
    //   275: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokespecial 153	org/json/JSONException:<init>	(Ljava/lang/String;)V
    //   284: checkcast 155	java/lang/Throwable
    //   287: athrow
    //   288: astore 8
    //   290: ldc 163
    //   292: istore_2
    //   293: goto -152 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	baec
    //   0	296	1	paramazrb	azrb
    //   46	247	2	i	int
    //   149	16	3	j	int
    //   21	142	4	str	java.lang.String
    //   28	143	5	localObject1	Object
    //   109	58	6	localObject2	Object
    //   123	46	7	localJSONObject1	org.json.JSONObject
    //   75	199	8	localJSONObject2	org.json.JSONObject
    //   288	1	8	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   66	97	211	java/lang/Exception
    //   102	111	211	java/lang/Exception
    //   116	125	211	java/lang/Exception
    //   130	141	211	java/lang/Exception
    //   141	178	211	java/lang/Exception
    //   180	211	211	java/lang/Exception
    //   226	257	211	java/lang/Exception
    //   257	288	211	java/lang/Exception
    //   130	141	288	java/lang/IllegalArgumentException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baec
 * JD-Core Version:    0.7.0.1
 */