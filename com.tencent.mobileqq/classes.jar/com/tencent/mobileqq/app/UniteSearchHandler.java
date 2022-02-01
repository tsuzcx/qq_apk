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
  public static String a;
  public static long[] a;
  public static String b;
  public static long[] b;
  public static String c;
  public static long[] c;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, UniteSearchHandler.RequestSearchWordCallback> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 1001L, 1002L, 1003L, 1005L, 2073745984L, 1006L };
    jdField_b_of_type_ArrayOfLong = new long[] { 1004L };
    jdField_c_of_type_ArrayOfLong = new long[] { 2073745984L, 1073745984L, 1001L, 8001L, 1002L, 1003L, 1005L, 1006L };
    jdField_a_of_type_JavaLangString = "hot_word_for_sub_business";
    jdField_b_of_type_JavaLangString = "hot_word_for_sub_business_req_time";
    jdField_c_of_type_JavaLangString = "hot_word_for_sub_business_exprire_time";
  }
  
  public UniteSearchHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    }
  }
  
  public UniteSearchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  private List<BusinessGroupWord> a(List<DynamicBusinessHotWord.GroupWord> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    FunctionModuleConfigManager.jdField_a_of_type_JavaUtilHashMap.clear();
    FunctionModuleConfigManager.b.clear();
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
      FunctionModuleConfigManager.jdField_a_of_type_JavaUtilHashMap.put(FunctionModuleConfigManager.a(localGroupID.a), localArrayList2);
      localObject2 = (DynamicBusinessHotWord.ClueWordItem)((DynamicBusinessHotWord.GroupWord)localObject1).clue_word_item.get();
      localObject1 = ((DynamicBusinessHotWord.ClueWordItem)localObject2).word_id.get().toStringUtf8();
      localObject2 = ((DynamicBusinessHotWord.ClueWordItem)localObject2).word.get().toStringUtf8();
      localObject1 = new BusinessGroupWord.ClueWordItem((String)localObject1, (String)localObject2);
      FunctionModuleConfigManager.b.put(FunctionModuleConfigManager.a(localGroupID.a), localObject2);
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
    if (paramInt == 1000)
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
      paramObject = new StringBuilder();
      paramObject.append("code is error，do not save the data, code=");
      paramObject.append(paramInt);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramObject.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleCompletedUrlResult. resultCode=");
      paramFromServiceMsg.append(i);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramFromServiceMsg.toString());
    }
    String str = paramToServiceMsg.extraData.getString("keyword", "");
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = str;
    paramFromServiceMsg[1] = Integer.valueOf(-1);
    paramFromServiceMsg[2] = "";
    if (i != 1000)
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
      i = paramToServiceMsg.result_code.get();
      paramObject = paramToServiceMsg.error_msg.get();
      if ((i != 0) && (i != 1009))
      {
        paramToServiceMsg = new Object[3];
        paramToServiceMsg[0] = str;
        paramToServiceMsg[1] = Integer.valueOf(i);
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
          localAssociateItem.jdField_a_of_type_JavaLangString = localAssociationItem.word.get().toStringUtf8();
          localAssociateItem.jdField_b_of_type_JavaLangString = localAssociationItem.subWord.get().toStringUtf8();
          localAssociateItem.d = localAssociationItem.pic_url.get().toStringUtf8();
          localAssociateItem.jdField_c_of_type_JavaLangString = localAssociationItem.jmp_url.get().toStringUtf8();
          localAssociateItem.jdField_b_of_type_Int = localAssociationItem.type.get();
          localAssociateItem.jdField_c_of_type_Int = localAssociationItem.group_mask.get();
          localArrayList.add(localAssociateItem);
        }
        localObject = paramObject.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramToServiceMsg.add(((DynamicAssociationWord.SuggestUrlItem)((Iterator)localObject).next()).url.get().toStringUtf8());
        }
        paramToServiceMsg = new Object[5];
        paramToServiceMsg[0] = str;
        paramToServiceMsg[1] = Integer.valueOf(i);
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
    paramString1 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_search_engineer").c("search_net").d(paramString1);
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
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleCompletedUrlResult. resultCode=");
      paramFromServiceMsg.append(i);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramFromServiceMsg.toString());
    }
    String str = paramToServiceMsg.extraData.getString("keyword", "");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = "";
    if (i != 1000)
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
      i = paramFromServiceMsg.result_code.get();
      paramObject = paramFromServiceMsg.error_msg.get();
      if ((i != 0) && (i != 1009))
      {
        paramFromServiceMsg = new Object[3];
        paramFromServiceMsg[0] = str;
        paramFromServiceMsg[1] = Integer.valueOf(i);
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
        paramFromServiceMsg[2] = Integer.valueOf(i);
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
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleUniteSearchResult. resultCode=");
      paramFromServiceMsg.append(i);
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, paramFromServiceMsg.toString());
    }
    SearchCostStat.a("uniteNetCode", String.valueOf(i));
    SearchCostStat.b("UniteNetRec");
    String str1 = paramToServiceMsg.extraData.getString("keyword", "");
    String str2 = paramToServiceMsg.extraData.getString("time", "");
    Object localObject2 = paramToServiceMsg.extraData.getLongArray("masks");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isFirstReq");
    long l1 = paramToServiceMsg.extraData.getLong("send_req_time");
    long l2 = i;
    paramFromServiceMsg = new Object[] { str1, Boolean.valueOf(bool2), str2, Integer.valueOf(-1), "" };
    a("dynamic_unite_search.1", l1, l2, str1);
    if (i != 1000)
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
        i = localRspBody.result_code.get();
        Object localObject1 = localRspBody.error_msg.get();
        if ((i != 0) && (i < 1000))
        {
          paramObject = new Object[5];
          paramObject[0] = str1;
          paramObject[1] = Boolean.valueOf(bool2);
          paramObject[2] = str2;
          paramObject[3] = Integer.valueOf(i);
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
            break label622;
          }
          bool1 = true;
          paramObject = localRspBody.tab_groups.get();
          localObject2 = new ArrayList(paramObject.size());
          i = 0;
          if (i < paramObject.size())
          {
            ((List)localObject2).add(new GroupTabModel((UniteSearch.TabItemGroup)paramObject.get(i)));
            i += 1;
            continue;
          }
          i = localRspBody.trigger_netword_num.get();
          if (i >= 0) {
            SharedPreUtils.r(BaseApplicationImpl.getContext(), i);
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
      label622:
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
    //   6: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +36 -> 45
    //   12: new 207	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc_w 548
    //   24: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: iload 4
    //   31: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: ldc 228
    //   37: iconst_2
    //   38: aload_2
    //   39: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_1
    //   46: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   49: ldc_w 308
    //   52: ldc 78
    //   54: invokevirtual 314	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 12
    //   59: aload_1
    //   60: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: ldc_w 452
    //   66: ldc 78
    //   68: invokevirtual 314	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 13
    //   73: aload_1
    //   74: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   77: ldc_w 454
    //   80: invokevirtual 458	android/os/Bundle:getLongArray	(Ljava/lang/String;)[J
    //   83: astore 14
    //   85: aload_1
    //   86: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   89: ldc_w 460
    //   92: invokevirtual 464	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   95: istore 7
    //   97: aload_1
    //   98: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   101: ldc_w 466
    //   104: invokevirtual 470	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   107: lstore 8
    //   109: iload 4
    //   111: i2l
    //   112: lstore 10
    //   114: bipush 6
    //   116: anewarray 316	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload 12
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: iload 7
    //   128: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   131: aastore
    //   132: dup
    //   133: iconst_2
    //   134: aload 13
    //   136: aastore
    //   137: dup
    //   138: iconst_3
    //   139: iconst_m1
    //   140: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aastore
    //   144: dup
    //   145: iconst_4
    //   146: ldc 78
    //   148: aastore
    //   149: dup
    //   150: iconst_5
    //   151: aload 14
    //   153: aastore
    //   154: astore_2
    //   155: aload_0
    //   156: ldc_w 550
    //   159: lload 8
    //   161: lload 10
    //   163: aload 12
    //   165: invokespecial 479	com/tencent/mobileqq/app/UniteSearchHandler:a	(Ljava/lang/String;JJLjava/lang/String;)V
    //   168: iload 4
    //   170: sipush 1000
    //   173: if_icmpeq +13 -> 186
    //   176: aload_0
    //   177: sipush 1000
    //   180: iconst_0
    //   181: aload_2
    //   182: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   185: return
    //   186: aload_3
    //   187: ifnonnull +13 -> 200
    //   190: aload_0
    //   191: sipush 1000
    //   194: iconst_0
    //   195: aload_2
    //   196: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   199: return
    //   200: aload_3
    //   201: instanceof 328
    //   204: ifne +13 -> 217
    //   207: aload_0
    //   208: sipush 1000
    //   211: iconst_0
    //   212: aload_2
    //   213: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   216: return
    //   217: new 552	tencent/im/oidb/search/DynamicTabSearch$RspBody
    //   220: dup
    //   221: invokespecial 553	tencent/im/oidb/search/DynamicTabSearch$RspBody:<init>	()V
    //   224: astore 15
    //   226: aload 15
    //   228: aload_3
    //   229: checkcast 328	[B
    //   232: checkcast 328	[B
    //   235: invokevirtual 554	tencent/im/oidb/search/DynamicTabSearch$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   238: pop
    //   239: aload 15
    //   241: getfield 555	tencent/im/oidb/search/DynamicTabSearch$RspBody:result_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   244: invokevirtual 343	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   247: istore 4
    //   249: aload 15
    //   251: getfield 556	tencent/im/oidb/search/DynamicTabSearch$RspBody:error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   254: invokevirtual 351	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   257: astore_3
    //   258: iload 4
    //   260: ifeq +73 -> 333
    //   263: iload 4
    //   265: sipush 1000
    //   268: if_icmplt +6 -> 274
    //   271: goto +62 -> 333
    //   274: bipush 6
    //   276: anewarray 316	java/lang/Object
    //   279: astore_1
    //   280: aload_1
    //   281: iconst_0
    //   282: aload 12
    //   284: aastore
    //   285: aload_1
    //   286: iconst_1
    //   287: iload 7
    //   289: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   292: aastore
    //   293: aload_1
    //   294: iconst_2
    //   295: aload 13
    //   297: aastore
    //   298: aload_1
    //   299: iconst_3
    //   300: iload 4
    //   302: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: aastore
    //   306: aload_1
    //   307: iconst_4
    //   308: aload_3
    //   309: aastore
    //   310: aload_1
    //   311: iconst_5
    //   312: aload 14
    //   314: aastore
    //   315: aload_0
    //   316: sipush 1000
    //   319: iconst_0
    //   320: aload_1
    //   321: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   324: return
    //   325: astore_3
    //   326: aload_1
    //   327: astore_2
    //   328: aload_3
    //   329: astore_1
    //   330: goto +278 -> 608
    //   333: aload 15
    //   335: getfield 559	tencent/im/oidb/search/DynamicTabSearch$RspBody:cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   338: invokevirtual 159	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   341: invokevirtual 492	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   344: astore_3
    //   345: aload 15
    //   347: getfield 560	tencent/im/oidb/search/DynamicTabSearch$RspBody:search_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   350: invokevirtual 498	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   353: ifeq +269 -> 622
    //   356: ldc_w 550
    //   359: aload 14
    //   361: aload 15
    //   363: getfield 560	tencent/im/oidb/search/DynamicTabSearch$RspBody:search_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   366: invokevirtual 159	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   369: invokevirtual 165	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   372: invokestatic 503	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[JLjava/lang/String;)V
    //   375: goto +3 -> 378
    //   378: aload 15
    //   380: getfield 563	tencent/im/oidb/search/DynamicTabSearch$RspBody:is_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: invokevirtual 343	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   386: iconst_1
    //   387: if_icmpne +238 -> 625
    //   390: iconst_1
    //   391: istore 5
    //   393: goto +3 -> 396
    //   396: aload 15
    //   398: getfield 564	tencent/im/oidb/search/DynamicTabSearch$RspBody:item_groups	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   401: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   404: astore 16
    //   406: new 536	com/tencent/mobileqq/search/net/parser/NetBaseParser
    //   409: dup
    //   410: invokespecial 537	com/tencent/mobileqq/search/net/parser/NetBaseParser:<init>	()V
    //   413: iconst_3
    //   414: anewarray 316	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: aload 12
    //   421: aastore
    //   422: dup
    //   423: iconst_1
    //   424: aload 16
    //   426: aastore
    //   427: dup
    //   428: iconst_2
    //   429: aload_1
    //   430: getfield 306	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   433: ldc_w 539
    //   436: invokevirtual 543	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   439: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   442: aastore
    //   443: invokevirtual 546	com/tencent/mobileqq/search/net/parser/NetBaseParser:a	([Ljava/lang/Object;)Ljava/util/List;
    //   446: astore 16
    //   448: aload 15
    //   450: getfield 567	tencent/im/oidb/search/DynamicTabSearch$RspBody:sub_hot_top_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   453: invokevirtual 159	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   456: invokevirtual 165	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   459: astore 17
    //   461: aload 15
    //   463: getfield 570	tencent/im/oidb/search/DynamicTabSearch$RspBody:dont_need_merge	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   466: invokevirtual 343	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   469: iconst_1
    //   470: if_icmpne +161 -> 631
    //   473: iconst_1
    //   474: istore 6
    //   476: goto +3 -> 479
    //   479: aload 15
    //   481: getfield 573	tencent/im/oidb/search/DynamicTabSearch$RspBody:hot_words	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   484: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   487: astore 18
    //   489: aload 15
    //   491: getfield 576	tencent/im/oidb/search/DynamicTabSearch$RspBody:extension	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   494: invokevirtual 159	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   497: invokevirtual 165	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   500: astore 15
    //   502: bipush 12
    //   504: anewarray 316	java/lang/Object
    //   507: astore_1
    //   508: aload_1
    //   509: iconst_0
    //   510: aload 12
    //   512: aastore
    //   513: aload_1
    //   514: iconst_1
    //   515: iload 7
    //   517: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   520: aastore
    //   521: aload_1
    //   522: iconst_2
    //   523: aload 13
    //   525: aastore
    //   526: aload_1
    //   527: iconst_3
    //   528: aload_3
    //   529: aastore
    //   530: aload_1
    //   531: iconst_4
    //   532: iload 5
    //   534: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   537: aastore
    //   538: aload_1
    //   539: iconst_5
    //   540: aload 16
    //   542: aastore
    //   543: aload_1
    //   544: bipush 6
    //   546: aload 14
    //   548: aastore
    //   549: aload_1
    //   550: bipush 7
    //   552: aload 17
    //   554: aastore
    //   555: aload_1
    //   556: bipush 8
    //   558: aload 18
    //   560: aastore
    //   561: aload_1
    //   562: bipush 9
    //   564: iload 6
    //   566: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   569: aastore
    //   570: aload_1
    //   571: bipush 10
    //   573: aload 15
    //   575: aastore
    //   576: aload_1
    //   577: bipush 11
    //   579: iload 4
    //   581: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   584: aastore
    //   585: aload_0
    //   586: sipush 1000
    //   589: iconst_1
    //   590: aload_1
    //   591: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   594: return
    //   595: astore_3
    //   596: aload_1
    //   597: astore_2
    //   598: aload_3
    //   599: astore_1
    //   600: goto +8 -> 608
    //   603: astore_1
    //   604: goto +4 -> 608
    //   607: astore_1
    //   608: aload_0
    //   609: sipush 1000
    //   612: iconst_0
    //   613: aload_2
    //   614: invokevirtual 326	com/tencent/mobileqq/app/UniteSearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   617: aload_1
    //   618: invokevirtual 401	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   621: return
    //   622: goto -244 -> 378
    //   625: iconst_0
    //   626: istore 5
    //   628: goto -232 -> 396
    //   631: iconst_0
    //   632: istore 6
    //   634: goto -155 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	UniteSearchHandler
    //   0	637	1	paramToServiceMsg	ToServiceMsg
    //   0	637	2	paramFromServiceMsg	FromServiceMsg
    //   0	637	3	paramObject	Object
    //   4	576	4	i	int
    //   391	236	5	bool1	boolean
    //   474	159	6	bool2	boolean
    //   95	421	7	bool3	boolean
    //   107	53	8	l1	long
    //   112	50	10	l2	long
    //   57	454	12	str1	String
    //   71	453	13	str2	String
    //   83	464	14	arrayOfLong	long[]
    //   224	350	15	localObject	Object
    //   404	137	16	localList1	List
    //   459	94	17	str3	String
    //   487	72	18	localList2	List
    // Exception table:
    //   from	to	target	type
    //   315	324	325	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   585	594	595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   406	473	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   479	508	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   513	521	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   530	538	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   561	570	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   576	585	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   226	258	607	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   274	280	607	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   285	293	607	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   298	306	607	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   333	375	607	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   378	390	607	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   396	406	607	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject != null) && (((HashMap)localObject).containsKey(Long.valueOf(paramToServiceMsg.extraData.getLong("time_stamp")))))
    {
      localObject = (UniteSearchHandler.RequestSearchWordCallback)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramToServiceMsg.extraData.getLong("time_stamp")));
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramToServiceMsg.extraData.getLong("time_stamp")));
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
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
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
    ((DynamicDiscovery.ReqBody)localObject).version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
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
    paramQQAppInterface.suin.set(a(str2));
    paramQQAppInterface.sclientIp.set(a((String)localObject));
    paramQQAppInterface.splatform.set("android");
    paramQQAppInterface.sversion.set(a("8.7.0"));
    localObject = paramQQAppInterface.ssessionId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(str1);
    ((PBStringField)localObject).set(a(localStringBuilder.toString()));
    paramQQAppInterface.stimeStamp.set(a(str1));
    paramQQAppInterface.sopername.set("Grp_all_search");
    paramQQAppInterface.smodule.set("hot_list");
    paramQQAppInterface.saction.set(a(paramString1));
    paramQQAppInterface.sreseverver2.set(a(paramString3));
    paramQQAppInterface.sreseverver4.set(a(paramString2));
    paramQQAppInterface.sreseverobj2.set(a(paramString4));
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
    paramQQAppInterface.suin.set(a(str1));
    paramQQAppInterface.sreseverver2.set(a("Kdfeedsback"));
    paramQQAppInterface.splatform.set("android");
    paramQQAppInterface.sversion.set(a("8.7.0"));
    paramQQAppInterface.smodule.set("all_result");
    paramQQAppInterface.sreseverobj1.set("2049");
    paramQQAppInterface.sclientIp.set(a(str2));
    paramQQAppInterface.ssessionId.set(paramString2);
    paramQQAppInterface.sreseverver3.set(a(paramString3));
    paramQQAppInterface.sreseverver4.set(a(paramString4));
    paramQQAppInterface.sreseverver5.set(a(paramString5));
    paramQQAppInterface.sreseverver6.set(a(paramString6));
    paramQQAppInterface.stimeStamp.set(a(String.valueOf(l)));
    paramQQAppInterface.saction.set(a(paramString1));
    paramString1 = createToServiceMsg("KDSearch.1");
    paramString1.putWupBuffer(paramQQAppInterface.toByteArray());
    sendPbReq(paramString1);
  }
  
  public void a(ByteStringMicro paramByteStringMicro, UniteSearchHandler.RequestSearchWordCallback paramRequestSearchWordCallback)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), paramRequestSearchWordCallback);
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
        BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit().putInt(jdField_c_of_type_JavaLangString, paramInt).commit();
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
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
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
    int i = paramInt2;
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
      ((StringBuilder)localObject1).append(i);
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
    paramInt2 = i;
    if (i == 6) {
      paramInt2 = 1;
    }
    i = paramInt2;
    if (paramInt2 > 0) {
      i = paramInt2 - 1;
    }
    ((UniteSearch.ReqBody)localObject1).key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((UniteSearch.ReqBody)localObject1).version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
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
      ((DynamicSearch.RootSearcherRequest)localObject2).rpt_busi_mask.set(SearchUtils.a(jdField_a_of_type_ArrayOfLong));
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
    ((UniteSearch.ReqBody)localObject1).from_action.set(i);
    localObject2 = new DynamicSearch.ExtensionRequestInfo();
    Object localObject3 = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      i = paramBundle.getInt("source", 0);
      ((UniteSearch.ReqBody)localObject1).locate_result_count.set(paramInt2);
      ((UniteSearch.ReqBody)localObject1).source.set(i);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("matchCount=");
        paramBundle.append(paramInt2);
        paramBundle.append(" source=");
        paramBundle.append(i);
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
    ((DynamicTabSearch.ReqBody)localObject1).version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
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
    int i;
    if (FunctionModuleConfigManager.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      i = 0;
    }
    else
    {
      Iterator localIterator1 = FunctionModuleConfigManager.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      paramInt1 = 2;
      for (;;)
      {
        i = paramInt1;
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
    ((DynamicSearch.ExtensionRequestInfo)localObject2).key_word_src.set(i);
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
    paramIHippyWupCallback.version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
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
  
  public byte[] a(String paramString)
  {
    return FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath(paramString));
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
    paramQQAppInterface.suin.set(a((String)localObject));
    paramQQAppInterface.sreseverver2.set(a(paramString3));
    paramQQAppInterface.splatform.set("android");
    paramQQAppInterface.sversion.set(a("8.7.0"));
    paramQQAppInterface.smodule.set(a(paramString2));
    paramQQAppInterface.sreseverobj1.set("2049");
    paramQQAppInterface.sclientIp.set(a(str));
    paramQQAppInterface.sreseverver3.set(a(paramString4));
    paramQQAppInterface.sreseverver4.set(a(paramString5));
    paramQQAppInterface.sreseverver7.set(a(paramString6));
    paramQQAppInterface.stimeStamp.set(a(String.valueOf(l)));
    paramQQAppInterface.saction.set(a(paramString1));
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
    int i = paramToServiceMsg.extraData.getInt("fromType");
    if (i == 11)
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
      SharedPreUtils.a(this.appRuntime.getAccount(), i, ((DynamicDiscovery.RspBody)localObject).expire_time.get());
      paramToServiceMsg = ((DynamicDiscovery.RspBody)localObject).result_items.get();
      paramObject = SearchEntryDataModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, i);
      if (((DynamicDiscovery.RspBody)localObject).bucket_id.get() != null)
      {
        paramToServiceMsg = ((DynamicDiscovery.RspBody)localObject).bucket_id.get().toStringUtf8();
        com.tencent.mobileqq.search.report.UniteSearchReportController.jdField_b_of_type_JavaLangString = paramToServiceMsg;
        notifyUI(1007, true, new Object[] { paramObject, Integer.valueOf(i) });
      }
    }
    else
    {
      notifyUI(1007, false, new Object[] { Integer.valueOf(paramInt), paramToServiceMsg, Integer.valueOf(i) });
      return;
      notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
      return;
      notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
      return;
    }
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
    int i;
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
        i = paramFromServiceMsg.getResultCode();
        a(i, paramObject, jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString);
        a(paramToServiceMsg, i, paramObject);
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
      i = paramToServiceMsg.extraData.getInt("needFlag", 0);
      if ((i & 0x4) != 0) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      if (((i & 0x2) != 0) || ((i & 0x1) != 0)) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniteSearchHandler
 * JD-Core Version:    0.7.0.1
 */