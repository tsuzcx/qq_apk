import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

class amne
  implements amnf
{
  amne(amnd paramamnd) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((amnd.a(this.a) != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPushManager", 2, "[onActionPush], aioType:" + paramInt + ";pushData:" + paramApolloActionPush.toString());
      }
      if ((amnd.a(this.a).curType == paramInt) && (paramInt == amnd.a(this.a).curType) && (!TextUtils.isEmpty(amnd.a(this.a).curFriendUin)) && (amnd.a(this.a).curFriendUin.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.a.a(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amne
 * JD-Core Version:    0.7.0.1
 */