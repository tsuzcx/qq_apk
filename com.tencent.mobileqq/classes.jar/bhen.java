import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.1;
import dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.2;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;
import java.util.ArrayList;
import java.util.List;

public class bhen
  extends QIMEffectCameraCaptureUnit
{
  private int d = 10013;
  private int e;
  
  public bhen(bhzc parambhzc, bhzb parambhzb)
  {
    super(parambhzc, parambhzb);
    this.jdField_a_of_type_Bhyu = new bhyu(this.d, 106, 12);
    this.jdField_a_of_type_Int = 10;
  }
  
  private Intent a(Activity paramActivity, Class<?> paramClass, PublishParam paramPublishParam, Intent paramIntent)
  {
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("arg_video_source", this.e);
    if (paramActivity.getIntent().getExtras() != null) {
      paramClass.putExtras(paramActivity.getIntent().getExtras());
    }
    if (paramIntent != null)
    {
      paramActivity = paramIntent.getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
      if (paramActivity != null) {
        paramClass.putParcelableArrayListExtra("key_read_in_joy_video_upload_report", paramActivity);
      }
    }
    if (paramPublishParam != null)
    {
      paramClass.putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramPublishParam);
      paramClass.putExtra("arg_video_duration", paramPublishParam.jdField_a_of_type_Long);
      paramClass.putExtra("arg_video_path", paramPublishParam.j);
      paramClass.putExtra("arg_video_cover", paramPublishParam.c);
      paramClass.putExtra("arg_video_width", paramPublishParam.jdField_a_of_type_Int);
      paramClass.putExtra("arg_video_height", paramPublishParam.jdField_b_of_type_Int);
      paramClass.putExtra("captureMode", b());
    }
    return paramClass;
  }
  
  private void ad()
  {
    int i = this.jdField_a_of_type_Bhzc.a().getIntent().getIntExtra("key_max_duration", 60);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(i * 1000);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setMaxDuration(i * 1000);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
    ThreadManager.excute(new QIMReadinjoyEffectsCameraCaptureUnit.2(this), 64, null, true);
  }
  
  private String b()
  {
    int i;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      return String.valueOf(i);
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public void K()
  {
    vhg.a().e();
    Activity localActivity = this.jdField_a_of_type_Bhzc.a();
    Intent localIntent = new Intent(localActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtras(this.jdField_a_of_type_Bhzc.a().getIntent().getExtras());
    localIntent.putExtra("qq_sub_business_id", this.jdField_a_of_type_Bhyu.c);
    localIntent.putExtra("entrance_type", this.jdField_a_of_type_Bhyu.jdField_b_of_type_Int);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("from_readinjoy_slideshow", true);
    localIntent.putExtra("ALBUM_NAME", baae.l);
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
    localIntent.putExtra("report_first_exposure", true);
    localActivity.startActivityForResult(localIntent, this.d);
    localActivity.overridePendingTransition(2130772277, 2130771990);
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    ad();
    return localView;
  }
  
  protected auuv a()
  {
    auuv localauuv = super.a();
    localauuv.b(false);
    return localauuv;
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
    Activity localActivity = this.jdField_a_of_type_Bhzc.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if ((paramInt1 == 10013) && (paramInt2 == -1) && (paramIntent != null))
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      bhiu localbhiu = (bhiu)bhfm.a().c(8);
      if (localbhiu != null) {
        localbhiu.e();
      }
      localActivity.startActivityForResult(a(localActivity, ReadInJoyDeliverVideoActivity.class, localPublishParam, paramIntent), 111);
      return;
    }
    if (paramInt1 == 111)
    {
      localActivity.setResult(paramInt2, paramIntent);
      localActivity.finish();
      return;
    }
    urk.d("Q.readinjoy.video_QIMReadinjoyEffectsCameraCaptureUnit", "onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    boolean bool1;
    boolean bool2;
    label36:
    Object localObject;
    Bundle localBundle;
    if (this.jdField_a_of_type_Bhyu.jdField_b_of_type_Int != 102)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Bhyu.jdField_b_of_type_Int == 102) {
        break label172;
      }
      bool2 = true;
      localObject = new bhza().a(false).e(bool1).f(bool2).g(true).h(this.h).a();
      localBundle = this.jdField_a_of_type_Bhzc.a().getIntent().getExtras();
      this.jdField_a_of_type_Bhyu.a((bhyy)localObject);
      this.e = 2;
      localObject = this.jdField_a_of_type_Bhzc.a().getIntent();
      if (!this.h) {
        break label178;
      }
    }
    label172:
    label178:
    for (int i = 2;; i = -1)
    {
      ((Intent)localObject).putExtra("extra_transiton_src_from", i);
      bjeg.a(this.jdField_a_of_type_Bhzc.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Bhyu, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, localBundle);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label36;
    }
  }
  
  public void b(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("video_refer", "READINJOY_VIDEO");
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
    localIntent.putExtra("readinjoy_video", true);
    localIntent.putExtra("needTheme", false);
    localIntent.putExtra("needVideoWording", true);
    localIntent.putExtra("needVideoDoodle", true);
    localIntent.putExtra("entrance_type", this.jdField_a_of_type_Bhyu.jdField_b_of_type_Int);
    localIntent.putExtra("edit_video_type", this.d);
    this.e = 1;
    paramActivity.startActivityForResult(localIntent, this.d);
  }
  
  public void h()
  {
    super.h();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131303850)
    {
      b(this.jdField_a_of_type_Bhzc.a());
      return;
    }
    super.onClick(paramView);
  }
  
  protected void y()
  {
    ThreadManager.post(new QIMReadinjoyEffectsCameraCaptureUnit.1(this, this.jdField_a_of_type_Bhzc.a()), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhen
 * JD-Core Version:    0.7.0.1
 */