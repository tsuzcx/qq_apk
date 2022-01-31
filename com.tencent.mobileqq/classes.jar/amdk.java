import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class amdk
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramInt = paramBundle.getInt("resp_result", 0);
      b(paramBoolean, paramBundle.getString("key_card_id"), paramInt);
      return;
    case 2: 
      b(paramBoolean, paramBundle.getString("key_card_id"));
      return;
    case 3: 
      a(paramBoolean, paramBundle.getString("key_card_id"));
      return;
    case 4: 
      a(paramBoolean);
      return;
    }
    a(paramBoolean, paramBundle.getString("key_card_id"), paramBundle.getInt("key_get_detail_type"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amdk
 * JD-Core Version:    0.7.0.1
 */