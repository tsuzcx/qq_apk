package com.tencent.mobileqq.activity.aio.photo;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.hiboom.SquareRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.NumberCheckBox;
import mqq.util.WeakReference;

public class PhotoListPanel$PhotoPanelAdapter$RecyclerHolder
  extends RecyclerView.ViewHolder
{
  public SquareRelativeLayout a;
  public URLImageView b;
  public NumberCheckBox c;
  public FrameLayout d;
  public ImageView e;
  public ImageView f;
  public URLDrawable g;
  public View h;
  public TextView i;
  PhotoListPanel.CheckBoxClickedListener j;
  
  public PhotoListPanel$PhotoPanelAdapter$RecyclerHolder(PhotoListPanel.PhotoPanelAdapter paramPhotoPanelAdapter, View paramView)
  {
    super(paramView);
    this.a = ((SquareRelativeLayout)paramView.findViewById(2131433481));
    this.a.setCloseSquare(true);
    this.b = ((URLImageView)paramView.findViewById(2131436048));
    this.j = ((PhotoListPanel)paramPhotoPanelAdapter.a.get()).e();
    this.c = ((NumberCheckBox)paramView.findViewById(2131435966));
    this.h = paramView.findViewById(2131440138);
    this.d = ((FrameLayout)paramView.findViewById(2131435967));
    FrameLayout localFrameLayout = this.d;
    if (localFrameLayout != null)
    {
      localFrameLayout.setOnClickListener(this.j);
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.d, "em_aio_image_quick", null);
    }
    if (((PhotoListPanel)paramPhotoPanelAdapter.a.get()).ai)
    {
      paramPhotoPanelAdapter = this.d;
      if (paramPhotoPanelAdapter != null) {
        paramPhotoPanelAdapter.setVisibility(8);
      }
    }
    this.e = ((ImageView)paramView.findViewById(2131436144));
    this.f = ((ImageView)paramView.findViewById(2131436049));
    this.i = ((TextView)paramView.findViewById(2131436143));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder
 * JD-Core Version:    0.7.0.1
 */