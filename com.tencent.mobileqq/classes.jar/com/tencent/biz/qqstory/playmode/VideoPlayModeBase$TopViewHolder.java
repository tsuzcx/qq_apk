package com.tencent.biz.qqstory.playmode;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public final class VideoPlayModeBase$TopViewHolder
  implements View.OnClickListener
{
  public SparseArray a;
  public LinearLayout a;
  protected VideoPlayModeBase a;
  public LinearLayout b;
  public LinearLayout c;
  public LinearLayout d;
  
  public VideoPlayModeBase$TopViewHolder(VideoPlayModeBase paramVideoPlayModeBase1, VideoPlayModeBase paramVideoPlayModeBase2)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase = paramVideoPlayModeBase2;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase.TopViewHolder
 * JD-Core Version:    0.7.0.1
 */