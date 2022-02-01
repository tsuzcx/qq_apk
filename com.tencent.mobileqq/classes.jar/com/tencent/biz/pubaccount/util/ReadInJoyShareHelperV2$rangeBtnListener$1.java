package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.FontSizePanel;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "lastPosition", "", "newPosition", "onChange"}, k=3, mv={1, 1, 16})
final class ReadInJoyShareHelperV2$rangeBtnListener$1
  implements RangeButtonView.OnChangeListener
{
  ReadInJoyShareHelperV2$rangeBtnListener$1(ReadInJoyShareHelperV2 paramReadInJoyShareHelperV2) {}
  
  public final void a(int paramInt1, int paramInt2)
  {
    ReadInJoyShareHelperV2.a(this.a, paramInt2);
    Object localObject = ReadInJoyShareHelperV2.a(this.a);
    if (localObject != null) {}
    for (float f = ((FontSizePanel)localObject).a(ReadInJoyShareHelperV2.a(this.a));; f = 1.0F)
    {
      ReadInJoyHelper.a("readinjoy_font_size_index_sp" + ReadInJoyUtils.a(), Integer.valueOf(ReadInJoyShareHelperV2.a(this.a)));
      localObject = ReadInJoyShareHelperV2.a(this.a);
      if (localObject != null) {
        ((ReadInJoyShareHelperV2.OnFontSizeChangeListener)localObject).a(ReadInJoyShareHelperV2.a(this.a), f);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.rangeBtnListener.1
 * JD-Core Version:    0.7.0.1
 */