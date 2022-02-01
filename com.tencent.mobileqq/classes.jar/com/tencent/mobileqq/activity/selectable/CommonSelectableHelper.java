package com.tencent.mobileqq.activity.selectable;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public final class CommonSelectableHelper
  implements ILifeCycleHelper, OnSelectListener
{
  private static final int jdField_a_of_type_Int = ViewUtils.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final WeakReference<BaseFragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public CommonSelectableHelper(BaseFragment paramBaseFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseFragment);
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramBaseFragment.getBaseActivity()).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
  }
  
  private void a(View paramView, BaseFragment paramBaseFragment)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.c()) && (!localAIOSelectableDelegateImpl.a()))
    {
      View localView = localAIOSelectableDelegateImpl.a();
      if (localView != null)
      {
        localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < jdField_a_of_type_Int + ImmersiveUtils.statusHeight)
        {
          localAIOSelectableDelegateImpl.d();
          return;
        }
        if (paramView != null)
        {
          paramBaseFragment = this.jdField_a_of_type_ArrayOfInt;
          int i = paramBaseFragment[1];
          paramView.getLocationInWindow(paramBaseFragment);
          if (i > this.jdField_a_of_type_ArrayOfInt[1])
          {
            localAIOSelectableDelegateImpl.d();
            return;
          }
          localAIOSelectableDelegateImpl.a(paramView);
          return;
        }
        if (Build.VERSION.SDK_INT >= 17)
        {
          paramView = new DisplayMetrics();
          paramBaseFragment.getBaseActivity().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
          localAIOSelectableDelegateImpl.d(paramView.heightPixels);
          return;
        }
        localAIOSelectableDelegateImpl.a();
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.c())
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getRawX();
      int k = (int)paramMotionEvent.getRawY();
      if (i == 0)
      {
        this.jdField_a_of_type_Boolean = (localAIOSelectableDelegateImpl.a(j, k) ^ true);
        this.jdField_a_of_type_Long = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Boolean)
        {
          this.d = j;
          this.e = k;
        }
        else
        {
          this.d = -1;
          this.e = -1;
        }
        this.c = 0;
        return;
      }
      if (i == 2)
      {
        if ((this.jdField_a_of_type_Boolean) && (Math.pow(this.d - j, 2.0D) + Math.pow(this.e - k, 2.0D) > jdField_b_of_type_Int))
        {
          this.c = 2;
          if (QLog.isColorLevel()) {
            QLog.d("ChatPieSelectableHelper", 0, "detect scrolling.");
          }
        }
      }
      else if (((i == 1) || (i == 3)) && (this.jdField_a_of_type_Boolean))
      {
        if (this.c == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatPieSelectableHelper", 0, "detect taping.");
          }
          long l1 = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
          long l2 = this.jdField_a_of_type_Long;
          if ((l2 != -1L) && (l1 != -1L))
          {
            if (l2 == l1) {
              localAIOSelectableDelegateImpl.d();
            }
          }
          else {
            localAIOSelectableDelegateImpl.d();
          }
        }
        this.c = 1;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Long = -1L;
      }
    }
  }
  
  public void a(@NonNull SelectableDelegate paramSelectableDelegate)
  {
    boolean bool = paramSelectableDelegate.c();
    paramSelectableDelegate = (BaseFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramSelectableDelegate instanceof ChatHistoryC2CAllFragment)) {
      paramSelectableDelegate = ((ChatHistoryC2CAllFragment)paramSelectableDelegate).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    } else if ((paramSelectableDelegate instanceof ChatHistoryTroopAllFragment)) {
      paramSelectableDelegate = ((ChatHistoryTroopAllFragment)paramSelectableDelegate).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    } else if ((paramSelectableDelegate instanceof ChatHistoryBubbleListForTroopFragment)) {
      paramSelectableDelegate = ((ChatHistoryBubbleListForTroopFragment)paramSelectableDelegate).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    } else {
      paramSelectableDelegate = null;
    }
    if (paramSelectableDelegate != null) {
      paramSelectableDelegate.requestDisallowInterceptTouchEvent(bool);
    }
  }
  
  public String getTag()
  {
    return "ChatPieSelectableHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 11, 14, 18, 16, 17 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject2 = (BaseFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1;
    if ((localObject2 instanceof ChatHistoryC2CAllFragment)) {
      localObject1 = ((ChatHistoryC2CAllFragment)localObject2).jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer;
    } else {
      localObject1 = null;
    }
    if (paramInt != 7)
    {
      if (paramInt != 11)
      {
        if (paramInt != 14)
        {
          switch (paramInt)
          {
          default: 
            return;
          case 18: 
            a((View)localObject1, (BaseFragment)localObject2);
            return;
          }
          localObject1 = AIOSelectableDelegateImpl.a();
          if ((((AIOSelectableDelegateImpl)localObject1).a() != null) && (((AIOSelectableDelegateImpl)localObject1).c()) && (((AIOSelectableDelegateImpl)localObject1).a())) {
            ((AIOSelectableDelegateImpl)localObject1).b();
          }
        }
        else
        {
          localObject1 = AIOSelectableDelegateImpl.a();
          if (((SelectableDelegate)localObject1).c()) {
            ((SelectableDelegate)localObject1).d();
          }
        }
      }
      else
      {
        AIOSelectableDelegateImpl.a().b(this);
        this.jdField_b_of_type_Boolean = false;
      }
    }
    else
    {
      localObject2 = AIOSelectableDelegateImpl.a();
      ((AIOSelectableDelegateImpl)localObject2).a(this);
      this.jdField_b_of_type_Boolean = true;
      if ((((AIOSelectableDelegateImpl)localObject2).a() != null) && (((AIOSelectableDelegateImpl)localObject2).c()) && (!((AIOSelectableDelegateImpl)localObject2).a())) {
        ((AIOSelectableDelegateImpl)localObject2).a((View)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonSelectableHelper
 * JD-Core Version:    0.7.0.1
 */