package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SensorHelper;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

class MultiVideoCtrlLayerUI4NewGroupChat$8
  extends GAudioUIObserver
{
  MultiVideoCtrlLayerUI4NewGroupChat$8(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (MultiVideoCtrlLayerUI4NewGroupChat.e(this.b))
    {
      this.b.z();
      if (paramInt == 0)
      {
        this.b.f(0L, null);
        return;
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        String str = this.b.U().getString(2131917882);
        DialogUtil.a(this.b.U(), 230, null, paramArrayOfByte, null, str, new MultiVideoCtrlLayerUI4NewGroupChat.8.2(this), null).show();
      }
    }
    else
    {
      paramArrayOfByte = this.b.U().getResources().getString(2131893448);
      QQToast.makeText(this.b.U(), -1, paramArrayOfByte, 0).show();
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (this.b.V()) {
      return;
    }
    if (paramLong2 != this.b.j)
    {
      localObject1 = this.b.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreateRoomSuc, not right session. [");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(this.b.j);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = this.b.am.k();
    Object localObject2 = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateRoomSuc, GroupID[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append(((SessionInfo)localObject1).f);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    boolean bool = this.b.H;
    int j = 3;
    if (bool) {
      i = 4;
    } else {
      i = 3;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b.am.ap());
    ((StringBuilder)localObject2).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject2).toString());
    int i = j;
    if (this.b.H) {
      i = 4;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b.am.ap());
    ((StringBuilder)localObject2).append("");
    MultiVideoRichActionReportCollection.a(i, ((StringBuilder)localObject2).toString());
    this.b.M();
    this.b.t(paramLong1);
    this.b.aR.c(true);
    this.b.aR.b(true);
    this.b.aR.a();
    ((SessionInfo)localObject1).bv = true;
    this.b.al.a(this.b.j);
    if (((SessionInfo)localObject1).ci == 4)
    {
      localObject1 = (AVActivity)this.b.ak.get();
      if ((localObject1 != null) && (!((AVActivity)localObject1).isFinishing())) {
        ((AVActivity)localObject1).runOnUiThread(new MultiVideoCtrlLayerUI4NewGroupChat.8.1(this, paramLong1));
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramLong2, paramString);
    if (QLog.isColorLevel())
    {
      localObject = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGroupSecurityLimit-->groupid=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" info=");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" strMsg=");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.b.h != 1) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject).putExtra("type", 33);
    ((Intent)localObject).putExtra("relationId", paramLong1);
    ((Intent)localObject).putExtra("uinType", this.b.g);
    ((Intent)localObject).putExtra("info", paramLong2);
    ((Intent)localObject).putExtra("strMsg", paramString);
    ((Intent)localObject).putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat1");
    paramString = (AVActivity)this.b.ak.get();
    if (paramString != null)
    {
      ((Intent)localObject).setPackage(this.b.al.getApplication().getPackageName());
      paramString.sendBroadcast((Intent)localObject);
      MultiVideoCtrlLayerUI4NewGroupChat.b(this.b, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.b.X, 2, "onGroupSecurityLimit-->can not get the activity");
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    this.b.f(0L, 16777215);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    this.b.b(paramLong, paramInt1, paramInt2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (this.b.V()) {
      return;
    }
    Object localObject = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoomSuc, GroupID[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    boolean bool = this.b.H;
    int j = 4;
    int i;
    if (bool) {
      i = 4;
    } else {
      i = 3;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.am.ap());
    ((StringBuilder)localObject).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject).toString());
    if (this.b.H) {
      i = j;
    } else {
      i = 3;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.am.ap());
    ((StringBuilder)localObject).append("");
    MultiVideoRichActionReportCollection.a(i, ((StringBuilder)localObject).toString());
    this.b.M();
    this.b.t(paramLong1);
    this.b.aR.c(true);
    this.b.aR.b(true);
    this.b.aR.a();
    this.b.al.a().postDelayed(new MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable(this.b), 500L);
    MultiVideoCtrlLayerUI4NewGroupChat.b(this.b);
    this.b.f(paramLong1, 16777215);
    this.b.S();
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.b(paramLong1, paramLong2, paramBoolean);
    this.b.am.k().bg = true;
    if (this.b.am.k().o == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.d(this.b);
    }
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.c(paramLong1, paramLong2, paramBoolean);
    this.b.am.k().bg = false;
    if (this.b.am.k().o == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.c(this.b);
    }
    if (this.b.am.k().H) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.8
 * JD-Core Version:    0.7.0.1
 */