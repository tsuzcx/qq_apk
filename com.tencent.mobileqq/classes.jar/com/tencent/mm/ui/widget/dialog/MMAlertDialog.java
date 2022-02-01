package com.tencent.mm.ui.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.rf.a;
import com.tencent.mm.ui.d;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class MMAlertDialog
  extends ReportDialog
  implements DialogInterface
{
  public static final int NOT_SHOW_ICON = 3;
  public static final int SHOW_SIGHT_ICON = 1;
  public static final int SHOW_VIDEO_ICON = 2;
  private Animation A;
  private Animation B;
  private Animation C;
  private MMAlertDialog.Builder.ITextSmileySpan D;
  private DialogInterface.OnDismissListener E;
  private IOnDialogDismissListener F;
  private Context a;
  private LinearLayout b;
  private Button c;
  private Button d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private EditText k;
  private CheckBox l;
  private ImageView m;
  private View n;
  private View o;
  private LinearLayout p;
  private ViewStub q;
  private LinearLayout r;
  private boolean s;
  private ViewGroup t;
  private LinearLayout u;
  private ViewGroup v;
  private View w;
  private boolean x = false;
  private boolean y = false;
  private Animation z;
  
  public MMAlertDialog(Context paramContext)
  {
    super(paramContext, 2131953304);
    this.a = paramContext;
    a(this.a);
  }
  
  public MMAlertDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131953304);
    this.a = paramContext;
    a(this.a);
  }
  
  private Bitmap a(Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / paramInt1;
    int i1 = g.b(this.a, 2131296305);
    paramInt1 = g.b(this.a, 2131296304);
    paramInt2 = 0;
    int i2;
    if ((f1 > 0.0F) && (f1 < 0.5D))
    {
      i2 = (int)(i1 / f1);
      paramInt2 = i1;
    }
    else
    {
      if ((f1 >= 0.5D) && (f1 < 1.0F))
      {
        i1 = (int)(paramInt1 * f1);
        paramInt2 = i1;
      }
      for (;;)
      {
        i2 = paramInt1;
        break label172;
        if ((f1 >= 1.0F) && (f1 < 2.0F))
        {
          i2 = (int)(paramInt1 / f1);
          paramInt2 = paramInt1;
          i1 = paramInt2;
          paramInt1 = i2;
          break label172;
        }
        if (f1 < 2.0F) {
          break;
        }
        i2 = (int)(i1 * f1);
        paramInt2 = paramInt1;
        paramInt1 = i1;
        i1 = i2;
      }
      i1 = 0;
      i2 = 0;
      paramInt1 = 0;
    }
    label172:
    if ((i1 > 0) && (i2 > 0) && (paramBitmap != null))
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i2, i1, true);
      paramImageView.setLayoutParams(new FrameLayout.LayoutParams(paramInt1, paramInt2));
      return paramBitmap;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    TextView localTextView = this.g;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = ((LinearLayout)View.inflate(this.a, 2131625435, null));
    this.c = ((Button)this.b.findViewById(2131438776));
    this.d = ((Button)this.b.findViewById(2131438768));
    this.e = ((TextView)this.b.findViewById(2131438777));
    this.f = ((TextView)this.b.findViewById(2131438779));
    this.g = ((TextView)this.b.findViewById(2131438771));
    this.h = ((TextView)this.b.findViewById(2131438775));
    this.i = ((TextView)this.b.findViewById(2131438774));
    this.j = ((TextView)this.b.findViewById(2131431231));
    this.k = ((EditText)this.b.findViewById(2131431232));
    this.l = ((CheckBox)this.b.findViewById(2131431230));
    this.m = ((ImageView)this.b.findViewById(2131438773));
    this.p = ((LinearLayout)this.b.findViewById(2131438778));
    this.q = ((ViewStub)this.b.findViewById(2131447528));
    this.r = ((LinearLayout)this.b.findViewById(2131438772));
    this.t = ((ViewGroup)this.b.findViewById(2131438763));
    this.w = this.b.findViewById(2131438767);
    this.u = ((LinearLayout)this.b.findViewById(2131438770));
    this.v = ((ViewGroup)this.b.findViewById(2131447527));
    setCanceledOnTouchOutside(true);
    this.z = AnimationUtils.loadAnimation(this.a, 2130772026);
    this.A = AnimationUtils.loadAnimation(this.a, 2130772026);
    this.B = AnimationUtils.loadAnimation(this.a, 2130772027);
    this.C = AnimationUtils.loadAnimation(this.a, 2130772027);
  }
  
  private void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.E = paramOnDismissListener;
  }
  
  private void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.w.setVisibility(8);
    this.t.removeAllViews();
    this.t.addView(paramView, paramLayoutParams);
  }
  
  private void a(Animation paramAnimation)
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((LinearLayout)localObject).startAnimation(paramAnimation);
    }
    localObject = this.u;
    if (localObject != null) {
      ((LinearLayout)localObject).startAnimation(paramAnimation);
    }
    localObject = this.j;
    if ((localObject != null) && (this.x)) {
      ((TextView)localObject).startAnimation(paramAnimation);
    }
    localObject = this.k;
    if (localObject != null)
    {
      if (!this.y)
      {
        ((EditText)localObject).setVisibility(8);
        return;
      }
      ((EditText)localObject).startAnimation(paramAnimation);
    }
  }
  
  private void a(MMAlertDialog.Builder.ITextSmileySpan paramITextSmileySpan)
  {
    this.D = paramITextSmileySpan;
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.u;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.j;
    if ((localObject != null) && (this.x)) {
      ((TextView)localObject).setVisibility(paramInt);
    }
    localObject = this.k;
    if (localObject != null)
    {
      if (!this.y)
      {
        ((EditText)localObject).setVisibility(8);
        return;
      }
      ((EditText)localObject).setVisibility(paramInt);
    }
  }
  
  public void apply(AlertParams paramAlertParams)
  {
    if ((paramAlertParams.a != null) && (paramAlertParams.a.length() > 0))
    {
      setTitleGravity(paramAlertParams.S);
      setTitle(paramAlertParams.a);
    }
    if ((paramAlertParams.b != null) && (paramAlertParams.b.length() > 0)) {
      setTitleDesc(paramAlertParams.b);
    }
    if (paramAlertParams.O != 0) {
      setTitleColor(paramAlertParams.O);
    }
    if (paramAlertParams.P != 0) {
      setTitleMaxLine(paramAlertParams.P);
    }
    if (paramAlertParams.Q != 0) {
      setMsgMaxLine(paramAlertParams.Q);
    }
    if (paramAlertParams.L != null) {
      setView(paramAlertParams.L);
    }
    if (paramAlertParams.M != null) {
      setCustomTitleView(paramAlertParams.M);
    }
    if (paramAlertParams.N != null) {
      setIconTitleDetail(paramAlertParams.N);
    }
    if (paramAlertParams.o != null) {
      setMsgIcon(paramAlertParams.o);
    }
    if ((paramAlertParams.s != null) && (paramAlertParams.s.length() > 0)) {
      setMessage(paramAlertParams.s);
    }
    setMsgContentBg(paramAlertParams.C);
    if (paramAlertParams.r != null)
    {
      setMsgIcon(paramAlertParams.r);
      setMsgIconVisibility(paramAlertParams.U);
    }
    if ((!paramAlertParams.Y) && (!paramAlertParams.Z))
    {
      if ((paramAlertParams.s != null) && (paramAlertParams.s.length() > 0)) {
        setMessage(paramAlertParams.s);
      }
      if ((paramAlertParams.t != null) && (paramAlertParams.t.length() > 0)) {
        setMsgSubTitle(paramAlertParams.t);
      } else {
        setMsgContentBg(false);
      }
      if ((paramAlertParams.u != null) && (paramAlertParams.u.length() > 0)) {
        setMsgSubDesc(paramAlertParams.u);
      }
      if (paramAlertParams.p != null) {
        setMsgIcon(paramAlertParams.p);
      }
    }
    if (paramAlertParams.Y) {
      setLeftIconStyle(paramAlertParams.p, paramAlertParams.t, paramAlertParams.u);
    } else if (paramAlertParams.Z) {
      setRightIconStyle(paramAlertParams.p, paramAlertParams.t, paramAlertParams.u);
    }
    if ((paramAlertParams.g != null) || (paramAlertParams.h != null)) {
      setIconTitle(paramAlertParams.g, paramAlertParams.h, Boolean.valueOf(paramAlertParams.i), paramAlertParams.k, paramAlertParams.l);
    }
    if (paramAlertParams.m != null) {
      setContentClick(paramAlertParams.m);
    }
    if ((paramAlertParams.q != null) && (!paramAlertParams.q.isRecycled())) {
      setDialogImage(paramAlertParams.q, paramAlertParams.D, paramAlertParams.T);
    }
    if ((paramAlertParams.c != null) && (paramAlertParams.c.length() > 0))
    {
      setContentDescTv(paramAlertParams.c);
      this.x = true;
      setContentDescTvGravity(paramAlertParams.R);
    }
    if ((paramAlertParams.d != null) && (paramAlertParams.d.length() > 0)) {
      setEditTextHint(paramAlertParams.d);
    }
    if ((paramAlertParams.e != null) && (paramAlertParams.e.length() > 0)) {
      setCheckBoxText(paramAlertParams.e);
    }
    if (paramAlertParams.f)
    {
      this.y = paramAlertParams.f;
      hasEditText(paramAlertParams.f);
    }
    if ((paramAlertParams.v != null) && (paramAlertParams.v.length() > 0)) {
      setPositiveButton(paramAlertParams.v, paramAlertParams.X, paramAlertParams.E);
    }
    if ((paramAlertParams.w != null) && (paramAlertParams.w.length() > 0)) {
      setNegativeButton(paramAlertParams.w, paramAlertParams.F);
    }
    if (paramAlertParams.W != 0) {
      setPositiveButtonColor(paramAlertParams.W);
    }
    if (paramAlertParams.V != 0) {
      setNegativeButtonColor(paramAlertParams.V);
    }
    if (paramAlertParams.G != null) {
      setOnCancelListener(paramAlertParams.G);
    }
    if (paramAlertParams.H != null)
    {
      a(paramAlertParams.H);
      setOnDismissListener(paramAlertParams.H);
    }
    if (paramAlertParams.n != null) {
      a(paramAlertParams.n);
    }
    setCancelable(paramAlertParams.A);
    this.s = paramAlertParams.A;
    if (!this.s) {
      setCanBack(paramAlertParams.B);
    }
    View localView;
    if ((paramAlertParams.x != null) || (paramAlertParams.y != null) || (paramAlertParams.z != null))
    {
      localView = View.inflate(this.a, 2131624537, null);
      Button localButton1 = (Button)localView.findViewById(2131438764);
      Button localButton2 = (Button)localView.findViewById(2131438765);
      Button localButton3 = (Button)localView.findViewById(2131438766);
      if (paramAlertParams.x != null)
      {
        localButton1.setVisibility(0);
        localButton1.setText(paramAlertParams.x);
        localButton1.setOnClickListener(new MMAlertDialog.6(this, paramAlertParams));
      }
      if (paramAlertParams.y != null)
      {
        localButton2.setVisibility(0);
        localButton2.setText(paramAlertParams.y);
        localButton2.setOnClickListener(new MMAlertDialog.7(this, paramAlertParams));
      }
      if (paramAlertParams.z != null)
      {
        localButton3.setVisibility(0);
        localButton3.setText(paramAlertParams.z);
        localButton3.setOnClickListener(new MMAlertDialog.8(this, paramAlertParams));
      }
      a(localView, new LinearLayout.LayoutParams(-1, -1));
    }
    if (paramAlertParams.j)
    {
      localView = View.inflate(this.a, 2131624532, null);
      this.d = ((Button)localView.findViewById(2131438768));
      this.c = ((Button)localView.findViewById(2131438776));
      if (paramAlertParams.W != 0) {
        setPositiveButtonColor(paramAlertParams.W);
      }
      if (paramAlertParams.V != 0) {
        setNegativeButtonColor(paramAlertParams.V);
      }
      if ((paramAlertParams.v != null) && (paramAlertParams.v.length() > 0)) {
        setPositiveButton(paramAlertParams.v, paramAlertParams.X, paramAlertParams.E);
      }
      if ((paramAlertParams.w != null) && (paramAlertParams.w.length() > 0)) {
        setNegativeButton(paramAlertParams.w, paramAlertParams.F);
      }
      a(localView, new LinearLayout.LayoutParams(-1, -1));
    }
  }
  
  public void dismiss()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new MMAlertDialog.9(this));
      f.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      return;
    }
    try
    {
      if ((this.a != null) && ((this.a instanceof Activity)))
      {
        if (!((Activity)this.a).isFinishing()) {
          super.dismiss();
        }
      }
      else {
        super.dismiss();
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismiss exception, e = ");
      localStringBuilder.append(localException.getMessage());
      f.e("MicroMsg.MMAlertDialog", localStringBuilder.toString(), new Object[0]);
    }
    IOnDialogDismissListener localIOnDialogDismissListener = this.F;
    if (localIOnDialogDismissListener != null) {
      localIOnDialogDismissListener.onDialogDismiss(this);
    }
  }
  
  public Button getButton(int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1) {
        return null;
      }
      return this.c;
    }
    return this.d;
  }
  
  public View getContentView()
  {
    return this.b;
  }
  
  public DialogInterface.OnDismissListener getDialogDismissListener()
  {
    return this.E;
  }
  
  public int getEditTextPasterLen()
  {
    EditText localEditText = this.k;
    if ((localEditText instanceof PasterEditText)) {
      return ((PasterEditText)localEditText).getPasterLen();
    }
    return 0;
  }
  
  public String getEditTextValue()
  {
    EditText localEditText = this.k;
    if (localEditText == null) {
      return null;
    }
    return localEditText.getText().toString();
  }
  
  public ImageView getMsgIcon()
  {
    return this.m;
  }
  
  public CheckBox getmCheckBox()
  {
    return this.l;
  }
  
  public void hasEditText(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.k.setVisibility(0);
      return;
    }
    this.k.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.b);
  }
  
  public void setButtonVisible(int paramInt, boolean paramBoolean)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1) {
        return;
      }
      if (paramBoolean)
      {
        this.c.setVisibility(0);
        return;
      }
      this.c.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      this.d.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void setCanBack(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.s = paramBoolean;
    setCanceledOnTouchOutside(this.s);
  }
  
  public void setCheckBoxText(CharSequence paramCharSequence)
  {
    this.l.setVisibility(0);
    this.l.setText(paramCharSequence);
  }
  
  public void setContentClick(MMAlertDialog.Builder.IOnContentClick paramIOnContentClick)
  {
    LinearLayout localLinearLayout = this.r;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0))
    {
      this.r.setOnClickListener(new MMAlertDialog.2(this, paramIOnContentClick));
      return;
    }
    localLinearLayout = this.u;
    if (localLinearLayout != null) {
      localLinearLayout.setOnClickListener(new MMAlertDialog.3(this, paramIOnContentClick));
    }
  }
  
  public void setContentDescTv(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.j.setVisibility(0);
      this.j.setText(paramCharSequence);
    }
  }
  
  public void setContentDescTvGravity(int paramInt)
  {
    TextView localTextView = this.j;
    if (localTextView != null) {
      localTextView.setGravity(paramInt);
    }
  }
  
  public void setCustomTitleView(View paramView)
  {
    this.p.setVisibility(0);
    this.q.setLayoutResource(2131624533);
    try
    {
      localLinearLayout = (LinearLayout)this.q.inflate();
    }
    catch (Exception localException)
    {
      LinearLayout localLinearLayout;
      label32:
      break label32;
    }
    this.q.setVisibility(0);
    localLinearLayout = null;
    localLinearLayout.addView(paramView);
  }
  
  public void setDialogImage(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
  {
    if (paramBitmap != null)
    {
      setMsgContentBg(false);
      this.r.setVisibility(0);
      this.r.setGravity(1);
      this.r.setPadding(0, 0, 0, 0);
      View localView = View.inflate(this.a, 2131624536, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131438773);
      Bitmap localBitmap = paramBitmap;
      if (paramBoolean) {
        localBitmap = d.a(a(paramBitmap, localImageView, paramBitmap.getWidth(), paramBitmap.getHeight()), true, g.a(this.a, 3), false);
      }
      localImageView.setImageBitmap(localBitmap);
      paramBitmap = (ImageView)localView.findViewById(2131435476);
      if (paramInt == 0)
      {
        paramBitmap.setVisibility(8);
      }
      else
      {
        paramBitmap.setVisibility(0);
        if (paramInt == 1) {
          paramBitmap.setImageResource(2131230847);
        } else if (paramInt == 2) {
          paramBitmap.setImageResource(2131230878);
        }
      }
      setView(localView, -2);
    }
  }
  
  public void setEditTextHint(CharSequence paramCharSequence)
  {
    this.k.setVisibility(0);
    this.k.setHint(paramCharSequence);
  }
  
  public void setIconTitle(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, MMAlertDialog.Builder.IOnTitleClick paramIOnTitleClick, MMAlertDialog.Builder.IIconAttach paramIIconAttach)
  {
    this.q.setLayoutResource(2131624538);
    try
    {
      localLinearLayout = (LinearLayout)this.q.inflate();
    }
    catch (Exception localException)
    {
      LinearLayout localLinearLayout;
      label25:
      Object localObject;
      break label25;
    }
    this.q.setVisibility(0);
    localLinearLayout = null;
    if ((localLinearLayout != null) && (paramString != null))
    {
      localObject = (ImageView)localLinearLayout.findViewById(2131447517);
      ((ImageView)localObject).setVisibility(0);
      if (paramIIconAttach != null) {
        paramIIconAttach.onIconAttach((ImageView)localObject, paramString);
      }
    }
    if ((localLinearLayout != null) && (paramCharSequence != null))
    {
      paramIIconAttach = (TextView)localLinearLayout.findViewById(2131447576);
      paramIIconAttach.setVisibility(0);
      localObject = this.D;
      paramString = paramCharSequence;
      if (localObject != null) {
        paramString = ((MMAlertDialog.Builder.ITextSmileySpan)localObject).smileySpan(this.a, paramCharSequence.toString(), this.e.getTextSize());
      }
      paramIIconAttach.setText(paramString);
    }
    if ((paramBoolean.booleanValue()) && (localLinearLayout != null))
    {
      paramString = (ImageView)localLinearLayout.findViewById(2131435482);
      paramString.setVisibility(0);
      b(0);
      localLinearLayout.setOnClickListener(new MMAlertDialog.1(this, paramIOnTitleClick, paramString));
    }
  }
  
  public void setIconTitleDetail(View paramView)
  {
    this.o = paramView;
    if (this.o != null)
    {
      this.r.setVisibility(8);
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      this.v.removeAllViews();
      this.v.addView(this.o, new LinearLayout.LayoutParams(-1, -1));
      this.v.setVisibility(8);
    }
  }
  
  public void setLeftIconStyle(Bitmap paramBitmap, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    View localView = View.inflate(this.a, 2131624534, null);
    Object localObject;
    if (paramBitmap != null)
    {
      localObject = (ImageView)localView.findViewById(2131438773);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageBitmap(paramBitmap);
    }
    if (paramCharSequence1 != null)
    {
      localObject = (TextView)localView.findViewById(2131438775);
      ((TextView)localObject).setVisibility(0);
      MMAlertDialog.Builder.ITextSmileySpan localITextSmileySpan = this.D;
      paramBitmap = paramCharSequence1;
      if (localITextSmileySpan != null) {
        paramBitmap = localITextSmileySpan.smileySpan(this.a, paramCharSequence1.toString(), ((TextView)localObject).getTextSize());
      }
      ((TextView)localObject).setText(paramBitmap);
    }
    if (paramCharSequence2 != null)
    {
      paramCharSequence1 = (TextView)localView.findViewById(2131438774);
      paramCharSequence1.setVisibility(0);
      localObject = this.D;
      paramBitmap = paramCharSequence2;
      if (localObject != null) {
        paramBitmap = ((MMAlertDialog.Builder.ITextSmileySpan)localObject).smileySpan(this.a, paramCharSequence2.toString(), paramCharSequence1.getTextSize());
      }
      paramCharSequence1.setText(paramBitmap);
    }
    setView(localView);
  }
  
  public void setMessage(int paramInt)
  {
    this.r.setVisibility(0);
    this.g.setVisibility(0);
    this.g.setText(paramInt);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.r.setVisibility(0);
    this.g.setVisibility(0);
    MMAlertDialog.Builder.ITextSmileySpan localITextSmileySpan = this.D;
    CharSequence localCharSequence = paramCharSequence;
    if (localITextSmileySpan != null) {
      localCharSequence = localITextSmileySpan.smileySpan(this.g.getContext(), paramCharSequence.toString(), this.g.getTextSize());
    }
    this.g.setText(localCharSequence);
  }
  
  public void setMsgContentBg(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i1 = g.a(this.a, 8);
      this.r.setVisibility(0);
      this.r.setPadding(i1, i1, i1, i1);
    }
  }
  
  public void setMsgIcon(int paramInt)
  {
    if (this.n != null) {
      return;
    }
    this.r.setVisibility(0);
    this.m.setVisibility(0);
    this.m.setBackgroundResource(paramInt);
  }
  
  public void setMsgIcon(Bitmap paramBitmap)
  {
    if (this.n != null) {
      return;
    }
    this.r.setVisibility(0);
    this.m.setVisibility(0);
    this.m.setImageBitmap(paramBitmap);
  }
  
  public void setMsgIcon(Drawable paramDrawable)
  {
    if (this.n != null) {
      return;
    }
    this.r.setVisibility(0);
    this.m.setVisibility(0);
    this.m.setBackgroundDrawable(paramDrawable);
  }
  
  public void setMsgIcon(String paramString)
  {
    int i1 = g.a(this.a, 120);
    this.r.setVisibility(0);
    this.m.setVisibility(0);
    ImageView localImageView = this.m;
    if ((localImageView instanceof a)) {
      ((a)localImageView).a(paramString, i1, i1);
    }
  }
  
  public void setMsgIconVisibility(int paramInt)
  {
    this.r.setVisibility(paramInt);
    this.m.setVisibility(paramInt);
  }
  
  public void setMsgMaxLine(int paramInt)
  {
    this.g.setMaxLines(paramInt);
  }
  
  public void setMsgSubDesc(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.r.setVisibility(0);
      this.i.setVisibility(0);
      MMAlertDialog.Builder.ITextSmileySpan localITextSmileySpan = this.D;
      CharSequence localCharSequence = paramCharSequence;
      if (localITextSmileySpan != null) {
        localCharSequence = localITextSmileySpan.smileySpan(this.i.getContext(), paramCharSequence.toString(), this.i.getTextSize());
      }
      this.i.setText(localCharSequence);
    }
  }
  
  public void setMsgSubTitle(CharSequence paramCharSequence)
  {
    this.r.setVisibility(0);
    this.h.setVisibility(0);
    this.h.setMaxLines(2);
    this.h.setText(paramCharSequence);
  }
  
  public void setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    setNegativeButton(this.a.getString(paramInt), paramOnClickListener);
  }
  
  public void setNegativeButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    setNegativeButton(paramCharSequence, true, paramOnClickListener);
  }
  
  public void setNegativeButton(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    Button localButton = this.d;
    if (localButton == null) {
      return;
    }
    localButton.setVisibility(0);
    this.d.setText(paramCharSequence);
    this.d.setOnClickListener(new MMAlertDialog.5(this, paramOnClickListener, paramBoolean));
  }
  
  public void setNegativeButtonColor(int paramInt)
  {
    this.d.setTextColor(paramInt);
  }
  
  public void setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    setPositiveButton(this.a.getString(paramInt), true, paramOnClickListener);
  }
  
  public void setPositiveButton(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    Button localButton = this.c;
    if (localButton == null) {
      return;
    }
    localButton.setVisibility(0);
    this.c.setText(paramCharSequence);
    this.c.setOnClickListener(new MMAlertDialog.4(this, paramOnClickListener, paramBoolean));
  }
  
  public void setPositiveButtonColor(int paramInt)
  {
    this.c.setTextColor(paramInt);
  }
  
  public void setRightIconStyle(Bitmap paramBitmap, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    View localView = View.inflate(this.a, 2131624535, null);
    Object localObject;
    if (paramBitmap != null)
    {
      localObject = (ImageView)localView.findViewById(2131438773);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageBitmap(paramBitmap);
    }
    if (paramCharSequence1 != null)
    {
      localObject = (TextView)localView.findViewById(2131438775);
      ((TextView)localObject).setVisibility(0);
      MMAlertDialog.Builder.ITextSmileySpan localITextSmileySpan = this.D;
      paramBitmap = paramCharSequence1;
      if (localITextSmileySpan != null) {
        paramBitmap = localITextSmileySpan.smileySpan(this.a, paramCharSequence1.toString(), ((TextView)localObject).getTextSize());
      }
      ((TextView)localObject).setText(paramBitmap);
    }
    if (paramCharSequence2 != null)
    {
      paramCharSequence1 = (TextView)localView.findViewById(2131438774);
      paramCharSequence1.setVisibility(0);
      localObject = this.D;
      paramBitmap = paramCharSequence2;
      if (localObject != null) {
        paramBitmap = ((MMAlertDialog.Builder.ITextSmileySpan)localObject).smileySpan(this.a, paramCharSequence2.toString(), paramCharSequence1.getTextSize());
      }
      paramCharSequence1.setText(paramBitmap);
    }
    setView(localView);
  }
  
  public void setTitle(int paramInt)
  {
    this.p.setVisibility(0);
    this.e.setVisibility(0);
    this.e.setMaxLines(2);
    this.e.setText(paramInt);
    this.e.getPaint().setFakeBoldText(true);
    a(this.a.getResources().getColor(2131165267));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.p.setVisibility(0);
    this.e.setVisibility(0);
    MMAlertDialog.Builder.ITextSmileySpan localITextSmileySpan = this.D;
    CharSequence localCharSequence = paramCharSequence;
    if (localITextSmileySpan != null) {
      localCharSequence = localITextSmileySpan.smileySpan(this.a, paramCharSequence.toString(), this.e.getTextSize());
    }
    this.e.setMaxLines(2);
    this.e.setText(localCharSequence);
    this.e.getPaint().setFakeBoldText(true);
    a(this.a.getResources().getColor(2131165267));
  }
  
  public void setTitleColor(int paramInt)
  {
    this.e.setTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setTitleDesc(CharSequence paramCharSequence)
  {
    this.p.setVisibility(0);
    this.f.setVisibility(0);
    MMAlertDialog.Builder.ITextSmileySpan localITextSmileySpan = this.D;
    CharSequence localCharSequence = paramCharSequence;
    if (localITextSmileySpan != null) {
      localCharSequence = localITextSmileySpan.smileySpan(this.a, paramCharSequence.toString(), this.e.getTextSize());
    }
    this.f.setText(localCharSequence);
  }
  
  public void setTitleGravity(int paramInt)
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setGravity(paramInt);
    }
  }
  
  public void setTitleMaxLine(int paramInt)
  {
    this.e.setMaxLines(paramInt);
  }
  
  public void setView(View paramView)
  {
    setView(paramView, -1);
  }
  
  public void setView(View paramView, int paramInt)
  {
    this.n = paramView;
    if (this.n != null)
    {
      this.r.setVisibility(0);
      this.u.setVisibility(0);
      this.u.removeAllViews();
      this.u.setGravity(1);
      this.u.addView(this.n, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
  }
  
  public void setiOnDialogDismissListener(IOnDialogDismissListener paramIOnDialogDismissListener)
  {
    this.F = paramIOnDialogDismissListener;
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      f.a("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMAlertDialog
 * JD-Core Version:    0.7.0.1
 */