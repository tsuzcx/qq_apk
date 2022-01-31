package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AdVideoPos;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsIdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoFloatInfo;

public class VideoPlayRecommendHandler
  extends BusinessHandler
{
  private long jdField_a_of_type_Long;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  
  public VideoPlayRecommendHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public VideoPlayRecommendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private oidb_0x6cf.PhoneInfo a()
  {
    oidb_0x6cf.PhoneInfo localPhoneInfo = new oidb_0x6cf.PhoneInfo();
    String str1 = DeviceInfoUtil.a();
    String str2 = DeviceInfoUtil.c(BaseApplication.getContext());
    if (!TextUtils.isEmpty(str1))
    {
      str1 = MD5Utils.d(str1.toLowerCase()).toLowerCase();
      localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str1));
      localPhoneInfo.uint32_muid_type.set(1);
    }
    for (;;)
    {
      int i = PublicAccountAdUtil.a();
      localPhoneInfo.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = DeviceInfoUtil.e();
        i = j;
      }
      catch (Exception localException)
      {
        label82:
        break label82;
      }
      localPhoneInfo.uint32_carrier.set(i);
      str1 = DeviceInfoUtil.f();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str1));
      str1 = DeviceInfoUtil.d();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str1));
      i = AppSetting.jdField_a_of_type_Int;
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      str1 = DatalineMathUtil.a(DatalineMathUtil.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str1));
      localPhoneInfo.uint32_os_type.set(2);
      localPhoneInfo.uint64_func_flag.set(1L);
      return localPhoneInfo;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = MD5Utils.d(str2.replaceAll(":", "").toUpperCase()).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str1));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (paramVideoInfo.jdField_h_of_type_Int != 2) {
        break;
      }
    } while ((!TextUtils.isEmpty(paramVideoInfo.m)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString)));
    while ((paramVideoInfo.jdField_h_of_type_Int != 1) || (TextUtils.isEmpty(paramVideoInfo.m)) || (TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 198	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +5124 -> 5128
    //   7: aload_3
    //   8: ifnull +5120 -> 5128
    //   11: iconst_1
    //   12: istore 14
    //   14: new 200	android/os/Bundle
    //   17: dup
    //   18: invokespecial 201	android/os/Bundle:<init>	()V
    //   21: astore 26
    //   23: aconst_null
    //   24: astore_2
    //   25: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +29 -> 57
    //   31: ldc 208
    //   33: iconst_2
    //   34: new 210	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   41: ldc 213
    //   43: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 14
    //   48: invokevirtual 220	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 14
    //   59: ifeq +4938 -> 4997
    //   62: new 228	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   65: dup
    //   66: invokespecial 229	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   69: astore_1
    //   70: aload_1
    //   71: aload_3
    //   72: checkcast 231	[B
    //   75: checkcast 231	[B
    //   78: invokevirtual 235	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   81: pop
    //   82: aload_1
    //   83: getfield 238	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   86: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   89: ifeq +478 -> 567
    //   92: aload_1
    //   93: getfield 238	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   96: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   99: bipush 83
    //   101: if_icmpne +466 -> 567
    //   104: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +11 -> 118
    //   110: ldc 208
    //   112: iconst_2
    //   113: ldc 243
    //   115: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload 26
    //   120: ldc 247
    //   122: iconst_1
    //   123: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   126: aload_1
    //   127: getfield 254	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   130: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   133: invokevirtual 258	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   136: astore_1
    //   137: new 260	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody
    //   140: dup
    //   141: invokespecial 261	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:<init>	()V
    //   144: astore 27
    //   146: aload 27
    //   148: aload_1
    //   149: invokevirtual 262	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   152: pop
    //   153: aload 27
    //   155: getfield 265	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:uint64_pos_ad_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   158: invokevirtual 266	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   161: ifeq +15 -> 176
    //   164: aload_0
    //   165: aload 27
    //   167: getfield 265	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:uint64_pos_ad_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   170: invokevirtual 268	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   173: putfield 270	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_Long	J
    //   176: aload 27
    //   178: getfield 273	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:bytes_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   181: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   184: ifeq +33 -> 217
    //   187: aload 27
    //   189: getfield 273	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:bytes_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   192: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   195: ifnull +22 -> 217
    //   198: aload 26
    //   200: ldc_w 275
    //   203: aload 27
    //   205: getfield 273	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:bytes_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   208: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   211: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   214: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_0
    //   218: getfield 281	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   221: ifnonnull +17 -> 238
    //   224: aload_0
    //   225: new 283	java/text/SimpleDateFormat
    //   228: dup
    //   229: ldc_w 285
    //   232: invokespecial 288	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   235: putfield 281	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   238: aload 27
    //   240: getfield 292	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   243: invokevirtual 295	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   246: ifeq +2972 -> 3218
    //   249: aload 27
    //   251: getfield 292	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   254: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   257: ifnull +2961 -> 3218
    //   260: aload 27
    //   262: getfield 292	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   265: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   268: astore_3
    //   269: aload_2
    //   270: astore_1
    //   271: aload_3
    //   272: ifnull +2679 -> 2951
    //   275: aload_2
    //   276: astore_1
    //   277: aload_3
    //   278: invokeinterface 302 1 0
    //   283: ifne +2668 -> 2951
    //   286: new 304	java/util/ArrayList
    //   289: dup
    //   290: aload_3
    //   291: invokeinterface 307 1 0
    //   296: invokespecial 309	java/util/ArrayList:<init>	(I)V
    //   299: astore_2
    //   300: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +34 -> 337
    //   306: ldc 208
    //   308: iconst_2
    //   309: new 210	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 311
    //   319: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_3
    //   323: invokeinterface 307 1 0
    //   328: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aload_3
    //   338: invokeinterface 318 1 0
    //   343: astore 20
    //   345: aload 20
    //   347: invokeinterface 323 1 0
    //   352: ifeq +4883 -> 5235
    //   355: aload 20
    //   357: invokeinterface 327 1 0
    //   362: checkcast 329	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary
    //   365: astore 22
    //   367: aconst_null
    //   368: astore_3
    //   369: new 166	com/tencent/biz/pubaccount/VideoInfo
    //   372: dup
    //   373: invokespecial 330	com/tencent/biz/pubaccount/VideoInfo:<init>	()V
    //   376: astore 21
    //   378: aload 22
    //   380: getfield 333	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   383: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   386: ifeq +30 -> 416
    //   389: aload 22
    //   391: getfield 333	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   394: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   397: ifnull +19 -> 416
    //   400: aload 21
    //   402: aload 22
    //   404: getfield 333	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   407: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   410: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   413: putfield 178	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   416: aload 22
    //   418: getfield 336	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_summary	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   421: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   424: ifeq +30 -> 454
    //   427: aload 22
    //   429: getfield 336	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_summary	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   432: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   435: ifnull +19 -> 454
    //   438: aload 21
    //   440: aload 22
    //   442: getfield 336	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_summary	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   445: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   448: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   451: putfield 338	com/tencent/biz/pubaccount/VideoInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   454: aload 22
    //   456: getfield 341	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_dislike_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   459: invokevirtual 295	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   462: ifeq +176 -> 638
    //   465: aload 22
    //   467: getfield 341	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_dislike_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   470: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   473: ifnull +165 -> 638
    //   476: aload 22
    //   478: getfield 341	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_dislike_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   481: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   484: astore_1
    //   485: aload_1
    //   486: ifnull +152 -> 638
    //   489: aload_1
    //   490: invokeinterface 307 1 0
    //   495: ifle +143 -> 638
    //   498: aload_1
    //   499: invokeinterface 307 1 0
    //   504: istore 5
    //   506: aload 21
    //   508: new 304	java/util/ArrayList
    //   511: dup
    //   512: invokespecial 342	java/util/ArrayList:<init>	()V
    //   515: putfield 345	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   518: iconst_0
    //   519: istore 4
    //   521: iload 4
    //   523: iload 5
    //   525: if_icmpge +113 -> 638
    //   528: new 347	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo
    //   531: dup
    //   532: invokespecial 348	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:<init>	()V
    //   535: astore 23
    //   537: aload 23
    //   539: aload_1
    //   540: iload 4
    //   542: invokeinterface 351 2 0
    //   547: checkcast 353	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$DisLikeInfo
    //   550: invokevirtual 356	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:a	(Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$DisLikeInfo;)V
    //   553: aload 23
    //   555: getfield 357	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   558: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   561: ifeq +63 -> 624
    //   564: goto +4555 -> 5119
    //   567: aload 26
    //   569: ldc 247
    //   571: iconst_0
    //   572: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   575: goto -449 -> 126
    //   578: astore_1
    //   579: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq +32 -> 614
    //   585: ldc 208
    //   587: iconst_2
    //   588: new 210	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   595: ldc_w 359
    //   598: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload_1
    //   602: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   605: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aload_0
    //   615: iconst_1
    //   616: iload 14
    //   618: aload 26
    //   620: invokespecial 365	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   623: return
    //   624: aload 21
    //   626: getfield 345	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   629: aload 23
    //   631: invokevirtual 369	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   634: pop
    //   635: goto +4484 -> 5119
    //   638: aload 22
    //   640: getfield 372	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   643: invokevirtual 266	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   646: ifeq +56 -> 702
    //   649: aload 22
    //   651: getfield 372	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   654: invokevirtual 268	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   657: lconst_0
    //   658: lcmp
    //   659: ifeq +43 -> 702
    //   662: aload 21
    //   664: aload_0
    //   665: getfield 281	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   668: aload 22
    //   670: getfield 372	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   673: invokevirtual 268	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   676: ldc2_w 373
    //   679: lmul
    //   680: invokestatic 379	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   683: invokevirtual 383	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   686: putfield 385	com/tencent/biz/pubaccount/VideoInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   689: aload 21
    //   691: aload 22
    //   693: getfield 372	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   696: invokevirtual 268	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   699: putfield 386	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Long	J
    //   702: aload 22
    //   704: getfield 389	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   707: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   710: ifeq +30 -> 740
    //   713: aload 22
    //   715: getfield 389	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   718: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   721: ifnull +19 -> 740
    //   724: aload 21
    //   726: aload 22
    //   728: getfield 389	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   731: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   734: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   737: putfield 392	com/tencent/biz/pubaccount/VideoInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   740: aload 22
    //   742: getfield 395	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   745: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   748: ifeq +30 -> 778
    //   751: aload 22
    //   753: getfield 395	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   756: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   759: ifnull +19 -> 778
    //   762: aload 21
    //   764: aload 22
    //   766: getfield 395	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   769: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   772: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   775: putfield 186	com/tencent/biz/pubaccount/VideoInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   778: aload 22
    //   780: getfield 398	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_content_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   783: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   786: ifeq +30 -> 816
    //   789: aload 22
    //   791: getfield 398	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_content_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   794: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   797: ifnull +19 -> 816
    //   800: aload 21
    //   802: aload 22
    //   804: getfield 398	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_content_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   807: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   810: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   813: putfield 183	com/tencent/biz/pubaccount/VideoInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   816: aload 22
    //   818: getfield 401	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_strategy_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   821: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   824: ifeq +16 -> 840
    //   827: aload 21
    //   829: aload 22
    //   831: getfield 401	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_strategy_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   834: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   837: putfield 403	com/tencent/biz/pubaccount/VideoInfo:jdField_k_of_type_Int	I
    //   840: aload 22
    //   842: getfield 406	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_algorithm_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   845: invokevirtual 266	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   848: ifeq +16 -> 864
    //   851: aload 21
    //   853: aload 22
    //   855: getfield 406	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_algorithm_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   858: invokevirtual 268	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   861: putfield 408	com/tencent/biz/pubaccount/VideoInfo:jdField_d_of_type_Long	J
    //   864: aload 22
    //   866: getfield 411	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   869: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   872: ifeq +30 -> 902
    //   875: aload 22
    //   877: getfield 411	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   880: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   883: ifnull +19 -> 902
    //   886: aload 21
    //   888: aload 22
    //   890: getfield 411	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   893: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   896: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   899: putfield 413	com/tencent/biz/pubaccount/VideoInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   902: aload 22
    //   904: getfield 416	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_video_comment_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   907: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   910: ifeq +52 -> 962
    //   913: aload 21
    //   915: aload 22
    //   917: getfield 416	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_video_comment_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   920: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   923: putfield 418	com/tencent/biz/pubaccount/VideoInfo:jdField_e_of_type_Int	I
    //   926: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   929: ifeq +33 -> 962
    //   932: ldc 208
    //   934: iconst_2
    //   935: new 210	java/lang/StringBuilder
    //   938: dup
    //   939: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   942: ldc_w 420
    //   945: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload 21
    //   950: getfield 418	com/tencent/biz/pubaccount/VideoInfo:jdField_e_of_type_Int	I
    //   953: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   956: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: aload 22
    //   964: getfield 423	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_like_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   967: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   970: ifeq +52 -> 1022
    //   973: aload 21
    //   975: aload 22
    //   977: getfield 423	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_like_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   980: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   983: putfield 426	com/tencent/biz/pubaccount/VideoInfo:jdField_o_of_type_Int	I
    //   986: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   989: ifeq +33 -> 1022
    //   992: ldc 208
    //   994: iconst_2
    //   995: new 210	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1002: ldc_w 428
    //   1005: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: aload 21
    //   1010: getfield 426	com/tencent/biz/pubaccount/VideoInfo:jdField_o_of_type_Int	I
    //   1013: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1016: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1019: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1022: aload 22
    //   1024: getfield 431	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_biu_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1027: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1030: ifeq +52 -> 1082
    //   1033: aload 21
    //   1035: aload 22
    //   1037: getfield 431	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_biu_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1040: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1043: putfield 433	com/tencent/biz/pubaccount/VideoInfo:jdField_f_of_type_Int	I
    //   1046: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1049: ifeq +33 -> 1082
    //   1052: ldc 208
    //   1054: iconst_2
    //   1055: new 210	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1062: ldc_w 435
    //   1065: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: aload 21
    //   1070: getfield 433	com/tencent/biz/pubaccount/VideoInfo:jdField_f_of_type_Int	I
    //   1073: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1082: aload 22
    //   1084: getfield 438	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_ads_guide_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1087: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1090: ifeq +16 -> 1106
    //   1093: aload 21
    //   1095: aload 22
    //   1097: getfield 438	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_ads_guide_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1100: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1103: putfield 441	com/tencent/biz/pubaccount/VideoInfo:i	I
    //   1106: aload 22
    //   1108: getfield 444	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_ads_jump_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1111: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1114: ifeq +16 -> 1130
    //   1117: aload 21
    //   1119: aload 22
    //   1121: getfield 444	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_ads_jump_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1124: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1127: putfield 446	com/tencent/biz/pubaccount/VideoInfo:jdField_j_of_type_Int	I
    //   1130: aload 22
    //   1132: getfield 449	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_video_source_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1135: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1138: ifeq +25 -> 1163
    //   1141: aload 22
    //   1143: getfield 449	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_video_source_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1146: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1149: iconst_1
    //   1150: if_icmpne +3990 -> 5140
    //   1153: iconst_1
    //   1154: istore 11
    //   1156: aload 21
    //   1158: iload 11
    //   1160: putfield 452	com/tencent/biz/pubaccount/VideoInfo:jdField_f_of_type_Boolean	Z
    //   1163: aload 22
    //   1165: getfield 455	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1168: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1171: ifeq +30 -> 1201
    //   1174: aload 22
    //   1176: getfield 455	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1179: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1182: ifnull +19 -> 1201
    //   1185: aload 21
    //   1187: aload 22
    //   1189: getfield 455	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1192: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1195: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1198: putfield 457	com/tencent/biz/pubaccount/VideoInfo:jdField_o_of_type_JavaLangString	Ljava/lang/String;
    //   1201: aload 22
    //   1203: getfield 460	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1206: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1209: ifeq +30 -> 1239
    //   1212: aload 22
    //   1214: getfield 460	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1217: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1220: ifnull +19 -> 1239
    //   1223: aload 21
    //   1225: aload 22
    //   1227: getfield 460	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1230: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1233: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1236: putfield 463	com/tencent/biz/pubaccount/VideoInfo:p	Ljava/lang/String;
    //   1239: aload 22
    //   1241: getfield 466	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_account_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1244: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1247: ifeq +25 -> 1272
    //   1250: aload 22
    //   1252: getfield 466	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_account_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1255: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1258: iconst_1
    //   1259: if_icmpne +3887 -> 5146
    //   1262: iconst_1
    //   1263: istore 11
    //   1265: aload 21
    //   1267: iload 11
    //   1269: putfield 468	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Boolean	Z
    //   1272: aload 22
    //   1274: getfield 471	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_myself_like_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1277: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1280: ifeq +25 -> 1305
    //   1283: aload 22
    //   1285: getfield 471	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_myself_like_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1288: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1291: iconst_1
    //   1292: if_icmpne +3860 -> 5152
    //   1295: iconst_1
    //   1296: istore 11
    //   1298: aload 21
    //   1300: iload 11
    //   1302: putfield 473	com/tencent/biz/pubaccount/VideoInfo:jdField_h_of_type_Boolean	Z
    //   1305: aload 22
    //   1307: getfield 476	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_report_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1310: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1313: ifeq +17 -> 1330
    //   1316: aload 21
    //   1318: aload_0
    //   1319: aload 22
    //   1321: getfield 476	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_report_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1324: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   1327: putfield 481	com/tencent/biz/pubaccount/VideoInfo:q	Ljava/lang/String;
    //   1330: aload 22
    //   1332: getfield 485	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_top_bar_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo;
    //   1335: invokevirtual 488	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:has	()Z
    //   1338: ifeq +127 -> 1465
    //   1341: aload 22
    //   1343: getfield 485	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_top_bar_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo;
    //   1346: invokevirtual 491	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1349: ifnull +116 -> 1465
    //   1352: aload 22
    //   1354: getfield 485	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_top_bar_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo;
    //   1357: astore_1
    //   1358: new 493	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo
    //   1361: dup
    //   1362: invokespecial 494	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:<init>	()V
    //   1365: astore 23
    //   1367: aload_1
    //   1368: getfield 497	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:uint32_topbar_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1371: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1374: ifeq +3784 -> 5158
    //   1377: aload_1
    //   1378: getfield 497	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:uint32_topbar_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1381: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1384: istore 4
    //   1386: aload 23
    //   1388: iload 4
    //   1390: putfield 498	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_a_of_type_Int	I
    //   1393: aload 23
    //   1395: aload_0
    //   1396: aload_1
    //   1397: getfield 501	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1400: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   1403: putfield 502	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1406: aload 23
    //   1408: aload_0
    //   1409: aload_1
    //   1410: getfield 505	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1413: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   1416: putfield 506	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1419: aload 23
    //   1421: aload_0
    //   1422: aload_1
    //   1423: getfield 509	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1426: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   1429: putfield 510	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1432: aload_1
    //   1433: getfield 513	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:uint32_jump_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1436: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1439: ifeq +3725 -> 5164
    //   1442: aload_1
    //   1443: getfield 513	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:uint32_jump_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1446: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1449: istore 4
    //   1451: aload 23
    //   1453: iload 4
    //   1455: putfield 515	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_b_of_type_Int	I
    //   1458: aload 21
    //   1460: aload 23
    //   1462: putfield 518	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo	Lcom/tencent/biz/pubaccount/VideoInfo$TopBarInfo;
    //   1465: aload 22
    //   1467: getfield 521	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1470: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1473: ifeq +345 -> 1818
    //   1476: aload 22
    //   1478: getfield 521	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1481: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1484: astore_1
    //   1485: aload_1
    //   1486: ifnull +332 -> 1818
    //   1489: new 523	org/json/JSONObject
    //   1492: dup
    //   1493: aload 22
    //   1495: getfield 521	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1498: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1501: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1504: invokespecial 524	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1507: ldc_w 526
    //   1510: invokevirtual 530	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1513: iconst_0
    //   1514: invokevirtual 536	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   1517: astore_1
    //   1518: aload_1
    //   1519: ifnull +299 -> 1818
    //   1522: aload 21
    //   1524: aload_1
    //   1525: ldc_w 538
    //   1528: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1531: putfield 188	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1534: aload_1
    //   1535: ldc_w 543
    //   1538: invokevirtual 546	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1541: ifeq +15 -> 1556
    //   1544: aload 21
    //   1546: aload_1
    //   1547: ldc_w 543
    //   1550: invokevirtual 550	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1553: putfield 551	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_Int	I
    //   1556: aload_1
    //   1557: ldc_w 553
    //   1560: invokevirtual 546	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1563: ifeq +15 -> 1578
    //   1566: aload 21
    //   1568: aload_1
    //   1569: ldc_w 553
    //   1572: invokevirtual 550	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1575: putfield 555	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Int	I
    //   1578: aload_1
    //   1579: ldc_w 557
    //   1582: invokevirtual 546	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1585: istore 11
    //   1587: iload 11
    //   1589: ifeq +18 -> 1607
    //   1592: aload 21
    //   1594: aload_1
    //   1595: ldc_w 557
    //   1598: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1601: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1604: putfield 564	com/tencent/biz/pubaccount/VideoInfo:jdField_d_of_type_Int	I
    //   1607: aload 21
    //   1609: aload_1
    //   1610: ldc_w 566
    //   1613: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1616: putfield 181	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1619: aload_1
    //   1620: ldc_w 568
    //   1623: invokevirtual 546	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1626: ifeq +15 -> 1641
    //   1629: aload 21
    //   1631: aload_1
    //   1632: ldc_w 568
    //   1635: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1638: putfield 571	com/tencent/biz/pubaccount/VideoInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1641: aload 21
    //   1643: iconst_1
    //   1644: putfield 572	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Int	I
    //   1647: aload_1
    //   1648: ldc_w 574
    //   1651: invokevirtual 546	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1654: ifeq +15 -> 1669
    //   1657: aload 21
    //   1659: aload_1
    //   1660: ldc_w 574
    //   1663: invokevirtual 550	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1666: putfield 572	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Int	I
    //   1669: aload 21
    //   1671: getfield 572	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Int	I
    //   1674: iconst_1
    //   1675: if_icmpeq +77 -> 1752
    //   1678: aload 21
    //   1680: aload_1
    //   1681: ldc_w 576
    //   1684: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1687: putfield 579	com/tencent/biz/pubaccount/VideoInfo:l	Ljava/lang/String;
    //   1690: aload 21
    //   1692: aload_1
    //   1693: ldc_w 581
    //   1696: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1699: putfield 176	com/tencent/biz/pubaccount/VideoInfo:m	Ljava/lang/String;
    //   1702: aload_1
    //   1703: ldc_w 583
    //   1706: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1709: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1712: ifne +15 -> 1727
    //   1715: aload 21
    //   1717: aload_1
    //   1718: ldc_w 583
    //   1721: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1724: putfield 186	com/tencent/biz/pubaccount/VideoInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1727: aload_1
    //   1728: ldc_w 585
    //   1731: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1734: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1737: ifne +15 -> 1752
    //   1740: aload 21
    //   1742: aload_1
    //   1743: ldc_w 585
    //   1746: invokevirtual 541	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1749: putfield 392	com/tencent/biz/pubaccount/VideoInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1752: aload_1
    //   1753: ldc_w 587
    //   1756: invokevirtual 590	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1759: astore_1
    //   1760: aload_1
    //   1761: ifnull +57 -> 1818
    //   1764: iconst_0
    //   1765: istore 4
    //   1767: iload 4
    //   1769: aload_1
    //   1770: invokevirtual 593	org/json/JSONArray:length	()I
    //   1773: if_icmpge +45 -> 1818
    //   1776: aload_1
    //   1777: iload 4
    //   1779: invokevirtual 536	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   1782: astore_3
    //   1783: aload_3
    //   1784: ifnull +3386 -> 5170
    //   1787: aload_3
    //   1788: ldc_w 595
    //   1791: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1794: istore 5
    //   1796: aload_3
    //   1797: ldc_w 600
    //   1800: invokevirtual 604	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1803: lstore 18
    //   1805: iload 5
    //   1807: iconst_2
    //   1808: if_icmpne +3362 -> 5170
    //   1811: aload 21
    //   1813: lload 18
    //   1815: putfield 606	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_Long	J
    //   1818: aload 22
    //   1820: getfield 609	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_is_ugc	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1823: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1826: ifeq +392 -> 2218
    //   1829: aload 22
    //   1831: getfield 609	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_is_ugc	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1834: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1837: iconst_1
    //   1838: if_icmpne +380 -> 2218
    //   1841: aload 21
    //   1843: iconst_1
    //   1844: putfield 611	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_Boolean	Z
    //   1847: aload 22
    //   1849: getfield 615	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo;
    //   1852: invokevirtual 618	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:has	()Z
    //   1855: ifeq +358 -> 2213
    //   1858: aload 22
    //   1860: getfield 615	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo;
    //   1863: invokevirtual 619	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1866: ifnull +347 -> 2213
    //   1869: aload 22
    //   1871: getfield 615	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo;
    //   1874: invokevirtual 619	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1877: checkcast 617	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo
    //   1880: astore_1
    //   1881: aload_1
    //   1882: invokevirtual 618	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:has	()Z
    //   1885: ifeq +328 -> 2213
    //   1888: aload_1
    //   1889: getfield 623	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo;
    //   1892: invokevirtual 626	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:has	()Z
    //   1895: ifeq +93 -> 1988
    //   1898: aload_1
    //   1899: getfield 623	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo;
    //   1902: invokevirtual 627	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1905: ifnull +83 -> 1988
    //   1908: aload_1
    //   1909: getfield 623	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo;
    //   1912: invokevirtual 627	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1915: checkcast 625	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo
    //   1918: getfield 630	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:uint64_feeds_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1921: invokevirtual 266	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1924: ifeq +24 -> 1948
    //   1927: aload 21
    //   1929: aload_1
    //   1930: getfield 623	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo;
    //   1933: invokevirtual 627	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1936: checkcast 625	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo
    //   1939: getfield 630	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:uint64_feeds_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1942: invokevirtual 268	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1945: putfield 632	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Long	J
    //   1948: aload_1
    //   1949: getfield 623	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo;
    //   1952: invokevirtual 627	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1955: checkcast 625	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo
    //   1958: getfield 635	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:uint32_feeds_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1961: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1964: ifeq +24 -> 1988
    //   1967: aload 21
    //   1969: aload_1
    //   1970: getfield 623	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo;
    //   1973: invokevirtual 627	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1976: checkcast 625	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo
    //   1979: getfield 635	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsIdInfo:uint32_feeds_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1982: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1985: putfield 637	com/tencent/biz/pubaccount/VideoInfo:jdField_g_of_type_Int	I
    //   1988: aload_1
    //   1989: getfield 640	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:uint32_follow_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1992: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1995: ifeq +24 -> 2019
    //   1998: aload_1
    //   1999: getfield 640	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:uint32_follow_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2002: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2005: iconst_2
    //   2006: if_icmpne +3173 -> 5179
    //   2009: iconst_1
    //   2010: istore 11
    //   2012: aload 21
    //   2014: iload 11
    //   2016: putfield 642	com/tencent/biz/pubaccount/VideoInfo:jdField_g_of_type_Boolean	Z
    //   2019: aload_1
    //   2020: getfield 645	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:uint64_cuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2023: invokevirtual 266	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   2026: ifeq +18 -> 2044
    //   2029: aload 21
    //   2031: aload_1
    //   2032: getfield 645	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:uint64_cuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2035: invokevirtual 268	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2038: invokestatic 647	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2041: putfield 392	com/tencent/biz/pubaccount/VideoInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   2044: aload_1
    //   2045: getfield 651	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:msg_ugc_video_info_list	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo;
    //   2048: invokevirtual 654	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:has	()Z
    //   2051: ifeq +162 -> 2213
    //   2054: aload_1
    //   2055: getfield 651	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:msg_ugc_video_info_list	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo;
    //   2058: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2061: ifnull +152 -> 2213
    //   2064: aload_1
    //   2065: getfield 651	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:msg_ugc_video_info_list	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo;
    //   2068: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2071: checkcast 653	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo
    //   2074: astore_1
    //   2075: aload_1
    //   2076: invokevirtual 654	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:has	()Z
    //   2079: ifeq +134 -> 2213
    //   2082: aload_1
    //   2083: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2086: ifnull +127 -> 2213
    //   2089: aload_1
    //   2090: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2093: checkcast 653	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo
    //   2096: getfield 656	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2099: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2102: ifeq +40 -> 2142
    //   2105: aload_1
    //   2106: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2109: checkcast 653	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo
    //   2112: getfield 656	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2115: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2118: ifnull +24 -> 2142
    //   2121: aload 21
    //   2123: aload_1
    //   2124: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2127: checkcast 653	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo
    //   2130: getfield 656	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2133: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2136: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2139: putfield 178	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2142: aload_1
    //   2143: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2146: checkcast 653	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo
    //   2149: getfield 659	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:uint32_busi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2152: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2155: ifeq +21 -> 2176
    //   2158: aload 21
    //   2160: aload_1
    //   2161: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2164: checkcast 653	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo
    //   2167: getfield 659	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:uint32_busi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2170: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2173: putfield 572	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Int	I
    //   2176: aload_1
    //   2177: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2180: checkcast 653	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo
    //   2183: getfield 662	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:bytes_share_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2186: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2189: ifeq +24 -> 2213
    //   2192: aload 21
    //   2194: aload_1
    //   2195: invokevirtual 655	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2198: checkcast 653	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo
    //   2201: getfield 662	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCVideoInfo:bytes_share_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2204: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2207: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2210: putfield 183	com/tencent/biz/pubaccount/VideoInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   2213: aload 21
    //   2215: invokestatic 667	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:a	(Lcom/tencent/biz/pubaccount/VideoInfo;)V
    //   2218: aload 22
    //   2220: getfield 670	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_label_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2223: invokevirtual 295	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2226: ifeq +257 -> 2483
    //   2229: aload 22
    //   2231: getfield 670	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_label_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2234: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2237: ifnull +246 -> 2483
    //   2240: aload 22
    //   2242: getfield 670	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_label_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2245: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2248: astore_3
    //   2249: aload_3
    //   2250: invokeinterface 307 1 0
    //   2255: ifle +2879 -> 5134
    //   2258: aload 21
    //   2260: new 304	java/util/ArrayList
    //   2263: dup
    //   2264: invokespecial 342	java/util/ArrayList:<init>	()V
    //   2267: putfield 672	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2270: goto +2864 -> 5134
    //   2273: iload 4
    //   2275: aload_3
    //   2276: invokeinterface 307 1 0
    //   2281: if_icmpge +202 -> 2483
    //   2284: aload_3
    //   2285: iload 4
    //   2287: invokeinterface 351 2 0
    //   2292: checkcast 674	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo
    //   2295: astore 23
    //   2297: new 676	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo
    //   2300: dup
    //   2301: invokespecial 677	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:<init>	()V
    //   2304: astore 24
    //   2306: aload 24
    //   2308: aload 23
    //   2310: getfield 680	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:uint32_channel_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2313: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2316: putfield 681	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_a_of_type_Int	I
    //   2319: aload 24
    //   2321: aload 23
    //   2323: getfield 684	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2326: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2329: putfield 685	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_b_of_type_Int	I
    //   2332: aload 23
    //   2334: getfield 688	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2337: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2340: ifnull +2845 -> 5185
    //   2343: aload 23
    //   2345: getfield 688	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2348: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2351: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2354: astore_1
    //   2355: aload 24
    //   2357: aload_1
    //   2358: putfield 689	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2361: aload 23
    //   2363: getfield 692	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_display_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2366: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2369: ifnull +2821 -> 5190
    //   2372: aload 23
    //   2374: getfield 692	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_display_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2377: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2380: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2383: astore_1
    //   2384: aload 24
    //   2386: aload_1
    //   2387: putfield 693	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2390: aload 23
    //   2392: getfield 696	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2395: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2398: ifnull +2797 -> 5195
    //   2401: aload 23
    //   2403: getfield 696	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2406: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2409: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2412: astore_1
    //   2413: aload 24
    //   2415: aload_1
    //   2416: putfield 697	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2419: aload 24
    //   2421: aload 23
    //   2423: getfield 700	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:uint32_is_topic	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2426: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2429: putfield 701	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_c_of_type_Int	I
    //   2432: aload 21
    //   2434: getfield 672	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2437: aload 24
    //   2439: invokevirtual 369	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2442: pop
    //   2443: iload 4
    //   2445: iconst_1
    //   2446: iadd
    //   2447: istore 4
    //   2449: goto -176 -> 2273
    //   2452: astore_1
    //   2453: aload_3
    //   2454: astore_1
    //   2455: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2458: ifeq -940 -> 1518
    //   2461: ldc 208
    //   2463: iconst_2
    //   2464: ldc_w 703
    //   2467: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2470: aload_3
    //   2471: astore_1
    //   2472: goto -954 -> 1518
    //   2475: astore_3
    //   2476: aload_3
    //   2477: invokevirtual 706	java/lang/NumberFormatException:printStackTrace	()V
    //   2480: goto -873 -> 1607
    //   2483: aload 22
    //   2485: getfield 710	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo;
    //   2488: invokevirtual 713	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:has	()Z
    //   2491: ifeq +323 -> 2814
    //   2494: aload 22
    //   2496: getfield 710	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo;
    //   2499: invokevirtual 714	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2502: checkcast 712	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo
    //   2505: getfield 718	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:feeds_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   2508: invokevirtual 721	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   2511: iconst_1
    //   2512: if_icmpne +302 -> 2814
    //   2515: aload 21
    //   2517: new 723	com/tencent/biz/pubaccount/VideoAdInfo
    //   2520: dup
    //   2521: aload_0
    //   2522: getfield 270	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_Long	J
    //   2525: aload 22
    //   2527: getfield 710	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo;
    //   2530: invokevirtual 714	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2533: checkcast 712	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo
    //   2536: getfield 727	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$PosAdInfo;
    //   2539: invokevirtual 730	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$PosAdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2542: checkcast 729	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$PosAdInfo
    //   2545: invokespecial 733	com/tencent/biz/pubaccount/VideoAdInfo:<init>	(JLtencent/im/oidb/cmd0x6cf/oidb_0x6cf$PosAdInfo;)V
    //   2548: putfield 169	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   2551: aload 22
    //   2553: getfield 710	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo;
    //   2556: invokevirtual 714	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2559: checkcast 712	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo
    //   2562: getfield 736	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:rpt_msg_neg_feedback	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2565: invokevirtual 295	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2568: ifeq +28 -> 2596
    //   2571: aload 21
    //   2573: getfield 169	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   2576: aload 22
    //   2578: getfield 710	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo;
    //   2581: invokevirtual 714	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2584: checkcast 712	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo
    //   2587: getfield 736	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$FeedsInfo:rpt_msg_neg_feedback	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2590: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2593: invokevirtual 739	com/tencent/biz/pubaccount/VideoAdInfo:a	(Ljava/util/List;)V
    //   2596: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2599: ifeq +36 -> 2635
    //   2602: ldc 208
    //   2604: iconst_2
    //   2605: new 210	java/lang/StringBuilder
    //   2608: dup
    //   2609: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   2612: ldc_w 741
    //   2615: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2618: aload 21
    //   2620: getfield 169	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   2623: invokevirtual 742	com/tencent/biz/pubaccount/VideoAdInfo:toString	()Ljava/lang/String;
    //   2626: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2632: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2635: aload 21
    //   2637: iconst_1
    //   2638: putfield 744	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Boolean	Z
    //   2641: aload 21
    //   2643: getfield 169	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   2646: getfield 745	com/tencent/biz/pubaccount/VideoAdInfo:jdField_g_of_type_Int	I
    //   2649: istore 4
    //   2651: iload 4
    //   2653: bipush 65
    //   2655: if_icmpne +2545 -> 5200
    //   2658: aload 21
    //   2660: iconst_2
    //   2661: putfield 172	com/tencent/biz/pubaccount/VideoInfo:jdField_h_of_type_Int	I
    //   2664: aload_0
    //   2665: aload 21
    //   2667: invokespecial 747	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/biz/pubaccount/VideoInfo;)Z
    //   2670: ifne +144 -> 2814
    //   2673: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2676: ifeq -2331 -> 345
    //   2679: ldc 208
    //   2681: iconst_2
    //   2682: new 210	java/lang/StringBuilder
    //   2685: dup
    //   2686: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   2689: ldc_w 749
    //   2692: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2695: aload 21
    //   2697: getfield 169	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   2700: getfield 750	com/tencent/biz/pubaccount/VideoAdInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   2703: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2706: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2709: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2712: goto -2367 -> 345
    //   2715: aload 21
    //   2717: iconst_1
    //   2718: putfield 172	com/tencent/biz/pubaccount/VideoInfo:jdField_h_of_type_Int	I
    //   2721: aload_0
    //   2722: aload 21
    //   2724: invokespecial 747	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/biz/pubaccount/VideoInfo;)Z
    //   2727: ifne +87 -> 2814
    //   2730: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2733: ifeq -2388 -> 345
    //   2736: ldc 208
    //   2738: iconst_2
    //   2739: new 210	java/lang/StringBuilder
    //   2742: dup
    //   2743: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   2746: ldc_w 752
    //   2749: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: aload 21
    //   2754: getfield 169	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   2757: getfield 750	com/tencent/biz/pubaccount/VideoAdInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   2760: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2763: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2766: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2769: goto -2424 -> 345
    //   2772: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2775: ifeq -2430 -> 345
    //   2778: ldc 208
    //   2780: iconst_2
    //   2781: new 210	java/lang/StringBuilder
    //   2784: dup
    //   2785: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   2788: ldc_w 754
    //   2791: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: aload 21
    //   2796: getfield 169	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   2799: getfield 750	com/tencent/biz/pubaccount/VideoAdInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   2802: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2805: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2808: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2811: goto -2466 -> 345
    //   2814: aload 22
    //   2816: getfield 758	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_barrage_text_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2819: invokevirtual 761	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   2822: ifeq +102 -> 2924
    //   2825: aload 22
    //   2827: getfield 758	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_barrage_text_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2830: invokevirtual 762	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   2833: ifnull +91 -> 2924
    //   2836: aload 22
    //   2838: getfield 758	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_barrage_text_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2841: invokevirtual 762	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   2844: astore_1
    //   2845: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2848: ifeq +34 -> 2882
    //   2851: ldc 208
    //   2853: iconst_2
    //   2854: new 210	java/lang/StringBuilder
    //   2857: dup
    //   2858: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   2861: ldc_w 764
    //   2864: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2867: aload_1
    //   2868: invokeinterface 307 1 0
    //   2873: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2876: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2879: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2882: aload_1
    //   2883: invokeinterface 318 1 0
    //   2888: astore_1
    //   2889: aload_1
    //   2890: invokeinterface 323 1 0
    //   2895: ifeq +29 -> 2924
    //   2898: aload_1
    //   2899: invokeinterface 327 1 0
    //   2904: checkcast 28	com/tencent/mobileqq/pb/ByteStringMicro
    //   2907: astore_3
    //   2908: aload 21
    //   2910: getfield 766	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2913: aload_3
    //   2914: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2917: invokevirtual 369	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2920: pop
    //   2921: goto -32 -> 2889
    //   2924: aload 21
    //   2926: getfield 744	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Boolean	Z
    //   2929: ifeq +12 -> 2941
    //   2932: aload 21
    //   2934: getfield 172	com/tencent/biz/pubaccount/VideoInfo:jdField_h_of_type_Int	I
    //   2937: iconst_2
    //   2938: if_icmpeq -2593 -> 345
    //   2941: aload_2
    //   2942: aload 21
    //   2944: invokevirtual 369	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2947: pop
    //   2948: goto -2603 -> 345
    //   2951: aload_1
    //   2952: ifnull +10 -> 2962
    //   2955: aload_1
    //   2956: invokevirtual 767	java/util/ArrayList:isEmpty	()Z
    //   2959: ifeq +18 -> 2977
    //   2962: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2965: ifeq +12 -> 2977
    //   2968: ldc 208
    //   2970: iconst_2
    //   2971: ldc_w 769
    //   2974: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2977: aload 26
    //   2979: ldc_w 771
    //   2982: aload_1
    //   2983: invokevirtual 775	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2986: aload 27
    //   2988: getfield 779	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:req_article_summary	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary;
    //   2991: invokevirtual 780	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:has	()Z
    //   2994: ifeq -2380 -> 614
    //   2997: aload 27
    //   2999: getfield 779	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:req_article_summary	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary;
    //   3002: invokevirtual 781	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3005: ifnull -2391 -> 614
    //   3008: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3011: ifeq +12 -> 3023
    //   3014: ldc 208
    //   3016: iconst_2
    //   3017: ldc_w 783
    //   3020: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3023: aload 27
    //   3025: getfield 779	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:req_article_summary	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary;
    //   3028: invokevirtual 781	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3031: checkcast 329	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary
    //   3034: astore 24
    //   3036: aload 24
    //   3038: getfield 333	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3041: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3044: ifeq +2070 -> 5114
    //   3047: aload 24
    //   3049: getfield 333	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3052: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3055: ifnull +2059 -> 5114
    //   3058: aload 24
    //   3060: getfield 333	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3063: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3066: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3069: astore_1
    //   3070: aload 24
    //   3072: getfield 786	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_inner_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3075: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3078: ifeq +2031 -> 5109
    //   3081: aload 24
    //   3083: getfield 786	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_inner_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3086: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3089: ifnull +2020 -> 5109
    //   3092: aload 24
    //   3094: getfield 786	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_inner_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3097: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3100: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3103: astore_2
    //   3104: new 304	java/util/ArrayList
    //   3107: dup
    //   3108: invokespecial 342	java/util/ArrayList:<init>	()V
    //   3111: astore 28
    //   3113: aload 24
    //   3115: getfield 758	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_barrage_text_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3118: invokevirtual 761	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   3121: ifeq +115 -> 3236
    //   3124: aload 24
    //   3126: getfield 758	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_barrage_text_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3129: invokevirtual 762	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   3132: ifnull +104 -> 3236
    //   3135: aload 24
    //   3137: getfield 758	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_recommend_barrage_text_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3140: invokevirtual 762	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   3143: astore_3
    //   3144: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3147: ifeq +34 -> 3181
    //   3150: ldc 208
    //   3152: iconst_2
    //   3153: new 210	java/lang/StringBuilder
    //   3156: dup
    //   3157: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   3160: ldc_w 788
    //   3163: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3166: aload_3
    //   3167: invokeinterface 307 1 0
    //   3172: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3175: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3178: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3181: aload_3
    //   3182: invokeinterface 318 1 0
    //   3187: astore_3
    //   3188: aload_3
    //   3189: invokeinterface 323 1 0
    //   3194: ifeq +42 -> 3236
    //   3197: aload 28
    //   3199: aload_3
    //   3200: invokeinterface 327 1 0
    //   3205: checkcast 28	com/tencent/mobileqq/pb/ByteStringMicro
    //   3208: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3211: invokevirtual 369	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3214: pop
    //   3215: goto -27 -> 3188
    //   3218: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3221: ifeq -235 -> 2986
    //   3224: ldc 208
    //   3226: iconst_2
    //   3227: ldc_w 790
    //   3230: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3233: goto -247 -> 2986
    //   3236: new 304	java/util/ArrayList
    //   3239: dup
    //   3240: invokespecial 342	java/util/ArrayList:<init>	()V
    //   3243: astore 29
    //   3245: aload 24
    //   3247: getfield 341	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_dislike_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3250: invokevirtual 295	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   3253: ifeq +104 -> 3357
    //   3256: aload 24
    //   3258: getfield 341	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_dislike_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3261: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3264: ifnull +93 -> 3357
    //   3267: aload 24
    //   3269: getfield 341	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_dislike_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3272: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3275: astore_3
    //   3276: aload_3
    //   3277: ifnull +80 -> 3357
    //   3280: aload_3
    //   3281: invokeinterface 307 1 0
    //   3286: ifle +71 -> 3357
    //   3289: aload_3
    //   3290: invokeinterface 307 1 0
    //   3295: istore 5
    //   3297: iconst_0
    //   3298: istore 4
    //   3300: iload 4
    //   3302: iload 5
    //   3304: if_icmpge +53 -> 3357
    //   3307: new 347	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo
    //   3310: dup
    //   3311: invokespecial 348	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:<init>	()V
    //   3314: astore 20
    //   3316: aload 20
    //   3318: aload_3
    //   3319: iload 4
    //   3321: invokeinterface 351 2 0
    //   3326: checkcast 353	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$DisLikeInfo
    //   3329: invokevirtual 356	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:a	(Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$DisLikeInfo;)V
    //   3332: aload 20
    //   3334: getfield 357	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3337: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3340: ifeq +6 -> 3346
    //   3343: goto +1897 -> 5240
    //   3346: aload 29
    //   3348: aload 20
    //   3350: invokevirtual 369	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3353: pop
    //   3354: goto +1886 -> 5240
    //   3357: new 304	java/util/ArrayList
    //   3360: dup
    //   3361: invokespecial 342	java/util/ArrayList:<init>	()V
    //   3364: astore 30
    //   3366: aload 24
    //   3368: getfield 670	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_label_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3371: invokevirtual 295	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   3374: ifeq +224 -> 3598
    //   3377: aload 24
    //   3379: getfield 670	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_label_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3382: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3385: ifnull +213 -> 3598
    //   3388: aload 24
    //   3390: getfield 670	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:rpt_label_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3393: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3396: astore 20
    //   3398: aload 20
    //   3400: ifnull +198 -> 3598
    //   3403: aload 20
    //   3405: invokeinterface 307 1 0
    //   3410: ifle +188 -> 3598
    //   3413: aload 20
    //   3415: invokeinterface 307 1 0
    //   3420: istore 5
    //   3422: iconst_0
    //   3423: istore 4
    //   3425: iload 4
    //   3427: iload 5
    //   3429: if_icmpge +169 -> 3598
    //   3432: aload 20
    //   3434: iload 4
    //   3436: invokeinterface 351 2 0
    //   3441: checkcast 674	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo
    //   3444: astore 21
    //   3446: new 676	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo
    //   3449: dup
    //   3450: invokespecial 677	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:<init>	()V
    //   3453: astore 22
    //   3455: aload 22
    //   3457: aload 21
    //   3459: getfield 680	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:uint32_channel_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3462: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3465: putfield 681	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_a_of_type_Int	I
    //   3468: aload 22
    //   3470: aload 21
    //   3472: getfield 684	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3475: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3478: putfield 685	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_b_of_type_Int	I
    //   3481: aload 21
    //   3483: getfield 688	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3486: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3489: ifnull +1760 -> 5249
    //   3492: aload 21
    //   3494: getfield 688	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3497: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3500: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3503: astore_3
    //   3504: aload 22
    //   3506: aload_3
    //   3507: putfield 689	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3510: aload 21
    //   3512: getfield 692	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_display_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3515: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3518: ifnull +1736 -> 5254
    //   3521: aload 21
    //   3523: getfield 692	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_display_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3526: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3529: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3532: astore_3
    //   3533: aload 22
    //   3535: aload_3
    //   3536: putfield 693	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3539: aload 21
    //   3541: getfield 696	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3544: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3547: ifnull +1712 -> 5259
    //   3550: aload 21
    //   3552: getfield 696	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:bytes_channel_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3555: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3558: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3561: astore_3
    //   3562: aload 22
    //   3564: aload_3
    //   3565: putfield 697	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3568: aload 22
    //   3570: aload 21
    //   3572: getfield 700	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ChannelInfo:uint32_is_topic	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3575: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3578: putfield 701	com/tencent/biz/pubaccount/VideoInfo$ChannelInfo:jdField_c_of_type_Int	I
    //   3581: aload 30
    //   3583: aload 22
    //   3585: invokevirtual 369	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3588: pop
    //   3589: iload 4
    //   3591: iconst_1
    //   3592: iadd
    //   3593: istore 4
    //   3595: goto -170 -> 3425
    //   3598: aload 24
    //   3600: getfield 793	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_ads_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3603: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3606: ifeq +1498 -> 5104
    //   3609: aload 24
    //   3611: getfield 793	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_ads_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3614: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3617: ifnull +1487 -> 5104
    //   3620: aload 24
    //   3622: getfield 793	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_ads_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3625: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3628: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3631: astore_3
    //   3632: aload 24
    //   3634: getfield 796	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_ads_guide_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3637: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3640: ifeq +1458 -> 5098
    //   3643: aload 24
    //   3645: getfield 796	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_ads_guide_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3648: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3651: ifnull +1447 -> 5098
    //   3654: aload 24
    //   3656: getfield 796	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_ads_guide_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3659: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3662: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3665: astore 20
    //   3667: aload 24
    //   3669: getfield 444	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_ads_jump_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3672: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3675: ifeq +1417 -> 5092
    //   3678: aload 24
    //   3680: getfield 444	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_ads_jump_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3683: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3686: istore 4
    //   3688: aload 24
    //   3690: getfield 438	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_ads_guide_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3693: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3696: ifeq +1390 -> 5086
    //   3699: aload 24
    //   3701: getfield 438	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_ads_guide_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3704: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3707: istore 5
    //   3709: aload 24
    //   3711: getfield 449	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_video_source_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3714: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3717: ifeq +1363 -> 5080
    //   3720: aload 24
    //   3722: getfield 449	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_video_source_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3725: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3728: iconst_1
    //   3729: if_icmpne +941 -> 4670
    //   3732: iconst_1
    //   3733: istore 11
    //   3735: goto +1529 -> 5264
    //   3738: aload 24
    //   3740: getfield 471	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_myself_like_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3743: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3746: ifeq +1328 -> 5074
    //   3749: aload 24
    //   3751: getfield 471	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_myself_like_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3754: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3757: iconst_1
    //   3758: if_icmpne +918 -> 4676
    //   3761: iconst_1
    //   3762: istore 11
    //   3764: goto +1507 -> 5271
    //   3767: aload 24
    //   3769: getfield 485	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_top_bar_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo;
    //   3772: invokevirtual 488	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:has	()Z
    //   3775: ifeq +1293 -> 5068
    //   3778: aload 24
    //   3780: getfield 485	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_top_bar_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo;
    //   3783: astore 22
    //   3785: new 493	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo
    //   3788: dup
    //   3789: invokespecial 494	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:<init>	()V
    //   3792: astore 21
    //   3794: aload 22
    //   3796: getfield 497	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:uint32_topbar_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3799: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3802: ifeq +880 -> 4682
    //   3805: aload 22
    //   3807: getfield 497	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:uint32_topbar_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3810: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3813: istore 6
    //   3815: aload 21
    //   3817: iload 6
    //   3819: putfield 498	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_a_of_type_Int	I
    //   3822: aload 21
    //   3824: aload_0
    //   3825: aload 22
    //   3827: getfield 501	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3830: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   3833: putfield 502	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3836: aload 21
    //   3838: aload_0
    //   3839: aload 22
    //   3841: getfield 505	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3844: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   3847: putfield 506	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3850: aload 21
    //   3852: aload_0
    //   3853: aload 22
    //   3855: getfield 509	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3858: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   3861: putfield 510	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3864: aload 22
    //   3866: getfield 513	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:uint32_jump_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3869: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3872: ifeq +816 -> 4688
    //   3875: aload 22
    //   3877: getfield 513	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$TopBarInfo:uint32_jump_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3880: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3883: istore 6
    //   3885: aload 21
    //   3887: iload 6
    //   3889: putfield 515	com/tencent/biz/pubaccount/VideoInfo$TopBarInfo:jdField_b_of_type_Int	I
    //   3892: aload 24
    //   3894: getfield 609	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_is_ugc	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3897: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3900: ifeq +1159 -> 5059
    //   3903: aload 24
    //   3905: getfield 609	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_is_ugc	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3908: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3911: iconst_1
    //   3912: if_icmpne +1147 -> 5059
    //   3915: aload 24
    //   3917: getfield 615	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo;
    //   3920: invokevirtual 618	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:has	()Z
    //   3923: ifeq +1127 -> 5050
    //   3926: aload 24
    //   3928: getfield 615	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo;
    //   3931: invokevirtual 619	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3934: ifnull +1116 -> 5050
    //   3937: aload 24
    //   3939: getfield 615	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:msg_ugc_feeds_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo;
    //   3942: invokevirtual 619	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3945: checkcast 617	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo
    //   3948: astore 22
    //   3950: aload 22
    //   3952: getfield 640	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:uint32_follow_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3955: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3958: ifeq +1092 -> 5050
    //   3961: aload 22
    //   3963: getfield 640	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$UGCFeedsInfo:uint32_follow_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3966: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3969: iconst_2
    //   3970: if_icmpne +724 -> 4694
    //   3973: iconst_1
    //   3974: istore 11
    //   3976: goto +1302 -> 5278
    //   3979: aload_1
    //   3980: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3983: ifeq +18 -> 4001
    //   3986: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3989: ifeq +12 -> 4001
    //   3992: ldc 208
    //   3994: iconst_2
    //   3995: ldc_w 798
    //   3998: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4001: aload 24
    //   4003: getfield 521	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4006: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4009: ifeq +1035 -> 5044
    //   4012: aload 24
    //   4014: getfield 521	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4017: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4020: astore 22
    //   4022: aload 22
    //   4024: ifnull +1020 -> 5044
    //   4027: aconst_null
    //   4028: astore 23
    //   4030: new 523	org/json/JSONObject
    //   4033: dup
    //   4034: aload 24
    //   4036: getfield 521	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4039: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4042: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4045: invokespecial 524	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4048: ldc_w 526
    //   4051: invokevirtual 530	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   4054: iconst_0
    //   4055: invokevirtual 536	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   4058: astore 22
    //   4060: aload 22
    //   4062: ifnull +982 -> 5044
    //   4065: aload 22
    //   4067: ldc_w 587
    //   4070: invokevirtual 590	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   4073: astore 22
    //   4075: aload 22
    //   4077: ifnull +967 -> 5044
    //   4080: iconst_0
    //   4081: istore 6
    //   4083: iload 6
    //   4085: aload 22
    //   4087: invokevirtual 593	org/json/JSONArray:length	()I
    //   4090: if_icmpge +954 -> 5044
    //   4093: aload 22
    //   4095: iload 6
    //   4097: invokevirtual 536	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   4100: astore 23
    //   4102: aload 23
    //   4104: ifnull +1187 -> 5291
    //   4107: aload 23
    //   4109: ldc_w 595
    //   4112: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4115: istore 7
    //   4117: aload 23
    //   4119: ldc_w 600
    //   4122: invokevirtual 604	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   4125: lstore 18
    //   4127: iload 7
    //   4129: iconst_2
    //   4130: if_icmpne +1161 -> 5291
    //   4133: iconst_0
    //   4134: istore 6
    //   4136: aload 24
    //   4138: getfield 416	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_video_comment_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4141: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4144: ifeq +54 -> 4198
    //   4147: aload 24
    //   4149: getfield 416	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_video_comment_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4152: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4155: istore 7
    //   4157: iload 7
    //   4159: istore 6
    //   4161: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4164: ifeq +34 -> 4198
    //   4167: ldc 208
    //   4169: iconst_2
    //   4170: new 210	java/lang/StringBuilder
    //   4173: dup
    //   4174: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   4177: ldc_w 800
    //   4180: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4183: iload 7
    //   4185: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4188: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4191: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4194: iload 7
    //   4196: istore 6
    //   4198: iconst_0
    //   4199: istore 7
    //   4201: aload 24
    //   4203: getfield 423	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_like_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4206: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4209: ifeq +54 -> 4263
    //   4212: aload 24
    //   4214: getfield 423	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_like_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4217: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4220: istore 8
    //   4222: iload 8
    //   4224: istore 7
    //   4226: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4229: ifeq +34 -> 4263
    //   4232: ldc 208
    //   4234: iconst_2
    //   4235: new 210	java/lang/StringBuilder
    //   4238: dup
    //   4239: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   4242: ldc_w 802
    //   4245: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4248: iload 8
    //   4250: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4253: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4256: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4259: iload 8
    //   4261: istore 7
    //   4263: aload 24
    //   4265: getfield 455	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4268: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4271: ifeq +767 -> 5038
    //   4274: aload 24
    //   4276: getfield 455	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4279: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4282: ifnull +756 -> 5038
    //   4285: aload 24
    //   4287: getfield 455	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_txt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4290: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4293: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4296: astore 22
    //   4298: aload 24
    //   4300: getfield 460	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4303: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4306: ifeq +726 -> 5032
    //   4309: aload 24
    //   4311: getfield 460	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4314: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4317: ifnull +715 -> 5032
    //   4320: aload 24
    //   4322: getfield 460	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_subscript_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4325: invokevirtual 26	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4328: invokevirtual 32	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4331: astore 23
    //   4333: aload 24
    //   4335: getfield 466	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_account_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4338: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4341: ifeq +685 -> 5026
    //   4344: aload 24
    //   4346: getfield 466	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_account_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4349: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4352: iconst_1
    //   4353: if_icmpne +947 -> 5300
    //   4356: iconst_1
    //   4357: istore 13
    //   4359: goto +925 -> 5284
    //   4362: aload 26
    //   4364: ldc_w 804
    //   4367: aload 29
    //   4369: invokevirtual 775	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4372: iconst_0
    //   4373: istore 8
    //   4375: aload 24
    //   4377: getfield 431	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_biu_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4380: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4383: ifeq +54 -> 4437
    //   4386: aload 24
    //   4388: getfield 431	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_biu_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4391: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4394: istore 9
    //   4396: iload 9
    //   4398: istore 8
    //   4400: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4403: ifeq +34 -> 4437
    //   4406: ldc 208
    //   4408: iconst_2
    //   4409: new 210	java/lang/StringBuilder
    //   4412: dup
    //   4413: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   4416: ldc_w 806
    //   4419: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4422: iload 9
    //   4424: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4427: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4430: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4433: iload 9
    //   4435: istore 8
    //   4437: aload 24
    //   4439: getfield 476	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_report_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4442: invokevirtual 22	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4445: ifeq +575 -> 5020
    //   4448: aload_0
    //   4449: aload 24
    //   4451: getfield 476	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_video_report_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4454: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   4457: astore 24
    //   4459: aconst_null
    //   4460: astore 25
    //   4462: aload 27
    //   4464: getfield 810	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:msg_interrupted_ad_weishi	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd;
    //   4467: invokevirtual 813	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:has	()Z
    //   4470: ifeq +297 -> 4767
    //   4473: aload 27
    //   4475: getfield 810	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:msg_interrupted_ad_weishi	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd;
    //   4478: invokevirtual 814	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4481: checkcast 812	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd
    //   4484: astore 27
    //   4486: new 816	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd
    //   4489: dup
    //   4490: invokespecial 817	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd:<init>	()V
    //   4493: astore 25
    //   4495: aload 25
    //   4497: aload_0
    //   4498: aload 27
    //   4500: getfield 820	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:bytes_ad_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4503: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   4506: putfield 821	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4509: aload 27
    //   4511: getfield 824	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:uint32_is_show_in_play_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4514: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4517: ifeq +795 -> 5312
    //   4520: aload 27
    //   4522: getfield 824	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:uint32_is_show_in_play_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4525: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4528: iconst_1
    //   4529: if_icmpne +777 -> 5306
    //   4532: iconst_1
    //   4533: istore 13
    //   4535: aload 25
    //   4537: iload 13
    //   4539: putfield 825	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd:jdField_b_of_type_Boolean	Z
    //   4542: aload 27
    //   4544: getfield 828	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:uint32_is_show_in_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4547: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4550: ifeq +774 -> 5324
    //   4553: aload 27
    //   4555: getfield 828	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:uint32_is_show_in_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4558: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4561: iconst_1
    //   4562: if_icmpne +756 -> 5318
    //   4565: iconst_1
    //   4566: istore 13
    //   4568: aload 25
    //   4570: iload 13
    //   4572: putfield 829	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd:jdField_a_of_type_Boolean	Z
    //   4575: aload 27
    //   4577: getfield 832	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:uint32_show_after_play_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4580: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4583: ifeq +747 -> 5330
    //   4586: aload 27
    //   4588: getfield 832	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:uint32_show_after_play_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4591: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4594: istore 9
    //   4596: aload 25
    //   4598: iload 9
    //   4600: putfield 833	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd:jdField_a_of_type_Int	I
    //   4603: aload_0
    //   4604: aload 27
    //   4606: getfield 836	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:bytes_show_positon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4609: invokespecial 478	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   4612: ldc_w 838
    //   4615: invokevirtual 842	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4618: astore 27
    //   4620: aload 25
    //   4622: aload 27
    //   4624: arraylength
    //   4625: newarray int
    //   4627: putfield 845	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd:jdField_a_of_type_ArrayOfInt	[I
    //   4630: iconst_0
    //   4631: istore 9
    //   4633: aload 27
    //   4635: arraylength
    //   4636: istore 10
    //   4638: iload 9
    //   4640: iload 10
    //   4642: if_icmpge +86 -> 4728
    //   4645: aload 25
    //   4647: getfield 845	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd:jdField_a_of_type_ArrayOfInt	[I
    //   4650: iload 9
    //   4652: aload 27
    //   4654: iload 9
    //   4656: aaload
    //   4657: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4660: iastore
    //   4661: iload 9
    //   4663: iconst_1
    //   4664: iadd
    //   4665: istore 9
    //   4667: goto -34 -> 4633
    //   4670: iconst_0
    //   4671: istore 11
    //   4673: goto +591 -> 5264
    //   4676: iconst_0
    //   4677: istore 11
    //   4679: goto +592 -> 5271
    //   4682: iconst_m1
    //   4683: istore 6
    //   4685: goto -870 -> 3815
    //   4688: iconst_0
    //   4689: istore 6
    //   4691: goto -806 -> 3885
    //   4694: iconst_0
    //   4695: istore 11
    //   4697: goto +581 -> 5278
    //   4700: astore 22
    //   4702: aload 23
    //   4704: astore 22
    //   4706: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4709: ifeq -649 -> 4060
    //   4712: ldc 208
    //   4714: iconst_2
    //   4715: ldc_w 847
    //   4718: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4721: aload 23
    //   4723: astore 22
    //   4725: goto -665 -> 4060
    //   4728: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4731: ifeq +605 -> 5336
    //   4734: ldc 208
    //   4736: iconst_2
    //   4737: new 210	java/lang/StringBuilder
    //   4740: dup
    //   4741: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   4744: ldc_w 849
    //   4747: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4750: aload 25
    //   4752: invokevirtual 850	com/tencent/biz/pubaccount/VideoInfo$InterruptedWeishiAd:toString	()Ljava/lang/String;
    //   4755: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4758: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4761: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4764: goto +572 -> 5336
    //   4767: aload 26
    //   4769: ldc_w 804
    //   4772: aload 29
    //   4774: invokevirtual 775	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4777: aload 26
    //   4779: ldc_w 852
    //   4782: aload_1
    //   4783: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4786: aload 26
    //   4788: ldc_w 854
    //   4791: aload_2
    //   4792: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4795: aload 26
    //   4797: ldc_w 856
    //   4800: lload 18
    //   4802: invokevirtual 860	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   4805: aload 26
    //   4807: ldc_w 862
    //   4810: aload 28
    //   4812: invokevirtual 865	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4815: aload 26
    //   4817: ldc_w 867
    //   4820: iload 6
    //   4822: invokevirtual 871	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4825: aload 26
    //   4827: ldc_w 873
    //   4830: iload 7
    //   4832: invokevirtual 871	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4835: aload 26
    //   4837: ldc_w 875
    //   4840: iload 8
    //   4842: invokevirtual 871	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4845: aload 26
    //   4847: ldc_w 877
    //   4850: aload_3
    //   4851: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4854: aload 26
    //   4856: ldc_w 879
    //   4859: aload 20
    //   4861: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4864: aload 26
    //   4866: ldc_w 881
    //   4869: iload 4
    //   4871: invokevirtual 871	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4874: aload 26
    //   4876: ldc_w 883
    //   4879: iload 5
    //   4881: invokevirtual 871	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4884: aload 26
    //   4886: ldc_w 885
    //   4889: iload 15
    //   4891: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   4894: aload 26
    //   4896: ldc_w 887
    //   4899: aload 22
    //   4901: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4904: aload 26
    //   4906: ldc_w 889
    //   4909: aload 23
    //   4911: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4914: aload 26
    //   4916: ldc_w 891
    //   4919: iload 17
    //   4921: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   4924: aload 26
    //   4926: ldc_w 893
    //   4929: iload 16
    //   4931: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   4934: aload 26
    //   4936: ldc_w 895
    //   4939: iload 11
    //   4941: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   4944: aload 26
    //   4946: ldc_w 897
    //   4949: iload 12
    //   4951: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   4954: aload 26
    //   4956: ldc_w 899
    //   4959: aload 30
    //   4961: invokevirtual 775	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4964: aload 26
    //   4966: ldc_w 901
    //   4969: aload 21
    //   4971: invokevirtual 905	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   4974: aload 26
    //   4976: ldc_w 907
    //   4979: aload 24
    //   4981: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4984: aload 26
    //   4986: ldc_w 909
    //   4989: aload 25
    //   4991: invokevirtual 905	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   4994: goto -4380 -> 614
    //   4997: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5000: ifeq -4386 -> 614
    //   5003: ldc 208
    //   5005: iconst_2
    //   5006: ldc_w 911
    //   5009: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5012: goto -4398 -> 614
    //   5015: astore 31
    //   5017: goto -356 -> 4661
    //   5020: aconst_null
    //   5021: astore 24
    //   5023: goto -564 -> 4459
    //   5026: iconst_0
    //   5027: istore 17
    //   5029: goto -667 -> 4362
    //   5032: aconst_null
    //   5033: astore 23
    //   5035: goto -702 -> 4333
    //   5038: aconst_null
    //   5039: astore 22
    //   5041: goto -743 -> 4298
    //   5044: lconst_0
    //   5045: lstore 18
    //   5047: goto -914 -> 4133
    //   5050: iconst_0
    //   5051: istore 11
    //   5053: iconst_1
    //   5054: istore 12
    //   5056: goto -1077 -> 3979
    //   5059: iconst_0
    //   5060: istore 11
    //   5062: iconst_0
    //   5063: istore 12
    //   5065: goto -1086 -> 3979
    //   5068: aconst_null
    //   5069: astore 21
    //   5071: goto -1179 -> 3892
    //   5074: iconst_0
    //   5075: istore 16
    //   5077: goto -1310 -> 3767
    //   5080: iconst_0
    //   5081: istore 15
    //   5083: goto -1345 -> 3738
    //   5086: iconst_0
    //   5087: istore 5
    //   5089: goto -1380 -> 3709
    //   5092: iconst_0
    //   5093: istore 4
    //   5095: goto -1407 -> 3688
    //   5098: aconst_null
    //   5099: astore 20
    //   5101: goto -1434 -> 3667
    //   5104: aconst_null
    //   5105: astore_3
    //   5106: goto -1474 -> 3632
    //   5109: aconst_null
    //   5110: astore_2
    //   5111: goto -2007 -> 3104
    //   5114: aconst_null
    //   5115: astore_1
    //   5116: goto -2046 -> 3070
    //   5119: iload 4
    //   5121: iconst_1
    //   5122: iadd
    //   5123: istore 4
    //   5125: goto -4604 -> 521
    //   5128: iconst_0
    //   5129: istore 14
    //   5131: goto -5117 -> 14
    //   5134: iconst_0
    //   5135: istore 4
    //   5137: goto -2864 -> 2273
    //   5140: iconst_0
    //   5141: istore 11
    //   5143: goto -3987 -> 1156
    //   5146: iconst_0
    //   5147: istore 11
    //   5149: goto -3884 -> 1265
    //   5152: iconst_0
    //   5153: istore 11
    //   5155: goto -3857 -> 1298
    //   5158: iconst_m1
    //   5159: istore 4
    //   5161: goto -3775 -> 1386
    //   5164: iconst_0
    //   5165: istore 4
    //   5167: goto -3716 -> 1451
    //   5170: iload 4
    //   5172: iconst_1
    //   5173: iadd
    //   5174: istore 4
    //   5176: goto -3409 -> 1767
    //   5179: iconst_0
    //   5180: istore 11
    //   5182: goto -3170 -> 2012
    //   5185: aconst_null
    //   5186: astore_1
    //   5187: goto -2832 -> 2355
    //   5190: aconst_null
    //   5191: astore_1
    //   5192: goto -2808 -> 2384
    //   5195: aconst_null
    //   5196: astore_1
    //   5197: goto -2784 -> 2413
    //   5200: iload 4
    //   5202: sipush 185
    //   5205: if_icmpeq -2490 -> 2715
    //   5208: iload 4
    //   5210: sipush 350
    //   5213: if_icmpeq -2498 -> 2715
    //   5216: iload 4
    //   5218: sipush 450
    //   5221: if_icmpeq -2506 -> 2715
    //   5224: iload 4
    //   5226: sipush 1122
    //   5229: if_icmpne -2457 -> 2772
    //   5232: goto -2517 -> 2715
    //   5235: aload_2
    //   5236: astore_1
    //   5237: goto -2286 -> 2951
    //   5240: iload 4
    //   5242: iconst_1
    //   5243: iadd
    //   5244: istore 4
    //   5246: goto -1946 -> 3300
    //   5249: aconst_null
    //   5250: astore_3
    //   5251: goto -1747 -> 3504
    //   5254: aconst_null
    //   5255: astore_3
    //   5256: goto -1723 -> 3533
    //   5259: aconst_null
    //   5260: astore_3
    //   5261: goto -1699 -> 3562
    //   5264: iload 11
    //   5266: istore 15
    //   5268: goto -1530 -> 3738
    //   5271: iload 11
    //   5273: istore 16
    //   5275: goto -1508 -> 3767
    //   5278: iconst_1
    //   5279: istore 12
    //   5281: goto -1302 -> 3979
    //   5284: iload 13
    //   5286: istore 17
    //   5288: goto -926 -> 4362
    //   5291: iload 6
    //   5293: iconst_1
    //   5294: iadd
    //   5295: istore 6
    //   5297: goto -1214 -> 4083
    //   5300: iconst_0
    //   5301: istore 13
    //   5303: goto -19 -> 5284
    //   5306: iconst_0
    //   5307: istore 13
    //   5309: goto -774 -> 4535
    //   5312: iconst_0
    //   5313: istore 13
    //   5315: goto -780 -> 4535
    //   5318: iconst_0
    //   5319: istore 13
    //   5321: goto -753 -> 4568
    //   5324: iconst_0
    //   5325: istore 13
    //   5327: goto -759 -> 4568
    //   5330: iconst_m1
    //   5331: istore 9
    //   5333: goto -737 -> 4596
    //   5336: goto -569 -> 4767
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5339	0	this	VideoPlayRecommendHandler
    //   0	5339	1	paramToServiceMsg	ToServiceMsg
    //   0	5339	2	paramFromServiceMsg	FromServiceMsg
    //   0	5339	3	paramObject	Object
    //   519	4726	4	i	int
    //   504	4584	5	j	int
    //   3813	1483	6	k	int
    //   4115	716	7	m	int
    //   4220	621	8	n	int
    //   4394	938	9	i1	int
    //   4636	7	10	i2	int
    //   1154	4118	11	bool1	boolean
    //   4949	331	12	bool2	boolean
    //   4357	969	13	bool3	boolean
    //   12	5118	14	bool4	boolean
    //   4889	378	15	bool5	boolean
    //   4929	345	16	bool6	boolean
    //   4919	368	17	bool7	boolean
    //   1803	3243	18	l	long
    //   343	4757	20	localObject1	Object
    //   376	4694	21	localObject2	Object
    //   365	3932	22	localObject3	Object
    //   4700	1	22	localJSONException	org.json.JSONException
    //   4704	336	22	localObject4	Object
    //   535	4499	23	localObject5	Object
    //   2304	2718	24	localObject6	Object
    //   4460	530	25	localInterruptedWeishiAd	VideoInfo.InterruptedWeishiAd
    //   21	4964	26	localBundle	android.os.Bundle
    //   144	4509	27	localObject7	Object
    //   3111	1700	28	localArrayList1	ArrayList
    //   3243	1530	29	localArrayList2	ArrayList
    //   3364	1596	30	localArrayList3	ArrayList
    //   5015	1	31	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   62	118	578	java/lang/Exception
    //   118	126	578	java/lang/Exception
    //   126	176	578	java/lang/Exception
    //   176	217	578	java/lang/Exception
    //   217	238	578	java/lang/Exception
    //   238	269	578	java/lang/Exception
    //   277	337	578	java/lang/Exception
    //   337	345	578	java/lang/Exception
    //   345	367	578	java/lang/Exception
    //   369	416	578	java/lang/Exception
    //   416	454	578	java/lang/Exception
    //   454	485	578	java/lang/Exception
    //   489	518	578	java/lang/Exception
    //   528	564	578	java/lang/Exception
    //   567	575	578	java/lang/Exception
    //   624	635	578	java/lang/Exception
    //   638	702	578	java/lang/Exception
    //   702	740	578	java/lang/Exception
    //   740	778	578	java/lang/Exception
    //   778	816	578	java/lang/Exception
    //   816	840	578	java/lang/Exception
    //   840	864	578	java/lang/Exception
    //   864	902	578	java/lang/Exception
    //   902	962	578	java/lang/Exception
    //   962	1022	578	java/lang/Exception
    //   1022	1082	578	java/lang/Exception
    //   1082	1106	578	java/lang/Exception
    //   1106	1130	578	java/lang/Exception
    //   1130	1153	578	java/lang/Exception
    //   1156	1163	578	java/lang/Exception
    //   1163	1201	578	java/lang/Exception
    //   1201	1239	578	java/lang/Exception
    //   1239	1262	578	java/lang/Exception
    //   1265	1272	578	java/lang/Exception
    //   1272	1295	578	java/lang/Exception
    //   1298	1305	578	java/lang/Exception
    //   1305	1330	578	java/lang/Exception
    //   1330	1386	578	java/lang/Exception
    //   1386	1451	578	java/lang/Exception
    //   1451	1465	578	java/lang/Exception
    //   1465	1485	578	java/lang/Exception
    //   1489	1518	578	java/lang/Exception
    //   1522	1556	578	java/lang/Exception
    //   1556	1578	578	java/lang/Exception
    //   1578	1587	578	java/lang/Exception
    //   1592	1607	578	java/lang/Exception
    //   1607	1641	578	java/lang/Exception
    //   1641	1669	578	java/lang/Exception
    //   1669	1727	578	java/lang/Exception
    //   1727	1752	578	java/lang/Exception
    //   1752	1760	578	java/lang/Exception
    //   1767	1783	578	java/lang/Exception
    //   1787	1805	578	java/lang/Exception
    //   1811	1818	578	java/lang/Exception
    //   1818	1948	578	java/lang/Exception
    //   1948	1988	578	java/lang/Exception
    //   1988	2009	578	java/lang/Exception
    //   2012	2019	578	java/lang/Exception
    //   2019	2044	578	java/lang/Exception
    //   2044	2142	578	java/lang/Exception
    //   2142	2176	578	java/lang/Exception
    //   2176	2213	578	java/lang/Exception
    //   2213	2218	578	java/lang/Exception
    //   2218	2270	578	java/lang/Exception
    //   2273	2355	578	java/lang/Exception
    //   2355	2384	578	java/lang/Exception
    //   2384	2413	578	java/lang/Exception
    //   2413	2443	578	java/lang/Exception
    //   2455	2470	578	java/lang/Exception
    //   2476	2480	578	java/lang/Exception
    //   2483	2596	578	java/lang/Exception
    //   2596	2635	578	java/lang/Exception
    //   2635	2651	578	java/lang/Exception
    //   2658	2712	578	java/lang/Exception
    //   2715	2769	578	java/lang/Exception
    //   2772	2811	578	java/lang/Exception
    //   2814	2882	578	java/lang/Exception
    //   2882	2889	578	java/lang/Exception
    //   2889	2921	578	java/lang/Exception
    //   2924	2941	578	java/lang/Exception
    //   2941	2948	578	java/lang/Exception
    //   2955	2962	578	java/lang/Exception
    //   2962	2977	578	java/lang/Exception
    //   2977	2986	578	java/lang/Exception
    //   2986	3023	578	java/lang/Exception
    //   3023	3070	578	java/lang/Exception
    //   3070	3104	578	java/lang/Exception
    //   3104	3181	578	java/lang/Exception
    //   3181	3188	578	java/lang/Exception
    //   3188	3215	578	java/lang/Exception
    //   3218	3233	578	java/lang/Exception
    //   3236	3276	578	java/lang/Exception
    //   3280	3297	578	java/lang/Exception
    //   3307	3343	578	java/lang/Exception
    //   3346	3354	578	java/lang/Exception
    //   3357	3398	578	java/lang/Exception
    //   3403	3422	578	java/lang/Exception
    //   3432	3504	578	java/lang/Exception
    //   3504	3533	578	java/lang/Exception
    //   3533	3562	578	java/lang/Exception
    //   3562	3589	578	java/lang/Exception
    //   3598	3632	578	java/lang/Exception
    //   3632	3667	578	java/lang/Exception
    //   3667	3688	578	java/lang/Exception
    //   3688	3709	578	java/lang/Exception
    //   3709	3732	578	java/lang/Exception
    //   3738	3761	578	java/lang/Exception
    //   3767	3815	578	java/lang/Exception
    //   3815	3885	578	java/lang/Exception
    //   3885	3892	578	java/lang/Exception
    //   3892	3973	578	java/lang/Exception
    //   3979	4001	578	java/lang/Exception
    //   4001	4022	578	java/lang/Exception
    //   4030	4060	578	java/lang/Exception
    //   4065	4075	578	java/lang/Exception
    //   4083	4102	578	java/lang/Exception
    //   4107	4127	578	java/lang/Exception
    //   4136	4157	578	java/lang/Exception
    //   4161	4194	578	java/lang/Exception
    //   4201	4222	578	java/lang/Exception
    //   4226	4259	578	java/lang/Exception
    //   4263	4298	578	java/lang/Exception
    //   4298	4333	578	java/lang/Exception
    //   4333	4356	578	java/lang/Exception
    //   4362	4372	578	java/lang/Exception
    //   4375	4396	578	java/lang/Exception
    //   4400	4433	578	java/lang/Exception
    //   4437	4459	578	java/lang/Exception
    //   4462	4532	578	java/lang/Exception
    //   4535	4565	578	java/lang/Exception
    //   4568	4596	578	java/lang/Exception
    //   4596	4630	578	java/lang/Exception
    //   4633	4638	578	java/lang/Exception
    //   4706	4721	578	java/lang/Exception
    //   4728	4764	578	java/lang/Exception
    //   4767	4994	578	java/lang/Exception
    //   1489	1518	2452	org/json/JSONException
    //   1592	1607	2475	java/lang/NumberFormatException
    //   4030	4060	4700	org/json/JSONException
    //   4645	4661	5015	java/lang/Exception
  }
  
  protected Class a()
  {
    return VideoPlayRecommendObserver.class;
  }
  
  public void a(long paramLong1, VideoInfo paramVideoInfo, int paramInt, ArrayList paramArrayList, String paramString1, long paramLong2, boolean paramBoolean, String paramString2, String paramString3)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    if (paramVideoInfo.jdField_g_of_type_JavaLangString == null) {
      paramVideoInfo.jdField_g_of_type_JavaLangString = "";
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  articleId = " + paramVideoInfo.jdField_g_of_type_JavaLangString + ", secondVideoArticleID = " + paramString1 + ", type = " + paramInt + ",polymericTopicId = " + paramLong2);
    }
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    Object localObject = ByteStringMicro.copyFromUtf8(paramVideoInfo.jdField_g_of_type_JavaLangString);
    localReqBody.bytes_inner_id.set((ByteStringMicro)localObject);
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint32_req_source.set(paramInt);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
      localReqBody.rpt_bytes_redo_inner_id.add(paramString1);
    }
    if (paramLong2 != -1L) {
      localReqBody.uint32_req_topic_id.set((int)paramLong2);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
      localReqBody.bytes_req_web.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString3);
      localReqBody.bytes_cookie.set(paramString1);
    }
    paramString2 = new oidb_0x6cf.ReqAdvertisePara();
    paramString2.msg_phone_info.set(a());
    paramString2.uint64_last_time.set(this.jdField_a_of_type_Long);
    paramString1 = new oidb_0x6cf.VideoFloatInfo();
    paramString1.uint32_ad_support.set(1);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      paramString1.uint32_info_num.set(0);
      paramString2.msg_video_float_info.set(paramString1);
      localReqBody.req_advertise_para.set(paramString2);
      localReqBody.uint32_req_dislike_type.set(1);
      paramArrayList = localReqBody.uint32_req_vertical_video;
      if (!paramBoolean) {
        break label786;
      }
      paramInt = 1;
      label360:
      paramArrayList.set(paramInt);
      paramArrayList = localReqBody.uint32_is_ugc;
      if (!paramVideoInfo.jdField_b_of_type_Boolean) {
        break label792;
      }
    }
    label786:
    label792:
    for (paramInt = 1;; paramInt = 0)
    {
      paramArrayList.set(paramInt);
      if (paramVideoInfo.jdField_b_of_type_Boolean)
      {
        paramArrayList = new oidb_0x6cf.FeedsIdInfo();
        paramArrayList.uint64_feeds_id.set(paramVideoInfo.jdField_c_of_type_Long);
        paramArrayList.uint32_feeds_type.set(paramVideoInfo.jdField_g_of_type_Int);
        localReqBody.ugc_feeds_info.set(paramArrayList);
      }
      if (!QLog.isColorLevel()) {
        break label808;
      }
      paramVideoInfo = new StringBuilder("getRecommendList AdvertiseParam:\n");
      paramVideoInfo.append("last_time=").append(this.jdField_a_of_type_Long).append(", info_num=").append(paramString1.uint32_info_num.get());
      if ((!paramString1.rpt_msg_ad_video_pos.has()) || (paramString1.rpt_msg_ad_video_pos.get() == null)) {
        break label798;
      }
      paramVideoInfo.append(", adList=\n");
      paramArrayList = paramString1.rpt_msg_ad_video_pos.get().iterator();
      while (paramArrayList.hasNext())
      {
        paramString1 = (oidb_0x6cf.AdVideoPos)paramArrayList.next();
        paramVideoInfo.append("[pos=").append(paramString1.int32_kd_pos.get()).append(", aid=").append(paramString1.uint64_aid.get()).append(", traceID=").append(paramString1.bytes_trace_id.get().toStringUtf8()).append("]\n");
      }
      paramString3 = new ArrayList();
      int i = 0;
      paramInt = 0;
      if (paramInt < paramArrayList.size())
      {
        localObject = (VideoInfo)paramArrayList.get(paramInt);
        if (!((VideoInfo)localObject).jdField_c_of_type_Boolean) {
          i += 1;
        }
        for (;;)
        {
          paramInt += 1;
          break;
          oidb_0x6cf.AdVideoPos localAdVideoPos = new oidb_0x6cf.AdVideoPos();
          if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
          {
            localAdVideoPos.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString));
            localAdVideoPos.uint64_aid.set(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e);
          }
          localAdVideoPos.int32_kd_pos.set(paramInt);
          paramString3.add(localAdVideoPos);
        }
      }
      paramString1.uint32_info_num.set(i);
      if (paramString3.size() <= 0) {
        break;
      }
      paramString1.rpt_msg_ad_video_pos.set(paramString3);
      break;
      paramInt = 0;
      break label360;
    }
    label798:
    QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramVideoInfo.toString());
    label808:
    super.b(super.a("OidbSvc.0x6cf", 1743, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoPlayRecommendHandler
 * JD-Core Version:    0.7.0.1
 */