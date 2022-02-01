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
  protected int a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected VideoPlayControllerForAIO.OnDownloadListener a;
  private final String jdField_a_of_type_JavaLangString = "VideoPlayControllerForAIO";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ImageView b;
  
  public VideoPlayControllerForAIO()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO$OnDownloadListener = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.b = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      b(8);
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null)
    {
      localLinearLayout.setVisibility(paramInt);
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131366307));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373043));
    this.b = ((ImageView)paramView.findViewById(2131373042));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131373044));
  }
  
  public void a(VideoPlayControllerForAIO.OnDownloadListener paramOnDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO$OnDownloadListener = paramOnDownloadListener;
  }
  
  public void a(boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    if (localAtomicBoolean != null) {
      localAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean a()
  {
    AtomicBoolean localAtomicBoolean = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    if (localAtomicBoolean != null) {
      return localAtomicBoolean.get();
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.b;
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
        ((StringBuilder)localObject).append(this.b.getLeft());
        ((StringBuilder)localObject).append(" , top = ");
        ((StringBuilder)localObject).append(this.b.getTop());
        ((StringBuilder)localObject).append(" , right = ");
        ((StringBuilder)localObject).append(this.b.getRight());
        ((StringBuilder)localObject).append(", bottom = ");
        ((StringBuilder)localObject).append(this.b.getBottom());
        QLog.d("VideoPlayControllerForAIO", 2, ((StringBuilder)localObject).toString());
      }
      if (new Rect(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
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
    if (this.b != null)
    {
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0))
      {
        this.b.setVisibility(8);
        return;
      }
      this.b.setVisibility(paramInt);
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO
 * JD-Core Version:    0.7.0.1
 */