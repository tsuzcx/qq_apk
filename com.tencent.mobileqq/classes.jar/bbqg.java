import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class bbqg
  implements azzw
{
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private bbqf jdField_a_of_type_Bbqf;
  private bejr jdField_a_of_type_Bejr = new bejr();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<bejq> jdField_a_of_type_JavaUtilList;
  
  public bbqg(bbpw parambbpw, QQAppInterface paramQQAppInterface, bbqf parambbqf)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bbqf = parambbqf;
  }
  
  private void a(List<bejq> paramList, Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, int paramInt1, int paramInt2)
  {
    Object localObject = (bejq)paramList.get(0);
    if (((bejq)localObject).c == 3)
    {
      localObject = (bdof)((bejq)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
      if (((bdof)localObject).a == 2) {
        paramPaint.setColor(((bdof)localObject).b);
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
      paramRect = (bejq)paramList.next();
      switch (paramRect.c)
      {
      default: 
        break;
      case 1: 
        paramCanvas.drawText(paramRect.jdField_a_of_type_JavaLangString, paramFloat1, paramFloat2 + paramFloat3, paramPaint);
        paramFloat1 += paramPaint.measureText(paramRect.jdField_a_of_type_JavaLangString);
        continue;
        if (((bdof)localObject).a != 3) {
          break;
        }
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localAppRuntime instanceof QQAppInterface)) {
          break;
        }
        paramPaint.setShader(bdnm.a((QQAppInterface)localAppRuntime).a(((bdof)localObject).b, paramList, paramFloat1, paramFloat2, paramRect, paramPaint, paramInt1, paramInt2));
        break;
      case 2: 
        paramRect = (bain)paramRect.jdField_a_of_type_AndroidTextStyleCharacterStyle;
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
    return bdnm.a(this.jdField_a_of_type_JavaUtilList, paramPaint, this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  public String a(azzc paramazzc, String paramString)
  {
    return paramString.replace("$NICK$", bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bbqf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bbqf.b, 1, 0));
  }
  
  public void a(int paramInt, String paramString, Paint paramPaint)
  {
    this.jdField_a_of_type_JavaUtilList = bdnm.a(paramInt, paramString, paramPaint, this.jdField_a_of_type_Bejr, 32);
  }
  
  public boolean a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Paint paramPaint)
  {
    a(this.jdField_a_of_type_JavaUtilList, paramCanvas, paramPaint, paramFloat1, paramFloat2, paramFloat3, this.jdField_a_of_type_AndroidGraphicsRect, paramInt1, paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqg
 * JD-Core Version:    0.7.0.1
 */