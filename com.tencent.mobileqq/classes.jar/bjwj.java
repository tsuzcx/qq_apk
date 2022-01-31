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

public class bjwj
  extends bjwu
  implements View.OnClickListener, bjsi
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjyh jdField_a_of_type_Bjyh;
  private bkik jdField_a_of_type_Bkik;
  private vyu jdField_a_of_type_Vyu;
  private wdl jdField_a_of_type_Wdl;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
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
  
  private void a(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_Vyu = vyt.a(a(), 0, 0, null);
      this.jdField_a_of_type_Vyu.a(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_Vyu.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfvzc = this.jdField_a_of_type_Vyu.a();
        paramInt = 0;
        while (paramInt < arrayOfvzc.length)
        {
          arrayOfvzc[paramInt].a(localObject.a[paramInt]);
          paramInt += 1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vyu.a().a());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Vyu.a());
        this.jdField_a_of_type_Vyu.d(true);
        if (this.jdField_a_of_type_Wdl != null) {
          this.jdField_a_of_type_Wdl.d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843689);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        vzc[] arrayOfvzc;
        return;
        this.jdField_a_of_type_Vyu.a().b(ajyc.a(2131703861));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setHint(ajyc.a(2131703874));
      }
    }
    this.jdField_a_of_type_Wdl = new wdl(a());
    this.jdField_a_of_type_Wdl.b(false);
    this.jdField_a_of_type_Wdl.a(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_Wdl.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_Wdl.a(((bkiq)localObject).a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject.a[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Wdl.a());
      this.jdField_a_of_type_Wdl.d(true);
      if (this.jdField_a_of_type_Vyu != null) {
        this.jdField_a_of_type_Vyu.d(false);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843689);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setHint(ajyc.a(2131703753));
    }
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
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371913));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379329));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374700));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368186));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363006).setOnClickListener(this);
    }
  }
  
  public JobSegment<bkkm, bkkm> a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return null;
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bkik.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131368222));
    a(bjsi.class, this);
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
        this.jdField_a_of_type_Bjww.a(0);
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
      return this.jdField_a_of_type_Bjyh.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_Bkik.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379329: 
      this.jdField_b_of_type_Int = 1000;
      a(1000);
      return;
    case 2131374700: 
      this.jdField_b_of_type_Int = 1001;
      a(1001);
      return;
    case 2131368186: 
      paramView = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_b_of_type_Int == 1000)
      {
        this.jdField_a_of_type_Bjww.a(35, paramView);
        return;
      }
      paramView.putInt("interact_type", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bjww.a(38, paramView);
      return;
    }
    if (this.jdField_b_of_type_Int == 1000)
    {
      paramView = this.jdField_a_of_type_Vyu.a();
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        paramView[i].a(false);
        i += 1;
      }
      paramView = this.jdField_a_of_type_Vyu.a();
      vzc[] arrayOfvzc = this.jdField_a_of_type_Vyu.a();
      Rect[] arrayOfRect = new Rect[arrayOfvzc.length];
      String[] arrayOfString = new String[arrayOfvzc.length];
      i = 0;
      while (i < arrayOfvzc.length)
      {
        arrayOfRect[i] = arrayOfvzc[i].a();
        arrayOfString[i] = arrayOfvzc[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_Bjyh.a(a(this.jdField_a_of_type_Int), arrayOfString, paramView, arrayOfRect, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bjww.a(0);
      return;
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_a_of_type_Wdl.c(false);
        paramView = a(this.jdField_a_of_type_Int);
        paramView.putInt("interact_type", 1001);
        this.jdField_a_of_type_Bkik.a(paramView, new bkiq(this.jdField_a_of_type_Wdl.a(), this.jdField_a_of_type_Wdl.a(), this.jdField_a_of_type_Wdl.a(), false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwj
 * JD-Core Version:    0.7.0.1
 */