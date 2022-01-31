import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class apko
  implements azwh
{
  apko(apkm paramapkm) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (apkm.a(this.a) == null) {}
    while (apkm.a(this.a).a()) {
      return;
    }
    paramInt2 = apkm.a(this.a).findFirstVisibleItemPosition();
    int i = apkm.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)apkm.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        apkt localapkt = (apkt)apkm.a(this.a).getChildViewHolder(apkm.a(this.a).getChildAt(paramInt1));
        if (!(localapkt instanceof apks)) {
          break label170;
        }
        ((apks)localapkt).a.setImageBitmap(paramBitmap);
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
 * Qualified Name:     apko
 * JD-Core Version:    0.7.0.1
 */