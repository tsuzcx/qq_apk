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

public class bima
  extends biwr
  implements axgl, bims, bimt<bilz>, bimu<bilz>
{
  private int jdField_a_of_type_Int;
  private bijd jdField_a_of_type_Bijd;
  private bikl jdField_a_of_type_Bikl;
  private bilv jdField_a_of_type_Bilv;
  private biqk jdField_a_of_type_Biqk;
  private birb jdField_a_of_type_Birb;
  private biwp jdField_a_of_type_Biwp;
  private biwq jdField_a_of_type_Biwq;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  
  public bima(Activity paramActivity, View paramView, biws parambiws)
  {
    super(paramActivity, paramView, parambiws);
    this.jdField_a_of_type_Bijd = ((bijd)parambiws.a(65537, new Object[0]));
    this.jdField_a_of_type_Bikl = this.jdField_a_of_type_Bijd.a();
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
      if (i >= this.jdField_a_of_type_Bilv.getItemCount()) {
        break label57;
      }
      bire localbire = this.jdField_a_of_type_Bilv.a(i);
      if (localbire != null)
      {
        j = i;
        if (paramString.equals(localbire.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  @NonNull
  private bire a(int paramInt)
  {
    if (this.jdField_a_of_type_Bilv != null) {
      return this.jdField_a_of_type_Bilv.a(paramInt);
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Bilv.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  private void a(bire parambire)
  {
    if ((parambire != null) && (!parambire.equals(bire.jdField_a_of_type_Bire)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Bilv.getItemCount()) || (this.jdField_a_of_type_Bilv.a(i) == null)) {
        break label103;
      }
      if (!parambire.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bilv.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Bilv.a(i).a(parambire);
      a(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Bilv.a(parambire);
        a(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private boolean a(bire parambire)
  {
    if (parambire != null) {
      return parambire.a();
    }
    return false;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && ((birt.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (birt.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (birt.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bilv.a();
    bizx.a().g();
    bizt.a().C();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class));
    this.jdField_a_of_type_Biwp.a().a(this.jdField_a_of_type_Bijd, new bimi(this));
    this.jdField_a_of_type_Biwq = ((biwq)bijo.a(this.jdField_a_of_type_Bijd).a(biwq.class));
    this.jdField_a_of_type_Biwq.a().a(this.jdField_a_of_type_Bijd, new bimj(this));
  }
  
  private void k()
  {
    if (b()) {
      return;
    }
    xfc.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bimk(this)).b();
  }
  
  private void l()
  {
    QLog.d("AEWaterMarkListPart", 4, "getDateFromPtv: ");
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this));
    biqu.b().a(this.jdField_a_of_type_Bijd, new biml(this));
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
      this.jdField_a_of_type_Birb.f();
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
          Object localObject = this.jdField_a_of_type_Birb.b();
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
              bire localbire = (bire)((Iterator)localObject).next();
              if (((!localbire.jdField_a_of_type_JavaLangString.contains("_3DFaceFila")) || (FilamentInitializer.supportFilament())) && ((!localbire.jdField_a_of_type_JavaLangString.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
              {
                if (i >= 10) {
                  break;
                }
                localArrayList.add(localbire);
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
    if (this.jdField_a_of_type_Biqk != null) {
      this.jdField_a_of_type_Biqk.b();
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Biqk == null)
    {
      this.jdField_a_of_type_Biqk = new biqk(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Biqk.a(new bimm(this));
    }
    this.jdField_a_of_type_Biqk.a();
  }
  
  @TargetApi(12)
  private void p()
  {
    int i = vzl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    ((AnimatorSet)localObject).addListener(new bimc(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = bjjp.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bimd(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Biwp.a())
    {
      if (this.jdField_a_of_type_Biws != null)
      {
        this.jdField_a_of_type_Biws.a(327683, new Object[0]);
        this.jdField_a_of_type_Biws.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bijd.a().a(true, 150);
      return;
    }
    int i = vzl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bime(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bjjp.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bimf(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Biwp.a())
    {
      if (this.jdField_a_of_type_Biws != null)
      {
        this.jdField_a_of_type_Biws.a(327684, new Object[0]);
        this.jdField_a_of_type_Biws.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bijd.a().a(true, 150);
      return;
    }
    int i = vzl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bimg(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bjjp.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bimh(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void s()
  {
    int j = 0;
    bire localbire1 = birb.a();
    if (localbire1 != null)
    {
      bire localbire2 = this.jdField_a_of_type_Bilv.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localbire2 != null)
      {
        i = j;
        if (localbire1.jdField_a_of_type_JavaLangString.equals(localbire2.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Bilv.getItemCount()) {
          break;
        }
        localbire2 = this.jdField_a_of_type_Bilv.a(i);
      } while ((localbire2 == null) || (!localbire1.jdField_a_of_type_JavaLangString.equals(localbire2.jdField_a_of_type_JavaLangString)));
      a(i);
      return;
    }
    a(0);
    return;
    a(this.jdField_a_of_type_Int);
  }
  
  public birb a()
  {
    return this.jdField_a_of_type_Birb;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376590)).inflate().findViewById(2131372852));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new xfk().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Bilv = new bilv(this.jdField_a_of_type_Bijd, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Bikl);
      this.jdField_a_of_type_Bilv.a(new bimb(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bilv);
      this.jdField_a_of_type_Birb = ((birb)bjav.a().c(18));
      if (b()) {
        break label243;
      }
      this.jdField_a_of_type_Birb.a(this, 113);
      this.jdField_a_of_type_Birb.a(this, 114);
      this.jdField_a_of_type_Birb.a(this, 115);
      this.jdField_a_of_type_Birb.a(this, 112);
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
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable bilz parambilz1, @Nullable bilz parambilz2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Biwp.b()) && (!b())) {
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
      this.jdField_a_of_type_Biwq.b().a(Boolean.valueOf(false));
      this.jdField_a_of_type_Biwq.c().a(Boolean.valueOf(false));
    } while ((!this.jdField_a_of_type_Biwp.b()) || (b()));
    s();
    p();
  }
  
  public void a(@NonNull bilz parambilz, int paramInt)
  {
    parambilz.a(4);
  }
  
  public void a(@NonNull bilz parambilz, boolean paramBoolean)
  {
    if (parambilz.jdField_a_of_type_Bire.b) {
      parambilz.jdField_a_of_type_Bire.c = true;
    }
    for (;;)
    {
      if ((birb.a() != null) && (!birb.a().equals(parambilz.jdField_a_of_type_Bire)))
      {
        birb.a().b = false;
        birb.a().c = false;
      }
      return;
      parambilz.jdField_a_of_type_Bire.b = true;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = birb.a();
      if ((paramObject == null) || (paramObject.equals(bire.jdField_a_of_type_Bire)))
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
        paramObject = birb.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = true;
        }
        a(paramObject);
        return;
      }
      if (paramInt == 115)
      {
        paramObject = birb.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = false;
        }
        a(paramObject);
        return;
      }
      if ((paramInt == 112) && (paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bire)))
      {
        paramObject = (bire)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_Bilv.getItemCount())
        {
          paramVarArgs = this.jdField_a_of_type_Bilv.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
          {
            paramVarArgs.d = true;
            paramVarArgs.e = false;
            this.jdField_a_of_type_Bilv.notifyItemChanged(paramInt);
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
    if (this.jdField_a_of_type_Biqk != null) {
      this.jdField_a_of_type_Biqk.c();
    }
    if ((birb.a() != null) && (!birb.a().c()) && (this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("widgetinfo", "camera^" + birb.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(@NonNull bilz parambilz, int paramInt)
  {
    if (!"call_material_id".equals(parambilz.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      parambilz.jdField_a_of_type_Bire.b = true;
      if ((birb.a() != null) && (!birb.a().equals(parambilz.jdField_a_of_type_Bire)))
      {
        birb.a().b = false;
        birb.a().c = false;
      }
    }
    QLog.d("AEWaterMarkListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  public void c(@Nullable bilz parambilz, int paramInt)
  {
    if (parambilz != null)
    {
      parambilz.a(3);
      bips.a().a(parambilz.jdField_a_of_type_Bire);
      if (this.jdField_a_of_type_Bilv != null)
      {
        if (!a(parambilz.jdField_a_of_type_Bire)) {
          break label42;
        }
        o();
      }
    }
    return;
    label42:
    n();
    this.jdField_a_of_type_Bilv.b(parambilz.jdField_a_of_type_Bire);
  }
  
  public void d()
  {
    if (biwy.a())
    {
      a(biwy.b);
      biwy.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Birb.a(this);
    this.jdField_a_of_type_Birb.b(null, false);
    if (this.jdField_a_of_type_Bilv != null) {
      this.jdField_a_of_type_Bilv.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bima
 * JD-Core Version:    0.7.0.1
 */