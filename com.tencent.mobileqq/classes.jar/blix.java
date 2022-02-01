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

public class blix
  extends blic
{
  private blja jdField_a_of_type_Blja;
  private bljc jdField_a_of_type_Bljc;
  private bljx jdField_a_of_type_Bljx;
  private bljy jdField_a_of_type_Bljy;
  private bnbo jdField_a_of_type_Bnbo;
  private bnbp jdField_a_of_type_Bnbp;
  private AETouchNotifyRelativeLayout jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_DovComQqImAeViewTabLayout;
  private List<bljb> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = bmby.a();
  
  public blix(bnbp parambnbp, bnbo parambnbo)
  {
    this.jdField_a_of_type_Bnbp = parambnbp;
    this.jdField_a_of_type_Bnbo = parambnbo;
    a();
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_Bnbp == null) {
      return null;
    }
    return this.jdField_a_of_type_Bnbp.a();
  }
  
  private blic a()
  {
    int i = this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem();
    return bljb.a((bljb)this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a()
  {
    if (a() == null) {
      return;
    }
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blvr.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (blvr.a(i).a()) {
      bmbg.a().a(i, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bmbg.a().a(str);
    bmbg.a().a(true);
    bmbg.a().b();
    bmbg.a().a();
    bmbg.a().b(blun.a(a()));
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
    if (blvr.j(paramActivity.getIntent()))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("ae_editor_bottom_tab_show_hide");
      localIntent.putExtra("is_show", paramBoolean);
      paramActivity.sendBroadcast(localIntent);
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
        if (bmbk.a().a("circle_entry_type_camera", false, 4)) {
          j = 1;
        }
      }
      localObject = bmbk.a();
      if (j != 1) {}
      for (;;)
      {
        ((bmbk)localObject).a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", bool, 0);
        bmbx.b("AECircleMultiUnit", "[initBottomTab] choose tab index=" + j);
        localArrayList.add(this.jdField_a_of_type_Bnbp.a().getResources().getString(2131694414));
        localArrayList.add(this.jdField_a_of_type_Bnbp.a().getResources().getString(2131689671));
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.a(this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager);
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabSelectedCallback(new bliy(this));
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
    Activity localActivity = this.jdField_a_of_type_Bnbp.a();
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
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(new bliz(this));
  }
  
  private void g()
  {
    bmau.a().b();
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setCurrentItem(1, true);
    this.jdField_a_of_type_Bljy.o();
    this.jdField_a_of_type_Bljy.f();
  }
  
  private void h()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Bnbp.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bnbp.a();
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
    bmbx.b("AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_Bnbp.a().getLayoutInflater().inflate(2131558504, null);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2131380767));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout = ((TabLayout)localView.findViewById(2131378102));
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout = ((AETouchNotifyRelativeLayout)localView.findViewById(2131366945));
    this.jdField_a_of_type_Blja.a(this.jdField_a_of_type_DovComQqImAeViewTabLayout);
    this.jdField_a_of_type_Bljc = new bljc(null);
    this.jdField_a_of_type_JavaUtilList.add(new bljb(this.jdField_a_of_type_Bljx, this.jdField_a_of_type_Bljx.a()));
    this.jdField_a_of_type_JavaUtilList.add(new bljb(this.jdField_a_of_type_Bljy, this.jdField_a_of_type_Bljy.a()));
    this.jdField_a_of_type_Bljc.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_Bljc);
    b();
    c();
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    bmbx.b("AECircleMultiUnit", "on activity result.");
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
      localHashMap.put(str1, bmns.a(bmns.a(str1, str2), paramIntent.getStringExtra("widgetinfo"), null, 1, null));
      bmnm.a(a(), localArrayList, localHashMap, blvr.a(a().getIntent()));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnbp.a().finish();
      return;
      if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
      {
        str1 = paramIntent.getStringExtra("ae_editor_video_path");
        str2 = paramIntent.getStringExtra("ae_editor_video_thumb_path");
        paramInt1 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
        paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
        localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
        int i = paramIntent.getIntExtra("ae_editor_video_from", blvr.a.a());
        paramIntent = (LocalMediaInfo)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        bmnm.a(a(), str1, str2, new Size(paramInt2, paramInt1), localArrayList, paramIntent, i);
      }
      else
      {
        bmnm.a(a(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blvr.a.a()));
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Bljy = new bljy(this.jdField_a_of_type_Bnbp, this.jdField_a_of_type_Bnbo);
    this.jdField_a_of_type_Bljx = new bljx(this.jdField_a_of_type_Bnbp, this.jdField_a_of_type_Bnbo);
    this.jdField_a_of_type_Bljy.a(paramBundle);
    this.jdField_a_of_type_Bljx.a(paramBundle);
    LiuHaiUtils.b(this.jdField_a_of_type_Bnbp.a());
    a(this.jdField_a_of_type_Bnbp.a(), this.jdField_a_of_type_Bnbp.a().getResources().getColor(2131167276), true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("ae_editor_bottom_tab_show_hide");
    paramBundle.addAction("ae_editor_bottom_tab_change_style");
    Activity localActivity = this.jdField_a_of_type_Bnbp.a();
    blja localblja = new blja(null);
    this.jdField_a_of_type_Blja = localblja;
    localActivity.registerReceiver(localblja, paramBundle);
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
    bmbx.b("AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_Bnbp.a().unregisterReceiver(this.jdField_a_of_type_Blja);
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(null);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bljb localbljb = (bljb)localIterator.next();
        if ((localbljb != null) && (bljb.a(localbljb) != null)) {
          bljb.a(localbljb).e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    a().f();
    if (this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem() == 0) {
      bmbc.a().ae();
    }
    for (;;)
    {
      i();
      bmbx.b("AECircleMultiUnit", "onResume.");
      if (this.jdField_a_of_type_Bljy != null) {
        this.jdField_a_of_type_Bljy.C();
      }
      return;
      bmbc.a().af();
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    g();
  }
  
  public void o()
  {
    super.o();
    a().o();
  }
  
  public void p()
  {
    super.p();
    a().p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blix
 * JD-Core Version:    0.7.0.1
 */