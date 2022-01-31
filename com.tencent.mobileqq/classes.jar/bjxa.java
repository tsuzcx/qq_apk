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

public class bjxa
  extends bjxl
  implements View.OnClickListener, bjsz
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjyy jdField_a_of_type_Bjyy;
  private bkjb jdField_a_of_type_Bkjb;
  private vyr jdField_a_of_type_Vyr;
  private wdi jdField_a_of_type_Wdi;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
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
  
  private void a(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_Vyr = vyq.a(a(), 0, 0, null);
      this.jdField_a_of_type_Vyr.a(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_Vyr.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfvyz = this.jdField_a_of_type_Vyr.a();
        paramInt = 0;
        while (paramInt < arrayOfvyz.length)
        {
          arrayOfvyz[paramInt].a(localObject.a[paramInt]);
          paramInt += 1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vyr.a().a());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Vyr.a());
        this.jdField_a_of_type_Vyr.d(true);
        if (this.jdField_a_of_type_Wdi != null) {
          this.jdField_a_of_type_Wdi.d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843690);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        vyz[] arrayOfvyz;
        return;
        this.jdField_a_of_type_Vyr.a().b(ajya.a(2131703872));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setHint(ajya.a(2131703885));
      }
    }
    this.jdField_a_of_type_Wdi = new wdi(a());
    this.jdField_a_of_type_Wdi.b(false);
    this.jdField_a_of_type_Wdi.a(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_Wdi.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_Wdi.a(((bkjh)localObject).a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject.a[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Wdi.a());
      this.jdField_a_of_type_Wdi.d(true);
      if (this.jdField_a_of_type_Vyr != null) {
        this.jdField_a_of_type_Vyr.d(false);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843690);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setHint(ajya.a(2131703764));
    }
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
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371913));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379334));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374702));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368186));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363005).setOnClickListener(this);
    }
  }
  
  public JobSegment<bkld, bkld> a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return null;
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bkjb.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131368222));
    a(bjsz.class, this);
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
        this.jdField_a_of_type_Bjxn.a(0);
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
      return this.jdField_a_of_type_Bjyy.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bkjb.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379334: 
      this.jdField_b_of_type_Int = 1000;
      a(1000);
      return;
    case 2131374702: 
      this.jdField_b_of_type_Int = 1001;
      a(1001);
      return;
    case 2131368186: 
      paramView = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_b_of_type_Int == 1000)
      {
        this.jdField_a_of_type_Bjxn.a(35, paramView);
        return;
      }
      paramView.putInt("interact_type", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bjxn.a(38, paramView);
      return;
    }
    if (this.jdField_b_of_type_Int == 1000)
    {
      paramView = this.jdField_a_of_type_Vyr.a();
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        paramView[i].a(false);
        i += 1;
      }
      paramView = this.jdField_a_of_type_Vyr.a();
      vyz[] arrayOfvyz = this.jdField_a_of_type_Vyr.a();
      Rect[] arrayOfRect = new Rect[arrayOfvyz.length];
      String[] arrayOfString = new String[arrayOfvyz.length];
      i = 0;
      while (i < arrayOfvyz.length)
      {
        arrayOfRect[i] = arrayOfvyz[i].a();
        arrayOfString[i] = arrayOfvyz[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_Bjyy.a(a(this.jdField_a_of_type_Int), arrayOfString, paramView, arrayOfRect, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bjxn.a(0);
      return;
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_a_of_type_Wdi.c(false);
        paramView = a(this.jdField_a_of_type_Int);
        paramView.putInt("interact_type", 1001);
        this.jdField_a_of_type_Bkjb.a(paramView, new bkjh(this.jdField_a_of_type_Wdi.a(), this.jdField_a_of_type_Wdi.a(), this.jdField_a_of_type_Wdi.a(), false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxa
 * JD-Core Version:    0.7.0.1
 */