import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class bnjr
  implements DialogInterface.OnClickListener
{
  public bnjr(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.a.jdField_a_of_type_Int == 2) {
        this.a.a();
      }
      this.a.a(this.a.c);
    }
    bnpu.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjr
 * JD-Core Version:    0.7.0.1
 */