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

public class aqwq
  extends aqkz<aqwl>
{
  final String a = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";
  
  @NonNull
  public aqwl a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aqwl();
  }
  
  @Nullable
  public aqwl a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaqlg != null) {
      try
      {
        if (paramArrayOfaqlg.length > 0)
        {
          paramArrayOfaqlg = (aqwl)aqlu.a(paramArrayOfaqlg[0].a, aqwl.class);
          return paramArrayOfaqlg;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqlg) {}
    }
    return null;
  }
  
  public void a(aqwl paramaqwl)
  {
    if (paramaqwl == null)
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
      if (paramaqwl == null) {
        break;
      }
      if (TextUtils.isEmpty(paramaqwl.a)) {
        paramaqwl.a = "{}";
      }
      SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("qfile_file_assistant_tips" + ((QQAppInterface)localObject).c(), 0).edit();
      localEditor.putString("qfile_file_assistant_tips", paramaqwl.a);
      localEditor.apply();
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "save FileAssistantTips config [" + paramaqwl.a + "]");
      localObject = (atam)((QQAppInterface)localObject).getManager(317);
      if (localObject == null) {
        break;
      }
      ((atam)localObject).a(paramaqwl);
      return;
    }
  }
  
  public Class<aqwl> clazz()
  {
    return aqwl.class;
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
 * Qualified Name:     aqwq
 * JD-Core Version:    0.7.0.1
 */