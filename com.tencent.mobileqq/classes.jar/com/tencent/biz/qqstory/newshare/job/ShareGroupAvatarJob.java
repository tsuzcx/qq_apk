package com.tencent.biz.qqstory.newshare.job;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.shareGroup.icon.RestrictedBitmap;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ShareGroupAvatarJob
  extends Job
{
  protected String a;
  
  public ShareGroupAvatarJob()
  {
    a(false, true);
  }
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((ShareGroupManager)SuperManager.a(7)).a(this.a);
    if (localShareGroupItem == null) {
      return;
    }
    ShareGroupIconManager localShareGroupIconManager = (ShareGroupIconManager)SuperManager.a(24);
    RestrictedBitmap localRestrictedBitmap = localShareGroupIconManager.a(localShareGroupItem.headerUnionIdList);
    if (localRestrictedBitmap == null)
    {
      localShareGroupIconManager.a(localShareGroupItem.headerUnionIdList, new ShareGroupAvatarJob.1(this));
      return;
    }
    a(localRestrictedBitmap);
  }
  
  protected void a(RestrictedBitmap paramRestrictedBitmap)
  {
    a("ShareGroupAvatarJob_sga", paramRestrictedBitmap.a());
    b(true);
  }
  
  protected void a(Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShareGroupAvatarJob", 2, paramError, new Object[0]);
    }
    b(false);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("ShareGroupAvatarJob_sgi"))) {
      this.a = ((String)a("ShareGroupAvatarJob_sgi"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.ShareGroupAvatarJob
 * JD-Core Version:    0.7.0.1
 */