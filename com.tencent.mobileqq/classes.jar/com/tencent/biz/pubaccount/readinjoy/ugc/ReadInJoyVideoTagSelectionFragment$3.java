package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import java.util.List;

class ReadInJoyVideoTagSelectionFragment$3
  extends ReadInJoyObserver
{
  ReadInJoyVideoTagSelectionFragment$3(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void c(List<TagInfo> paramList)
  {
    ReadInJoyVideoTagSelectionFragment.a(this.a).addAll(paramList);
    ReadInJoyLogicEngineEventDispatcher.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment.3
 * JD-Core Version:    0.7.0.1
 */