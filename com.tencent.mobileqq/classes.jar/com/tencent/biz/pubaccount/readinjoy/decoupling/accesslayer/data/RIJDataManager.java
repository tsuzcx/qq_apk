package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSPreLayoutHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.OnDrawCompleteListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJDataManager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RIJDataManager.Builder jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder;
  ReadInJoyBaseListView.OnDrawCompleteListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener;
  public AbsListView.OnScrollListener a;
  protected List<BaseArticleInfo> a;
  
  public RIJDataManager(RIJDataManager.Builder paramBuilder)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RIJDataManager.2(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder = paramBuilder;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener = new RIJDataManager.OnDrawCompleteListener(this, this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
      if ((a().size() > 0) && (paramInt1 == 70))
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)a().get(0);
        if (localBaseArticleInfo != null) {
          ((KandianSubscribeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a((ArticleInfo)localBaseArticleInfo, NetConnInfoCenter.getServerTime());
        }
      }
    }
  }
  
  private void c(List<BaseArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      QLog.d("RIJDataManager", 1, "articleInfo list size =  " + paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
        if (localBaseArticleInfo != null) {
          localArrayList.add(localBaseArticleInfo);
        } else {
          QLog.d("RIJDataManager", 1, "has null items");
        }
      }
      paramList.clear();
      paramList.addAll(localArrayList);
    }
    QLog.d("RIJDataManager", 1, "tempList size =  " + localArrayList.size());
  }
  
  public int a()
  {
    return a().size();
  }
  
  public long a(int paramInt)
  {
    Object localObject = a(paramInt);
    if ((localObject instanceof BaseArticleInfo)) {
      return ((BaseArticleInfo)localObject).mArticleID;
    }
    return paramInt;
  }
  
  public RIJDataManager.Builder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder;
  }
  
  public ReadInJoyModelImpl a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    ArticleInfo localArticleInfo = null;
    if (paramInt2 < a() - 1) {
      localArticleInfo = (ArticleInfo)a(paramInt2 + 1);
    }
    return new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.a(), paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.d(), a(), localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.a());
  }
  
  public ArticleInfo a(Activity paramActivity)
  {
    long l = paramActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
    ArticleInfo localArticleInfo2 = ReadInJoyLogicEngine.a().a(0, l);
    ArticleInfo localArticleInfo1 = localArticleInfo2;
    if (localArticleInfo2 == null) {
      localArticleInfo1 = (ArticleInfo)paramActivity.getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
    }
    return localArticleInfo1;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public ReadInJoyBaseListView.OnDrawCompleteListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener;
  }
  
  public Object a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a().size())) {
      return a(paramInt);
    }
    return null;
  }
  
  public List<BaseArticleInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    a().clear();
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a().removeAll(paramArrayList);
      a().e(true);
      a().a().notifyDataSetChanged();
    }
    BaseArticleInfo localBaseArticleInfo = null;
    if (paramArrayList.size() > 0) {
      localBaseArticleInfo = (BaseArticleInfo)paramArrayList.get(0);
    }
    int i = 2131699744;
    if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) {
      i = 2131699745;
    }
    if ((a().a() instanceof BaseActivity))
    {
      QQToast.a(a().a(), -1, a().a().getString(i), 0).b(((BaseActivity)a().a()).getTitleBarHeight());
      a().a().a(paramInt, paramArrayList, paramArrayList1);
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramObject != null)
        {
          l1 = l2;
          if ((paramObject instanceof DislikeInfo)) {
            l1 = ((DislikeInfo)paramObject).a;
          }
        }
        paramArrayList = null;
        if ((localBaseArticleInfo instanceof AdvertisementInfo)) {
          paramArrayList = (AdvertisementInfo)localBaseArticleInfo;
        }
        ReadInJoyLogicEngine.a().a(a().a(), paramArrayList, l1, paramArrayList1, paramBoolean1);
      }
    }
    for (;;)
    {
      try
      {
        paramArrayList = new JSONObject();
        paramArrayList.put("time", System.currentTimeMillis() / 1000L);
        paramArrayList.put("channel_id", a().b());
        if (paramArrayList1 == null) {
          continue;
        }
        paramInt = paramArrayList1.size();
        paramArrayList.put("tag_num", paramInt);
        if (!(a().a() instanceof BaseActivity)) {
          continue;
        }
        paramArrayList.put("folder_status", RIJKanDianFolderStatus.a);
        paramArrayList.put("kandian_mode", RIJAppSetting.a());
        if (localBaseArticleInfo != null)
        {
          paramArrayList.put("feeds_type", "" + RIJFeedsType.a(localBaseArticleInfo));
          paramArrayList.put("rowkey", ReadinjoyReportUtils.a(localBaseArticleInfo));
        }
        paramArrayList = paramArrayList.toString();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007059", "0X8007059", 0, 0, "", "", RIJDislikeManager.a(paramArrayList1), paramArrayList, false);
      }
      catch (JSONException paramArrayList)
      {
        paramArrayList.printStackTrace();
        continue;
      }
      PTSPreLayoutHandler.a(localBaseArticleInfo);
      return;
      if (!(a().a() instanceof PluginBaseActivity)) {
        break;
      }
      QQToast.a(a().a(), -1, a().a().getString(i), 0).b(((PluginBaseActivity)a().a()).g());
      break;
      paramInt = 0;
      continue;
      if ((a().a() instanceof PluginBaseActivity))
      {
        paramArrayList.put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", paramArrayList.toString());
      }
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, ReadInJoyXListView paramReadInJoyXListView)
  {
    int j = 0;
    int k = -1;
    int i = 0;
    Object localObject;
    if (i < a().size())
    {
      localObject = (BaseArticleInfo)a().get(i);
      if (((localObject instanceof AdvertisementInfo)) && (paramAdvertisementInfo.mAdTraceId.equals(((AdvertisementInfo)localObject).mAdTraceId))) {
        localObject = (AdvertisementInfo)localObject;
      }
    }
    for (;;)
    {
      if ((i < 0) || (localObject == null)) {}
      label214:
      for (;;)
      {
        return;
        i += 1;
        break;
        label86:
        j += 1;
        if (j < paramReadInJoyXListView.getChildCount())
        {
          paramAdvertisementInfo = paramReadInJoyXListView.getChildAt(j).getTag(2131381651);
          if (!(paramAdvertisementInfo instanceof IReadInJoyModel)) {
            paramAdvertisementInfo = null;
          }
        }
        for (;;)
        {
          label123:
          if (paramAdvertisementInfo == null) {
            break label214;
          }
          if ((paramAdvertisementInfo instanceof ProteusItemView)) {
            paramAdvertisementInfo = ((ProteusItemView)paramAdvertisementInfo).a();
          }
          for (;;)
          {
            paramReadInJoyXListView = new RIJDataManager.1(this, (BaseArticleInfo)localObject, i);
            localObject = (Animation)paramAdvertisementInfo.getTag(2131369928);
            if (localObject == null) {
              break;
            }
            ((Animation)localObject).setAnimationListener(paramReadInJoyXListView);
            paramAdvertisementInfo.startAnimation((Animation)localObject);
            return;
            if (localObject != ((IReadInJoyModel)paramAdvertisementInfo).a()) {
              break label86;
            }
            paramAdvertisementInfo = paramReadInJoyXListView.getChildAt(j);
            break label123;
          }
          paramAdvertisementInfo = null;
        }
      }
      localObject = null;
      i = k;
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, boolean paramBoolean)
  {
    if ((a() != null) && (a().contains(paramBaseArticleInfo1)))
    {
      int i = a().indexOf(paramBaseArticleInfo1);
      if (paramBoolean) {
        a().remove(i + 1);
      }
      a().add(i + 1, paramBaseArticleInfo2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.a().notifyDataSetChanged();
    }
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    if ((paramList != null) && (this.jdField_a_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      c(paramList);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.e(true);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setData:");
      if (paramList != null) {
        break label132;
      }
    }
    label132:
    for (int i = 0;; i = paramList.size())
    {
      QLog.d("RIJDataManager", 2, i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.a().a(System.nanoTime());
      VideoBehaviorsReporter.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.a(), a());
      return;
    }
  }
  
  public void a(List<ArticleInfo> paramList, int paramInt)
  {
    a().removeAll(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.e(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.a().notifyDataSetChanged();
    int i = 0;
    if (i < paramList.size())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.get(i);
      if (localArticleInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l = localArticleInfo.mRecommendSeq;
        if (ReadinjoyFixPosArticleManager.a(l)) {
          ReadinjoyFixPosArticleManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.b(), l);
        } else {
          ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.b(), localArticleInfo);
        }
      }
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager$Builder.b(), paramInt);
  }
  
  public void b()
  {
    QLog.d("RIJDataManager", 1, "invalidAllArticles");
    ProteusSupportUtil.a(a().a(), "default_feeds");
    if (a() != null)
    {
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
        if (localBaseArticleInfo != null) {
          localBaseArticleInfo.invalidateProteusTemplateBean();
        }
      }
    }
  }
  
  public void b(List<BaseArticleInfo> paramList)
  {
    QLog.d("RIJDataManager", 2, "deleteData: " + paramList);
    EmojiManager.a(8);
    if ((paramList != null) && (a().getClass().isInstance(paramList)) && (paramList.size() > 0)) {
      a().removeAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager
 * JD-Core Version:    0.7.0.1
 */