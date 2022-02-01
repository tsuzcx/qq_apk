import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bngt
  extends RecyclerView.Adapter<bngv>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bngw jdField_a_of_type_Bngw;
  private bngx jdField_a_of_type_Bngx;
  ArrayList<bngw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bngt(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public bngv a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bngv(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558489, paramViewGroup, false), this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(bngv parambngv, int paramInt)
  {
    parambngv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambngv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    int i = ((bngw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    parambngv.jdField_a_of_type_AndroidWidgetTextView.setText(((bngw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
    parambngv.jdField_a_of_type_AndroidViewView.setOnClickListener(new bngu(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(parambngv, paramInt, getItemId(paramInt));
  }
  
  public void a(bngx parambngx)
  {
    this.jdField_a_of_type_Bngx = parambngx;
  }
  
  public void a(List<bngw> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return super.getItemId(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngt
 * JD-Core Version:    0.7.0.1
 */