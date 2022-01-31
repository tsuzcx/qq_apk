import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;

public class apvn
  implements View.OnTouchListener, aswl, bhtv
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private apww jdField_a_of_type_Apww;
  private aswk jdField_a_of_type_Aswk = new aswk(120, this);
  private bhtv jdField_a_of_type_Bhtv;
  private EmotionPanelListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int b;
  private int c;
  private int d;
  private int e;
  
  public apvn(EmotionPanelListView paramEmotionPanelListView, apww paramapww, bhtv parambhtv)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bhtv = parambhtv;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = paramEmotionPanelListView;
    this.jdField_a_of_type_Apww = paramapww;
    this.c = bdoo.a(5.0F);
    this.jdField_a_of_type_Aswk.b(30);
  }
  
  private void a(int paramInt)
  {
    if (paramInt != this.jdField_b_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.getChildAt(0) != null) && (paramInt == 0) && (this.jdField_b_of_type_Int != 1) && (a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView)) && (this.jdField_a_of_type_Apww != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.getListViewScrollY() < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Apww.n();
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelListView", 2, "onScrollStateChanged onPullDown");
        }
      }
      this.jdField_b_of_type_Int = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelListView", 2, "onScrollStateChanged mLastState :" + this.jdField_b_of_type_Int);
      }
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof URLImageView))
    {
      int i = this.jdField_a_of_type_ArrayOfInt[1] + paramView.getWidth() - this.c - this.d;
      float f = paramView.getWidth() / 2.0F;
      if (i < f)
      {
        paramView.setAlpha((f - i) * 1.0F / f);
        return;
      }
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(1.0F);
  }
  
  private boolean a(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramListView.getChildCount() > 0)
    {
      bool1 = bool2;
      if (paramListView.getFirstVisiblePosition() == 0)
      {
        bool1 = bool2;
        if (paramListView.getChildAt(0) != null)
        {
          bool1 = bool2;
          if (paramListView.getChildAt(0).getTop() >= paramListView.getPaddingTop()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(AbsListView paramAbsListView)
  {
    if (paramAbsListView != null)
    {
      int k = paramAbsListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = paramAbsListView.getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = m - 1;
          if (j >= 0)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(m - 1);
            localView2.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
            this.jdField_a_of_type_ArrayOfInt[0] = localView2.getLeft();
            if ((this.e > 0) && (this.jdField_a_of_type_ArrayOfInt[0] + localView2.getWidth() * 2.0F / 3.0F > this.e) && (this.d > 0) && (this.jdField_a_of_type_ArrayOfInt[1] + localView2.getWidth() - this.c > this.d)) {
              a(localView2);
            }
            for (;;)
            {
              j -= 1;
              break;
              localView2.setAlpha(1.0F);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public aswk a()
  {
    return this.jdField_a_of_type_Aswk;
  }
  
  public void a(AbsListView paramAbsListView)
  {
    if (((paramAbsListView.getAdapter() instanceof apyy)) || ((paramAbsListView.getAdapter() instanceof apyo)))
    {
      if (((this.jdField_a_of_type_Apww instanceof EmoticonMainPanel)) && (((EmoticonMainPanel)this.jdField_a_of_type_Apww).a().a != null))
      {
        int i = EmoticonPanelController.jdField_b_of_type_Int;
        List localList = ((EmoticonMainPanel)this.jdField_a_of_type_Apww).a().jdField_b_of_type_JavaUtilList;
        EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = ((EmoticonMainPanel)this.jdField_a_of_type_Apww).a().a;
        if ((i >= 0) && (localList != null) && (i < localList.size()))
        {
          Object localObject2 = localEmotionPanelViewPagerAdapter.a(i);
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (i - 1 >= 0) {
              localObject1 = localEmotionPanelViewPagerAdapter.a(i - 1);
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (i + 1 < localList.size()) {
              localObject2 = localEmotionPanelViewPagerAdapter.a(i + 1);
            }
          }
          if (localObject2 != null)
          {
            localObject1 = new int[2];
            ((ImageButton)localObject2).getLocationOnScreen((int[])localObject1);
            this.e = ((ImageButton)localObject2).getLeft();
            this.d = localObject1[1];
          }
        }
      }
      b(paramAbsListView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Apww != null))
    {
      this.jdField_a_of_type_Apww.m();
      this.jdField_a_of_type_Aswk.a(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListView", 2, "onCheckSpeed overSpeed :" + paramBoolean);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bhtv != null) {
      this.jdField_a_of_type_Bhtv.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView)) && (this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Apww != null)) {
      a(0);
    }
    a(paramAbsListView);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.getListViewScrollY();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bhtv != null) {
      this.jdField_a_of_type_Bhtv.onScrollStateChanged(paramAbsListView, paramInt);
    }
    a(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Aswk.a(true);
      if (this.jdField_a_of_type_Apww != null) {
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Apww.c();
      }
    }
    for (;;)
    {
      return false;
      if ((i == 1) && (this.jdField_a_of_type_Boolean)) {
        if ((a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.getListViewScrollY() < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Apww != null))
        {
          this.jdField_a_of_type_Apww.n();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch scroll top pull down");
          }
        }
        else if ((a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView)) && (paramMotionEvent.getY() > this.jdField_a_of_type_Float) && (this.jdField_a_of_type_Apww != null))
        {
          this.jdField_a_of_type_Apww.n();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch no scroll top pull down");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvn
 * JD-Core Version:    0.7.0.1
 */