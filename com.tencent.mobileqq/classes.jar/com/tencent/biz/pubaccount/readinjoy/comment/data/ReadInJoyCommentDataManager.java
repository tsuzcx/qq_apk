package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.comment.RIJCommentResultDispatcher;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuideHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentSinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentStickyData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.CreateCommentResult;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkWrapper;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.biz.pubaccount.readinjoy.common.RIJUtilsHelper;
import com.tencent.biz.pubaccount.readinjoy.common.RIJUtilsHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule.CommentReportInfo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import com.tencent.util.Pair;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentDataManager
  extends ReadInJoyObserver
  implements ReadInJoyCommentObserver
{
  private static final LruCache<String, Boolean> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  private static Map<String, ReadInJoyCommentDataManager> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  protected CommonCommentData a;
  private ReadInJoyCommentDataManager.CommentAnchor jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor;
  private ReadInJoyCommentPBModule.Label jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label = new ReadInJoyCommentPBModule.Label();
  private ReadInJoyCommentPBModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule = null;
  private ReadInJoyCommentSSOModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule = null;
  private GuideHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper = new GuideHelper();
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private LongSparseArray<Pair<String, BaseCommentData>> jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
  protected String a;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "";
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private Map<String, BaseCommentData> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString = "";
  private List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString = "";
  private List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString = "";
  private List<ReadInJoyCommentDataManager.OnDataChangeListener> jdField_e_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_e_of_type_Boolean = false;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString = "";
  private boolean jdField_h_of_type_Boolean;
  private String i = "";
  
  private ReadInJoyCommentDataManager(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramString = RIJUtilsHelper.a.a();
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule = paramString.a().a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule.a(this);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule = new ReadInJoyCommentSSOModule();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule.a(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper);
    r();
  }
  
  private int a(BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {}
    do
    {
      return 0;
      if (paramBaseCommentData.isActivity()) {
        return 4;
      }
      if (paramBaseCommentData.isBanner()) {
        return 5;
      }
    } while (!paramBaseCommentData.isDynamicComment());
    return 7;
  }
  
  public static ReadInJoyCommentDataManager a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    return (ReadInJoyCommentDataManager)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
  }
  
  public static ReadInJoyCommentDataManager a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      localObject = null;
    }
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager;
    do
    {
      return localObject;
      localReadInJoyCommentDataManager = (ReadInJoyCommentDataManager)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
      localObject = localReadInJoyCommentDataManager;
    } while (localReadInJoyCommentDataManager != null);
    Object localObject = new ReadInJoyCommentDataManager(paramArticleInfo.innerUniqueID);
    ((ReadInJoyCommentDataManager)localObject).b(paramArticleInfo);
    ((ReadInJoyCommentDataManager)localObject).jdField_a_of_type_Int = paramInt;
    if ((paramInt == 1) || (paramInt == 10))
    {
      ((ReadInJoyCommentDataManager)localObject).jdField_a_of_type_JavaLangString = (paramArticleInfo.mArticleID + "");
      ((ReadInJoyCommentDataManager)localObject).jdField_g_of_type_JavaLangString = (paramArticleInfo.mArticleID + "");
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilMap.put(paramArticleInfo.innerUniqueID, localObject);
      ((ReadInJoyCommentDataManager)localObject).jdField_h_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "create commentDataManager, articleInfo : ", paramArticleInfo, ", src : ", Integer.valueOf(paramInt) });
      return localObject;
      ((ReadInJoyCommentDataManager)localObject).jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
      ((ReadInJoyCommentDataManager)localObject).jdField_h_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    }
  }
  
  private Pair<Integer, Integer> a()
  {
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    k -= 1;
    BaseCommentData localBaseCommentData;
    while (k >= 0)
    {
      localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(k));
      if ((localBaseCommentData == null) || (!localBaseCommentData.isAuthorBottom)) {
        break;
      }
      k -= 1;
      j += 1;
    }
    int m = b();
    k = m;
    while (k <= this.jdField_a_of_type_JavaUtilList.size() - 1 - j)
    {
      localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(k));
      if ((localBaseCommentData == null) || (!localBaseCommentData.isAuthorSticky)) {
        break;
      }
      m += 1;
      k += 1;
    }
    return new Pair(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - m - j), Integer.valueOf(j));
  }
  
  private List<CommentViewItem> a(int paramInt, List<BaseCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramList.next();
      localArrayList.add(new CommentViewItem(paramInt, a(localBaseCommentData), localBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    }
    return localArrayList;
  }
  
  private List<CommentViewItem> a(boolean paramBoolean, BaseCommentData paramBaseCommentData, List<SubCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new CommentViewItem(0, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localArrayList.add(new CommentViewItem(3, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramBaseCommentData = paramList.iterator();
      if (paramBaseCommentData.hasNext())
      {
        paramList = (SubCommentData)paramBaseCommentData.next();
        if (paramList.isActivity()) {}
        for (int j = 4;; j = 0)
        {
          localArrayList.add(new CommentViewItem(j, paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ReadInJoyCommentDataManager.13(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch sub commentList, id : ", paramString1, ", fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_c_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
  }
  
  private void a(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof CommentData)) {
      return;
    }
    int j = ((CommentData)paramBaseCommentData).subCommentNum;
    a((CommentData)paramBaseCommentData, -(j + 1));
    g(paramBaseCommentData.commentId);
  }
  
  private void a(CommentData paramCommentData, int paramInt)
  {
    if (paramCommentData == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramCommentData.commentId)))
      {
        this.jdField_c_of_type_Long += paramInt;
        QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | mHotCommentCnt " + this.jdField_c_of_type_Long);
      }
      this.jdField_b_of_type_Long += paramInt;
      QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | totalCommentCnt " + this.jdField_b_of_type_Long);
    } while ((this.jdField_d_of_type_JavaUtilList == null) || (!this.jdField_d_of_type_JavaUtilList.contains(paramCommentData.commentId)));
    this.jdField_d_of_type_Long += paramInt;
    QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | mFamilyCommentCnt " + this.jdField_d_of_type_Long);
  }
  
  private void a(ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob)
  {
    a(paramCallbackActionJob, true);
  }
  
  private void a(ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob, boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_JavaUtilList.isEmpty()) && (paramCallbackActionJob != null)) {
      a(this.jdField_e_of_type_JavaUtilList, paramBoolean, paramCallbackActionJob);
    }
    ArrayList localArrayList = new ArrayList();
    if (RIJCommentResultDispatcher.a().a() != null) {
      localArrayList.addAll(RIJCommentResultDispatcher.a().a());
    }
    if ((localArrayList != null) && (paramCallbackActionJob != null)) {
      a(localArrayList, paramBoolean, paramCallbackActionJob);
    }
  }
  
  private void a(CreateCommentResult paramCreateCommentResult)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onCreateCommentResult | create comment resp, seq ", Long.valueOf(paramCreateCommentResult.jdField_a_of_type_Long), " succ : ", Boolean.valueOf(paramCreateCommentResult.jdField_a_of_type_Boolean), " data : ", paramCreateCommentResult.jdField_a_of_type_JavaLangString });
    int j = paramCreateCommentResult.jdField_c_of_type_Int;
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    Pair localPair = (Pair)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramCreateCommentResult.jdField_a_of_type_Long);
    if (localPair == null) {
      QLog.d("ReadInJoyCommentDataManager", 1, "onCreateCommentResult | fake comment data not exist, return !");
    }
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = (BaseCommentData)localPair.second;
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.b(paramCreateCommentResult.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(paramCreateCommentResult.jdField_c_of_type_JavaLangString)) {
        localBaseCommentData.commentContent = paramCreateCommentResult.jdField_c_of_type_JavaLangString;
      }
      localBaseCommentData.shareUrl = paramCreateCommentResult.jdField_d_of_type_JavaLangString;
      if (paramCreateCommentResult.jdField_a_of_type_Boolean)
      {
        localBaseCommentData.commentRptDataList = paramCreateCommentResult.jdField_a_of_type_JavaUtilList;
        ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (String)localPair.first);
        a(localBaseCommentData, paramCreateCommentResult.jdField_a_of_type_JavaLangString, j);
        return;
      }
      if ((localBaseCommentData instanceof CommentData))
      {
        a(new ReadInJoyCommentDataManager.33(this, paramCreateCommentResult));
        return;
      }
    } while (!(localBaseCommentData instanceof SubCommentData));
    a(new ReadInJoyCommentDataManager.34(this));
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return;
      paramArticleInfo = (ReadInJoyCommentDataManager)jdField_a_of_type_JavaUtilMap.remove(paramArticleInfo.innerUniqueID);
    } while (paramArticleInfo == null);
    paramArticleInfo.d();
    QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager | destroy");
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (paramInt == 6)
    {
      paramArticleInfo = (ReadInJoyCommentDataManager)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
      if (paramArticleInfo != null) {
        paramArticleInfo.u();
      }
      QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager feedsType " + paramInt);
      return;
    }
    a(paramArticleInfo);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBoolean)) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(b(paramString), Boolean.TRUE);
    }
  }
  
  private void a(List<ReadInJoyCommentDataManager.OnDataChangeListener> paramList, boolean paramBoolean, ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob)
  {
    int j = 0;
    if (j < paramList.size())
    {
      ReadInJoyCommentDataManager.OnDataChangeListener localOnDataChangeListener = (ReadInJoyCommentDataManager.OnDataChangeListener)paramList.get(j);
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.36(this, paramCallbackActionJob, localOnDataChangeListener));
      }
      for (;;)
      {
        j += 1;
        break;
        paramCallbackActionJob.a(localOnDataChangeListener);
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131718574), 0).a();
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    if (paramBoolean2) {
      if (TextUtils.isEmpty(paramString)) {}
    }
    for (;;)
    {
      QQToast.a(localBaseApplication, 1, paramString, 0).a();
      return;
      paramString = HardCodeUtil.a(2131718573);
      continue;
      paramString = HardCodeUtil.a(2131718572);
    }
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (jdField_a_of_type_AndroidSupportV4UtilLruCache.get(b(paramString)) != null);
  }
  
  private boolean a(List<CommentData> paramList)
  {
    if ((paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CommentData localCommentData = (CommentData)paramList.next();
      if ((localCommentData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString.equals(localCommentData.commentId)))
      {
        localCommentData.isAnchor = true;
        return true;
      }
    }
    return false;
  }
  
  private int b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int j = 0;
      for (;;)
      {
        k = j;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject = (String)localIterator.next();
        localObject = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        k = j;
        if (localObject == null) {
          break;
        }
        k = j;
        if (!((BaseCommentData)localObject).isBanner) {
          break;
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  private static String b(String paramString)
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount() + '_' + paramString;
  }
  
  private List<CommentViewItem> b(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!TextUtils.isEmpty(str)) && (this.jdField_b_of_type_JavaUtilMap.get(str) != null)) {
        localArrayList.add(new CommentViewItem(paramInt, a((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str)), (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
    }
    return localArrayList;
  }
  
  private void b(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof SubCommentData)) {}
    CommentData localCommentData;
    do
    {
      return;
      localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)paramBaseCommentData).parentCommentId);
    } while (localCommentData == null);
    if (localCommentData.subCommentNum > 0) {
      localCommentData.subCommentNum -= 1;
    }
    List localList = localCommentData.subCommentList;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        SubCommentData localSubCommentData = (SubCommentData)localIterator.next();
        if (localSubCommentData.commentId.equalsIgnoreCase(paramBaseCommentData.commentId)) {
          localList.remove(localSubCommentData);
        }
      }
    }
    a(localCommentData, -1);
    this.jdField_c_of_type_JavaUtilList.remove(paramBaseCommentData.commentId);
  }
  
  private void b(CreateCommentResult paramCreateCommentResult)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.37(this, paramCreateCommentResult));
    }
  }
  
  private void c(List<CommentData> paramList1, List<CommentData> paramList2)
  {
    if (this.jdField_b_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          CommentData localCommentData = (CommentData)paramList1.next();
          if (localCommentData != null)
          {
            this.jdField_b_of_type_JavaUtilMap.put(localCommentData.commentId, localCommentData);
            if (this.jdField_a_of_type_JavaUtilList != null) {
              this.jdField_a_of_type_JavaUtilList.add(localCommentData.commentId);
            }
          }
        }
      }
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (CommentData)paramList1.next();
          if (paramList2 != null)
          {
            if (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramList2.commentId)) {
              this.jdField_b_of_type_JavaUtilMap.put(paramList2.commentId, paramList2);
            }
            if (this.jdField_b_of_type_JavaUtilList != null) {
              this.jdField_b_of_type_JavaUtilList.add(paramList2.commentId);
            }
          }
        }
      }
    }
  }
  
  private void d(List<CommentData> paramList, List<String> paramList1)
  {
    if (this.jdField_b_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          CommentData localCommentData = (CommentData)paramList.next();
          if (localCommentData != null)
          {
            this.jdField_b_of_type_JavaUtilMap.put(localCommentData.commentId, localCommentData);
            if (paramList1 != null) {
              paramList1.add(localCommentData.commentId);
            }
          }
        }
      }
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131713003), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131699711), 0).a();
  }
  
  private void g(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramString);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.remove(paramString);
    }
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.remove(paramString);
    }
    v();
  }
  
  public static void h()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private void j(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ReadInJoyCommentDataManager.8(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch NewCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_d_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (Object localObject1 = "";; localObject1 = this.jdField_d_of_type_JavaLangString)
    {
      this.jdField_d_of_type_JavaLangString = ((String)localObject1);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.9(this, (String)localObject1));
      return;
    }
  }
  
  private void k(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ReadInJoyCommentDataManager.10(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch HotCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_e_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (Object localObject1 = "";; localObject1 = this.jdField_e_of_type_JavaLangString)
    {
      this.jdField_e_of_type_JavaLangString = ((String)localObject1);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.11(this, (String)localObject1));
      return;
    }
  }
  
  private void l(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ReadInJoyCommentDataManager.12(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetchFamilyCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_f_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (String str = "";; str = this.jdField_f_of_type_JavaLangString)
    {
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_f_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      return;
    }
  }
  
  private void r()
  {
    ReadInJoyUserInfoModule.a(ReadInJoyUtils.a(), null);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void t()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void u()
  {
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void v()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((BaseCommentData)localIterator.next()).isComment());
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        w();
      }
      return;
    }
  }
  
  private void w()
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @VisibleForTesting
  int a(@NonNull RIJCommentReportModule.CommentReportInfo paramCommentReportInfo)
  {
    paramCommentReportInfo = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramCommentReportInfo.b());
    if (paramCommentReportInfo != null)
    {
      a(paramCommentReportInfo, -(paramCommentReportInfo.subCommentNum + 1));
      g(paramCommentReportInfo.commentId);
    }
    return 1;
  }
  
  public int a(String paramString)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localBaseCommentData == null) {
      return 0;
    }
    if ((localBaseCommentData instanceof CommentData))
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        return 1;
      }
      if (this.jdField_b_of_type_JavaUtilList.contains(paramString)) {
        return 2;
      }
    }
    else if ((localBaseCommentData instanceof SubCommentData))
    {
      return a(((SubCommentData)localBaseCommentData).parentCommentId);
    }
    return 0;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long a(int paramInt)
  {
    long l = this.jdField_b_of_type_Long;
    if (paramInt == 6) {
      l = this.jdField_d_of_type_Long;
    }
    QLog.d("ReadInJoyCommentDataManager", 2, "getFirstCommentTotalCount | feedsType " + paramInt + "; totalCount " + l);
    return l;
  }
  
  public long a(String paramString)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && ((paramString instanceof CommentData))) {
      return ((CommentData)paramString).subCommentNum;
    }
    return 0L;
  }
  
  public BaseCommentData a(int paramInt, String paramString)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = new CommentData();
      ((BaseCommentData)localObject1).level = paramInt;
      ((BaseCommentData)localObject1).anonymous = 0;
      ((BaseCommentData)localObject1).authorSelection = 0;
      ((BaseCommentData)localObject1).awesome = 0;
      ((BaseCommentData)localObject1).uin = ReadInJoyUtils.a();
      ((BaseCommentData)localObject1).homepage = RIJJumpUtils.a(((BaseCommentData)localObject1).uin);
      ((BaseCommentData)localObject1).myself = 1;
      ((BaseCommentData)localObject1).like = 0;
      ((BaseCommentData)localObject1).disLike = 0;
      ((BaseCommentData)localObject1).likeCnt = 0;
      ((BaseCommentData)localObject1).rank = 0;
      ((BaseCommentData)localObject1).rowKey = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      ((BaseCommentData)localObject1).contentSrc = this.jdField_a_of_type_Int;
      ((BaseCommentData)localObject1).authorComment = "";
      ((BaseCommentData)localObject1).commentTime = NetConnInfoCenter.getServerTime();
      localObject3 = ReadInJoyUserInfoModule.a(Long.parseLong(((BaseCommentData)localObject1).uin), null);
      if (localObject3 == null) {
        break label385;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).nick;
      label133:
      ((BaseCommentData)localObject1).nickName = ((String)localObject2);
      if (localObject3 == null) {
        break label393;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).faceUrl;
      label151:
      ((BaseCommentData)localObject1).avatar = ((String)localObject2);
    }
    label385:
    label393:
    label428:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        RIJCommentTopicUtil.a(paramString, (BaseCommentData)localObject1);
        localObject2 = paramString.optJSONArray("linkList");
        if (localObject2 != null)
        {
          localObject3 = new ReadInJoyCommentDataManager.35(this).getType();
          ((BaseCommentData)localObject1).commentLinkDataList = ((List)new Gson().fromJson(((JSONArray)localObject2).toString(), (Type)localObject3));
        }
        BaseCommentData localBaseCommentData;
        if (paramInt == 2)
        {
          localObject2 = (SubCommentData)localObject1;
          localObject3 = paramString.getString("commentId");
          localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject3);
          if (!(localBaseCommentData instanceof SubCommentData)) {
            continue;
          }
          ((SubCommentData)localObject2).parentCommentId = ((SubCommentData)localBaseCommentData).parentCommentId;
          if (paramString.optBoolean("isSecondReply", false))
          {
            ((SubCommentData)localObject2).repliedCommentId = ((String)localObject3);
            localObject3 = paramString.optString("replyUin");
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              ((SubCommentData)localObject2).repliedUserUin = ((String)localObject3);
              paramString = ReadInJoyUserInfoModule.a(Long.valueOf((String)localObject3).longValue(), null);
              if (paramString == null) {
                break label428;
              }
              paramString = paramString.nick;
              ((SubCommentData)localObject2).repliedUserNickname = paramString;
              ((SubCommentData)localObject2).repliedUserHomePage = RIJJumpUtils.a((String)localObject3);
              ((SubCommentData)localObject2).hasTarget = 1;
            }
          }
        }
        return localObject1;
        if (paramInt == 2)
        {
          localObject1 = new SubCommentData();
          break;
        }
        return null;
        localObject2 = ReadInJoyUserInfoModule.a();
        break label133;
        localObject2 = "";
        break label151;
        if ((localBaseCommentData instanceof CommentData))
        {
          ((SubCommentData)localObject2).parentCommentId = localBaseCommentData.commentId;
          continue;
          paramString = ReadInJoyUserInfoModule.a();
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
  }
  
  public BaseCommentData a(String paramString)
  {
    return (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
  }
  
  public CommonCommentData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  }
  
  public ReadInJoyCommentDataManager.CommentAnchor a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor;
  }
  
  public ReadInJoyCommentPBModule.Label a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label;
  }
  
  public GuideHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper;
  }
  
  @VisibleForTesting
  Pair<List<BaseCommentData>, List<BaseCommentData>> a(BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {}
    String str;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return null;
      str = paramBaseCommentData.uin;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      if ((paramBaseCommentData instanceof CommentData))
      {
        localArrayList1.add(paramBaseCommentData);
        a(paramBaseCommentData);
        return new Pair(localArrayList1, localArrayList2);
      }
    } while (!(paramBaseCommentData instanceof SubCommentData));
    localArrayList2.add(paramBaseCommentData);
    b(paramBaseCommentData);
    return new Pair(localArrayList1, localArrayList2);
    paramBaseCommentData = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    while (paramBaseCommentData.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramBaseCommentData.next();
      if ((localBaseCommentData != null) && (str.equals(localBaseCommentData.uin))) {
        if ((localBaseCommentData instanceof CommentData)) {
          localArrayList1.add(localBaseCommentData);
        } else if ((localBaseCommentData instanceof SubCommentData)) {
          localArrayList2.add(localBaseCommentData);
        }
      }
    }
    paramBaseCommentData = localArrayList1.iterator();
    while (paramBaseCommentData.hasNext()) {
      a((BaseCommentData)paramBaseCommentData.next());
    }
    paramBaseCommentData = localArrayList2.iterator();
    while (paramBaseCommentData.hasNext()) {
      b((BaseCommentData)paramBaseCommentData.next());
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  public String a()
  {
    return this.i;
  }
  
  public String a(String paramString)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if ((paramString instanceof SubCommentData)) {
      return ((SubCommentData)paramString).parentCommentId;
    }
    if ((paramString instanceof CommentData)) {
      return paramString.commentId;
    }
    return "";
  }
  
  public List<CommentViewItem> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(j));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ReadInJoyCommentHelper.a())))) {
          localArrayList2.add(localCommentData);
        }
        j += 1;
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new CommentViewItem(1, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
      localArrayList1.addAll(a(1, new ArrayList(localArrayList2)));
    }
    if ("getTotalHotCommentList " + localArrayList1 != null) {}
    for (int j = localArrayList1.size();; j = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(j) });
      return localArrayList1;
    }
  }
  
  public List<CommentViewItem> a(int paramInt)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "getCurrentFeedsTypeItemList | feedsType " + paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return new ArrayList();
    case 3: 
      return a();
    case 2: 
      return b();
    }
    return c();
  }
  
  public List<CommentViewItem> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new CommentViewItem(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new CommentViewItem(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    a(new ReadInJoyCommentDataManager.38(this, paramInt));
  }
  
  public void a(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo1, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo2, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo)
  {
    boolean bool1;
    boolean bool2;
    Object localObject;
    long l;
    label105:
    int j;
    if (paramInt == 0)
    {
      bool1 = true;
      bool2 = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
      localObject = paramResponseCommentInfo1;
      if (paramResponseCommentInfo1 == null) {
        localObject = new ReadInJoyCommentPBModule.ResponseCommentInfo();
      }
      paramResponseCommentInfo1 = paramResponseCommentInfo2;
      if (paramResponseCommentInfo2 == null) {
        paramResponseCommentInfo1 = new ReadInJoyCommentPBModule.ResponseCommentInfo();
      }
      paramResponseCommentInfo2 = paramResponseExtraInfo;
      if (paramResponseExtraInfo == null) {
        paramResponseCommentInfo2 = new ReadInJoyCommentPBModule.ResponseExtraInfo();
      }
      if (bool1)
      {
        this.jdField_c_of_type_Boolean = paramResponseCommentInfo1.jdField_a_of_type_Boolean;
        this.jdField_d_of_type_Boolean = ((ReadInJoyCommentPBModule.ResponseCommentInfo)localObject).jdField_a_of_type_Boolean;
        if (((ReadInJoyCommentPBModule.ResponseCommentInfo)localObject).jdField_a_of_type_JavaUtilList == null) {
          break label511;
        }
        l = ((ReadInJoyCommentPBModule.ResponseCommentInfo)localObject).jdField_a_of_type_JavaUtilList.size();
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_JavaLangString = paramResponseCommentInfo1.jdField_a_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = ((ReadInJoyCommentPBModule.ResponseCommentInfo)localObject).jdField_a_of_type_JavaLangString;
        a(this.jdField_h_of_type_JavaLangString, paramResponseCommentInfo2.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label = paramResponseCommentInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label;
        this.jdField_h_of_type_Boolean = paramResponseCommentInfo2.jdField_b_of_type_Boolean;
        this.i = paramResponseCommentInfo2.jdField_b_of_type_JavaLangString;
        c(((ReadInJoyCommentPBModule.ResponseCommentInfo)localObject).jdField_a_of_type_JavaUtilList, paramResponseCommentInfo1.jdField_a_of_type_JavaUtilList);
      }
      if (!bool2) {
        break label538;
      }
      if (paramResponseCommentInfo2.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramResponseCommentInfo2.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_Long = paramResponseCommentInfo2.jdField_b_of_type_Long;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_b_of_type_Boolean))
      {
        if (!a(((ReadInJoyCommentPBModule.ResponseCommentInfo)localObject).jdField_a_of_type_JavaUtilList)) {
          a(new ReadInJoyCommentDataManager.19(this));
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_b_of_type_Boolean = false;
      }
      paramInt = 3;
      List localList = a(3);
      if (localList != null)
      {
        paramResponseExtraInfo = localList;
        if (!localList.isEmpty()) {}
      }
      else
      {
        paramInt = 2;
        paramResponseExtraInfo = a(2);
      }
      if (paramInt != 3) {
        break label517;
      }
      bool2 = this.jdField_d_of_type_Boolean;
      label303:
      if (!((ReadInJoyCommentPBModule.ResponseCommentInfo)localObject).a()) {
        break label526;
      }
      j = ((ReadInJoyCommentPBModule.ResponseCommentInfo)localObject).jdField_a_of_type_JavaUtilList.size();
      label323:
      localObject = new StringBuilder().append(", new size : ");
      if (!paramResponseCommentInfo1.a()) {
        break label532;
      }
    }
    label517:
    label526:
    label532:
    for (int k = paramResponseCommentInfo1.jdField_a_of_type_JavaUtilList.size();; k = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(j), k, ", totalCnt : ", this.jdField_b_of_type_Long + " , hideCnt : " + this.jdField_a_of_type_Long });
      a(new ReadInJoyCommentDataManager.20(this, bool1, paramResponseExtraInfo, bool2, paramInt));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.a(false);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper.a(paramResponseCommentInfo2.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper.a(paramResponseCommentInfo2.jdField_a_of_type_JavaLangString);
      return;
      bool1 = false;
      break;
      label511:
      l = 0L;
      break label105;
      bool2 = this.jdField_c_of_type_Boolean;
      break label303;
      j = 0;
      break label323;
    }
    label538:
    if (paramResponseCommentInfo1 != null) {}
    for (paramResponseCommentInfo1 = a(2, new ArrayList(paramResponseCommentInfo1.jdField_a_of_type_JavaUtilList));; paramResponseCommentInfo1 = new ArrayList())
    {
      bool2 = this.jdField_a_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo1.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ReadInJoyCommentDataManager.21(this, bool1, paramResponseCommentInfo1));
      return;
    }
  }
  
  public void a(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString);
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_c_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      this.jdField_d_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      c(null, paramCommentData.jdField_a_of_type_JavaUtilList);
      bool1 = true;
      if (!bool2) {
        break label227;
      }
      if (paramResponseCommentInfo.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramResponseCommentInfo.jdField_a_of_type_Long;
      }
      paramResponseCommentInfo = b();
      paramResponseExtraInfo = new StringBuilder().append(", new size : ");
      if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
        break label222;
      }
    }
    label222:
    for (paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadNewCommentFinish, ret : ", Boolean.valueOf(bool1), paramInt, ", totalCnt : ", Long.valueOf(this.jdField_b_of_type_Long) });
      a(new ReadInJoyCommentDataManager.22(this, bool1, paramResponseCommentInfo));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.a(false);
      }
      return;
      bool1 = false;
      break;
    }
    label227:
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramResponseCommentInfo = a(2, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramResponseCommentInfo = new ArrayList())
    {
      bool2 = this.jdField_c_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreNewComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ReadInJoyCommentDataManager.23(this, bool1, paramResponseCommentInfo, bool2));
      return;
    }
  }
  
  public void a(int paramInt, String paramString, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo)
  {
    boolean bool2 = true;
    boolean bool3 = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
    ReadInJoyCommentPBModule.ResponseCommentInfo localResponseCommentInfo = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      localResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    if (paramResponseExtraInfo == null) {
      new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = localResponseCommentInfo.jdField_a_of_type_Boolean;
      this.jdField_c_of_type_JavaLangString = localResponseCommentInfo.jdField_a_of_type_JavaLangString;
      if (localResponseCommentInfo.jdField_b_of_type_JavaUtilList == null) {
        break label378;
      }
      paramResponseCommentInfo = localResponseCommentInfo.jdField_b_of_type_JavaUtilList.iterator();
      while (paramResponseCommentInfo.hasNext())
      {
        paramResponseExtraInfo = (SubCommentData)paramResponseCommentInfo.next();
        if (paramResponseExtraInfo != null)
        {
          if (TextUtils.isEmpty(paramResponseExtraInfo.parentCommentId)) {
            paramResponseExtraInfo.parentCommentId = paramString;
          }
          this.jdField_b_of_type_JavaUtilMap.put(paramResponseExtraInfo.commentId, paramResponseExtraInfo);
          this.jdField_c_of_type_JavaUtilList.add(paramResponseExtraInfo.commentId);
        }
      }
      paramResponseExtraInfo = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (!this.jdField_g_of_type_Boolean)
      {
        paramResponseCommentInfo = paramResponseExtraInfo;
        if (paramResponseExtraInfo != null) {}
      }
      else
      {
        paramResponseCommentInfo = localResponseCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData;
        this.jdField_b_of_type_JavaUtilMap.put(paramString, paramResponseCommentInfo);
      }
      paramResponseCommentInfo = a(bool3, paramResponseCommentInfo, localResponseCommentInfo.jdField_b_of_type_JavaUtilList);
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (localResponseCommentInfo.jdField_b_of_type_JavaUtilList == null) {
          break label367;
        }
        paramInt = localResponseCommentInfo.jdField_b_of_type_JavaUtilList.size();
        label248:
        if ((localResponseCommentInfo == null) || (!localResponseCommentInfo.jdField_a_of_type_Boolean)) {
          break label372;
        }
      }
      for (;;)
      {
        QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "getSubCommentListResp ret : ", Boolean.valueOf(bool1), ", mainCommentID : ", paramString, ", size : ", Integer.valueOf(paramInt), ", hasNext : ", Boolean.valueOf(bool2), ", isFirstFetch : ", Boolean.valueOf(bool3) });
        a(new ReadInJoyCommentDataManager.30(this, bool3, bool1, paramResponseCommentInfo));
        return;
        paramResponseCommentInfo = null;
        bool1 = false;
        break;
        label367:
        paramInt = 0;
        break label248;
        label372:
        bool2 = false;
      }
      label378:
      paramResponseCommentInfo = null;
      bool1 = true;
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    paramBaseCommentData.commentId = paramString;
    this.jdField_b_of_type_JavaUtilMap.put(paramBaseCommentData.commentId, paramBaseCommentData);
    label103:
    boolean bool;
    label154:
    int j;
    if ((paramBaseCommentData instanceof CommentData)) {
      if (paramInt == 6)
      {
        if (this.jdField_d_of_type_JavaUtilList == null) {
          this.jdField_d_of_type_JavaUtilList = new ArrayList();
        }
        if (this.jdField_d_of_type_JavaUtilList.size() == 0)
        {
          this.jdField_d_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          if (this.jdField_b_of_type_JavaUtilList.size() != 0) {
            break label342;
          }
          this.jdField_b_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.contains(paramBaseCommentData.commentId))) {
            this.jdField_a_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          }
          if ((paramInt != 3) && (paramInt != 6)) {
            break label440;
          }
          bool = true;
          a((CommentData)paramBaseCommentData, 1);
          if (paramInt != 6) {
            break label446;
          }
          j = 4;
          label172:
          QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | createComment feedsType " + j);
          a(new ReadInJoyCommentDataManager.39(this, new CommentViewItem(j, 0, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), bool, paramInt));
        }
      }
    }
    label342:
    do
    {
      do
      {
        return;
        paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_d_of_type_JavaUtilList.get(0));
        if ((paramString != null) && (paramString.isBanner())) {
          if (this.jdField_d_of_type_JavaUtilList.size() < 2) {
            this.jdField_d_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          }
        }
        for (;;)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | familyCommentFeeds");
          break;
          this.jdField_d_of_type_JavaUtilList.add(1, paramBaseCommentData.commentId);
          continue;
          this.jdField_d_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
        }
        paramInt = 2;
        break;
        paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaUtilList.get(0));
        if ((paramString != null) && (paramString.isBanner()))
        {
          if (this.jdField_b_of_type_JavaUtilList.size() < 2)
          {
            this.jdField_b_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
            break label103;
          }
          this.jdField_b_of_type_JavaUtilList.add(1, paramBaseCommentData.commentId);
          break label103;
        }
        this.jdField_b_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
        break label103;
        bool = false;
        break label154;
        j = 2;
        break label172;
      } while (!(paramBaseCommentData instanceof SubCommentData));
      this.jdField_c_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "add new sub comment, now size : ", Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
      paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)paramBaseCommentData).parentCommentId);
      paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)paramBaseCommentData).parentCommentId);
    } while (paramString == null);
    label440:
    label446:
    paramString.subCommentNum += 1;
    a(paramString, 1);
    a(new ReadInJoyCommentDataManager.40(this, paramBaseCommentData));
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {}
    do
    {
      do
      {
        return;
        paramCommentViewItem = paramCommentViewItem.a;
      } while (paramCommentViewItem == null);
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.remove(paramCommentViewItem);
      }
      paramCommentViewItem = paramCommentViewItem.commentId;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramCommentViewItem)))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramCommentViewItem);
        a(new ReadInJoyCommentDataManager.1(this));
      }
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.contains(paramCommentViewItem)))
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramCommentViewItem);
        a(new ReadInJoyCommentDataManager.2(this));
      }
    } while ((this.jdField_d_of_type_JavaUtilList == null) || (!this.jdField_d_of_type_JavaUtilList.contains(paramCommentViewItem)));
    this.jdField_d_of_type_JavaUtilList.remove(paramCommentViewItem);
    a(new ReadInJoyCommentDataManager.3(this));
  }
  
  public void a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule == null) || (paramCommentViewItem == null) || (paramCommentViewItem.a == null)) {
      return;
    }
    BaseCommentData localBaseCommentData = paramCommentViewItem.a;
    if ((localBaseCommentData instanceof CommentData))
    {
      int j = ((CommentData)localBaseCommentData).subCommentNum;
      a((CommentData)localBaseCommentData, -(j + 1));
      g(localBaseCommentData.commentId);
    }
    if ((localBaseCommentData instanceof SubCommentData))
    {
      CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)localBaseCommentData).parentCommentId);
      if (localCommentData != null)
      {
        if (localCommentData.subCommentNum > 0) {
          localCommentData.subCommentNum -= 1;
        }
        List localList = localCommentData.subCommentList;
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            SubCommentData localSubCommentData = (SubCommentData)localIterator.next();
            if (localSubCommentData.commentId.equalsIgnoreCase(localBaseCommentData.commentId)) {
              localList.remove(localSubCommentData);
            }
          }
        }
      }
      a(localCommentData, -1);
      this.jdField_c_of_type_JavaUtilList.remove(localBaseCommentData.commentId);
    }
    a(new ReadInJoyCommentDataManager.14(this, localBaseCommentData.getCommentLevel(), paramCommentViewItem, paramInt), false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(ReadInJoyCommentDataManager.CommentAnchor paramCommentAnchor)
  {
    if ("setCommentAnchor | commentid : " + paramCommentAnchor != null) {}
    for (String str = paramCommentAnchor.jdField_a_of_type_JavaLangString;; str = "")
    {
      QLog.d("ReadInJoyCommentDataManager", 1, str);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor = paramCommentAnchor;
      return;
    }
  }
  
  /* Error */
  public void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 106	com/tencent/biz/pubaccount/readinjoy/comment/data/ReadInJoyCommentDataManager:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 348 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 106	com/tencent/biz/pubaccount/readinjoy/comment/data/ReadInJoyCommentDataManager:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   24: aload_1
    //   25: invokeinterface 300 2 0
    //   30: pop
    //   31: goto -14 -> 17
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	ReadInJoyCommentDataManager
    //   0	39	1	paramOnDataChangeListener	ReadInJoyCommentDataManager.OnDataChangeListener
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	34	finally
    //   20	31	34	finally
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.disLike = paramInt;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule.a(paramString, 1, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "onSinkCommentResult: id[" + paramString + "] opType[" + paramInt + "] success[" + paramBoolean1 + "] overtimes[" + paramBoolean2 + "]");
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    }
    while (paramBoolean1)
    {
      Object localObject = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (localObject == null)
      {
        return;
        bool = false;
      }
      else
      {
        ((BaseCommentData)localObject).isAuthorSticky = false;
        ((BaseCommentData)localObject).isAuthorBottom = bool;
        if (bool)
        {
          if (this.jdField_d_of_type_Boolean) {
            this.jdField_b_of_type_JavaUtilMap.remove(paramString);
          }
          for (;;)
          {
            paramInt = 2131718584;
            a(new ReadInJoyCommentDataManager.41(this, a()));
            QQToast.a(BaseApplicationImpl.context, 2, HardCodeUtil.a(paramInt), 0).a();
            return;
            this.jdField_a_of_type_JavaUtilList.remove(paramString);
            this.jdField_a_of_type_JavaUtilList.add(paramString);
          }
        }
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
        localObject = a();
        paramInt = ((Integer)((Pair)localObject).first).intValue();
        int j = ((Integer)((Pair)localObject).second).intValue();
        if (paramInt >= 10) {
          this.jdField_a_of_type_JavaUtilList.add(9, paramString);
        }
        for (;;)
        {
          paramInt = 2131718595;
          break;
          if (paramInt >= 2) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size() - j - 1, paramString);
          } else if (j > 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size() - j, paramString);
          } else {
            this.jdField_a_of_type_JavaUtilList.add(paramString);
          }
        }
      }
    }
    if (bool) {
      if (paramBoolean2) {
        paramInt = 2131718583;
      }
    }
    for (;;)
    {
      QQToast.a(BaseApplicationImpl.context, HardCodeUtil.a(paramInt), 0).a();
      return;
      paramInt = 2131718582;
      continue;
      paramInt = 2131718594;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    f();
    a(1, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
    RIJCommentReportModule.CommentReportInfo localCommentReportInfo = new RIJCommentReportModule.CommentReportInfo();
    localCommentReportInfo.a(localBaseCommentData.rowKey);
    localCommentReportInfo.a(paramInt);
    localCommentReportInfo.d(paramString2);
    if ((localBaseCommentData instanceof CommentData))
    {
      localCommentReportInfo.b(localBaseCommentData.commentId);
      localCommentReportInfo.c("");
    }
    for (;;)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(this);
      ReadInJoyLogicEngine.a().a(localCommentReportInfo);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "commentID : ", paramString1, ", reportReason : ", "reportInfo :", localCommentReportInfo });
      return;
      if ((localBaseCommentData instanceof SubCommentData))
      {
        localCommentReportInfo.b(((SubCommentData)localBaseCommentData).parentCommentId);
        localCommentReportInfo.c(localBaseCommentData.commentId);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    QLog.d("ReadInJoyCommentDataManager", 2, "setTitleShowData | showFamilyTitle : " + this.jdField_f_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, @NonNull RIJCommentReportModule.CommentReportInfo paramCommentReportInfo)
  {
    e(paramBoolean);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onCommentReportResult(): success : ", Boolean.valueOf(paramBoolean), ", retCode : ", Integer.valueOf(paramInt), ", retMsg : ", paramString, "reportInfo :", paramCommentReportInfo });
    if (paramBoolean) {
      if (!TextUtils.isEmpty(paramCommentReportInfo.c())) {
        paramInt = b(paramCommentReportInfo);
      }
    }
    for (;;)
    {
      a(new ReadInJoyCommentDataManager.18(this, paramInt, paramBoolean, paramCommentReportInfo), false);
      return;
      paramInt = a(paramCommentReportInfo);
      continue;
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLikeOrDislikeCommentResult ret : ", Boolean.valueOf(paramBoolean), ", commentData : ", paramBaseCommentData, ", opType ; ", Integer.valueOf(paramInt1), ", opValue : ", Integer.valueOf(paramInt2) });
    a(new ReadInJoyCommentDataManager.32(this, paramBoolean, paramBaseCommentData, paramInt1, paramInt2));
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if (localObject != null) {
        ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean, this.jdField_a_of_type_JavaLangString, paramBaseCommentData.commentId, String.valueOf(paramInt2), "onCommentLike", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    if (paramBaseCommentData == null) {}
    for (;;)
    {
      return;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "del comment resp, ret : ", Boolean.valueOf(paramBoolean), ", data : ", paramBaseCommentData });
      if (paramBoolean)
      {
        QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131712918), 0).a();
        paramString = BaseActivity.sTopActivity.getIntent().getBundleExtra("bundle");
        if (!(paramBaseCommentData instanceof CommentData)) {
          break label137;
        }
      }
      label137:
      for (int j = ((CommentData)paramBaseCommentData).subCommentNum + 1; paramString != null; j = 1)
      {
        ReadInJoyLogicEngineEventDispatcher.a().a(true, this.jdField_a_of_type_JavaLangString, paramBaseCommentData.commentId, "onCommentDelete", paramString.getInt("seq"), j);
        return;
        QQToast.a(BaseApplication.getContext(), 1, paramString, 0).a();
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, int paramInt, String paramString, boolean paramBoolean2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "onAuthorDeleteCommentResult | bSuccess " + paramBoolean1 + " errMsg " + paramString);
    if (paramCommentViewItem == null) {}
    do
    {
      return;
      paramString = paramCommentViewItem.a;
    } while (paramString == null);
    if (paramBoolean1)
    {
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131712918), 0).a();
      a(paramString);
      b(paramString);
      a(new ReadInJoyCommentDataManager.31(this, paramString.getCommentLevel(), paramCommentViewItem, paramInt), false);
      return;
    }
    paramString = BaseApplicationImpl.context;
    if (paramBoolean2)
    {
      paramInt = 0;
      if (!paramBoolean2) {
        break label150;
      }
    }
    label150:
    for (paramCommentViewItem = HardCodeUtil.a(2131718577);; paramCommentViewItem = HardCodeUtil.a(2131718576))
    {
      QQToast.a(paramString, paramInt, paramCommentViewItem, 0).a();
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, String paramString, boolean paramBoolean2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "onBlockUserCommentResult | bSuccess " + paramBoolean1 + " errMsg " + paramString);
    if (paramCommentViewItem == null) {}
    do
    {
      do
      {
        return;
        paramCommentViewItem = paramCommentViewItem.a;
      } while (paramCommentViewItem == null);
      a(paramBoolean1, paramBoolean2, paramString);
    } while (!paramBoolean1);
    paramString = a(paramCommentViewItem);
    a(new ReadInJoyCommentDataManager.43(this, paramCommentViewItem.getCommentLevel(), paramString), false);
  }
  
  public boolean a()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public boolean a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    try
    {
      boolean bool = this.jdField_e_of_type_JavaUtilList.remove(paramOnDataChangeListener);
      return bool;
    }
    finally
    {
      paramOnDataChangeListener = finally;
      throw paramOnDataChangeListener;
    }
  }
  
  @VisibleForTesting
  int b(@NonNull RIJCommentReportModule.CommentReportInfo paramCommentReportInfo)
  {
    CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramCommentReportInfo.b());
    if (localCommentData != null)
    {
      if (localCommentData.subCommentNum > 0) {
        localCommentData.subCommentNum -= 1;
      }
      List localList = localCommentData.subCommentList;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          SubCommentData localSubCommentData = (SubCommentData)localIterator.next();
          if (localSubCommentData.commentId.equalsIgnoreCase(paramCommentReportInfo.c())) {
            localList.remove(localSubCommentData);
          }
        }
      }
    }
    a(localCommentData, -1);
    this.jdField_c_of_type_JavaUtilList.remove(paramCommentReportInfo.c());
    return 2;
  }
  
  public List<CommentViewItem> b()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      j = 0;
      if (j < this.jdField_b_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaUtilList.get(j));
        if (localCommentData == null) {}
        for (;;)
        {
          j += 1;
          break;
          if ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ReadInJoyCommentHelper.a()))) {
            localArrayList2.add(localCommentData);
          }
        }
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new CommentViewItem(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
      localArrayList1.addAll(a(2, new ArrayList(localArrayList2)));
    }
    if ("getTotalNewCommentList " + localArrayList1 != null) {}
    for (int j = localArrayList1.size();; j = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(j) });
      return localArrayList1;
    }
  }
  
  public List<CommentViewItem> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new CommentViewItem(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new CommentViewItem(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.addAll(b(0, this.jdField_c_of_type_JavaUtilList));
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "get all sub comment list , parentID : ", paramString, ", sub list size : ", Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
    return localArrayList;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ReadInJoyCommentDataManager.4(this, paramInt2));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "loadFirstCommentList | feedsType : " + paramInt1 + " contentSrc : " + this.jdField_a_of_type_Int + "; fetchType : " + paramInt2, ", cookie : ", this.jdField_b_of_type_JavaLangString });
    if (paramInt2 == 1) {}
    for (String str = "";; str = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaLangString = str;
      if ((paramInt2 != 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_Boolean)) {
        break;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.5(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString));
      return;
    }
    if (paramInt1 == 6)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.6(this));
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.7(this, null));
  }
  
  public void b(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString);
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      this.jdField_e_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      a(this.jdField_h_of_type_JavaLangString, paramResponseCommentInfo.jdField_a_of_type_Boolean);
      c(paramCommentData.jdField_a_of_type_JavaUtilList, null);
      bool1 = true;
    }
    while (bool2) {
      if ((bool1) && ((paramCommentData.jdField_a_of_type_JavaUtilList == null) || (paramCommentData.jdField_a_of_type_JavaUtilList.isEmpty())))
      {
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
        {
          QLog.d("ReadInJoyCommentDataManager", 1, "switchCommentFeedsType | hot is empty or first change to new : ");
          j(1);
          return;
          bool1 = false;
        }
        else
        {
          a(new ReadInJoyCommentDataManager.24(this, a(3)));
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_b_of_type_Boolean))
        {
          if (!a(paramCommentData.jdField_a_of_type_JavaUtilList)) {
            a(new ReadInJoyCommentDataManager.25(this));
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_b_of_type_Boolean = false;
        }
        paramResponseCommentInfo = a();
        if (paramCommentData.jdField_a_of_type_JavaUtilList != null)
        {
          paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();
          label238:
          paramResponseExtraInfo = new StringBuilder().append(", hot size : ");
          if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
            break label375;
          }
        }
        label375:
        for (int j = paramCommentData.jdField_a_of_type_JavaUtilList.size();; j = 0)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadHotCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(paramInt), j, ", totalCnt : ", Long.valueOf(this.jdField_c_of_type_Long) });
          a(new ReadInJoyCommentDataManager.26(this, bool1, paramResponseCommentInfo));
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$CommentAnchor.a(false);
          return;
          paramInt = 0;
          break label238;
        }
      }
    }
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramResponseCommentInfo = a(1, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramResponseCommentInfo = new ArrayList())
    {
      bool2 = this.jdField_d_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreHotComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ReadInJoyCommentDataManager.27(this, bool1, paramResponseCommentInfo, bool2));
      return;
    }
  }
  
  public void b(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem == null) || (paramCommentViewItem.a == null)) {
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "blockUserComment | " + paramCommentViewItem.a);
    RIJCommentNetworkHelper.a.a(paramCommentViewItem, this);
  }
  
  public void b(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if ((paramCommentViewItem == null) || (paramCommentViewItem.a == null)) {
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "authorDeleteComment | " + paramCommentViewItem.a);
    RIJCommentNetworkHelper.a.a(this.jdField_a_of_type_Int, paramCommentViewItem, paramInt, this);
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper.a(paramArticleInfo);
  }
  
  public void b(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    int k;
    if (paramString != null)
    {
      paramString.like = paramInt;
      k = paramString.likeCnt;
      if (!paramString.isLiked()) {
        break label77;
      }
    }
    label77:
    for (int j = 1;; j = -1)
    {
      paramString.likeCnt = (j + k);
      if (paramString.likeCnt < 0) {
        paramString.likeCnt = 0;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule.a(paramString, 0, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    QLog.d("ReadInJoyCommentDataManager", 1, "onUpdateCommentStickyResult: id[" + paramString + "] success[" + paramBoolean1 + "] overtimes[" + paramBoolean2 + "]");
    int j;
    if (paramInt == 1) {
      j = 1;
    }
    while (paramBoolean1)
    {
      Object localObject = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (localObject == null)
      {
        return;
        j = 0;
      }
      else
      {
        if (paramInt == 1) {}
        for (paramBoolean1 = bool;; paramBoolean1 = false)
        {
          ((BaseCommentData)localObject).isAuthorSticky = paramBoolean1;
          ((BaseCommentData)localObject).isAuthorBottom = false;
          if (j == 0) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.remove(paramString);
          this.jdField_a_of_type_JavaUtilList.add(b(), paramString);
          paramInt = 2131718589;
          a(new ReadInJoyCommentDataManager.42(this, a()));
          QQToast.a(BaseApplicationImpl.context, 2, HardCodeUtil.a(paramInt), 0).a();
          return;
        }
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
        localObject = a();
        paramInt = ((Integer)((Pair)localObject).first).intValue();
        j = ((Integer)((Pair)localObject).second).intValue();
        if (paramInt >= 10) {
          this.jdField_a_of_type_JavaUtilList.add(9, paramString);
        }
        for (;;)
        {
          paramInt = 2131718593;
          break;
          if (j > 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size() - j, paramString);
          } else {
            this.jdField_a_of_type_JavaUtilList.add(paramString);
          }
        }
      }
    }
    if (j != 0) {
      if (paramBoolean2) {
        paramInt = 2131718588;
      }
    }
    for (;;)
    {
      QQToast.a(BaseApplicationImpl.context, paramInt, 0).a();
      return;
      paramInt = 2131718587;
      continue;
      paramInt = 2131718592;
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString) == null) {
      return;
    }
    paramString = new FirstCommentSinkData(paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_Int, "");
    if (paramBoolean) {}
    for (int j = 3;; j = 2)
    {
      paramString.a(j);
      RIJCommentNetworkHelper.a.a(paramString, this);
      return;
    }
  }
  
  public void b(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onReportCommentResp ret : ", Boolean.valueOf(paramBoolean), ", commentData : ", paramBaseCommentData, ", extraData : ", paramString });
  }
  
  public List<CommentViewItem> c()
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0))
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localObject != null) {
          localArrayList2.add(localObject);
        }
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean))
      {
        QLog.d("ReadInJoyCommentDataManager", 1, "getTotalFamilyCommentList | showTitle dont showSwitch");
        localArrayList1.add(new CommentViewItem(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
      localArrayList1.addAll(a(4, new ArrayList(localArrayList2)));
    }
    if ("getTotalFamilyCommentList " + localArrayList1 != null) {}
    for (int j = localArrayList1.size();; j = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(j) });
      return localArrayList1;
    }
  }
  
  public void c(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool2 = TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString);
    boolean bool1;
    label91:
    long l;
    if (paramInt == 0)
    {
      bool1 = true;
      if (!bool1) {
        break label221;
      }
      this.jdField_f_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      this.jdField_e_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      d(paramCommentData.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList);
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult succeed ");
      if (!bool2) {
        break label244;
      }
      if (paramResponseCommentInfo == null) {
        break label233;
      }
      l = paramResponseCommentInfo.jdField_a_of_type_Long;
      label106:
      this.jdField_d_of_type_Long = l;
      paramResponseCommentInfo = new StringBuilder();
      if (!paramCommentData.a()) {
        break label239;
      }
    }
    label221:
    label233:
    label239:
    for (paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstFaimilyCommentFinish, ret : ", Boolean.valueOf(bool1), ",  size : ", paramInt + ", mFamilyCommentCnt : ", Long.valueOf(this.jdField_d_of_type_Long) });
      a(new ReadInJoyCommentDataManager.28(this, bool1, c()));
      return;
      bool1 = false;
      break;
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult failed ");
      break label91;
      l = 0L;
      break label106;
    }
    label244:
    if (paramCommentData != null) {}
    for (paramResponseCommentInfo = a(4, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramResponseCommentInfo = new ArrayList())
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreFamilyComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      a(new ReadInJoyCommentDataManager.29(this, bool1, paramResponseCommentInfo));
      return;
    }
  }
  
  public void c(String paramString)
  {
    a(2, paramString, null);
  }
  
  public void c(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    SubCommentData localSubCommentData;
    do
    {
      return;
      localSubCommentData = (SubCommentData)a(2, paramString);
    } while (localSubCommentData == null);
    SubCommentCreateData localSubCommentCreateData = new SubCommentCreateData(this.jdField_a_of_type_Int, "");
    localSubCommentCreateData.a(localSubCommentData.parentCommentId);
    localSubCommentCreateData.b(this.jdField_h_of_type_JavaLangString);
    localSubCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localSubCommentCreateData.d(localSubCommentData.commentContent);
    localSubCommentCreateData.a(localSubCommentData.commentRptDataList);
    localSubCommentCreateData.b(localSubCommentData.commentLinkDataList);
    if (localSubCommentData.hasTarget()) {
      localSubCommentCreateData.e(localSubCommentData.repliedCommentId);
    }
    try
    {
      localSubCommentCreateData.a(Long.parseLong(localSubCommentData.repliedUserUin));
      long l = RIJCommentNetworkWrapper.a.a(localSubCommentCreateData, new ReadInJoyCommentDataManager.15(this, paramString, localSubCommentData), paramString, paramInt, false);
      QLog.d("ReadInJoyCommentDataManager", 1, "create reply comment, seq : " + l + ", data : " + localSubCommentData);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyCommentDataManager", 1, "replyComment: Invalid repliedSubAuthorId.");
      }
    }
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString) == null) {
      return;
    }
    paramString = new FirstCommentStickyData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_Int, "", paramString);
    if (paramBoolean) {}
    for (int j = 1;; j = 2)
    {
      paramString.a(j);
      RIJCommentNetworkHelper.a.a(paramString, this);
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "CommentDataManager destroy, articleInfo : ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo });
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    s();
    t();
    u();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) {
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    }
    if (this.jdField_e_of_type_JavaUtilList != null) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule.a();
    }
    e();
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = a(1, paramString);
    } while (localBaseCommentData == null);
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.jdField_a_of_type_Int, "");
    localFirstCommentCreateData.b(this.jdField_h_of_type_JavaLangString);
    localFirstCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localFirstCommentCreateData.a(localBaseCommentData.commentContent);
    localFirstCommentCreateData.a(localBaseCommentData.commentRptDataList);
    localFirstCommentCreateData.b(localBaseCommentData.commentLinkDataList);
    RIJCommentNetworkWrapper.a.a(localFirstCommentCreateData, new ReadInJoyCommentDataManager.17(this), paramString, 2, true);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = a(1, paramString);
    } while (localBaseCommentData == null);
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.jdField_a_of_type_Int, "");
    localFirstCommentCreateData.b(this.jdField_h_of_type_JavaLangString);
    localFirstCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localFirstCommentCreateData.a(localBaseCommentData.commentContent);
    localFirstCommentCreateData.a(localBaseCommentData.commentRptDataList);
    localFirstCommentCreateData.b(localBaseCommentData.commentLinkDataList);
    long l = RIJCommentNetworkWrapper.a.a(localFirstCommentCreateData, new ReadInJoyCommentDataManager.16(this, paramString, localBaseCommentData), paramString, paramInt, false);
    QLog.d("ReadInJoyCommentDataManager", 1, "create main comment, seq : " + l + ", data : " + localBaseCommentData);
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this);
  }
  
  public void e(int paramInt)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "loadMoreComment | with feedsType : " + paramInt);
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 3: 
    case 5: 
      k(2);
      return;
    case 2: 
      j(2);
      return;
    }
    l(2);
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_b_of_type_JavaUtilMap.remove(str);
      }
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void g()
  {
    try
    {
      this.jdField_e_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager
 * JD-Core Version:    0.7.0.1
 */