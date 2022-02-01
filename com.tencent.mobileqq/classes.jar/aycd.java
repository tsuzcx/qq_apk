import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class aycd
  implements BusinessObserver
{
  private void g(boolean paramBoolean, int paramInt)
  {
    a(paramBoolean, paramInt);
    if (paramBoolean) {
      e(true, 7);
    }
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 217) {
      return amtj.a(2131701598);
    }
    if ((paramInt == 219) || (paramInt == 216)) {
      return amtj.a(2131701603);
    }
    if (paramInt == 224) {
      return amtj.a(2131701595);
    }
    if (paramInt == 223) {
      return amtj.a(2131701596);
    }
    return amtj.a(2131701599);
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, int paramInt) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, int paramInt) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void d(boolean paramBoolean, int paramInt) {}
  
  protected void e(boolean paramBoolean) {}
  
  protected void e(boolean paramBoolean, int paramInt) {}
  
  protected void f(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int k = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int j = 0;
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      if (paramBoolean)
      {
        if (paramBundle.getBoolean("bind_state"))
        {
          a(true, true);
          return;
        }
        a(true, false);
        return;
      }
      a(false, false);
      return;
    case 35: 
      a(paramBoolean, paramBundle);
      return;
    case 14: 
      paramInt = j;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      a(paramBoolean, paramInt);
      return;
    case 15: 
      paramInt = k;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      b(paramBoolean, paramInt);
      return;
    case 28: 
      paramInt = i;
      if (paramBundle != null)
      {
        paramInt = i;
        if (paramBundle.getBoolean("hasUpdate")) {
          paramInt = 1;
        }
      }
      e(paramBoolean, paramInt);
      return;
    case 16: 
      if (paramBundle != null) {}
      for (paramInt = paramBundle.getInt("k_result");; paramInt = -1)
      {
        f(paramBoolean, paramInt);
        return;
      }
    case 17: 
      e(paramBoolean);
      return;
    case 19: 
      b(paramBoolean, paramBundle);
      return;
    case 20: 
      a(paramBoolean);
      return;
    case 23: 
      f(paramBoolean);
      return;
    case 26: 
      a(paramBoolean, paramBundle.getBoolean("bindOK"), paramBundle.getBoolean("hadBind"), paramBundle.getString("bindUin"));
      return;
    case 27: 
      b(paramBoolean, paramBundle.getBoolean("bind_state", false));
      return;
    case 31: 
      paramInt = m;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      g(paramBoolean, paramInt);
      return;
    case 30: 
      paramInt = n;
      if (paramBoolean) {
        paramInt = paramBundle.getInt("param_update_flag");
      }
      e(paramBoolean, paramInt);
      return;
    case 100: 
      a(paramBundle.getInt("current_percentage"), paramBundle.getInt("expected_percentage"));
      return;
    case 32: 
      c(paramBoolean);
      return;
    case 33: 
      d(paramBoolean);
      return;
    case 34: 
      b(paramBoolean);
      return;
    case 38: 
      paramInt = i1;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      d(paramBoolean, paramInt);
      return;
    }
    paramInt = i2;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("param_fail_reason", 0);
    }
    c(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aycd
 * JD-Core Version:    0.7.0.1
 */