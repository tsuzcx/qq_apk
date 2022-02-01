package com.tencent.ilive.audiencepages.room.pagelogic;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudienceMultiRoomActivityLogic
{
  private static AudienceMultiRoomActivityLogic jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicAudienceMultiRoomActivityLogic = new AudienceMultiRoomActivityLogic();
  private AudienceRoomActivity jdField_a_of_type_ComTencentIliveAudiencepagesRoomAudienceRoomActivity;
  private List<AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static AudienceMultiRoomActivityLogic a()
  {
    return jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicAudienceMultiRoomActivityLogic;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() >= 1)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      ((AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)localList.get(localList.size() - 1)).a();
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBundleExtra("biz_ext_data") != null) && ("1".equals(paramIntent.getBundleExtra("biz_ext_data").getString("remove_last_room", ""))) && (this.jdField_a_of_type_JavaUtilList.size() >= 2))
    {
      paramIntent = this.jdField_a_of_type_JavaUtilList;
      ((AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)paramIntent.get(paramIntent.size() - 2)).c();
    }
  }
  
  public void a(AudienceRoomActivity paramAudienceRoomActivity)
  {
    this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomAudienceRoomActivity = paramAudienceRoomActivity;
  }
  
  public void a(AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener paramOnMultiRoomOperateListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramOnMultiRoomOperateListener)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnMultiRoomOperateListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  public boolean a(AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener paramOnMultiRoomOperateListener)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    boolean bool = false;
    if (i <= 2) {
      return false;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (paramOnMultiRoomOperateListener != (AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)localList.get(localList.size() - 1)) {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() >= 1) {
      ((AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)this.jdField_a_of_type_JavaUtilList.get(0)).b();
    }
  }
  
  public void b(AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener paramOnMultiRoomOperateListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramOnMultiRoomOperateListener);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)((Iterator)localObject).next()).c();
    }
    localObject = this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomAudienceRoomActivity;
    if (localObject != null) {
      ((AudienceRoomActivity)localObject).onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomActivityLogic
 * JD-Core Version:    0.7.0.1
 */