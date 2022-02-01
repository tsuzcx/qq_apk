package com.tencent.biz.qqcircle.widgets.pick;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

public class IphonePickerView
  extends LinearLayout
{
  public static int a = -7829368;
  private static int b = -12303292;
  private int c = 0;
  private Button d;
  private TextView e;
  private WheelView[] f;
  private IphonePickerView.InnerAdapter[] g;
  private IphonePickerView.IphonePickListener h;
  private IphonePickerView.PickerViewAdapter i;
  private AdapterView.OnItemSelectedListener j = new IphonePickerView.2(this);
  private VerticalGallery.OnSelectViewDataUpdateListener k = new IphonePickerView.3(this);
  
  public IphonePickerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IphonePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        localWheelTextView = (WheelTextView)paramView;
        localWheelTextView.setTextSize(20.0F);
        localWheelTextView.setTextColor(a);
        paramView.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167058));
        return;
      }
      WheelTextView localWheelTextView = (WheelTextView)paramView;
      localWheelTextView.setTextSize(20.0F);
      localWheelTextView.setTextColor(b);
      paramView.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof WheelTextView))
    {
      paramView = (WheelTextView)paramView;
      paramView.setContentDescription(new StringBuilder(paramView.getText()));
    }
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    IphonePickerView.InnerAdapter localInnerAdapter = new IphonePickerView.InnerAdapter(this, paramInt, 25);
    this.f[paramInt] = paramWheelView;
    this.g[paramInt] = localInnerAdapter;
    paramWheelView.setAdapter(localInnerAdapter);
    paramWheelView.setOnItemSelectedListener(this.j);
    paramWheelView.setOnSelectViewDataUpdateListener(this.k);
    paramWheelView.setOnEndMovementListener(new IphonePickerView.EndMovementListener(this, paramInt));
  }
  
  public int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.f;
      if (paramInt < localObject.length) {
        return localObject[paramInt].getSelectedItemPosition();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void a(IphonePickerView.PickerViewAdapter paramPickerViewAdapter)
  {
    Object localObject1 = getContext().getResources();
    a = QCircleSkinHelper.getInstance().getColor(2131167084);
    b = QCircleSkinHelper.getInstance().getColor(2131167084);
    setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167058));
    Object localObject2 = findViewById(2131447375);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167050));
    }
    localObject2 = findViewById(2131437231);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167051));
    }
    localObject2 = findViewById(2131437214);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167051));
    }
    this.i = paramPickerViewAdapter;
    this.c = this.i.a();
    int m = this.c;
    if ((m > 0) && (m <= 3))
    {
      this.f = new WheelView[m];
      this.g = new IphonePickerView.InnerAdapter[m];
      this.d = ((Button)findViewById(2131447373));
      this.e = ((TextView)findViewById(2131447416));
      paramPickerViewAdapter = this.d;
      if (paramPickerViewAdapter != null) {
        paramPickerViewAdapter.setOnClickListener(new IphonePickerView.1(this));
      }
      paramPickerViewAdapter = (WheelView)findViewById(2131431635);
      localObject1 = (WheelView)findViewById(2131435192);
      localObject2 = (WheelView)findViewById(2131438752);
      a(paramPickerViewAdapter, 0);
      if (this.c < 2)
      {
        ((WheelView)localObject1).setVisibility(8);
      }
      else
      {
        ((WheelView)localObject1).setVisibility(0);
        a((WheelView)localObject1, 1);
      }
      if (this.c < 3)
      {
        ((WheelView)localObject2).setVisibility(8);
        return;
      }
      ((WheelView)localObject2).setVisibility(0);
      a((WheelView)localObject2, 2);
      return;
    }
    paramPickerViewAdapter = new StringBuilder();
    paramPickerViewAdapter.append("Unsupportted column count ");
    paramPickerViewAdapter.append(this.c);
    throw new RuntimeException(paramPickerViewAdapter.toString());
  }
  
  public void setPickListener(IphonePickerView.IphonePickListener paramIphonePickListener)
  {
    this.h = paramIphonePickListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      localObject = this.f;
      if (paramInt1 < localObject.length)
      {
        localObject[paramInt1].setSelection(paramInt2, true);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt1);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setTips(int paramInt)
  {
    this.e.setText(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.IphonePickerView
 * JD-Core Version:    0.7.0.1
 */