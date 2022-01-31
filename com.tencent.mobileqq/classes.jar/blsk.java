import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import dov.com.qq.im.capture.data.LockedCategory;

class blsk
  implements DialogInterface.OnClickListener
{
  blsk(blsj paramblsj, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Blsj.b(this.jdField_a_of_type_Blsj.a.a);
    this.jdField_a_of_type_Blsj.a = null;
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Blsj.c = true;
      if ((BaseActivity.sTopActivity instanceof SplashActivity))
      {
        paramDialogInterface = (SplashActivity)BaseActivity.sTopActivity;
        Intent localIntent = new Intent();
        localIntent.putExtra("main_tab_id", 8);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("switch_anim", true);
        paramDialogInterface.b(localIntent);
      }
    }
    else
    {
      return;
    }
    paramDialogInterface = new Intent(BaseActivity.sTopActivity, SplashActivity.class);
    paramDialogInterface.putExtra("tab_index", MainFragment.b);
    paramDialogInterface.putExtra("fragment_id", 1);
    paramDialogInterface.setFlags(67108864);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsk
 * JD-Core Version:    0.7.0.1
 */