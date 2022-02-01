import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.ditto.utils.ClassLoadUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.stickynote.QzoneStickyNoteManager.2;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class bmht
  implements bkhe
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private azpa jdField_a_of_type_Azpa;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Class jdField_a_of_type_JavaLangClass;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private Class<?> jdField_b_of_type_JavaLangClass;
  private Object jdField_b_of_type_JavaLangObject;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  
  private int a()
  {
    return this.jdField_c_of_type_Int - 2;
  }
  
  private Class<?> a()
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangClass == null) {
        this.jdField_b_of_type_JavaLangClass = ClassLoadUtils.load(this.jdField_a_of_type_JavaLangClassLoader, "com.qzone.homepage.ui.activity.FriendProfileCardAdapter");
      }
      return this.jdField_b_of_type_JavaLangClass;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 4, "getAdapterClass failed!", localException);
      }
    }
  }
  
  private Object a()
  {
    if (this.jdField_b_of_type_JavaLangObject != null) {
      return this.jdField_b_of_type_JavaLangObject;
    }
    try
    {
      Class localClass = ClassLoadUtils.load(this.jdField_a_of_type_JavaLangClassLoader, "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter$LoadCallback");
      ClassLoader localClassLoader = this.jdField_a_of_type_JavaLangClassLoader;
      bmhv localbmhv = new bmhv(this);
      this.jdField_b_of_type_JavaLangObject = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, localbmhv);
      return this.jdField_b_of_type_JavaLangObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 1, "getLocalCallback failed: " + localThrowable.getMessage());
      }
    }
  }
  
  private Object a(ListView paramListView)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaLangClassLoader == null) {
      return null;
    }
    try
    {
      Constructor localConstructor = b().getConstructor(new Class[] { Activity.class, ListView.class, Long.TYPE, Boolean.TYPE });
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {}
      for (;;)
      {
        paramListView = localConstructor.newInstance(new Object[] { this.jdField_a_of_type_AndroidAppActivity, paramListView, Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(bool) });
        return paramListView;
        bool = false;
      }
      return null;
    }
    catch (Exception paramListView)
    {
      QLog.w("QzoneStickyNoteManager", 4, "newConverter failed: " + paramListView.getMessage());
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    QZLog.d("QzoneStickyNoteManager", 4, String.format("onLoad pos=%s hasMore=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_c_of_type_Boolean = true;
    this.d = paramBoolean;
  }
  
  private void a(ListAdapter paramListAdapter)
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramListAdapter != null))
    {
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(paramListAdapter);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void a(AbsListView paramAbsListView, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      b().getDeclaredMethod("onScrollStateChanged", new Class[] { AbsListView.class, Integer.TYPE }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramAbsListView, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramAbsListView)
    {
      QLog.w("QzoneStickyNoteManager", 4, "onScrollStateChangedProxy failed: " + paramAbsListView.getMessage());
    }
  }
  
  private void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      b().getDeclaredMethod("onScroll", new Class[] { AbsListView.class, Integer.TYPE, Integer.TYPE, Integer.TYPE }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramAbsListView, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
    }
    catch (Exception paramAbsListView)
    {
      QLog.w("QzoneStickyNoteManager", 4, "onScrollProxy failed: " + paramAbsListView.getMessage());
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      b().getDeclaredMethod("onLifecycle", new Class[] { String.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneStickyNoteManager", 4, "onLifecycle failed: " + paramString.getMessage());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QZLog.d("QzoneStickyNoteManager", 4, "onLoadFinish " + paramBoolean);
    this.jdField_a_of_type_Int = 1;
  }
  
  private Class b()
  {
    if (this.jdField_a_of_type_JavaLangClass != null) {
      return this.jdField_a_of_type_JavaLangClass;
    }
    try
    {
      this.jdField_a_of_type_JavaLangClass = ClassLoadUtils.load(this.jdField_a_of_type_JavaLangClassLoader, "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter");
      return this.jdField_a_of_type_JavaLangClass;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 4, "getConverterClass failed: " + localException.getMessage());
      }
    }
  }
  
  private void c()
  {
    Class localClass;
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null)
    {
      localClass = a();
      if (localClass == null) {}
    }
    try
    {
      localClass.getDeclaredMethod("setStickyNoteComponent", new Class[] { azpa.class }).invoke(this.jdField_a_of_type_AndroidWidgetBaseAdapter, new Object[] { this.jdField_a_of_type_Azpa });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneStickyNoteManager", 1, "setStickyNoteComponentToAdapter failed!", localException);
    }
  }
  
  private void d()
  {
    QLog.i("QzoneStickyNoteManager", 1, "tryLoadMore");
    if ((this.d) && (this.jdField_a_of_type_Int != 2) && (this.jdField_b_of_type_Int == 0))
    {
      this.jdField_a_of_type_Int = 2;
      e();
    }
  }
  
  private void e()
  {
    QLog.i("QzoneStickyNoteManager", 1, "loadMore");
    Object localObject = a();
    if (localObject == null)
    {
      QLog.e("QzoneStickyNoteManager", 1, "loadMore exit due to null callback");
      return;
    }
    try
    {
      b().getDeclaredMethod("loadMore", new Class[] { Object.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { localObject });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneStickyNoteManager", 1, "loadMore failed: " + localException.getMessage());
    }
  }
  
  private void f()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    QZLog.d("QzoneStickyNoteManager", 4, String.format("scrollToStickNoteTop firstVisiblePos=%s", new Object[] { Integer.valueOf(i) }));
    if ((i > 1) && ((this.jdField_a_of_type_AndroidAppActivity instanceof FriendProfileCardActivity)))
    {
      i = ((FriendProfileCardActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();
      int j = this.jdField_a_of_type_AndroidViewView.getHeight();
      this.jdField_a_of_type_ComTencentWidgetListView.setSelectionFromTop(1, i + j);
    }
  }
  
  public BaseAdapter a()
  {
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
      return this.jdField_a_of_type_AndroidWidgetBaseAdapter;
    }
    if (this.jdField_a_of_type_JavaLangObject == null) {
      return null;
    }
    if (this.jdField_a_of_type_JavaLangClassLoader != null) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)b().getDeclaredMethod("getAdapter", new Class[0]).invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]));
      c();
      return this.jdField_a_of_type_AndroidWidgetBaseAdapter;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 4, "getAdapter failed: " + localException.getMessage());
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetListView != null)) {
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(new bkqn(null));
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QZLog.d("QzoneStickyNoteManager", 4, String.format("onActivityResult requestCode=%s resultCode=%s mCanLoadMore=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.d) }));
    try
    {
      b().getDeclaredMethod("onActivityResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if ((paramInt1 == 201209) && (paramInt2 == -1) && (!this.d)) {
        f();
      }
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QZLog.e("QzoneStickyNoteManager", 4, new Object[] { "onActivityResult failed!", paramIntent });
      }
    }
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, Card paramCard, ListView paramListView, View paramView, azpa paramazpa)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null))
    {
      QLog.w("QzoneStickyNoteManager", 1, "init failed due to null parameter");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Azpa = paramazpa;
    blvu.a(new bmhu(this, paramActivity, paramQQAppInterface, paramListView, paramCard));
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, ListView paramListView, Card paramCard)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (paramCard == null)) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramCard.uin);
        QZLog.i("QzoneStickyNoteManager", "attach: " + this.jdField_a_of_type_Boolean + ", " + l);
        if ((l <= 0L) || (this.jdField_a_of_type_Boolean)) {
          continue;
        }
        if (this.jdField_a_of_type_JavaLangClassLoader == null) {
          this.jdField_a_of_type_JavaLangClassLoader = QzonePluginProxyActivity.a();
        }
        if (paramQQAppInterface != blvu.a()) {
          blvu.a(paramActivity, paramQQAppInterface);
        }
        this.jdField_a_of_type_AndroidAppActivity = paramActivity;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_AndroidOsHandler.post(new QzoneStickyNoteManager.2(this, paramListView, paramCard));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          long l = 0L;
        }
      }
    }
  }
  
  public void a(Card paramCard)
  {
    if (this.jdField_a_of_type_JavaLangObject == null) {}
    while (this.jdField_a_of_type_JavaLangClassLoader == null) {
      return;
    }
    try
    {
      b().getDeclaredMethod("updateFriendProfileCard", new Class[] { Card.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramCard });
      return;
    }
    catch (Exception paramCard)
    {
      QLog.w("QzoneStickyNoteManager", 4, "updateFriendProfileCard failed: " + paramCard.getMessage());
    }
  }
  
  public void b()
  {
    a("onResume");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt3;
    a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        this.jdField_c_of_type_Boolean = false;
      }
      if (paramAbsListView.getLastVisiblePosition() >= a()) {
        d();
      }
    }
    a(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmht
 * JD-Core Version:    0.7.0.1
 */