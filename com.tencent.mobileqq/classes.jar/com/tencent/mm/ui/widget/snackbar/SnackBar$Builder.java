package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.View;

public class SnackBar$Builder
{
  private SnackBar a;
  private Context b;
  private String c;
  private String d;
  private int e = 0;
  private Parcelable f;
  private short g = 3500;
  private int h = -1;
  private int i = 0;
  
  public SnackBar$Builder(Activity paramActivity)
  {
    this.b = paramActivity.getApplicationContext();
    this.a = new SnackBar(paramActivity, this.i);
  }
  
  public SnackBar$Builder(Context paramContext, View paramView)
  {
    this.b = paramContext;
    this.a = new SnackBar(paramContext, paramView, this.i);
  }
  
  private int a()
  {
    return this.b.getResources().getColor(2131168455);
  }
  
  public SnackBar show()
  {
    String str = this.c;
    Object localObject = this.d;
    if (localObject != null) {
      localObject = ((String)localObject).toUpperCase();
    } else {
      localObject = null;
    }
    int k = this.e;
    Parcelable localParcelable = this.f;
    short s = this.g;
    int j = this.h;
    if (j == -1) {
      j = a();
    }
    localObject = new Snack(str, (String)localObject, k, localParcelable, s, j);
    SnackBar.a(this.a, (Snack)localObject);
    return this.a;
  }
  
  public Builder withActionIconId(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder withActionMessage(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Builder withActionMessageId(int paramInt)
  {
    if (paramInt > 0) {
      this.d = this.b.getString(paramInt);
    }
    return this;
  }
  
  public Builder withDuration(Short paramShort)
  {
    this.g = paramShort.shortValue();
    return this;
  }
  
  public Builder withFromSource(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public Builder withMessage(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Builder withMessageId(int paramInt)
  {
    this.c = this.b.getString(paramInt);
    return this;
  }
  
  public Builder withOnClickListener(SnackBar.OnMessageClickListener paramOnMessageClickListener)
  {
    SnackBar.a(this.a, paramOnMessageClickListener);
    return this;
  }
  
  public Builder withTextColorId(int paramInt)
  {
    this.h = this.b.getResources().getColor(paramInt);
    return this;
  }
  
  public Builder withToken(Parcelable paramParcelable)
  {
    this.f = paramParcelable;
    return this;
  }
  
  public Builder withVisibilityChangeListener(SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    SnackBar.a(this.a, paramOnVisibilityChangeListener);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackBar.Builder
 * JD-Core Version:    0.7.0.1
 */