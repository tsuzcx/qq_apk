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
import android.text.TextUtils;
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
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.15;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.16;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.5;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.AEPlayShowGridAdapter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class bnda
  extends bnqb
  implements bczs, bnds, bndt<bncz>, bndu<bncz>
{
  protected int a;
  protected bmxa a;
  public bnbg a;
  public bncv a;
  public bnkb a;
  private bnpz jdField_a_of_type_Bnpz;
  private bnqa jdField_a_of_type_Bnqa;
  private bnrr jdField_a_of_type_Bnrr;
  public AEBottomListScrollView a;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private volatile boolean jdField_a_of_type_Boolean;
  
  public bnda(Activity paramActivity, View paramView, bnqc parambnqc)
  {
    super(paramActivity, paramView, parambnqc);
    this.jdField_a_of_type_Bmxa = ((bmxa)parambnqc.a(65537, new Object[0]));
    this.jdField_a_of_type_Bnbg = this.jdField_a_of_type_Bmxa.a();
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
      if (i >= this.jdField_a_of_type_Bncv.getItemCount()) {
        break label57;
      }
      bnke localbnke = this.jdField_a_of_type_Bncv.a(i);
      if (localbnke != null)
      {
        j = i;
        if (paramString.equals(localbnke.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  private bnke a(int paramInt)
  {
    if (this.jdField_a_of_type_Bncv != null) {
      return this.jdField_a_of_type_Bncv.a(paramInt);
    }
    return null;
  }
  
  private bnke a(String paramString, List<bnka> paramList)
  {
    bnke localbnke;
    do
    {
      do
      {
        paramList = paramList.iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject = (bnka)paramList.next();
          } while ((localObject == null) || (((bnka)localObject).a == null));
          localObject = ((bnka)localObject).a.iterator();
        }
        localbnke = (bnke)((Iterator)localObject).next();
      } while (localbnke == null);
      if (TextUtils.isEmpty(paramString)) {
        return localbnke;
      }
    } while (!paramString.equals(localbnke.jdField_a_of_type_JavaLangString));
    return localbnke;
    return null;
  }
  
  private void a(bnke parambnke)
  {
    if ((parambnke != null) && (!parambnke.equals(bnke.jdField_a_of_type_Bnke)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Bncv.getItemCount()) || (this.jdField_a_of_type_Bncv.a(i) == null)) {
        break label103;
      }
      if (!parambnke.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bncv.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Bncv.a(i).a(parambnke);
      c(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Bncv.a(parambnke);
        c(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private void a(String paramString)
  {
    int i = 1;
    bnqq.a().f("-1");
    int j = a(paramString);
    if (j != -1)
    {
      this.mActivity.getIntent().putExtra("widgetinfo", "camera^" + paramString);
      paramString = a(j);
      if (paramString != null)
      {
        bnqm.a().d(paramString.jdField_a_of_type_JavaLangString);
        paramString.b = true;
        this.mActivity.getIntent().putExtra("key_camera_material_name", paramString.i);
      }
      i = j;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_Bncv.getItemCount())
      {
        c(i);
        this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getAdapter().notifyDataSetChanged();
      }
      return;
      bnkb localbnkb = this.jdField_a_of_type_Bnkb;
      if ((this.jdField_a_of_type_Bmxa != null) && (this.jdField_a_of_type_Bmxa.k())) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = localbnkb.a(paramString, bool);
        if (paramString == null) {
          break label195;
        }
        this.jdField_a_of_type_Bncv.a(paramString);
        bnqm.a().d(paramString.jdField_a_of_type_JavaLangString);
        paramString.b = true;
        break;
      }
      label195:
      if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) && (this.jdField_a_of_type_Bmxa != null)) {
        Toast.makeText(this.jdField_a_of_type_Bmxa.a(), 2131689682, 1).show();
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
          break label99;
        }
        if (!paramString2.startsWith("http")) {
          break label68;
        }
        b(paramString2);
      }
    }
    for (;;)
    {
      l();
      this.jdField_a_of_type_Bnkb.a(this, 116);
      return;
      label68:
      if (!this.jdField_a_of_type_Boolean)
      {
        a(paramString2);
      }
      else
      {
        bnrh.b("AEBottomListPart", "take same procedure CANCELED, handleNormalEnter");
        m();
        continue;
        label99:
        m();
      }
    }
  }
  
  @WorkerThread
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Bnkb.a(paramBoolean, a());
    ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, (List)localObject));
    localObject = this.jdField_a_of_type_Bnkb.a(paramString2, a());
    if ((a(paramString1, paramString2)) && (localObject != null) && (!((bnke)localObject).f) && (!((bnke)localObject).e))
    {
      if (NetworkUtil.isNetworkAvailable(this.mActivity)) {
        break label132;
      }
      bnrh.b("AEBottomListPart", "loadAndHandleData---no network");
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.getUIHandler().post(new AEBottomListPart.8(this));
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEBottomListPart.10(this, paramString1, paramString2));
      return;
      label132:
      this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_Bnkb.getApp(), (bnke)localObject, new bndl(this));
      bnrh.b("AEBottomListPart", "wait till takeSameMaterial download finish, BEGIN");
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        bnrh.b("AEBottomListPart", "wait till takeSameMaterial download finish, OVER");
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
    bnrh.b("AEBottomListPart", "handleTakeSameH5Enter---url=" + paramString);
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Bmxa.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLDecoder.decode(paramString, "UTF-8"));
      localIntent.putExtra("loc_play_show_material_id", paramString);
      this.jdField_a_of_type_Bmxa.a().startActivity(localIntent);
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
    if ((this.jdField_a_of_type_Bnqa != null) && (this.jdField_a_of_type_Bnqa.a() != null))
    {
      localBoolean = (Boolean)this.jdField_a_of_type_Bnqa.a().getValue();
      if (localBoolean == null) {}
    }
    for (boolean bool = localBoolean.booleanValue();; bool = true) {
      return (!c()) && (this.jdField_a_of_type_Bnpz.b()) && (bool);
    }
  }
  
  private boolean c()
  {
    return (this.mActivity != null) && ((bnlb.f(this.mActivity.getIntent())) || (bnlb.h(this.mActivity.getIntent())) || (bnlb.i(this.mActivity.getIntent())));
  }
  
  private void j()
  {
    if (!b()) {
      return;
    }
    aalp.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bndj(this)).b();
  }
  
  private void k()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_Bnrr == null)
      {
        this.jdField_a_of_type_Bnrr = new bnrr(this.mActivity);
        this.jdField_a_of_type_Bnrr.a(new bndk(this));
      }
      this.jdField_a_of_type_Bnrr.show();
    }
  }
  
  private void l()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.jdField_a_of_type_Bnrr != null) && (this.jdField_a_of_type_Bnrr.isShowing())) {
      this.jdField_a_of_type_Bnrr.dismiss();
    }
  }
  
  private void m()
  {
    int i = 0;
    bnke localbnke = bnkb.a();
    if (localbnke != null)
    {
      int j = a(localbnke.jdField_a_of_type_JavaLangString);
      i = j;
      if (j == -1)
      {
        this.jdField_a_of_type_Bncv.a(localbnke);
        i = 1;
      }
    }
    if (i < this.jdField_a_of_type_Bncv.getItemCount()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.scrollToPosition(i);
    }
  }
  
  private void n()
  {
    if ((bnkb.a() != null) && (bnkb.a().jdField_a_of_type_Boolean)) {
      bnkb.a().b = true;
    }
  }
  
  private void o()
  {
    int j = 0;
    bnke localbnke1 = bnkb.a();
    if (localbnke1 != null)
    {
      bnke localbnke2 = this.jdField_a_of_type_Bncv.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localbnke2 != null)
      {
        i = j;
        if (localbnke1.jdField_a_of_type_JavaLangString.equals(localbnke2.jdField_a_of_type_JavaLangString))
        {
          c(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Bncv.getItemCount()) {
          break;
        }
        localbnke2 = this.jdField_a_of_type_Bncv.a(i);
      } while ((localbnke2 == null) || (!localbnke1.jdField_a_of_type_JavaLangString.equals(localbnke2.jdField_a_of_type_JavaLangString)));
      c(i);
      return;
    }
    c(0);
    return;
    c(this.jdField_a_of_type_Int);
  }
  
  private void p()
  {
    String str = bnqu.a().a("sp_key_ae_user_selected_watermark", "", 0);
    if (!"sp_val_ae_user_selected_watermark_none".equals(str))
    {
      bnrh.b("AEBottomListPart", "recoverLastWatermark---materialId=" + str);
      bnqm.a().au();
      ThreadManager.excute(new AEBottomListPart.16(this, str), 64, null, true);
    }
  }
  
  public bnkb a()
  {
    return this.jdField_a_of_type_Bnkb;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bncv.a();
    bnqq.a().g();
    bnqm.a().ab();
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable bncz parambncz1, @Nullable bncz parambncz2) {}
  
  protected void a(int paramInt)
  {
    int i = UIUtils.dip2px(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bndd(this));
    localAnimatorSet.setDuration(300L).start();
    b(paramInt);
  }
  
  public void a(@NonNull bncz parambncz, int paramInt)
  {
    parambncz.a(4);
    if ((!"call_material_id".equals(parambncz.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Bncv.a()) && (parambncz.jdField_a_of_type_Bnke.jdField_a_of_type_Boolean))
    {
      parambncz.jdField_a_of_type_Bnke.b = false;
      parambncz.jdField_a_of_type_Bnke.c = false;
    }
    this.jdField_a_of_type_Bncv.a(false);
  }
  
  public void a(@NonNull bncz parambncz, boolean paramBoolean)
  {
    if (parambncz.jdField_a_of_type_Bnke.b) {
      parambncz.jdField_a_of_type_Bnke.c = true;
    }
    for (;;)
    {
      if ((!"call_material_id".equals(parambncz.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) && (bnkb.a() != null) && (!bnkb.a().equals(parambncz.jdField_a_of_type_Bnke)))
      {
        bnkb.a().b = false;
        bnkb.a().c = false;
      }
      return;
      parambncz.jdField_a_of_type_Bnke.b = true;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(bnke parambnke)
  {
    if (parambnke != null) {
      return parambnke.a();
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bnpz = ((bnpz)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnpz.class));
    this.jdField_a_of_type_Bnpz.a.observe(this.jdField_a_of_type_Bmxa, new bndh(this));
    this.jdField_a_of_type_Bnqa = ((bnqa)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnqa.class));
    this.jdField_a_of_type_Bnqa.a().observe(this.jdField_a_of_type_Bmxa, new bndi(this));
  }
  
  protected void b(int paramInt)
  {
    Animation localAnimation = bonj.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    localAnimation.setStartOffset(0L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new bnde(this, paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void b(@NonNull bncz parambncz, int paramInt)
  {
    if (!"call_material_id".equals(parambncz.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      parambncz.jdField_a_of_type_Bnke.b = true;
      if ((bnkb.a() != null) && (!bnkb.a().equals(parambncz.jdField_a_of_type_Bnke)))
      {
        bnkb.a().b = false;
        bnkb.a().c = false;
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
        ((bnkb)bogd.a(18)).a(str1);
        bnke localbnke = this.jdField_a_of_type_Bnkb.a(str1, a());
        if ((localbnke != null) && (localbnke.e))
        {
          bool = false;
          if (bool)
          {
            k();
            if (this.jdField_a_of_type_Bnrr != null) {
              this.jdField_a_of_type_Bnrr.a(10);
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
  
  public void c(int paramInt)
  {
    bnrh.a("AEBottomListPart", "reset Selection pos: " + paramInt);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Bncv.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  public void c(@Nullable bncz parambncz, int paramInt)
  {
    if (parambncz != null)
    {
      parambncz.a(3);
      parambncz = parambncz.jdField_a_of_type_Bnke;
      bnhs.a().a(parambncz);
      if (this.jdField_a_of_type_Bncv != null)
      {
        if (!a(parambncz)) {
          break label46;
        }
        zfn.a(this.mActivity, parambncz);
      }
    }
    return;
    label46:
    this.jdField_a_of_type_Bncv.b(parambncz);
  }
  
  @TargetApi(12)
  protected void d()
  {
    int i = UIUtils.dip2px(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    localAnimatorSet.addListener(new bndc(this));
    localAnimatorSet.setDuration(300L).start();
    h();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Bnpz.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.a(327683, new Object[0]);
        this.mPartManager.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bmxa.a().a(true, 150);
      return;
    }
    a(327683);
  }
  
  protected void f() {}
  
  protected void g()
  {
    if (this.jdField_a_of_type_Bnpz.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.a(327684, new Object[0]);
        this.mPartManager.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bmxa.a().a(true, 150);
      return;
    }
    a(327684);
  }
  
  protected void h()
  {
    Animation localAnimation = bonj.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    localAnimation.setStartOffset(200L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new bndf(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void i()
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
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.mRootView.findViewById(2131378163)).inflate().findViewById(2131374156));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new aalx().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Bncv = new bncv(this.jdField_a_of_type_Bmxa, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Bnbg);
      this.jdField_a_of_type_Bncv.a(new bndb(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bncv);
      this.jdField_a_of_type_Bnkb = ((bnkb)bogd.a().c(18));
      if (c()) {
        break label243;
      }
      this.jdField_a_of_type_Bnkb.a(this, 113);
      this.jdField_a_of_type_Bnkb.a(this, 114);
      this.jdField_a_of_type_Bnkb.a(this, 115);
      this.jdField_a_of_type_Bnkb.a(this, 112);
      a();
      c();
    }
    for (;;)
    {
      b();
      return;
      label243:
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      this.jdField_a_of_type_Bncv.b();
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    bnrh.a("AEBottomListPart", "AEBottomListPart notify---eventId=" + paramInt);
    if (paramInt == 113)
    {
      paramObject = bnkb.a();
      if ((paramObject == null) || (paramObject.equals(bnke.jdField_a_of_type_Bnke)))
      {
        c(0);
        if (a()) {
          p();
        }
        QLog.d("AEBottomListPart", 4, "current pendant has change");
      }
    }
    label266:
    do
    {
      for (;;)
      {
        return;
        a(paramObject);
        break;
        if (paramInt == 1024)
        {
          QLog.d("AEBottomListPart", 4, "current watermark has change");
          c(0);
          return;
        }
        if (paramInt == 114)
        {
          paramObject = bnkb.a();
          if ((paramObject != null) && (!paramObject.equals(bnke.jdField_a_of_type_Bnke))) {
            paramObject.jdField_a_of_type_Boolean = true;
          }
          a(paramObject);
          return;
        }
        if (paramInt == 115)
        {
          paramObject = bnkb.a();
          if (paramObject != null) {
            paramObject.jdField_a_of_type_Boolean = false;
          }
          a(paramObject);
          return;
        }
        if (paramInt != 112) {
          break label266;
        }
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bnke)))
        {
          paramObject = (bnke)paramVarArgs[0];
          paramInt = 0;
          while (paramInt < this.jdField_a_of_type_Bncv.getItemCount())
          {
            paramVarArgs = this.jdField_a_of_type_Bncv.a(paramInt);
            if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
            {
              paramVarArgs.e = true;
              paramVarArgs.f = false;
              this.jdField_a_of_type_Bncv.notifyItemChanged(paramInt);
              return;
            }
            paramInt += 1;
          }
        }
      }
    } while (paramInt != 116);
    bnrh.b("AEBottomListPart", "notify---TEMPLATE_INFO_LIST_UPDATE");
    ThreadManager.getUIHandler().post(new AEBottomListPart.15(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (b()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
    }
  }
  
  public void onActivityResume()
  {
    if ((bnkb.a() != null) && (!bnkb.a().c()) && (this.mActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.mActivity.getIntent().putExtra("widgetinfo", "camera^" + bnkb.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bnkb.a(this);
    this.jdField_a_of_type_Bnkb.f();
    if (this.jdField_a_of_type_Bncv != null) {
      this.jdField_a_of_type_Bncv.c();
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 131076: 
    case 131077: 
    case 131075: 
      do
      {
        return;
        e();
        return;
        g();
        return;
        this.jdField_a_of_type_Bnqa.b().postValue(Boolean.valueOf(false));
        this.jdField_a_of_type_Bnqa.d().postValue(Boolean.valueOf(false));
        this.jdField_a_of_type_Bnqa.c().postValue(Boolean.valueOf(false));
        n();
      } while ((!this.jdField_a_of_type_Bnpz.b()) || (c()));
      o();
      d();
      return;
    }
    this.jdField_a_of_type_Bnqa.d().postValue(Boolean.valueOf(true));
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnda
 * JD-Core Version:    0.7.0.1
 */