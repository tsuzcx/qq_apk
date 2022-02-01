package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Observable;
import org.jetbrains.annotations.NotNull;

public class UnreadBackBottomHelper
  extends Observable
  implements View.OnClickListener, ILifeCycleHelper
{
  private boolean a = false;
  private final BaseChatPie b;
  private final AIOContext c;
  private ChatXListView d;
  private int e;
  private int f;
  private View g;
  private TextView h;
  private int i;
  private int j;
  private boolean k;
  private boolean l = true;
  
  public UnreadBackBottomHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    this.d = paramBaseChatPie.U;
    this.c = paramBaseChatPie.bv();
    this.c.d().a(this);
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    if (paramSessionInfo != null)
    {
      int m = paramSessionInfo.a;
      if ((m != 0) && (m != 1000) && (m != 1003) && (m != 1006) && (m != 10008) && (m != 10013) && (m != 1022) && (m != 1023)) {
        return false;
      }
      bool = true;
    }
    return bool;
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    boolean bool1 = false;
    if (paramBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "chatPie is null");
      }
      return false;
    }
    SessionInfo localSessionInfo = paramBaseChatPie.ah;
    if (localSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "sessionInfo is null");
      }
      return false;
    }
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if ((paramBaseChatPie instanceof FriendChatPie))
    {
      boolean bool3 = Utils.c(localSessionInfo.b);
      boolean bool4 = RobotUtils.a(paramBaseChatPie.d, localSessionInfo.b);
      bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!bool4) {
          bool2 = true;
        }
      }
    }
    if ((paramBaseChatPie instanceof StrangerChatPie)) {
      bool1 = a(paramBaseChatPie.ah);
    } else {
      bool1 = bool2;
    }
    if ((paramBaseChatPie instanceof NearbyChatPie)) {
      bool1 = true;
    }
    bool2 = bool1;
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeBaseChatPieIsGuildChatPie(paramBaseChatPie))
    {
      bool2 = bool1;
      if (!((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeGuildChatContextIsHomePageChannel(this.c)) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private void e()
  {
    if (!this.a) {
      return;
    }
    BaseChatPie localBaseChatPie = this.b;
    if ((localBaseChatPie != null) && (this.h == null)) {
      localBaseChatPie.al();
    }
    this.l = false;
    notifyObservers();
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "onScrollOutScreen");
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.a) {
      return;
    }
    if ((this.d == null) && (this.b.U == null)) {
      return;
    }
    this.d = this.b.U;
    Object localObject = this.d.getChildAt(0);
    if (localObject != null)
    {
      this.g = ((View)localObject);
      this.f = ((View)localObject).getTop();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("firstView != null. top: ");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("UnreadBackBottomHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((this.h != null) && (this.e == 0))
    {
      if (a()) {
        this.h.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "unread count is 0, core button gone");
      }
    }
    this.l = true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (this.a)
    {
      if (this.b == null) {
        return;
      }
      paramInt4 = 0;
      boolean bool;
      if (paramInt1 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.k = bool;
      if ((this.d == null) && (this.b.U == null)) {
        return;
      }
      this.d = this.b.U;
      if (paramInt7 <= 0)
      {
        if ((this.h != null) && (this.e == 0))
        {
          localView = this.g;
          if ((localView != null) && (this.f - localView.getTop() < this.d.getHeight()))
          {
            if (a()) {
              this.h.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
              QLog.d("UnreadBackBottomHelper", 2, "scroll to bottom, button gone");
            }
          }
        }
        this.i = paramInt1;
        this.j = (paramInt3 - paramInt5 - paramInt1);
        localView = this.d.getChildAt(0);
        if (localView != null) {
          this.g = localView;
        }
      }
      if (paramInt1 + paramInt2 < paramInt3 - paramInt5 - this.j) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      View localView = this.g;
      paramInt2 = paramInt4;
      if (localView != null)
      {
        paramInt2 = paramInt4;
        if (localView.getTop() > this.f + this.d.getHeight()) {
          paramInt2 = 1;
        }
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.l = true;
        return;
      }
      e();
    }
  }
  
  public void a(View paramView)
  {
    paramView = this.b;
    if (paramView != null)
    {
      paramView = paramView.ah;
      if (paramView != null)
      {
        int m = d(paramView.a);
        if (m != -1) {
          a("0X800AC89", m);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "core button on click");
    }
  }
  
  public void a(TextView paramTextView)
  {
    if (!this.a) {
      return;
    }
    if ((paramTextView == null) && (QLog.isColorLevel())) {
      QLog.e("UnreadBackBottomHelper", 1, "button is null");
    }
    this.h = paramTextView;
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "attachButton success");
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!this.a)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("switch is off. reportType: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", aioType: ");
        localStringBuilder.append(paramInt);
        QLog.d("UnreadBackBottomHelper", 2, localStringBuilder.toString());
      }
      return;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state changed from: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" to: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("UnreadBackBottomHelper", 2, localStringBuilder.toString());
    }
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    Object localObject = this.c.e().b();
    if ((localObject instanceof TroopListUI))
    {
      localObject = ((TroopListUI)localObject).y();
      if ((localObject != null) && (((JumpStateMachineController)localObject).a() == JumpState.JUMP_SUCCESS)) {
        return false;
      }
    }
    else if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeListUiIsGuildListUI(localObject))
    {
      localObject = (JumpStateMachineController)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildListUIJumpStateController(localObject);
      if ((localObject != null) && (((JumpStateMachineController)localObject).a() == JumpState.JUMP_SUCCESS)) {
        return false;
      }
    }
    return true;
  }
  
  public void b()
  {
    TextView localTextView = this.h;
    if (localTextView != null)
    {
      localTextView.setBackgroundResource(2130838379);
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "resume button to unread mode");
      }
      if (AppSetting.e)
      {
        localTextView = this.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131886598));
        localStringBuilder.append(this.e);
        localStringBuilder.append(HardCodeUtil.a(2131886599));
        localTextView.setContentDescription(localStringBuilder.toString());
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.a) {
      return;
    }
    if (paramInt < 0) {
      return;
    }
    this.e = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update unread count: ");
      localStringBuilder.append(paramInt);
      QLog.d("UnreadBackBottomHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void c(int paramInt)
  {
    if (!this.a) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("delta: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("UnreadBackBottomHelper", 2, ((StringBuilder)localObject1).toString());
    }
    if (Math.abs(paramInt) < 20) {
      return;
    }
    if (paramInt > 0)
    {
      localObject1 = this.h;
      if ((localObject1 != null) && (this.e == 0)) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    else if ((this.h != null) && (this.e == 0) && (!this.l) && (!this.k))
    {
      localObject1 = this.b;
      Object localObject2;
      if (localObject1 != null)
      {
        AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)((BaseChatPie)localObject1).q(15);
        localObject2 = (AIOShortcutBarHelper)this.b.q(52);
        localObject1 = localObject2;
        if (localAIOLongShotHelper != null)
        {
          localObject1 = localObject2;
          if (localAIOLongShotHelper.c())
          {
            paramInt = 1;
            localObject1 = localObject2;
            break label172;
          }
        }
      }
      else
      {
        localObject1 = null;
      }
      paramInt = 0;
      label172:
      if ((this.h.getVisibility() == 8) && (paramInt == 0))
      {
        this.h.setText("");
        this.h.setBackgroundResource(2130837951);
        this.h.setVisibility(0);
        if (AppSetting.e) {
          this.h.setContentDescription(HardCodeUtil.a(2131886598));
        }
        localObject2 = this.b;
        if (localObject2 != null)
        {
          localObject2 = ((BaseChatPie)localObject2).ah;
          if (localObject2 != null)
          {
            paramInt = d(((SessionInfo)localObject2).a);
            if (paramInt != -1) {
              a("0X800AC88", paramInt);
            }
          }
        }
        if (localObject1 != null) {
          ((AIOShortcutBarHelper)localObject1).d(9);
        }
      }
    }
  }
  
  public boolean c()
  {
    TextView localTextView = this.h;
    boolean bool = false;
    if (localTextView == null) {
      return false;
    }
    if (localTextView.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public int d(int paramInt)
  {
    int m = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 3;
      }
      m = 2;
    }
    return m;
  }
  
  public void d()
  {
    TextView localTextView = this.h;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  @NotNull
  public String getTag()
  {
    return "UnreadBackBottomHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 3 };
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131438953)
    {
      Object localObject = this.b.d;
      MsgList localMsgList = this.c.e();
      ((IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all")).setActionPlayList(null);
      localObject = this.b.V;
      localMsgList.f().a(((ChatAdapter1)localObject).getCount(), localMsgList.b().c(((ChatAdapter1)localObject).getCount()));
      if (localMsgList.f().b() > 0)
      {
        localMsgList.d().l();
        this.c.e().f().a(131075);
      }
      paramView.setVisibility(8);
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 3) {
      a(a(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.UnreadBackBottomHelper
 * JD-Core Version:    0.7.0.1
 */