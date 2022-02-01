package com.tencent.biz.qqstory.network.handler;

import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import vli;
import vue;
import vux;
import wbn;
import wbp;
import wbq;

public class GetHotSortVideoHandler$GetHotSortVideoResponse$1
  implements Runnable
{
  public GetHotSortVideoHandler$GetHotSortVideoResponse$1(wbp paramwbp, ArrayList paramArrayList, wbq paramwbq) {}
  
  public void run()
  {
    ((vue)vux.a(25)).a(this.jdField_a_of_type_JavaUtilArrayList, wbn.a(this.jdField_a_of_type_Wbp.a), true);
    this.jdField_a_of_type_Wbq.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    vli.a().dispatch(this.jdField_a_of_type_Wbq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1
 * JD-Core Version:    0.7.0.1
 */