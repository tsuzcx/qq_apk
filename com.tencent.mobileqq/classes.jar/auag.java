import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class auag
  extends TaskFlowEngine
{
  private static volatile auag jdField_a_of_type_Auag;
  private auah jdField_a_of_type_Auah;
  private auai jdField_a_of_type_Auai;
  private boolean jdField_a_of_type_Boolean;
  
  private auag()
  {
    a();
  }
  
  public static auag a()
  {
    if (jdField_a_of_type_Auag == null) {}
    try
    {
      if (jdField_a_of_type_Auag == null) {
        jdField_a_of_type_Auag = new auag();
      }
      return jdField_a_of_type_Auag;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Auai = new auai(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Auai });
  }
  
  public void a(auah paramauah)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + paramauah + ",current:" + this.jdField_a_of_type_Auah);
    if ((paramauah != null) && (paramauah.equals(this.jdField_a_of_type_Auah)))
    {
      this.jdField_a_of_type_Auah = null;
      this.jdField_a_of_type_Auai.a(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, auah paramauah)
  {
    this.jdField_a_of_type_Boolean = false;
    resetTaskAndDepends(this.jdField_a_of_type_Auai);
    b(paramauah);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Auai.a(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(auah paramauah)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + paramauah);
    this.jdField_a_of_type_Auah = paramauah;
    this.jdField_a_of_type_Auai.a(paramauah);
    boolean bool;
    if (this.jdField_a_of_type_Auai.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramauah != null)
      {
        bool = this.jdField_a_of_type_Auai.isSucceed();
        if (this.jdField_a_of_type_Auai.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Auai.msg)
    {
      paramauah.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Auai);
    if ((paramBaseTask instanceof auai))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Auah != null) {
        this.jdField_a_of_type_Auah.onEngineLoad(false, ((auai)paramBaseTask).msg);
      }
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Auah != null) {
        this.jdField_a_of_type_Auah.onEngineLoad(true, "");
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
 * Qualified Name:     auag
 * JD-Core Version:    0.7.0.1
 */