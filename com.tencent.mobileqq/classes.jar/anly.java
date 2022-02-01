import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;

public class anly
  implements alaq
{
  public anly(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void a(int paramInt)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartMoving:: side = " + paramInt + " getActivity = " + this.a.getActivity() + " mDrawerBg= " + this.a.jdField_a_of_type_AndroidViewViewGroup);
    }
    if (this.a.getActivity() == null) {
      return;
    }
    if (this.a.jdField_a_of_type_AndroidViewViewGroup != null) {
      FrameHelperActivity.a(this.a, false);
    }
    alaq[] arrayOfalaq = this.a.jdField_a_of_type_ArrayOfAlaq;
    int j = arrayOfalaq.length;
    while (i < j)
    {
      alaq localalaq = arrayOfalaq[i];
      if (localalaq != null) {
        localalaq.a(paramInt);
      }
      i += 1;
    }
    this.a.d(true);
  }
  
  @TargetApi(11)
  public void a(int paramInt, float paramFloat)
  {
    int i = 0;
    if ((QLog.isDevelopLevel()) && (FrameHelperActivity.a(this.a)))
    {
      FrameHelperActivity.a(this.a, false);
      QLog.i("Q.recent", 4, "onDrawerMoving:: side = " + paramInt + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {
      return;
    }
    if ((!this.a.getActivity().isFinishing()) && (FrameHelperActivity.a(this.a) != null) && (bkfq.a()))
    {
      localObject1 = FrameHelperActivity.a(this.a).a(bkfq.a);
      if (localObject1 != null) {
        ((bkpm)localObject1).c();
      }
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    Object localObject1 = this.a.jdField_a_of_type_ArrayOfAlaq;
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.a(paramInt, paramFloat);
      }
      i += 1;
    }
    this.a.d(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    FrameHelperActivity.a(this.a, true);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerOpened:: side = " + paramInt1 + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {
      return;
    }
    FrameHelperActivity.b(this.a, true);
    this.a.a(paramInt2, true, FrameHelperActivity.a(this.a));
    Object localObject1 = this.a.getActivity().app;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from DrawerOpened");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
    if ((!this.a.getActivity().isFinishing()) && (FrameHelperActivity.a(this.a) != null))
    {
      FrameHelperActivity.a(this.a).a();
      if (bkfq.a())
      {
        localObject1 = FrameHelperActivity.a(this.a).a(bkfq.a);
        if (localObject1 != null)
        {
          if (paramInt2 != 1) {
            break label260;
          }
          ((bkpm)localObject1).d();
        }
      }
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {}
      localObject1 = this.a.jdField_a_of_type_ArrayOfAlaq;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.a(paramInt1, paramInt2);
        }
        i += 1;
      }
      label260:
      ((bkpm)localObject1).a();
    }
    FrameHelperActivity.a(this.a);
    this.a.d(true);
    pmk.a().m();
    this.a.m();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartToggle:: side = " + paramInt + " open:" + paramBoolean + " getActivity = " + this.a.getActivity());
    }
    alaq[] arrayOfalaq = this.a.jdField_a_of_type_ArrayOfAlaq;
    int j = arrayOfalaq.length;
    int i = 0;
    while (i < j)
    {
      alaq localalaq = arrayOfalaq[i];
      if (localalaq != null) {
        localalaq.a(paramInt, paramBoolean);
      }
      i += 1;
    }
    if (paramBoolean) {
      ThreadManager.post(new FrameHelperActivity.1.1(this), 5, null, true);
    }
    this.a.d(paramBoolean);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerClosed:: side = " + paramInt1 + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {
      return;
    }
    FrameHelperActivity.b(this.a, false);
    this.a.a(paramInt2, false, FrameHelperActivity.a(this.a));
    if ((!this.a.getActivity().isFinishing()) && (FrameHelperActivity.a(this.a) != null))
    {
      FrameHelperActivity.a(this.a).b();
      if (bkfq.a())
      {
        localObject1 = FrameHelperActivity.a(this.a).a(bkfq.a);
        if (localObject1 != null) {
          ((bkpm)localObject1).b();
        }
      }
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      }
    }
    if (this.a.jdField_a_of_type_AndroidViewViewGroup != null) {
      ((ImageView)this.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380259)).setImageResource(0);
    }
    Object localObject1 = this.a.jdField_a_of_type_ArrayOfAlaq;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.b(paramInt1, paramInt2);
      }
      i += 1;
    }
    this.a.d(false);
    localObject1 = (QQAppInterface)pha.a();
    if (localObject1 != null) {
      ((KandianMergeManager)((QQAppInterface)localObject1).getManager(162)).p();
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(17)) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(17);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anly
 * JD-Core Version:    0.7.0.1
 */