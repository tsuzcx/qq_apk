package com.tencent.biz.qqstory.msgTabNode.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import java.util.List;

public abstract interface MsgTabVideoPreloaderDataProvider$DataProviderListener
{
  public abstract void a(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo, Error paramError);
  
  public abstract void a(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo, @NonNull List<StoryVideoItem> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.DataProviderListener
 * JD-Core Version:    0.7.0.1
 */