package com.tencent.biz.pubaccount.weishi_new.comment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.event.WSActivityResultEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentSuccessEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide.WSCommentAtHelper;
import com.tencent.biz.subscribe.comment.CommentBoxListener;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.SafeDialog;
import com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper;
import com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;

public class WsCommentInputPopupWindow
  extends SafeDialog
  implements DialogInterface.OnDismissListener, View.OnClickListener, WSCommentInputView, WSSimpleEventReceiver
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  private final Activity d;
  private final View e;
  private LinearLayout f;
  private ImageButton g;
  private EditText h;
  private CommentEditText i;
  private KandianUrlImageView j;
  private ImageButton k;
  private View l;
  private SoftKeyboardStateHelper.SoftKeyboardStateListener m;
  private SoftKeyboardStateHelper n;
  private WSCommentEmoController o;
  private CommentBoxListener p;
  private InputMethodManager q;
  private WsCommentInputPopupWindow.OnDismissListener r;
  private Handler s;
  private WSCommentInputPresenter t;
  private WSOnGetReportInfo u;
  private boolean v = false;
  private boolean w;
  private int x;
  
  public WsCommentInputPopupWindow(Activity paramActivity, WSOnGetReportInfo paramWSOnGetReportInfo)
  {
    super(paramActivity, 2131952656);
    this.u = paramWSOnGetReportInfo;
    this.d = paramActivity;
    this.e = LayoutInflater.from(getContext()).inflate(2131626037, null);
    this.t = new WSCommentInputPresenter(this);
    h();
    setCancelable(true);
    setContentView(this.e);
    i();
    l();
    setOnDismissListener(this);
    aF_();
  }
  
  private void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
    ImageButton localImageButton = this.g;
    int i1;
    if (paramBoolean) {
      i1 = 2130853522;
    } else {
      i1 = 2130853508;
    }
    localImageButton.setImageResource(i1);
  }
  
  private void b(boolean paramBoolean)
  {
    j().c();
    WSCommentUtil.b(this.l);
    if (paramBoolean)
    {
      a(this.i);
      return;
    }
    b(this.i);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.v) {
      WSCommentUtil.a(this.l);
    }
    j().b();
    if (paramBoolean) {
      this.i.clearFocus();
    }
    b(this.i);
    if (this.h == null)
    {
      this.h = new EditText(this.f.getContext());
      this.h.setBackgroundColor(0);
    }
    if (this.h.getParent() == null) {
      this.f.addView(this.h, 0, new LinearLayout.LayoutParams(1, 1));
    }
  }
  
  private void h()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setSoftInputMode(16);
  }
  
  private void i()
  {
    this.f = ((LinearLayout)this.e.findViewById(2131431436));
    this.g = ((ImageButton)this.e.findViewById(2131429880));
    this.i = ((CommentEditText)this.e.findViewById(2131447156));
    this.i.setOnInputBackListener(new WsCommentInputPopupWindow.1(this));
    this.j = ((KandianUrlImageView)this.e.findViewById(2131429804));
    this.j.setOnClickListener(this);
    q();
    this.k = ((ImageButton)this.e.findViewById(2131429958));
    this.a = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.b = this.a.edit();
    this.x = this.a.getInt("GroupSoftKeyboardHeight", AIOUtils.b(250.0F, getContext().getResources()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mEmojiPanel initView() step1 :");
    ((StringBuilder)localObject).append(this.x);
    WSLog.b("WsCommentInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    if (this.x == 0)
    {
      this.x = ScreenUtil.dip2px(250.0F);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel initView() step2 :");
      ((StringBuilder)localObject).append(this.x);
      WSLog.b("WsCommentInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
    localObject = (ViewGroup)this.e.findViewById(2131432402);
    j().a((PublicFragmentActivity)this.d, (ViewGroup)localObject, this.i, this.x);
    this.l = this.e.findViewById(2131429582);
    this.l.setOnClickListener(new WsCommentInputPopupWindow.2(this));
    this.q = ((InputMethodManager)this.d.getSystemService("input_method"));
    m();
  }
  
  private WSCommentEmoController j()
  {
    if (this.o == null) {
      this.o = new WSCommentEmoController();
    }
    return this.o;
  }
  
  private void k()
  {
    if (this.i == null) {
      return;
    }
    p();
  }
  
  private void l()
  {
    WSSimpleEventBus.a().a(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
    o();
  }
  
  private void m()
  {
    j().a(this.x);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mEmojiPanel onGetKeyBoardHeight() :");
    localStringBuilder.append(this.x);
    WSLog.b("WsCommentInputPopupWindow", 1, localStringBuilder.toString());
  }
  
  private void n()
  {
    this.n = new SoftKeyboardStateHelper(this.e);
    this.m = new WsCommentInputPopupWindow.4(this);
    this.n.a(this.m);
  }
  
  private void o()
  {
    this.i.setImeOptions(268435456);
    this.i.setOnFocusChangeListener(new WsCommentInputPopupWindow.5(this));
    this.i.setOnEditorActionListener(new WsCommentInputPopupWindow.6(this));
    CommentEditText localCommentEditText = this.i;
    localCommentEditText.addTextChangedListener(new WsCommentInputPopupWindow.7(this, localCommentEditText));
  }
  
  private void p()
  {
    this.n.b(this.m);
    WSLog.b("WsCommentInputPopupWindow", "[WsCommentInputPopupWindow.java][onAtClick] 呼起好友选择器");
    this.t.a(this.d, 1056, this.i.getText().toString());
  }
  
  private void q()
  {
    if (WSCommentAtHelper.a.b())
    {
      this.j.setVisibility(0);
      String str = WSCommentAtHelper.a.c();
      WSPicLoader.a().a(this.j, str, WSFeedUtils.f(2130853504));
      return;
    }
    this.j.setVisibility(8);
  }
  
  private Handler r()
  {
    if (this.s == null) {
      this.s = new Handler(Looper.getMainLooper());
    }
    return this.s;
  }
  
  public void a(int paramInt)
  {
    show();
    n();
    if (paramInt > 0) {
      r().post(new WsCommentInputPopupWindow.10(this));
    } else {
      r().post(new WsCommentInputPopupWindow.11(this));
    }
    WsCommentInputPopupWindow.OnDismissListener localOnDismissListener = this.r;
    if (localOnDismissListener != null) {
      localOnDismissListener.a();
    }
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i2 = this.i.getSelectionStart();
    int i1 = i2;
    if (i2 >= 1)
    {
      Editable localEditable = this.i.getText();
      int i3 = i2 - 1;
      i1 = i2;
      if (localEditable.charAt(i3) == '@')
      {
        this.i.getText().delete(i3, i2);
        i1 = i3;
      }
    }
    this.i.getText().insert(i1, paramSpannableStringBuilder);
    this.i.setSelection(i1 + paramSpannableStringBuilder.length());
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new WsCommentInputPopupWindow.9(this, paramView));
  }
  
  public void a(WsCommentInputPopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.r = paramOnDismissListener;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof WSActivityResultEvent))
    {
      WSActivityResultEvent localWSActivityResultEvent = (WSActivityResultEvent)paramWSSimpleBaseEvent;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WsCommentInputPopupWindow.java][onReceiveEvent] event:");
      localStringBuilder.append(paramWSSimpleBaseEvent);
      WSLog.b("WsCommentInputPopupWindow", localStringBuilder.toString());
      if (localWSActivityResultEvent.getRequestCode() == 1056)
      {
        r().postDelayed(new WsCommentInputPopupWindow.8(this), 200L);
        this.t.a(paramWSSimpleBaseEvent);
      }
    }
    else if ((paramWSSimpleBaseEvent instanceof WSCommentSuccessEvent))
    {
      this.t.a(paramWSSimpleBaseEvent);
    }
  }
  
  public void a(CommentBoxListener paramCommentBoxListener)
  {
    this.p = paramCommentBoxListener;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.i.setHint(paramString);
    }
  }
  
  @TargetApi(19)
  public void aF_()
  {
    super.aF_();
    WSCommentUtil.a(getWindow());
  }
  
  public void b()
  {
    r().post(new WsCommentInputPopupWindow.3(this));
  }
  
  public void b(View paramView)
  {
    if (paramView != null) {
      this.q.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public void b(String paramString)
  {
    CommentEditText localCommentEditText = this.i;
    if (localCommentEditText == null) {
      return;
    }
    localCommentEditText.setText(paramString);
    int i1 = 0;
    if (!TextUtils.isEmpty(this.i.getText())) {
      i1 = paramString.length();
    }
    this.i.setSelection(i1);
  }
  
  public String c()
  {
    Object localObject1 = this.i;
    Object localObject2 = "";
    if (localObject1 == null) {
      return "";
    }
    Object localObject3;
    if ((((CommentEditText)localObject1).getText() instanceof QzoneTextBuilder))
    {
      localObject3 = (QzoneTextBuilder)this.i.getText();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((QzoneTextBuilder)localObject3).toPlainText();
      }
    }
    else
    {
      localObject1 = localObject2;
      if ((this.i.getText() instanceof QQTextBuilder))
      {
        localObject3 = (QQTextBuilder)this.i.getText();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = WSCommentUtil.a((QQTextBuilder)localObject3);
        }
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals("[emoji]", (CharSequence)localObject1))) {
      localObject1 = QzoneEmotionUtils.splash2Emo((String)localObject1);
    } else {
      localObject1 = this.i.getText().toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[WsCommentInputPopupWindow.java][getText] text:");
    ((StringBuilder)localObject2).append((String)localObject1);
    WSLog.e("WsCommentInputPopupWindow", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public String d()
  {
    return this.t.a(c());
  }
  
  public void dismiss()
  {
    b(this.i);
    b(false);
    super.dismiss();
  }
  
  public ArrayList<String> e()
  {
    return this.t.b();
  }
  
  public void f()
  {
    WSSimpleEventBus.a().b(this);
    r().removeCallbacksAndMessages(null);
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick:");
    localStringBuilder.append(paramView.getId());
    WSLog.b("WsCommentInputPopupWindow", 1, localStringBuilder.toString());
    switch (paramView.getId())
    {
    default: 
    case 2131447156: 
      WSLog.b("WsCommentInputPopupWindow", 1, "text_input");
      b(true);
      a(false);
      return;
    case 2131429958: 
      paramView = this.p;
      if (paramView != null)
      {
        paramView.a();
        return;
      }
      break;
    case 2131429880: 
      WSLog.b("WsCommentInputPopupWindow", 1, "btn_emotion");
      if (this.w)
      {
        b(true);
        a(false);
        return;
      }
      c(false);
      a(true);
      return;
    case 2131429804: 
      k();
      WSCommentBeaconReport.a(this.u.a(), this.u.b(), this.u.c(), this.u.d());
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.n;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
    this.n = null;
    a(true);
    this.v = false;
    b(false);
    paramDialogInterface = this.r;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(c());
    }
    paramDialogInterface = this.h;
    if ((paramDialogInterface != null) && (paramDialogInterface.getParent() != null))
    {
      this.f.removeView(this.h);
      this.h = null;
      this.i.clearFocus();
    }
  }
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSActivityResultEvent.class);
    localArrayList.add(WSCommentSuccessEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */