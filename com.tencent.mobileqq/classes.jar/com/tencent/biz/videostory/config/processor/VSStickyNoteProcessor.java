package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class VSStickyNoteProcessor
  extends IQConfigProcessor<VSStickyNoteConfBean>
{
  @NonNull
  public VSStickyNoteConfBean a(int paramInt)
  {
    return new VSStickyNoteConfBean();
  }
  
  @Nullable
  public VSStickyNoteConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      VSStickyNoteConfBean localVSStickyNoteConfBean = VSStickyNoteConfBean.a(paramArrayOfQConfItem[0].a);
      a(localVSStickyNoteConfBean);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed ");
      localStringBuilder.append(paramArrayOfQConfItem[0].a);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, localStringBuilder.toString());
      return localVSStickyNoteConfBean;
    }
    return null;
  }
  
  public void a(VSStickyNoteConfBean paramVSStickyNoteConfBean)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramVSStickyNoteConfBean != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramVSStickyNoteConfBean.toString());
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, localStringBuilder.toString());
      VSConfigManager.a().a("sticky_note_publish_entrance_config", paramVSStickyNoteConfBean.a());
    }
  }
  
  public Class<VSStickyNoteConfBean> clazz()
  {
    return VSStickyNoteConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 595;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSStickyNoteProcessor
 * JD-Core Version:    0.7.0.1
 */