import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView;
import java.util.List;

public class awxk
  extends Handler
{
  public awxk(NearbyCardVoteView paramNearbyCardVoteView) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int j;
    if (paramMessage.what == NearbyCardVoteView.c)
    {
      j = paramMessage.arg1;
      if (paramMessage.arg2 > 0)
      {
        i = 2;
        this.a.a(j, i);
      }
    }
    while (paramMessage.what != NearbyCardVoteView.d) {
      for (;;)
      {
        return;
        i = 0;
      }
    }
    int m = paramMessage.arg1;
    int n = paramMessage.arg2;
    Object localObject = (List)paramMessage.obj;
    paramMessage = (Message)localObject;
    if (localObject != null)
    {
      paramMessage = (Message)localObject;
      if (n < ((List)localObject).size()) {
        paramMessage = ((List)localObject).subList(0, n);
      }
    }
    paramMessage = ayol.a(paramMessage);
    int i = 0;
    int k;
    if ((i < n) && (i < 20))
    {
      if ((paramMessage == null) || (i >= paramMessage.size())) {
        break label267;
      }
      k = (int)((TPraiseInfo)paramMessage.get(i)).uCustomId;
      j = ((TPraiseInfo)paramMessage.get(i)).iIsPayed;
    }
    for (;;)
    {
      localObject = this.a.a.obtainMessage(NearbyCardVoteView.c, k, j);
      this.a.a.sendMessageDelayed((Message)localObject, (i + 2) * 500);
      i += 1;
      break;
      paramMessage = this.a.getContext().getSharedPreferences("nearby_card_reddot_num", 0).edit();
      paramMessage.putInt("voteNum", m);
      paramMessage.putInt("increaseNum", n);
      paramMessage.commit();
      return;
      label267:
      j = 0;
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxk
 * JD-Core Version:    0.7.0.1
 */