package com.tencent.mobileqq.activity.contacts.newfriendentry;

import android.content.res.Resources;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class CTNewFriendEntryController
{
  private RelativeLayout a;
  private SingleLineTextView b;
  private ImageView c;
  private RelativeLayout d;
  private RelativeLayout e;
  private SingleLineTextView f;
  private SingleLineTextView g;
  private RecyclerView h;
  private NewFriendEntryMultiHeadsAdapter i;
  private TextView j;
  private TextView k;
  private QQAppInterface l;
  private ViewGroup.LayoutParams m;
  private int n;
  private int o;
  
  public CTNewFriendEntryController(RelativeLayout paramRelativeLayout, QQAppInterface paramQQAppInterface)
  {
    this.a = paramRelativeLayout;
    this.m = paramRelativeLayout.getLayoutParams();
    this.l = paramQQAppInterface;
    this.j = ((TextView)paramRelativeLayout.findViewById(2131448118));
    this.k = ((TextView)paramRelativeLayout.findViewById(2131439394));
    this.b = ((SingleLineTextView)paramRelativeLayout.findViewById(2131439280));
    this.c = ((ImageView)paramRelativeLayout.findViewById(2131439281));
    this.d = ((RelativeLayout)paramRelativeLayout.findViewById(2131439274));
    this.e = ((RelativeLayout)paramRelativeLayout.findViewById(2131439564));
    this.f = ((SingleLineTextView)paramRelativeLayout.findViewById(2131439320));
    this.g = ((SingleLineTextView)paramRelativeLayout.findViewById(2131444678));
    a(paramRelativeLayout);
    b();
    if (QLog.isColorLevel())
    {
      paramRelativeLayout = new StringBuilder();
      paramRelativeLayout.append("CTNewFriendEntryController maxDisplayHeadCount = ");
      paramRelativeLayout.append(this.n);
      QLog.d("CTNewFriendEntryController", 2, paramRelativeLayout.toString());
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (INewFriendService)this.l.getRuntimeService(INewFriendService.class, "");
    StringBuilder localStringBuilder = new StringBuilder(32);
    if (paramInt == 0)
    {
      localObject = ((INewFriendService)localObject).getLastUnreadNewFriendMessage();
      int i2 = 1;
      int i1;
      if ((localObject != null) && (((NewFriendMessage)localObject).a(this.l)))
      {
        if (paramBoolean) {
          ReportController.b(this.l, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
        }
        localStringBuilder.append(this.l.getApp().getResources().getString(2131892123));
        localStringBuilder.append(" 有更新");
        i1 = i2;
      }
      else if (((INewFriendVerificationService)this.l.getRuntimeService(INewFriendVerificationService.class)).isShowRedPoint())
      {
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("CTNewFriendEntryController", 2, "contacts updateUnreadCount");
          i1 = i2;
        }
      }
      else
      {
        localStringBuilder.append(this.l.getApp().getResources().getString(2131917035));
        i1 = 0;
      }
      CustomWidgetUtil.a(this.k, i1, paramInt, 0);
      this.j.setVisibility(4);
      this.k.setVisibility(0);
    }
    else if (paramInt > 0)
    {
      if (paramBoolean) {
        ReportController.b(this.l, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
      }
      localStringBuilder.append(this.l.getApp().getResources().getString(2131892123));
      localStringBuilder.append(" ");
      if (paramInt > 99)
      {
        localStringBuilder.append("多于99条未读");
      }
      else
      {
        localStringBuilder.append(paramInt);
        localStringBuilder.append("条未读");
      }
      CustomWidgetUtil.a(this.j, 3, paramInt, 0);
      this.j.setVisibility(0);
      this.k.setVisibility(4);
    }
    this.a.setContentDescription(localStringBuilder.toString());
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    this.h = ((RecyclerView)paramRelativeLayout.findViewById(2131439271));
    int i1 = ViewUtils.getScreenWidth();
    int i2 = ViewUtils.dpToPx(68.0F);
    int i3 = ViewUtils.dpToPx(48.0F);
    int i4 = ViewUtils.dpToPx(8.0F);
    i2 = i1 - i2 + i4;
    i1 = i2 / i3;
    int i5 = i2 % i3;
    if (i5 > i4)
    {
      i2 = i1 + 1;
      float f1 = (i5 - i4) * 1.0F / (i3 - i4);
      paramRelativeLayout = new CTNewFriendEntryController.1(this, f1);
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory(paramRelativeLayout);
      i1 = i2;
      paramRelativeLayout = localPaintDrawable;
      if (QLog.isColorLevel())
      {
        paramRelativeLayout = new StringBuilder();
        paramRelativeLayout.append("initHeadsRecyclerView count = ");
        paramRelativeLayout.append(i2);
        paramRelativeLayout.append(", ratio = ");
        paramRelativeLayout.append(f1);
        QLog.d("CTNewFriendEntryController", 2, paramRelativeLayout.toString());
        i1 = i2;
        paramRelativeLayout = localPaintDrawable;
      }
    }
    else
    {
      paramRelativeLayout = null;
    }
    this.n = i1;
    this.i = new NewFriendEntryMultiHeadsAdapter(this.l, null, paramRelativeLayout, this.n);
    this.h.setAdapter(this.i);
    this.h.setLayoutFrozen(true);
    this.h.addItemDecoration(new NewFriendEntryMultiHeadsAdapter.SpacesItemDecoration(ViewUtils.dpToPx(8.0F)));
    paramRelativeLayout = new DefaultItemAnimator();
    paramRelativeLayout.setAddDuration(1000L);
    this.h.setItemAnimator(paramRelativeLayout);
    paramRelativeLayout = new LinearLayoutManager(this.l.getApp());
    paramRelativeLayout.setOrientation(0);
    this.h.setLayoutManager(paramRelativeLayout);
  }
  
  private void a(List<Object> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() < 0) {
        return;
      }
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      this.b.setVisibility(4);
      this.c.setVisibility(4);
      this.h.setVisibility(0);
      this.m.height = ViewUtils.dpToPx(93.0F);
      this.a.requestLayout();
      Object localObject1 = paramList.get(0);
      if ((localObject1 instanceof FriendSystemMessage))
      {
        Object localObject2 = (FriendSystemMessage)localObject1;
        this.f.setText(((FriendSystemMessage)localObject2).c());
        localObject1 = ((FriendSystemMessage)localObject2).a(this.e.getContext());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showOneNewFriendUI nickname = ");
          localStringBuilder.append(((FriendSystemMessage)localObject2).c());
          localStringBuilder.append("reqContent = ");
          localStringBuilder.append((String)localObject1);
          QLog.d("CTNewFriendEntryController", 2, localStringBuilder.toString());
        }
        this.g.setText((CharSequence)localObject1);
        localObject2 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(15);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(15, 0);
        }
      }
      else if ((localObject1 instanceof PhoneContact))
      {
        localObject1 = (PhoneContact)localObject1;
        this.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
      }
      else if ((localObject1 instanceof ContactMatchMessage))
      {
        localObject1 = (ContactMatchMessage)localObject1;
        this.f.setText(((ContactMatchMessage)localObject1).a.name);
        localObject1 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
      }
      this.i.a(paramList.subList(0, 1));
    }
  }
  
  private void a(boolean paramBoolean, List<Object> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showMultiNewFriendUI doAnimate = ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(",count = ");
        localStringBuilder.append(paramList.size());
        QLog.d("CTNewFriendEntryController", 2, localStringBuilder.toString());
      }
      this.d.setVisibility(0);
      this.h.setVisibility(0);
      this.e.setVisibility(4);
      this.b.setVisibility(4);
      this.c.setVisibility(4);
      this.m.height = ViewUtils.dpToPx(93.0F);
      this.a.requestLayout();
      if (paramBoolean)
      {
        if (paramList.size() > 0) {
          this.i.a(paramList.get(0));
        }
      }
      else {
        this.i.a(paramList);
      }
    }
  }
  
  private void b()
  {
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
    this.e.setVisibility(4);
    this.h.setVisibility(4);
    this.m.height = ViewUtils.dpToPx(56.0F);
    this.a.requestLayout();
  }
  
  public void a()
  {
    int i2 = this.o;
    int i1 = 1;
    if (i2 != 1) {
      if (i2 > 1) {
        i1 = 2;
      } else {
        i1 = 0;
      }
    }
    ReportController.b(this.l, "dc00898", "", "", "0X8007F18", "0X8007F18", 1, 0, String.valueOf(i1), "", "", "");
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTNewFriendEntryController", 2, "clearData");
    }
    this.l = paramQQAppInterface;
    this.h.getRecycledViewPool().clear();
    this.i.a(paramQQAppInterface);
    this.i.a(new ArrayList());
  }
  
  public void a(List<Object> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList != null)
    {
      if (paramList.size() < 0) {
        return;
      }
      int i1 = paramList.size();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateRedDotCount count = ");
        localStringBuilder.append(i1);
        localStringBuilder.append(",doAnimate = ");
        localStringBuilder.append(paramBoolean1);
        QLog.d("CTNewFriendEntryController", 2, localStringBuilder.toString());
      }
      if (i1 == 0)
      {
        b();
      }
      else
      {
        boolean bool = true;
        if (i1 == 1)
        {
          a(paramList);
        }
        else
        {
          if ((paramBoolean1) && (i1 - this.o == 1)) {
            paramBoolean1 = bool;
          } else {
            paramBoolean1 = false;
          }
          a(paramBoolean1, paramList);
        }
      }
      this.o = i1;
      a(i1, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController
 * JD-Core Version:    0.7.0.1
 */