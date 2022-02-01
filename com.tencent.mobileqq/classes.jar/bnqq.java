import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.List;

class bnqq
  implements Observer<List<bnpk>>
{
  bnqq(bnqm parambnqm) {}
  
  public void a(@Nullable List<bnpk> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      bnqm.a(this.a).clear();
      bnqm.a(this.a).addAll(paramList);
      bnqm.a(this.a).notifyDataSetChanged();
      paramList = bnqm.a(this.a).a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      bnzb.b("AEGIFStickerListPart", "takeSameId=" + paramList);
      if (!TextUtils.isEmpty(paramList))
      {
        int i = 0;
        while (i < bnqm.a(this.a).size())
        {
          bnpk localbnpk = (bnpk)bnqm.a(this.a).get(i);
          if ((localbnpk != null) && (paramList.equals(localbnpk.a)))
          {
            bnqm.a(this.a, localbnpk);
            bnqm.a(this.a).a(i + 1);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqq
 * JD-Core Version:    0.7.0.1
 */