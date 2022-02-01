package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.redpoint.CleanRedPointUIComponent;
import com.tencent.mobileqq.troop.redpoint.DrawRedPointUIComponent;
import com.tencent.mobileqq.troop.redpoint.RedPointUIData;
import com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopSettingRedPointHelper
  implements ILifeCycleHelper
{
  private QQAppInterface a;
  private TroopChatPie b;
  private String c = "";
  private String d = "";
  private View e = null;
  private View f = null;
  private List<Integer> g = new ArrayList();
  private List<Integer> h = new ArrayList();
  private DrawRedPointUIComponent i;
  private CleanRedPointUIComponent j;
  private CenterProcessor k;
  
  public TroopSettingRedPointHelper(TroopChatPie paramTroopChatPie)
  {
    this.b = paramTroopChatPie;
    this.a = paramTroopChatPie.d;
  }
  
  private void a()
  {
    if (this.a != null)
    {
      Object localObject = this.b;
      if ((localObject != null) && (((TroopChatPie)localObject).ah != null) && (!TextUtils.isEmpty(this.b.ah.b)) && (this.g != null) && (this.h != null))
      {
        if (this.b.aZ == null) {
          return;
        }
        this.c = this.b.ah.b;
        localObject = ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.c);
        if (localObject != null)
        {
          if (((TroopInfo)localObject).isExited()) {
            return;
          }
          this.k = new CenterProcessor(this.a, this.c);
          this.d = "troop";
          this.e = this.b.aZ.findViewById(2131444532);
          this.f = this.b.aZ.findViewById(2131436194);
          b();
          c();
          localObject = new RedPointUIData();
          ((RedPointUIData)localObject).g = this.a;
          ((RedPointUIData)localObject).a = this.c;
          ((RedPointUIData)localObject).b = this.d;
          ((RedPointUIData)localObject).e = this.g;
          ((RedPointUIData)localObject).f = this.h;
          ((RedPointUIData)localObject).c = this.e;
          ((RedPointUIData)localObject).d = this.f;
          ((RedPointUIData)localObject).h = new TroopSettingRedPointHelper.1(this);
          this.k.b();
          this.i = new DrawRedPointUIComponent((RedPointUIData)localObject);
          this.j = new CleanRedPointUIComponent((RedPointUIData)localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onCreate : mUin = ");
            ((StringBuilder)localObject).append(this.c);
            QLog.d("TroopSettingRedHelper", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  private void b()
  {
    this.g.add(Integer.valueOf(1));
    this.g.add(Integer.valueOf(2));
    this.g.add(Integer.valueOf(3));
    this.g.add(Integer.valueOf(5));
  }
  
  private void c()
  {
    this.h.add(Integer.valueOf(1));
  }
  
  private void d()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      ((CenterProcessor)localObject).a();
      this.k = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((DrawRedPointUIComponent)localObject).a();
      this.i = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((CleanRedPointUIComponent)localObject).a();
      this.j = null;
    }
    localObject = this.g;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.h;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.e = null;
    this.f = null;
  }
  
  public String getTag()
  {
    return "TroopSettingRedHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 15) {
        return;
      }
      d();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopSettingRedPointHelper
 * JD-Core Version:    0.7.0.1
 */