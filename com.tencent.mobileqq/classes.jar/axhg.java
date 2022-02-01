import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;

public class axhg
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public axhg(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (MultiCardRecommendFragment.a(this.a) != null) {
      MultiCardRecommendFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhg
 * JD-Core Version:    0.7.0.1
 */