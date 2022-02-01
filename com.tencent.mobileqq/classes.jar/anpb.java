import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class anpb
  implements anpq
{
  public anpb(ApolloPanel paramApolloPanel) {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (ApolloPanel.f(this.a));
      ApolloPanel.d(this.a, true);
      QLog.d("ApolloPanel", 1, "kapu installed, refresh");
      this.a.b(this.a.a.app.getCurrentUin());
      return;
    } while (!ApolloPanel.f(this.a));
    ApolloPanel.d(this.a, false);
    QLog.d("ApolloPanel", 1, "kapu remove, refresh");
    this.a.b(this.a.a.app.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpb
 * JD-Core Version:    0.7.0.1
 */