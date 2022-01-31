import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;

public class bdtg
  implements View.OnClickListener
{
  public bdtg(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).getOutputMute())
    {
      ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).setOutputMute(false);
      ((ImageView)paramView).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845847));
      return;
    }
    ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).setOutputMute(true);
    ((ImageView)paramView).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845846));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtg
 * JD-Core Version:    0.7.0.1
 */