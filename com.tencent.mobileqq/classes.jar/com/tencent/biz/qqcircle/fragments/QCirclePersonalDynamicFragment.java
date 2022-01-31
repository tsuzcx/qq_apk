package com.tencent.biz.qqcircle.fragments;

import alud;
import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import tra;
import trq;
import tvw;
import txe;
import ubq;
import ubz;
import yii;

public class QCirclePersonalDynamicFragment
  extends QCirclePersonalBaseBottomFragment
{
  private void a(ubz<List<FeedCloudMeta.StFeed>> paramubz)
  {
    if (paramubz == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp return unexpected data！");
      return;
    }
    boolean bool = paramubz.a();
    int i;
    switch (paramubz.a())
    {
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_Trq != null))
    {
      this.jdField_a_of_type_Trq.a(true, bool);
      return;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return empty data");
      if ((paramubz.b()) && (this.jdField_a_of_type_Trq != null) && (this.jdField_a_of_type_Trq.getItemCount() > 0))
      {
        this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        if ((this.jdField_a_of_type_Tvw != null) && (this.jdField_a_of_type_Trq != null) && (!this.jdField_a_of_type_Trq.a()))
        {
          if (tra.a(this.b)) {}
          for (paramubz = getString(2131698304);; paramubz = getString(2131698306))
          {
            ((QCircleStatusView)this.jdField_a_of_type_Tvw.a().a()).b(paramubz);
            f();
            this.jdField_a_of_type_Trq.clearData();
            this.jdField_a_of_type_Trq.notifyDataSetChanged();
            i = 1;
            break;
          }
          if (paramubz.a() == null) {}
          for (paramubz = alud.a(2131720478);; paramubz = paramubz.a())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return error！errMsg:" + paramubz);
            if ((this.jdField_a_of_type_Trq == null) || (this.jdField_a_of_type_Trq.getItemCount() <= 0)) {
              break label301;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramubz, 1).a();
            i = 1;
            break;
          }
          label301:
          if (this.jdField_a_of_type_Tvw != null)
          {
            ((QCircleStatusView)this.jdField_a_of_type_Tvw.a().a()).c(paramubz);
            f();
            i = 1;
            continue;
            i = 0;
            continue;
            ArrayList localArrayList = (ArrayList)paramubz.a();
            if (this.jdField_a_of_type_Trq != null)
            {
              if (paramubz.b()) {
                this.jdField_a_of_type_Trq.addAll(localArrayList);
              }
              for (;;)
              {
                if (this.jdField_a_of_type_Tvw != null)
                {
                  ((QCircleStatusView)this.jdField_a_of_type_Tvw.a().a()).setVisibility(8);
                  this.jdField_a_of_type_Tvw.a().a().setVisibility(0);
                }
                this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Trq.setDatas(localArrayList);
                this.jdField_a_of_type_Trq.a();
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
    if (this.jdField_a_of_type_Trq != null)
    {
      localObject = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject).pageType = 8;
      this.jdField_a_of_type_Trq.a((ExtraTypeInfo)localObject);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Ubq = ((ubq)a(a(), null, ubq.class));
      this.jdField_a_of_type_Ubq.b().observe(a(), new txe(this));
    }
    if (tra.a(this.b)) {}
    for (Object localObject = getString(2131698304);; localObject = getString(2131698306))
    {
      ((QCircleStatusView)this.jdField_a_of_type_Tvw.a().a()).b((String)localObject);
      ((QCircleStatusView)this.jdField_a_of_type_Tvw.a().a()).setVisibility(8);
      this.jdField_a_of_type_Tvw.a().a().setNestedScrollingEnabled(true);
      return;
    }
  }
  
  public boolean a()
  {
    return tra.a(this.b);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ubq != null) {
      this.jdField_a_of_type_Ubq.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalDynamicFragment
 * JD-Core Version:    0.7.0.1
 */