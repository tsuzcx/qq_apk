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

public class bpeb
  extends bpen
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, bpab
{
  private int jdField_a_of_type_Int = 1000;
  private View jdField_a_of_type_AndroidViewView;
  private bpga jdField_a_of_type_Bpga;
  private bpqd jdField_a_of_type_Bpqd;
  private boolean jdField_a_of_type_Boolean;
  
  public bpeb(@NonNull bpep parambpep, @NonNull bpga parambpga, bpqd parambpqd)
  {
    super(parambpep);
    this.jdField_a_of_type_Bpga = parambpga;
    this.jdField_a_of_type_Bpqd = parambpqd;
  }
  
  private Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    bpim localbpim = null;
    if (paramInt == 1000) {
      localbpim = a().a;
    }
    while (localbpim != null)
    {
      bpga.a(localBundle, localbpim);
      return localBundle;
      if (paramInt == 1001) {
        localbpim = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  @NonNull
  private bpaa a()
  {
    bpaa localbpaa = (bpaa)a(bpaa.class);
    if (localbpaa == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localbpaa;
  }
  
  @NonNull
  private bpge a()
  {
    bpge localbpge = (bpge)a(bpge.class);
    if (localbpge == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localbpge;
  }
  
  @NonNull
  private bphw a()
  {
    bozw localbozw = (bozw)a(bozw.class);
    if (localbozw == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbozw.a().a();
  }
  
  @NonNull
  private bpik a()
  {
    bozw localbozw = (bozw)a(bozw.class);
    if (localbozw == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbozw.a().a();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((bpik)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((bpik)localObject).f();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((bpik)localObject).e();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((bphw)localObject).a == null);
    if (paramBoolean)
    {
      ((bphw)localObject).f();
      return;
    }
    ((bphw)localObject).e();
  }
  
  public void a()
  {
    super.a();
    a(bpab.class, this);
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bpep.a.b != 0) {
      return;
    }
    this.jdField_a_of_type_Bpep.a().a().postDelayed(new EditVideoInteractFace.1(this), 1000L);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    d();
  }
  
  public void a(int paramInt, @NonNull bpsf parambpsf)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      a().b(paramInt, parambpsf);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      a().a_(paramInt, parambpsf);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData)
  {
    this.jdField_a_of_type_Int = paramInteractPasterParcelData.jdField_a_of_type_Int;
    Bitmap localBitmap = ((bolk)bojv.a(15)).a();
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
      } while (this.jdField_a_of_type_Bpga == null);
      this.jdField_a_of_type_Bpga.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
      return;
    } while ((this.jdField_a_of_type_Int != 1001) || (this.jdField_a_of_type_Bpqd == null));
    this.jdField_a_of_type_Bpqd.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return this.jdField_a_of_type_Bpga.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bpqd.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((ViewGroup)this.jdField_a_of_type_Bpfx.a()).removeView(this.jdField_a_of_type_AndroidViewView);
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
      yqu.a((Activity)paramView.getContext(), "sticker_element", "0", (String)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131381054: 
    case 2131381055: 
      localObject = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bpep.a(35, localObject);
      a(1001, false);
      this.jdField_a_of_type_Int = 1000;
      if (paramView.getId() == 2131381054) {
        yqu.b("clk_vote_entry", c(), 1, new String[0]);
      }
      for (;;)
      {
        localObject = "0";
        break;
        if (paramView.getId() == 2131381055) {
          yqu.b("interact_cover", c(), 1, new String[0]);
        }
      }
    }
    Object localObject = a(this.jdField_a_of_type_Int);
    ((Bundle)localObject).putInt("interact_type", 1001);
    this.jdField_a_of_type_Bpep.a(38, localObject);
    a(1000, false);
    this.jdField_a_of_type_Int = 1001;
    if (paramView.getId() == 2131375941) {
      yqu.b("clk_vote_entry", c(), 2, new String[0]);
    }
    for (;;)
    {
      localObject = "1";
      break;
      if (paramView.getId() == 2131375942) {
        yqu.b("interact_cover", c(), 2, new String[0]);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_Bpfx == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
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
      localObject = this.jdField_a_of_type_Bpep.a(8L);
    } while (localObject == null);
    int i = ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth() / 2;
    int k = this.jdField_a_of_type_AndroidViewView.getWidth() * 107 / 230;
    this.jdField_a_of_type_AndroidViewView.setX(j + i - k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpeb
 * JD-Core Version:    0.7.0.1
 */