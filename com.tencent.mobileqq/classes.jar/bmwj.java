import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;

public class bmwj
  extends bhyb
{
  public static final TroopBarPOI a;
  protected LayoutInflater a;
  protected ArrayList<TroopBarPOI> a;
  protected TroopBarPOI b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", alpo.a(2131711374), 0, "", 0, "");
  }
  
  public bmwj(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(ArrayList<TroopBarPOI> paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (paramTroopBarPOI != null) {
      this.b = new TroopBarPOI(paramTroopBarPOI);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopBarPOI localTroopBarPOI;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561527, null);
      paramViewGroup = new bmwk();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376322));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369298));
      paramView.setTag(paramViewGroup);
      localTroopBarPOI = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopBarPOI.c);
      paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      if (!localTroopBarPOI.equals(this.b)) {
        break label135;
      }
    }
    label135:
    for (paramInt = 0;; paramInt = 8)
    {
      paramViewGroup.setVisibility(paramInt);
      paramView.setContentDescription(localTroopBarPOI.c);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      return paramView;
      paramViewGroup = (bmwk)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwj
 * JD-Core Version:    0.7.0.1
 */