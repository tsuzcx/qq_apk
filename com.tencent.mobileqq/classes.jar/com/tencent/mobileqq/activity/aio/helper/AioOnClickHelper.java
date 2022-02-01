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
    paramAIOContext.a().a(this);
  }
  
  @NonNull
  public String getTag()
  {
    return "AioOnClickHelper";
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131369202) && (i != 2131369563) && (i != 2131379476) && (i != 2131369985)) {
      com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AioOnClickHelper
 * JD-Core Version:    0.7.0.1
 */