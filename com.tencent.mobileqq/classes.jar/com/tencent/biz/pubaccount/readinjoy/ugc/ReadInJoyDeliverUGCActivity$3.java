package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import java.util.List;

class ReadInJoyDeliverUGCActivity$3
  implements AdapterView.OnItemLongClickListener
{
  ReadInJoyDeliverUGCActivity$3(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!ReadInJoyDeliverUGCActivity.a(this.a).a().get(paramInt).equals(ReadInJoyDeliverUGCActivity.a(this.a))) {
      ReadInJoyDeliverUGCActivity.a(this.a).a(paramInt);
    }
    ReadInJoyDeliverUGCActivity.a(this.a, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.3
 * JD-Core Version:    0.7.0.1
 */