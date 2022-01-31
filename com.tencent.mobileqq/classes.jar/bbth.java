import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bbth
  implements SeekBar.OnSeekBarChangeListener
{
  public bbth(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator;
    if (((paramSeekBar.getProgress() == paramSeekBar.getMax()) || (this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_e_of_type_Int > paramSeekBar.getProgress())) && (!this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b)) {
      localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
    }
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(localObject1)).seekTo(0);
      paramSeekBar.setProgress(0);
      ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(localObject1)).pause();
      Object localObject2 = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_e_of_type_JavaUtilHashMap.get(localObject1);
      localObject1 = (SeekBar)((FrameLayout)localObject2).findViewById(2131375774);
      TextView localTextView1 = (TextView)((FrameLayout)localObject2).findViewById(2131373122);
      TextView localTextView2 = (TextView)((FrameLayout)localObject2).findViewById(2131373121);
      ImageView localImageView1 = (ImageView)((FrameLayout)localObject2).findViewById(2131373120);
      ImageView localImageView2 = (ImageView)((FrameLayout)localObject2).findViewById(2131373119);
      localObject2 = (TextView)((FrameLayout)localObject2).findViewById(2131373118);
      localImageView1.setImageResource(2130848221);
      localImageView1.setVisibility(0);
      ((SeekBar)localObject1).setVisibility(4);
      localTextView1.setVisibility(4);
      localTextView2.setVisibility(4);
      localImageView2.setVisibility(4);
      ((TextView)localObject2).setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_e_of_type_Int = 0;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_e_of_type_Int = paramSeekBar.getProgress();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "onStartTrackingTouch");
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    long l = ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).getDuration();
    i = (int)(i / 100.0D * l);
    ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).seekTo(i);
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_e_of_type_Int = paramSeekBar.getProgress();
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "mLastprogressTime1:" + this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbth
 * JD-Core Version:    0.7.0.1
 */