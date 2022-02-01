package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.immersive.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTab;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import java.util.ArrayList;

public class QFSPersonalBottomBlock
  extends QCircleBaseSingleViewBlock
{
  private QFSPersonalBottomWidget a;
  private ArrayList<QFSPersonalTab> c;
  
  public QFSPersonalBottomBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView<ArrayList<QFSPersonalTab>> a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QFSPersonalBottomWidget(paramViewGroup.getContext(), (QFSPersonalDetailsFragment)getParentFragment());
    paramViewGroup = this.c;
    if (paramViewGroup != null) {
      this.a.setData(paramViewGroup);
    }
    return this.a;
  }
  
  protected String a()
  {
    return "QFSPersonalBottomBlock";
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalBottomBlock
 * JD-Core Version:    0.7.0.1
 */