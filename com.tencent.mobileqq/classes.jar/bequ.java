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

public class bequ
  extends RecyclerView.Adapter<beqy>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private beqz jdField_a_of_type_Beqz;
  private boolean jdField_a_of_type_Boolean;
  private arhq[] jdField_a_of_type_ArrayOfArhq;
  
  public bequ(Context paramContext, beqz parambeqz, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Beqz = parambeqz;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfArhq[this.jdField_a_of_type_Int].jdField_a_of_type_Int;
  }
  
  @NonNull
  public beqy a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new beqy(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561005, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    bdla.b(null, "dc00898", "", "", "0X800B358", "0X800B358", 0, 0, "", "", "", "");
    paramView = bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(2131720154).setPositiveButton(2131720122, new beqx(this, paramInt)).setNegativeButton(2131720121, new beqw(this));
    paramView.show();
    ((TextView)paramView.findViewById(2131365644)).setGravity(17);
  }
  
  public void a(@NonNull beqy parambeqy, int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfArhq == null) || (this.jdField_a_of_type_ArrayOfArhq.length == 0))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambeqy, paramInt, getItemId(paramInt));
      return;
    }
    if (this.jdField_a_of_type_Int == paramInt)
    {
      parambeqy.a.setSelected(true);
      parambeqy.a.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
      parambeqy.a.setText(this.jdField_a_of_type_ArrayOfArhq[paramInt].jdField_a_of_type_JavaLangString);
      parambeqy.a.setOnClickListener(new beqv(this, parambeqy));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("HorizontalAdapter", 2, "onBindViewHolder() called with: position = [" + paramInt + "], holder.templateTitle = [" + parambeqy.a + "], mTemplates[position].title = [" + this.jdField_a_of_type_ArrayOfArhq[paramInt].jdField_a_of_type_JavaLangString + "]");
      break;
      parambeqy.a.setSelected(false);
      parambeqy.a.setTypeface(Typeface.defaultFromStyle(0));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(arhq[] paramArrayOfarhq)
  {
    this.jdField_a_of_type_ArrayOfArhq = paramArrayOfarhq;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_ArrayOfArhq == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfArhq.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bequ
 * JD-Core Version:    0.7.0.1
 */