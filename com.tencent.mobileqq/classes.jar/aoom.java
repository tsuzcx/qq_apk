import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1;
import java.util.Random;

public class aoom
  implements View.OnClickListener
{
  public aoom(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startTitleProgress();
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131695129);
    this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    if (this.a.jdField_a_of_type_Apet != null)
    {
      paramView = this.a.jdField_a_of_type_Apet;
      paramView.a += 1;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(1500);
    new Handler().postDelayed(new FilePreviewActivity.6.1(this), i % 1001 + 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoom
 * JD-Core Version:    0.7.0.1
 */