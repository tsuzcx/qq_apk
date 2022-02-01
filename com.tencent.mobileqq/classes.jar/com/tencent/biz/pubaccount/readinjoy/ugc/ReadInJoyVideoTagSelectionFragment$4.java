package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class ReadInJoyVideoTagSelectionFragment$4
  implements AdapterView.OnItemClickListener
{
  ReadInJoyVideoTagSelectionFragment$4(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (TagInfo)ReadInJoyVideoTagSelectionFragment.a(this.a).getItem(paramInt);
    ReadInJoyVideoTagSelectionFragment.a(this.a).b(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment.4
 * JD-Core Version:    0.7.0.1
 */