package com.tencent.biz.qqcircle.immersive.personal.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.biz.qqcircle.immersive.QFSPersonalFeedFragment;
import java.util.ArrayList;
import java.util.List;

public class QFSPersonalFeedVpAdapter
  extends FragmentStateAdapter
{
  private List<QFSPersonalFeedFragment> a = new ArrayList();
  
  public QFSPersonalFeedVpAdapter(@NonNull Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public void a(List<QFSPersonalFeedFragment> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  @NonNull
  public Fragment createFragment(int paramInt)
  {
    return (Fragment)this.a.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedVpAdapter
 * JD-Core Version:    0.7.0.1
 */