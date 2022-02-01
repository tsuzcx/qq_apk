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
  private static final String b = BaseApplication.getContext().getString(2131893228);
  private static final String c = BaseApplication.getContext().getString(2131893231);
  public boolean a = false;
  private final Activity d;
  private final InputMethodManager e;
  private EditText f;
  private ImageView g;
  private ViewGroup h;
  private VideoChatRoomListView i;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private final Rect m = new Rect();
  private final Point n = new Point();
  private EmotionInputDetector.EventListener o;
  private final WeakReferenceHandler p = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private int q = -1;
  private int r = -1;
  
  private EmotionInputDetector(Activity paramActivity)
  {
    this.d = paramActivity;
    this.e = ((InputMethodManager)paramActivity.getSystemService("input_method"));
    this.d.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    if (Build.VERSION.SDK_INT <= 18) {
      this.a = true;
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("EmotionInputDetector, ARMode2[");
      paramActivity.append(this.a);
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
    if (this.l != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, String.format("updateInputPanelState, [%s --> %s], seq[%s], soft[%s]", new Object[] { Integer.valueOf(this.l), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(this.j) }));
      }
      this.l = paramInt;
      EmotionInputDetector.EventListener localEventListener = this.o;
      if (localEventListener != null) {
        localEventListener.a(this.l, paramLong);
      }
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    int i1 = this.k;
    if (i1 != paramInt) {
      this.k = paramInt;
    }
    EmotionInputDetector.EventListener localEventListener = this.o;
    if ((localEventListener != null) && (i1 != paramInt)) {
      localEventListener.b(i1, paramInt, this.l, paramLong);
    }
  }
  
  private void i()
  {
    Object localObject = this.f.getText();
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
    this.f.setText("");
    if ((this.o != null) && (!android.text.TextUtils.isEmpty((CharSequence)localObject))) {
      this.o.a((String)localObject);
    }
  }
  
  private void j()
  {
    long l1 = AudioHelper.c();
    Object localObject;
    if (this.p.hasMessages(2))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showEmotionLayout, is to show. seq[");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append("]");
        QLog.i("ChatRoomUtil", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (f())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showEmotionLayout, is showing. seq[");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append("]");
        QLog.i("ChatRoomUtil", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showEmotionLayout, isSoftKeyboardShown[");
      ((StringBuilder)localObject).append(g());
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomUtil", 2, ((StringBuilder)localObject).toString());
    }
    this.g.setImageResource(2130843171);
    if (g())
    {
      a(5, l1);
      h();
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).arg2 = 0;
      this.p.sendMessageDelayed((Message)localObject, 100L);
      return;
    }
    k();
  }
  
  private void k()
  {
    long l1 = AudioHelper.c();
    this.g.setImageResource(2130843171);
    this.g.setContentDescription(c);
    this.h.setVisibility(0);
    a(4, l1);
    a(l1, 1);
  }
  
  private void l()
  {
    Object localObject = this.d.getWindow().getDecorView();
    View localView = ((View)localObject).getRootView();
    localView.getWindowVisibleDisplayFrame(this.m);
    int i1 = localView.getRootView().getHeight();
    int i2 = i1 - this.m.height();
    if (i2 > i1 / 4) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (i2 > 0)
    {
      int i3 = this.q;
      if (i3 == -1) {
        this.q = i2;
      } else if (i3 > i2) {
        this.q = i2;
      }
      i3 = this.r;
      if (i3 == -1) {
        this.r = i2;
      } else if (i3 < i2) {
        this.r = i2;
      }
      if ((this.q == this.r) && (this.m.top > 0)) {
        this.q = this.m.top;
      }
    }
    if (i1 != this.j)
    {
      long l1 = AudioHelper.c();
      if (i1 == 1)
      {
        this.d.getWindowManager().getDefaultDisplay().getSize(this.n);
        ChatRoomUtil.a = Math.max(this.n.y - this.m.bottom, this.r - this.q);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, String.format("updateSoftKeyboardState, seq[%s], [%s --> %s], inputPanelState[%s], height[%s], KeyBoardHeight[%s], ARMode2[%s], decorView[%s, %s, %s, %s], s[%s, %s], temp[%s, %s, %s, %s], diff[%s, %s]", new Object[] { Long.valueOf(l1), Integer.valueOf(this.j), Integer.valueOf(i1), Integer.valueOf(this.l), Integer.valueOf(i2), Integer.valueOf(ChatRoomUtil.a), Boolean.valueOf(this.a), Integer.valueOf(((View)localObject).getLeft()), Integer.valueOf(((View)localObject).getTop()), Integer.valueOf(((View)localObject).getRight()), Integer.valueOf(((View)localObject).getBottom()), Integer.valueOf(this.n.x), Integer.valueOf(this.n.y), Integer.valueOf(this.m.left), Integer.valueOf(this.m.top), Integer.valueOf(this.m.right), Integer.valueOf(this.m.bottom), Integer.valueOf(this.q), Integer.valueOf(this.r) }));
      }
      i2 = this.j;
      this.j = i1;
      if (this.j == 1)
      {
        this.p.removeMessages(2);
        a(2, l1);
        if (f()) {
          c();
        }
      }
      else if (this.l == 5)
      {
        this.p.removeMessages(2);
        k();
      }
      else if (f())
      {
        a(4, l1);
      }
      else
      {
        a(7, l1);
      }
      localObject = this.o;
      if (localObject != null) {
        ((EmotionInputDetector.EventListener)localObject).a(i2, i1, this.l, l1);
      }
    }
  }
  
  private void m()
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("showSoftKeyboard, seq[%s], emotion[%s], soft[%s]", new Object[] { Long.valueOf(l1), Boolean.valueOf(f()), Boolean.valueOf(g()) }));
    }
    if (g()) {
      return;
    }
    this.f.setFocusable(true);
    this.f.setFocusableInTouchMode(true);
    this.f.requestFocus();
    Object localObject = this.e;
    if (localObject != null) {
      ((InputMethodManager)localObject).showSoftInput(this.f, 1);
    }
    if (!android.text.TextUtils.isEmpty(this.f.getText()))
    {
      localObject = this.f;
      ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
    }
    if (f())
    {
      a(6, l1);
      c();
      return;
    }
    a(1, l1);
  }
  
  public EmotionInputDetector a()
  {
    this.d.getWindow().setSoftInputMode(19);
    return this;
  }
  
  public EmotionInputDetector a(ViewGroup paramViewGroup)
  {
    this.h = paramViewGroup;
    return this;
  }
  
  public EmotionInputDetector a(EditText paramEditText)
  {
    this.f = paramEditText;
    this.f.setFocusable(true);
    this.f.setFocusableInTouchMode(true);
    this.f.requestFocus();
    this.f.setEditableFactory(QQTextBuilder.getCustomSizeEditableFactory(16));
    this.f.setOnClickListener(new EmotionInputDetector.1(this));
    this.f.addTextChangedListener(new EmotionInputDetector.2(this));
    this.f.setOnKeyListener(new EmotionInputDetector.3(this));
    ViewCompat.setAccessibilityDelegate(this.f, new EmotionInputDetector.4(this));
    return this;
  }
  
  public EmotionInputDetector a(ImageView paramImageView)
  {
    this.g = paramImageView;
    this.g.setImageResource(2130843169);
    this.g.setContentDescription(b);
    this.g.setOnClickListener(new EmotionInputDetector.5(this));
    return this;
  }
  
  public EmotionInputDetector a(EmotionInputDetector.EventListener paramEventListener)
  {
    this.o = paramEventListener;
    return this;
  }
  
  public EmotionInputDetector a(VideoChatRoomListView paramVideoChatRoomListView)
  {
    this.i = paramVideoChatRoomListView;
    this.i.setOnDispatchTouchEventResponseListener(new EmotionInputDetector.6(this));
    return this;
  }
  
  public void b()
  {
    this.f.clearFocus();
  }
  
  public void c()
  {
    long l1 = AudioHelper.c();
    if (f())
    {
      this.g.setImageResource(2130843169);
      this.g.setContentDescription(b);
      this.h.setVisibility(8);
      if ((this.l != 6) && (!g())) {
        a(7, l1);
      }
      a(l1, 2);
    }
  }
  
  public int d()
  {
    return this.l;
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.f);
  }
  
  public boolean e()
  {
    boolean bool2 = f();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = g();
    }
    return bool1;
  }
  
  public void emoticonMall() {}
  
  public boolean f()
  {
    ViewGroup localViewGroup = this.h;
    return (localViewGroup != null) && (localViewGroup.getVisibility() == 0);
  }
  
  public boolean g()
  {
    if (this.j == 0) {
      l();
    }
    return this.j == 1;
  }
  
  public void h()
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideSoftKeyboard, soft[");
      localStringBuilder.append(g());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.i("ChatRoomUtil", 2, localStringBuilder.toString());
    }
    if (g())
    {
      this.f.clearFocus();
      this.e.hideSoftInputFromWindow(this.f.getWindowToken(), 0);
      if (this.l != 5) {
        a(3, l1);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if ((g()) && (paramMessage.arg1 == 0))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        paramMessage.arg1 += 1;
        this.p.sendMessageDelayed(localMessage, 100L);
        return true;
      }
      k();
    }
    return true;
  }
  
  public void onGlobalLayout()
  {
    l();
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send()
  {
    i();
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(null, this.d, this.f, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector
 * JD-Core Version:    0.7.0.1
 */