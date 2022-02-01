import com.tencent.mobileqq.together.writetogether.data.GetChangesetsResp;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.qphone.base.util.QLog;

public class bemu
  implements anui
{
  public void a(int paramInt, boolean paramBoolean, bent parambent)
  {
    QLog.d("WriteTogetherOidbObserver", 4, "type:" + paramInt + ", isSuccess: " + paramBoolean + ", data: " + parambent.a);
    bemo.a = parambent.a;
  }
  
  public void a(int paramInt, boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    if (!paramBoolean) {
      QLog.d("WriteTogetherOidbObserver", 4, "isSuccess: false");
    }
    if (paramOpenDocParam != null)
    {
      QLog.d("WriteTogetherOidbObserver", 4, paramOpenDocParam.toString());
      return;
    }
    QLog.d("WriteTogetherOidbObserver", 4, "param is null");
  }
  
  public void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void a(boolean paramBoolean, GetChangesetsResp paramGetChangesetsResp) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    QLog.d("WriteTogetherOidbObserver", 4, "type: " + paramInt + ", isSuccess: " + paramBoolean + ", data: " + paramObject);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if ((paramObject instanceof bent))
      {
        QLog.d("WriteTogetherOidbObserver", 4, "receive pad id: " + ((bent)paramObject).a);
        a(paramInt, paramBoolean, (bent)paramObject);
        return;
      }
      QLog.d("WriteTogetherOidbObserver", 4, "data is not String: " + paramObject);
      return;
    case 2: 
      if ((paramObject instanceof OpenDocParam))
      {
        a(paramInt, paramBoolean, (OpenDocParam)paramObject);
        return;
      }
      QLog.d("WriteTogetherOidbObserver", 4, "data is not OpenDocParam: " + paramObject);
      return;
    case 3: 
      a(paramBoolean, (GetChangesetsResp)paramObject);
      return;
    case 4: 
      a(paramInt, paramBoolean, (Object[])paramObject);
      return;
    }
    QLog.d("WriteTogetherOidbObserver", 4, "error. isSuccess: " + paramBoolean + ", data: " + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemu
 * JD-Core Version:    0.7.0.1
 */