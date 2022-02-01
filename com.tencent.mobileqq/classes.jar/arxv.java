import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.2;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.3;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.MobileQQ;

public class arxv
  extends Observable
  implements asga
{
  public static String a;
  public static String b;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private arxz jdField_a_of_type_Arxz = new arxz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  private volatile boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QfileFavFileRecordProvider<FileAssistant>";
    jdField_b_of_type_JavaLangString = "FavFileS ";
  }
  
  public arxv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(List<FavFileInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_Arxz.a(paramList, paramInt);
  }
  
  private void b(Bundle paramBundle)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + ">>>syncLastFileRecord...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(0L, false, null, new arxx(this, paramBundle));
  }
  
  private void d()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.jdField_a_of_type_JavaLangRunnable = new QfileFavFileRecordProvider.2(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "setGettingFavList timeout:" + 30000L);
  }
  
  private void e()
  {
    this.c = false;
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "unsetGettingFavList");
  }
  
  private void f()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_b_of_type_JavaLangRunnable = new QfileFavFileRecordProvider.3(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "setRefreshingFavList timeout:" + 30000L);
  }
  
  private void g()
  {
    this.d = false;
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "unsetRefreshingFavList");
  }
  
  private void h()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "resetFileRecordInfo.");
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Arxz.a();
  }
  
  public List<FavFileInfo> a(int paramInt)
  {
    return this.jdField_a_of_type_Arxz.a(paramInt);
  }
  
  public void a()
  {
    if (this.c)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "getMoreFileRecords. is getting...");
      return;
    }
    if (this.d)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "getMoreFileRecords. is refreshing...");
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + ">>>getMoreFileRecords... lastTimestamp:" + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Boolean, null, new arxw(this));
    d();
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onFileThumbUpdated. favid:" + paramLong + " type:" + paramInt + " strSavePath:" + paramString);
    FavFileInfo localFavFileInfo = this.jdField_a_of_type_Arxz.a(paramLong);
    if (localFavFileInfo != null)
    {
      if (paramInt != 0) {
        break label114;
      }
      localFavFileInfo.g = paramString;
    }
    for (;;)
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(2), { new Bundle() } });
      return;
      label114:
      if (paramInt == 1) {
        localFavFileInfo.h = paramString;
      } else if (paramInt == 2) {
        localFavFileInfo.i = paramString;
      } else if (paramInt == 3) {
        localFavFileInfo.j = paramString;
      } else if (paramInt == 4) {
        localFavFileInfo.k = paramString;
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onFileDownloaded. favid:" + paramLong + " strSavePath:" + paramString);
    FavFileInfo localFavFileInfo = this.jdField_a_of_type_Arxz.a(paramLong);
    if (localFavFileInfo != null) {
      localFavFileInfo.e = paramString;
    }
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(2), { new Bundle() } });
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.d) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "refreshFileRecords...");
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "refreshFileRecords no network");
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076);
      int j = (int)bfvh.a(BaseApplicationImpl.getContext(), 5.0F);
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697671, 0).b(i - j);
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), new Bundle() } });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramBundle);
    f();
  }
  
  public void a(aryb paramaryb)
  {
    if (paramaryb == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "addOrUpdateRecords parm err");
    }
    do
    {
      return;
      if (paramaryb.a.size() > 0) {
        a(paramaryb.a, 1);
      }
      if (paramaryb.b.size() > 0) {
        a(paramaryb.b, 2);
      }
      if (paramaryb.c.size() > 0) {
        a(paramaryb.c, 3);
      }
      if (paramaryb.d.size() > 0) {
        a(paramaryb.d, 4);
      }
    } while (paramaryb.e.size() <= 0);
    a(paramaryb.e, 5);
  }
  
  public void a(List<FavFileInfo> paramList, aryb paramaryb)
  {
    if ((paramaryb == null) || (paramList == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "pickFavFileList parm err");
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FavFileInfo localFavFileInfo = (FavFileInfo)paramList.next();
      if (localFavFileInfo != null) {
        paramaryb.a(localFavFileInfo.c).add(localFavFileInfo);
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "pickFavFileList. picSize:" + paramaryb.a.size() + " docSize:" + paramaryb.b.size() + " videoSize:" + paramaryb.c.size() + " appSize:" + paramaryb.d.size() + " otherSize:" + paramaryb.e.size());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      b(paramBundle);
      return;
    }
    int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076);
    int j = (int)bfvh.a(BaseApplicationImpl.getContext(), 5.0F);
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697670, 0).b(i - j);
    g();
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), paramBundle } });
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "init...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
  }
  
  public void c()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "release...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Arxz.a();
    e();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxv
 * JD-Core Version:    0.7.0.1
 */