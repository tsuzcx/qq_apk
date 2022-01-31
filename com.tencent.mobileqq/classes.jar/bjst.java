import android.support.annotation.NonNull;

public class bjst
  extends bjxl
{
  public bjst(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  /* Error */
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_2
    //   3: invokespecial 17	bjxl:a	(ILbkld;)V
    //   6: invokestatic 22	bkrf:a	()Lbkrf;
    //   9: invokestatic 22	bkrf:a	()Lbkrf;
    //   12: invokevirtual 26	bkrf:c	()I
    //   15: invokevirtual 29	bkrf:a	(I)Ldov/com/qq/im/capture/data/QIMFilterCategoryItem;
    //   18: astore 5
    //   20: invokestatic 22	bkrf:a	()Lbkrf;
    //   23: invokestatic 22	bkrf:a	()Lbkrf;
    //   26: invokevirtual 26	bkrf:c	()I
    //   29: invokevirtual 32	bkrf:b	(I)Ldov/com/qq/im/capture/data/QIMFilterCategoryItem;
    //   32: astore 6
    //   34: invokestatic 37	bjav:a	()Lbjav;
    //   37: bipush 8
    //   39: invokevirtual 40	bjav:c	(I)Lbjan;
    //   42: checkcast 42	bjed
    //   45: invokevirtual 45	bjed:a	()Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   48: astore 4
    //   50: new 47	org/json/JSONObject
    //   53: dup
    //   54: invokespecial 50	org/json/JSONObject:<init>	()V
    //   57: astore_3
    //   58: aload 5
    //   60: ifnull +96 -> 156
    //   63: aload_2
    //   64: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   67: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   70: ifnonnull +17 -> 87
    //   73: aload_2
    //   74: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   77: new 63	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo
    //   80: dup
    //   81: invokespecial 64	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:<init>	()V
    //   84: putfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   87: aload_2
    //   88: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   91: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   94: aload 5
    //   96: getfield 69	dov/com/qq/im/capture/data/QIMFilterCategoryItem:a	Ljava/lang/String;
    //   99: putfield 72	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:id	Ljava/lang/String;
    //   102: aload_2
    //   103: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   106: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   109: aload 5
    //   111: getfield 75	dov/com/qq/im/capture/data/QIMFilterCategoryItem:f	Ljava/lang/String;
    //   114: putfield 78	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:type	Ljava/lang/String;
    //   117: aload 5
    //   119: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   122: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +207 -> 332
    //   128: aload_3
    //   129: getstatic 91	tnj:B	Ljava/lang/String;
    //   132: aload 5
    //   134: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   137: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   140: pop
    //   141: aload_2
    //   142: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   145: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   148: aload 5
    //   150: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   153: putfield 98	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:name	Ljava/lang/String;
    //   156: aload 6
    //   158: ifnull +104 -> 262
    //   161: aload 6
    //   163: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   166: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +93 -> 262
    //   172: aload 6
    //   174: invokevirtual 101	dov/com/qq/im/capture/data/QIMFilterCategoryItem:c	()Z
    //   177: ifne +85 -> 262
    //   180: aload_2
    //   181: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   184: getfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   187: ifnonnull +17 -> 204
    //   190: aload_2
    //   191: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   194: new 107	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter
    //   197: dup
    //   198: invokespecial 108	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter:<init>	()V
    //   201: putfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   204: aload_2
    //   205: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   208: getfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   211: aload 6
    //   213: getfield 69	dov/com/qq/im/capture/data/QIMFilterCategoryItem:a	Ljava/lang/String;
    //   216: putfield 109	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter:id	Ljava/lang/String;
    //   219: aload_2
    //   220: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   223: getfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   226: aload 6
    //   228: getfield 75	dov/com/qq/im/capture/data/QIMFilterCategoryItem:f	Ljava/lang/String;
    //   231: putfield 112	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter:typeId	Ljava/lang/String;
    //   234: aload_2
    //   235: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   238: getfield 105	com/tencent/mobileqq/tribe/TribeVideoPublishParams:filter	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter;
    //   241: aload 6
    //   243: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   246: putfield 113	com/tencent/mobileqq/tribe/TribeVideoPublishParams$Filter:name	Ljava/lang/String;
    //   249: aload_3
    //   250: getstatic 116	tnj:z	Ljava/lang/String;
    //   253: aload 6
    //   255: getfield 80	dov/com/qq/im/capture/data/QIMFilterCategoryItem:b	Ljava/lang/String;
    //   258: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   261: pop
    //   262: aload 4
    //   264: ifnull +27 -> 291
    //   267: aload 4
    //   269: getfield 121	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mMusicName	Ljava/lang/String;
    //   272: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifne +16 -> 291
    //   278: aload_3
    //   279: getstatic 124	tnj:A	Ljava/lang/String;
    //   282: aload 4
    //   284: getfield 121	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mMusicName	Ljava/lang/String;
    //   287: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload_0
    //   292: ldc 126
    //   294: invokevirtual 129	bjst:a	(Ljava/lang/Class;)Lbjxm;
    //   297: checkcast 126	bjsu
    //   300: astore 4
    //   302: aload 4
    //   304: ifnull +13 -> 317
    //   307: aload 4
    //   309: invokeinterface 132 1 0
    //   314: ifnonnull +60 -> 374
    //   317: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +11 -> 331
    //   323: ldc 139
    //   325: iconst_2
    //   326: ldc 141
    //   328: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: return
    //   332: aload 5
    //   334: getfield 148	dov/com/qq/im/capture/data/QIMFilterCategoryItem:e	Ljava/lang/String;
    //   337: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifne -184 -> 156
    //   343: aload_3
    //   344: getstatic 91	tnj:B	Ljava/lang/String;
    //   347: aload 5
    //   349: getfield 148	dov/com/qq/im/capture/data/QIMFilterCategoryItem:e	Ljava/lang/String;
    //   352: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   355: pop
    //   356: aload_2
    //   357: getfield 55	bkld:jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams;
    //   360: getfield 61	com/tencent/mobileqq/tribe/TribeVideoPublishParams:combo0Info	Lcom/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo;
    //   363: aload 5
    //   365: getfield 148	dov/com/qq/im/capture/data/QIMFilterCategoryItem:e	Ljava/lang/String;
    //   368: putfield 98	com/tencent/mobileqq/tribe/TribeVideoPublishParams$ComboInfo:name	Ljava/lang/String;
    //   371: goto -215 -> 156
    //   374: aload 4
    //   376: invokeinterface 132 1 0
    //   381: invokevirtual 153	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	()Lbkak;
    //   384: astore 5
    //   386: ldc 155
    //   388: getstatic 158	bjbe:b	Ljava/lang/String;
    //   391: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   394: ifeq +16 -> 410
    //   397: aload 5
    //   399: ifnull +24 -> 423
    //   402: aload 5
    //   404: invokevirtual 168	bkak:a	()Z
    //   407: ifne +16 -> 423
    //   410: aload_3
    //   411: getstatic 171	tnj:y	Ljava/lang/String;
    //   414: ldc 172
    //   416: invokestatic 177	ajya:a	(I)Ljava/lang/String;
    //   419: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   422: pop
    //   423: aload 4
    //   425: invokeinterface 132 1 0
    //   430: iload_1
    //   431: invokevirtual 178	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(I)Ljava/lang/String;
    //   434: astore 4
    //   436: aload 4
    //   438: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   441: ifne +13 -> 454
    //   444: aload_3
    //   445: getstatic 181	tnj:x	Ljava/lang/String;
    //   448: aload 4
    //   450: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload_3
    //   455: invokevirtual 185	org/json/JSONObject:toString	()Ljava/lang/String;
    //   458: astore_3
    //   459: ldc 139
    //   461: ldc 187
    //   463: aload_3
    //   464: invokestatic 192	ved:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   467: aload_2
    //   468: getfield 195	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   471: ldc 197
    //   473: aload_3
    //   474: invokevirtual 203	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   477: pop
    //   478: return
    //   479: astore 4
    //   481: goto -27 -> 454
    //   484: astore 5
    //   486: goto -63 -> 423
    //   489: astore 4
    //   491: goto -200 -> 291
    //   494: astore 5
    //   496: goto -234 -> 262
    //   499: astore 7
    //   501: goto -145 -> 356
    //   504: astore 7
    //   506: goto -365 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	bjst
    //   0	509	1	paramInt	int
    //   0	509	2	parambkld	bkld
    //   57	417	3	localObject1	java.lang.Object
    //   48	401	4	localObject2	java.lang.Object
    //   479	1	4	localJSONException1	org.json.JSONException
    //   489	1	4	localJSONException2	org.json.JSONException
    //   18	385	5	localObject3	java.lang.Object
    //   484	1	5	localJSONException3	org.json.JSONException
    //   494	1	5	localJSONException4	org.json.JSONException
    //   32	222	6	localQIMFilterCategoryItem	dov.com.qq.im.capture.data.QIMFilterCategoryItem
    //   499	1	7	localJSONException5	org.json.JSONException
    //   504	1	7	localJSONException6	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   444	454	479	org/json/JSONException
    //   410	423	484	org/json/JSONException
    //   278	291	489	org/json/JSONException
    //   249	262	494	org/json/JSONException
    //   343	356	499	org/json/JSONException
    //   128	141	504	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjst
 * JD-Core Version:    0.7.0.1
 */