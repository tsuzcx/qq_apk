import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin.13.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bbtw
  implements View.OnTouchListener
{
  public bbtw(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return false;
        this.a.a.x = ((int)paramMotionEvent.getRawX());
        this.a.a.y = ((int)paramMotionEvent.getRawY());
        if (QLog.isColorLevel())
        {
          QLog.d("HealthBusinessPlugin", 2, "down clicked");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("HealthBusinessPlugin", 2, "move clicked");
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "up clicked");
    }
    this.a.b.x = ((int)paramMotionEvent.getRawX());
    this.a.b.y = ((int)paramMotionEvent.getRawY());
    if ((Math.abs(this.a.a.y - this.a.b.y) < 8) && (Math.abs(this.a.a.x - this.a.b.x) < 8))
    {
      paramView = new Rect();
      paramMotionEvent = this.a.e.keySet().iterator();
      while (paramMotionEvent.hasNext())
      {
        Object localObject = (String)paramMotionEvent.next();
        FrameLayout localFrameLayout = (FrameLayout)this.a.e.get(localObject);
        SeekBar localSeekBar = ((bbuf)this.a.jdField_f_of_type_JavaUtilHashMap.get(localObject)).jdField_a_of_type_AndroidWidgetSeekBar;
        TextView localTextView1 = ((bbuf)this.a.jdField_f_of_type_JavaUtilHashMap.get(localObject)).jdField_c_of_type_AndroidWidgetTextView;
        TextView localTextView2 = ((bbuf)this.a.jdField_f_of_type_JavaUtilHashMap.get(localObject)).jdField_b_of_type_AndroidWidgetTextView;
        ImageView localImageView1 = ((bbuf)this.a.jdField_f_of_type_JavaUtilHashMap.get(localObject)).jdField_a_of_type_AndroidWidgetImageView;
        ImageView localImageView2 = ((bbuf)this.a.jdField_f_of_type_JavaUtilHashMap.get(localObject)).jdField_b_of_type_AndroidWidgetImageView;
        TextView localTextView3 = ((bbuf)this.a.jdField_f_of_type_JavaUtilHashMap.get(localObject)).jdField_a_of_type_AndroidWidgetTextView;
        ImageView localImageView3 = ((bbuf)this.a.jdField_f_of_type_JavaUtilHashMap.get(localObject)).jdField_c_of_type_AndroidWidgetImageView;
        localFrameLayout.getGlobalVisibleRect(paramView);
        if ((paramView.contains(this.a.a.x, this.a.a.y)) && (paramView.contains(this.a.b.x, this.a.b.y)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("HealthBusinessPlugin", 2, "videoplayer section clicked");
          }
          if (localSeekBar.getVisibility() == 4)
          {
            localSeekBar.setVisibility(0);
            localTextView1.setVisibility(0);
            localTextView2.setVisibility(0);
            localImageView3.setVisibility(0);
            if (((TVK_IMediaPlayer)this.a.d.get(localObject)).isPlaying()) {}
            for (int i = 2130847681;; i = 2130848227)
            {
              localImageView1.setImageResource(i);
              localImageView1.setVisibility(0);
              this.a.jdField_f_of_type_Boolean = true;
              localImageView2.setVisibility(4);
              localTextView3.setVisibility(4);
              this.a.c.removeCallbacksAndMessages(null);
              localObject = new HealthBusinessPlugin.13.1(this, localSeekBar, localTextView1, localTextView2, localImageView3, localImageView1, localImageView2, localTextView3);
              this.a.c.postDelayed((Runnable)localObject, 3000L);
              break;
            }
          }
          localSeekBar.setVisibility(4);
          localTextView1.setVisibility(4);
          localTextView2.setVisibility(4);
          localImageView3.setVisibility(4);
          localImageView1.setVisibility(4);
          this.a.jdField_f_of_type_Boolean = false;
          localImageView2.setVisibility(0);
          localTextView3.setVisibility(0);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbtw
 * JD-Core Version:    0.7.0.1
 */