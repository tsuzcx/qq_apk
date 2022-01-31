import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class arts
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private artr jdField_a_of_type_Artr;
  private artv jdField_a_of_type_Artv;
  private artw jdField_a_of_type_Artw;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<afuz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private volatile List<RecentBaseData> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int;
  private volatile Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  
  public arts(artr paramartr)
  {
    this.jdField_a_of_type_Artr = paramartr;
  }
  
  public static arts a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "create() called with: app = [" + paramAppInterface + "]");
    }
    paramAppInterface = (artr)paramAppInterface.getManager(325);
    arts localarts = new arts(paramAppInterface);
    localarts.c(paramAppInterface.a(localarts));
    return localarts;
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
  
  public afuz a(MultiAIOItemFragment paramMultiAIOItemFragment)
  {
    Object localObject2 = null;
    int i = paramMultiAIOItemFragment.a();
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      localObject1 = localObject2;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (afuz)this.jdField_a_of_type_JavaUtilList.get(i);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = afvg.a(paramMultiAIOItemFragment.getActivity(), paramMultiAIOItemFragment.a(), paramMultiAIOItemFragment.getActivity().app);
      a(i, (afuz)localObject2);
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
    for (View localView = null;; localView = (View)this.jdField_a_of_type_JavaUtilArrayList.remove(0))
    {
      if (localView != null)
      {
        ViewParent localViewParent = localView.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
      }
      return localView;
    }
  }
  
  public artw a()
  {
    return this.jdField_a_of_type_Artw;
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
      localList1 = artg.a(paramFragmentActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3);
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
  
  public void a(int paramInt, afuz paramafuz)
  {
    while (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
      this.jdField_a_of_type_JavaUtilList.add(null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "setMiniPie() called with: position = [" + paramInt + "], miniPie = [" + paramafuz + "]");
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, paramafuz);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Artv != null) {
      this.jdField_a_of_type_Artv.a(paramIntent);
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
      a(paramLayoutInflater.inflate(2131493203, paramViewGroup, false));
      paramInt -= 1;
    }
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "addCacheView() called with: v = [" + paramView + "], size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void a(artv paramartv)
  {
    this.jdField_a_of_type_Artv = paramartv;
  }
  
  public void a(artw paramartw)
  {
    this.jdField_a_of_type_Artw = paramartw;
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
    if (this.jdField_a_of_type_Artw != null) {
      this.jdField_a_of_type_Artw.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arts
 * JD-Core Version:    0.7.0.1
 */