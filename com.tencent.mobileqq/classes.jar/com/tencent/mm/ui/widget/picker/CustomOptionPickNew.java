package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.ip.a;
import com.tencent.luggage.wxa.ir.c;
import com.tencent.luggage.wxa.it.b;
import com.tencent.luggage.wxa.it.d;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.Arrays;

public class CustomOptionPickNew
  extends FrameLayout
{
  private String[] a;
  private b<String> b;
  private Context c;
  private int d;
  private int e;
  
  public CustomOptionPickNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131952936));
    this.c = paramContext;
    this.b = new b(paramContext);
    init();
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131952936), paramAttributeSet);
    this.c = paramContext;
    this.b = new b(paramContext);
    init();
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    this.b = new b(paramContext);
    init();
  }
  
  private void setDividerColor(int paramInt)
  {
    this.b.d.c(paramInt);
  }
  
  public int currentIndex()
  {
    return getValue();
  }
  
  public String currentValue()
  {
    this.b.i();
    return this.a[this.d];
  }
  
  public int getValue()
  {
    this.b.i();
    return this.d;
  }
  
  public WheelView getView()
  {
    return this.b.j();
  }
  
  public void init()
  {
    new a(this.c, new CustomOptionPickNew.1(this)).b(this.e).a(ContextCompat.getColor(this.c, 2131165199)).a(this.b);
    setDividerHeight(this.c.getResources().getDimensionPixelSize(2131296955));
    setItemHeight(this.c.getResources().getDimensionPixelSize(2131296339));
    setDividerColor(ContextCompat.getColor(this.c, 2131165199));
    this.b.d.a(0, this.c.getResources().getDimensionPixelSize(2131296336), 0, this.c.getResources().getDimensionPixelSize(2131296336));
    this.b.d.c().b(ContextCompat.getColor(this.c, 2131165207)).a(this.c.getResources().getDimensionPixelSize(2131296336)).setBackgroundColor(ContextCompat.getColor(this.c, 2131165193));
  }
  
  public void setDividerHeight(float paramFloat)
  {
    this.b.a(paramFloat);
  }
  
  public void setItemHeight(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public void setOnValueChangedListener(c paramc)
  {
    this.b.a(paramc);
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
    this.b.a(Arrays.asList(paramArrayOfString));
  }
  
  public void setValue(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void updateSelectedItem(int paramInt)
  {
    this.b.j().setCurrentItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomOptionPickNew
 * JD-Core Version:    0.7.0.1
 */