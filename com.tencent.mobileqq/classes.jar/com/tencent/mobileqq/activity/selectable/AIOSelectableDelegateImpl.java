package com.tencent.mobileqq.activity.selectable;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AIOSelectableDelegateImpl
  implements Handler.Callback, SelectableDelegate
{
  private static final int jdField_a_of_type_Int = ViewUtils.b(30.0F);
  private static final int jdField_b_of_type_Int = ViewUtils.b(28.0F);
  private static final int c = ViewUtils.b(72.0F);
  private static final int d = ViewUtils.b(63.0F);
  protected long a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private SelectableComponent jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
  private SelectableCursor jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
  private SelectableMagnifier jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier;
  protected SelectablePopupMenu a;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private WeakReference<AIOSelectableDelegateProxy> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<OnSelectListener>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private SelectableCursor jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
  private boolean jdField_b_of_type_Boolean = true;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l;
  
  private AIOSelectableDelegateImpl()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static AIOSelectableDelegateImpl a()
  {
    return AIOSelectableDelegateImpl.Holder.a;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.highlightBackgroundColor(this.k);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.selectContent(this.e, this.f);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.highlightContent();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.b(this.l);
    this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.b(this.l);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, true);
    SelectableCursor localSelectableCursor = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    localSelectableCursor.b(arrayOfInt[0], arrayOfInt[1], 1);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.locationByIndex(this.f, this.jdField_a_of_type_ArrayOfInt, false);
    localSelectableCursor = this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    localSelectableCursor.b(arrayOfInt[0], arrayOfInt[1], 2);
  }
  
  private boolean g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent != null;
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor != null) && (this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor != null)) {
      return;
    }
    throw new IllegalStateException("Has not bound cursors.");
  }
  
  private boolean h()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu != null;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier != null) {
      return;
    }
    throw new IllegalStateException("Has no magnifier.");
  }
  
  private void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      OnSelectListener localOnSelectListener = (OnSelectListener)((WeakReference)localIterator.next()).get();
      if (localOnSelectListener != null) {
        localOnSelectListener.a(this);
      }
    }
  }
  
  public int a()
  {
    g();
    SelectableComponent localSelectableComponent = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
    if (localSelectableComponent != null) {
      return localSelectableComponent.contentLength();
    }
    return 0;
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor != null) && (d())) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    if ((paramInt1 == 2) && (this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor != null) && (e())) {
      return this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    g();
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.touchIndex(paramInt1, paramInt2);
  }
  
  @Nullable
  public View a()
  {
    SelectableComponent localSelectableComponent = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
    if (localSelectableComponent != null) {
      return localSelectableComponent.view();
    }
    return null;
  }
  
  @Nullable
  AIOSelectableDelegateProxy a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (AIOSelectableDelegateProxy)localWeakReference.get();
    }
    return null;
  }
  
  @Nullable
  public String a()
  {
    g();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
    if (localObject != null)
    {
      localObject = ((SelectableComponent)localObject).content();
      if (localObject != null) {
        return ((CharSequence)localObject).toString();
      }
    }
    return "";
  }
  
  public void a()
  {
    a((View)null);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      if (paramInt1 > paramInt2)
      {
        this.e = paramInt2;
        this.f = paramInt1;
      }
      else
      {
        this.e = paramInt1;
        this.f = paramInt2;
      }
      if (this.f - this.e > 0) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      this.e = -1;
      this.f = -1;
      this.jdField_a_of_type_Boolean = false;
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.selectContent(this.e, this.f);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.highlightContent();
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, true);
    SelectableCursor localSelectableCursor = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    localSelectableCursor.b(arrayOfInt[0], arrayOfInt[1], 1);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.locationByIndex(this.f, this.jdField_a_of_type_ArrayOfInt, false);
    localSelectableCursor = this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    localSelectableCursor.b(arrayOfInt[0], arrayOfInt[1], 2);
    j();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    g();
    h();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = Integer.valueOf(paramInt3);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 10L);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    g();
    i();
    if (this.g == -1) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = Message.obtain();
    int m;
    if (paramBoolean) {
      m = 2;
    } else {
      m = 3;
    }
    localMessage.what = m;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = Integer.valueOf(this.g);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 10L);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.g = paramInt;
    if (!paramBoolean) {
      this.h = paramInt;
    }
  }
  
  void a(View paramView)
  {
    int m;
    if (paramView != null)
    {
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      m = this.jdField_a_of_type_ArrayOfInt[1];
    }
    else
    {
      m = ViewUtils.b();
    }
    d(m);
  }
  
  void a(BaseChatPie paramBaseChatPie)
  {
    BaseChatPie localBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      SelectablePopupMenu localSelectablePopupMenu = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu;
      localBaseChatPie = paramBaseChatPie;
      if ((localSelectablePopupMenu instanceof AIOMenuWrapper)) {
        localBaseChatPie = ((AIOMenuWrapper)localSelectablePopupMenu).a;
      }
    }
    int m;
    if ((localBaseChatPie != null) && (localBaseChatPie.a != null) && (localBaseChatPie.a.getVisibility() == 0))
    {
      localBaseChatPie.a.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      m = this.jdField_a_of_type_ArrayOfInt[1];
    }
    else
    {
      m = ViewUtils.b();
    }
    d(m);
  }
  
  void a(@Nullable AIOSelectableDelegateProxy paramAIOSelectableDelegateProxy)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAIOSelectableDelegateProxy);
  }
  
  public void a(@NonNull OnSelectListener paramOnSelectListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (paramOnSelectListener == (OnSelectListener)((WeakReference)localIterator.next()).get())
      {
        m = 1;
        break label45;
      }
    }
    int m = 0;
    label45:
    if (m == 0) {
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramOnSelectListener));
    }
  }
  
  public void a(@NonNull SelectableComponent paramSelectableComponent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent = paramSelectableComponent;
  }
  
  public void a(@NonNull SelectableCursor paramSelectableCursor1, @NonNull SelectableCursor paramSelectableCursor2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor = paramSelectableCursor1;
    this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor = paramSelectableCursor2;
  }
  
  public void a(@NonNull SelectablePopupMenu paramSelectablePopupMenu)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu = paramSelectablePopupMenu;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    g();
    this.e = 0;
    this.f = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.contentLength();
    if (this.e >= this.f)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.highlightBackgroundColor(this.k);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.selectContent(this.e, this.f);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.highlightContent();
    h();
    this.g = -1;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.b(this.l);
    this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.b(this.l);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, true);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    paramChatMessage.b(arrayOfInt[0], arrayOfInt[1], 1);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.locationByIndex(this.f, this.jdField_a_of_type_ArrayOfInt, false);
    paramChatMessage = this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    paramChatMessage.b(arrayOfInt[0], arrayOfInt[1], 2);
    a();
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier;
    if (paramChatMessage == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier = new QMagnifier();
    } else if (paramChatMessage.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier.a();
    }
    j();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    SelectablePopupMenu localSelectablePopupMenu = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu;
    if (localSelectablePopupMenu != null) {
      return localSelectablePopupMenu.a();
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (!c()) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
    if (localObject == null) {
      return false;
    }
    localObject = ((SelectableComponent)localObject).view();
    ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int m = arrayOfInt[0];
    int n = arrayOfInt[1];
    int i1 = ((View)localObject).getMeasuredWidth();
    int i2 = ((View)localObject).getMeasuredHeight();
    return (paramInt1 >= m) && (paramInt1 <= i1 + m) && (paramInt2 >= n) && (paramInt2 <= i2 + n);
  }
  
  public int b()
  {
    g();
    return this.e;
  }
  
  @Nullable
  public String b()
  {
    g();
    CharSequence localCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.selectContent();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  public void b()
  {
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu.a();
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public void b(@NonNull OnSelectListener paramOnSelectListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (paramOnSelectListener == (OnSelectListener)localWeakReference.get())
      {
        paramOnSelectListener = localWeakReference;
        break label47;
      }
    }
    paramOnSelectListener = null;
    label47:
    if (paramOnSelectListener != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnSelectListener);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c()
  {
    g();
    return this.f;
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent instanceof MixedMsgLinearLayout))
    {
      g();
      CharSequence localCharSequence = ((MixedMsgLinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent).a();
      if (localCharSequence != null) {
        return localCharSequence.toString();
      }
      return null;
    }
    return b();
  }
  
  public void c()
  {
    j();
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    SelectableMagnifier localSelectableMagnifier = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier;
    if (localSelectableMagnifier != null)
    {
      if (localSelectableMagnifier.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier = null;
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu = null;
    this.jdField_a_of_type_Boolean = false;
    this.e = -1;
    this.f = -1;
    this.g = -1;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.jdField_a_of_type_Long = -1L;
    j();
  }
  
  void d(int paramInt)
  {
    if (!g()) {
      return;
    }
    if (!h()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu;
    if ((localObject1 instanceof CommonMenuWrapper)) {
      n = ((CommonMenuWrapper)localObject1).jdField_b_of_type_Int;
    } else {
      n = ((SelectablePopupMenu)localObject1).a();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu;
    int i1;
    if ((localObject1 instanceof CommonMenuWrapper)) {
      i1 = ((CommonMenuWrapper)localObject1).jdField_a_of_type_Int;
    } else {
      i1 = ((SelectablePopupMenu)localObject1).b();
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.view();
    localObject1 = localObject2;
    if (((View)localObject2).getId() != 2131364521)
    {
      View localView = ((View)localObject2).findViewById(2131364521);
      localObject1 = localObject2;
      if (localView != null) {
        localObject1 = localView;
      }
    }
    ((View)localObject1).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    localObject2 = this.jdField_a_of_type_ArrayOfInt;
    int i3 = 1;
    int i4 = localObject2[1];
    int i5 = localObject2[1];
    int i6 = ((View)localObject1).getHeight();
    localObject1 = this.jdField_a_of_type_ArrayOfInt;
    int i2 = 0;
    int i7 = localObject1[0];
    int i8 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.view().getPaddingLeft();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, true);
    localObject1 = this.jdField_a_of_type_ArrayOfInt;
    int i9 = localObject1[0];
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.locationByIndex(this.f, (int[])localObject1, false);
    int m = this.jdField_a_of_type_ArrayOfInt[0];
    if (this.h == 2)
    {
      i9 = m - n;
      if ((i9 > jdField_a_of_type_Int) || (i9 < 0))
      {
        i9 = jdField_a_of_type_Int;
        if (m - i9 < i7 + i8) {
          break label339;
        }
        m -= i9;
        break label339;
      }
    }
    else
    {
      m = n - i9;
      if ((m > jdField_a_of_type_Int) || (m < 0)) {
        break label332;
      }
    }
    m = n;
    break label339;
    label332:
    m = jdField_a_of_type_Int + i9;
    label339:
    if (i4 - jdField_b_of_type_Int < c + ImmersiveUtils.statusHeight)
    {
      i4 = i5 + i6 + 0;
      if (i4 < c + ImmersiveUtils.statusHeight)
      {
        if ((i1 != 0) && (i1 - jdField_b_of_type_Int > c + ImmersiveUtils.statusHeight))
        {
          paramInt = i1 - jdField_b_of_type_Int;
          m = i2;
          break label591;
        }
        if (i1 != 0)
        {
          i3 = d;
          i4 = jdField_b_of_type_Int;
          if (i3 + i1 - i4 < paramInt)
          {
            paramInt = i1 - i4;
            m = 1;
            break label591;
          }
        }
        paramInt = c + ImmersiveUtils.statusHeight;
      }
      else
      {
        if (d + i4 > paramInt)
        {
          if ((i1 != 0) && (i1 - jdField_b_of_type_Int > c + ImmersiveUtils.statusHeight))
          {
            paramInt = i1 - jdField_b_of_type_Int;
          }
          else
          {
            if (i1 != 0)
            {
              i2 = d;
              i4 = jdField_b_of_type_Int;
              if (i2 + i1 - i4 < paramInt)
              {
                paramInt = i1 - i4;
                break label564;
              }
            }
            paramInt = c + ImmersiveUtils.statusHeight + d + jdField_b_of_type_Int;
            n = m;
          }
          m = 0;
          break label567;
        }
        else
        {
          paramInt = i4;
          n = m;
        }
        m = i3;
        break label591;
      }
    }
    else if (i4 <= paramInt)
    {
      paramInt = i4 - jdField_b_of_type_Int;
    }
    label564:
    label567:
    int n = m;
    m = i2;
    label591:
    a(n, paramInt, m);
  }
  
  public boolean d()
  {
    SelectableCursor localSelectableCursor = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    return (localSelectableCursor != null) && (localSelectableCursor.a(1));
  }
  
  void e()
  {
    g();
    h();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public boolean e()
  {
    SelectableCursor localSelectableCursor = this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    return (localSelectableCursor != null) && (localSelectableCursor.a(2));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu.a();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
    if (localObject != null)
    {
      ((SelectableComponent)localObject).selectContent(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.clearHighlightContent();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    if (localObject != null)
    {
      if (((SelectableCursor)localObject).a(1)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.a(1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor = null;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    if (localObject != null)
    {
      if (((SelectableCursor)localObject).a(2)) {
        this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.a(2);
      }
      this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor = null;
    }
    a(null);
  }
  
  public boolean f()
  {
    return (d()) && (e());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    if (paramMessage.what == 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
      if (localObject != null)
      {
        SelectablePopupMenu localSelectablePopupMenu = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu;
        if (localSelectablePopupMenu != null)
        {
          localSelectablePopupMenu.a(((SelectableComponent)localObject).view(), paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier;
          if ((paramMessage != null) && (paramMessage.a())) {
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier.a();
          }
        }
      }
      return true;
    }
    if (paramMessage.what == 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier != null)
      {
        if (((Integer)paramMessage.obj).intValue() == 1) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
        } else {
          localObject = this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
        }
        if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier.a(((SelectableCursor)localObject).a(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.view(), true);
        }
      }
    }
    else if (paramMessage.what == 3)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier != null)
      {
        if (((Integer)paramMessage.obj).intValue() == 1) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
        } else {
          localObject = this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
        }
        if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableMagnifier.a(((SelectableCursor)localObject).a(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.view(), false);
        }
      }
    }
    else if (paramMessage.what == 4)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor != null) && (this.jdField_b_of_type_ComTencentMobileqqActivitySelectableSelectableCursor != null))
      {
        g();
        a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl
 * JD-Core Version:    0.7.0.1
 */