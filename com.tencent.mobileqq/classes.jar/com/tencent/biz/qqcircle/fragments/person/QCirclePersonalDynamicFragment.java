package com.tencent.biz.qqcircle.fragments.person;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import uxx;
import uyk;
import vnt;
import vuf;
import zxi;

public class QCirclePersonalDynamicFragment
  extends QCirclePersonalBaseBottomFragment
{
  public String a()
  {
    return "profile_moment";
  }
  
  protected void a()
  {
    this.b = getString(2131697214);
    Object localObject = new QCirclePersonalBottomStatusView(getActivity());
    ((QCirclePersonalBottomStatusView)localObject).setOwnerPicAndText("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/2-halfscreen/text_halfscreen_03.png", getString(2131697216));
    ((QCirclePersonalBottomStatusView)localObject).setReportBean(a());
    this.jdField_a_of_type_Zxi.a().setStatusView((StatusView)localObject);
    if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter instanceof uyk))
    {
      localObject = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject).pageType = 8;
      ((uyk)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter).a((ExtraTypeInfo)localObject);
      ((uyk)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter).c(1);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Vuf = ((vuf)a(a(), null, vuf.class));
      this.jdField_a_of_type_Vuf.b().observe(a(), new vnt(this));
    }
    this.jdField_a_of_type_Zxi.a().a().setNestedScrollingEnabled(true);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Vuf != null) {
      this.jdField_a_of_type_Vuf.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean d()
  {
    return uxx.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDynamicFragment
 * JD-Core Version:    0.7.0.1
 */