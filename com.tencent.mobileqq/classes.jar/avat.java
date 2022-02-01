import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class avat
  implements aoog
{
  avat(avar paramavar) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (avar.a(this.a) == null) {}
    while (avar.a(this.a).a()) {
      return;
    }
    paramInt2 = avar.a(this.a).findFirstVisibleItemPosition();
    int i = avar.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)avar.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        avay localavay = (avay)avar.a(this.a).getChildViewHolder(avar.a(this.a).getChildAt(paramInt1));
        if (!(localavay instanceof avax)) {
          break label170;
        }
        ((avax)localavay).a.setImageBitmap(paramBitmap);
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
 * Qualified Name:     avat
 * JD-Core Version:    0.7.0.1
 */