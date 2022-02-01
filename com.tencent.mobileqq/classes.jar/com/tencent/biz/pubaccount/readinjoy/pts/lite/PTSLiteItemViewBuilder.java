package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteItemViewUtil;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteItemViewUtil.Companion;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSStyleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PTSLiteItemViewBuilder
{
  private static int jdField_a_of_type_Int = 148;
  private static int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private static HashMap<String, Integer> c = new HashMap();
  private Context jdField_a_of_type_AndroidContentContext;
  private PTSLiteSwiperEventDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteSwiperEventDispatcher;
  private PTSLiteTapEventDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteTapEventDispatcher;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList;
  private HashMap<String, ArticleInfo> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public PTSLiteItemViewBuilder(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    c();
    b();
  }
  
  public static int a()
  {
    if (jdField_b_of_type_Int > jdField_a_of_type_Int) {
      return jdField_b_of_type_Int - jdField_a_of_type_Int + 1;
    }
    return 0;
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.ptsItemData == null) || (TextUtils.isEmpty(paramArticleInfo.ptsLitePageName))) {
      return jdField_a_of_type_Int;
    }
    paramArticleInfo = (Integer)c.get(paramArticleInfo.ptsLitePageName);
    if (paramArticleInfo != null) {
      return paramArticleInfo.intValue();
    }
    return jdField_a_of_type_Int;
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramArticleInfo.innerUniqueID, Integer.valueOf(paramInt));
    if ((paramArticleInfo.mSubArtilceList != null) && (paramArticleInfo.mSubArtilceList.size() > 0))
    {
      paramArticleInfo = paramArticleInfo.mSubArtilceList.iterator();
      while (paramArticleInfo.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramArticleInfo.next();
        this.jdField_a_of_type_JavaUtilHashMap.put(localArticleInfo.innerUniqueID, Integer.valueOf(paramInt));
      }
    }
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    ThreadManager.executeOnSubThread(new PTSLiteItemViewBuilder.2(this, paramPTSItemData));
  }
  
  private void a(String paramString1, HashMap<String, String> paramHashMap, View paramView, String paramString2)
  {
    paramView = new StringBuilder();
    paramView.append("identifier = ").append(paramString1).append("\n");
    if (paramHashMap != null)
    {
      paramString1 = paramHashMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramHashMap = (Map.Entry)paramString1.next();
        paramView.append("dataSet [ ").append((String)paramHashMap.getKey()).append(" ] =").append((String)paramHashMap.getValue()).append("\n");
      }
    }
    QLog.i("PTSLiteItemViewBuilder", 1, paramString2 + ", " + paramView.toString());
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= jdField_a_of_type_Int) && (paramInt <= jdField_b_of_type_Int);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return true;
      if (!a(paramArticleInfo)) {
        break;
      }
    } while (a(paramArticleInfo) == jdField_a_of_type_Int);
    return false;
    return false;
  }
  
  public static <T extends BaseArticleInfo> boolean a(T paramT)
  {
    return (paramT != null) && (!TextUtils.isEmpty(paramT.ptsLitePageName)) && (paramT.ptsItemData != null);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteTapEventDispatcher = new PTSLiteTapEventDispatcher.Builder().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter).a(this.jdField_a_of_type_JavaUtilHashMap).b(this.jdField_b_of_type_JavaUtilHashMap).a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteSwiperEventDispatcher = new PTSLiteSwiperEventDispatcher.Builder().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter).a(this.jdField_a_of_type_JavaUtilHashMap).b(this.jdField_b_of_type_JavaUtilHashMap).a();
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = new PTSLiteItemViewBuilder.1(this);
  }
  
  private void c()
  {
    c.clear();
    Object localObject = PTSStyleManager.a().a("default_feeds");
    if (localObject == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[initViewTypeCount], pageNameList is null.");
      return;
    }
    jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().a() + 148;
    int i = jdField_a_of_type_Int;
    localObject = new ArrayList((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      int j = i + 1;
      i = j;
      if (!c.containsKey(str))
      {
        c.put(str, Integer.valueOf(j));
        QLog.i("PTSLiteItemViewBuilder", 1, "[initViewTypeCount], pageName = " + str + ", viewType = " + j);
        i = j;
      }
    }
    jdField_b_of_type_Int = i;
    QLog.i("PTSLiteItemViewBuilder", 1, "[initViewType], type_pts_lite_gone = " + jdField_a_of_type_Int + ", type_pts_lite_end = " + jdField_b_of_type_Int);
  }
  
  public View a(View paramView, ArticleInfo paramArticleInfo, int paramInt, ReadInJoyModelImpl paramReadInJoyModelImpl)
  {
    if (paramArticleInfo == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[getView], articleInfo is null.");
      return paramView;
    }
    PTSItemData localPTSItemData = paramArticleInfo.ptsItemData;
    PTSComposer localPTSComposer = paramArticleInfo.ptsComposer;
    if ((localPTSItemData != null) && (localPTSComposer != null)) {
      if ((paramView instanceof PTSLitePlayableCardView))
      {
        paramView = (PTSLitePlayableCardView)paramView;
        localPTSComposer.layoutToView(paramView.a(), this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener);
        PTSLiteItemViewUtil.a.a(paramView.a());
        PTSLiteItemViewUtil.a.a(paramReadInJoyModelImpl, paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
        a(paramArticleInfo, paramInt);
        this.jdField_b_of_type_JavaUtilHashMap.put(paramArticleInfo.innerUniqueID, paramArticleInfo);
        a(localPTSItemData);
      }
    }
    for (;;)
    {
      paramView.setTag(2131369928, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a());
      return paramView;
      paramView = new PTSLitePlayableCardView(this.jdField_a_of_type_AndroidContentContext);
      break;
      QLog.e("PTSLiteItemViewBuilder", 1, "[getView] error, ptsItemData is null or ptsComposer is null, hide the itemView, " + PTSPreLayoutHandler.a(paramArticleInfo));
      paramView = new PTSLitePlayableCardView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setVisibility(8);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    QLog.i("PTSLiteItemViewBuilder", 1, "[destroy] channelId = " + i);
    if ((i == 41505) || (i == 41697))
    {
      PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().b(Integer.valueOf(41505)));
      PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().b(Integer.valueOf(41697)));
      return;
    }
    PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().b(Integer.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */