package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import lqw;
import lqx;
import lqy;
import lqz;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Client;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqBody;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.Client;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.ReqArticle;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.ReqBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.RspBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.RspShare;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.Client;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqArticle;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspTopic;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.Topic;

public class FastWebModule
  extends ReadInJoyEngineModule
{
  public static final String a;
  private QQLruCache jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private HashMap b = new HashMap();
  private HashMap c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = FastWebModule.class.getSimpleName();
  }
  
  public FastWebModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    a();
  }
  
  private long a()
  {
    int i = NetUtil.a(null);
    Object localObject = ReadInJoyHelper.j(ReadInJoyUtils.a());
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return 1000L;
      localObject = ((String)localObject).split(",");
    } while (localObject.length != 4);
    switch (i)
    {
    default: 
      return 1000L;
    case 1: 
      return Long.valueOf(localObject[0]).longValue();
    case 2: 
      return Long.valueOf(localObject[1]).longValue();
    case 3: 
      return Long.valueOf(localObject[2]).longValue();
    }
    return Long.valueOf(localObject[3]).longValue();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new lqy(this, 2012, 30, 1);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("ad6Seq")).intValue();
    String str = (String)paramToServiceMsg.getAttribute("uniflag");
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("ad6ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("reqType")).intValue();
    oidb_cmd0xad6.RspBody localRspBody = new oidb_cmd0xad6.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool1 = false;
    boolean bool2 = false;
    paramToServiceMsg = null;
    if (k == 0)
    {
      bool1 = bool2;
      if (localRspBody.bool_use_webview.has())
      {
        bool1 = bool2;
        if (localRspBody.bool_use_webview.get()) {
          bool1 = true;
        }
      }
      paramToServiceMsg = new FastWebArticleInfo();
      boolean bool3 = paramToServiceMsg.a(localRspBody, j);
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      paramFromServiceMsg = (FastWebModule.FastWebContentGetCallback)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(i));
      if (paramFromServiceMsg != null) {
        ThreadManager.getUIHandler().post(new lqw(this, paramFromServiceMsg, bool1, bool2, paramToServiceMsg));
      }
      QLog.d("Q.readinjoy.fast_web", 2, "ad6 resp  result : " + bool1 + ", seq : " + i + ", useWebView : " + bool2 + ", cost : " + l + ", retCode : " + k + ", native info : " + paramToServiceMsg);
      if (j != 2) {
        this.c.put(str, new lqz(this, paramToServiceMsg));
      }
      for (;;)
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("which", "2");
        paramToServiceMsg.put("reqType", String.valueOf(j));
        paramToServiceMsg.put("param_uin", ReadInJoyUtils.a());
        paramToServiceMsg.put("param_retCode", k + "");
        paramToServiceMsg.put("param_succ", String.valueOf(bool1));
        paramToServiceMsg.put("param_netType", NetUtil.a(null) + "");
        StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", bool1, l, 0L, paramToServiceMsg, null);
        return;
        if ((paramToServiceMsg != null) && (this.c.containsKey(str)))
        {
          paramFromServiceMsg = (lqz)this.c.get(str);
          ((FastWebArticleInfo)paramFromServiceMsg.a()).a(paramToServiceMsg.b, paramToServiceMsg.jdField_a_of_type_Long);
          paramFromServiceMsg.a(paramFromServiceMsg.a());
        }
      }
      bool2 = false;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("ad7Seq")).intValue();
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)paramToServiceMsg.getAttribute("ad7ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("ad7Action")).intValue();
    paramToServiceMsg = new oidb_cmd0xad7.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new FastWebShareInfo();
    boolean bool;
    if ((k == 0) && (paramToServiceMsg.msg_rsp_share.has()))
    {
      bool = true;
      paramToServiceMsg = (oidb_cmd0xad7.RspShare)paramToServiceMsg.msg_rsp_share.get();
      paramFromServiceMsg.b = paramToServiceMsg.bytes_wechat_pyq.get().toStringUtf8();
      paramFromServiceMsg.jdField_a_of_type_JavaLangString = paramToServiceMsg.bytes_weibo.get().toStringUtf8();
      paramFromServiceMsg.d = paramToServiceMsg.bytes_friend.get().toStringUtf8();
      paramFromServiceMsg.c = paramToServiceMsg.bytes_wechat.get().toStringUtf8();
      paramFromServiceMsg.e = paramToServiceMsg.bytes_qzhone.get().toStringUtf8();
    }
    for (;;)
    {
      paramToServiceMsg = (FastWebModule.FastWebArticleRichReqCallback)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(i));
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(bool, j, paramFromServiceMsg);
      }
      QLog.d("Q.readinjoy.fast_web", 2, "handle ad7rsp , succ " + bool + ", retCode : " + k + ", seq : " + i + ", cost : " + (l1 - l2) + "\n" + paramFromServiceMsg);
      return;
      bool = false;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt, FastWebModule.FastWebContentGetCallback paramFastWebContentGetCallback)
  {
    if (paramInt != 2) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = (lqz)this.c.get(paramString2);
        if (localObject1 != null)
        {
          if (((lqz)localObject1).a()) {
            this.c.remove(paramString2);
          }
        }
        else
        {
          localObject1 = new oidb_cmd0xad6.ReqBody();
          Object localObject2 = new oidb_cmd0xad6.Client();
          ((oidb_cmd0xad6.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
          ((oidb_cmd0xad6.Client)localObject2).uint32_type.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).msg_client.set((MessageMicro)localObject2);
          localObject2 = new oidb_cmd0xad6.ReqArticle();
          if (paramString2 != null) {
            ((oidb_cmd0xad6.ReqArticle)localObject2).bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString2));
          }
          ((oidb_cmd0xad6.ReqArticle)localObject2).bytes_url.set(ByteStringMicro.copyFromUtf8(paramString1));
          if (!TextUtils.isEmpty(paramString3)) {
            ((oidb_cmd0xad6.ReqArticle)localObject2).uint64_public_uin.set(Long.valueOf(paramString3).longValue());
          }
          ((oidb_cmd0xad6.ReqArticle)localObject2).uint64_prev_version.set(0L);
          ((oidb_cmd0xad6.ReqBody)localObject1).msg_req_article.set((MessageMicro)localObject2);
          if (paramInt != 1) {
            continue;
          }
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(1);
          paramString3 = ReadInJoyOidbHelper.a("OidbSvc.0xad6", 2774, 0, ((oidb_cmd0xad6.ReqBody)localObject1).toByteArray());
          int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          long l = a();
          paramString3.addAttribute("ad6Seq", Integer.valueOf(i));
          paramString3.addAttribute("ad6ReqTime", Long.valueOf(System.currentTimeMillis()));
          paramString3.addAttribute("uniflag", paramString2);
          paramString3.addAttribute("reqType", Integer.valueOf(paramInt));
          paramString3.setTimeout(l);
          if (paramFastWebContentGetCallback != null) {
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramFastWebContentGetCallback);
          }
          QLog.d("Q.readinjoy.fast_web", 2, "send get content req , seq : " + i + ", rowkey : " + paramString2 + ", oriUrl : " + paramString1 + ", reqType : " + paramInt + ", timeout : " + l);
          a(paramString3);
          return i;
        }
        if (paramFastWebContentGetCallback != null) {
          paramFastWebContentGetCallback.a(true, ((lqz)localObject1).a, (FastWebArticleInfo)((lqz)localObject1).a());
        }
        QLog.d("Q.readinjoy.fast_web", 2, "hit cache, rowkey : " + paramString2 + ", url : " + paramString1 + " isUserWeb " + ((lqz)localObject1).a);
        return -1;
        if (paramInt == 3)
        {
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(0);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(0);
          continue;
        }
        if (paramInt != 2) {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("Q.readinjoy.fast_web", 2, "send ad6 req error " + paramString1);
        if (paramFastWebContentGetCallback != null) {
          paramFastWebContentGetCallback.a(false, true, null);
        }
        return -1;
      }
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(0);
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(1);
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(1);
    }
  }
  
  public Parcelable a(String paramString)
  {
    paramString = (lqz)this.b.get(paramString);
    if ((paramString == null) || (paramString.a())) {
      return null;
    }
    return (Parcelable)paramString.a();
  }
  
  public FastWebArticleInfo a(String paramString)
  {
    paramString = (lqz)this.c.get(paramString);
    if (paramString != null) {
      return (FastWebArticleInfo)paramString.a();
    }
    return null;
  }
  
  public List a(String paramString)
  {
    return ItemDatasListUtils.a((List)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString));
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    Object localObject1 = new oidb_cmd0xb54.ReqBody();
    Object localObject2 = new oidb_cmd0xb54.Client();
    ((oidb_cmd0xb54.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    ((oidb_cmd0xb54.Client)localObject2).uint32_type.set(1);
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_client.set((MessageMicro)localObject2);
    localObject2 = new oidb_cmd0xb54.ReqArticle();
    ((oidb_cmd0xb54.ReqArticle)localObject2).bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.innerUniqueID));
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_req_article.set((MessageMicro)localObject2);
    ((oidb_cmd0xb54.ReqBody)localObject1).uint32_topic.set(1);
    localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xb54", 2900, 0, ((oidb_cmd0xb54.ReqBody)localObject1).toByteArray());
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    ((ToServiceMsg)localObject1).addAttribute("b54Seq", Integer.valueOf(i));
    ((ToServiceMsg)localObject1).addAttribute("b54ReqTime", Long.valueOf(System.currentTimeMillis()));
    ((ToServiceMsg)localObject1).addAttribute("uniflag", paramArticleInfo.innerUniqueID);
    ((ToServiceMsg)localObject1).addAttribute("rowkey", paramArticleInfo.innerUniqueID);
    if (paramFastWebArticleRichReqCallback != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramFastWebArticleRichReqCallback);
    }
    a((ToServiceMsg)localObject1);
    QLog.d("Q.readinjoy.fast_web", 2, "req article topic info , rowkey : " + paramArticleInfo.innerUniqueID + ", seq : " + i);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xad6")) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xad7"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb54"));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, Parcelable paramParcelable)
  {
    lqz locallqz = (lqz)this.b.get(paramString);
    if (locallqz == null)
    {
      paramParcelable = new lqz(this, paramParcelable);
      this.b.put(paramString, paramParcelable);
      return;
    }
    locallqz.a(paramParcelable);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    oidb_cmd0xad7.ReqBody localReqBody = new oidb_cmd0xad7.ReqBody();
    Object localObject = new oidb_cmd0xad7.Client();
    ((oidb_cmd0xad7.Client)localObject).bytes_version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    ((oidb_cmd0xad7.Client)localObject).uint32_type.set(1);
    localReqBody.msg_client.set((MessageMicro)localObject);
    localObject = new oidb_cmd0xad7.ReqArticle();
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_article_id.set(ByteStringMicro.copyFromUtf8(paramString2));
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_url.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((oidb_cmd0xad7.ReqArticle)localObject).uint64_public_uin.set(Long.valueOf(paramString3).longValue());
    ((oidb_cmd0xad7.ReqArticle)localObject).uint32_prev_version.set(0);
    localReqBody.msg_req_article.set((MessageMicro)localObject);
    if (paramInt == 2) {
      localReqBody.uint32_friend.set(1);
    }
    for (;;)
    {
      paramString3 = ReadInJoyOidbHelper.a("OidbSvc.0xad7", 2775, 0, localReqBody.toByteArray());
      int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      paramString3.addAttribute("ad7Seq", Integer.valueOf(i));
      paramString3.addAttribute("ad7ReqTime", Long.valueOf(System.currentTimeMillis()));
      paramString3.addAttribute("ad7Action", Integer.valueOf(paramInt));
      if (paramFastWebArticleRichReqCallback != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramFastWebArticleRichReqCallback);
      }
      a(paramString3);
      QLog.d("Q.readinjoy.fast_web", 2, "get share Json  articleID : " + paramString2 + ", oriUrl : " + paramString1 + ", seq : " + i + ", action : " + paramInt);
      return;
      if (paramInt == 3) {
        localReqBody.uint32_qzhone.set(1);
      } else if (paramInt == 12) {
        localReqBody.uint32_weibo.set(1);
      } else if (paramInt == 9) {
        localReqBody.uint32_wechat.set(1);
      } else if (paramInt == 10) {
        localReqBody.uint32_wechat_pyq.set(1);
      }
    }
  }
  
  public void a(String paramString, List paramList)
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, paramList);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lqx(this, paramList));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("b54Seq")).intValue();
    Object localObject2 = (String)paramToServiceMsg.getAttribute("uniflag");
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)paramToServiceMsg.getAttribute("b54ReqTime")).longValue();
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("rowkey");
    Object localObject1 = new oidb_cmd0xb54.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramFromServiceMsg = (FastWebModule.FastWebArticleRichReqCallback)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    paramObject = (lqz)this.c.get(localObject2);
    if (paramObject == null) {
      return;
    }
    paramObject = (FastWebArticleInfo)paramObject.a();
    if (j == 0)
    {
      if (((oidb_cmd0xb54.RspBody)localObject1).msg_rsp_topic.has())
      {
        Object localObject3 = (oidb_cmd0xb54.RspTopic)((oidb_cmd0xb54.RspBody)localObject1).msg_rsp_topic.get();
        localObject1 = new StringBuilder("0xb54 resp article topic info successful !  cost : " + (l1 - l2) + ", seq : " + i + "\n");
        if (((oidb_cmd0xb54.RspTopic)localObject3).rpt_msg_topic.has())
        {
          localObject2 = new ArrayList(((oidb_cmd0xb54.RspTopic)localObject3).rpt_msg_topic.size());
          localObject3 = ((oidb_cmd0xb54.RspTopic)localObject3).rpt_msg_topic.get().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            oidb_cmd0xb54.Topic localTopic = (oidb_cmd0xb54.Topic)((Iterator)localObject3).next();
            ArticleTopicData.TopicInfo localTopicInfo = new ArticleTopicData.TopicInfo();
            localTopicInfo.jdField_a_of_type_JavaLangString = localTopic.bytes_title.get().toStringUtf8();
            localTopicInfo.jdField_a_of_type_Long = localTopic.uint64_topic_id.get();
            localTopicInfo.b = localTopic.bytes_url.get().toStringUtf8();
            ((List)localObject2).add(localTopicInfo);
            ((StringBuilder)localObject1).append("title : ").append(localTopicInfo.jdField_a_of_type_JavaLangString).append(", topicID : ").append(localTopicInfo.jdField_a_of_type_Long).append(", url : ").append(localTopicInfo.b).append("\n");
          }
          paramObject.jdField_a_of_type_JavaUtilList = ((List)localObject2);
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.a(true, paramToServiceMsg, paramObject);
          }
        }
        QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      paramObject.jdField_a_of_type_JavaUtilList = null;
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(false, paramToServiceMsg, paramObject);
      }
      QLog.d("Q.readinjoy.fast_web", 2, "oxb54 resp has no topic info !");
      return;
    }
    QLog.d("Q.readinjoy.fast_web", 2, "oxb54 resp error, code : " + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FastWebModule
 * JD-Core Version:    0.7.0.1
 */