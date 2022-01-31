import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.5;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bilj
  extends biwa
  implements axgj, bimb, bimc<bili>, bimd<bili>
{
  private int jdField_a_of_type_Int;
  private biim jdField_a_of_type_Biim;
  private biju jdField_a_of_type_Biju;
  private bile jdField_a_of_type_Bile;
  private bipt jdField_a_of_type_Bipt;
  private biqk jdField_a_of_type_Biqk;
  private bivy jdField_a_of_type_Bivy;
  private bivz jdField_a_of_type_Bivz;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  
  public bilj(Activity paramActivity, View paramView, biwb parambiwb)
  {
    super(paramActivity, paramView, parambiwb);
    this.jdField_a_of_type_Biim = ((biim)parambiwb.a(65537, new Object[0]));
    this.jdField_a_of_type_Biju = this.jdField_a_of_type_Biim.a();
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
      if (i >= this.jdField_a_of_type_Bile.getItemCount()) {
        break label57;
      }
      biqn localbiqn = this.jdField_a_of_type_Bile.a(i);
      if (localbiqn != null)
      {
        j = i;
        if (paramString.equals(localbiqn.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  @NonNull
  private biqn a(int paramInt)
  {
    if (this.jdField_a_of_type_Bile != null) {
      return this.jdField_a_of_type_Bile.a(paramInt);
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Bile.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  private void a(biqn parambiqn)
  {
    if ((parambiqn != null) && (!parambiqn.equals(biqn.jdField_a_of_type_Biqn)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Bile.getItemCount()) || (this.jdField_a_of_type_Bile.a(i) == null)) {
        break label103;
      }
      if (!parambiqn.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bile.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Bile.a(i).a(parambiqn);
      a(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Bile.a(parambiqn);
        a(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private boolean a(biqn parambiqn)
  {
    if (parambiqn != null) {
      return parambiqn.a();
    }
    return false;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && ((birc.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (birc.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (birc.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bile.a();
    bizg.a().g();
    bizc.a().C();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bivy = ((bivy)biix.a(this.jdField_a_of_type_Biim).a(bivy.class));
    this.jdField_a_of_type_Bivy.a().a(this.jdField_a_of_type_Biim, new bilr(this));
    this.jdField_a_of_type_Bivz = ((bivz)biix.a(this.jdField_a_of_type_Biim).a(bivz.class));
    this.jdField_a_of_type_Bivz.a().a(this.jdField_a_of_type_Biim, new bils(this));
  }
  
  private void k()
  {
    if (b()) {
      return;
    }
    xff.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bilt(this)).b();
  }
  
  private void l()
  {
    QLog.d("AEWaterMarkListPart", 4, "getDateFromPtv: ");
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this));
    biqd.b().a(this.jdField_a_of_type_Biim, new bilu(this));
  }
  
  private void m()
  {
    long l3 = 0L;
    long l1;
    if (QLog.isDevelopLevel())
    {
      l1 = System.currentTimeMillis();
      QLog.d("AEWaterMarkListPart", 4, "dataNotify begin");
    }
    for (;;)
    {
      this.jdField_a_of_type_Biqk.f();
      long l2;
      if (QLog.isDevelopLevel())
      {
        l2 = System.currentTimeMillis();
        QLog.d("AEWaterMarkListPart", 4, "dataNotify forceInit done cost=" + (l2 - l1));
      }
      for (;;)
      {
        long l4;
        if (QLog.isDevelopLevel())
        {
          l4 = System.currentTimeMillis();
          QLog.d("AEWaterMarkListPart", 4, "dataNotify getTemplateInfos done cost=" + (l4 - l2));
        }
        for (l2 = l4;; l2 = 0L)
        {
          Object localObject = this.jdField_a_of_type_Biqk.b();
          if (QLog.isDevelopLevel())
          {
            l4 = System.currentTimeMillis();
            QLog.d("AEWaterMarkListPart", 4, "found hot category cost=" + (l4 - l2));
          }
          for (l2 = l4;; l2 = 0L)
          {
            if (((List)localObject).isEmpty())
            {
              ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, l1));
              return;
            }
            ArrayList localArrayList = new ArrayList();
            localObject = ((List)localObject).iterator();
            int i = 0;
            while (((Iterator)localObject).hasNext())
            {
              biqn localbiqn = (biqn)((Iterator)localObject).next();
              if (((!localbiqn.jdField_a_of_type_JavaLangString.contains("_3DFaceFila")) || (FilamentInitializer.supportFilament())) && ((!localbiqn.jdField_a_of_type_JavaLangString.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
              {
                if (i >= 10) {
                  break;
                }
                localArrayList.add(localbiqn);
                i += 1;
              }
            }
            l1 = l3;
            if (QLog.isDevelopLevel())
            {
              l1 = System.currentTimeMillis();
              QLog.d("AEWaterMarkListPart", 4, "filterFilament cost=" + (l1 - l2));
            }
            ThreadManager.getUIHandler().post(new AEBottomListPart.8(this, localArrayList, l1));
            return;
          }
        }
        l2 = 0L;
      }
      l1 = 0L;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Bipt != null) {
      this.jdField_a_of_type_Bipt.b();
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Bipt == null)
    {
      this.jdField_a_of_type_Bipt = new bipt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Bipt.a(new bilv(this));
    }
    this.jdField_a_of_type_Bipt.a();
  }
  
  @TargetApi(12)
  private void p()
  {
    int i = vzo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    ((AnimatorSet)localObject).addListener(new bill(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = bjiy.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bilm(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Bivy.a())
    {
      if (this.jdField_a_of_type_Biwb != null)
      {
        this.jdField_a_of_type_Biwb.a(327683, new Object[0]);
        this.jdField_a_of_type_Biwb.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Biim.a().a(true, 150);
      return;
    }
    int i = vzo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new biln(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bjiy.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bilo(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Bivy.a())
    {
      if (this.jdField_a_of_type_Biwb != null)
      {
        this.jdField_a_of_type_Biwb.a(327684, new Object[0]);
        this.jdField_a_of_type_Biwb.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Biim.a().a(true, 150);
      return;
    }
    int i = vzo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bilp(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bjiy.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bilq(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void s()
  {
    int j = 0;
    biqn localbiqn1 = biqk.a();
    if (localbiqn1 != null)
    {
      biqn localbiqn2 = this.jdField_a_of_type_Bile.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localbiqn2 != null)
      {
        i = j;
        if (localbiqn1.jdField_a_of_type_JavaLangString.equals(localbiqn2.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Bile.getItemCount()) {
          break;
        }
        localbiqn2 = this.jdField_a_of_type_Bile.a(i);
      } while ((localbiqn2 == null) || (!localbiqn1.jdField_a_of_type_JavaLangString.equals(localbiqn2.jdField_a_of_type_JavaLangString)));
      a(i);
      return;
    }
    a(0);
    return;
    a(this.jdField_a_of_type_Int);
  }
  
  public biqk a()
  {
    return this.jdField_a_of_type_Biqk;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376588)).inflate().findViewById(2131372850));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new xfn().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Bile = new bile(this.jdField_a_of_type_Biim, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Biju);
      this.jdField_a_of_type_Bile.a(new bilk(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bile);
      this.jdField_a_of_type_Biqk = ((biqk)bjae.a().c(18));
      if (b()) {
        break label243;
      }
      this.jdField_a_of_type_Biqk.a(this, 113);
      this.jdField_a_of_type_Biqk.a(this, 114);
      this.jdField_a_of_type_Biqk.a(this, 115);
      this.jdField_a_of_type_Biqk.a(this, 112);
      e();
      l();
    }
    for (;;)
    {
      f();
      return;
      label243:
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable bili parambili1, @Nullable bili parambili2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Bivy.b()) && (!b())) {
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
      q();
      return;
      r();
      return;
      this.jdField_a_of_type_Bivz.b().a(Boolean.valueOf(false));
      this.jdField_a_of_type_Bivz.c().a(Boolean.valueOf(false));
    } while ((!this.jdField_a_of_type_Bivy.b()) || (b()));
    s();
    p();
  }
  
  public void a(@NonNull bili parambili, int paramInt)
  {
    parambili.a(4);
  }
  
  public void a(@NonNull bili parambili, boolean paramBoolean)
  {
    if (parambili.jdField_a_of_type_Biqn.b) {
      parambili.jdField_a_of_type_Biqn.c = true;
    }
    for (;;)
    {
      if ((biqk.a() != null) && (!biqk.a().equals(parambili.jdField_a_of_type_Biqn)))
      {
        biqk.a().b = false;
        biqk.a().c = false;
      }
      return;
      parambili.jdField_a_of_type_Biqn.b = true;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = biqk.a();
      if ((paramObject == null) || (paramObject.equals(biqn.jdField_a_of_type_Biqn)))
      {
        a(0);
        QLog.d("AEWaterMarkListPart", 4, "current pendant has change");
      }
    }
    for (;;)
    {
      return;
      a(paramObject);
      break;
      if (paramInt == 114)
      {
        paramObject = biqk.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = true;
        }
        a(paramObject);
        return;
      }
      if (paramInt == 115)
      {
        paramObject = biqk.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = false;
        }
        a(paramObject);
        return;
      }
      if ((paramInt == 112) && (paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof biqn)))
      {
        paramObject = (biqn)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_Bile.getItemCount())
        {
          paramVarArgs = this.jdField_a_of_type_Bile.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
          {
            paramVarArgs.d = true;
            paramVarArgs.e = false;
            this.jdField_a_of_type_Bile.notifyItemChanged(paramInt);
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bipt != null) {
      this.jdField_a_of_type_Bipt.c();
    }
    if ((biqk.a() != null) && (!biqk.a().c()) && (this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("widgetinfo", "camera^" + biqk.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(@NonNull bili parambili, int paramInt)
  {
    if (!"call_material_id".equals(parambili.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      parambili.jdField_a_of_type_Biqn.b = true;
      if ((biqk.a() != null) && (!biqk.a().equals(parambili.jdField_a_of_type_Biqn)))
      {
        biqk.a().b = false;
        biqk.a().c = false;
      }
    }
    QLog.d("AEWaterMarkListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  public void c(@Nullable bili parambili, int paramInt)
  {
    if (parambili != null)
    {
      parambili.a(3);
      bipb.a().a(parambili.jdField_a_of_type_Biqn);
      if (this.jdField_a_of_type_Bile != null)
      {
        if (!a(parambili.jdField_a_of_type_Biqn)) {
          break label42;
        }
        o();
      }
    }
    return;
    label42:
    n();
    this.jdField_a_of_type_Bile.b(parambili.jdField_a_of_type_Biqn);
  }
  
  public void d()
  {
    if (biwh.a())
    {
      a(biwh.b);
      biwh.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Biqk.a(this);
    this.jdField_a_of_type_Biqk.b(null, false);
    if (this.jdField_a_of_type_Bile != null) {
      this.jdField_a_of_type_Bile.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilj
 * JD-Core Version:    0.7.0.1
 */