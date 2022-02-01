package com.tencent.mobileqq.activity.qwallet.fragment;

import albw;
import alcc;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import zps;

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
        alcc localalcc = (alcc)localIterator.next();
        TextView localTextView = new TextView(this.this$0.mActivity);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.leftMargin = zps.a(this.this$0.mActivity, 5.0F);
        localMarginLayoutParams.rightMargin = zps.a(this.this$0.mActivity, 5.0F);
        localMarginLayoutParams.bottomMargin = zps.a(this.this$0.mActivity, 10.0F);
        WordChainHbFragment.a(this.this$0).addView(localTextView, localMarginLayoutParams);
        localTextView.setText(localalcc.a);
        localTextView.setPadding(zps.a(this.this$0.mActivity, 16.0F), zps.a(this.this$0.mActivity, 5.0F), zps.a(this.this$0.mActivity, 16.0F), zps.a(this.this$0.mActivity, 5.0F));
        localTextView.setTextColor(Color.parseColor("#03081A"));
        localTextView.setTag(localalcc);
        localTextView.setBackgroundDrawable(this.this$0.getResources().getDrawable(2130847295));
        localTextView.setOnClickListener(new albw(this, localTextView, localalcc));
      }
      WordChainHbFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.1
 * JD-Core Version:    0.7.0.1
 */