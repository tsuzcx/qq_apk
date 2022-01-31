import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class arnb
  extends TaskFlowEngine
{
  private static volatile arnb jdField_a_of_type_Arnb;
  private arnc jdField_a_of_type_Arnc;
  private arnd jdField_a_of_type_Arnd;
  private boolean jdField_a_of_type_Boolean;
  
  private arnb()
  {
    a();
  }
  
  public static arnb a()
  {
    if (jdField_a_of_type_Arnb == null) {}
    try
    {
      if (jdField_a_of_type_Arnb == null) {
        jdField_a_of_type_Arnb = new arnb();
      }
      return jdField_a_of_type_Arnb;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Arnd = new arnd(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Arnd });
  }
  
  public void a(arnc paramarnc)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + paramarnc + ",current:" + this.jdField_a_of_type_Arnc);
    if ((paramarnc != null) && (paramarnc.equals(this.jdField_a_of_type_Arnc)))
    {
      this.jdField_a_of_type_Arnc = null;
      this.jdField_a_of_type_Arnd.a(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, arnc paramarnc)
  {
    this.jdField_a_of_type_Boolean = false;
    resetTaskAndDepends(this.jdField_a_of_type_Arnd);
    b(paramarnc);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Arnd.a(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(arnc paramarnc)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + paramarnc);
    this.jdField_a_of_type_Arnc = paramarnc;
    this.jdField_a_of_type_Arnd.a(paramarnc);
    boolean bool;
    if (this.jdField_a_of_type_Arnd.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramarnc != null)
      {
        bool = this.jdField_a_of_type_Arnd.isSucceed();
        if (this.jdField_a_of_type_Arnd.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Arnd.msg)
    {
      paramarnc.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Arnd);
    if ((paramBaseTask instanceof arnd))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Arnc != null) {
        this.jdField_a_of_type_Arnc.onEngineLoad(false, ((arnd)paramBaseTask).msg);
      }
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Arnc != null) {
        this.jdField_a_of_type_Arnc.onEngineLoad(true, "");
      }
    }
  }
  
  @Deprecated
  public void start()
  {
    QLog.w("MiniLoadManager", 1, "[MiniEng]start does nothing, use start(MiniAppConfig) instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     arnb
 * JD-Core Version:    0.7.0.1
 */