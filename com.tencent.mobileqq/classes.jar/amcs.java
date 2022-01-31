import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class amcs
  extends bead
{
  public amcs(SignatureManager paramSignatureManager) {}
  
  public void onCancel(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onCancel| task:" + parambeae);
    }
  }
  
  @TargetApi(9)
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onDone| task:" + parambeae);
    }
    Object localObject2 = parambeae.a();
    if (localObject2 != null) {}
    for (int i = ((Bundle)localObject2).getInt("resType");; i = 0)
    {
      switch (i)
      {
      }
      label256:
      label385:
      for (;;)
      {
        return;
        if ((3 == parambeae.a()) || (parambeae.a() == 0))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          label177:
          Object localObject1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            parambeae = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0);
            i = parambeae.getInt("sigTplCfgVerTemp", 0);
            parambeae = parambeae.edit();
            parambeae.putInt("sigTplCfgVer", i);
            if (Build.VERSION.SDK_INT <= 8) {
              parambeae.commit();
            }
          }
          else
          {
            if (SignatureManager.a(this.a) == null) {
              break label256;
            }
            parambeae = new File(SignatureManager.b);
            localObject1 = SignatureManager.a(this.a);
            localObject2 = bdtg.a("signatureTemplate");
            if (!parambeae.exists()) {
              break label258;
            }
          }
          label258:
          for (long l = parambeae.length();; l = -1L)
          {
            ((bbaa)localObject1).a((String)localObject2, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Signature", 2, "[preDownload]:preDownload individual sign Success");
            return;
            parambeae.apply();
            break label177;
            break;
          }
          if ((3 == parambeae.a()) || (parambeae.a() == 0))
          {
            i = ((Bundle)localObject2).getInt("dynamicType");
            localObject1 = ((Bundle)localObject2).getString("tplId");
            localObject2 = ((Bundle)localObject2).getString("fileName");
            parambeae = null;
            switch (i)
            {
            }
            for (;;)
            {
              if (parambeae == null) {
                break label385;
              }
              parambeae = new File(parambeae);
              if (!beag.a(new File(bdtt.a((String)localObject1, (String)localObject2)), parambeae, true)) {
                break;
              }
              this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
              return;
              parambeae = bdtt.a((String)localObject1, "dynamic_aio");
            }
          }
        }
      }
    }
  }
  
  public boolean onStart(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onStart| task:" + parambeae);
    }
    super.onStart(parambeae);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcs
 * JD-Core Version:    0.7.0.1
 */