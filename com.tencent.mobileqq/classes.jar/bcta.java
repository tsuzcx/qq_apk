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

public class bcta
  extends RecyclerView.Adapter<bctb>
  implements bctc
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final TypedArray jdField_a_of_type_AndroidContentResTypedArray;
  private final bcsz jdField_a_of_type_Bcsz;
  private CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private HashMap<String, ArrayList<MessageRecord>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bcta(Context paramContext, bcsz parambcsz, TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bcsz = parambcsz;
    this.jdField_a_of_type_AndroidContentResTypedArray = paramTypedArray;
    if (this.jdField_a_of_type_AndroidContentResTypedArray.getBoolean(8, false)) {
      a(new CalendarDay(System.currentTimeMillis()));
    }
  }
  
  public bctb a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bctb(new SimpleMonthView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentResTypedArray), this);
  }
  
  public void a(int paramInt1, int paramInt2, ArrayList<MessageRecord> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "-" + paramInt2, paramArrayList);
    notifyDataSetChanged();
  }
  
  public void a(bctb parambctb, int paramInt)
  {
    SimpleMonthView localSimpleMonthView = parambctb.a;
    HashMap localHashMap = new HashMap();
    parambctb = this.jdField_a_of_type_Bcsz.a();
    CalendarDay localCalendarDay1 = new CalendarDay(System.currentTimeMillis());
    CalendarDay localCalendarDay2 = new CalendarDay(localCalendarDay1.year, localCalendarDay1.month, 1);
    if (parambctb.getTimeInMillis() > localCalendarDay2.getTimeInMillis()) {
      parambctb = new CalendarDay(localCalendarDay1.year, localCalendarDay1.month - 1, 1);
    }
    for (;;)
    {
      int i = (parambctb.month + paramInt) % 12;
      int j = parambctb.year;
      paramInt = (parambctb.month + paramInt) / 12 + j;
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
      localSimpleMonthView.setStartAndEndDate(parambctb, localCalendarDay1);
      localSimpleMonthView.invalidate();
      this.jdField_a_of_type_Bcsz.a(localSimpleMonthView, paramInt, i);
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
      this.jdField_a_of_type_Bcsz.a(paramCalendarDay, (MessageRecord)paramObject);
    }
  }
  
  public int getItemCount()
  {
    int i = this.jdField_a_of_type_Bcsz.a().year * 12 + this.jdField_a_of_type_Bcsz.a().month;
    int j = this.jdField_a_of_type_Bcsz.b().year * 12 + this.jdField_a_of_type_Bcsz.b().month;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcta
 * JD-Core Version:    0.7.0.1
 */