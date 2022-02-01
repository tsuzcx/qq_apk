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
  private TextView l;
  private LinearLayout m;
  private TextView n;
  private LinkedHashMap<Integer, NickNameLayoutExtender> o;
  private BaseChatItemLayout p;
  private Context q;
  private BaseChatItemLayoutViewBasicAbility r;
  private View s;
  
  static
  {
    int i1 = k;
    k = i1 + 1;
    a = i1;
    i1 = k;
    k = i1 + 1;
    b = i1;
    i1 = k;
    k = i1 + 1;
    c = i1;
    i1 = k;
    k = i1 + 1;
    d = i1;
    i1 = k;
    k = i1 + 1;
    e = i1;
    i1 = k;
    k = i1 + 1;
    f = i1;
    i1 = k;
    k = i1 + 1;
    g = i1;
    i1 = k;
    k = i1 + 1;
    h = i1;
    i1 = k;
    k = i1 + 1;
    i = i1;
    i1 = k;
    k = i1 + 1;
    j = i1;
  }
  
  public NickNameChatItemLayoutProcessor(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.p = paramBaseChatItemLayout;
    this.q = paramContext;
  }
  
  private void a(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.rightMargin = this.m.getContext().getResources().getDimensionPixelSize(2131296651);
      if ((this.p.ac != null) && (this.p.ac.getVisibility() != 8)) {
        localLayoutParams.leftMargin = AIOUtils.b(30.0F, this.q.getResources());
      } else {
        localLayoutParams.leftMargin = AIOUtils.b(5.0F, this.q.getResources());
      }
      localLayoutParams.addRule(0, 2131430587);
      localLayoutParams.addRule(1, 0);
      return;
    }
    TextView localTextView = this.n;
    if ((localTextView != null) && (localTextView.getVisibility() == 0))
    {
      localLayoutParams.leftMargin = AIOUtils.b(4.0F, this.q.getResources());
      localLayoutParams.addRule(1, 2131430616);
    }
    else
    {
      localTextView = this.l;
      if ((localTextView != null) && (localTextView.getVisibility() == 0))
      {
        localLayoutParams.leftMargin = AIOUtils.b(2.0F, this.q.getResources());
        localLayoutParams.addRule(1, 2131430588);
      }
      else
      {
        localLayoutParams.leftMargin = this.q.getResources().getDimensionPixelSize(2131296651);
        localLayoutParams.addRule(1, 2131430587);
      }
    }
    localLayoutParams.rightMargin = AIOUtils.b(5.0F, this.q.getResources());
    localLayoutParams.addRule(0, 0);
  }
  
  private void d()
  {
    this.m = new RightLinearLayout(this.q);
    this.m.setOrientation(0);
    this.m.setGravity(53);
    this.m.setId(2131430596);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.q.getResources().getDimensionPixelSize(2131296653);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.q.getResources().getDimensionPixelSize(2131296652);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.p.getTopId());
    Object localObject2 = (BubbleViewWrapper)this.p.a(BubbleViewWrapper.class);
    if (localObject2 != null)
    {
      localObject2 = ((BubbleViewWrapper)localObject2).c();
      if (localObject2 != null)
      {
        ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject2).getLayoutParams()).addRule(3, 2131430596);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
        }
      }
    }
    this.p.addView(this.m, (ViewGroup.LayoutParams)localObject1);
    if (this.o == null)
    {
      this.o = new LinkedHashMap();
      this.o.put(Integer.valueOf(a), (NickNameLayoutExtender)((IQzoneRedDotExtender)QRoute.api(IQzoneRedDotExtender.class)).getQzoneRedDotExtender(this.q));
      this.o.put(Integer.valueOf(b), (NickNameLayoutExtender)((IQcircleRedDotExtender)QRoute.api(IQcircleRedDotExtender.class)).getQcircleRedDotExtender(this.q));
      this.o.put(Integer.valueOf(c), new TroopHonorViewExtender(this.q));
      this.o.put(Integer.valueOf(d), new NickNameExtraExtender(this.q));
      this.o.put(Integer.valueOf(e), new TroopMemberGradeLevelExtender(this.q));
      this.o.put(Integer.valueOf(f), new VipExtendIconExtender(this.q));
      this.o.put(Integer.valueOf(g), new VipIconExtender(this.q));
      this.o.put(Integer.valueOf(h), new NickNameExtender(this.q));
      this.o.put(Integer.valueOf(i), new TroopMemberNewLevelExtender(this.q));
      this.o.put(Integer.valueOf(j), new TroopMemberLevelExtender(this.q));
    }
    localObject1 = this.o.values().iterator();
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
            this.m.addView((View)localObject2);
          } else {
            this.m.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
        }
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      if (((LinearLayout)localObject).getVisibility() != 8)
      {
        this.m.setVisibility(8);
        localObject = (BubbleViewWrapper)this.p.a(BubbleViewWrapper.class);
        if (localObject != null)
        {
          localObject = ((BubbleViewWrapper)localObject).c();
          if (localObject != null)
          {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, this.p.getTopId());
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" setNick mTopId = ");
              ((StringBuilder)localObject).append(this.p.getTopId());
              QLog.d("BubbleView", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      localObject = b(h);
      if (localObject != null)
      {
        localObject = ((NickNameLayoutExtender)localObject).getView();
        if ((localObject instanceof ColorNickTextView)) {
          ((ColorNickTextView)localObject).setMosaicEffect(null);
        }
      }
    }
  }
  
  private void f()
  {
    if (this.m.getVisibility() != 0)
    {
      this.m.setVisibility(0);
      Object localObject = (BubbleViewWrapper)this.p.a(BubbleViewWrapper.class);
      if (localObject != null)
      {
        localObject = ((BubbleViewWrapper)localObject).c();
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, 2131430596);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name_layout");
          }
        }
      }
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility a()
  {
    if (this.r == null)
    {
      LinearLayout localLinearLayout = this.m;
      if (localLinearLayout != null) {
        this.r = new BaseChatItemLayoutViewBasicAbilityImpl(localLinearLayout);
      }
    }
    return this.r;
  }
  
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    NickNameLayoutExtender localNickNameLayoutExtender = b(paramInt);
    if (localNickNameLayoutExtender != null) {
      return localNickNameLayoutExtender.getBasicAbility();
    }
    return null;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.l == null)
      {
        this.l = new TextView(this.q);
        this.l.setId(2131430588);
        this.l.setTextSize(2, 12.0F);
        this.l.setIncludeFontPadding(false);
        this.l.setPadding(AIOUtils.b(5.0F, this.q.getResources()), 0, AIOUtils.b(5.0F, this.q.getResources()), 0);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setSingleLine();
        this.l.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.l.getContext().getResources().getDimensionPixelSize(2131296653);
        localLayoutParams.bottomMargin = this.l.getContext().getResources().getDimensionPixelSize(2131296652);
        localLayoutParams.addRule(3, this.p.getTopId());
        Object localObject = (BubbleViewWrapper)this.p.a(BubbleViewWrapper.class);
        if (localObject != null)
        {
          localObject = ((BubbleViewWrapper)localObject).c();
          if (localObject != null) {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, 2131430596);
          }
        }
        this.p.addView(this.l, localLayoutParams);
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
      localLayoutParams.leftMargin = this.l.getContext().getResources().getDimensionPixelSize(2131296651);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(1, 2131430587);
      localLayoutParams.addRule(0, 0);
      this.l.setTextColor(-1);
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).setHotChatRoleBg(this.l, paramInt);
      this.l.setPadding(AIOUtils.b(5.0F, this.q.getResources()), 0, AIOUtils.b(5.0F, this.q.getResources()), 0);
      if (this.l.getVisibility() != 0) {
        this.l.setVisibility(0);
      }
      this.l.setText(paramString);
      this.l.setContentDescription(paramString);
      return;
    }
    paramString = this.l;
    if ((paramString != null) && (paramString.getVisibility() != 4)) {
      this.l.setVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.n == null)
      {
        this.n = new TextView(this.q);
        this.n.setId(2131430616);
        this.n.setGravity(16);
        this.n.setIncludeFontPadding(false);
        localObject1 = this.n;
        ((TextView)localObject1).setCompoundDrawablePadding(AIOUtils.b(2.0F, ((TextView)localObject1).getContext().getResources()));
        localObject1 = this.n;
        ((TextView)localObject1).setPadding(AIOUtils.b(4.0F, ((TextView)localObject1).getContext().getResources()), 0, AIOUtils.b(4.0F, this.n.getContext().getResources()), 0);
        localObject1 = this.n;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("LV");
        ((StringBuilder)localObject2).append(paramInt);
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.n.setTextColor(-1);
        localObject1 = this.n.getContext().getResources().getDrawable(2130847146);
        localObject2 = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).getGlamourLevelColors(this.n.getContext());
        int i2 = Color.parseColor("#FFCC59");
        int i1 = i2;
        if (localObject2 != null)
        {
          i1 = i2;
          if (paramInt < localObject2.length) {
            i1 = localObject2[paramInt];
          }
        }
        localObject2 = this.n;
        ((TextView)localObject2).setBackgroundDrawable(BizTroopUtil.a(((TextView)localObject2).getContext().getResources(), i1, (Drawable)localObject1));
        this.n.setTextSize(1, 10.0F);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = DisplayUtil.a(this.q, 1.0F);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.q, 1.0F);
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131430596);
        localObject2 = (BubbleViewWrapper)this.p.a(BubbleViewWrapper.class);
        if (localObject2 != null)
        {
          localObject2 = ((BubbleViewWrapper)localObject2).c();
          if (localObject2 != null) {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject2).getLayoutParams()).addRule(3, 2131430596);
          }
        }
        this.p.addView(this.n, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
      if (this.p.d())
      {
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(2.0F, this.q.getResources());
        localObject2 = this.l;
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131430596);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.q.getResources());
          localObject1 = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131430616);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131430596);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        }
      }
      else
      {
        localObject2 = this.l;
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.q.getResources());
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131430588);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.E;
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131430587);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
        }
      }
      localObject1 = this.n;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LV");
      ((StringBuilder)localObject2).append(paramInt);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.n.setVisibility(0);
      return;
    }
    Object localObject1 = this.n;
    if ((localObject1 != null) && (((TextView)localObject1).getVisibility() != 8)) {
      this.n.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, NickNameChatItemLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    if (paramBoolean)
    {
      if (this.m == null) {
        d();
      }
      a(paramNickNameLayoutData.c);
      f();
      Iterator localIterator = this.o.values().iterator();
      while (localIterator.hasNext()) {
        ((NickNameLayoutExtender)localIterator.next()).updateView(paramNickNameLayoutData);
      }
    }
    e();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      Object localObject2;
      if (this.n == null)
      {
        this.n = new TextView(this.q);
        this.n.setId(2131430616);
        this.n.setGravity(16);
        this.n.setIncludeFontPadding(false);
        localObject1 = this.n;
        ((TextView)localObject1).setCompoundDrawablePadding(AIOUtils.b(2.0F, ((TextView)localObject1).getContext().getResources()));
        localObject1 = this.n;
        ((TextView)localObject1).setPadding(AIOUtils.b(4.0F, ((TextView)localObject1).getContext().getResources()), 0, AIOUtils.b(4.0F, this.n.getContext().getResources()), 0);
        this.n.setText(paramString);
        this.n.setTextColor(-1);
        localObject1 = this.n.getContext().getResources().getDrawable(2130847146);
        int i1 = Color.parseColor("#12B7F5");
        localObject2 = this.n;
        ((TextView)localObject2).setBackgroundDrawable(BizTroopUtil.a(((TextView)localObject2).getContext().getResources(), i1, (Drawable)localObject1));
        this.n.setTextSize(1, 10.0F);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = DisplayUtil.a(this.q, 1.0F);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.q, 1.0F);
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131430596);
        localObject2 = (BubbleViewWrapper)this.p.a(BubbleViewWrapper.class);
        if (localObject2 != null)
        {
          localObject2 = ((BubbleViewWrapper)localObject2).c();
          if (localObject2 != null)
          {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject2).getLayoutParams()).addRule(3, 2131430596);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
            }
          }
        }
        this.p.addView(this.n, (ViewGroup.LayoutParams)localObject1);
      }
      Object localObject1 = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
      if (this.p.d())
      {
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(2.0F, this.q.getResources());
        localObject2 = this.l;
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131430596);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.q.getResources());
          localObject1 = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131430616);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131430596);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        }
      }
      else
      {
        localObject2 = this.l;
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.q.getResources());
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131430588);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.E;
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131430587);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
        }
      }
      this.n.setText(paramString);
      this.n.setVisibility(0);
      return;
    }
    paramString = this.n;
    if ((paramString != null) && (paramString.getVisibility() != 8)) {
      this.n.setVisibility(8);
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
      if (this.s == null)
      {
        this.s = RobotChatUtil.b(this.q);
        localObject = this.s;
        if (localObject != null)
        {
          ((View)localObject).setId(2131430623);
          localObject = new RelativeLayout.LayoutParams(-2, DisplayUtil.a(this.q, 16.0F));
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131430596);
          this.p.addView(this.s, (ViewGroup.LayoutParams)localObject);
          localObject = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(-1.0F, this.q.getResources());
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(4.0F, this.q.getResources());
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131430596);
        }
      }
      localObject = this.s;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.s;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility b()
  {
    return new BaseChatItemLayoutViewBasicAbilityImpl(this.n);
  }
  
  public NickNameLayoutExtender b(int paramInt)
  {
    LinkedHashMap localLinkedHashMap = this.o;
    if (localLinkedHashMap != null) {
      return (NickNameLayoutExtender)localLinkedHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public BaseChatItemLayoutViewBasicAbility c()
  {
    return new BaseChatItemLayoutViewBasicAbilityImpl(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor
 * JD-Core Version:    0.7.0.1
 */