import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ArithmeticCaptureView;

class bbty
  extends xky
{
  bbty(bbtx parambbtx, LayoutInflater paramLayoutInflater)
  {
    super(paramLayoutInflater);
  }
  
  protected View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842960 });
    int i = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    if (i == 2131363888) {
      return new ArithmeticCaptureView(paramContext, paramAttributeSet);
    }
    return super.a(paramView, paramString, paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbty
 * JD-Core Version:    0.7.0.1
 */