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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class anxn
  implements aobi, aobr
{
  private static SparseArrayCompat<anzm> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private anxx jdField_a_of_type_Anxx;
  private aoai jdField_a_of_type_Aoai;
  private aoaj jdField_a_of_type_Aoaj;
  private aobg jdField_a_of_type_Aobg;
  private aobq jdField_a_of_type_Aobq;
  private SwipePostTableLayout jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ColorNoteController.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = true;
  private boolean d;
  
  public anxn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public anxn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, false, false, 2131165479);
  }
  
  public anxn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, paramBoolean3, false, paramBoolean4, paramInt);
  }
  
  public anxn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, @DrawableRes int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramSwipePostTableLayout != null) {
        break label124;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = new SwipePostTableLayout(paramContext);
      if (paramBoolean3)
      {
        if ((aobk.a()) && ((!paramBoolean4) || (Build.VERSION.SDK_INT != 26))) {
          break label133;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setBackgroundResource(paramInt);
      }
    }
    for (;;)
    {
      this.c = paramBoolean2;
      if ((paramBoolean2) && (!paramBoolean1)) {
        this.jdField_a_of_type_Aoai = new aoai();
      }
      this.jdField_a_of_type_Aoaj = new aoaj(paramContext);
      anyk.a();
      return;
      label124:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = paramSwipePostTableLayout;
      break;
      label133:
      paramSwipePostTableLayout = (Activity)paramContext;
      if (!paramBoolean3) {}
      for (paramBoolean3 = bool;; paramBoolean3 = false)
      {
        this.jdField_a_of_type_Aobq = new aobq(paramSwipePostTableLayout, paramBoolean3);
        this.jdField_a_of_type_Aobq.a(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setTranslucentConvertor(this.jdField_a_of_type_Aobq);
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
  
  public anxn(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  public static anzm a(ColorNote paramColorNote)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      r();
    }
    anzm localanzm = (anzm)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramColorNote.getServiceType());
    paramColorNote = localanzm;
    if (localanzm == null) {
      paramColorNote = (anzm)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(65536);
    }
    return paramColorNote;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    aobd.a(paramContext, 6, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    anyk.a().a(paramQQAppInterface, paramBoolean);
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
    switch (anyi.a(paramColorNote.getServiceType()))
    {
    default: 
      paramBundle = null;
      if (paramBundle != null)
      {
        if (!anyi.b(paramColorNote)) {
          break label301;
        }
        azmj.b(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", anxm.b(anyi.a(paramColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      paramBundle.a(paramContext, anyi.b(paramColorNote));
      bool = true;
      return bool;
      paramBundle = new anyw(paramBundle);
      break;
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("recent_note", anyi.b(paramColorNote));
      paramBundle = new anyu(localBundle);
      break;
      paramBundle = new anyr();
      break;
      paramBundle = new anyo();
      break;
      paramBundle = new anyp();
      break;
      paramBundle = new anyt();
      break;
      paramBundle = new anym();
      break;
      paramBundle = new anyq();
      break;
      paramBundle = new anyv();
      break;
      paramBundle = new anys();
      break;
      label301:
      azmj.b(null, "dc00898", "", "", "0X800A749", "0X800A749", anxm.a(paramColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return anyk.a().a();
  }
  
  public static void c(boolean paramBoolean)
  {
    anyk.a().a(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = true;
    int i = 0;
    if (this.jdField_a_of_type_Anxx != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      localObject = anyk.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_Anxx.a(((Point)localObject).x, ((Point)localObject).y);
      }
      if ((!c()) && ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f))) {
        break label231;
      }
      if ((this.jdField_a_of_type_Aobq == null) || (this.jdField_a_of_type_Aobq.a())) {
        break label145;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Aobg.onColorNoteAnimFinish();
      }
    }
    else
    {
      return;
    }
    this.b = true;
    this.jdField_a_of_type_Aobq.a();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    return;
    label145:
    this.b = false;
    Object localObject = this.jdField_a_of_type_Aoaj.a();
    if (localObject != null)
    {
      localObject = ((anxw)localObject).getColorNote();
      if ((localObject == null) || (((ColorNote)localObject).mServiceType != 16842752)) {}
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localObject = this.jdField_a_of_type_Anxx;
      aobg localaobg = this.jdField_a_of_type_Aobg;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) {}
      for (;;)
      {
        ((anxx)localObject).a(localaobg, paramBoolean, i);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.getScrollX();
      }
      label231:
      this.jdField_a_of_type_Aobg.onColorNoteAnimFinish();
      return;
    }
  }
  
  private static void r()
  {
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(65536, new anzl());
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(16908289, new anzo());
  }
  
  public ColorNote a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new anyc().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
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
    if (this.jdField_a_of_type_Aoai != null) {
      this.jdField_a_of_type_Aoai.a();
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
    this.jdField_a_of_type_Aoaj.a(paramActivity);
    this.jdField_a_of_type_Anxx = new anxx(paramActivity);
    this.jdField_a_of_type_Anxx.a();
    anyk.a().a();
  }
  
  public void a(anxq paramanxq)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnColorNoteCurdListener(paramanxq);
    }
    if (this.jdField_a_of_type_Aoai != null) {
      this.jdField_a_of_type_Aoai.a(paramanxq);
    }
    if (this.jdField_a_of_type_Aoaj != null) {
      this.jdField_a_of_type_Aoaj.a(paramanxq);
    }
    anyk.a().a(paramanxq);
  }
  
  public void a(anxw paramanxw)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setServiceInfo(paramanxw);
    }
    if (this.jdField_a_of_type_Aoai != null) {
      this.jdField_a_of_type_Aoai.a(paramanxw);
    }
    this.jdField_a_of_type_Aoaj.a(paramanxw);
  }
  
  public void a(aobe paramaobe)
  {
    anyk.a().a(paramaobe);
  }
  
  public void a(aobg paramaobg)
  {
    this.jdField_a_of_type_Aobg = paramaobg;
  }
  
  public void a(aobn paramaobn)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnPageSwipeListener(paramaobn);
    }
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Aoaj != null)
    {
      this.jdField_a_of_type_Aoaj.a(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteController", 2, "update color note from share entrance: " + paramColorNote.getServiceType() + ", " + paramColorNote.mSubType + ", " + paramColorNote.mMainTitle);
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = anyi.a(paramString);
    if (anyi.b(i)) {
      d(false);
    }
    while (anyi.a(i))
    {
      g();
      return;
      d(true);
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Aobq != null)) {
      this.jdField_a_of_type_Aobq.a();
    }
  }
  
  public boolean a()
  {
    return anyk.a().b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b();
    }
    if (this.jdField_a_of_type_Aoai != null) {
      this.jdField_a_of_type_Aoai.b();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aoaj != null) {
      return this.jdField_a_of_type_Aoaj.a();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.c();
    }
    if (this.jdField_a_of_type_Aoai != null) {
      this.jdField_a_of_type_Aoai.b(this.d);
    }
    anyk.a().b();
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Aoaj != null) {
      return this.jdField_a_of_type_Aoaj.b();
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
    if (this.jdField_a_of_type_Aoaj != null)
    {
      this.jdField_a_of_type_Aoaj.a();
      ColorNote localColorNote = this.jdField_a_of_type_Aoaj.a().getColorNote();
      if (localColorNote != null)
      {
        anyk.a().a(localColorNote.mServiceType, localColorNote.mSubType, true);
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
    if (this.jdField_a_of_type_Aoaj != null)
    {
      this.jdField_a_of_type_Aoaj.b();
      ColorNote localColorNote = this.jdField_a_of_type_Aoaj.a().getColorNote();
      if (localColorNote != null)
      {
        anyk.a().a(localColorNote.mServiceType, localColorNote.mSubType, false);
        if (this.jdField_a_of_type_Boolean)
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 2, localBaseApplication.getString(2131690908), 2000).a();
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
    if (this.jdField_a_of_type_Aoaj != null) {
      this.jdField_a_of_type_Aoaj.c();
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
    anyk.a().a();
  }
  
  public void n()
  {
    anyk.a().b();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Aoai != null) {
      this.jdField_a_of_type_Aoai.c();
    }
  }
  
  public void p()
  {
    this.d = false;
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_Aoaj != null) {
      anzv.a(this.jdField_a_of_type_Aoaj.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxn
 * JD-Core Version:    0.7.0.1
 */