package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.richstatus.sign.AIOSignViewHolder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.widget.MutilayoutSlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.MaxHeightRelativelayout;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class SigTlpAnimation
  extends XBubbleAnimation
{
  protected static Rect b;
  protected Rect a;
  protected View a;
  private SigTlpAnimation.ItemViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder;
  private RichStatItemBuilder.Holder jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder;
  protected SignatureTemplateInfo.DynamicItem a;
  public String a;
  protected boolean a;
  public String[] a;
  protected String b;
  private int c;
  
  static
  {
    jdField_b_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public SigTlpAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_b_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public int a(View paramView, boolean paramBoolean)
  {
    View localView = (View)paramView.getParent();
    int i = paramView.getTop();
    if (localView == null) {
      return i;
    }
    if (paramBoolean)
    {
      j = i;
      do
      {
        i = j;
        if ((localView instanceof ChatXListView)) {
          break;
        }
        i = j + localView.getTop();
        paramView = (View)localView.getParent();
        localView = paramView;
        j = i;
      } while (paramView != null);
      return i;
    }
    paramView = localView;
    int j = i;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      j = i;
      do
      {
        i = j;
        if ((localView instanceof MutilayoutSlideDetectListView)) {
          break;
        }
        i = j + localView.getTop();
        paramView = (View)localView.getParent();
        localView = paramView;
        j = i;
      } while (paramView != null);
      return i;
    }
    do
    {
      i = j;
      if ((paramView instanceof MaxHeightRelativelayout)) {
        break;
      }
      i = j + paramView.getTop();
      localView = (View)paramView.getParent();
      paramView = localView;
      j = i;
    } while (localView != null);
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.a(true);
  }
  
  protected void a(int paramInt)
  {
    QQViewCompatUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if ((paramBoolean) && ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeAllViews();
      this.jdField_a_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
  
  protected boolean a()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(this.jdField_a_of_type_AndroidGraphicsRect.left);
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(this.jdField_a_of_type_AndroidGraphicsRect.top);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("rect.left=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRect.left);
        ((StringBuilder)localObject).append(",rect.top=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRect.top);
        QLog.d("SigTlpAnimation", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null)
        {
          ((View)localObject).offsetLeftAndRight(jdField_b_of_type_AndroidGraphicsRect.left);
          this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(jdField_b_of_type_AndroidGraphicsRect.top);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("rectAio.left=");
            ((StringBuilder)localObject).append(jdField_b_of_type_AndroidGraphicsRect.left);
            ((StringBuilder)localObject).append(",rectAio.top=");
            ((StringBuilder)localObject).append(jdField_b_of_type_AndroidGraphicsRect.top);
            QLog.d("SigTlpAnimation", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new SigTlpAnimation.1(this));
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      if (!((File)localObject).isDirectory()) {
        return false;
      }
      if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {
        return true;
      }
      localObject = FileUtils.getChildFiles(paramString);
      if (((ArrayList)localObject).size() <= 0) {
        return false;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[((ArrayList)localObject).size()];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("%d.png");
      paramString = ((StringBuilder)localObject).toString();
      int k = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      int j;
      for (int i = 0; i < k; i = j)
      {
        localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
        j = i + 1;
        localObject[i] = String.format(paramString, new Object[] { Integer.valueOf(j) });
      }
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return false;
    }
    if (b())
    {
      if (paramBoolean) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable);
      }
      ViewGroup.LayoutParams localLayoutParams1 = new ViewGroup.LayoutParams(-2, -2);
      localLayoutParams1.height = (this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top);
      localLayoutParams1.width = (this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, localLayoutParams1, false);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        ViewGroup.LayoutParams localLayoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        localLayoutParams2.height = (this.jdField_a_of_type_AndroidViewView.getBottom() - this.jdField_a_of_type_AndroidViewView.getTop());
        localLayoutParams2.width = (this.jdField_a_of_type_AndroidViewView.getRight() - this.jdField_a_of_type_AndroidViewView.getLeft());
        Object localObject = (View)this.jdField_a_of_type_AndroidViewView.getParent();
        View localView = this.jdField_a_of_type_AndroidViewView;
        if (((localView instanceof TextView)) && (localObject != null) && ((localObject instanceof RelativeLayout)))
        {
          localObject = (RelativeLayout)localView.getParent();
          jdField_b_of_type_AndroidGraphicsRect.left = (this.jdField_a_of_type_AndroidViewView.getLeft() + ((RelativeLayout)localObject).getLeft() + ((View)((RelativeLayout)localObject).getParent()).getLeft());
          ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("paramButton.width=");
          ((StringBuilder)localObject).append(localLayoutParams2.width);
          ((StringBuilder)localObject).append(",paramButton.height=");
          ((StringBuilder)localObject).append(localLayoutParams2.height);
          QLog.d("SigTlpAnimation", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, 1, localLayoutParams2, false);
        this.jdField_a_of_type_AndroidViewView.layout(0, 0, localLayoutParams2.width, localLayoutParams2.height);
      }
      this.jdField_b_of_type_AndroidViewView.layout(0, 0, localLayoutParams1.width, localLayoutParams1.height);
      return a();
    }
    return false;
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
      QLog.d("SigTlpAnimation", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeAllViews();
      a(false);
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 7) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    String str1 = String.valueOf(paramVarArgs[1]);
    this.jdField_b_of_type_JavaLangString = String.valueOf(paramVarArgs[2]);
    String str2 = (String)paramVarArgs[3];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[4]).booleanValue();
    if (paramVarArgs[5] != null) {
      this.jdField_a_of_type_AndroidViewView = ((View)paramVarArgs[5]);
    }
    this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = ((SignatureTemplateInfo.DynamicItem)paramVarArgs[6]);
    ThreadManager.getFileThreadHandler().post(new SigTlpAnimation.2(this, str1, str2));
    return true;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.a(false);
  }
  
  public boolean b()
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    Object localObject1 = null;
    int k = 0;
    int m = 0;
    Object localObject2;
    int j;
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder = null;
      this.c = AIOUtils.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      localObject2 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.c));
      if ((localObject2 != null) && ((localObject2 instanceof RichStatItemBuilder.Holder)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder = ((RichStatItemBuilder.Holder)localObject2);
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("list view item's tag can not cast to Holder, object:");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(",mPosition:");
        localStringBuilder.append(this.c);
        QLog.e("SigTlpAnimation", 2, localStringBuilder.toString());
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder;
      if (localObject2 == null)
      {
        a(true);
        return false;
      }
      if (((RichStatItemBuilder.Holder)localObject2).a != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.a();
      }
      if ((this.jdField_b_of_type_AndroidViewView != null) && (localObject1 != null))
      {
        k = ((View)localObject1).getLeft();
        j = a((View)localObject1, true) - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getParentTop(mHolder.sigView, true):");
          ((StringBuilder)localObject2).append(a((View)localObject1, true));
          ((StringBuilder)localObject2).append(",istview.getScrollY():");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
          QLog.e("SigTlpAnimation", 2, ((StringBuilder)localObject2).toString());
        }
        i = ((View)localObject1).getWidth();
        m = ((View)localObject1).getHeight();
        if (this.jdField_a_of_type_AndroidViewView != null) {
          jdField_b_of_type_AndroidGraphicsRect.top = 0;
        }
      }
      else
      {
        int n = 0;
        j = 0;
        i = 0;
        k = m;
        m = n;
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder = null;
        this.c = SignatureManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        localObject1 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.c));
        if ((localObject1 != null) && ((localObject1 instanceof SigTlpAnimation.ItemViewHolder)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder = ((SigTlpAnimation.ItemViewHolder)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("list view item's tag can not cast to ItemViewHolder, object:");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.e("SigTlpAnimation", 2, ((StringBuilder)localObject2).toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder == null) {
          return false;
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder.a.getRight();
          j = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder.a.getLeft();
          m = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder.a.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder.a.getTop();
          i -= j;
        }
        else
        {
          m = 0;
          i = 0;
        }
        j = 0;
      }
      else
      {
        k = ((View)localObject1).getLeft();
        j = this.jdField_a_of_type_AndroidViewView.getTop();
        i = this.jdField_a_of_type_AndroidViewView.getRight() - this.jdField_a_of_type_AndroidViewView.getLeft();
        m = this.jdField_a_of_type_AndroidViewView.getBottom() - this.jdField_a_of_type_AndroidViewView.getTop();
      }
    }
    float f2 = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.a;
    float f1 = i;
    int i = k + (int)(f2 * f1);
    f2 = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.b;
    float f3 = m;
    j += (int)(f2 * f3);
    this.jdField_a_of_type_AndroidGraphicsRect.set(i, j, (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.c * f1) + i, (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.d * f3) + j);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindView top=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(",left=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("SigTlpAnimation", 2, ((StringBuilder)localObject1).toString());
    }
    return true;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable.a();
    }
  }
  
  public void d()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation
 * JD-Core Version:    0.7.0.1
 */