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

public class bkuy
  extends blfs
  implements azga, bkvp, bkvq<bkux>, bkvr<bkux>
{
  private int jdField_a_of_type_Int;
  private bkpl jdField_a_of_type_Bkpl;
  private bkth jdField_a_of_type_Bkth;
  private bkur jdField_a_of_type_Bkur;
  private bkzy jdField_a_of_type_Bkzy;
  private blfq jdField_a_of_type_Blfq;
  private blfr jdField_a_of_type_Blfr;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  
  public bkuy(Activity paramActivity, View paramView, blft paramblft)
  {
    super(paramActivity, paramView, paramblft);
    this.jdField_a_of_type_Bkpl = ((bkpl)paramblft.a(65537, new Object[0]));
    this.jdField_a_of_type_Bkth = this.jdField_a_of_type_Bkpl.a();
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
      if (i >= this.jdField_a_of_type_Bkur.getItemCount()) {
        break label57;
      }
      blab localblab = this.jdField_a_of_type_Bkur.a(i);
      if (localblab != null)
      {
        j = i;
        if (paramString.equals(localblab.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  private blab a(int paramInt)
  {
    if (this.jdField_a_of_type_Bkur != null) {
      return this.jdField_a_of_type_Bkur.a(paramInt);
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Bkur.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  private void a(blab paramblab)
  {
    if ((paramblab != null) && (!paramblab.equals(blab.jdField_a_of_type_Blab)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Bkur.getItemCount()) || (this.jdField_a_of_type_Bkur.a(i) == null)) {
        break label103;
      }
      if (!paramblab.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bkur.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Bkur.a(i).a(paramblab);
      a(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Bkur.a(paramblab);
        a(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private boolean a(blab paramblab)
  {
    if (paramblab != null) {
      return paramblab.a();
    }
    return false;
  }
  
  private boolean b()
  {
    Boolean localBoolean;
    if ((this.jdField_a_of_type_Blfr != null) && (this.jdField_a_of_type_Blfr.a() != null))
    {
      localBoolean = (Boolean)this.jdField_a_of_type_Blfr.a().a();
      if (localBoolean == null) {}
    }
    for (boolean bool = localBoolean.booleanValue();; bool = true) {
      return (!c()) && (this.jdField_a_of_type_Blfq.b()) && (bool);
    }
  }
  
  private boolean c()
  {
    return ((this.jdField_a_of_type_AndroidAppActivity != null) && ((blat.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (blat.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (blat.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())))) || (blat.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bkur.a();
    bliy.a().g();
    bliu.a().I();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class));
    this.jdField_a_of_type_Blfq.a.a(this.jdField_a_of_type_Bkpl, new bkvf(this));
    this.jdField_a_of_type_Blfr = ((blfr)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfr.class));
    this.jdField_a_of_type_Blfr.a().a(this.jdField_a_of_type_Bkpl, new bkvg(this));
  }
  
  private void k()
  {
    if (!b()) {
      return;
    }
    yyk.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bkvh(this)).b();
  }
  
  private void l()
  {
    QLog.d("AEWaterMarkListPart", 4, "getDateFromPtv: ");
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this));
    bkzr.b().a(this.jdField_a_of_type_Bkpl, new bkvi(this));
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
      this.jdField_a_of_type_Bkzy.f();
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
          Object localObject = this.jdField_a_of_type_Bkzy.b();
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
              blab localblab = (blab)((Iterator)localObject).next();
              if (((!localblab.jdField_a_of_type_JavaLangString.contains("_3DFaceFila")) || (FilamentInitializer.supportFilament())) && ((!localblab.jdField_a_of_type_JavaLangString.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
              {
                if (i >= 10) {
                  break;
                }
                localArrayList.add(localblab);
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
    int i = xsm.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    ((AnimatorSet)localObject).addListener(new bkvj(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = blzm.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bkva(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Blfq.a())
    {
      if (this.jdField_a_of_type_Blft != null)
      {
        this.jdField_a_of_type_Blft.a(327683, new Object[0]);
        this.jdField_a_of_type_Blft.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bkpl.a().a(true, 150);
      return;
    }
    int i = xsm.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bkvb(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = blzm.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bkvc(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Blfq.a())
    {
      if (this.jdField_a_of_type_Blft != null)
      {
        this.jdField_a_of_type_Blft.a(327684, new Object[0]);
        this.jdField_a_of_type_Blft.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bkpl.a().a(true, 150);
      return;
    }
    int i = xsm.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bkvd(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = blzm.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bkve(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void q()
  {
    int j = 0;
    blab localblab1 = bkzy.a();
    if (localblab1 != null)
    {
      blab localblab2 = this.jdField_a_of_type_Bkur.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localblab2 != null)
      {
        i = j;
        if (localblab1.jdField_a_of_type_JavaLangString.equals(localblab2.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Bkur.getItemCount()) {
          break;
        }
        localblab2 = this.jdField_a_of_type_Bkur.a(i);
      } while ((localblab2 == null) || (!localblab1.jdField_a_of_type_JavaLangString.equals(localblab2.jdField_a_of_type_JavaLangString)));
      a(i);
      return;
    }
    a(0);
    return;
    a(this.jdField_a_of_type_Int);
  }
  
  public bkzy a()
  {
    return this.jdField_a_of_type_Bkzy;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377144)).inflate().findViewById(2131373342));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new yys().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Bkur = new bkur(this.jdField_a_of_type_Bkpl, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Bkth);
      this.jdField_a_of_type_Bkur.a(new bkuz(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bkur);
      this.jdField_a_of_type_Bkzy = ((bkzy)blqr.a().c(18));
      if (c()) {
        break label243;
      }
      this.jdField_a_of_type_Bkzy.a(this, 113);
      this.jdField_a_of_type_Bkzy.a(this, 114);
      this.jdField_a_of_type_Bkzy.a(this, 115);
      this.jdField_a_of_type_Bkzy.a(this, 112);
      e();
      l();
    }
    for (;;)
    {
      f();
      return;
      label243:
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      this.jdField_a_of_type_Bkur.b();
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable bkux parambkux1, @Nullable bkux parambkux2) {}
  
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
      this.jdField_a_of_type_Blfr.b().a(Boolean.valueOf(false));
      this.jdField_a_of_type_Blfr.c().a(Boolean.valueOf(false));
    } while ((!this.jdField_a_of_type_Blfq.b()) || (c()));
    q();
    n();
  }
  
  public void a(@NonNull bkux parambkux, int paramInt)
  {
    parambkux.a(4);
  }
  
  public void a(@NonNull bkux parambkux, boolean paramBoolean)
  {
    if (parambkux.jdField_a_of_type_Blab.b) {
      parambkux.jdField_a_of_type_Blab.c = true;
    }
    for (;;)
    {
      if ((bkzy.a() != null) && (!bkzy.a().equals(parambkux.jdField_a_of_type_Blab)))
      {
        bkzy.a().b = false;
        bkzy.a().c = false;
      }
      return;
      parambkux.jdField_a_of_type_Blab.b = true;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = bkzy.a();
      if ((paramObject == null) || (paramObject.equals(blab.jdField_a_of_type_Blab)))
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
        paramObject = bkzy.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = true;
        }
        a(paramObject);
        return;
      }
      if (paramInt == 115)
      {
        paramObject = bkzy.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = false;
        }
        a(paramObject);
        return;
      }
      if ((paramInt == 112) && (paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof blab)))
      {
        paramObject = (blab)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_Bkur.getItemCount())
        {
          paramVarArgs = this.jdField_a_of_type_Bkur.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
          {
            paramVarArgs.d = true;
            paramVarArgs.e = false;
            this.jdField_a_of_type_Bkur.notifyItemChanged(paramInt);
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void b()
  {
    if ((bkzy.a() != null) && (!bkzy.a().c()) && (this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("widgetinfo", "camera^" + bkzy.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(@NonNull bkux parambkux, int paramInt)
  {
    if (!"call_material_id".equals(parambkux.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      parambkux.jdField_a_of_type_Blab.b = true;
      if ((bkzy.a() != null) && (!bkzy.a().equals(parambkux.jdField_a_of_type_Blab)))
      {
        bkzy.a().b = false;
        bkzy.a().c = false;
      }
    }
    QLog.d("AEWaterMarkListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  public void c(@Nullable bkux parambkux, int paramInt)
  {
    if (parambkux != null)
    {
      parambkux.a(3);
      parambkux = parambkux.jdField_a_of_type_Blab;
      bkyt.a().a(parambkux);
      if (this.jdField_a_of_type_Bkur != null)
      {
        if (!a(parambkux)) {
          break label46;
        }
        xsx.a(this.jdField_a_of_type_AndroidAppActivity, parambkux);
      }
    }
    return;
    label46:
    this.jdField_a_of_type_Bkur.b(parambkux);
  }
  
  public void d()
  {
    if (blfz.a())
    {
      a(blfz.b);
      blfz.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Bkzy.a(this);
    this.jdField_a_of_type_Bkzy.b(null, false);
    if (this.jdField_a_of_type_Bkur != null) {
      this.jdField_a_of_type_Bkur.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuy
 * JD-Core Version:    0.7.0.1
 */