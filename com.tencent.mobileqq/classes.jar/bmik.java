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

public class bmik
  extends bmiv
  implements View.OnClickListener, bmej
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmki jdField_a_of_type_Bmki;
  private bmul jdField_a_of_type_Bmul;
  private xnj jdField_a_of_type_Xnj;
  private xsa jdField_a_of_type_Xsa;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
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
  
  private void a(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_Xnj = xni.a(a(), 0, 0, null);
      this.jdField_a_of_type_Xnj.a(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_Xnj.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfxnr = this.jdField_a_of_type_Xnj.a();
        paramInt = 0;
        while (paramInt < arrayOfxnr.length)
        {
          arrayOfxnr[paramInt].a(localObject.a[paramInt]);
          paramInt += 1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Xnj.a().a());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Xnj.a());
        this.jdField_a_of_type_Xnj.d(true);
        if (this.jdField_a_of_type_Xsa != null) {
          this.jdField_a_of_type_Xsa.d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844048);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        xnr[] arrayOfxnr;
        return;
        this.jdField_a_of_type_Xnj.a().b(alpo.a(2131704244));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setHint(alpo.a(2131704257));
      }
    }
    this.jdField_a_of_type_Xsa = new xsa(a());
    this.jdField_a_of_type_Xsa.b(false);
    this.jdField_a_of_type_Xsa.a(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_Xsa.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_Xsa.a(((bmur)localObject).a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject.a[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Xsa.a());
      this.jdField_a_of_type_Xsa.d(true);
      if (this.jdField_a_of_type_Xnj != null) {
        this.jdField_a_of_type_Xnj.d(false);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844048);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setHint(alpo.a(2131704136));
    }
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
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372232));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380035));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375164));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368332));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363041).setOnClickListener(this);
    }
  }
  
  public JobSegment<bmwn, bmwn> a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return null;
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bmul.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131368368));
    a(bmej.class, this);
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
        this.jdField_a_of_type_Bmix.a(0);
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
      return this.jdField_a_of_type_Bmki.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bmul.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380035: 
      this.jdField_b_of_type_Int = 1000;
      a(1000);
      return;
    case 2131375164: 
      this.jdField_b_of_type_Int = 1001;
      a(1001);
      return;
    case 2131368332: 
      paramView = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_b_of_type_Int == 1000)
      {
        this.jdField_a_of_type_Bmix.a(35, paramView);
        return;
      }
      paramView.putInt("interact_type", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bmix.a(38, paramView);
      return;
    }
    if (this.jdField_b_of_type_Int == 1000)
    {
      paramView = this.jdField_a_of_type_Xnj.a();
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        paramView[i].a(false);
        i += 1;
      }
      paramView = this.jdField_a_of_type_Xnj.a();
      xnr[] arrayOfxnr = this.jdField_a_of_type_Xnj.a();
      Rect[] arrayOfRect = new Rect[arrayOfxnr.length];
      String[] arrayOfString = new String[arrayOfxnr.length];
      i = 0;
      while (i < arrayOfxnr.length)
      {
        arrayOfRect[i] = arrayOfxnr[i].a();
        arrayOfString[i] = arrayOfxnr[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_Bmki.a(a(this.jdField_a_of_type_Int), arrayOfString, paramView, arrayOfRect, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bmix.a(0);
      return;
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_a_of_type_Xsa.c(false);
        paramView = a(this.jdField_a_of_type_Int);
        paramView.putInt("interact_type", 1001);
        this.jdField_a_of_type_Bmul.a(paramView, new bmur(this.jdField_a_of_type_Xsa.a(), this.jdField_a_of_type_Xsa.a(), this.jdField_a_of_type_Xsa.a(), false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmik
 * JD-Core Version:    0.7.0.1
 */