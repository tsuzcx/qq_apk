package com.tencent.biz.pubaccount.weishi_new.comment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.subscribe.comment.CommentBoxListener;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.SafeDialog;
import com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.widget.QzoneEmotionUtils;

public class WsCommentInputPopupWindow
  extends SafeDialog
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSCommentEmoController jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentEmoController;
  private WsCommentInputPopupWindow.OnDismissListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow$OnDismissListener;
  private CommentBoxListener jdField_a_of_type_ComTencentBizSubscribeCommentCommentBoxListener;
  private CommentEditText jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private ImageButton jdField_c_of_type_AndroidWidgetImageButton;
  private int jdField_d_of_type_Int = 140;
  private ImageButton jdField_d_of_type_AndroidWidgetImageButton;
  
  public WsCommentInputPopupWindow(Activity paramActivity)
  {
    super(paramActivity, 2131755691);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131559994, null);
    b();
    setCancelable(true);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    c();
    d();
    setOnDismissListener(this);
    D_();
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private WSCommentEmoController a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentEmoController == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentEmoController = new WSCommentEmoController();
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentEmoController;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(paramInt1);
    this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(paramInt1);
    this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(paramInt1);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(paramInt2);
  }
  
  private void a(boolean paramBoolean)
  {
    a().c();
    d(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
    }
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
  }
  
  private void b()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setSoftInputMode(16);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      c(this.jdField_b_of_type_AndroidViewView);
    }
    a().b();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.clearFocus();
    }
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    if (this.jdField_a_of_type_AndroidWidgetEditText == null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = new EditText(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText.getParent() == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetEditText, 0, new LinearLayout.LayoutParams(1, 1));
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365264));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363924));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131378535));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new WsCommentInputPopupWindow.1(this));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363962));
    this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363954));
    this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363937));
    this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364001));
    this.jdField_a_of_type_AndroidContentSharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("GroupSoftKeyboardHeight", AIOUtils.b(250.0F, getContext().getResources()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mEmojiPanel initView() step1 :");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    WSLog.b("CommentInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ScreenUtil.dip2px(250.0F);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel initView() step2 :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      WSLog.b("CommentInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
    localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366116);
    a().a((PublicFragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText, this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363669);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new WsCommentInputPopupWindow.2(this));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method"));
    this.jdField_a_of_type_Boolean = true;
    e();
  }
  
  private void c(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    g();
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
    a().a(this.jdField_a_of_type_Int);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mEmojiPanel onGetKeyBoardHeight() :");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    WSLog.b("CommentInputPopupWindow", 1, localStringBuilder.toString());
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper = new SoftKeyboardStateHelper(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper.a(new WsCommentInputPopupWindow.3(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnFocusChangeListener(new WsCommentInputPopupWindow.5(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new WsCommentInputPopupWindow.6(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new WsCommentInputPopupWindow.7(this));
  }
  
  @TargetApi(19)
  public void D_()
  {
    super.D_();
    Object localObject = getWindow();
    if (localObject == null) {
      return;
    }
    localObject = ((Window)localObject).getDecorView();
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      int i = 0;
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        int j = ((ViewGroup)localObject).getChildCount();
        while (i < j)
        {
          View localView = ((ViewGroup)localObject).getChildAt(i);
          if (localView == null) {
            return;
          }
          if (localView.getId() == 16908290) {
            return;
          }
          if (!(localView instanceof ViewStub)) {
            localView.setAlpha(0.0F);
          }
          i += 1;
        }
      }
    }
  }
  
  public String a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
    String str = "";
    if (localObject1 == null) {
      return "";
    }
    Object localObject2;
    if ((((CommentEditText)localObject1).getText() instanceof QzoneTextBuilder))
    {
      localObject2 = (QzoneTextBuilder)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
      localObject1 = str;
      if (localObject2 != null) {
        localObject1 = ((QzoneTextBuilder)localObject2).toPlainText();
      }
    }
    else
    {
      localObject1 = str;
      if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof QQTextBuilder))
      {
        localObject2 = (QQTextBuilder)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
        localObject1 = str;
        if (localObject2 != null) {
          localObject1 = a((QQTextBuilder)localObject2);
        }
      }
    }
    if ((!android.text.TextUtils.isEmpty((CharSequence)localObject1)) && (!android.text.TextUtils.equals("[emoji]", (CharSequence)localObject1))) {
      return QzoneEmotionUtils.splash2Emo((String)localObject1);
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText().toString();
  }
  
  public String a(QQTextBuilder paramQQTextBuilder)
  {
    int i = paramQQTextBuilder.length();
    Object localObject1 = new char[i];
    int j = 0;
    paramQQTextBuilder.getChars(0, i, (char[])localObject1, 0);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((char[])localObject1);
    localObject1 = (EmoticonSpan[])paramQQTextBuilder.getSpans(0, i, EmoticonSpan.class);
    int m = localObject1.length;
    int k = 0;
    while (j < m)
    {
      Object localObject2 = localObject1[j];
      int n = paramQQTextBuilder.getSpanStart(localObject2);
      int i1 = paramQQTextBuilder.getSpanEnd(localObject2);
      i = ((EmoticonSpan)localObject2).emojiType;
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2) {
            break label248;
          }
          localObject2 = ((EmoticonSpan)localObject2).getDescription();
          localStringBuffer.replace(n + k, i1 + k, (String)localObject2);
          i = ((String)localObject2).length();
        }
        else
        {
          localObject2 = QQSysFaceUtil.getFaceDescription(((EmoticonSpan)localObject2).index & 0x7FFFFFFF);
          localStringBuffer.replace(n + k, i1 + k, (String)localObject2);
          i = ((String)localObject2).length();
        }
      }
      for (;;)
      {
        k += i - (i1 - n);
        break label248;
        try
        {
          localObject2 = com.tencent.mobileqq.text.TextUtils.getEmojiString(((EmoticonSpan)localObject2).index);
          localStringBuffer.replace(n + k, i1 + k, (String)localObject2);
          i = ((String)localObject2).length();
        }
        catch (Exception localException)
        {
          WSLog.d("CommentInputPopupWindow", localException.getMessage());
        }
      }
      label248:
      j += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void a(int paramInt)
  {
    show();
    f();
    if (paramInt > 0)
    {
      a().post(new WsCommentInputPopupWindow.9(this, paramInt));
      return;
    }
    a().post(new WsCommentInputPopupWindow.10(this));
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new WsCommentInputPopupWindow.8(this, paramView));
  }
  
  public void a(WsCommentInputPopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(CommentBoxListener paramCommentBoxListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBoxListener = paramCommentBoxListener;
  }
  
  public void a(String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setHint(paramString);
    }
  }
  
  public void b(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public void b(String paramString)
  {
    CommentEditText localCommentEditText = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
    if (localCommentEditText == null) {
      return;
    }
    localCommentEditText.setText(paramString);
  }
  
  public void dismiss()
  {
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    a(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick:");
    localStringBuilder.append(paramView.getId());
    WSLog.b("CommentInputPopupWindow", 1, localStringBuilder.toString());
    switch (paramView.getId())
    {
    default: 
    case 2131378535: 
      WSLog.b("CommentInputPopupWindow", 1, "text_input");
      a(true);
      a(8, 0);
      return;
    case 2131364001: 
      paramView = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBoxListener;
      if (paramView != null)
      {
        paramView.a();
        return;
      }
      break;
    case 2131363962: 
      WSLog.b("CommentInputPopupWindow", 1, "btn_keyboard");
      a(true);
      a(8, 0);
      return;
    case 2131363954: 
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length() > this.jdField_d_of_type_Int)
      {
        paramView = getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131702369));
        localStringBuilder.append(this.jdField_d_of_type_Int);
        localStringBuilder.append(HardCodeUtil.a(2131702370));
        QQToast.a(paramView, localStringBuilder.toString(), 0).a();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.append("[em]e166[/em]");
      a(0, 8);
      return;
    case 2131363937: 
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length() > this.jdField_d_of_type_Int)
      {
        paramView = getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131702369));
        localStringBuilder.append(this.jdField_d_of_type_Int);
        localStringBuilder.append(HardCodeUtil.a(2131702370));
        QQToast.a(paramView, localStringBuilder.toString(), 0).a();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.append("[em]e163[/em]");
      a(0, 8);
      return;
    case 2131363924: 
      WSLog.b("CommentInputPopupWindow", 1, "btn_emotion");
      b(false);
      a(0, 8);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper = null;
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_Boolean = false;
    a(false);
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow$OnDismissListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
    paramDialogInterface = this.jdField_a_of_type_AndroidWidgetEditText;
    if ((paramDialogInterface != null) && (paramDialogInterface.getParent() != null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetEditText = null;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.clearFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */