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

public class amgo
  implements amkl, amku
{
  private static SparseArrayCompat<amim> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private amgx jdField_a_of_type_Amgx;
  private amji jdField_a_of_type_Amji;
  private amjj jdField_a_of_type_Amjj;
  private amkj jdField_a_of_type_Amkj;
  private amkt jdField_a_of_type_Amkt;
  private SwipePostTableLayout jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ColorNoteController.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = true;
  private boolean d = true;
  
  public amgo(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public amgo(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, false, false, 2131165444);
  }
  
  public amgo(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramSwipePostTableLayout != null) {
        break label116;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = new SwipePostTableLayout(paramContext);
      if (paramBoolean3)
      {
        if (amkn.a()) {
          break label125;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setBackgroundResource(paramInt);
      }
    }
    for (;;)
    {
      this.c = paramBoolean2;
      if ((paramBoolean2) && (!paramBoolean1)) {
        this.jdField_a_of_type_Amji = new amji();
      }
      this.jdField_a_of_type_Amjj = new amjj(paramContext);
      amhk.a();
      return;
      label116:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = paramSwipePostTableLayout;
      break;
      label125:
      paramSwipePostTableLayout = (Activity)paramContext;
      if (!paramBoolean3) {}
      for (paramBoolean3 = bool;; paramBoolean3 = false)
      {
        this.jdField_a_of_type_Amkt = new amkt(paramSwipePostTableLayout, paramBoolean3);
        this.jdField_a_of_type_Amkt.a(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setTranslucentConvertor(this.jdField_a_of_type_Amkt);
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
  
  public amgo(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  public static amim a(ColorNote paramColorNote)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      q();
    }
    amim localamim = (amim)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramColorNote.getServiceType());
    paramColorNote = localamim;
    if (localamim == null) {
      paramColorNote = (amim)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(65536);
    }
    return paramColorNote;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    amkg.a(paramContext, 6, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    amhk.a().a(paramQQAppInterface, paramBoolean);
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
    switch (amhi.a(paramColorNote.getServiceType()))
    {
    default: 
      paramBundle = null;
      if (paramBundle != null)
      {
        if (!amhi.b(paramColorNote)) {
          break label301;
        }
        axqw.b(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", amgn.b(amhi.a(paramColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      paramBundle.a(paramContext, amhi.b(paramColorNote));
      bool = true;
      return bool;
      paramBundle = new amhw(paramBundle);
      break;
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("recent_note", amhi.b(paramColorNote));
      paramBundle = new amhu(localBundle);
      break;
      paramBundle = new amhr();
      break;
      paramBundle = new amho();
      break;
      paramBundle = new amhp();
      break;
      paramBundle = new amht();
      break;
      paramBundle = new amhm();
      break;
      paramBundle = new amhq();
      break;
      paramBundle = new amhv();
      break;
      paramBundle = new amhs();
      break;
      label301:
      axqw.b(null, "dc00898", "", "", "0X800A749", "0X800A749", amgn.a(paramColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return amhk.a().a();
  }
  
  public static void c(boolean paramBoolean)
  {
    amhk.a().a(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = true;
    int i = 0;
    if (this.jdField_a_of_type_Amgx != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      localObject = amhk.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_Amgx.a(((Point)localObject).x, ((Point)localObject).y);
      }
      if ((!c()) && ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f))) {
        break label231;
      }
      if ((this.jdField_a_of_type_Amkt == null) || (this.jdField_a_of_type_Amkt.a())) {
        break label145;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Amkj.onColorNoteAnimFinish();
      }
    }
    else
    {
      return;
    }
    this.b = true;
    this.jdField_a_of_type_Amkt.a();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    return;
    label145:
    this.b = false;
    Object localObject = this.jdField_a_of_type_Amjj.a();
    if (localObject != null)
    {
      localObject = ((amgw)localObject).getColorNote();
      if ((localObject == null) || (((ColorNote)localObject).mServiceType != 16842752)) {}
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localObject = this.jdField_a_of_type_Amgx;
      amkj localamkj = this.jdField_a_of_type_Amkj;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) {}
      for (;;)
      {
        ((amgx)localObject).a(localamkj, paramBoolean, i);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.getScrollX();
      }
      label231:
      this.jdField_a_of_type_Amkj.onColorNoteAnimFinish();
      return;
    }
  }
  
  private static void q()
  {
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(65536, new amil());
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(16908289, new amio());
  }
  
  public ColorNote a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new amhc().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
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
    if (this.jdField_a_of_type_Amji != null) {
      this.jdField_a_of_type_Amji.a();
    }
  }
  
  public void a(amgr paramamgr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnColorNoteCurdListener(paramamgr);
    }
    if (this.jdField_a_of_type_Amji != null) {
      this.jdField_a_of_type_Amji.a(paramamgr);
    }
    if (this.jdField_a_of_type_Amjj != null) {
      this.jdField_a_of_type_Amjj.a(paramamgr);
    }
    amhk.a().a(paramamgr);
  }
  
  public void a(amgw paramamgw)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setServiceInfo(paramamgw);
    }
    if (this.jdField_a_of_type_Amji != null) {
      this.jdField_a_of_type_Amji.a(paramamgw);
    }
    this.jdField_a_of_type_Amjj.a(paramamgw);
  }
  
  public void a(amkh paramamkh)
  {
    amhk.a().a(paramamkh);
  }
  
  public void a(amkj paramamkj)
  {
    this.jdField_a_of_type_Amkj = paramamkj;
  }
  
  public void a(amkq paramamkq)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnPageSwipeListener(paramamkq);
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
    this.jdField_a_of_type_Amjj.a(paramActivity);
    this.jdField_a_of_type_Amgx = new amgx(paramActivity);
    this.jdField_a_of_type_Amgx.a();
    amhk.a().a();
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Amjj != null)
    {
      this.jdField_a_of_type_Amjj.a(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteController", 2, "update color note from share entrance: " + paramColorNote.getServiceType() + ", " + paramColorNote.mSubType + ", " + paramColorNote.mMainTitle);
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = amhi.a(paramString);
    if (amhi.b(i)) {
      d(false);
    }
    while (amhi.a(i))
    {
      g();
      return;
      d(true);
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Amkt != null)) {
      this.jdField_a_of_type_Amkt.a();
    }
  }
  
  public boolean a()
  {
    return amhk.a().b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b();
    }
    if (this.jdField_a_of_type_Amji != null) {
      this.jdField_a_of_type_Amji.b();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Amjj != null) {
      return this.jdField_a_of_type_Amjj.a();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.c();
    }
    if (this.jdField_a_of_type_Amji != null) {
      this.jdField_a_of_type_Amji.b(this.d);
    }
    amhk.a().b();
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Amjj != null) {
      return this.jdField_a_of_type_Amjj.b();
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
    if (this.jdField_a_of_type_Amjj != null)
    {
      this.jdField_a_of_type_Amjj.a();
      ColorNote localColorNote = this.jdField_a_of_type_Amjj.a().getColorNote();
      if (localColorNote != null)
      {
        amhk.a().a(localColorNote.mServiceType, localColorNote.mSubType, true);
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
    if (this.jdField_a_of_type_Amjj != null)
    {
      this.jdField_a_of_type_Amjj.b();
      ColorNote localColorNote = this.jdField_a_of_type_Amjj.a().getColorNote();
      if (localColorNote != null)
      {
        amhk.a().a(localColorNote.mServiceType, localColorNote.mSubType, false);
        if (this.jdField_a_of_type_Boolean)
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          bcpw.a(localBaseApplication, 2, localBaseApplication.getString(2131690856), 2000).a();
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
    if (this.jdField_a_of_type_Amjj != null) {
      this.jdField_a_of_type_Amjj.c();
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
    amhk.a().a();
  }
  
  public void n()
  {
    amhk.a().b();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Amji != null) {
      this.jdField_a_of_type_Amji.c();
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Amjj != null) {
      amiv.a(this.jdField_a_of_type_Amjj.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgo
 * JD-Core Version:    0.7.0.1
 */