package com.tencent.biz.qqstory.network.handler;

import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import wfo;
import wot;
import wpm;
import wwc;
import wwe;
import wwf;

public class GetHotSortVideoHandler$GetHotSortVideoResponse$1
  implements Runnable
{
  public GetHotSortVideoHandler$GetHotSortVideoResponse$1(wwe paramwwe, ArrayList paramArrayList, wwf paramwwf) {}
  
  public void run()
  {
    ((wot)wpm.a(25)).a(this.jdField_a_of_type_JavaUtilArrayList, wwc.a(this.jdField_a_of_type_Wwe.a), true);
    this.jdField_a_of_type_Wwf.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    wfo.a().dispatch(this.jdField_a_of_type_Wwf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1
 * JD-Core Version:    0.7.0.1
 */