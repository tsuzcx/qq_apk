package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;

public class TroopKeyWordHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  
  public TroopKeyWordHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public String getTag()
  {
    return "TroopKeywordManager.troop.special_msg.keyword";
  }
  
  public int[] interestedIn()
  {
    return new int[8];
  }
  
  public void onMoveToState(int paramInt)
  {
    String str = this.a.d();
    if (!TextUtils.isEmpty(str)) {
      TroopKeywordManager.a(this.a.a).a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopKeyWordHelper
 * JD-Core Version:    0.7.0.1
 */