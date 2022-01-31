package com.tencent.biz.qqstory.storyHome.memory.view.adapter;

import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;

public class MemoriesInnerListAdapter$PublishVideoItem
  extends VideoCollectionItem.FakeVideoUIItem
{
  public MemoriesInnerListAdapter$PublishVideoItem()
  {
    super("memory_publish", null);
  }
  
  public static boolean a(VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem)
  {
    return TextUtils.equals("memory_publish", paramFakeVideoUIItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter.PublishVideoItem
 * JD-Core Version:    0.7.0.1
 */