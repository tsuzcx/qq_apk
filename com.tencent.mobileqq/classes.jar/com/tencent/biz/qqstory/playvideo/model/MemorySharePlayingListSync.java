package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import ntj;

public class MemorySharePlayingListSync
  extends BasePagePlayingListSync
{
  protected int c;
  protected String c;
  protected int d;
  public String d;
  protected int e;
  protected String e;
  
  private MemorySharePlayingListSync(String paramString1, String paramString2)
  {
    super(paramString2);
    AssertUtils.a(paramString1);
    SLog.e("Q.qqstory.player.MemorySharePlayingListSync", "init MemorySharePlayingListSync while unionId is null!");
    this.jdField_d_of_type_JavaLangString = paramString1;
    a(true);
  }
  
  public static MemorySharePlayingListSync a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString1 = new MemorySharePlayingListSync(paramString1, paramString2);
    paramString1.jdField_c_of_type_JavaLangString = paramString3;
    paramString1.jdField_c_of_type_Int = paramInt;
    return paramString1;
  }
  
  public static MemorySharePlayingListSync a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramString1 = new MemorySharePlayingListSync(paramString1, paramString2);
    paramString1.jdField_e_of_type_JavaLangString = paramString3;
    paramString1.jdField_d_of_type_Int = paramInt1;
    paramString1.jdField_e_of_type_Int = paramInt2;
    return paramString1;
  }
  
  protected int a()
  {
    return 25;
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.jdField_c_of_type_Boolean = true;
    GetCollectionVideoListRequest localGetCollectionVideoListRequest = new GetCollectionVideoListRequest();
    localGetCollectionVideoListRequest.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    if (this.jdField_c_of_type_JavaLangString != null) {
      localGetCollectionVideoListRequest.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(this.jdField_c_of_type_JavaLangString);
    }
    localGetCollectionVideoListRequest.jdField_d_of_type_JavaLangString = this.a;
    localGetCollectionVideoListRequest.jdField_c_of_type_Int = 20;
    localGetCollectionVideoListRequest.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
    localGetCollectionVideoListRequest.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localGetCollectionVideoListRequest.f = this.jdField_d_of_type_Int;
    localGetCollectionVideoListRequest.g = this.jdField_e_of_type_Int;
    SLog.d("Q.qqstory.player.MemorySharePlayingListSync", "loadCollectionVideo with timezone. uid=%s feedid=%s identify=%d collectionId=%s timeZoneOffset=%d", new Object[] { this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, Integer.valueOf(this.jdField_d_of_type_Int), this.jdField_c_of_type_JavaLangString, Integer.valueOf(localGetCollectionVideoListRequest.jdField_e_of_type_Int) });
    CmdTaskManger.a().a(localGetCollectionVideoListRequest, new ntj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync
 * JD-Core Version:    0.7.0.1
 */