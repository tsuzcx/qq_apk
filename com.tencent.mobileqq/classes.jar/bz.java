import android.os.AsyncTask;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.List;

public class bz
  extends AsyncTask<Integer, Integer, String>
{
  public bz(LiteActivity paramLiteActivity, ArrayList paramArrayList) {}
  
  DataLineMsgRecord a(ajum paramajum, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == 0) {
      switch (apug.a(paramString))
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msgtype = ajum.a(i);
      localDataLineMsgRecord.sessionid = paramajum.a(0, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a).longValue();
      localDataLineMsgRecord.path = paramString;
      localDataLineMsgRecord.thumbPath = null;
      localDataLineMsgRecord.groupId = paramInt2;
      localDataLineMsgRecord.groupSize = paramInt3;
      localDataLineMsgRecord.groupIndex = paramInt4;
      return localDataLineMsgRecord;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  protected String a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    a(this.jdField_a_of_type_JavaUtilArrayList, i);
    return null;
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(false);
  }
  
  void a(List<String> paramList, int paramInt)
  {
    if (paramList == null) {}
    ajum localajum;
    int j;
    int i;
    Object localObject;
    for (;;)
    {
      return;
      localajum = (ajum)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(8);
      j = paramList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localObject = a(localajum, (String)paramList.get(i), paramInt, 0, 0, 0);
        if (localObject != null) {
          localajum.a((DataLineMsgRecord)localObject, false);
        }
        i += 1;
      }
    }
    label117:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((j > 3) && (j < 50))
    {
      localObject = new ArrayList();
      int k = localajum.a();
      i = 0;
      if (i < j)
      {
        localDataLineMsgRecord = a(localajum, (String)paramList.get(i), paramInt, k, j, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, k)) {
          break label408;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localajum.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label259:
    label405:
    label408:
    for (;;)
    {
      i += 1;
      break label117;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localajum.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      j = localajum.a();
      i = 0;
      if (i < 50)
      {
        localDataLineMsgRecord = a(localajum, (String)paramList.get(i), paramInt, j, 50, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, j)) {
          break label405;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localajum.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label259;
        if (((ArrayList)localObject).size() > 0) {
          localajum.a((ArrayList)localObject, false);
        }
        i = 0;
        while (i < 50)
        {
          paramList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bz
 * JD-Core Version:    0.7.0.1
 */