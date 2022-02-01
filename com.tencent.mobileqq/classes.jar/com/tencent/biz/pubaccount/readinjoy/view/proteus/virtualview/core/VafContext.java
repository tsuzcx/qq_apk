package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;

public class VafContext
{
  public static final int SLOP = 5;
  private Context context;
  private Activity curActivity;
  private BaseTemplateFactory templateFactory;
  private ViewFactory viewFactory = new ViewFactory();
  
  public Context getContext()
  {
    return this.context;
  }
  
  public Activity getCurActivity()
  {
    return this.curActivity;
  }
  
  public BaseTemplateFactory getTemplateFactory()
  {
    return this.templateFactory;
  }
  
  public ViewFactory getViewFactory()
  {
    return this.viewFactory;
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
    this.viewFactory.init(paramContext);
  }
  
  public void setCurActivity(Activity paramActivity)
  {
    this.curActivity = paramActivity;
  }
  
  public void setTemplateFactory(BaseTemplateFactory paramBaseTemplateFactory)
  {
    this.templateFactory = paramBaseTemplateFactory;
  }
  
  public void setViewFactory(ViewFactory paramViewFactory)
  {
    if (paramViewFactory != null) {
      this.viewFactory = paramViewFactory;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext
 * JD-Core Version:    0.7.0.1
 */