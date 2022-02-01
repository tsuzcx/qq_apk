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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoInteractFace.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bqfw
  extends bqgi
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, bqbw
{
  private int jdField_a_of_type_Int = 1000;
  private View jdField_a_of_type_AndroidViewView;
  private bqhv jdField_a_of_type_Bqhv;
  private bqry jdField_a_of_type_Bqry;
  private boolean jdField_a_of_type_Boolean;
  
  public bqfw(@NonNull bqgk parambqgk, @NonNull bqhv parambqhv, bqry parambqry)
  {
    super(parambqgk);
    this.jdField_a_of_type_Bqhv = parambqhv;
    this.jdField_a_of_type_Bqry = parambqry;
  }
  
  private Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    bqkh localbqkh = null;
    if (paramInt == 1000) {
      localbqkh = a().a;
    }
    while (localbqkh != null)
    {
      bqhv.a(localBundle, localbqkh);
      return localBundle;
      if (paramInt == 1001) {
        localbqkh = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  @NonNull
  private bqbv a()
  {
    bqbv localbqbv = (bqbv)a(bqbv.class);
    if (localbqbv == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localbqbv;
  }
  
  @NonNull
  private bqhz a()
  {
    bqhz localbqhz = (bqhz)a(bqhz.class);
    if (localbqhz == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localbqhz;
  }
  
  @NonNull
  private bqjr a()
  {
    bqbr localbqbr = (bqbr)a(bqbr.class);
    if (localbqbr == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbqbr.a().a();
  }
  
  @NonNull
  private bqkf a()
  {
    bqbr localbqbr = (bqbr)a(bqbr.class);
    if (localbqbr == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbqbr.a().a();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((bqkf)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((bqkf)localObject).f();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((bqkf)localObject).e();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((bqjr)localObject).a == null);
    if (paramBoolean)
    {
      ((bqjr)localObject).f();
      return;
    }
    ((bqjr)localObject).e();
  }
  
  public void a()
  {
    super.a();
    a(bqbw.class, this);
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bqgk.a.b != 0) {
      return;
    }
    this.jdField_a_of_type_Bqgk.a().a().postDelayed(new EditVideoInteractFace.1(this), 1000L);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    d();
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      a().b(paramInt, parambqua);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      a().a_(paramInt, parambqua);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData)
  {
    this.jdField_a_of_type_Int = paramInteractPasterParcelData.jdField_a_of_type_Int;
    Bitmap localBitmap = ((bpnf)bplq.a(15)).a();
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
      } while (this.jdField_a_of_type_Bqhv == null);
      this.jdField_a_of_type_Bqhv.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
      return;
    } while ((this.jdField_a_of_type_Int != 1001) || (this.jdField_a_of_type_Bqry == null));
    this.jdField_a_of_type_Bqry.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return this.jdField_a_of_type_Bqhv.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bqry.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((ViewGroup)this.jdField_a_of_type_Bqhs.a()).removeView(this.jdField_a_of_type_AndroidViewView);
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
      yup.a((Activity)paramView.getContext(), "sticker_element", "0", (String)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131381236: 
    case 2131381237: 
      localObject = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bqgk.a(35, localObject);
      a(1001, false);
      this.jdField_a_of_type_Int = 1000;
      if (paramView.getId() == 2131381236) {
        yup.b("clk_vote_entry", c(), 1, new String[0]);
      }
      for (;;)
      {
        localObject = "0";
        break;
        if (paramView.getId() == 2131381237) {
          yup.b("interact_cover", c(), 1, new String[0]);
        }
      }
    }
    Object localObject = a(this.jdField_a_of_type_Int);
    ((Bundle)localObject).putInt("interact_type", 1001);
    this.jdField_a_of_type_Bqgk.a(38, localObject);
    a(1000, false);
    this.jdField_a_of_type_Int = 1001;
    if (paramView.getId() == 2131376081) {
      yup.b("clk_vote_entry", c(), 2, new String[0]);
    }
    for (;;)
    {
      localObject = "1";
      break;
      if (paramView.getId() == 2131376082) {
        yup.b("interact_cover", c(), 2, new String[0]);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_Bqhs == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
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
      localObject = this.jdField_a_of_type_Bqgk.a(8L);
    } while (localObject == null);
    int i = ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth() / 2;
    int k = this.jdField_a_of_type_AndroidViewView.getWidth() * 107 / 230;
    this.jdField_a_of_type_AndroidViewView.setX(j + i - k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfw
 * JD-Core Version:    0.7.0.1
 */