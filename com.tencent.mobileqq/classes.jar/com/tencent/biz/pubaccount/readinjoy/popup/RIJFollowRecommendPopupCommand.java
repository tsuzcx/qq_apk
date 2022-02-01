package com.tencent.biz.pubaccount.readinjoy.popup;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowRecommendPopupCommand;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "command", "", "obj", "", "(ILjava/lang/Object;)V", "getCommand", "()I", "getObj", "()Ljava/lang/Object;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class RIJFollowRecommendPopupCommand
  extends SimpleBaseEvent
{
  public static final int COMMAND_CLOSE = 1;
  public static final int COMMAND_REFRESH_FOLLOW_UI = 2;
  public static final RIJFollowRecommendPopupCommand.Companion Companion = new RIJFollowRecommendPopupCommand.Companion(null);
  private final int command;
  @Nullable
  private final Object obj;
  
  public RIJFollowRecommendPopupCommand(int paramInt, @Nullable Object paramObject)
  {
    this.command = paramInt;
    this.obj = paramObject;
  }
  
  public final int getCommand()
  {
    return this.command;
  }
  
  @Nullable
  public final Object getObj()
  {
    return this.obj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowRecommendPopupCommand
 * JD-Core Version:    0.7.0.1
 */