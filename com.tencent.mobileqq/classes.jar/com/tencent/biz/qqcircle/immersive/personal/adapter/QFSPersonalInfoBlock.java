package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.immersive.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

public class QFSPersonalInfoBlock
  extends QCircleBaseSingleViewBlock
{
  public QFSPersonalInfoBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected String a()
  {
    return "QFSPersonalInfoBlock";
  }
  
  protected QCircleBaseWidgetView b(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    paramViewGroup = new QFSPersonalInfoWidget(paramViewGroup.getContext(), (QFSPersonalDetailsFragment)getParentFragment());
    paramViewGroup.setReportBean(d());
    return paramViewGroup;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalInfoBlock
 * JD-Core Version:    0.7.0.1
 */