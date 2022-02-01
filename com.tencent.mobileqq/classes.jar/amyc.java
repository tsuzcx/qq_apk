import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class amyc
  extends bhhe
{
  public amyc(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(bhhf parambhhf)
  {
    if (parambhhf == null) {
      return;
    }
    try
    {
      ??? = parambhhf.a().getString("path");
      String str = parambhhf.a().getString("url");
      parambhhf = this.a.a((String)???);
      str = bita.d(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambhhf);
        return;
      }
      return;
    }
    catch (Exception parambhhf)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambhhf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyc
 * JD-Core Version:    0.7.0.1
 */