import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMultiSegment.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMultiSegment.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bpel
  extends bpen
  implements bpal, IEventReceiver
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private List<Long> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  
  public bpel(@NonNull bpep parambpep)
  {
    super(parambpep);
  }
  
  private long a(long paramLong)
  {
    int k = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return paramLong;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue() > paramLong) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break label104;
        }
        if (i != 0) {
          break;
        }
        return 0L;
      }
      i += 1;
    }
    return ((Long)this.jdField_a_of_type_JavaUtilList.get(i - 1)).longValue();
    label104:
    return ((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
  }
  
  private void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seekPlayer, pos:" + paramLong);
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new EditVideoMultiSegment.2(this), 3000L);
      boolean bool2 = false;
      long l2 = 0L;
      long l1 = l2;
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        l1 = l2;
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilList.size() != 0)
        {
          l1 = l2;
          bool1 = bool2;
          if (!this.jdField_b_of_type_Boolean)
          {
            l1 = l2;
            bool1 = bool2;
            if (paramBoolean2)
            {
              l1 = l2;
              bool1 = bool2;
              if (paramLong >= this.jdField_b_of_type_Long)
              {
                l2 = a(paramLong);
                l1 = l2;
                bool1 = bool2;
                if (l2 < this.jdField_b_of_type_Long)
                {
                  l1 = l2;
                  bool1 = bool2;
                  if (this.jdField_b_of_type_Long <= paramLong)
                  {
                    bool1 = true;
                    l1 = l2;
                  }
                }
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seekplayer, pos: " + paramLong + " keyPos:" + l1 + " curseek:" + this.jdField_b_of_type_Long + " useIFrame:" + this.jdField_b_of_type_Boolean + "  bNext:" + bool1);
      }
      localObject = (bpez)a(bpez.class);
      if (localObject != null)
      {
        if (!bool1) {
          break label340;
        }
        ((bpez)localObject).b(paramLong, paramBoolean1);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = paramLong;
      this.jdField_a_of_type_Boolean = true;
      localObject = (bpam)a(bpam.class);
      if (localObject != null) {
        ((bpam)localObject).a(paramLong);
      }
      return;
      label340:
      ((bpez)localObject).a(paramLong, paramBoolean1);
    }
  }
  
  private void d()
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("keyFrames{");
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      localStringBuilder.append('}');
    }
    for (;;)
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, localStringBuilder.toString());
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((Long)localIterator.next());
        localStringBuilder.append(",");
      }
      localStringBuilder.append('}');
    }
  }
  
  public int a()
  {
    bpez localbpez = (bpez)a(bpez.class);
    if (localbpez != null) {
      return localbpez.a();
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "onCreate");
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    a(bpal.class, this);
    if ((this.jdField_a_of_type_Bpep.a.a instanceof EditLocalVideoSource))
    {
      long l = ((EditLocalVideoSource)this.jdField_a_of_type_Bpep.a.a).a * -1;
      SegmentKeeper.adjustTime(l);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "local video, adjusttime::" + l);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    a(paramLong, paramBoolean, true);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seek, current state is seeking, pos:" + paramLong);
      }
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramLong, paramBoolean1, paramBoolean2);
      return;
    }
    ThreadManager.getUIHandler().post(new EditVideoMultiSegment.1(this, paramLong, paramBoolean1, paramBoolean2));
  }
  
  public void a(List<Long> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    d();
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    case 13: 
      this.c = ((Long[])(Long[])paramMessage.obj)[0].longValue();
      this.jdField_a_of_type_Boolean = false;
      return true;
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public void b()
  {
    Object localObject = (bpez)a(bpez.class);
    if (localObject != null) {
      ((bpez)localObject).k();
    }
    localObject = (bpam)a(bpam.class);
    if (localObject != null) {
      ((bpam)localObject).ab_();
    }
  }
  
  public void c()
  {
    Object localObject = (bpez)a(bpez.class);
    if (localObject != null) {
      ((bpez)localObject).l();
    }
    localObject = (bpam)a(bpam.class);
    if (localObject != null) {
      ((bpam)localObject).d();
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "onDestroy");
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public boolean m_()
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    bpez localbpez = (bpez)a(bpez.class);
    if (localbpez != null) {
      this.jdField_b_of_type_Boolean = localbpez.a(this.c);
    }
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpel
 * JD-Core Version:    0.7.0.1
 */