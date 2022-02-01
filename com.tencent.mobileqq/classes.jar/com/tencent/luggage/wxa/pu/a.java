package com.tencent.luggage.wxa.pu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class a
  extends LinearLayout
{
  private Context a;
  private int b = 0;
  private Button c;
  private Button d;
  private Button e;
  private Button f;
  private Button g;
  private Button h;
  private Button i;
  private Button j;
  private Button k;
  private Button l;
  private Button m;
  private ImageButton n;
  private EditText o;
  private View p;
  private boolean q;
  
  public a(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.p = LayoutInflater.from(paramContext).inflate(2131624245, this, true);
    paramContext = this.p;
    this.c = ((Button)paramContext.findViewById(2131447001));
    this.d = ((Button)paramContext.findViewById(2131447002));
    this.e = ((Button)paramContext.findViewById(2131447003));
    this.f = ((Button)paramContext.findViewById(2131447004));
    this.g = ((Button)paramContext.findViewById(2131447005));
    this.h = ((Button)paramContext.findViewById(2131447006));
    this.i = ((Button)paramContext.findViewById(2131447007));
    this.j = ((Button)paramContext.findViewById(2131447008));
    this.k = ((Button)paramContext.findViewById(2131447009));
    this.l = ((Button)paramContext.findViewById(2131447011));
    this.m = ((Button)paramContext.findViewById(2131447000));
    this.n = ((ImageButton)paramContext.findViewById(2131447010));
    paramContext = new a.1(this);
    if (Build.VERSION.SDK_INT >= 14)
    {
      this.c.setContentDescription("1");
      this.d.setContentDescription("2");
      this.e.setContentDescription("3");
      this.f.setContentDescription("4");
      this.g.setContentDescription("5");
      this.h.setContentDescription("6");
      this.i.setContentDescription("7");
      this.j.setContentDescription("8");
      this.k.setContentDescription("9");
      this.m.setContentDescription("0");
      this.l.setContentDescription("字母X");
      this.n.setContentDescription("删除");
    }
    this.c.setOnClickListener(paramContext);
    this.d.setOnClickListener(paramContext);
    this.e.setOnClickListener(paramContext);
    this.f.setOnClickListener(paramContext);
    this.g.setOnClickListener(paramContext);
    this.h.setOnClickListener(paramContext);
    this.i.setOnClickListener(paramContext);
    this.j.setOnClickListener(paramContext);
    this.k.setOnClickListener(paramContext);
    this.l.setOnClickListener(paramContext);
    this.m.setOnClickListener(paramContext);
    this.n.setOnClickListener(paramContext);
  }
  
  public void a()
  {
    this.q = true;
    this.c.setTextColor(getResources().getColor(2131165356));
    this.c.setBackgroundResource(2130838714);
    this.d.setTextColor(getResources().getColor(2131165356));
    this.d.setBackgroundResource(2130838714);
    this.e.setTextColor(getResources().getColor(2131165356));
    this.e.setBackgroundResource(2130838714);
    this.f.setTextColor(getResources().getColor(2131165356));
    this.f.setBackgroundResource(2130838714);
    this.g.setTextColor(getResources().getColor(2131165356));
    this.g.setBackgroundResource(2130838714);
    this.h.setTextColor(getResources().getColor(2131165356));
    this.h.setBackgroundResource(2130838714);
    this.i.setTextColor(getResources().getColor(2131165356));
    this.i.setBackgroundResource(2130838714);
    this.j.setTextColor(getResources().getColor(2131165356));
    this.j.setBackgroundResource(2130838714);
    this.k.setTextColor(getResources().getColor(2131165356));
    this.k.setBackgroundResource(2130838714);
    this.l.setTextColor(getResources().getColor(2131165356));
    this.l.setBackgroundResource(2130852801);
    this.m.setTextColor(getResources().getColor(2131165356));
    this.m.setBackgroundResource(2130838714);
    this.n.setBackgroundResource(2130852801);
    this.p.findViewById(2131445159).setBackgroundResource(2131165228);
    this.p.findViewById(2131432004).setBackgroundResource(2131165352);
    this.p.findViewById(2131432009).setBackgroundResource(2131165352);
    this.p.findViewById(2131432010).setBackgroundResource(2131165352);
    this.p.findViewById(2131432011).setBackgroundResource(2131165352);
    this.p.findViewById(2131432012).setBackgroundResource(2131165352);
    this.p.findViewById(2131432013).setBackgroundResource(2131165352);
    this.p.findViewById(2131432014).setBackgroundResource(2131165352);
    this.p.findViewById(2131432015).setBackgroundResource(2131165352);
    this.p.findViewById(2131432016).setBackgroundResource(2131165352);
    this.p.findViewById(2131432005).setBackgroundResource(2131165352);
    this.p.findViewById(2131432006).setBackgroundResource(2131165352);
    this.p.findViewById(2131432007).setBackgroundResource(2131165352);
    this.p.findViewById(2131432008).setBackgroundResource(2131165352);
  }
  
  public void setInputEditText(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      this.o = paramEditText;
      int i1 = this.o.getImeOptions();
      paramEditText = this.o.getImeActionLabel();
      if (!TextUtils.isEmpty(paramEditText)) {
        this.l.setText(paramEditText);
      }
      if (i1 != 1) {
        return;
      }
      this.b = 0;
      if (TextUtils.isEmpty(paramEditText)) {
        this.l.setText("");
      }
    }
  }
  
  public void setSecureAccessibility(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    this.m.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.c.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.d.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.e.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.f.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.g.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.h.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.i.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.j.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.k.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.l.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.n.setAccessibilityDelegate(paramAccessibilityDelegate);
  }
  
  public void setXMode(int paramInt)
  {
    this.b = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          this.b = 0;
          return;
        }
        this.l.setText(".");
        if (this.q)
        {
          this.l.setBackgroundResource(2130852801);
          return;
        }
        this.l.setBackgroundResource(2130852800);
        return;
      }
      this.l.setText("X");
      if (this.q)
      {
        this.l.setBackgroundResource(2130852801);
        return;
      }
      this.l.setBackgroundResource(2130852800);
      return;
    }
    this.l.setText("");
    if (this.q)
    {
      this.l.setBackgroundResource(2131165503);
      return;
    }
    this.l.setBackgroundResource(2131165500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pu.a
 * JD-Core Version:    0.7.0.1
 */