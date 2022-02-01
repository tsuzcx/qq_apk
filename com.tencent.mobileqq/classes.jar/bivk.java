import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class bivk
  extends RecyclerView.Adapter<bivl>
  implements bivm
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final TypedArray jdField_a_of_type_AndroidContentResTypedArray;
  private final bivj jdField_a_of_type_Bivj;
  private CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private HashMap<String, ArrayList<MessageRecord>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bivk(Context paramContext, bivj parambivj, TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bivj = parambivj;
    this.jdField_a_of_type_AndroidContentResTypedArray = paramTypedArray;
    if (this.jdField_a_of_type_AndroidContentResTypedArray.getBoolean(8, false)) {
      a(new CalendarDay(System.currentTimeMillis()));
    }
  }
  
  public bivl a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bivl(new SimpleMonthView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentResTypedArray), this);
  }
  
  public void a(int paramInt1, int paramInt2, ArrayList<MessageRecord> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "-" + paramInt2, paramArrayList);
    notifyDataSetChanged();
  }
  
  public void a(bivl parambivl, int paramInt)
  {
    SimpleMonthView localSimpleMonthView = parambivl.a;
    HashMap localHashMap = new HashMap();
    CalendarDay localCalendarDay1 = this.jdField_a_of_type_Bivj.a();
    CalendarDay localCalendarDay2 = new CalendarDay(System.currentTimeMillis());
    CalendarDay localCalendarDay3 = new CalendarDay(localCalendarDay2.year, localCalendarDay2.month, 1);
    if (localCalendarDay1.getTimeInMillis() > localCalendarDay3.getTimeInMillis()) {
      localCalendarDay1 = new CalendarDay(localCalendarDay2.year, localCalendarDay2.month - 1, 1);
    }
    for (;;)
    {
      int i = (localCalendarDay1.month + paramInt) % 12;
      int j = localCalendarDay1.year;
      j = (localCalendarDay1.month + paramInt) / 12 + j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay != null)
      {
        localHashMap.put("selected_begin_year", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year));
        localHashMap.put("selected_begin_month", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month));
        localHashMap.put("selected_begin_day", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.day));
      }
      localSimpleMonthView.b();
      localHashMap.put("year", Integer.valueOf(j));
      localHashMap.put("month", Integer.valueOf(i));
      localHashMap.put("week_start", Integer.valueOf(Calendar.getInstance().getFirstDayOfWeek()));
      localSimpleMonthView.setMonthParams(localHashMap);
      localSimpleMonthView.setMessageRecords((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(j + "-" + i));
      localSimpleMonthView.setStartAndEndDate(localCalendarDay1, localCalendarDay2);
      localSimpleMonthView.invalidate();
      this.jdField_a_of_type_Bivj.a(localSimpleMonthView, j, i);
      EventCollector.getInstance().onRecyclerBindViewHolder(parambivl, paramInt, getItemId(paramInt));
      return;
    }
  }
  
  protected void a(CalendarDay paramCalendarDay)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = paramCalendarDay;
    notifyDataSetChanged();
  }
  
  public void a(SimpleMonthView paramSimpleMonthView, CalendarDay paramCalendarDay, Object paramObject)
  {
    if ((paramCalendarDay != null) && (paramObject != null) && ((paramObject instanceof MessageRecord)))
    {
      a(paramCalendarDay);
      this.jdField_a_of_type_Bivj.a(paramCalendarDay, (MessageRecord)paramObject);
    }
  }
  
  public int getItemCount()
  {
    int i = this.jdField_a_of_type_Bivj.a().year * 12 + this.jdField_a_of_type_Bivj.a().month;
    int j = this.jdField_a_of_type_Bivj.b().year * 12 + this.jdField_a_of_type_Bivj.b().month;
    if (i == j) {
      return 2;
    }
    return j - i + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivk
 * JD-Core Version:    0.7.0.1
 */