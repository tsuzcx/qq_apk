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
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected CommentEditText a;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper;
  private SubscribeCommentInputPopupWindow.EventListener jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow$EventListener;
  private SubscribeCommentInputPopupWindow.OnDismissListener jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow$OnDismissListener;
  private IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  
  public SubscribeCommentInputPopupWindow(Activity paramActivity)
  {
    super(paramActivity, 2131755690);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558735, null);
    b();
    setCancelable(true);
    d();
    setContentView(this.jdField_a_of_type_AndroidViewView);
    f();
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
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).getView().setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
    if (localObject != null) {
      ((SystemAndEmojiEmoticonPanel)localObject).setVisibility(8);
    }
    d(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean) {
      a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    }
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364941));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363924));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131378535));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new SubscribeCommentInputPopupWindow.1(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setEditableFactory(QzoneTextBuilder.a);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363962));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364001));
    this.jdField_a_of_type_AndroidContentSharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("GroupSoftKeyboardHeight", AIOUtils.b(250.0F, getContext().getResources()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mEmojiPanel initView() step1 :");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("QCircleBaseInputPopupWindow", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ScreenUtil.dip2px(250.0F);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mEmojiPanel initView() step2 :");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("QCircleBaseInputPopupWindow", 1, localStringBuilder.toString());
    }
    e();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363669);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new SubscribeCommentInputPopupWindow.2(this));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method"));
    this.jdField_a_of_type_Boolean = true;
    g();
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
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
    SubscribeCommentInputPopupWindow.3 local3 = new SubscribeCommentInputPopupWindow.3(this);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299168);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = ((IEmoticonMainPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131366117));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.setCallBack(local3);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.setOnlySysAndEmoji(true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.init((QQAppInterface)localObject, 100003, getContext(), i, null, null, false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.hideAllTabs();
      return;
    }
    QLog.e("QCircleBaseInputPopupWindow", 1, "initEmojiPanel() runtime != QQAppInterface");
    localObject = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel((Context)localObject, local3);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    i();
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if ((localObject != null) && (((IEmoticonMainPanel)localObject).getView().getLayoutParams() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().getLayoutParams().height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("QCircleBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
    if ((localObject != null) && (((SystemAndEmojiEmoticonPanel)localObject).getLayoutParams() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getLayoutParams().height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("QCircleBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper = new SoftKeyboardStateHelper(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper.a(new SubscribeCommentInputPopupWindow.5(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new SubscribeCommentInputPopupWindow.7(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new SubscribeCommentInputPopupWindow.8(this));
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_Boolean) {
      c(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_c_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).getView().setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
    if (localObject != null) {
      ((SystemAndEmojiEmoticonPanel)localObject).setVisibility(0);
    }
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
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
          localObject1 = ((QQTextBuilder)localObject2).toPlainText();
        }
      }
    }
    return QzoneEmotionUtils.splash2Emo(((String)localObject1).replaceAll(HardCodeUtil.a(2131705865), HardCodeUtil.a(2131705867)).replaceAll(HardCodeUtil.a(2131705864), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(2131717181), "/chigua")).trim();
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new SubscribeCommentInputPopupWindow.9(this, paramView));
  }
  
  public void a(SubscribeCommentInputPopupWindow.EventListener paramEventListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow$EventListener = paramEventListener;
  }
  
  public void a(SubscribeCommentInputPopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(String paramString)
  {
    CommentEditText localCommentEditText = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
    if (localCommentEditText == null) {
      return;
    }
    localCommentEditText.setText(paramString);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setSelection(paramString.length());
  }
  
  public void a(boolean paramBoolean)
  {
    show();
    h();
    if (paramBoolean)
    {
      a().post(new SubscribeCommentInputPopupWindow.11(this));
      return;
    }
    a().post(new SubscribeCommentInputPopupWindow.12(this));
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
    CommentEditText localCommentEditText = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
    if (localCommentEditText != null) {
      localCommentEditText.setHint(paramString);
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new SubscribeCommentInputPopupWindow.4(this));
      this.jdField_a_of_type_AndroidViewView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.start();
    }
  }
  
  public void dismiss()
  {
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
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
    case 2131378535: 
      QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
      b(true);
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      break;
    case 2131364001: 
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow$EventListener;
      if (localObject != null) {
        ((SubscribeCommentInputPopupWindow.EventListener)localObject).a();
      }
      break;
    case 2131363962: 
      QLog.d("QCircleBaseInputPopupWindow", 1, "btn_keyboard");
      b(true);
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      break;
    case 2131363924: 
      QLog.d("QCircleBaseInputPopupWindow", 1, "btn_emotion");
      j();
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper;
    if (paramDialogInterface != null)
    {
      paramDialogInterface.a();
      this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_Boolean = false;
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow$OnDismissListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */