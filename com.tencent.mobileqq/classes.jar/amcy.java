import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.List;

public class amcy<T>
  extends arrz<T>
  implements View.OnClickListener
{
  private DragSortListView a;
  
  public amcy(Context paramContext, List<T> paramList, DragSortListView paramDragSortListView)
  {
    super(paramContext, paramList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = paramDragSortListView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561195, null);; localView = paramView)
    {
      localView.setVisibility(0);
      localView.findViewById(2131377341).setVisibility(8);
      TextView localTextView = (TextView)localView.findViewById(2131367650);
      Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localTextView.setText(localGroups.group_name);
      ViewCompat.setImportantForAccessibility(localView.findViewById(2131367654), 1);
      localView.setContentDescription(localGroups.group_name + anni.a(2131704134));
      if ((VersionUtils.isOreo()) && (AppSetting.c)) {
        localView.setOnClickListener(this);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
  }
  
  public void onClick(View paramView)
  {
    if (AppSetting.c) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcy
 * JD-Core Version:    0.7.0.1
 */