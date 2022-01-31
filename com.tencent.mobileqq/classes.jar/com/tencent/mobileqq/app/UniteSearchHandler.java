package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import pb.unite.search.DynamicAssociationWord.AssociationItem;
import pb.unite.search.DynamicAssociationWord.ReqBody;
import pb.unite.search.DynamicAssociationWord.RspBody;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;
import pb.unite.search.DynamicBusinessHotWord.ClueWordItem;
import pb.unite.search.DynamicBusinessHotWord.GroupID;
import pb.unite.search.DynamicBusinessHotWord.GroupWord;
import pb.unite.search.DynamicBusinessHotWord.HotWordItem;
import pb.unite.search.DynamicBusinessHotWord.ReqBody;
import pb.unite.search.DynamicBusinessHotWord.RspBody;
import pb.unite.search.DynamicContentRecommend.ReqBody;
import pb.unite.search.DynamicContentRecommend.RspBody;
import pb.unite.search.DynamicDiscovery.ReqBody;
import pb.unite.search.DynamicDiscovery.RspBody;
import pb.unite.search.DynamicSearch.ExtensionRequestInfo;
import pb.unite.search.DynamicSearch.RootSearcherRequest;
import pb.unite.search.DynamicTabSearch.ReqBody;
import pb.unite.search.DynamicTabSearch.RspBody;
import pb.unite.search.UniteSearch.ReqBody;
import pb.unite.search.UniteSearch.RspBody;
import pb.unite.search.UniteSearch.TabItemGroup;
import zma;

