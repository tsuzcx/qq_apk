package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;

class LocationFaceAdapter$LocationItemLayout
  extends LinearLayout
{
  private int a;
  private int b;
  private float c;
  private int d;
  private View.OnClickListener e;
  private final int f = 5;
  
  public LocationFaceAdapter$LocationItemLayout(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.e = paramOnClickListener;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramFloat;
    paramInt1 = DisplayUtil.b(getContext(), 6.0F);
    paramInt2 = this.a;
    int i = this.b;
    this.d = ((paramInt2 - (i - 1) * 2 * paramInt1) / i);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(17);
    int j = DisplayUtil.b(getContext(), 12.0F);
    int k = (int)((this.d - j * 2) * this.c);
    int i = 0;
    while (i < this.b)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131624736, null);
      int m = this.d;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, m);
      if (i == 0)
      {
        localLayoutParams.setMargins(0, j, j / 2, 0);
      }
      else if (this.b - 1 == i)
      {
        localLayoutParams.setMargins(j / 2, j, 0, 0);
      }
      else
      {
        m = j / 2;
        localLayoutParams.setMargins(m, j, m, 0);
      }
      localView.setLayoutParams(localLayoutParams);
      ((ImageView)localView.findViewById(2131437692)).setPadding(k, k, k, k);
      addView(localView);
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = paramInt;
      if (i >= paramInt) {
        break;
      }
      j = paramInt;
      if (i >= getChildCount()) {
        break;
      }
      getChildAt(i).setVisibility(0);
      i += 1;
    }
    while ((j < this.b) && (j < getChildCount()))
    {
      getChildAt(j).setVisibility(4);
      j += 1;
    }
  }
  
  public void a(LocationFacePackage paramLocationFacePackage, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.b;
    int i = paramInt1 * j;
    if (paramInt1 == paramInt2 - 1) {
      paramInt1 = paramLocationFacePackage.d();
    } else {
      paramInt1 = i + j;
    }
    a(paramInt1 - i);
    paramInt2 = i;
    while (paramInt2 < paramInt1)
    {
      Object localObject1 = getChildAt(paramInt2 - i);
      Object localObject2 = ((View)localObject1).findViewById(2131437705);
      URLImageView localURLImageView = (URLImageView)((View)localObject1).findViewById(2131437692);
      Object localObject3 = (TextView)((View)localObject1).findViewById(2131437706);
      ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131437704);
      String str = paramLocationFacePackage.b(paramInt2);
      localObject1 = paramLocationFacePackage.a(paramInt2);
      if (localObject1 == null)
      {
        SLog.e("LocationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { paramLocationFacePackage.toString() });
      }
      else
      {
        ((TextView)localObject3).setText(str);
        ((View)localObject2).setOnClickListener(this.e);
        localURLImageView.setTag(2131446820, Integer.valueOf(paramInt2));
        if (!paramBoolean)
        {
          localProgressBar.setVisibility(4);
          localURLImageView.setImageDrawable(null);
        }
        else
        {
          localURLImageView.setTag(2131446833, localObject1);
          localURLImageView.setTag(2131446799, Boolean.valueOf(false));
          localProgressBar.setVisibility(0);
          localObject2 = new LocationFaceAdapter.URLDrawableListener((String)localObject1, localURLImageView, localProgressBar);
          localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject2);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
          if (((URLDrawable)localObject1).getStatus() == 1) {
            ((LocationFaceAdapter.URLDrawableListener)localObject2).onLoadSuccessed(localURLImageView, (URLDrawable)localObject1);
          }
          if (!paramBoolean) {
            localObject1 = null;
          }
          localURLImageView.setImageDrawable((Drawable)localObject1);
        }
      }
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.LocationFaceAdapter.LocationItemLayout
 * JD-Core Version:    0.7.0.1
 */