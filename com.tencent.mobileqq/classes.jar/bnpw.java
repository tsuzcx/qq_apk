import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnpw
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bnpy> jdField_a_of_type_AndroidUtilSparseArray;
  
  bnpw(bnps parambnps, Context paramContext)
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
    if (bnps.a(this.jdField_a_of_type_Bnps) == null) {
      return 0;
    }
    return bnps.a(this.jdField_a_of_type_Bnps).length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @SuppressLint({"ResourceType"})
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (bnpy)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558484, null);
      localObject1 = new bnpy(this);
      ((bnpy)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2);
      ((bnpy)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131371491));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    localObject2 = bnps.a(this.jdField_a_of_type_Bnps)[paramInt];
    TextView localTextView = ((bnpy)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setText(((AECaptureMode)localObject2).textId);
    if (bnps.a(this.jdField_a_of_type_Bnps))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165357));
      if (bnps.a(this.jdField_a_of_type_Bnps) != localObject2) {
        break label220;
      }
      localTextView.setAlpha(1.0F);
    }
    for (;;)
    {
      localTextView.setOnClickListener(new bnpx(this, (AECaptureMode)localObject2, paramInt));
      paramViewGroup.addView(((bnpy)localObject1).jdField_a_of_type_AndroidViewView);
      return ((bnpy)localObject1).jdField_a_of_type_AndroidViewView;
      localTextView.setShadowLayer(4.0F, 0.0F, 2.0F, localTextView.getResources().getColor(2131165369));
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167363));
      break;
      label220:
      localTextView.setAlpha(0.6F);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpw
 * JD-Core Version:    0.7.0.1
 */