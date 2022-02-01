package com.tencent.biz.qqcircle.fragments.person;

import aabd;
import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import uzg;
import uzt;
import vpy;
import vpz;
import vxe;

public class QCirclePersonalDynamicFragment
  extends QCirclePersonalBaseBottomFragment
{
  public String a()
  {
    return "profile_moment";
  }
  
  protected void a()
  {
    this.b = getString(2131697282);
    Object localObject = new QCirclePersonalBottomStatusView(getActivity());
    ((QCirclePersonalBottomStatusView)localObject).setOwnerPicAndText("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/2-halfscreen/text_halfscreen_03.png", getString(2131697285));
    ((QCirclePersonalBottomStatusView)localObject).setReportBean(a());
    this.jdField_a_of_type_Aabd.a().setStatusView((StatusView)localObject);
    if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter instanceof uzt))
    {
      localObject = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject).pageType = 8;
      ((uzt)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter).a((ExtraTypeInfo)localObject);
      ((uzt)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter).c(1);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Vxe = ((vxe)a(a(), null, vxe.class));
      this.jdField_a_of_type_Vxe.b().observe(a(), new vpy(this));
      this.jdField_a_of_type_Vxe.d().observe(a(), new vpz(this));
    }
    this.jdField_a_of_type_Aabd.a().a().setNestedScrollingEnabled(true);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Vxe != null) {
      this.jdField_a_of_type_Vxe.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public String c()
  {
    return "QCirclePersonalDynamicFragment";
  }
  
  public boolean d()
  {
    return uzg.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDynamicFragment
 * JD-Core Version:    0.7.0.1
 */