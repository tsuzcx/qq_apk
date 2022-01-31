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

public class biha
  extends QIMEffectCameraCaptureUnit
{
  private boolean a;
  private int d;
  private String l;
  
  public biha(bjqu parambjqu, bjqt parambjqt)
  {
    super(parambjqu, parambjqt);
    this.jdField_a_of_type_Bjqm = new bjqm(10004, 8, 2);
    this.jdField_a_of_type_Int = 6;
  }
  
  private void b(Activity paramActivity)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    bgxy.c(paramActivity, localAppRuntime.getAccount(), localIntent, -1);
  }
  
  public int a()
  {
    return 2131560547;
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
        localActivity = this.jdField_a_of_type_Bjqu.a();
        paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
        if (paramInt1 != 1002) {
          break;
        }
        b(localActivity);
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
        if (!(localObject1 instanceof ahuc)) {
          break label564;
        }
        localObject1 = (ahuc)localObject1;
        ((ahuc)localObject1).c_((String)localObject2);
        localObject2 = paramIntent.getStringExtra("key_content");
        bool = paramIntent.getBooleanExtra("forward_to_qzone_to_enable_edit", false);
        bihp.a(this.jdField_a_of_type_Bjqu.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_Bjqt, null, (ahuc)localObject1, (String)localObject2, 1, null, bool, null, false);
        localActivity.finish();
        if (this.jdField_a_of_type_Bizx != null)
        {
          this.jdField_a_of_type_Bizx.l();
          this.jdField_a_of_type_Bizx.n();
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
        bihp.a(this.jdField_a_of_type_Bjqu.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_Bjqt, new bihb(this, localActivity, paramIntent));
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = this.jdField_a_of_type_Bjqu.a();
          paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
          if (paramInt1 == 1002)
          {
            b((Activity)localObject1);
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
        if ((bool) || (paramIntent != null) || (!(this.jdField_a_of_type_Bjqu.a() instanceof SplashActivity))) {
          break;
        }
        if (this.jdField_a_of_type_Bizx != null)
        {
          this.jdField_a_of_type_Bizx.l();
          this.jdField_a_of_type_Bizx.n();
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
  
  public void a(avum paramavum)
  {
    super.a(paramavum);
    bjqn localbjqn = new bjqp(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(2).b(101).a();
    this.jdField_a_of_type_Bjqm.a(localbjqn);
    bkuq.a(this.jdField_a_of_type_Bjqu.a(), paramavum, this.jdField_a_of_type_Bjqm, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    bjqq localbjqq = new bjqs().a(101).b(2).a();
    this.jdField_a_of_type_Bjqm.a(localbjqq);
    a(paramLocalMediaInfo);
    bkuq.a(this.jdField_a_of_type_Bjqu.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Bjqm, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
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
    Bundle localBundle = this.jdField_a_of_type_Bjqu.a().getIntent().getExtras();
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.d = localBundle.getInt("ARG_DD_CATEGORY_ID");
    this.l = localBundle.getString("ARG_DD_ITEM_ID");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biha
 * JD-Core Version:    0.7.0.1
 */