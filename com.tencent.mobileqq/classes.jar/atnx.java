import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atnx
  implements FaceDecoder.DecodeTaskCompletionListener
{
  atnx(atnv paramatnv) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (atnv.a(this.a) == null) {}
    while (atnv.a(this.a).isPausing()) {
      return;
    }
    paramInt2 = atnv.a(this.a).findFirstVisibleItemPosition();
    int i = atnv.a(this.a).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)atnv.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        atoc localatoc = (atoc)atnv.a(this.a).getChildViewHolder(atnv.a(this.a).getChildAt(paramInt1));
        if (!(localatoc instanceof atob)) {
          break label170;
        }
        ((atob)localatoc).a.setImageBitmap(paramBitmap);
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
 * Qualified Name:     atnx
 * JD-Core Version:    0.7.0.1
 */