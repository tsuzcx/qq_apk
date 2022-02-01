package com.tencent.mobileqq.apollo.game.process.download;

import com.tencent.mobileqq.apollo.game.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class CmGameSubRscHandler$2
  implements Runnable
{
  CmGameSubRscHandler$2(CmGameSubRscHandler paramCmGameSubRscHandler, long paramLong, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener) {}
  
  public void run()
  {
    DialogUtil.a(CmGameSubRscHandler.a(this.this$0), 0, null, String.format(HardCodeUtil.a(2131900316), new Object[] { Float.valueOf((float)this.a * 1.0F / 1024.0F / 1024.0F) }), 2131887648, 2131892267, new CmGameSubRscHandler.2.1(this), new CmGameSubRscHandler.2.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.download.CmGameSubRscHandler.2
 * JD-Core Version:    0.7.0.1
 */