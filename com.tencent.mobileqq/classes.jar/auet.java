import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class auet
  extends anam
{
  private WeakReference<Context> a;
  
  public auet(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    int k = -1;
    Context localContext = (Context)this.a.get();
    if (localContext == null)
    {
      QLog.e("HiBoomFont.HiBoomManager", 1, "onAuthHiBoom: context == null");
      return;
    }
    Object localObject = auen.a(localContext);
    if ((localObject != null) && (((bhht)localObject).isShowing())) {
      ((bhht)localObject).dismiss();
    }
    label124:
    int j;
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length >= 5)
      {
        int i;
        if ((arrayOfObject[0] instanceof Integer))
        {
          i = ((Integer)arrayOfObject[0]).intValue();
          if (!(arrayOfObject[1] instanceof byte[])) {
            break label217;
          }
          localObject = (byte[])arrayOfObject[1];
          if (!(arrayOfObject[2] instanceof Integer)) {
            break label223;
          }
          j = ((Integer)arrayOfObject[2]).intValue();
          label146:
          if (!(arrayOfObject[3] instanceof String)) {
            break label229;
          }
        }
        label217:
        label223:
        label229:
        for (paramObject = (String)arrayOfObject[3];; paramObject = null)
        {
          if ((arrayOfObject[4] instanceof Integer)) {
            k = ((Integer)arrayOfObject[4]).intValue();
          }
          if (i == 0) {
            break label234;
          }
          if (localObject == null) {
            break label260;
          }
          auen.a(localContext, (byte[])localObject, j);
          auen.b.set(false);
          return;
          i = -1;
          break;
          localObject = null;
          break label124;
          j = -1;
          break label146;
        }
      }
    }
    switch (k)
    {
    default: 
      QQToast.a(localContext, 1, amtj.a(2131704603), 0).a();
      auen.b.set(false);
      return;
    case 1: 
      label234:
      localObject = new Bundle();
      label260:
      ((Bundle)localObject).putInt("forward_type", 37);
      ((Bundle)localObject).putInt("emoInputType", 5);
      ((Bundle)localObject).putString("forward_text", paramObject);
      ((Bundle)localObject).putInt("key_hiboom_id", j);
      ((Bundle)localObject).putInt("key_hiboom_type", auen.a(j));
      paramObject = new Intent();
      paramObject.putExtras((Bundle)localObject);
      atky.a((Activity)localContext, paramObject, 21);
      return;
    }
    if ((localContext instanceof FragmentActivity))
    {
      localObject = (FragmentActivity)localContext;
      if ((((FragmentActivity)localObject).getChatFragment() != null) && (((FragmentActivity)localObject).getChatFragment().a() != null))
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a();
        ((auen)((BaseChatPie)localObject).app.getManager(219)).a((BaseChatPie)localObject, paramObject, j, auen.a(j));
        ((BaseChatPie)localObject).showInputPanel();
        ((BaseChatPie)localObject).input.setText("");
      }
    }
    auen.b.set(false);
  }
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    int j = -1;
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      QLog.e("HiBoomFont.HiBoomManager", 1, "onAuthHiBoom: context == null");
    }
    for (;;)
    {
      return;
      Object localObject = auen.a(localContext);
      if ((localObject != null) && (((bhht)localObject).isShowing())) {
        ((bhht)localObject).dismiss();
      }
      if (paramBoolean)
      {
        if (!(paramObject instanceof Object[])) {
          break label454;
        }
        localObject = (Object[])paramObject;
        if (localObject.length >= 5)
        {
          int i;
          if ((localObject[0] instanceof Integer))
          {
            i = ((Integer)localObject[0]).intValue();
            label102:
            if ((localObject[1] instanceof Integer)) {
              j = ((Integer)localObject[1]).intValue();
            }
            if (!(localObject[2] instanceof byte[])) {
              break label249;
            }
            paramObject = (byte[])localObject[2];
            label145:
            if (!(localObject[3] instanceof Boolean)) {
              break label254;
            }
            paramBoolean = ((Boolean)localObject[3]).booleanValue();
            label166:
            if (!(localObject[4] instanceof String)) {
              break label259;
            }
          }
          label259:
          for (localObject = (String)localObject[4];; localObject = null)
          {
            if (i == 0) {
              break label265;
            }
            QLog.d("HiBoomFont.HiBoomManager", 1, "onSetHiBoom fail ret = " + i + " id = " + j);
            if (!paramBoolean) {
              break;
            }
            auen.a(localContext, paramObject, j);
            auen.b.set(false);
            return;
            i = -1;
            break label102;
            label249:
            paramObject = null;
            break label145;
            label254:
            paramBoolean = false;
            break label166;
          }
          label265:
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomManager", 2, "onSetHiBoom success");
          }
          if (paramBoolean)
          {
            if ((localContext instanceof FragmentActivity))
            {
              paramObject = (FragmentActivity)localContext;
              if ((paramObject.getChatFragment() != null) && (paramObject.getChatFragment().a() != null))
              {
                paramObject = paramObject.getChatFragment().a();
                ((auen)paramObject.app.getManager(219)).a(paramObject, (String)localObject, j, auen.a(j));
                paramObject.showInputPanel();
                paramObject.input.setText("");
              }
            }
            auen.b.set(false);
          }
          paramObject = BaseApplicationImpl.getApplication().getRuntime();
          if (!(paramObject instanceof QQAppInterface)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomManager", 2, "onSetHiBoom get hiboom list");
          }
          ((anaj)((QQAppInterface)paramObject).getBusinessHandler(13)).b();
          return;
        }
        paramBoolean = false;
      }
      while (paramBoolean)
      {
        QQToast.a(localContext, 1, amtj.a(2131704600), 0).a();
        auen.b.set(false);
        return;
        paramBoolean = ((Boolean)paramObject).booleanValue();
        continue;
        label454:
        paramBoolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auet
 * JD-Core Version:    0.7.0.1
 */