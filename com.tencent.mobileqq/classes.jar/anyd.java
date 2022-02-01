import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class anyd
  extends anvi
{
  anyd(anyb paramanyb) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "onAddFriend " + paramString);
    }
    paramString = anyb.a(this.a).obtainMessage(8, 0, 0, paramString);
    anyb.a(this.a).sendMessage(paramString);
  }
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_success", paramBoolean);
    localBundle.putString("key_req_uin", paramString);
    paramString = anyb.a(this.a).obtainMessage(9, 0, 0, localBundle);
    anyb.a(this.a).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyd
 * JD-Core Version:    0.7.0.1
 */