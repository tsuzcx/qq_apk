package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ApolloPanelListAdapter$FrameCallback
  implements GetFrameCallback
{
  private ApolloLinearLayout.ViewHolder a;
  private ApolloInfo b;
  private Context c;
  
  public ApolloPanelListAdapter$FrameCallback(ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo, Context paramContext)
  {
    this.a = paramViewHolder;
    this.b = paramApolloInfo;
    this.c = paramContext;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable MemeAction paramMemeAction)
  {
    if (this.a != null) {
      ThreadManager.getUIHandler().post(new ApolloPanelListAdapter.FrameCallback.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter.FrameCallback
 * JD-Core Version:    0.7.0.1
 */