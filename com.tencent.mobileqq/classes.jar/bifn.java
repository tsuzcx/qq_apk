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

public class bifn
  extends bifz
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, bibl
{
  private int jdField_a_of_type_Int = 1000;
  private View jdField_a_of_type_AndroidViewView;
  private bihm jdField_a_of_type_Bihm;
  private birw jdField_a_of_type_Birw;
  private boolean jdField_a_of_type_Boolean;
  
  public bifn(@NonNull bigb parambigb, @NonNull bihm parambihm, birw parambirw)
  {
    super(parambigb);
    this.jdField_a_of_type_Bihm = parambihm;
    this.jdField_a_of_type_Birw = parambirw;
  }
  
  private Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    bijy localbijy = null;
    if (paramInt == 1000) {
      localbijy = a().a;
    }
    while (localbijy != null)
    {
      bihm.a(localBundle, localbijy);
      return localBundle;
      if (paramInt == 1001) {
        localbijy = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  @NonNull
  private bibk a()
  {
    bibk localbibk = (bibk)a(bibk.class);
    if (localbibk == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localbibk;
  }
  
  @NonNull
  private bihq a()
  {
    bihq localbihq = (bihq)a(bihq.class);
    if (localbihq == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localbihq;
  }
  
  @NonNull
  private biji a()
  {
    bibg localbibg = (bibg)a(bibg.class);
    if (localbibg == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbibg.a().a();
  }
  
  @NonNull
  private bijw a()
  {
    bibg localbibg = (bibg)a(bibg.class);
    if (localbibg == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbibg.a().a();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((bijw)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((bijw)localObject).f();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((bijw)localObject).e();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((biji)localObject).a == null);
    if (paramBoolean)
    {
      ((biji)localObject).f();
      return;
    }
    ((biji)localObject).e();
  }
  
  public void a()
  {
    super.a();
    a(bibl.class, this);
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bigb.a.b != 0) {
      return;
    }
    this.jdField_a_of_type_Bigb.a().a().postDelayed(new EditVideoInteractFace.1(this), 1000L);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    d();
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      a().b(paramInt, parambitz);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      a().a_(paramInt, parambitz);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData)
  {
    this.jdField_a_of_type_Int = paramInteractPasterParcelData.jdField_a_of_type_Int;
    Bitmap localBitmap = ((bhhb)bhfm.a(15)).a();
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
      } while (this.jdField_a_of_type_Bihm == null);
      this.jdField_a_of_type_Bihm.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
      return;
    } while ((this.jdField_a_of_type_Int != 1001) || (this.jdField_a_of_type_Birw == null));
    this.jdField_a_of_type_Birw.a(paramInteractPasterParcelData.jdField_a_of_type_ArrayOfJavaLangString, localBitmap, paramInteractPasterParcelData.jdField_a_of_type_ArrayOfAndroidGraphicsRect, paramInteractPasterParcelData.jdField_a_of_type_Float, paramInteractPasterParcelData.b, paramInteractPasterParcelData.c, paramInteractPasterParcelData.d, false);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return this.jdField_a_of_type_Bihm.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Birw.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((ViewGroup)this.jdField_a_of_type_Bihj.a()).removeView(this.jdField_a_of_type_AndroidViewView);
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
      urp.a((Activity)paramView.getContext(), "sticker_element", "0", (String)localObject);
      return;
    case 2131313494: 
    case 2131313495: 
      localObject = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bigb.a(35, localObject);
      a(1001, false);
      this.jdField_a_of_type_Int = 1000;
      if (paramView.getId() == 2131313494) {
        urp.b("clk_vote_entry", c(), 1, new String[0]);
      }
      for (;;)
      {
        localObject = "0";
        break;
        if (paramView.getId() == 2131313495) {
          urp.b("interact_cover", c(), 1, new String[0]);
        }
      }
    }
    Object localObject = a(this.jdField_a_of_type_Int);
    ((Bundle)localObject).putInt("interact_type", 1001);
    this.jdField_a_of_type_Bigb.a(38, localObject);
    a(1000, false);
    this.jdField_a_of_type_Int = 1001;
    if (paramView.getId() == 2131308960) {
      urp.b("clk_vote_entry", c(), 2, new String[0]);
    }
    for (;;)
    {
      localObject = "1";
      break;
      if (paramView.getId() == 2131308961) {
        urp.b("interact_cover", c(), 2, new String[0]);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_Bihj == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
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
      localObject = this.jdField_a_of_type_Bigb.a(8L);
    } while (localObject == null);
    int i = ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth() / 2;
    int k = this.jdField_a_of_type_AndroidViewView.getWidth() * 107 / 230;
    this.jdField_a_of_type_AndroidViewView.setX(j + i - k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bifn
 * JD-Core Version:    0.7.0.1
 */