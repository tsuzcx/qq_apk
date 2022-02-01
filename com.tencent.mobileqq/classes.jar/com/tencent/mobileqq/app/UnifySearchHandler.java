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
  public static long[] a = { 1001L, 1002L, 1003L, 1005L, 2073745984L, 1006L, 1007L };
  public static long[] b = { 1004L };
  public static long[] c = { 2073745984L, 1073745984L, 1001L, 1002L, 1003L, 1005L, 1006L };
  public static String d = "hot_word_for_sub_business_unify";
  public static String e = "hot_word_for_sub_business_req_time_unify";
  public static String f = "hot_word_for_sub_business_exprire_time_unify";
  private QQAppInterface g;
  
  public UnifySearchHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.g = ((QQAppInterface)paramAppInterface);
    }
  }
  
  public UnifySearchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.g = paramQQAppInterface;
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
    FunctionModuleConfigManager.b.clear();
    FunctionModuleConfigManager.c.clear();
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
      FunctionModuleConfigManager.b.put(FunctionModuleConfigManager.a(localGroupID.a), localArrayList2);
      localObject2 = (UnifySearchBusiHotWord.ClueWordItem)((UnifySearchBusiHotWord.GroupWord)localObject1).clue_word_item.get();
      localObject1 = ((UnifySearchBusiHotWord.ClueWordItem)localObject2).word_id.get().toStringUtf8();
      localObject2 = ((UnifySearchBusiHotWord.ClueWordItem)localObject2).word.get().toStringUtf8();
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
    localStringBuilder.append(",fileName=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",key=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",data=");
    localStringBuilder.append(paramObject);
    QLog.i("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, localStringBuilder.toString());
    if ((paramInt == 1000) && (paramObject != null))
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
          localAssociateItem.b = localAssociationItem.word.get().toStringUtf8();
          localAssociateItem.c = localAssociationItem.sub_word.get().toStringUtf8();
          localAssociateItem.e = localAssociationItem.pic_url.get().toStringUtf8();
          localAssociateItem.d = localAssociationItem.jmp_url.get().toStringUtf8();
          localAssociateItem.f = localAssociationItem.type.get();
          localAssociateItem.g = localAssociationItem.group_mask.get();
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
    return (StudyModeManager.h()) && ((paramLong == 1100L) || (paramLong == 1012L) || (paramLong == 1003L));
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
    //   1: invokevirtual 395	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 4
    //   6: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +36 -> 45
    //   12: new 160	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc_w 506
    //   24: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: iload 4
    //   31: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: ldc 149
    //   37: iconst_2
    //   38: aload_2
    //   39: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: ldc_w 508
    //   48: iload 4
    //   50: invokestatic 513	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   53: invokestatic 517	com/tencent/mobileqq/search/util/SearchCostStat:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc_w 519
    //   59: invokestatic 521	com/tencent/mobileqq/search/util/SearchCostStat:b	(Ljava/lang/String;)V
    //   62: aload_1
    //   63: getfield 403	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   66: ldc_w 405
    //   69: ldc_w 357
    //   72: invokevirtual 409	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 11
    //   77: aload_1
    //   78: getfield 403	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   81: ldc_w 523
    //   84: ldc_w 357
    //   87: invokevirtual 409	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 12
    //   92: aload_1
    //   93: getfield 403	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   96: ldc_w 525
    //   99: invokevirtual 529	android/os/Bundle:getLongArray	(Ljava/lang/String;)[J
    //   102: astore 14
    //   104: aload_1
    //   105: getfield 403	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   108: ldc_w 531
    //   111: invokevirtual 535	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   114: istore 6
    //   116: aload_1
    //   117: getfield 403	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   120: ldc_w 537
    //   123: invokevirtual 541	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   126: lstore 7
    //   128: iload 4
    //   130: i2l
    //   131: lstore 9
    //   133: iconst_5
    //   134: anewarray 411	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload 11
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: iload 6
    //   146: invokestatic 546	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   149: aastore
    //   150: dup
    //   151: iconst_2
    //   152: aload 12
    //   154: aastore
    //   155: dup
    //   156: iconst_3
    //   157: iconst_m1
    //   158: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: dup
    //   163: iconst_4
    //   164: ldc_w 357
    //   167: aastore
    //   168: astore_2
    //   169: aload_0
    //   170: ldc_w 548
    //   173: lload 7
    //   175: lload 9
    //   177: aload 11
    //   179: invokevirtual 380	com/tencent/mobileqq/app/UnifySearchHandler:a	(Ljava/lang/String;JJLjava/lang/String;)V
    //   182: iload 4
    //   184: sipush 1000
    //   187: if_icmpeq +13 -> 200
    //   190: aload_0
    //   191: sipush 1004
    //   194: iconst_0
    //   195: aload_2
    //   196: invokevirtual 421	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   199: return
    //   200: aload_3
    //   201: ifnonnull +13 -> 214
    //   204: aload_0
    //   205: sipush 1004
    //   208: iconst_0
    //   209: aload_2
    //   210: invokevirtual 421	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   213: return
    //   214: aload_3
    //   215: instanceof 423
    //   218: ifne +13 -> 231
    //   221: aload_0
    //   222: sipush 1004
    //   225: iconst_0
    //   226: aload_2
    //   227: invokevirtual 421	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   230: return
    //   231: new 550	pb/unify/search/UnifySearchUnite$RspBody
    //   234: dup
    //   235: invokespecial 551	pb/unify/search/UnifySearchUnite$RspBody:<init>	()V
    //   238: astore 13
    //   240: aload 13
    //   242: aload_3
    //   243: checkcast 423	[B
    //   246: checkcast 423	[B
    //   249: invokevirtual 552	pb/unify/search/UnifySearchUnite$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   252: pop
    //   253: aload 13
    //   255: getfield 553	pb/unify/search/UnifySearchUnite$RspBody:result_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 438	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: istore 4
    //   263: aload 13
    //   265: getfield 554	pb/unify/search/UnifySearchUnite$RspBody:error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   268: invokevirtual 446	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   271: astore_3
    //   272: iload 4
    //   274: ifeq +67 -> 341
    //   277: iload 4
    //   279: sipush 1000
    //   282: if_icmplt +6 -> 288
    //   285: goto +56 -> 341
    //   288: iconst_5
    //   289: anewarray 411	java/lang/Object
    //   292: astore_1
    //   293: aload_1
    //   294: iconst_0
    //   295: aload 11
    //   297: aastore
    //   298: aload_1
    //   299: iconst_1
    //   300: iload 6
    //   302: invokestatic 546	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   305: aastore
    //   306: aload_1
    //   307: iconst_2
    //   308: aload 12
    //   310: aastore
    //   311: aload_1
    //   312: iconst_3
    //   313: iload 4
    //   315: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: aload_1
    //   320: iconst_4
    //   321: aload_3
    //   322: aastore
    //   323: aload_0
    //   324: sipush 1004
    //   327: iconst_0
    //   328: aload_1
    //   329: invokevirtual 421	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   332: return
    //   333: astore_3
    //   334: aload_1
    //   335: astore_2
    //   336: aload_3
    //   337: astore_1
    //   338: goto +334 -> 672
    //   341: aload 13
    //   343: getfield 557	pb/unify/search/UnifySearchUnite$RspBody:cookie_topic	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   346: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   349: invokevirtual 561	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   352: astore_3
    //   353: aload 13
    //   355: getfield 564	pb/unify/search/UnifySearchUnite$RspBody:search_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   358: invokevirtual 567	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   361: ifeq +22 -> 383
    //   364: ldc_w 548
    //   367: aload 14
    //   369: aload 13
    //   371: getfield 564	pb/unify/search/UnifySearchUnite$RspBody:search_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   374: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   377: invokevirtual 267	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   380: invokestatic 572	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[JLjava/lang/String;)V
    //   383: aload 13
    //   385: getfield 575	pb/unify/search/UnifySearchUnite$RspBody:is_end_topic	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   388: invokevirtual 438	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   391: iconst_1
    //   392: if_icmpne +298 -> 690
    //   395: iconst_1
    //   396: istore 5
    //   398: goto +3 -> 401
    //   401: aload 13
    //   403: getfield 578	pb/unify/search/UnifySearchUnite$RspBody:tab_groups	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   406: invokevirtual 249	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   409: astore 15
    //   411: new 181	java/util/ArrayList
    //   414: dup
    //   415: aload 15
    //   417: invokeinterface 215 1 0
    //   422: invokespecial 218	java/util/ArrayList:<init>	(I)V
    //   425: astore 14
    //   427: iconst_0
    //   428: istore 4
    //   430: iload 4
    //   432: aload 15
    //   434: invokeinterface 215 1 0
    //   439: if_icmpge +39 -> 478
    //   442: aload 14
    //   444: new 580	com/tencent/mobileqq/search/model/GroupTabModel
    //   447: dup
    //   448: aload 15
    //   450: iload 4
    //   452: invokeinterface 583 2 0
    //   457: checkcast 585	pb/unify/search/UnifySearchUnite$TabItemGroup
    //   460: invokespecial 588	com/tencent/mobileqq/search/model/GroupTabModel:<init>	(Lpb/unify/search/UnifySearchUnite$TabItemGroup;)V
    //   463: invokeinterface 277 2 0
    //   468: pop
    //   469: iload 4
    //   471: iconst_1
    //   472: iadd
    //   473: istore 4
    //   475: goto -45 -> 430
    //   478: aload 13
    //   480: getfield 591	pb/unify/search/UnifySearchUnite$RspBody:trigger_netword_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   483: invokevirtual 438	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   486: istore 4
    //   488: iload 4
    //   490: iflt +11 -> 501
    //   493: invokestatic 594	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   496: iload 4
    //   498: invokestatic 600	com/tencent/mobileqq/utils/SharedPreUtils:s	(Landroid/content/Context;I)V
    //   501: aload_0
    //   502: iconst_3
    //   503: anewarray 411	java/lang/Object
    //   506: dup
    //   507: iconst_0
    //   508: aload 11
    //   510: aastore
    //   511: dup
    //   512: iconst_1
    //   513: aload 13
    //   515: getfield 603	pb/unify/search/UnifySearchUnite$RspBody:item_groups	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   518: invokevirtual 249	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   521: aastore
    //   522: dup
    //   523: iconst_2
    //   524: aload_1
    //   525: getfield 403	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   528: ldc 120
    //   530: invokevirtual 606	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   533: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   536: aastore
    //   537: invokevirtual 609	com/tencent/mobileqq/app/UnifySearchHandler:a	([Ljava/lang/Object;)Ljava/util/List;
    //   540: astore 15
    //   542: aload 13
    //   544: getfield 612	pb/unify/search/UnifySearchUnite$RspBody:exhibition_flags	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   547: invokevirtual 438	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   550: istore 4
    //   552: bipush 8
    //   554: anewarray 411	java/lang/Object
    //   557: astore_1
    //   558: aload_1
    //   559: iconst_0
    //   560: aload 11
    //   562: aastore
    //   563: aload_1
    //   564: iconst_1
    //   565: iload 6
    //   567: invokestatic 546	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   570: aastore
    //   571: aload_1
    //   572: iconst_2
    //   573: aload 12
    //   575: aastore
    //   576: aload_1
    //   577: iconst_3
    //   578: aload_3
    //   579: aastore
    //   580: aload_1
    //   581: iconst_4
    //   582: iload 5
    //   584: invokestatic 546	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   587: aastore
    //   588: aload_1
    //   589: iconst_5
    //   590: aload 14
    //   592: aastore
    //   593: aload_1
    //   594: bipush 6
    //   596: aload 15
    //   598: aastore
    //   599: aload_1
    //   600: bipush 7
    //   602: iload 4
    //   604: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   607: aastore
    //   608: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   611: ifeq +36 -> 647
    //   614: new 160	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   621: astore_2
    //   622: aload_2
    //   623: ldc_w 614
    //   626: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload_2
    //   631: iload 4
    //   633: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: ldc 149
    //   639: iconst_2
    //   640: aload_2
    //   641: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: aload_0
    //   648: sipush 1004
    //   651: iconst_1
    //   652: aload_1
    //   653: invokevirtual 421	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   656: return
    //   657: astore_2
    //   658: aload_1
    //   659: astore_3
    //   660: goto +16 -> 676
    //   663: astore_3
    //   664: aload_1
    //   665: astore_2
    //   666: aload_3
    //   667: astore_1
    //   668: goto +4 -> 672
    //   671: astore_1
    //   672: aload_2
    //   673: astore_3
    //   674: aload_1
    //   675: astore_2
    //   676: aload_0
    //   677: sipush 1004
    //   680: iconst_0
    //   681: aload_3
    //   682: invokevirtual 421	com/tencent/mobileqq/app/UnifySearchHandler:notifyUI	(IZLjava/lang/Object;)V
    //   685: aload_2
    //   686: invokevirtual 497	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   689: return
    //   690: iconst_0
    //   691: istore 5
    //   693: goto -292 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	this	UnifySearchHandler
    //   0	696	1	paramToServiceMsg	ToServiceMsg
    //   0	696	2	paramFromServiceMsg	FromServiceMsg
    //   0	696	3	paramObject	Object
    //   4	628	4	i	int
    //   396	296	5	bool1	boolean
    //   114	452	6	bool2	boolean
    //   126	48	7	l1	long
    //   131	45	9	l2	long
    //   75	486	11	str1	String
    //   90	484	12	str2	String
    //   238	305	13	localRspBody	pb.unify.search.UnifySearchUnite.RspBody
    //   102	489	14	localObject	Object
    //   409	188	15	localList	List
    // Exception table:
    //   from	to	target	type
    //   323	332	333	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   647	656	657	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   608	647	663	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   240	272	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   288	293	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   298	306	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   311	319	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   341	383	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   383	395	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   401	427	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   430	469	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   478	488	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   493	501	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   501	558	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   563	571	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   580	588	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   599	608	671	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
      boolean bool2 = SearchUtils.d(i);
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
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
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
    ((UnifySearchDiscovery.ReqBody)localObject).version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
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
    ((UnifySearchUnite.ReqBody)localObject1).version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
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
      ((UnifySearchCommon.RootSearcherRequest)localObject2).rpt_busi_mask.set(SearchUtils.b(a));
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
    Object localObject3 = SharedPreUtils.n(this.g.getCurrentAccountUin());
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
    ((UnifyTabSearch.ReqBody)localObject1).version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
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
    if (FunctionModuleConfigManager.b.isEmpty())
    {
      i = 0;
    }
    else
    {
      localObject2 = FunctionModuleConfigManager.b.values().iterator();
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
    ArrayList localArrayList2 = new ArrayList(((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList2.add(((ByteStringMicro)((Iterator)localObject2).next()).toStringUtf8());
    }
    localObject2 = ((UnifySearchCommon.ResultItemGroup)localObject1).result_items.get();
    ArrayList localArrayList1 = new ArrayList(((List)localObject2).size());
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
    long l1 = ((List)localObject2).size();
    i = 0;
    localObject1 = localObject2;
    boolean bool2;
    while (i < ((List)localObject1).size())
    {
      Object localObject3 = (UnifySearchCommon.ResultItem)((List)localObject1).get(i);
      Object localObject4 = ((UnifySearchCommon.ResultItem)localObject3).sub_result_items.get();
      int m = ((List)localObject4).size() + 1;
      localObject2 = new ArrayList(m);
      ((List)localObject2).add(localObject3);
      ((List)localObject2).addAll((Collection)localObject4);
      int k = 0;
      int j = i;
      i = m;
      for (;;)
      {
        localObject3 = paramResultItemGroup;
        if (k >= i) {
          break;
        }
        localObject4 = (UnifySearchCommon.ResultItem)((List)localObject2).get(k);
        Object localObject5 = ((UnifySearchCommon.ResultItem)localObject4).result_id.get().toStringUtf8();
        bool2 = ((UnifySearchCommon.ResultItem)localObject4).layout_id.has();
        String str4 = ((UnifySearchCommon.ResultItem)localObject4).name.get().toStringUtf8();
        long l2;
        if (((UnifySearchCommon.ResultItem)localObject4).group_mask.has()) {
          l2 = ((UnifySearchCommon.ResultItem)localObject4).group_mask.get();
        } else {
          l2 = paramLong;
        }
        String str5 = ((UnifySearchCommon.ResultItem)localObject4).pic_url.get().toStringUtf8();
        String str6 = ((UnifySearchCommon.ResultItem)localObject4).jmp_url.get().toStringUtf8();
        String str7 = ((UnifySearchCommon.ResultItem)localObject4).extension.get().toStringUtf8();
        if (bool2)
        {
          if (paramLong == 1100L)
          {
            if ((((UnifySearchCommon.ResultItemGroup)localObject3).group_extra_flag.has()) && ((((UnifySearchCommon.ResultItemGroup)localObject3).group_extra_flag.get() & 0x1) == 0)) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            localObject3 = new RichSearchModelNode(paramString, paramLong, localArrayList2, (UnifySearchCommon.ResultItem)localObject4, paramInt, str1);
            localObject5 = (RichSearchModelNode)localObject3;
            ((RichSearchModelNode)localObject5).b(((UnifySearchCommon.ResultItem)localObject4).layout_id.get());
            ((RichSearchModelNode)localObject5).c(null);
            ((RichSearchModelNode)localObject5).b(bool2);
          }
          else
          {
            localObject3 = a(((UnifySearchCommon.ResultItem)localObject4).layout_id.get(), paramString, paramLong, localArrayList2, (UnifySearchCommon.ResultItem)localObject4, paramInt);
          }
          if ((localObject3 != null) && (((NetSearchTemplateBaseItem)localObject3).i()))
          {
            ((NetSearchTemplateBaseItem)localObject3).af = ((UnifySearchCommon.ResultItem)localObject4).seporator_type.get();
            ((NetSearchTemplateBaseItem)localObject3).r = bool1;
            localArrayList1.add(localObject3);
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
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("itemGroupMask is not valid. mask=");
            ((StringBuilder)localObject3).append(l2);
            QLog.e("Q.uniteSearch.UnifySearchHandler818searchProto_new", 1, ((StringBuilder)localObject3).toString());
          }
          else if (l2 == 2073745984L)
          {
            localObject3 = new SearchResultModelForEntrance(paramString, str7, -4, str5);
            ((SearchResultModelForEntrance)localObject3).af = ((UnifySearchCommon.ResultItem)localObject4).seporator_type.get();
            localArrayList1.add(localObject3);
          }
          else
          {
            localObject3 = new GroupBaseNetSearchModelItem(paramString, (String)localObject5, str4, str5, str6, str7, l2, localArrayList2, paramInt);
            ((GroupBaseNetSearchModelItem)localObject3).af = ((UnifySearchCommon.ResultItem)localObject4).seporator_type.get();
            ((GroupBaseNetSearchModelItem)localObject3).G = bool1;
            ((GroupBaseNetSearchModelItem)localObject3).L = j;
            ((GroupBaseNetSearchModelItem)localObject3).m = paramInt;
            localArrayList1.add(localObject3);
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
      localObject2 = paramResultItemGroup.more_name.get().toStringUtf8();
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
        paramList.add(new GroupSearchModelRichNode(paramString, paramLong, str1, localArrayList1, l1, (String)localObject1, (String)localObject2, localArrayList2, bool1, bool2, bool3, str2, str3));
        return;
      }
      paramResultItemGroup = new GroupBaseNetSearchModel(paramString, paramLong, str1, localArrayList1, l1, (String)localObject1, (String)localObject2, localArrayList2, bool1, bool2, bool3, str2, str3);
      paramResultItemGroup.b(paramInt);
      paramList.add(paramResultItemGroup);
    }
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
          SharedPreUtils.b(this.g.getCurrentAccountUin(), i, paramInt);
          paramToServiceMsg = localRspBody.result_items.get();
          paramToServiceMsg = SearchEntryDataModel.b(this.g, paramToServiceMsg, i);
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
  
  public byte[] b(String paramString)
  {
    return FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath(paramString));
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
        a(i, paramObject, d, e);
        a(paramToServiceMsg, i, paramObject);
        return;
      }
      if ("UnifySearch.Discovery".equals(str)) {
        b(paramToServiceMsg, paramFromServiceMsg.getResultCode(), paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.UnifySearchHandler
 * JD-Core Version:    0.7.0.1
 */