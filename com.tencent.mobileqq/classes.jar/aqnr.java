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

public class aqnr
  implements aqrs, aqsa
{
  private static SparseArrayCompat<aqpw> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private aqob jdField_a_of_type_Aqob;
  private aqqs jdField_a_of_type_Aqqs;
  private aqqt jdField_a_of_type_Aqqt;
  private aqrq jdField_a_of_type_Aqrq;
  private aqrz jdField_a_of_type_Aqrz;
  private SwipePostTableLayout jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ColorNoteController.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = true;
  private boolean d;
  
  public aqnr(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public aqnr(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, false, false, 2131165528);
  }
  
  public aqnr(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, paramBoolean3, false, paramBoolean4, paramInt);
  }
  
  public aqnr(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, @DrawableRes int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramSwipePostTableLayout != null) {
        break label124;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = new SwipePostTableLayout(paramContext);
      if (paramBoolean3)
      {
        if ((aqru.a()) && ((!paramBoolean4) || (Build.VERSION.SDK_INT != 26))) {
          break label133;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setBackgroundResource(paramInt);
      }
    }
    for (;;)
    {
      this.c = paramBoolean2;
      if ((paramBoolean2) && (!paramBoolean1)) {
        this.jdField_a_of_type_Aqqs = new aqqs();
      }
      this.jdField_a_of_type_Aqqt = new aqqt(paramContext);
      aqos.a();
      return;
      label124:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = paramSwipePostTableLayout;
      break;
      label133:
      paramSwipePostTableLayout = (Activity)paramContext;
      if (!paramBoolean3) {}
      for (paramBoolean3 = bool;; paramBoolean3 = false)
      {
        this.jdField_a_of_type_Aqrz = new aqrz(paramSwipePostTableLayout, paramBoolean3);
        this.jdField_a_of_type_Aqrz.a(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setTranslucentConvertor(this.jdField_a_of_type_Aqrz);
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
  
  public aqnr(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  public static aqpw a(ColorNote paramColorNote)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      q();
    }
    aqpw localaqpw = (aqpw)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramColorNote.getServiceType());
    paramColorNote = localaqpw;
    if (localaqpw == null) {
      paramColorNote = (aqpw)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(65536);
    }
    return paramColorNote;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    aqrl.a(paramContext, 6, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aqos.a().a(paramQQAppInterface, paramBoolean);
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
    switch (aqoq.a(paramColorNote.getServiceType()))
    {
    default: 
      paramBundle = null;
      if (paramBundle != null)
      {
        if (!aqoq.b(paramColorNote)) {
          break label353;
        }
        bdla.b(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", aqnq.b(aqoq.a(paramColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      Object localObject = paramColorNote;
      if (aqoq.b(paramColorNote)) {
        localObject = aqoq.b(paramColorNote);
      }
      paramBundle.launch(paramContext, (ColorNote)localObject);
      bool = true;
      return bool;
      paramBundle = new aqpf(paramBundle);
      break;
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putBoolean("recent_note", aqoq.b(paramColorNote));
      paramBundle = new aqpc((Bundle)localObject);
      break;
      paramBundle = new aqoz();
      break;
      paramBundle = new aqow();
      break;
      paramBundle = new aqox();
      break;
      paramBundle = new aqpb();
      break;
      paramBundle = new aqou();
      break;
      paramBundle = new aqoy();
      break;
      paramBundle = new aqpd();
      break;
      paramBundle = new aqpa();
      break;
      paramBundle = new aqpe();
      break;
      paramBundle = new QQVoiceLauncher();
      break;
      label353:
      bdla.b(null, "dc00898", "", "", "0X800A749", "0X800A749", aqnq.a(paramColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return aqos.a().a();
  }
  
  public static void c(boolean paramBoolean)
  {
    aqos.a().a(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = true;
    int i = 0;
    Object localObject;
    if (this.jdField_a_of_type_Aqob != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      localObject = aqos.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_Aqob.a(((Point)localObject).x, ((Point)localObject).y);
      }
      if ((!c()) && ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f))) {
        break label245;
      }
      if ((this.jdField_a_of_type_Aqrz == null) || (this.jdField_a_of_type_Aqrz.a())) {
        break label152;
      }
      if (!paramBoolean) {
        break label117;
      }
      this.jdField_a_of_type_Aqrq.onColorNoteAnimFinish();
    }
    label117:
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_Aqrz.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    return;
    label152:
    this.b = false;
    if (this.jdField_a_of_type_Aqqt != null)
    {
      localObject = this.jdField_a_of_type_Aqqt.a();
      if (localObject != null)
      {
        localObject = ((aqoa)localObject).getColorNote();
        if ((localObject == null) || (((ColorNote)localObject).mServiceType != 16842752)) {}
      }
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localObject = this.jdField_a_of_type_Aqob;
      aqrq localaqrq = this.jdField_a_of_type_Aqrq;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) {}
      for (;;)
      {
        ((aqob)localObject).a(localaqrq, paramBoolean, i);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.getScrollX();
      }
      label245:
      this.jdField_a_of_type_Aqrq.onColorNoteAnimFinish();
      return;
    }
  }
  
  private static void q()
  {
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(65536, new aqpu());
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(16908289, new aqpy());
  }
  
  public ColorNote a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new aqoi().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
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
    if (this.jdField_a_of_type_Aqqs != null) {
      this.jdField_a_of_type_Aqqs.a();
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
    this.jdField_a_of_type_Aqqt.a(paramActivity);
    this.jdField_a_of_type_Aqob = new aqob(paramActivity);
    this.jdField_a_of_type_Aqob.a();
    aqos.a().a();
  }
  
  public void a(aqnu paramaqnu)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnColorNoteCurdListener(paramaqnu);
    }
    if (this.jdField_a_of_type_Aqqs != null) {
      this.jdField_a_of_type_Aqqs.a(paramaqnu);
    }
    if (this.jdField_a_of_type_Aqqt != null) {
      this.jdField_a_of_type_Aqqt.a(paramaqnu);
    }
    aqos.a().a(paramaqnu);
  }
  
  public void a(aqoa paramaqoa)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setServiceInfo(paramaqoa);
    }
    if (this.jdField_a_of_type_Aqqs != null) {
      this.jdField_a_of_type_Aqqs.a(paramaqoa);
    }
    this.jdField_a_of_type_Aqqt.a(paramaqoa);
  }
  
  public void a(aqrn paramaqrn)
  {
    aqos.a().a(paramaqrn);
  }
  
  public void a(aqrq paramaqrq)
  {
    this.jdField_a_of_type_Aqrq = paramaqrq;
  }
  
  public void a(aqrw paramaqrw)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnPageSwipeListener(paramaqrw);
    }
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Aqqt != null)
    {
      this.jdField_a_of_type_Aqqt.a(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteController", 2, "update color note from share entrance: " + paramColorNote.getServiceType() + ", " + paramColorNote.mSubType + ", " + paramColorNote.mMainTitle);
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = aqoq.a(paramString);
    if (aqoq.b(i)) {
      d(false);
    }
    while (aqoq.a(i))
    {
      g();
      return;
      d(true);
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Aqrz != null)) {
      this.jdField_a_of_type_Aqrz.a();
    }
  }
  
  public boolean a()
  {
    return aqos.a().b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b();
    }
    if (this.jdField_a_of_type_Aqqs != null) {
      this.jdField_a_of_type_Aqqs.b();
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
    if (this.jdField_a_of_type_Aqqt != null) {
      return this.jdField_a_of_type_Aqqt.a();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.c();
    }
    if (this.jdField_a_of_type_Aqqs != null) {
      this.jdField_a_of_type_Aqqs.b(this.d);
    }
    aqos.a().b();
    this.jdField_a_of_type_Aqqt = null;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Aqqt != null) {
      return this.jdField_a_of_type_Aqqt.b();
    }
    return false;
  }
  
  public void c_(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(true);
    }
    if (this.b) {
      d();
    }
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
  
  public void e()
  {
    if (this.jdField_a_of_type_Aqqt != null)
    {
      this.jdField_a_of_type_Aqqt.a();
      ColorNote localColorNote = this.jdField_a_of_type_Aqqt.a().getColorNote();
      if (localColorNote != null)
      {
        aqos.a().a(localColorNote.mServiceType, localColorNote.mSubType, true);
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
    if (this.jdField_a_of_type_Aqqt != null)
    {
      this.jdField_a_of_type_Aqqt.b();
      ColorNote localColorNote = this.jdField_a_of_type_Aqqt.a().getColorNote();
      if (localColorNote != null)
      {
        aqos.a().a(localColorNote.mServiceType, localColorNote.mSubType, false);
        if (this.jdField_a_of_type_Boolean)
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 2, localBaseApplication.getString(2131690875), 2000).a();
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
    if (this.jdField_a_of_type_Aqqt != null) {
      this.jdField_a_of_type_Aqqt.c();
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
    aqos.a().a();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Aqqs != null) {
      this.jdField_a_of_type_Aqqs.c();
    }
  }
  
  public void o()
  {
    this.d = false;
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Aqqt != null) {
      aqqf.a(this.jdField_a_of_type_Aqqt.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnr
 * JD-Core Version:    0.7.0.1
 */