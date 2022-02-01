package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class TipsHelper
  implements ILifeCycleHelper
{
  private boolean a = true;
  protected final AIOContext c;
  protected QQAppInterface d;
  protected BaseActivity e;
  protected TipsManager f;
  protected BaseSessionInfo g;
  
  public TipsHelper(AIOContext paramAIOContext)
  {
    this.c = paramAIOContext;
    this.d = paramAIOContext.a();
    this.e = paramAIOContext.b();
    this.g = paramAIOContext.O();
  }
  
  protected void a()
  {
    this.f = this.c.c();
    HongbaoKeywordGrayTips localHongbaoKeywordGrayTips = new HongbaoKeywordGrayTips(this.c);
    VipSpecialCareGrayTips localVipSpecialCareGrayTips = new VipSpecialCareGrayTips(this.d, this.f, this.e, this.g);
    ComicTipsBar localComicTipsBar = new ComicTipsBar(this.d, this.f, this.e);
    this.f.b(localComicTipsBar);
    this.f.b(localHongbaoKeywordGrayTips);
    this.f.b(localVipSpecialCareGrayTips);
  }
  
  @NonNull
  public String getTag()
  {
    return "TipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 10)
    {
      if (this.a)
      {
        a();
        this.a = false;
      }
    }
    else if (paramInt == 15) {
      this.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TipsHelper
 * JD-Core Version:    0.7.0.1
 */