import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class besj
  extends RecyclerView.Adapter<besk>
  implements besl
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final TypedArray jdField_a_of_type_AndroidContentResTypedArray;
  private final besi jdField_a_of_type_Besi;
  private CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private HashMap<String, ArrayList<MessageRecord>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public besj(Context paramContext, besi parambesi, TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Besi = parambesi;
    this.jdField_a_of_type_AndroidContentResTypedArray = paramTypedArray;
    if (this.jdField_a_of_type_AndroidContentResTypedArray.getBoolean(8, false)) {
      a(new CalendarDay(System.currentTimeMillis()));
    }
  }
  
  public besk a(ViewGroup paramViewGroup, int paramInt)
  {
    return new besk(new SimpleMonthView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentResTypedArray), this);
  }
  
  public void a(int paramInt1, int paramInt2, ArrayList<MessageRecord> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "-" + paramInt2, paramArrayList);
    notifyDataSetChanged();
  }
  
  public void a(besk parambesk, int paramInt)
  {
    SimpleMonthView localSimpleMonthView = parambesk.a;
    HashMap localHashMap = new HashMap();
    parambesk = this.jdField_a_of_type_Besi.a();
    CalendarDay localCalendarDay1 = new CalendarDay(System.currentTimeMillis());
    CalendarDay localCalendarDay2 = new CalendarDay(localCalendarDay1.year, localCalendarDay1.month, 1);
    if (parambesk.getTimeInMillis() > localCalendarDay2.getTimeInMillis()) {
      parambesk = new CalendarDay(localCalendarDay1.year, localCalendarDay1.month - 1, 1);
    }
    for (;;)
    {
      int i = (parambesk.month + paramInt) % 12;
      int j = parambesk.year;
      paramInt = (parambesk.month + paramInt) / 12 + j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay != null)
      {
        localHashMap.put("selected_begin_year", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year));
        localHashMap.put("selected_begin_month", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month));
        localHashMap.put("selected_begin_day", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.day));
      }
      localSimpleMonthView.b();
      localHashMap.put("year", Integer.valueOf(paramInt));
      localHashMap.put("month", Integer.valueOf(i));
      localHashMap.put("week_start", Integer.valueOf(Calendar.getInstance().getFirstDayOfWeek()));
      localSimpleMonthView.setMonthParams(localHashMap);
      localSimpleMonthView.setMessageRecords((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt + "-" + i));
      localSimpleMonthView.setStartAndEndDate(parambesk, localCalendarDay1);
      localSimpleMonthView.invalidate();
      this.jdField_a_of_type_Besi.a(localSimpleMonthView, paramInt, i);
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
      this.jdField_a_of_type_Besi.a(paramCalendarDay, (MessageRecord)paramObject);
    }
  }
  
  public int getItemCount()
  {
    int i = this.jdField_a_of_type_Besi.a().year * 12 + this.jdField_a_of_type_Besi.a().month;
    int j = this.jdField_a_of_type_Besi.b().year * 12 + this.jdField_a_of_type_Besi.b().month;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besj
 * JD-Core Version:    0.7.0.1
 */