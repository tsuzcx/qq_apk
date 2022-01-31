import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.ChangeFace;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMTribeEffectsCameraCaptureUnit.1;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class bihk
  extends QIMEffectCameraCaptureUnit
{
  public static int d = 60000;
  
  public bihk(bjqu parambjqu, bjqt parambjqt)
  {
    super(parambjqu, parambjqt);
    this.jdField_a_of_type_Bjqm = new bjqm(10012, 105, 11);
    this.jdField_a_of_type_Int = 9;
  }
  
  private void a(TribeVideoPublishParams paramTribeVideoPublishParams)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = ((bkyy)bjae.a(3)).a();
    if (localPtvTemplateInfo != null)
    {
      paramTribeVideoPublishParams.changeFace = new TribeVideoPublishParams.ChangeFace();
      paramTribeVideoPublishParams.changeFace.id = localPtvTemplateInfo.id;
      paramTribeVideoPublishParams.changeFace.type = localPtvTemplateInfo.name;
    }
    if ((AdvancedProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(AdvancedProviderView.class) != null) {
      paramTribeVideoPublishParams.beauty = AdvancedProviderView.b();
    }
  }
  
  public void I()
  {
    vuc.a().e();
    Activity localActivity = this.jdField_a_of_type_Bjqu.a();
    Intent localIntent = new Intent(localActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 24);
    localIntent.putExtras(this.jdField_a_of_type_Bjqu.a().getIntent().getExtras());
    localIntent.putExtra("qq_sub_business_id", this.jdField_a_of_type_Bjqm.c);
    localIntent.putExtra("entrance_type", this.jdField_a_of_type_Bjqm.jdField_b_of_type_Int);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("from_tribe_slideshow", true);
    localIntent.putExtra("ALBUM_NAME", bbbi.l);
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
    localIntent.putExtra("report_first_exposure", true);
    localActivity.startActivityForResult(localIntent, 10012);
    localActivity.overridePendingTransition(2130772278, 2130771990);
  }
  
  public int a()
  {
    return 2131560547;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(true);
    Object localObject1 = azcd.a(this.jdField_a_of_type_Bjqu.a().getIntent().getExtras());
    if (localObject1 != null) {
      d = ((JSONObject)localObject1).optInt("needVideoTimeLimit", 10) * 1000;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(d);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setMaxDuration(d);
    localObject1 = this.jdField_a_of_type_Bjqu.a().getIntent().getExtras();
    try
    {
      Object localObject2 = ((Bundle)localObject1).getString("options");
      if (QLog.isColorLevel()) {
        QLog.d("QIMTribeEffectsCameraCaptureUnit", 2, "onVideoCaptured option: " + (String)localObject2);
      }
      localObject2 = new JSONObject((String)localObject2);
      boolean bool1 = ((JSONObject)localObject2).optBoolean("needVideoDoodle", false);
      boolean bool2 = ((JSONObject)localObject2).optBoolean("needVideoWording", false);
      ((Bundle)localObject1).putBoolean("needVideoDoodle", bool1);
      ((Bundle)localObject1).putBoolean("needVideoWording", bool2);
      this.jdField_a_of_type_Bjqu.a().getIntent().putExtras((Bundle)localObject1);
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QIMTribeEffectsCameraCaptureUnit", 2, "onVideoCaptured: " + localException);
    }
    return localView;
    return localView;
  }
  
  protected avuj a()
  {
    avuj localavuj = super.a();
    if (axik.r > 2000000)
    {
      localavuj.j(2000000);
      axik.r = 2000000;
      veg.b("QIMTribeEffectsCameraCaptureUnit", "maxrate:" + axik.r);
    }
    localavuj.b(false);
    return localavuj;
  }
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(0));
    localArrayList.add(Integer.valueOf(2));
    return localArrayList;
  }
  
  protected List<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_AndroidWidgetTextView);
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Activity localActivity = this.jdField_a_of_type_Bjqu.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      if (paramInt1 != azak.jdField_a_of_type_Int) {
        break label87;
      }
      if (paramInt2 != -1) {
        break;
      }
    } while (paramIntent == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("result", paramIntent.getStringExtra("result"));
    localActivity.setResult(-1, localIntent);
    localActivity.finish();
    return;
    label87:
    if ((paramInt1 == 10012) && (paramInt2 == -1))
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      TribeVideoPublishParams localTribeVideoPublishParams = (TribeVideoPublishParams)paramIntent.getSerializableExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY);
      localIntent = new Intent();
      localIntent.putExtra("thumbPath", localPublishParam.c);
      localIntent.putExtra("videoPath", localPublishParam.j);
      localIntent.putExtra("fakeVid", localPublishParam.b);
      localIntent.putExtra("videoDoodleDescription", localPublishParam.f);
      paramInt1 = paramIntent.getIntExtra("theme_id", -1);
      paramIntent = paramIntent.getStringExtra("theme_name");
      localIntent.putExtra("theme_id", paramInt1);
      localIntent.putExtra("theme_name", paramIntent);
      a(localTribeVideoPublishParams);
      localIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, localTribeVideoPublishParams);
      paramIntent = (bjdm)bjae.a().c(8);
      if (paramIntent != null) {
        paramIntent.e();
      }
      paramIntent = localActivity.getIntent().getExtras().getString("options");
      localIntent.setClass(localActivity, TroopBarPublishActivity.class);
      localIntent.putExtra("options", paramIntent);
      localIntent.putExtra("captureMode", this.jdField_b_of_type_Int);
      localActivity.startActivityForResult(localIntent, azak.jdField_a_of_type_Int);
      return;
    }
    veg.d("QIMTribeEffectsCameraCaptureUnit", "onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    boolean bool1;
    boolean bool2;
    label36:
    Object localObject;
    Bundle localBundle;
    if (this.jdField_a_of_type_Bjqm.jdField_b_of_type_Int != 102)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Bjqm.jdField_b_of_type_Int == 102) {
        break label167;
      }
      bool2 = true;
      localObject = new bjqs().a(false).e(bool1).f(bool2).g(true).h(this.h).a();
      localBundle = this.jdField_a_of_type_Bjqu.a().getIntent().getExtras();
      this.jdField_a_of_type_Bjqm.a((bjqq)localObject);
      localObject = this.jdField_a_of_type_Bjqu.a().getIntent();
      if (!this.h) {
        break label173;
      }
    }
    label167:
    label173:
    for (int i = 2;; i = -1)
    {
      ((Intent)localObject).putExtra("extra_transiton_src_from", i);
      bkuq.a(this.jdField_a_of_type_Bjqu.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Bjqm, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, localBundle);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label36;
    }
  }
  
  public void b(Activity paramActivity)
  {
    Bundle localBundle = paramActivity.getIntent().getExtras();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 24);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("video_refer", "tribe");
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
    localIntent.putExtras(localBundle);
    localIntent.putExtra("entrance_type", this.jdField_a_of_type_Bjqm.jdField_b_of_type_Int);
    localIntent.putExtra("edit_video_type", 10012);
    paramActivity.startActivityForResult(localIntent, 10012);
  }
  
  public void h()
  {
    super.h();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    }
    b(this.jdField_a_of_type_Bjqu.a());
  }
  
  protected void w()
  {
    ThreadManager.post(new QIMTribeEffectsCameraCaptureUnit.1(this, this.jdField_a_of_type_Bjqu.a()), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihk
 * JD-Core Version:    0.7.0.1
 */