package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.RightLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopHonorViewExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberGradeLevelExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberLevelExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberNewLevelExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipExtendIconExtender;
import com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipIconExtender;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.robotchat.RobotChatUtil;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.aioreddot.IQcircleRedDotExtender;
import com.tencent.qzonehub.api.aioreddot.IQzoneRedDotExtender;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class NickNameChatItemLayoutProcessor
  implements INickNameLayoutProcessor
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
  private static int k;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  private BaseChatItemLayoutViewBasicAbility jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility;
  private LinkedHashMap<Integer, NickNameLayoutExtender> jdField_a_of_type_JavaUtilLinkedHashMap;
  private TextView b;
  
  static
  {
    int m = k;
    k = m + 1;
    jdField_a_of_type_Int = m;
    m = k;
    k = m + 1;
    jdField_b_of_type_Int = m;
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
  
  public NickNameChatItemLayoutProcessor(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new RightLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(53);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131364539);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296421);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296420);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
    Object localObject2 = (BubbleViewWrapper)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(BubbleViewWrapper.class);
    if (localObject2 != null)
    {
      localObject2 = ((BubbleViewWrapper)localObject2).a();
      if (localObject2 != null)
      {
        ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject2).getLayoutParams()).addRule(3, 2131364539);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject1);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(jdField_a_of_type_Int), (NickNameLayoutExtender)((IQzoneRedDotExtender)QRoute.api(IQzoneRedDotExtender.class)).getQzoneRedDotExtender(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(jdField_b_of_type_Int), (NickNameLayoutExtender)((IQcircleRedDotExtender)QRoute.api(IQcircleRedDotExtender.class)).getQcircleRedDotExtender(this.jdField_a_of_type_AndroidContentContext));
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
      Object localObject3 = (NickNameLayoutExtender)((Iterator)localObject1).next();
      if (localObject3 != null)
      {
        localObject2 = ((NickNameLayoutExtender)localObject3).getView();
        if (localObject2 != null)
        {
          localObject3 = ((NickNameLayoutExtender)localObject3).getViewLayoutParams();
          if (localObject3 == null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          } else {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.rightMargin = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getDimensionPixelSize(2131296419);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() != 8)) {
        localLayoutParams.leftMargin = AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      } else {
        localLayoutParams.leftMargin = AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      localLayoutParams.addRule(0, 2131364530);
      localLayoutParams.addRule(1, 0);
      return;
    }
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() == 0))
    {
      localLayoutParams.leftMargin = AIOUtils.b(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.addRule(1, 2131364557);
    }
    else
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((localTextView != null) && (localTextView.getVisibility() == 0))
      {
        localLayoutParams.leftMargin = AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(1, 2131364531);
      }
      else
      {
        localLayoutParams.leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296419);
        localLayoutParams.addRule(1, 2131364530);
      }
    }
    localLayoutParams.rightMargin = AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.addRule(0, 0);
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null)
    {
      if (((LinearLayout)localObject).getVisibility() != 8)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject = (BubbleViewWrapper)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(BubbleViewWrapper.class);
        if (localObject != null)
        {
          localObject = ((BubbleViewWrapper)localObject).a();
          if (localObject != null)
          {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" setNick mTopId = ");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
              QLog.d("BubbleView", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      localObject = a(h);
      if (localObject != null)
      {
        localObject = ((NickNameLayoutExtender)localObject).getView();
        if ((localObject instanceof ColorNickTextView)) {
          ((ColorNickTextView)localObject).setMosaicEffect(null);
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      Object localObject = (BubbleViewWrapper)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(BubbleViewWrapper.class);
      if (localObject != null)
      {
        localObject = ((BubbleViewWrapper)localObject).a();
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, 2131364539);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name_layout");
          }
        }
      }
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility == null)
    {
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility = new BaseChatItemLayoutViewBasicAbilityImpl(localLinearLayout);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility;
  }
  
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    NickNameLayoutExtender localNickNameLayoutExtender = a(paramInt);
    if (localNickNameLayoutExtender != null) {
      return localNickNameLayoutExtender.getBasicAbility();
    }
    return null;
  }
  
  public NickNameLayoutExtender a(int paramInt)
  {
    LinkedHashMap localLinkedHashMap = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    if (localLinkedHashMap != null) {
      return (NickNameLayoutExtender)localLinkedHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131364531);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131296421);
        localLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131296420);
        localLayoutParams.addRule(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
        Object localObject = (BubbleViewWrapper)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(BubbleViewWrapper.class);
        if (localObject != null)
        {
          localObject = ((BubbleViewWrapper)localObject).a();
          if (localObject != null) {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, 2131364539);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.leftMargin = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131296419);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(1, 2131364530);
      localLayoutParams.addRule(0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).setHotChatRoleBg(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      return;
    }
    paramString = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((paramString != null) && (paramString.getVisibility() != 4)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetTextView.setId(2131364557);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
        ((TextView)localObject1).setCompoundDrawablePadding(AIOUtils.b(2.0F, ((TextView)localObject1).getContext().getResources()));
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
        ((TextView)localObject1).setPadding(AIOUtils.b(4.0F, ((TextView)localObject1).getContext().getResources()), 0, AIOUtils.b(4.0F, this.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources()), 0);
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("LV");
        ((StringBuilder)localObject2).append(paramInt);
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getDrawable(2130845677);
        localObject2 = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).getGlamourLevelColors(this.jdField_b_of_type_AndroidWidgetTextView.getContext());
        int n = Color.parseColor("#FFCC59");
        int m = n;
        if (localObject2 != null)
        {
          m = n;
          if (paramInt < localObject2.length) {
            m = localObject2[paramInt];
          }
        }
        localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
        ((TextView)localObject2).setBackgroundDrawable(BizTroopUtil.a(((TextView)localObject2).getContext().getResources(), m, (Drawable)localObject1));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131364539);
        localObject2 = (BubbleViewWrapper)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(BubbleViewWrapper.class);
        if (localObject2 != null)
        {
          localObject2 = ((BubbleViewWrapper)localObject2).a();
          if (localObject2 != null) {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject2).getLayoutParams()).addRule(3, 2131364539);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c())
      {
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364539);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364557);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364539);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131364531);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.E;
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131364530);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
        }
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LV");
      ((StringBuilder)localObject2).append(paramInt);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localObject1 != null) && (((TextView)localObject1).getVisibility() != 8)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, NickNameChatItemLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        a();
      }
      a(paramNickNameLayoutData.a);
      c();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((NickNameLayoutExtender)localIterator.next()).updateView(paramNickNameLayoutData);
      }
    }
    b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      Object localObject2;
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetTextView.setId(2131364557);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
        ((TextView)localObject1).setCompoundDrawablePadding(AIOUtils.b(2.0F, ((TextView)localObject1).getContext().getResources()));
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
        ((TextView)localObject1).setPadding(AIOUtils.b(4.0F, ((TextView)localObject1).getContext().getResources()), 0, AIOUtils.b(4.0F, this.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources()), 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getDrawable(2130845677);
        int m = Color.parseColor("#12B7F5");
        localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
        ((TextView)localObject2).setBackgroundDrawable(BizTroopUtil.a(((TextView)localObject2).getContext().getResources(), m, (Drawable)localObject1));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131364539);
        localObject2 = (BubbleViewWrapper)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(BubbleViewWrapper.class);
        if (localObject2 != null)
        {
          localObject2 = ((BubbleViewWrapper)localObject2).a();
          if (localObject2 != null)
          {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject2).getLayoutParams()).addRule(3, 2131364539);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
      }
      Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c())
      {
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364539);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364557);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364539);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131364531);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.E;
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131364530);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramString = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((paramString != null) && (paramString.getVisibility() != 8)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return;
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = RobotChatUtil.a(this.jdField_a_of_type_AndroidContentContext);
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null)
        {
          ((View)localObject).setId(2131364564);
          localObject = new RelativeLayout.LayoutParams(-2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131364539);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(-1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131364539);
        }
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility b()
  {
    return new BaseChatItemLayoutViewBasicAbilityImpl(this.jdField_b_of_type_AndroidWidgetTextView);
  }
  
  public BaseChatItemLayoutViewBasicAbility c()
  {
    return new BaseChatItemLayoutViewBasicAbilityImpl(this.jdField_a_of_type_AndroidWidgetTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor
 * JD-Core Version:    0.7.0.1
 */