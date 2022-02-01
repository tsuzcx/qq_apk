package com.tencent.biz.qqstory.shareGroup.infocard.model;

import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.handler.VidToShareGroupVideoInfoHandler;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import java.util.List;

public class ShareGroupDataPuller
  extends MemoryDataPuller
{
  protected final int a;
  protected final String a;
  
  public ShareGroupDataPuller(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public BatchNetHandler a(String paramString, List<String> paramList)
  {
    return new VidToShareGroupVideoInfoHandler(paramString, paramList);
  }
  
  public INetPageLoader a()
  {
    return new ShareGroupDateListPageLoader(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDataPuller
 * JD-Core Version:    0.7.0.1
 */