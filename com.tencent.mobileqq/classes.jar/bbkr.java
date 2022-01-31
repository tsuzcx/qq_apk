import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import java.util.ArrayList;

public class bbkr
  extends BroadcastReceiver
{
  public bbkr(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("key_photo_delete_action".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      if ((i >= 0) && (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
        this.a.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    do
    {
      do
      {
        return;
        if (!"key_audio_delete_action".equals(paramContext)) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      } while (!this.a.k);
      bcmc.a(this.a.m, this.a.n, "del_record", this.a.o, "", "", "");
      return;
    } while (!"key_photo_add_action".equals(paramContext));
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkr
 * JD-Core Version:    0.7.0.1
 */