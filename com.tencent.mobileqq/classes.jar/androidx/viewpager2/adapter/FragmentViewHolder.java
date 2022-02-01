package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public final class FragmentViewHolder
  extends RecyclerView.ViewHolder
{
  private FragmentViewHolder(@NonNull FrameLayout paramFrameLayout)
  {
    super(paramFrameLayout);
  }
  
  @NonNull
  static FragmentViewHolder create(@NonNull ViewGroup paramViewGroup)
  {
    paramViewGroup = new FrameLayout(paramViewGroup.getContext());
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramViewGroup.setId(ViewCompat.generateViewId());
    paramViewGroup.setSaveEnabled(false);
    return new FragmentViewHolder(paramViewGroup);
  }
  
  @NonNull
  FrameLayout getContainer()
  {
    return (FrameLayout)this.itemView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentViewHolder
 * JD-Core Version:    0.7.0.1
 */