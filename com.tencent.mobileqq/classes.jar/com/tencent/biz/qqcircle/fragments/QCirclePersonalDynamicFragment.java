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
import tra;
import trl;
import tvm;
import twn;
import tzf;
import tzm;
import yeb;

public class QCirclePersonalDynamicFragment
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
        if ((this.jdField_a_of_type_Tvm != null) && (this.jdField_a_of_type_Trl != null) && (!this.jdField_a_of_type_Trl.a()))
        {
          if (tra.a(this.b)) {}
          for (paramtzm = getString(2131698301);; paramtzm = getString(2131698303))
          {
            this.jdField_a_of_type_Tvm.a().a().b(paramtzm);
            f();
            this.jdField_a_of_type_Trl.a();
            this.jdField_a_of_type_Trl.notifyDataSetChanged();
            i = 1;
            break;
          }
          if (paramtzm.a() == null) {}
          for (paramtzm = alpo.a(2131720466);; paramtzm = paramtzm.a())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return error！errMsg:" + paramtzm);
            if ((this.jdField_a_of_type_Trl == null) || (this.jdField_a_of_type_Trl.getItemCount() <= 0)) {
              break label298;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramtzm, 1).a();
            i = 1;
            break;
          }
          label298:
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
      localObject = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject).pageType = 8;
      this.jdField_a_of_type_Trl.a((ExtraTypeInfo)localObject);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Tzf = ((tzf)a(a(), null, tzf.class));
      this.jdField_a_of_type_Tzf.b().observe(a(), new twn(this));
    }
    if (tra.a(this.b)) {}
    for (Object localObject = getString(2131698301);; localObject = getString(2131698303))
    {
      this.jdField_a_of_type_Tvm.a().a().b((String)localObject);
      this.jdField_a_of_type_Tvm.a().a().setVisibility(8);
      return;
    }
  }
  
  public boolean a()
  {
    return tra.a(this.b);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Tzf != null) {
      this.jdField_a_of_type_Tzf.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalDynamicFragment
 * JD-Core Version:    0.7.0.1
 */