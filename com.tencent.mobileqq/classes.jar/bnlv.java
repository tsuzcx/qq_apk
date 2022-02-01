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

public class bnlv
  implements Observer<Boolean>
{
  bnlv(bnln parambnln) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean == null) || (!paramBoolean.booleanValue())) {}
    label516:
    for (;;)
    {
      return;
      bnln.b(this.a);
      paramBoolean = bnjw.a().a(2);
      if (paramBoolean.size() > 0)
      {
        Pair localPair = bnln.a(this.a, paramBoolean);
        int i;
        label61:
        int j;
        if ((localPair == null) || (localPair.first == null))
        {
          i = 0;
          if ((localPair != null) && (localPair.second != null)) {
            break label492;
          }
          j = 0;
          label76:
          bnln.b(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).categoryId);
          bnln.a(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).fontId);
          if (bnln.b(this.a))
          {
            if ((i == 0) && (j == 0) && (!bnln.c(this.a))) {
              Toast.makeText(bnln.a(this.a).a(), 2131689682, 1).show();
            }
            bnln.a(this.a, true);
          }
          bnln.b(this.a).clear();
          bnln.b(this.a).addAll(paramBoolean);
          bnln.a(this.a, bnln.b(this.a, paramBoolean));
          bnln.a(this.a).setTabData((String[])bnln.a(this.a).first, (int[])bnln.a(this.a).second);
          bnln.a(this.a).post(new AEGIFStickerListPart.7.1(this, i));
          bnln.a(this.a).clear();
          bnln.a(this.a).addAll(((AEGifCategoryWrapper)bnln.b(this.a).get(i)).materialWrapperList);
          bnln.a(this.a).notifyDataSetChanged();
          bnln.a(this.a).post(new AEGIFStickerListPart.7.2(this, j));
          paramBoolean = (bnkg)((AEGifCategoryWrapper)bnln.b(this.a).get(i)).materialWrapperList.get(j);
          if (paramBoolean.b != 1) {
            break label507;
          }
          bnln.a(this.a, null);
        }
        for (;;)
        {
          if ((!TextUtils.isEmpty(bnln.a(this.a))) || (i != 0)) {
            break label516;
          }
          bnln.c(this.a, ((AEGifCategoryWrapper)bnln.b(this.a).get(i)).categoryId);
          if ((bnln.a(this.a) == null) || (!bnln.a(this.a).a())) {
            break;
          }
          bnqq.a().l(bnln.a(this.a));
          bnqm.a().aj();
          return;
          i = ((Integer)localPair.first).intValue();
          break label61;
          label492:
          j = ((Integer)localPair.second).intValue();
          break label76;
          label507:
          bnln.a(this.a, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlv
 * JD-Core Version:    0.7.0.1
 */