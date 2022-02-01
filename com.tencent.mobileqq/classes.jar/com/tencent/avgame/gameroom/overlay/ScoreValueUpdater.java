package com.tencent.avgame.gameroom.overlay;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class ScoreValueUpdater
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private long b;
  
  public ScoreValueUpdater(TextView paramTextView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Long > this.b) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Long));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 40L);
  }
  
  public void run()
  {
    this.jdField_a_of_type_Long += 10L;
    if (this.jdField_a_of_type_Long >= this.b)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.b));
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Long));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.ScoreValueUpdater
 * JD-Core Version:    0.7.0.1
 */