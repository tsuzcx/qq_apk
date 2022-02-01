import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class axer
  extends TaskFlowEngine
{
  private static volatile axer jdField_a_of_type_Axer;
  private axes jdField_a_of_type_Axes;
  private axet jdField_a_of_type_Axet;
  private boolean jdField_a_of_type_Boolean;
  
  private axer()
  {
    a();
  }
  
  public static axer a()
  {
    if (jdField_a_of_type_Axer == null) {}
    try
    {
      if (jdField_a_of_type_Axer == null) {
        jdField_a_of_type_Axer = new axer();
      }
      return jdField_a_of_type_Axer;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Axet = new axet(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Axet });
  }
  
  public void a(axes paramaxes)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + paramaxes + ",current:" + this.jdField_a_of_type_Axes);
    if ((paramaxes != null) && (paramaxes.equals(this.jdField_a_of_type_Axes)))
    {
      this.jdField_a_of_type_Axes = null;
      this.jdField_a_of_type_Axet.a(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, axes paramaxes)
  {
    this.jdField_a_of_type_Boolean = false;
    resetTaskAndDepends(this.jdField_a_of_type_Axet);
    b(paramaxes);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Axet.a(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(axes paramaxes)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + paramaxes);
    this.jdField_a_of_type_Axes = paramaxes;
    this.jdField_a_of_type_Axet.a(paramaxes);
    boolean bool;
    if (this.jdField_a_of_type_Axet.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramaxes != null)
      {
        bool = this.jdField_a_of_type_Axet.isSucceed();
        if (this.jdField_a_of_type_Axet.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Axet.msg)
    {
      paramaxes.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Axet);
    if ((paramBaseTask instanceof axet))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Axes != null) {
        this.jdField_a_of_type_Axes.onEngineLoad(false, ((axet)paramBaseTask).msg);
      }
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Axes != null) {
        this.jdField_a_of_type_Axes.onEngineLoad(true, "");
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
 * Qualified Name:     axer
 * JD-Core Version:    0.7.0.1
 */