import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class auep
  extends TaskFlowEngine
{
  private static volatile auep jdField_a_of_type_Auep;
  private aueq jdField_a_of_type_Aueq;
  private auer jdField_a_of_type_Auer;
  private boolean jdField_a_of_type_Boolean;
  
  private auep()
  {
    a();
  }
  
  public static auep a()
  {
    if (jdField_a_of_type_Auep == null) {}
    try
    {
      if (jdField_a_of_type_Auep == null) {
        jdField_a_of_type_Auep = new auep();
      }
      return jdField_a_of_type_Auep;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Auer = new auer(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Auer });
  }
  
  public void a(aueq paramaueq)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + paramaueq + ",current:" + this.jdField_a_of_type_Aueq);
    if ((paramaueq != null) && (paramaueq.equals(this.jdField_a_of_type_Aueq)))
    {
      this.jdField_a_of_type_Aueq = null;
      this.jdField_a_of_type_Auer.a(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, aueq paramaueq)
  {
    this.jdField_a_of_type_Boolean = false;
    resetTaskAndDepends(this.jdField_a_of_type_Auer);
    b(paramaueq);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Auer.a(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(aueq paramaueq)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + paramaueq);
    this.jdField_a_of_type_Aueq = paramaueq;
    this.jdField_a_of_type_Auer.a(paramaueq);
    boolean bool;
    if (this.jdField_a_of_type_Auer.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramaueq != null)
      {
        bool = this.jdField_a_of_type_Auer.isSucceed();
        if (this.jdField_a_of_type_Auer.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Auer.msg)
    {
      paramaueq.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Auer);
    if ((paramBaseTask instanceof auer))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Aueq != null) {
        this.jdField_a_of_type_Aueq.onEngineLoad(false, ((auer)paramBaseTask).msg);
      }
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Aueq != null) {
        this.jdField_a_of_type_Aueq.onEngineLoad(true, "");
      }
    }
  }
  
  @Deprecated
  public void start()
  {
    QLog.w("MiniLoadManager", 1, "[MiniEng]start does nothing, use start(MiniAppConfig) instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auep
 * JD-Core Version:    0.7.0.1
 */