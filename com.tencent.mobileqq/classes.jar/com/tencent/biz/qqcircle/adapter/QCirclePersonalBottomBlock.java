package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;

public class QCirclePersonalBottomBlock
  extends QCircleBaseSingleViewBlock
{
  private QCirclePersonalBottomView a;
  private QCirclePersonalDetailViewModel c;
  private QCircleInitBean d;
  
  public QCirclePersonalBottomBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void c()
  {
    this.c = ((QCirclePersonalDetailViewModel)getViewModel(QCirclePersonalDetailViewModel.class));
    QCirclePersonalDetailViewModel localQCirclePersonalDetailViewModel = this.c;
    if (localQCirclePersonalDetailViewModel == null)
    {
      QLog.e("QCirclePersonalBottomBlock", 1, "initModel error");
      return;
    }
    localQCirclePersonalDetailViewModel.e().observe((QCircleBaseFragment)getParentFragment(), new QCirclePersonalBottomBlock.1(this));
    this.c.b().observe((QCircleBaseFragment)getParentFragment(), new QCirclePersonalBottomBlock.2(this));
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QCirclePersonalBottomView(paramViewGroup.getContext(), paramMultiViewBlock);
    this.a.setReportBean(d());
    c();
    return this.a;
  }
  
  protected String a()
  {
    return "QCirclePersonalBottomBlock";
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    this.d = paramQCircleInitBean;
  }
  
  public int b()
  {
    QCirclePersonalBottomView localQCirclePersonalBottomView = this.a;
    if (localQCirclePersonalBottomView != null) {
      return localQCirclePersonalBottomView.getCurrentIndex();
    }
    return -1;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCirclePersonalBottomBlock
 * JD-Core Version:    0.7.0.1
 */