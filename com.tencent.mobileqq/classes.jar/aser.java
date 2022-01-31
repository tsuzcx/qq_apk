import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aser
  implements bdbc
{
  aser(asep paramasep) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (asep.a(this.a) == null) {}
    while (asep.a(this.a).a()) {
      return;
    }
    paramInt2 = asep.a(this.a).findFirstVisibleItemPosition();
    int i = asep.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)asep.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        asew localasew = (asew)asep.a(this.a).getChildViewHolder(asep.a(this.a).getChildAt(paramInt1));
        if (!(localasew instanceof asev)) {
          break label170;
        }
        ((asev)localasew).a.setImageBitmap(paramBitmap);
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
 * Qualified Name:     aser
 * JD-Core Version:    0.7.0.1
 */