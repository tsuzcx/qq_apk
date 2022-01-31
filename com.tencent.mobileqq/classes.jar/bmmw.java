import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tribe.async.async.JobSegment;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bmmw
  extends bmnh
  implements View.OnClickListener, bmiv
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmou jdField_a_of_type_Bmou;
  private bmyx jdField_a_of_type_Bmyx;
  private xrs jdField_a_of_type_Xrs;
  private xwj jdField_a_of_type_Xwj;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  private Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    bmrg localbmrg = null;
    if (paramInt == 1000) {
      localbmrg = a().a;
    }
    while (localbmrg != null)
    {
      bmou.a(localBundle, localbmrg);
      return localBundle;
      if (paramInt == 1001) {
        localbmrg = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  @NonNull
  private bmiu a()
  {
    bmiu localbmiu = (bmiu)a(bmiu.class);
    if (localbmiu == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localbmiu;
  }
  
  @NonNull
  private bmoy a()
  {
    bmoy localbmoy = (bmoy)a(bmoy.class);
    if (localbmoy == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localbmoy;
  }
  
  @NonNull
  private bmqq a()
  {
    bmiq localbmiq = (bmiq)a(bmiq.class);
    if (localbmiq == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbmiq.a().a();
  }
  
  @NonNull
  private bmre a()
  {
    bmiq localbmiq = (bmiq)a(bmiq.class);
    if (localbmiq == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localbmiq.a().a();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_Xrs = xrr.a(a(), 0, 0, null);
      this.jdField_a_of_type_Xrs.a(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_Xrs.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfxsa = this.jdField_a_of_type_Xrs.a();
        paramInt = 0;
        while (paramInt < arrayOfxsa.length)
        {
          arrayOfxsa[paramInt].a(localObject.a[paramInt]);
          paramInt += 1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Xrs.a().a());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Xrs.a());
        this.jdField_a_of_type_Xrs.d(true);
        if (this.jdField_a_of_type_Xwj != null) {
          this.jdField_a_of_type_Xwj.d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844120);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        xsa[] arrayOfxsa;
        return;
        this.jdField_a_of_type_Xrs.a().b(alud.a(2131704256));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setHint(alud.a(2131704269));
      }
    }
    this.jdField_a_of_type_Xwj = new xwj(a());
    this.jdField_a_of_type_Xwj.b(false);
    this.jdField_a_of_type_Xwj.a(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_Xwj.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_Xwj.a(((bmzd)localObject).a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject.a[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Xwj.a());
      this.jdField_a_of_type_Xwj.d(true);
      if (this.jdField_a_of_type_Xrs != null) {
        this.jdField_a_of_type_Xrs.d(false);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844120);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setHint(alud.a(2131704148));
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((bmre)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((bmre)localObject).f();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((bmre)localObject).e();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((bmqq)localObject).a == null);
    if (paramBoolean)
    {
      ((bmqq)localObject).f();
      return;
    }
    ((bmqq)localObject).e();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372252));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380093));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375215));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368343));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363041).setOnClickListener(this);
    }
  }
  
  public JobSegment<bnaz, bnaz> a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return null;
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bmyx.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131368379));
    a(bmiv.class, this);
  }
  
  public void a(int paramInt, @NonNull bnaz parambnaz)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      a().b(paramInt, parambnaz);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      a().a_(paramInt, parambnaz);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData) {}
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_Bmnj.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      d();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(this.jdField_a_of_type_Int, false);
      a(this.jdField_a_of_type_Int);
      return;
      a(this.jdField_a_of_type_Int, true);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return this.jdField_a_of_type_Bmou.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bmyx.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380093: 
      this.jdField_b_of_type_Int = 1000;
      a(1000);
      return;
    case 2131375215: 
      this.jdField_b_of_type_Int = 1001;
      a(1001);
      return;
    case 2131368343: 
      paramView = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_b_of_type_Int == 1000)
      {
        this.jdField_a_of_type_Bmnj.a(35, paramView);
        return;
      }
      paramView.putInt("interact_type", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bmnj.a(38, paramView);
      return;
    }
    if (this.jdField_b_of_type_Int == 1000)
    {
      paramView = this.jdField_a_of_type_Xrs.a();
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        paramView[i].a(false);
        i += 1;
      }
      paramView = this.jdField_a_of_type_Xrs.a();
      xsa[] arrayOfxsa = this.jdField_a_of_type_Xrs.a();
      Rect[] arrayOfRect = new Rect[arrayOfxsa.length];
      String[] arrayOfString = new String[arrayOfxsa.length];
      i = 0;
      while (i < arrayOfxsa.length)
      {
        arrayOfRect[i] = arrayOfxsa[i].a();
        arrayOfString[i] = arrayOfxsa[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_Bmou.a(a(this.jdField_a_of_type_Int), arrayOfString, paramView, arrayOfRect, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bmnj.a(0);
      return;
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_a_of_type_Xwj.c(false);
        paramView = a(this.jdField_a_of_type_Int);
        paramView.putInt("interact_type", 1001);
        this.jdField_a_of_type_Bmyx.a(paramView, new bmzd(this.jdField_a_of_type_Xwj.a(), this.jdField_a_of_type_Xwj.a(), this.jdField_a_of_type_Xwj.a(), false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmw
 * JD-Core Version:    0.7.0.1
 */