import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class biwl
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<biwn> jdField_a_of_type_AndroidUtilSparseArray;
  
  biwl(biwh parambiwh, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return biwo.a(biwh.a(this.jdField_a_of_type_Biwh)).length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (biwn)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558476, null);
      localObject1 = new biwn(this);
      ((biwn)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2);
      ((biwn)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131370351));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    localObject2 = ((biwn)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    ((TextView)localObject2).setText(biwo.a(biwh.a(this.jdField_a_of_type_Biwh))[paramInt].b);
    if (biwh.a(this.jdField_a_of_type_Biwh))
    {
      ((TextView)localObject2).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165275));
      if (biwh.a(this.jdField_a_of_type_Biwh) != paramInt) {
        break label216;
      }
      ((TextView)localObject2).setAlpha(1.0F);
    }
    for (;;)
    {
      ((TextView)localObject2).setOnClickListener(new biwm(this, paramInt));
      paramViewGroup.addView(((biwn)localObject1).jdField_a_of_type_AndroidViewView);
      return ((biwn)localObject1).jdField_a_of_type_AndroidViewView;
      ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, ((TextView)localObject2).getResources().getColor(2131165284));
      ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167134));
      break;
      label216:
      ((TextView)localObject2).setAlpha(0.6F);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwl
 * JD-Core Version:    0.7.0.1
 */