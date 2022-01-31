import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import cooperation.qzone.share.QZoneShareActivity;

public class amyz
  implements Runnable
{
  public amyz(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845271);
    this.a.d = true;
    this.a.e = false;
    QZoneShareActivity.a(this.a, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyz
 * JD-Core Version:    0.7.0.1
 */