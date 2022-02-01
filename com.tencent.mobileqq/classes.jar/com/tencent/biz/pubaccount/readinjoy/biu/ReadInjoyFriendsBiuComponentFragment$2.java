package com.tencent.biz.pubaccount.readinjoy.biu;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class ReadInjoyFriendsBiuComponentFragment$2
  implements AdapterView.OnItemClickListener
{
  ReadInjoyFriendsBiuComponentFragment$2(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.a.doOnBackPressed();
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView instanceof ReadInjoyFriendsBiuComponentFragment.ViewHolder))
    {
      paramAdapterView = (ReadInjoyFriendsBiuComponentFragment.ViewHolder)paramAdapterView;
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramAdapterView.jdField_a_of_type_JavaLangString);
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramAdapterView.jdField_a_of_type_Long, paramAdapterView.b, "0X800953C", paramAdapterView.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment.2
 * JD-Core Version:    0.7.0.1
 */