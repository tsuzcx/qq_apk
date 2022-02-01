package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType$Companion;", "", "()V", "fromInt", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;", "operation", "", "fromPBInt", "value", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertRecordAction$ActionType$Companion
{
  @NotNull
  public final RIJFeedsDynamicInsertRecordAction.ActionType a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_NONE;
    case 1: 
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_FOLLOW;
    case 2: 
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_LOVE;
    case 3: 
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SEE_LATER;
    case 4: 
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SHARE;
    case 5: 
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS;
    case 7: 
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ARTICLE_READ_PROGRESS;
    }
    return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_DATA_CARD_FOLLOW;
  }
  
  @NotNull
  public final RIJFeedsDynamicInsertRecordAction.ActionType b(int paramInt)
  {
    if (paramInt == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_FOLLOW.getActionType()) {
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_FOLLOW;
    }
    if (paramInt == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_LOVE.getActionType()) {
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_LOVE;
    }
    if (paramInt == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SEE_LATER.getActionType()) {
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SEE_LATER;
    }
    if (paramInt == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SHARE.getActionType()) {
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SHARE;
    }
    if (paramInt == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS.getActionType()) {
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS;
    }
    if (paramInt == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ARTICLE_READ_PROGRESS.getActionType()) {
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ARTICLE_READ_PROGRESS;
    }
    if (paramInt == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_DATA_CARD_FOLLOW.getActionType()) {
      return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_DATA_CARD_FOLLOW;
    }
    return RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_NONE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType.Companion
 * JD-Core Version:    0.7.0.1
 */