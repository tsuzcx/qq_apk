import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class blfn
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<blfp> jdField_a_of_type_AndroidUtilSparseArray;
  
  blfn(blfj paramblfj, Context paramContext)
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
    if (blfj.a(this.jdField_a_of_type_Blfj) == null) {
      return 0;
    }
    return blfj.a(this.jdField_a_of_type_Blfj).length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @SuppressLint({"ResourceType"})
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (blfp)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558476, null);
      localObject1 = new blfp(this);
      ((blfp)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2);
      ((blfp)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131370674));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    localObject2 = blfj.a(this.jdField_a_of_type_Blfj)[paramInt];
    TextView localTextView = ((blfp)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setText(((AECaptureMode)localObject2).textId);
    if (blfj.a(this.jdField_a_of_type_Blfj))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165307));
      if (blfj.a(this.jdField_a_of_type_Blfj) != localObject2) {
        break label220;
      }
      localTextView.setAlpha(1.0F);
    }
    for (;;)
    {
      localTextView.setOnClickListener(new blfo(this, (AECaptureMode)localObject2, paramInt));
      paramViewGroup.addView(((blfp)localObject1).jdField_a_of_type_AndroidViewView);
      return ((blfp)localObject1).jdField_a_of_type_AndroidViewView;
      localTextView.setShadowLayer(4.0F, 0.0F, 2.0F, localTextView.getResources().getColor(2131165319));
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167194));
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
 * Qualified Name:     blfn
 * JD-Core Version:    0.7.0.1
 */