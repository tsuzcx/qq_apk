package com.tencent.mobileqq.activity.emogroupstore;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class EmoticonGroupStoreFragment$10
  implements View.OnClickListener
{
  EmoticonGroupStoreFragment$10(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((EmoticonFromGroupEntity)localIterator.next()).status = -1;
    }
    this.a.a.clear();
    EmoticonGroupStoreFragment.a(this.a).setVisibility(8);
    EmoticonGroupStoreFragment.b(this.a).setVisibility(0);
    EmoticonGroupStoreFragment.a(this.a).a = false;
    EmoticonGroupStoreFragment.a(this.a).a(false);
    EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
    EmoticonGroupStoreFragment.e(this.a);
    this.a.a(true);
    this.a.resetLeftButton();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.10
 * JD-Core Version:    0.7.0.1
 */