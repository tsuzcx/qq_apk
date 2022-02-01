package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;

public class FMHelper
  implements ILifeCycleHelper
{
  private QQAppInterface a;
  private BaseChatPie b;
  private FMObserver c;
  
  public FMHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    this.a = paramBaseChatPie.d;
  }
  
  public String getTag()
  {
    return "FMHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 1, 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 15) {
          return;
        }
        this.a.getFileManagerNotifyCenter().deleteObserver(this.c);
        return;
      }
      this.a.getFileManagerNotifyCenter().addObserver(this.c);
      return;
    }
    if (this.c == null) {
      this.c = new FMHelper.MyFMObserver(this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FMHelper
 * JD-Core Version:    0.7.0.1
 */