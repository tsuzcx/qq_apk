import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class bbvo
  extends AsyncTask<Void, Integer, Integer>
{
  bbvo(bbvn parambbvn) {}
  
  private void a(long paramLong)
  {
    long l = bbvn.a(this.a).getLong("k_icon", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask clearIcons " + l + ", " + paramLong + ", " + 104L);
    }
    Object localObject;
    if (l < paramLong)
    {
      localObject = null;
      if (paramLong <= 104L) {
        break label180;
      }
    }
    for (;;)
    {
      try
      {
        InputStream localInputStream = bbvn.a(this.a).getApp().getAssets().open("rich_status.xml");
        localObject = localInputStream;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localObject = (SparseArray)bbvn.a(this.a, localObject)[0];
      if (bbvn.a(this.a, (SparseArray)localObject, bbvn.a(this.a))) {
        bbvn.a(this.a).edit().putLong("k_icon", paramLong).commit();
      }
      return;
      try
      {
        label180:
        FileInputStream localFileInputStream = new FileInputStream(new File(bbvn.a(this.a).getApp().getFilesDir(), "rich_status.xml"));
        localObject = localFileInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = bbvn.a(this.a).getLong("k_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local with file " + l + ", " + 104L);
    }
    if (l > 104L) {}
    ArrayList localArrayList;
    label221:
    for (;;)
    {
      try
      {
        paramVarArgs = new FileInputStream(new File(bbvn.a(this.a).getApp().getFilesDir(), "rich_status.xml"));
        if (paramVarArgs != null) {
          break label221;
        }
        Object localObject;
        paramVarArgs = null;
      }
      catch (FileNotFoundException paramVarArgs)
      {
        try
        {
          localObject = bbvn.a(this.a).getApp().getAssets().open("rich_status.xml");
          paramVarArgs = (Void[])localObject;
          l = 104L;
          localObject = bbvn.a(this.a, paramVarArgs);
          paramVarArgs = (SparseArray)localObject[0];
          localArrayList = (ArrayList)localObject[1];
          if ((paramVarArgs != null) && (paramVarArgs.size() != 0) && (localArrayList != null) && (localArrayList.size() != 0)) {
            break;
          }
          publishProgress(new Integer[] { Integer.valueOf(-1) });
          a(l);
          return Integer.valueOf(100);
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        paramVarArgs = paramVarArgs;
        paramVarArgs.printStackTrace();
      }
    }
    for (;;)
    {
      synchronized (bbvn.a(this.a))
      {
        if ((!isCancelled()) && (bbvn.a(this.a).size() == 0))
        {
          bbvn.a(this.a, paramVarArgs);
          bbvn.a(this.a).clear();
          bbvn.a(this.a).addAll(localArrayList);
          publishProgress(new Integer[] { Integer.valueOf(102) });
        }
      }
      cancel(true);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onPostExecute " + paramInteger);
    }
    bbvn.a(this.a, null);
    if (101 == bbvn.a(this.a, false)) {
      bbvn.a(this.a);
    }
    this.a.a(false);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onProgressUpdate " + i);
    }
    if (bbvn.a(this.a) != null)
    {
      paramVarArgs = bbvn.a(this.a).iterator();
      while (paramVarArgs.hasNext()) {
        ((bbtb)paramVarArgs.next()).a(i, 300);
      }
    }
    gk.a().c(i, 300);
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onCancelled");
    }
    bbvn.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvo
 * JD-Core Version:    0.7.0.1
 */