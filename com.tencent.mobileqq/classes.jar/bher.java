import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin.11.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bher
  implements View.OnClickListener
{
  public bher(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString, bhfc parambhfc) {}
  
  public void onClick(View paramView)
  {
    Object localObject3 = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.e.get(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = (SeekBar)((FrameLayout)localObject3).findViewById(2131377106);
    Object localObject2 = (TextView)((FrameLayout)localObject3).findViewById(2131374319);
    TextView localTextView1 = (TextView)((FrameLayout)localObject3).findViewById(2131374318);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject3).findViewById(2131374317);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject3).findViewById(2131374316);
    TextView localTextView2 = (TextView)((FrameLayout)localObject3).findViewById(2131374315);
    localObject3 = new HealthBusinessPlugin.11.1(this, (SeekBar)localObject1, (TextView)localObject2, localTextView1, localImageView1, localImageView2, localTextView2);
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.f) {
      if (((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).isPlaying())
      {
        i = 2130848612;
        localImageView1.setImageResource(i);
        localImageView1.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.f = true;
        ((SeekBar)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        localTextView1.setVisibility(0);
        localImageView2.setVisibility(4);
        localTextView2.setVisibility(4);
        if (((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).isPlaying())
        {
          this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.postDelayed((Runnable)localObject3, 3000L);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2130849161;
      break;
      if (((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).isPlaying())
      {
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).pause();
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Boolean = true;
        localImageView1.setImageResource(2130849161);
        localImageView1.setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.d("HealthBusinessPlugin", 2, "play onclick in video ");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Boolean = false;
        localObject1 = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.postDelayed((Runnable)localObject3, 3000L);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(localObject2)).pause();
        }
        ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).start();
        this.jdField_a_of_type_Bhfc.a.setImageResource(2130848612);
        this.jdField_a_of_type_Bhfc.a.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bher
 * JD-Core Version:    0.7.0.1
 */