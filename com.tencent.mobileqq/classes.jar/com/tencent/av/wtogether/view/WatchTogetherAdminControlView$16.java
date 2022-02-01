package com.tencent.av.wtogether.view;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class WatchTogetherAdminControlView$16
  implements SeekBar.OnSeekBarChangeListener
{
  WatchTogetherAdminControlView$16(WatchTogetherAdminControlView paramWatchTogetherAdminControlView, SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onStartTrackingTouch(paramSeekBar);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onStopTrackingTouch(paramSeekBar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.16
 * JD-Core Version:    0.7.0.1
 */