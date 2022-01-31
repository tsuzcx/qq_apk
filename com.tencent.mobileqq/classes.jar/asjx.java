import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import com.tencent.qphone.base.util.QLog;

public class asjx
  implements View.OnClickListener
{
  public asjx(QQGameStatusView paramQQGameStatusView) {}
  
  public void onClick(View paramView)
  {
    if ((QQGameStatusView.a(this.a) == null) || (QQGameStatusView.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (QQGameStatusView.a(this.a) == 1)
        {
          QQGameStatusView.a(this.a).b(QQGameStatusView.a(this.a));
          return;
        }
        if (QQGameStatusView.a(this.a) == 2)
        {
          QQGameStatusView.a(this.a).a(QQGameStatusView.a(this.a));
          return;
        }
        if (QQGameStatusView.a(this.a) == 3)
        {
          QQGameStatusView.a(this.a).c(QQGameStatusView.a(this.a));
          return;
        }
        if (QQGameStatusView.a(this.a) == 5)
        {
          QQGameStatusView.a(this.a).d(QQGameStatusView.a(this.a));
          return;
        }
      } while (QQGameStatusView.a(this.a) != 6);
      if (!TextUtils.isEmpty(QQGameStatusView.b(this.a)))
      {
        QQGameStatusView.a(this.a).a(QQGameStatusView.a(this.a), QQGameStatusView.b(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQGameStatusView", 1, "downloadFilePath is null,install faile");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjx
 * JD-Core Version:    0.7.0.1
 */