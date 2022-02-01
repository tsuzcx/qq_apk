import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auvy
  implements View.OnClickListener
{
  public auvy(DeleteFaceFragment paramDeleteFaceFragment, FragmentActivity paramFragmentActivity) {}
  
  public void onClick(View paramView)
  {
    bdla.b(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://accounts.qq.com/face/delete");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 1001);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvy
 * JD-Core Version:    0.7.0.1
 */