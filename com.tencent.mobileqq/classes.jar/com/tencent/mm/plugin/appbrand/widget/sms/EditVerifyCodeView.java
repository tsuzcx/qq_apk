package com.tencent.mm.plugin.appbrand.widget.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.o;

public class EditVerifyCodeView
  extends RelativeLayout
{
  View.OnKeyListener a = new EditVerifyCodeView.3(this);
  public EditVerifyCodeView.a b;
  private Context c;
  private StringBuilder d = new StringBuilder();
  private ImageView[] e = new ImageView[6];
  private TextView[] f = new TextView[6];
  private VerifyCodeEditText g;
  
  public EditVerifyCodeView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    String str = this.d.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mBuilder:");
    ((StringBuilder)localObject).append(this.d);
    o.d("MicroMsg.EditVerifyCodeView", ((StringBuilder)localObject).toString());
    int i = str.length();
    if ((i > 0) && (i <= 6))
    {
      localObject = this.f;
      int j = i - 1;
      localObject[j].setVisibility(0);
      char c1 = str.charAt(j);
      this.f[j].setText(String.valueOf(c1));
      this.e[j].setVisibility(4);
    }
    if (i == 6)
    {
      localObject = this.b;
      if (localObject != null) {
        ((EditVerifyCodeView.a)localObject).a(str);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    b(paramContext);
  }
  
  private void b()
  {
    Object localObject = this.d.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("del before str:");
    localStringBuilder.append(this.d);
    o.d("MicroMsg.EditVerifyCodeView", localStringBuilder.toString());
    int i = ((String)localObject).length();
    if (i == 0) {
      return;
    }
    if ((i > 0) && (i <= 6))
    {
      localObject = this.d;
      int j = i - 1;
      ((StringBuilder)localObject).delete(j, i);
      this.f[j].setVisibility(4);
      this.f[j].setText("");
      this.e[j].setVisibility(0);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("del after str:");
    ((StringBuilder)localObject).append(this.d);
    o.d("MicroMsg.EditVerifyCodeView", ((StringBuilder)localObject).toString());
  }
  
  @SuppressLint({"InflateParams"})
  private void b(Context paramContext)
  {
    this.c = paramContext;
    paramContext = LayoutInflater.from(this.c).inflate(2131624742, null);
    Object localObject1 = (TextView)paramContext.findViewById(2131430915);
    Object localObject2 = (TextView)paramContext.findViewById(2131430916);
    Object localObject3 = (TextView)paramContext.findViewById(2131430917);
    Object localObject4 = (TextView)paramContext.findViewById(2131430918);
    Object localObject5 = (TextView)paramContext.findViewById(2131430919);
    Object localObject6 = (TextView)paramContext.findViewById(2131430920);
    Object localObject7 = this.f;
    localObject7[0] = localObject1;
    localObject7[1] = localObject2;
    localObject7[2] = localObject3;
    localObject7[3] = localObject4;
    localObject7[4] = localObject5;
    localObject7[5] = localObject6;
    localObject1 = (ImageView)paramContext.findViewById(2131430909);
    localObject2 = (ImageView)paramContext.findViewById(2131430910);
    localObject3 = (ImageView)paramContext.findViewById(2131430911);
    localObject4 = (ImageView)paramContext.findViewById(2131430912);
    localObject5 = (ImageView)paramContext.findViewById(2131430913);
    localObject6 = (ImageView)paramContext.findViewById(2131430914);
    localObject7 = this.e;
    localObject7[0] = localObject1;
    localObject7[1] = localObject2;
    localObject7[2] = localObject3;
    localObject7[3] = localObject4;
    localObject7[4] = localObject5;
    localObject7[5] = localObject6;
    this.g = ((VerifyCodeEditText)paramContext.findViewById(2131449351));
    this.g.addTextChangedListener(new EditVerifyCodeView.1(this));
    this.g.setKeyListener(new EditVerifyCodeView.2(this));
    this.g.setOnKeyListener(this.a);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private void c()
  {
    String str = this.d.toString();
    int j = str.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mBuilder:");
    localStringBuilder.append(this.d);
    o.d("MicroMsg.EditVerifyCodeView", localStringBuilder.toString());
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        this.f[i].setVisibility(0);
        char c1 = str.charAt(i);
        this.f[i].setText(String.valueOf(c1));
        this.e[i].setVisibility(4);
        i += 1;
      }
    }
    int i = 0;
    while (i < 6)
    {
      this.f[i].setVisibility(4);
      this.f[i].setText("");
      this.e[i].setVisibility(0);
      i += 1;
    }
  }
  
  public VerifyCodeEditText getEditText()
  {
    return this.g;
  }
  
  public String getText()
  {
    return this.d.toString();
  }
  
  public void setCodeEditCompleListener(EditVerifyCodeView.a parama)
  {
    this.b = parama;
  }
  
  public void setText(String paramString)
  {
    StringBuilder localStringBuilder = this.d;
    localStringBuilder.delete(0, localStringBuilder.length());
    this.d.append(paramString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView
 * JD-Core Version:    0.7.0.1
 */