import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bdvg
  extends arac<bdvi>
{
  public static final bdvh a = new bdvh(null);
  
  @NotNull
  public bdvi a(int paramInt)
  {
    return new bdvi();
  }
  
  @Nullable
  public bdvi a(@Nullable araj[] paramArrayOfaraj)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeSwitchDialogConfigProcessor", 2, "onParsed");
    }
    bdvi localbdvi = new bdvi();
    if (paramArrayOfaraj != null)
    {
      if (paramArrayOfaraj.length != 0) {
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
        paramArrayOfaraj = paramArrayOfaraj[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfaraj, "confFiles[0].content");
        localbdvi.a(paramArrayOfaraj);
      }
      return localbdvi;
      i = 0;
      break;
    }
  }
  
  public void a(@Nullable bdvi parambdvi) {}
  
  @NotNull
  public Class<bdvi> clazz()
  {
    return bdvi.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 619;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvg
 * JD-Core Version:    0.7.0.1
 */