package com.tencent.biz.subscribe.bizdapters;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class RelativeLiveFeedsAdapter$RelativeFeedVH
  extends RecyclerView.ViewHolder
{
  public TextView a;
  
  public RelativeLiveFeedsAdapter$RelativeFeedVH(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter, View paramView)
  {
    super(paramView);
    if ((paramView instanceof FrameLayout))
    {
      paramRelativeLiveFeedsAdapter = (FrameLayout)paramView;
      if (paramRelativeLiveFeedsAdapter.getChildCount() > 0)
      {
        paramRelativeLiveFeedsAdapter = paramRelativeLiveFeedsAdapter.getChildAt(0);
        if ((paramRelativeLiveFeedsAdapter instanceof TextView)) {
          this.a = ((TextView)paramRelativeLiveFeedsAdapter);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.a;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.RelativeFeedVH
 * JD-Core Version:    0.7.0.1
 */