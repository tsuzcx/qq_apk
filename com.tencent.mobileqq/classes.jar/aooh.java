import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1;
import java.util.Random;

public class aooh
  implements View.OnClickListener
{
  public aooh(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startTitleProgress();
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131695128);
    this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    if (this.a.jdField_a_of_type_Apep != null)
    {
      paramView = this.a.jdField_a_of_type_Apep;
      paramView.a += 1;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(1500);
    new Handler().postDelayed(new FilePreviewActivity.6.1(this), i % 1001 + 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aooh
 * JD-Core Version:    0.7.0.1
 */