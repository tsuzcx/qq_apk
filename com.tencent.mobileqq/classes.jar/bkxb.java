import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.List;

class bkxb
  implements bmac<List<bkvz>>
{
  bkxb(bkwx parambkwx) {}
  
  public void a(@Nullable List<bkvz> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      bkwx.a(this.a).clear();
      bkwx.a(this.a).addAll(paramList);
      bkwx.a(this.a).notifyDataSetChanged();
      paramList = bkwx.a(this.a).a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      blfg.b("AEGIFStickerListPart", "takeSameId=" + paramList);
      if (!TextUtils.isEmpty(paramList))
      {
        int i = 0;
        while (i < bkwx.a(this.a).size())
        {
          bkvz localbkvz = (bkvz)bkwx.a(this.a).get(i);
          if ((localbkvz != null) && (paramList.equals(localbkvz.a)))
          {
            bkwx.a(this.a, localbkvz);
            bkwx.a(this.a).a(i + 1);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxb
 * JD-Core Version:    0.7.0.1
 */