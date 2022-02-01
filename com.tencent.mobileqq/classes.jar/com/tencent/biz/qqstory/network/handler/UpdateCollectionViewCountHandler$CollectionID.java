package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollectionID;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class UpdateCollectionViewCountHandler$CollectionID
{
  public int a;
  public int b;
  
  public qqstory_struct.DateVideoCollectionID a()
  {
    qqstory_struct.DateVideoCollectionID localDateVideoCollectionID = new qqstory_struct.DateVideoCollectionID();
    localDateVideoCollectionID.collection_id.set(this.a);
    localDateVideoCollectionID.collection_type.set(this.b);
    return localDateVideoCollectionID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.UpdateCollectionViewCountHandler.CollectionID
 * JD-Core Version:    0.7.0.1
 */