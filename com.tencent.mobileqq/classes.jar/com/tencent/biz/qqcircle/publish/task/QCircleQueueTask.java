package com.tencent.biz.qqcircle.publish.task;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.common.IQZoneServiceListener;
import com.tencent.biz.qqcircle.publish.queue.IUploadQueueListener;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.task.report.TaskReportInfo;
import com.tencent.biz.qqcircle.publish.task.report.TaskReportInfo.MediaReportInfo;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.utils.Const.UploadRetCode;
import java.util.Iterator;
import java.util.List;

public abstract class QCircleQueueTask
  extends QCircleTask
  implements IQZoneServiceListener, IUploadQueueListener, IQueueTask
{
  public long V = 0L;
  @NeedParcel
  public int W;
  public long X;
  public long Y;
  @NeedParcel
  public long Z;
  private long a = System.nanoTime();
  public long aa;
  @NeedParcel
  public int ab;
  public TaskReportInfo ac = new TaskReportInfo();
  String ad = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoQueueing", "排队中...");
  String ae = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoStop", "任务暂停");
  String af = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoFailMsg", "任务失败,");
  String ag = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoFail", "任务失败");
  String ah = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoNetWorkError", "网络错误");
  String ai = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoFileNotExist", "文件不存在");
  String aj = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoCancel", "已取消");
  String ak = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoSuccess", "上传成功");
  
  public QCircleQueueTask()
  {
    this.an = this;
  }
  
  public QCircleQueueTask(int paramInt)
  {
    super(null, null, null, paramInt);
    this.an = this;
  }
  
  public List<String> A()
  {
    return null;
  }
  
  public void E()
  {
    if (5 == this.W)
    {
      String str = al;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleQueueTask.run type:");
      localStringBuilder.append(k());
      localStringBuilder.append(" is canceled");
      QLog.i(str, 1, localStringBuilder.toString());
      return;
    }
    x();
    this.V = System.currentTimeMillis();
    super.E();
  }
  
  public void F()
  {
    this.X = 0L;
    this.Y = 0L;
  }
  
  protected int a(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append(String.valueOf(paramInt));
    paramString.append(System.currentTimeMillis());
    return paramInt + paramString.toString().hashCode();
  }
  
  public void a(int paramInt)
  {
    this.W = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.V = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.X = paramLong1;
    this.Y = paramLong2;
    QCircleTaskQueue.a().f(this);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt, String paramString) {}
  
  public void a(String paramString)
  {
    this.ao = paramString;
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.aa;
    if ((l2 == 0L) || (l1 - l2 > 20000L))
    {
      this.aa = l1;
      Object localObject = QCircleTaskQueue.a().h();
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          IQueueTask localIQueueTask = (IQueueTask)((Iterator)localObject).next();
          if (localIQueueTask != null) {
            localIQueueTask.a(l1);
          }
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.W = paramInt;
  }
  
  public void b(TaskReportInfo.MediaReportInfo paramMediaReportInfo)
  {
    if (paramMediaReportInfo == null)
    {
      QLog.e(al, 1, "addReportInfo error, reportinfo null");
      return;
    }
    if (this.ac == null) {
      this.ac = new TaskReportInfo();
    }
    this.ac.a(paramMediaReportInfo);
  }
  
  public int bn_()
  {
    return this.W;
  }
  
  public long c()
  {
    return this.a;
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    this.ap = paramInt;
  }
  
  public void e()
  {
    this.ab += 1;
    F();
  }
  
  public void f() {}
  
  public boolean g()
  {
    return false;
  }
  
  public void h() {}
  
  public String j()
  {
    return this.av;
  }
  
  public abstract int k();
  
  public long l()
  {
    return this.V;
  }
  
  public QCircleQueueTaskInfo m()
  {
    QCircleQueueTaskInfo localQCircleQueueTaskInfo = new QCircleQueueTaskInfo();
    int i = this.W;
    localQCircleQueueTaskInfo.c = i;
    Object localObject;
    StringBuilder localStringBuilder;
    switch (i)
    {
    default: 
      break;
    case 5: 
      if ((this.ap != 301002) && (this.ap != 301013))
      {
        if (this.ap == Const.UploadRetCode.FILE_NOT_EXIST.getCode())
        {
          localQCircleQueueTaskInfo.b = this.ai;
        }
        else
        {
          localObject = al;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("STATE_CANCEL mResultCode:");
          localStringBuilder.append(this.ap);
          QLog.i((String)localObject, 1, localStringBuilder.toString());
          if (this.ap == 0) {
            localQCircleQueueTaskInfo.b = this.ae;
          } else {
            localQCircleQueueTaskInfo.b = this.aj;
          }
        }
      }
      else {
        localQCircleQueueTaskInfo.b = this.ah;
      }
      break;
    case 4: 
      localQCircleQueueTaskInfo.b = this.ad;
      break;
    case 3: 
      localQCircleQueueTaskInfo.b = this.ak;
      break;
    case 2: 
      localObject = al;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("STATE_PAUSE mResultCode:");
      localStringBuilder.append(this.ap);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      if (this.ap == 0)
      {
        localQCircleQueueTaskInfo.b = this.ae;
      }
      else if (!TextUtils.isEmpty(this.ao))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.af);
        ((StringBuilder)localObject).append(this.ao);
        localQCircleQueueTaskInfo.b = ((StringBuilder)localObject).toString();
      }
      else if (QCircleTaskQueue.a().c(this, false))
      {
        localQCircleQueueTaskInfo.b = QCircleConfigHelper.a("QZoneSetting", "SafetyStrikeMessage", "你的帐户被禁止发言");
      }
      else
      {
        localQCircleQueueTaskInfo.b = this.ag;
      }
      break;
    case 1: 
      localQCircleQueueTaskInfo.b = this.ad;
      break;
    case 0: 
    case 6: 
      localQCircleQueueTaskInfo.b = this.ad;
    }
    localQCircleQueueTaskInfo.d = this.X;
    localQCircleQueueTaskInfo.e = this.Y;
    return localQCircleQueueTaskInfo;
  }
  
  public boolean n()
  {
    return false;
  }
  
  public int o()
  {
    return this.ap;
  }
  
  public int p()
  {
    return this.ab;
  }
  
  public long q()
  {
    return this.ax;
  }
  
  public long r()
  {
    return 0L;
  }
  
  public String s()
  {
    return null;
  }
  
  public boolean t()
  {
    return false;
  }
  
  public abstract void x();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleQueueTask
 * JD-Core Version:    0.7.0.1
 */