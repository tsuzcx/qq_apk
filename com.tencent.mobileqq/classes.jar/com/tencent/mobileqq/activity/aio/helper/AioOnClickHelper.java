package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AioOnClickHelper
  implements View.OnClickListener, IHelper
{
  private final AIOContext a;
  
  public AioOnClickHelper(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    paramAIOContext.d().a(this);
  }
  
  @NonNull
  public String getTag()
  {
    return "AioOnClickHelper";
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131436180) && (i != 2131436666) && (i != 2131448219) && (i != 2131437136)) {
      com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AioOnClickHelper
 * JD-Core Version:    0.7.0.1
 */