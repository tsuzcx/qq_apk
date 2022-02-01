package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.NumberCheckBox;

public class PhotoGridAdapter$PhotoVH
  extends RecyclerView.ViewHolder
{
  public ImageView a;
  public ImageView b;
  public ImageView c;
  public NumberCheckBox d;
  public URLDrawable e;
  public TextView f;
  public View g;
  public TextView h;
  public PhotoGridAdapter.PhotoItemClickListener i;
  
  public PhotoGridAdapter$PhotoVH(PhotoGridAdapter paramPhotoGridAdapter, View paramView)
  {
    super(paramView);
    this.a = ((ImageView)paramView.findViewById(2063991308));
    this.b = ((ImageView)paramView.findViewById(2063991146));
    this.g = paramView.findViewById(2063991309);
    this.d = ((NumberCheckBox)paramView.findViewById(2063991310));
    this.f = ((TextView)paramView.findViewById(2063991312));
    this.c = ((ImageView)paramView.findViewById(2063991296));
    paramPhotoGridAdapter = this.c;
    if (paramPhotoGridAdapter != null) {
      paramPhotoGridAdapter.setVisibility(8);
    }
    if (this.d != null) {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.d, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.PhotoVH
 * JD-Core Version:    0.7.0.1
 */