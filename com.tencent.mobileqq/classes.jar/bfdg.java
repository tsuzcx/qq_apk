import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.ArrayList;

public class bfdg
  extends Handler
{
  public bfdg(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (bfdp)paramMessage.obj;
    long l1;
    long l2;
    bfeg localbfeg;
    if (this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying())
    {
      l1 = this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
      l2 = this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
      paramMessage.jdField_a_of_type_AndroidWidgetSeekBar.setMax((int)l1);
      paramMessage.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)l2);
      this.a.b(paramMessage);
      paramMessage = (bfed)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramMessage.jdField_a_of_type_Int);
      if ((paramMessage instanceof bfeg))
      {
        localbfeg = (bfeg)paramMessage;
        if ((!this.a.d) && (l2 >= l1 * 0.8D))
        {
          this.a.d = true;
          if (localbfeg.h == 0) {
            break label271;
          }
          paramMessage = "" + localbfeg.h;
          if (localbfeg.c != 31) {
            break label277;
          }
        }
      }
    }
    label271:
    label277:
    for (String str = "1";; str = "2")
    {
      bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_active", this.a.c, 0, localbfeg.d, "" + localbfeg.b, paramMessage, str);
      if (this.a.h < l1 - 100L) {
        this.a.h = ((int)l2);
      }
      return;
      paramMessage = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdg
 * JD-Core Version:    0.7.0.1
 */