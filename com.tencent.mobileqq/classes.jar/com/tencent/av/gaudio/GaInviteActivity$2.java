package com.tencent.av.gaudio;

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
    if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong)) {
      this.a.f();
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.c.equals(paramString))) {
      this.a.finish();
    }
  }
  
  protected void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.GAudioFriends)paramArrayList.next()).jdField_a_of_type_Long).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
        this.a.finish();
      }
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.a("onServiceConnected");
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_b_of_type_JavaLangString);
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
      localStringBuilder.append(this.a.jdField_b_of_type_Long);
      localStringBuilder.append(", mGroupId:");
      localStringBuilder.append(this.a.jdField_a_of_type_Long);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.finish();
    }
  }
  
  protected void d(long paramLong)
  {
    if (this.a.jdField_a_of_type_Long != paramLong) {
      this.a.a(-1035L);
    }
    this.a.finish();
  }
  
  protected void e(long paramLong)
  {
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity.2
 * JD-Core Version:    0.7.0.1
 */