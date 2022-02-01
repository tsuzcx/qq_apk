import android.os.AsyncTask;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.Iterator;
import java.util.List;

public class cj
  extends AsyncTask<Bundle, Integer, Void>
{
  public cj(LiteActivity paramLiteActivity) {}
  
  protected Void a(Bundle... paramVarArgs)
  {
    Object localObject = paramVarArgs[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
    if (localObject == null) {}
    for (;;)
    {
      return null;
      paramVarArgs = (anvu)this.a.app.a(8);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
        localDataLineMsgRecord.path = str;
        localDataLineMsgRecord.msgtype = -2009;
        paramVarArgs.a(localDataLineMsgRecord, false);
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     cj
 * JD-Core Version:    0.7.0.1
 */