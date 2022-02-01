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
      Bitmap localBitmap = GameResultFragment.a(this.this$0).getDrawingCache();
      if (localBitmap != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initViewForGameKnowledge save bitmap ");
        ((StringBuilder)localObject).append(localBitmap.getWidth());
        QLog.d("GameResultFragment", 2, ((StringBuilder)localObject).toString());
        int i = ViewUtils.a(300.0F);
        localObject = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        localCanvas.drawARGB(255, 255, 255, 255);
        localCanvas.drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new Rect(0, 0, i, i), null);
        ThreadManager.getSubThreadHandler().post(new GameResultFragment.4.1(this, (Bitmap)localObject));
        return;
      }
      QLog.d("GameResultFragment", 2, "initViewForGameKnowledge no bitmap cache");
      this.this$0.a(5, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.4
 * JD-Core Version:    0.7.0.1
 */