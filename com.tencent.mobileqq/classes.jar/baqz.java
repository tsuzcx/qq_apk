import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import org.json.JSONObject;

public class baqz
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  
  public baqz(TroopGiftActionButton paramTroopGiftActionButton, Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(TroopGiftActionButton.a(paramTroopGiftActionButton).optString("buttonColor")));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(bawz.a(getContext(), 3.0F));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (bawz.a(getContext(), 3.0F) / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (bawz.a(getContext(), 3.0F) / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (bawz.a(getContext(), 68.0F) - bawz.a(getContext(), 3.0F) / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (bawz.a(getContext(), 68.0F) - bawz.a(getContext(), 3.0F) / 2);
    a(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, -(100 - this.jdField_a_of_type_Int) * 360 / 100, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baqz
 * JD-Core Version:    0.7.0.1
 */