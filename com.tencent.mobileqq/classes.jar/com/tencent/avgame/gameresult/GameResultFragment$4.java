package com.tencent.avgame.gameresult;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class GameResultFragment$4
  implements Runnable
{
  GameResultFragment$4(GameResultFragment paramGameResultFragment) {}
  
  public void run()
  {
    if (GameResultFragment.a(this.this$0) != null)
    {
      GameResultFragment.a(this.this$0).setDrawingCacheEnabled(true);
      Bitmap localBitmap1 = GameResultFragment.a(this.this$0).getDrawingCache();
      if (localBitmap1 != null)
      {
        QLog.d("GameResultFragment", 2, "initViewForGameKnowledge save bitmap " + localBitmap1.getWidth());
        int i = ViewUtils.dip2px(300.0F);
        Bitmap localBitmap2 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap2);
        localCanvas.drawARGB(255, 255, 255, 255);
        localCanvas.drawBitmap(localBitmap1, new Rect(0, 0, localBitmap1.getWidth(), localBitmap1.getHeight()), new Rect(0, 0, i, i), null);
        ThreadManager.getSubThreadHandler().post(new GameResultFragment.4.1(this, localBitmap2));
      }
    }
    else
    {
      return;
    }
    QLog.d("GameResultFragment", 2, "initViewForGameKnowledge no bitmap cache");
    this.this$0.a(5, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.4
 * JD-Core Version:    0.7.0.1
 */