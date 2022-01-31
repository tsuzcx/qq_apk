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

public class bkqr
  extends blbl
  implements azbr, bkri, bkrj<bkqq>, bkrk<bkqq>
{
  private int jdField_a_of_type_Int;
  private bkle jdField_a_of_type_Bkle;
  private bkpa jdField_a_of_type_Bkpa;
  private bkqk jdField_a_of_type_Bkqk;
  private bkvr jdField_a_of_type_Bkvr;
  private blbj jdField_a_of_type_Blbj;
  private blbk jdField_a_of_type_Blbk;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  
  public bkqr(Activity paramActivity, View paramView, blbm paramblbm)
  {
    super(paramActivity, paramView, paramblbm);
    this.jdField_a_of_type_Bkle = ((bkle)paramblbm.a(65537, new Object[0]));
    this.jdField_a_of_type_Bkpa = this.jdField_a_of_type_Bkle.a();
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
      if (i >= this.jdField_a_of_type_Bkqk.getItemCount()) {
        break label57;
      }
      bkvu localbkvu = this.jdField_a_of_type_Bkqk.a(i);
      if (localbkvu != null)
      {
        j = i;
        if (paramString.equals(localbkvu.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  private bkvu a(int paramInt)
  {
    if (this.jdField_a_of_type_Bkqk != null) {
      return this.jdField_a_of_type_Bkqk.a(paramInt);
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Bkqk.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  private void a(bkvu parambkvu)
  {
    if ((parambkvu != null) && (!parambkvu.equals(bkvu.jdField_a_of_type_Bkvu)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Bkqk.getItemCount()) || (this.jdField_a_of_type_Bkqk.a(i) == null)) {
        break label103;
      }
      if (!parambkvu.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bkqk.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Bkqk.a(i).a(parambkvu);
      a(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Bkqk.a(parambkvu);
        a(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private boolean a(bkvu parambkvu)
  {
    if (parambkvu != null) {
      return parambkvu.a();
    }
    return false;
  }
  
  private boolean b()
  {
    Boolean localBoolean;
    if ((this.jdField_a_of_type_Blbk != null) && (this.jdField_a_of_type_Blbk.a() != null))
    {
      localBoolean = (Boolean)this.jdField_a_of_type_Blbk.a().a();
      if (localBoolean == null) {}
    }
    for (boolean bool = localBoolean.booleanValue();; bool = true) {
      return (!c()) && (this.jdField_a_of_type_Blbj.b()) && (bool);
    }
  }
  
  private boolean c()
  {
    return ((this.jdField_a_of_type_AndroidAppActivity != null) && ((bkwm.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bkwm.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bkwm.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())))) || (bkwm.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bkqk.a();
    bler.a().g();
    blen.a().I();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Blbj = ((blbj)bklq.a(this.jdField_a_of_type_Bkle).a(blbj.class));
    this.jdField_a_of_type_Blbj.a.a(this.jdField_a_of_type_Bkle, new bkqy(this));
    this.jdField_a_of_type_Blbk = ((blbk)bklq.a(this.jdField_a_of_type_Bkle).a(blbk.class));
    this.jdField_a_of_type_Blbk.a().a(this.jdField_a_of_type_Bkle, new bkqz(this));
  }
  
  private void k()
  {
    if (!b()) {
      return;
    }
    ytv.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bkra(this)).b();
  }
  
  private void l()
  {
    QLog.d("AEWaterMarkListPart", 4, "getDateFromPtv: ");
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this));
    bkvk.b().a(this.jdField_a_of_type_Bkle, new bkrb(this));
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
      this.jdField_a_of_type_Bkvr.f();
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
          Object localObject = this.jdField_a_of_type_Bkvr.b();
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
              bkvu localbkvu = (bkvu)((Iterator)localObject).next();
              if (((!localbkvu.jdField_a_of_type_JavaLangString.contains("_3DFaceFila")) || (FilamentInitializer.supportFilament())) && ((!localbkvu.jdField_a_of_type_JavaLangString.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
              {
                if (i >= 10) {
                  break;
                }
                localArrayList.add(localbkvu);
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
    int i = xod.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    ((AnimatorSet)localObject).addListener(new bkrc(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = blva.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bkqt(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Blbj.a())
    {
      if (this.jdField_a_of_type_Blbm != null)
      {
        this.jdField_a_of_type_Blbm.a(327683, new Object[0]);
        this.jdField_a_of_type_Blbm.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bkle.a().a(true, 150);
      return;
    }
    int i = xod.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bkqu(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = blva.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bkqv(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Blbj.a())
    {
      if (this.jdField_a_of_type_Blbm != null)
      {
        this.jdField_a_of_type_Blbm.a(327684, new Object[0]);
        this.jdField_a_of_type_Blbm.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bkle.a().a(true, 150);
      return;
    }
    int i = xod.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bkqw(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = blva.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bkqx(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void q()
  {
    int j = 0;
    bkvu localbkvu1 = bkvr.a();
    if (localbkvu1 != null)
    {
      bkvu localbkvu2 = this.jdField_a_of_type_Bkqk.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localbkvu2 != null)
      {
        i = j;
        if (localbkvu1.jdField_a_of_type_JavaLangString.equals(localbkvu2.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Bkqk.getItemCount()) {
          break;
        }
        localbkvu2 = this.jdField_a_of_type_Bkqk.a(i);
      } while ((localbkvu2 == null) || (!localbkvu1.jdField_a_of_type_JavaLangString.equals(localbkvu2.jdField_a_of_type_JavaLangString)));
      a(i);
      return;
    }
    a(0);
    return;
    a(this.jdField_a_of_type_Int);
  }
  
  public bkvr a()
  {
    return this.jdField_a_of_type_Bkvr;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377090)).inflate().findViewById(2131373290));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new yud().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Bkqk = new bkqk(this.jdField_a_of_type_Bkle, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Bkpa);
      this.jdField_a_of_type_Bkqk.a(new bkqs(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bkqk);
      this.jdField_a_of_type_Bkvr = ((bkvr)blmf.a().c(18));
      if (c()) {
        break label243;
      }
      this.jdField_a_of_type_Bkvr.a(this, 113);
      this.jdField_a_of_type_Bkvr.a(this, 114);
      this.jdField_a_of_type_Bkvr.a(this, 115);
      this.jdField_a_of_type_Bkvr.a(this, 112);
      e();
      l();
    }
    for (;;)
    {
      f();
      return;
      label243:
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      this.jdField_a_of_type_Bkqk.b();
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable bkqq parambkqq1, @Nullable bkqq parambkqq2) {}
  
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
      this.jdField_a_of_type_Blbk.b().a(Boolean.valueOf(false));
      this.jdField_a_of_type_Blbk.c().a(Boolean.valueOf(false));
    } while ((!this.jdField_a_of_type_Blbj.b()) || (c()));
    q();
    n();
  }
  
  public void a(@NonNull bkqq parambkqq, int paramInt)
  {
    parambkqq.a(4);
  }
  
  public void a(@NonNull bkqq parambkqq, boolean paramBoolean)
  {
    if (parambkqq.jdField_a_of_type_Bkvu.b) {
      parambkqq.jdField_a_of_type_Bkvu.c = true;
    }
    for (;;)
    {
      if ((bkvr.a() != null) && (!bkvr.a().equals(parambkqq.jdField_a_of_type_Bkvu)))
      {
        bkvr.a().b = false;
        bkvr.a().c = false;
      }
      return;
      parambkqq.jdField_a_of_type_Bkvu.b = true;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = bkvr.a();
      if ((paramObject == null) || (paramObject.equals(bkvu.jdField_a_of_type_Bkvu)))
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
        paramObject = bkvr.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = true;
        }
        a(paramObject);
        return;
      }
      if (paramInt == 115)
      {
        paramObject = bkvr.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = false;
        }
        a(paramObject);
        return;
      }
      if ((paramInt == 112) && (paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bkvu)))
      {
        paramObject = (bkvu)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_Bkqk.getItemCount())
        {
          paramVarArgs = this.jdField_a_of_type_Bkqk.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
          {
            paramVarArgs.d = true;
            paramVarArgs.e = false;
            this.jdField_a_of_type_Bkqk.notifyItemChanged(paramInt);
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void b()
  {
    if ((bkvr.a() != null) && (!bkvr.a().c()) && (this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("widgetinfo", "camera^" + bkvr.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(@NonNull bkqq parambkqq, int paramInt)
  {
    if (!"call_material_id".equals(parambkqq.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      parambkqq.jdField_a_of_type_Bkvu.b = true;
      if ((bkvr.a() != null) && (!bkvr.a().equals(parambkqq.jdField_a_of_type_Bkvu)))
      {
        bkvr.a().b = false;
        bkvr.a().c = false;
      }
    }
    QLog.d("AEWaterMarkListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  public void c(@Nullable bkqq parambkqq, int paramInt)
  {
    if (parambkqq != null)
    {
      parambkqq.a(3);
      parambkqq = parambkqq.jdField_a_of_type_Bkvu;
      bkum.a().a(parambkqq);
      if (this.jdField_a_of_type_Bkqk != null)
      {
        if (!a(parambkqq)) {
          break label46;
        }
        xoo.a(this.jdField_a_of_type_AndroidAppActivity, parambkqq);
      }
    }
    return;
    label46:
    this.jdField_a_of_type_Bkqk.b(parambkqq);
  }
  
  public void d()
  {
    if (blbs.a())
    {
      a(blbs.b);
      blbs.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Bkvr.a(this);
    this.jdField_a_of_type_Bkvr.b(null, false);
    if (this.jdField_a_of_type_Bkqk != null) {
      this.jdField_a_of_type_Bkqk.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqr
 * JD-Core Version:    0.7.0.1
 */