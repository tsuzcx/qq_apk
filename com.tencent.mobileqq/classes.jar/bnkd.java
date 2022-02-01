import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
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
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.5;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bnkd
  extends bnva
  implements bcha, bnku, bnkv<bnkc>, bnkw<bnkc>
{
  private int jdField_a_of_type_Int;
  private bndy jdField_a_of_type_Bndy;
  private bnii jdField_a_of_type_Bnii;
  private bnjw jdField_a_of_type_Bnjw;
  private bnpc jdField_a_of_type_Bnpc;
  private bnuy jdField_a_of_type_Bnuy;
  private bnuz jdField_a_of_type_Bnuz;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  
  public bnkd(Activity paramActivity, View paramView, bnvb parambnvb)
  {
    super(paramActivity, paramView, parambnvb);
    this.jdField_a_of_type_Bndy = ((bndy)parambnvb.a(65537, new Object[0]));
    this.jdField_a_of_type_Bnii = this.jdField_a_of_type_Bndy.a();
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
      if (i >= this.jdField_a_of_type_Bnjw.getItemCount()) {
        break label57;
      }
      bnpf localbnpf = this.jdField_a_of_type_Bnjw.a(i);
      if (localbnpf != null)
      {
        j = i;
        if (paramString.equals(localbnpf.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  private bnpf a(int paramInt)
  {
    if (this.jdField_a_of_type_Bnjw != null) {
      return this.jdField_a_of_type_Bnjw.a(paramInt);
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Bnjw.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  private void a(bnpf parambnpf)
  {
    if ((parambnpf != null) && (!parambnpf.equals(bnpf.jdField_a_of_type_Bnpf)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Bnjw.getItemCount()) || (this.jdField_a_of_type_Bnjw.a(i) == null)) {
        break label103;
      }
      if (!parambnpf.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bnjw.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Bnjw.a(i).a(parambnpf);
      a(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Bnjw.a(parambnpf);
        a(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private boolean a(bnpf parambnpf)
  {
    if (parambnpf != null) {
      return parambnpf.a();
    }
    return false;
  }
  
  private boolean b()
  {
    Boolean localBoolean;
    if ((this.jdField_a_of_type_Bnuz != null) && (this.jdField_a_of_type_Bnuz.a() != null))
    {
      localBoolean = (Boolean)this.jdField_a_of_type_Bnuz.a().getValue();
      if (localBoolean == null) {}
    }
    for (boolean bool = localBoolean.booleanValue();; bool = true) {
      return (!c()) && (this.jdField_a_of_type_Bnuy.b()) && (bool);
    }
  }
  
  private boolean c()
  {
    return ((this.jdField_a_of_type_AndroidAppActivity != null) && ((bnqb.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bnqb.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bnqb.i(this.jdField_a_of_type_AndroidAppActivity.getIntent())))) || (bnqb.j(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bnjw.a();
    bnyl.a().g();
    bnyh.a().V();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bnuy = ((bnuy)bner.a(this.jdField_a_of_type_Bndy).get(bnuy.class));
    this.jdField_a_of_type_Bnuy.a.observe(this.jdField_a_of_type_Bndy, new bnkk(this));
    this.jdField_a_of_type_Bnuz = ((bnuz)bner.a(this.jdField_a_of_type_Bndy).get(bnuz.class));
    this.jdField_a_of_type_Bnuz.a().observe(this.jdField_a_of_type_Bndy, new bnkl(this));
  }
  
  private void k()
  {
    if (!b()) {
      return;
    }
    aavn.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bnkm(this)).b();
  }
  
  private void l()
  {
    QLog.d("AEWaterMarkListPart", 4, "getDateFromPtv: ");
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this));
    bnov.b().observe(this.jdField_a_of_type_Bndy, new bnkn(this));
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
      this.jdField_a_of_type_Bnpc.f();
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
          Object localObject = this.jdField_a_of_type_Bnpc.c();
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
              bnpf localbnpf = (bnpf)((Iterator)localObject).next();
              if (localbnpf.jdField_a_of_type_JavaLangString.contains("_3DFaceFila"))
              {
                Ace3DEngineInitializer localAce3DEngineInitializer = FeatureManager.Features.ACE_3D_ENGINE;
                if (!Ace3DEngineInitializer.supportAceEngine()) {}
              }
              else if ((!localbnpf.jdField_a_of_type_JavaLangString.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))
              {
                if (i >= 10) {
                  break;
                }
                localArrayList.add(localbnpf);
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
  
  @TargetApi(12)
  private void n()
  {
    int i = zlx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    ((AnimatorSet)localObject).addListener(new bnko(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = bosq.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bnkf(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Bnuy.a())
    {
      if (this.jdField_a_of_type_Bnvb != null)
      {
        this.jdField_a_of_type_Bnvb.a(327683, new Object[0]);
        this.jdField_a_of_type_Bnvb.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bndy.a().a(true, 150);
      return;
    }
    int i = zlx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bnkg(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bosq.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bnkh(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Bnuy.a())
    {
      if (this.jdField_a_of_type_Bnvb != null)
      {
        this.jdField_a_of_type_Bnvb.a(327684, new Object[0]);
        this.jdField_a_of_type_Bnvb.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bndy.a().a(true, 150);
      return;
    }
    int i = zlx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bnki(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bosq.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bnkj(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void q()
  {
    int j = 0;
    bnpf localbnpf1 = bnpc.a();
    if (localbnpf1 != null)
    {
      bnpf localbnpf2 = this.jdField_a_of_type_Bnjw.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localbnpf2 != null)
      {
        i = j;
        if (localbnpf1.jdField_a_of_type_JavaLangString.equals(localbnpf2.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Bnjw.getItemCount()) {
          break;
        }
        localbnpf2 = this.jdField_a_of_type_Bnjw.a(i);
      } while ((localbnpf2 == null) || (!localbnpf1.jdField_a_of_type_JavaLangString.equals(localbnpf2.jdField_a_of_type_JavaLangString)));
      a(i);
      return;
    }
    a(0);
    return;
    a(this.jdField_a_of_type_Int);
  }
  
  public bnpc a()
  {
    return this.jdField_a_of_type_Bnpc;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377951)).inflate().findViewById(2131374042));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new aavv().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Bnjw = new bnjw(this.jdField_a_of_type_Bndy, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Bnii);
      this.jdField_a_of_type_Bnjw.a(new bnke(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bnjw);
      this.jdField_a_of_type_Bnpc = ((bnpc)bojv.a().c(18));
      if (c()) {
        break label243;
      }
      this.jdField_a_of_type_Bnpc.a(this, 113);
      this.jdField_a_of_type_Bnpc.a(this, 114);
      this.jdField_a_of_type_Bnpc.a(this, 115);
      this.jdField_a_of_type_Bnpc.a(this, 112);
      e();
      l();
    }
    for (;;)
    {
      f();
      return;
      label243:
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      this.jdField_a_of_type_Bnjw.b();
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable bnkc parambnkc1, @Nullable bnkc parambnkc2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (b()) {
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
      o();
      return;
      p();
      return;
      this.jdField_a_of_type_Bnuz.b().postValue(Boolean.valueOf(false));
      this.jdField_a_of_type_Bnuz.c().postValue(Boolean.valueOf(false));
    } while ((!this.jdField_a_of_type_Bnuy.b()) || (c()));
    q();
    n();
  }
  
  public void a(@NonNull bnkc parambnkc, int paramInt)
  {
    parambnkc.a(4);
  }
  
  public void a(@NonNull bnkc parambnkc, boolean paramBoolean)
  {
    if (parambnkc.jdField_a_of_type_Bnpf.b) {
      parambnkc.jdField_a_of_type_Bnpf.c = true;
    }
    for (;;)
    {
      if ((bnpc.a() != null) && (!bnpc.a().equals(parambnkc.jdField_a_of_type_Bnpf)))
      {
        bnpc.a().b = false;
        bnpc.a().c = false;
      }
      return;
      parambnkc.jdField_a_of_type_Bnpf.b = true;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = bnpc.a();
      if ((paramObject == null) || (paramObject.equals(bnpf.jdField_a_of_type_Bnpf)))
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
        paramObject = bnpc.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = true;
        }
        a(paramObject);
        return;
      }
      if (paramInt == 115)
      {
        paramObject = bnpc.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = false;
        }
        a(paramObject);
        return;
      }
      if ((paramInt == 112) && (paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bnpf)))
      {
        paramObject = (bnpf)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_Bnjw.getItemCount())
        {
          paramVarArgs = this.jdField_a_of_type_Bnjw.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
          {
            paramVarArgs.e = true;
            paramVarArgs.f = false;
            this.jdField_a_of_type_Bnjw.notifyItemChanged(paramInt);
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void b()
  {
    if ((bnpc.a() != null) && (!bnpc.a().c()) && (this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("widgetinfo", "camera^" + bnpc.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(@NonNull bnkc parambnkc, int paramInt)
  {
    if (!"call_material_id".equals(parambnkc.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      parambnkc.jdField_a_of_type_Bnpf.b = true;
      if ((bnpc.a() != null) && (!bnpc.a().equals(parambnkc.jdField_a_of_type_Bnpf)))
      {
        bnpc.a().b = false;
        bnpc.a().c = false;
      }
    }
    QLog.d("AEWaterMarkListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  public void c(@Nullable bnkc parambnkc, int paramInt)
  {
    if (parambnkc != null)
    {
      parambnkc.a(3);
      parambnkc = parambnkc.jdField_a_of_type_Bnpf;
      bnnx.a().a(parambnkc);
      if (this.jdField_a_of_type_Bnjw != null)
      {
        if (!a(parambnkc)) {
          break label46;
        }
        zmi.a(this.jdField_a_of_type_AndroidAppActivity, parambnkc);
      }
    }
    return;
    label46:
    this.jdField_a_of_type_Bnjw.b(parambnkc);
  }
  
  public void d()
  {
    if (bnvh.a())
    {
      a(bnvh.b);
      bnvh.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Bnpc.a(this);
    this.jdField_a_of_type_Bnpc.b(null, false);
    if (this.jdField_a_of_type_Bnjw != null) {
      this.jdField_a_of_type_Bnjw.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkd
 * JD-Core Version:    0.7.0.1
 */