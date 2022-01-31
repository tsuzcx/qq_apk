import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.SystemFaceData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class anpz
  extends anpi
  implements Handler.Callback
{
  public static final String a;
  private Handler a;
  private ArrayList<String> b;
  
  static
  {
    jdField_a_of_type_JavaLangString = SystemFaceData.class.getSimpleName();
  }
  
  public anpz(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.face.gifv14", paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void c(String paramString)
  {
    int j = 0;
    int i = j;
    try
    {
      int m = Integer.parseInt(paramString);
      i = j;
      int k = ayjw.a[m];
      i = j;
      j = ayjw.b[m];
      i = j;
      localURL = new URL("emotion", BaseApplicationImpl.getContext().getResources().getResourceEntryName(k), "");
      i = j;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject;
      do
      {
        for (;;)
        {
          URL localURL;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "reloadFaceOnUI() ", localMalformedURLException);
          }
          localObject = null;
        }
        Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(i);
        localObject = URLDrawable.getDrawable((URL)localObject, localDrawable, localDrawable, true);
        if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "reloadFaceOnUI() idx=" + paramString + " d.status!=successed||loading. go to restartDownload");
          }
          ((URLDrawable)localObject).addHeader("faceIdx", paramString);
          ((URLDrawable)localObject).restartDownload();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reloadFaceOnUI() idx=" + paramString + " d.status=" + ((URLDrawable)localObject).getStatus() + " do nothing..");
    }
    if (localURL == null) {
      return;
    }
  }
  
  public int a()
  {
    return 10055;
  }
  
  public Class<? extends XmlData> a()
  {
    return SystemFaceData.class;
  }
  
  public String a()
  {
    return "actEarlySysFaceGif";
  }
  
  public void a(String paramString)
  {
    try
    {
      File localFile = BaseApplicationImpl.getContext().getDir("systemface", 0);
      bbdj.a(paramString, localFile.getAbsolutePath(), true);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDownloadFinish() uncompressZip to:" + localFile.getAbsolutePath());
      }
      super.a(paramString);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(196864);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(String paramString)
  {
    anox.a.lock();
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (!this.b.contains(paramString))
      {
        this.b.add(0, paramString);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addWaittingFace idx=" + paramString);
        }
      }
      return;
    }
    finally
    {
      anox.a.unlock();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = null;
      if ((this.b == null) || (this.b.size() <= 0)) {
        continue;
      }
      anox.a.lock();
      try
      {
        if (this.b.size() > 0) {
          paramMessage = (String)this.b.remove(0);
        }
        anox.a.unlock();
        if ((paramMessage == null) || (paramMessage.length() <= 0)) {
          continue;
        }
        c(paramMessage);
        if (this.b.size() <= 0) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(196864, 2000L);
        return false;
      }
      finally
      {
        anox.a.unlock();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anpz
 * JD-Core Version:    0.7.0.1
 */