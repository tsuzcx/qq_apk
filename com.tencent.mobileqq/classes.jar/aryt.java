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

public class aryt
  implements View.OnTouchListener, avdu, bkhe
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private asag jdField_a_of_type_Asag;
  private avdt jdField_a_of_type_Avdt = new avdt(120, this);
  private bkhe jdField_a_of_type_Bkhe;
  private EmotionPanelListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  
  public aryt(EmotionPanelListView paramEmotionPanelListView, asag paramasag, bkhe parambkhe)
  {
    this.jdField_a_of_type_Bkhe = parambkhe;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = paramEmotionPanelListView;
    this.jdField_a_of_type_Asag = paramasag;
    this.c = bgtn.a(5.0F);
    this.jdField_a_of_type_Avdt.b(30);
  }
  
  private void a(int paramInt)
  {
    if (paramInt != this.jdField_b_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.getChildAt(0) != null) && (paramInt == 0) && (this.jdField_b_of_type_Int != 1) && (a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView)) && (this.jdField_a_of_type_Asag != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.getListViewScrollY() < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Asag.n();
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
  
  private void a(AbsListView paramAbsListView, boolean paramBoolean)
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
            if ((paramBoolean) && (this.e > 0) && (this.jdField_a_of_type_ArrayOfInt[0] + localView2.getWidth() * 2.0F / 3.0F > this.e) && (this.d > 0) && (this.jdField_a_of_type_ArrayOfInt[1] + localView2.getWidth() - this.c > this.d)) {
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
  
  public avdt a()
  {
    return this.jdField_a_of_type_Avdt;
  }
  
  public void a(AbsListView paramAbsListView)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((!(paramAbsListView.getAdapter() instanceof asct)) && (!(paramAbsListView.getAdapter() instanceof ascj))) {
      return;
    }
    if (((this.jdField_a_of_type_Asag instanceof EmoticonMainPanel)) && (((EmoticonMainPanel)this.jdField_a_of_type_Asag).a().a != null))
    {
      int i = EmoticonPanelController.jdField_b_of_type_Int;
      List localList = ((EmoticonMainPanel)this.jdField_a_of_type_Asag).a().jdField_b_of_type_JavaUtilList;
      EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = ((EmoticonMainPanel)this.jdField_a_of_type_Asag).a().a;
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
        if ((localObject2 != null) && (((ImageButton)localObject2).getVisibility() == 0))
        {
          localObject1 = new int[2];
          ((ImageButton)localObject2).getLocationOnScreen((int[])localObject1);
          this.e = ((ImageButton)localObject2).getLeft();
          this.d = localObject1[1];
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      a(paramAbsListView, bool);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Asag != null))
    {
      this.jdField_a_of_type_Asag.m();
      this.jdField_a_of_type_Avdt.a(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListView", 2, "onCheckSpeed overSpeed :" + paramBoolean);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bkhe != null) {
      this.jdField_a_of_type_Bkhe.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView)) && (this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Asag != null)) {
      a(0);
    }
    a(paramAbsListView);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.getListViewScrollY();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bkhe != null) {
      this.jdField_a_of_type_Bkhe.onScrollStateChanged(paramAbsListView, paramInt);
    }
    a(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Avdt.a(true);
      if (this.jdField_a_of_type_Asag != null) {
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Asag.c();
      }
    }
    for (;;)
    {
      return false;
      if ((i == 1) && (this.jdField_a_of_type_Boolean)) {
        if ((a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.getListViewScrollY() < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Asag != null))
        {
          this.jdField_a_of_type_Asag.n();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch scroll top pull down");
          }
        }
        else if ((a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView)) && (paramMotionEvent.getY() > this.jdField_a_of_type_Float) && (this.jdField_a_of_type_Asag != null))
        {
          this.jdField_a_of_type_Asag.n();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch no scroll top pull down");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryt
 * JD-Core Version:    0.7.0.1
 */