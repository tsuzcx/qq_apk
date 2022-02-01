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

public class bpif
  extends RecyclerView.Adapter<bpii>
{
  private bpih jdField_a_of_type_Bpih;
  private String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bpii a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bpii(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558547, paramViewGroup, false));
  }
  
  public void a(bpih parambpih)
  {
    this.jdField_a_of_type_Bpih = parambpih;
  }
  
  public void a(bpii parambpii, int paramInt)
  {
    int j = 0;
    if (paramInt >= 1)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      parambpii.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor((String)localObject));
      parambpii.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambpii.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable);
      if ((localObject != null) && (((String)localObject).equals(this.jdField_a_of_type_JavaLangString)))
      {
        i = 1;
        localObject = parambpii.jdField_a_of_type_AndroidViewView;
        if (i == 0) {
          break label121;
        }
      }
      label121:
      for (i = j;; i = 4)
      {
        ((View)localObject).setVisibility(i);
        parambpii.itemView.setOnClickListener(new bpig(this, paramInt));
        EventCollector.getInstance().onRecyclerBindViewHolder(parambpii, paramInt, getItemId(paramInt));
        return;
        i = 0;
        break;
      }
    }
    parambpii.jdField_a_of_type_AndroidViewView.setVisibility(4);
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    Object localObject = parambpii.jdField_a_of_type_AndroidWidgetImageView;
    if (bool) {}
    for (int i = 2130837727;; i = 2130837728)
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
 * Qualified Name:     bpif
 * JD-Core Version:    0.7.0.1
 */