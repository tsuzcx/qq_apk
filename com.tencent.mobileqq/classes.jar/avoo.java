import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.View.DragShadowBuilder;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

@TargetApi(11)
class avoo
  extends View.DragShadowBuilder
{
  public int a;
  
  public avoo(avnl paramavnl, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Avnl.a.f * 1.4D));
  }
  
  public void onDrawShadow(Canvas paramCanvas)
  {
    getView().setDrawingCacheEnabled(false);
    getView().setDrawingCacheEnabled(true);
    Object localObject = new Paint();
    ((Paint)localObject).setShadowLayer(10.0F, 0.0F, 0.0F, -16777216);
    paramCanvas.drawRect(new Rect(10, 10, this.jdField_a_of_type_Int + 10, this.jdField_a_of_type_Int + 10), (Paint)localObject);
    localObject = getView().getDrawingCache();
    Matrix localMatrix = new Matrix();
    float f = this.jdField_a_of_type_Int / ((Bitmap)localObject).getWidth();
    localMatrix.postScale(f, f);
    paramCanvas.drawBitmap(Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true), 10.0F, 10.0F, null);
  }
  
  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    int i = this.jdField_a_of_type_Int + 20;
    int j = this.jdField_a_of_type_Int + 20;
    paramPoint1.set(i, j);
    paramPoint2.set(i / 2, j / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avoo
 * JD-Core Version:    0.7.0.1
 */