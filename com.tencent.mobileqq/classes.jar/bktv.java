import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class bktv
  implements DialogInterface.OnClickListener
{
  public bktv(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.a.jdField_a_of_type_Int == 2) {
        this.a.a();
      }
      this.a.a(this.a.c);
    }
    bkzy.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bktv
 * JD-Core Version:    0.7.0.1
 */