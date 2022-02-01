import android.os.Bundle;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer.GetCoverTask;

public class aunv
  extends CardObserver
{
  public aunv(ZanRankingIpcServer.GetCoverTask paramGetCoverTask) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      String str = this.a.a.getString("uin");
      if (paramObject.uin.equals(str)) {
        ZanRankingIpcServer.GetCoverTask.a(this.a, paramObject, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunv
 * JD-Core Version:    0.7.0.1
 */