package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;

public class MemorySharePlayingListSync
  extends BasePagePlayingListSync
{
  protected int b;
  protected int c;
  protected String c;
  protected int d;
  protected String d;
  protected String e;
  
  protected void a() {}
  
  protected void b()
  {
    this.jdField_c_of_type_Boolean = true;
    GetCollectionVideoListRequest localGetCollectionVideoListRequest = new GetCollectionVideoListRequest();
    localGetCollectionVideoListRequest.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    if (this.jdField_c_of_type_JavaLangString != null) {
      localGetCollectionVideoListRequest.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(this.jdField_c_of_type_JavaLangString);
    }
    localGetCollectionVideoListRequest.jdField_d_of_type_JavaLangString = this.a;
    localGetCollectionVideoListRequest.jdField_c_of_type_Int = 20;
    localGetCollectionVideoListRequest.jdField_e_of_type_Int = this.b;
    localGetCollectionVideoListRequest.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localGetCollectionVideoListRequest.f = this.jdField_c_of_type_Int;
    localGetCollectionVideoListRequest.g = this.jdField_d_of_type_Int;
    SLog.d("Q.qqstory.player.MemorySharePlayingListSync", "loadCollectionVideo with timezone. uid=%s feedid=%s identify=%d collectionId=%s timeZoneOffset=%d", new Object[] { this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_c_of_type_JavaLangString, Integer.valueOf(localGetCollectionVideoListRequest.jdField_e_of_type_Int) });
    CmdTaskManger.a().a(localGetCollectionVideoListRequest, new MemorySharePlayingListSync.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync
 * JD-Core Version:    0.7.0.1
 */