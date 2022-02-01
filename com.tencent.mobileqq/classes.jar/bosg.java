import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import dov.com.qq.im.ae.gif.AEGIFStickerListPart.7.1;
import dov.com.qq.im.ae.gif.AEGIFStickerListPart.7.2;
import java.util.List;

public class bosg
  implements Observer<Boolean>
{
  bosg(bory parambory) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean == null) || (!paramBoolean.booleanValue())) {}
    label61:
    label76:
    label486:
    label501:
    label510:
    for (;;)
    {
      return;
      bory.c(this.a);
      paramBoolean = boqm.a().a(2);
      if (paramBoolean.size() > 0)
      {
        Pair localPair = bory.a(this.a, paramBoolean);
        int i;
        int j;
        if ((localPair == null) || (localPair.first == null))
        {
          i = 0;
          if ((localPair != null) && (localPair.second != null)) {
            break label486;
          }
          j = 0;
          bory.a(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).categoryId);
          bory.a(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).fontId);
          if (bory.a(this.a))
          {
            if ((i == 0) && (j == 0) && (!bory.b(this.a))) {
              Toast.makeText(bory.a(this.a).a(), 2131689675, 1).show();
            }
            bory.a(this.a, true);
          }
          bory.b(this.a).clear();
          bory.b(this.a).addAll(paramBoolean);
          bory.a(this.a, bory.b(this.a, paramBoolean));
          bory.a(this.a).setTabData((String[])bory.a(this.a).first, (int[])bory.a(this.a).second);
          bory.a(this.a).post(new AEGIFStickerListPart.7.1(this, i));
          bory.a(this.a).clear();
          bory.a(this.a).addAll(((AEGifCategoryWrapper)bory.b(this.a).get(i)).materialWrapperList);
          bory.a(this.a).notifyDataSetChanged();
          bory.a(this.a).post(new AEGIFStickerListPart.7.2(this, j));
          paramBoolean = (boqw)((AEGifCategoryWrapper)bory.b(this.a).get(i)).materialWrapperList.get(j);
          if (paramBoolean.b != 1) {
            break label501;
          }
          bory.a(this.a, null);
        }
        for (;;)
        {
          if ((!TextUtils.isEmpty(bory.a(this.a))) || (i != 0)) {
            break label510;
          }
          bory.b(this.a, ((AEGifCategoryWrapper)bory.b(this.a).get(i)).categoryId);
          if ((bory.a(this.a) == null) || (!bory.a(this.a).a())) {
            break;
          }
          bozr.a().h(bory.a(this.a));
          return;
          i = ((Integer)localPair.first).intValue();
          break label61;
          j = ((Integer)localPair.second).intValue();
          break label76;
          bory.a(this.a, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosg
 * JD-Core Version:    0.7.0.1
 */