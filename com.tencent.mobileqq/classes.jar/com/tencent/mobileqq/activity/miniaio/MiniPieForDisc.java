package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class MiniPieForDisc
  extends MiniPie
{
  public MiniPieForDisc(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
  }
  
  private void C()
  {
    if (!this.P) {
      return;
    }
    if (this.S != null)
    {
      this.S.setOnClickListener(null);
      if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
      {
        this.S.setVisibility(0);
        this.S.setContentDescription(this.b.getResources().getString(2131896551));
        return;
      }
      this.S.setVisibility(8);
    }
  }
  
  protected void A()
  {
    this.a = "MiniPieForDisc";
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void i()
  {
    super.i();
    C();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieForDisc
 * JD-Core Version:    0.7.0.1
 */