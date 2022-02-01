package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.RightLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopHonorViewExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberGradeLevelExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberLevelExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberNewLevelExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipExtendIconExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipIconExtender;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.aioreddot.QcircleRedDotExtender;
import cooperation.qzone.aioreddot.QzoneRedDotExtender;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class NickNameLayoutProcessor
  implements INickNameLayoutProcessor, INickNameLayoutViewBasicAbility
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  private static int k = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  private LinkedHashMap<Integer, NickNameLayoutExtender> jdField_a_of_type_JavaUtilLinkedHashMap;
  
  static
  {
    int m = k;
    k = m + 1;
    jdField_a_of_type_Int = m;
    m = k;
    k = m + 1;
    b = m;
    m = k;
    k = m + 1;
    c = m;
    m = k;
    k = m + 1;
    d = m;
    m = k;
    k = m + 1;
    e = m;
    m = k;
    k = m + 1;
    f = m;
    m = k;
    k = m + 1;
    g = m;
    m = k;
    k = m + 1;
    h = m;
    m = k;
    k = m + 1;
    i = m;
    m = k;
    k = m + 1;
    j = m;
  }
  
  public NickNameLayoutProcessor(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b();
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)((View)localObject).getLayoutParams()).addRule(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
          }
        }
      }
      Object localObject = a(h);
      if (localObject != null)
      {
        localObject = ((NickNameLayoutExtender)localObject).getView();
        if ((localObject instanceof ColorNickTextView)) {
          ((ColorNickTextView)localObject).setMosaicEffect(null);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.rightMargin = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getDimensionPixelSize(2131296440);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; localLayoutParams.leftMargin = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
      {
        localLayoutParams.addRule(0, 2131364643);
        localLayoutParams.addRule(1, 0);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c())
    {
      localLayoutParams.leftMargin = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.addRule(1, 2131364670);
    }
    for (;;)
    {
      localLayoutParams.rightMargin = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.addRule(0, 0);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.d())
      {
        localLayoutParams.leftMargin = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(1, 2131364644);
      }
      else
      {
        localLayoutParams.leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296440);
        localLayoutParams.addRule(1, 2131364643);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b();
      if (localView != null)
      {
        ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(3, 2131364652);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name_layout");
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new RightLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(53);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131364652);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296442);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296441);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b();
    if (localView != null)
    {
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(3, 2131364652);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject1);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(jdField_a_of_type_Int), new QzoneRedDotExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(b), new QcircleRedDotExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(c), new TroopHonorViewExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(d), new NickNameExtraExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(e), new TroopMemberGradeLevelExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(f), new VipExtendIconExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(g), new VipIconExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(h), new NickNameExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(i), new TroopMemberNewLevelExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(j), new TroopMemberLevelExtender(this.jdField_a_of_type_AndroidContentContext));
    }
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (NickNameLayoutExtender)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localView = ((NickNameLayoutExtender)localObject2).getView();
        if (localView != null)
        {
          localObject2 = ((NickNameLayoutExtender)localObject2).getViewLayoutParams();
          if (localObject2 == null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          } else {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject2);
          }
        }
      }
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public NickNameExtenderViewBasicAbility a(int paramInt)
  {
    NickNameLayoutExtender localNickNameLayoutExtender = a(paramInt);
    if (localNickNameLayoutExtender != null) {
      return localNickNameLayoutExtender.getBasicAbility();
    }
    return null;
  }
  
  public NickNameLayoutExtender a(int paramInt)
  {
    NickNameLayoutExtender localNickNameLayoutExtender = null;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) {
      localNickNameLayoutExtender = (NickNameLayoutExtender)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    }
    return localNickNameLayoutExtender;
  }
  
  public void a(boolean paramBoolean, NickNameLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        c();
      }
      a(paramNickNameLayoutData.a);
      b();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((NickNameLayoutExtender)localIterator.next()).updateView(paramNickNameLayoutData);
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor
 * JD-Core Version:    0.7.0.1
 */