package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

public class ActionSheetDialog
  extends SafeDialog
  implements DialogInterface.OnCancelListener, Animation.AnimationListener
{
  protected Context a;
  protected Context b;
  private TextView d;
  private Button e;
  private LinearLayout f;
  private LinearLayout g;
  private View h;
  private Handler i;
  private int j = 0;
  private ArrayList<Button> k = new ArrayList();
  private View.OnClickListener l = null;
  
  public ActionSheetDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    this.b = paramContext;
    setContentView(2131624403);
    b();
    c();
    aF_();
  }
  
  public ActionSheetDialog(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, m);
  }
  
  private void b()
  {
    this.f = ((LinearLayout)findViewById(2131431538));
    this.g = ((LinearLayout)findViewById(2131437821));
    this.e = ((Button)findViewById(2131427505));
    this.e.setDrawingCacheEnabled(false);
    this.h = findViewById(2131429234);
    this.d = ((TextView)findViewById(2131447463));
    this.d.setVisibility(8);
    this.d.setText("");
  }
  
  private void c()
  {
    this.e.setOnClickListener(new ActionSheetDialog.2(this));
    this.i = new Handler(Looper.getMainLooper());
  }
  
  private void d()
  {
    Object localObject = new TranslateAnimation(0.0F, 0.0F, this.g.getHeight(), 0.0F);
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(this.a, 17432582));
    ((TranslateAnimation)localObject).setDuration(200L);
    this.g.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.h.startAnimation((Animation)localObject);
  }
  
  private void e()
  {
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.g.getHeight());
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(this.a, 17432582));
    ((TranslateAnimation)localObject).setDuration(200L);
    this.g.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.h.startAnimation((Animation)localObject);
    ((AlphaAnimation)localObject).setAnimationListener(this);
  }
  
  public Button a(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Button localButton = new Button(this.a);
    this.f.addView(localButton);
    Object localObject = (LinearLayout.LayoutParams)localButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = -1;
    ((LinearLayout.LayoutParams)localObject).height = ((int)this.a.getResources().getDimension(2131297770));
    ((LinearLayout.LayoutParams)localObject).bottomMargin = ((int)this.a.getResources().getDimension(2131297106));
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localButton.setText(paramString);
    int m = 2130839210;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              paramInt = this.b.getResources().getColor(2131165468);
            } else {
              paramInt = -14833678;
            }
          }
          else
          {
            paramInt = this.b.getResources().getColor(2131168539);
            localButton.setTypeface(Typeface.defaultFromStyle(1));
          }
        }
        else
        {
          paramInt = -16777216;
          int n = AIOUtils.b(8.0F, getContext().getResources());
          paramString = new SpannableString(localButton.getText());
          localObject = this.a.getResources().getDrawable(2130841175);
          ((Drawable)localObject).setBounds(n, 0, ((Drawable)localObject).getIntrinsicWidth() + n, ((Drawable)localObject).getIntrinsicHeight());
          paramString.setSpan(new ImageSpan((Drawable)localObject, 1), paramString.length() - 1, paramString.length(), 33);
          localButton.setText(paramString);
        }
      }
      else
      {
        paramInt = -14207157;
        m = 2130839208;
      }
    }
    else {
      paramInt = this.b.getResources().getColor(2131167862);
    }
    localButton.setBackgroundDrawable(this.b.getResources().getDrawable(m));
    localButton.setTextColor(paramInt);
    localButton.setTextSize(16.0F);
    localButton.setOnClickListener(paramOnClickListener);
    this.j += 1;
    this.k.add(localButton);
    return localButton;
  }
  
  public void a(String paramString)
  {
    this.e.post(new ActionSheetDialog.4(this, paramString));
  }
  
  public void dismiss()
  {
    e();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.l;
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.onClick(null);
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      dismiss();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      dismiss();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void show()
  {
    if (isShowing()) {
      return;
    }
    Context localContext = this.a;
    if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing())) {
      return;
    }
    super.show();
    this.g.setVisibility(4);
    this.h.setVisibility(4);
    this.i.postDelayed(new ActionSheetDialog.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ActionSheetDialog
 * JD-Core Version:    0.7.0.1
 */