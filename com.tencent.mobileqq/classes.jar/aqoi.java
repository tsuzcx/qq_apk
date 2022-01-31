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
import android.view.Window;
import android.view.WindowManager.LayoutParams;
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

public class aqoi
  extends aqok
  implements View.OnClickListener, bfqu
{
  public Activity a;
  public Intent a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public TextureView a;
  public View a;
  public ImageButton a;
  public RelativeLayout a;
  public aqmo a;
  public aqnf a;
  public aqof a;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public aqoi(Activity paramActivity, aqnf paramaqnf)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aqnf = paramaqnf;
    super.a(this.jdField_a_of_type_Aqnf);
  }
  
  private void f(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null))
    {
      if (paramBoolean)
      {
        localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
        localLayoutParams.flags |= 0x400;
        this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
      }
    }
    else {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
    localLayoutParams.flags &= 0xFFFFFBFF;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364691));
    if (this.jdField_a_of_type_Aqnf.a()) {
      this.jdField_a_of_type_AndroidViewTextureView = ((TextureView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364889));
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Aqnf.a.b());
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentWidgetGallery instanceof DragGallery)) {
      ((DragGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setGalleryScaleListener(this.jdField_a_of_type_Aqof);
    }
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131365403));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_Aqnf.a.b.a());
    this.jdField_a_of_type_ComTencentWidgetDragView.a();
    aqmi localaqmi = this.jdField_a_of_type_Aqnf.a.a();
    if (localaqmi != null) {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localaqmi.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373023));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    if (bkvi.b())
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
      localLayoutParams.addRule(10, -1);
      localLayoutParams.topMargin = bkvi.a;
    }
  }
  
  public void F()
  {
    Object localObject = this.jdField_a_of_type_Aqnf.a.a();
    if ((localObject != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
      if (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1) {
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        axqy.b(null, "dc00898", "", "", (String)localObject, (String)localObject, this.jdField_a_of_type_Aqmo.c(), 0, "", "", "", "");
      }
      this.jdField_a_of_type_Aqnf.q();
      this.jdField_b_of_type_AndroidAppActivity.finish();
      return;
      if (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 2) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_Aqmo.c() == 4) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      f(true);
    }
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().j();
    }
    this.jdField_a_of_type_Aqnf.f();
  }
  
  public void H() {}
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public aqmi a(int paramInt)
  {
    return this.jdField_a_of_type_Aqof.a(paramInt);
  }
  
  protected aqof a(Context paramContext)
  {
    this.jdField_a_of_type_Aqof = new aqof(paramContext);
    this.jdField_a_of_type_Aqof.a(this.jdField_a_of_type_Aqnf);
    if ((agpc.class.isInstance(this.jdField_a_of_type_Aqof)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
      ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_Aqof);
    }
    return this.jdField_a_of_type_Aqof;
  }
  
  public aqog a()
  {
    if (this.jdField_a_of_type_Aqof != null) {
      return this.jdField_a_of_type_Aqof.a();
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
    if ((paramFloat < 0.8F) && (this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().j();
    }
    this.jdField_a_of_type_Aqnf.a(false);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().b(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aqof.a(paramInt1, paramInt2);
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
            paramIntent = a();
          } while (paramIntent == null);
          paramIntent.n();
          return;
        } while (paramInt1 == 103);
        super.a(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 != -1) || (paramInt1 != 0)) {
          break;
        }
        aqnx.a(this.jdField_b_of_type_AndroidAppActivity, paramIntent.getExtras());
      } while ((this.jdField_a_of_type_Aqnf.a() == null) || (this.jdField_a_of_type_Aqnf.a().a() != 9501));
      this.jdField_b_of_type_AndroidAppActivity.finish();
      return;
    } while ((paramInt2 != -1) || (paramInt1 != 10001));
    bcql.a(this.jdField_b_of_type_AndroidAppActivity, 2131719571, 0).a();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aqof.a(paramInt, paramBoolean);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Aqmo = this.jdField_a_of_type_Aqnf.a();
    if (this.jdField_a_of_type_Aqmo == null) {
      this.jdField_a_of_type_Aqmo = new aqmo(paramIntent);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().a(paramConfiguration);
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
    if (this.jdField_a_of_type_Aqof != null)
    {
      this.jdField_a_of_type_Aqof.a(paramInt);
      this.jdField_a_of_type_Aqnf.a.a(paramInt);
      if (this.jdField_a_of_type_Aqof.a() != null) {
        this.jdField_a_of_type_Aqof.a().a(paramAdapterView, paramView, paramInt, paramLong);
      }
    }
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.e();
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
      } while ((this.jdField_a_of_type_Aqof == null) || (this.jdField_a_of_type_Aqof.a() == null));
      return this.jdField_a_of_type_Aqof.a().a(paramInt, paramKeyEvent);
    }
    return c();
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      return this.jdField_a_of_type_Aqof.a().a(paramAdapterView, paramView, paramInt, paramLong);
    }
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected RelativeLayout b()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_b_of_type_AndroidAppActivity).inflate(2131560619, null);
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null))
    {
      this.jdField_a_of_type_Aqof.a().f();
      this.jdField_a_of_type_Aqof.a().jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().c(paramInt);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aqof.a(paramInt, paramBoolean);
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
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null))
    {
      this.jdField_a_of_type_Aqof.a().e();
      this.jdField_a_of_type_Aqof.a().jdField_a_of_type_Boolean = false;
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
    if (this.jdField_a_of_type_Aqof != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Aqof.a() != null) {
        bool1 = this.jdField_a_of_type_Aqof.a().a();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    super.d();
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null))
    {
      this.jdField_a_of_type_Aqof.a().g();
      this.jdField_a_of_type_Aqof.a().b = true;
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
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null))
    {
      this.jdField_a_of_type_Aqof.a().k();
      this.jdField_a_of_type_Aqof.a().b = false;
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
    this.jdField_a_of_type_Aqof.notifyDataSetChanged();
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
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().q();
    }
    if (this.jdField_a_of_type_Aqnf.b(this.jdField_a_of_type_Aqnf.a())) {
      this.jdField_a_of_type_Aqnf.f();
    }
  }
  
  public void j()
  {
    super.j();
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().r();
    }
    if (this.jdField_a_of_type_Aqnf.b(this.jdField_a_of_type_Aqnf.a())) {
      this.jdField_a_of_type_Aqnf.a(true);
    }
  }
  
  public void k()
  {
    super.k();
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().d();
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
    if (this.jdField_a_of_type_Aqof != null)
    {
      this.jdField_a_of_type_Aqof.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Aqnf.a());
      aqmd.a().a().c("AIOGalleryScene", 2, "notifyImageModelDataChanged");
    }
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().h();
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
      axqy.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    } while ((this.jdField_a_of_type_Aqof == null) || (this.jdField_a_of_type_Aqof.a() == null));
    aqmd.a().a().a("AIOGalleryScene", 2, "onClick btn, showActionSheet");
    this.jdField_a_of_type_Aqof.a().a(2);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    if ((this.jdField_a_of_type_Aqof != null) && (this.jdField_a_of_type_Aqof.a() != null)) {
      this.jdField_a_of_type_Aqof.a().b(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqoi
 * JD-Core Version:    0.7.0.1
 */