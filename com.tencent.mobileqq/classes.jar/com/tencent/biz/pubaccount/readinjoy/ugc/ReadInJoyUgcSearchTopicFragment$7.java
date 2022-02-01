package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;

class ReadInJoyUgcSearchTopicFragment$7
  implements SimpleAdapter.ViewBinder
{
  ReadInJoyUgcSearchTopicFragment$7(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public boolean setViewValue(View paramView, Object paramObject, String paramString)
  {
    if (((paramView instanceof TextView)) && ((paramObject instanceof CharSequence)))
    {
      ((TextView)paramView).setText((CharSequence)paramObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment.7
 * JD-Core Version:    0.7.0.1
 */