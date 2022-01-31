import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class asbu
  implements bdbc
{
  asbu(asbs paramasbs) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (asbs.a(this.a) == null) {}
    while (asbs.a(this.a).a()) {
      return;
    }
    paramInt2 = asbs.a(this.a).findFirstVisibleItemPosition();
    int i = asbs.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)asbs.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        asbz localasbz = (asbz)asbs.a(this.a).getChildViewHolder(asbs.a(this.a).getChildAt(paramInt1));
        if (!(localasbz instanceof asby)) {
          break label170;
        }
        ((asby)localasbz).a.setImageBitmap(paramBitmap);
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label74;
      break;
      label170:
      QLog.e("Forward.Preview.Dialog", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbu
 * JD-Core Version:    0.7.0.1
 */