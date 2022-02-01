import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.ColorNoteController.1;
import com.tencent.mobileqq.colornote.ColorNoteController.2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceLauncher;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqre
  implements aqvf, aqvn
{
  private static SparseArrayCompat<aqtj> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private aqro jdField_a_of_type_Aqro;
  private aquf jdField_a_of_type_Aquf;
  private aqug jdField_a_of_type_Aqug;
  private aqvd jdField_a_of_type_Aqvd;
  private aqvm jdField_a_of_type_Aqvm;
  private SwipePostTableLayout jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ColorNoteController.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = true;
  private boolean d;
  
  public aqre(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public aqre(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, false, false, 2131165514);
  }
  
  public aqre(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, paramBoolean3, false, paramBoolean4, paramInt);
  }
  
  public aqre(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, @DrawableRes int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramSwipePostTableLayout != null) {
        break label124;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = new SwipePostTableLayout(paramContext);
      if (paramBoolean3)
      {
        if ((aqvh.a()) && ((!paramBoolean4) || (Build.VERSION.SDK_INT != 26))) {
          break label133;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setBackgroundResource(paramInt);
      }
    }
    for (;;)
    {
      this.c = paramBoolean2;
      if ((paramBoolean2) && (!paramBoolean1)) {
        this.jdField_a_of_type_Aquf = new aquf();
      }
      this.jdField_a_of_type_Aqug = new aqug(paramContext);
      aqsf.a();
      return;
      label124:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = paramSwipePostTableLayout;
      break;
      label133:
      paramSwipePostTableLayout = (Activity)paramContext;
      if (!paramBoolean3) {}
      for (paramBoolean3 = bool;; paramBoolean3 = false)
      {
        this.jdField_a_of_type_Aqvm = new aqvm(paramSwipePostTableLayout, paramBoolean3);
        this.jdField_a_of_type_Aqvm.a(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setTranslucentConvertor(this.jdField_a_of_type_Aqvm);
        if (!paramBoolean5) {
          break label212;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnSwipeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(false);
        break;
      }
      label212:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.post(new ColorNoteController.2(this));
    }
  }
  
  public aqre(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  public static aqtj a(ColorNote paramColorNote)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      q();
    }
    aqtj localaqtj = (aqtj)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramColorNote.getServiceType());
    paramColorNote = localaqtj;
    if (localaqtj == null) {
      paramColorNote = (aqtj)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(65536);
    }
    return paramColorNote;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    aquy.a(paramContext, 6, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aqsf.a().a(paramQQAppInterface, paramBoolean);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    ColorNoteSmallScreenService.a(paramBoolean, paramInt);
  }
  
  public static boolean a(Context paramContext, ColorNote paramColorNote)
  {
    return a(paramContext, paramColorNote, null);
  }
  
  public static boolean a(Context paramContext, ColorNote paramColorNote, Bundle paramBundle)
  {
    boolean bool = false;
    switch (aqsd.a(paramColorNote.getServiceType()))
    {
    default: 
      paramBundle = null;
      if (paramBundle != null)
      {
        if (!aqsd.b(paramColorNote)) {
          break label353;
        }
        bdll.b(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", aqrd.b(aqsd.a(paramColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      Object localObject = paramColorNote;
      if (aqsd.b(paramColorNote)) {
        localObject = aqsd.b(paramColorNote);
      }
      paramBundle.launch(paramContext, (ColorNote)localObject);
      bool = true;
      return bool;
      paramBundle = new aqss(paramBundle);
      break;
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putBoolean("recent_note", aqsd.b(paramColorNote));
      paramBundle = new aqsp((Bundle)localObject);
      break;
      paramBundle = new aqsm();
      break;
      paramBundle = new aqsj();
      break;
      paramBundle = new aqsk();
      break;
      paramBundle = new aqso();
      break;
      paramBundle = new aqsh();
      break;
      paramBundle = new aqsl();
      break;
      paramBundle = new aqsq();
      break;
      paramBundle = new aqsn();
      break;
      paramBundle = new aqsr();
      break;
      paramBundle = new QQVoiceLauncher();
      break;
      label353:
      bdll.b(null, "dc00898", "", "", "0X800A749", "0X800A749", aqrd.a(paramColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return aqsf.a().a();
  }
  
  public static void c(boolean paramBoolean)
  {
    aqsf.a().a(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = true;
    int i = 0;
    if (this.jdField_a_of_type_Aqro != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      localObject = aqsf.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_Aqro.a(((Point)localObject).x, ((Point)localObject).y);
      }
      if ((!c()) && ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f))) {
        break label231;
      }
      if ((this.jdField_a_of_type_Aqvm == null) || (this.jdField_a_of_type_Aqvm.a())) {
        break label145;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Aqvd.onColorNoteAnimFinish();
      }
    }
    else
    {
      return;
    }
    this.b = true;
    this.jdField_a_of_type_Aqvm.a();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    return;
    label145:
    this.b = false;
    Object localObject = this.jdField_a_of_type_Aqug.a();
    if (localObject != null)
    {
      localObject = ((aqrn)localObject).getColorNote();
      if ((localObject == null) || (((ColorNote)localObject).mServiceType != 16842752)) {}
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localObject = this.jdField_a_of_type_Aqro;
      aqvd localaqvd = this.jdField_a_of_type_Aqvd;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) {}
      for (;;)
      {
        ((aqro)localObject).a(localaqvd, paramBoolean, i);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.getScrollX();
      }
      label231:
      this.jdField_a_of_type_Aqvd.onColorNoteAnimFinish();
      return;
    }
  }
  
  private static void q()
  {
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(65536, new aqth());
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(16908289, new aqtl());
  }
  
  public ColorNote a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new aqrv().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
  }
  
  public SwipePostTableLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.a();
    }
    if (this.jdField_a_of_type_Aquf != null) {
      this.jdField_a_of_type_Aquf.a();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.a(paramActivity);
    }
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView1 = paramActivity.getChildAt(0);
    View localView2 = paramActivity.findViewById(16908290);
    paramActivity = localView2;
    if (localView2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ColorNoteController", 2, "can not find content view");
      }
      paramActivity = localView1;
    }
    this.jdField_a_of_type_Aqug.a(paramActivity);
    this.jdField_a_of_type_Aqro = new aqro(paramActivity);
    this.jdField_a_of_type_Aqro.a();
    aqsf.a().a();
  }
  
  public void a(aqrh paramaqrh)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnColorNoteCurdListener(paramaqrh);
    }
    if (this.jdField_a_of_type_Aquf != null) {
      this.jdField_a_of_type_Aquf.a(paramaqrh);
    }
    if (this.jdField_a_of_type_Aqug != null) {
      this.jdField_a_of_type_Aqug.a(paramaqrh);
    }
    aqsf.a().a(paramaqrh);
  }
  
  public void a(aqrn paramaqrn)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setServiceInfo(paramaqrn);
    }
    if (this.jdField_a_of_type_Aquf != null) {
      this.jdField_a_of_type_Aquf.a(paramaqrn);
    }
    this.jdField_a_of_type_Aqug.a(paramaqrn);
  }
  
  public void a(aqva paramaqva)
  {
    aqsf.a().a(paramaqva);
  }
  
  public void a(aqvd paramaqvd)
  {
    this.jdField_a_of_type_Aqvd = paramaqvd;
  }
  
  public void a(aqvj paramaqvj)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnPageSwipeListener(paramaqvj);
    }
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Aqug != null)
    {
      this.jdField_a_of_type_Aqug.a(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteController", 2, "update color note from share entrance: " + paramColorNote.getServiceType() + ", " + paramColorNote.mSubType + ", " + paramColorNote.mMainTitle);
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = aqsd.a(paramString);
    if (aqsd.b(i)) {
      d(false);
    }
    while (aqsd.a(i))
    {
      g();
      return;
      d(true);
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Aqvm != null)) {
      this.jdField_a_of_type_Aqvm.a();
    }
  }
  
  public boolean a()
  {
    return aqsf.a().b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b();
    }
    if (this.jdField_a_of_type_Aquf != null) {
      this.jdField_a_of_type_Aquf.b();
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b(paramActivity);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aqug != null) {
      return this.jdField_a_of_type_Aqug.a();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.c();
    }
    if (this.jdField_a_of_type_Aquf != null) {
      this.jdField_a_of_type_Aquf.b(this.d);
    }
    aqsf.a().b();
    this.jdField_a_of_type_Aqug = null;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Aqug != null) {
      return this.jdField_a_of_type_Aqug.b();
    }
    return false;
  }
  
  public void d()
  {
    e(false);
  }
  
  public void d(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.e;
    }
    return false;
  }
  
  public void d_(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(true);
    }
    if (this.b) {
      d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aqug != null)
    {
      this.jdField_a_of_type_Aqug.a();
      ColorNote localColorNote = this.jdField_a_of_type_Aqug.a().getColorNote();
      if (localColorNote != null)
      {
        aqsf.a().a(localColorNote.mServiceType, localColorNote.mSubType, true);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteController", 2, "insert color note from share entrance: " + localColorNote.getServiceType() + ", " + localColorNote.mSubType + ", " + localColorNote.mMainTitle);
        }
      }
    }
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aqug != null)
    {
      this.jdField_a_of_type_Aqug.b();
      ColorNote localColorNote = this.jdField_a_of_type_Aqug.a().getColorNote();
      if (localColorNote != null)
      {
        aqsf.a().a(localColorNote.mServiceType, localColorNote.mSubType, false);
        if (this.jdField_a_of_type_Boolean)
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 2, localBaseApplication.getString(2131690750), 2000).a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteController", 2, "delete color note from share entrance: " + localColorNote.getServiceType() + ", " + localColorNote.mSubType + ", " + localColorNote.mMainTitle);
        }
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.i();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.j();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Aqug != null) {
      this.jdField_a_of_type_Aqug.c();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.e();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f();
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void m()
  {
    aqsf.a().a();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Aquf != null) {
      this.jdField_a_of_type_Aquf.c();
    }
  }
  
  public void o()
  {
    this.d = false;
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Aqug != null) {
      aqts.a(this.jdField_a_of_type_Aqug.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqre
 * JD-Core Version:    0.7.0.1
 */