import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.Toast;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.10;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.16;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.5;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class boll
  extends bowm
  implements bczs, bomc, bomd<bolk>, bome<bolk>
{
  protected int a;
  protected bofh a;
  protected bojq a;
  public bolg a;
  public boqr a;
  private bowk jdField_a_of_type_Bowk;
  private bowl jdField_a_of_type_Bowl;
  private bpap jdField_a_of_type_Bpap;
  public AEBottomListScrollView a;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private volatile boolean jdField_a_of_type_Boolean;
  
  public boll(Activity paramActivity, View paramView, bown parambown)
  {
    super(paramActivity, paramView, parambown);
    this.jdField_a_of_type_Bofh = ((bofh)parambown.a(65537, new Object[0]));
    this.jdField_a_of_type_Bojq = this.jdField_a_of_type_Bofh.a();
  }
  
  private int a(String paramString)
  {
    int j;
    if (paramString == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_Bolg.getItemCount()) {
        break label57;
      }
      boqu localboqu = this.jdField_a_of_type_Bolg.a(i);
      if (localboqu != null)
      {
        j = i;
        if (paramString.equals(localboqu.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  private boqu a(int paramInt)
  {
    if (this.jdField_a_of_type_Bolg != null) {
      return this.jdField_a_of_type_Bolg.a(paramInt);
    }
    return null;
  }
  
  private void a(boqu paramboqu)
  {
    if ((paramboqu != null) && (!paramboqu.equals(boqu.jdField_a_of_type_Boqu)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Bolg.getItemCount()) || (this.jdField_a_of_type_Bolg.a(i) == null)) {
        break label103;
      }
      if (!paramboqu.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bolg.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Bolg.a(i).a(paramboqu);
      b(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Bolg.a(paramboqu);
        b(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private void a(String paramString)
  {
    int i = 1;
    bozv.a().f("-1");
    int j = a(paramString);
    if (j != -1)
    {
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("widgetinfo", "camera^" + paramString);
      paramString = a(j);
      if (paramString != null)
      {
        bozr.a().d(paramString.jdField_a_of_type_JavaLangString);
        paramString.b = true;
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("key_camera_material_name", paramString.i);
      }
      i = j;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_Bolg.getItemCount())
      {
        b(i);
        this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getAdapter().notifyDataSetChanged();
      }
      return;
      boqr localboqr = this.jdField_a_of_type_Boqr;
      if ((this.jdField_a_of_type_Bofh != null) && (this.jdField_a_of_type_Bofh.b())) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = localboqr.a(paramString, bool);
        if (paramString == null) {
          break label195;
        }
        this.jdField_a_of_type_Bolg.a(paramString);
        bozr.a().d(paramString.jdField_a_of_type_JavaLangString);
        paramString.b = true;
        break;
      }
      label195:
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
        Toast.makeText(this.jdField_a_of_type_Bofh.a(), 2131689675, 1).show();
      }
      i = 0;
    }
  }
  
  @MainThread
  private void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      if ((paramString1 == null) || (paramString1.equals(AECaptureMode.NORMAL.name)))
      {
        if (paramString2 == null) {
          break label96;
        }
        if (!paramString2.startsWith("http")) {
          break label67;
        }
        b(paramString2);
      }
    }
    for (;;)
    {
      r();
      this.jdField_a_of_type_Boqr.a(this, 116);
      return;
      label67:
      if (!this.jdField_a_of_type_Boolean)
      {
        a(paramString2);
      }
      else
      {
        bpam.b("AEBottomListPart", "take same procedure CANCELED, handleNormalEnter");
        s();
        continue;
        label96:
        s();
      }
    }
  }
  
  @WorkerThread
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Boqr.a(paramBoolean, a());
    ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, (List)localObject));
    localObject = this.jdField_a_of_type_Boqr.a(paramString2, a());
    if ((a(paramString1, paramString2)) && (localObject != null) && (!((boqu)localObject).f) && (!((boqu)localObject).e))
    {
      if (bhnv.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label131;
      }
      bpam.b("AEBottomListPart", "loadAndHandleData---no network");
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.getUIHandler().post(new AEBottomListPart.8(this));
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEBottomListPart.10(this, paramString1, paramString2));
      return;
      label131:
      this.jdField_a_of_type_Boqr.a(this.jdField_a_of_type_Boqr.a(), (boqu)localObject, new bolw(this));
      bpam.b("AEBottomListPart", "wait till takeSameMaterial download finish, BEGIN");
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        bpam.b("AEBottomListPart", "wait till takeSameMaterial download finish, OVER");
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  private boolean a(boqu paramboqu)
  {
    if (paramboqu != null) {
      return paramboqu.a();
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!paramString1.equals(AECaptureMode.NORMAL.name)) {}
    }
    else
    {
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (!paramString2.startsWith("http")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(int paramInt)
  {
    bpam.a("AEBottomListPart", "reset Selection pos: " + paramInt);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Bolg.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  private void b(String paramString)
  {
    bpam.b("AEBottomListPart", "handleTakeSameH5Enter---url=" + paramString);
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Bofh.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLDecoder.decode(paramString, "UTF-8"));
      localIntent.putExtra("loc_play_show_material_id", paramString);
      this.jdField_a_of_type_Bofh.a().startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean c()
  {
    Boolean localBoolean;
    if ((this.jdField_a_of_type_Bowl != null) && (this.jdField_a_of_type_Bowl.a() != null))
    {
      localBoolean = (Boolean)this.jdField_a_of_type_Bowl.a().getValue();
      if (localBoolean == null) {}
    }
    for (boolean bool = localBoolean.booleanValue();; bool = true) {
      return (!d()) && (this.jdField_a_of_type_Bowk.b()) && (bool);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && ((born.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (born.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (born.i(this.jdField_a_of_type_AndroidAppActivity.getIntent())));
  }
  
  private void p()
  {
    if (!c()) {
      return;
    }
    aazq.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bolu(this)).b();
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_Bpap == null)
      {
        this.jdField_a_of_type_Bpap = new bpap(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_Bpap.a(new bolv(this));
      }
      this.jdField_a_of_type_Bpap.show();
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) && (this.jdField_a_of_type_Bpap != null) && (this.jdField_a_of_type_Bpap.isShowing())) {
      this.jdField_a_of_type_Bpap.dismiss();
    }
  }
  
  private void s()
  {
    int i = 0;
    boqu localboqu = boqr.a();
    if (localboqu != null)
    {
      int j = a(localboqu.jdField_a_of_type_JavaLangString);
      i = j;
      if (j == -1)
      {
        this.jdField_a_of_type_Bolg.a(localboqu);
        i = 1;
      }
    }
    if (i < this.jdField_a_of_type_Bolg.getItemCount()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.scrollToPosition(i);
    }
  }
  
  private void t()
  {
    int j = 0;
    boqu localboqu1 = boqr.a();
    if (localboqu1 != null)
    {
      boqu localboqu2 = this.jdField_a_of_type_Bolg.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localboqu2 != null)
      {
        i = j;
        if (localboqu1.jdField_a_of_type_JavaLangString.equals(localboqu2.jdField_a_of_type_JavaLangString))
        {
          b(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Bolg.getItemCount()) {
          break;
        }
        localboqu2 = this.jdField_a_of_type_Bolg.a(i);
      } while ((localboqu2 == null) || (!localboqu1.jdField_a_of_type_JavaLangString.equals(localboqu2.jdField_a_of_type_JavaLangString)));
      b(i);
      return;
    }
    b(0);
    return;
    b(this.jdField_a_of_type_Int);
  }
  
  public boqr a()
  {
    return this.jdField_a_of_type_Boqr;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378106)).inflate().findViewById(2131374181));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new aazy().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Bolg = new bolg(this.jdField_a_of_type_Bofh, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Bojq);
      this.jdField_a_of_type_Bolg.a(new bolm(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bolg);
      this.jdField_a_of_type_Boqr = ((boqr)bplq.a().c(18));
      if (d()) {
        break label243;
      }
      this.jdField_a_of_type_Boqr.a(this, 113);
      this.jdField_a_of_type_Boqr.a(this, 114);
      this.jdField_a_of_type_Boqr.a(this, 115);
      this.jdField_a_of_type_Boqr.a(this, 112);
      b();
      f();
    }
    for (;;)
    {
      e();
      return;
      label243:
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      this.jdField_a_of_type_Bolg.b();
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable bolk parambolk1, @Nullable bolk parambolk2) {}
  
  protected void a(int paramInt)
  {
    Animation localAnimation = bpul.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    localAnimation.setStartOffset(0L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new bolq(this, paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (c()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      i();
      return;
      j();
      return;
      this.jdField_a_of_type_Bowl.b().postValue(Boolean.valueOf(false));
      this.jdField_a_of_type_Bowl.c().postValue(Boolean.valueOf(false));
    } while ((!this.jdField_a_of_type_Bowk.b()) || (d()));
    t();
    h();
  }
  
  public void a(@NonNull bolk parambolk, int paramInt)
  {
    parambolk.a(4);
  }
  
  public void a(@NonNull bolk parambolk, boolean paramBoolean)
  {
    if (parambolk.jdField_a_of_type_Boqu.b) {
      parambolk.jdField_a_of_type_Boqu.c = true;
    }
    for (;;)
    {
      if ((boqr.a() != null) && (!boqr.a().equals(parambolk.jdField_a_of_type_Boqu)))
      {
        boqr.a().b = false;
        boqr.a().c = false;
      }
      return;
      parambolk.jdField_a_of_type_Boqu.b = true;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = boqr.a();
      if ((paramObject == null) || (paramObject.equals(boqu.jdField_a_of_type_Boqu)))
      {
        b(0);
        QLog.d("AEBottomListPart", 4, "current pendant has change");
      }
    }
    label195:
    do
    {
      for (;;)
      {
        return;
        a(paramObject);
        break;
        if (paramInt == 114)
        {
          paramObject = boqr.a();
          if (paramObject != null) {
            paramObject.jdField_a_of_type_Boolean = true;
          }
          a(paramObject);
          return;
        }
        if (paramInt == 115)
        {
          paramObject = boqr.a();
          if (paramObject != null) {
            paramObject.jdField_a_of_type_Boolean = false;
          }
          a(paramObject);
          return;
        }
        if (paramInt != 112) {
          break label195;
        }
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof boqu)))
        {
          paramObject = (boqu)paramVarArgs[0];
          paramInt = 0;
          while (paramInt < this.jdField_a_of_type_Bolg.getItemCount())
          {
            paramVarArgs = this.jdField_a_of_type_Bolg.a(paramInt);
            if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
            {
              paramVarArgs.e = true;
              paramVarArgs.f = false;
              this.jdField_a_of_type_Bolg.notifyItemChanged(paramInt);
              return;
            }
            paramInt += 1;
          }
        }
      }
    } while (paramInt != 116);
    bpam.b("AEBottomListPart", "notify---TEMPLATE_INFO_LIST_UPDATE");
    ThreadManager.getUIHandler().post(new AEBottomListPart.16(this));
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bolg.a();
    bozv.a().g();
    bozr.a().X();
  }
  
  public void b(@NonNull bolk parambolk, int paramInt)
  {
    if (!"call_material_id".equals(parambolk.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      parambolk.jdField_a_of_type_Boqu.b = true;
      if ((boqr.a() != null) && (!boqr.a().equals(parambolk.jdField_a_of_type_Boqu)))
      {
        boqr.a().b = false;
        boqr.a().c = false;
      }
    }
    QLog.d("AEBottomListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    if ((boqr.a() != null) && (!boqr.a().c()) && (this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("widgetinfo", "camera^" + boqr.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(@Nullable bolk parambolk, int paramInt)
  {
    if (parambolk != null)
    {
      parambolk.a(3);
      parambolk = parambolk.jdField_a_of_type_Boqu;
      bopi.a().a(parambolk);
      if (this.jdField_a_of_type_Bolg != null)
      {
        if (!a(parambolk)) {
          break label46;
        }
        zqd.a(this.jdField_a_of_type_AndroidAppActivity, parambolk);
      }
    }
    return;
    label46:
    this.jdField_a_of_type_Bolg.b(parambolk);
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    this.jdField_a_of_type_Bowk.a.observe(this.jdField_a_of_type_Bofh, new bols(this));
    this.jdField_a_of_type_Bowl = ((bowl)bofz.a(this.jdField_a_of_type_Bofh).get(bowl.class));
    this.jdField_a_of_type_Bowl.a().observe(this.jdField_a_of_type_Bofh, new bolt(this));
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    String str1 = localIntent.getStringExtra("KEY_CURRENT_SELECT_ID");
    String str2 = localIntent.getStringExtra("KEY_CURRENT_TAB");
    if ("null".equalsIgnoreCase(str1)) {
      str1 = null;
    }
    for (;;)
    {
      boolean bool = a(str2, str1);
      if (bool)
      {
        ((boqr)bplq.a(18)).a(str1);
        boqu localboqu = this.jdField_a_of_type_Boqr.a(str1, a());
        if ((localboqu != null) && (localboqu.e))
        {
          bool = false;
          if (bool)
          {
            q();
            if (this.jdField_a_of_type_Bpap != null) {
              this.jdField_a_of_type_Bpap.a(10);
            }
          }
          localIntent.removeExtra("KEY_CURRENT_SELECT_ID");
          localIntent.removeExtra("KEY_CURRENT_TAB");
        }
      }
      for (;;)
      {
        ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this, str2, str1, bool));
        return;
        break;
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boqr.a(this);
    this.jdField_a_of_type_Boqr.j();
    if (this.jdField_a_of_type_Bolg != null) {
      this.jdField_a_of_type_Bolg.c();
    }
  }
  
  @TargetApi(12)
  protected void h()
  {
    int i = zps.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    localAnimatorSet.addListener(new boln(this));
    localAnimatorSet.setDuration(300L).start();
    k();
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Bowk.a())
    {
      if (this.jdField_a_of_type_Bown != null)
      {
        this.jdField_a_of_type_Bown.a(327683, new Object[0]);
        this.jdField_a_of_type_Bown.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bofh.a().a(true, 150);
      return;
    }
    int i = zps.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bolo(this));
    localAnimatorSet.setDuration(300L).start();
    a(327683);
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_Bowk.a())
    {
      if (this.jdField_a_of_type_Bown != null)
      {
        this.jdField_a_of_type_Bown.a(327684, new Object[0]);
        this.jdField_a_of_type_Bown.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bofh.a().a(true, 150);
      return;
    }
    int i = zps.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bolp(this));
    localAnimatorSet.setDuration(300L).start();
    a(327684);
  }
  
  protected void k()
  {
    Animation localAnimation = bpul.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    localAnimation.setStartOffset(200L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new bolr(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void l()
  {
    if (bowt.a())
    {
      a(bowt.b);
      bowt.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boll
 * JD-Core Version:    0.7.0.1
 */