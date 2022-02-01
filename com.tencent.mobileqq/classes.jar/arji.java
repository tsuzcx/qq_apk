import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arji
  extends aqwt<arjd>
{
  final String a = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";
  
  @NonNull
  public arjd a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arjd();
  }
  
  @Nullable
  public arjd a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (arjd)aqxo.a(paramArrayOfaqxa[0].a, arjd.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa) {}
    }
    return null;
  }
  
  public void a(arjd paramarjd)
  {
    if (paramarjd == null)
    {
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onUpdate: newConf is null.");
      return;
    }
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "QfileFileAssistantTipsConfigProcessor onUpdate");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null)
      {
        QLog.e("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "app is null!!!");
        return;
      }
      if (paramarjd == null) {
        break;
      }
      if (TextUtils.isEmpty(paramarjd.a)) {
        paramarjd.a = "{}";
      }
      SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("qfile_file_assistant_tips" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
      localEditor.putString("qfile_file_assistant_tips", paramarjd.a);
      localEditor.apply();
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "save FileAssistantTips config [" + paramarjd.a + "]");
      localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
      if (localObject == null) {
        break;
      }
      ((atix)localObject).a(paramarjd);
      return;
    }
  }
  
  public Class<arjd> clazz()
  {
    return arjd.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 606;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arji
 * JD-Core Version:    0.7.0.1
 */