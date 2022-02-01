package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSpecialTopic;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentInfo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentWhiteSpace;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.KandianNegativeWindowForAd;
import com.tencent.widget.ListView;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class FeedItemCell
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ReadInJoyModelImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyModelImpl;
  ComponentView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView;
  FeedItemCell.CellListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener;
  ComponentAccountSummary jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary;
  ComponentComment jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment;
  ComponentContentUgcOriginalHeader jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader;
  ComponentContentUgcSource jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource;
  ComponentDivider jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider;
  ComponentHeaderFriendRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend;
  ComponentHeaderNewSocial jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial;
  ComponentHeaderPolymeric jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric;
  ComponentHeaderPublish jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish;
  ComponentHeaderRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend;
  ComponentHeaderSpecialTopic jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic;
  ComponentHeaderTopicRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend;
  ComponentHeaderUgc jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc;
  ComponentInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo;
  ComponentJump jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump;
  ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  ComponentPolymericView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView;
  ComponentSocialOperation jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation;
  ComponentTitle jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle;
  ComponentTopicItemSingle jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle;
  ComponentWhiteSpace jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  Object jdField_a_of_type_JavaLangObject;
  List<ComponentTopicItemMulti> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public FeedItemCell(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCell", 2, "FeedItemCell created, class = " + getClass().getSimpleName());
    }
    a(paramContext);
    a(paramIFaceDecoder);
    a(paramReadInJoyBaseAdapter);
    a();
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ListView localListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    int j = localListView.getChildCount();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.g();
    localArrayList1.add(this.jdField_a_of_type_AndroidViewView);
    localArrayList2.add(paramIReadInJoyModel);
    int i = 0;
    while (i < j)
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)localListView.getChildAt(i).getTag(2131381651);
      View localView = localListView.getChildAt(i);
      if ((localIReadInJoyModel != null) && (localView != null) && (localIReadInJoyModel != paramIReadInJoyModel) && (paramIReadInJoyModel.a().mGroupId == localIReadInJoyModel.a().mGroupId) && (paramIReadInJoyModel.a().mGroupId != -1L))
      {
        localArrayList1.add(localView);
        localArrayList2.add(localIReadInJoyModel);
      }
      i += 1;
    }
    paramIReadInJoyModel = new FeedItemCell.7(this, localArrayList2, paramInt, paramArrayList, paramObject);
    paramInt = 0;
    while (paramInt < localArrayList1.size())
    {
      paramArrayList = (Animation)((View)localArrayList1.get(paramInt)).getTag(2131369928);
      if (paramArrayList == null)
      {
        paramInt += 1;
      }
      else
      {
        if (paramInt != 0) {
          paramArrayList.setAnimationListener(null);
        }
        for (;;)
        {
          ((View)localArrayList1.get(paramInt)).startAnimation(paramArrayList);
          paramArrayList.startNow();
          break;
          paramArrayList.setAnimationListener(paramIReadInJoyModel);
        }
      }
    }
  }
  
  private void a(ArrayList<IReadInJoyModel> paramArrayList, int paramInt, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    try
    {
      a().post(new FeedItemCell.8(this, paramArrayList, paramArrayList1, paramInt, paramObject, paramBoolean));
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      throw new Exception("FeedItemCell convertView is null!");
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ComponentView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView;
  }
  
  public abstract FeedItemCell a();
  
  public FeedItemCell a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public FeedItemCell a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public FeedItemCell a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public FeedItemCell a(ReadInJoyModelImpl paramReadInJoyModelImpl)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyModelImpl = paramReadInJoyModelImpl;
    return this;
  }
  
  public FeedItemCell a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public FeedItemCell a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial = new ComponentHeaderNewSocial(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public FeedItemCell a(IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    return this;
  }
  
  public FeedItemCell a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener = new FeedItemCell.1(this);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc.a(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.a(paramLong, paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    Object localObject = null;
    boolean bool = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a() instanceof AdvertisementInfo;
    KandianNegativeWindow localKandianNegativeWindow;
    KandianNegativeWindowForAd localKandianNegativeWindowForAd;
    if (RIJFeedsType.a(((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a()))
    {
      localKandianNegativeWindow = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
      localKandianNegativeWindowForAd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
      if (!bool) {
        break label383;
      }
      if ((localKandianNegativeWindow != null) && (localKandianNegativeWindow.isShowing())) {
        localKandianNegativeWindow.dismiss();
      }
      localObject = (AdvertisementInfo)((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
      if (localObject != null) {
        break label116;
      }
    }
    label116:
    label383:
    do
    {
      return;
      localObject = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a().mDislikeInfos;
      break;
      localKandianNegativeWindowForAd.b((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject, ((AdvertisementInfo)localObject).mAdDislikeInfos);
      localKandianNegativeWindowForAd.a(paramView, new FeedItemCell.2(this));
      localKandianNegativeWindowForAd.a(new FeedItemCell.3(this));
      localKandianNegativeWindowForAd.setOnDismissListener(new FeedItemCell.4(this, localKandianNegativeWindowForAd));
      for (;;)
      {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
        if ((paramView != null) && (paramView.b()))
        {
          paramView.a();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(true);
        }
        try
        {
          paramView = new JSONObject();
          paramView.put("time", System.currentTimeMillis() / 1000L);
          paramView.put("channel_id", ((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).e());
          localObject = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
          if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
            break;
          }
          paramView.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
          paramView.put("kandian_mode", RIJAppSetting.a());
          paramView.put("feeds_type", "" + RIJFeedsType.a((BaseArticleInfo)localObject));
          paramView.put("rowkey", ReadinjoyReportUtils.a((BaseArticleInfo)localObject));
          paramView = paramView.toString();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView, false);
          return;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
        if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().a(paramView, ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a(), ((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).b, this.jdField_a_of_type_AndroidViewView);
        }
        else
        {
          if ((localKandianNegativeWindowForAd != null) && (localKandianNegativeWindowForAd.isShowing())) {
            localKandianNegativeWindowForAd.dismiss();
          }
          localKandianNegativeWindow.a((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject, (ArrayList)localObject);
          localKandianNegativeWindow.a(paramView, new FeedItemCell.5(this));
          localKandianNegativeWindow.setOnDismissListener(new FeedItemCell.6(this, localKandianNegativeWindow));
        }
      }
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof PluginBaseActivity));
    paramView.put("folder_status", 1);
    ReportController.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", paramView.toString());
  }
  
  public void a(View paramView, Map<String, Object> paramMap) {}
  
  FeedItemCell b()
  {
    return g().h().i().k().l().n();
  }
  
  public FeedItemCell b(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric = new ComponentHeaderPolymeric(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public void b() {}
  
  FeedItemCell c()
  {
    return g().l().n();
  }
  
  public FeedItemCell c(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish = new ComponentHeaderPublish(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public abstract FeedItemCell d();
  
  public FeedItemCell d(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc = new ComponentHeaderUgc(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public abstract FeedItemCell e();
  
  public FeedItemCell e(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend = new ComponentHeaderRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public FeedItemCell f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary = new ComponentAccountSummary(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell f(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend = new ComponentHeaderTopicRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public FeedItemCell g()
  {
    return this;
  }
  
  public FeedItemCell h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle = new ComponentTitle(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public FeedItemCell i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo = new ComponentInfo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public FeedItemCell j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource = new ComponentContentUgcSource(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump = new ComponentJump(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider = new ComponentDivider(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public FeedItemCell m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace = new ComponentWhiteSpace(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public FeedItemCell n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = new ComponentLastRead(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.a(this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))
      {
        IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setReadedStatus(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(localIReadInJoyModel.e(), localIReadInJoyModel.a().mArticleID));
      }
      label119:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace.a(this.jdField_a_of_type_JavaLangObject);
      }
      try
      {
        e();
        return this;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return this;
      }
    }
    catch (Exception localException2)
    {
      break label119;
    }
  }
  
  public FeedItemCell p()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener == null) {}
    do
    {
      return this;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
    return this;
  }
  
  public FeedItemCell q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation = new ComponentSocialOperation(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell r()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader = new ComponentContentUgcOriginalHeader(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell s()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle = new ComponentTopicItemSingle(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell t()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ComponentTopicItemMulti(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_JavaUtilList.add(new ComponentTopicItemMulti(this.jdField_a_of_type_AndroidContentContext));
    return this;
  }
  
  public FeedItemCell u()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView = new ComponentPolymericView(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell
 * JD-Core Version:    0.7.0.1
 */