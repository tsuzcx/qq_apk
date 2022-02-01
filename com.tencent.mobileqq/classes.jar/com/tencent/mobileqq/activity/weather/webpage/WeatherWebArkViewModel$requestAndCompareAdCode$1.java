package com.tencent.mobileqq.activity.weather.webpage;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "onLocationFinish", "", "errCode", "", "info", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebArkViewModel$requestAndCompareAdCode$1
  extends LbsManagerServiceOnLocationChangeListener
{
  WeatherWebArkViewModel$requestAndCompareAdCode$1(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramBoolean, bool);
  }
  
  /* Error */
  public void onLocationFinish(int paramInt, @org.jetbrains.annotations.Nullable com.tencent.mobileqq.soso.location.data.SosoLbsInfo paramSosoLbsInfo)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +271 -> 272
    //   4: aload_2
    //   5: ifnull +267 -> 272
    //   8: aload_2
    //   9: getfield 47	com/tencent/mobileqq/soso/location/data/SosoLbsInfo:mLocation	Lcom/tencent/mobileqq/soso/location/data/SosoLocation;
    //   12: ifnull +260 -> 272
    //   15: aload_2
    //   16: getfield 47	com/tencent/mobileqq/soso/location/data/SosoLbsInfo:mLocation	Lcom/tencent/mobileqq/soso/location/data/SosoLocation;
    //   19: getfield 52	com/tencent/mobileqq/soso/location/data/SosoLocation:cityCode	Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: ldc 54
    //   26: invokestatic 60	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 31	com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: checkcast 62	java/lang/CharSequence
    //   36: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifeq +39 -> 78
    //   42: aload_2
    //   43: checkcast 62	java/lang/CharSequence
    //   46: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +29 -> 78
    //   52: aload_0
    //   53: getfield 29	com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1:jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel	Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;
    //   56: invokevirtual 73	com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel:a	()Landroidx/lifecycle/MutableLiveData;
    //   59: new 75	com/tencent/mobileqq/activity/weather/webpage/WebPageData
    //   62: dup
    //   63: iconst_3
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_0
    //   68: iconst_0
    //   69: bipush 62
    //   71: aconst_null
    //   72: invokespecial 78	com/tencent/mobileqq/activity/weather/webpage/WebPageData:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   75: invokevirtual 84	androidx/lifecycle/MutableLiveData:postValue	(Ljava/lang/Object;)V
    //   78: aload_2
    //   79: checkcast 62	java/lang/CharSequence
    //   82: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +122 -> 207
    //   88: aload_2
    //   89: checkcast 62	java/lang/CharSequence
    //   92: aload_0
    //   93: getfield 31	com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: checkcast 62	java/lang/CharSequence
    //   99: invokestatic 88	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   102: ifne +105 -> 207
    //   105: new 90	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 93	org/json/JSONObject:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: ldc 95
    //   116: iconst_2
    //   117: invokevirtual 99	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   120: pop
    //   121: new 90	org/json/JSONObject
    //   124: dup
    //   125: invokespecial 93	org/json/JSONObject:<init>	()V
    //   128: astore 4
    //   130: aload 4
    //   132: ldc 101
    //   134: aload_2
    //   135: invokevirtual 104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload_3
    //   140: ldc 106
    //   142: aload 4
    //   144: invokevirtual 104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_0
    //   149: getfield 29	com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1:jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel	Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;
    //   152: invokevirtual 73	com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel:a	()Landroidx/lifecycle/MutableLiveData;
    //   155: astore 4
    //   157: aload_3
    //   158: invokevirtual 110	org/json/JSONObject:toString	()Ljava/lang/String;
    //   161: astore 5
    //   163: aload 5
    //   165: ldc 112
    //   167: invokestatic 60	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   170: aload 4
    //   172: new 75	com/tencent/mobileqq/activity/weather/webpage/WebPageData
    //   175: dup
    //   176: iconst_0
    //   177: ldc 114
    //   179: aload 5
    //   181: aconst_null
    //   182: iconst_0
    //   183: iconst_0
    //   184: bipush 56
    //   186: aconst_null
    //   187: invokespecial 78	com/tencent/mobileqq/activity/weather/webpage/WebPageData:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   190: invokevirtual 84	androidx/lifecycle/MutableLiveData:postValue	(Ljava/lang/Object;)V
    //   193: ldc 116
    //   195: ldc 118
    //   197: aload_3
    //   198: invokevirtual 110	org/json/JSONObject:toString	()Ljava/lang/String;
    //   201: ldc 120
    //   203: invokestatic 126	com/tencent/ark/ark:arkNotify	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   206: pop
    //   207: ldc 128
    //   209: iconst_1
    //   210: new 130	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   217: ldc 133
    //   219: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload_1
    //   223: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc 142
    //   228: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 144
    //   237: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: getfield 31	com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   244: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: return
    //   254: astore_2
    //   255: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +14 -> 272
    //   261: ldc 128
    //   263: iconst_2
    //   264: aload_2
    //   265: iconst_0
    //   266: anewarray 157	java/lang/Object
    //   269: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   272: ldc 162
    //   274: astore_2
    //   275: goto -246 -> 29
    //   278: astore_3
    //   279: ldc 128
    //   281: iconst_1
    //   282: ldc 164
    //   284: aload_3
    //   285: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: goto -81 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	1
    //   0	291	1	paramInt	int
    //   0	291	2	paramSosoLbsInfo	com.tencent.mobileqq.soso.location.data.SosoLbsInfo
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebArkViewModel.requestAndCompareAdCode.1
 * JD-Core Version:    0.7.0.1
 */