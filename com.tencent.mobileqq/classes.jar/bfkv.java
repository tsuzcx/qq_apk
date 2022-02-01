import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class bfkv
  implements bdyu
{
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private bfku jdField_a_of_type_Bfku;
  private bimw jdField_a_of_type_Bimw = new bimw();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<bimv> jdField_a_of_type_JavaUtilList;
  
  public bfkv(bfkl parambfkl, QQAppInterface paramQQAppInterface, bfku parambfku)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bfku = parambfku;
  }
  
  private void a(List<bimv> paramList, Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, int paramInt1, int paramInt2)
  {
    Object localObject = (bimv)paramList.get(0);
    if (((bimv)localObject).c == 3)
    {
      localObject = (bhmv)((bimv)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
      if (((bhmv)localObject).a == 2) {
        paramPaint.setColor(((bhmv)localObject).b);
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
      paramRect = (bimv)paramList.next();
      switch (paramRect.c)
      {
      default: 
        break;
      case 1: 
        paramCanvas.drawText(paramRect.jdField_a_of_type_JavaLangString, paramFloat1, paramFloat2 + paramFloat3, paramPaint);
        paramFloat1 += paramPaint.measureText(paramRect.jdField_a_of_type_JavaLangString);
        continue;
        if (((bhmv)localObject).a != 3) {
          break;
        }
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localAppRuntime instanceof QQAppInterface)) {
          break;
        }
        paramPaint.setShader(bhmb.a((QQAppInterface)localAppRuntime).a(((bhmv)localObject).b, paramList, paramFloat1, paramFloat2, paramRect, paramPaint, paramInt1, paramInt2));
        break;
      case 2: 
        paramRect = (QQText.EmoticonSpan)paramRect.jdField_a_of_type_AndroidTextStyleCharacterStyle;
        paramInt1 = paramRect.getDrawable().getBounds().height();
        paramRect.draw(paramCanvas, "", 0, 0, paramFloat1, (int)paramFloat2, (int)(paramInt1 + paramFloat2), (int)(paramInt1 + paramFloat2), paramPaint);
        paramFloat1 += paramRect.getDrawable().getBounds().width();
      }
    }
    label275:
    paramPaint.setShader(null);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString, Paint paramPaint)
  {
    return bhmb.a(this.jdField_a_of_type_JavaUtilList, paramPaint, this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  public String a(bdya parambdya, String paramString)
  {
    return paramString.replace("$NICK$", ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfku.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bfku.b, 1, 0));
  }
  
  public void a(int paramInt, String paramString, Paint paramPaint)
  {
    this.jdField_a_of_type_JavaUtilList = bhmb.a(paramInt, paramString, paramPaint, this.jdField_a_of_type_Bimw, 32);
  }
  
  public boolean a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Paint paramPaint)
  {
    a(this.jdField_a_of_type_JavaUtilList, paramCanvas, paramPaint, paramFloat1, paramFloat2, paramFloat3, this.jdField_a_of_type_AndroidGraphicsRect, paramInt1, paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkv
 * JD-Core Version:    0.7.0.1
 */