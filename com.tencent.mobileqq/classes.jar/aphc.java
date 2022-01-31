import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler.1;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler.2;
import com.tencent.mobileqq.earlydownload.xmldata.PokeResData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aphc
  extends apgu
{
  private boolean d;
  
  public aphc(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.poke.res_0625", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10044;
  }
  
  public Class<? extends XmlData> a()
  {
    return PokeResData.class;
  }
  
  public String a()
  {
    return "PokeResHandler_0625";
  }
  
  public void a()
  {
    BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).edit().putBoolean("ready", true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess:" + paramString);
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    String str = bduw.a(afsw.a());
    if (QLog.isColorLevel()) {
      QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess imagePath=" + str);
    }
    ThreadManager.post(new PokeResHandler.1(this, str, paramString), 8, null, true);
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ThreadManager.executeOnSubThread(new PokeResHandler.2(this));
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean g()
  {
    if (!this.d) {
      this.d = BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).getBoolean("ready", false);
    }
    return super.g() & this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphc
 * JD-Core Version:    0.7.0.1
 */