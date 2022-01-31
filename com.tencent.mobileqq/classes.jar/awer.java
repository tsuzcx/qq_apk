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

class awer
  extends AsyncTask<Void, Integer, Integer>
{
  awer(aweq paramaweq) {}
  
  private void a(long paramLong)
  {
    long l = aweq.a(this.a).getLong("k_icon", 0L);
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
        InputStream localInputStream = aweq.a(this.a).getApp().getAssets().open("rich_status.xml");
        localObject = localInputStream;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localObject = (SparseArray)aweq.a(this.a, localObject)[0];
      if (aweq.a(this.a, (SparseArray)localObject, aweq.a(this.a))) {
        aweq.a(this.a).edit().putLong("k_icon", paramLong).commit();
      }
      return;
      try
      {
        label180:
        FileInputStream localFileInputStream = new FileInputStream(new File(aweq.a(this.a).getApp().getFilesDir(), "rich_status.xml"));
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
    long l = aweq.a(this.a).getLong("k_version", 0L);
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
        paramVarArgs = new FileInputStream(new File(aweq.a(this.a).getApp().getFilesDir(), "rich_status.xml"));
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
          localObject = aweq.a(this.a).getApp().getAssets().open("rich_status.xml");
          paramVarArgs = (Void[])localObject;
          l = 104L;
          localObject = aweq.a(this.a, paramVarArgs);
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
      synchronized (aweq.a(this.a))
      {
        if ((!isCancelled()) && (aweq.a(this.a).size() == 0))
        {
          aweq.a(this.a, paramVarArgs);
          aweq.a(this.a).clear();
          aweq.a(this.a).addAll(localArrayList);
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
    aweq.a(this.a, null);
    if (101 == aweq.a(this.a, false)) {
      aweq.a(this.a);
    }
    this.a.a(false);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onProgressUpdate " + i);
    }
    if (aweq.a(this.a) != null)
    {
      paramVarArgs = aweq.a(this.a).iterator();
      while (paramVarArgs.hasNext()) {
        ((awcd)paramVarArgs.next()).a(i, 300);
      }
    }
    hy.a().c(i, 300);
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onCancelled");
    }
    aweq.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awer
 * JD-Core Version:    0.7.0.1
 */