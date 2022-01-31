import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class anyt
  implements DialogInterface.OnClickListener
{
  public anyt(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.a.a, FavEmosmManageActivity.class);
    paramDialogInterface.putExtra("camera_emo_mode", 1);
    this.a.a.startActivity(paramDialogInterface);
    axqy.b(((BaseActivity)this.a.a).app, "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyt
 * JD-Core Version:    0.7.0.1
 */