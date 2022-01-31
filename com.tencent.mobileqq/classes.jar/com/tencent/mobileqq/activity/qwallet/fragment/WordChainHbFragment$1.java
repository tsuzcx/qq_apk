package com.tencent.mobileqq.activity.qwallet.fragment;

import aiyw;
import aiza;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import xsm;

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
        aiza localaiza = (aiza)localIterator.next();
        TextView localTextView = new TextView(this.this$0.mActivity);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.leftMargin = xsm.a(this.this$0.mActivity, 5.0F);
        localMarginLayoutParams.rightMargin = xsm.a(this.this$0.mActivity, 5.0F);
        localMarginLayoutParams.bottomMargin = xsm.a(this.this$0.mActivity, 10.0F);
        WordChainHbFragment.a(this.this$0).addView(localTextView, localMarginLayoutParams);
        localTextView.setText(localaiza.a);
        localTextView.setPadding(xsm.a(this.this$0.mActivity, 16.0F), xsm.a(this.this$0.mActivity, 5.0F), xsm.a(this.this$0.mActivity, 16.0F), xsm.a(this.this$0.mActivity, 5.0F));
        localTextView.setTextColor(Color.parseColor("#03081A"));
        localTextView.setTag(localaiza);
        localTextView.setBackgroundDrawable(this.this$0.getResources().getDrawable(2130846828));
        localTextView.setOnClickListener(new aiyw(this, localTextView, localaiza));
      }
      WordChainHbFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.1
 * JD-Core Version:    0.7.0.1
 */