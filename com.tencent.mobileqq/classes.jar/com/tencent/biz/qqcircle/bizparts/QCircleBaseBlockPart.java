package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;

public class QCircleBaseBlockPart
  extends BlockPart
  implements ReportBean<QCircleReportBean>
{
  protected QCircleReportBean a;
  
  public QCircleBaseBlockPart() {}
  
  public QCircleBaseBlockPart(int paramInt1, List<MultiViewBlock> paramList, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramList, paramInt2, paramInt3);
  }
  
  protected BlockContainer a(Context paramContext)
  {
    return new QCircleBlockContainer(paramContext);
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.a = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public IStatusViewProvider bc_()
  {
    if (this.d != null)
    {
      if (this.d.getStatusInterface() != null) {
        return this.d.getStatusInterface();
      }
      QCircleStatusView localQCircleStatusView = new QCircleStatusView(g());
      this.d.setStatusViewInterface(localQCircleStatusView);
      return localQCircleStatusView;
    }
    return null;
  }
  
  public QCircleBaseFragment bd_()
  {
    BasePartFragment localBasePartFragment = super.j();
    if ((localBasePartFragment instanceof QCircleBaseFragment)) {
      return (QCircleBaseFragment)localBasePartFragment;
    }
    return null;
  }
  
  public QCircleBlockContainer be_()
  {
    if ((this.d instanceof QCircleBlockContainer)) {
      return (QCircleBlockContainer)this.d;
    }
    return null;
  }
  
  public QCircleReportBean d()
  {
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    return QCircleReportBean.getReportBean(a(), this.a);
  }
  
  protected int e()
  {
    return QCircleReportBean.getParentPageId(a(), this.a);
  }
  
  protected int f()
  {
    return QCircleReportBean.getPageId(a(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart
 * JD-Core Version:    0.7.0.1
 */