import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class apnd
  implements azwh
{
  apnd(apnb paramapnb) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (apnb.a(this.a) == null) {}
    while (apnb.a(this.a).a()) {
      return;
    }
    paramInt2 = apnb.a(this.a).findFirstVisibleItemPosition();
    int i = apnb.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)apnb.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        apni localapni = (apni)apnb.a(this.a).getChildViewHolder(apnb.a(this.a).getChildAt(paramInt1));
        if (!(localapni instanceof apnh)) {
          break label170;
        }
        ((apnh)localapni).a.setImageBitmap(paramBitmap);
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
 * Qualified Name:     apnd
 * JD-Core Version:    0.7.0.1
 */