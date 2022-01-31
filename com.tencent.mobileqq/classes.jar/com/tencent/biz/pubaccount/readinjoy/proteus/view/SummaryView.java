package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeArticleCommentSummaryView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;

public class SummaryView
  extends TextBase
{
  private NativeArticleCommentSummaryView a;
  private final int z = -16777216;
  
  public SummaryView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.C = Utils.a(17.0D);
    this.a = new NativeArticleCommentSummaryView(paramVafContext.a());
    this.a.setTextColor(-16777216);
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.a.setModel(paramIReadInJoyModel);
    if (paramIReadInJoyModel.a() == null) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    this.a.a(paramIReadInJoyModel, localSpannableStringBuilder);
    this.a.b(paramIReadInJoyModel, localSpannableStringBuilder);
    this.a.setText(localSpannableStringBuilder);
  }
  
  public int a()
  {
    return this.a.a();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a()
  {
    super.a();
    this.a.setBackgroundColor(this.d);
    this.a.setTextSize(0, this.C);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected boolean a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
    return true;
  }
  
  public int b()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.SummaryView
 * JD-Core Version:    0.7.0.1
 */