import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.1.1;

public class bfiu
  implements FaceDrawable.OnLoadingStateChangeListener
{
  public bfiu(TroopGiftAnimationController.5 param5) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = TroopUtils.headDrawableToBitamp(this.a.this$0.a(String.valueOf(this.a.a.senderUin), null));
    if ((paramInt1 == 0) && (paramInt2 == 1) && (this.a.this$0.a != null)) {
      this.a.this$0.a.b(new TroopGiftAnimationController.5.1.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfiu
 * JD-Core Version:    0.7.0.1
 */