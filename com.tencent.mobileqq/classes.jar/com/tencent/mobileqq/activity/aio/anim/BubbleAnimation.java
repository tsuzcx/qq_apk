package com.tencent.mobileqq.activity.aio.anim;

import android.widget.ListAdapter;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.util.List;

public class BubbleAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private AIOAnimationConatiner.AIOAnimator jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
  private SigTlpAnimation jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation;
  private XBubbleAnimation jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation;
  
  public BubbleAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean b(Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 4)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWidgetListView != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator = new BubbleNewAIOAnim(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
          }
          bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramVarArgs);
        }
      }
    }
    return bool1;
  }
  
  private boolean c(Object... paramVarArgs)
  {
    boolean bool1 = ((Boolean)paramVarArgs[4]).booleanValue();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation != null) && ((paramVarArgs[5] != null) || (bool1))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.a(true);
    }
    boolean bool2 = false;
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation = new SigTlpAnimation(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
        bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.a(paramVarArgs);
      }
    }
    return bool1;
  }
  
  private boolean d(Object... paramVarArgs)
  {
    Object localObject;
    if (paramVarArgs.length == 3) {
      localObject = (Pair)paramVarArgs[2];
    } else {
      localObject = null;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((Pair)localObject).first == null) {
        return false;
      }
      bool1 = bool2;
      if (((BubbleInfo.CommonAttrs)((Pair)localObject).first).a.e == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation;
        if (localObject != null) {
          ((XBubbleAnimation)localObject).e();
        }
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWidgetListView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation = new XBubbleAnimation(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
          bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation.a(paramVarArgs);
        }
      }
    }
    return bool1;
  }
  
  protected void a()
  {
    SigTlpAnimation localSigTlpAnimation = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation;
    if (localSigTlpAnimation != null) {
      localSigTlpAnimation.a();
    }
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation;
    if (localObject != null) {
      ((XBubbleAnimation)localObject).a(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if (localObject != null) {
      ((AIOAnimationConatiner.AIOAnimator)localObject).a(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation;
    if (localObject != null) {
      ((SigTlpAnimation)localObject).a(paramInt);
    }
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    boolean bool2;
    if (localObject != null) {
      bool2 = ((AIOAnimationConatiner.AIOAnimator)localObject).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      bool2 = false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation;
    boolean bool1 = bool2;
    if (localObject != null) {
      if ((!((XBubbleAnimation)localObject).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) && (!bool2)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation;
    if (localObject != null) {
      bool1 = ((SigTlpAnimation)localObject).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return bool1;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    boolean bool = false;
    if (i >= 2) {}
    for (;;)
    {
      try
      {
        long l = ((Long)paramVarArgs[1]).longValue();
        if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() != null) && (l > 0L))
        {
          Object localObject2 = null;
          ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
          i = localListAdapter.getCount() - 1;
          Object localObject1 = localObject2;
          if (i >= 0)
          {
            localObject1 = localListAdapter.getItem(i);
            if (!(localObject1 instanceof ChatMessage)) {
              break label243;
            }
            localObject1 = (ChatMessage)localObject1;
            if (((ChatMessage)localObject1).uniseq != l) {
              break label243;
            }
          }
          if (localObject1 != null)
          {
            localObject1 = EmojiStickerManager.a().a((MessageRecord)localObject1);
            if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
            {
              if (QLog.isColorLevel()) {
                QLog.i("BubbleAnimation", 2, "contain sticker, so stop bubble animation!");
              }
              return false;
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("BubbleAnimation", 1, "", localException);
      }
      i = ((Integer)paramVarArgs[0]).intValue();
      if ((i != 0) && (i != 1) && (i != 6))
      {
        if ((i != 5) && (i != 3) && (i != 2))
        {
          if (i == 4) {
            return c(paramVarArgs);
          }
        }
        else {
          return b(paramVarArgs);
        }
      }
      else {
        bool = d(paramVarArgs);
      }
      return bool;
      label243:
      i -= 1;
    }
  }
  
  protected void b()
  {
    SigTlpAnimation localSigTlpAnimation = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation;
    if (localSigTlpAnimation != null) {
      localSigTlpAnimation.b();
    }
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation;
    if (localObject != null) {
      ((XBubbleAnimation)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if (localObject != null) {
      ((AIOAnimationConatiner.AIOAnimator)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation;
    if (localObject != null) {
      ((SigTlpAnimation)localObject).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.BubbleAnimation
 * JD-Core Version:    0.7.0.1
 */