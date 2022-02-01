package com.tencent.av.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.EllipsisUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class MultiVideoCtrlLayerUIBase$11
  extends GAudioUIObserver
{
  MultiVideoCtrlLayerUIBase$11(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  protected void a(long paramLong)
  {
    String str = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroyUI, groupId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], mRelationId[");
    localStringBuilder.append(this.b.j);
    localStringBuilder.append("], mIntentRelationId[");
    localStringBuilder.append(this.b.i);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((this.b.j == paramLong) || (this.b.i == paramLong)) {
      this.b.e(true);
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    this.b.t.a(paramLong, paramInt1, paramInt2, paramBoolean);
    ((AVActivity)this.b.ak.get()).L.b(paramLong, paramBoolean);
    if (paramLong == this.b.k) {
      this.b.s();
    }
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      localObject1 = this.b.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGaOperationResult, result[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], uin[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], info[");
      ((StringBuilder)localObject2).append(paramLong3);
      ((StringBuilder)localObject2).append("], groupId[");
      ((StringBuilder)localObject2).append(paramLong4);
      ((StringBuilder)localObject2).append("], relationType[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], mCameraNum[");
      ((StringBuilder)localObject2).append(this.b.ac);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    switch (paramInt1)
    {
    default: 
    case 97: 
    case 98: 
      if (paramLong3 == 1L)
      {
        localObject1 = this.b;
        ((MultiVideoCtrlLayerUIBase)localObject1).a(((MultiVideoCtrlLayerUIBase)localObject1).k, paramInt1, false, -1, 0);
        return;
      }
      break;
    case 96: 
      if (paramLong3 == 1L)
      {
        this.b.d("onGaOperationResult");
        this.b.a("onGaOperationResult.1", paramLong1);
        localObject1 = this.b;
        ((MultiVideoCtrlLayerUIBase)localObject1).b(paramLong1, ((MultiVideoCtrlLayerUIBase)localObject1).am.k().bi);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.b.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGaOperationResult --> EV_GA_SDK_REQUEST_VIDEO_SUC Failed. Info = ");
        ((StringBuilder)localObject2).append(paramLong3);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return;
      }
      break;
    case 93: 
    case 94: 
    case 95: 
      this.b.f(paramLong1, 16777215);
      return;
    case 91: 
    case 92: 
      this.b.z(paramLong3);
      return;
    case 90: 
      if (paramLong3 == 3L)
      {
        localObject1 = this.b.am.k().bi;
        paramInt1 = 0;
        while (paramInt1 < ((ArrayList)localObject1).size())
        {
          localObject2 = (VideoViewInfo)((ArrayList)localObject1).get(paramInt1);
          if ((paramLong2 == ((VideoViewInfo)localObject2).a) && (((VideoViewInfo)localObject2).b == 1))
          {
            bool = ((VideoViewInfo)localObject2).c;
            break label454;
          }
          paramInt1 += 1;
        }
        bool = false;
        label454:
        this.b.ao.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
        this.b.I(paramLong1);
        this.b.a("onGaOperationResult.2", paramLong1);
      }
      else if (paramLong3 == 2L)
      {
        TipsUtil.a(this.b.al, 1029);
      }
      else if (paramLong3 == 4L)
      {
        if ((paramLong2 == this.b.al.getLongAccountUin()) && (!this.b.am.k().H)) {
          paramInt1 = i;
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 == 0)
        {
          TipsUtil.a(this.b.al, 1031);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject1 = this.b.X;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("VideoConstants.GaChatOperationResult.EV_GA_SDK_GO_ON_STAGE_SUC with repeat message ");
            ((StringBuilder)localObject2).append(MultiVideoCtrlLayerUIBase.a(this.b));
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          if (MultiVideoCtrlLayerUIBase.a(this.b))
          {
            TipsUtil.a(this.b.al, 1031);
            MultiVideoCtrlLayerUIBase.a(this.b, false);
          }
        }
        if (this.b.h == 2) {
          ReportController.b(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
        }
      }
      else if (paramLong3 == 8L)
      {
        if (MultiVideoCtrlLayerUIBase.a(this.b))
        {
          MultiVideoCtrlLayerUIBase.a(this.b, false);
          TipsUtil.a(this.b.al, 1033, this.b.aj.getString(2131893474));
        }
      }
      else if ((paramLong3 == 9L) && (MultiVideoCtrlLayerUIBase.a(this.b)))
      {
        MultiVideoCtrlLayerUIBase.a(this.b, false);
        TipsUtil.a(this.b.al, 1033, this.b.aj.getString(2131893475));
      }
      this.b.f(paramLong1, 16777215);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (paramLong3 == this.b.k)
    {
      if (this.b.am.k().H)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = this.b.X;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onMemberVideoOut, seq[");
          ((StringBuilder)localObject2).append(paramLong1);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        this.b.w(paramLong1);
        if (this.b.am != null) {
          this.b.am.a(this.b.k, this.b.am.k().bi, this.b.am.k().bk, 1, false);
        }
      }
    }
    else
    {
      localObject1 = new VideoViewInfo();
      ((VideoViewInfo)localObject1).a = paramLong3;
      ((VideoViewInfo)localObject1).b = paramInt;
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      this.b.ao.update(null, new Object[] { Integer.valueOf(104), localObject2 });
      if (paramInt == 2)
      {
        this.b.k(1036);
        TipsUtil.b(this.b.al, 1036);
      }
    }
    this.b.H();
    this.b.a(paramLong3, 6, false, 73, 0);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramBoolean);
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMemberLeave, mRelationId[");
      localStringBuilder.append(this.b.j);
      localStringBuilder.append("], groupId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], friendUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], isQQUser[");
      localStringBuilder.append(this.b.G);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.b.j != paramLong1) {
      return;
    }
    this.b.G = paramBoolean;
    super.a(paramLong1, paramLong2, paramBoolean);
    this.b.a(paramLong2, 1, true, 71, 0);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel())
    {
      localObject = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMemberJoin, mRelationId[");
      localStringBuilder.append(this.b.j);
      localStringBuilder.append("], groupId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], isQQUser[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], friendUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], isRefresh[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.b.j != paramLong1) {
      return;
    }
    Object localObject = this.b;
    ((MultiVideoCtrlLayerUIBase)localObject).G = paramBoolean2;
    ((MultiVideoCtrlLayerUIBase)localObject).a(paramLong2, 0, paramBoolean1, 70, 0);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    int i;
    if (paramBoolean1) {
      i = 42;
    } else {
      i = 43;
    }
    this.b.a(paramLong, 2, paramBoolean2, i, paramInt);
  }
  
  protected void a(ArrayList<Long> paramArrayList, int paramInt)
  {
    if (paramInt == 0)
    {
      TipsUtil.b(this.b.al, 1034);
      TipsUtil.b(this.b.al, 1035);
      if (this.b.z != null)
      {
        this.b.al.a().removeCallbacks(this.b.z);
        this.b.z = null;
      }
    }
    else
    {
      if ((paramInt == 1) && (((Long)paramArrayList.get(0)).longValue() == this.b.k))
      {
        TipsUtil.a(this.b.al, 1035, this.b.al.getApp().getString(2131893292), this.b.al.getApp().getString(2131893642), new MultiVideoCtrlLayerUIBase.11.1(this));
        return;
      }
      if (this.b.z == null)
      {
        localObject = this.b;
        ((MultiVideoCtrlLayerUIBase)localObject).z = new MultiVideoCtrlLayerUIBase.RefreshNoiseStateRunnable((MultiVideoCtrlLayerUIBase)localObject);
        localObject = this.b.al.a();
        Runnable localRunnable = this.b.z;
        long l2 = this.b.am.u;
        long l1 = 2000L;
        if (l2 >= 2000L) {
          l1 = this.b.am.u;
        }
        ((Handler)localObject).postDelayed(localRunnable, l1);
      }
      paramArrayList = this.b.am.a(String.valueOf(paramArrayList.get(0)), String.valueOf(this.b.am.k().aN), this.b.h);
      float f = this.b.aj.getDimensionPixelSize(2131297547);
      Object localObject = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject, paramArrayList, this.b.as.getPaint(), f);
      if (paramInt == 1)
      {
        TipsUtil.a(this.b.al, 1035, this.b.al.getApp().getString(2131893293), this.b.al.getApp().getString(2131893643), new MultiVideoCtrlLayerUIBase.11.2(this));
        return;
      }
      ((StringBuilder)localObject).append(this.b.al.getApp().getString(2131893294));
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(this.b.al.getApp().getString(2131893295));
      TipsUtil.a(this.b.al, 1035, ((StringBuilder)localObject).toString(), this.b.al.getApp().getString(2131893644), new MultiVideoCtrlLayerUIBase.11.3(this));
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    int i;
    int j;
    if (paramBoolean1)
    {
      i = 7;
      j = 78;
    }
    else
    {
      this.b.k(1036);
      TipsUtil.b(this.b.al, 1036);
      i = 8;
      j = 79;
    }
    this.b.a(paramLong2, i, false, j, 0);
  }
  
  protected void c(long paramLong, int paramInt)
  {
    long l = AudioHelper.c();
    if (QLog.isDevelopLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstFrameDataComeIn, uin[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], videoSrcType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    paramInt = this.b.am.k().b(paramLong, paramInt);
    if ((paramInt != -1) && (((VideoViewInfo)this.b.am.k().bi.get(paramInt)).c))
    {
      this.b.Y();
      TipsUtil.b(this.b.al, 1036);
      TipsUtil.b(this.b.al, 1037);
    }
    this.b.I(l);
    this.b.e("onFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    super.c(paramLong1, paramLong2);
    this.b.H();
    this.b.a(paramLong2, 5, false, 72, 0);
  }
  
  protected void d()
  {
    if ((this.b.A != null) && (this.b.al != null) && (this.b.al.a() != null)) {
      this.b.al.a().post(this.b.A);
    }
  }
  
  protected void d(long paramLong, int paramInt)
  {
    super.d(paramLong, paramInt);
    if ((paramLong == this.b.al.getLongAccountUin()) || (paramInt != 0) || (paramLong == 0L)) {
      this.b.s();
    }
    if ((!this.b.am.ap) && (paramLong != this.b.k))
    {
      if (paramLong == 0L) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      boolean bool = true;
      if (paramInt == 1)
      {
        String str = this.b.am.a(String.valueOf(paramLong), String.valueOf(this.b.am.k().aN), this.b.h);
        if (str != null)
        {
          localObject = str;
          if (str.length() != 0) {}
        }
        else
        {
          localObject = String.valueOf(paramLong);
        }
        float f = this.b.aj.getDimensionPixelSize(2131297547);
        localStringBuilder.append(this.b.aj.getString(2131893311));
        EllipsisUtil.b(localStringBuilder, (String)localObject, this.b.as.getPaint(), f);
        localStringBuilder.append(this.b.aj.getString(2131893310));
      }
      else if (paramInt == 0)
      {
        localStringBuilder.append(this.b.aj.getString(2131893312));
      }
      TipsUtil.a(this.b.al, 1033, localStringBuilder.toString());
      Object localObject = this.b;
      if (paramInt != 1) {
        bool = false;
      }
      ((MultiVideoCtrlLayerUIBase)localObject).f(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.11
 * JD-Core Version:    0.7.0.1
 */