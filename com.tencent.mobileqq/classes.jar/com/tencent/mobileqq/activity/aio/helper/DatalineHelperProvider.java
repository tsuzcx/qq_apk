package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie;
import com.tencent.mobileqq.filemanager.fileassistant.aio.DatalineMultiForwardHelper;

public class DatalineHelperProvider
  extends FriendHelperProvider
{
  public DatalineHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(DatalineChatPie paramDatalineChatPie)
  {
    a(1, new DatalineMultiForwardHelper(paramDatalineChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((DatalineChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.DatalineHelperProvider
 * JD-Core Version:    0.7.0.1
 */