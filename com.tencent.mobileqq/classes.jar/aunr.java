import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class aunr
{
  public static int a(Context paramContext)
  {
    switch (b(paramContext))
    {
    case 0: 
    default: 
      return -1;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 0;
  }
  
  public static int b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext == null) || (!paramContext.isConnected())) {
      return 0;
    }
    switch (paramContext.getType())
    {
    default: 
      return -1;
    case 1: 
      return 1;
    case 9: 
      return 5;
    }
    switch (paramContext.getSubtype())
    {
    case 16: 
    default: 
      return -1;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
      return 3;
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunr
 * JD-Core Version:    0.7.0.1
 */