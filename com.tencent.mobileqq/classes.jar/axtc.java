import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.1;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.2;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.3;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.4;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.5;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.6;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class axtc
  extends axtl
{
  public axtc(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new DCShortVideo.5(this, paramInt, paramBoolean));
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.3(this, paramAppInterface, paramInt1, paramInt3, paramString, paramInt2, paramLong));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.4(this, paramAppInterface, paramInt1, paramInt2, paramString));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, axtf paramaxtf)
  {
    paramaxtf.f = paramInt1;
    if (paramInt2 == 0) {
      paramaxtf.b = 0;
    }
    for (;;)
    {
      paramAppInterface = (auul)paramAppInterface.getManager(106);
      if (paramAppInterface != null)
      {
        paramaxtf.d = paramAppInterface.a();
        paramaxtf.e = paramAppInterface.b();
      }
      paramaxtf.g = Calendar.getInstance().get(11);
      paramaxtf.h = bdin.a(BaseApplication.getContext());
      return;
      if (paramInt2 == 3000)
      {
        paramaxtf.b = 3000;
      }
      else
      {
        if (paramInt2 == 1)
        {
          if ((paramAppInterface instanceof QQAppInterface)) {
            switch (((QQAppInterface)paramAppInterface).b(paramString))
            {
            default: 
              paramaxtf.b = 1;
            }
          }
          for (;;)
          {
            paramaxtf.c = 0;
            TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(52);
            if (localTroopManager == null) {
              break;
            }
            paramString = localTroopManager.c(paramString);
            if (paramString == null) {
              break;
            }
            paramaxtf.c = paramString.wMemberNum;
            break;
            paramaxtf.b = 1;
            continue;
            paramaxtf.b = 3;
            continue;
            paramaxtf.b = 4;
            continue;
            paramaxtf.b = 2;
            continue;
            paramaxtf.b = 1;
          }
        }
        paramaxtf.b = 9999;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramQQAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.2(this, paramQQAppInterface, paramInt1, paramInt2, paramString, paramInt3));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString3, long paramLong, String paramString4)
  {
    if ((paramQQAppInterface != null) && (paramString1 != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.1(this, paramString1, paramQQAppInterface, paramInt1, paramInt2, paramString2, paramLong, paramString4, paramBoolean1, paramInt3, paramString3, paramBoolean2));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong)
  {
    ThreadManager.getSubThreadHandler().post(new DCShortVideo.6(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt7, paramInt8, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axtc
 * JD-Core Version:    0.7.0.1
 */