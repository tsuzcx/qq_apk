package com.tencent.mm.ui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MMAlertDialog$Builder
{
  private Context a;
  private AlertParams b;
  
  public MMAlertDialog$Builder(Context paramContext)
  {
    this.a = paramContext;
    this.b = new AlertParams();
  }
  
  public MMAlertDialog$Builder(Context paramContext, AlertParams paramAlertParams)
  {
    this.a = paramContext;
    this.b = paramAlertParams;
  }
  
  public MMAlertDialog create()
  {
    MMAlertDialog localMMAlertDialog = new MMAlertDialog(this.a, 2131953304);
    localMMAlertDialog.apply(this.b);
    return localMMAlertDialog;
  }
  
  public DialogInterface.OnCancelListener getCancelListener()
  {
    return this.b.G;
  }
  
  public DialogInterface.OnDismissListener getDismissListener()
  {
    return this.b.H;
  }
  
  public AlertParams getParams()
  {
    return this.b;
  }
  
  public Builder hasEditText(boolean paramBoolean)
  {
    this.b.f = paramBoolean;
    return this;
  }
  
  public Builder hasMsgContentBg(boolean paramBoolean)
  {
    this.b.C = paramBoolean;
    return this;
  }
  
  public Builder setBtnUpDown(boolean paramBoolean)
  {
    this.b.j = paramBoolean;
    return this;
  }
  
  public Builder setCanBack(boolean paramBoolean)
  {
    this.b.B = paramBoolean;
    return this;
  }
  
  public Builder setCancelable(boolean paramBoolean)
  {
    this.b.A = paramBoolean;
    return this;
  }
  
  public Builder setCenterImg(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
  {
    AlertParams localAlertParams = this.b;
    localAlertParams.q = paramBitmap;
    localAlertParams.D = paramBoolean;
    localAlertParams.T = paramInt;
    return this;
  }
  
  public Builder setCheckBox(String paramString)
  {
    this.b.e = paramString;
    return this;
  }
  
  public Builder setContentClick(MMAlertDialog.Builder.IOnContentClick paramIOnContentClick)
  {
    this.b.m = paramIOnContentClick;
    return this;
  }
  
  public Builder setContentDescTv(String paramString)
  {
    this.b.c = paramString;
    return this;
  }
  
  public Builder setContentDescTvGravity(int paramInt)
  {
    this.b.R = paramInt;
    return this;
  }
  
  public Builder setContext(Context paramContext)
  {
    this.a = paramContext;
    return this;
  }
  
  public Builder setCustomTitle(View paramView)
  {
    this.b.M = paramView;
    return this;
  }
  
  public Builder setEditTextHint(String paramString)
  {
    this.b.d = paramString;
    return this;
  }
  
  @Deprecated
  public Builder setImageTitle(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, MMAlertDialog.Builder.IOnTitleClick paramIOnTitleClick)
  {
    return setImageTitle(paramString, paramCharSequence, paramBoolean, paramIOnTitleClick, null);
  }
  
  public Builder setImageTitle(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, MMAlertDialog.Builder.IOnTitleClick paramIOnTitleClick, MMAlertDialog.Builder.IIconAttach paramIIconAttach)
  {
    AlertParams localAlertParams = this.b;
    localAlertParams.g = paramString;
    localAlertParams.h = paramCharSequence;
    localAlertParams.i = paramBoolean.booleanValue();
    paramString = this.b;
    paramString.k = paramIOnTitleClick;
    paramString.l = paramIIconAttach;
    return this;
  }
  
  public Builder setLeftIconStyle(Bitmap paramBitmap, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AlertParams localAlertParams = this.b;
    localAlertParams.p = paramBitmap;
    localAlertParams.t = paramCharSequence1;
    localAlertParams.u = paramCharSequence2;
    localAlertParams.Y = true;
    return this;
  }
  
  public Builder setMsg(int paramInt)
  {
    this.b.s = this.a.getString(paramInt);
    return this;
  }
  
  public Builder setMsg(String paramString)
  {
    this.b.s = paramString;
    return this;
  }
  
  public Builder setMsgIcon(int paramInt)
  {
    this.b.o = this.a.getResources().getDrawable(paramInt);
    return this;
  }
  
  public Builder setMsgIcon(Bitmap paramBitmap)
  {
    this.b.p = paramBitmap;
    return this;
  }
  
  public Builder setMsgIcon(Drawable paramDrawable)
  {
    this.b.o = paramDrawable;
    return this;
  }
  
  public Builder setMsgIcon(String paramString)
  {
    this.b.r = paramString;
    return this;
  }
  
  public Builder setMsgIconVisivility(int paramInt)
  {
    this.b.U = paramInt;
    return this;
  }
  
  public Builder setMsgMaxLine(int paramInt)
  {
    this.b.Q = paramInt;
    return this;
  }
  
  public Builder setMsgSubDesc(String paramString)
  {
    this.b.u = paramString;
    return this;
  }
  
  public Builder setMsgSubTitle(CharSequence paramCharSequence)
  {
    this.b.t = paramCharSequence;
    return this;
  }
  
  public Builder setMultiBtnListener(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    AlertParams localAlertParams = this.b;
    localAlertParams.I = paramOnClickListener1;
    localAlertParams.J = paramOnClickListener2;
    localAlertParams.K = paramOnClickListener3;
    return this;
  }
  
  public Builder setMultiBtnText(String paramString1, String paramString2, String paramString3)
  {
    AlertParams localAlertParams = this.b;
    localAlertParams.x = paramString1;
    localAlertParams.y = paramString2;
    localAlertParams.z = paramString3;
    return this;
  }
  
  public Builder setNegativeBtnColor(int paramInt)
  {
    this.b.V = paramInt;
    return this;
  }
  
  public Builder setNegativeBtnListener(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.b.F = paramOnClickListener;
    return this;
  }
  
  public Builder setNegativeBtnText(int paramInt)
  {
    this.b.w = this.a.getString(paramInt);
    return this;
  }
  
  public Builder setNegativeBtnText(String paramString)
  {
    this.b.w = paramString;
    return this;
  }
  
  public Builder setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.b.G = paramOnCancelListener;
    return this;
  }
  
  public Builder setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.b.H = paramOnDismissListener;
    return this;
  }
  
  public Builder setPositiveBtnColor(int paramInt)
  {
    this.b.W = paramInt;
    return this;
  }
  
  public Builder setPositiveBtnListener(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.b.E = paramOnClickListener;
    return this;
  }
  
  public Builder setPositiveBtnListener(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertParams localAlertParams = this.b;
    localAlertParams.E = paramOnClickListener;
    localAlertParams.X = paramBoolean;
    return this;
  }
  
  public Builder setPositiveBtnText(int paramInt)
  {
    this.b.v = this.a.getString(paramInt);
    return this;
  }
  
  public Builder setPositiveBtnText(String paramString)
  {
    this.b.v = paramString;
    return this;
  }
  
  public Builder setRightIconStyle(Bitmap paramBitmap, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AlertParams localAlertParams = this.b;
    localAlertParams.p = paramBitmap;
    localAlertParams.t = paramCharSequence1;
    localAlertParams.u = paramCharSequence2;
    localAlertParams.Z = true;
    return this;
  }
  
  public Builder setTextSmileySpan(MMAlertDialog.Builder.ITextSmileySpan paramITextSmileySpan)
  {
    this.b.n = paramITextSmileySpan;
    return this;
  }
  
  public Builder setTitle(int paramInt)
  {
    this.b.a = this.a.getString(paramInt);
    return this;
  }
  
  public Builder setTitle(CharSequence paramCharSequence)
  {
    this.b.a = paramCharSequence;
    return this;
  }
  
  public Builder setTitle(String paramString)
  {
    this.b.a = paramString;
    return this;
  }
  
  public Builder setTitleColor(int paramInt)
  {
    this.b.O = paramInt;
    return this;
  }
  
  public Builder setTitleDesc(CharSequence paramCharSequence)
  {
    this.b.b = paramCharSequence;
    return this;
  }
  
  public Builder setTitleDetailView(View paramView)
  {
    this.b.N = paramView;
    return this;
  }
  
  public Builder setTitleGravity(int paramInt)
  {
    this.b.S = paramInt;
    return this;
  }
  
  public Builder setTitleMaxLine(int paramInt)
  {
    this.b.P = paramInt;
    return this;
  }
  
  public Builder setView(View paramView)
  {
    this.b.L = paramView;
    return this;
  }
  
  public void show()
  {
    create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder
 * JD-Core Version:    0.7.0.1
 */