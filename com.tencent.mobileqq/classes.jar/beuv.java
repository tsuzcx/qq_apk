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
import java.util.Iterator;
import java.util.List;

public class beuv
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private beuw jdField_a_of_type_Beuw;
  private ShareActionSheetV2 jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2;
  private List<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public beuv(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "ActionSheetItemAdapter() called with: context = [" + paramContext + "], objects = [" + paramList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private static void a(int paramInt, String paramString, ImageView paramImageView, bdip parambdip, beuv parambeuv, ShareActionSheetV2 paramShareActionSheetV2)
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
    label82:
    while (paramInt != -1)
    {
      if (ShareActionSheetV2.a(paramShareActionSheetV2) == null) {
        ShareActionSheetV2.a(paramShareActionSheetV2, new SparseArray());
      }
      anoe localanoe = (anoe)ShareActionSheetV2.a(paramShareActionSheetV2).get(paramInt);
      parambeuv = localanoe;
      if (localanoe == null)
      {
        parambeuv = new anoe(paramShareActionSheetV2.a, paramInt);
        if (!azib.a()) {
          break label270;
        }
      }
      for (byte b = 1;; b = 3)
      {
        parambeuv.a(b);
        parambeuv.a();
        ShareActionSheetV2.a(paramShareActionSheetV2).put(paramInt, parambeuv);
        paramImageView.setTag(paramString);
        parambeuv.a(ShareActionSheetV2.a(paramShareActionSheetV2));
        paramString = parambeuv.a(paramString, true);
        if (paramString == null) {
          break;
        }
        parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable = new BitmapDrawable(paramString);
        b(parambdip);
        return;
        paramInt = 1;
        break label82;
        if ((TextUtils.isEmpty(parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.argus)) || (!parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.argus.contains("isNewTroop=1"))) {
          break label276;
        }
        paramInt = 113;
        break label82;
        paramInt = 101;
        break label82;
      }
      paramInt = 4;
    }
  }
  
  private void a(bdip parambdip)
  {
    if (parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 72) {
      a(parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.uinType, parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.uin, parambdip.jdField_a_of_type_AndroidWidgetImageView, parambdip, this, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2);
    }
  }
  
  private static void b(bdip parambdip)
  {
    if (parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        parambdip.jdField_a_of_type_AndroidWidgetImageView.setBackground(parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        return;
      }
      parambdip.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
      return;
    }
    parambdip.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(parambdip.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
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
    int i = 0;
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      this.jdField_a_of_type_AndroidContentResResources = paramViewGroup.getContext().getResources();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296685));
    }
    if (this.jdField_a_of_type_Beuw == null) {
      this.jdField_a_of_type_Beuw = new beuw(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558863, paramViewGroup, false);
      paramViewGroup = new bdip();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376507));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376508));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem = a(paramInt);
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem != null) {
        break;
      }
      QLog.e("ShareActionSheetV2", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (bdip)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296685);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getPaint().setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298844));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label);
    paramInt = -8947849;
    Object localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable)
    {
      ((TextView)localObject).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconNeedBg) {
        break label498;
      }
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable == null) {
        break label441;
      }
      localObject = paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable;
      label305:
      paramInt = ((Drawable)localObject).getIntrinsicWidth();
      int j = ((Drawable)localObject).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= paramInt) {
        break label460;
      }
      paramInt = (int)((this.jdField_a_of_type_Int - paramInt) / 2.0F);
      label337:
      if (this.jdField_a_of_type_Int > j) {
        i = (int)((this.jdField_a_of_type_Int - j) / 2.0F);
      }
      localObject = this.jdField_a_of_type_Beuw.a((Drawable)localObject, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        break label465;
      }
      Drawable localDrawable = beuw.a(this.jdField_a_of_type_Beuw, (Drawable)localObject);
      localObject = this.jdField_a_of_type_Beuw.a((Drawable)localObject, localDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label488;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      return paramView;
      paramInt = 2138535799;
      break;
      label441:
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      break label305;
      label460:
      paramInt = 0;
      break label337;
      label465:
      localObject = beuw.b(this.jdField_a_of_type_Beuw, (Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label488:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    return paramView;
    label498:
    if ((paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 72) || (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 73)) {
      if (azib.a()) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837552);
      }
    }
    for (;;)
    {
      b(paramViewGroup);
      a(paramViewGroup);
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837551);
      continue;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuv
 * JD-Core Version:    0.7.0.1
 */