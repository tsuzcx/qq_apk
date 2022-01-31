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

public class bjwi
  extends bjwu
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, bjsi
{
  private int jdField_a_of_type_Int = 1000;
  private View jdField_a_of_type_AndroidViewView;
  private bjyh jdField_a_of_type_Bjyh;
  private bkik jdField_a_of_type_Bkik;
  private boolean jdField_a_of_type_Boolean;
  
  public bjwi(@NonNull bjww parambjww, @NonNull bjyh parambjyh, bkik parambkik)
  {
    super(parambjww);
    this.jdField_a_of_type_Bjyh = parambjyh;
    this.jdField_a_of_type_Bkik = parambkik;
  }
  
  private Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    bkat localbkat = null;
    if (paramInt == 1000) {
      localbkat = a().a;
    }
    while (localbkat != null)
    {
      bjyh.a(localBundle, localbkat);
      return localBundle;
      if (paramInt == 1001) {
        localbkat = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  @NonNull
  private bjsh a()
  {
    bjsh localbjsh = (bjsh)a(bjsh.class);
    if (localbjsh == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localbjsh;
  }
  
  @NonNull
  private bjyl a()
  {
    bjyl localbjyl = (bjyl)a(bjyl.class);
    if (localbjyl == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localbjyl;
  }
  
  @NonNull
  private bkad a()
  {
    bjsd localbjsd = (bjsd)a(bjsd.class);
    if (localbjsd == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbjsd.a().a();
  }
  
  @NonNull
  private bkar a()
  {
    bjsd localbjsd = (bjsd)a(bjsd.class);
    if (localbjsd == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbjsd.a().a();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((bkar)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((bkar)localObject).f();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((bkar)localObject).e();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((bkad)localObject).a == null);
    if (paramBoolean)
    {
      ((bkad)localObject).f();
      return;
    }
    ((bkad)localObject).e();
  }
  
  public void a()
  {
    super.a();
    a(bjsi.class, this);
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bjww.a.b != 0) {
      return;
    }
    this.jdField_a_of_type_Bjww.a().a().postDelayed(new EditVideoInteractFace.1(this), 1000L);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    d();
  }
  
  public void a(int paramInt, @NonNull bkkm parambkkm)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      a().b(paramInt, parambkkm);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      a().a_(paramInt, parambkkm);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData)
  {
    this.jdField_a_of_type_Int = paramInteractPasterParcelData.jdField_a_of_type_Int;
    Bitmap localBitmap = ((bjbt)bjae.a(15)).a();
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
      } while (this.jdField_a_of_type_Bjyh == null);
      this.jdField_a_of_type_Bjyh.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
      return;
    } while ((this.jdField_a_of_type_Int != 1001) || (this.jdField_a_of_type_Bkik == null));
    this.jdField_a_of_type_Bkik.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return this.jdField_a_of_type_Bjyh.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bkik.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((ViewGroup)this.jdField_a_of_type_Bjye.a()).removeView(this.jdField_a_of_type_AndroidViewView);
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
      vel.a((Activity)paramView.getContext(), "sticker_element", "0", (String)localObject);
      return;
    case 2131379329: 
    case 2131379330: 
      localObject = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bjww.a(35, localObject);
      a(1001, false);
      this.jdField_a_of_type_Int = 1000;
      if (paramView.getId() == 2131379329) {
        vel.b("clk_vote_entry", c(), 1, new String[0]);
      }
      for (;;)
      {
        localObject = "0";
        break;
        if (paramView.getId() == 2131379330) {
          vel.b("interact_cover", c(), 1, new String[0]);
        }
      }
    }
    Object localObject = a(this.jdField_a_of_type_Int);
    ((Bundle)localObject).putInt("interact_type", 1001);
    this.jdField_a_of_type_Bjww.a(38, localObject);
    a(1000, false);
    this.jdField_a_of_type_Int = 1001;
    if (paramView.getId() == 2131374700) {
      vel.b("clk_vote_entry", c(), 2, new String[0]);
    }
    for (;;)
    {
      localObject = "1";
      break;
      if (paramView.getId() == 2131374701) {
        vel.b("interact_cover", c(), 2, new String[0]);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_Bjye == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
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
      localObject = this.jdField_a_of_type_Bjww.a(8L);
    } while (localObject == null);
    int i = ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth() / 2;
    int k = this.jdField_a_of_type_AndroidViewView.getWidth() * 107 / 230;
    this.jdField_a_of_type_AndroidViewView.setX(j + i - k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwi
 * JD-Core Version:    0.7.0.1
 */