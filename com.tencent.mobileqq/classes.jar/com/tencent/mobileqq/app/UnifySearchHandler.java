package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.BusinessGroupWord.ClueWordItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord.GroupID;
import com.tencent.mobileqq.search.model.BusinessGroupWord.HotWordItem;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModelRichNode;
import com.tencent.mobileqq.search.model.GroupTabModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateAvatarsItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBannerTitleItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBigImageItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateFriendUpdatesItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateQAItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUpdatesItem;
import com.tencent.mobileqq.search.model.RichSearchModelNode;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.net.parser.TabNetBaseParser;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchAssociationWord.AssociationItem;
import pb.unify.search.UnifySearchAssociationWord.RspBody;
import pb.unify.search.UnifySearchAssociationWord.SuggestUrlItem;
import pb.unify.search.UnifySearchBusiHotWord.ClueWordItem;
import pb.unify.search.UnifySearchBusiHotWord.GroupID;
import pb.unify.search.UnifySearchBusiHotWord.GroupWord;
import pb.unify.search.UnifySearchBusiHotWord.HotWordItem;
import pb.unify.search.UnifySearchBusiHotWord.ReqBody;
import pb.unify.search.UnifySearchBusiHotWord.RspBody;
import pb.unify.search.UnifySearchCommon.ExtensionRequestInfo;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unify.search.UnifySearchCommon.ResultItemGroup;
import pb.unify.search.UnifySearchCommon.RootSearcherRequest;
import pb.unify.search.UnifySearchDiscovery.ReqBody;
import pb.unify.search.UnifySearchDiscovery.RspBody;
import pb.unify.search.UnifySearchUnite.ReqBody;
import pb.unify.search.UnifySearchUnite.RspBody;
import pb.unify.search.UnifySearchUnite.TabItemGroup;
import pb.unify.search.UnifyTabSearch.ReqBody;
import pb.unify.search.UnifyTabSearch.RspBody;

