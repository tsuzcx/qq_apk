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

public class bjwz
  extends bjxl
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, bjsz
{
  private int jdField_a_of_type_Int = 1000;
  private View jdField_a_of_type_AndroidViewView;
  private bjyy jdField_a_of_type_Bjyy;
  private bkjb jdField_a_of_type_Bkjb;
  private boolean jdField_a_of_type_Boolean;
  
  public bjwz(@NonNull bjxn parambjxn, @NonNull bjyy parambjyy, bkjb parambkjb)
  {
    super(parambjxn);
    this.jdField_a_of_type_Bjyy = parambjyy;
    this.jdField_a_of_type_Bkjb = parambkjb;
  }
  
  private Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    bkbk localbkbk = null;
    if (paramInt == 1000) {
      localbkbk = a().a;
    }
    while (localbkbk != null)
    {
      bjyy.a(localBundle, localbkbk);
      return localBundle;
      if (paramInt == 1001) {
        localbkbk = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  @NonNull
  private bjsy a()
  {
    bjsy localbjsy = (bjsy)a(bjsy.class);
    if (localbjsy == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localbjsy;
  }
  
  @NonNull
  private bjzc a()
  {
    bjzc localbjzc = (bjzc)a(bjzc.class);
    if (localbjzc == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localbjzc;
  }
  
  @NonNull
  private bkau a()
  {
    bjsu localbjsu = (bjsu)a(bjsu.class);
    if (localbjsu == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbjsu.a().a();
  }
  
  @NonNull
  private bkbi a()
  {
    bjsu localbjsu = (bjsu)a(bjsu.class);
    if (localbjsu == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbjsu.a().a();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((bkbi)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((bkbi)localObject).f();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((bkbi)localObject).e();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((bkau)localObject).a == null);
    if (paramBoolean)
    {
      ((bkau)localObject).f();
      return;
    }
    ((bkau)localObject).e();
  }
  
  public void a()
  {
    super.a();
    a(bjsz.class, this);
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bjxn.a.b != 0) {
      return;
    }
    this.jdField_a_of_type_Bjxn.a().a().postDelayed(new EditVideoInteractFace.1(this), 1000L);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    d();
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      a().b(paramInt, parambkld);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      a().a_(paramInt, parambkld);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData)
  {
    this.jdField_a_of_type_Int = paramInteractPasterParcelData.jdField_a_of_type_Int;
    Bitmap localBitmap = ((bjck)bjav.a(15)).a();
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
      } while (this.jdField_a_of_type_Bjyy == null);
      this.jdField_a_of_type_Bjyy.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
      return;
    } while ((this.jdField_a_of_type_Int != 1001) || (this.jdField_a_of_type_Bkjb == null));
    this.jdField_a_of_type_Bkjb.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return this.jdField_a_of_type_Bjyy.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bkjb.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((ViewGroup)this.jdField_a_of_type_Bjyv.a()).removeView(this.jdField_a_of_type_AndroidViewView);
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
      vei.a((Activity)paramView.getContext(), "sticker_element", "0", (String)localObject);
      return;
    case 2131379334: 
    case 2131379335: 
      localObject = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bjxn.a(35, localObject);
      a(1001, false);
      this.jdField_a_of_type_Int = 1000;
      if (paramView.getId() == 2131379334) {
        vei.b("clk_vote_entry", c(), 1, new String[0]);
      }
      for (;;)
      {
        localObject = "0";
        break;
        if (paramView.getId() == 2131379335) {
          vei.b("interact_cover", c(), 1, new String[0]);
        }
      }
    }
    Object localObject = a(this.jdField_a_of_type_Int);
    ((Bundle)localObject).putInt("interact_type", 1001);
    this.jdField_a_of_type_Bjxn.a(38, localObject);
    a(1000, false);
    this.jdField_a_of_type_Int = 1001;
    if (paramView.getId() == 2131374702) {
      vei.b("clk_vote_entry", c(), 2, new String[0]);
    }
    for (;;)
    {
      localObject = "1";
      break;
      if (paramView.getId() == 2131374703) {
        vei.b("interact_cover", c(), 2, new String[0]);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_Bjyv == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
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
      localObject = this.jdField_a_of_type_Bjxn.a(8L);
    } while (localObject == null);
    int i = ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth() / 2;
    int k = this.jdField_a_of_type_AndroidViewView.getWidth() * 107 / 230;
    this.jdField_a_of_type_AndroidViewView.setX(j + i - k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwz
 * JD-Core Version:    0.7.0.1
 */