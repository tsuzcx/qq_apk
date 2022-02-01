import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Point;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.util.WeakReference;

public class aqsf
{
  private static aqsf jdField_a_of_type_Aqsf;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static final byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aqsg(this);
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private WeakReference<aqrh> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private WeakReference<aqva> jdField_b_of_type_MqqUtilWeakReference;
  private boolean jdField_b_of_type_Boolean = true;
  
  public static aqsf a()
  {
    if (jdField_a_of_type_Aqsf == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Aqsf == null)
      {
        jdField_a_of_type_Aqsf = new aqsf();
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteQIPCModule", 2, "create ColorNoteQIPCModule");
        }
      }
      return jdField_a_of_type_Aqsf;
    }
  }
  
  public Point a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("key_float_window_position");
    localIntentFilter.addAction("key_delete_item_call");
    localIntentFilter.addAction("key_after_sync_msg");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteQIPCModule", 1, "register broadcast");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteQIPCModule", 2, "register failed", localException);
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, paramString, paramBoolean, 0);
  }
  
  public void a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQIPCModule", 2, "[updateColorNoteSet] " + aqsd.a());
    }
    if (paramInt2 == 2) {
      return;
    }
    paramString = paramInt1 + paramString + paramInt2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.remove(paramString);
  }
  
  public void a(Point paramPoint)
  {
    if ((paramPoint != null) && (paramPoint.x != 0) && (paramPoint.y != 0)) {
      this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
    }
  }
  
  public void a(aqrh paramaqrh)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaqrh);
  }
  
  public void a(aqva paramaqva)
  {
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramaqva);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aqrl.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    aqrl.a(paramBoolean);
  }
  
  public boolean a()
  {
    return aqrl.a();
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, 0);
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    return (paramInt2 != 2) && (this.jdField_a_of_type_JavaUtilSet.contains(paramInt1 + paramString + paramInt2));
  }
  
  public void b()
  {
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteQIPCModule", 1, "unregister broadcast");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteQIPCModule", 2, "unregister failed", localException);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQIPCModule", 2, "[setSyncState] " + aqsd.a());
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQIPCModule", 2, "[setCanAddColorNote] " + aqsd.a());
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQIPCModule", 2, "[getCanAddColorNote] " + aqsd.a());
    }
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsf
 * JD-Core Version:    0.7.0.1
 */