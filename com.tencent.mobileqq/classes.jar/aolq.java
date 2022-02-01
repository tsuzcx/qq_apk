import QC.HamletCheck;
import QC.UniBusinessCheckItem;
import QC.UniLoginCheckRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class aolq
  implements anui
{
  private WeakReference<QQAppInterface> a;
  
  public aolq(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      if ((paramObject instanceof UniLoginCheckRsp))
      {
        bidn.a(localQQAppInterface).a(((UniLoginCheckRsp)paramObject).stKeyWord);
        paramObject = (UniLoginCheckRsp)paramObject;
        if (paramObject.ret != 0) {
          break;
        }
        ChatBackgroundManager localChatBackgroundManager = (ChatBackgroundManager)localQQAppInterface.getManager(63);
        localChatBackgroundManager.a();
        localChatBackgroundManager.b();
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "bg and effect id clear");
        }
        Iterator localIterator = paramObject.stHamletList.iterator();
        while (localIterator.hasNext())
        {
          HamletCheck localHamletCheck = (HamletCheck)localIterator.next();
          if ((localHamletCheck.itemlist != null) && (localHamletCheck.itemlist.size() > 0))
          {
            int i = -1;
            paramInt = -1;
            paramObject = localHamletCheck.itemlist.iterator();
            Object localObject;
            while (paramObject.hasNext())
            {
              localObject = (UniBusinessCheckItem)paramObject.next();
              if (((UniBusinessCheckItem)localObject).appid == 8) {
                i = ((UniBusinessCheckItem)localObject).itemid;
              } else if (((UniBusinessCheckItem)localObject).appid == 35) {
                paramInt = ((UniBusinessCheckItem)localObject).itemid;
              }
            }
            if (i >= 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQInitHandler", 2, "bgId:" + i + " effectId:" + paramInt);
              }
              localObject = String.valueOf(localHamletCheck.uid);
              paramObject = localObject;
              if (localQQAppInterface.getAccount().equals(localObject))
              {
                paramObject = localObject;
                if (localHamletCheck.locationtype == 1) {
                  paramObject = null;
                }
              }
              if ((!"99".equals(String.valueOf(i))) || (paramInt > 0)) {
                localChatBackgroundManager.a(i, paramInt, paramObject, "chatbgAuth", ChatBackgroundAuth.a(localHamletCheck.locationtype));
              }
            }
          }
        }
      }
    }
    QLog.e("QQInitHandler", 1, "onResponse: ret:" + paramObject.ret + " errmsg:" + paramObject.errmsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aolq
 * JD-Core Version:    0.7.0.1
 */