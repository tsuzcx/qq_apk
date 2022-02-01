package com.tencent.biz.qqstory.utils;

import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Locale;

public class PollWidgetUtils$SingleOptionElement
  extends PollWidgetUtils.OptionElement
  implements View.OnTouchListener
{
  public static final int[] a = { 2131429951, 2131429952 };
  public static final int[] b = { 2130846010, 2130846013 };
  public static final int[] c = { 2130846011, 2130846014 };
  public static final int[] d = { 2131447206, 2131447207 };
  int e;
  TextView f;
  TextView g;
  public boolean h;
  
  public PollWidgetUtils$SingleOptionElement(PollWidgetUtils.WidgetWrapper paramWidgetWrapper, View paramView, int paramInt)
  {
    super(paramWidgetWrapper, paramView);
    this.e = paramInt;
    this.f = ((TextView)paramView.findViewById(a[paramInt]));
    this.g = ((TextView)paramView.findViewById(d[paramInt]));
    paramView.setOnTouchListener(this);
  }
  
  public void a(float paramFloat)
  {
    this.g.setText(String.format(Locale.getDefault(), "%.0f%%", new Object[] { Float.valueOf(paramFloat) }));
  }
  
  public void a(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      localCharSequence = this.f.getHint();
    } else {
      localCharSequence = paramCharSequence;
    }
    int j;
    if (this.g.getVisibility() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    float[] arrayOfFloat1;
    if (j != 0)
    {
      k = UIUtils.a(this.f.getContext(), 72.5F);
      arrayOfFloat1 = new float[3];
      float[] tmp67_65 = arrayOfFloat1;
      tmp67_65[0] = 21.0F;
      float[] tmp72_67 = tmp67_65;
      tmp72_67[1] = 18.0F;
      float[] tmp77_72 = tmp72_67;
      tmp77_72[2] = 14.0F;
      tmp77_72;
    }
    else
    {
      k = UIUtils.a(this.f.getContext(), 84.0F);
      arrayOfFloat1 = new float[2];
      float[] tmp107_105 = arrayOfFloat1;
      tmp107_105[0] = 28.0F;
      float[] tmp112_107 = tmp107_105;
      tmp112_107[1] = 21.0F;
      tmp112_107;
    }
    this.f.setMaxWidth(k);
    float[] arrayOfFloat2 = new float[localCharSequence.length()];
    Paint localPaint = new Paint(this.f.getPaint());
    int i1 = -1;
    int i = 0;
    for (;;)
    {
      m = i1;
      if (i >= arrayOfFloat1.length) {
        break label312;
      }
      localPaint.setTextSize(TypedValue.applyDimension(1, arrayOfFloat1[i], this.f.getResources().getDisplayMetrics()));
      localPaint.getTextWidths(localCharSequence.toString(), arrayOfFloat2);
      int i2 = arrayOfFloat2.length;
      m = 0;
      int n = 0;
      while (m < i2)
      {
        float f1 = arrayOfFloat2[m];
        n = (int)(n + f1);
        m += 1;
      }
      if ((n <= k) || (i == arrayOfFloat1.length - 1)) {
        break;
      }
      i += 1;
    }
    this.f.setTextSize(1, arrayOfFloat1[i]);
    this.f.setText(paramCharSequence);
    SLog.a("Q.qqstory.widget.PollWidgetUtils", "text size = %s", Float.valueOf(arrayOfFloat1[i]));
    int m = i;
    label312:
    paramCharSequence = PollWidgetUtils.a(this.f, 2);
    this.f.setText(paramCharSequence);
    if ((j != 0) && (m == arrayOfFloat1.length - 1)) {
      this.g.setTextSize(1, 20.0F);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    super.a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.setBackgroundResource(b[this.e]);
      this.f.setShadowLayer(0.01F, 0.0F, 2.0F, -35568);
      this.f.setTextColor(-1);
      this.g.setShadowLayer(0.01F, 0.0F, 2.0F, -35568);
      this.g.setTextColor(-1);
      return;
    }
    if (this.h) {
      this.j.setBackgroundResource(0);
    } else {
      this.j.setBackgroundResource(c[this.e]);
    }
    this.f.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.f.setTextColor(-16777216);
    this.g.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.g.setTextColor(-16777216);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.g.getVisibility() != 0))
    {
      this.g.setVisibility(0);
      a(this.f.getText());
      return;
    }
    if ((!paramBoolean) && (this.g.getVisibility() == 0))
    {
      this.g.setVisibility(8);
      a(this.f.getText());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!b()) && (this.k != null) && (this.i.g()))
    {
      int i = paramMotionEvent.getActionMasked();
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              break label119;
            }
          }
          else
          {
            if ((paramMotionEvent.getX() >= 0.0F) && (paramMotionEvent.getX() <= paramView.getWidth()) && (paramMotionEvent.getY() >= 0.0F) && (paramMotionEvent.getY() <= paramView.getHeight())) {
              break label119;
            }
            b(false);
            break label119;
          }
        }
        b(false);
      }
      else
      {
        b(true);
      }
      label119:
      return paramView.onTouchEvent(paramMotionEvent);
    }
    return paramView.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.SingleOptionElement
 * JD-Core Version:    0.7.0.1
 */