import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipeback.PostTable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import mqq.util.WeakReference;

@ProxyService(proxy=PageGestureProxy.class)
public class bkzk
  implements aqrn, PageGestureProxy
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  protected aqre a;
  private aqrf jdField_a_of_type_Aqrf;
  private aqrn jdField_a_of_type_Aqrn;
  private aquf jdField_a_of_type_Aquf;
  private aqvl jdField_a_of_type_Aqvl;
  private bhpc jdField_a_of_type_Bhpc;
  public PostTable a;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private boolean c;
  
  private ColorNote a()
  {
    if (this.jdField_a_of_type_Aqrn != null) {
      return this.jdField_a_of_type_Aqrn.getColorNote();
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Aquf == null)
    {
      this.jdField_a_of_type_Aqrf = new aqrf();
      this.jdField_a_of_type_Aqrf.a(new bkzn(this));
      this.jdField_a_of_type_Aquf = new aquf();
      this.jdField_a_of_type_Aquf.a(this.jdField_a_of_type_Aqrf);
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_Aqre = new aqre(paramActivity, false, true);
    this.jdField_a_of_type_Aqre.a(paramActivity);
    this.jdField_a_of_type_Aqre.a(this);
    this.jdField_a_of_type_Aqre.a(new bkzl(this, paramActivity));
    this.jdField_a_of_type_Aqre.a(new bkzm(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable = new PostTable(paramActivity);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramActivity.getSystemService("vibrator"));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    Object localObject;
    do
    {
      return;
      if (this.jdField_a_of_type_Bhpc != null) {
        break;
      }
      localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while (localObject == null);
    this.jdField_a_of_type_Bhpc = new bhpc((Context)localObject, 2131755824);
    this.jdField_a_of_type_Bhpc.setContentView(2131559008);
    this.jdField_a_of_type_Bhpc.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bhpc.setTitle(((Activity)localObject).getString(2131690759));
    this.jdField_a_of_type_Bhpc.setNegativeButton(((Activity)localObject).getString(2131690758), new bkzo(this, (Activity)localObject));
    for (;;)
    {
      this.jdField_a_of_type_Bhpc.show();
      localObject = this.jdField_a_of_type_Bhpc.getTitleTextView();
      ((View)localObject).setClickable(true);
      ((View)localObject).setFocusable(true);
      ((View)localObject).setFocusableInTouchMode(true);
      bhga.a((View)localObject, true);
      return;
      if (this.jdField_a_of_type_Bhpc.isShowing()) {
        this.jdField_a_of_type_Bhpc.dismiss();
      }
    }
  }
  
  public aqre a()
  {
    return this.jdField_a_of_type_Aqre;
  }
  
  public void a(aqrn paramaqrn)
  {
    this.jdField_a_of_type_Aqrn = paramaqrn;
    a();
    this.jdField_a_of_type_Aquf.a(paramaqrn);
  }
  
  public ColorNote getColorNote()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null)
    {
      MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
      if (QLog.isColorLevel()) {
        QLog.d("PageGuestureProxyImpl", 2, "getColorNote, appId: " + localMiniAppInfo.appId + ", name: " + localMiniAppInfo.name);
      }
      return new aqrv().a(16842752).a(localMiniAppInfo.appId).b(localMiniAppInfo.name).c(localMiniAppInfo.desc).d(localMiniAppInfo.iconUrl).a();
    }
    return null;
  }
  
  public void onActivityCreate(Activity paramActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    a(paramActivity);
  }
  
  public void onActivityDestroy(Activity paramActivity)
  {
    this.jdField_a_of_type_Aqre.c();
  }
  
  public void onActivityFinish(Activity paramActivity) {}
  
  public void onActivityPause(Activity paramActivity)
  {
    this.jdField_a_of_type_Aqre.b();
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    this.jdField_a_of_type_Aqre.a();
  }
  
  public void onActivityStop(Activity paramActivity)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onActivityStop");
    this.jdField_a_of_type_Aqre.b();
  }
  
  public void onCreateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void onLoadUrl(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    }
    a(this);
  }
  
  public void onMoveTaskToBack(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Aqre != null) && (this.jdField_a_of_type_Aqre.c())) {
      this.jdField_a_of_type_Aqre.d();
    }
  }
  
  public void onPageWebViewInit()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localActivity != null) {
        this.jdField_a_of_type_Aqvl = new aqvl(localActivity);
      }
    }
    a();
  }
  
  public void onProcessTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onProcessTouchEvent");
    double d;
    Object localObject;
    boolean bool1;
    if ((this.jdField_a_of_type_Aqrf != null) && (this.jdField_a_of_type_Aqrf.b()) && (this.jdField_a_of_type_Aqvl != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable != null))
    {
      d = this.jdField_a_of_type_Aqvl.a(paramMotionEvent);
      this.jdField_a_of_type_Aqrf.a();
      localObject = this.jdField_a_of_type_Aqrn.getColorNote();
      if (localObject == null) {
        break label323;
      }
      bool1 = this.jdField_a_of_type_Aqrf.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {
        break label383;
      }
    }
    label227:
    label383:
    for (boolean bool2 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.isLimitedAccessApp();; bool2 = false)
    {
      if ((d > 0.0D) && (!bool1) && (!bool2) && (this.jdField_a_of_type_MqqUtilWeakReference != null))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(0);
          this.jdField_a_of_type_Boolean = true;
        }
        localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if ((this.jdField_a_of_type_Aqrf.a()) && (localObject != null)) {
          if (this.jdField_a_of_type_Aqvl.a(paramMotionEvent, (Context)localObject))
          {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.b();
            if ((!this.c) && (this.jdField_a_of_type_AndroidOsVibrator != null))
            {
              this.jdField_a_of_type_AndroidOsVibrator.vibrate(20L);
              this.c = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(d);
            if (this.b)
            {
              bdll.b(null, "dc00898", "", "", "0X800A741", "0X800A741", aqrd.a(this.jdField_a_of_type_Aqrn.getColorNote().mServiceType), 0, "", "", "", "");
              this.b = false;
            }
          }
        }
      }
      for (;;)
      {
        if ((paramMotionEvent.getActionMasked() == 1) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
          this.jdField_a_of_type_Boolean = false;
        }
        return;
        bool1 = false;
        break;
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a();
        this.c = false;
        break label227;
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.c();
        break label227;
        if ((d < 1.0E-008D) || (bool1))
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  public boolean onViewReleasedAndNeedScrollOriginPosition(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    QLog.d("PageGuestureProxyImpl", 1, "onViewReleased");
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.isLimitedAccessApp();; bool1 = false)
    {
      if (bool1) {
        return false;
      }
      ColorNote localColorNote = a();
      Activity localActivity;
      if (localColorNote != null)
      {
        bool1 = this.jdField_a_of_type_Aqrf.a(localColorNote.getServiceType(), localColorNote.getSubType());
        this.b = true;
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label222;
        }
        localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
        label85:
        if ((this.jdField_a_of_type_Aqvl == null) || (!this.jdField_a_of_type_Aqvl.a(paramMotionEvent, localActivity)) || (bool1) || (localColorNote == null)) {
          break label278;
        }
        if (!this.jdField_a_of_type_Aqrf.a()) {
          break label228;
        }
        paramMotionEvent = localColorNote.parseBundle();
        paramMotionEvent.putInt("color_note_curd_from_type", 1);
        this.jdField_a_of_type_Aqrf.a(paramMotionEvent);
        bdll.b(null, "dc00898", "", "", "0X800A742", "0X800A742", aqrd.a(this.jdField_a_of_type_Aqrn.getColorNote().mServiceType), 0, "", "", "", "");
        bool1 = false;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
          this.jdField_a_of_type_Boolean = false;
        }
        return bool1;
        bool1 = false;
        break;
        label222:
        localActivity = null;
        break label85;
        label228:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        b();
        bdll.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        bool1 = bool2;
        continue;
        label278:
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzk
 * JD-Core Version:    0.7.0.1
 */