package com.tencent.biz.qqcircle.comment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.qqcircle.widgets.comment.Patterns;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QCircleCommentInputPopupWindow
  extends QCircleBaseInputPopupWindow
{
  private View n;
  private SystemAndEmojiEmoticonPanel p;
  private LinearLayout q;
  private ImageButton r;
  private ImageButton s;
  private TextView t;
  private LinearLayout u;
  private LinearLayout v;
  private TextView w;
  private QCircleCommentInputPopupWindow.OnCommentPopupHeightChangeListener x;
  private boolean y = false;
  
  public QCircleCommentInputPopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    k();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QCircleCommentInputPopupWindow.OnCommentPopupHeightChangeListener localOnCommentPopupHeightChangeListener = this.x;
    if (localOnCommentPopupHeightChangeListener != null) {
      localOnCommentPopupHeightChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.p;
    if (localObject != null) {
      ((SystemAndEmojiEmoticonPanel)localObject).setVisibility(8);
    }
    d(this.k);
    if (paramBoolean) {
      a(this.c, 0);
    }
  }
  
  private void o()
  {
    Object localObject = this.n;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null))
    {
      this.n.getLayoutParams().height = this.e;
      this.n.invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("QCircleBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.p;
    if ((localObject != null) && (((SystemAndEmojiEmoticonPanel)localObject).getLayoutParams() != null))
    {
      this.p.getLayoutParams().height = this.e;
      this.p.invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("QCircleBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
    p();
  }
  
  private void p()
  {
    if (this.a == null) {
      return;
    }
    View localView = this.a.findViewById(2131431083);
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new QCircleCommentInputPopupWindow.2(this, localView));
  }
  
  private void q()
  {
    if (this.h) {
      c(this.k);
    }
    this.y = true;
    Object localObject = this.n;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.p;
    if (localObject != null) {
      ((SystemAndEmojiEmoticonPanel)localObject).setVisibility(0);
    }
    b(this.c);
  }
  
  private void r()
  {
    this.c.setOnEditorActionListener(new QCircleCommentInputPopupWindow.5(this));
    this.c.addTextChangedListener(new QCircleCommentInputPopupWindow.6(this));
  }
  
  private void s()
  {
    this.u.setVisibility(8);
    Object localObject1 = this.c.getText().toString();
    Object localObject2 = Patterns.k.matcher((CharSequence)localObject1);
    int i = 0;
    while (((Matcher)localObject2).find()) {
      i += ((Matcher)localObject2).end() - ((Matcher)localObject2).start() - 2;
    }
    i = ((String)localObject1).length() - i;
    int j = QCircleConfigHelper.n();
    if (i >= j - 10)
    {
      this.u.setVisibility(0);
      localObject1 = this.t;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      if (i > j) {
        this.t.setTextColor(getContext().getResources().getColor(2131167034));
      } else {
        this.t.setTextColor(getContext().getResources().getColor(2131167035));
      }
      localObject1 = this.w;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(j);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
  }
  
  private void t()
  {
    this.l = new SoftKeyboardStateHelper(this.a);
    this.l.a(new QCircleCommentInputPopupWindow.7(this));
    this.a.getViewTreeObserver();
  }
  
  public int a()
  {
    return 2131626772;
  }
  
  protected void a(View paramView) {}
  
  public void a(QCircleCommentInputPopupWindow.OnCommentPopupHeightChangeListener paramOnCommentPopupHeightChangeListener)
  {
    this.x = paramOnCommentPopupHeightChangeListener;
  }
  
  public void a(boolean paramBoolean)
  {
    show();
    t();
    if (paramBoolean)
    {
      h().post(new QCircleCommentInputPopupWindow.3(this));
      return;
    }
    h().post(new QCircleCommentInputPopupWindow.4(this));
  }
  
  protected void d()
  {
    this.q = ((LinearLayout)this.a.findViewById(2131431066));
    this.s = ((ImageButton)this.a.findViewById(2131429880));
    this.r = ((ImageButton)this.a.findViewById(2131429918));
    this.t = ((TextView)this.a.findViewById(2131448881));
    this.u = ((LinearLayout)this.a.findViewById(2131450239));
    this.w = ((TextView)this.a.findViewById(2131448882));
    super.d();
    o();
  }
  
  public void dismiss()
  {
    b(false);
    super.dismiss();
  }
  
  protected void e()
  {
    super.e();
    this.s.setOnClickListener(this);
    this.r.setOnClickListener(this);
    r();
  }
  
  protected void k()
  {
    QCircleCommentInputPopupWindow.1 local1 = new QCircleCommentInputPopupWindow.1(this);
    this.v = ((LinearLayout)this.a.findViewById(2131437601));
    this.n = HostEmotionUtil.getEmojiPanel(HostUIHelper.getInstance().getHostApplicationContext(), local1);
    this.n.setVisibility(0);
    this.v.addView(this.n, new LinearLayout.LayoutParams(-1, -1));
  }
  
  protected boolean l()
  {
    try
    {
      int j = QCircleConfigHelper.n();
      int i;
      if (this.t == null) {
        i = 0;
      } else {
        i = Integer.parseInt(this.t.getText().toString());
      }
      if (i > j) {
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick:");
    localStringBuilder.append(paramView.getId());
    QLog.d("QCircleBaseInputPopupWindow", 1, localStringBuilder.toString());
    int i = paramView.getId();
    if (i == 2131429880)
    {
      QLog.d("QCircleBaseInputPopupWindow", 1, "btn_emotion");
      q();
      this.r.setVisibility(0);
      this.s.setVisibility(8);
    }
    else if (i == 2131447156)
    {
      QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
      b(true);
      this.r.setVisibility(8);
      this.s.setVisibility(0);
    }
    else if (i == 2131429958)
    {
      if ((!l()) && (this.j != null)) {
        this.j.a();
      }
    }
    else if (i == 2131429918)
    {
      QLog.d("QCircleBaseInputPopupWindow", 1, "btn_keyboard");
      b(true);
      this.r.setVisibility(8);
      this.s.setVisibility(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.s.setVisibility(8);
    this.r.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */