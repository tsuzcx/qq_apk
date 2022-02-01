import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class auiu
  implements aobv
{
  auiu(auis paramauis) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (auis.a(this.a) == null) {}
    while (auis.a(this.a).a()) {
      return;
    }
    paramInt2 = auis.a(this.a).findFirstVisibleItemPosition();
    int i = auis.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)auis.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        auiz localauiz = (auiz)auis.a(this.a).getChildViewHolder(auis.a(this.a).getChildAt(paramInt1));
        if (!(localauiz instanceof auiy)) {
          break label170;
        }
        ((auiy)localauiz).a.setImageBitmap(paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiu
 * JD-Core Version:    0.7.0.1
 */