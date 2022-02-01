import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class anfy
  extends bhyn
{
  public anfy(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(bhyo parambhyo)
  {
    if (parambhyo == null) {
      return;
    }
    try
    {
      ??? = parambhyo.a().getString("path");
      String str = parambhyo.a().getString("url");
      parambhyo = this.a.a((String)???);
      str = MD5Utils.toMD5(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambhyo);
        return;
      }
      return;
    }
    catch (Exception parambhyo)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambhyo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfy
 * JD-Core Version:    0.7.0.1
 */