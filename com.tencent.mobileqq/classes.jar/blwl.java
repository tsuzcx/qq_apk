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

public class blwl
  implements Observer<Boolean>
{
  blwl(blwd paramblwd) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean == null) || (!paramBoolean.booleanValue())) {}
    label516:
    for (;;)
    {
      return;
      blwd.c(this.a);
      paramBoolean = blut.a().a(2);
      if (paramBoolean.size() > 0)
      {
        Pair localPair = blwd.a(this.a, paramBoolean);
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
          blwd.b(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).categoryId);
          blwd.a(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).fontId);
          if (blwd.b(this.a))
          {
            if ((i == 0) && (j == 0) && (!blwd.c(this.a))) {
              Toast.makeText(blwd.a(this.a).a(), 2131689674, 1).show();
            }
            blwd.a(this.a, true);
          }
          blwd.b(this.a).clear();
          blwd.b(this.a).addAll(paramBoolean);
          blwd.a(this.a, blwd.b(this.a, paramBoolean));
          blwd.a(this.a).setTabData((String[])blwd.a(this.a).first, (int[])blwd.a(this.a).second);
          blwd.a(this.a).post(new AEGIFStickerListPart.7.1(this, i));
          blwd.a(this.a).clear();
          blwd.a(this.a).addAll(((AEGifCategoryWrapper)blwd.b(this.a).get(i)).materialWrapperList);
          blwd.a(this.a).notifyDataSetChanged();
          blwd.a(this.a).post(new AEGIFStickerListPart.7.2(this, j));
          paramBoolean = (blvd)((AEGifCategoryWrapper)blwd.b(this.a).get(i)).materialWrapperList.get(j);
          if (paramBoolean.b != 1) {
            break label507;
          }
          blwd.a(this.a, null);
        }
        for (;;)
        {
          if ((!TextUtils.isEmpty(blwd.a(this.a))) || (i != 0)) {
            break label516;
          }
          blwd.c(this.a, ((AEGifCategoryWrapper)blwd.b(this.a).get(i)).categoryId);
          if ((blwd.a(this.a) == null) || (!blwd.a(this.a).a())) {
            break;
          }
          bmbg.a().l(blwd.a(this.a));
          bmbc.a().aj();
          return;
          i = ((Integer)localPair.first).intValue();
          break label61;
          label492:
          j = ((Integer)localPair.second).intValue();
          break label76;
          label507:
          blwd.a(this.a, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwl
 * JD-Core Version:    0.7.0.1
 */