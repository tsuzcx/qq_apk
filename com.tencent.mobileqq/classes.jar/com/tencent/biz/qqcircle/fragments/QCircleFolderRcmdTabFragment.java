package com.tencent.biz.qqcircle.fragments;

import alpo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import trj;
import trl;
import tvm;
import twf;
import tyj;
import tym;
import tzm;
import ydp;
import yeb;

public class QCircleFolderRcmdTabFragment
  extends QCircleBaseTabFragment
{
  public static String k = "QCircleFolderRcmdTabFragment";
  private trj a;
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Tvm.a().a().addOnScrollListener(new twf(this));
  }
  
  protected void a(tzm<List<FeedCloudMeta.StFeed>> paramtzm)
  {
    int j = 0;
    if (paramtzm == null)
    {
      QLog.e(k, 1, "handleFeedDataRsp() return unexpected data！");
      return;
    }
    boolean bool = paramtzm.a();
    int i = j;
    switch (paramtzm.a())
    {
    default: 
      i = j;
    }
    while ((i != 0) && (this.jdField_a_of_type_Trl != null))
    {
      this.jdField_a_of_type_Trl.a(true, bool);
      return;
      QLog.e(k, 1, "handleFeedDataRsp() return empty");
      if ((paramtzm.b()) && (this.jdField_a_of_type_Trl != null) && (this.jdField_a_of_type_Trl.getItemCount() > 0))
      {
        this.jdField_a_of_type_Trl.a().a(bool);
        i = 1;
      }
      else
      {
        if ((this.jdField_a_of_type_Trl != null) && (!this.jdField_a_of_type_Trl.a()))
        {
          if ((this.jdField_a_of_type_Trl.getItemCount() <= 0) && (this.jdField_a_of_type_Trj.getItemCount() <= 0)) {
            break label197;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131720466), 1).a();
        }
        for (;;)
        {
          i = 1;
          break;
          label197:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d();
          }
        }
        if (paramtzm.a() == null) {}
        for (paramtzm = alpo.a(2131720466);; paramtzm = paramtzm.a())
        {
          QLog.e(k, 1, "handleFeedDataRsp() return error！errMsg:" + paramtzm);
          if ((this.jdField_a_of_type_Trl == null) || (this.jdField_a_of_type_Trl.a())) {
            break label432;
          }
          if ((this.jdField_a_of_type_Trl.getItemCount() <= 0) && (this.jdField_a_of_type_Trj.getItemCount() <= 0)) {
            break label316;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, paramtzm, 1).a();
          i = 1;
          break;
        }
        label316:
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d(paramtzm);
          i = 1;
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c();
          }
          if (this.jdField_a_of_type_Trl != null)
          {
            if (paramtzm.b()) {
              this.jdField_a_of_type_Trl.a((List)paramtzm.a());
            }
            for (;;)
            {
              this.jdField_a_of_type_Trl.a().a(bool);
              i = 1;
              break;
              this.jdField_a_of_type_Trl.a((ArrayList)paramtzm.a());
              if (d.equals(b())) {
                this.jdField_a_of_type_Trl.Q_();
              }
            }
          }
        }
        label432:
        i = 1;
      }
    }
  }
  
  public String b()
  {
    return i;
  }
  
  protected List<ydp> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Trj = new trj(null);
    localArrayList.add(this.jdField_a_of_type_Trj);
    return localArrayList;
  }
  
  public void c()
  {
    super.c();
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_Trj.a(this.jdField_a_of_type_Tzb, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    tym.a().a(3);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (tym.a().b(3)) {
        tym.a().a(getActivity().getIntent());
      }
      tyj.a("", 23, 1L);
      return;
    }
    tym.a().a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment
 * JD-Core Version:    0.7.0.1
 */