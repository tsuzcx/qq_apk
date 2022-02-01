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
    FilterAdapter.FilterItemContent localFilterItemContent = (FilterAdapter.FilterItemContent)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
    boolean bool = localFilterItemContent.jdField_a_of_type_Boolean;
    if (bool)
    {
      if (EmoticonGroupStoreFragment.b(this.a).contains(localFilterItemContent.jdField_a_of_type_JavaLangString)) {
        EmoticonGroupStoreFragment.b(this.a).remove(localFilterItemContent.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      EmoticonGroupStoreFragment.b(this.a).add(localFilterItemContent.jdField_a_of_type_JavaLangString);
    }
    ((FilterAdapter.FilterItemContent)EmoticonGroupStoreFragment.a(this.a).get(paramInt)).jdField_a_of_type_Boolean = (bool ^ true);
    EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.2
 * JD-Core Version:    0.7.0.1
 */