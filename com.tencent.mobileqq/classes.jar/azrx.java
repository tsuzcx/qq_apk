import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class azrx
  implements aybz
{
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private azrw jdField_a_of_type_Azrw;
  private bckq jdField_a_of_type_Bckq = new bckq();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<bckp> jdField_a_of_type_JavaUtilList;
  
  public azrx(azrn paramazrn, QQAppInterface paramQQAppInterface, azrw paramazrw)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Azrw = paramazrw;
  }
  
  private void a(List<bckp> paramList, Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, int paramInt1, int paramInt2)
  {
    Object localObject = (bckp)paramList.get(0);
    if (((bckp)localObject).c == 3)
    {
      localObject = (bbpl)((bckp)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
      if (((bbpl)localObject).a == 2) {
        paramPaint.setColor(((bbpl)localObject).b);
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
      paramRect = (bckp)paramList.next();
      switch (paramRect.c)
      {
      default: 
        break;
      case 1: 
        paramCanvas.drawText(paramRect.jdField_a_of_type_JavaLangString, paramFloat1, paramFloat2 + paramFloat3, paramPaint);
        paramFloat1 += paramPaint.measureText(paramRect.jdField_a_of_type_JavaLangString);
        continue;
        if (((bbpl)localObject).a != 3) {
          break;
        }
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localAppRuntime instanceof QQAppInterface)) {
          break;
        }
        paramPaint.setShader(bbos.a((QQAppInterface)localAppRuntime).a(((bbpl)localObject).b, paramList, paramFloat1, paramFloat2, paramRect, paramPaint, paramInt1, paramInt2));
        break;
      case 2: 
        paramRect = (aykr)paramRect.jdField_a_of_type_AndroidTextStyleCharacterStyle;
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
    return bbos.a(this.jdField_a_of_type_JavaUtilList, paramPaint, this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  public String a(aybf paramaybf, String paramString)
  {
    return paramString.replace("$NICK$", bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azrw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azrw.b, 1, 0));
  }
  
  public void a(int paramInt, String paramString, Paint paramPaint)
  {
    this.jdField_a_of_type_JavaUtilList = bbos.a(paramInt, paramString, paramPaint, this.jdField_a_of_type_Bckq, 32);
  }
  
  public boolean a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Paint paramPaint)
  {
    a(this.jdField_a_of_type_JavaUtilList, paramCanvas, paramPaint, paramFloat1, paramFloat2, paramFloat3, this.jdField_a_of_type_AndroidGraphicsRect, paramInt1, paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azrx
 * JD-Core Version:    0.7.0.1
 */