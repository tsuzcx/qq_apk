package com.tencent.biz.qqcircle.fragments;

import alpo;
import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import trl;
import tvm;
import two;
import tzf;
import tzm;
import yeb;

public class QCirclePersonalPushFragment
  extends QCirclePersonalBaseBottomFragment
{
  private void a(tzm<List<FeedCloudMeta.StFeed>> paramtzm)
  {
    if (paramtzm == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp return unexpected data！");
      return;
    }
    boolean bool = paramtzm.a();
    int i;
    switch (paramtzm.a())
    {
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_Trl != null))
    {
      this.jdField_a_of_type_Trl.a(true, bool);
      return;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return empty data");
      if ((paramtzm.b()) && (this.jdField_a_of_type_Trl != null) && (this.jdField_a_of_type_Trl.getItemCount() > 0))
      {
        this.jdField_a_of_type_Trl.a().a(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_Tvm != null)
        {
          paramtzm = getString(2131698302);
          this.jdField_a_of_type_Tvm.a().a().b(paramtzm);
          f();
          i = 1;
          continue;
          if (paramtzm.a() == null) {}
          for (paramtzm = alpo.a(2131720466);; paramtzm = paramtzm.a())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return error！errMsg:" + paramtzm);
            if ((this.jdField_a_of_type_Trl == null) || (this.jdField_a_of_type_Trl.getItemCount() <= 0)) {
              break label247;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramtzm, 1).a();
            i = 1;
            break;
          }
          label247:
          if (this.jdField_a_of_type_Tvm != null)
          {
            this.jdField_a_of_type_Tvm.a().a().c(paramtzm);
            f();
            i = 1;
            continue;
            i = 0;
            continue;
            ArrayList localArrayList = (ArrayList)paramtzm.a();
            if (this.jdField_a_of_type_Trl != null)
            {
              if (paramtzm.b()) {
                this.jdField_a_of_type_Trl.a(localArrayList);
              }
              for (;;)
              {
                if (this.jdField_a_of_type_Tvm != null)
                {
                  this.jdField_a_of_type_Tvm.a().a().setVisibility(8);
                  this.jdField_a_of_type_Tvm.a().a().setVisibility(0);
                }
                this.jdField_a_of_type_Trl.a().a(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Trl.a(localArrayList);
                this.jdField_a_of_type_Trl.Q_();
              }
            }
          }
        }
        i = 1;
      }
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Trl != null)
    {
      ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
      localExtraTypeInfo.pageType = 9;
      this.jdField_a_of_type_Trl.a(localExtraTypeInfo);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Tzf = ((tzf)a(a(), null, tzf.class));
      this.jdField_a_of_type_Tzf.c().observe(a(), new two(this));
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Tzf != null) {
      this.jdField_a_of_type_Tzf.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalPushFragment
 * JD-Core Version:    0.7.0.1
 */