import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class anjw
  extends biht
{
  public anjw(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(bihu parambihu)
  {
    if (parambihu == null) {
      return;
    }
    try
    {
      ??? = parambihu.a().getString("path");
      String str = parambihu.a().getString("url");
      parambihu = this.a.a((String)???);
      str = bjtz.d(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambihu);
        return;
      }
      return;
    }
    catch (Exception parambihu)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambihu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjw
 * JD-Core Version:    0.7.0.1
 */