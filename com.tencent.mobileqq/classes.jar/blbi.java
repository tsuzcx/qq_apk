import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.List;

class blbi
  implements bmeo<List<blag>>
{
  blbi(blbe paramblbe) {}
  
  public void a(@Nullable List<blag> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      blbe.a(this.a).clear();
      blbe.a(this.a).addAll(paramList);
      blbe.a(this.a).notifyDataSetChanged();
      paramList = blbe.a(this.a).a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      bljn.b("AEGIFStickerListPart", "takeSameId=" + paramList);
      if (!TextUtils.isEmpty(paramList))
      {
        int i = 0;
        while (i < blbe.a(this.a).size())
        {
          blag localblag = (blag)blbe.a(this.a).get(i);
          if ((localblag != null) && (paramList.equals(localblag.a)))
          {
            blbe.a(this.a, localblag);
            blbe.a(this.a).a(i + 1);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbi
 * JD-Core Version:    0.7.0.1
 */