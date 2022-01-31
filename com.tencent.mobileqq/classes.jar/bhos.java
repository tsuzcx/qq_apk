import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bhos
{
  public static Bitmap a(String paramString1, float paramFloat1, float paramFloat2, Bitmap paramBitmap, String paramString2, String paramString3)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
    ((BitmapFactory.Options)localObject).inMutable = true;
    localObject = azvq.a(paramString1, (BitmapFactory.Options)localObject);
    if (localObject == null) {
      return localObject;
    }
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    int i = ((Bitmap)localObject).getWidth();
    int j = ((Bitmap)localObject).getHeight();
    float f1 = 0.0F;
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    if (paramBitmap != null)
    {
      int k = (int)(i * 0.27F + 0.5F);
      paramString1 = new Rect(0, 0, k, k);
      k = (int)(k * 0.5F + 0.5F);
      int m = (int)(i * paramFloat1 + 0.5F);
      j = (int)(j * paramFloat2 + 0.5F) - k;
      paramString1.offset(m - k, j);
      localCanvas.drawBitmap(paramBitmap, null, paramString1, null);
      f1 = 0.0F + (j + k * 2);
    }
    f1 += 28.0F;
    paramBitmap = new Paint();
    paramBitmap.setAntiAlias(true);
    paramBitmap.setColor(-256);
    paramFloat2 = f1;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() > 10) {
        paramString1 = paramString2.substring(0, 10) + "...";
      }
      paramBitmap.setTextSize(42.0F);
      paramBitmap.setColor(-16777216);
      paramFloat2 = paramBitmap.measureText(paramString1);
      f1 -= paramBitmap.ascent();
      localCanvas.drawText(paramString1, i * paramFloat1 - paramFloat2 * 0.5F, f1, paramBitmap);
      paramFloat2 = f1 + paramBitmap.descent();
    }
    f1 = paramFloat2 + 16.0F;
    paramFloat2 = f1;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = "QIM:" + paramString3;
      paramBitmap.setTextSize(30.0F);
      paramBitmap.setColor(-10765379);
      paramFloat2 = paramBitmap.measureText(paramString1);
      f1 -= paramBitmap.ascent();
      localCanvas.drawText(paramString1, i * paramFloat1 - paramFloat2 * 0.5F, f1, paramBitmap);
      paramFloat2 = f1 + paramBitmap.descent();
    }
    paramString1 = "https://ti.qq.com/qim/toprofile.html?uin=" + paramString3;
    f1 = paramFloat2 + 50.0F;
    j = (int)(i * 0.19F + 0.5F);
    paramString1 = azsq.a(paramString1, localResources, j, 0, false);
    if (paramString1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FilterComboShare", 2, "has qrcode");
      }
      localCanvas.drawBitmap(paramString1, (i - paramString1.getWidth()) * 0.5F, f1, null);
    }
    float f2 = j;
    paramBitmap.setTextSize(16.0F);
    paramBitmap.setColor(-10765379);
    paramString1 = ajjy.a(2131636373);
    paramFloat2 = paramBitmap.measureText(paramString1);
    f1 = f1 + f2 + 24.0F - paramBitmap.ascent();
    localCanvas.drawText(paramString1, i * paramFloat1 - paramFloat2 * 0.5F, f1, paramBitmap);
    paramBitmap.descent();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhos
 * JD-Core Version:    0.7.0.1
 */