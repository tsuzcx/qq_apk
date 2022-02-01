package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;

public class QuestionOptionsView
  extends GridView
{
  private QuestionOptionsAdapter a;
  private IQuestionOptionPresenter b;
  private int c = -1;
  private QuestionOptionItemConfig d = null;
  
  public QuestionOptionsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QuestionOptionsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QuestionOptionsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    setNumColumns(2);
    setVerticalScrollBarEnabled(false);
    this.b = new QuestionOptionsPresenterImpl(this);
    this.a = new QuestionOptionsAdapter(getContext(), this.b);
  }
  
  public static RelativeLayout.LayoutParams getDefaultLayoutParams()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(97.0F));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(1);
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(16.0F);
    localLayoutParams.leftMargin = ViewUtils.dpToPx(16.0F);
    localLayoutParams.rightMargin = ViewUtils.dpToPx(16.0F);
    return localLayoutParams;
  }
  
  public void a()
  {
    setHorizontalSpacing(ViewUtils.dpToPx(15.0F));
    setVerticalSpacing(ViewUtils.dpToPx(7.0F));
    setVerticalScrollBarEnabled(false);
    setAdapter(this.a);
    setSelector(new ColorDrawable(0));
    setOnItemClickListener(new QuestionOptionsView.1(this));
    post(new QuestionOptionsView.2(this));
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView = getChildAt(paramInt);
    if (localView != null) {
      ((QuestionOptionItemView)localView).a(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public void b()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView != null) {
        ((QuestionOptionItemView)localView).b();
      }
      i += 1;
    }
  }
  
  public IQuestionOptionPresenter getPresenter()
  {
    return this.b;
  }
  
  public void setConfig(QuestionOptionItemConfig paramQuestionOptionItemConfig)
  {
    this.d = paramQuestionOptionItemConfig;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof QuestionOptionItemView)) {
        ((QuestionOptionItemView)localView).setConfig(paramQuestionOptionItemConfig);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView
 * JD-Core Version:    0.7.0.1
 */