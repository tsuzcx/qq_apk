import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class avdf
  extends RecyclerView.Adapter<avdi>
{
  float jdField_a_of_type_Float = 1.0F;
  Context jdField_a_of_type_AndroidContentContext;
  aoof jdField_a_of_type_Aoof;
  List<Pair<String, String>> jdField_a_of_type_JavaUtilList;
  
  public avdf(Context paramContext, aoof paramaoof, float paramFloat)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public avdi a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == avdb.b)
    {
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297057);
      paramInt = i;
      if (this.jdField_a_of_type_Float != 0.0F) {
        paramInt = (int)(i / this.jdField_a_of_type_Float);
      }
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      return new avdi(paramViewGroup);
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559178, paramViewGroup, false);
    if ((this.jdField_a_of_type_Float != 0.0F) && (paramViewGroup != null))
    {
      Object localObject1 = paramViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = agej.a(80.0F / this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (ImageView)paramViewGroup.findViewById(2131368580);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((ImageView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          paramInt = agej.a(40.0F / this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((ViewGroup.LayoutParams)localObject2).width = paramInt;
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = (TextView)paramViewGroup.findViewById(2131380309);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setTextSize(2, (int)(10.0D / this.jdField_a_of_type_Float));
        localObject2 = (ViewGroup.MarginLayoutParams)((TextView)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).setMargins((int)(((ViewGroup.MarginLayoutParams)localObject2).leftMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).topMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).rightMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).bottomMargin / this.jdField_a_of_type_Float));
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    return new avdh(paramViewGroup);
  }
  
  public void a(avdi paramavdi, int paramInt)
  {
    if (paramavdi.a == avdb.b) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramavdi, paramInt, getItemId(paramInt));
      return;
      if (paramavdi.a == avdb.a)
      {
        int i = paramInt - 1;
        if (i < 0) {
          QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "type normal in wrong index");
        }
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((paramavdi instanceof avdh)) {
          ((avdh)paramavdi).a((String)localPair.first, (String)localPair.second, this.jdField_a_of_type_Aoof);
        }
      }
    }
  }
  
  public void a(List<Pair<String, String>> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return avdb.b;
    }
    return avdb.a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new avdg(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdf
 * JD-Core Version:    0.7.0.1
 */