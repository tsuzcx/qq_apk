import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

@Deprecated
public class amyc
  extends ampa<amyb>
{
  public int a()
  {
    return 533;
  }
  
  @NonNull
  public amyb a(int paramInt)
  {
    return new amyb();
  }
  
  @Nullable
  public amyb a(amph[] paramArrayOfamph)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfamph != null) {
      try
      {
        if (paramArrayOfamph.length > 0)
        {
          paramArrayOfamph = (amyb)ampv.a(paramArrayOfamph[0].a, amyb.class);
          return paramArrayOfamph;
        }
      }
      catch (QStorageInstantiateException paramArrayOfamph)
      {
        QLog.e("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfamph.getMessage());
      }
    }
    return null;
  }
  
  public Class<amyb> a()
  {
    return amyb.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amyb paramamyb)
  {
    if (paramamyb != null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label152;
      }
    }
    label152:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (TextUtils.isEmpty(paramamyb.a)) {
          paramamyb.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_exciting_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_file_exciting", paramamyb.a);
        localEditor.apply();
        QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "save download config [" + paramamyb.a + "]");
        localObject = (aoww)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aoww)localObject).a(paramamyb);
        }
      }
      return;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyc
 * JD-Core Version:    0.7.0.1
 */