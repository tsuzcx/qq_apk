package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.FontSizePanel;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoyShareHelper$2
  implements RangeButtonView.OnChangeListener
{
  ReadInJoyShareHelper$2(ReadInJoyShareHelper paramReadInJoyShareHelper) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ReadInJoyShareHelper.a(this.a, paramInt2);
    float f = ReadInJoyShareHelper.a(this.a).a(ReadInJoyShareHelper.a(this.a));
    ReadInJoyHelper.a("readinjoy_font_size_sp", Float.valueOf(f));
    ReadInJoyHelper.a("readinjoy_font_size_index_sp" + ReadInJoyUtils.a(), Integer.valueOf(ReadInJoyShareHelper.a(this.a)));
    if (ReadInJoyShareHelper.a(this.a) != null) {
      ReadInJoyShareHelper.a(this.a).a(ReadInJoyShareHelper.a(this.a), f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.2
 * JD-Core Version:    0.7.0.1
 */