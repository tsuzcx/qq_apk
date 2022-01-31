import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azxc
  extends aofy<azxe>
{
  public static final azxd a = new azxd(null);
  
  public int a()
  {
    return 619;
  }
  
  @NotNull
  public azxe a(int paramInt)
  {
    return new azxe();
  }
  
  @Nullable
  public azxe a(@Nullable aogf[] paramArrayOfaogf)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeSwitchDialogConfigProcessor", 2, "onParsed");
    }
    azxe localazxe = new azxe();
    if (paramArrayOfaogf != null)
    {
      if (paramArrayOfaogf.length != 0) {
        break label68;
      }
      i = 1;
      if (i != 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        paramArrayOfaogf = paramArrayOfaogf[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfaogf, "confFiles[0].content");
        localazxe.a(paramArrayOfaogf);
      }
      return localazxe;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public Class<azxe> a()
  {
    return azxe.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(@Nullable azxe paramazxe) {}
  
  public boolean a()
  {
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxc
 * JD-Core Version:    0.7.0.1
 */