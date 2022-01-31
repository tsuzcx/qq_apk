import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;

public class anmn
  extends aimu
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public anmn(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_ark_app_res_path");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_should_compress", false);
    this.b = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new anmo(this));
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_Aimr.from))
    {
      Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
      localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      localIntent.putExtra("key_ark_app_res_path", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_should_compress", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_ark_app_engine_res_dir", this.b);
      localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
      localIntent.putExtra("enter_from", 3);
    }
    super.onBackPressed(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmn
 * JD-Core Version:    0.7.0.1
 */