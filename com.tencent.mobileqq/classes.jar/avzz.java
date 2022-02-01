import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class avzz
  implements View.OnClickListener, awat, awau, awav
{
  private long jdField_a_of_type_Long;
  public Context a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  awas jdField_a_of_type_Awas;
  MultiCardFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
  private Long jdField_a_of_type_JavaLangLong;
  public boolean a;
  
  private void b(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379587);
      if (localView != null) {
        if (!paramBoolean) {
          break label33;
        }
      }
    }
    label33:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    if (this.jdField_a_of_type_Long != paramLong) {}
    do
    {
      return;
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        b(true);
        a(null);
        return;
      }
      b(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment == null);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(paramArrayList, null, null);
  }
  
  public void a(long paramLong, HashMap<Long, String> paramHashMap)
  {
    if ((this.jdField_a_of_type_Long != paramLong) || (paramHashMap == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(null, null, paramHashMap);
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    }
  }
  
  public void a(ArrayList<Long> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPreLoadData : ");
          localStringBuilder.append(paramArrayList.size());
          localStringBuilder.append("  ");
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            localStringBuilder.append((Long)localIterator.next());
            localStringBuilder.append(" ");
          }
          QLog.d("MultiCardContainer", 2, "onPreLoadData : " + localStringBuilder.toString());
        }
      } while (this.jdField_a_of_type_Awas == null);
      if (paramBoolean1) {
        this.jdField_a_of_type_Awas.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, paramArrayList, this);
      }
    } while (!paramBoolean2);
    this.jdField_a_of_type_Awas.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, paramArrayList, this);
  }
  
  public void a(HashMap<Long, IntimateInfo> paramHashMap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(null, paramHashMap, null);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363264: 
        a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzz
 * JD-Core Version:    0.7.0.1
 */