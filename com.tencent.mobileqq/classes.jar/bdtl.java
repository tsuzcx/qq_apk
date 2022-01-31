import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin.14.1.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bdtl
  implements View.OnTouchListener
{
  bdtl(bdtk parambdtk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.a.e.keySet().iterator();
    while (paramView.hasNext())
    {
      paramMotionEvent = (String)paramView.next();
      Object localObject = (FrameLayout)this.a.a.e.get(paramMotionEvent);
      localObject = ((bdts)this.a.a.jdField_f_of_type_JavaUtilHashMap.get(paramMotionEvent)).jdField_a_of_type_AndroidWidgetSeekBar;
      TextView localTextView1 = ((bdts)this.a.a.jdField_f_of_type_JavaUtilHashMap.get(paramMotionEvent)).jdField_c_of_type_AndroidWidgetTextView;
      TextView localTextView2 = ((bdts)this.a.a.jdField_f_of_type_JavaUtilHashMap.get(paramMotionEvent)).jdField_b_of_type_AndroidWidgetTextView;
      ImageView localImageView1 = ((bdts)this.a.a.jdField_f_of_type_JavaUtilHashMap.get(paramMotionEvent)).jdField_a_of_type_AndroidWidgetImageView;
      ImageView localImageView2 = ((bdts)this.a.a.jdField_f_of_type_JavaUtilHashMap.get(paramMotionEvent)).jdField_b_of_type_AndroidWidgetImageView;
      TextView localTextView3 = ((bdts)this.a.a.jdField_f_of_type_JavaUtilHashMap.get(paramMotionEvent)).jdField_a_of_type_AndroidWidgetTextView;
      ImageView localImageView3 = ((bdts)this.a.a.jdField_f_of_type_JavaUtilHashMap.get(paramMotionEvent)).jdField_c_of_type_AndroidWidgetImageView;
      if (QLog.isColorLevel()) {
        QLog.d("HealthBusinessPlugin", 2, "videoplayer section clicked");
      }
      if (((SeekBar)localObject).getVisibility() == 4)
      {
        ((SeekBar)localObject).setVisibility(0);
        localTextView1.setVisibility(0);
        localTextView2.setVisibility(0);
        localImageView3.setVisibility(0);
        if (((TVK_IMediaPlayer)this.a.a.d.get(paramMotionEvent)).isPlaying()) {}
        for (int i = 2130848063;; i = 2130848612)
        {
          localImageView1.setImageResource(i);
          localImageView1.setVisibility(0);
          this.a.a.jdField_f_of_type_Boolean = true;
          localImageView2.setVisibility(4);
          localTextView3.setVisibility(4);
          this.a.a.c.removeCallbacksAndMessages(null);
          paramMotionEvent = new HealthBusinessPlugin.14.1.1(this, (SeekBar)localObject, localTextView1, localTextView2, localImageView3, localImageView1, localImageView2, localTextView3);
          this.a.a.c.postDelayed(paramMotionEvent, 3000L);
          break;
        }
      }
      ((SeekBar)localObject).setVisibility(4);
      localTextView1.setVisibility(4);
      localTextView2.setVisibility(4);
      localImageView3.setVisibility(4);
      localImageView1.setVisibility(4);
      this.a.a.jdField_f_of_type_Boolean = false;
      localImageView2.setVisibility(0);
      localTextView3.setVisibility(0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtl
 * JD-Core Version:    0.7.0.1
 */