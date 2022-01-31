import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class asjg
  extends TaskFlowEngine
{
  private static volatile asjg jdField_a_of_type_Asjg;
  private asjh jdField_a_of_type_Asjh;
  private asji jdField_a_of_type_Asji;
  private boolean jdField_a_of_type_Boolean;
  
  private asjg()
  {
    a();
  }
  
  public static asjg a()
  {
    if (jdField_a_of_type_Asjg == null) {}
    try
    {
      if (jdField_a_of_type_Asjg == null) {
        jdField_a_of_type_Asjg = new asjg();
      }
      return jdField_a_of_type_Asjg;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Asji = new asji(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Asji });
  }
  
  public void a(asjh paramasjh)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + paramasjh + ",current:" + this.jdField_a_of_type_Asjh);
    if ((paramasjh != null) && (paramasjh.equals(this.jdField_a_of_type_Asjh)))
    {
      this.jdField_a_of_type_Asjh = null;
      this.jdField_a_of_type_Asji.a(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, asjh paramasjh)
  {
    this.jdField_a_of_type_Boolean = false;
    resetTaskAndDepends(this.jdField_a_of_type_Asji);
    b(paramasjh);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Asji.a(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(asjh paramasjh)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + paramasjh);
    this.jdField_a_of_type_Asjh = paramasjh;
    this.jdField_a_of_type_Asji.a(paramasjh);
    boolean bool;
    if (this.jdField_a_of_type_Asji.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramasjh != null)
      {
        bool = this.jdField_a_of_type_Asji.isSucceed();
        if (this.jdField_a_of_type_Asji.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Asji.msg)
    {
      paramasjh.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Asji);
    if ((paramBaseTask instanceof asji))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Asjh != null) {
        this.jdField_a_of_type_Asjh.onEngineLoad(false, ((asji)paramBaseTask).msg);
      }
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Asjh != null) {
        this.jdField_a_of_type_Asjh.onEngineLoad(true, "");
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
 * Qualified Name:     asjg
 * JD-Core Version:    0.7.0.1
 */