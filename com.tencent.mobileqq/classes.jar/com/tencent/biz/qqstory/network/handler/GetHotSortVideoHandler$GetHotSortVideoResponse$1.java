package com.tencent.biz.qqstory.network.handler;

import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import umc;
import uvh;
import uwa;
import vcq;
import vcs;
import vct;

public class GetHotSortVideoHandler$GetHotSortVideoResponse$1
  implements Runnable
{
  public GetHotSortVideoHandler$GetHotSortVideoResponse$1(vcs paramvcs, ArrayList paramArrayList, vct paramvct) {}
  
  public void run()
  {
    ((uvh)uwa.a(25)).a(this.jdField_a_of_type_JavaUtilArrayList, vcq.a(this.jdField_a_of_type_Vcs.a), true);
    this.jdField_a_of_type_Vct.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    umc.a().dispatch(this.jdField_a_of_type_Vct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1
 * JD-Core Version:    0.7.0.1
 */