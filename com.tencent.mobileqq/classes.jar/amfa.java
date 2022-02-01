import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1", "Lcom/tencent/mobileqq/app/soso/LbsManagerService$OnLocationChangeListener;", "onLocationFinish", "", "errCode", "", "info", "Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amfa
  extends LbsManagerService.OnLocationChangeListener
{
  amfa(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramBoolean, bool);
  }
  
  /* Error */
  public void onLocationFinish(int paramInt, @org.jetbrains.annotations.Nullable com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +271 -> 272
    //   4: aload_2
    //   5: ifnull +267 -> 272
    //   8: aload_2
    //   9: getfield 48	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:mLocation	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   12: ifnull +260 -> 272
    //   15: aload_2
    //   16: getfield 48	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:mLocation	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   19: getfield 53	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation:cityCode	Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: ldc 55
    //   26: invokestatic 61	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 32	amfa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: checkcast 63	java/lang/CharSequence
    //   36: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifeq +39 -> 78
    //   42: aload_2
    //   43: checkcast 63	java/lang/CharSequence
    //   46: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +29 -> 78
    //   52: aload_0
    //   53: getfield 30	amfa:jdField_a_of_type_Amex	Lamex;
    //   56: invokevirtual 74	amex:a	()Landroid/arch/lifecycle/MutableLiveData;
    //   59: new 76	amfe
    //   62: dup
    //   63: iconst_3
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_0
    //   68: iconst_0
    //   69: bipush 62
    //   71: aconst_null
    //   72: invokespecial 79	amfe:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   75: invokevirtual 85	android/arch/lifecycle/MutableLiveData:postValue	(Ljava/lang/Object;)V
    //   78: aload_2
    //   79: checkcast 63	java/lang/CharSequence
    //   82: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +122 -> 207
    //   88: aload_2
    //   89: checkcast 63	java/lang/CharSequence
    //   92: aload_0
    //   93: getfield 32	amfa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: checkcast 63	java/lang/CharSequence
    //   99: invokestatic 89	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   102: ifne +105 -> 207
    //   105: new 91	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 94	org/json/JSONObject:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: ldc 96
    //   116: iconst_2
    //   117: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   120: pop
    //   121: new 91	org/json/JSONObject
    //   124: dup
    //   125: invokespecial 94	org/json/JSONObject:<init>	()V
    //   128: astore 4
    //   130: aload 4
    //   132: ldc 102
    //   134: aload_2
    //   135: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload_3
    //   140: ldc 107
    //   142: aload 4
    //   144: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_0
    //   149: getfield 30	amfa:jdField_a_of_type_Amex	Lamex;
    //   152: invokevirtual 74	amex:a	()Landroid/arch/lifecycle/MutableLiveData;
    //   155: astore 4
    //   157: aload_3
    //   158: invokevirtual 111	org/json/JSONObject:toString	()Ljava/lang/String;
    //   161: astore 5
    //   163: aload 5
    //   165: ldc 113
    //   167: invokestatic 61	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   170: aload 4
    //   172: new 76	amfe
    //   175: dup
    //   176: iconst_0
    //   177: ldc 115
    //   179: aload 5
    //   181: aconst_null
    //   182: iconst_0
    //   183: iconst_0
    //   184: bipush 56
    //   186: aconst_null
    //   187: invokespecial 79	amfe:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   190: invokevirtual 85	android/arch/lifecycle/MutableLiveData:postValue	(Ljava/lang/Object;)V
    //   193: ldc 117
    //   195: ldc 119
    //   197: aload_3
    //   198: invokevirtual 111	org/json/JSONObject:toString	()Ljava/lang/String;
    //   201: ldc 121
    //   203: invokestatic 127	com/tencent/ark/ark:arkNotify	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   206: pop
    //   207: ldc 129
    //   209: iconst_1
    //   210: new 131	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   217: ldc 134
    //   219: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload_1
    //   223: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc 143
    //   228: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 145
    //   237: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: getfield 32	amfa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   244: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: return
    //   254: astore_2
    //   255: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +14 -> 272
    //   261: ldc 129
    //   263: iconst_2
    //   264: aload_2
    //   265: iconst_0
    //   266: anewarray 158	java/lang/Object
    //   269: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   272: ldc 163
    //   274: astore_2
    //   275: goto -246 -> 29
    //   278: astore_3
    //   279: ldc 129
    //   281: iconst_1
    //   282: ldc 165
    //   284: aload_3
    //   285: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: goto -81 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	amfa
    //   0	291	1	paramInt	int
    //   0	291	2	paramSosoLbsInfo	com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo
    //   112	86	3	localJSONObject	org.json.JSONObject
    //   278	7	3	localThrowable	java.lang.Throwable
    //   128	43	4	localObject	java.lang.Object
    //   161	19	5	str	String
    // Exception table:
    //   from	to	target	type
    //   15	29	254	java/lang/Throwable
    //   193	207	278	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfa
 * JD-Core Version:    0.7.0.1
 */