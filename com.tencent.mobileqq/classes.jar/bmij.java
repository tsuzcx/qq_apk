import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoInteractFace.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bmij
  extends bmiv
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, bmej
{
  private int jdField_a_of_type_Int = 1000;
  private View jdField_a_of_type_AndroidViewView;
  private bmki jdField_a_of_type_Bmki;
  private bmul jdField_a_of_type_Bmul;
  private boolean jdField_a_of_type_Boolean;
  
  public bmij(@NonNull bmix parambmix, @NonNull bmki parambmki, bmul parambmul)
  {
    super(parambmix);
    this.jdField_a_of_type_Bmki = parambmki;
    this.jdField_a_of_type_Bmul = parambmul;
  }
  
  private Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    bmmu localbmmu = null;
    if (paramInt == 1000) {
      localbmmu = a().a;
    }
    while (localbmmu != null)
    {
      bmki.a(localBundle, localbmmu);
      return localBundle;
      if (paramInt == 1001) {
        localbmmu = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  @NonNull
  private bmei a()
  {
    bmei localbmei = (bmei)a(bmei.class);
    if (localbmei == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localbmei;
  }
  
  @NonNull
  private bmkm a()
  {
    bmkm localbmkm = (bmkm)a(bmkm.class);
    if (localbmkm == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localbmkm;
  }
  
  @NonNull
  private bmme a()
  {
    bmee localbmee = (bmee)a(bmee.class);
    if (localbmee == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbmee.a().a();
  }
  
  @NonNull
  private bmms a()
  {
    bmee localbmee = (bmee)a(bmee.class);
    if (localbmee == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbmee.a().a();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((bmms)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((bmms)localObject).f();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((bmms)localObject).e();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((bmme)localObject).a == null);
    if (paramBoolean)
    {
      ((bmme)localObject).f();
      return;
    }
    ((bmme)localObject).e();
  }
  
  public void a()
  {
    super.a();
    a(bmej.class, this);
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bmix.a.b != 0) {
      return;
    }
    this.jdField_a_of_type_Bmix.a().a().postDelayed(new EditVideoInteractFace.1(this), 1000L);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    d();
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      a().b(paramInt, parambmwn);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      a().a_(paramInt, parambmwn);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData)
  {
    this.jdField_a_of_type_Int = paramInteractPasterParcelData.jdField_a_of_type_Int;
    Bitmap localBitmap = ((blnu)blmf.a(15)).a();
    if ((localBitmap == null) || (localBitmap.isRecycled())) {}
    do
    {
      do
      {
        return;
        localBitmap = Bitmap.createBitmap(localBitmap);
        if (this.jdField_a_of_type_Int != 1000) {
          break;
        }
      } while (this.jdField_a_of_type_Bmki == null);
      this.jdField_a_of_type_Bmki.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
      return;
    } while ((this.jdField_a_of_type_Int != 1001) || (this.jdField_a_of_type_Bmul == null));
    this.jdField_a_of_type_Bmul.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return this.jdField_a_of_type_Bmki.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bmul.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((ViewGroup)this.jdField_a_of_type_Bmkf.a()).removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void f()
  {
    super.f();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      localObject = null;
      wta.a((Activity)paramView.getContext(), "sticker_element", "0", (String)localObject);
      return;
    case 2131380035: 
    case 2131380036: 
      localObject = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bmix.a(35, localObject);
      a(1001, false);
      this.jdField_a_of_type_Int = 1000;
      if (paramView.getId() == 2131380035) {
        wta.b("clk_vote_entry", c(), 1, new String[0]);
      }
      for (;;)
      {
        localObject = "0";
        break;
        if (paramView.getId() == 2131380036) {
          wta.b("interact_cover", c(), 1, new String[0]);
        }
      }
    }
    Object localObject = a(this.jdField_a_of_type_Int);
    ((Bundle)localObject).putInt("interact_type", 1001);
    this.jdField_a_of_type_Bmix.a(38, localObject);
    a(1000, false);
    this.jdField_a_of_type_Int = 1001;
    if (paramView.getId() == 2131375164) {
      wta.b("clk_vote_entry", c(), 2, new String[0]);
    }
    for (;;)
    {
      localObject = "1";
      break;
      if (paramView.getId() == 2131375165) {
        wta.b("interact_cover", c(), 2, new String[0]);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_Bmkf == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoInteractFace", 2, "initTransitionRecommendView onGlobalLayout null");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
      }
      localObject = this.jdField_a_of_type_Bmix.a(8L);
    } while (localObject == null);
    int i = ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth() / 2;
    int k = this.jdField_a_of_type_AndroidViewView.getWidth() * 107 / 230;
    this.jdField_a_of_type_AndroidViewView.setX(j + i - k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmij
 * JD-Core Version:    0.7.0.1
 */