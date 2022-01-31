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

public class bcvd
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bcve jdField_a_of_type_Bcve;
  private ShareActionSheetV2 jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2;
  private List<bbje> jdField_a_of_type_JavaUtilList;
  
  public bcvd(Context paramContext, List<bbje> paramList, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "ActionSheetItemAdapter() called with: context = [" + paramContext + "], objects = [" + paramList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private static void a(int paramInt, String paramString, ImageView paramImageView, bbjh parambbjh, bcvd parambcvd, ShareActionSheetV2 paramShareActionSheetV2)
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
      alxg localalxg = (alxg)ShareActionSheetV2.a(paramShareActionSheetV2).get(paramInt);
      parambcvd = localalxg;
      if (localalxg == null)
      {
        parambcvd = new alxg(paramShareActionSheetV2.a, paramInt);
        if (!axmt.a()) {
          break label262;
        }
      }
      for (byte b = 1;; b = 3)
      {
        parambcvd.a(b);
        parambcvd.a();
        ShareActionSheetV2.a(paramShareActionSheetV2).put(paramInt, parambcvd);
        paramImageView.setTag(paramString);
        parambcvd.a(ShareActionSheetV2.a(paramShareActionSheetV2));
        paramString = parambcvd.a(paramString, true);
        if (paramString == null) {
          break;
        }
        parambbjh.jdField_a_of_type_Bbje.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramString);
        b(parambbjh);
        return;
        paramInt = 1;
        break label74;
        if ((TextUtils.isEmpty(parambbjh.jdField_a_of_type_Bbje.jdField_b_of_type_JavaLangString)) || (!parambbjh.jdField_a_of_type_Bbje.jdField_b_of_type_JavaLangString.contains("isNewTroop=1"))) {
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
  
  private void a(bbjh parambbjh)
  {
    if (parambbjh.jdField_a_of_type_Bbje.jdField_c_of_type_Int == 72) {
      a(parambbjh.jdField_a_of_type_Bbje.f, parambbjh.jdField_a_of_type_Bbje.jdField_c_of_type_JavaLangString, parambbjh.jdField_a_of_type_AndroidWidgetImageView, parambbjh, this, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2);
    }
  }
  
  private static void b(bbjh parambbjh)
  {
    if (parambbjh.jdField_a_of_type_Bbje.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        parambbjh.jdField_a_of_type_AndroidWidgetImageView.setBackground(parambbjh.jdField_a_of_type_Bbje.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      parambbjh.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(parambbjh.jdField_a_of_type_Bbje.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    parambbjh.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(parambbjh.jdField_a_of_type_Bbje.jdField_b_of_type_Int);
  }
  
  public bbje a(int paramInt)
  {
    bbje localbbje;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localbbje = null;
      return localbbje;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localbbje = (bbje)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localbbje != null)
      {
        k = j;
        if (localbbje.d == 0) {
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
      bbje localbbje = (bbje)localIterator.next();
      if ((localbbje == null) || (localbbje.d != 0)) {
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
    if (this.jdField_a_of_type_Bcve == null) {
      this.jdField_a_of_type_Bcve = new bcve(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558827, paramViewGroup, false);
      paramViewGroup = new bbjh();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376006));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376007));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Bbje = a(paramInt);
      if (paramViewGroup.jdField_a_of_type_Bbje != null) {
        break;
      }
      QLog.e("ShareActionSheetV2", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (bbjh)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_Bbje.jdField_a_of_type_Int);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296669);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getPaint().setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298816));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_Bbje.jdField_a_of_type_JavaLangString);
    paramInt = -8947849;
    Object localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    if (paramViewGroup.jdField_a_of_type_Bbje.jdField_c_of_type_Boolean)
    {
      ((TextView)localObject).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_Bbje.jdField_b_of_type_Boolean) {
        break label498;
      }
      if (paramViewGroup.jdField_a_of_type_Bbje.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label441;
      }
      localObject = paramViewGroup.jdField_a_of_type_Bbje.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
      localObject = this.jdField_a_of_type_Bcve.a((Drawable)localObject, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_Bbje.jdField_c_of_type_Boolean) {
        break label465;
      }
      Drawable localDrawable = bcve.a(this.jdField_a_of_type_Bcve, (Drawable)localObject);
      localObject = this.jdField_a_of_type_Bcve.a((Drawable)localObject, localDrawable);
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
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_Bbje.jdField_b_of_type_Int);
      break label305;
      label460:
      paramInt = 0;
      break label337;
      label465:
      localObject = bcve.b(this.jdField_a_of_type_Bcve, (Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label488:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    return paramView;
    label498:
    if ((paramViewGroup.jdField_a_of_type_Bbje.jdField_c_of_type_Int == 72) || (paramViewGroup.jdField_a_of_type_Bbje.jdField_c_of_type_Int == 73)) {
      if (axmt.a()) {
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
 * Qualified Name:     bcvd
 * JD-Core Version:    0.7.0.1
 */