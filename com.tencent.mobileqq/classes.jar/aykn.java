import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import java.util.ArrayList;

public class aykn
  extends BaseAdapter
  implements azwh
{
  private Context jdField_a_of_type_AndroidContentContext;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public aykn(NewTroopContactView paramNewTroopContactView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844056);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.size() > 0))
      {
        String str = ((ResultRecord)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.get(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.size() - 1)).jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(str))
        {
          NewTroopContactView.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView, str);
          this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_Ayju.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.b(false);
          NewTroopContactView.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getLayoutInflater().inflate(2131493590, null);
    }
    paramViewGroup.setTag(localResultRecord);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131300226);
    if (paramInt == getCount() - 1) {
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localImageView.setImageDrawable(paramView);
        label78:
        localImageView.setBackgroundDrawable(null);
        if (localResultRecord.jdField_a_of_type_Int != 4) {
          break label174;
        }
      }
    }
    TextView localTextView;
    label174:
    for (paramInt = 11;; paramInt = 1)
    {
      localTextView = (TextView)paramViewGroup.findViewById(2131312386);
      if (localResultRecord.jdField_a_of_type_Int != 5) {
        break label179;
      }
      localImageView.setImageResource(2130841491);
      localTextView.setVisibility(0);
      localTextView.setText(babh.a(localResultRecord.b));
      if (AppSetting.c) {
        localImageView.setContentDescription(localResultRecord.b);
      }
      return paramViewGroup;
      paramView = null;
      break;
      localImageView.setImageDrawable(null);
      break label78;
    }
    label179:
    String str = localResultRecord.jdField_a_of_type_JavaLangString;
    paramView = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_Azwg.a(paramInt, str);
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_Azwg.a(str, paramInt, true);
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    for (;;)
    {
      localImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getResources(), paramView));
      localTextView.setVisibility(8);
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView == null) {}
    for (;;)
    {
      return;
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView.getChildAt(paramInt1);
        Object localObject = localView.getTag();
        if ((localObject != null) && ((localObject instanceof ResultRecord)) && (paramString.equals(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))) {
          ((ImageView)localView.findViewById(2131300226)).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getResources(), paramBitmap));
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aykn
 * JD-Core Version:    0.7.0.1
 */