package com.tencent.biz.subscribe.comment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;

public class SubscribeCommentInputPopupWindow
  extends SafeDialog
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  protected View a;
  protected CommentEditText b;
  private SharedPreferences d;
  private SharedPreferences.Editor e;
  private Activity f;
  private ImageButton g;
  private ImageButton h;
  private Button i;
  private int j;
  private IEmoticonMainPanel k;
  private SystemAndEmojiEmoticonPanel l;
  private InputMethodManager m;
  private boolean n = false;
  private int o = -1;
  private boolean p = false;
  private int q = 0;
  private SubscribeCommentInputPopupWindow.EventListener r;
  private SubscribeCommentInputPopupWindow.OnDismissListener s;
  private View t;
  private SoftKeyboardStateHelper u;
  private Handler v;
  private AlphaAnimation w;
  private LinearLayout x;
  private boolean y = false;
  
  public SubscribeCommentInputPopupWindow(Activity paramActivity)
  {
    super(paramActivity, 2131952655);
    this.f = paramActivity;
    this.a = LayoutInflater.from(getContext()).inflate(2131624355, null);
    b();
    setCancelable(true);
    e();
    setContentView(this.a);
    h();
    setOnDismissListener(this);
    aF_();
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).getView().setVisibility(8);
    }
    localObject = this.l;
    if (localObject != null) {
      ((SystemAndEmojiEmoticonPanel)localObject).setVisibility(8);
    }
    d(this.t);
    if (paramBoolean) {
      a(this.b);
    }
  }
  
  private void c(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void d(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.x = ((LinearLayout)this.a.findViewById(2131431066));
    this.g = ((ImageButton)this.a.findViewById(2131429880));
    this.b = ((CommentEditText)this.a.findViewById(2131447156));
    this.b.setOnInputBackListener(new SubscribeCommentInputPopupWindow.1(this));
    this.b.setEditableFactory(QzoneTextBuilder.a);
    this.h = ((ImageButton)this.a.findViewById(2131429918));
    this.i = ((Button)this.a.findViewById(2131429958));
    this.d = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.e = this.d.edit();
    this.j = this.d.getInt("GroupSoftKeyboardHeight", AIOUtils.b(250.0F, getContext().getResources()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mEmojiPanel initView() step1 :");
    localStringBuilder.append(this.j);
    QLog.d("QCircleBaseInputPopupWindow", 1, localStringBuilder.toString());
    if (this.j == 0)
    {
      this.j = ScreenUtil.dip2px(250.0F);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mEmojiPanel initView() step2 :");
      localStringBuilder.append(this.j);
      QLog.d("QCircleBaseInputPopupWindow", 1, localStringBuilder.toString());
    }
    f();
    this.t = this.a.findViewById(2131429582);
    this.t.setOnClickListener(new SubscribeCommentInputPopupWindow.2(this));
    this.m = ((InputMethodManager)this.f.getSystemService("input_method"));
    this.n = true;
    i();
    this.a.setVisibility(4);
  }
  
  private void f()
  {
    SubscribeCommentInputPopupWindow.3 local3 = new SubscribeCommentInputPopupWindow.3(this);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      int i1 = getContext().getResources().getDimensionPixelSize(2131299920);
      this.k = ((IEmoticonMainPanel)this.a.findViewById(2131432403));
      this.k.setCallBack(local3);
      this.k.setOnlySysAndEmoji(true);
      this.k.init((QQAppInterface)localObject, 100003, getContext(), i1, null, null, false);
      this.k.hideAllTabs();
      return;
    }
    QLog.e("QCircleBaseInputPopupWindow", 1, "initEmojiPanel() runtime != QQAppInterface");
    localObject = this.f;
    if ((localObject != null) && (this.x != null))
    {
      this.l = new SystemAndEmojiEmoticonPanel((Context)localObject, local3);
      this.l.setBackgroundColor(-1);
      this.x.addView(this.l);
    }
  }
  
  private void h()
  {
    this.g.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    k();
  }
  
  private void i()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((IEmoticonMainPanel)localObject).getView().getLayoutParams() != null))
    {
      this.k.getView().getLayoutParams().height = this.j;
      this.k.getView().invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("QCircleBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.l;
    if ((localObject != null) && (((SystemAndEmojiEmoticonPanel)localObject).getLayoutParams() != null))
    {
      this.l.getLayoutParams().height = this.j;
      this.l.invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("QCircleBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void j()
  {
    this.u = new SoftKeyboardStateHelper(this.a);
    this.u.a(new SubscribeCommentInputPopupWindow.5(this));
    this.a.getViewTreeObserver();
  }
  
  private void k()
  {
    this.b.setImeOptions(268435456);
    this.b.setOnEditorActionListener(new SubscribeCommentInputPopupWindow.7(this));
    this.b.addTextChangedListener(new SubscribeCommentInputPopupWindow.8(this));
  }
  
  private void l()
  {
    if (this.p) {
      c(this.t);
    }
    this.y = true;
    Object localObject = this.k;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).getView().setVisibility(0);
    }
    localObject = this.l;
    if (localObject != null) {
      ((SystemAndEmojiEmoticonPanel)localObject).setVisibility(0);
    }
    b(this.b);
  }
  
  private Handler m()
  {
    if (this.v == null) {
      this.v = new Handler(Looper.getMainLooper());
    }
    return this.v;
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new SubscribeCommentInputPopupWindow.9(this, paramView));
  }
  
  public void a(SubscribeCommentInputPopupWindow.EventListener paramEventListener)
  {
    this.r = paramEventListener;
  }
  
  public void a(SubscribeCommentInputPopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.s = paramOnDismissListener;
  }
  
  public void a(String paramString)
  {
    CommentEditText localCommentEditText = this.b;
    if (localCommentEditText == null) {
      return;
    }
    localCommentEditText.setText(paramString);
    this.b.setSelection(paramString.length());
  }
  
  public void a(boolean paramBoolean)
  {
    show();
    j();
    if (paramBoolean)
    {
      m().post(new SubscribeCommentInputPopupWindow.11(this));
      return;
    }
    m().post(new SubscribeCommentInputPopupWindow.12(this));
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
  
  protected void b()
  {
    if ((getWindow() != null) && (getWindow().getAttributes() != null))
    {
      Window localWindow = getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setSoftInputMode(16);
    }
  }
  
  public void b(View paramView)
  {
    paramView.post(new SubscribeCommentInputPopupWindow.10(this, paramView));
  }
  
  public void b(String paramString)
  {
    CommentEditText localCommentEditText = this.b;
    if (localCommentEditText != null) {
      localCommentEditText.setHint(paramString);
    }
  }
  
  protected void c()
  {
    if (this.a != null)
    {
      this.w = new AlphaAnimation(0.0F, 1.0F);
      this.w.setDuration(200L);
      this.w.setAnimationListener(new SubscribeCommentInputPopupWindow.4(this));
      this.a.setAnimation(this.w);
      this.w.start();
    }
  }
  
  public String d()
  {
    Object localObject1 = this.b;
    String str = "";
    if (localObject1 == null) {
      return "";
    }
    Object localObject2;
    if ((((CommentEditText)localObject1).getText() instanceof QzoneTextBuilder))
    {
      localObject2 = (QzoneTextBuilder)this.b.getText();
      localObject1 = str;
      if (localObject2 != null) {
        localObject1 = ((QzoneTextBuilder)localObject2).toPlainText();
      }
    }
    else
    {
      localObject1 = str;
      if ((this.b.getText() instanceof QQTextBuilder))
      {
        localObject2 = (QQTextBuilder)this.b.getText();
        localObject1 = str;
        if (localObject2 != null) {
          localObject1 = ((QQTextBuilder)localObject2).toPlainText();
        }
      }
    }
    return QzoneEmotionUtils.splash2Emo(((String)localObject1).replaceAll(HardCodeUtil.a(2131903750), HardCodeUtil.a(2131903752)).replaceAll(HardCodeUtil.a(2131903749), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(2131914654), "/chigua")).trim();
  }
  
  public void dismiss()
  {
    b(this.b);
    b(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick:");
    ((StringBuilder)localObject).append(paramView.getId());
    QLog.d("QCircleBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131447156: 
      QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
      b(true);
      this.h.setVisibility(8);
      this.g.setVisibility(0);
      break;
    case 2131429958: 
      localObject = this.r;
      if (localObject != null) {
        ((SubscribeCommentInputPopupWindow.EventListener)localObject).a();
      }
      break;
    case 2131429918: 
      QLog.d("QCircleBaseInputPopupWindow", 1, "btn_keyboard");
      b(true);
      this.h.setVisibility(8);
      this.g.setVisibility(0);
      break;
    case 2131429880: 
      QLog.d("QCircleBaseInputPopupWindow", 1, "btn_emotion");
      l();
      this.h.setVisibility(0);
      this.g.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.u;
    if (paramDialogInterface != null)
    {
      paramDialogInterface.a();
      this.u = null;
    }
    this.g.setVisibility(8);
    this.h.setVisibility(0);
    this.p = false;
    paramDialogInterface = this.s;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */