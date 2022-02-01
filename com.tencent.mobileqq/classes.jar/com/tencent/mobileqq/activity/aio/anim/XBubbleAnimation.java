package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.io.IOException;

public class XBubbleAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private BaseBubbleBuilder.ViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
  public BubbleInfo.CommonAttrs a;
  public VipPngPlayAnimationDrawable a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int b;
  protected View b;
  public BubbleInfo.CommonAttrs b;
  public VipPngPlayAnimationDrawable b;
  public boolean b;
  public boolean c = false;
  
  public XBubbleAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    float f;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      paramInt2 = 0;
      break;
    case 7: 
      if (paramBoolean) {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      } else {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;
      }
      f = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      break;
    case 6: 
      if (paramBoolean) {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      } else {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;
      }
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      break;
    case 5: 
      if (paramBoolean) {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      } else {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;
      }
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      break;
    case 4: 
      if (paramBoolean) {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;
      } else {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      }
      paramInt1 = (int)(paramInt1 + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      break;
    case 3: 
      if (paramBoolean) {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;
      } else {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      }
      paramInt1 = (int)(paramInt1 + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      break;
    case 2: 
      if (paramBoolean) {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;
      } else {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      }
      f = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      paramInt2 = (int)(f - paramInt2 / 2.0F - paramInt3 / 2.0F);
      break;
    case 1: 
      if (paramBoolean) {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;
      } else {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      }
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      break;
    }
    if (paramBoolean) {
      paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;
    } else {
      paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    }
    paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    return new int[] { paramInt1, paramInt2 };
  }
  
  protected void a(int paramInt)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      localView.offsetTopAndBottom(paramInt);
      if ((this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.d) || (this.jdField_b_of_type_AndroidViewView.getBottom() <= 0))
      {
        i = 1;
        break label41;
      }
    }
    int i = 0;
    label41:
    localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView.offsetTopAndBottom(paramInt);
      if ((!this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.d) && (this.jdField_a_of_type_AndroidViewView.getBottom() > 0)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((i != 0) && (this.jdField_b_of_type_Int != 0)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new XBubbleAnimation.2(this));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean1) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
    if (localObject != null)
    {
      Drawable localDrawable = ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.getBackground();
      if ((localDrawable instanceof VipBubbleDrawable))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a;
        } else {
          localObject = null;
        }
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
          if ((localObject == null) || (!((BubbleInfo.CommonAttrs)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_Boolean))
          {
            localObject = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
            if ((localObject == null) || (!((BubbleInfo.CommonAttrs)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_Boolean)) {}
          }
          else if (paramBoolean1)
          {
            ((VipBubbleDrawable)localDrawable).c(true);
          }
          else
          {
            ((VipBubbleDrawable)localDrawable).c(false);
          }
        }
        if (paramBoolean2) {
          ((VipBubbleDrawable)localDrawable).a(paramBoolean1);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("background alpha changed:");
          ((StringBuilder)localObject).append(String.valueOf(paramBoolean1));
          QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  protected boolean a()
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) && (this.jdField_a_of_type_AndroidViewView == null)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = null;
    int i = AIOUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    Object localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, i));
    if ((localObject != null) && ((localObject instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject);
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("list view item's tag can not cast to ViewHolder, object:");
      localStringBuilder.append(localObject);
      QLog.e("XBubbleAnimation", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Int != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
      if ((localObject == null) || (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null)) {
        e();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
    if ((localObject != null) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.top = (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.left = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getBottom() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getRight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindView bubbleRect top=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRect.top);
        ((StringBuilder)localObject).append(",left=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRect.left);
        ((StringBuilder)localObject).append(",bottom=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRect.bottom);
        ((StringBuilder)localObject).append(",right=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRect.right);
        ((StringBuilder)localObject).append(",listView height=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
        QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend() ^ true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
      if ((localObject != null) && (((BubbleInfo.CommonAttrs)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (!this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.c)) {
        this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.c = false;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.c = bool2;
      }
      boolean bool1;
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_JavaLangString))
        {
          localObject = this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
          if (!bool2) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((VipPngPlayAnimationDrawable)localObject).c = bool1;
        }
        else
        {
          this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.c = bool2;
        }
      }
      if (this.jdField_b_of_type_Int == 6)
      {
        this.jdField_b_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
        return true;
      }
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.d, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool2);
      int n = localObject[1] + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
      if (!bool2)
      {
        j = localObject[0] + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left;
        localObject = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
        i = j;
        if (localObject == null) {
          break label901;
        }
        localObject = a(((BubbleInfo.CommonAttrs)localObject).d, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool2);
        i = localObject[0] - this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right;
        k = localObject[1];
        m = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
      }
      else
      {
        j = localObject[0] - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right;
        localObject = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
        i = j;
        if (localObject == null) {
          break label901;
        }
        localObject = a(((BubbleInfo.CommonAttrs)localObject).d, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool2);
        i = localObject[0] + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left;
        k = localObject[1];
        m = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
      }
      k += m;
      int m = j;
      int j = i;
      break label908;
      label901:
      int k = 0;
      j = 0;
      m = i;
      label908:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindView mView master_x=");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(",master_y=");
        ((StringBuilder)localObject).append(n);
        ((StringBuilder)localObject).append(",mAttrsFirst.mRect.right=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right);
        ((StringBuilder)localObject).append(",mAttrsFirst.mRect.bottom=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom);
        ((StringBuilder)localObject).append(",listview.Width=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetListView.getWidth());
        ((StringBuilder)localObject).append(",listview.Height=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
        QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
      }
      if ((m >= -this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right) && (m <= this.jdField_a_of_type_ComTencentWidgetListView.getWidth()) && (n >= -this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom))
      {
        i = m - this.jdField_b_of_type_AndroidViewView.getLeft();
        m = n - this.jdField_b_of_type_AndroidViewView.getTop();
        if ((i == 0) && (m == 0))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("bindView mView dx=");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(",dy=");
            ((StringBuilder)localObject).append(m);
            QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(i);
          this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(m);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("bindView mView.offsetLeftAndRight ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(",mView.offsetTopAndBottom ");
            ((StringBuilder)localObject).append(m);
            QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
          }
        }
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_a_of_type_AndroidViewView != null) && (bool1))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindView mLinkView x=");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(",y=");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(",mRect.right=");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right);
          ((StringBuilder)localObject).append(",mRect.bottom=");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom);
          ((StringBuilder)localObject).append(",listview.Width=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetListView.getWidth());
          ((StringBuilder)localObject).append(",listview.Height=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
          QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
        }
        if ((j >= -this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right) && (j <= this.jdField_a_of_type_ComTencentWidgetListView.getWidth()) && (k >= -this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom))
        {
          i = j - this.jdField_a_of_type_AndroidViewView.getLeft();
          j = k - this.jdField_a_of_type_AndroidViewView.getTop();
          if ((i == 0) && (j == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("bindView mLinkView dx=");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(",dy=");
              ((StringBuilder)localObject).append(j);
              QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(i);
            this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(j);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("bindView mLinkView.offsetLeftAndRight ");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(",mLinkView.offsetTopAndBottom ");
              ((StringBuilder)localObject).append(j);
              QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
            }
          }
          return true;
        }
      }
      else
      {
        return bool1;
      }
    }
    else if (this.jdField_b_of_type_Int != 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new XBubbleAnimation.1(this));
    }
    return false;
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("layout changed=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",bottom=");
      localStringBuilder.append(paramInt4);
      QLog.d("XBubbleAnimation", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      a();
      return true;
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    ThreadManager.post(new XBubbleAnimation.3(this, paramVarArgs), 8, null, true);
    return true;
  }
  
  public boolean b(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length != 3) {
      return false;
    }
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    if ((((Long)paramArrayOfObject[1]).longValue() != this.jdField_a_of_type_Long) || (this.jdField_b_of_type_Int != i))
    {
      paramArrayOfObject = (Pair)paramArrayOfObject[2];
      if ((paramArrayOfObject != null) && (paramArrayOfObject.first != null))
      {
        if (((BubbleInfo.CommonAttrs)paramArrayOfObject.first).jdField_a_of_type_ArrayOfJavaLangString == null) {
          return false;
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramArrayOfObject.first);
        this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramArrayOfObject.second);
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString);
          if ((this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString != null)) {
            this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString);
          }
          return true;
        }
        catch (IOException paramArrayOfObject)
        {
          QLog.e("XBubbleAnimation", 1, "VipPngPlayAnimationDrawable measure exception", paramArrayOfObject);
        }
      }
    }
    return false;
  }
  
  protected void c()
  {
    VipPngPlayAnimationDrawable localVipPngPlayAnimationDrawable = this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
    if (localVipPngPlayAnimationDrawable != null) {
      localVipPngPlayAnimationDrawable.a();
    }
    localVipPngPlayAnimationDrawable = this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
    if (localVipPngPlayAnimationDrawable != null) {
      localVipPngPlayAnimationDrawable.a();
    }
  }
  
  public boolean c(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    boolean bool2 = false;
    Object localObject;
    if ((i == 3) && (!this.c))
    {
      int j = ((Integer)paramArrayOfObject[0]).intValue();
      long l = ((Long)paramArrayOfObject[1]).longValue();
      i = AIOUtils.a(l, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, i));
      if ((localObject != null) && ((localObject instanceof BaseBubbleBuilder.ViewHolder)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("list view item's tag can not cast to ViewHolder, object:");
        localStringBuilder.append(localObject);
        QLog.e("XBubbleAnimation", 1, localStringBuilder.toString());
      }
      boolean bool1;
      if (l == this.jdField_a_of_type_Long)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Int == j) {}
      }
      else
      {
        paramArrayOfObject = (Pair)paramArrayOfObject[2];
        bool1 = bool2;
        if (paramArrayOfObject != null)
        {
          bool1 = bool2;
          if (paramArrayOfObject.first != null)
          {
            if (((BubbleInfo.CommonAttrs)paramArrayOfObject.first).jdField_a_of_type_ArrayOfJavaLangString == null) {
              return false;
            }
            e();
            this.jdField_a_of_type_Long = l;
            this.jdField_b_of_type_Int = j;
            this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramArrayOfObject.first);
            this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramArrayOfObject.second);
            this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.c);
            if (j != 0)
            {
              paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
              if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_Boolean) {
                i = 1;
              } else {
                i = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_Int;
              }
              paramArrayOfObject.h = i;
            }
            this.jdField_b_of_type_AndroidViewView = new XBubbleAnimation.4(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
            this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
            this.jdField_b_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.i, this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.j);
            paramArrayOfObject = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
            if ((paramArrayOfObject != null) && (paramArrayOfObject.jdField_a_of_type_ArrayOfJavaLangString != null))
            {
              this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.c);
              if (j != 0)
              {
                paramArrayOfObject = this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
                if (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_Boolean) {
                  i = 1;
                } else {
                  i = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_Int;
                }
                paramArrayOfObject.h = i;
              }
              this.jdField_a_of_type_AndroidViewView = new XBubbleAnimation.5(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
              this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
              this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.i, this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.j);
            }
            bool1 = a();
            this.jdField_b_of_type_Boolean = true;
          }
        }
      }
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start XBubbleAnimation failed. args.length=");
      ((StringBuilder)localObject).append(paramArrayOfObject.length);
      ((StringBuilder)localObject).append(", mIsStop=");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void d()
  {
    e();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XBubbleAnimation", 2, "now stop current animation!");
    }
    this.jdField_b_of_type_Boolean = false;
    this.c = true;
    c();
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation
 * JD-Core Version:    0.7.0.1
 */