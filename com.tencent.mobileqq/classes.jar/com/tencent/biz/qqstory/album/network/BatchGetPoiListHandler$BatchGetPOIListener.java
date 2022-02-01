package com.tencent.biz.qqstory.album.network;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.HashMap;

public abstract interface BatchGetPoiListHandler$BatchGetPOIListener
{
  public abstract void a(ErrorMessage paramErrorMessage, HashMap<String, AddressItem> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.BatchGetPoiListHandler.BatchGetPOIListener
 * JD-Core Version:    0.7.0.1
 */