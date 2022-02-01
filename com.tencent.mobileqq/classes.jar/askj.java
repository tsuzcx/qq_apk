import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.widget.GridView;

class askj
  extends FrameLayout
{
  public askj(askg paramaskg, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = askg.a(this.a).getPaddingLeft() + getPaddingLeft();
    if (i != paramInt1) {
      offsetLeftAndRight(i - paramInt1);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(askg.a(this.a).getMeasuredWidth() - askg.a(this.a).getPaddingLeft() - askg.a(this.a).getPaddingRight(), View.MeasureSpec.getMode(paramInt1)), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askj
 * JD-Core Version:    0.7.0.1
 */