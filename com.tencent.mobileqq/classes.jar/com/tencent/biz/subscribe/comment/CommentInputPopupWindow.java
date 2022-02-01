package com.tencent.biz.subscribe.comment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CommentInputPopupWindow
  extends SafeDialog
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private SharedPreferences.Editor a;
  private Activity b;
  private ImageButton d;
  private CommentEditText e;
  private ImageButton f;
  private int g;
  private EmoView h;
  private InputMethodManager i;
  private boolean j;
  private CommentBoxListener k;
  private int l;
  private CommentInputPopupWindow.OnDismissListener m;
  private View n;
  private SoftKeyboardStateHelper o;
  private Handler p;
  private boolean q;
  
  private void a(boolean paramBoolean)
  {
    EmoView localEmoView = this.h;
    if (localEmoView != null) {
      localEmoView.setVisibility(8);
    }
    d(this.n);
    if (paramBoolean) {
      a(this.e);
    }
  }
  
  private void b()
  {
    this.h.getLayoutParams().height = this.g;
    this.h.invalidate();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mEmojiPanel onGetKeyBoardHeight() :");
    localStringBuilder.append(this.g);
    QLog.d("CommentInputPopupWindow", 1, localStringBuilder.toString());
  }
  
  private void c()
  {
    if (this.j) {
      c(this.n);
    }
    this.q = true;
    this.h.setVisibility(0);
    WorkSpaceView localWorkSpaceView = (WorkSpaceView)this.h.getChildAt(0);
    if (localWorkSpaceView != null) {
      d().post(new CommentInputPopupWindow.8(this, localWorkSpaceView));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("workSpaceView is empty");
    localStringBuilder.append(localWorkSpaceView);
    boolean bool;
    if (localStringBuilder.toString() != null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("CommentInputPopupWindow", 1, new Object[] { Boolean.valueOf(bool) });
    b(this.e);
  }
  
  private void c(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private Handler d()
  {
    if (this.p == null) {
      this.p = new Handler(Looper.getMainLooper());
    }
    return this.p;
  }
  
  private void d(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new CommentInputPopupWindow.7(this, paramView));
  }
  
  @TargetApi(19)
  public void aF_()
  {
    super.aF_();
    Object localObject = getWindow();
    if (localObject == null) {
      return;
    }
    localObject = ((Window)localObject).getDecorView();
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      int i1 = 0;
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        int i2 = ((ViewGroup)localObject).getChildCount();
        while (i1 < i2)
        {
          View localView = ((ViewGroup)localObject).getChildAt(i1);
          if (localView == null) {
            return;
          }
          if (localView.getId() == 16908290) {
            return;
          }
          if (!(localView instanceof ViewStub)) {
            localView.setAlpha(0.0F);
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void b(View paramView)
  {
    this.i.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public void dismiss()
  {
    b(this.e);
    a(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick:");
    ((StringBuilder)localObject).append(paramView.getId());
    QLog.d("CommentInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131447156: 
      QLog.d("CommentInputPopupWindow", 1, "text_input");
      a(true);
      this.f.setVisibility(8);
      this.d.setVisibility(0);
      break;
    case 2131429958: 
      localObject = this.k;
      if (localObject != null) {
        ((CommentBoxListener)localObject).a();
      }
      break;
    case 2131429918: 
      QLog.d("CommentInputPopupWindow", 1, "btn_keyboard");
      a(true);
      this.f.setVisibility(8);
      this.d.setVisibility(0);
      break;
    case 2131429880: 
      QLog.d("CommentInputPopupWindow", 1, "btn_emotion");
      c();
      this.f.setVisibility(0);
      this.d.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.o.a();
    this.o = null;
    this.d.setVisibility(8);
    this.f.setVisibility(0);
    this.j = false;
    paramDialogInterface = this.m;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */