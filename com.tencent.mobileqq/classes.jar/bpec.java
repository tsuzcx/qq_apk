import android.graphics.Bitmap;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.JobSegment;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bpec
  extends bpen
  implements View.OnClickListener, bpab
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bpga jdField_a_of_type_Bpga;
  private bpqd jdField_a_of_type_Bpqd;
  private zld jdField_a_of_type_Zld;
  private zpu jdField_a_of_type_Zpu;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
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
  
  private void a(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_Zld = zlc.a(a(), 0, 0, null);
      this.jdField_a_of_type_Zld.a(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_Zld.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfzll = this.jdField_a_of_type_Zld.a();
        paramInt = 0;
        while (paramInt < arrayOfzll.length)
        {
          arrayOfzll[paramInt].a(localObject.a[paramInt]);
          paramInt += 1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Zld.a().a());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Zld.a());
        this.jdField_a_of_type_Zld.d(true);
        if (this.jdField_a_of_type_Zpu != null) {
          this.jdField_a_of_type_Zpu.d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844517);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        zll[] arrayOfzll;
        return;
        this.jdField_a_of_type_Zld.a().b(anni.a(2131702653));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setHint(anni.a(2131702666));
      }
    }
    this.jdField_a_of_type_Zpu = new zpu(a());
    this.jdField_a_of_type_Zpu.b(false);
    this.jdField_a_of_type_Zpu.a(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_Zpu.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_Zpu.a(((bpqj)localObject).a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject.a[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Zpu.a());
      this.jdField_a_of_type_Zpu.d(true);
      if (this.jdField_a_of_type_Zld != null) {
        this.jdField_a_of_type_Zld.d(false);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844517);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setHint(anni.a(2131702545));
    }
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
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372842));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381054));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375941));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368651));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363225).setOnClickListener(this);
    }
  }
  
  public JobSegment<bpsf, bpsf> a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return null;
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bpqd.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131368686));
    a(bpab.class, this);
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
        this.jdField_a_of_type_Bpep.a(0);
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
      return this.jdField_a_of_type_Bpga.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bpqd.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131381054: 
    case 2131375941: 
    case 2131368651: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.jdField_b_of_type_Int = 1000;
        a(1000);
        continue;
        this.jdField_b_of_type_Int = 1001;
        a(1001);
        continue;
        localObject = a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        if (this.jdField_b_of_type_Int == 1000)
        {
          this.jdField_a_of_type_Bpep.a(35, localObject);
        }
        else
        {
          ((Bundle)localObject).putInt("interact_type", this.jdField_b_of_type_Int);
          this.jdField_a_of_type_Bpep.a(38, localObject);
        }
      }
    }
    if (this.jdField_b_of_type_Int == 1000)
    {
      localObject = this.jdField_a_of_type_Zld.a();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].a(false);
        i += 1;
      }
      localObject = this.jdField_a_of_type_Zld.a();
      zll[] arrayOfzll = this.jdField_a_of_type_Zld.a();
      Rect[] arrayOfRect = new Rect[arrayOfzll.length];
      String[] arrayOfString = new String[arrayOfzll.length];
      i = 0;
      while (i < arrayOfzll.length)
      {
        arrayOfRect[i] = arrayOfzll[i].a();
        arrayOfString[i] = arrayOfzll[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_Bpga.a(a(this.jdField_a_of_type_Int), arrayOfString, (Bitmap)localObject, arrayOfRect, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bpep.a(0);
      break;
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_a_of_type_Zpu.c(false);
        localObject = a(this.jdField_a_of_type_Int);
        ((Bundle)localObject).putInt("interact_type", 1001);
        this.jdField_a_of_type_Bpqd.a((Bundle)localObject, new bpqj(this.jdField_a_of_type_Zpu.a(), this.jdField_a_of_type_Zpu.a(), this.jdField_a_of_type_Zpu.a(), false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpec
 * JD-Core Version:    0.7.0.1
 */