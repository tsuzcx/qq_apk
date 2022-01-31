import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class asje
  extends TaskFlowEngine
{
  private static volatile asje jdField_a_of_type_Asje;
  private asjf jdField_a_of_type_Asjf;
  private asjg jdField_a_of_type_Asjg;
  private boolean jdField_a_of_type_Boolean;
  
  private asje()
  {
    a();
  }
  
  public static asje a()
  {
    if (jdField_a_of_type_Asje == null) {}
    try
    {
      if (jdField_a_of_type_Asje == null) {
        jdField_a_of_type_Asje = new asje();
      }
      return jdField_a_of_type_Asje;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Asjg = new asjg(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Asjg });
  }
  
  public void a(asjf paramasjf)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + paramasjf + ",current:" + this.jdField_a_of_type_Asjf);
    if ((paramasjf != null) && (paramasjf.equals(this.jdField_a_of_type_Asjf)))
    {
      this.jdField_a_of_type_Asjf = null;
      this.jdField_a_of_type_Asjg.a(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, asjf paramasjf)
  {
    this.jdField_a_of_type_Boolean = false;
    resetTaskAndDepends(this.jdField_a_of_type_Asjg);
    b(paramasjf);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Asjg.a(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(asjf paramasjf)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + paramasjf);
    this.jdField_a_of_type_Asjf = paramasjf;
    this.jdField_a_of_type_Asjg.a(paramasjf);
    boolean bool;
    if (this.jdField_a_of_type_Asjg.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramasjf != null)
      {
        bool = this.jdField_a_of_type_Asjg.isSucceed();
        if (this.jdField_a_of_type_Asjg.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Asjg.msg)
    {
      paramasjf.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Asjg);
    if ((paramBaseTask instanceof asjg))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Asjf != null) {
        this.jdField_a_of_type_Asjf.onEngineLoad(false, ((asjg)paramBaseTask).msg);
      }
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Asjf != null) {
        this.jdField_a_of_type_Asjf.onEngineLoad(true, "");
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
 * Qualified Name:     asje
 * JD-Core Version:    0.7.0.1
 */