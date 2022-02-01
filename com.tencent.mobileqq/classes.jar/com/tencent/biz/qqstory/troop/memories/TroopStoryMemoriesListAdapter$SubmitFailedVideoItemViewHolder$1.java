package com.tencent.biz.qqstory.troop.memories;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopStoryMemoriesListAdapter$SubmitFailedVideoItemViewHolder$1
  implements View.OnClickListener
{
  TroopStoryMemoriesListAdapter$SubmitFailedVideoItemViewHolder$1(TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder paramSubmitFailedVideoItemViewHolder, TroopStoryItemInfo paramTroopStoryItemInfo) {}
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.a.storyId);
    if (localStoryVideoItem != null) {
      ((StoryVideoUploadManager)SuperManager.c().b(3)).a(localStoryVideoItem);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */