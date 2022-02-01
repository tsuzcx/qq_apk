package com.tencent.biz.qqstory.view.widget;

import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;

public class StorySimpleLoadView
  extends RelativeLayout
{
  public StorySimpleLoadView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StorySimpleLoadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StorySimpleLoadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    ProgressBar localProgressBar = new ProgressBar(getContext());
    localProgressBar.setIndeterminate(true);
    localProgressBar.setIndeterminateDrawable(getContext().getResources().getDrawable(2130846828));
    localProgressBar.setId(2131370286);
    int i = UIUtils.dip2px(getContext(), 24.0F);
    Object localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    addView(localProgressBar, (ViewGroup.LayoutParams)localObject);
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(amtj.a(2131713595));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(3, localProgressBar.getId());
    addView((View)localObject, localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StorySimpleLoadView
 * JD-Core Version:    0.7.0.1
 */