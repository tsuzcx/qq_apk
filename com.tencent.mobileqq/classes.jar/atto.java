import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.QQFavProxy.1;
import com.tencent.mobileqq.filemanager.app.QQFavProxy.2;
import com.tencent.mobileqq.filemanager.app.QQFavProxy.3;
import com.tencent.mobileqq.filemanager.app.QQFavProxy.4;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class atto
{
  static String jdField_a_of_type_JavaLangString = "QQFavProxy<FileAssistant>";
  static String b = "FavFileS ";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, attp> jdField_a_of_type_JavaUtilHashMap;
  private HashSet<attq> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  
  public atto(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b(long paramLong, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append(b).append("onGettedFileList. reqTimeStamp:").append(paramLong).append(" size:");
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      QLog.i((String)localObject, 1, i);
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        if (paramBundle == null) {
          break label257;
        }
      }
    }
    label257:
    for (boolean bool = paramBundle.getBoolean("fecth_operate_end");; bool = true)
    {
      localObject = (attp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localObject == null) {}
      do
      {
        return;
        i = 0;
        break;
        if (((attp)localObject).jdField_a_of_type_JavaUtilList == null) {
          ((attp)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        if (bool)
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
          if (paramList != null) {
            ((attp)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
          }
          if (paramBundle != null) {
            ((attp)localObject).jdField_a_of_type_Long = paramBundle.getLong("resultTimestamp");
          }
          ((attp)localObject).a(0, ((attp)localObject).jdField_a_of_type_JavaUtilList, paramBundle);
          return;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, b + "onGettedFileList. fav is getting and waiting");
        if (paramList != null) {
          ((attp)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
      } while (paramBundle == null);
      ((attp)localObject).jdField_a_of_type_Long = paramBundle.getLong("resultTimestamp");
      return;
    }
  }
  
  public long a(long paramLong, List<FavFileInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      attp localattp = (attp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (paramList != null) {
        paramList.addAll(localattp.jdField_a_of_type_JavaUtilList);
      }
      if (localattp != null) {
        return localattp.jdField_a_of_type_Long;
      }
    }
    return 0L;
  }
  
  public void a(long paramLong)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, b + "cancelGetFileList. reqTimeStamp:" + paramLong);
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, b + "onFileDownloaded. favId:" + paramLong + " strSavePath:" + paramString + "lz:" + this.jdField_a_of_type_JavaUtilHashSet.size());
    if (this.jdField_a_of_type_JavaUtilHashSet.size() == 0) {}
    for (;;)
    {
      return;
      Object localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new QQFavProxy.4(this, paramLong, paramString));
        return;
      }
      localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((attq)((Iterator)localObject).next()).a(paramLong, paramString);
      }
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    int i = 0;
    QLog.i(jdField_a_of_type_JavaLangString, 1, b + "onFileThumbUpdated. favId:" + paramLong + " strThumbPath:" + paramString + " format:" + paramInt + " lz:" + this.jdField_a_of_type_JavaUtilHashSet.size());
    if (this.jdField_a_of_type_JavaUtilHashSet.size() == 0) {}
    for (;;)
    {
      return;
      if (paramInt == 64) {}
      for (;;)
      {
        localObject = Looper.getMainLooper();
        if (Thread.currentThread() == ((Looper)localObject).getThread()) {
          break;
        }
        new Handler((Looper)localObject).post(new QQFavProxy.3(this, paramLong, i, paramString));
        return;
        if (paramInt == 128) {
          i = 1;
        } else if (paramInt == 320) {
          i = 2;
        }
      }
      Object localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((attq)((Iterator)localObject).next()).a(paramLong, i, paramString);
      }
    }
  }
  
  public void a(long paramLong, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    new Handler(Looper.getMainLooper()).post(new QQFavProxy.1(this, paramLong, paramList, paramBundle));
  }
  
  public void a(long paramLong, boolean paramBoolean, Bundle paramBundle, attp paramattp)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, b + "getFileList. lastTimestamp:" + paramLong);
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (paramattp != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramattp);
    }
    bmkq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramLong, Boolean.valueOf(paramBoolean), paramBundle);
  }
  
  public void a(attq paramattq)
  {
    if (paramattq == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramattq);
  }
  
  public void a(FavFileInfo paramFavFileInfo, int paramInt)
  {
    int i = 64;
    if (paramInt == 0) {}
    for (;;)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, b + "downloadThumb. favId:" + paramFavFileInfo.jdField_a_of_type_Long + " format:" + i);
      bmkq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramFavFileInfo, i);
      return;
      if (paramInt == 1) {
        i = 128;
      } else if (paramInt == 2) {
        i = 320;
      } else if (paramInt == 3) {
        i = 640;
      } else if (paramInt == 4) {
        i = 1024;
      }
    }
  }
  
  public void a(List<FavFileInfo> paramList, String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, b + "sendFavFiles. size:" + paramList.size() + " strToUin:" + paramString + " toUinType:" + paramInt);
    bmkq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramString, paramInt);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("delete_favids");
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, b + "onFileListRefreshed. bSuc:" + paramBoolean + " delFavIds:" + str);
    if (this.jdField_a_of_type_JavaUtilHashSet.size() == 0) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new QQFavProxy.2(this, paramBoolean, paramBundle));
  }
  
  public boolean a(Bundle paramBundle)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, b + "refreshList.");
    return bmkq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramBundle);
  }
  
  public void b(attq paramattq)
  {
    if (paramattq == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.remove(paramattq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atto
 * JD-Core Version:    0.7.0.1
 */