import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class bfuh
  implements bdye
{
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private bfug jdField_a_of_type_Bfug;
  private biwc jdField_a_of_type_Biwc = new biwc();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<biwb> jdField_a_of_type_JavaUtilList;
  
  public bfuh(bftx parambftx, QQAppInterface paramQQAppInterface, bfug parambfug)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bfug = parambfug;
  }
  
  private void a(List<biwb> paramList, Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, int paramInt1, int paramInt2)
  {
    Object localObject = (biwb)paramList.get(0);
    if (((biwb)localObject).c == 3)
    {
      localObject = (bhxs)((biwb)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
      if (((bhxs)localObject).a == 2) {
        paramPaint.setColor(((bhxs)localObject).b);
      }
    }
    else
    {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label275;
      }
      paramRect = (biwb)paramList.next();
      switch (paramRect.c)
      {
      default: 
        break;
      case 1: 
        paramCanvas.drawText(paramRect.jdField_a_of_type_JavaLangString, paramFloat1, paramFloat2 + paramFloat3, paramPaint);
        paramFloat1 += paramPaint.measureText(paramRect.jdField_a_of_type_JavaLangString);
        continue;
        if (((bhxs)localObject).a != 3) {
          break;
        }
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localAppRuntime instanceof QQAppInterface)) {
          break;
        }
        paramPaint.setShader(bhwz.a((QQAppInterface)localAppRuntime).a(((bhxs)localObject).b, paramList, paramFloat1, paramFloat2, paramRect, paramPaint, paramInt1, paramInt2));
        break;
      case 2: 
        paramRect = (begw)paramRect.jdField_a_of_type_AndroidTextStyleCharacterStyle;
        paramInt1 = paramRect.a().getBounds().height();
        paramRect.draw(paramCanvas, "", 0, 0, paramFloat1, (int)paramFloat2, (int)(paramInt1 + paramFloat2), (int)(paramInt1 + paramFloat2), paramPaint);
        paramFloat1 += paramRect.a().getBounds().width();
      }
    }
    label275:
    paramPaint.setShader(null);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString, Paint paramPaint)
  {
    return bhwz.a(this.jdField_a_of_type_JavaUtilList, paramPaint, this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  public String a(bdxk parambdxk, String paramString)
  {
    return paramString.replace("$NICK$", bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfug.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bfug.b, 1, 0));
  }
  
  public void a(int paramInt, String paramString, Paint paramPaint)
  {
    this.jdField_a_of_type_JavaUtilList = bhwz.a(paramInt, paramString, paramPaint, this.jdField_a_of_type_Biwc, 32);
  }
  
  public boolean a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Paint paramPaint)
  {
    a(this.jdField_a_of_type_JavaUtilList, paramCanvas, paramPaint, paramFloat1, paramFloat2, paramFloat3, this.jdField_a_of_type_AndroidGraphicsRect, paramInt1, paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfuh
 * JD-Core Version:    0.7.0.1
 */