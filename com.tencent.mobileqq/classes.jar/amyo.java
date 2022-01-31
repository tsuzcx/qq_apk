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

public class amyo
  extends ampa<amyj>
{
  final String a = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";
  
  public int a()
  {
    return 606;
  }
  
  @NonNull
  public amyj a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new amyj();
  }
  
  @Nullable
  public amyj a(amph[] paramArrayOfamph)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfamph != null) {
      try
      {
        if (paramArrayOfamph.length > 0)
        {
          paramArrayOfamph = (amyj)ampv.a(paramArrayOfamph[0].a, amyj.class);
          return paramArrayOfamph;
        }
      }
      catch (QStorageInstantiateException paramArrayOfamph) {}
    }
    return null;
  }
  
  public Class<amyj> a()
  {
    return amyj.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amyj paramamyj)
  {
    if (paramamyj == null)
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
      if (paramamyj == null) {
        break;
      }
      if (TextUtils.isEmpty(paramamyj.a)) {
        paramamyj.a = "{}";
      }
      SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("qfile_file_assistant_tips" + ((QQAppInterface)localObject).c(), 0).edit();
      localEditor.putString("qfile_file_assistant_tips", paramamyj.a);
      localEditor.apply();
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "save FileAssistantTips config [" + paramamyj.a + "]");
      localObject = (aoww)((QQAppInterface)localObject).getManager(317);
      if (localObject == null) {
        break;
      }
      ((aoww)localObject).a(paramamyj);
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
 * Qualified Name:     amyo
 * JD-Core Version:    0.7.0.1
 */