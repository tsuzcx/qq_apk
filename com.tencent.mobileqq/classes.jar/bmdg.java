import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bmdg
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<uqf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public bmdg(List<uqf> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void a(int paramInt, View paramView)
  {
    uqf localuqf = a(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131377476);
    ImageView localImageView = (ImageView)paramView.findViewById(2131377466);
    View localView = paramView.findViewById(2131377474);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131377471);
    localTextView.setText(localuqf.b);
    if (this.b == 0) {
      this.b = xod.a(paramView.getContext(), 60.0F);
    }
    xod.a(localImageView, localuqf.h, this.b, this.b, paramView.getContext().getResources().getDrawable(2130846232), null);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label186;
      }
      localView.setVisibility(0);
      paramView.setContentDescription(alpo.a(2131715262) + localuqf.b + "’");
    }
    for (;;)
    {
      if (localuqf.c) {
        break label233;
      }
      localProgressBar.setVisibility(0);
      localTextView.setVisibility(8);
      return;
      paramInt = 0;
      break;
      label186:
      localView.setVisibility(8);
      paramView.setContentDescription(alpo.a(2131715263) + localuqf.b + alpo.a(2131715261));
    }
    label233:
    localProgressBar.setVisibility(8);
    localTextView.setVisibility(0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public uqf a(int paramInt)
  {
    return (uqf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560745, paramViewGroup, false);
      localView.setFocusable(true);
    }
    a(paramInt, localView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdg
 * JD-Core Version:    0.7.0.1
 */