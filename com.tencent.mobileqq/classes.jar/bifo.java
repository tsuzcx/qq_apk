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

public class bifo
  extends bifz
  implements View.OnClickListener, bibl
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bihm jdField_a_of_type_Bihm;
  private birw jdField_a_of_type_Birw;
  private vly jdField_a_of_type_Vly;
  private vqp jdField_a_of_type_Vqp;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
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
  
  private void a(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_Vly = vlx.a(a(), 0, 0, null);
      this.jdField_a_of_type_Vly.a(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_Vly.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfvmg = this.jdField_a_of_type_Vly.a();
        paramInt = 0;
        while (paramInt < arrayOfvmg.length)
        {
          arrayOfvmg[paramInt].a(localObject.a[paramInt]);
          paramInt += 1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vly.a().a());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Vly.a());
        this.jdField_a_of_type_Vly.d(true);
        if (this.jdField_a_of_type_Vqp != null) {
          this.jdField_a_of_type_Vqp.d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843606);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        vmg[] arrayOfvmg;
        return;
        this.jdField_a_of_type_Vly.a().b(ajjy.a(2131638076));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setHint(ajjy.a(2131638089));
      }
    }
    this.jdField_a_of_type_Vqp = new vqp(a());
    this.jdField_a_of_type_Vqp.b(false);
    this.jdField_a_of_type_Vqp.a(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_Vqp.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_Vqp.a(((bisc)localObject).a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject.a[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Vqp.a());
      this.jdField_a_of_type_Vqp.d(true);
      if (this.jdField_a_of_type_Vly != null) {
        this.jdField_a_of_type_Vly.d(false);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843606);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setHint(ajjy.a(2131637968));
    }
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
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131306217));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313494));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131308960));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302566));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297465).setOnClickListener(this);
    }
  }
  
  public JobSegment<bitz, bitz> a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return null;
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Birw.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131302600));
    a(bibl.class, this);
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
        this.jdField_a_of_type_Bigb.a(0);
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
      return this.jdField_a_of_type_Bihm.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Birw.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131313494: 
      this.jdField_b_of_type_Int = 1000;
      a(1000);
      return;
    case 2131308960: 
      this.jdField_b_of_type_Int = 1001;
      a(1001);
      return;
    case 2131302566: 
      paramView = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_b_of_type_Int == 1000)
      {
        this.jdField_a_of_type_Bigb.a(35, paramView);
        return;
      }
      paramView.putInt("interact_type", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bigb.a(38, paramView);
      return;
    }
    if (this.jdField_b_of_type_Int == 1000)
    {
      paramView = this.jdField_a_of_type_Vly.a();
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        paramView[i].a(false);
        i += 1;
      }
      paramView = this.jdField_a_of_type_Vly.a();
      vmg[] arrayOfvmg = this.jdField_a_of_type_Vly.a();
      Rect[] arrayOfRect = new Rect[arrayOfvmg.length];
      String[] arrayOfString = new String[arrayOfvmg.length];
      i = 0;
      while (i < arrayOfvmg.length)
      {
        arrayOfRect[i] = arrayOfvmg[i].a();
        arrayOfString[i] = arrayOfvmg[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_Bihm.a(a(this.jdField_a_of_type_Int), arrayOfString, paramView, arrayOfRect, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bigb.a(0);
      return;
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_a_of_type_Vqp.c(false);
        paramView = a(this.jdField_a_of_type_Int);
        paramView.putInt("interact_type", 1001);
        this.jdField_a_of_type_Birw.a(paramView, new bisc(this.jdField_a_of_type_Vqp.a(), this.jdField_a_of_type_Vqp.a(), this.jdField_a_of_type_Vqp.a(), false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bifo
 * JD-Core Version:    0.7.0.1
 */