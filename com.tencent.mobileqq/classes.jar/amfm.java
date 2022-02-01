import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class amfm
  extends BaseAdapter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new amfn(this);
  private auvo jdField_a_of_type_Auvo;
  protected QQAppInterface a;
  protected List<Object> a;
  
  public amfm(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, auvo paramauvo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramFragmentActivity.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramFragmentActivity.getResources().getDrawable(2130845306);
    this.jdField_a_of_type_Auvo = paramauvo;
  }
  
  public void a(List<AppletItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (AppletItem)getItem(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    label122:
    boolean bool;
    if (paramView == null)
    {
      localObject1 = new amfo();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561482, paramViewGroup, false);
      ((amfo)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362877));
      ((amfo)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362876));
      ((amfo)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362878));
      ((amfo)localObject1).jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131362879));
      paramView.setTag(localObject1);
      ((amfo)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839496);
      Object localObject3 = ((amfo)localObject1).jdField_a_of_type_ComTencentWidgetSwitch;
      if (((AppletItem)localObject2).b() != 1) {
        break label327;
      }
      bool = true;
      label151:
      ((Switch)localObject3).setChecked(bool);
      ((amfo)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      ((amfo)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("AppletsListAdapter", 2, ((AppletItem)localObject2).toString());
      }
      ((amfo)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((AppletItem)localObject2).a());
      ((amfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem = ((AppletItem)localObject2);
      if (TextUtils.isEmpty(((AppletItem)localObject2).b())) {
        break label333;
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = AIOUtils.dp2px(((amfo)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth(), this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject2 = URLDrawable.getDrawable(((AppletItem)localObject2).b(), (URLDrawable.URLDrawableOptions)localObject3);
      ((amfo)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      localObject1 = (amfo)paramView.getTag();
      break label122;
      label327:
      bool = false;
      break label151;
      label333:
      ((amfo)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfm
 * JD-Core Version:    0.7.0.1
 */