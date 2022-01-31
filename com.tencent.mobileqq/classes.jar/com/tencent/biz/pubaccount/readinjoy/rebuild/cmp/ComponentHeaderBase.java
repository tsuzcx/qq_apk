package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import baxy;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import onh;
import osg;
import pau;
import pqo;
import pqy;
import puy;
import qbz;
import qci;
import ram;

public abstract class ComponentHeaderBase
  extends FrameLayout
  implements pqo
{
  baxy jdField_a_of_type_Baxy;
  public ComponentNotIntrest a;
  public puy a;
  ram jdField_a_of_type_Ram;
  
  public ComponentHeaderBase(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentHeaderBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentHeaderBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Puy = new puy();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559869, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131370911));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pau))
    {
      pau localpau = (pau)paramObject;
      this.jdField_a_of_type_Puy.a(localpau);
      b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramObject);
        if (!a()) {
          break label56;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(8);
      }
    }
    return;
    label56:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(0);
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(parampqy);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Puy.a == null) || (this.jdField_a_of_type_Puy.a.a() == null)) {
      QLog.d("ComponentHeaderBase", 2, "isHideNotInterestView model or articleInfo is null !");
    }
    ArticleInfo localArticleInfo;
    do
    {
      return false;
      localArticleInfo = this.jdField_a_of_type_Puy.a.a();
    } while (((onh.b(localArticleInfo)) || (onh.c(localArticleInfo)) || (onh.e(localArticleInfo)) || (onh.f(localArticleInfo))) && ((localArticleInfo.mChannelID != 70L) || ((!this.jdField_a_of_type_Puy.a()) && (localArticleInfo.mChannelID != 70L) && ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.h != 1)))));
    return true;
  }
  
  public void b() {}
  
  protected void c()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_Puy.a.a();
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new qbz();
      localReportInfo.mUin = onh.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((qbz)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qci != null) {
          ((qbz)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qci.jdField_a_of_type_Long;
        }
        ((qbz)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((qbz)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).d;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((qbz)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (qci)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((qbz)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((qci)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 14;
      localReportInfo.mFeedsReportData = ((qbz)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    osg.a().a((List)localObject1);
  }
  
  public void setLogic(ram paramram, baxy parambaxy)
  {
    this.jdField_a_of_type_Ram = paramram;
    this.jdField_a_of_type_Baxy = parambaxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderBase
 * JD-Core Version:    0.7.0.1
 */