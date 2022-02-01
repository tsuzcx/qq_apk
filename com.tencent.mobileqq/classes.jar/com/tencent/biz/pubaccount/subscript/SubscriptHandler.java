package com.tencent.biz.pubaccount.subscript;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439.ArticleInfo;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439.ReqBody;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439.RspBody;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439.SubscribeInfo;
import tencent.im.oidb.cmd0x472.Oidb_0x472.ArticleSummary;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SubscriptHandler
  extends BusinessHandler
{
  public SubscriptHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static ReadInJoyArticle a(Oidb_0x472.ArticleSummary paramArticleSummary, int paramInt)
  {
    if (paramArticleSummary == null) {
      return null;
    }
    ReadInJoyArticle localReadInJoyArticle = new ReadInJoyArticle();
    localReadInJoyArticle.mChannelID = paramInt;
    if (paramArticleSummary.uint64_article_id.has()) {
      localReadInJoyArticle.mArticleID = paramArticleSummary.uint64_article_id.get();
    }
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localReadInJoyArticle.mTitle = paramArticleSummary.bytes_article_title.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
      localReadInJoyArticle.mSummary = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_first_page_pic_url.has()) && (paramArticleSummary.bytes_first_page_pic_url.get() != null)) {
      localReadInJoyArticle.mFirstPagePicUrl = paramArticleSummary.bytes_first_page_pic_url.get().toStringUtf8();
    }
    return localReadInJoyArticle;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetRecommendList onReceive :");
      paramToServiceMsg.append(bool1);
      QLog.d("SubscriptHandler", 2, paramToServiceMsg.toString());
    }
    if (!bool1) {
      return;
    }
    SubscriptRecommendAccountInfo localSubscriptRecommendAccountInfo = null;
    int i;
    boolean bool2;
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      i = paramToServiceMsg.uint32_result.get();
      if (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel()) {
        break label786;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("result: ");
      paramFromServiceMsg.append(i);
      QLog.i("SubscriptHandler", 2, paramFromServiceMsg.toString());
    }
    catch (Exception paramToServiceMsg)
    {
      if (!QLog.isColorLevel()) {
        break label785;
      }
      QLog.e("SubscriptHandler", 2, "handleGetRecommendList onReceive fail: ", paramToServiceMsg);
    }
    if (bool1)
    {
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      paramObject = new oidb_cmd0x439.RspBody();
      paramObject.mergeFrom(paramToServiceMsg);
      paramFromServiceMsg = "";
      paramToServiceMsg = paramFromServiceMsg;
      if (paramObject.bytes_subscribe_detail_url_pre.has())
      {
        paramToServiceMsg = paramFromServiceMsg;
        if (paramObject.bytes_subscribe_detail_url_pre.get() != null) {
          paramToServiceMsg = paramObject.bytes_subscribe_detail_url_pre.get().toStringUtf8();
        }
      }
      paramFromServiceMsg = localSubscriptRecommendAccountInfo;
      bool2 = bool1;
      if (paramObject.rpt_msg_subscribe_info.has())
      {
        paramFromServiceMsg = localSubscriptRecommendAccountInfo;
        bool2 = bool1;
        if (paramObject.rpt_msg_subscribe_info.get() != null)
        {
          paramObject = paramObject.rpt_msg_subscribe_info.get();
          paramFromServiceMsg = new ArrayList(paramObject.size());
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            Object localObject1 = (oidb_cmd0x439.SubscribeInfo)paramObject.next();
            localSubscriptRecommendAccountInfo = new SubscriptRecommendAccountInfo();
            Object localObject2;
            if (((oidb_cmd0x439.SubscribeInfo)localObject1).uint64_subscribe_id.has())
            {
              localSubscriptRecommendAccountInfo.jdField_a_of_type_Long = ((oidb_cmd0x439.SubscribeInfo)localObject1).uint64_subscribe_id.get();
              if ((localSubscriptRecommendAccountInfo.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(paramToServiceMsg)))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(paramToServiceMsg);
                ((StringBuilder)localObject2).append(localSubscriptRecommendAccountInfo.jdField_a_of_type_Long);
                localSubscriptRecommendAccountInfo.b = ((StringBuilder)localObject2).toString();
              }
            }
            if ((((oidb_cmd0x439.SubscribeInfo)localObject1).bytes_subscribe_name.has()) && (((oidb_cmd0x439.SubscribeInfo)localObject1).bytes_subscribe_name.get() != null)) {
              localSubscriptRecommendAccountInfo.jdField_a_of_type_JavaLangString = ((oidb_cmd0x439.SubscribeInfo)localObject1).bytes_subscribe_name.get().toStringUtf8();
            }
            if ((((oidb_cmd0x439.SubscribeInfo)localObject1).rpt_article_list.has()) && (((oidb_cmd0x439.SubscribeInfo)localObject1).rpt_article_list.get() != null))
            {
              localObject2 = ((oidb_cmd0x439.SubscribeInfo)localObject1).rpt_article_list.get();
              if (!((List)localObject2).isEmpty())
              {
                localObject1 = new ReadInJoyArticle();
                localObject2 = (oidb_cmd0x439.ArticleInfo)((List)localObject2).get(0);
                if (((oidb_cmd0x439.ArticleInfo)localObject2).uint64_article_id.has()) {
                  ((ReadInJoyArticle)localObject1).mArticleID = ((oidb_cmd0x439.ArticleInfo)localObject2).uint64_article_id.get();
                }
                if ((((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_subject.has()) && (((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_subject.get() != null)) {
                  ((ReadInJoyArticle)localObject1).mTitle = ((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_subject.get().toStringUtf8();
                }
                if ((((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_url.has()) && (((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_url.get() != null)) {
                  ((ReadInJoyArticle)localObject1).mArticleUrl = ((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_url.get().toStringUtf8();
                }
                if ((((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_sum_pic.has()) && (((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_sum_pic.get() != null)) {
                  ((ReadInJoyArticle)localObject1).mFirstPagePicUrl = ((oidb_cmd0x439.ArticleInfo)localObject2).bytes_article_sum_pic.get().toStringUtf8();
                }
                localSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle = ((ReadInJoyArticle)localObject1);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("handleGetRecommendList create SubscriptRecommendAccountInfo id: ");
              ((StringBuilder)localObject1).append(localSubscriptRecommendAccountInfo.jdField_a_of_type_Long);
              ((StringBuilder)localObject1).append(" | name: ");
              ((StringBuilder)localObject1).append(localSubscriptRecommendAccountInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject1).append(" | article: ");
              ((StringBuilder)localObject1).append(localSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle);
              QLog.i("SubscriptHandler", 2, ((StringBuilder)localObject1).toString());
            }
            paramFromServiceMsg.add(localSubscriptRecommendAccountInfo);
          }
        }
      }
    }
    for (;;)
    {
      if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()))
      {
        super.notifyUI(1, bool2, paramFromServiceMsg);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("SubscriptHandler", 2, "handleGetRecommendList onReceive fail, list is null");
        return;
      }
      label785:
      return;
      label786:
      if (i == 0)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool2 = true;
    }
  }
  
  /* Error */
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 80	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: aconst_null
    //   21: astore 10
    //   23: aconst_null
    //   24: astore 12
    //   26: aconst_null
    //   27: astore 11
    //   29: aconst_null
    //   30: astore_2
    //   31: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +36 -> 70
    //   37: new 87	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: ldc_w 269
    //   49: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_1
    //   54: iload 5
    //   56: invokevirtual 97	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 99
    //   62: iconst_2
    //   63: aload_1
    //   64: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload 11
    //   72: astore_1
    //   73: iload 5
    //   75: istore 6
    //   77: iload 5
    //   79: ifeq +322 -> 401
    //   82: new 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   85: dup
    //   86: invokespecial 109	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   89: astore 13
    //   91: aload 13
    //   93: aload_3
    //   94: checkcast 111	[B
    //   97: checkcast 111	[B
    //   100: invokevirtual 115	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: pop
    //   104: aload 13
    //   106: getfield 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 124	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: istore 4
    //   114: iload 4
    //   116: ifne +9 -> 125
    //   119: iconst_1
    //   120: istore 5
    //   122: goto +6 -> 128
    //   125: iconst_0
    //   126: istore 5
    //   128: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +35 -> 166
    //   134: new 87	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   141: astore_1
    //   142: aload_1
    //   143: ldc 135
    //   145: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: iload 4
    //   152: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: ldc 99
    //   158: iconst_2
    //   159: aload_1
    //   160: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload 12
    //   168: astore_1
    //   169: iload 5
    //   171: istore 6
    //   173: iload 5
    //   175: ifeq +226 -> 401
    //   178: aload 13
    //   180: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   183: invokevirtual 50	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   186: invokevirtual 148	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   189: astore_1
    //   190: new 271	tencent/im/oidb/cmd0x472/Oidb_0x472$RspBody
    //   193: dup
    //   194: invokespecial 272	tencent/im/oidb/cmd0x472/Oidb_0x472$RspBody:<init>	()V
    //   197: astore_3
    //   198: aload_3
    //   199: aload_1
    //   200: invokevirtual 273	tencent/im/oidb/cmd0x472/Oidb_0x472$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   203: pop
    //   204: aload_3
    //   205: getfield 277	tencent/im/oidb/cmd0x472/Oidb_0x472$RspBody:rspChannelArticle	Ltencent/im/oidb/cmd0x472/Oidb_0x472$RspChannelArticle;
    //   208: invokevirtual 280	tencent/im/oidb/cmd0x472/Oidb_0x472$RspChannelArticle:has	()Z
    //   211: istore 7
    //   213: aload 12
    //   215: astore_1
    //   216: iload 5
    //   218: istore 6
    //   220: iload 7
    //   222: ifeq +179 -> 401
    //   225: aload_3
    //   226: getfield 277	tencent/im/oidb/cmd0x472/Oidb_0x472$RspBody:rspChannelArticle	Ltencent/im/oidb/cmd0x472/Oidb_0x472$RspChannelArticle;
    //   229: invokevirtual 283	tencent/im/oidb/cmd0x472/Oidb_0x472$RspChannelArticle:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   232: checkcast 279	tencent/im/oidb/cmd0x472/Oidb_0x472$RspChannelArticle
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull +107 -> 344
    //   240: aload_1
    //   241: getfield 286	tencent/im/oidb/cmd0x472/Oidb_0x472$RspChannelArticle:uint64_channel_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   244: invokevirtual 37	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   247: lstore 8
    //   249: lload 8
    //   251: lconst_0
    //   252: lcmp
    //   253: ifne +91 -> 344
    //   256: aload_1
    //   257: getfield 287	tencent/im/oidb/cmd0x472/Oidb_0x472$RspChannelArticle:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   260: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   263: astore_3
    //   264: aload_3
    //   265: ifnull +79 -> 344
    //   268: aload_3
    //   269: invokeinterface 222 1 0
    //   274: ifne +70 -> 344
    //   277: new 169	java/util/ArrayList
    //   280: dup
    //   281: aload_3
    //   282: invokeinterface 174 1 0
    //   287: invokespecial 177	java/util/ArrayList:<init>	(I)V
    //   290: astore_1
    //   291: aload_3
    //   292: invokeinterface 181 1 0
    //   297: astore_2
    //   298: aload_2
    //   299: invokeinterface 186 1 0
    //   304: ifeq +26 -> 330
    //   307: aload_1
    //   308: aload_2
    //   309: invokeinterface 190 1 0
    //   314: checkcast 23	tencent/im/oidb/cmd0x472/Oidb_0x472$ArticleSummary
    //   317: lload 8
    //   319: l2i
    //   320: invokestatic 289	com/tencent/biz/pubaccount/subscript/SubscriptHandler:a	(Ltencent/im/oidb/cmd0x472/Oidb_0x472$ArticleSummary;I)Lcom/tencent/biz/pubaccount/subscript/ReadInJoyArticle;
    //   323: invokevirtual 290	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   326: pop
    //   327: goto -29 -> 298
    //   330: iconst_1
    //   331: istore 6
    //   333: goto +68 -> 401
    //   336: astore_3
    //   337: aload_1
    //   338: astore_2
    //   339: aload_3
    //   340: astore_1
    //   341: goto +13 -> 354
    //   344: iconst_0
    //   345: istore 6
    //   347: aload 11
    //   349: astore_1
    //   350: goto +51 -> 401
    //   353: astore_1
    //   354: iconst_0
    //   355: istore 5
    //   357: aload_1
    //   358: astore_3
    //   359: goto +14 -> 373
    //   362: astore_3
    //   363: aload 10
    //   365: astore_2
    //   366: goto +7 -> 373
    //   369: astore_3
    //   370: aload 10
    //   372: astore_2
    //   373: aload_2
    //   374: astore_1
    //   375: iload 5
    //   377: istore 6
    //   379: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +19 -> 401
    //   385: ldc 99
    //   387: iconst_2
    //   388: ldc_w 264
    //   391: aload_3
    //   392: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   395: iload 5
    //   397: istore 6
    //   399: aload_2
    //   400: astore_1
    //   401: iload 6
    //   403: ifne +12 -> 415
    //   406: new 169	java/util/ArrayList
    //   409: dup
    //   410: iconst_0
    //   411: invokespecial 177	java/util/ArrayList:<init>	(I)V
    //   414: astore_1
    //   415: aload_0
    //   416: iconst_2
    //   417: iload 6
    //   419: aload_1
    //   420: invokespecial 257	com/tencent/mobileqq/app/BusinessHandler:notifyUI	(IZLjava/lang/Object;)V
    //   423: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	SubscriptHandler
    //   0	424	1	paramToServiceMsg	ToServiceMsg
    //   0	424	2	paramFromServiceMsg	FromServiceMsg
    //   0	424	3	paramObject	Object
    //   112	39	4	i	int
    //   12	384	5	bool1	boolean
    //   75	343	6	bool2	boolean
    //   211	10	7	bool3	boolean
    //   247	71	8	l	long
    //   21	350	10	localObject1	Object
    //   27	321	11	localObject2	Object
    //   24	190	12	localObject3	Object
    //   89	90	13	localOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    // Exception table:
    //   from	to	target	type
    //   291	298	336	java/lang/Exception
    //   298	327	336	java/lang/Exception
    //   225	236	353	java/lang/Exception
    //   240	249	353	java/lang/Exception
    //   256	264	353	java/lang/Exception
    //   268	291	353	java/lang/Exception
    //   128	166	362	java/lang/Exception
    //   178	213	362	java/lang/Exception
    //   82	114	369	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    boolean bool = QLog.isDevelopLevel();
    int i = 4;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRecommendListAsync() start uinStr: ");
      localStringBuilder.append(paramString);
      QLog.d("SubscriptHandler", 4, localStringBuilder.toString());
    }
    paramString = new oidb_cmd0x439.ReqBody();
    paramString.uint32_want_count.set(0);
    paramString.uint32_req_subscribe_info.set(1);
    paramString.uint32_req_article_info.set(1);
    paramString.uint32_version.set(1);
    paramString.uint32_comefrom.set(2);
    int j = NetUtil.a(null);
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            i = 0;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    paramString.uint32_network_type.set(i);
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.1081", 1081, 0, paramString.toByteArray()));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SubscriptObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.1081".equalsIgnoreCase(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x472".equalsIgnoreCase(str)) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptHandler
 * JD-Core Version:    0.7.0.1
 */