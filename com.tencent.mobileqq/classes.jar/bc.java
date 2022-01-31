import android.content.res.Resources;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SelectLimitListener;
import com.tencent.mobileqq.widget.QQToast;

public class bc
  implements PhotoListPanel.SelectLimitListener
{
  public bc(LiteActivity paramLiteActivity) {}
  
  public boolean a(int paramInt)
  {
    String str = String.format(this.a.getResources().getString(2131432986), new Object[] { Integer.valueOf(paramInt) });
    QQToast.a(this.a, str, 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bc
 * JD-Core Version:    0.7.0.1
 */