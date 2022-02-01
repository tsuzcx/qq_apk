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

public class boeg
  extends bocu
{
  private boej jdField_a_of_type_Boej;
  private boel jdField_a_of_type_Boel;
  private bofg jdField_a_of_type_Bofg;
  private bofh jdField_a_of_type_Bofh;
  private bqah jdField_a_of_type_Bqah;
  private bqai jdField_a_of_type_Bqai;
  private AETouchNotifyRelativeLayout jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_DovComQqImAeViewTabLayout;
  private List<boek> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = bpan.a();
  
  public boeg(bqai parambqai, bqah parambqah)
  {
    this.jdField_a_of_type_Bqai = parambqai;
    this.jdField_a_of_type_Bqah = parambqah;
    a();
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_Bqai == null) {
      return null;
    }
    return this.jdField_a_of_type_Bqai.a();
  }
  
  private bocu a()
  {
    int i = this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem();
    return boek.a((boek)this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a()
  {
    if (a() == null) {
      return;
    }
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (born.a(i).a()) {
      bozv.a().a(i, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bozv.a().a(str);
    bozv.a().a(true);
    bozv.a().b();
    bozv.a().a();
    bozv.a().b(boqg.a(a()));
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
  
  private void b()
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
        if (bozz.a().a("circle_entry_type_camera", false, 4)) {
          j = 1;
        }
      }
      localObject = bozz.a();
      if (j != 1) {}
      for (;;)
      {
        ((bozz)localObject).a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", bool, 0);
        bpam.b("AECircleMultiUnit", "[initBottomTab] choose tab index=" + j);
        localArrayList.add(this.jdField_a_of_type_Bqai.a().getResources().getString(2131694300));
        localArrayList.add(this.jdField_a_of_type_Bqai.a().getResources().getString(2131689672));
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.a(this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager);
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabSelectedCallback(new boeh(this));
        if (b()) {
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
  
  private boolean b()
  {
    Activity localActivity = this.jdField_a_of_type_Bqai.a();
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
  
  private void c()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(new boei(this));
  }
  
  private void g()
  {
    bowp.a().b();
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setCurrentItem(1, true);
    this.jdField_a_of_type_Bofh.p();
    this.jdField_a_of_type_Bofh.f();
  }
  
  private void h()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Bqai.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bqai.a();
    int i;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      label49:
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label136;
      }
    }
    label136:
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
      break label49;
    }
  }
  
  private void i()
  {
    Intent localIntent = new Intent();
    bpam.b("AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_Bqai.a().getLayoutInflater().inflate(2131558505, null);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2131381041));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout = ((TabLayout)localView.findViewById(2131378335));
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout = ((AETouchNotifyRelativeLayout)localView.findViewById(2131366922));
    this.jdField_a_of_type_Boej.a(this.jdField_a_of_type_DovComQqImAeViewTabLayout);
    this.jdField_a_of_type_Boel = new boel(null);
    this.jdField_a_of_type_JavaUtilList.add(new boek(this.jdField_a_of_type_Bofg, this.jdField_a_of_type_Bofg.a()));
    this.jdField_a_of_type_JavaUtilList.add(new boek(this.jdField_a_of_type_Bofh, this.jdField_a_of_type_Bofh.a()));
    this.jdField_a_of_type_Boel.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_Boel);
    b();
    c();
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    bpam.b("AECircleMultiUnit", "on activity result.");
    if ((paramInt2 != -1) || (a() == null) || (paramIntent == null)) {
      return;
    }
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
      localHashMap.put(str1, bpkw.a(bpkw.a(str1, str2), paramIntent.getStringExtra("widgetinfo"), null, 1, null));
      bpkq.a(a(), localArrayList, localHashMap, born.a(a().getIntent()));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bqai.a().finish();
      return;
      if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
      {
        str1 = paramIntent.getStringExtra("ae_editor_video_path");
        str2 = paramIntent.getStringExtra("ae_editor_video_thumb_path");
        paramInt1 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
        paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
        localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
        int i = paramIntent.getIntExtra("ae_editor_video_from", born.a.a());
        paramIntent = (LocalMediaInfo)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        bpkq.a(BaseApplicationImpl.getContext(), str1, str2, new Size(paramInt2, paramInt1), localArrayList, paramIntent, i);
      }
      else
      {
        bpkq.a(a(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a()));
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Bofh = new bofh(this.jdField_a_of_type_Bqai, this.jdField_a_of_type_Bqah);
    this.jdField_a_of_type_Bofg = new bofg(this.jdField_a_of_type_Bqai, this.jdField_a_of_type_Bqah);
    this.jdField_a_of_type_Bofh.a(paramBundle);
    this.jdField_a_of_type_Bofg.a(paramBundle);
    LiuHaiUtils.b(this.jdField_a_of_type_Bqai.a());
    a(this.jdField_a_of_type_Bqai.a(), this.jdField_a_of_type_Bqai.a().getResources().getColor(2131167247), true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("ae_editor_bottom_tab_show_hide");
    paramBundle.addAction("ae_editor_bottom_tab_change_style");
    Activity localActivity = this.jdField_a_of_type_Bqai.a();
    boej localboej = new boej(null);
    this.jdField_a_of_type_Boej = localboej;
    localActivity.registerReceiver(localboej, paramBundle);
  }
  
  public boolean a()
  {
    a().a();
    return super.a();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      a();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    a().b(paramBundle);
  }
  
  public void b_(int paramInt1, int paramInt2)
  {
    super.b_(paramInt1, paramInt2);
    a().b_(paramInt1, paramInt2);
  }
  
  public void d()
  {
    super.d();
    a().d();
  }
  
  @QQPermissionDenied(1)
  public void denied() {}
  
  public void e()
  {
    super.e();
    bpam.b("AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_Bqai.a().unregisterReceiver(this.jdField_a_of_type_Boej);
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(null);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        boek localboek = (boek)localIterator.next();
        if ((localboek != null) && (boek.a(localboek) != null)) {
          boek.a(localboek).e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    a().f();
    if (this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem() == 0) {
      bozr.a().aa();
    }
    for (;;)
    {
      i();
      bpam.b("AECircleMultiUnit", "onResume.");
      if (this.jdField_a_of_type_Bofh != null) {
        this.jdField_a_of_type_Bofh.a();
      }
      return;
      bozr.a().ab();
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    g();
  }
  
  public void p()
  {
    super.p();
    a().p();
  }
  
  public void t()
  {
    super.t();
    a().t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boeg
 * JD-Core Version:    0.7.0.1
 */