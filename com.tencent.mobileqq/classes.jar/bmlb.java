import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bmlb
  extends RecyclerView.Adapter<bmle>
{
  private bmld jdField_a_of_type_Bmld;
  private String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bmle a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bmle(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558546, paramViewGroup, false));
  }
  
  public void a(bmld parambmld)
  {
    this.jdField_a_of_type_Bmld = parambmld;
  }
  
  public void a(bmle parambmle, int paramInt)
  {
    if (paramInt >= 1)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      parambmle.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor((String)localObject));
      parambmle.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambmle.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable);
      bool = ((String)localObject).equals(this.jdField_a_of_type_JavaLangString);
      localObject = parambmle.jdField_a_of_type_AndroidViewView;
      if (bool) {}
      for (i = 0;; i = 4)
      {
        ((View)localObject).setVisibility(i);
        parambmle.itemView.setOnClickListener(new bmlc(this, paramInt));
        EventCollector.getInstance().onRecyclerBindViewHolder(parambmle, paramInt, getItemId(paramInt));
        return;
      }
    }
    parambmle.jdField_a_of_type_AndroidViewView.setVisibility(4);
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    Object localObject = parambmle.jdField_a_of_type_AndroidWidgetImageView;
    if (bool) {}
    for (int i = 2130837738;; i = 2130837739)
    {
      ((ImageView)localObject).setImageResource(i);
      break;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_JavaUtilList.remove("#FFFFFF");
    }
    this.jdField_a_of_type_JavaUtilList.add("#FFFFFF");
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlb
 * JD-Core Version:    0.7.0.1
 */