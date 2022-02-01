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

public class arme
  extends arac<arlz>
{
  final String a = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";
  
  @NonNull
  public arlz a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arlz();
  }
  
  @Nullable
  public arlz a(araj[] paramArrayOfaraj)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arlz)arax.a(paramArrayOfaraj[0].a, arlz.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj) {}
    }
    return null;
  }
  
  public void a(arlz paramarlz)
  {
    if (paramarlz == null)
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
      if (paramarlz == null) {
        break;
      }
      if (TextUtils.isEmpty(paramarlz.a)) {
        paramarlz.a = "{}";
      }
      SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("qfile_file_assistant_tips" + ((QQAppInterface)localObject).c(), 0).edit();
      localEditor.putString("qfile_file_assistant_tips", paramarlz.a);
      localEditor.apply();
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "save FileAssistantTips config [" + paramarlz.a + "]");
      localObject = (atsh)((QQAppInterface)localObject).getManager(317);
      if (localObject == null) {
        break;
      }
      ((atsh)localObject).a(paramarlz);
      return;
    }
  }
  
  public Class<arlz> clazz()
  {
    return arlz.class;
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
 * Qualified Name:     arme
 * JD-Core Version:    0.7.0.1
 */