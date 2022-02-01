package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.biz.hippy.api.IHippyWupCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.BusinessGroupWord.ClueWordItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord.GroupID;
import com.tencent.mobileqq.search.model.BusinessGroupWord.HotWordItem;
import com.tencent.mobileqq.search.model.GroupTabModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.net.parser.NetBaseParser;
import com.tencent.mobileqq.search.util.SearchCostStat;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.search.DynamicAssociationWord.AssociationItem;
import tencent.im.oidb.search.DynamicAssociationWord.ReqBody;
import tencent.im.oidb.search.DynamicAssociationWord.RspBody;
import tencent.im.oidb.search.DynamicAssociationWord.SuggestUrlItem;
import tencent.im.oidb.search.DynamicBusinessHotWord.ClueWordItem;
import tencent.im.oidb.search.DynamicBusinessHotWord.GroupID;
import tencent.im.oidb.search.DynamicBusinessHotWord.GroupWord;
import tencent.im.oidb.search.DynamicBusinessHotWord.HotWordItem;
import tencent.im.oidb.search.DynamicBusinessHotWord.ReqBody;
import tencent.im.oidb.search.DynamicBusinessHotWord.RspBody;
import tencent.im.oidb.search.DynamicDiscovery.ReqBody;
import tencent.im.oidb.search.DynamicDiscovery.RspBody;
import tencent.im.oidb.search.DynamicKdReport.ReqBody;
import tencent.im.oidb.search.DynamicSearch.ExtensionRequestInfo;
import tencent.im.oidb.search.DynamicSearch.RootSearcherRequest;
import tencent.im.oidb.search.DynamicTabSearch.ReqBody;
import tencent.im.oidb.search.RequestSearchWord.ReqBody;
import tencent.im.oidb.search.RequestSearchWord.RspBody;
import tencent.im.oidb.search.RequestSearchWord.SearchKeywords;
import tencent.im.oidb.search.UniteSearch.ReqBody;
import tencent.im.oidb.search.UniteSearch.RspBody;
import tencent.im.oidb.search.UniteSearch.TabItemGroup;

