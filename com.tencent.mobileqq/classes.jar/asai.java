import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class asai
  implements bcwt
{
  asai(asag paramasag) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (asag.a(this.a) == null) {}
    while (asag.a(this.a).a()) {
      return;
    }
    paramInt2 = asag.a(this.a).findFirstVisibleItemPosition();
    int i = asag.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)asag.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        asan localasan = (asan)asag.a(this.a).getChildViewHolder(asag.a(this.a).getChildAt(paramInt1));
        if (!(localasan instanceof asam)) {
          break label170;
        }
        ((asam)localasan).a.setImageBitmap(paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asai
 * JD-Core Version:    0.7.0.1
 */