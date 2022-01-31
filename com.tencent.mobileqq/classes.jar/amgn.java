import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amgn
  implements amkk, amkt
{
  private static SparseArrayCompat<amil> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private amgw jdField_a_of_type_Amgw;
  private amjh jdField_a_of_type_Amjh;
  private amji jdField_a_of_type_Amji;
  private amki jdField_a_of_type_Amki;
  private amks jdField_a_of_type_Amks;
  private SwipePostTableLayout jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ColorNoteController.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = true;
  private boolean d = true;
  
  public amgn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public amgn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, false, false, 2131165444);
  }
  
  public amgn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramSwipePostTableLayout != null) {
        break label116;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = new SwipePostTableLayout(paramContext);
      if (paramBoolean3)
      {
        if (amkm.a()) {
          break label125;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setBackgroundResource(paramInt);
      }
    }
    for (;;)
    {
      this.c = paramBoolean2;
      if ((paramBoolean2) && (!paramBoolean1)) {
        this.jdField_a_of_type_Amjh = new amjh();
      }
      this.jdField_a_of_type_Amji = new amji(paramContext);
      amhj.a();
      return;
      label116:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = paramSwipePostTableLayout;
      break;
      label125:
      paramSwipePostTableLayout = (Activity)paramContext;
      if (!paramBoolean3) {}
      for (paramBoolean3 = bool;; paramBoolean3 = false)
      {
        this.jdField_a_of_type_Amks = new amks(paramSwipePostTableLayout, paramBoolean3);
        this.jdField_a_of_type_Amks.a(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setTranslucentConvertor(this.jdField_a_of_type_Amks);
        if (!paramBoolean4) {
          break label204;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnSwipeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(false);
        break;
      }
      label204:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.post(new ColorNoteController.2(this));
    }
  }
  
  public amgn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  public static amil a(ColorNote paramColorNote)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      q();
    }
    amil localamil = (amil)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramColorNote.getServiceType());
    paramColorNote = localamil;
    if (localamil == null) {
      paramColorNote = (amil)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(65536);
    }
    return paramColorNote;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    amkf.a(paramContext, 6, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    amhj.a().a(paramQQAppInterface, paramBoolean);
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
    switch (amhh.a(paramColorNote.getServiceType()))
    {
    default: 
      paramBundle = null;
      if (paramBundle != null)
      {
        if (!amhh.b(paramColorNote)) {
          break label301;
        }
        axqy.b(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", amgm.b(amhh.a(paramColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      paramBundle.a(paramContext, amhh.b(paramColorNote));
      bool = true;
      return bool;
      paramBundle = new amhv(paramBundle);
      break;
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("recent_note", amhh.b(paramColorNote));
      paramBundle = new amht(localBundle);
      break;
      paramBundle = new amhq();
      break;
      paramBundle = new amhn();
      break;
      paramBundle = new amho();
      break;
      paramBundle = new amhs();
      break;
      paramBundle = new amhl();
      break;
      paramBundle = new amhp();
      break;
      paramBundle = new amhu();
      break;
      paramBundle = new amhr();
      break;
      label301:
      axqy.b(null, "dc00898", "", "", "0X800A749", "0X800A749", amgm.a(paramColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return amhj.a().a();
  }
  
  public static void c(boolean paramBoolean)
  {
    amhj.a().a(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = true;
    int i = 0;
    if (this.jdField_a_of_type_Amgw != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      localObject = amhj.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_Amgw.a(((Point)localObject).x, ((Point)localObject).y);
      }
      if ((!c()) && ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f))) {
        break label231;
      }
      if ((this.jdField_a_of_type_Amks == null) || (this.jdField_a_of_type_Amks.a())) {
        break label145;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Amki.onColorNoteAnimFinish();
      }
    }
    else
    {
      return;
    }
    this.b = true;
    this.jdField_a_of_type_Amks.a();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    return;
    label145:
    this.b = false;
    Object localObject = this.jdField_a_of_type_Amji.a();
    if (localObject != null)
    {
      localObject = ((amgv)localObject).getColorNote();
      if ((localObject == null) || (((ColorNote)localObject).mServiceType != 16842752)) {}
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localObject = this.jdField_a_of_type_Amgw;
      amki localamki = this.jdField_a_of_type_Amki;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) {}
      for (;;)
      {
        ((amgw)localObject).a(localamki, paramBoolean, i);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.getScrollX();
      }
      label231:
      this.jdField_a_of_type_Amki.onColorNoteAnimFinish();
      return;
    }
  }
  
  private static void q()
  {
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(65536, new amik());
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(16908289, new amin());
  }
  
  public ColorNote a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new amhb().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
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
    if (this.jdField_a_of_type_Amjh != null) {
      this.jdField_a_of_type_Amjh.a();
    }
  }
  
  public void a(amgq paramamgq)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnColorNoteCurdListener(paramamgq);
    }
    if (this.jdField_a_of_type_Amjh != null) {
      this.jdField_a_of_type_Amjh.a(paramamgq);
    }
    if (this.jdField_a_of_type_Amji != null) {
      this.jdField_a_of_type_Amji.a(paramamgq);
    }
    amhj.a().a(paramamgq);
  }
  
  public void a(amgv paramamgv)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setServiceInfo(paramamgv);
    }
    if (this.jdField_a_of_type_Amjh != null) {
      this.jdField_a_of_type_Amjh.a(paramamgv);
    }
    this.jdField_a_of_type_Amji.a(paramamgv);
  }
  
  public void a(amkg paramamkg)
  {
    amhj.a().a(paramamkg);
  }
  
  public void a(amki paramamki)
  {
    this.jdField_a_of_type_Amki = paramamki;
  }
  
  public void a(amkp paramamkp)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnPageSwipeListener(paramamkp);
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
    this.jdField_a_of_type_Amji.a(paramActivity);
    this.jdField_a_of_type_Amgw = new amgw(paramActivity);
    this.jdField_a_of_type_Amgw.a();
    amhj.a().a();
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Amji != null)
    {
      this.jdField_a_of_type_Amji.a(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteController", 2, "update color note from share entrance: " + paramColorNote.getServiceType() + ", " + paramColorNote.mSubType + ", " + paramColorNote.mMainTitle);
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = amhh.a(paramString);
    if (amhh.b(i)) {
      d(false);
    }
    while (amhh.a(i))
    {
      g();
      return;
      d(true);
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Amks != null)) {
      this.jdField_a_of_type_Amks.a();
    }
  }
  
  public boolean a()
  {
    return amhj.a().b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b();
    }
    if (this.jdField_a_of_type_Amjh != null) {
      this.jdField_a_of_type_Amjh.b();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Amji != null) {
      return this.jdField_a_of_type_Amji.a();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.c();
    }
    if (this.jdField_a_of_type_Amjh != null) {
      this.jdField_a_of_type_Amjh.b(this.d);
    }
    amhj.a().b();
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Amji != null) {
      return this.jdField_a_of_type_Amji.b();
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
    if (this.jdField_a_of_type_Amji != null)
    {
      this.jdField_a_of_type_Amji.a();
      ColorNote localColorNote = this.jdField_a_of_type_Amji.a().getColorNote();
      if (localColorNote != null)
      {
        amhj.a().a(localColorNote.mServiceType, localColorNote.mSubType, true);
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
    if (this.jdField_a_of_type_Amji != null)
    {
      this.jdField_a_of_type_Amji.b();
      ColorNote localColorNote = this.jdField_a_of_type_Amji.a().getColorNote();
      if (localColorNote != null)
      {
        amhj.a().a(localColorNote.mServiceType, localColorNote.mSubType, false);
        if (this.jdField_a_of_type_Boolean)
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          bcql.a(localBaseApplication, 2, localBaseApplication.getString(2131690856), 2000).a();
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
    if (this.jdField_a_of_type_Amji != null) {
      this.jdField_a_of_type_Amji.c();
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
    amhj.a().a();
  }
  
  public void n()
  {
    amhj.a().b();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Amjh != null) {
      this.jdField_a_of_type_Amjh.c();
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Amji != null) {
      amiu.a(this.jdField_a_of_type_Amji.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgn
 * JD-Core Version:    0.7.0.1
 */