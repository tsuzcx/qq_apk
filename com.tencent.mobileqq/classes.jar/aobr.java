import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aobr
  extends BroadcastReceiver
{
  aobr(aobq paramaobq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivityProxy", 2, "QQMapActivityProxy-onReceive:" + hashCode() + ", action=" + paramContext);
    }
    if (paramContext.equals("com.tencent.mobileqq.addLbsObserver")) {
      if (aobq.a(this.a) != null) {
        aobq.a(this.a).addObserver(aobq.a(this.a));
      }
    }
    do
    {
      do
      {
        int i;
        int j;
        int k;
        int m;
        int n;
        do
        {
          String str;
          int i1;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!paramContext.equals("com.tencent.mobileqq.removeLbsObserver")) {
                    break;
                  }
                } while (aobq.a(this.a) == null);
                aobq.a(this.a).removeObserver(aobq.a(this.a));
                return;
                if (!paramContext.equals("com.tencent.mobileqq.getStreetViewUrl")) {
                  break;
                }
              } while (aobq.a(this.a) == null);
              ((anxi)aobq.a(this.a).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b((int)(paramIntent.getDoubleExtra("latitude", 0.0D) * 1000000.0D), (int)(paramIntent.getDoubleExtra("longitude", 0.0D) * 1000000.0D));
              return;
              if (!paramContext.equals("com.tencent.mobileqq.unregisterReceiver")) {
                break;
              }
              try
              {
                aobq.a(this.a).unregisterReceiver(aobq.a(this.a));
                return;
              }
              catch (Exception paramContext) {}
            } while (!QLog.isColorLevel());
            QLog.w("QQMapActivityProxy", 2, "mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : " + paramContext.toString());
            return;
            if (!paramContext.equals("com.tencent.mobileqq.getLbsShareSearch")) {
              break;
            }
            i = paramIntent.getIntExtra("latitude", 0);
            j = paramIntent.getIntExtra("longitude", 0);
            k = paramIntent.getIntExtra("coordinate", 0);
            paramContext = paramIntent.getStringExtra("keyword");
            str = paramIntent.getStringExtra("category");
            m = paramIntent.getIntExtra("page", 0);
            n = paramIntent.getIntExtra("count", 0);
            i1 = paramIntent.getIntExtra("requireMyLbs", 0);
          } while (aobq.a(this.a) == null);
          ((anxi)aobq.a(this.a).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(i, j, k, paramContext, str, m, n, i1);
          return;
          if (!paramContext.equals("com.tencent.mobileqq.getLbsShareShop")) {
            break;
          }
          i = paramIntent.getIntExtra("latitude", 0);
          j = paramIntent.getIntExtra("longitude", 0);
          k = paramIntent.getIntExtra("coordinate", 0);
          m = paramIntent.getIntExtra("begin", 0);
          n = paramIntent.getIntExtra("count", 0);
        } while (aobq.a(this.a) == null);
        ((anxi)aobq.a(this.a).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(i, j, k, m, n);
        return;
      } while (!paramContext.equals("com.tencent.mobileqq.getShareShopDetail"));
      paramContext = paramIntent.getStringExtra("shop_id");
    } while ((TextUtils.isEmpty(paramContext)) || (aobq.a(this.a) == null));
    paramIntent = new ArrayList();
    paramIntent.add(paramContext);
    ((anxi)aobq.a(this.a).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aobr
 * JD-Core Version:    0.7.0.1
 */