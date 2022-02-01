import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.adapter.PictureAdapter.1;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class amef
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public amef(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.endsWith("video=1");
  }
  
  public boolean a(List<String> paramList)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramList == this.jdField_a_of_type_JavaUtilList) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramList == null);
        bool1 = bool2;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      bool1 = bool2;
    } while (paramList.size() != this.jdField_a_of_type_JavaUtilList.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label101;
      }
      bool1 = bool2;
      if (!((String)paramList.get(i)).equals(this.jdField_a_of_type_JavaUtilList.get(i))) {
        break;
      }
      i += 1;
    }
    label101:
    return true;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return Math.min(this.jdField_a_of_type_JavaUtilList.size(), 4);
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt < 4)) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt < 4)) {
      return paramInt;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new ameg();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558861, null);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)localView.findViewById(2131377616));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368613);
      localView.setTag(paramView);
      localObject = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.post(new PictureAdapter.1(this, paramView, (String)localObject));
      if ((this.jdField_a_of_type_Boolean) || (!a((String)localObject))) {
        break label152;
      }
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ameg)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label152:
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amef
 * JD-Core Version:    0.7.0.1
 */