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

public class aqxj
  extends aqxl
{
  private LinkedList<aqxk> a = new LinkedList();
  private QQAppInterface b;
  private boolean d;
  
  public aqxj(QQAppInterface paramQQAppInterface)
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
  
  public void a(aqxk paramaqxk)
  {
    synchronized (this.a)
    {
      if (!this.a.contains(paramaqxk)) {
        this.a.add(paramaqxk);
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
  
  public void b(aqxk paramaqxk)
  {
    synchronized (this.a)
    {
      this.a.remove(paramaqxk);
      return;
    }
  }
  
  public boolean b()
  {
    if (this.d)
    {
      this.b.setTalkbackSwitch();
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "isNetValid2Download by user " + AppSetting.c);
      }
      return AppSetting.c;
    }
    this.b.setTalkbackSwitch();
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "isNetValid2Download by startup " + AppSetting.c);
    }
    return (AppSetting.c) && (super.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxj
 * JD-Core Version:    0.7.0.1
 */