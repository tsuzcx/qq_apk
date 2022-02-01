import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class avry
  extends TaskFlowEngine
{
  private static volatile avry jdField_a_of_type_Avry;
  private avrz jdField_a_of_type_Avrz;
  private avsa jdField_a_of_type_Avsa;
  private boolean jdField_a_of_type_Boolean;
  
  private avry()
  {
    a();
  }
  
  public static avry a()
  {
    if (jdField_a_of_type_Avry == null) {}
    try
    {
      if (jdField_a_of_type_Avry == null) {
        jdField_a_of_type_Avry = new avry();
      }
      return jdField_a_of_type_Avry;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Avsa = new avsa(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Avsa });
  }
  
  public void a(avrz paramavrz)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + paramavrz + ",current:" + this.jdField_a_of_type_Avrz);
    if ((paramavrz != null) && (paramavrz.equals(this.jdField_a_of_type_Avrz)))
    {
      this.jdField_a_of_type_Avrz = null;
      this.jdField_a_of_type_Avsa.a(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, avrz paramavrz)
  {
    this.jdField_a_of_type_Boolean = false;
    resetTaskAndDepends(this.jdField_a_of_type_Avsa);
    b(paramavrz);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Avsa.a(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(avrz paramavrz)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + paramavrz);
    this.jdField_a_of_type_Avrz = paramavrz;
    this.jdField_a_of_type_Avsa.a(paramavrz);
    boolean bool;
    if (this.jdField_a_of_type_Avsa.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramavrz != null)
      {
        bool = this.jdField_a_of_type_Avsa.isSucceed();
        if (this.jdField_a_of_type_Avsa.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Avsa.msg)
    {
      paramavrz.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Avsa);
    if ((paramBaseTask instanceof avsa))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Avrz != null) {
        this.jdField_a_of_type_Avrz.onEngineLoad(false, ((avsa)paramBaseTask).msg);
      }
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Avrz != null) {
        this.jdField_a_of_type_Avrz.onEngineLoad(true, "");
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
 * Qualified Name:     avry
 * JD-Core Version:    0.7.0.1
 */