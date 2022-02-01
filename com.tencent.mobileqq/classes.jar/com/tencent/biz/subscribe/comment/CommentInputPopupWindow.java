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
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private CommentBoxListener jdField_a_of_type_ComTencentBizSubscribeCommentCommentBoxListener;
  private CommentEditText jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
  private CommentInputPopupWindow.OnDismissListener jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow$OnDismissListener;
  private EmoView jdField_a_of_type_ComTencentBizSubscribeCommentEmoView;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean jdField_b_of_type_Boolean;
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.setVisibility(8);
    }
    d(this.jdField_a_of_type_AndroidViewView);
    if (paramBoolean) {
      a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.getLayoutParams().height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.invalidate();
    QLog.d("CommentInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.jdField_a_of_type_Int);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      c(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.setVisibility(0);
    WorkSpaceView localWorkSpaceView = (WorkSpaceView)this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.getChildAt(0);
    if (localWorkSpaceView != null) {
      a().post(new CommentInputPopupWindow.8(this, localWorkSpaceView));
    }
    if ("workSpaceView is empty" + localWorkSpaceView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("CommentInputPopupWindow", 1, new Object[] { Boolean.valueOf(bool) });
      b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
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
  
  @TargetApi(19)
  public void K_()
  {
    int i = 0;
    super.K_();
    Object localObject = getWindow();
    if (localObject == null) {}
    label101:
    for (;;)
    {
      return;
      localObject = ((Window)localObject).getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = ((ViewGroup)localObject).getChildAt(0);
        if ((localObject instanceof ViewGroup))
        {
          int j = ((ViewGroup)localObject).getChildCount();
          for (;;)
          {
            if (i >= j) {
              break label101;
            }
            View localView = ((ViewGroup)localObject).getChildAt(i);
            if ((localView == null) || (localView.getId() == 16908290)) {
              break;
            }
            if (!(localView instanceof ViewStub)) {
              localView.setAlpha(0.0F);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new CommentInputPopupWindow.7(this, paramView));
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public void dismiss()
  {
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    a(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    QLog.d("CommentInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("CommentInputPopupWindow", 1, "btn_emotion");
      c();
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      continue;
      QLog.d("CommentInputPopupWindow", 1, "text_input");
      a(true);
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBoxListener != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBoxListener.a();
        continue;
        QLog.d("CommentInputPopupWindow", 1, "btn_keyboard");
        a(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper.a();
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper = null;
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow$OnDismissListener != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow$OnDismissListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */