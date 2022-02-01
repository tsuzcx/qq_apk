import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.qq.im.capture.view.MusicProviderView;

public class bpvn
  implements DialogInterface.OnClickListener
{
  public bpvn(MusicProviderView paramMusicProviderView, MusicItemInfo paramMusicItemInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    MusicProviderView.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_a_of_type_Bpvt.k();
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpvn
 * JD-Core Version:    0.7.0.1
 */