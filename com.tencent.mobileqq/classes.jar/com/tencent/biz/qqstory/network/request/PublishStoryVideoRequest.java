package com.tencent.biz.qqstory.network.request;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.biz.qqstory.network.response.PublishStoryVideoRespond;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class PublishStoryVideoRequest
  extends NetworkRequest
{
  public static final String A = String.valueOf(4);
  public static final String B = String.valueOf(5);
  public static final String a;
  public static final String b;
  public static final String x;
  public static final String y;
  public static final String z;
  public AddressItem a;
  public VideoLinkInfo a;
  public boolean a;
  public byte[] a;
  public long b;
  public boolean b;
  public byte[] b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public byte[] c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  @Nullable
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.video_show_publish");
    jdField_b_of_type_JavaLangString = StoryApi.a("StoryGroupSvc.do_video_publish");
    x = String.valueOf(1);
    y = String.valueOf(2);
    z = String.valueOf(3);
  }
  
  public PublishStoryVideoRequest(boolean paramBoolean)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 5;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspPublishVideo localRspPublishVideo = new qqstory_service.RspPublishVideo();
    try
    {
      localRspPublishVideo.mergeFrom(paramArrayOfByte);
      return new PublishStoryVideoRespond(localRspPublishVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return jdField_b_of_type_JavaLangString;
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  /* Error */
  public byte[] a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +13 -> 20
    //   10: new 123	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc 125
    //   16: invokespecial 128	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: aload_0
    //   21: getfield 130	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_Long	J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifgt +33 -> 59
    //   29: new 123	java/lang/IllegalArgumentException
    //   32: dup
    //   33: new 132	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   40: ldc 135
    //   42: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 130	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_Long	J
    //   49: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 128	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: aload_0
    //   60: getfield 147	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +33 -> 99
    //   69: new 123	java/lang/IllegalArgumentException
    //   72: dup
    //   73: new 132	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   80: ldc 149
    //   82: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: getfield 147	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   89: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokespecial 128	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   98: athrow
    //   99: aload_0
    //   100: getfield 82	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_b_of_type_Boolean	Z
    //   103: ifeq +28 -> 131
    //   106: aload_0
    //   107: getfield 151	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_b_of_type_ArrayOfByte	[B
    //   110: ifnull +11 -> 121
    //   113: aload_0
    //   114: getfield 151	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_b_of_type_ArrayOfByte	[B
    //   117: arraylength
    //   118: ifgt +13 -> 131
    //   121: new 123	java/lang/IllegalArgumentException
    //   124: dup
    //   125: ldc 153
    //   127: invokespecial 128	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    //   131: new 155	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo
    //   134: dup
    //   135: invokespecial 156	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:<init>	()V
    //   138: astore_3
    //   139: aload_3
    //   140: getfield 160	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: aload_0
    //   144: getfield 80	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   147: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   150: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   153: aload_3
    //   154: getfield 175	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:vid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   157: aload_0
    //   158: getfield 115	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   164: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   167: aload_3
    //   168: getfield 178	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   171: aload_0
    //   172: getfield 147	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   175: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   178: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   181: aload_3
    //   182: getfield 182	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:total_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   185: aload_0
    //   186: getfield 130	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_Long	J
    //   189: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   192: aload_0
    //   193: getfield 189	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   196: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   199: ifeq +24 -> 223
    //   202: aload_0
    //   203: invokestatic 194	com/tencent/biz/qqstory/storyHome/model/FeedManager:a	()Ljava/text/SimpleDateFormat;
    //   206: new 196	java/util/Date
    //   209: dup
    //   210: aload_0
    //   211: getfield 198	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_d_of_type_Long	J
    //   214: invokespecial 200	java/util/Date:<init>	(J)V
    //   217: invokevirtual 206	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   220: putfield 189	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   223: aload_3
    //   224: getfield 210	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:date	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   227: aload_0
    //   228: getfield 189	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   231: invokestatic 215	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   234: invokevirtual 219	java/lang/Integer:intValue	()I
    //   237: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   240: aload_3
    //   241: getfield 227	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   244: aload_0
    //   245: getfield 229	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_g_of_type_Int	I
    //   248: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   251: aload_3
    //   252: getfield 232	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:sync_to_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   255: astore_2
    //   256: aload_0
    //   257: getfield 234	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_Boolean	Z
    //   260: ifeq +758 -> 1018
    //   263: iconst_1
    //   264: istore_1
    //   265: aload_2
    //   266: iload_1
    //   267: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   270: ldc 236
    //   272: ldc 238
    //   274: aload_0
    //   275: getfield 234	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_Boolean	Z
    //   278: invokestatic 243	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   281: invokestatic 248	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   284: aload_0
    //   285: getfield 250	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:w	Ljava/lang/String;
    //   288: ifnull +14 -> 302
    //   291: aload_3
    //   292: getfield 254	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:compared_vid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   295: aload_0
    //   296: getfield 250	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:w	Ljava/lang/String;
    //   299: invokevirtual 258	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   302: aload_0
    //   303: getfield 86	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_k_of_type_Int	I
    //   306: ifeq +14 -> 320
    //   309: aload_3
    //   310: getfield 261	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:compared_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   313: aload_0
    //   314: getfield 86	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_k_of_type_Int	I
    //   317: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   320: aload_0
    //   321: getfield 263	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_l_of_type_Int	I
    //   324: ifeq +14 -> 338
    //   327: aload_3
    //   328: getfield 266	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:compared_activity_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   331: aload_0
    //   332: getfield 263	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_l_of_type_Int	I
    //   335: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   338: ldc_w 268
    //   341: ldc_w 270
    //   344: aload_0
    //   345: getfield 86	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_k_of_type_Int	I
    //   348: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: aload_0
    //   352: getfield 263	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_l_of_type_Int	I
    //   355: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   358: invokestatic 276	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   361: aload_0
    //   362: getfield 278	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:v	Ljava/lang/String;
    //   365: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: ifne +17 -> 385
    //   371: aload_3
    //   372: getfield 281	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:game_pk_vid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   375: aload_0
    //   376: getfield 278	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:v	Ljava/lang/String;
    //   379: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   382: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   385: new 283	org/json/JSONObject
    //   388: dup
    //   389: invokespecial 284	org/json/JSONObject:<init>	()V
    //   392: astore_2
    //   393: aload_2
    //   394: ldc_w 286
    //   397: aload_0
    //   398: getfield 288	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_Int	I
    //   401: invokevirtual 292	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   404: pop
    //   405: aload_2
    //   406: ldc_w 294
    //   409: aload_0
    //   410: getfield 296	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_d_of_type_Int	I
    //   413: invokevirtual 292	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   416: pop
    //   417: aload_2
    //   418: ldc_w 298
    //   421: aload_0
    //   422: getfield 300	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_e_of_type_Long	J
    //   425: invokevirtual 303	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   428: pop
    //   429: aload_2
    //   430: ldc_w 305
    //   433: aload_0
    //   434: getfield 307	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_e_of_type_Int	I
    //   437: invokevirtual 292	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   440: pop
    //   441: aload_0
    //   442: getfield 309	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   445: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   448: ifne +15 -> 463
    //   451: aload_2
    //   452: ldc_w 311
    //   455: aload_0
    //   456: getfield 309	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   459: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   462: pop
    //   463: aload_0
    //   464: getfield 316	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   467: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   470: ifne +15 -> 485
    //   473: aload_2
    //   474: ldc_w 318
    //   477: aload_0
    //   478: getfield 316	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   481: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   484: pop
    //   485: aload_0
    //   486: getfield 320	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:m	Ljava/lang/String;
    //   489: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   492: ifne +15 -> 507
    //   495: aload_2
    //   496: ldc_w 322
    //   499: aload_0
    //   500: getfield 320	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:m	Ljava/lang/String;
    //   503: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   506: pop
    //   507: aload_0
    //   508: getfield 324	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:n	Ljava/lang/String;
    //   511: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   514: ifne +22 -> 536
    //   517: aload_2
    //   518: ldc_w 326
    //   521: new 328	org/json/JSONArray
    //   524: dup
    //   525: aload_0
    //   526: getfield 324	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:n	Ljava/lang/String;
    //   529: invokespecial 329	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   532: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   535: pop
    //   536: aload_2
    //   537: ldc_w 331
    //   540: aload_0
    //   541: getfield 333	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_b_of_type_Long	J
    //   544: ldc2_w 334
    //   547: ldiv
    //   548: invokevirtual 303	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   551: pop
    //   552: aload_0
    //   553: getfield 307	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_e_of_type_Int	I
    //   556: ifne +494 -> 1050
    //   559: aload_0
    //   560: getfield 337	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_Int	I
    //   563: ifne +460 -> 1023
    //   566: aload_3
    //   567: getfield 340	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   570: iconst_1
    //   571: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   574: aload_0
    //   575: getfield 342	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_Long	J
    //   578: lconst_0
    //   579: lcmp
    //   580: ifeq +498 -> 1078
    //   583: aload_2
    //   584: ldc_w 344
    //   587: aload_0
    //   588: getfield 342	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_Long	J
    //   591: invokevirtual 303	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   594: pop
    //   595: aload_2
    //   596: ldc_w 346
    //   599: iconst_1
    //   600: invokevirtual 349	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   603: pop
    //   604: aload_3
    //   605: getfield 352	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_origin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   608: iconst_1
    //   609: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   612: aload_0
    //   613: getfield 354	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:o	Ljava/lang/String;
    //   616: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   619: ifne +15 -> 634
    //   622: aload_2
    //   623: ldc_w 356
    //   626: aload_0
    //   627: getfield 354	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:o	Ljava/lang/String;
    //   630: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   633: pop
    //   634: aload_0
    //   635: getfield 358	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_i_of_type_Int	I
    //   638: ifeq +15 -> 653
    //   641: aload_2
    //   642: ldc_w 360
    //   645: aload_0
    //   646: getfield 358	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_i_of_type_Int	I
    //   649: invokevirtual 292	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   652: pop
    //   653: aload_0
    //   654: getfield 362	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_h_of_type_Int	I
    //   657: ifeq +15 -> 672
    //   660: aload_2
    //   661: ldc_w 364
    //   664: aload_0
    //   665: getfield 362	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_h_of_type_Int	I
    //   668: invokevirtual 292	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   671: pop
    //   672: aload_0
    //   673: getfield 366	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:q	Ljava/lang/String;
    //   676: ifnull +34 -> 710
    //   679: aload_2
    //   680: ldc_w 368
    //   683: new 283	org/json/JSONObject
    //   686: dup
    //   687: aload_0
    //   688: getfield 366	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:q	Ljava/lang/String;
    //   691: invokespecial 369	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   694: invokevirtual 372	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   697: pop
    //   698: aload_2
    //   699: ldc_w 374
    //   702: aload_0
    //   703: getfield 376	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:r	Ljava/lang/String;
    //   706: invokevirtual 372	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   709: pop
    //   710: aload_0
    //   711: getfield 378	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:s	Ljava/lang/String;
    //   714: ifnull +34 -> 748
    //   717: aload_2
    //   718: ldc_w 380
    //   721: new 283	org/json/JSONObject
    //   724: dup
    //   725: aload_0
    //   726: getfield 378	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:s	Ljava/lang/String;
    //   729: invokespecial 369	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   732: invokevirtual 372	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   735: pop
    //   736: aload_2
    //   737: ldc_w 382
    //   740: aload_0
    //   741: getfield 384	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:t	Ljava/lang/String;
    //   744: invokevirtual 372	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   747: pop
    //   748: aload_0
    //   749: getfield 86	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_k_of_type_Int	I
    //   752: ifeq +15 -> 767
    //   755: aload_2
    //   756: ldc_w 386
    //   759: aload_0
    //   760: getfield 86	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_k_of_type_Int	I
    //   763: invokevirtual 292	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   766: pop
    //   767: aload_0
    //   768: getfield 388	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:u	Ljava/lang/String;
    //   771: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   774: ifne +22 -> 796
    //   777: aload_2
    //   778: ldc_w 390
    //   781: new 283	org/json/JSONObject
    //   784: dup
    //   785: aload_0
    //   786: getfield 388	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:u	Ljava/lang/String;
    //   789: invokespecial 369	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   792: invokevirtual 372	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   795: pop
    //   796: aload_3
    //   797: getfield 393	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_attr	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   800: aload_2
    //   801: invokevirtual 394	org/json/JSONObject:toString	()Ljava/lang/String;
    //   804: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   807: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   810: aload_0
    //   811: getfield 396	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo;
    //   814: ifnull +110 -> 924
    //   817: aload_0
    //   818: getfield 396	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo;
    //   821: iconst_1
    //   822: invokevirtual 401	com/tencent/biz/qqstory/model/item/VideoLinkInfo:a	(Z)Ljava/lang/String;
    //   825: astore_2
    //   826: ldc 236
    //   828: ldc_w 403
    //   831: aload_2
    //   832: invokestatic 248	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   835: aload_3
    //   836: getfield 406	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_extern_link_attr	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   839: aload_2
    //   840: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   843: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   846: aload_0
    //   847: getfield 396	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo;
    //   850: getfield 407	com/tencent/biz/qqstory/model/item/VideoLinkInfo:jdField_a_of_type_Int	I
    //   853: iconst_3
    //   854: if_icmpne +11 -> 865
    //   857: aload_3
    //   858: getfield 410	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:is_capture_together_video	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   861: iconst_1
    //   862: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   865: aload_0
    //   866: getfield 396	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo;
    //   869: getfield 413	com/tencent/biz/qqstory/model/item/VideoLinkInfo:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo$VipFrwrdLinkInfo;
    //   872: ifnull +52 -> 924
    //   875: aload_0
    //   876: getfield 396	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo;
    //   879: getfield 413	com/tencent/biz/qqstory/model/item/VideoLinkInfo:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo$VipFrwrdLinkInfo;
    //   882: getfield 416	com/tencent/biz/qqstory/model/item/VideoLinkInfo$VipFrwrdLinkInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   885: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   888: ifne +36 -> 924
    //   891: aload_3
    //   892: getfield 420	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:wording_check	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   895: invokevirtual 426	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   898: astore_2
    //   899: aload_2
    //   900: aload_0
    //   901: getfield 396	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo;
    //   904: getfield 413	com/tencent/biz/qqstory/model/item/VideoLinkInfo:jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo	Lcom/tencent/biz/qqstory/model/item/VideoLinkInfo$VipFrwrdLinkInfo;
    //   907: getfield 416	com/tencent/biz/qqstory/model/item/VideoLinkInfo$VipFrwrdLinkInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   910: invokeinterface 432 2 0
    //   915: pop
    //   916: aload_3
    //   917: getfield 420	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:wording_check	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   920: aload_2
    //   921: invokevirtual 435	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   924: aload_0
    //   925: getfield 324	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:n	Ljava/lang/String;
    //   928: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   931: ifne +167 -> 1098
    //   934: new 328	org/json/JSONArray
    //   937: dup
    //   938: aload_0
    //   939: getfield 324	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:n	Ljava/lang/String;
    //   942: invokespecial 329	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   945: astore_2
    //   946: aload_2
    //   947: ifnull +151 -> 1098
    //   950: aload_2
    //   951: invokevirtual 438	org/json/JSONArray:length	()I
    //   954: ifle +144 -> 1098
    //   957: new 440	java/util/ArrayList
    //   960: dup
    //   961: invokespecial 441	java/util/ArrayList:<init>	()V
    //   964: astore 4
    //   966: iconst_0
    //   967: istore_1
    //   968: iload_1
    //   969: aload_2
    //   970: invokevirtual 438	org/json/JSONArray:length	()I
    //   973: if_icmpge +116 -> 1089
    //   976: aload 4
    //   978: aload_2
    //   979: iload_1
    //   980: invokevirtual 445	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   983: ldc_w 446
    //   986: invokevirtual 449	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   989: invokestatic 454	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   992: invokeinterface 432 2 0
    //   997: pop
    //   998: iload_1
    //   999: iconst_1
    //   1000: iadd
    //   1001: istore_1
    //   1002: goto -34 -> 968
    //   1005: astore_2
    //   1006: ldc 236
    //   1008: ldc_w 456
    //   1011: aload_2
    //   1012: invokestatic 459	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1015: goto -775 -> 240
    //   1018: iconst_0
    //   1019: istore_1
    //   1020: goto -755 -> 265
    //   1023: aload_3
    //   1024: getfield 340	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1027: aload_0
    //   1028: getfield 337	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_Int	I
    //   1031: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1034: goto -460 -> 574
    //   1037: astore_2
    //   1038: ldc 236
    //   1040: ldc_w 461
    //   1043: aload_2
    //   1044: invokestatic 459	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1047: goto -123 -> 924
    //   1050: aload_3
    //   1051: getfield 340	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1054: astore 4
    //   1056: aload_0
    //   1057: getfield 337	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_Int	I
    //   1060: iconst_3
    //   1061: if_icmpne +656 -> 1717
    //   1064: aload_0
    //   1065: getfield 337	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_f_of_type_Int	I
    //   1068: istore_1
    //   1069: aload 4
    //   1071: iload_1
    //   1072: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1075: goto -501 -> 574
    //   1078: aload_3
    //   1079: getfield 352	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_origin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1082: iconst_0
    //   1083: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1086: goto -474 -> 612
    //   1089: aload_3
    //   1090: getfield 464	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:mention_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1093: aload 4
    //   1095: invokevirtual 468	com/tencent/mobileqq/pb/PBRepeatField:addAll	(Ljava/util/Collection;)V
    //   1098: aload_0
    //   1099: getfield 470	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1102: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1105: ifne +17 -> 1122
    //   1108: aload_3
    //   1109: getfield 473	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:label	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1112: aload_0
    //   1113: getfield 470	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1116: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1119: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1122: aload_0
    //   1123: getfield 475	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1126: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1129: ifeq +428 -> 1557
    //   1132: aload_0
    //   1133: getfield 309	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1136: astore_2
    //   1137: aload_2
    //   1138: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1141: ifne +14 -> 1155
    //   1144: aload_3
    //   1145: getfield 478	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:doodle_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1148: aload_2
    //   1149: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1152: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1155: aload_0
    //   1156: getfield 480	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1159: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1162: ifne +17 -> 1179
    //   1165: aload_3
    //   1166: getfield 483	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_cover	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1169: aload_0
    //   1170: getfield 480	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1173: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1176: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1179: aload_0
    //   1180: getfield 485	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1183: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1186: ifne +17 -> 1203
    //   1189: aload_3
    //   1190: getfield 488	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:doodle_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1193: aload_0
    //   1194: getfield 485	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1197: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1200: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1203: aload_0
    //   1204: getfield 490	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem	Lcom/tencent/biz/qqstory/model/item/AddressItem;
    //   1207: ifnull +17 -> 1224
    //   1210: aload_3
    //   1211: getfield 494	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:address	Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$Address;
    //   1214: aload_0
    //   1215: getfield 490	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem	Lcom/tencent/biz/qqstory/model/item/AddressItem;
    //   1218: invokevirtual 500	com/tencent/biz/qqstory/model/item/AddressItem:convertToProtoObject	()Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$Address;
    //   1221: invokevirtual 505	com/tencent/biz/qqstory/network/pb/qqstory_struct$Address:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1224: aload_3
    //   1225: getfield 508	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:create_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1228: aload_0
    //   1229: getfield 198	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_d_of_type_Long	J
    //   1232: ldc2_w 334
    //   1235: ldiv
    //   1236: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1239: aload_0
    //   1240: getfield 510	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:p	Ljava/lang/String;
    //   1243: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1246: ifne +17 -> 1263
    //   1249: aload_3
    //   1250: getfield 513	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:multi_shoot_group_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1253: aload_0
    //   1254: getfield 510	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:p	Ljava/lang/String;
    //   1257: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1260: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1263: aload_0
    //   1264: getfield 515	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ArrayOfByte	[B
    //   1267: ifnull +36 -> 1303
    //   1270: aload_0
    //   1271: getfield 515	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ArrayOfByte	[B
    //   1274: arraylength
    //   1275: ifle +28 -> 1303
    //   1278: new 517	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf
    //   1281: dup
    //   1282: invokespecial 518	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf:<init>	()V
    //   1285: astore_2
    //   1286: aload_2
    //   1287: aload_0
    //   1288: getfield 515	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_a_of_type_ArrayOfByte	[B
    //   1291: invokevirtual 519	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1294: pop
    //   1295: aload_3
    //   1296: getfield 523	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:reader_conf	Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf;
    //   1299: aload_2
    //   1300: invokevirtual 524	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1303: aload_0
    //   1304: getfield 151	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_b_of_type_ArrayOfByte	[B
    //   1307: ifnull +33 -> 1340
    //   1310: aload_0
    //   1311: getfield 151	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_b_of_type_ArrayOfByte	[B
    //   1314: arraylength
    //   1315: ifle +25 -> 1340
    //   1318: new 526	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoSpreadGroupList
    //   1321: dup
    //   1322: invokespecial 527	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoSpreadGroupList:<init>	()V
    //   1325: astore_2
    //   1326: aload_2
    //   1327: aload_0
    //   1328: getfield 151	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_b_of_type_ArrayOfByte	[B
    //   1331: invokevirtual 528	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoSpreadGroupList:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1334: pop
    //   1335: aload_3
    //   1336: aload_2
    //   1337: putfield 532	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:group_list	Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$VideoSpreadGroupList;
    //   1340: aload_3
    //   1341: getfield 535	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:ignore_personal_publish	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1344: astore_2
    //   1345: aload_0
    //   1346: getfield 82	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_b_of_type_Boolean	Z
    //   1349: ifeq +232 -> 1581
    //   1352: iconst_1
    //   1353: istore_1
    //   1354: aload_2
    //   1355: iload_1
    //   1356: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1359: aload_3
    //   1360: getfield 538	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:group_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1363: aload_0
    //   1364: getfield 84	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_j_of_type_Int	I
    //   1367: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1370: aload_0
    //   1371: getfield 540	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_ArrayOfByte	[B
    //   1374: ifnull +73 -> 1447
    //   1377: aload_0
    //   1378: getfield 540	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_ArrayOfByte	[B
    //   1381: arraylength
    //   1382: ifle +65 -> 1447
    //   1385: new 542	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase
    //   1388: dup
    //   1389: invokespecial 543	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:<init>	()V
    //   1392: astore_2
    //   1393: aload_2
    //   1394: aload_0
    //   1395: getfield 540	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_c_of_type_ArrayOfByte	[B
    //   1398: invokevirtual 544	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1401: pop
    //   1402: aload_3
    //   1403: getfield 547	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_label_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1406: aload_2
    //   1407: getfield 550	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:tag_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1410: invokevirtual 553	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1413: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1416: aload_3
    //   1417: getfield 556	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1420: aload_2
    //   1421: getfield 559	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:tag_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1424: invokevirtual 561	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1427: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1430: aload_3
    //   1431: getfield 564	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_label_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1434: aload_2
    //   1435: getfield 567	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:tag_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1438: invokevirtual 569	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1441: invokestatic 166	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1444: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1447: aload_3
    //   1448: getfield 572	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:client_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1451: iconst_5
    //   1452: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1455: aload_0
    //   1456: getfield 366	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:q	Ljava/lang/String;
    //   1459: ifnull +146 -> 1605
    //   1462: aload_0
    //   1463: getfield 366	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:q	Ljava/lang/String;
    //   1466: invokestatic 577	com/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout:a	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout;
    //   1469: astore_2
    //   1470: aload_2
    //   1471: ifnull +134 -> 1605
    //   1474: aload_2
    //   1475: getfield 580	com/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1478: ifnull +127 -> 1605
    //   1481: aload_2
    //   1482: getfield 580	com/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1485: arraylength
    //   1486: iconst_2
    //   1487: if_icmple +118 -> 1605
    //   1490: aload_3
    //   1491: getfield 583	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:poll_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1494: aload_2
    //   1495: getfield 580	com/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1498: iconst_0
    //   1499: aaload
    //   1500: invokevirtual 258	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1503: new 440	java/util/ArrayList
    //   1506: dup
    //   1507: aload_2
    //   1508: getfield 580	com/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1511: arraylength
    //   1512: invokespecial 585	java/util/ArrayList:<init>	(I)V
    //   1515: astore 4
    //   1517: iconst_1
    //   1518: istore_1
    //   1519: iload_1
    //   1520: aload_2
    //   1521: getfield 580	com/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1524: arraylength
    //   1525: if_icmpge +71 -> 1596
    //   1528: aload 4
    //   1530: aload_2
    //   1531: getfield 580	com/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1534: iload_1
    //   1535: aaload
    //   1536: invokeinterface 432 2 0
    //   1541: pop
    //   1542: iload_1
    //   1543: iconst_1
    //   1544: iadd
    //   1545: istore_1
    //   1546: goto -27 -> 1519
    //   1549: astore_2
    //   1550: aload_2
    //   1551: invokevirtual 588	org/json/JSONException:printStackTrace	()V
    //   1554: goto -456 -> 1098
    //   1557: aload_0
    //   1558: getfield 475	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1561: astore_2
    //   1562: goto -425 -> 1137
    //   1565: astore_2
    //   1566: aload_2
    //   1567: invokevirtual 589	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1570: goto -267 -> 1303
    //   1573: astore_2
    //   1574: aload_2
    //   1575: invokevirtual 589	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1578: goto -238 -> 1340
    //   1581: iconst_0
    //   1582: istore_1
    //   1583: goto -229 -> 1354
    //   1586: astore 4
    //   1588: aload 4
    //   1590: invokevirtual 589	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1593: goto -191 -> 1402
    //   1596: aload_3
    //   1597: getfield 592	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:poll_options	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1600: aload 4
    //   1602: invokevirtual 435	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   1605: aload_0
    //   1606: getfield 378	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:s	Ljava/lang/String;
    //   1609: ifnull +75 -> 1684
    //   1612: aload_0
    //   1613: getfield 378	com/tencent/biz/qqstory/network/request/PublishStoryVideoRequest:s	Ljava/lang/String;
    //   1616: invokestatic 597	com/tencent/biz/qqstory/model/item/StoryVideoItem$InteractPasterLayout:a	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/model/item/StoryVideoItem$InteractPasterLayout;
    //   1619: astore_2
    //   1620: aload_2
    //   1621: ifnull +63 -> 1684
    //   1624: aload_2
    //   1625: getfield 598	com/tencent/biz/qqstory/model/item/StoryVideoItem$InteractPasterLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1628: ifnull +56 -> 1684
    //   1631: aload_2
    //   1632: getfield 598	com/tencent/biz/qqstory/model/item/StoryVideoItem$InteractPasterLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1635: arraylength
    //   1636: ifle +48 -> 1684
    //   1639: new 600	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo
    //   1642: dup
    //   1643: invokespecial 601	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo:<init>	()V
    //   1646: astore 4
    //   1648: aload 4
    //   1650: getfield 604	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo:paster_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1653: aload_2
    //   1654: getfield 605	com/tencent/biz/qqstory/model/item/StoryVideoItem$InteractPasterLayout:jdField_a_of_type_Int	I
    //   1657: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1660: aload 4
    //   1662: getfield 608	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo:paster_contents	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1665: aload_2
    //   1666: getfield 598	com/tencent/biz/qqstory/model/item/StoryVideoItem$InteractPasterLayout:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1669: invokestatic 614	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   1672: invokevirtual 435	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   1675: aload_3
    //   1676: getfield 618	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:interact_paster_info	Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo;
    //   1679: aload 4
    //   1681: invokevirtual 619	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1684: ldc 236
    //   1686: new 132	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   1693: ldc_w 621
    //   1696: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: aload_3
    //   1700: invokestatic 626	com/tencent/biz/qqstory/utils/PBUtils:a	(Lcom/tencent/mobileqq/pb/MessageMicro;)Ljava/lang/String;
    //   1703: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1706: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1709: invokestatic 629	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1712: aload_3
    //   1713: invokevirtual 632	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:toByteArray	()[B
    //   1716: areturn
    //   1717: iconst_0
    //   1718: istore_1
    //   1719: goto -650 -> 1069
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1722	0	this	PublishStoryVideoRequest
    //   264	1455	1	i1	int
    //   255	724	2	localObject1	java.lang.Object
    //   1005	7	2	localNumberFormatException	java.lang.NumberFormatException
    //   1037	7	2	localException	java.lang.Exception
    //   1136	395	2	localObject2	java.lang.Object
    //   1549	2	2	localJSONException	org.json.JSONException
    //   1561	1	2	str	String
    //   1565	2	2	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   1573	2	2	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   1619	47	2	localInteractPasterLayout	com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout
    //   138	1575	3	localReqPublishVideo	com.tencent.biz.qqstory.network.pb.qqstory_service.ReqPublishVideo
    //   964	565	4	localObject3	java.lang.Object
    //   1586	15	4	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   1646	34	4	localInteractPasterInfo	com.tencent.biz.qqstory.network.pb.qqstory_struct.InteractPasterInfo
    // Exception table:
    //   from	to	target	type
    //   223	240	1005	java/lang/NumberFormatException
    //   385	463	1037	java/lang/Exception
    //   463	485	1037	java/lang/Exception
    //   485	507	1037	java/lang/Exception
    //   507	536	1037	java/lang/Exception
    //   536	574	1037	java/lang/Exception
    //   574	612	1037	java/lang/Exception
    //   612	634	1037	java/lang/Exception
    //   634	653	1037	java/lang/Exception
    //   653	672	1037	java/lang/Exception
    //   672	710	1037	java/lang/Exception
    //   710	748	1037	java/lang/Exception
    //   748	767	1037	java/lang/Exception
    //   767	796	1037	java/lang/Exception
    //   796	865	1037	java/lang/Exception
    //   865	924	1037	java/lang/Exception
    //   1023	1034	1037	java/lang/Exception
    //   1050	1069	1037	java/lang/Exception
    //   1069	1075	1037	java/lang/Exception
    //   1078	1086	1037	java/lang/Exception
    //   934	946	1549	org/json/JSONException
    //   950	966	1549	org/json/JSONException
    //   968	998	1549	org/json/JSONException
    //   1089	1098	1549	org/json/JSONException
    //   1286	1303	1565	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1326	1340	1573	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1393	1402	1586	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public String toString()
  {
    return "PublishStoryVideoRequest{title='" + this.jdField_c_of_type_JavaLangString + '\'' + ", vid='" + this.jdField_d_of_type_JavaLangString + '\'' + ", videoThumbnailUrl='" + this.jdField_j_of_type_JavaLangString + '\'' + ", mOriginalMaskPicUrl='" + this.jdField_k_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest
 * JD-Core Version:    0.7.0.1
 */