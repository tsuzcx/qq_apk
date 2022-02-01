import android.support.annotation.NonNull;

public class bnbz
  extends bnec
{
  public bnbz(@NonNull bnee parambnee)
  {
    super(parambnee);
  }
  
  /* Error */
  public void a(int paramInt, @NonNull bnot parambnot)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_2
    //   3: invokespecial 17	bnec:a	(ILbnot;)V
    //   6: invokestatic 22	bnub:a	()Lbnub;
    //   9: invokevirtual 26	bnub:c	()I
    //   12: istore_3
    //   13: iload_3
    //   14: ifgt +4 -> 18
    //   17: return
    //   18: invokestatic 22	bnub:a	()Lbnub;
    //   21: iload_3
    //   22: invokevirtual 29	bnub:a	(I)Ldov/com/qq/im/capture/data/QIMFilterCategoryItem;
    //   25: astore 6
    //   27: invokestatic 22	bnub:a	()Lbnub;
    //   30: iload_3
    //   31: invokevirtual 32	bnub:b	(I)Ldov/com/qq/im/capture/data/QIMFilterCategoryItem;
    //   34: astore 7
    //   36: invokestatic 37	bmql:a	()Lbmql;
    //   39: bipush 8
    //   41: invokevirtual 40	bmql:c	(I)Lbmqj;
    //   44: checkcast 42	bmtm
    //   47: invokevirtual 45	bmtm:a	()Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   50: astore 5
    //   52: new 47	org/json/JSONObject
    //   55: dup
    //   56: invokespecial 50	org/json/JSONObject:<init>	()V
    //   59: astore 4
    //   61: aload 6
    //   63: ifnull +97 -> 160
    //   66: aload_2
    //   67: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   70: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   73: ifnonnull +17 -> 90
    //   76: aload_2
    //   77: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   80: new 63	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo
    //   83: dup
    //   84: invokespecial 64	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:<init>	()V
    //   87: putfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   90: aload_2
    //   91: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   94: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   97: aload 6
    //   99: getfield 69	dov/com/qq/im/capture/data/QIMFilterCategoryItem:a	Ljava/lang/String;
    //   102: putfield 72	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:id	Ljava/lang/String;
    //   105: aload_2
    //   106: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   109: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   112: aload 6
    //   114: getfield 75	dov/com/qq/im/capture/data/QIMFilterCategoryItem:f	Ljava/lang/String;
    //   117: putfield 78	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:type	Ljava/lang/String;
    //   120: aload 6
    //   122: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   125: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne +210 -> 338
    //   131: aload 4
    //   133: getstatic 91	wfh:B	Ljava/lang/String;
    //   136: aload 6
    //   138: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   141: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   144: pop
    //   145: aload_2
    //   146: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   149: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   152: aload 6
    //   154: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   157: putfield 98	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:name	Ljava/lang/String;
    //   160: aload 7
    //   162: ifnull +105 -> 267
    //   165: aload 7
    //   167: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   170: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifne +94 -> 267
    //   176: aload 7
    //   178: invokevirtual 101	dov/com/qq/im/capture/data/QIMFilterCategoryItem:c	()Z
    //   181: ifne +86 -> 267
    //   184: aload_2
    //   185: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   188: getfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   191: ifnonnull +17 -> 208
    //   194: aload_2
    //   195: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   198: new 107	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter
    //   201: dup
    //   202: invokespecial 108	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter:<init>	()V
    //   205: putfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   208: aload_2
    //   209: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   212: getfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   215: aload 7
    //   217: getfield 69	dov/com/qq/im/capture/data/QIMFilterCategoryItem:a	Ljava/lang/String;
    //   220: putfield 109	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter:id	Ljava/lang/String;
    //   223: aload_2
    //   224: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   227: getfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   230: aload 7
    //   232: getfield 75	dov/com/qq/im/capture/data/QIMFilterCategoryItem:f	Ljava/lang/String;
    //   235: putfield 112	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter:typeId	Ljava/lang/String;
    //   238: aload_2
    //   239: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   242: getfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   245: aload 7
    //   247: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   250: putfield 113	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter:name	Ljava/lang/String;
    //   253: aload 4
    //   255: getstatic 116	wfh:z	Ljava/lang/String;
    //   258: aload 7
    //   260: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   263: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload 5
    //   269: ifnull +28 -> 297
    //   272: aload 5
    //   274: getfield 121	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mMusicName	Ljava/lang/String;
    //   277: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifne +17 -> 297
    //   283: aload 4
    //   285: getstatic 124	wfh:A	Ljava/lang/String;
    //   288: aload 5
    //   290: getfield 121	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mMusicName	Ljava/lang/String;
    //   293: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   296: pop
    //   297: aload_0
    //   298: ldc 126
    //   300: invokevirtual 129	bnbz:a	(Ljava/lang/Class;)Lbned;
    //   303: checkcast 126	bnca
    //   306: astore 5
    //   308: aload 5
    //   310: ifnull +13 -> 323
    //   313: aload 5
    //   315: invokeinterface 132 1 0
    //   320: ifnonnull +61 -> 381
    //   323: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -309 -> 17
    //   329: ldc 139
    //   331: iconst_2
    //   332: ldc 141
    //   334: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: return
    //   338: aload 6
    //   340: getfield 148	dov/com/qq/im/capture/data/QIMFilterCategoryItem:e	Ljava/lang/String;
    //   343: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   346: ifne -186 -> 160
    //   349: aload 4
    //   351: getstatic 91	wfh:B	Ljava/lang/String;
    //   354: aload 6
    //   356: getfield 148	dov/com/qq/im/capture/data/QIMFilterCategoryItem:e	Ljava/lang/String;
    //   359: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   362: pop
    //   363: aload_2
    //   364: getfield 55	bnot:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   367: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   370: aload 6
    //   372: getfield 148	dov/com/qq/im/capture/data/QIMFilterCategoryItem:e	Ljava/lang/String;
    //   375: putfield 98	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:name	Ljava/lang/String;
    //   378: goto -218 -> 160
    //   381: aload 5
    //   383: invokeinterface 132 1 0
    //   388: invokevirtual 153	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	()Lbnfz;
    //   391: astore 6
    //   393: ldc 155
    //   395: getstatic 158	bmqu:b	Ljava/lang/String;
    //   398: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   401: ifeq +16 -> 417
    //   404: aload 6
    //   406: ifnull +25 -> 431
    //   409: aload 6
    //   411: invokevirtual 168	bnfz:a	()Z
    //   414: ifne +17 -> 431
    //   417: aload 4
    //   419: getstatic 171	wfh:y	Ljava/lang/String;
    //   422: ldc 172
    //   424: invokestatic 177	amtj:a	(I)Ljava/lang/String;
    //   427: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   430: pop
    //   431: aload 5
    //   433: invokeinterface 132 1 0
    //   438: iload_1
    //   439: invokevirtual 178	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(I)Ljava/lang/String;
    //   442: astore 5
    //   444: aload 5
    //   446: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne +14 -> 463
    //   452: aload 4
    //   454: getstatic 181	wfh:x	Ljava/lang/String;
    //   457: aload 5
    //   459: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   462: pop
    //   463: aload 4
    //   465: invokevirtual 185	org/json/JSONObject:toString	()Ljava/lang/String;
    //   468: astore 4
    //   470: ldc 139
    //   472: ldc 187
    //   474: aload 4
    //   476: invokestatic 192	xvv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   479: aload_2
    //   480: getfield 195	bnot:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   483: ldc 197
    //   485: aload 4
    //   487: invokevirtual 203	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   490: pop
    //   491: return
    //   492: astore 5
    //   494: goto -31 -> 463
    //   497: astore 6
    //   499: goto -68 -> 431
    //   502: astore 5
    //   504: goto -207 -> 297
    //   507: astore 6
    //   509: goto -242 -> 267
    //   512: astore 8
    //   514: goto -151 -> 363
    //   517: astore 8
    //   519: goto -374 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	this	bnbz
    //   0	522	1	paramInt	int
    //   0	522	2	parambnot	bnot
    //   12	19	3	i	int
    //   59	427	4	localObject1	java.lang.Object
    //   50	408	5	localObject2	java.lang.Object
    //   492	1	5	localJSONException1	org.json.JSONException
    //   502	1	5	localJSONException2	org.json.JSONException
    //   25	385	6	localObject3	java.lang.Object
    //   497	1	6	localJSONException3	org.json.JSONException
    //   507	1	6	localJSONException4	org.json.JSONException
    //   34	225	7	localQIMFilterCategoryItem	dov.com.qq.im.capture.data.QIMFilterCategoryItem
    //   512	1	8	localJSONException5	org.json.JSONException
    //   517	1	8	localJSONException6	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   452	463	492	org/json/JSONException
    //   417	431	497	org/json/JSONException
    //   283	297	502	org/json/JSONException
    //   253	267	507	org/json/JSONException
    //   349	363	512	org/json/JSONException
    //   131	145	517	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbz
 * JD-Core Version:    0.7.0.1
 */