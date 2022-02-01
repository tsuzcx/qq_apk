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
  private XBubbleAnimation d;
  private AIOAnimationConatiner.AIOAnimator e;
  private SigTlpAnimation f;
  
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
      if (this.a != null)
      {
        bool1 = bool2;
        if (this.b != null)
        {
          if (this.e == null) {
            this.e = new BubbleNewAIOAnim(0, this.a, this.b);
          }
          bool1 = this.e.a(paramVarArgs);
        }
      }
    }
    return bool1;
  }
  
  private boolean c(Object... paramVarArgs)
  {
    boolean bool1 = ((Boolean)paramVarArgs[4]).booleanValue();
    if ((this.f != null) && ((paramVarArgs[5] != null) || (bool1))) {
      this.f.b(true);
    }
    boolean bool2 = false;
    bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.b != null)
      {
        this.f = new SigTlpAnimation(this.c, this.a, this.b);
        bool1 = this.f.a(paramVarArgs);
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
      if (((BubbleInfo.CommonAttrs)((Pair)localObject).first).l.n == 1)
      {
        localObject = this.d;
        if (localObject != null) {
          ((XBubbleAnimation)localObject).g();
        }
        bool1 = bool2;
        if (this.b != null)
        {
          this.d = new XBubbleAnimation(this.c, this.a, this.b);
          bool1 = this.d.a(paramVarArgs);
        }
      }
    }
    return bool1;
  }
  
  protected void a()
  {
    SigTlpAnimation localSigTlpAnimation = this.f;
    if (localSigTlpAnimation != null) {
      localSigTlpAnimation.a();
    }
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((XBubbleAnimation)localObject).a(paramInt);
    }
    localObject = this.e;
    if (localObject != null) {
      ((AIOAnimationConatiner.AIOAnimator)localObject).a(paramInt);
    }
    localObject = this.f;
    if (localObject != null) {
      ((SigTlpAnimation)localObject).a(paramInt);
    }
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.e;
    boolean bool2;
    if (localObject != null) {
      bool2 = ((AIOAnimationConatiner.AIOAnimator)localObject).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      bool2 = false;
    }
    localObject = this.d;
    boolean bool1 = bool2;
    if (localObject != null) {
      if ((!((XBubbleAnimation)localObject).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) && (!bool2)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
    localObject = this.f;
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
        if ((this.b != null) && (this.b.getAdapter() != null) && (l > 0L))
        {
          Object localObject2 = null;
          ListAdapter localListAdapter = this.b.getAdapter();
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
            localObject1 = EmojiStickerManager.a().c((MessageRecord)localObject1);
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
    SigTlpAnimation localSigTlpAnimation = this.f;
    if (localSigTlpAnimation != null) {
      localSigTlpAnimation.b();
    }
  }
  
  protected boolean b(int paramInt)
  {
    return true;
  }
  
  protected void c()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((XBubbleAnimation)localObject).g();
    }
    localObject = this.e;
    if (localObject != null) {
      ((AIOAnimationConatiner.AIOAnimator)localObject).c();
    }
    localObject = this.f;
    if (localObject != null) {
      ((SigTlpAnimation)localObject).b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.BubbleAnimation
 * JD-Core Version:    0.7.0.1
 */