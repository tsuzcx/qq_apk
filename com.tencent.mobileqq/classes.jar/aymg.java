import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.widget.GridView;
import java.util.Collection;
import java.util.Map;

public class aymg
  extends AvatarWallPagerAdapter<GridView>
{
  protected LinearLayout.LayoutParams a;
  
  public aymg(aykx paramaykx, AvatarWallViewPager paramAvatarWallViewPager)
  {
    super(paramAvatarWallViewPager);
  }
  
  public View a(int paramInt, GridView paramGridView)
  {
    return aykx.a(this.jdField_a_of_type_Aykx, aykx.a(this.jdField_a_of_type_Aykx), paramInt);
  }
  
  public View a(boolean paramBoolean, int paramInt)
  {
    View localView = new View(this.jdField_a_of_type_Aykx.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(zps.a(this.jdField_a_of_type_Aykx.jdField_a_of_type_AndroidContentContext, 30.0F), zps.a(this.jdField_a_of_type_Aykx.jdField_a_of_type_AndroidContentContext, 1.5F));
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = zps.a(this.jdField_a_of_type_Aykx.jdField_a_of_type_AndroidContentContext, 2.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.rightMargin = zps.a(this.jdField_a_of_type_Aykx.jdField_a_of_type_AndroidContentContext, 2.0F);
    }
    localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    if (paramBoolean)
    {
      localView.setBackgroundColor(-1);
      return localView;
    }
    localView.setBackgroundColor(1728053247);
    return localView;
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Aykx.jdField_a_of_type_JavaUtilMap.values().remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymg
 * JD-Core Version:    0.7.0.1
 */