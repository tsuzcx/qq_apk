import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ArithmeticCaptureView;

class bfym
  extends zmn
{
  bfym(bfyl parambfyl, LayoutInflater paramLayoutInflater)
  {
    super(paramLayoutInflater);
  }
  
  protected View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842960 });
    int i = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    if (i == 2131364134) {
      return new ArithmeticCaptureView(paramContext, paramAttributeSet);
    }
    return super.a(paramView, paramString, paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfym
 * JD-Core Version:    0.7.0.1
 */