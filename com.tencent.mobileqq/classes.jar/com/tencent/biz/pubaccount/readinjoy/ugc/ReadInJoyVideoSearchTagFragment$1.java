package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.widget.ArrayAdapter;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ReadInJoyVideoSearchTagFragment$1
  extends ReadInJoyObserver
{
  ReadInJoyVideoSearchTagFragment$1(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment) {}
  
  public void c(List<TagInfo> paramList)
  {
    ReadInJoyVideoSearchTagFragment.a(this.a).setNotifyOnChange(false);
    ReadInJoyVideoSearchTagFragment.a(this.a).clear();
    ReadInJoyVideoSearchTagFragment.a(this.a).setNotifyOnChange(true);
    ReadInJoyVideoSearchTagFragment.a(this.a).addAll(paramList);
    if (paramList.isEmpty()) {
      QQToast.a(this.a.getActivity(), 2131718392, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment.1
 * JD-Core Version:    0.7.0.1
 */