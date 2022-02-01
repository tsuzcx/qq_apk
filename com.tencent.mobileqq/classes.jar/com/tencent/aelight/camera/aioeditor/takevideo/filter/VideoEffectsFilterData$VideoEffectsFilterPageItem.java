package com.tencent.aelight.camera.aioeditor.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoEffectsFilterData$VideoEffectsFilterPageItem
  extends FilterData.FilterPageItem<VideoEffectsFilterData>
{
  public final TextView d = (TextView)this.a.findViewById(2131447062);
  public final ImageView e = (ImageView)this.a.findViewById(2131435357);
  public final TextView f = (TextView)this.a.findViewById(2131447151);
  
  VideoEffectsFilterData$VideoEffectsFilterPageItem(VideoEffectsFilterData paramVideoEffectsFilterData, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131628051, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.d.setVisibility(4);
    this.e.setVisibility(4);
  }
  
  public void a(VideoEffectsFilterData paramVideoEffectsFilterData, int paramInt)
  {
    super.a(paramVideoEffectsFilterData, paramInt);
    if ((this.b != null) && (((VideoEffectsFilterData)this.b).e != 0) && (((VideoEffectsFilterData)this.b).b != null))
    {
      this.e.setVisibility(0);
      this.e.setImageResource(((VideoEffectsFilterData)this.b).e);
      this.d.setVisibility(0);
      this.d.setText(((VideoEffectsFilterData)this.b).b);
      this.f.setText(((VideoEffectsFilterData)this.b).d);
      return;
    }
    this.e.setVisibility(4);
    this.d.setVisibility(4);
    this.f.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.filter.VideoEffectsFilterData.VideoEffectsFilterPageItem
 * JD-Core Version:    0.7.0.1
 */