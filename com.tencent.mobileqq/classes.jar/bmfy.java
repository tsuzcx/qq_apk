import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;

public class bmfy
  implements DialogInterface.OnClickListener
{
  public bmfy(QZoneShareActivity paramQZoneShareActivity, Activity paramActivity, QZoneShareData paramQZoneShareData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationQzoneQZoneShareData, false);
    this.jdField_a_of_type_AndroidAppActivity.setResult(0, this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.getIntent());
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfy
 * JD-Core Version:    0.7.0.1
 */