import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class bknu
  extends QIMEffectCameraCaptureUnit
{
  private boolean a;
  private int d;
  private String l;
  
  public bknu(bmhh parambmhh, bmhg parambmhg)
  {
    super(parambmhh, parambmhg);
    this.jdField_a_of_type_Bmgz = new bmgz(10004, 8, 2);
    this.jdField_a_of_type_Int = 6;
  }
  
  private void a(Activity paramActivity)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    bjdt.c(paramActivity, localAppRuntime.getAccount(), localIntent, -1);
  }
  
  public int a()
  {
    return 2131560740;
  }
  
  public View a()
  {
    View localView = super.a();
    this.b.setOnClickListener(this);
    this.b.setVisibility(0);
    return localView;
  }
  
  protected List<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Activity localActivity;
    Object localObject2;
    Object localObject1;
    switch (paramInt1)
    {
    default: 
    case 10004: 
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        localActivity = this.jdField_a_of_type_Bmhh.a();
        paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
        if (paramInt1 != 1002) {
          break;
        }
        a(localActivity);
        localObject2 = paramIntent.getStringExtra("forward_source_to_qzone");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label570;
        }
        localObject1 = paramIntent.getStringExtra("set_user_callback");
      } while (localObject1 == null);
    }
    for (;;)
    {
      boolean bool;
      try
      {
        localObject1 = Class.forName((String)localObject1).newInstance();
        if (!(localObject1 instanceof ajpz)) {
          break label564;
        }
        localObject1 = (ajpz)localObject1;
        ((ajpz)localObject1).c_((String)localObject2);
        localObject2 = paramIntent.getStringExtra("key_content");
        bool = paramIntent.getBooleanExtra("forward_to_qzone_to_enable_edit", false);
        bkoi.a(this.jdField_a_of_type_Bmhh.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_Bmhg, null, (ajpz)localObject1, (String)localObject2, 1, null, bool, null, false);
        localActivity.finish();
        if (this.jdField_a_of_type_Blqk != null)
        {
          this.jdField_a_of_type_Blqk.l();
          this.jdField_a_of_type_Blqk.n();
        }
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QIMQuickShootEffectCameraCaptureUnit", 2, "initComponentParamData:exp =" + localThrowable);
        localObject1 = localObject2;
        continue;
      }
      if (paramInt1 == 1003)
      {
        paramIntent = ((PublishParam)paramIntent.getParcelableExtra(PublishParam.a)).c;
        localObject1 = new Intent(localActivity, QQStoryMainActivity.class);
        ((Intent)localObject1).putExtra("new_video_extra_info", paramIntent);
        localActivity.startActivity((Intent)localObject1);
        localActivity.finish();
      }
      else
      {
        bkoi.a(this.jdField_a_of_type_Bmhh.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_Bmhg, new bknv(this, localActivity, paramIntent));
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = this.jdField_a_of_type_Bmhh.a();
          paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
          if (paramInt1 == 1002)
          {
            a((Activity)localObject1);
            paramIntent.putExtra("open_leba_tab_fragment", true);
            ((Activity)localObject1).setResult(-1, paramIntent);
            ((Activity)localObject1).finish();
            return;
          }
          if (paramInt1 != 1003) {
            break;
          }
          paramIntent = ((PublishParam)paramIntent.getParcelableExtra(PublishParam.a)).c;
          localObject2 = new Intent((Context)localObject1, QQStoryMainActivity.class);
          ((Intent)localObject2).putExtra("new_video_extra_info", paramIntent);
          ((Activity)localObject1).startActivity((Intent)localObject2);
          ((Activity)localObject1).finish();
          return;
        }
        if (paramInt2 != 0) {
          break;
        }
        bool = false;
        if (paramIntent != null) {
          bool = paramIntent.getBooleanExtra("mark_from_artfilter_bridge_activity", false);
        }
        if ((bool) || (paramIntent != null) || (!(this.jdField_a_of_type_Bmhh.a() instanceof SplashActivity))) {
          break;
        }
        if (this.jdField_a_of_type_Blqk != null)
        {
          this.jdField_a_of_type_Blqk.l();
          this.jdField_a_of_type_Blqk.n();
        }
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(false);
        return;
        label564:
        localObject1 = null;
        continue;
        label570:
        localObject1 = null;
      }
    }
  }
  
  public void a(axqw paramaxqw)
  {
    super.a(paramaxqw);
    bmha localbmha = new bmhc(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(2).b(101).a();
    this.jdField_a_of_type_Bmgz.a(localbmha);
    bnld.a(this.jdField_a_of_type_Bmhh.a(), paramaxqw, this.jdField_a_of_type_Bmgz, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    bmhd localbmhd = new bmhf().a(101).b(2).a();
    this.jdField_a_of_type_Bmgz.a(localbmhd);
    a(paramLocalMediaInfo);
    bnld.a(this.jdField_a_of_type_Bmhh.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Bmgz, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  public void h()
  {
    super.h();
    this.b.setVisibility(8);
  }
  
  public void n()
  {
    super.n();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(102, this.d, this.l);
    }
  }
  
  public void o()
  {
    Bundle localBundle = this.jdField_a_of_type_Bmhh.a().getIntent().getExtras();
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.d = localBundle.getInt("ARG_DD_CATEGORY_ID");
    this.l = localBundle.getString("ARG_DD_ITEM_ID");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknu
 * JD-Core Version:    0.7.0.1
 */