package com.tencent.ilive.audiencepages.room.pagelogic;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudienceMultiRoomActivityLogic
{
  private static AudienceMultiRoomActivityLogic a = new AudienceMultiRoomActivityLogic();
  private List<AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener> b = new ArrayList();
  private AudienceRoomActivity c;
  
  public static AudienceMultiRoomActivityLogic a()
  {
    return a;
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBundleExtra("biz_ext_data") != null) && ("1".equals(paramIntent.getBundleExtra("biz_ext_data").getString("remove_last_room", ""))) && (this.b.size() >= 2))
    {
      paramIntent = this.b;
      ((AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)paramIntent.get(paramIntent.size() - 2)).c();
    }
  }
  
  public void a(AudienceRoomActivity paramAudienceRoomActivity)
  {
    this.c = paramAudienceRoomActivity;
  }
  
  public void a(AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener paramOnMultiRoomOperateListener)
  {
    if (this.b.contains(paramOnMultiRoomOperateListener)) {
      return;
    }
    this.b.add(paramOnMultiRoomOperateListener);
  }
  
  public int b()
  {
    return this.b.size();
  }
  
  public void b(AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener paramOnMultiRoomOperateListener)
  {
    this.b.remove(paramOnMultiRoomOperateListener);
  }
  
  public void c()
  {
    if (this.b.size() >= 1)
    {
      List localList = this.b;
      ((AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)localList.get(localList.size() - 1)).a();
    }
  }
  
  public boolean c(AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener paramOnMultiRoomOperateListener)
  {
    int i = this.b.size();
    boolean bool = false;
    if (i <= 2) {
      return false;
    }
    List localList = this.b;
    if (paramOnMultiRoomOperateListener != (AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)localList.get(localList.size() - 1)) {
      bool = true;
    }
    return bool;
  }
  
  public void d()
  {
    if (this.b.size() >= 1) {
      ((AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)this.b.get(0)).b();
    }
  }
  
  public void e()
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener)((Iterator)localObject).next()).c();
    }
    localObject = this.c;
    if (localObject != null) {
      ((AudienceRoomActivity)localObject).onBackPressed();
    }
  }
  
  public boolean f()
  {
    return this.b.size() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomActivityLogic
 * JD-Core Version:    0.7.0.1
 */