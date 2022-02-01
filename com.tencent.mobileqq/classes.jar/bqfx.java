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

public class bqfx
  extends bqgi
  implements View.OnClickListener, bqbw
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bqhv jdField_a_of_type_Bqhv;
  private bqry jdField_a_of_type_Bqry;
  private zoy jdField_a_of_type_Zoy;
  private ztp jdField_a_of_type_Ztp;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
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
  
  private void a(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_Zoy = zox.a(a(), 0, 0, null);
      this.jdField_a_of_type_Zoy.a(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_Zoy.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfzpg = this.jdField_a_of_type_Zoy.a();
        paramInt = 0;
        while (paramInt < arrayOfzpg.length)
        {
          arrayOfzpg[paramInt].a(localObject.a[paramInt]);
          paramInt += 1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Zoy.a().a());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Zoy.a());
        this.jdField_a_of_type_Zoy.d(true);
        if (this.jdField_a_of_type_Ztp != null) {
          this.jdField_a_of_type_Ztp.d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844531);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        zpg[] arrayOfzpg;
        return;
        this.jdField_a_of_type_Zoy.a().b(anzj.a(2131702760));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setHint(anzj.a(2131702773));
      }
    }
    this.jdField_a_of_type_Ztp = new ztp(a());
    this.jdField_a_of_type_Ztp.b(false);
    this.jdField_a_of_type_Ztp.a(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_Ztp.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_Ztp.a(((bqse)localObject).a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject.a[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Ztp.a());
      this.jdField_a_of_type_Ztp.d(true);
      if (this.jdField_a_of_type_Zoy != null) {
        this.jdField_a_of_type_Zoy.d(false);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844531);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setHint(anzj.a(2131702652));
    }
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
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372955));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381236));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376081));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368725));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363249).setOnClickListener(this);
    }
  }
  
  public JobSegment<bqua, bqua> a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return null;
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bqry.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131368760));
    a(bqbw.class, this);
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
        this.jdField_a_of_type_Bqgk.a(0);
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
      return this.jdField_a_of_type_Bqhv.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bqry.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131381236: 
    case 2131376081: 
    case 2131368725: 
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
          this.jdField_a_of_type_Bqgk.a(35, localObject);
        }
        else
        {
          ((Bundle)localObject).putInt("interact_type", this.jdField_b_of_type_Int);
          this.jdField_a_of_type_Bqgk.a(38, localObject);
        }
      }
    }
    if (this.jdField_b_of_type_Int == 1000)
    {
      localObject = this.jdField_a_of_type_Zoy.a();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].a(false);
        i += 1;
      }
      localObject = this.jdField_a_of_type_Zoy.a();
      zpg[] arrayOfzpg = this.jdField_a_of_type_Zoy.a();
      Rect[] arrayOfRect = new Rect[arrayOfzpg.length];
      String[] arrayOfString = new String[arrayOfzpg.length];
      i = 0;
      while (i < arrayOfzpg.length)
      {
        arrayOfRect[i] = arrayOfzpg[i].a();
        arrayOfString[i] = arrayOfzpg[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_Bqhv.a(a(this.jdField_a_of_type_Int), arrayOfString, (Bitmap)localObject, arrayOfRect, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bqgk.a(0);
      break;
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_a_of_type_Ztp.c(false);
        localObject = a(this.jdField_a_of_type_Int);
        ((Bundle)localObject).putInt("interact_type", 1001);
        this.jdField_a_of_type_Bqry.a((Bundle)localObject, new bqse(this.jdField_a_of_type_Ztp.a(), this.jdField_a_of_type_Ztp.a(), this.jdField_a_of_type_Ztp.a(), false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfx
 * JD-Core Version:    0.7.0.1
 */