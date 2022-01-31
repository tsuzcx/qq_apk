import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.ArrayList;

public class azaz
  extends Handler
{
  public azaz(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (azbj)paramMessage.obj;
    long l1;
    long l2;
    azcb localazcb;
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())
    {
      l1 = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
      l2 = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      paramMessage.jdField_a_of_type_AndroidWidgetSeekBar.setMax((int)l1);
      paramMessage.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)l2);
      this.a.b(paramMessage);
      paramMessage = (azby)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramMessage.jdField_a_of_type_Int);
      if ((paramMessage instanceof azcb))
      {
        localazcb = (azcb)paramMessage;
        if ((!this.a.d) && (l2 >= l1 * 0.8D))
        {
          this.a.d = true;
          if (localazcb.h == 0) {
            break label271;
          }
          paramMessage = "" + localazcb.h;
          if (localazcb.c != 31) {
            break label277;
          }
        }
      }
    }
    label271:
    label277:
    for (String str = "1";; str = "2")
    {
      axqy.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_active", this.a.c, 0, localazcb.d, "" + localazcb.b, paramMessage, str);
      if (this.a.h < l1 - 100L) {
        this.a.h = ((int)l2);
      }
      return;
      paramMessage = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azaz
 * JD-Core Version:    0.7.0.1
 */