public class UniteSearchHandler
  extends BusinessHandler
{
  public static long[] a = { 1001L, 1002L, 1003L, 1005L, 2073745984L, 1006L };
  public static long[] b = { 1004L };
  public static long[] c = { 2073745984L, 1073745984L, 1001L, 8001L, 1002L, 1003L, 1005L, 1006L };
  public static String d = "hot_word_for_sub_business";
  public static String e = "hot_word_for_sub_business_req_time";
  public static String f = "hot_word_for_sub_business_exprire_time";
  private QQAppInterface g;
  private AppInterface h;
  private HashMap<Long, UniteSearchHandler.RequestSearchWordCallback> i = new HashMap();
  
  public UniteSearchHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.h = paramAppInterface;
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.g = ((QQAppInterface)paramAppInterface);
    }
  }
  
  public UniteSearchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.g = paramQQAppInterface;
    this.h = paramQQAppInterface;
  }
  
  private List<BusinessGroupWord> a(List<DynamicBusinessHotWord.GroupWord> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    FunctionModuleConfigManager.b.clear();
    FunctionModuleConfigManager.c.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (DynamicBusinessHotWord.GroupWord)localIterator.next();
      ArrayList localArrayList2 = new ArrayList(paramList.size());
      BusinessGroupWord.GroupID localGroupID = new BusinessGroupWord.GroupID(((DynamicBusinessHotWord.GroupID)((DynamicBusinessHotWord.GroupWord)localObject1).group_id.get()).rpt_group_mask.get());
      Object localObject2 = ((DynamicBusinessHotWord.GroupWord)localObject1).rpt_hot_word_items.get();
      new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DynamicBusinessHotWord.HotWordItem localHotWordItem = (DynamicBusinessHotWord.HotWordItem)((Iterator)localObject2).next();
        localArrayList2.add(new BusinessGroupWord.HotWordItem(localHotWordItem.word_id.get().toStringUtf8(), localHotWordItem.word.get().toStringUtf8()));
      }
      FunctionModuleConfigManager.b.put(FunctionModuleConfigManager.a(localGroupID.a), localArrayList2);
      localObject2 = (DynamicBusinessHotWord.ClueWordItem)((DynamicBusinessHotWord.GroupWord)localObject1).clue_word_item.get();
      localObject1 = ((DynamicBusinessHotWord.ClueWordItem)localObject2).word_id.get().toStringUtf8();
      localObject2 = ((DynamicBusinessHotWord.ClueWordItem)localObject2).word.get().toStringUtf8();
      localObject1 = new BusinessGroupWord.ClueWordItem((String)localObject1, (String)localObject2);
      FunctionModuleConfigManager.c.put(FunctionModuleConfigManager.a(localGroupID.a), localObject2);
      localArrayList1.add(new BusinessGroupWord(localGroupID, localArrayList2, (BusinessGroupWord.ClueWordItem)localObject1));
    }
    return localArrayList1;
  }
  
  private void a(int paramInt, Object paramObject, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveData code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" fileName=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" key=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" data=");
    localStringBuilder.append(paramObject);
    QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 1, localStringBuilder.toString());
    if ((paramInt == 1000) && (paramObject != null))
    {
      ThreadManager.post(new UniteSearchHandler.1(this, paramString1, paramObject), 5, null, true);
      paramObject = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
      paramString1 = new StringBuilder();
      paramString1.append(System.currentTimeMillis());
      paramString1.append("");
      paramObject.putString(paramString2, paramString1.toString()).commit();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("code is error，do not save the data= ");
      paramString1.append(paramObject);
      paramString1.append(", code=");
      paramString1.append(paramInt);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramString1.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleCompletedUrlResult. resultCode=");
      paramFromServiceMsg.append(j);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramFromServiceMsg.toString());
    }
    String str = paramToServiceMsg.extraData.getString("keyword", "");
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = str;
    paramFromServiceMsg[1] = Integer.valueOf(-1);
    paramFromServiceMsg[2] = "";
    if (j != 1000)
    {
      notifyUI(1006, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1006, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1006, false, paramFromServiceMsg);
      return;
    }
    paramToServiceMsg = new DynamicAssociationWord.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      j = paramToServiceMsg.result_code.get();
      paramObject = paramToServiceMsg.error_msg.get();
      if ((j != 0) && (j != 1009))
      {
        paramToServiceMsg = new Object[3];
        paramToServiceMsg[0] = str;
        paramToServiceMsg[1] = Integer.valueOf(j);
        paramToServiceMsg[2] = paramObject;
        try
        {
          notifyUI(1006, false, paramToServiceMsg);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
        }
      }
      else
      {
        Object localObject = paramToServiceMsg.association_items.get();
        paramObject = paramToServiceMsg.suggest_url_items.get();
        DynamicAssociationWord.SuggestUrlItem localSuggestUrlItem = (DynamicAssociationWord.SuggestUrlItem)paramToServiceMsg.completed_url_items.get();
        ArrayList localArrayList = new ArrayList();
        paramToServiceMsg = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DynamicAssociationWord.AssociationItem localAssociationItem = (DynamicAssociationWord.AssociationItem)((Iterator)localObject).next();
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.b = localAssociationItem.word.get().toStringUtf8();
          localAssociateItem.c = localAssociationItem.subWord.get().toStringUtf8();
          localAssociateItem.e = localAssociationItem.pic_url.get().toStringUtf8();
          localAssociateItem.d = localAssociationItem.jmp_url.get().toStringUtf8();
          localAssociateItem.f = localAssociationItem.type.get();
          localAssociateItem.g = localAssociationItem.group_mask.get();
          localArrayList.add(localAssociateItem);
        }
        localObject = paramObject.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramToServiceMsg.add(((DynamicAssociationWord.SuggestUrlItem)((Iterator)localObject).next()).url.get().toStringUtf8());
        }
        paramToServiceMsg = new Object[5];
        paramToServiceMsg[0] = str;
        paramToServiceMsg[1] = Integer.valueOf(j);
        paramToServiceMsg[2] = localArrayList;
        paramToServiceMsg[3] = paramObject;
        paramToServiceMsg[4] = localSuggestUrlItem;
        try
        {
          notifyUI(1006, true, paramToServiceMsg);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramObject = paramToServiceMsg;
        }
      }
      notifyUI(1006, false, paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramObject = paramFromServiceMsg;
      paramFromServiceMsg = paramToServiceMsg;
    }
    paramFromServiceMsg.printStackTrace();
  }
  
  private void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    long l = System.currentTimeMillis();
    paramString1 = new ReportTask(this.g).a("dc00899").b("grp_search_engineer").c("search_net").d(paramString1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(l - paramLong1);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString2);
    paramString1.a(new String[] { localObject1, localObject2, localStringBuilder.toString(), StoryReportor.a(null) }).a();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleCompletedUrlResult. resultCode=");
      paramFromServiceMsg.append(j);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramFromServiceMsg.toString());
    }
    String str = paramToServiceMsg.extraData.getString("keyword", "");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = "";
    if (j != 1000)
    {
      notifyUI(1005, false, paramToServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1005, false, paramToServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1005, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new DynamicAssociationWord.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      j = paramFromServiceMsg.result_code.get();
      paramObject = paramFromServiceMsg.error_msg.get();
      if ((j != 0) && (j != 1009))
      {
        paramFromServiceMsg = new Object[3];
        paramFromServiceMsg[0] = str;
        paramFromServiceMsg[1] = Integer.valueOf(j);
        paramFromServiceMsg[2] = paramObject;
        try
        {
          notifyUI(1005, false, paramFromServiceMsg);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
        }
      }
      else
      {
        paramObject = (DynamicAssociationWord.SuggestUrlItem)paramFromServiceMsg.completed_url_items.get();
        paramFromServiceMsg = new Object[3];
        paramFromServiceMsg[0] = str;
        paramFromServiceMsg[1] = paramObject;
        paramFromServiceMsg[2] = Integer.valueOf(j);
        try
        {
          notifyUI(1005, true, paramFromServiceMsg);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
        }
      }
      notifyUI(1005, false, paramToServiceMsg);
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
    paramFromServiceMsg.printStackTrace();
  }
  
  private String c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleUniteSearchResult. resultCode=");
      paramFromServiceMsg.append(j);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramFromServiceMsg.toString());
    }
    SearchCostStat.a("uniteNetCode", String.valueOf(j));
    SearchCostStat.b("UniteNetRec");
    String str1 = paramToServiceMsg.extraData.getString("keyword", "");
    String str2 = paramToServiceMsg.extraData.getString("time", "");
    Object localObject2 = paramToServiceMsg.extraData.getLongArray("masks");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isFirstReq");
    long l1 = paramToServiceMsg.extraData.getLong("send_req_time");
    long l2 = j;
    paramFromServiceMsg = new Object[] { str1, Boolean.valueOf(bool2), str2, Integer.valueOf(-1), "" };
    a("dynamic_unite_search.1", l1, l2, str1);
    if (j != 1000)
    {
      notifyUI(1004, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1004, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1004, false, paramFromServiceMsg);
      return;
    }
    UniteSearch.RspBody localRspBody = new UniteSearch.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        j = localRspBody.result_code.get();
        Object localObject1 = localRspBody.error_msg.get();
        if ((j != 0) && (j < 1000))
        {
          paramObject = new Object[5];
          paramObject[0] = str1;
          paramObject[1] = Boolean.valueOf(bool2);
          paramObject[2] = str2;
          paramObject[3] = Integer.valueOf(j);
          paramObject[4] = localObject1;
          paramToServiceMsg = paramObject;
          try
          {
            notifyUI(1004, false, paramObject);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
        }
        else
        {
          localObject1 = localRspBody.cookie_topic.get().toByteArray();
          if (localRspBody.search_ver.has()) {
            SearchUtils.a("dynamic_unite_search.1", (long[])localObject2, localRspBody.search_ver.get().toStringUtf8());
          }
          if (localRspBody.is_end_topic.get() != 1) {
            break label625;
          }
          bool1 = true;
          paramObject = localRspBody.tab_groups.get();
          localObject2 = new ArrayList(paramObject.size());
          j = 0;
          if (j < paramObject.size())
          {
            ((List)localObject2).add(new GroupTabModel((UniteSearch.TabItemGroup)paramObject.get(j)));
            j += 1;
            continue;
          }
          j = localRspBody.trigger_netword_num.get();
          if (j >= 0) {
            SharedPreUtils.r(BaseApplicationImpl.getContext(), j);
          }
          paramObject = localRspBody.item_groups.get();
          paramToServiceMsg = new NetBaseParser().a(new Object[] { str1, paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) });
          paramObject = new Object[7];
          paramObject[0] = str1;
          paramObject[1] = Boolean.valueOf(bool2);
          paramObject[2] = str2;
          paramObject[3] = localObject1;
          paramObject[4] = Boolean.valueOf(bool1);
          paramObject[5] = localObject2;
          paramObject[6] = paramToServiceMsg;
          paramToServiceMsg = paramObject;
          notifyUI(1004, true, paramObject);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
        notifyUI(1004, false, paramToServiceMsg);
        paramFromServiceMsg.printStackTrace();
        return;
      }
      label625:
      boolean bool1 = false;
    }
  }
  
  /* Error */
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 298	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 4
    //   6: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +36 -> 45
    //   12: new 205	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc_w 556
    //   24: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: iload 4
    //   31: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: ldc 226
    //   37: iconst_2
    //   38: aload_2
    //   39: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_1
    //   46: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   49: ldc_w 308
    //   52: ldc_w 272
    //   55: invokevirtual 314	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 12
    //   60: aload_1
    //   61: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   64: ldc_w 460
    //   67: ldc_w 272
    //   70: invokevirtual 314	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: astore 13
    //   75: aload_1
    //   76: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   79: ldc_w 462
    //   82: invokevirtual 466	android/os/Bundle:getLongArray	(Ljava/lang/String;)[J
    //   85: astore 14
    //   87: aload_1
    //   88: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   91: ldc_w 468
    //   94: invokevirtual 472	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   97: istore 7
    //   99: aload_1
    //   100: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   103: ldc_w 474
    //   106: invokevirtual 478	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   109: lstore 8
    //   111: iload 4
    //   113: i2l
    //   114: lstore 10
    //   116: bipush 6
    //   118: anewarray 316	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload 12
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: iload 7
    //   130: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   133: aastore
    //   134: dup
    //   135: iconst_2
    //   136: aload 13
    //   138: aastore
    //   139: dup
    //   140: iconst_3
    //   141: iconst_m1
    //   142: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: dup
    //   147: iconst_4
    //   148: ldc_w 272
    //   151: aastore
    //   152: dup
    //   153: iconst_5
    //   154: aload 14
    //   156: aastore
    //   157: astore_2
    //   158: aload_0
    //   159: ldc_w 558
    //   162: lload 8
    //   164: lload 10
    //   166: aload 12
    //   168: invokespecial 487	com/tencent/mobileqq/app/UniteSearchHandler:a	(Ljava/lang/String;JJLjava/lang/String;)V
    //   171: iload 4
    //   173: sipush 1000
    //   176: if_icmpeq +13 -> 189
    //   179: aload_0
    //   180: sipush 1000
    //   183: iconst_0
    //   184: aload_2
    //   185: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   188: return
    //   189: aload_3
    //   190: ifnonnull +13 -> 203
    //   193: aload_0
    //   194: sipush 1000
    //   197: iconst_0
    //   198: aload_2
    //   199: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   202: return
    //   203: aload_3
    //   204: instanceof 328
    //   207: ifne +13 -> 220
    //   210: aload_0
    //   211: sipush 1000
    //   214: iconst_0
    //   215: aload_2
    //   216: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   219: return
    //   220: new 560	tencent/im/oidb/search/DynamicTabSearch$RspBody
    //   223: dup
    //   224: invokespecial 561	tencent/im/oidb/search/DynamicTabSearch$RspBody:<init>	()V
    //   227: astore 15
    //   229: aload 15
    //   231: aload_3
    //   232: checkcast 328	[B
    //   235: checkcast 328	[B
    //   238: invokevirtual 562	tencent/im/oidb/search/DynamicTabSearch$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   241: pop
    //   242: aload 15
    //   244: getfield 563	tencent/im/oidb/search/DynamicTabSearch$RspBody:result_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   247: invokevirtual 343	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   250: istore 4
    //   252: aload 15
    //   254: getfield 564	tencent/im/oidb/search/DynamicTabSearch$RspBody:error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   257: invokevirtual 351	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   260: astore_3
    //   261: iload 4
    //   263: ifeq +73 -> 336
    //   266: iload 4
    //   268: sipush 1000
    //   271: if_icmplt +6 -> 277
    //   274: goto +62 -> 336
    //   277: bipush 6
    //   279: anewarray 316	java/lang/Object
    //   282: astore_1
    //   283: aload_1
    //   284: iconst_0
    //   285: aload 12
    //   287: aastore
    //   288: aload_1
    //   289: iconst_1
    //   290: iload 7
    //   292: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   295: aastore
    //   296: aload_1
    //   297: iconst_2
    //   298: aload 13
    //   300: aastore
    //   301: aload_1
    //   302: iconst_3
    //   303: iload 4
    //   305: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: aastore
    //   309: aload_1
    //   310: iconst_4
    //   311: aload_3
    //   312: aastore
    //   313: aload_1
    //   314: iconst_5
    //   315: aload 14
    //   317: aastore
    //   318: aload_0
    //   319: sipush 1000
    //   322: iconst_0
    //   323: aload_1
    //   324: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   327: return
    //   328: astore_3
    //   329: aload_1
    //   330: astore_2
    //   331: aload_3
    //   332: astore_1
    //   333: goto +278 -> 611
    //   336: aload 15
    //   338: getfield 567	tencent/im/oidb/search/DynamicTabSearch$RspBody:cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   341: invokevirtual 157	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   344: invokevirtual 500	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   347: astore_3
    //   348: aload 15
    //   350: getfield 568	tencent/im/oidb/search/DynamicTabSearch$RspBody:search_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   353: invokevirtual 506	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   356: ifeq +269 -> 625
    //   359: ldc_w 558
    //   362: aload 14
    //   364: aload 15
    //   366: getfield 568	tencent/im/oidb/search/DynamicTabSearch$RspBody:search_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   369: invokevirtual 157	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   372: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   375: invokestatic 511	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[JLjava/lang/String;)V
    //   378: goto +3 -> 381
    //   381: aload 15
    //   383: getfield 571	tencent/im/oidb/search/DynamicTabSearch$RspBody:is_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   386: invokevirtual 343	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   389: iconst_1
    //   390: if_icmpne +238 -> 628
    //   393: iconst_1
    //   394: istore 5
    //   396: goto +3 -> 399
    //   399: aload 15
    //   401: getfield 572	tencent/im/oidb/search/DynamicTabSearch$RspBody:item_groups	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   404: invokevirtual 144	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   407: astore 16
    //   409: new 544	com/tencent/mobileqq/search/net/parser/NetBaseParser
    //   412: dup
    //   413: invokespecial 545	com/tencent/mobileqq/search/net/parser/NetBaseParser:<init>	()V
    //   416: iconst_3
    //   417: anewarray 316	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload 12
    //   424: aastore
    //   425: dup
    //   426: iconst_1
    //   427: aload 16
    //   429: aastore
    //   430: dup
    //   431: iconst_2
    //   432: aload_1
    //   433: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   436: ldc_w 547
    //   439: invokevirtual 551	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   442: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: aastore
    //   446: invokevirtual 554	com/tencent/mobileqq/search/net/parser/NetBaseParser:a	([Ljava/lang/Object;)Ljava/util/List;
    //   449: astore 16
    //   451: aload 15
    //   453: getfield 575	tencent/im/oidb/search/DynamicTabSearch$RspBody:sub_hot_top_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   456: invokevirtual 157	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   459: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   462: astore 17
    //   464: aload 15
    //   466: getfield 578	tencent/im/oidb/search/DynamicTabSearch$RspBody:dont_need_merge	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   469: invokevirtual 343	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   472: iconst_1
    //   473: if_icmpne +161 -> 634
    //   476: iconst_1
    //   477: istore 6
    //   479: goto +3 -> 482
    //   482: aload 15
    //   484: getfield 581	tencent/im/oidb/search/DynamicTabSearch$RspBody:hot_words	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   487: invokevirtual 144	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   490: astore 18
    //   492: aload 15
    //   494: getfield 584	tencent/im/oidb/search/DynamicTabSearch$RspBody:extension	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   497: invokevirtual 157	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   500: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   503: astore 15
    //   505: bipush 12
    //   507: anewarray 316	java/lang/Object
    //   510: astore_1
    //   511: aload_1
    //   512: iconst_0
    //   513: aload 12
    //   515: aastore
    //   516: aload_1
    //   517: iconst_1
    //   518: iload 7
    //   520: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   523: aastore
    //   524: aload_1
    //   525: iconst_2
    //   526: aload 13
    //   528: aastore
    //   529: aload_1
    //   530: iconst_3
    //   531: aload_3
    //   532: aastore
    //   533: aload_1
    //   534: iconst_4
    //   535: iload 5
    //   537: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   540: aastore
    //   541: aload_1
    //   542: iconst_5
    //   543: aload 16
    //   545: aastore
    //   546: aload_1
    //   547: bipush 6
    //   549: aload 14
    //   551: aastore
    //   552: aload_1
    //   553: bipush 7
    //   555: aload 17
    //   557: aastore
    //   558: aload_1
    //   559: bipush 8
    //   561: aload 18
    //   563: aastore
    //   564: aload_1
    //   565: bipush 9
    //   567: iload 6
    //   569: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   572: aastore
    //   573: aload_1
    //   574: bipush 10
    //   576: aload 15
    //   578: aastore
    //   579: aload_1
    //   580: bipush 11
    //   582: iload 4
    //   584: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   587: aastore
    //   588: aload_0
    //   589: sipush 1000
    //   592: iconst_1
    //   593: aload_1
    //   594: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   597: return
    //   598: astore_3
    //   599: aload_1
    //   600: astore_2
    //   601: aload_3
    //   602: astore_1
    //   603: goto +8 -> 611
    //   606: astore_1
    //   607: goto +4 -> 611
    //   610: astore_1
    //   611: aload_0
    //   612: sipush 1000
    //   615: iconst_0
    //   616: aload_2
    //   617: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   620: aload_1
    //   621: invokevirtual 402	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   624: return
    //   625: goto -244 -> 381
    //   628: iconst_0
    //   629: istore 5
    //   631: goto -232 -> 399
    //   634: iconst_0
    //   635: istore 6
    //   637: goto -155 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	640	0	this	UniteSearchHandler
    //   0	640	1	paramToServiceMsg	ToServiceMsg
    //   0	640	2	paramFromServiceMsg	FromServiceMsg
    //   0	640	3	paramObject	Object
    //   4	579	4	j	int
    //   394	236	5	bool1	boolean
    //   477	159	6	bool2	boolean
    //   97	422	7	bool3	boolean
    //   109	54	8	l1	long
    //   114	51	10	l2	long
    //   58	456	12	str1	String
    //   73	454	13	str2	String
    //   85	465	14	arrayOfLong	long[]
    //   227	350	15	localObject	Object
    //   407	137	16	localList1	List
    //   462	94	17	str3	String
    //   490	72	18	localList2	List
    // Exception table:
    //   from	to	target	type
    //   318	327	328	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   588	597	598	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   409	476	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   482	511	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   516	524	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   533	541	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   564	573	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   579	588	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   229	261	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   277	283	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   288	296	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   301	309	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   336	378	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   381	393	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   399	409	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = this.i;
    if ((localObject != null) && (((HashMap)localObject).containsKey(Long.valueOf(paramToServiceMsg.extraData.getLong("time_stamp")))))
    {
      localObject = (UniteSearchHandler.RequestSearchWordCallback)this.i.get(Long.valueOf(paramToServiceMsg.extraData.getLong("time_stamp")));
      this.i.remove(Long.valueOf(paramToServiceMsg.extraData.getLong("time_stamp")));
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
    else
    {
      paramToServiceMsg = null;
    }
    if (paramToServiceMsg != null)
    {
      localObject = new RequestSearchWord.RspBody();
      if (((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject) == 0) {
        try
        {
          ((RequestSearchWord.RspBody)localObject).mergeFrom((byte[])paramObject);
          paramToServiceMsg.a(((RequestSearchWord.RspBody)localObject).msg_search_keywords.rcmds, ((RequestSearchWord.RspBody)localObject).msg_search_keywords.sessionid);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(" handleGetPadRightsInfo exception: ");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 1, paramFromServiceMsg.toString());
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "sendBusiHotWordRequest. ");
    }
    DynamicBusinessHotWord.ReqBody localReqBody = new DynamicBusinessHotWord.ReqBody();
    localReqBody.business.set(128);
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    ToServiceMsg localToServiceMsg = createToServiceMsg("dynamic_busi_hot_word.1");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface, paramInt, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUniteSearchDiscovery. fromType ：");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, ((StringBuilder)localObject).toString());
    }
    if ((!paramBoolean) && (!SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), paramInt)))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("SearchDiscoveryLocalDataExpired. fromType ：");
        paramQQAppInterface.append(paramInt);
        QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramQQAppInterface.toString());
      }
      return;
    }
    Object localObject = new DynamicDiscovery.ReqBody();
    ((DynamicDiscovery.ReqBody)localObject).version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    ((DynamicDiscovery.ReqBody)localObject).business.set(128);
    ((DynamicDiscovery.ReqBody)localObject).from_type.set(paramInt);
    if ((paramInt != 10) && (paramInt != 6)) {
      paramQQAppInterface = createToServiceMsg("DynamicScDiscovery.1");
    } else {
      paramQQAppInterface = createToServiceMsg("qb_discovery.1");
    }
    paramQQAppInterface.extraData.putInt("fromType", paramInt);
    try
    {
      paramQQAppInterface.putWupBuffer(((DynamicDiscovery.ReqBody)localObject).toByteArray());
      label193:
      sendPbReq(paramQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      break label193;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str1 = String.valueOf(System.currentTimeMillis());
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    Object localObject = DatalineMathUtil.a(DatalineMathUtil.a());
    paramQQAppInterface = new DynamicKdReport.ReqBody();
    paramQQAppInterface.suin.set(c(str2));
    paramQQAppInterface.sclientIp.set(c((String)localObject));
    paramQQAppInterface.splatform.set("android");
    paramQQAppInterface.sversion.set(c("8.8.17"));
    localObject = paramQQAppInterface.ssessionId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(str1);
    ((PBStringField)localObject).set(c(localStringBuilder.toString()));
    paramQQAppInterface.stimeStamp.set(c(str1));
    paramQQAppInterface.sopername.set("Grp_all_search");
    paramQQAppInterface.smodule.set("hot_list");
    paramQQAppInterface.saction.set(c(paramString1));
    paramQQAppInterface.sreseverver2.set(c(paramString3));
    paramQQAppInterface.sreseverver4.set(c(paramString2));
    paramQQAppInterface.sreseverobj2.set(c(paramString4));
    paramString1 = createToServiceMsg("KDSearch.1");
    paramString1.putWupBuffer(paramQQAppInterface.toByteArray());
    sendPbReq(paramString1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    long l = System.currentTimeMillis();
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = DatalineMathUtil.a(DatalineMathUtil.a());
    paramQQAppInterface = new DynamicKdReport.ReqBody();
    paramQQAppInterface.sopername.set("Grp_all_search");
    paramQQAppInterface.suin.set(c(str1));
    paramQQAppInterface.sreseverver2.set(c("Kdfeedsback"));
    paramQQAppInterface.splatform.set("android");
    paramQQAppInterface.sversion.set(c("8.8.17"));
    paramQQAppInterface.smodule.set("all_result");
    paramQQAppInterface.sreseverobj1.set("2049");
    paramQQAppInterface.sclientIp.set(c(str2));
    paramQQAppInterface.ssessionId.set(paramString2);
    paramQQAppInterface.sreseverver3.set(c(paramString3));
    paramQQAppInterface.sreseverver4.set(c(paramString4));
    paramQQAppInterface.sreseverver5.set(c(paramString5));
    paramQQAppInterface.sreseverver6.set(c(paramString6));
    paramQQAppInterface.stimeStamp.set(c(String.valueOf(l)));
    paramQQAppInterface.saction.set(c(paramString1));
    paramString1 = createToServiceMsg("KDSearch.1");
    paramString1.putWupBuffer(paramQQAppInterface.toByteArray());
    sendPbReq(paramString1);
  }
  
  public void a(ByteStringMicro paramByteStringMicro, UniteSearchHandler.RequestSearchWordCallback paramRequestSearchWordCallback)
  {
    long l = System.currentTimeMillis();
    this.i.put(Long.valueOf(l), paramRequestSearchWordCallback);
    paramRequestSearchWordCallback = new RequestSearchWord.ReqBody();
    paramRequestSearchWordCallback.bytes_rowkey.set(paramByteStringMicro);
    paramRequestSearchWordCallback.uint32_oper_type.set(1);
    paramByteStringMicro = ((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).makeOIDBPkg("OidbSvc.0xd78_0", 3448, 0, paramRequestSearchWordCallback.toByteArray());
    paramByteStringMicro.extraData.putBoolean("req_pb_protocol_flag", true);
    paramByteStringMicro.extraData.putLong("time_stamp", l);
    sendPbReq(paramByteStringMicro);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<---handleBusiHotWord. resultCode=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, localStringBuilder.toString());
    }
    if (paramToServiceMsg != null) {
      a("dynamic_busi_hot_word.1", paramToServiceMsg.extraData.getLong("send_req_time"), paramInt, "");
    }
    if (paramInt != 1000)
    {
      notifyUI(1002, false, null);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1002, false, null);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1002, false, null);
      return;
    }
    paramToServiceMsg = new DynamicBusinessHotWord.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramInt = paramToServiceMsg.result_code.get();
      paramObject = paramToServiceMsg.error_msg.get();
      if (paramInt == 0)
      {
        paramInt = paramToServiceMsg.expire_time.get();
        BaseApplication.getContext().getSharedPreferences(d, 0).edit().putInt(f, paramInt).commit();
        paramToServiceMsg = paramToServiceMsg.rpt_item_groups.get();
        notifyUI(1002, true, new Object[] { Integer.valueOf(paramInt), a(paramToServiceMsg) });
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("response data: expireTime:");
          paramObject.append(paramInt);
          paramObject.append(",resultItemList :");
          paramObject.append(paramToServiceMsg.toString());
          QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramObject.toString());
        }
      }
      else
      {
        notifyUI(1002, false, new Object[] { Integer.valueOf(paramInt), paramObject });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(1002, false, null);
      paramToServiceMsg.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, 1, false);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendAssociationWordRequest. keyword=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, ((StringBuilder)localObject).toString());
    }
    DynamicAssociationWord.ReqBody localReqBody = new DynamicAssociationWord.ReqBody();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "sendAssociationWordRequest. keyword is empty.");
      return;
    }
    localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    localReqBody.business.set(128);
    localReqBody.need_flag.set(paramInt);
    if (paramBoolean) {
      localObject = createToServiceMsg("qb_association_word.1");
    } else {
      localObject = createToServiceMsg("dynamic_association_word.1");
    }
    ((ToServiceMsg)localObject).extraData.putString("keyword", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("send_req_time", System.currentTimeMillis());
    ((ToServiceMsg)localObject).extraData.putInt("needFlag", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, int paramInt2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt1, paramList1, paramList2, paramInt2, paramArrayOfByte, paramDouble1, paramDouble2, paramBoolean, false, paramInt3, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, int paramInt2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, Bundle paramBundle)
  {
    int j = paramInt2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send uniteSearch keyword = [");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("], time = [");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("], count = [");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("], businessMaskArray = [");
      ((StringBuilder)localObject1).append(paramList1);
      ((StringBuilder)localObject1).append("], fromAction = [");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("], cookie = [");
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      ((StringBuilder)localObject1).append("], latitude = [");
      ((StringBuilder)localObject1).append(paramDouble1);
      ((StringBuilder)localObject1).append("], longitude = [");
      ((StringBuilder)localObject1).append(paramDouble2);
      ((StringBuilder)localObject1).append("], isMoreSearch = [");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append("], hasLocalData = [");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append("]");
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new UniteSearch.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "send uniteSearch. keyword is empty.");
      return;
    }
    paramInt2 = j;
    if (j == 6) {
      paramInt2 = 1;
    }
    j = paramInt2;
    if (paramInt2 > 0) {
      j = paramInt2 - 1;
    }
    ((UniteSearch.ReqBody)localObject1).key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((UniteSearch.ReqBody)localObject1).version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    if (paramBoolean2) {
      ((UniteSearch.ReqBody)localObject1).client_has_people_and_qun.set(1);
    }
    if (paramInt3 == 1) {
      ((UniteSearch.ReqBody)localObject1).from_tabbar_index.set(0);
    } else if (paramInt3 == 2) {
      ((UniteSearch.ReqBody)localObject1).from_tabbar_index.set(1);
    } else if (paramInt3 == 21) {
      ((UniteSearch.ReqBody)localObject1).from_tabbar_index.set(2);
    } else {
      ((UniteSearch.ReqBody)localObject1).from_tabbar_index.set(0);
    }
    if (!paramBoolean1)
    {
      localObject2 = new DynamicSearch.RootSearcherRequest();
      ((DynamicSearch.RootSearcherRequest)localObject2).business.set(128);
      ((DynamicSearch.RootSearcherRequest)localObject2).rpt_busi_mask.set(SearchUtils.b(a));
      ((UniteSearch.ReqBody)localObject1).req_entity.set((MessageMicro)localObject2);
    }
    Object localObject2 = new DynamicSearch.RootSearcherRequest();
    ((DynamicSearch.RootSearcherRequest)localObject2).business.set(128);
    ((DynamicSearch.RootSearcherRequest)localObject2).page_size.set(paramInt1);
    ((DynamicSearch.RootSearcherRequest)localObject2).rpt_busi_mask.set(paramList1);
    if (paramArrayOfByte != null) {
      ((DynamicSearch.RootSearcherRequest)localObject2).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((UniteSearch.ReqBody)localObject1).req_topic.set((MessageMicro)localObject2);
    ((UniteSearch.ReqBody)localObject1).from_action.set(j);
    localObject2 = new DynamicSearch.ExtensionRequestInfo();
    Object localObject3 = SharedPreUtils.m(this.g.getCurrentAccountUin());
    if ((localObject3 != null) && (localObject3.length != 0))
    {
      paramInt2 = localObject3.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        if (localObject3[paramInt1].equals(paramString1))
        {
          paramInt1 = 1;
          break label575;
        }
        paramInt1 += 1;
      }
      paramInt1 = 2;
    }
    else
    {
      paramInt1 = 0;
    }
    label575:
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("key_word_src=");
      ((StringBuilder)localObject3).append(paramInt1);
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, ((StringBuilder)localObject3).toString());
    }
    if (paramBundle != null)
    {
      paramInt2 = paramBundle.getInt("matchCount", 0);
      j = paramBundle.getInt("source", 0);
      ((UniteSearch.ReqBody)localObject1).locate_result_count.set(paramInt2);
      ((UniteSearch.ReqBody)localObject1).source.set(j);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("matchCount=");
        paramBundle.append(paramInt2);
        paramBundle.append(" source=");
        paramBundle.append(j);
        QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramBundle.toString());
      }
    }
    ((DynamicSearch.ExtensionRequestInfo)localObject2).key_word_src.set(paramInt1);
    ((DynamicSearch.ExtensionRequestInfo)localObject2).latitude.set((float)paramDouble1);
    ((DynamicSearch.ExtensionRequestInfo)localObject2).longitude.set((float)paramDouble2);
    if (paramList2 != null) {
      ((DynamicSearch.ExtensionRequestInfo)localObject2).rpt_pubacc_local_result.set(paramList2);
    }
    ((UniteSearch.ReqBody)localObject1).extension_request_info.set((MessageMicro)localObject2);
    paramList2 = createToServiceMsg("dynamic_unite_search.1");
    paramList2.extraData.putInt("fromType", paramInt3);
    paramList2.extraData.putString("keyword", paramString1);
    paramString1 = paramList2.extraData;
    paramBoolean1 = true;
    paramString1.putString("time", paramString2);
    paramList2.extraData.putLongArray("masks", SearchUtil.a(paramList1));
    paramString1 = paramList2.extraData;
    if (paramArrayOfByte != null) {
      paramBoolean1 = false;
    }
    paramString1.putBoolean("isFirstReq", paramBoolean1);
    paramList2.extraData.putLong("send_req_time", System.currentTimeMillis());
    paramList2.putWupBuffer(((UniteSearch.ReqBody)localObject1).toByteArray());
    sendPbReq(paramList2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, List<Long> paramList1, List<Long> paramList2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt, paramList1, paramList2, paramArrayOfByte, 0, paramDouble1, paramDouble2, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, byte[] paramArrayOfByte, int paramInt2, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send tabSearch keyword = [");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("], reqTime = [");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("], count = [");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("], businessMaskArray = [");
      ((StringBuilder)localObject1).append(paramList1);
      ((StringBuilder)localObject1).append("], cookie = [");
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      ((StringBuilder)localObject1).append("], latitude = [");
      ((StringBuilder)localObject1).append(paramDouble1);
      ((StringBuilder)localObject1).append("], longitude = [");
      ((StringBuilder)localObject1).append(paramDouble2);
      ((StringBuilder)localObject1).append("]");
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new DynamicTabSearch.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "send tabSearch. keyword is empty.");
      return;
    }
    ((DynamicTabSearch.ReqBody)localObject1).key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((DynamicTabSearch.ReqBody)localObject1).version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    Object localObject2 = new DynamicSearch.RootSearcherRequest();
    ((DynamicSearch.RootSearcherRequest)localObject2).business.set(128);
    ((DynamicSearch.RootSearcherRequest)localObject2).page_size.set(paramInt1);
    ((DynamicSearch.RootSearcherRequest)localObject2).rpt_busi_mask.set(paramList1);
    if (paramArrayOfByte != null) {
      ((DynamicSearch.RootSearcherRequest)localObject2).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((DynamicTabSearch.ReqBody)localObject1).search_request.set((MessageMicro)localObject2);
    localObject2 = new DynamicSearch.ExtensionRequestInfo();
    ((DynamicSearch.ExtensionRequestInfo)localObject2).latitude.set((float)paramDouble1);
    ((DynamicSearch.ExtensionRequestInfo)localObject2).longitude.set((float)paramDouble2);
    int j;
    if (FunctionModuleConfigManager.b.isEmpty())
    {
      j = 0;
    }
    else
    {
      Iterator localIterator1 = FunctionModuleConfigManager.b.values().iterator();
      paramInt1 = 2;
      for (;;)
      {
        j = paramInt1;
        if (!localIterator1.hasNext()) {
          break label396;
        }
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        if (localIterator2.hasNext())
        {
          if (!paramString1.equals((BusinessGroupWord.HotWordItem)localIterator2.next())) {
            break;
          }
          paramInt1 = 1;
        }
      }
    }
    label396:
    ((DynamicSearch.ExtensionRequestInfo)localObject2).key_word_src.set(j);
    if (paramList2 != null) {
      ((DynamicSearch.ExtensionRequestInfo)localObject2).rpt_pubacc_local_result.set(paramList2);
    }
    ((DynamicTabSearch.ReqBody)localObject1).extension_request_info.set((MessageMicro)localObject2);
    if (paramInt2 != 0) {
      ((DynamicTabSearch.ReqBody)localObject1).from_sub_hot_word_id.set(paramInt2, true);
    }
    paramList2 = createToServiceMsg("dynamic_tab_search.1");
    paramList2.extraData.putString("keyword", paramString1);
    paramList2.extraData.putString("time", paramString2);
    paramList2.extraData.putLongArray("masks", SearchUtil.a(paramList1));
    paramString2 = paramList2.extraData;
    boolean bool;
    if (paramArrayOfByte == null) {
      bool = true;
    } else {
      bool = false;
    }
    paramString2.putBoolean("isFirstReq", bool);
    paramList2.extraData.putLong("send_req_time", System.currentTimeMillis());
    if (paramBundle != null)
    {
      bool = paramBundle.getBoolean("isLoadMore", false);
      paramInt1 = paramBundle.getInt("fromTypeForReport", 0);
      if (!bool)
      {
        paramString2 = SearchUtils.a(paramList1);
        paramList1 = new StringBuilder();
        paramList1.append("");
        paramList1.append(paramInt1);
        SearchUtils.a("sub_result", "active_search", new String[] { paramString1, paramString2, paramList1.toString(), "" });
      }
      paramList2.extraData.putAll(paramBundle);
    }
    paramList2.putWupBuffer(((DynamicTabSearch.ReqBody)localObject1).toByteArray());
    sendPbReq(paramList2);
  }
  
  public void a(byte[] paramArrayOfByte, IHippyWupCallback paramIHippyWupCallback, Integer paramInteger)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "getUniteSearchDiscovery. fromHippy ：");
    }
    paramIHippyWupCallback = new DynamicDiscovery.ReqBody();
    paramIHippyWupCallback.version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    paramIHippyWupCallback.business.set(128);
    paramIHippyWupCallback.extend_type.set(1);
    paramIHippyWupCallback.jce_req_buffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = createToServiceMsg("qb_discovery.1");
    paramArrayOfByte.extraData.putInt("fromType", 11);
    paramArrayOfByte.extraData.putInt("searchHippyRequestId", paramInteger.intValue());
    try
    {
      paramArrayOfByte.putWupBuffer(paramIHippyWupCallback.toByteArray());
      label107:
      sendPbReq(paramArrayOfByte);
      return;
    }
    catch (Exception paramIHippyWupCallback)
    {
      break label107;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sasa_report=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" module=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("ver2=");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("ver4=");
    ((StringBuilder)localObject).append(paramString5);
    ((StringBuilder)localObject).append("ver7=");
    ((StringBuilder)localObject).append(paramString6);
    QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 1, ((StringBuilder)localObject).toString());
    long l = System.currentTimeMillis();
    localObject = paramQQAppInterface.getCurrentAccountUin();
    String str = DatalineMathUtil.a(DatalineMathUtil.a());
    paramQQAppInterface = new DynamicKdReport.ReqBody();
    paramQQAppInterface.sopername.set("Grp_all_search");
    paramQQAppInterface.suin.set(c((String)localObject));
    paramQQAppInterface.sreseverver2.set(c(paramString3));
    paramQQAppInterface.splatform.set("android");
    paramQQAppInterface.sversion.set(c("8.8.17"));
    paramQQAppInterface.smodule.set(c(paramString2));
    paramQQAppInterface.sreseverobj1.set("2049");
    paramQQAppInterface.sclientIp.set(c(str));
    paramQQAppInterface.sreseverver3.set(c(paramString4));
    paramQQAppInterface.sreseverver4.set(c(paramString5));
    paramQQAppInterface.sreseverver7.set(c(paramString6));
    paramQQAppInterface.stimeStamp.set(c(String.valueOf(l)));
    paramQQAppInterface.saction.set(c(paramString1));
    paramString1 = createToServiceMsg("KDSearch.1");
    paramString1.putWupBuffer(paramQQAppInterface.toByteArray());
    sendPbReq(paramString1);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUniteSearchDiscovery. code ：");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, ((StringBuilder)localObject).toString());
    }
    int j = paramToServiceMsg.extraData.getInt("fromType");
    if (j == 11)
    {
      notifyUI(1008, true, new Object[] { paramToServiceMsg, Integer.valueOf(paramInt), paramObject });
      return;
    }
    if ((paramInt == 1000) && ((paramObject instanceof byte[]))) {
      localObject = new DynamicDiscovery.RspBody();
    }
    try
    {
      ((DynamicDiscovery.RspBody)localObject).mergeFrom((byte[])paramObject);
      paramInt = ((DynamicDiscovery.RspBody)localObject).result_code.get();
      if (((DynamicDiscovery.RspBody)localObject).error_msg.get() == null) {
        break label362;
      }
      paramToServiceMsg = ((DynamicDiscovery.RspBody)localObject).error_msg.get().toStringUtf8();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        continue;
        paramToServiceMsg = null;
        continue;
        paramToServiceMsg = null;
      }
    }
    if (paramInt == 0)
    {
      SharedPreUtils.a(this.appRuntime.getAccount(), j, ((DynamicDiscovery.RspBody)localObject).expire_time.get());
      paramToServiceMsg = ((DynamicDiscovery.RspBody)localObject).result_items.get();
      paramObject = SearchEntryDataModel.a(this.g, paramToServiceMsg, j);
      if (((DynamicDiscovery.RspBody)localObject).bucket_id.get() != null)
      {
        paramToServiceMsg = ((DynamicDiscovery.RspBody)localObject).bucket_id.get().toStringUtf8();
        com.tencent.mobileqq.search.report.UniteSearchReportController.b = paramToServiceMsg;
        notifyUI(1007, true, new Object[] { paramObject, Integer.valueOf(j) });
      }
    }
    else
    {
      notifyUI(1007, false, new Object[] { Integer.valueOf(paramInt), paramToServiceMsg, Integer.valueOf(j) });
      return;
      notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(j) });
      return;
      notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(j) });
      return;
    }
  }
  
  public byte[] b(String paramString)
  {
    return FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath(paramString));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return UniteSearchObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(", serviceCmd: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", resultCode: ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, localStringBuilder.toString());
    }
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmd filter error=");
        paramToServiceMsg.append(str);
        QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramToServiceMsg.toString());
      }
      return;
    }
    int j;
    if ((!"dynamic_association_word.1".equals(str)) && (!"qb_association_word.1".equals(str)))
    {
      if ("dynamic_unite_search.1".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("dynamic_tab_search.1".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("dynamic_busi_hot_word.1".equals(str))
      {
        j = paramFromServiceMsg.getResultCode();
        a(j, paramObject, d, e);
        a(paramToServiceMsg, j, paramObject);
        return;
      }
      if ((!"DynamicScDiscovery.1".equals(str)) && (!"qb_discovery.1".equals(str)))
      {
        if ("OidbSvc.0xd78_0".equals(str)) {
          e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else {
        b(paramToServiceMsg, paramFromServiceMsg.getResultCode(), paramObject);
      }
    }
    else
    {
      j = paramToServiceMsg.extraData.getInt("needFlag", 0);
      if ((j & 0x4) != 0) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      if (((j & 0x2) != 0) || ((j & 0x1) != 0)) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniteSearchHandler
 * JD-Core Version:    0.7.0.1
 */