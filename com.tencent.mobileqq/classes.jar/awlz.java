import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class awlz
  extends TaskFlowEngine
{
  private static volatile awlz jdField_a_of_type_Awlz;
  private awma jdField_a_of_type_Awma;
  private awmb jdField_a_of_type_Awmb;
  private boolean jdField_a_of_type_Boolean;
  
  private awlz()
  {
    a();
  }
  
  public static awlz a()
  {
    if (jdField_a_of_type_Awlz == null) {}
    try
    {
      if (jdField_a_of_type_Awlz == null) {
        jdField_a_of_type_Awlz = new awlz();
      }
      return jdField_a_of_type_Awlz;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Awmb = new awmb(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Awmb });
  }
  
  public void a(awma paramawma)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + paramawma + ",current:" + this.jdField_a_of_type_Awma);
    if ((paramawma != null) && (paramawma.equals(this.jdField_a_of_type_Awma)))
    {
      this.jdField_a_of_type_Awma = null;
      this.jdField_a_of_type_Awmb.a(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, awma paramawma)
  {
    this.jdField_a_of_type_Boolean = false;
    resetTaskAndDepends(this.jdField_a_of_type_Awmb);
    b(paramawma);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Awmb.a(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(awma paramawma)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + paramawma);
    this.jdField_a_of_type_Awma = paramawma;
    this.jdField_a_of_type_Awmb.a(paramawma);
    boolean bool;
    if (this.jdField_a_of_type_Awmb.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramawma != null)
      {
        bool = this.jdField_a_of_type_Awmb.isSucceed();
        if (this.jdField_a_of_type_Awmb.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Awmb.msg)
    {
      paramawma.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Awmb);
    if ((paramBaseTask instanceof awmb))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Awma != null) {
        this.jdField_a_of_type_Awma.onEngineLoad(false, ((awmb)paramBaseTask).msg);
      }
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Awma != null) {
        this.jdField_a_of_type_Awma.onEngineLoad(true, "");
      }
    }
  }
  
  @Deprecated
  public void start()
  {
    QLog.w("MiniLoadManager", 1, "[MiniEng]start does nothing, use start(MiniAppConfig) instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlz
 * JD-Core Version:    0.7.0.1
 */