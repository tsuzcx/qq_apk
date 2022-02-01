import android.graphics.Bitmap;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class auzx
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  private auzx(HiBoomTextView paramHiBoomTextView) {}
  
  /* Error */
  private void a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_1
    //   4: if_icmplt +8 -> 12
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpge +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: getfield 21	auzx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   19: ifnull +37 -> 56
    //   22: aload_0
    //   23: getfield 21	auzx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   26: invokevirtual 27	android/graphics/Bitmap:getWidth	()I
    //   29: iload_1
    //   30: if_icmplt +14 -> 44
    //   33: aload_0
    //   34: getfield 21	auzx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   37: invokevirtual 30	android/graphics/Bitmap:getHeight	()I
    //   40: iload_2
    //   41: if_icmpge +15 -> 56
    //   44: aload_0
    //   45: getfield 21	auzx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   48: invokevirtual 33	android/graphics/Bitmap:recycle	()V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 21	auzx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   56: aload_0
    //   57: getfield 21	auzx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   60: ifnonnull +15 -> 75
    //   63: aload_0
    //   64: iload_1
    //   65: iload_2
    //   66: getstatic 39	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   69: invokestatic 43	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   72: putfield 21	auzx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   75: aload_0
    //   76: getfield 21	auzx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   79: iconst_0
    //   80: invokevirtual 47	android/graphics/Bitmap:eraseColor	(I)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: astore_3
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_3
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	auzx
    //   0	91	1	paramInt1	int
    //   0	91	2	paramInt2	int
    //   86	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	14	86	finally
    //   15	44	86	finally
    //   44	56	86	finally
    //   56	75	86	finally
    //   75	85	86	finally
    //   87	89	86	finally
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzx
 * JD-Core Version:    0.7.0.1
 */