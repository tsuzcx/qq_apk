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
import com.tencent.mobileqq.widget.MutilayoutSlideDetectListView;
import com.tencent.qphone.base.util.QLog;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = null;
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
      do
      {
        if ((localView instanceof ChatXListView)) {
          break;
        }
        j = localView.getTop() + i;
        paramView = (View)localView.getParent();
        localView = paramView;
        i = j;
      } while (paramView != null);
      return j;
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
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(true);
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.offsetChildrenTopAndBottom(paramInt);
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
      if (QLog.isColorLevel()) {
        QLog.d("SigTlpAnimation", 2, "rect.left=" + this.jdField_a_of_type_AndroidGraphicsRect.left + ",rect.top=" + this.jdField_a_of_type_AndroidGraphicsRect.top);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(jdField_b_of_type_AndroidGraphicsRect.left);
        this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(jdField_b_of_type_AndroidGraphicsRect.top);
        if (QLog.isColorLevel()) {
          QLog.d("SigTlpAnimation", 2, "rectAio.left=" + jdField_b_of_type_AndroidGraphicsRect.left + ",rectAio.top=" + jdField_b_of_type_AndroidGraphicsRect.top);
        }
      }
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.post(new SigTlpAnimation.1(this));
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    Object localObject = new File(paramString);
    boolean bool1;
    if ((localObject == null) || (!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (this.jdField_a_of_type_ArrayOfJavaLangString != null);
    localObject = FileUtils.a(paramString);
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[((ArrayList)localObject).size()];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString).append(File.separator).append("%d.png");
    paramString = ((StringBuilder)localObject).toString();
    int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = String.format(paramString, new Object[] { Integer.valueOf(i + 1) });
      i += 1;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return false;
    }
    if (b())
    {
      if (paramBoolean) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
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
        if (((this.jdField_a_of_type_AndroidViewView instanceof TextView)) && (localObject != null) && ((localObject instanceof RelativeLayout)))
        {
          localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.getParent();
          Rect localRect = jdField_b_of_type_AndroidGraphicsRect;
          int i = this.jdField_a_of_type_AndroidViewView.getLeft();
          int j = ((RelativeLayout)localObject).getLeft();
          localRect.left = (((View)((RelativeLayout)localObject).getParent()).getLeft() + (j + i));
          ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SigTlpAnimation", 2, "paramButton.width=" + localLayoutParams2.width + ",paramButton.height=" + localLayoutParams2.height);
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
    if (QLog.isColorLevel()) {
      QLog.d("SigTlpAnimation", 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(false);
  }
  
  public boolean b()
  {
    int k = 0;
    Object localObject;
    label162:
    int m;
    int j;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder = null;
      this.c = AIOUtils.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.c));
      if ((localObject != null) && ((localObject instanceof RichStatItemBuilder.Holder))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder = ((RichStatItemBuilder.Holder)localObject);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder == null)
      {
        a(true);
        return false;
        if (QLog.isColorLevel()) {
          QLog.e("SigTlpAnimation", 2, "list view item's tag can not cast to Holder, object:" + localObject + ",mPosition:" + this.c);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.a();
        if ((this.jdField_b_of_type_AndroidViewView == null) || (localObject == null)) {
          break label649;
        }
        m = ((View)localObject).getLeft();
        j = a((View)localObject, true);
        int n = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
        if (QLog.isColorLevel()) {
          QLog.e("SigTlpAnimation", 2, "getParentTop(mHolder.sigView, true):" + a((View)localObject, true) + ",istview.getScrollY():" + this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
        }
        k = ((View)localObject).getWidth();
        i = ((View)localObject).getHeight();
        if (this.jdField_a_of_type_AndroidViewView != null) {
          jdField_b_of_type_AndroidGraphicsRect.top = 0;
        }
        j -= n;
      }
    }
    for (;;)
    {
      label284:
      m += (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.a * k);
      j += (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.b * i);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      float f = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.c;
      k = (int)(k * f);
      f = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.d;
      ((Rect)localObject).set(m, j, k + m, (int)(i * f) + j);
      if (QLog.isColorLevel()) {
        QLog.d("SigTlpAnimation", 2, "bindView top=" + j + ",left=" + m);
      }
      return true;
      localObject = null;
      break label162;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder = null;
        this.c = SignatureManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.c));
        if ((localObject != null) && ((localObject instanceof SigTlpAnimation.ItemViewHolder)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder = ((SigTlpAnimation.ItemViewHolder)localObject);
          label484:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder == null) {
            break label587;
          }
          if (this.jdField_b_of_type_AndroidViewView == null) {
            break label642;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder.a.getRight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder.a.getLeft();
          i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder.a.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation$ItemViewHolder.a.getTop();
        }
      }
      for (;;)
      {
        m = 0;
        k = j;
        j = 0;
        break label284;
        if (!QLog.isColorLevel()) {
          break label484;
        }
        QLog.e("SigTlpAnimation", 2, "list view item's tag can not cast to ItemViewHolder, object:" + localObject);
        break label484;
        label587:
        break;
        m = this.jdField_a_of_type_AndroidViewView.getLeft();
        j = this.jdField_a_of_type_AndroidViewView.getTop();
        k = this.jdField_a_of_type_AndroidViewView.getRight() - this.jdField_a_of_type_AndroidViewView.getLeft();
        i = this.jdField_a_of_type_AndroidViewView.getBottom() - this.jdField_a_of_type_AndroidViewView.getTop();
        break label284;
        label642:
        i = 0;
        j = 0;
      }
      label649:
      i = 0;
      j = 0;
      m = 0;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
  }
  
  public void d()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation
 * JD-Core Version:    0.7.0.1
 */