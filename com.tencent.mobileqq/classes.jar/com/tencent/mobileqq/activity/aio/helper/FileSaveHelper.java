package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;

public class FileSaveHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  
  public FileSaveHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.a != null)) {
      ((MultiRichMediaSaveManager)this.a.a.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER)).onDestroy();
    }
  }
  
  public String getTag()
  {
    return "FileSaveHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FileSaveHelper
 * JD-Core Version:    0.7.0.1
 */