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
import java.util.ArrayList;
import java.util.List;

public class apnf
  extends RecyclerView.Adapter<apni>
{
  float jdField_a_of_type_Float = 1.0F;
  Context jdField_a_of_type_AndroidContentContext;
  azwg jdField_a_of_type_Azwg;
  List<Pair<String, String>> jdField_a_of_type_JavaUtilList;
  
  public apnf(Context paramContext, azwg paramazwg, float paramFloat)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Azwg = paramazwg;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public apni a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == apnb.b)
    {
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165901);
      paramInt = i;
      if (this.jdField_a_of_type_Float != 0.0F) {
        paramInt = (int)(i / this.jdField_a_of_type_Float);
      }
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      return new apni(paramViewGroup);
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493500, paramViewGroup, false);
    if ((this.jdField_a_of_type_Float != 0.0F) && (paramViewGroup != null))
    {
      Object localObject1 = paramViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = aciy.a(80.0F / this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (ImageView)paramViewGroup.findViewById(2131302411);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((ImageView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          paramInt = aciy.a(40.0F / this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((ViewGroup.LayoutParams)localObject2).width = paramInt;
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = (TextView)paramViewGroup.findViewById(2131312700);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setTextSize(2, (int)(10.0D / this.jdField_a_of_type_Float));
        localObject2 = (ViewGroup.MarginLayoutParams)((TextView)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).setMargins((int)(((ViewGroup.MarginLayoutParams)localObject2).leftMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).topMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).rightMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).bottomMargin / this.jdField_a_of_type_Float));
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    return new apnh(paramViewGroup);
  }
  
  public void a(apni paramapni, int paramInt)
  {
    if (paramapni.a == apnb.b) {}
    Pair localPair;
    do
    {
      do
      {
        return;
      } while (paramapni.a != apnb.a);
      paramInt -= 1;
      if (paramInt < 0) {
        QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "type normal in wrong index");
      }
      localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while (!(paramapni instanceof apnh));
    ((apnh)paramapni).a((String)localPair.first, (String)localPair.second, this.jdField_a_of_type_Azwg);
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
      return apnb.b;
    }
    return apnb.a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new apng(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apnf
 * JD-Core Version:    0.7.0.1
 */