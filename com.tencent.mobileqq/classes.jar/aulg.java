import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aulg
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aulf jdField_a_of_type_Aulf;
  private aulj jdField_a_of_type_Aulj;
  private aulk jdField_a_of_type_Aulk;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<aijq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private volatile List<RecentBaseData> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int;
  private volatile Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  
  public aulg(aulf paramaulf)
  {
    this.jdField_a_of_type_Aulf = paramaulf;
  }
  
  public static aulg a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "create() called with: app = [" + paramAppInterface + "]");
    }
    paramAppInterface = (aulf)paramAppInterface.getManager(325);
    aulg localaulg = new aulg(paramAppInterface);
    localaulg.c(paramAppInterface.a(localaulg));
    return localaulg;
  }
  
  private void a(List<RecentBaseData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "setRecentUserList() called with: recentUserList = [" + paramList + "]");
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aijq a(MultiAIOItemFragment paramMultiAIOItemFragment)
  {
    Object localObject2 = null;
    int i = paramMultiAIOItemFragment.a();
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      localObject1 = localObject2;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (aijq)this.jdField_a_of_type_JavaUtilList.get(i);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = aijx.a(paramMultiAIOItemFragment.getActivity(), paramMultiAIOItemFragment.a(), paramMultiAIOItemFragment.getActivity().app);
      a(i, (aijq)localObject2);
    }
    return localObject2;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    for (View localView1 = null;; localView1 = (View)this.jdField_a_of_type_JavaUtilArrayList.remove(0))
    {
      if (localView1 != null)
      {
        localObject = localView1.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(localView1);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MultiAioContext", 2, "getCacheViewFor() called with: position = [" + paramInt + "], v = " + localView1);
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView2 = (View)((Iterator)localObject).next();
        QLog.d("MultiAioContext", 2, "getCacheViewFor() cached v = [" + localView2 + "]");
      }
    }
    return localView1;
  }
  
  public aulk a()
  {
    return this.jdField_a_of_type_Aulk;
  }
  
  public List<RecentBaseData> a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "getRecentUserList() called with: app = [" + paramQQAppInterface + "], activity = [" + paramFragmentActivity + "], openedFrom = [" + paramString1 + "], enteranceType = [" + paramInt + "], enteranceUin = [" + paramString2 + "], enterNickName = [" + paramString3 + "], mRecentUserList = " + this.jdField_b_of_type_JavaUtilList);
    }
    List localList2 = this.jdField_b_of_type_JavaUtilList;
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = auku.a(paramFragmentActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3);
      a(localList1);
    }
    return localList1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "destroy() called");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, aijq paramaijq)
  {
    while (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
      this.jdField_a_of_type_JavaUtilList.add(null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "setMiniPie() called with: position = [" + paramInt + "], miniPie = [" + paramaijq + "]");
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, paramaijq);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aulj != null) {
      this.jdField_a_of_type_Aulj.a(paramIntent);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "setDecorViewBitmap() called with: decorViewBitmap = [" + paramBitmap + "]");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt)
  {
    while (paramInt > 0)
    {
      a(paramLayoutInflater.inflate(2131558794, paramViewGroup, false));
      paramInt -= 1;
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "putCacheView() called size = " + this.jdField_a_of_type_JavaUtilArrayList.size() + " with: v = [" + paramView + "]");
    }
  }
  
  public void a(aulj paramaulj)
  {
    this.jdField_a_of_type_Aulj = paramaulj;
  }
  
  public void a(aulk paramaulk)
  {
    this.jdField_a_of_type_Aulk = paramaulk;
  }
  
  public void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getRecentThreadLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this);
    this.jdField_a_of_type_AndroidOsHandler.postAtTime(new MultiAioContext.1(this, paramFragmentActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3), this, 0L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Bitmap b()
  {
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aulk != null) {
      this.jdField_a_of_type_Aulk.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Bitmap c()
  {
    return this.jdField_c_of_type_AndroidGraphicsBitmap;
  }
  
  public void c(Bitmap paramBitmap)
  {
    this.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulg
 * JD-Core Version:    0.7.0.1
 */