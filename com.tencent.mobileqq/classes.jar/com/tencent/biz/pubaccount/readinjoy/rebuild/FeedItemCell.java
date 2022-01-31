package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
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
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentWhiteSpace;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianPopupWindow;
import com.tencent.widget.KandianPopupWindowForAd;
import com.tencent.widget.ListView;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lth;
import lti;
import ltj;
import ltk;
import org.json.JSONObject;

public abstract class FeedItemCell
{
  public int a;
  public Context a;
  View jdField_a_of_type_AndroidViewView;
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
  public ComponentLastRead a;
  ComponentPolymericView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView;
  ComponentSocialOperation jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation;
  ComponentTitle jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle;
  ComponentTopicItemSingle jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle;
  ComponentWhiteSpace jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace;
  public ReadInJoyBaseAdapter a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public Object a;
  List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public FeedItemCell(Context paramContext, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCell", 2, "FeedItemCell created, class = " + getClass().getSimpleName());
    }
    a(paramContext);
    a(paramFaceDecoder);
    a(paramReadInJoyBaseAdapter);
    a();
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, int paramInt, ArrayList paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ListView localListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    int j = localListView.getChildCount();
    localArrayList1.add(this.jdField_a_of_type_AndroidViewView);
    localArrayList2.add(paramIReadInJoyModel);
    int i = 0;
    while (i < j)
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)localListView.getChildAt(i).getTag(2131362079);
      View localView = localListView.getChildAt(i);
      if ((localIReadInJoyModel != null) && (localView != null) && (localIReadInJoyModel != paramIReadInJoyModel) && (paramIReadInJoyModel.a().mGroupId == localIReadInJoyModel.a().mGroupId) && (paramIReadInJoyModel.a().mGroupId != -1L))
      {
        localArrayList1.add(localView);
        localArrayList2.add(localIReadInJoyModel);
      }
      i += 1;
    }
    paramIReadInJoyModel = new ltk(this, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    while (paramInt < localArrayList1.size())
    {
      paramArrayList = (Animation)((View)localArrayList1.get(paramInt)).getTag(2131362291);
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
          break;
          paramArrayList.setAnimationListener(paramIReadInJoyModel);
        }
      }
    }
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      throw new Exception("FeedItemCell convertView is null!");
    }
    return this.jdField_a_of_type_AndroidViewView;
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
  
  public FeedItemCell a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public FeedItemCell a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial = new ComponentHeaderNewSocial(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setLogic(paramReadInJoyBaseAdapter, paramFaceDecoder);
    return this;
  }
  
  public FeedItemCell a(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    return this;
  }
  
  public FeedItemCell a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener = new lth(this);
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
    ArrayList localArrayList = null;
    boolean bool = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a() instanceof AdvertisementInfo;
    if (ReadInJoyUtils.a(((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a())) {}
    for (;;)
    {
      KandianPopupWindow localKandianPopupWindow = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
      KandianPopupWindowForAd localKandianPopupWindowForAd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
      if (bool)
      {
        if ((localKandianPopupWindow != null) && (localKandianPopupWindow.isShowing())) {
          localKandianPopupWindow.dismiss();
        }
        if (!localKandianPopupWindowForAd.a()) {
          localKandianPopupWindowForAd.a();
        }
        if (localKandianPopupWindowForAd.a(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).b, localArrayList)) {
          localKandianPopupWindowForAd.a(paramView, new lti(this));
        }
      }
      try
      {
        label122:
        paramView = new JSONObject();
        paramView.put("time", System.currentTimeMillis() / 1000L);
        paramView.put("channel_id", ((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).e());
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
        {
          paramView.put("folder_status", ReadInJoyUtils.d);
          paramView.put("kandian_mode", ReadInJoyUtils.e());
          paramView.put("feeds_type", "" + ReadInJoyUtils.a(((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a()));
          PublicAccountReportUtils.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
        }
        while (!(this.jdField_a_of_type_AndroidContentContext instanceof PluginBaseActivity))
        {
          return;
          localArrayList = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a().mDislikeInfos;
          break;
          if ((localKandianPopupWindowForAd != null) && (localKandianPopupWindowForAd.isShowing())) {
            localKandianPopupWindowForAd.dismiss();
          }
          if (!localKandianPopupWindow.a()) {
            localKandianPopupWindow.a();
          }
          if (!localKandianPopupWindow.a(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).b, localArrayList)) {
            break label122;
          }
          localKandianPopupWindow.a(paramView, new ltj(this));
          break label122;
        }
        paramView.put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", paramView.toString());
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void a(View paramView, Map paramMap) {}
  
  public View b()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a.jdField_a_of_type_AndroidViewView != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a.jdField_a_of_type_AndroidViewView;
      if (!((View)localObject).isShown()) {}
    }
    View localView;
    do
    {
      do
      {
        return localObject;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.jdField_a_of_type_AndroidViewView == null)) {
          break;
        }
        localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.jdField_a_of_type_AndroidViewView;
        localObject = localView;
      } while (localView.isShown());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a.jdField_a_of_type_AndroidViewView == null)) {
        break;
      }
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a.jdField_a_of_type_AndroidViewView;
      localObject = localView;
    } while (localView.isShown());
    return null;
  }
  
  FeedItemCell b()
  {
    return g().h().i().k().l().n();
  }
  
  public FeedItemCell b(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric = new ComponentHeaderPolymeric(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.setLogic(paramReadInJoyBaseAdapter, paramFaceDecoder);
    return this;
  }
  
  FeedItemCell c()
  {
    return g().l().n();
  }
  
  public FeedItemCell c(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish = new ComponentHeaderPublish(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.setLogic(paramReadInJoyBaseAdapter, paramFaceDecoder);
    return this;
  }
  
  public abstract FeedItemCell d();
  
  public FeedItemCell d(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc = new ComponentHeaderUgc(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc.setLogic(paramReadInJoyBaseAdapter, paramFaceDecoder);
    return this;
  }
  
  public abstract FeedItemCell e();
  
  public FeedItemCell e(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend = new ComponentHeaderRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend.setLogic(paramReadInJoyBaseAdapter, paramFaceDecoder);
    return this;
  }
  
  public FeedItemCell f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary = new ComponentAccountSummary(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell f(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend = new ComponentHeaderTopicRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.setLogic(paramReadInJoyBaseAdapter, paramFaceDecoder);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell
 * JD-Core Version:    0.7.0.1
 */