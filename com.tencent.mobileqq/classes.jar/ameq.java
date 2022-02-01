import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ameq
  extends bgod
{
  public ameq(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(bgoe parambgoe)
  {
    if (parambgoe == null) {
      return;
    }
    try
    {
      ??? = parambgoe.a().getString("path");
      String str = parambgoe.a().getString("url");
      parambgoe = this.a.a((String)???);
      str = MD5Utils.toMD5(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambgoe);
        return;
      }
      return;
    }
    catch (Exception parambgoe)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambgoe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ameq
 * JD-Core Version:    0.7.0.1
 */