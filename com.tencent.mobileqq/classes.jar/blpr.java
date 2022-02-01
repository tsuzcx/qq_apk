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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.10;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.16;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.5;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.AEPlayShowGridAdapter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class blpr
  extends bmar
  implements bbsx, blqj, blqk<blpq>, blql<blpq>
{
  protected int a;
  protected bljy a;
  protected blnv a;
  public blpm a;
  public bluy a;
  private bmap jdField_a_of_type_Bmap;
  private bmaq jdField_a_of_type_Bmaq;
  private bmca jdField_a_of_type_Bmca;
  public AEBottomListScrollView a;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private volatile boolean jdField_a_of_type_Boolean;
  
  public blpr(Activity paramActivity, View paramView, bmas parambmas)
  {
    super(paramActivity, paramView, parambmas);
    this.jdField_a_of_type_Bljy = ((bljy)parambmas.a(65537, new Object[0]));
    this.jdField_a_of_type_Blnv = this.jdField_a_of_type_Bljy.a();
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
      if (i >= this.jdField_a_of_type_Blpm.getItemCount()) {
        break label57;
      }
      blvb localblvb = this.jdField_a_of_type_Blpm.a(i);
      if (localblvb != null)
      {
        j = i;
        if (paramString.equals(localblvb.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  private blvb a(int paramInt)
  {
    if (this.jdField_a_of_type_Blpm != null) {
      return this.jdField_a_of_type_Blpm.a(paramInt);
    }
    return null;
  }
  
  private void a(blvb paramblvb)
  {
    if ((paramblvb != null) && (!paramblvb.equals(blvb.jdField_a_of_type_Blvb)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Blpm.getItemCount()) || (this.jdField_a_of_type_Blpm.a(i) == null)) {
        break label103;
      }
      if (!paramblvb.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Blpm.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Blpm.a(i).a(paramblvb);
      b(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Blpm.a(paramblvb);
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
    bmbg.a().f("-1");
    int j = a(paramString);
    if (j != -1)
    {
      this.mActivity.getIntent().putExtra("widgetinfo", "camera^" + paramString);
      paramString = a(j);
      if (paramString != null)
      {
        bmbc.a().d(paramString.jdField_a_of_type_JavaLangString);
        paramString.b = true;
        this.mActivity.getIntent().putExtra("key_camera_material_name", paramString.i);
      }
      i = j;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_Blpm.getItemCount())
      {
        b(i);
        this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getAdapter().notifyDataSetChanged();
      }
      return;
      bluy localbluy = this.jdField_a_of_type_Bluy;
      if ((this.jdField_a_of_type_Bljy != null) && (this.jdField_a_of_type_Bljy.k())) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = localbluy.a(paramString, bool);
        if (paramString == null) {
          break label195;
        }
        this.jdField_a_of_type_Blpm.a(paramString);
        bmbc.a().d(paramString.jdField_a_of_type_JavaLangString);
        paramString.b = true;
        break;
      }
      label195:
      if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) && (this.jdField_a_of_type_Bljy != null)) {
        Toast.makeText(this.jdField_a_of_type_Bljy.a(), 2131689674, 1).show();
      }
      i = 0;
    }
  }
  
  @MainThread
  private void a(String paramString1, String paramString2)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing())) {
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
      k();
      this.jdField_a_of_type_Bluy.a(this, 116);
      return;
      label67:
      if (!this.jdField_a_of_type_Boolean)
      {
        a(paramString2);
      }
      else
      {
        bmbx.b("AEBottomListPart", "take same procedure CANCELED, handleNormalEnter");
        l();
        continue;
        label96:
        l();
      }
    }
  }
  
  @WorkerThread
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Bluy.a(paramBoolean, a());
    ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, (List)localObject));
    localObject = this.jdField_a_of_type_Bluy.a(paramString2, a());
    if ((a(paramString1, paramString2)) && (localObject != null) && (!((blvb)localObject).f) && (!((blvb)localObject).e))
    {
      if (NetworkUtil.isNetworkAvailable(this.mActivity)) {
        break label131;
      }
      bmbx.b("AEBottomListPart", "loadAndHandleData---no network");
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.getUIHandler().post(new AEBottomListPart.8(this));
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEBottomListPart.10(this, paramString1, paramString2));
      return;
      label131:
      this.jdField_a_of_type_Bluy.a(this.jdField_a_of_type_Bluy.getApp(), (blvb)localObject, new blqc(this));
      bmbx.b("AEBottomListPart", "wait till takeSameMaterial download finish, BEGIN");
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        bmbx.b("AEBottomListPart", "wait till takeSameMaterial download finish, OVER");
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
  
  private void b(String paramString)
  {
    bmbx.b("AEBottomListPart", "handleTakeSameH5Enter---url=" + paramString);
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Bljy.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLDecoder.decode(paramString, "UTF-8"));
      localIntent.putExtra("loc_play_show_material_id", paramString);
      this.jdField_a_of_type_Bljy.a().startActivity(localIntent);
      this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean b()
  {
    Boolean localBoolean;
    if ((this.jdField_a_of_type_Bmaq != null) && (this.jdField_a_of_type_Bmaq.a() != null))
    {
      localBoolean = (Boolean)this.jdField_a_of_type_Bmaq.a().getValue();
      if (localBoolean == null) {}
    }
    for (boolean bool = localBoolean.booleanValue();; bool = true) {
      return (!c()) && (this.jdField_a_of_type_Bmap.b()) && (bool);
    }
  }
  
  private boolean c()
  {
    return (this.mActivity != null) && ((blvr.f(this.mActivity.getIntent())) || (blvr.h(this.mActivity.getIntent())) || (blvr.i(this.mActivity.getIntent())));
  }
  
  private void i()
  {
    if (!b()) {
      return;
    }
    zwd.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new blqa(this)).b();
  }
  
  private void j()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_Bmca == null)
      {
        this.jdField_a_of_type_Bmca = new bmca(this.mActivity);
        this.jdField_a_of_type_Bmca.a(new blqb(this));
      }
      this.jdField_a_of_type_Bmca.show();
    }
  }
  
  private void k()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.jdField_a_of_type_Bmca != null) && (this.jdField_a_of_type_Bmca.isShowing())) {
      this.jdField_a_of_type_Bmca.dismiss();
    }
  }
  
  private void l()
  {
    int i = 0;
    blvb localblvb = bluy.a();
    if (localblvb != null)
    {
      int j = a(localblvb.jdField_a_of_type_JavaLangString);
      i = j;
      if (j == -1)
      {
        this.jdField_a_of_type_Blpm.a(localblvb);
        i = 1;
      }
    }
    if (i < this.jdField_a_of_type_Blpm.getItemCount()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.scrollToPosition(i);
    }
  }
  
  private void m()
  {
    int j = 0;
    blvb localblvb1 = bluy.a();
    if (localblvb1 != null)
    {
      blvb localblvb2 = this.jdField_a_of_type_Blpm.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localblvb2 != null)
      {
        i = j;
        if (localblvb1.jdField_a_of_type_JavaLangString.equals(localblvb2.jdField_a_of_type_JavaLangString))
        {
          b(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Blpm.getItemCount()) {
          break;
        }
        localblvb2 = this.jdField_a_of_type_Blpm.a(i);
      } while ((localblvb2 == null) || (!localblvb1.jdField_a_of_type_JavaLangString.equals(localblvb2.jdField_a_of_type_JavaLangString)));
      b(i);
      return;
    }
    b(0);
    return;
    b(this.jdField_a_of_type_Int);
  }
  
  public bluy a()
  {
    return this.jdField_a_of_type_Bluy;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Blpm.a();
    bmbg.a().g();
    bmbc.a().ab();
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable blpq paramblpq1, @Nullable blpq paramblpq2) {}
  
  protected void a(int paramInt)
  {
    Animation localAnimation = bmxr.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    localAnimation.setStartOffset(0L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new blpw(this, paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void a(@NonNull blpq paramblpq, int paramInt)
  {
    paramblpq.a(4);
  }
  
  public void a(@NonNull blpq paramblpq, boolean paramBoolean)
  {
    if (paramblpq.jdField_a_of_type_Blvb.b) {
      paramblpq.jdField_a_of_type_Blvb.c = true;
    }
    for (;;)
    {
      if ((bluy.a() != null) && (!bluy.a().equals(paramblpq.jdField_a_of_type_Blvb)))
      {
        bluy.a().b = false;
        bluy.a().c = false;
      }
      return;
      paramblpq.jdField_a_of_type_Blvb.b = true;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(blvb paramblvb)
  {
    if (paramblvb != null) {
      return paramblvb.a();
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bmap = ((bmap)blks.a(this.jdField_a_of_type_Bljy).get(bmap.class));
    this.jdField_a_of_type_Bmap.a.observe(this.jdField_a_of_type_Bljy, new blpy(this));
    this.jdField_a_of_type_Bmaq = ((bmaq)blks.a(this.jdField_a_of_type_Bljy).get(bmaq.class));
    this.jdField_a_of_type_Bmaq.a().observe(this.jdField_a_of_type_Bljy, new blpz(this));
  }
  
  public void b(int paramInt)
  {
    bmbx.a("AEBottomListPart", "reset Selection pos: " + paramInt);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Blpm.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  public void b(@NonNull blpq paramblpq, int paramInt)
  {
    if (!"call_material_id".equals(paramblpq.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      paramblpq.jdField_a_of_type_Blvb.b = true;
      if ((bluy.a() != null) && (!bluy.a().equals(paramblpq.jdField_a_of_type_Blvb)))
      {
        bluy.a().b = false;
        bluy.a().c = false;
      }
    }
    QLog.d("AEBottomListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  protected void c()
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
      return;
    }
    Intent localIntent = this.mActivity.getIntent();
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
        ((bluy)bmql.a(18)).a(str1);
        blvb localblvb = this.jdField_a_of_type_Bluy.a(str1, a());
        if ((localblvb != null) && (localblvb.e))
        {
          bool = false;
          if (bool)
          {
            j();
            if (this.jdField_a_of_type_Bmca != null) {
              this.jdField_a_of_type_Bmca.a(10);
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
  
  public void c(@Nullable blpq paramblpq, int paramInt)
  {
    if (paramblpq != null)
    {
      paramblpq.a(3);
      paramblpq = paramblpq.jdField_a_of_type_Blvb;
      bltp.a().a(paramblpq);
      if (this.jdField_a_of_type_Blpm != null)
      {
        if (!a(paramblpq)) {
          break label46;
        }
        yqu.a(this.mActivity, paramblpq);
      }
    }
    return;
    label46:
    this.jdField_a_of_type_Blpm.b(paramblpq);
  }
  
  @TargetApi(12)
  protected void d()
  {
    int i = UIUtils.dip2px(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    localAnimatorSet.addListener(new blpt(this));
    localAnimatorSet.setDuration(300L).start();
    g();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Bmap.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.a(327683, new Object[0]);
        this.mPartManager.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bljy.a().a(true, 150);
      return;
    }
    int i = UIUtils.dip2px(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new blpu(this));
    localAnimatorSet.setDuration(300L).start();
    a(327683);
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_Bmap.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.a(327684, new Object[0]);
        this.mPartManager.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bljy.a().a(true, 150);
      return;
    }
    int i = UIUtils.dip2px(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new blpv(this));
    localAnimatorSet.setDuration(300L).start();
    a(327684);
  }
  
  protected void g()
  {
    Animation localAnimation = bmxr.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    localAnimation.setStartOffset(200L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new blpx(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void h()
  {
    if (AEPlayShowGridAdapter.selectedMidMaterialNotConsumed())
    {
      a(AEPlayShowGridAdapter.selectedMidMaterial);
      AEPlayShowGridAdapter.onSelectedMidMaterialConsumed();
    }
  }
  
  public void initView()
  {
    if (this.mRootView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.mRootView.findViewById(2131377877)).inflate().findViewById(2131373927));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new zwl().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Blpm = new blpm(this.jdField_a_of_type_Bljy, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Blnv);
      this.jdField_a_of_type_Blpm.a(new blps(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Blpm);
      this.jdField_a_of_type_Bluy = ((bluy)bmql.a().c(18));
      if (c()) {
        break label243;
      }
      this.jdField_a_of_type_Bluy.a(this, 113);
      this.jdField_a_of_type_Bluy.a(this, 114);
      this.jdField_a_of_type_Bluy.a(this, 115);
      this.jdField_a_of_type_Bluy.a(this, 112);
      a();
      c();
    }
    for (;;)
    {
      b();
      return;
      label243:
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      this.jdField_a_of_type_Blpm.b();
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = bluy.a();
      if ((paramObject == null) || (paramObject.equals(blvb.jdField_a_of_type_Blvb)))
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
          paramObject = bluy.a();
          if (paramObject != null) {
            paramObject.jdField_a_of_type_Boolean = true;
          }
          a(paramObject);
          return;
        }
        if (paramInt == 115)
        {
          paramObject = bluy.a();
          if (paramObject != null) {
            paramObject.jdField_a_of_type_Boolean = false;
          }
          a(paramObject);
          return;
        }
        if (paramInt != 112) {
          break label195;
        }
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof blvb)))
        {
          paramObject = (blvb)paramVarArgs[0];
          paramInt = 0;
          while (paramInt < this.jdField_a_of_type_Blpm.getItemCount())
          {
            paramVarArgs = this.jdField_a_of_type_Blpm.a(paramInt);
            if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
            {
              paramVarArgs.e = true;
              paramVarArgs.f = false;
              this.jdField_a_of_type_Blpm.notifyItemChanged(paramInt);
              return;
            }
            paramInt += 1;
          }
        }
      }
    } while (paramInt != 116);
    bmbx.b("AEBottomListPart", "notify---TEMPLATE_INFO_LIST_UPDATE");
    ThreadManager.getUIHandler().post(new AEBottomListPart.16(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (b()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
    }
  }
  
  public void onActivityResume()
  {
    if ((bluy.a() != null) && (!bluy.a().c()) && (this.mActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.mActivity.getIntent().putExtra("widgetinfo", "camera^" + bluy.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bluy.a(this);
    this.jdField_a_of_type_Bluy.f();
    if (this.jdField_a_of_type_Blpm != null) {
      this.jdField_a_of_type_Blpm.c();
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      e();
      return;
      f();
      return;
      this.jdField_a_of_type_Bmaq.b().postValue(Boolean.valueOf(false));
      this.jdField_a_of_type_Bmaq.c().postValue(Boolean.valueOf(false));
    } while ((!this.jdField_a_of_type_Bmap.b()) || (c()));
    m();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpr
 * JD-Core Version:    0.7.0.1
 */