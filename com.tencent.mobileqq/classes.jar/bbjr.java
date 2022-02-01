import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class bbjr
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bbjs jdField_a_of_type_Bbjs;
  private List<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public bbjr(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localActionSheetItem = null;
      return localActionSheetItem;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localActionSheetItem != null)
      {
        k = j;
        if (localActionSheetItem.visibility == 0) {
          k = j + 1;
        }
      }
      if (k == paramInt) {
        break;
      }
      i += 1;
      j = k;
    }
    label89:
    return null;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      if ((localActionSheetItem == null) || (localActionSheetItem.visibility != 0)) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      this.jdField_a_of_type_AndroidContentResResources = paramViewGroup.getContext().getResources();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296796));
    }
    if (this.jdField_a_of_type_Bbjs == null) {
      this.jdField_a_of_type_Bbjs = new bbjs(paramViewGroup.getContext());
    }
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558969, paramViewGroup, false);
      paramView = new ShareActionSheetBuilder.ActionSheetItemViewHolder();
      paramView.vIcon = ((ImageView)localView.findViewById(2131377530));
      paramView.vLabel = ((TextView)localView.findViewById(2131377531));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.sheetItem = a(paramInt);
      if (paramView.sheetItem != null) {
        break;
      }
      QLog.e("ShareActionSheet", 2, "ShareActionSheet.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    localView.setId(paramView.sheetItem.id);
    paramView.vLabel.setText(bbjp.a(paramView.sheetItem.label, 6));
    int i = -8947849;
    Object localObject = paramView.vLabel;
    if (paramView.sheetItem.enable)
    {
      label256:
      ((TextView)localObject).setTextColor(i);
      if (!paramView.sheetItem.iconNeedBg) {
        break label493;
      }
      if (paramView.sheetItem.iconDrawable == null) {
        break label434;
      }
      localObject = paramView.sheetItem.iconDrawable;
      label292:
      i = ((Drawable)localObject).getIntrinsicWidth();
      int k = ((Drawable)localObject).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= i) {
        break label453;
      }
      i = (int)((this.jdField_a_of_type_Int - i) / 2.0F);
      label328:
      if (this.jdField_a_of_type_Int > k) {
        j = (int)((this.jdField_a_of_type_Int - k) / 2.0F);
      }
      localObject = this.jdField_a_of_type_Bbjs.a((Drawable)localObject, i, j);
      if (!paramView.sheetItem.enable) {
        break label459;
      }
      Drawable localDrawable = bbjs.a(this.jdField_a_of_type_Bbjs, (Drawable)localObject);
      localObject = this.jdField_a_of_type_Bbjs.a((Drawable)localObject, localDrawable);
      paramView.vIcon.setImageDrawable((Drawable)localObject);
      label408:
      if (Build.VERSION.SDK_INT < 16) {
        break label482;
      }
      paramView.vIcon.setBackground(null);
    }
    for (;;)
    {
      break;
      i = 2138535799;
      break label256;
      label434:
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramView.sheetItem.icon);
      break label292;
      label453:
      i = 0;
      break label328;
      label459:
      localObject = bbjs.b(this.jdField_a_of_type_Bbjs, (Drawable)localObject);
      paramView.vIcon.setImageDrawable((Drawable)localObject);
      break label408;
      label482:
      paramView.vIcon.setBackgroundDrawable(null);
      continue;
      label493:
      paramView.vIcon.setImageResource(2130837562);
      if (paramView.sheetItem.iconDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramView.vIcon.setBackground(paramView.sheetItem.iconDrawable);
        } else {
          paramView.vIcon.setBackgroundDrawable(paramView.sheetItem.iconDrawable);
        }
      }
      else {
        paramView.vIcon.setBackgroundResource(paramView.sheetItem.icon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjr
 * JD-Core Version:    0.7.0.1
 */