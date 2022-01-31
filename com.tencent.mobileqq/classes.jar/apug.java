import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.view.AIOGalleryScene.1;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;

public class apug
  extends apui
  implements View.OnClickListener, beij
{
  public Activity a;
  public Intent a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public TextureView a;
  public View a;
  public ImageButton a;
  public RelativeLayout a;
  public apsx a;
  public apte a;
  public apud a;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public apug(Activity paramActivity, apte paramapte)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Apte = paramapte;
    super.a(this.jdField_a_of_type_Apte);
  }
  
  private void f(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null))
    {
      if (paramBoolean) {
        bjeh.c(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    else {
      return;
    }
    bjeh.b(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299132));
    if (this.jdField_a_of_type_Apte.a()) {
      this.jdField_a_of_type_AndroidViewTextureView = ((TextureView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299326));
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Apte.a.b());
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentWidgetGallery instanceof DragGallery)) {
      ((DragGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setGalleryScaleListener(this.jdField_a_of_type_Apud);
    }
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131299824));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_Apte.a.b.a());
    this.jdField_a_of_type_ComTencentWidgetDragView.a();
    apsr localapsr = this.jdField_a_of_type_Apte.a.a();
    if (localapsr != null) {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localapsr.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131307311));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    if (bjeh.b())
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
      localLayoutParams.addRule(10, -1);
      localLayoutParams.topMargin = bjeh.a;
    }
  }
  
  public void F()
  {
    Object localObject = this.jdField_a_of_type_Apte.a.a();
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
      if (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1) {
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        awqx.b(null, "dc00898", "", "", (String)localObject, (String)localObject, this.jdField_a_of_type_Apsx.c(), 0, "", "", "", "");
      }
      this.jdField_a_of_type_Apte.q();
      this.jdField_b_of_type_AndroidAppActivity.finish();
      return;
      if (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 2) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_Apsx.c() == 4) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      f(true);
    }
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().j();
    }
    this.jdField_a_of_type_Apte.f();
  }
  
  public void H() {}
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public apsr a(int paramInt)
  {
    return this.jdField_a_of_type_Apud.a(paramInt);
  }
  
  protected apud a(Context paramContext)
  {
    this.jdField_a_of_type_Apud = new apud(paramContext);
    this.jdField_a_of_type_Apud.a(this.jdField_a_of_type_Apte);
    if ((agdg.class.isInstance(this.jdField_a_of_type_Apud)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
      ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_Apud);
    }
    return this.jdField_a_of_type_Apud;
  }
  
  public apue a()
  {
    if (this.jdField_a_of_type_Apud != null) {
      return this.jdField_a_of_type_Apud.a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      f(false);
    }
    this.jdField_b_of_type_AndroidViewView.setAlpha(paramFloat);
    if ((paramFloat < 0.8F) && (this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().j();
    }
    this.jdField_a_of_type_Apte.a(false);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().b(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Apud.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 19002)
    {
      if (paramInt2 == -1) {
        this.jdField_b_of_type_AndroidAppActivity.setResult(-1, paramIntent);
      }
      this.jdField_b_of_type_AndroidAppActivity.finish();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt1 != 19000) {
                break;
              }
            } while (paramInt2 != -1);
            return;
            if (paramInt1 != 19005) {
              break;
            }
          } while (paramInt2 != -1);
          return;
        } while (paramInt1 == 103);
        super.a(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 != -1) || (paramInt1 != 0)) {
          break;
        }
        aptv.a(this.jdField_b_of_type_AndroidAppActivity, paramIntent.getExtras());
      } while ((this.jdField_a_of_type_Apte.a() == null) || (this.jdField_a_of_type_Apte.a().a() != 9501));
      this.jdField_b_of_type_AndroidAppActivity.finish();
      return;
    } while ((paramInt2 != -1) || (paramInt1 != 10001));
    bbmy.a(this.jdField_b_of_type_AndroidAppActivity, 2131653676, 0).a();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Apud.a(paramInt, paramBoolean);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Apsx = this.jdField_a_of_type_Apte.a();
    if (this.jdField_a_of_type_Apsx == null) {
      this.jdField_a_of_type_Apsx = new apsx(paramIntent);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().a(paramConfiguration);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    r();
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    if (this.jdField_a_of_type_Apud != null)
    {
      this.jdField_a_of_type_Apud.a(paramInt);
      this.jdField_a_of_type_Apte.a.a(paramInt);
      if (this.jdField_a_of_type_Apud.a() != null) {
        this.jdField_a_of_type_Apud.a().a(paramAdapterView, paramView, paramInt, paramLong);
      }
    }
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.e();
    }
  }
  
  public void a(boolean paramBoolean)
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
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
    case 82: 
      do
      {
        return super.a(paramInt, paramKeyEvent);
      } while ((this.jdField_a_of_type_Apud == null) || (this.jdField_a_of_type_Apud.a() == null));
      return this.jdField_a_of_type_Apud.a().a(paramInt, paramKeyEvent);
    }
    return c();
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      return this.jdField_a_of_type_Apud.a().a(paramAdapterView, paramView, paramInt, paramLong);
    }
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected RelativeLayout b()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_b_of_type_AndroidAppActivity).inflate(2131495046, null);
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null))
    {
      this.jdField_a_of_type_Apud.a().f();
      this.jdField_a_of_type_Apud.a().jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().c(paramInt);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Apud.a(paramInt, paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewTextureView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewTextureView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    super.c();
    s();
    b(true);
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null))
    {
      this.jdField_a_of_type_Apud.a().e();
      this.jdField_a_of_type_Apud.a().jdField_a_of_type_Boolean = false;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    TextureView localTextureView;
    if (this.jdField_a_of_type_AndroidViewTextureView != null)
    {
      localTextureView = this.jdField_a_of_type_AndroidViewTextureView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextureView.setVisibility(i);
      return;
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      f(false);
    }
    super.c();
    c(false);
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Apud != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Apud.a() != null) {
        bool1 = this.jdField_a_of_type_Apud.a().a();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    super.d();
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null))
    {
      this.jdField_a_of_type_Apud.a().g();
      this.jdField_a_of_type_Apud.a().b = true;
    }
    a(false);
    b(false);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    super.e();
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null))
    {
      this.jdField_a_of_type_Apud.a().k();
      this.jdField_a_of_type_Apud.a().b = false;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.getAnimation() != null)
      {
        this.jdField_a_of_type_AndroidViewView.getAnimation().cancel();
        this.jdField_a_of_type_AndroidViewView.setAnimation(null);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Apud.notifyDataSetChanged();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AIOGalleryScene.1(this), 1000L);
    }
  }
  
  public void i()
  {
    super.i();
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().p();
    }
    if (this.jdField_a_of_type_Apte.b(this.jdField_a_of_type_Apte.a())) {
      this.jdField_a_of_type_Apte.f();
    }
  }
  
  public void j()
  {
    super.j();
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().q();
    }
    if (this.jdField_a_of_type_Apte.b(this.jdField_a_of_type_Apte.a())) {
      this.jdField_a_of_type_Apte.a(true);
    }
  }
  
  public void k()
  {
    super.k();
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Boolean = false;
    f(true);
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Apud != null)
    {
      this.jdField_a_of_type_Apud.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Apte.a());
      apsm.a().a().c("AIOGalleryScene", 2, "notifyImageModelDataChanged");
    }
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().h();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      awqx.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    } while ((this.jdField_a_of_type_Apud == null) || (this.jdField_a_of_type_Apud.a() == null));
    apsm.a().a().a("AIOGalleryScene", 2, "onClick btn, showActionSheet");
    this.jdField_a_of_type_Apud.a().a(2);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    if ((this.jdField_a_of_type_Apud != null) && (this.jdField_a_of_type_Apud.a() != null)) {
      this.jdField_a_of_type_Apud.a().b(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apug
 * JD-Core Version:    0.7.0.1
 */