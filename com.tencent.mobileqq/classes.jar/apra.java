import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.PhotoListLogicArk.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

public class apra
  extends akhu
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public apra(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    localIntent.putExtra("key_ark_app_res_path", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_should_compress", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("key_ark_app_engine_res_dir", this.b);
    localIntent.putExtra("enter_from", 3);
    return super.caseNoSingModeImage(paramView, paramInt);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    paramIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    paramIntent.putExtra("enter_from", 3);
    super.enterAlbumListFragment(paramIntent);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_ark_app_res_path");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_should_compress", false);
    this.b = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void onBackPressed()
  {
    apqv.a().a("callbackArk", null, null);
    ((NewPhotoListActivity)this.mActivity).finish();
    bgkc.anim(this.mActivity, false, false);
  }
  
  public void onSendBtnClick(View paramView)
  {
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
      ((NewPhotoListActivity)this.mActivity).recordLastPos((String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1));
    }
    bgkc.a();
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(this.mPhotoCommonData.selectedPhotoList.size() * 128);
        int i = 0;
        while (i < this.mPhotoCommonData.selectedPhotoList.size())
        {
          paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), this.mPhotoCommonData.selectedPhotoList.get(i) }));
          i += 1;
        }
        QLog.d("PhotoListLogicArk", 2, paramView.toString());
      }
      ((NewPhotoListActivity)this.mActivity).showProgressDialog();
      ThreadManagerV2.executeOnSubThread(new PhotoListLogicArk.1(this));
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).finish();
      return;
      apqv.a().a("callbackArk", null, null);
    }
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    apqv.a().a("callbackArk", null, null);
    ((NewPhotoListActivity)this.mActivity).finish();
    super.onTitleBtnCancelClick(paramView);
  }
  
  public void postInitUI()
  {
    super.postInitUI();
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if (localNewPhotoListActivity != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListLogicArk", 2, "ArkApp ark app res:" + this.jdField_a_of_type_JavaLangString);
      }
      localNewPhotoListActivity.findViewById(2131372839).setVisibility(4);
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    super.startPhotoPreviewActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apra
 * JD-Core Version:    0.7.0.1
 */