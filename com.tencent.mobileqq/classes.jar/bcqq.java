import android.graphics.Bitmap;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.4.1;
import com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView;
import com.tencent.qphone.base.util.QLog;

public class bcqq
  implements bcxc
{
  public bcqq(TroopGiftAnimationController.5 param5) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1) && ((this.a.this$0.a instanceof TroopGiftToPersonalSurfaceView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "onLoadingStateChanged: curState = " + paramInt2);
      }
      Bitmap localBitmap = bclo.a(this.a.this$0.a(String.valueOf(this.a.a.receiverUin), null));
      this.a.this$0.a.b(new TroopGiftAnimationController.5.4.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqq
 * JD-Core Version:    0.7.0.1
 */