package com.tencent.mobileqq.activity.emogroupstore;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class EmoticonGroupStoreFragment$2
  implements AdapterView.OnItemClickListener
{
  EmoticonGroupStoreFragment$2(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FilterAdapter.FilterItemContent localFilterItemContent = (FilterAdapter.FilterItemContent)EmoticonGroupStoreFragment.b(this.a).get(paramInt);
    boolean bool = localFilterItemContent.e;
    if (bool)
    {
      if (EmoticonGroupStoreFragment.c(this.a).contains(localFilterItemContent.a)) {
        EmoticonGroupStoreFragment.c(this.a).remove(localFilterItemContent.a);
      }
    }
    else {
      EmoticonGroupStoreFragment.c(this.a).add(localFilterItemContent.a);
    }
    ((FilterAdapter.FilterItemContent)EmoticonGroupStoreFragment.b(this.a).get(paramInt)).e = (bool ^ true);
    EmoticonGroupStoreFragment.d(this.a).notifyDataSetChanged();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.2
 * JD-Core Version:    0.7.0.1
 */