import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bowh
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bowj> jdField_a_of_type_AndroidUtilSparseArray;
  
  bowh(bowd parambowd, Context paramContext)
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
    if (bowd.a(this.jdField_a_of_type_Bowd) == null) {
      return 0;
    }
    return bowd.a(this.jdField_a_of_type_Bowd).length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @SuppressLint({"ResourceType"})
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (bowj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558483, null);
      localObject1 = new bowj(this);
      ((bowj)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2);
      ((bowj)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131371336));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    localObject2 = bowd.a(this.jdField_a_of_type_Bowd)[paramInt];
    TextView localTextView = ((bowj)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setText(((AECaptureMode)localObject2).textId);
    if (bowd.a(this.jdField_a_of_type_Bowd))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165343));
      if (bowd.a(this.jdField_a_of_type_Bowd) != localObject2) {
        break label220;
      }
      localTextView.setAlpha(1.0F);
    }
    for (;;)
    {
      localTextView.setOnClickListener(new bowi(this, (AECaptureMode)localObject2, paramInt));
      paramViewGroup.addView(((bowj)localObject1).jdField_a_of_type_AndroidViewView);
      return ((bowj)localObject1).jdField_a_of_type_AndroidViewView;
      localTextView.setShadowLayer(4.0F, 0.0F, 2.0F, localTextView.getResources().getColor(2131165355));
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167302));
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
 * Qualified Name:     bowh
 * JD-Core Version:    0.7.0.1
 */