public class UnifySearchHandler
  extends BusinessHandler
{
  public static String a;
  public static long[] a;
  public static String b;
  public static long[] b;
  public static String c;
  public static long[] c;
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 1001L, 1002L, 1003L, 1005L, 2073745984L, 1006L, 1007L };
    jdField_b_of_type_ArrayOfLong = new long[] { 1004L };
    jdField_c_of_type_ArrayOfLong = new long[] { 2073745984L, 1073745984L, 1001L, 1002L, 1003L, 1005L, 1006L };
    jdField_a_of_type_JavaLangString = "hot_word_for_sub_business_unify";
    jdField_b_of_type_JavaLangString = "hot_word_for_sub_business_req_time_unify";
    jdField_c_of_type_JavaLangString = "hot_word_for_sub_business_exprire_time_unify";
  }
  
  public UnifySearchHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    }
  }
  
  public UnifySearchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private NetSearchTemplateBaseItem a(int paramInt1, String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    case 10: 
    default: 
      return null;
    case 2: 
      return new NetSearchTemplateAvatarsItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 3: 
      return new NetSearchTemplateUpdatesItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 4: 
      return new NetSearchTemplateBannerTitleItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 7: 
      return new NetSearchTemplateHorizontalContainerItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 6: 
      return new NetSearchTemplateUniversalItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 8: 
      return new NetSearchTemplateSubItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 9: 
      return new NetSearchTemplateSubItemTitle(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 11: 
      return new NetSearchTemplateFriendUpdatesItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 12: 
      return new NetSearchTemplateBigImageItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 13: 
      return new NetSearchTemplateHorSlidingContainerItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 14: 
      return new NetSearchTemplateTitleItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 15: 
      return new NetSearchTemplateQAItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 16: 
      return new NetSearchTemplateNetSeaEntranceItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 17: 
      return new NetSearchTemplateNewEntranceItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    }
    return new NetSearchTemplateMiniAppItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("fromType", -1) == 99))
    {
      localObject2 = null;
      if (paramString != null) {}
      try
      {
        localObject1 = new JSONObject(paramString);
        localObject2 = localObject1;
        ((JSONObject)localObject1).put("scenario", "related_people_and_groups_panel");
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "getMergedJsonData JSONException", localJSONException);
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((JSONObject)localObject1).toString();; localObject1 = paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "getMergedJsonData finalJsonData = " + (String)localObject1 + ",inputJson = " + paramString + ",extraData = " + paramBundle);
      }
      return localObject1;
      localObject1 = new JSONObject();
      break;
    }
  }
  
  private List<BusinessGroupWord> a(List<UnifySearchBusiHotWord.GroupWord> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    FunctionModuleConfigManager.a.clear();
    FunctionModuleConfigManager.b.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (UnifySearchBusiHotWord.GroupWord)localIterator.next();
      ArrayList localArrayList2 = new ArrayList(paramList.size());
      BusinessGroupWord.GroupID localGroupID = new BusinessGroupWord.GroupID(((UnifySearchBusiHotWord.GroupID)((UnifySearchBusiHotWord.GroupWord)localObject1).group_id.get()).rpt_group_mask.get());
      Object localObject2 = ((UnifySearchBusiHotWord.GroupWord)localObject1).rpt_hot_word_items.get();
      new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        UnifySearchBusiHotWord.HotWordItem localHotWordItem = (UnifySearchBusiHotWord.HotWordItem)((Iterator)localObject2).next();
        localArrayList2.add(new BusinessGroupWord.HotWordItem(localHotWordItem.word_id.get().toStringUtf8(), localHotWordItem.word.get().toStringUtf8()));
      }
      FunctionModuleConfigManager.a.put(FunctionModuleConfigManager.a(localGroupID.a), localArrayList2);
      localObject2 = (UnifySearchBusiHotWord.ClueWordItem)((UnifySearchBusiHotWord.GroupWord)localObject1).clue_word_item.get();
      localObject1 = ((UnifySearchBusiHotWord.ClueWordItem)localObject2).word_id.get().toStringUtf8();
      localObject2 = ((UnifySearchBusiHotWord.ClueWordItem)localObject2).word.get().toStringUtf8();
      localObject1 = new BusinessGroupWord.ClueWordItem((String)localObject1, (String)localObject2);
      FunctionModuleConfigManager.b.put(FunctionModuleConfigManager.a(localGroupID.a), localObject2);
      localArrayList1.add(new BusinessGroupWord(localGroupID, localArrayList2, (BusinessGroupWord.ClueWordItem)localObject1));
    }
    return localArrayList1;
  }
  
  private void a(int paramInt, Object paramObject, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "code=" + paramInt + " fileName=" + paramString1 + " key=" + paramString2 + " data=" + paramObject);
    }
    if (paramInt == 1000)
    {
      ThreadManager.post(new UnifySearchHandler.1(this, paramString1, paramObject), 5, null, true);
      BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit().putString(paramString2, System.currentTimeMillis() + "").commit();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "code is error，do not save the data, code=" + paramInt);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleTimeOut serviceCmd:" + paramToServiceMsg);
    }
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    a(paramString, paramLong1, paramLong2, "");
  }
  
  private boolean a(long paramLong)
  {
    return (paramLong != 1100L) && (paramLong != 1101L) && (paramLong != 1701L);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleError serviceCmd:" + paramToServiceMsg);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleCompletedUrlResult. resultCode=" + i);
    }
    String str = paramToServiceMsg.extraData.getString("keyword", "");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = "";
    if (i != 1000)
    {
      notifyUI(1006, false, paramToServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1006, false, paramToServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1006, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new UnifySearchAssociationWord.RspBody();
    for (;;)
    {
      Object localObject;
      UnifySearchAssociationWord.SuggestUrlItem localSuggestUrlItem;
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
        localSuggestUrlItem = (UnifySearchAssociationWord.SuggestUrlItem)paramFromServiceMsg.completed_url_item.get();
        localArrayList = new ArrayList();
        paramFromServiceMsg = new ArrayList();
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          UnifySearchAssociationWord.AssociationItem localAssociationItem = (UnifySearchAssociationWord.AssociationItem)((Iterator)localObject).next();
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.jdField_a_of_type_JavaLangString = localAssociationItem.word.get().toStringUtf8();
          localAssociateItem.jdField_b_of_type_JavaLangString = localAssociationItem.sub_word.get().toStringUtf8();
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
        notifyUI(1006, false, paramToServiceMsg);
        paramFromServiceMsg.printStackTrace();
        return;
      }
      while (((Iterator)localObject).hasNext()) {
        paramFromServiceMsg.add(((UnifySearchAssociationWord.SuggestUrlItem)((Iterator)localObject).next()).url.get().toStringUtf8());
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
        notifyUI(1006, true, paramFromServiceMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
    }
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = str;
    paramFromServiceMsg[1] = Integer.valueOf(i);
    paramFromServiceMsg[2] = paramObject;
    paramToServiceMsg = paramFromServiceMsg;
    notifyUI(1006, false, paramFromServiceMsg);
  }
  
  private boolean b(long paramLong)
  {
    return (StudyModeManager.a()) && ((paramLong == 1100L) || (paramLong == 1012L) || (paramLong == 1003L));
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleCompletedUrlResult. resultCode=" + i);
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("keyword", "");
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = paramToServiceMsg;
    paramFromServiceMsg[1] = Integer.valueOf(-1);
    paramFromServiceMsg[2] = "";
    if (i != 1000)
    {
      notifyUI(1005, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1005, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1005, false, paramFromServiceMsg);
      return;
    }
    Object localObject = new UnifySearchAssociationWord.RspBody();
    try
    {
      ((UnifySearchAssociationWord.RspBody)localObject).mergeFrom((byte[])paramObject);
      i = ((UnifySearchAssociationWord.RspBody)localObject).result_code.get();
      str = ((UnifySearchAssociationWord.RspBody)localObject).error_msg.get();
      if ((i != 0) && (i != 1009)) {
        break label245;
      }
      localObject = (UnifySearchAssociationWord.SuggestUrlItem)((UnifySearchAssociationWord.RspBody)localObject).completed_url_item.get();
      paramObject = new Object[3];
      paramObject[0] = paramToServiceMsg;
      paramObject[1] = localObject;
      paramObject[2] = Integer.valueOf(i);
      paramToServiceMsg = paramObject;
      try
      {
        notifyUI(1005, true, paramObject);
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
      label231:
      break label231;
    }
    notifyUI(1005, false, paramFromServiceMsg);
    paramToServiceMsg.printStackTrace();
    return;
    label245:
    paramObject = new Object[3];
    paramObject[0] = paramToServiceMsg;
    paramObject[1] = Integer.valueOf(i);
    paramObject[2] = str;
    paramToServiceMsg = paramObject;
    notifyUI(1005, false, paramObject);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleUnifySearchUniteResult. resultCode=" + i);
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
    a("UnifySearch.Unite", paramToServiceMsg.extraData.getLong("send_req_time"), i, str1);
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
    UnifySearchUnite.RspBody localRspBody = new UnifySearchUnite.RspBody();
    try
    {
      localRspBody.mergeFrom((byte[])paramObject);
      i = localRspBody.result_code.get();
      localObject1 = localRspBody.error_msg.get();
      if ((i != 0) && (i < 1000)) {
        break label603;
      }
      localObject1 = localRspBody.cookie_topic.get().toByteArray();
      if (localRspBody.search_ver.has()) {
        SearchUtils.a("UnifySearch.Unite", (long[])localObject2, localRspBody.search_ver.get().toStringUtf8());
      }
      if (localRspBody.is_end_topic.get() != 1) {
        break label655;
      }
      bool1 = true;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        Object localObject1;
        label603:
        continue;
        boolean bool1 = false;
      }
    }
    paramObject = localRspBody.tab_groups.get();
    localObject2 = new ArrayList(paramObject.size());
    i = 0;
    while (i < paramObject.size())
    {
      ((List)localObject2).add(new GroupTabModel((UnifySearchUnite.TabItemGroup)paramObject.get(i)));
      i += 1;
    }
    i = localRspBody.trigger_netword_num.get();
    if (i >= 0) {
      SharedPreUtils.s(BaseApplicationImpl.getContext(), i);
    }
    paramObject = localRspBody.item_groups.get();
    if (StudyModeManager.a()) {}
    for (paramToServiceMsg = new ArrayList(0);; paramToServiceMsg = a(new Object[] { str1, paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) }))
    {
      i = localRspBody.exhibition_flags.get();
      paramObject = new Object[8];
      paramObject[0] = str1;
      paramObject[1] = Boolean.valueOf(bool2);
      paramObject[2] = str2;
      paramObject[3] = localObject1;
      paramObject[4] = Boolean.valueOf(bool1);
      paramObject[5] = localObject2;
      paramObject[6] = paramToServiceMsg;
      paramObject[7] = Integer.valueOf(i);
      paramToServiceMsg = paramObject;
      try
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = paramObject;
          QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "handleUnifySearchUniteResult subId = " + i);
        }
        paramToServiceMsg = paramObject;
        notifyUI(1004, true, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
      }
      notifyUI(1004, false, paramFromServiceMsg);
      paramToServiceMsg.printStackTrace();
      return;
    }
    paramObject = new Object[5];
    paramObject[0] = str1;
    paramObject[1] = Boolean.valueOf(bool2);
    paramObject[2] = str2;
    paramObject[3] = Integer.valueOf(i);
    paramObject[4] = localObject1;
    paramToServiceMsg = paramObject;
    notifyUI(1004, false, paramObject);
  }
  
  public List<ISearchResultGroupModel> a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 3))
    {
      paramVarArgs = null;
      return paramVarArgs;
    }
    String str = "";
    if ((paramVarArgs[0] instanceof String)) {
      str = (String)paramVarArgs[0];
    }
    Object localObject;
    label53:
    int i;
    boolean bool2;
    if ((paramVarArgs[1] instanceof List))
    {
      localObject = (List)paramVarArgs[1];
      i = -1;
      if ((paramVarArgs[2] instanceof Integer)) {
        i = ((Integer)paramVarArgs[2]).intValue();
      }
      bool2 = SearchUtils.c(i);
      if (!bool2) {
        break label202;
      }
    }
    label202:
    for (boolean bool1 = SearchConfigUtils.b(i);; bool1 = true)
    {
      ArrayList localArrayList = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramVarArgs = localArrayList;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramVarArgs = (UnifySearchCommon.ResultItemGroup)((Iterator)localObject).next();
        long l = paramVarArgs.group_mask.get();
        if (((!bool2) || (!a(l)) || (bool1)) && (!b(l))) {
          a(paramVarArgs, l, str, i, localArrayList);
        }
      }
      localObject = new ArrayList();
      break label53;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "sendBusiHotWordRequest. ");
    }
    UnifySearchBusiHotWord.ReqBody localReqBody = new UnifySearchBusiHotWord.ReqBody();
    localReqBody.business.set(128);
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
    ToServiceMsg localToServiceMsg = createToServiceMsg("UnifySearch.BusiHotWord");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "getUniteSearchDiscovery. fromType = " + paramInt);
    }
    if (!SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin(), paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "getUniteSearchDiscovery. fromType = " + paramInt + ", cache is not expired, return");
      }
      return;
    }
    UnifySearchDiscovery.ReqBody localReqBody = new UnifySearchDiscovery.ReqBody();
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
    localReqBody.business.set(128);
    localReqBody.from_type.set(paramInt);
    paramQQAppInterface = createToServiceMsg("UnifySearch.Discovery");
    paramQQAppInterface.extraData.putInt("fromType", paramInt);
    try
    {
      paramQQAppInterface.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(paramQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, "getUniteSearchDiscovery fromType:" + paramInt + ", error:" + localException.toString());
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleBusiHotWord. resultCode=" + paramInt);
    }
    if (paramToServiceMsg != null) {
      a("UnifySearch.BusiHotWord", paramToServiceMsg.extraData.getLong("send_req_time"), paramInt);
    }
    if (paramInt != 1000) {
      notifyUI(1002, false, null);
    }
    for (;;)
    {
      return;
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
      paramToServiceMsg = new UnifySearchBusiHotWord.RspBody();
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
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "response data: expireTime:" + paramInt + ",resultItemList :" + paramToServiceMsg.toString());
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(1002, false, null);
        paramToServiceMsg.printStackTrace();
        return;
      }
    }
    notifyUI(1002, false, new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleTabSearchWrapResult. resultCode=" + i);
    }
    String str1 = paramToServiceMsg.extraData.getString("keyword", "");
    String str2 = paramToServiceMsg.extraData.getString("time", "");
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("masks");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("isFirstReq");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isLoadMore", false);
    paramFromServiceMsg = new Object[6];
    paramFromServiceMsg[0] = str1;
    paramFromServiceMsg[1] = Boolean.valueOf(bool3);
    paramFromServiceMsg[2] = str2;
    paramFromServiceMsg[3] = Integer.valueOf(-1);
    paramFromServiceMsg[4] = "";
    paramFromServiceMsg[5] = arrayOfLong;
    a("UnifySearch.Tab", paramToServiceMsg.extraData.getLong("send_req_time"), i, str1);
    if (i != 1000)
    {
      notifyUI(1000, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1000, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1000, false, paramFromServiceMsg);
      return;
    }
    UnifyTabSearch.RspBody localRspBody = new UnifyTabSearch.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        i = localRspBody.result_code.get();
        localObject1 = localRspBody.error_msg.get();
        if ((i != 0) && (i < 1000)) {
          continue;
        }
        localObject1 = localRspBody.cookie.get().toByteArray();
        if (localRspBody.search_ver.has()) {
          SearchUtils.a("UnifySearch.Tab", arrayOfLong, localRspBody.search_ver.get().toStringUtf8());
        }
        if (localRspBody.is_end.get() != 1) {
          continue;
        }
        bool1 = true;
        paramObject = localRspBody.item_groups.get();
        Object localObject2 = new TabNetBaseParser();
        if (bool2) {
          ((TabNetBaseParser)localObject2).a(true);
        }
        paramToServiceMsg = ((TabNetBaseParser)localObject2).a(new Object[] { str1, paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) });
        localObject2 = localRspBody.sub_hot_top_wording.get().toStringUtf8();
        if (localRspBody.dont_need_merge.get() != 1) {
          continue;
        }
        bool2 = true;
        List localList = localRspBody.hot_words.get();
        String str3 = localRspBody.extension.get().toStringUtf8();
        i = localRspBody.exhibition_flags.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "handleTabSearchWrapResult subId = " + i);
        }
        paramObject = new Object[12];
        paramObject[0] = str1;
        paramObject[1] = Boolean.valueOf(bool3);
        paramObject[2] = str2;
        paramObject[3] = localObject1;
        paramObject[4] = Boolean.valueOf(bool1);
        paramObject[5] = paramToServiceMsg;
        paramObject[6] = arrayOfLong;
        paramObject[7] = localObject2;
        paramObject[8] = localList;
        paramObject[9] = Boolean.valueOf(bool2);
        paramObject[10] = str3;
        paramObject[11] = Integer.valueOf(i);
        paramToServiceMsg = paramObject;
        try
        {
          notifyUI(1000, true, paramObject);
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
        Object localObject1;
        boolean bool1;
        continue;
      }
      notifyUI(1000, false, paramFromServiceMsg);
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
    paramObject[4] = localObject1;
    paramObject[5] = arrayOfLong;
    paramToServiceMsg = paramObject;
    notifyUI(1000, false, paramObject);
  }
  
  public void a(String paramString)
  {
    a(paramString, 1);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    long l = System.currentTimeMillis();
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_search_engineer").c("search_net").d(paramString1).a(new String[] { paramLong2 + "", "" + (l - paramLong1), "" + paramString2, StoryReportor.a(null) }).a();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, int paramInt2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt1, paramList1, paramList2, paramInt2, paramArrayOfByte, paramDouble1, paramDouble2, paramBoolean, false, paramInt3, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, int paramInt2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "send uniteSearch keyword = [" + paramString1 + "], time = [" + paramString2 + "], count = [" + paramInt1 + "], businessMaskArray = [" + paramList1 + "], fromAction = [" + paramInt2 + "], cookie = [" + paramArrayOfByte + "], latitude = [" + paramDouble1 + "], longitude = [" + paramDouble2 + "], isMoreSearch = [" + paramBoolean1 + "], hasLocalData = [" + paramBoolean2 + "]");
    }
    UnifySearchUnite.ReqBody localReqBody = new UnifySearchUnite.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "send uniteSearch. keyword is empty.");
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
      localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
      if (paramBoolean2) {
        localReqBody.client_has_people_and_qun.set(1);
      }
      Object localObject1;
      Object localObject2;
      if (paramInt3 == 1)
      {
        localReqBody.from_tabbar_index.set(0);
        if (!paramBoolean1)
        {
          localObject1 = new UnifySearchCommon.RootSearcherRequest();
          ((UnifySearchCommon.RootSearcherRequest)localObject1).business.set(128);
          ((UnifySearchCommon.RootSearcherRequest)localObject1).rpt_busi_mask.set(SearchUtils.a(jdField_a_of_type_ArrayOfLong));
          localReqBody.req_entity.set((MessageMicro)localObject1);
        }
        localObject1 = new UnifySearchCommon.RootSearcherRequest();
        ((UnifySearchCommon.RootSearcherRequest)localObject1).business.set(128);
        ((UnifySearchCommon.RootSearcherRequest)localObject1).page_size.set(paramInt1);
        ((UnifySearchCommon.RootSearcherRequest)localObject1).rpt_busi_mask.set(paramList1);
        if (paramArrayOfByte != null) {
          ((UnifySearchCommon.RootSearcherRequest)localObject1).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        }
        localReqBody.req_topic.set((MessageMicro)localObject1);
        localReqBody.from_action.set(i);
        localObject1 = new UnifySearchCommon.ExtensionRequestInfo();
        i = 2;
        localObject2 = SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((localObject2 != null) && (localObject2.length != 0)) {
          break label896;
        }
        paramInt1 = 0;
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "key_word_src=" + paramInt1);
        }
        if (paramBundle != null)
        {
          paramInt2 = paramBundle.getInt("matchCount", 0);
          i = paramBundle.getInt("source", 0);
          localReqBody.locate_result_count.set(paramInt2);
          localReqBody.source.set(i);
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "matchCount=" + paramInt2 + " source=" + i);
          }
        }
        ((UnifySearchCommon.ExtensionRequestInfo)localObject1).key_word_src.set(paramInt1);
        ((UnifySearchCommon.ExtensionRequestInfo)localObject1).latitude.set((float)paramDouble1);
        ((UnifySearchCommon.ExtensionRequestInfo)localObject1).longitude.set((float)paramDouble2);
        paramBundle = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
        localObject2 = paramBundle.getString("cur_city", null);
        paramInt1 = paramBundle.getInt("cur_adcode", 0);
        ((UnifySearchCommon.ExtensionRequestInfo)localObject1).adcode.set(paramInt1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "uniteSearch, area:" + (String)localObject2 + " code:" + paramInt1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramBundle = ((String)localObject2).split("-");
          if (paramBundle != null)
          {
            if (paramBundle.length != 2) {
              break label940;
            }
            ((UnifySearchCommon.ExtensionRequestInfo)localObject1).region.set(ByteStringMicro.copyFromUtf8(paramBundle[1]));
            ((UnifySearchCommon.ExtensionRequestInfo)localObject1).city.set(ByteStringMicro.copyFromUtf8(paramBundle[0]));
          }
        }
        label707:
        if (paramList2 != null) {
          ((UnifySearchCommon.ExtensionRequestInfo)localObject1).rpt_pubacc_local_result.set(paramList2);
        }
        localReqBody.extension_request_info.set((MessageMicro)localObject1);
        paramList2 = createToServiceMsg("UnifySearch.Unite");
        paramList2.extraData.putInt("fromType", paramInt3);
        paramList2.extraData.putString("keyword", paramString1);
        paramList2.extraData.putString("time", paramString2);
        paramList2.extraData.putLongArray("masks", SearchUtil.a(paramList1));
        paramString1 = paramList2.extraData;
        if (paramArrayOfByte != null) {
          break label965;
        }
      }
      label896:
      label940:
      label965:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        paramString1.putBoolean("isFirstReq", paramBoolean1);
        paramList2.extraData.putLong("send_req_time", System.currentTimeMillis());
        paramList2.putWupBuffer(localReqBody.toByteArray());
        sendPbReq(paramList2);
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
        int j = localObject2.length;
        paramInt2 = 0;
        for (;;)
        {
          paramInt1 = i;
          if (paramInt2 >= j) {
            break;
          }
          if (localObject2[paramInt2].equals(paramString1))
          {
            paramInt1 = 1;
            break;
          }
          paramInt2 += 1;
        }
        if (paramBundle.length != 1) {
          break label707;
        }
        ((UnifySearchCommon.ExtensionRequestInfo)localObject1).city.set(ByteStringMicro.copyFromUtf8(paramBundle[0]));
        break label707;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, byte[] paramArrayOfByte, int paramInt2, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt1, paramList1, paramList2, paramArrayOfByte, paramInt2, paramDouble1, paramDouble2, paramBundle, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, byte[] paramArrayOfByte, int paramInt2, double paramDouble1, double paramDouble2, Bundle paramBundle, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "send tabSearchWrap keyword = [" + paramString1 + "], reqTime = [" + paramString2 + "], count = [" + paramInt1 + "], businessMaskArray = [" + paramList1 + "], cookie = [" + paramArrayOfByte + "], latitude = [" + paramDouble1 + "], longitude = [" + paramDouble2 + "]，jsonData = [" + paramString3 + "]");
    }
    UnifyTabSearch.ReqBody localReqBody = new UnifyTabSearch.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "send tabSearch. keyword is empty.");
      return;
    }
    localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
    Object localObject = new UnifySearchCommon.RootSearcherRequest();
    ((UnifySearchCommon.RootSearcherRequest)localObject).business.set(128);
    ((UnifySearchCommon.RootSearcherRequest)localObject).page_size.set(paramInt1);
    ((UnifySearchCommon.RootSearcherRequest)localObject).rpt_busi_mask.set(paramList1);
    if (paramArrayOfByte != null) {
      ((UnifySearchCommon.RootSearcherRequest)localObject).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramString3 = a(paramBundle, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "tabSearchWrap finalJsonData = " + paramString3);
    }
    if (paramString3 != null) {}
    boolean bool;
    for (;;)
    {
      try
      {
        ((UnifySearchCommon.RootSearcherRequest)localObject).json_data.set(ByteStringMicro.copyFrom(paramString3, "utf-8"));
        localReqBody.search_request.set((MessageMicro)localObject);
        paramString3 = new UnifySearchCommon.ExtensionRequestInfo();
        paramString3.latitude.set((float)paramDouble1);
        paramString3.longitude.set((float)paramDouble2);
        if (FunctionModuleConfigManager.a.isEmpty())
        {
          i = 0;
          paramString3.key_word_src.set(i);
          if (paramList2 != null) {
            paramString3.rpt_pubacc_local_result.set(paramList2);
          }
          localReqBody.extension_request_info.set(paramString3);
          if (paramInt2 != 0) {
            localReqBody.from_sub_hot_word_id.set(paramInt2, true);
          }
          paramList2 = createToServiceMsg("UnifySearch.Tab");
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
          sendPbReq(paramList2);
          return;
        }
      }
      catch (UnsupportedEncodingException paramString3)
      {
        QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, paramString3, new Object[0]);
        continue;
        localObject = FunctionModuleConfigManager.a.values().iterator();
        paramInt1 = 2;
      }
      label620:
      int i = paramInt1;
      if (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((List)((Iterator)localObject).next()).iterator();
        while (localIterator.hasNext()) {
          if (paramString1.equals((BusinessGroupWord.HotWordItem)localIterator.next())) {
            paramInt1 = 1;
          }
        }
      }
    }
    for (;;)
    {
      break label620;
      bool = false;
      break;
    }
  }
  
  public void a(UnifySearchCommon.ResultItemGroup paramResultItemGroup, long paramLong, String paramString, int paramInt, List<ISearchResultGroupModel> paramList)
  {
    String str1 = paramResultItemGroup.group_name.get().toStringUtf8();
    Object localObject1 = paramResultItemGroup.rpt_highlight_words.get();
    ArrayList localArrayList1 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localArrayList1.add(((ByteStringMicro)((Iterator)localObject1).next()).toStringUtf8());
    }
    Object localObject2 = paramResultItemGroup.result_items.get();
    ArrayList localArrayList2 = new ArrayList(((List)localObject2).size());
    boolean bool1;
    String str2;
    String str3;
    long l1;
    int i;
    label156:
    Object localObject3;
    int j;
    label237:
    String str4;
    long l2;
    label315:
    String str5;
    String str6;
    String str7;
    if (paramResultItemGroup.hide_title.get() == 1)
    {
      bool1 = true;
      str2 = paramResultItemGroup.group_footer_name.get().toStringUtf8();
      str3 = paramResultItemGroup.group_footer_jump_url.get().toStringUtf8();
      l1 = ((List)localObject2).size();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label746;
      }
      localObject1 = (UnifySearchCommon.ResultItem)((List)localObject2).get(i);
      localObject3 = ((UnifySearchCommon.ResultItem)localObject1).sub_result_items.get();
      int k = ((List)localObject3).size() + 1;
      ArrayList localArrayList3 = new ArrayList(k);
      localArrayList3.add(localObject1);
      localArrayList3.addAll((Collection)localObject3);
      j = 0;
      if (j >= k) {
        break label737;
      }
      localObject3 = (UnifySearchCommon.ResultItem)localArrayList3.get(j);
      localObject1 = ((UnifySearchCommon.ResultItem)localObject3).result_id.get().toStringUtf8();
      bool2 = ((UnifySearchCommon.ResultItem)localObject3).layout_id.has();
      str4 = ((UnifySearchCommon.ResultItem)localObject3).name.get().toStringUtf8();
      if (!((UnifySearchCommon.ResultItem)localObject3).group_mask.has()) {
        break label511;
      }
      l2 = ((UnifySearchCommon.ResultItem)localObject3).group_mask.get();
      str5 = ((UnifySearchCommon.ResultItem)localObject3).pic_url.get().toStringUtf8();
      str6 = ((UnifySearchCommon.ResultItem)localObject3).jmp_url.get().toStringUtf8();
      str7 = ((UnifySearchCommon.ResultItem)localObject3).extension.get().toStringUtf8();
      if (!bool2) {
        break label552;
      }
      if (paramLong != 1100L) {
        break label517;
      }
      if ((!paramResultItemGroup.group_extra_flag.has()) || ((paramResultItemGroup.group_extra_flag.get() & 0x1) != 0)) {
        break label916;
      }
    }
    label517:
    label916:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject1 = new RichSearchModelNode(paramString, paramLong, localArrayList1, (UnifySearchCommon.ResultItem)localObject3, paramInt);
      ((RichSearchModelNode)localObject1).a(((UnifySearchCommon.ResultItem)localObject3).layout_id.get());
      ((RichSearchModelNode)localObject1).c(null);
      ((RichSearchModelNode)localObject1).a(bool2);
      label445:
      if ((localObject1 != null) && (((NetSearchTemplateBaseItem)localObject1).b()))
      {
        ((NetSearchTemplateBaseItem)localObject1).u = ((UnifySearchCommon.ResultItem)localObject3).seporator_type.get();
        ((NetSearchTemplateBaseItem)localObject1).a = bool1;
        localArrayList2.add(localObject1);
        l2 = l1;
      }
      for (;;)
      {
        j += 1;
        l1 = l2;
        break label237;
        bool1 = false;
        break;
        label511:
        l2 = paramLong;
        break label315;
        localObject1 = a(((UnifySearchCommon.ResultItem)localObject3).layout_id.get(), paramString, paramLong, localArrayList1, (UnifySearchCommon.ResultItem)localObject3, paramInt);
        break label445;
        l2 = l1 - 1L;
        continue;
        label552:
        if (!SearchUtils.b(l2))
        {
          QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, "itemGroupMask is not valid. mask=" + l2);
          l2 = l1;
        }
        else if (l2 == 2073745984L)
        {
          localObject1 = new SearchResultModelForEntrance(paramString, str7, -4, str5);
          ((SearchResultModelForEntrance)localObject1).u = ((UnifySearchCommon.ResultItem)localObject3).seporator_type.get();
          localArrayList2.add(localObject1);
          l2 = l1;
        }
        else
        {
          localObject1 = new GroupBaseNetSearchModelItem(paramString, (String)localObject1, str4, str5, str6, str7, l2, localArrayList1, paramInt);
          l2 = l1;
          if (localObject1 != null)
          {
            ((GroupBaseNetSearchModelItem)localObject1).u = ((UnifySearchCommon.ResultItem)localObject3).seporator_type.get();
            ((GroupBaseNetSearchModelItem)localObject1).c = bool1;
            ((GroupBaseNetSearchModelItem)localObject1).j = i;
            ((GroupBaseNetSearchModelItem)localObject1).a = paramInt;
            localArrayList2.add(localObject1);
            l2 = l1;
          }
        }
      }
      label737:
      i += 1;
      break label156;
      label746:
      if (l1 > 0L)
      {
        l1 = paramResultItemGroup.total_result_count.get();
        localObject1 = paramResultItemGroup.more_url.get().toStringUtf8();
        localObject2 = paramResultItemGroup.more_name.get().toStringUtf8();
        if (paramResultItemGroup.highlight_title_keyword.get() != 1) {
          break label863;
        }
        bool2 = true;
        if (paramResultItemGroup.hide_title_blank_view.get() != 1) {
          break label869;
        }
      }
      label863:
      label869:
      for (boolean bool3 = true;; bool3 = false)
      {
        if (paramLong != 1100L) {
          break label875;
        }
        paramList.add(new GroupSearchModelRichNode(paramString, paramLong, str1, localArrayList2, l1, (String)localObject1, (String)localObject2, localArrayList1, bool1, bool2, bool3, str2, str3));
        return;
        bool2 = false;
        break;
      }
      label875:
      paramList.add(new GroupBaseNetSearchModel(paramString, paramLong, str1, localArrayList2, l1, (String)localObject1, (String)localObject2, localArrayList1, bool1, bool2, bool3, str2, str3));
      return;
    }
  }
  
  public byte[] a(String paramString)
  {
    return FileUtils.a(BaseApplication.getContext().getFileStreamPath(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "<<---handleUnifySearchUniteDiscovery. resultCode=" + paramInt + ", fromType = " + i);
    }
    if ((paramInt != 1000) || (paramObject == null) || (!(paramObject instanceof byte[])))
    {
      notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
      return;
    }
    UnifySearchDiscovery.RspBody localRspBody = new UnifySearchDiscovery.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        paramInt = localRspBody.result_code.get();
        if (localRspBody.error_msg.get() == null) {
          break label339;
        }
        paramToServiceMsg = localRspBody.error_msg.get().toStringUtf8();
        if (paramInt != 0) {
          break label344;
        }
        paramInt = localRspBody.expire_time.get();
        SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, paramInt);
        paramToServiceMsg = localRspBody.result_items.get();
        paramToServiceMsg = SearchEntryDataModel.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "response data: expireTime:" + paramInt + ",modelList :" + paramToServiceMsg.toString());
        }
        notifyUI(1007, true, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "handleUnifySearchUniteDiscovery, InvalidProtocolBufferMicroException e = " + paramToServiceMsg);
      return;
      label339:
      paramToServiceMsg = null;
    }
    label344:
    notifyUI(1007, false, new Object[] { Integer.valueOf(paramInt), paramToServiceMsg, Integer.valueOf(i) });
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return UnifySearchObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq: ").append(paramToServiceMsg.getRequestSsoSeq()).append(", serviceCmd: ").append(str).append(", resultCode: ").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, localStringBuilder.toString());
    }
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "cmd filter error=" + str);
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
        if (!"UnifySearch.AssociationWord".equals(str)) {
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
      if ("UnifySearch.Unite".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("UnifySearch.Tab".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("UnifySearch.BusiHotWord".equals(str))
      {
        i = paramFromServiceMsg.getResultCode();
        a(i, paramObject, jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString);
        a(paramToServiceMsg, i, paramObject);
        return;
      }
    } while (!"UnifySearch.Discovery".equals(str));
    b(paramToServiceMsg, paramFromServiceMsg.getResultCode(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.UnifySearchHandler
 * JD-Core Version:    0.7.0.1
 */