import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdjr
  extends RecyclerView.Adapter<bdjv>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private bdjw jdField_a_of_type_Bdjw;
  private boolean jdField_a_of_type_Boolean;
  private aqej[] jdField_a_of_type_ArrayOfAqej;
  
  public bdjr(Context paramContext, bdjw parambdjw, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bdjw = parambdjw;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfAqej[this.jdField_a_of_type_Int].jdField_a_of_type_Int;
  }
  
  @NonNull
  public bdjv a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bdjv(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560944, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    bcef.b(null, "dc00898", "", "", "0X800B358", "0X800B358", 0, 0, "", "", "", "");
    paramView = bfur.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(2131719701).setPositiveButton(2131719669, new bdju(this, paramInt)).setNegativeButton(2131719668, new bdjt(this));
    paramView.show();
    ((TextView)paramView.findViewById(2131365552)).setGravity(17);
  }
  
  public void a(@NonNull bdjv parambdjv, int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfAqej == null) || (this.jdField_a_of_type_ArrayOfAqej.length == 0))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambdjv, paramInt, getItemId(paramInt));
      return;
    }
    if (this.jdField_a_of_type_Int == paramInt)
    {
      parambdjv.a.setSelected(true);
      parambdjv.a.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
      parambdjv.a.setText(this.jdField_a_of_type_ArrayOfAqej[paramInt].jdField_a_of_type_JavaLangString);
      parambdjv.a.setOnClickListener(new bdjs(this, parambdjv));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("HorizontalAdapter", 2, "onBindViewHolder() called with: position = [" + paramInt + "], holder.templateTitle = [" + parambdjv.a + "], mTemplates[position].title = [" + this.jdField_a_of_type_ArrayOfAqej[paramInt].jdField_a_of_type_JavaLangString + "]");
      break;
      parambdjv.a.setSelected(false);
      parambdjv.a.setTypeface(Typeface.defaultFromStyle(0));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(aqej[] paramArrayOfaqej)
  {
    this.jdField_a_of_type_ArrayOfAqej = paramArrayOfaqej;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_ArrayOfAqej == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfAqej.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjr
 * JD-Core Version:    0.7.0.1
 */