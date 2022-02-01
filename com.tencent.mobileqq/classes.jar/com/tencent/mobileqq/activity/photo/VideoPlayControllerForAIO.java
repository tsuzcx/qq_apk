package com.tencent.mobileqq.activity.photo;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoPlayControllerForAIO
  extends VideoPlayController
{
  protected VideoPlayControllerForAIO.OnDownloadListener j = null;
  TextView k;
  protected int l = -1;
  private final String m = "VideoPlayControllerForAIO";
  private ImageView n;
  private ImageView o;
  private LinearLayout p;
  private AtomicBoolean q = new AtomicBoolean(false);
  
  public void a()
  {
    this.n = null;
    this.o = null;
    this.p = null;
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = this.n;
    if (localImageView != null) {
      localImageView.setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      b(8);
    }
    LinearLayout localLinearLayout = this.p;
    if (localLinearLayout != null)
    {
      localLinearLayout.setVisibility(paramInt);
      if (this.k == null) {
        this.k = ((TextView)this.p.findViewById(2131432606));
      }
      this.k.setText(paramString);
    }
  }
  
  public void a(View paramView)
  {
    this.n = ((ImageView)paramView.findViewById(2131440625));
    this.o = ((ImageView)paramView.findViewById(2131440624));
    this.p = ((LinearLayout)paramView.findViewById(2131440626));
  }
  
  public void a(VideoPlayControllerForAIO.OnDownloadListener paramOnDownloadListener)
  {
    this.j = paramOnDownloadListener;
  }
  
  public void a(boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = this.q;
    if (localAtomicBoolean != null) {
      localAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.o;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, mCenterPlayBtn is null.");
      }
      return false;
    }
    if (((ImageView)localObject).getVisibility() == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemClick, event.getRawX() = ");
        ((StringBuilder)localObject).append(paramMotionEvent.getRawX());
        ((StringBuilder)localObject).append(" , event.getRawY() = ");
        ((StringBuilder)localObject).append(paramMotionEvent.getRawY());
        ((StringBuilder)localObject).append(" , mCenterPlayBtn left = ");
        ((StringBuilder)localObject).append(this.o.getLeft());
        ((StringBuilder)localObject).append(" , top = ");
        ((StringBuilder)localObject).append(this.o.getTop());
        ((StringBuilder)localObject).append(" , right = ");
        ((StringBuilder)localObject).append(this.o.getRight());
        ((StringBuilder)localObject).append(", bottom = ");
        ((StringBuilder)localObject).append(this.o.getBottom());
        QLog.d("VideoPlayControllerForAIO", 2, ((StringBuilder)localObject).toString());
      }
      if (new Rect(this.o.getLeft(), this.o.getTop(), this.o.getRight(), this.o.getBottom()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, playbtn contains event");
        }
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, mCenterPlayBtn is not visible.");
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (this.o != null)
    {
      LinearLayout localLinearLayout = this.p;
      if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0))
      {
        this.o.setVisibility(8);
        return;
      }
      this.o.setVisibility(paramInt);
    }
  }
  
  public boolean b()
  {
    AtomicBoolean localAtomicBoolean = this.q;
    if (localAtomicBoolean != null) {
      return localAtomicBoolean.get();
    }
    return false;
  }
  
  public void e(int paramInt)
  {
    this.l = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO
 * JD-Core Version:    0.7.0.1
 */