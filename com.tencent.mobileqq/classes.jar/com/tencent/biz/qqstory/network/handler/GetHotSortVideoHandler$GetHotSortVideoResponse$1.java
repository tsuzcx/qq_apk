package com.tencent.biz.qqstory.network.handler;

import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import wad;
import wiz;
import wjs;
import wqi;
import wqk;
import wql;

public class GetHotSortVideoHandler$GetHotSortVideoResponse$1
  implements Runnable
{
  public GetHotSortVideoHandler$GetHotSortVideoResponse$1(wqk paramwqk, ArrayList paramArrayList, wql paramwql) {}
  
  public void run()
  {
    ((wiz)wjs.a(25)).a(this.jdField_a_of_type_JavaUtilArrayList, wqi.a(this.jdField_a_of_type_Wqk.a), true);
    this.jdField_a_of_type_Wql.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    wad.a().dispatch(this.jdField_a_of_type_Wql);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1
 * JD-Core Version:    0.7.0.1
 */