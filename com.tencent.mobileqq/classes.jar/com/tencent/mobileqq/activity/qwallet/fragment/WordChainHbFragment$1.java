package com.tencent.mobileqq.activity.qwallet.fragment;

import aiuh;
import aiul;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import xod;

public class WordChainHbFragment$1
  implements Runnable
{
  WordChainHbFragment$1(WordChainHbFragment paramWordChainHbFragment) {}
  
  public void run()
  {
    if ((WordChainHbFragment.a(this.this$0) != null) && (WordChainHbFragment.a(this.this$0).size() > 0) && (WordChainHbFragment.a(this.this$0) != null))
    {
      Iterator localIterator = WordChainHbFragment.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        aiul localaiul = (aiul)localIterator.next();
        TextView localTextView = new TextView(this.this$0.mActivity);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.leftMargin = xod.a(this.this$0.mActivity, 5.0F);
        localMarginLayoutParams.rightMargin = xod.a(this.this$0.mActivity, 5.0F);
        localMarginLayoutParams.bottomMargin = xod.a(this.this$0.mActivity, 10.0F);
        WordChainHbFragment.a(this.this$0).addView(localTextView, localMarginLayoutParams);
        localTextView.setText(localaiul.a);
        localTextView.setPadding(xod.a(this.this$0.mActivity, 16.0F), xod.a(this.this$0.mActivity, 5.0F), xod.a(this.this$0.mActivity, 16.0F), xod.a(this.this$0.mActivity, 5.0F));
        localTextView.setTextColor(Color.parseColor("#03081A"));
        localTextView.setTag(localaiul);
        localTextView.setBackgroundDrawable(this.this$0.getResources().getDrawable(2130846755));
        localTextView.setOnClickListener(new aiuh(this, localTextView, localaiul));
      }
      WordChainHbFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.1
 * JD-Core Version:    0.7.0.1
 */