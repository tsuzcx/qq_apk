package com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import ofa;
import ofb;

public class EditVideoSyncStoryGuide
  extends EditVideoPart
{
  public EditVideoSyncStoryGuide(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    e();
  }
  
  protected void e()
  {
    Object localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 230);
    ((QQCustomDialog)localObject).setTitle("分享到日迹");
    ((QQCustomDialog)localObject).setMessage("分享后，好友即可在日迹中查看该视频，并保存到\"我的日迹\"");
    ((QQCustomDialog)localObject).setNegativeButton("我知道了", new ofa(this, (QQCustomDialog)localObject));
    ((QQCustomDialog)localObject).setOnDismissListener(new ofb(this));
    ((QQCustomDialog)localObject).show();
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a != null)
    {
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a.getInt("curType", 1);
      if (i != 1) {
        break label123;
      }
    }
    label123:
    for (localObject = "1";; localObject = "2")
    {
      StoryReportor.a("aio_shoot", "exp_tip", 0, 0, new String[] { localObject });
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSyncStoryGuide
 * JD-Core Version:    0.7.0.1
 */