public class UniteSearchHandler
  extends BusinessHandler
{
  public static String a;
  public static long[] a;
  public static String b;
  public static long[] b;
  public static String c;
  public static long[] c;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 1001L, 1002L, 1003L, 1005L, 2073745984L, 1006L, 1007L };
    jdField_b_of_type_ArrayOfLong = new long[] { 1004L };
    jdField_c_of_type_ArrayOfLong = new long[] { 2073745984L, 1073745984L, 1001L, 1002L, 1003L, 1005L, 1006L, 1007L };
    jdField_a_of_type_JavaLangString = "hot_word_for_sub_business";
    jdField_b_of_type_JavaLangString = "hot_word_for_sub_business_req_time";
    jdField_c_of_type_JavaLangString = "hot_word_for_sub_business_exprire_time";
  }
  
  public UniteSearchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    FunctionModuleConfigManager.a.clear();
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
      FunctionModuleConfigManager.a.put(FunctionModuleConfigManager.a(localGroupID.a), localArrayList2);
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "code=" + paramInt + " fileName=" + paramString1 + " key=" + paramString2 + " data=" + paramObject);
    }
    if (paramInt == 1000)
    {
      ThreadManager.post(new zma(this, paramString1, paramObject), 5, null, true);
      BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit().putString(paramString2, System.currentTimeMillis() + "").commit();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "code is error，do not save the data, code=" + paramInt);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleTimeOut serviceCmd:" + paramFromServiceMsg);
    }
    if (("DynamicScDiscovery.1".equals(paramFromServiceMsg)) || ("kandian_search_hot_word.1".equals(paramFromServiceMsg))) {
      SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramToServiceMsg.extraData.getInt("fromType"), 5);
    }
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    a(paramString, paramLong1, paramLong2, "");
  }
  
  private void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    long l = System.currentTimeMillis();
    new ReportTask(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_search_engineer").c("search_net").d(paramString1).a(new String[] { paramLong2 + "", "" + (l - paramLong1), "" + paramString2, StoryReportor.a(null) }).a();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleError serviceCmd:" + paramFromServiceMsg);
    }
    if (("DynamicScDiscovery.1".equals(paramFromServiceMsg)) || ("kandian_search_hot_word.1".equals(paramFromServiceMsg))) {
      SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramToServiceMsg.extraData.getInt("fromType"), 5);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleCompletedUrlResult. resultCode=" + i);
    }
    String str = paramToServiceMsg.extraData.getString("keyword", "");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = "";
    if (i != 1000)
    {
      a(1006, false, paramToServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      a(1006, false, paramToServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      a(1006, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new DynamicAssociationWord.RspBody();
    for (;;)
    {
      Object localObject;
      DynamicAssociationWord.SuggestUrlItem localSuggestUrlItem;
      ArrayList localArrayList;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.result_code.get();
        paramObject = paramFromServiceMsg.error_msg.get();
        if ((i != 0) && (i != 1009)) {
          break;
        }
        localObject = paramFromServiceMsg.association_items.get();
        paramObject = paramFromServiceMsg.suggest_url_items.get();
        localSuggestUrlItem = (DynamicAssociationWord.SuggestUrlItem)paramFromServiceMsg.completed_url_items.get();
        localArrayList = new ArrayList();
        paramFromServiceMsg = new ArrayList();
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
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
          continue;
        }
        localObject = paramObject.iterator();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(1006, false, paramToServiceMsg);
        paramFromServiceMsg.printStackTrace();
        return;
      }
      while (((Iterator)localObject).hasNext()) {
        paramFromServiceMsg.add(((DynamicAssociationWord.SuggestUrlItem)((Iterator)localObject).next()).url.get().toStringUtf8());
      }
      paramFromServiceMsg = new Object[5];
      paramFromServiceMsg[0] = str;
      paramFromServiceMsg[1] = Integer.valueOf(i);
      paramFromServiceMsg[2] = localArrayList;
      paramFromServiceMsg[3] = paramObject;
      paramFromServiceMsg[4] = localSuggestUrlItem;
      paramToServiceMsg = paramFromServiceMsg;
      try
      {
        a(1006, true, paramFromServiceMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
    }
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = str;
    paramFromServiceMsg[1] = Integer.valueOf(i);
    paramFromServiceMsg[2] = paramObject;
    paramToServiceMsg = paramFromServiceMsg;
    a(1006, false, paramFromServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleCompletedUrlResult. resultCode=" + i);
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("keyword", "");
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = paramToServiceMsg;
    paramFromServiceMsg[1] = Integer.valueOf(-1);
    paramFromServiceMsg[2] = "";
    if (i != 1000)
    {
      a(1005, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      a(1005, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      a(1005, false, paramFromServiceMsg);
      return;
    }
    Object localObject = new DynamicAssociationWord.RspBody();
    try
    {
      ((DynamicAssociationWord.RspBody)localObject).mergeFrom((byte[])paramObject);
      i = ((DynamicAssociationWord.RspBody)localObject).result_code.get();
      str = ((DynamicAssociationWord.RspBody)localObject).error_msg.get();
      if ((i != 0) && (i != 1009)) {
        break label243;
      }
      localObject = (DynamicAssociationWord.SuggestUrlItem)((DynamicAssociationWord.RspBody)localObject).completed_url_items.get();
      paramObject = new Object[3];
      paramObject[0] = paramToServiceMsg;
      paramObject[1] = localObject;
      paramObject[2] = Integer.valueOf(i);
      paramToServiceMsg = paramObject;
      try
      {
        a(1005, true, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      String str;
      label229:
      break label229;
    }
    a(1005, false, paramFromServiceMsg);
    paramToServiceMsg.printStackTrace();
    return;
    label243:
    paramObject = new Object[3];
    paramObject[0] = paramToServiceMsg;
    paramObject[1] = Integer.valueOf(i);
    paramObject[2] = str;
    paramToServiceMsg = paramObject;
    a(1005, false, paramObject);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleUniteSearchResult. resultCode=" + i);
    }
    String str1 = paramToServiceMsg.extraData.getString("keyword", "");
    String str2 = paramToServiceMsg.extraData.getString("time", "");
    Object localObject2 = paramToServiceMsg.extraData.getLongArray("masks");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isFirstReq");
    paramFromServiceMsg = new Object[5];
    paramFromServiceMsg[0] = str1;
    paramFromServiceMsg[1] = Boolean.valueOf(bool2);
    paramFromServiceMsg[2] = str2;
    paramFromServiceMsg[3] = Integer.valueOf(-1);
    paramFromServiceMsg[4] = "";
    a("dynamic_unite_search.1", paramToServiceMsg.extraData.getLong("send_req_time"), i, str1);
    if (i != 1000)
    {
      a(1004, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      a(1004, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      a(1004, false, paramFromServiceMsg);
      return;
    }
    UniteSearch.RspBody localRspBody = new UniteSearch.RspBody();
    try
    {
      localRspBody.mergeFrom((byte[])paramObject);
      i = localRspBody.result_code.get();
      localObject1 = localRspBody.error_msg.get();
      if ((i != 0) && (i < 1000)) {
        break label533;
      }
      localObject1 = localRspBody.cookie_topic.get().toByteArray();
      if (localRspBody.search_ver.has()) {
        SearchUtils.a("dynamic_unite_search.1", (long[])localObject2, localRspBody.search_ver.get().toStringUtf8());
      }
      if (localRspBody.is_end_topic.get() != 1) {
        break label585;
      }
      bool1 = true;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        Object localObject1;
        continue;
        boolean bool1 = false;
      }
    }
    paramObject = localRspBody.tab_groups.get();
    localObject2 = new ArrayList(paramObject.size());
    i = 0;
    while (i < paramObject.size())
    {
      ((List)localObject2).add(new GroupTabModel((UniteSearch.TabItemGroup)paramObject.get(i)));
      i += 1;
    }
    i = localRspBody.trigger_netword_num.get();
    if (i >= 0) {
      SharedPreUtils.v(BaseApplicationImpl.getContext(), i);
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
    try
    {
      a(1004, true, paramObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
    }
    a(1004, false, paramFromServiceMsg);
    paramToServiceMsg.printStackTrace();
    return;
    label533:
    paramObject = new Object[5];
    paramObject[0] = str1;
    paramObject[1] = Boolean.valueOf(bool2);
    paramObject[2] = str2;
    paramObject[3] = Integer.valueOf(i);
    paramObject[4] = localObject1;
    paramToServiceMsg = paramObject;
    a(1004, false, paramObject);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleTabSearchResult. resultCode=" + i);
    }
    String str1 = paramToServiceMsg.extraData.getString("keyword", "");
    String str2 = paramToServiceMsg.extraData.getString("time", "");
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("masks");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("isFirstReq");
    paramFromServiceMsg = new Object[6];
    paramFromServiceMsg[0] = str1;
    paramFromServiceMsg[1] = Boolean.valueOf(bool3);
    paramFromServiceMsg[2] = str2;
    paramFromServiceMsg[3] = Integer.valueOf(-1);
    paramFromServiceMsg[4] = "";
    paramFromServiceMsg[5] = arrayOfLong;
    a("dynamic_tab_search.1", paramToServiceMsg.extraData.getLong("send_req_time"), i, str1);
    if (i != 1000)
    {
      a(1000, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      a(1000, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      a(1000, false, paramFromServiceMsg);
      return;
    }
    Object localObject1 = new DynamicTabSearch.RspBody();
    for (;;)
    {
      try
      {
        ((DynamicTabSearch.RspBody)localObject1).mergeFrom((byte[])paramObject);
        i = ((DynamicTabSearch.RspBody)localObject1).result_code.get();
        localObject2 = ((DynamicTabSearch.RspBody)localObject1).error_msg.get();
        if ((i != 0) && (i < 1000)) {
          continue;
        }
        localObject2 = ((DynamicTabSearch.RspBody)localObject1).cookie.get().toByteArray();
        if (((DynamicTabSearch.RspBody)localObject1).search_ver.has()) {
          SearchUtils.a("dynamic_tab_search.1", arrayOfLong, ((DynamicTabSearch.RspBody)localObject1).search_ver.get().toStringUtf8());
        }
        if (((DynamicTabSearch.RspBody)localObject1).is_end.get() != 1) {
          continue;
        }
        bool1 = true;
        paramObject = ((DynamicTabSearch.RspBody)localObject1).item_groups.get();
        paramToServiceMsg = new NetBaseParser().a(new Object[] { str1, paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) });
        String str3 = ((DynamicTabSearch.RspBody)localObject1).sub_hot_top_wording.get().toStringUtf8();
        if (((DynamicTabSearch.RspBody)localObject1).dont_need_merge.get() != 1) {
          continue;
        }
        bool2 = true;
        localObject1 = ((DynamicTabSearch.RspBody)localObject1).hot_words.get();
        paramObject = new Object[10];
        paramObject[0] = str1;
        paramObject[1] = Boolean.valueOf(bool3);
        paramObject[2] = str2;
        paramObject[3] = localObject2;
        paramObject[4] = Boolean.valueOf(bool1);
        paramObject[5] = paramToServiceMsg;
        paramObject[6] = arrayOfLong;
        paramObject[7] = str3;
        paramObject[8] = localObject1;
        paramObject[9] = Boolean.valueOf(bool2);
        paramToServiceMsg = paramObject;
        try
        {
          a(1000, true, paramObject);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        Object localObject2;
        boolean bool1;
        boolean bool2;
        continue;
      }
      a(1000, false, paramFromServiceMsg);
      paramToServiceMsg.printStackTrace();
      return;
      bool1 = false;
      continue;
      bool2 = false;
    }
    paramObject = new Object[6];
    paramObject[0] = str1;
    paramObject[1] = Boolean.valueOf(bool3);
    paramObject[2] = str2;
    paramObject[3] = Integer.valueOf(i);
    paramObject[4] = localObject2;
    paramObject[5] = arrayOfLong;
    paramToServiceMsg = paramObject;
    a(1000, false, paramObject);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleContentRecommendResult. resultCode=" + i);
    }
    if ((i != 1000) || (paramObject == null) || (!(paramObject instanceof byte[])))
    {
      a(1008, false, null);
      SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 5);
    }
    do
    {
      return;
      paramFromServiceMsg = new DynamicContentRecommend.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.result_code.get();
        paramObject = paramFromServiceMsg.error_msg.get().toStringUtf8();
        if (i != 0) {
          break;
        }
        i = paramFromServiceMsg.cache_time.get();
        paramToServiceMsg = SearchEntryDataModel.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg, paramToServiceMsg.extraData.getInt("fromType"));
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "response data: cacheTime:" + i + ",recommendResult :" + paramToServiceMsg.toString());
        }
        a(1008, true, new Object[] { paramToServiceMsg });
        SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(1008, false, null);
        SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 5);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "handleContentRecommendResult, InvalidProtocolBufferMicroException e= " + paramToServiceMsg);
    return;
    SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 5);
    a(1008, false, new Object[] { Integer.valueOf(i), paramObject });
  }
  
  protected Class a()
  {
    return UniteSearchObserver.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler", 2, " sendContentRecommendRequest.");
    }
    if (!SharedPreUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    DynamicContentRecommend.ReqBody localReqBody = new DynamicContentRecommend.ReqBody();
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    localReqBody.business.set(128);
    ToServiceMsg localToServiceMsg = a("DynamicScRecommend.1");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.extraData.putLong("send_req_time", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("fromType", paramInt);
    b(localToServiceMsg);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "sendKandianHotwordsReq. fromType = " + 6);
    }
    if (!SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), 6))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "sendKandianHotwordsReq. fromType = " + 6 + ", cache is not expired, return");
      }
      return;
    }
    paramQQAppInterface = new DynamicDiscovery.ReqBody();
    paramQQAppInterface.version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    paramQQAppInterface.business.set(128);
    paramQQAppInterface.from_type.set(6);
    ToServiceMsg localToServiceMsg = a("kandian_search_hot_word.1");
    localToServiceMsg.extraData.putInt("fromType", 6);
    localToServiceMsg.putWupBuffer(paramQQAppInterface.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "getUniteSearchDiscovery. fromType = " + paramInt);
    }
    if (!SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "getUniteSearchDiscovery. fromType = " + paramInt + ", cache is not expired, return");
      }
      return;
    }
    paramQQAppInterface = new DynamicDiscovery.ReqBody();
    paramQQAppInterface.version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    paramQQAppInterface.business.set(128);
    paramQQAppInterface.from_type.set(paramInt);
    ToServiceMsg localToServiceMsg = a("DynamicScDiscovery.1");
    localToServiceMsg.extraData.putInt("fromType", paramInt);
    localToServiceMsg.putWupBuffer(paramQQAppInterface.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleBusiHotWord. resultCode=" + paramInt);
    }
    if (paramToServiceMsg != null) {
      a("dynamic_busi_hot_word.1", paramToServiceMsg.extraData.getLong("send_req_time"), paramInt);
    }
    if (paramInt != 1000) {
      a(1002, false, null);
    }
    for (;;)
    {
      return;
      if (paramObject == null)
      {
        a(1002, false, null);
        return;
      }
      if (!(paramObject instanceof byte[]))
      {
        a(1002, false, null);
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
          a(1002, true, new Object[] { Integer.valueOf(paramInt), a(paramToServiceMsg) });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "response data: expireTime:" + paramInt + ",resultItemList :" + paramToServiceMsg.toString());
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(1002, false, null);
        paramToServiceMsg.printStackTrace();
        return;
      }
    }
    a(1002, false, new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq: ").append(paramToServiceMsg.getRequestSsoSeq()).append(", serviceCmd: ").append(str).append(", resultCode: ").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, localStringBuilder.toString());
    }
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "cmd filter error=" + str);
      }
    }
    label213:
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() == 1002) {
        a(paramToServiceMsg, paramFromServiceMsg);
      }
      int i;
      for (;;)
      {
        if (!"dynamic_association_word.1".equals(str)) {
          break label213;
        }
        i = paramToServiceMsg.extraData.getInt("needFlag", 0);
        if ((i & 0x4) != 0) {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        if (((i & 0x2) == 0) && ((i & 0x1) == 0)) {
          break;
        }
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if (paramFromServiceMsg.getResultCode() != 1000) {
          b(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      if ("dynamic_unite_search.1".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("dynamic_tab_search.1".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("dynamic_busi_hot_word.1".equals(str))
      {
        i = paramFromServiceMsg.getResultCode();
        a(i, paramObject, jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString);
        a(paramToServiceMsg, i, paramObject);
        return;
      }
      if ("DynamicScDiscovery.1".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg.getResultCode(), paramObject);
        return;
      }
      if ("DynamicScRecommend.1".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"kandian_search_hot_word.1".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg.getResultCode(), paramObject);
  }
  
  public void a(String paramString)
  {
    a(paramString, 1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "sendAssociationWordRequest. keyword=" + paramString);
    }
    DynamicAssociationWord.ReqBody localReqBody = new DynamicAssociationWord.ReqBody();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler", 2, "sendAssociationWordRequest. keyword is empty.");
      return;
    }
    localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    localReqBody.business.set(128);
    localReqBody.need_flag.set(paramInt);
    ToServiceMsg localToServiceMsg = a("dynamic_association_word.1");
    localToServiceMsg.extraData.putString("keyword", paramString);
    localToServiceMsg.extraData.putLong("send_req_time", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("needFlag", paramInt);
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List paramList1, List paramList2, int paramInt2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt1, paramList1, paramList2, paramInt2, paramArrayOfByte, paramDouble1, paramDouble2, paramBoolean, false, paramInt3, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List paramList1, List paramList2, int paramInt2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "send uniteSearch keyword = [" + paramString1 + "], time = [" + paramString2 + "], count = [" + paramInt1 + "], businessMaskArray = [" + paramList1 + "], fromAction = [" + paramInt2 + "], cookie = [" + paramArrayOfByte + "], latitude = [" + paramDouble1 + "], longitude = [" + paramDouble2 + "], isMoreSearch = [" + paramBoolean1 + "], hasLocalData = [" + paramBoolean2 + "]");
    }
    UniteSearch.ReqBody localReqBody = new UniteSearch.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler", 2, "send uniteSearch. keyword is empty.");
      return;
    }
    if (paramInt2 == 6) {
      paramInt2 = 1;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 > 0) {
        i = paramInt2 - 1;
      }
      localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
      localReqBody.version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
      if (paramBoolean2) {
        localReqBody.client_has_people_and_qun.set(1);
      }
      String[] arrayOfString;
      if (paramInt3 == 1)
      {
        localReqBody.from_tabbar_index.set(0);
        if (!paramBoolean1)
        {
          localObject = new DynamicSearch.RootSearcherRequest();
          ((DynamicSearch.RootSearcherRequest)localObject).business.set(128);
          ((DynamicSearch.RootSearcherRequest)localObject).rpt_busi_mask.set(SearchUtils.a(jdField_a_of_type_ArrayOfLong));
          localReqBody.req_entity.set((MessageMicro)localObject);
        }
        Object localObject = new DynamicSearch.RootSearcherRequest();
        ((DynamicSearch.RootSearcherRequest)localObject).business.set(128);
        ((DynamicSearch.RootSearcherRequest)localObject).page_size.set(paramInt1);
        ((DynamicSearch.RootSearcherRequest)localObject).rpt_busi_mask.set(paramList1);
        if (paramArrayOfByte != null) {
          ((DynamicSearch.RootSearcherRequest)localObject).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        }
        localReqBody.req_topic.set((MessageMicro)localObject);
        localReqBody.from_action.set(i);
        localObject = new DynamicSearch.ExtensionRequestInfo();
        i = 2;
        arrayOfString = SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((arrayOfString != null) && (arrayOfString.length != 0)) {
          break label748;
        }
        paramInt1 = 0;
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "key_word_src=" + paramInt1);
        }
        if (paramBundle != null)
        {
          paramInt2 = paramBundle.getInt("matchCount", 0);
          i = paramBundle.getInt("source", 0);
          localReqBody.locate_result_count.set(paramInt2);
          localReqBody.source.set(i);
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "matchCount=" + paramInt2 + " source=" + i);
          }
        }
        ((DynamicSearch.ExtensionRequestInfo)localObject).key_word_src.set(paramInt1);
        ((DynamicSearch.ExtensionRequestInfo)localObject).latitude.set((float)paramDouble1);
        ((DynamicSearch.ExtensionRequestInfo)localObject).longitude.set((float)paramDouble2);
        if (paramList2 != null) {
          ((DynamicSearch.ExtensionRequestInfo)localObject).rpt_pubacc_local_result.set(paramList2);
        }
        localReqBody.extension_request_info.set((MessageMicro)localObject);
        paramList2 = a("dynamic_unite_search.1");
        paramList2.extraData.putInt("fromType", paramInt3);
        paramList2.extraData.putString("keyword", paramString1);
        paramList2.extraData.putString("time", paramString2);
        paramList2.extraData.putLongArray("masks", SearchUtil.a(paramList1));
        paramString1 = paramList2.extraData;
        if (paramArrayOfByte != null) {
          break label792;
        }
      }
      label792:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        paramString1.putBoolean("isFirstReq", paramBoolean1);
        paramList2.extraData.putLong("send_req_time", System.currentTimeMillis());
        paramList2.putWupBuffer(localReqBody.toByteArray());
        b(paramList2);
        return;
        if (paramInt3 == 2)
        {
          localReqBody.from_tabbar_index.set(1);
          break;
        }
        if (paramInt3 == 21)
        {
          localReqBody.from_tabbar_index.set(2);
          break;
        }
        localReqBody.from_tabbar_index.set(0);
        break;
        label748:
        int j = arrayOfString.length;
        paramInt2 = 0;
        for (;;)
        {
          paramInt1 = i;
          if (paramInt2 >= j) {
            break;
          }
          if (arrayOfString[paramInt2].equals(paramString1))
          {
            paramInt1 = 1;
            break;
          }
          paramInt2 += 1;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, List paramList1, List paramList2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt, paramList1, paramList2, paramArrayOfByte, 0, paramDouble1, paramDouble2, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List paramList1, List paramList2, byte[] paramArrayOfByte, int paramInt2, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "send tabSearch keyword = [" + paramString1 + "], reqTime = [" + paramString2 + "], count = [" + paramInt1 + "], businessMaskArray = [" + paramList1 + "], cookie = [" + paramArrayOfByte + "], latitude = [" + paramDouble1 + "], longitude = [" + paramDouble2 + "]");
    }
    DynamicTabSearch.ReqBody localReqBody = new DynamicTabSearch.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler", 2, "send tabSearch. keyword is empty.");
      return;
    }
    localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    Object localObject = new DynamicSearch.RootSearcherRequest();
    ((DynamicSearch.RootSearcherRequest)localObject).business.set(128);
    ((DynamicSearch.RootSearcherRequest)localObject).page_size.set(paramInt1);
    ((DynamicSearch.RootSearcherRequest)localObject).rpt_busi_mask.set(paramList1);
    if (paramArrayOfByte != null) {
      ((DynamicSearch.RootSearcherRequest)localObject).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localReqBody.search_request.set((MessageMicro)localObject);
    localObject = new DynamicSearch.ExtensionRequestInfo();
    ((DynamicSearch.ExtensionRequestInfo)localObject).latitude.set((float)paramDouble1);
    ((DynamicSearch.ExtensionRequestInfo)localObject).longitude.set((float)paramDouble2);
    int i;
    if (FunctionModuleConfigManager.a.isEmpty()) {
      i = 0;
    }
    boolean bool;
    Iterator localIterator1;
    label526:
    do
    {
      ((DynamicSearch.ExtensionRequestInfo)localObject).key_word_src.set(i);
      if (paramList2 != null) {
        ((DynamicSearch.ExtensionRequestInfo)localObject).rpt_pubacc_local_result.set(paramList2);
      }
      localReqBody.extension_request_info.set((MessageMicro)localObject);
      if (paramInt2 != 0) {
        localReqBody.from_sub_hot_word_id.set(paramInt2, true);
      }
      paramList2 = a("dynamic_tab_search.1");
      paramList2.extraData.putString("keyword", paramString1);
      paramList2.extraData.putString("time", paramString2);
      paramList2.extraData.putLongArray("masks", SearchUtil.a(paramList1));
      paramString2 = paramList2.extraData;
      if (paramArrayOfByte != null) {
        break;
      }
      bool = true;
      paramString2.putBoolean("isFirstReq", bool);
      paramList2.extraData.putLong("send_req_time", System.currentTimeMillis());
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("isLoadMore", false);
        paramInt1 = paramBundle.getInt("fromTypeForReport", 0);
        if (!bool) {
          SearchUtils.a("sub_result", "active_search", new String[] { paramString1, SearchUtils.a(paramList1), "" + paramInt1, "" });
        }
        paramList2.extraData.putAll(paramBundle);
      }
      paramList2.putWupBuffer(localReqBody.toByteArray());
      b(paramList2);
      return;
      localIterator1 = FunctionModuleConfigManager.a.values().iterator();
      paramInt1 = 2;
      i = paramInt1;
    } while (!localIterator1.hasNext());
    Iterator localIterator2 = ((List)localIterator1.next()).iterator();
    while (localIterator2.hasNext()) {
      if (paramString1.equals((BusinessGroupWord.HotWordItem)localIterator2.next())) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      break label526;
      bool = false;
      break;
    }
  }
  
  public byte[] a(String paramString)
  {
    return FileUtils.a(BaseApplication.getContext().getFileStreamPath(paramString));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler", 2, "sendBusiHotWordRequest. ");
    }
    DynamicBusinessHotWord.ReqBody localReqBody = new DynamicBusinessHotWord.ReqBody();
    localReqBody.business.set(128);
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    ToServiceMsg localToServiceMsg = a("dynamic_busi_hot_word.1");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    b(localToServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleUniteSearchDiscovery. resultCode=" + paramInt + ", fromType = " + i);
    }
    if ((paramInt != 1000) || (paramObject == null) || (!(paramObject instanceof byte[])))
    {
      a(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
      SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, 5);
      return;
    }
    DynamicDiscovery.RspBody localRspBody = new DynamicDiscovery.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        paramInt = localRspBody.result_code.get();
        if (localRspBody.error_msg.get() == null) {
          break label373;
        }
        paramToServiceMsg = localRspBody.error_msg.get().toStringUtf8();
        if (paramInt != 0) {
          break label378;
        }
        paramInt = localRspBody.expire_time.get();
        paramToServiceMsg = localRspBody.result_items.get();
        paramToServiceMsg = SearchEntryDataModel.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "response data: expireTime:" + paramInt + ",modelList :" + paramToServiceMsg.toString());
        }
        a(1007, true, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
        SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, localRspBody.expire_time.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
        SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, 5);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.uniteSearch.UniteSearchHandler", 2, "handleUniteSearchDiscovery, InvalidProtocolBufferMicroException e = " + paramToServiceMsg);
      return;
      label373:
      paramToServiceMsg = null;
    }
    label378:
    SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, 5);
    a(1007, false, new Object[] { Integer.valueOf(paramInt), paramToServiceMsg, Integer.valueOf(i) });
  }
  
  public void c(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "<<---handleKandianHotwordsReq. resultCode=" + paramInt + ", fromType = " + i);
    }
    if ((paramInt != 1000) || (paramObject == null) || (!(paramObject instanceof byte[])))
    {
      a(1009, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
      SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, 5);
      return;
    }
    DynamicDiscovery.RspBody localRspBody = new DynamicDiscovery.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        paramInt = localRspBody.result_code.get();
        if (localRspBody.error_msg.get() == null) {
          break label373;
        }
        paramToServiceMsg = localRspBody.error_msg.get().toStringUtf8();
        if (paramInt != 0) {
          break label378;
        }
        paramInt = localRspBody.expire_time.get();
        paramToServiceMsg = localRspBody.result_items.get();
        paramToServiceMsg = SearchEntryDataModel.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchHandler", 2, "response data: expireTime:" + paramInt + ",modelList :" + paramToServiceMsg.toString());
        }
        a(1009, true, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
        SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, localRspBody.expire_time.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(1009, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
        SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, 5);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.uniteSearch.UniteSearchHandler", 2, "handleUniteSearchDiscovery, InvalidProtocolBufferMicroException e = " + paramToServiceMsg);
      return;
      label373:
      paramToServiceMsg = null;
    }
    label378:
    SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, 5);
    a(1009, false, new Object[] { Integer.valueOf(paramInt), paramToServiceMsg, Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniteSearchHandler
 * JD-Core Version:    0.7.0.1
 */