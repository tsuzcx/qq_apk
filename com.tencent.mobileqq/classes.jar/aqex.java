import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchHistoryManager.1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class aqex
  implements Handler.Callback
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private bhsl jdField_a_of_type_Bhsl = new bhsl(ThreadManager.getFileThreadLooper(), this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  WeakReference<aqey> b;
  
  public aqex(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
    ThreadManager.postImmediately(new ExtendFriendSearchHistoryManager.1(this), null, true);
  }
  
  private void b()
  {
    ??? = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (??? == null) {}
    do
    {
      return;
      ??? = bdhb.a(String.format("%s_%s_%s", new Object[] { "extend_frd_search_history", Integer.valueOf(this.jdField_a_of_type_Int), ((QQAppInterface)???).getCurrentAccountUin() }));
    } while (this.jdField_a_of_type_Boolean);
    if ((??? != null) && ((??? instanceof List))) {}
    for (??? = (List)???;; ??? = null)
    {
      Object localObject2 = ???;
      if (??? == null) {
        localObject2 = new ArrayList();
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label201;
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
        if (this.jdField_a_of_type_JavaUtilList.size() > 10) {
          this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        }
      }
      this.jdField_a_of_type_Boolean = true;
      label201:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (this.b == null) || (this.b.get() == null)) {
          break;
        }
        ((aqey)this.b.get()).b();
        return;
      }
    }
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    bdhb.a(String.format("%s_%s_%s", new Object[] { "extend_frd_search_history", Integer.valueOf(this.jdField_a_of_type_Int), localQQAppInterface.getCurrentAccountUin() }), this.jdField_a_of_type_JavaUtilList);
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Boolean = true;
      if ((this.b != null) && (this.b.get() != null)) {
        ((aqey)this.b.get()).b();
      }
      if (!this.jdField_a_of_type_Bhsl.hasMessages(0)) {
        this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(0, 300L);
      }
      return;
    }
  }
  
  public void a(aqey paramaqey)
  {
    if (paramaqey != null)
    {
      this.b = new WeakReference(paramaqey);
      return;
    }
    this.b = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_Boolean) {
        b();
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
          this.jdField_a_of_type_JavaUtilList.remove(paramString);
        }
        this.jdField_a_of_type_JavaUtilList.add(0, paramString);
        if (this.jdField_a_of_type_JavaUtilList.size() > 10) {
          this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        }
        if ((this.b != null) && (this.b.get() != null)) {
          ((aqey)this.b.get()).b();
        }
        if (this.jdField_a_of_type_Bhsl.hasMessages(0)) {
          continue;
        }
        this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(0, 300L);
        return;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqex
 * JD-Core Version:    0.7.0.1
 */