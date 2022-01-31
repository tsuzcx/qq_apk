import com.tencent.mobileqq.olympic.TorchInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.olympic.OlympicTorchSvc.SceneWording;
import tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo;

public class atgz
  implements ajfe
{
  public void a(boolean paramBoolean, int paramInt1, TorchInfo paramTorchInfo, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte, TorchInfo paramTorchInfo) {}
  
  public void a(boolean paramBoolean, TorchInfo paramTorchInfo) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString, torch_transfer.TorchbearerInfo paramTorchbearerInfo, OlympicTorchSvc.SceneWording paramSceneWording) {}
  
  public void b(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicObserver", 2, new Object[] { "onUpdata, type=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 6: 
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
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if ((paramObject != null) && ((paramObject instanceof Object[]))) {
                        break;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d("OlympicObserver", 2, "NOTIFY_GET_BUSINESS_TORCH, data is null or not Object[]");
                    return;
                    paramObject = (Object[])paramObject;
                    if (paramObject.length >= 4) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("OlympicObserver", 2, "NOTIFY_GET_BUSINESS_TORCH, objs.length < 4, is " + paramObject.length);
                  return;
                  a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (torch_transfer.TorchbearerInfo)paramObject[3], (OlympicTorchSvc.SceneWording)paramObject[4]);
                  return;
                  if ((paramObject != null) && ((paramObject instanceof Object[]))) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("OlympicObserver", 2, "NOTIFY_DELIVER_TORCH, data is null or not Object[]");
                return;
                paramObject = (Object[])paramObject;
                if (paramObject.length >= 6) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("OlympicObserver", 2, "NOTIFY_DELIVER_TORCH, objs.length < 6, is " + paramObject.length);
              return;
              a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (byte[])paramObject[5]);
              return;
              if ((paramObject != null) && ((paramObject instanceof Object[]))) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("OlympicObserver", 2, "NOTIFY_EXIT_DELIVER_TORCH, data is null or not Object[]");
            return;
            paramObject = (Object[])paramObject;
            if (paramObject.length >= 2) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("OlympicObserver", 2, "NOTIFY_EXIT_DELIVER_TORCH, objs.length < 2, is " + paramObject.length);
          return;
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof Object[])));
        paramObject = (Object[])paramObject;
      } while (paramObject.length < 2);
      b(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (byte[])paramObject[2], (TorchInfo)paramObject[3]);
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (TorchInfo)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OlympicObserver", 2, "NOTIFY_PUSH_0Xb4");
    }
    a(true, (TorchInfo)((Object[])(Object[])paramObject)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     atgz
 * JD-Core Version:    0.7.0.1
 */