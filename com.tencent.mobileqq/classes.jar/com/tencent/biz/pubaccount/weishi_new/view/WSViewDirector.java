package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.view.View;

public class WSViewDirector
{
  protected final View a;
  
  protected WSViewDirector(View paramView)
  {
    this.a = paramView;
  }
  
  protected <T extends View> T a(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
  
  protected Context g()
  {
    return this.a.getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSViewDirector
 * JD-Core Version:    0.7.0.1
 */