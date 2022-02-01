import android.os.AsyncTask;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.ArrayList;
import java.util.List;

public class ci
  extends AsyncTask<Bundle, Integer, Void>
{
  public ci(LiteActivity paramLiteActivity) {}
  
  DataLineMsgRecord a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.msgtype = -2000;
    localDataLineMsgRecord.groupId = paramInt1;
    localDataLineMsgRecord.groupSize = paramInt2;
    localDataLineMsgRecord.groupIndex = paramInt3;
    return localDataLineMsgRecord;
  }
  
  protected Void a(Bundle... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
    if (paramVarArgs == null) {
      return null;
    }
    a(paramVarArgs);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.a.a(false);
  }
  
  void a(List<String> paramList)
  {
    ansr localansr = (ansr)this.a.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    for (;;)
    {
      int j = paramList.size();
      if (j <= 3)
      {
        i = 0;
        while (i < j)
        {
          localansr.a(a((String)paramList.get(i), 0, 0, 0), false);
          i += 1;
        }
      }
      if ((j > 3) && (j < 50))
      {
        localArrayList = new ArrayList();
        int k = localansr.a();
        i = 0;
        while (i < j)
        {
          localArrayList.add(a((String)paramList.get(i), k, j, i));
          i += 1;
        }
        dq.n(this.a.app);
        localansr.a(localArrayList, false);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      j = localansr.a();
      int i = 0;
      while (i < 50)
      {
        localArrayList.add(a((String)paramList.get(i), j, 50, i));
        i += 1;
      }
      dq.n(this.a.app);
      localansr.a(localArrayList, false);
      i = 0;
      while (i < 50)
      {
        paramList.remove(0);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ci
 * JD-Core Version:    0.7.0.1
 */