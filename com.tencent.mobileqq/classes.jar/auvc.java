import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class auvc
  implements FaceDecoder.DecodeTaskCompletionListener
{
  auvc(auva paramauva) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (auva.a(this.a) == null) {}
    while (auva.a(this.a).isPausing()) {
      return;
    }
    paramInt2 = auva.a(this.a).findFirstVisibleItemPosition();
    int i = auva.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)auva.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        auvh localauvh = (auvh)auva.a(this.a).getChildViewHolder(auva.a(this.a).getChildAt(paramInt1));
        if (!(localauvh instanceof auvg)) {
          break label170;
        }
        ((auvg)localauvh).a.setImageBitmap(paramBitmap);
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label74;
      break;
      label170:
      QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvc
 * JD-Core Version:    0.7.0.1
 */