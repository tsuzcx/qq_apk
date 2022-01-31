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

public class aopv
  extends aofy<aopq>
{
  final String a = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";
  
  public int a()
  {
    return 606;
  }
  
  @NonNull
  public aopq a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aopq();
  }
  
  @Nullable
  public aopq a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aopq)aogt.a(paramArrayOfaogf[0].a, aopq.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf) {}
    }
    return null;
  }
  
  public Class<aopq> a()
  {
    return aopq.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aopq paramaopq)
  {
    if (paramaopq == null)
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
      if (paramaopq == null) {
        break;
      }
      if (TextUtils.isEmpty(paramaopq.a)) {
        paramaopq.a = "{}";
      }
      SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("qfile_file_assistant_tips" + ((QQAppInterface)localObject).c(), 0).edit();
      localEditor.putString("qfile_file_assistant_tips", paramaopq.a);
      localEditor.apply();
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "save FileAssistantTips config [" + paramaopq.a + "]");
      localObject = (aqpu)((QQAppInterface)localObject).getManager(317);
      if (localObject == null) {
        break;
      }
      ((aqpu)localObject).a(paramaopq);
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
 * Qualified Name:     aopv
 * JD-Core Version:    0.7.0.1
 */