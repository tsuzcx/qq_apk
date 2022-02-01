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

public class bogk
  extends RecyclerView.Adapter<bogn>
{
  private bogm jdField_a_of_type_Bogm;
  private String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bogn a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bogn(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558545, paramViewGroup, false));
  }
  
  public void a(bogm parambogm)
  {
    this.jdField_a_of_type_Bogm = parambogm;
  }
  
  public void a(bogn parambogn, int paramInt)
  {
    int j = 0;
    if (paramInt >= 1)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      parambogn.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor((String)localObject));
      parambogn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambogn.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable);
      if ((localObject != null) && (((String)localObject).equals(this.jdField_a_of_type_JavaLangString)))
      {
        i = 1;
        localObject = parambogn.jdField_a_of_type_AndroidViewView;
        if (i == 0) {
          break label121;
        }
      }
      label121:
      for (i = j;; i = 4)
      {
        ((View)localObject).setVisibility(i);
        parambogn.itemView.setOnClickListener(new bogl(this, paramInt));
        EventCollector.getInstance().onRecyclerBindViewHolder(parambogn, paramInt, getItemId(paramInt));
        return;
        i = 0;
        break;
      }
    }
    parambogn.jdField_a_of_type_AndroidViewView.setVisibility(4);
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    Object localObject = parambogn.jdField_a_of_type_AndroidWidgetImageView;
    if (bool) {}
    for (int i = 2130837721;; i = 2130837722)
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
 * Qualified Name:     bogk
 * JD-Core Version:    0.7.0.1
 */