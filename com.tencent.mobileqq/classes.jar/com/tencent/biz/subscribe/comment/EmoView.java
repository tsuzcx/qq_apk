package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class EmoView
  extends LinearLayout
  implements KeyClickListener, WorkSpaceView.OnScreenChangeListener
{
  private int a = 2130839213;
  private int b = this.a;
  private WorkSpaceView c;
  private Activity d;
  private LinearLayout e;
  private WorkSpaceView.OnScreenChangeListener f;
  private EditText g;
  private Handler h;
  private boolean i = false;
  private final int j = 28;
  private EmoView.EmoClickListener k;
  private boolean[] l = { 1, 0, 0, 0 };
  private int m = 1;
  private int n = -1;
  private EmoView.EmoClickListener o = new EmoView.4(this);
  private boolean p = true;
  
  public EmoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    a();
  }
  
  private void a()
  {
    this.c = new WorkSpaceView(getContext());
    this.c.setOnScreenChangeListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 81;
    this.c.setLayoutParams(localLayoutParams);
    this.h = new EmoView.1(this);
    this.c.setHandler(this.h);
    this.e = new LinearLayout(getContext());
    this.e.setOrientation(0);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 81;
    this.e.setPadding(0, 13, 0, 13);
    this.e.setLayoutParams(localLayoutParams);
    super.addView(this.c);
    super.addView(this.e);
  }
  
  private static void a(EditText paramEditText, int paramInt, String paramString)
  {
    paramEditText.getText().insert(paramInt, paramString);
    String str = paramEditText.getText().toString();
    if (paramString.length() + paramInt > str.length())
    {
      paramEditText.setSelection(str.length());
      return;
    }
    paramEditText.setSelection(paramInt + paramString.length());
  }
  
  public static void a(EditText paramEditText, String paramString)
  {
    int i1 = paramEditText.getSelectionStart();
    if (i1 >= paramEditText.length()) {}
    try
    {
      paramEditText.append(paramString);
      return;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    a(paramEditText, i1, paramString);
    return;
    a(paramEditText, i1, paramString);
  }
  
  private void b(int paramInt)
  {
    double d1 = 27;
    Double.isNaN(d1);
    int i1 = (int)Math.ceil(107.0D / (d1 * 1.0D));
    GridView localGridView = (GridView)LayoutInflater.from(getContext()).inflate(2131624396, null);
    localGridView.setNumColumns(7);
    if (paramInt == i1) {
      i1 = 26;
    } else {
      i1 = 27;
    }
    EmoWindowAdapter localEmoWindowAdapter = new EmoWindowAdapter(getContext(), paramInt, i1, 28, paramInt, this);
    localGridView.setAdapter(localEmoWindowAdapter);
    localGridView.setColumnWidth(this.d.getWindowManager().getDefaultDisplay().getWidth() / 7);
    localGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtil.dip2px(196.0F)));
    this.c.addView(localGridView);
    postDelayed(new EmoView.2(this, paramInt, localGridView, localEmoWindowAdapter), 1000L);
    localGridView.setOnItemClickListener(new EmoView.3(this, paramInt));
  }
  
  private void setCurrentNavigation(int paramInt)
  {
    int i2 = this.e.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      this.e.getChildAt(i1).setSelected(false);
      i1 += 1;
    }
    View localView = this.e.getChildAt(paramInt);
    if (localView != null) {
      localView.setSelected(true);
    }
  }
  
  public void a(int paramInt)
  {
    this.m = (paramInt + 1);
    setCurrentNavigation(paramInt);
    WorkSpaceView.OnScreenChangeListener localOnScreenChangeListener = this.f;
    if (localOnScreenChangeListener != null) {
      localOnScreenChangeListener.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 27)
    {
      this.o.a();
      return;
    }
    paramInt1 = (paramInt2 - 1) * 27 + paramInt1;
    if (paramInt1 < 107)
    {
      String str = Patterns.e[EmoWindowAdapter.c[paramInt1]];
      this.o.a(str);
    }
  }
  
  public int getCurrentScreenIndex()
  {
    return this.c.getCurrentScreen();
  }
  
  public View getCurrentView()
  {
    WorkSpaceView localWorkSpaceView = this.c;
    return localWorkSpaceView.getChildAt(localWorkSpaceView.getCurrentScreen());
  }
  
  public void setNavgationVisible(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.e;
    if (localLinearLayout != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localLinearLayout.setVisibility(i1);
    }
  }
  
  public void setOnScreenChangeListener(WorkSpaceView.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.f = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoView
 * JD-Core Version:    0.7.0.1
 */