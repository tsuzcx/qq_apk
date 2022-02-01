package androidx.viewpager2.adapter;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;

class FragmentStateAdapter$1
  implements View.OnLayoutChangeListener
{
  FragmentStateAdapter$1(FragmentStateAdapter paramFragmentStateAdapter, FrameLayout paramFrameLayout, FragmentViewHolder paramFragmentViewHolder) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.val$container.getParent() != null)
    {
      this.val$container.removeOnLayoutChangeListener(this);
      this.this$0.placeFragmentInViewHolder(this.val$holder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.1
 * JD-Core Version:    0.7.0.1
 */