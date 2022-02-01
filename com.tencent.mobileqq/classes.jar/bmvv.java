import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.bean.Size;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.view.AETouchNotifyRelativeLayout;
import dov.com.qq.im.ae.view.NoScrollViewPager;
import dov.com.qq.im.ae.view.TabLayout;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class bmvv
  extends bmut
{
  private bmvy jdField_a_of_type_Bmvy;
  private bmwa jdField_a_of_type_Bmwa;
  private bmwz jdField_a_of_type_Bmwz;
  private bmxa jdField_a_of_type_Bmxa;
  private borg jdField_a_of_type_Borg;
  private borh jdField_a_of_type_Borh;
  private AETouchNotifyRelativeLayout jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_DovComQqImAeViewTabLayout;
  private List<bmvz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = bnri.a();
  
  public bmvv(borh paramborh, borg paramborg)
  {
    this.jdField_a_of_type_Borh = paramborh;
    this.jdField_a_of_type_Borg = paramborg;
    a();
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_Borh == null) {
      return null;
    }
    return this.jdField_a_of_type_Borh.a();
  }
  
  private bmut a()
  {
    int i = this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem();
    return bmvz.a((bmvz)this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a()
  {
    if (a() == null) {
      return;
    }
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnlb.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (bnlb.a(i).a()) {
      bnqq.a().a(i, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bnqq.a().a(str);
    bnqq.a().a(true);
    bnqq.a().b();
    bnqq.a().a();
    bnqq.a().b(bnjq.a(a()));
  }
  
  public static void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = paramActivity.getWindow();
      localWindow.clearFlags(67108864);
      localWindow.getDecorView().setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(paramInt);
    }
    for (;;)
    {
      ImmersiveUtils.a(paramBoolean, paramActivity.getWindow());
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        paramActivity.getWindow().addFlags(67108864);
      }
    }
  }
  
  public static void a(boolean paramBoolean, Activity paramActivity)
  {
    if (bnlb.j(paramActivity.getIntent()))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("ae_editor_bottom_tab_show_hide");
      localIntent.putExtra("is_show", paramBoolean);
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  private boolean a()
  {
    Activity localActivity = this.jdField_a_of_type_Borh.a();
    if (Build.VERSION.SDK_INT < 23) {}
    int i;
    int j;
    do
    {
      return true;
      i = localActivity.checkSelfPermission("android.permission.CAMERA");
      j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    } while ((i == 0) && (j == 0));
    return false;
  }
  
  private void e()
  {
    boolean bool = true;
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().getIntent().getStringExtra("tab");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("camera"))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (bnqu.a().a("circle_entry_type_camera", false, 4)) {
          j = 1;
        }
      }
      localObject = bnqu.a();
      if (j != 1) {}
      for (;;)
      {
        ((bnqu)localObject).a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", bool, 0);
        bnrh.b("AECircleMultiUnit", "[initBottomTab] choose tab index=" + j);
        localArrayList.add(this.jdField_a_of_type_Borh.a().getResources().getString(2131694615));
        localArrayList.add(this.jdField_a_of_type_Borh.a().getResources().getString(2131689671));
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.a(this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager);
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabSelectedCallback(new bmvw(this));
        if (a()) {
          break;
        }
        if (j != 0) {
          h();
        }
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, 0);
        return;
        bool = false;
      }
      this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, j);
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(new bmvx(this));
  }
  
  private void g()
  {
    bnqe.a().b();
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setCurrentItem(1, true);
    this.jdField_a_of_type_Bmxa.j();
    this.jdField_a_of_type_Bmxa.d();
  }
  
  private void h()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Borh.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Borh.a();
    int i;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      label48:
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label132;
      }
    }
    label132:
    for (int j = 1;; j = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      i = 0;
      break label48;
    }
  }
  
  private void l()
  {
    Intent localIntent = new Intent();
    bnrh.b("AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_Borh.a().getLayoutInflater().inflate(2131558515, null);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2131381118));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout = ((TabLayout)localView.findViewById(2131378390));
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout = ((AETouchNotifyRelativeLayout)localView.findViewById(2131367063));
    this.jdField_a_of_type_Bmvy.a(this.jdField_a_of_type_DovComQqImAeViewTabLayout);
    this.jdField_a_of_type_Bmwa = new bmwa(null);
    this.jdField_a_of_type_JavaUtilList.add(new bmvz(this.jdField_a_of_type_Bmwz, this.jdField_a_of_type_Bmwz.a()));
    this.jdField_a_of_type_JavaUtilList.add(new bmvz(this.jdField_a_of_type_Bmxa, this.jdField_a_of_type_Bmxa.a()));
    this.jdField_a_of_type_Bmwa.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_Bmwa);
    e();
    f();
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    bnrh.b("AECircleMultiUnit", "on activity result.");
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 203) {
      a().a(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt2 != -1) || (a() == null) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      String str1;
      String str2;
      ArrayList localArrayList;
      if (paramIntent.getBooleanExtra("h5_key_flag", false))
      {
        str1 = paramIntent.getStringExtra("h5_key_video_path");
        str2 = paramIntent.getStringExtra("h5_key_thumb_path");
        localArrayList = new ArrayList();
        localArrayList.add(str1);
        HashMap localHashMap = new HashMap();
        localHashMap.put(str1, bodk.a(bodk.a(str1, str2), paramIntent.getStringExtra("widgetinfo"), null, 1, null));
        bode.a(a(), localArrayList, localHashMap, bnlb.a(a().getIntent()));
      }
      while (paramInt1 != 203)
      {
        this.jdField_a_of_type_Borh.a().finish();
        return;
        if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
        {
          str1 = paramIntent.getStringExtra("ae_editor_video_path");
          str2 = paramIntent.getStringExtra("ae_editor_video_thumb_path");
          paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
          int i = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
          localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
          int j = paramIntent.getIntExtra("ae_editor_video_from", bnlb.a.a());
          paramIntent = (LocalMediaInfo)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
          bode.a(a(), str1, str2, new Size(i, paramInt2), localArrayList, paramIntent, j);
        }
        else
        {
          bode.a(a(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnlb.a.a()));
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Bmxa = new bmxa(this.jdField_a_of_type_Borh, this.jdField_a_of_type_Borg);
    this.jdField_a_of_type_Bmwz = new bmwz(this.jdField_a_of_type_Borh, this.jdField_a_of_type_Borg);
    this.jdField_a_of_type_Bmxa.a(paramBundle);
    this.jdField_a_of_type_Bmwz.a(paramBundle);
    LiuHaiUtils.b(this.jdField_a_of_type_Borh.a());
    a(this.jdField_a_of_type_Borh.a(), this.jdField_a_of_type_Borh.a().getResources().getColor(2131167296), true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("ae_editor_bottom_tab_show_hide");
    paramBundle.addAction("ae_editor_bottom_tab_change_style");
    Activity localActivity = this.jdField_a_of_type_Borh.a();
    bmvy localbmvy = new bmvy(null);
    this.jdField_a_of_type_Bmvy = localbmvy;
    localActivity.registerReceiver(localbmvy, paramBundle);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      b();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public void b()
  {
    super.b();
    a().b();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    a().b(paramBundle);
  }
  
  public boolean b()
  {
    a().b();
    return super.b();
  }
  
  public void c()
  {
    super.c();
    bnrh.b("AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_Borh.a().unregisterReceiver(this.jdField_a_of_type_Bmvy);
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(null);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bmvz localbmvz = (bmvz)localIterator.next();
        if ((localbmvz != null) && (bmvz.a(localbmvz) != null)) {
          bmvz.a(localbmvz).c();
        }
      }
    }
  }
  
  public void d()
  {
    super.d();
    a().d();
    if (this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem() == 0) {
      bnqm.a().ae();
    }
    for (;;)
    {
      l();
      bnrh.b("AECircleMultiUnit", "onResume.");
      if (this.jdField_a_of_type_Bmxa != null) {
        this.jdField_a_of_type_Bmxa.M();
      }
      return;
      bnqm.a().af();
    }
  }
  
  @QQPermissionDenied(1)
  public void denied() {}
  
  @QQPermissionGrant(1)
  public void grant()
  {
    g();
  }
  
  public void j()
  {
    super.j();
    a().j();
  }
  
  public void k()
  {
    super.k();
    a().k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvv
 * JD-Core Version:    0.7.0.1
 */