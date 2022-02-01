import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class bigd
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bige jdField_a_of_type_Bige;
  private ShareActionSheetV2 jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2;
  private List<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public bigd(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "ActionSheetItemAdapter() called with: context = [" + paramContext + "], objects = [" + paramList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private static void a(int paramInt, String paramString, ImageView paramImageView, bgsa parambgsa, bigd parambigd, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    switch (paramInt)
    {
    case 6000: 
    default: 
      paramInt = -1;
    }
    label90:
    while (paramInt != -1)
    {
      if (ShareActionSheetV2.a(paramShareActionSheetV2) == null) {
        ShareActionSheetV2.a(paramShareActionSheetV2, new SparseArray());
      }
      apss localapss = (apss)ShareActionSheetV2.a(paramShareActionSheetV2).get(paramInt);
      parambigd = localapss;
      if (localapss == null)
      {
        parambigd = new apss(paramShareActionSheetV2.a, paramInt);
        if (!bcnj.a()) {
          break label278;
        }
      }
      for (byte b = 1;; b = 3)
      {
        parambigd.a(b);
        parambigd.a();
        ShareActionSheetV2.a(paramShareActionSheetV2).put(paramInt, parambigd);
        paramImageView.setTag(paramString);
        parambigd.a(ShareActionSheetV2.a(paramShareActionSheetV2));
        paramString = parambigd.a(paramString, true);
        if (paramString == null) {
          break;
        }
        parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable = new BitmapDrawable(paramString);
        b(parambgsa);
        return;
        paramInt = 1;
        break label90;
        if ((TextUtils.isEmpty(parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.argus)) || (!parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.argus.contains("isNewTroop=1"))) {
          break label284;
        }
        paramInt = 113;
        break label90;
        paramInt = 101;
        break label90;
      }
      paramInt = 4;
    }
  }
  
  private void a(bgsa parambgsa)
  {
    if (parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 72) {
      a(parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.uinType, parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.uin, parambgsa.jdField_a_of_type_AndroidWidgetImageView, parambgsa, this, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2);
    }
  }
  
  private static void b(bgsa parambgsa)
  {
    if (parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        parambgsa.jdField_a_of_type_AndroidWidgetImageView.setBackground(parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        return;
      }
      parambgsa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
      return;
    }
    parambgsa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(parambgsa.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
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
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296728));
    }
    if (this.jdField_a_of_type_Bige == null) {
      this.jdField_a_of_type_Bige = new bige(paramViewGroup.getContext());
    }
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558935, paramViewGroup, false);
      paramView = new bgsa();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377352));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377353));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem = a(paramInt);
      if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem != null) {
        break;
      }
      QLog.e("ShareActionSheetV2", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bgsa)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    localView.setId(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296728);
    paramView.jdField_a_of_type_AndroidWidgetTextView.getPaint().setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298927));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label);
    int i = -8947849;
    Object localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
    if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable)
    {
      label299:
      ((TextView)localObject).setTextColor(i);
      if (!paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconNeedBg) {
        break label537;
      }
      if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable == null) {
        break label478;
      }
      localObject = paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable;
      label335:
      i = ((Drawable)localObject).getIntrinsicWidth();
      int k = ((Drawable)localObject).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= i) {
        break label497;
      }
      i = (int)((this.jdField_a_of_type_Int - i) / 2.0F);
      label371:
      if (this.jdField_a_of_type_Int > k) {
        j = (int)((this.jdField_a_of_type_Int - k) / 2.0F);
      }
      localObject = this.jdField_a_of_type_Bige.a((Drawable)localObject, i, j);
      if (!paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        break label503;
      }
      Drawable localDrawable = bige.a(this.jdField_a_of_type_Bige, (Drawable)localObject);
      localObject = this.jdField_a_of_type_Bige.a((Drawable)localObject, localDrawable);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label451:
      if (Build.VERSION.SDK_INT < 16) {
        break label526;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
    }
    for (;;)
    {
      break;
      i = 2138535799;
      break label299;
      label478:
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      break label335;
      label497:
      i = 0;
      break label371;
      label503:
      localObject = bige.b(this.jdField_a_of_type_Bige, (Drawable)localObject);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label451;
      label526:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    }
    label537:
    if ((paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 72) || (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 73)) {
      if (bcnj.a()) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837564);
      }
    }
    for (;;)
    {
      b(paramView);
      a(paramView);
      break;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837563);
      continue;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigd
 * JD-Core Version:    0.7.0.1
 */