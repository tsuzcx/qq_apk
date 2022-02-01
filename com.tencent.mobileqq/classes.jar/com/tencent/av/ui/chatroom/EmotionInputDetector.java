package com.tencent.av.ui.chatroom;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class EmotionInputDetector
  implements Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, EmoticonCallback
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131695471);
  private static final String jdField_b_of_type_JavaLangString = BaseApplication.getContext().getString(2131695474);
  private int jdField_a_of_type_Int = 0;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private EmotionInputDetector.EventListener jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector$EventListener;
  private VideoChatRoomListView jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private int c = 0;
  private int d = -1;
  private int e = -1;
  
  private EmotionInputDetector(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramActivity.getSystemService("input_method"));
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    if (Build.VERSION.SDK_INT <= 18) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("EmotionInputDetector, ARMode2[");
      paramActivity.append(this.jdField_a_of_type_Boolean);
      paramActivity.append("], sdk[");
      paramActivity.append(Build.VERSION.SDK_INT);
      paramActivity.append("]");
      QLog.i("ChatRoomUtil", 2, paramActivity.toString());
    }
  }
  
  public static EmotionInputDetector a(Activity paramActivity)
  {
    return new EmotionInputDetector(paramActivity);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.c != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, String.format("updateInputPanelState, [%s --> %s], seq[%s], soft[%s]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      this.c = paramInt;
      EmotionInputDetector.EventListener localEventListener = this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector$EventListener;
      if (localEventListener != null) {
        localEventListener.a(this.c, paramLong);
      }
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    int i = this.jdField_b_of_type_Int;
    if (i != paramInt) {
      this.jdField_b_of_type_Int = paramInt;
    }
    EmotionInputDetector.EventListener localEventListener = this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector$EventListener;
    if ((localEventListener != null) && (i != paramInt)) {
      localEventListener.b(i, paramInt, this.c, paramLong);
    }
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    boolean bool = localObject instanceof QQTextBuilder;
    QQTextBuilder localQQTextBuilder = null;
    if (bool)
    {
      localQQTextBuilder = (QQTextBuilder)localObject;
      localObject = null;
    }
    else
    {
      String str = localObject.toString();
      localObject = str;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(str))
      {
        localQQTextBuilder = new QQTextBuilder(str, 3, 16);
        localObject = str;
      }
    }
    if (localQQTextBuilder != null) {
      localObject = ChatRoomUtil.a(localQQTextBuilder);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    if ((this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector$EventListener != null) && (!android.text.TextUtils.isEmpty((CharSequence)localObject))) {
      this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector$EventListener.a((String)localObject);
    }
  }
  
  private void e()
  {
    long l = AudioHelper.b();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(2))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showEmotionLayout, is to show. seq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]");
        QLog.i("ChatRoomUtil", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (b())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showEmotionLayout, is showing. seq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]");
        QLog.i("ChatRoomUtil", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showEmotionLayout, isSoftKeyboardShown[");
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomUtil", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842236);
    if (c())
    {
      a(5, l);
      c();
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).arg2 = 0;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject, 100L);
      return;
    }
    f();
  }
  
  private void f()
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842236);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    a(4, l);
    a(l, 1);
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    View localView = ((View)localObject).getRootView();
    localView.getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = localView.getRootView().getHeight();
    int j = i - this.jdField_a_of_type_AndroidGraphicsRect.height();
    if (j > i / 4) {
      i = 1;
    } else {
      i = 2;
    }
    if (j > 0)
    {
      int k = this.d;
      if (k == -1) {
        this.d = j;
      } else if (k > j) {
        this.d = j;
      }
      k = this.e;
      if (k == -1) {
        this.e = j;
      } else if (k < j) {
        this.e = j;
      }
      if ((this.d == this.e) && (this.jdField_a_of_type_AndroidGraphicsRect.top > 0)) {
        this.d = this.jdField_a_of_type_AndroidGraphicsRect.top;
      }
    }
    if (i != this.jdField_a_of_type_Int)
    {
      long l = AudioHelper.b();
      if (i == 1)
      {
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getSize(this.jdField_a_of_type_AndroidGraphicsPoint);
        ChatRoomUtil.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_AndroidGraphicsPoint.y - this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.e - this.d);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, String.format("updateSoftKeyboardState, seq[%s], [%s --> %s], inputPanelState[%s], height[%s], KeyBoardHeight[%s], ARMode2[%s], decorView[%s, %s, %s, %s], s[%s, %s], temp[%s, %s, %s, %s], diff[%s, %s]", new Object[] { Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(i), Integer.valueOf(this.c), Integer.valueOf(j), Integer.valueOf(ChatRoomUtil.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(((View)localObject).getLeft()), Integer.valueOf(((View)localObject).getTop()), Integer.valueOf(((View)localObject).getRight()), Integer.valueOf(((View)localObject).getBottom()), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsPoint.x), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsPoint.y), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.left), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.top), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.right), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.bottom), Integer.valueOf(this.d), Integer.valueOf(this.e) }));
      }
      j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
        a(2, l);
        if (b()) {
          b();
        }
      }
      else if (this.c == 5)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
        f();
      }
      else if (b())
      {
        a(4, l);
      }
      else
      {
        a(7, l);
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector$EventListener;
      if (localObject != null) {
        ((EmotionInputDetector.EventListener)localObject).a(j, i, this.c, l);
      }
    }
  }
  
  private void h()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("showSoftKeyboard, seq[%s], emotion[%s], soft[%s]", new Object[] { Long.valueOf(l), Boolean.valueOf(b()), Boolean.valueOf(c()) }));
    }
    if (c()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    Object localObject = this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
    if (localObject != null) {
      ((InputMethodManager)localObject).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 1);
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
    }
    if (b())
    {
      a(6, l);
      b();
      return;
    }
    a(1, l);
  }
  
  public int a()
  {
    return this.c;
  }
  
  public EmotionInputDetector a()
  {
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setSoftInputMode(19);
    return this;
  }
  
  public EmotionInputDetector a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    return this;
  }
  
  public EmotionInputDetector a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.getCustomSizeEditableFactory(16));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new EmotionInputDetector.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new EmotionInputDetector.2(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new EmotionInputDetector.3(this));
    ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetEditText, new EmotionInputDetector.4(this));
    return this;
  }
  
  public EmotionInputDetector a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842234);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new EmotionInputDetector.5(this));
    return this;
  }
  
  public EmotionInputDetector a(EmotionInputDetector.EventListener paramEventListener)
  {
    this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector$EventListener = paramEventListener;
    return this;
  }
  
  public EmotionInputDetector a(VideoChatRoomListView paramVideoChatRoomListView)
  {
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView = paramVideoChatRoomListView;
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView.setOnDispatchTouchEventResponseListener(new EmotionInputDetector.6(this));
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
  }
  
  public boolean a()
  {
    boolean bool2 = b();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = c();
    }
    return bool1;
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842234);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((this.c != 6) && (!c())) {
        a(7, l);
      }
      a(l, 2);
    }
  }
  
  public boolean b()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    return (localViewGroup != null) && (localViewGroup.getVisibility() == 0);
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideSoftKeyboard, soft[");
      localStringBuilder.append(c());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("ChatRoomUtil", 2, localStringBuilder.toString());
    }
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      if (this.c != 5) {
        a(3, l);
      }
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int == 0) {
      g();
    }
    return this.jdField_a_of_type_Int == 1;
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void emoticonMall() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if ((c()) && (paramMessage.arg1 == 0))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        paramMessage.arg1 += 1;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, 100L);
        return true;
      }
      f();
    }
    return true;
  }
  
  public void onGlobalLayout()
  {
    g();
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send()
  {
    d();
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(null, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector
 * JD-Core Version:    0.7.0.1
 */