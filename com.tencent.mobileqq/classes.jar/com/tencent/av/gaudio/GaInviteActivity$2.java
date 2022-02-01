package com.tencent.av.gaudio;

import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class GaInviteActivity$2
  extends GAudioUIObserver
{
  GaInviteActivity$2(GaInviteActivity paramGaInviteActivity) {}
  
  protected void a(long paramLong, int paramInt)
  {
    if ((this.b.b == paramLong) || (0L == paramLong))
    {
      this.b.i();
      this.b.f.d(paramInt);
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((this.b.b == paramLong) && (this.b.B.equals(paramString))) {
      this.b.finish();
    }
  }
  
  protected void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.GAudioFriends)paramArrayList.next()).a).equalsIgnoreCase(this.b.e.getAccount())) {
        this.b.finish();
      }
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.b.u) {
      this.b.a("onServiceConnected");
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.l);
      ((StringBuilder)localObject).append(".troopgroup_vedio.invite");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupId:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", memUin:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",invitedId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mInviterUin:");
      localStringBuilder.append(this.b.c);
      localStringBuilder.append(", mGroupId:");
      localStringBuilder.append(this.b.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramLong2 == this.b.c) && (paramLong1 == this.b.b)) {
      this.b.finish();
    }
  }
  
  protected void d(long paramLong)
  {
    if (this.b.b != paramLong) {
      this.b.a(-1035L);
    }
    this.b.finish();
  }
  
  protected void e(long paramLong)
  {
    if (this.b.b == paramLong) {
      this.b.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity.2
 * JD-Core Version:    0.7.0.1
 */