import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;

public class aqoe
  extends aqol
  implements agpd
{
  public int a;
  public Activity a;
  public ImageButton a;
  public RelativeLayout a;
  public aqmm a;
  public bcuq a;
  public AIOGalleryBasePresenter a;
  public boolean a;
  public int b;
  public ImageButton b;
  public RelativeLayout b;
  public boolean b;
  public int c;
  private int d;
  
  public aqoe(Activity paramActivity, AIOGalleryBasePresenter paramAIOGalleryBasePresenter)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().widthPixels;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter = paramAIOGalleryBasePresenter;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public View a(int paramInt, aqmg paramaqmg)
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    int m = 4;
    QLog.d("AIOGalleryView", 2, "TimShareTest Class Name is " + getClass());
    if (this.jdField_a_of_type_Bcuq == null)
    {
      localObject1 = new bcvg();
      ((bcvg)localObject1).a = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_Bcuq = bcus.a((bcvg)localObject1);
      this.jdField_a_of_type_Bcuq.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692918));
    }
    this.jdField_a_of_type_Bcuq.a(0, 0, 0);
    this.jdField_a_of_type_Bcuq.a(new aqof(this));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a();
    if ((localObject1 != null) && (((aqmg)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {}
    int i;
    switch (((aqmg)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      label174:
      if ((localObject1 != null) && (((aqmg)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {}
      for (int j = ((aqmg)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_b_of_type_Int;; j = 0)
      {
        int k;
        if (j == 0)
        {
          k = 1;
          label203:
          j = m;
          switch (this.jdField_a_of_type_Aqmm.c())
          {
          default: 
            j = 0;
          case 3: 
            label242:
            if (this.jdField_a_of_type_Aqmm.c()) {
              j = 6;
            }
            break;
          }
        }
        for (;;)
        {
          if (paramInt == 2) {
            paramInt = 1;
          }
          for (;;)
          {
            axqw.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", i, 0, String.valueOf(k), String.valueOf(j), String.valueOf(paramInt), "");
            return;
            Object localObject2 = (AIOPicData)((aqmg)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
            if ((((AIOPicData)localObject2).jdField_b_of_type_Int != 1) || (!((AIOPicData)localObject2).k)) {
              break label534;
            }
            i = 2;
            break label174;
            i = 2;
            break label174;
            localObject2 = (AIOShortVideoData)((aqmg)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
            if (((AIOShortVideoData)localObject2).d == 0)
            {
              i = 4;
              break label174;
            }
            if (((AIOShortVideoData)localObject2).d != 1) {
              break;
            }
            i = 3;
            break label174;
            i = 5;
            break label174;
            if (j == 1)
            {
              k = 2;
              break label203;
            }
            if ((j == 1004) || (j == 1008) || (j == 1009) || (j == 1010) || (j == 1011) || (j == 1020) || (j == 1021) || (j == 1022) || (j == 1023) || (j == 1024) || (j == 1025) || (j == 1036) || (j == 10002) || (j == 10003) || (j == 10004))
            {
              k = 3;
              break label203;
            }
            k = 4;
            break label203;
            j = 1;
            break label242;
            j = 5;
            break label242;
            if (paramInt == 1) {
              paramInt = 2;
            } else {
              paramInt = 0;
            }
          }
        }
      }
      label534:
      i = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<bbje> paramArrayList)
  {
    bbje localbbje = new bbje();
    localbbje.a = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localbbje.jdField_b_of_type_Int = paramInt2;
    localbbje.c = paramInt3;
    localbbje.jdField_b_of_type_JavaLangString = paramString;
    paramArrayList.add(localbbje);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<bbje> paramArrayList)
  {
    bbje localbbje = new bbje();
    localbbje.a = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localbbje.jdField_b_of_type_Int = paramInt2;
    localbbje.c = paramInt3;
    localbbje.jdField_b_of_type_JavaLangString = "";
    paramArrayList.add(localbbje);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<bbje> paramArrayList, int paramInt4)
  {
    bbje localbbje = new bbje();
    localbbje.a = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localbbje.jdField_b_of_type_Int = paramInt2;
    localbbje.c = paramInt3;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localbbje.e = paramInt4;
    paramArrayList.add(localbbje);
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void a(int paramInt, View paramView, aqmg paramaqmg) {}
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    a(paramInt, null, null, paramView, paramBoolean);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean) {}
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      aqmb.a().a().a("AIOGalleryView", 4, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Aqmm = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a();
    if (this.jdField_a_of_type_Aqmm == null) {
      this.jdField_a_of_type_Aqmm = new aqmm(paramIntent);
    }
    this.c = (axnq.a(this.jdField_a_of_type_AndroidAppActivity) / 2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().heightPixels;
    if ((i != this.jdField_a_of_type_Int) || (j != this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_b_of_type_Int = j;
      URLDrawable.clearMemoryCache();
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    b(paramViewGroup);
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Aqmm.b())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.d()) {
        break label115;
      }
      h();
    }
    label115:
    label251:
    label254:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a().b(true);
        this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a().a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.h();
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.e();
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.g();
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.q();
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.p();
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(true);
      }
      return;
      int i = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b();
      if (this.jdField_a_of_type_Aqmm.f())
      {
        if (i - paramInt <= 0) {
          break label251;
        }
        if (paramInt > i - 25) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if ((i == 1) || (paramInt == 0) || (this.d == i)) {
          break label254;
        }
        aqmb.a().a().a("AIOGalleryView", 4, "[onItemSelected] loadMedias: mLastLoadCount=" + this.d);
        this.d = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b();
        this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(0);
        break;
        paramInt = 0;
        continue;
        if (paramInt < 25)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.h();
    if (this.jdField_a_of_type_Aqmm.f())
    {
      aqmg localaqmg = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a();
      if (localaqmg != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", aqnt.a(localaqmg.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData));
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      }
    }
    if (this.jdField_a_of_type_Aqmm.d()) {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidAppActivity.getIntent());
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a() != null)
        {
          a(3);
          aqmb.a().a().a("AIOGalleryView", 2, "onKeyDown, showActionSheet");
        }
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        aqmb.a().a().a("AIOGalleryView", 1, "onKeyDown showActionSheet exception = " + paramKeyEvent.getMessage());
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX()) > this.c)
    {
      aqmb.a().a().a("AIOGalleryView", 4, "onScrollHalfScreenWidth");
      c();
    }
    return false;
  }
  
  public boolean a(aqmg paramaqmg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a();
  }
  
  public boolean a(bfol parambfol, AIOPicData paramAIOPicData)
  {
    return false;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    axqw.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (this.jdField_a_of_type_Aqmm.c() == 4) {
      return true;
    }
    try
    {
      a(1);
      aqmb.a().a().a("AIOGalleryView", 2, "onItemLongClick, showActionSheet");
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        aqmb.a().a().a("AIOGalleryView", 1, "onItemLongClick showActionSheet exception: " + paramAdapterView.getMessage());
      }
    }
  }
  
  public boolean a(String paramString, AIOPicData paramAIOPicData, File paramFile)
  {
    return false;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramInt))) {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(false);
    }
  }
  
  public void b(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void b(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(true);
    if (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a() != null) {
      ((ProGallery)this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()).setGestureListener(this);
    }
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void b(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  boolean b()
  {
    return false;
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramInt))) {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.aF_();
  }
  
  boolean c()
  {
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.a(null);
      this.jdField_a_of_type_Bcuq.b();
    }
    bbbf.a().a();
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.q();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.c(paramBoolean);
    if (paramBoolean) {
      o();
    }
  }
  
  public boolean d()
  {
    return (!this.jdField_a_of_type_Aqmm.c()) && (this.jdField_a_of_type_Aqmm.a() != 1037) && (this.jdField_a_of_type_Aqmm.a() != 1044) && (akpy.a(this.jdField_a_of_type_Aqmm.a()) != 1032) && (this.jdField_a_of_type_Aqmm.c() != 3) && (this.jdField_a_of_type_Aqmm.c() != 4) && (this.jdField_a_of_type_Aqmm.h());
  }
  
  public void e()
  {
    aqmg localaqmg = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b();
    if (localaqmg != null) {
      localaqmg.jdField_a_of_type_Boolean = true;
    }
    if (!b()) {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(true);
    }
    if (this.jdField_a_of_type_Aqmm.c() == 4) {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(false);
    }
  }
  
  public void f()
  {
    if (!c()) {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(false);
    }
  }
  
  public void g()
  {
    if (!c()) {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(false);
    }
    d(false);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Aqmm.b()) {}
    int i;
    Gallery localGallery;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.c();
      localGallery = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a();
    } while ((localGallery == null) || (i == localGallery.getSelectedItemPosition()));
    localGallery.setSelection(i);
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  protected void l()
  {
    if (this.jdField_a_of_type_Aqmm.c() == 2) {}
    for (int i = 1;; i = 0)
    {
      aqmg localaqmg = this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.jdField_a_of_type_Aqnd.a.a();
      aqnv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqmm.c(), this.jdField_a_of_type_Aqmm.a(), localaqmg);
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772273, 2130772213);
      if (i == 0) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.jdField_a_of_type_Aqnd.m();
      return;
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryView", 2, "doQuitImmersion, basePresenter.isActionSheetVisibleBeforeImm = " + this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.jdField_b_of_type_Boolean + " , basePresenter.isActionSheetVisibleBeforeImm , basePresenter.isDanmakuVisibleBeforeImm = " + this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.c);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.c) {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.d(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.e();
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.g();
    d(true);
  }
  
  public void n()
  {
    this.jdField_a_of_type_Bcuq.b();
  }
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqoe
 * JD-Core Version:    0.7.0.1
 */