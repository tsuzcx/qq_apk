package com.tencent.mobileqq.activity.selectable;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public final class CommonSelectableHelper
  implements ILifeCycleHelper, OnSelectListener
{
  private static final int jdField_a_of_type_Int = ViewUtils.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final WeakReference<Fragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public CommonSelectableHelper(Fragment paramFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFragment);
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramFragment.getActivity()).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
  }
  
  private void a(View paramView, Fragment paramFragment)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.c()) && (!localAIOSelectableDelegateImpl.a()))
    {
      View localView = localAIOSelectableDelegateImpl.a();
      if (localView != null)
      {
        localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() >= jdField_a_of_type_Int + ImmersiveUtils.statusHeight) {
          break label76;
        }
        localAIOSelectableDelegateImpl.d();
      }
    }
    return;
    label76:
    if (paramView != null)
    {
      int i = this.jdField_a_of_type_ArrayOfInt[1];
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
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
      paramFragment.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      localAIOSelectableDelegateImpl.d(paramView.heightPixels);
      return;
    }
    localAIOSelectableDelegateImpl.a();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((!localAIOSelectableDelegateImpl.c()) || (!this.jdField_b_of_type_Boolean)) {}
    int i;
    label102:
    do
    {
      do
      {
        int j;
        int k;
        do
        {
          return;
          i = paramMotionEvent.getAction();
          j = (int)paramMotionEvent.getRawX();
          k = (int)paramMotionEvent.getRawY();
          if (i == 0)
          {
            if (!localAIOSelectableDelegateImpl.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
              if (!this.jdField_a_of_type_Boolean) {
                break label102;
              }
              this.d = j;
            }
            for (this.e = k;; this.e = -1)
            {
              this.c = 0;
              return;
              bool = false;
              break;
              this.d = -1;
            }
          }
          if (i != 2) {
            break;
          }
        } while ((!this.jdField_a_of_type_Boolean) || (Math.pow(this.d - j, 2.0D) + Math.pow(this.e - k, 2.0D) <= jdField_b_of_type_Int));
        this.c = 2;
      } while (!QLog.isColorLevel());
      QLog.d("ChatPieSelectableHelper", 0, "detect scrolling.");
      return;
    } while (((i != 1) && (i != 3)) || (!this.jdField_a_of_type_Boolean));
    if (this.c == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatPieSelectableHelper", 0, "detect taping.");
      }
      long l = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localAIOSelectableDelegateImpl.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localAIOSelectableDelegateImpl.d();
    }
  }
  
  public void a(@NonNull SelectableDelegate paramSelectableDelegate)
  {
    boolean bool = paramSelectableDelegate.c();
    paramSelectableDelegate = (Fragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramSelectableDelegate instanceof ChatHistoryC2CAllFragment)) {
      paramSelectableDelegate = ((ChatHistoryC2CAllFragment)paramSelectableDelegate).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    }
    for (;;)
    {
      if (paramSelectableDelegate != null) {
        paramSelectableDelegate.requestDisallowInterceptTouchEvent(bool);
      }
      return;
      if ((paramSelectableDelegate instanceof ChatHistoryTroopAllFragment)) {
        paramSelectableDelegate = ((ChatHistoryTroopAllFragment)paramSelectableDelegate).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else if ((paramSelectableDelegate instanceof ChatHistoryBubbleListForTroopFragment)) {
        paramSelectableDelegate = ((ChatHistoryBubbleListForTroopFragment)paramSelectableDelegate).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else {
        paramSelectableDelegate = null;
      }
    }
  }
  
  public String getTag()
  {
    return "ChatPieSelectableHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 10, 13, 17, 15, 16 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject2 = (Fragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1 = null;
    if ((localObject2 instanceof ChatHistoryC2CAllFragment)) {
      localObject1 = ((ChatHistoryC2CAllFragment)localObject2).jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer;
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = AIOSelectableDelegateImpl.a();
          ((AIOSelectableDelegateImpl)localObject2).a(this);
          this.jdField_b_of_type_Boolean = true;
        } while ((((AIOSelectableDelegateImpl)localObject2).a() == null) || (!((AIOSelectableDelegateImpl)localObject2).c()) || (((AIOSelectableDelegateImpl)localObject2).a()));
        ((AIOSelectableDelegateImpl)localObject2).a((View)localObject1);
        return;
        AIOSelectableDelegateImpl.a().b(this);
        this.jdField_b_of_type_Boolean = false;
        return;
        localObject1 = AIOSelectableDelegateImpl.a();
      } while (!((SelectableDelegate)localObject1).c());
      ((SelectableDelegate)localObject1).d();
      return;
      a((View)localObject1, (Fragment)localObject2);
      return;
      localObject1 = AIOSelectableDelegateImpl.a();
    } while ((((AIOSelectableDelegateImpl)localObject1).a() == null) || (!((AIOSelectableDelegateImpl)localObject1).c()) || (!((AIOSelectableDelegateImpl)localObject1).a()));
    ((AIOSelectableDelegateImpl)localObject1).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonSelectableHelper
 * JD-Core Version:    0.7.0.1
 */