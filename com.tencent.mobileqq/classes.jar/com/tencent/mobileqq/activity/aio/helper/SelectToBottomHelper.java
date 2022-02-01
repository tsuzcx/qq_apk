package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectTouchBarView;
import com.tencent.widget.ListView;
import java.util.List;

public class SelectToBottomHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  private ListView b;
  private List<ChatMessage> c;
  private ListAdapter d;
  private SelectTouchBarView e;
  private int f = 0;
  
  public SelectToBottomHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = this.a.U;
    this.d = this.a.V;
    if (this.d != null) {
      this.c = this.a.V.a();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = MultiMsgManager.a();
    int i = paramInt1;
    while (i <= paramInt2)
    {
      if ((i >= 0) && (i < this.c.size()))
      {
        ChatMessage localChatMessage = (ChatMessage)this.c.get(i);
        if ((((MultiMsgManager)localObject).a(localChatMessage) != paramBoolean) && (MultiMsgUtil.d(localChatMessage)) && (this.a != null))
        {
          int j = MultiMsgManager.a().c();
          if ((paramBoolean) && (MultiMsgManager.a().a(localChatMessage, j)))
          {
            if (MultiMsgManager.a().e == 7) {
              localObject = this.a.e.getString(2131896475, new Object[] { Integer.valueOf(j) });
            } else {
              localObject = this.a.e.getString(2131896474, new Object[] { Integer.valueOf(j) });
            }
            QQToast.makeText(this.a.e, (CharSequence)localObject, 0).show();
            return;
          }
          ((MultiMsgManager)localObject).a(localChatMessage, paramBoolean);
          this.a.a(localChatMessage, null, paramBoolean);
          ((ChatAdapter1)this.d).notifyDataSetChanged();
        }
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("item index: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" to ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" Perform select");
    QLog.d("SelectToBottomHelper", 3, ((StringBuilder)localObject).toString());
  }
  
  private void a(View paramView)
  {
    g();
    if ((this.a != null) && (this.c != null))
    {
      if (this.b == null) {
        return;
      }
      g();
      this.f = this.c.size();
      if (MultiMsgManager.a().f() == 0) {
        QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131911223), 0).show();
      }
      int i = d();
      int k = e();
      int j = c();
      if ((j >= 0) && (i >= 0))
      {
        if (k < 0) {
          return;
        }
        if (j < i) {
          return;
        }
        k = j + 1;
        int m = this.b.getCount() - 1;
        if ((k < this.b.getCount()) && (k <= m)) {
          a(k, m, false);
        }
        a(i, j);
        paramView = this.a;
        if ((paramView != null) && (paramView.ah != null))
        {
          j = MultiMsgManager.a().f();
          i = Integer.valueOf(ChatActivityUtils.c(this.a.ah.a)).intValue();
          if (i == 0) {
            i = 1;
          } else if (i == 1) {
            i = 3;
          } else if (i == 3) {
            i = 2;
          } else if (i == 2) {
            i = 4;
          } else {
            i = 5;
          }
          ReportController.b(this.a.i(), "dc00898", "", "", "0X800A510", "0X800A510", i, j, "", "", "", "");
        }
      }
    }
  }
  
  private int c()
  {
    g();
    int j = this.b.getFirstVisiblePosition();
    int i = this.b.getChildCount() - 1;
    while (i >= 0)
    {
      if (c(i))
      {
        i = i + j - 1;
        break label52;
      }
      i -= 1;
    }
    i = -1;
    label52:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Real last visible index is: ");
    localStringBuilder.append(i);
    QLog.d("SelectToBottomHelper", 3, localStringBuilder.toString());
    return i;
  }
  
  private boolean c(int paramInt)
  {
    g();
    Object localObject = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (paramInt >= 0)
      {
        bool1 = bool2;
        if (paramInt <= ((ListView)localObject).getCount())
        {
          if (this.e == null) {
            return false;
          }
          localObject = this.b.getChildAt(paramInt);
          int i = ((View)localObject).getTop();
          paramInt = i;
          if ((localObject instanceof BaseChatItemLayout))
          {
            localObject = (HeadIconWrapper)((BaseChatItemLayout)localObject).a(HeadIconWrapper.class);
            paramInt = i;
            if (localObject != null)
            {
              localObject = ((HeadIconWrapper)localObject).c();
              paramInt = i;
              if (localObject != null) {
                paramInt = i + ((BaseChatItemLayoutViewBasicAbility)localObject).getTop();
              }
            }
          }
          localObject = (RelativeLayout)this.e.findViewById(2131428092);
          bool1 = bool2;
          if (paramInt < this.e.getTop() + ((RelativeLayout)localObject).getHeight() / 2) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private int d()
  {
    g();
    Object localObject = MultiMsgManager.a();
    int i = 0;
    while (i < this.c.size())
    {
      ChatMessage localChatMessage = (ChatMessage)this.c.get(i);
      if ((((MultiMsgManager)localObject).a(localChatMessage)) && (MultiMsgUtil.d(localChatMessage))) {
        break label64;
      }
      i += 1;
    }
    i = -1;
    label64:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("First selected index is: ");
    ((StringBuilder)localObject).append(i);
    QLog.d("SelectToBottomHelper", 3, ((StringBuilder)localObject).toString());
    return i;
  }
  
  private int e()
  {
    g();
    Object localObject = MultiMsgManager.a();
    int i = this.c.size() - 1;
    while (i >= 0)
    {
      ChatMessage localChatMessage = (ChatMessage)this.c.get(i);
      if ((((MultiMsgManager)localObject).a(localChatMessage)) && (MultiMsgUtil.d(localChatMessage))) {
        break label65;
      }
      i -= 1;
    }
    i = -1;
    label65:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Last selected index is: ");
    ((StringBuilder)localObject).append(i);
    QLog.d("SelectToBottomHelper", 3, ((StringBuilder)localObject).toString());
    return i;
  }
  
  private boolean f()
  {
    int i = d();
    int j = e();
    int k = c();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (k >= 0)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if (j < 0) {
          return false;
        }
        bool1 = bool2;
        if (k >= i) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void g()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie != null)
    {
      this.b = localBaseChatPie.U;
      this.d = this.a.V;
      if (this.d != null) {
        this.c = this.a.V.a();
      }
    }
  }
  
  protected SelectTouchBarView a(Context paramContext)
  {
    return new SelectTouchBarView(paramContext);
  }
  
  public void a()
  {
    SelectTouchBarView localSelectTouchBarView = this.e;
    if (localSelectTouchBarView != null) {
      localSelectTouchBarView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    SelectTouchBarView localSelectTouchBarView = this.e;
    if (localSelectTouchBarView != null)
    {
      if ((paramInt != 0) && ((localSelectTouchBarView.getMeasuredHeight() == 0) || (f()))) {
        this.e.setVisibility(0);
      } else {
        this.e.setVisibility(8);
      }
      this.e.setCheckedNum(paramInt);
    }
  }
  
  public void a(LinearLayout paramLinearLayout, int paramInt, RelativeLayout paramRelativeLayout)
  {
    if (this.e == null)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        this.e = a(((BaseChatPie)localObject).e);
        localObject = new RelativeLayout.LayoutParams(-1, paramInt);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, paramLinearLayout.getId());
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.e.a(HardCodeUtil.a(2131911222)).a(paramInt).b();
        paramRelativeLayout.addView(this.e);
        this.e.setId(2131428091);
        this.e.setOnClickListener(new SelectToBottomHelper.1(this));
      }
    }
  }
  
  public void b()
  {
    SelectTouchBarView localSelectTouchBarView = this.e;
    if (localSelectTouchBarView != null) {
      localSelectTouchBarView.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
  {
    g();
    if (paramInt == 18)
    {
      int i = c();
      int j = d();
      if (this.e != null)
      {
        if (j < 0) {
          return;
        }
        paramInt = i;
        if (this.f != this.c.size())
        {
          paramInt = i + (this.c.size() - this.f);
          this.f = this.c.size();
        }
        if (paramInt < j)
        {
          this.e.setVisibility(8);
          return;
        }
        this.e.setVisibility(0);
      }
    }
  }
  
  public String getTag()
  {
    return "SelectToBottomHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 18, 19 };
  }
  
  public void onMoveToState(int paramInt)
  {
    SelectTouchBarView localSelectTouchBarView;
    if (paramInt != 7)
    {
      if (paramInt != 18)
      {
        if (paramInt != 19) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectToBottomHelper", 1, "onConfigurationChanged");
        }
        localSelectTouchBarView = this.e;
        if (localSelectTouchBarView != null)
        {
          localSelectTouchBarView.a();
          if (QLog.isColorLevel()) {
            QLog.d("SelectToBottomHelper", 1, "onConfigurationChanged->updateDotLine");
          }
        }
      }
      else
      {
        b(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("SelectToBottomHelper", 1, "onScrollStateIdle");
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectToBottomHelper", 1, "onResume");
      }
      localSelectTouchBarView = this.e;
      if (localSelectTouchBarView != null)
      {
        localSelectTouchBarView.a();
        if (QLog.isColorLevel()) {
          QLog.d("SelectToBottomHelper", 1, "onResume->updateDotLine");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SelectToBottomHelper
 * JD-Core Version:    0.7.0.1
 */