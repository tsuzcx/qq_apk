import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.util.Pair;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceRespInfo;

public class anvn
  implements anui
{
  protected void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, long paramLong) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              a(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
              return;
              a(paramBoolean, (GetResourceRespInfo)paramObject);
              return;
              a(paramBoolean, (String)paramObject);
              return;
              a(paramBoolean, (UpgradeDetailWrapper)paramObject);
              return;
              a(paramBoolean, (AppShareID)paramObject);
              return;
              b(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
              return;
              a(paramBoolean, ((Integer)paramObject).intValue());
              return;
              if ((paramObject != null) && ((paramObject instanceof OperateVoipTipsInfo)))
              {
                paramObject = (OperateVoipTipsInfo)paramObject;
                a(paramObject.uin, paramObject.uinType, paramObject.taskList);
              }
              b(paramBoolean);
              return;
              paramObject = (Pair)paramObject;
              a(paramBoolean, (String)paramObject.first, (String)paramObject.second);
              return;
              b(paramBoolean, ((Boolean)paramObject).booleanValue());
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            a(((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
          a((Boolean)paramObject[0], (Boolean)paramObject[1], (String)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while (paramObject.length <= 4);
      b((Boolean)paramObject[0], (Boolean)paramObject[1], (String)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
      return;
    } while (!(paramObject instanceof Object[]));
    a(((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvn
 * JD-Core Version:    0.7.0.1
 */