import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.EmoticonManagerIPC;
import com.tencent.mobileqq.vas.ipc.remote.IEmoticonManager;
import com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.2;
import com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.3;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness.Config;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class bhsx
  implements bhpn, bhpt
{
  public int a;
  private bhpo jdField_a_of_type_Bhpo;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  public int b;
  
  public bhsx(VasResDrawable paramVasResDrawable)
  {
    this(paramVasResDrawable, null, 2130846115);
  }
  
  public bhsx(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_Bhpo = paramVasResDrawable.a();
    paramVasResDrawable.a().jdField_a_of_type_Int = 2130847441;
    paramVasResDrawable.a().b = paramInt;
    paramVasResDrawable.a().e = 104;
    if (paramAppRuntime != null) {
      paramVasResDrawable.a("my_uin", paramAppRuntime.getAccount());
    }
  }
  
  public String a()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString, "bg.png");
    if (localFile.exists()) {
      return localFile.getAbsolutePath();
    }
    return new File(this.jdField_a_of_type_JavaLangString, "bg.9.png").getAbsolutePath();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("downloadDone isMainThread:");
      if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId())
      {
        bool = true;
        QLog.d("TroopNickAdapter", 2, bool);
      }
    }
    else
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("resType");
      }
      switch (i)
      {
      }
    }
    do
    {
      return;
      bool = false;
      break;
    } while ((3 != paramInt) && (paramInt != 0));
    ThreadManager.excute(new TroopNickAdapter.3(this, paramBundle), 128, null, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new TroopNickAdapter.2(this, paramString, paramInt1, paramInt2), 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String[] a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(paramString);
    if ((localObject1 == null) || (!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNickAdapter", 2, "SignatureView DynamicItem png file path error.");
      }
      return null;
    }
    localObject1 = ((File)localObject1).listFiles();
    for (;;)
    {
      try
      {
        Object localObject2 = new StringBuilder();
        StringBuilder localStringBuilder = ((StringBuilder)localObject2).append(paramString).append(File.separator);
        if (!new File(paramString, "01.9.png").exists()) {
          break label254;
        }
        paramString = "%s.9.png";
        localStringBuilder.append(paramString);
        localObject2 = ((StringBuilder)localObject2).toString();
        int i = 1;
        if (i < localObject1.length)
        {
          if (i < 10)
          {
            paramString = "0" + i;
            paramString = String.format((String)localObject2, new Object[] { paramString });
            if (new File(paramString).exists())
            {
              localArrayList.add(paramString);
              i += 1;
            }
          }
          else
          {
            paramString = i + "";
            continue;
          }
          paramString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      label254:
      paramString = "%s.png";
    }
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_Bhpo.a();
    if (TroopNickNameBusiness.a.a(i))
    {
      this.jdField_a_of_type_JavaLangString = TroopNickNameBusiness.a.b(i);
      TroopNickNameBusiness.Config localConfig = TroopNickNameBusiness.a(this.jdField_a_of_type_JavaLangString);
      String str;
      int j;
      if (localConfig != null)
      {
        this.jdField_a_of_type_Int = localConfig.fontId;
        this.b = localConfig.fontType;
        str = this.jdField_a_of_type_JavaLangString;
        j = localConfig.delay;
        if (!this.jdField_a_of_type_Boolean) {
          break label86;
        }
      }
      label86:
      for (i = -1;; i = localConfig.repeatCount)
      {
        a(str, j, i);
        return;
      }
    }
    ((IEmoticonManager)RemoteProxy.getProxy(EmoticonManagerIPC.class)).startTroopNickDownload(i, null, -1, new bhsy(this));
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsx
 * JD-Core Version:    0.7.0.1
 */