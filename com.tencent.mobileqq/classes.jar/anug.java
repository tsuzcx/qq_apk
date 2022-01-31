import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

final class anug
  implements View.OnClickListener
{
  anug(Context paramContext, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", "https://ti.qq.com/extend-friend/?_wv=536870912");
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    awqx.b(null, "dc00898", "", "", "kuolie", "0X80097DE", 0, 0, "", "", "", "");
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anug
 * JD-Core Version:    0.7.0.1
 */