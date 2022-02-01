package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.PressedSpan;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class NativeCommentView$1
  extends PressedSpan
{
  NativeCommentView$1(NativeCommentView paramNativeCommentView, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a.a();
    if (paramView.isPGCShortContent())
    {
      RIJFrameworkReportManager.a(this.a.getContext(), paramView, (int)paramView.mChannelID);
      PGCShortContentUtils.a(this.a.getContext(), paramView);
      return;
    }
    RIJJumpUtils.a(this.a.getContext(), this.a.a.a.a(), 1, false, 8, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView.1
 * JD-Core Version:    0.7.0.1
 */