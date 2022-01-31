import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.1;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2;
import com.tencent.mobileqq.earlydownload.xmldata.ChirpSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class anpg
  extends anpi
{
  private LinkedList<anph> a = new LinkedList();
  private QQAppInterface b;
  private boolean d;
  
  public anpg(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.chirp", paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public int a()
  {
    return 10040;
  }
  
  public Class<? extends XmlData> a()
  {
    return ChirpSoData.class;
  }
  
  public String a()
  {
    return "actEarlyChirpSo";
  }
  
  public void a(anph paramanph)
  {
    synchronized (this.a)
    {
      if (!this.a.contains(paramanph)) {
        this.a.add(paramanph);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "onDownload success " + paramString);
    }
    paramString = new ChirpSoHandler.1(this, paramString);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      ThreadManager.getSubThreadHandler().post(paramString);
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new ChirpSoHandler.2(this));
      return;
      paramString.run();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "restartDownload " + paramBoolean);
    }
    if (!this.d) {
      this.d = paramBoolean;
    }
    if ((a() != null) && (a().loadState == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "is in downloading");
      }
      return;
    }
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(anph paramanph)
  {
    synchronized (this.a)
    {
      this.a.remove(paramanph);
      return;
    }
  }
  
  public boolean b()
  {
    if (this.d)
    {
      this.b.E();
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "isNetValid2Download by user " + AppSetting.d);
      }
      return AppSetting.d;
    }
    this.b.E();
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "isNetValid2Download by startup " + AppSetting.d);
    }
    return (AppSetting.d) && (super.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anpg
 * JD-Core Version:    0.7.0.1
 */