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
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBannerTitleItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBigImageItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateFriendUpdatesItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateQAItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUpdatesItem;
import com.tencent.mobileqq.search.business.net.model.RichSearchModelNode;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.BusinessGroupWord.ClueWordItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord.GroupID;
import com.tencent.mobileqq.search.model.BusinessGroupWord.HotWordItem;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModelRichNode;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
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
import pb.unify.search.UnifySearchDiscovery.ReqBody;
import pb.unify.search.UnifySearchDiscovery.RspBody;
import pb.unify.search.UnifySearchUnite.ReqBody;
import pb.unify.search.UnifyTabSearch.ReqBody;
import pb.unify.search.UnifyTabSearch.RspBody;
import unify.search.UnifySearchCommon.ExtensionRequestInfo;
import unify.search.UnifySearchCommon.ResultItem;
import unify.search.UnifySearchCommon.ResultItemGroup;
import unify.search.UnifySearchCommon.RootSearcherRequest;

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
    case 19: 
      return new NetSearchTemplateIndividuateContainerItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 18: 
      return new NetSearchTemplateMiniAppItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 17: 
      return new NetSearchTemplateNewEntranceItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 16: 
      return new NetSearchTemplateNetSeaEntranceItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 15: 
      return new NetSearchTemplateQAItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 14: 
      return new NetSearchTemplateTitleItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 13: 
      return new NetSearchTemplateHorSlidingContainerItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 12: 
      return new NetSearchTemplateBigImageItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 11: 
      return new NetSearchTemplateFriendUpdatesItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 9: 
      return new NetSearchTemplateSubItemTitle(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 8: 
      return new NetSearchTemplateSubItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 7: 
      return new NetSearchTemplateHorizontalContainerItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 6: 
      return new NetSearchTemplateUniversalItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 4: 
      return new NetSearchTemplateBannerTitleItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    case 3: 
      return new NetSearchTemplateUpdatesItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
    }
    return new NetSearchTemplateAvatarsItem(paramString, paramLong, paramList, paramResultItem, paramInt2);
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("fromType", -1) == 99))
    {
      localObject1 = null;
      if (paramString != null) {}
      try
      {
        localObject2 = new JSONObject(paramString);
        break label44;
        localObject2 = new JSONObject();
        label44:
        localObject1 = localObject2;
        ((JSONObject)localObject2).put("scenario", "related_people_and_groups_panel");
      }
      catch (JSONException localJSONException)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "getMergedJsonData JSONException", localJSONException);
          localObject2 = localObject1;
        }
      }
      if (localObject2 != null)
      {
        localObject1 = ((JSONObject)localObject2).toString();
        break label100;
      }
    }
    Object localObject1 = paramString;
    label100:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getMergedJsonData finalJsonData = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",inputJson = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",extraData = ");
      ((StringBuilder)localObject2).append(paramBundle);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveData code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",fileName=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",key=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",data=");
    localStringBuilder.append(paramObject);
    QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, localStringBuilder.toString());
    if (paramInt == 1000)
    {
      ThreadManager.post(new UnifySearchHandler.1(this, paramString1, paramObject), 5, null, true);
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
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramObject.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleTimeOut serviceCmd:");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramFromServiceMsg.toString());
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
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleError serviceCmd:");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramFromServiceMsg.toString());
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleCompletedUrlResult. resultCode=");
      paramFromServiceMsg.append(i);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramFromServiceMsg.toString());
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
    paramToServiceMsg = new UnifySearchAssociationWord.RspBody();
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
        UnifySearchAssociationWord.SuggestUrlItem localSuggestUrlItem = (UnifySearchAssociationWord.SuggestUrlItem)paramToServiceMsg.completed_url_item.get();
        ArrayList localArrayList = new ArrayList();
        paramToServiceMsg = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
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
        }
        localObject = paramObject.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramToServiceMsg.add(((UnifySearchAssociationWord.SuggestUrlItem)((Iterator)localObject).next()).url.get().toStringUtf8());
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
  
  private boolean b(long paramLong)
  {
    return (StudyModeManager.a()) && ((paramLong == 1100L) || (paramLong == 1012L) || (paramLong == 1003L));
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleCompletedUrlResult. resultCode=");
      paramFromServiceMsg.append(i);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramFromServiceMsg.toString());
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
    paramFromServiceMsg = new UnifySearchAssociationWord.RspBody();
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
        paramObject = (UnifySearchAssociationWord.SuggestUrlItem)paramFromServiceMsg.completed_url_item.get();
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
  
  /* Error */
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 392	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 4
    //   6: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +36 -> 45
    //   12: new 157	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc_w 501
    //   24: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: iload 4
    //   31: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: ldc 145
    //   37: iconst_2
    //   38: aload_2
    //   39: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: ldc_w 503
    //   48: iload 4
    //   50: invokestatic 508	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   53: invokestatic 512	com/tencent/mobileqq/search/util/SearchCostStat:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc_w 514
    //   59: invokestatic 516	com/tencent/mobileqq/search/util/SearchCostStat:b	(Ljava/lang/String;)V
    //   62: aload_1
    //   63: getfield 400	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   66: ldc_w 402
    //   69: ldc_w 354
    //   72: invokevirtual 406	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 12
    //   77: aload_1
    //   78: getfield 400	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   81: ldc_w 518
    //   84: ldc_w 354
    //   87: invokevirtual 406	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 13
    //   92: aload_1
    //   93: getfield 400	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   96: ldc_w 520
    //   99: invokevirtual 524	android/os/Bundle:getLongArray	(Ljava/lang/String;)[J
    //   102: astore_2
    //   103: aload_1
    //   104: getfield 400	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   107: ldc_w 526
    //   110: invokevirtual 530	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   113: istore 6
    //   115: aload_1
    //   116: getfield 400	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   119: ldc_w 532
    //   122: invokevirtual 536	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   125: lstore 7
    //   127: iload 4
    //   129: i2l
    //   130: lstore 9
    //   132: iconst_5
    //   133: anewarray 408	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload 12
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: iload 6
    //   145: invokestatic 541	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: aload 13
    //   153: aastore
    //   154: dup
    //   155: iconst_3
    //   156: iconst_m1
    //   157: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: dup
    //   162: iconst_4
    //   163: ldc_w 354
    //   166: aastore
    //   167: astore 11
    //   169: aload_0
    //   170: ldc_w 543
    //   173: lload 7
    //   175: lload 9
    //   177: aload 12
    //   179: invokevirtual 377	com/tencent/mobileqq/app/UnifySearchHandler:a	(Ljava/lang/String;JJLjava/lang/String;)V
    //   182: iload 4
    //   184: sipush 1000
    //   187: if_icmpeq +14 -> 201
    //   190: aload_0
    //   191: sipush 1004
    //   194: iconst_0
    //   195: aload 11
    //   197: invokevirtual 418	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   200: return
    //   201: aload_3
    //   202: ifnonnull +14 -> 216
    //   205: aload_0
    //   206: sipush 1004
    //   209: iconst_0
    //   210: aload 11
    //   212: invokevirtual 418	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   215: return
    //   216: aload_3
    //   217: instanceof 420
    //   220: ifne +14 -> 234
    //   223: aload_0
    //   224: sipush 1004
    //   227: iconst_0
    //   228: aload 11
    //   230: invokevirtual 418	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   233: return
    //   234: new 545	pb/unify/search/UnifySearchUnite$RspBody
    //   237: dup
    //   238: invokespecial 546	pb/unify/search/UnifySearchUnite$RspBody:<init>	()V
    //   241: astore 14
    //   243: aload 14
    //   245: aload_3
    //   246: checkcast 420	[B
    //   249: checkcast 420	[B
    //   252: invokevirtual 547	pb/unify/search/UnifySearchUnite$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   255: pop
    //   256: aload 14
    //   258: getfield 548	pb/unify/search/UnifySearchUnite$RspBody:result_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   261: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   264: istore 4
    //   266: aload 14
    //   268: getfield 549	pb/unify/search/UnifySearchUnite$RspBody:error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   271: invokevirtual 443	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   274: astore_3
    //   275: iload 4
    //   277: ifeq +63 -> 340
    //   280: iload 4
    //   282: sipush 1000
    //   285: if_icmplt +6 -> 291
    //   288: goto +52 -> 340
    //   291: iconst_5
    //   292: anewarray 408	java/lang/Object
    //   295: astore_2
    //   296: aload_2
    //   297: iconst_0
    //   298: aload 12
    //   300: aastore
    //   301: aload_2
    //   302: iconst_1
    //   303: iload 6
    //   305: invokestatic 541	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   308: aastore
    //   309: aload_2
    //   310: iconst_2
    //   311: aload 13
    //   313: aastore
    //   314: aload_2
    //   315: iconst_3
    //   316: iload 4
    //   318: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aastore
    //   322: aload_2
    //   323: iconst_4
    //   324: aload_3
    //   325: aastore
    //   326: aload_0
    //   327: sipush 1004
    //   330: iconst_0
    //   331: aload_2
    //   332: invokevirtual 418	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   335: return
    //   336: astore_1
    //   337: goto +350 -> 687
    //   340: aload 14
    //   342: getfield 552	pb/unify/search/UnifySearchUnite$RspBody:cookie_topic	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   345: invokevirtual 259	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   348: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   351: astore_3
    //   352: aload 14
    //   354: getfield 559	pb/unify/search/UnifySearchUnite$RspBody:search_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   357: invokevirtual 562	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   360: ifeq +21 -> 381
    //   363: ldc_w 543
    //   366: aload_2
    //   367: aload 14
    //   369: getfield 559	pb/unify/search/UnifySearchUnite$RspBody:search_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   372: invokevirtual 259	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   375: invokevirtual 264	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   378: invokestatic 567	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[JLjava/lang/String;)V
    //   381: aload 14
    //   383: getfield 570	pb/unify/search/UnifySearchUnite$RspBody:is_end_topic	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   386: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   389: iconst_1
    //   390: if_icmpne +315 -> 705
    //   393: iconst_1
    //   394: istore 5
    //   396: goto +3 -> 399
    //   399: aload 14
    //   401: getfield 573	pb/unify/search/UnifySearchUnite$RspBody:tab_groups	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   404: invokevirtual 246	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   407: astore_2
    //   408: new 178	java/util/ArrayList
    //   411: dup
    //   412: aload_2
    //   413: invokeinterface 212 1 0
    //   418: invokespecial 215	java/util/ArrayList:<init>	(I)V
    //   421: astore 15
    //   423: iconst_0
    //   424: istore 4
    //   426: iload 4
    //   428: aload_2
    //   429: invokeinterface 212 1 0
    //   434: if_icmpge +38 -> 472
    //   437: aload 15
    //   439: new 575	com/tencent/mobileqq/search/model/GroupTabModel
    //   442: dup
    //   443: aload_2
    //   444: iload 4
    //   446: invokeinterface 578 2 0
    //   451: checkcast 580	pb/unify/search/UnifySearchUnite$TabItemGroup
    //   454: invokespecial 583	com/tencent/mobileqq/search/model/GroupTabModel:<init>	(Lpb/unify/search/UnifySearchUnite$TabItemGroup;)V
    //   457: invokeinterface 274 2 0
    //   462: pop
    //   463: iload 4
    //   465: iconst_1
    //   466: iadd
    //   467: istore 4
    //   469: goto -43 -> 426
    //   472: aload 14
    //   474: getfield 586	pb/unify/search/UnifySearchUnite$RspBody:trigger_netword_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   477: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   480: istore 4
    //   482: iload 4
    //   484: iflt +11 -> 495
    //   487: invokestatic 589	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   490: iload 4
    //   492: invokestatic 595	com/tencent/mobileqq/utils/SharedPreUtils:s	(Landroid/content/Context;I)V
    //   495: aload 14
    //   497: getfield 598	pb/unify/search/UnifySearchUnite$RspBody:item_groups	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   500: invokevirtual 246	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   503: astore_2
    //   504: invokestatic 497	com/tencent/mobileqq/studymode/StudyModeManager:a	()Z
    //   507: ifeq +15 -> 522
    //   510: new 178	java/util/ArrayList
    //   513: dup
    //   514: iconst_0
    //   515: invokespecial 215	java/util/ArrayList:<init>	(I)V
    //   518: astore_2
    //   519: goto +36 -> 555
    //   522: aload_0
    //   523: iconst_3
    //   524: anewarray 408	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: aload 12
    //   531: aastore
    //   532: dup
    //   533: iconst_1
    //   534: aload_2
    //   535: aastore
    //   536: dup
    //   537: iconst_2
    //   538: aload_1
    //   539: getfield 400	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   542: ldc 116
    //   544: invokevirtual 601	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   547: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   550: aastore
    //   551: invokevirtual 604	com/tencent/mobileqq/app/UnifySearchHandler:a	([Ljava/lang/Object;)Ljava/util/List;
    //   554: astore_2
    //   555: aload 14
    //   557: getfield 607	pb/unify/search/UnifySearchUnite$RspBody:exhibition_flags	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   560: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   563: istore 4
    //   565: bipush 8
    //   567: anewarray 408	java/lang/Object
    //   570: astore_1
    //   571: aload_1
    //   572: iconst_0
    //   573: aload 12
    //   575: aastore
    //   576: aload_1
    //   577: iconst_1
    //   578: iload 6
    //   580: invokestatic 541	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   583: aastore
    //   584: aload_1
    //   585: iconst_2
    //   586: aload 13
    //   588: aastore
    //   589: aload_1
    //   590: iconst_3
    //   591: aload_3
    //   592: aastore
    //   593: aload_1
    //   594: iconst_4
    //   595: iload 5
    //   597: invokestatic 541	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   600: aastore
    //   601: aload_1
    //   602: iconst_5
    //   603: aload 15
    //   605: aastore
    //   606: aload_1
    //   607: bipush 6
    //   609: aload_2
    //   610: aastore
    //   611: aload_1
    //   612: bipush 7
    //   614: iload 4
    //   616: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   619: aastore
    //   620: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +36 -> 659
    //   626: new 157	java/lang/StringBuilder
    //   629: dup
    //   630: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   633: astore_2
    //   634: aload_2
    //   635: ldc_w 609
    //   638: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload_2
    //   643: iload 4
    //   645: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: ldc 145
    //   651: iconst_2
    //   652: aload_2
    //   653: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   659: aload_0
    //   660: sipush 1004
    //   663: iconst_1
    //   664: aload_1
    //   665: invokevirtual 418	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   668: return
    //   669: astore_2
    //   670: aload_1
    //   671: astore_3
    //   672: goto +19 -> 691
    //   675: astore_3
    //   676: aload_1
    //   677: astore_2
    //   678: aload_3
    //   679: astore_1
    //   680: goto +7 -> 687
    //   683: astore_1
    //   684: aload 11
    //   686: astore_2
    //   687: aload_2
    //   688: astore_3
    //   689: aload_1
    //   690: astore_2
    //   691: aload_0
    //   692: sipush 1004
    //   695: iconst_0
    //   696: aload_3
    //   697: invokevirtual 418	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   700: aload_2
    //   701: invokevirtual 493	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   704: return
    //   705: iconst_0
    //   706: istore 5
    //   708: goto -309 -> 399
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	711	0	this	UnifySearchHandler
    //   0	711	1	paramToServiceMsg	ToServiceMsg
    //   0	711	2	paramFromServiceMsg	FromServiceMsg
    //   0	711	3	paramObject	Object
    //   4	640	4	i	int
    //   394	313	5	bool1	boolean
    //   113	466	6	bool2	boolean
    //   125	49	7	l1	long
    //   130	46	9	l2	long
    //   167	518	11	arrayOfObject	Object[]
    //   75	499	12	str1	String
    //   90	497	13	str2	String
    //   241	315	14	localRspBody	pb.unify.search.UnifySearchUnite.RspBody
    //   421	183	15	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   326	335	336	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   659	668	669	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   620	659	675	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   243	275	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   291	296	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   301	309	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   314	322	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   340	381	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   381	393	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   399	423	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   426	463	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   472	482	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   487	495	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   495	519	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   522	555	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   555	571	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   576	584	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   593	601	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   611	620	683	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public List<ISearchResultGroupModel> a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 3))
    {
      String str;
      if ((paramVarArgs[0] instanceof String)) {
        str = (String)paramVarArgs[0];
      } else {
        str = "";
      }
      if ((paramVarArgs[1] instanceof List)) {
        localObject = (List)paramVarArgs[1];
      } else {
        localObject = new ArrayList();
      }
      int i;
      if ((paramVarArgs[2] instanceof Integer)) {
        i = ((Integer)paramVarArgs[2]).intValue();
      } else {
        i = -1;
      }
      boolean bool2 = SearchUtils.c(i);
      boolean bool1;
      if (bool2) {
        bool1 = SearchConfigUtils.b(i);
      } else {
        bool1 = true;
      }
      paramVarArgs = new ArrayList(((List)localObject).size());
      Object localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        UnifySearchCommon.ResultItemGroup localResultItemGroup = (UnifySearchCommon.ResultItemGroup)((Iterator)localObject).next();
        long l = localResultItemGroup.group_mask.get();
        if (((!bool2) || (!a(l)) || (bool1)) && (!b(l))) {
          a(localResultItemGroup, l, str, i, paramVarArgs);
        }
      }
      return paramVarArgs;
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "sendBusiHotWordRequest. ");
    }
    UnifySearchBusiHotWord.ReqBody localReqBody = new UnifySearchBusiHotWord.ReqBody();
    localReqBody.business.set(128);
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    ToServiceMsg localToServiceMsg = createToServiceMsg("UnifySearch.BusiHotWord");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUniteSearchDiscovery. fromType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, ((StringBuilder)localObject).toString());
    }
    if (!SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin(), paramInt))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getUniteSearchDiscovery. fromType = ");
        paramQQAppInterface.append(paramInt);
        paramQQAppInterface.append(", cache is not expired, return");
        QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramQQAppInterface.toString());
      }
      return;
    }
    Object localObject = new UnifySearchDiscovery.ReqBody();
    ((UnifySearchDiscovery.ReqBody)localObject).version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    ((UnifySearchDiscovery.ReqBody)localObject).business.set(128);
    ((UnifySearchDiscovery.ReqBody)localObject).from_type.set(paramInt);
    paramQQAppInterface = createToServiceMsg("UnifySearch.Discovery");
    paramQQAppInterface.extraData.putInt("fromType", paramInt);
    try
    {
      paramQQAppInterface.putWupBuffer(((UnifySearchDiscovery.ReqBody)localObject).toByteArray());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUniteSearchDiscovery fromType:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", error:");
      localStringBuilder.append(localException.toString());
      QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, localStringBuilder.toString());
    }
    sendPbReq(paramQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<---handleBusiHotWord. resultCode=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, localStringBuilder.toString());
    }
    if (paramToServiceMsg != null) {
      a("UnifySearch.BusiHotWord", paramToServiceMsg.extraData.getLong("send_req_time"), paramInt);
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
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("response data: expireTime:");
          paramObject.append(paramInt);
          paramObject.append(",resultItemList :");
          paramObject.append(paramToServiceMsg.toString());
          QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramObject.toString());
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
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("<<---handleTabSearchWrapResult. resultCode=");
      paramFromServiceMsg.append(i);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramFromServiceMsg.toString());
    }
    String str1 = paramToServiceMsg.extraData.getString("keyword", "");
    String str2 = paramToServiceMsg.extraData.getString("time", "");
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("masks");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("isFirstReq");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isLoadMore", false);
    long l1 = paramToServiceMsg.extraData.getLong("send_req_time");
    long l2 = i;
    paramFromServiceMsg = new Object[] { str1, Boolean.valueOf(bool3), str2, Integer.valueOf(-1), "", arrayOfLong };
    a("UnifySearch.Tab", l1, l2, str1);
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
        paramObject = localRspBody.error_msg.get();
        if ((i != 0) && (i < 1000))
        {
          paramToServiceMsg = new Object[6];
          paramToServiceMsg[0] = str1;
          paramToServiceMsg[1] = Boolean.valueOf(bool3);
          paramToServiceMsg[2] = str2;
          paramToServiceMsg[3] = Integer.valueOf(i);
          paramToServiceMsg[4] = paramObject;
          paramToServiceMsg[5] = arrayOfLong;
          try
          {
            notifyUI(1000, false, paramToServiceMsg);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
        }
        else
        {
          paramObject = localRspBody.cookie.get().toByteArray();
          if (localRspBody.search_ver.has()) {
            SearchUtils.a("UnifySearch.Tab", arrayOfLong, localRspBody.search_ver.get().toStringUtf8());
          }
          if (localRspBody.is_end.get() != 1) {
            break label705;
          }
          bool1 = true;
          List localList1 = localRspBody.item_groups.get();
          Object localObject = new TabNetBaseParser();
          if (!bool2) {
            break label711;
          }
          ((TabNetBaseParser)localObject).a(true);
          localList1 = ((TabNetBaseParser)localObject).a(new Object[] { str1, localList1, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) });
          localObject = localRspBody.sub_hot_top_wording.get().toStringUtf8();
          if (localRspBody.dont_need_merge.get() != 1) {
            break label714;
          }
          bool2 = true;
          List localList2 = localRspBody.hot_words.get();
          String str3 = localRspBody.extension.get().toStringUtf8();
          i = localRspBody.exhibition_flags.get();
          boolean bool4 = QLog.isColorLevel();
          if (bool4) {}
          try
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleTabSearchWrapResult subId = ");
            paramToServiceMsg.append(i);
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramToServiceMsg.toString());
            paramToServiceMsg = new Object[12];
            paramToServiceMsg[0] = str1;
            paramToServiceMsg[1] = Boolean.valueOf(bool3);
            paramToServiceMsg[2] = str2;
            paramToServiceMsg[3] = paramObject;
            paramToServiceMsg[4] = Boolean.valueOf(bool1);
            paramToServiceMsg[5] = localList1;
            paramToServiceMsg[6] = arrayOfLong;
            paramToServiceMsg[7] = localObject;
            paramToServiceMsg[8] = localList2;
            paramToServiceMsg[9] = Boolean.valueOf(bool2);
            paramToServiceMsg[10] = str3;
            paramToServiceMsg[11] = Integer.valueOf(i);
            try
            {
              notifyUI(1000, true, paramToServiceMsg);
              return;
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
          }
          catch (InvalidProtocolBufferMicroException paramObject)
          {
            paramToServiceMsg = paramFromServiceMsg;
            paramFromServiceMsg = paramObject;
          }
        }
        notifyUI(1000, false, paramToServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
      }
      paramFromServiceMsg.printStackTrace();
      return;
      label705:
      boolean bool1 = false;
      continue;
      label711:
      continue;
      label714:
      bool2 = false;
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, 1);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
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
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new UnifySearchUnite.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "send uniteSearch. keyword is empty.");
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
    ((UnifySearchUnite.ReqBody)localObject1).key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((UnifySearchUnite.ReqBody)localObject1).version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    if (paramBoolean2) {
      ((UnifySearchUnite.ReqBody)localObject1).client_has_people_and_qun.set(1);
    }
    if (paramInt3 == 1) {
      ((UnifySearchUnite.ReqBody)localObject1).from_tabbar_index.set(0);
    } else if (paramInt3 == 2) {
      ((UnifySearchUnite.ReqBody)localObject1).from_tabbar_index.set(1);
    } else if (paramInt3 == 21) {
      ((UnifySearchUnite.ReqBody)localObject1).from_tabbar_index.set(2);
    } else {
      ((UnifySearchUnite.ReqBody)localObject1).from_tabbar_index.set(0);
    }
    if (!paramBoolean1)
    {
      localObject2 = new UnifySearchCommon.RootSearcherRequest();
      ((UnifySearchCommon.RootSearcherRequest)localObject2).business.set(128);
      ((UnifySearchCommon.RootSearcherRequest)localObject2).rpt_busi_mask.set(SearchUtils.a(jdField_a_of_type_ArrayOfLong));
      ((UnifySearchUnite.ReqBody)localObject1).req_entity.set((MessageMicro)localObject2);
    }
    Object localObject2 = new UnifySearchCommon.RootSearcherRequest();
    ((UnifySearchCommon.RootSearcherRequest)localObject2).business.set(128);
    ((UnifySearchCommon.RootSearcherRequest)localObject2).page_size.set(paramInt1);
    ((UnifySearchCommon.RootSearcherRequest)localObject2).rpt_busi_mask.set(paramList1);
    if (paramArrayOfByte != null) {
      ((UnifySearchCommon.RootSearcherRequest)localObject2).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((UnifySearchUnite.ReqBody)localObject1).req_topic.set((MessageMicro)localObject2);
    ((UnifySearchUnite.ReqBody)localObject1).from_action.set(i);
    localObject2 = new UnifySearchCommon.ExtensionRequestInfo();
    Object localObject3 = SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, ((StringBuilder)localObject3).toString());
    }
    if (paramBundle != null)
    {
      paramInt2 = paramBundle.getInt("matchCount", 0);
      i = paramBundle.getInt("source", 0);
      ((UnifySearchUnite.ReqBody)localObject1).locate_result_count.set(paramInt2);
      ((UnifySearchUnite.ReqBody)localObject1).source.set(i);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("matchCount=");
        paramBundle.append(paramInt2);
        paramBundle.append(" source=");
        paramBundle.append(i);
        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramBundle.toString());
      }
    }
    ((UnifySearchCommon.ExtensionRequestInfo)localObject2).key_word_src.set(paramInt1);
    ((UnifySearchCommon.ExtensionRequestInfo)localObject2).latitude.set((float)paramDouble1);
    ((UnifySearchCommon.ExtensionRequestInfo)localObject2).longitude.set((float)paramDouble2);
    localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    paramBundle = ((SharedPreferences)localObject3).getString("cur_city", null);
    paramInt1 = ((SharedPreferences)localObject3).getInt("cur_adcode", 0);
    ((UnifySearchCommon.ExtensionRequestInfo)localObject2).adcode.set(paramInt1);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("uniteSearch, area:");
      ((StringBuilder)localObject3).append(paramBundle);
      ((StringBuilder)localObject3).append(" code:");
      ((StringBuilder)localObject3).append(paramInt1);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, ((StringBuilder)localObject3).toString());
    }
    if (!TextUtils.isEmpty(paramBundle))
    {
      paramBundle = paramBundle.split("-");
      if (paramBundle != null) {
        if (paramBundle.length == 2)
        {
          ((UnifySearchCommon.ExtensionRequestInfo)localObject2).region.set(ByteStringMicro.copyFromUtf8(paramBundle[1]));
          ((UnifySearchCommon.ExtensionRequestInfo)localObject2).city.set(ByteStringMicro.copyFromUtf8(paramBundle[0]));
        }
        else if (paramBundle.length == 1)
        {
          ((UnifySearchCommon.ExtensionRequestInfo)localObject2).city.set(ByteStringMicro.copyFromUtf8(paramBundle[0]));
        }
      }
    }
    paramBoolean1 = true;
    if (paramList2 != null) {
      ((UnifySearchCommon.ExtensionRequestInfo)localObject2).rpt_pubacc_local_result.set(paramList2);
    }
    ((UnifySearchUnite.ReqBody)localObject1).extension_request_info.set((MessageMicro)localObject2);
    paramList2 = createToServiceMsg("UnifySearch.Unite");
    paramList2.extraData.putInt("fromType", paramInt3);
    paramList2.extraData.putString("keyword", paramString1);
    paramList2.extraData.putString("time", paramString2);
    paramList2.extraData.putLongArray("masks", SearchUtil.a(paramList1));
    paramString1 = paramList2.extraData;
    if (paramArrayOfByte != null) {
      paramBoolean1 = false;
    }
    paramString1.putBoolean("isFirstReq", paramBoolean1);
    paramList2.extraData.putLong("send_req_time", System.currentTimeMillis());
    paramList2.putWupBuffer(((UnifySearchUnite.ReqBody)localObject1).toByteArray());
    sendPbReq(paramList2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, byte[] paramArrayOfByte, int paramInt2, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt1, paramList1, paramList2, paramArrayOfByte, paramInt2, paramDouble1, paramDouble2, paramBundle, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, byte[] paramArrayOfByte, int paramInt2, double paramDouble1, double paramDouble2, Bundle paramBundle, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send tabSearchWrap keyword = [");
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
      ((StringBuilder)localObject1).append("]，jsonData = [");
      ((StringBuilder)localObject1).append(paramString3);
      ((StringBuilder)localObject1).append("]");
      QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new UnifyTabSearch.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, "send tabSearch. keyword is empty.");
      return;
    }
    ((UnifyTabSearch.ReqBody)localObject1).key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((UnifyTabSearch.ReqBody)localObject1).version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    Object localObject2 = new UnifySearchCommon.RootSearcherRequest();
    ((UnifySearchCommon.RootSearcherRequest)localObject2).business.set(128);
    ((UnifySearchCommon.RootSearcherRequest)localObject2).page_size.set(paramInt1);
    ((UnifySearchCommon.RootSearcherRequest)localObject2).rpt_busi_mask.set(paramList1);
    if (paramArrayOfByte != null) {
      ((UnifySearchCommon.RootSearcherRequest)localObject2).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramString3 = a(paramBundle, paramString3);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("tabSearchWrap finalJsonData = ");
      ((StringBuilder)localObject3).append(paramString3);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, ((StringBuilder)localObject3).toString());
    }
    if (paramString3 != null) {
      try
      {
        ((UnifySearchCommon.RootSearcherRequest)localObject2).json_data.set(ByteStringMicro.copyFrom(paramString3, "utf-8"));
      }
      catch (UnsupportedEncodingException paramString3)
      {
        QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, paramString3, new Object[0]);
      }
    }
    ((UnifyTabSearch.ReqBody)localObject1).search_request.set((MessageMicro)localObject2);
    paramString3 = new UnifySearchCommon.ExtensionRequestInfo();
    paramString3.latitude.set((float)paramDouble1);
    paramString3.longitude.set((float)paramDouble2);
    int i;
    if (FunctionModuleConfigManager.a.isEmpty())
    {
      i = 0;
    }
    else
    {
      localObject2 = FunctionModuleConfigManager.a.values().iterator();
      paramInt1 = 2;
      for (;;)
      {
        i = paramInt1;
        if (!((Iterator)localObject2).hasNext()) {
          break label507;
        }
        localObject3 = ((List)((Iterator)localObject2).next()).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          if (!paramString1.equals((BusinessGroupWord.HotWordItem)((Iterator)localObject3).next())) {
            break;
          }
          paramInt1 = 1;
        }
      }
    }
    label507:
    paramString3.key_word_src.set(i);
    if (paramList2 != null) {
      paramString3.rpt_pubacc_local_result.set(paramList2);
    }
    ((UnifyTabSearch.ReqBody)localObject1).extension_request_info.set(paramString3);
    if (paramInt2 != 0) {
      ((UnifyTabSearch.ReqBody)localObject1).from_sub_hot_word_id.set(paramInt2, true);
    }
    paramList2 = createToServiceMsg("UnifySearch.Tab");
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
    paramList2.putWupBuffer(((UnifyTabSearch.ReqBody)localObject1).toByteArray());
    sendPbReq(paramList2);
  }
  
  public void a(UnifySearchCommon.ResultItemGroup paramResultItemGroup, long paramLong, String paramString, int paramInt, List<ISearchResultGroupModel> paramList)
  {
    Object localObject1 = paramResultItemGroup;
    String str1 = ((UnifySearchCommon.ResultItemGroup)localObject1).group_name.get().toStringUtf8();
    Object localObject2 = ((UnifySearchCommon.ResultItemGroup)localObject1).rpt_highlight_words.get();
    ArrayList localArrayList = new ArrayList(((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList.add(((ByteStringMicro)((Iterator)localObject2).next()).toStringUtf8());
    }
    Object localObject3 = ((UnifySearchCommon.ResultItemGroup)localObject1).result_items.get();
    localObject2 = new ArrayList(((List)localObject3).size());
    int i = ((UnifySearchCommon.ResultItemGroup)localObject1).hide_title.get();
    boolean bool3 = false;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    String str2 = ((UnifySearchCommon.ResultItemGroup)localObject1).group_footer_name.get().toStringUtf8();
    String str3 = ((UnifySearchCommon.ResultItemGroup)localObject1).group_footer_jump_url.get().toStringUtf8();
    long l1 = ((List)localObject3).size();
    i = 0;
    localObject1 = localObject3;
    boolean bool2;
    while (i < ((List)localObject1).size())
    {
      Object localObject4 = (UnifySearchCommon.ResultItem)((List)localObject1).get(i);
      Object localObject5 = ((UnifySearchCommon.ResultItem)localObject4).sub_result_items.get();
      int m = ((List)localObject5).size() + 1;
      localObject3 = new ArrayList(m);
      ((List)localObject3).add(localObject4);
      ((List)localObject3).addAll((Collection)localObject5);
      int k = 0;
      int j = i;
      i = m;
      for (;;)
      {
        localObject4 = paramResultItemGroup;
        if (k >= i) {
          break;
        }
        localObject5 = (UnifySearchCommon.ResultItem)((List)localObject3).get(k);
        Object localObject6 = ((UnifySearchCommon.ResultItem)localObject5).result_id.get().toStringUtf8();
        bool2 = ((UnifySearchCommon.ResultItem)localObject5).layout_id.has();
        String str4 = ((UnifySearchCommon.ResultItem)localObject5).name.get().toStringUtf8();
        long l2;
        if (((UnifySearchCommon.ResultItem)localObject5).group_mask.has()) {
          l2 = ((UnifySearchCommon.ResultItem)localObject5).group_mask.get();
        } else {
          l2 = paramLong;
        }
        String str5 = ((UnifySearchCommon.ResultItem)localObject5).pic_url.get().toStringUtf8();
        String str6 = ((UnifySearchCommon.ResultItem)localObject5).jmp_url.get().toStringUtf8();
        String str7 = ((UnifySearchCommon.ResultItem)localObject5).extension.get().toStringUtf8();
        if (bool2)
        {
          if (paramLong == 1100L)
          {
            if ((((UnifySearchCommon.ResultItemGroup)localObject4).group_extra_flag.has()) && ((((UnifySearchCommon.ResultItemGroup)localObject4).group_extra_flag.get() & 0x1) == 0)) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            localObject4 = new RichSearchModelNode(paramString, paramLong, localArrayList, (UnifySearchCommon.ResultItem)localObject5, paramInt);
            localObject6 = (RichSearchModelNode)localObject4;
            ((RichSearchModelNode)localObject6).a(((UnifySearchCommon.ResultItem)localObject5).layout_id.get());
            ((RichSearchModelNode)localObject6).c(null);
            ((RichSearchModelNode)localObject6).a(bool2);
          }
          else
          {
            localObject4 = a(((UnifySearchCommon.ResultItem)localObject5).layout_id.get(), paramString, paramLong, localArrayList, (UnifySearchCommon.ResultItem)localObject5, paramInt);
          }
          if ((localObject4 != null) && (((NetSearchTemplateBaseItem)localObject4).b()))
          {
            ((NetSearchTemplateBaseItem)localObject4).u = ((UnifySearchCommon.ResultItem)localObject5).seporator_type.get();
            ((NetSearchTemplateBaseItem)localObject4).a = bool1;
            ((List)localObject2).add(localObject4);
          }
          else
          {
            l1 -= 1L;
          }
        }
        for (;;)
        {
          break;
          if (!SearchUtils.b(l2))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("itemGroupMask is not valid. mask=");
            ((StringBuilder)localObject4).append(l2);
            QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, ((StringBuilder)localObject4).toString());
          }
          else if (l2 == 2073745984L)
          {
            localObject4 = new SearchResultModelForEntrance(paramString, str7, -4, str5);
            ((SearchResultModelForEntrance)localObject4).u = ((UnifySearchCommon.ResultItem)localObject5).seporator_type.get();
            ((List)localObject2).add(localObject4);
          }
          else
          {
            localObject4 = new GroupBaseNetSearchModelItem(paramString, (String)localObject6, str4, str5, str6, str7, l2, localArrayList, paramInt);
            ((GroupBaseNetSearchModelItem)localObject4).u = ((UnifySearchCommon.ResultItem)localObject5).seporator_type.get();
            ((GroupBaseNetSearchModelItem)localObject4).c = bool1;
            ((GroupBaseNetSearchModelItem)localObject4).j = j;
            ((GroupBaseNetSearchModelItem)localObject4).a = paramInt;
            ((List)localObject2).add(localObject4);
          }
        }
        k += 1;
      }
      i = j + 1;
    }
    if (l1 > 0L)
    {
      l1 = paramResultItemGroup.total_result_count.get();
      localObject1 = paramResultItemGroup.more_url.get().toStringUtf8();
      localObject3 = paramResultItemGroup.more_name.get().toStringUtf8();
      if (paramResultItemGroup.highlight_title_keyword.get() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (paramResultItemGroup.hide_title_blank_view.get() == 1) {
        bool3 = true;
      }
      if (paramLong == 1100L)
      {
        paramList.add(new GroupSearchModelRichNode(paramString, paramLong, str1, (List)localObject2, l1, (String)localObject1, (String)localObject3, localArrayList, bool1, bool2, bool3, str2, str3));
        return;
      }
      paramResultItemGroup = new GroupBaseNetSearchModel(paramString, paramLong, str1, (List)localObject2, l1, (String)localObject1, (String)localObject3, localArrayList, bool1, bool2, bool3, str2, str3);
      paramResultItemGroup.a(paramInt);
      paramList.add(paramResultItemGroup);
    }
  }
  
  public byte[] a(String paramString)
  {
    return FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<<---handleUnifySearchUniteDiscovery. resultCode=");
      paramToServiceMsg.append(paramInt);
      paramToServiceMsg.append(", fromType = ");
      paramToServiceMsg.append(i);
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramToServiceMsg.toString());
    }
    UnifySearchDiscovery.RspBody localRspBody;
    if ((paramInt == 1000) && (paramObject != null) && ((paramObject instanceof byte[]))) {
      localRspBody = new UnifySearchDiscovery.RspBody();
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        paramInt = localRspBody.result_code.get();
        if (localRspBody.error_msg.get() == null) {
          break label403;
        }
        paramToServiceMsg = localRspBody.error_msg.get().toStringUtf8();
        if (paramInt == 0)
        {
          paramInt = localRspBody.expire_time.get();
          SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, paramInt);
          paramToServiceMsg = localRspBody.result_items.get();
          paramToServiceMsg = SearchEntryDataModel.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, i);
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("response data: expireTime:");
            paramObject.append(paramInt);
            paramObject.append(",modelList :");
            paramObject.append(paramToServiceMsg.toString());
            QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramObject.toString());
          }
          notifyUI(1007, true, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
          return;
        }
        notifyUI(1007, false, new Object[] { Integer.valueOf(paramInt), paramToServiceMsg, Integer.valueOf(i) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleUnifySearchUniteDiscovery, InvalidProtocolBufferMicroException e = ");
          paramObject.append(paramToServiceMsg);
          QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramObject.toString());
        }
        return;
      }
      notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
      return;
      label403:
      paramToServiceMsg = null;
    }
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
      localStringBuilder.append("onReceive success ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(", serviceCmd: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", resultCode: ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, localStringBuilder.toString());
    }
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmd filter error=");
        paramToServiceMsg.append(str);
        QLog.d("Q.uniteSearch.UnifySearchHandler818searchProto_new", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if (paramFromServiceMsg.getResultCode() == 1002) {
      a(paramToServiceMsg, paramFromServiceMsg);
    } else if (paramFromServiceMsg.getResultCode() != 1000) {
      b(paramToServiceMsg, paramFromServiceMsg);
    }
    int i;
    if ("UnifySearch.AssociationWord".equals(str))
    {
      i = paramToServiceMsg.extraData.getInt("needFlag", 0);
      if ((i & 0x4) != 0) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      if (((i & 0x2) != 0) || ((i & 0x1) != 0)) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else
    {
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
      if ("UnifySearch.Discovery".equals(str)) {
        b(paramToServiceMsg, paramFromServiceMsg.getResultCode(), paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.UnifySearchHandler
 * JD-Core Version:    0.7.0.1
 */