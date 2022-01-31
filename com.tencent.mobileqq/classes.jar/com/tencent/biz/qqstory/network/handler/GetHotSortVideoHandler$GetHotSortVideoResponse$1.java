package com.tencent.biz.qqstory.network.handler;

import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import sgi;
import spn;
import sqg;
import sww;
import swy;
import swz;

public class GetHotSortVideoHandler$GetHotSortVideoResponse$1
  implements Runnable
{
  public GetHotSortVideoHandler$GetHotSortVideoResponse$1(swy paramswy, ArrayList paramArrayList, swz paramswz) {}
  
  public void run()
  {
    ((spn)sqg.a(25)).a(this.jdField_a_of_type_JavaUtilArrayList, sww.a(this.jdField_a_of_type_Swy.a), true);
    this.jdField_a_of_type_Swz.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    sgi.a().dispatch(this.jdField_a_of_type_Swz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1
 * JD-Core Version:    0.7.0.1
 */