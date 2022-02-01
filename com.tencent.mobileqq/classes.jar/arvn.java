import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class arvn
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  protected final View a;
  
  public arvn(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private View a(View paramView, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF();
    int i = 0;
    Object localObject = null;
    Iterator localIterator = paramView.getTouchables().iterator();
    View localView;
    float f1;
    if (localIterator.hasNext())
    {
      localView = (View)localIterator.next();
      f1 = localView.getX();
      float f2 = localView.getY();
      localRectF.set(f1, f2, localView.getMeasuredWidth() + f1, localView.getMeasuredWidth() + f2);
      if (!localRectF.contains(paramFloat1, paramFloat2)) {
        break label160;
      }
      if (localView.equals(paramView)) {
        i = 1;
      }
    }
    label160:
    for (;;)
    {
      break;
      localObject = localView;
      if ((localView instanceof ViewGroup))
      {
        localObject = a(paramView, paramFloat1 - f1, paramFloat2 - paramFloat1);
        continue;
        if ((i != 0) && (localObject == null)) {
          localObject = paramView;
        }
      }
      else
      {
        return localObject;
      }
      return localObject;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View a(arvz paramarvz)
  {
    return a(this.jdField_a_of_type_AndroidViewView, paramarvz.a(), paramarvz.b());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_a_of_type_AndroidViewView.getAlpha() * 255.0F));
    int i = paramCanvas.saveLayer(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint, 31);
    this.jdField_a_of_type_AndroidViewView.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvn
 * JD-Core Version:    0.7.0.1
 */