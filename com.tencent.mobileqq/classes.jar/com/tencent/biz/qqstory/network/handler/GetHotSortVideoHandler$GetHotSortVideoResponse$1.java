package com.tencent.biz.qqstory.network.handler;

import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import stb;
import tcg;
import tcz;
import tjp;
import tjr;
import tjs;

public class GetHotSortVideoHandler$GetHotSortVideoResponse$1
  implements Runnable
{
  public GetHotSortVideoHandler$GetHotSortVideoResponse$1(tjr paramtjr, ArrayList paramArrayList, tjs paramtjs) {}
  
  public void run()
  {
    ((tcg)tcz.a(25)).a(this.jdField_a_of_type_JavaUtilArrayList, tjp.a(this.jdField_a_of_type_Tjr.a), true);
    this.jdField_a_of_type_Tjs.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    stb.a().dispatch(this.jdField_a_of_type_Tjs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1
 * JD-Core Version:    0.7.0.1
 */