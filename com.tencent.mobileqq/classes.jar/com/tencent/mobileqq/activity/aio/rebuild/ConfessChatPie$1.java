package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessObserver;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class ConfessChatPie$1
  extends ConfessObserver
{
  ConfessChatPie$1(ConfessChatPie paramConfessChatPie) {}
  
  private void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.f != null) && (!this.a.f.isFinishing()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramBoolean) {
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        localStringBuilder.append("屏蔽失败，请重试。");
        this.a.a(2, localStringBuilder.toString(), 500);
        return;
      }
      localStringBuilder.append("屏蔽失败，");
      localStringBuilder.append(paramString);
      this.a.a(2, localStringBuilder.toString(), 500);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!ConfessConfig.a(this.a.d)) {
      return;
    }
    if ((paramString.equals(this.a.ah.b)) && (paramInt1 == this.a.ah.v) && (paramInt2 == this.a.ah.a))
    {
      ConfessChatPie.a(this.a);
      if (QLog.isColorLevel())
      {
        String str = this.a.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCheckHolmesTipsView  frdUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" type:");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" topicid:");
        localStringBuilder.append(paramInt1);
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (!ConfessConfig.a(this.a.d)) {
      return;
    }
    if (paramBoolean2) {
      paramLong1 = paramLong2;
    }
    String str = Long.toString(paramLong1);
    if ((str.equals(this.a.ah.b)) && (paramInt1 == this.a.ah.v) && (paramInt2 == this.a.ah.a))
    {
      Object localObject1;
      Object localObject2;
      if (paramBoolean1)
      {
        localObject1 = this.a.d.getProxyManager().j();
        localObject2 = ((ConfessProxy)localObject1).b(this.a.ah.b, this.a.ah.a, this.a.ah.v);
        if (localObject2 != null)
        {
          if (((ConfessConvInfo)localObject2).holmesCurCount == paramInt3) {
            if (((ConfessConvInfo)localObject2).holmesTolCount == paramInt4) {
              break label178;
            }
          }
          ((ConfessProxy)localObject1).a(str, paramInt2, paramInt1, paramInt3, paramInt4);
        }
        label178:
        ConfessChatPie.a(this.a, true);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.a.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGetHolmesProgress ");
        ((StringBuilder)localObject2).append(paramBoolean1);
        ((StringBuilder)localObject2).append(" frdUin:");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" type:");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append(" topicid:");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(" curCount:");
        ((StringBuilder)localObject2).append(paramInt3);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ConfessInfo paramConfessInfo)
  {
    if ((this.a.ah != null) && (Utils.a(paramString1, this.a.ah.b)) && (paramInt1 == this.a.ah.a) && (paramInt2 == this.a.ah.v))
    {
      if (QLog.isColorLevel())
      {
        String str = this.a.c;
        paramInt2 = this.a.ah.v;
        if (paramString2 == null) {
          paramConfessInfo = "";
        } else {
          paramConfessInfo = paramString2;
        }
        QLog.i(str, 2, String.format("onSetShieldFlag suc:%b frdUin:%s uinType:%d topicId:%d hours:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo }));
      }
      this.a.a();
      a(paramBoolean, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.1
 * JD-Core Version:    0.7.0.1
 */