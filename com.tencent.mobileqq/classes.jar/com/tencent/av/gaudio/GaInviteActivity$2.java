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
  
  public void a(long paramLong, int paramInt)
  {
    if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong)) {
      this.a.f();
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.c.equals(paramString))) {
      this.a.finish();
    }
  }
  
  public void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.GAudioFriends)paramArrayList.next()).jdField_a_of_type_Long).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
        this.a.finish();
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.a("onServiceConnected");
    }
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString + ".troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_b_of_type_Long + ", mGroupId:" + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.finish();
    }
  }
  
  public void d(long paramLong)
  {
    if (this.a.jdField_a_of_type_Long != paramLong) {
      this.a.a(-1035L);
    }
    this.a.finish();
  }
  
  public void e(long paramLong)
  {
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity.2
 * JD-Core Version:    0.7.0.1
 */