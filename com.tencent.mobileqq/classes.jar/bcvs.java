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
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class bcvs
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bcvt jdField_a_of_type_Bcvt;
  private ShareActionSheetV2 jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2;
  private List<bbjs> jdField_a_of_type_JavaUtilList;
  
  public bcvs(Context paramContext, List<bbjs> paramList, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "ActionSheetItemAdapter() called with: context = [" + paramContext + "], objects = [" + paramList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private static void a(int paramInt, String paramString, ImageView paramImageView, bbjv parambbjv, bcvs parambcvs, ShareActionSheetV2 paramShareActionSheetV2)
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
    label74:
    while (paramInt != -1)
    {
      if (ShareActionSheetV2.a(paramShareActionSheetV2) == null) {
        ShareActionSheetV2.a(paramShareActionSheetV2, new SparseArray());
      }
      alxf localalxf = (alxf)ShareActionSheetV2.a(paramShareActionSheetV2).get(paramInt);
      parambcvs = localalxf;
      if (localalxf == null)
      {
        parambcvs = new alxf(paramShareActionSheetV2.a, paramInt);
        if (!axmv.a()) {
          break label262;
        }
      }
      for (byte b = 1;; b = 3)
      {
        parambcvs.a(b);
        parambcvs.a();
        ShareActionSheetV2.a(paramShareActionSheetV2).put(paramInt, parambcvs);
        paramImageView.setTag(paramString);
        parambcvs.a(ShareActionSheetV2.a(paramShareActionSheetV2));
        paramString = parambcvs.a(paramString, true);
        if (paramString == null) {
          break;
        }
        parambbjv.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramString);
        b(parambbjv);
        return;
        paramInt = 1;
        break label74;
        if ((TextUtils.isEmpty(parambbjv.jdField_a_of_type_Bbjs.jdField_b_of_type_JavaLangString)) || (!parambbjv.jdField_a_of_type_Bbjs.jdField_b_of_type_JavaLangString.contains("isNewTroop=1"))) {
          break label268;
        }
        paramInt = 113;
        break label74;
        paramInt = 101;
        break label74;
      }
      paramInt = 4;
    }
  }
  
  private void a(bbjv parambbjv)
  {
    if (parambbjv.jdField_a_of_type_Bbjs.jdField_c_of_type_Int == 72) {
      a(parambbjv.jdField_a_of_type_Bbjs.f, parambbjv.jdField_a_of_type_Bbjs.jdField_c_of_type_JavaLangString, parambbjv.jdField_a_of_type_AndroidWidgetImageView, parambbjv, this, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2);
    }
  }
  
  private static void b(bbjv parambbjv)
  {
    if (parambbjv.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        parambbjv.jdField_a_of_type_AndroidWidgetImageView.setBackground(parambbjv.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      parambbjv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(parambbjv.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    parambbjv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(parambbjv.jdField_a_of_type_Bbjs.jdField_b_of_type_Int);
  }
  
  public bbjs a(int paramInt)
  {
    bbjs localbbjs;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localbbjs = null;
      return localbbjs;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localbbjs = (bbjs)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localbbjs != null)
      {
        k = j;
        if (localbbjs.d == 0) {
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
      bbjs localbbjs = (bbjs)localIterator.next();
      if ((localbbjs == null) || (localbbjs.d != 0)) {
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
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296669));
    }
    if (this.jdField_a_of_type_Bcvt == null) {
      this.jdField_a_of_type_Bcvt = new bcvt(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558827, paramViewGroup, false);
      paramViewGroup = new bbjv();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376008));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376009));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Bbjs = a(paramInt);
      if (paramViewGroup.jdField_a_of_type_Bbjs != null) {
        break;
      }
      QLog.e("ShareActionSheetV2", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (bbjv)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_Int);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296669);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getPaint().setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298816));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_JavaLangString);
    paramInt = -8947849;
    Object localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_c_of_type_Boolean)
    {
      ((TextView)localObject).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Boolean) {
        break label498;
      }
      if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label441;
      }
      localObject = paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
      localObject = this.jdField_a_of_type_Bcvt.a((Drawable)localObject, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_Bbjs.jdField_c_of_type_Boolean) {
        break label465;
      }
      Drawable localDrawable = bcvt.a(this.jdField_a_of_type_Bcvt, (Drawable)localObject);
      localObject = this.jdField_a_of_type_Bcvt.a((Drawable)localObject, localDrawable);
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
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Int);
      break label305;
      label460:
      paramInt = 0;
      break label337;
      label465:
      localObject = bcvt.b(this.jdField_a_of_type_Bcvt, (Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label488:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    return paramView;
    label498:
    if ((paramViewGroup.jdField_a_of_type_Bbjs.jdField_c_of_type_Int == 72) || (paramViewGroup.jdField_a_of_type_Bbjs.jdField_c_of_type_Int == 73)) {
      if (axmv.a()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcvs
 * JD-Core Version:    0.7.0.1
 */