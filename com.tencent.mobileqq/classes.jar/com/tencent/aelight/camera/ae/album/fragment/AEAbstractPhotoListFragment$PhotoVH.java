package com.tencent.aelight.camera.ae.album.fragment;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.NumberCheckBox;

public class AEAbstractPhotoListFragment$PhotoVH
  extends RecyclerView.ViewHolder
{
  public ImageView a;
  public ImageView b;
  public ImageView c;
  public ImageView d;
  public NumberCheckBox e;
  public URLDrawable f;
  public TextView g;
  public View h;
  public TextView i;
  public AEAbstractPhotoListFragment.PhotoItemClickListener j;
  
  public AEAbstractPhotoListFragment$PhotoVH(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment, View paramView)
  {
    super(paramView);
    this.b = ((ImageView)paramView.findViewById(2063991308));
    this.a = ((ImageView)paramView.findViewById(2063991299));
    this.c = ((ImageView)paramView.findViewById(2063991146));
    this.h = paramView.findViewById(2063991309);
    this.e = ((NumberCheckBox)paramView.findViewById(2063991310));
    this.g = ((TextView)paramView.findViewById(2063991312));
    this.d = ((ImageView)paramView.findViewById(2063991296));
    paramAEAbstractPhotoListFragment = this.d;
    if (paramAEAbstractPhotoListFragment != null) {
      paramAEAbstractPhotoListFragment.setVisibility(8);
    }
    if (this.e != null) {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.e, false);
    }
    if (this.g != null) {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.g, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH
 * JD-Core Version:    0.7.0.1
 */