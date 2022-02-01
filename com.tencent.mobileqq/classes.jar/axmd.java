import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axmd
  implements AdapterView.OnItemClickListener
{
  public axmd(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ShortVideoCommentsView.a(this.a, (Comments.Comment)paramAdapterView.getAdapter().getItem(paramInt));
    if (ShortVideoCommentsView.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      long l = this.a.a.getLongAccountUin();
      if (ShortVideoCommentsView.a(this.a).c == l)
      {
        this.a.a(anni.a(2131712844));
        ShortVideoCommentsView.a(this.a, null);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("回复 ");
        if (ShortVideoCommentsView.a(this.a).b.length() >= 6)
        {
          localStringBuilder.append(ShortVideoCommentsView.a(this.a).b.substring(0, 5));
          localStringBuilder.append("...");
        }
        for (;;)
        {
          ShortVideoCommentsView.a(this.a).setText("");
          ShortVideoCommentsView.a(this.a).setHint(localStringBuilder);
          if (!ShortVideoCommentsView.f(this.a)) {
            break label222;
          }
          this.a.l();
          break;
          localStringBuilder.append(ShortVideoCommentsView.a(this.a).b);
        }
        label222:
        ShortVideoCommentsView.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmd
 * JD-Core Version:    0.7.0.1
 */