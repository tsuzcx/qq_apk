package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import bcws;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ors;
import owy;
import pgd;
import pxj;
import pxt;
import qbs;
import qlv;
import qme;
import rqj;

public abstract class ComponentHeaderBase
  extends FrameLayout
  implements pxj
{
  bcws jdField_a_of_type_Bcws;
  public ComponentNotIntrest a;
  public qbs a;
  rqj jdField_a_of_type_Rqj;
  
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
    this.jdField_a_of_type_Qbs = new qbs();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559964, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131371222));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      pgd localpgd = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(localpgd);
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
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(parampxt);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Qbs.a == null) || (this.jdField_a_of_type_Qbs.a.a() == null)) {
      QLog.d("ComponentHeaderBase", 2, "isHideNotInterestView model or articleInfo is null !");
    }
    ArticleInfo localArticleInfo;
    do
    {
      return false;
      localArticleInfo = this.jdField_a_of_type_Qbs.a.a();
    } while (((ors.b(localArticleInfo)) || (ors.c(localArticleInfo)) || (ors.e(localArticleInfo)) || (ors.f(localArticleInfo))) && ((localArticleInfo.mChannelID != 70L) || ((!this.jdField_a_of_type_Qbs.a()) && (localArticleInfo.mChannelID != 70L) && ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.h != 1)))));
    return true;
  }
  
  public void b() {}
  
  protected void c()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_Qbs.a.a();
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new qlv();
      localReportInfo.mUin = ors.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((qlv)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qme != null) {
          ((qlv)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qme.jdField_a_of_type_Long;
        }
        ((qlv)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((qlv)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).d;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((qlv)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (qme)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((qlv)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((qme)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 14;
      localReportInfo.mFeedsReportData = ((qlv)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    owy.a().a((List)localObject1);
  }
  
  public void setLogic(rqj paramrqj, bcws parambcws)
  {
    this.jdField_a_of_type_Rqj = paramrqj;
    this.jdField_a_of_type_Bcws = parambcws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderBase
 * JD-Core Version:    0.7.0.1
 */