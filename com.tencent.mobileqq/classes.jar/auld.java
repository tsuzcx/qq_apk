import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class auld
  implements aobv
{
  auld(aulb paramaulb) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (aulb.a(this.a) == null) {}
    while (aulb.a(this.a).a()) {
      return;
    }
    paramInt2 = aulb.a(this.a).findFirstVisibleItemPosition();
    int i = aulb.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)aulb.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        auli localauli = (auli)aulb.a(this.a).getChildViewHolder(aulb.a(this.a).getChildAt(paramInt1));
        if (!(localauli instanceof aulh)) {
          break label170;
        }
        ((aulh)localauli).a.setImageBitmap(paramBitmap);
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
 * Qualified Name:     auld
 * JD-Core Version:    0.7.0.1
 */