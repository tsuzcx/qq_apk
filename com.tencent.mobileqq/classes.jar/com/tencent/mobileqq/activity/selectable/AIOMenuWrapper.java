package com.tencent.mobileqq.activity.selectable;

import android.view.View;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class AIOMenuWrapper
  extends CommonMenuWrapper
{
  protected final BaseChatPie a;
  private int[] e;
  
  public AIOMenuWrapper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a()
  {
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeBaseChatPieIsGuildChatPie(this.a))
    {
      if (this.b != null)
      {
        this.b.a(2131431492, HardCodeUtil.a(2131900427), 2130839057);
        this.b.a(2131445511, HardCodeUtil.a(2131900425), 2130839077);
      }
    }
    else {
      super.a();
    }
  }
  
  void a(QQCustomMenu paramQQCustomMenu, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramQQCustomMenu != null) && (paramQQCustomMenu.b() > 0))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((BaseChatPie)localObject).bb() < 8)
        {
          if ((this.e == null) && (this.a.X != null))
          {
            this.e = new int[2];
            this.a.X.getLocationInWindow(this.e);
          }
          localObject = this.e;
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = Integer.valueOf(localObject[1]);
          }
          a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, false, (Integer)localObject);
        }
      }
      else {
        a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.AIOMenuWrapper
 * JD-Core Version:    0.7.0.1
 */